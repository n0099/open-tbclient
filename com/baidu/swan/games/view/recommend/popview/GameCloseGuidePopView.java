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
import d.b.g0.a.f;
import d.b.g0.a.g;
import d.b.g0.a.k;
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
    public static final boolean m = k.f45443a;

    /* renamed from: e  reason: collision with root package name */
    public Context f12581e;

    /* renamed from: f  reason: collision with root package name */
    public View f12582f;

    /* renamed from: g  reason: collision with root package name */
    public View f12583g;

    /* renamed from: h  reason: collision with root package name */
    public View f12584h;
    public RecyclerView i;
    public e j;
    public RecommendItemModel k;
    public d.b.g0.g.k0.i.b.c l;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (GameCloseGuidePopView.this.j != null) {
                GameCloseGuidePopView.this.j.c();
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
                if (GameCloseGuidePopView.this.k != null && !TextUtils.isEmpty(GameCloseGuidePopView.this.k.getScheme()) && !TextUtils.isEmpty(GameCloseGuidePopView.this.k.getAppKey())) {
                    SchemeRouter.invokeSchemeForInner(GameCloseGuidePopView.this.f12581e, Uri.parse(GameCloseGuidePopView.this.k.getScheme()));
                    GameCloseGuidePopView.this.l.b(3, "popview", GameCloseGuidePopView.this.k.getAppKey(), "");
                }
                GameCloseGuidePopView.this.j.a();
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
                GameCloseGuidePopView.this.j.b();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Callback {

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ List f12589e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.g.k0.i.e.a f12590f;

            public a(List list, d.b.g0.g.k0.i.e.a aVar) {
                this.f12589e = list;
                this.f12590f = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                GameCloseGuidePopView.this.i.setAdapter(new GameGuideAdapter(GameCloseGuidePopView.this.f12581e, this.f12589e));
                GameCloseGuidePopView.this.l.c(3, this.f12590f);
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
                for (int i = 0; i < length; i++) {
                    if (optJSONArray.opt(i) != null) {
                        arrayList.add((RecommendItemModel) gson.fromJson(optJSONArray.opt(i).toString(), (Class<Object>) RecommendItemModel.class));
                    }
                }
                GameCloseGuidePopView.this.post(new a(arrayList, new d.b.g0.g.k0.i.e.a(GameCloseGuidePopView.this.k, arrayList)));
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
        this.f12581e = context;
        i();
        h();
    }

    public final void h() {
        this.l = new d.b.g0.g.k0.i.b.c();
        d.b.g0.g.k0.i.f.a.a(new d());
    }

    public final void i() {
        LayoutInflater.from(this.f12581e).inflate(g.swangame_game_close_guide_view, this);
        this.f12582f = findViewById(f.tv_exit_game);
        this.f12583g = findViewById(f.tv_more_game);
        this.f12584h = findViewById(f.rl_guide_game_bg);
        this.i = (RecyclerView) findViewById(f.rv_guide_game);
        this.f12582f.setOnClickListener(new a());
        this.f12583g.setOnClickListener(new b());
        this.f12584h.setOnClickListener(new c());
        d.b.g0.g.k0.i.f.d.a(this.f12582f);
        d.b.g0.g.k0.i.f.d.a(this.f12583g);
        this.i.setLayoutManager(new GridLayoutManager(this.f12581e, 3));
    }

    public void setOnClickListener(e eVar) {
        this.j = eVar;
    }
}
