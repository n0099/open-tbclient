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
import com.google.gson.Gson;
import d.a.m0.a.k;
import d.a.m0.f.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GameCloseGuidePopView extends RelativeLayout {
    public static final boolean m = k.f46983a;

    /* renamed from: e  reason: collision with root package name */
    public Context f11872e;

    /* renamed from: f  reason: collision with root package name */
    public View f11873f;

    /* renamed from: g  reason: collision with root package name */
    public View f11874g;

    /* renamed from: h  reason: collision with root package name */
    public View f11875h;

    /* renamed from: i  reason: collision with root package name */
    public RecyclerView f11876i;
    public e j;
    public RecommendItemModel k;
    public d.a.m0.h.o0.g.b.c l;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (GameCloseGuidePopView.this.j != null) {
                GameCloseGuidePopView.this.j.a();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (GameCloseGuidePopView.this.j != null) {
                GameCloseGuidePopView.this.j.b();
                if (GameCloseGuidePopView.this.k == null || TextUtils.isEmpty(GameCloseGuidePopView.this.k.getScheme()) || TextUtils.isEmpty(GameCloseGuidePopView.this.k.getAppKey())) {
                    return;
                }
                SchemeRouter.invokeSchemeForInner(GameCloseGuidePopView.this.f11872e, Uri.parse(GameCloseGuidePopView.this.k.getScheme()));
                GameCloseGuidePopView.this.l.b(3, "popview", GameCloseGuidePopView.this.k.getAppKey(), "");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (GameCloseGuidePopView.this.j != null) {
                GameCloseGuidePopView.this.j.c();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Callback {

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ List f11881e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d.a.m0.h.o0.g.e.a f11882f;

            public a(List list, d.a.m0.h.o0.g.e.a aVar) {
                this.f11881e = list;
                this.f11882f = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                GameCloseGuidePopView.this.f11876i.setAdapter(new GameGuideAdapter(GameCloseGuidePopView.this.f11872e, this.f11881e));
                GameCloseGuidePopView.this.l.c(3, this.f11882f);
            }
        }

        public d() {
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            if (GameCloseGuidePopView.m) {
                iOException.printStackTrace();
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            if (response == null || response.body() == null) {
                return;
            }
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
                GameCloseGuidePopView.this.k = (RecommendItemModel) gson.fromJson(optString, (Class<Object>) RecommendItemModel.class);
                JSONArray optJSONArray = optJSONObject.optJSONArray("app_list");
                if (optJSONArray == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    if (optJSONArray.opt(i2) != null) {
                        arrayList.add((RecommendItemModel) gson.fromJson(optJSONArray.opt(i2).toString(), (Class<Object>) RecommendItemModel.class));
                    }
                }
                GameCloseGuidePopView.this.post(new a(arrayList, new d.a.m0.h.o0.g.e.a(GameCloseGuidePopView.this.k, arrayList)));
            } catch (JSONException e2) {
                if (GameCloseGuidePopView.m) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a();

        void b();

        void c();
    }

    public GameCloseGuidePopView(Context context) {
        super(context);
        this.f11872e = context;
        i();
        h();
    }

    public final void h() {
        this.l = new d.a.m0.h.o0.g.b.c();
        d.a.m0.h.o0.g.f.a.a(new d());
    }

    public final void i() {
        LayoutInflater.from(this.f11872e).inflate(f.swangame_game_close_guide_view, this);
        this.f11873f = findViewById(d.a.m0.f.e.tv_exit_game);
        this.f11874g = findViewById(d.a.m0.f.e.tv_more_game);
        this.f11875h = findViewById(d.a.m0.f.e.rl_guide_game_bg);
        this.f11876i = (RecyclerView) findViewById(d.a.m0.f.e.rv_guide_game);
        this.f11873f.setOnClickListener(new a());
        this.f11874g.setOnClickListener(new b());
        this.f11875h.setOnClickListener(new c());
        d.a.m0.h.o0.g.f.e.a(this.f11873f);
        d.a.m0.h.o0.g.f.e.a(this.f11874g);
        this.f11876i.setLayoutManager(new GridLayoutManager(this.f11872e, 3));
    }

    public void setOnClickListener(e eVar) {
        this.j = eVar;
    }
}
