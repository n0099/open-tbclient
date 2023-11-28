package com.baidu.swan.games.view.recommend.popview;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import com.baidu.tieba.R;
import com.baidu.tieba.da4;
import com.baidu.tieba.q94;
import com.baidu.tieba.sm1;
import com.baidu.tieba.w94;
import com.baidu.tieba.z94;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GameCloseGuidePopView extends RelativeLayout {
    public static final boolean i = sm1.a;
    public Context a;
    public View b;
    public View c;
    public View d;
    public RecyclerView e;
    public e f;
    public RecommendItemModel g;
    public q94 h;

    /* loaded from: classes4.dex */
    public interface e {
        void a();

        void b();

        void c();
    }

    /* loaded from: classes4.dex */
    public class d implements Callback {

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public final /* synthetic */ List a;
            public final /* synthetic */ w94 b;

            public a(List list, w94 w94Var) {
                this.a = list;
                this.b = w94Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                GameCloseGuidePopView.this.e.setAdapter(new GameGuideAdapter(GameCloseGuidePopView.this.a, this.a));
                GameCloseGuidePopView.this.h.c(3, this.b);
            }
        }

        public d() {
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            if (GameCloseGuidePopView.i) {
                iOException.printStackTrace();
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            if (response != null && response.body() != null) {
                try {
                    JSONObject optJSONObject = new JSONObject(response.body().string()).optJSONObject("data");
                    if (optJSONObject == null) {
                        return;
                    }
                    String optString = optJSONObject.optString("game_center");
                    if (TextUtils.isEmpty(optString)) {
                        return;
                    }
                    Gson gson = new Gson();
                    GameCloseGuidePopView.this.g = (RecommendItemModel) gson.fromJson(optString, (Class<Object>) RecommendItemModel.class);
                    JSONArray optJSONArray = optJSONObject.optJSONArray("app_list");
                    if (optJSONArray == null) {
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        if (optJSONArray.opt(i) != null) {
                            arrayList.add((RecommendItemModel) gson.fromJson(optJSONArray.opt(i).toString(), (Class<Object>) RecommendItemModel.class));
                        }
                    }
                    GameCloseGuidePopView.this.post(new a(arrayList, new w94(GameCloseGuidePopView.this.g, arrayList)));
                } catch (JSONException e) {
                    if (GameCloseGuidePopView.i) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (GameCloseGuidePopView.this.f != null) {
                GameCloseGuidePopView.this.f.a();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (GameCloseGuidePopView.this.f != null) {
                GameCloseGuidePopView.this.f.b();
                if (GameCloseGuidePopView.this.g != null && !TextUtils.isEmpty(GameCloseGuidePopView.this.g.getScheme()) && !TextUtils.isEmpty(GameCloseGuidePopView.this.g.getAppKey())) {
                    SchemeRouter.invokeSchemeForInner(GameCloseGuidePopView.this.a, Uri.parse(GameCloseGuidePopView.this.g.getScheme()));
                    GameCloseGuidePopView.this.h.b(3, "popview", GameCloseGuidePopView.this.g.getAppKey(), "");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (GameCloseGuidePopView.this.f != null) {
                GameCloseGuidePopView.this.f.c();
            }
        }
    }

    public final void h() {
        this.h = new q94();
        z94.a(new d());
    }

    public GameCloseGuidePopView(Context context) {
        super(context);
        this.a = context;
        i();
        h();
    }

    public void setOnClickListener(e eVar) {
        this.f = eVar;
    }

    public final void i() {
        LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0978, this);
        this.b = findViewById(R.id.obfuscated_res_0x7f092803);
        this.c = findViewById(R.id.obfuscated_res_0x7f092839);
        this.d = findViewById(R.id.obfuscated_res_0x7f09203a);
        this.e = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f09209e);
        this.b.setOnClickListener(new a());
        this.c.setOnClickListener(new b());
        this.d.setOnClickListener(new c());
        da4.a(this.b);
        da4.a(this.c);
        this.e.setLayoutManager(new GridLayoutManager(this.a, 3));
    }
}
