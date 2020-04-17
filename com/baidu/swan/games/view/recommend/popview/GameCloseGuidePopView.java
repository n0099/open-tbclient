package com.baidu.swan.games.view.recommend.popview;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.apps.a;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class GameCloseGuidePopView extends RelativeLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private View cTF;
    private View cTG;
    private View cTH;
    private a cTI;
    private RecommendItemModel cTJ;
    private com.baidu.swan.games.view.recommend.a.c cTK;
    private Context mContext;
    private RecyclerView mRecyclerView;

    /* loaded from: classes11.dex */
    public interface a {
        void WN();

        void WO();

        void WP();
    }

    public GameCloseGuidePopView(Context context) {
        super(context);
        this.mContext = context;
        initView();
        initData();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(a.g.swangame_game_close_guide_view, this);
        this.cTF = findViewById(a.f.tv_exit_game);
        this.cTG = findViewById(a.f.tv_more_game);
        this.cTH = findViewById(a.f.rl_guide_game_bg);
        this.mRecyclerView = (RecyclerView) findViewById(a.f.rv_guide_game);
        this.cTF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GameCloseGuidePopView.this.cTI != null) {
                    GameCloseGuidePopView.this.cTI.WO();
                }
            }
        });
        this.cTG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GameCloseGuidePopView.this.cTI != null) {
                    if (GameCloseGuidePopView.this.cTJ != null && !TextUtils.isEmpty(GameCloseGuidePopView.this.cTJ.getScheme()) && !TextUtils.isEmpty(GameCloseGuidePopView.this.cTJ.getAppKey())) {
                        SchemeRouter.invokeSchemeForInner(GameCloseGuidePopView.this.mContext, Uri.parse(GameCloseGuidePopView.this.cTJ.getScheme()));
                        GameCloseGuidePopView.this.cTK.c(3, "popview", GameCloseGuidePopView.this.cTJ.getAppKey(), "");
                    }
                    GameCloseGuidePopView.this.cTI.WP();
                }
            }
        });
        this.cTH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GameCloseGuidePopView.this.cTI != null) {
                    GameCloseGuidePopView.this.cTI.WN();
                }
            }
        });
        e.aF(this.cTF);
        e.aF(this.cTG);
        this.mRecyclerView.setLayoutManager(new GridLayoutManager(this.mContext, 3));
    }

    private void initData() {
        this.cTK = new com.baidu.swan.games.view.recommend.a.c();
        b.a(new Callback() { // from class: com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.4
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                if (GameCloseGuidePopView.DEBUG) {
                    iOException.printStackTrace();
                }
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                if (response != null && response.body() != null) {
                    try {
                        JSONObject optJSONObject = new JSONObject(response.body().string()).optJSONObject("data");
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("game_center");
                            if (!TextUtils.isEmpty(optString)) {
                                Gson gson = new Gson();
                                GameCloseGuidePopView.this.cTJ = (RecommendItemModel) gson.fromJson(optString, (Class<Object>) RecommendItemModel.class);
                                JSONArray optJSONArray = optJSONObject.optJSONArray("app_list");
                                if (optJSONArray != null) {
                                    final ArrayList arrayList = new ArrayList();
                                    int length = optJSONArray.length();
                                    for (int i = 0; i < length; i++) {
                                        if (optJSONArray.opt(i) != null) {
                                            arrayList.add((RecommendItemModel) gson.fromJson(optJSONArray.opt(i).toString(), (Class<Object>) RecommendItemModel.class));
                                        }
                                    }
                                    final com.baidu.swan.games.view.recommend.model.a aVar = new com.baidu.swan.games.view.recommend.model.a(GameCloseGuidePopView.this.cTJ, arrayList);
                                    GameCloseGuidePopView.this.post(new Runnable() { // from class: com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.4.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            GameCloseGuidePopView.this.mRecyclerView.setAdapter(new com.baidu.swan.games.view.recommend.popview.a(GameCloseGuidePopView.this.mContext, arrayList));
                                            GameCloseGuidePopView.this.cTK.b(3, aVar);
                                        }
                                    });
                                }
                            }
                        }
                    } catch (JSONException e) {
                        if (GameCloseGuidePopView.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    public void setOnClickListener(a aVar) {
        this.cTI = aVar;
    }
}
