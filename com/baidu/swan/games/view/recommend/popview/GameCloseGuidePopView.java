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
/* loaded from: classes10.dex */
public class GameCloseGuidePopView extends RelativeLayout {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private View ebR;
    private View ebS;
    private View ebT;
    private a ebU;
    private RecommendItemModel ebV;
    private com.baidu.swan.games.view.recommend.a.c ebW;
    private Context mContext;
    private RecyclerView mRecyclerView;

    /* loaded from: classes10.dex */
    public interface a {
        void apI();

        void apJ();

        void apK();
    }

    public GameCloseGuidePopView(Context context) {
        super(context);
        this.mContext = context;
        initView();
        initData();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(a.g.swangame_game_close_guide_view, this);
        this.ebR = findViewById(a.f.tv_exit_game);
        this.ebS = findViewById(a.f.tv_more_game);
        this.ebT = findViewById(a.f.rl_guide_game_bg);
        this.mRecyclerView = (RecyclerView) findViewById(a.f.rv_guide_game);
        this.ebR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GameCloseGuidePopView.this.ebU != null) {
                    GameCloseGuidePopView.this.ebU.apJ();
                }
            }
        });
        this.ebS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GameCloseGuidePopView.this.ebU != null) {
                    if (GameCloseGuidePopView.this.ebV != null && !TextUtils.isEmpty(GameCloseGuidePopView.this.ebV.getScheme()) && !TextUtils.isEmpty(GameCloseGuidePopView.this.ebV.getAppKey())) {
                        SchemeRouter.invokeSchemeForInner(GameCloseGuidePopView.this.mContext, Uri.parse(GameCloseGuidePopView.this.ebV.getScheme()));
                        GameCloseGuidePopView.this.ebW.c(3, "popview", GameCloseGuidePopView.this.ebV.getAppKey(), "");
                    }
                    GameCloseGuidePopView.this.ebU.apK();
                }
            }
        });
        this.ebT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GameCloseGuidePopView.this.ebU != null) {
                    GameCloseGuidePopView.this.ebU.apI();
                }
            }
        });
        e.aT(this.ebR);
        e.aT(this.ebS);
        this.mRecyclerView.setLayoutManager(new GridLayoutManager(this.mContext, 3));
    }

    private void initData() {
        this.ebW = new com.baidu.swan.games.view.recommend.a.c();
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
                                GameCloseGuidePopView.this.ebV = (RecommendItemModel) gson.fromJson(optString, (Class<Object>) RecommendItemModel.class);
                                JSONArray optJSONArray = optJSONObject.optJSONArray("app_list");
                                if (optJSONArray != null) {
                                    final ArrayList arrayList = new ArrayList();
                                    int length = optJSONArray.length();
                                    for (int i = 0; i < length; i++) {
                                        if (optJSONArray.opt(i) != null) {
                                            arrayList.add((RecommendItemModel) gson.fromJson(optJSONArray.opt(i).toString(), (Class<Object>) RecommendItemModel.class));
                                        }
                                    }
                                    final com.baidu.swan.games.view.recommend.model.a aVar = new com.baidu.swan.games.view.recommend.model.a(GameCloseGuidePopView.this.ebV, arrayList);
                                    GameCloseGuidePopView.this.post(new Runnable() { // from class: com.baidu.swan.games.view.recommend.popview.GameCloseGuidePopView.4.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            GameCloseGuidePopView.this.mRecyclerView.setAdapter(new com.baidu.swan.games.view.recommend.popview.a(GameCloseGuidePopView.this.mContext, arrayList));
                                            GameCloseGuidePopView.this.ebW.b(3, aVar);
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
        this.ebU = aVar;
    }
}
