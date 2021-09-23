package com.baidu.swan.games.view.recommend.popview;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.p0.a.k;
import c.a.p0.f.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes6.dex */
public class GameCloseGuidePopView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f47203e;

    /* renamed from: f  reason: collision with root package name */
    public View f47204f;

    /* renamed from: g  reason: collision with root package name */
    public View f47205g;

    /* renamed from: h  reason: collision with root package name */
    public View f47206h;

    /* renamed from: i  reason: collision with root package name */
    public RecyclerView f47207i;

    /* renamed from: j  reason: collision with root package name */
    public e f47208j;
    public RecommendItemModel k;
    public c.a.p0.h.o0.g.b.c l;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GameCloseGuidePopView f47209e;

        public a(GameCloseGuidePopView gameCloseGuidePopView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameCloseGuidePopView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47209e = gameCloseGuidePopView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f47209e.f47208j == null) {
                return;
            }
            this.f47209e.f47208j.a();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GameCloseGuidePopView f47210e;

        public b(GameCloseGuidePopView gameCloseGuidePopView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameCloseGuidePopView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47210e = gameCloseGuidePopView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f47210e.f47208j == null) {
                return;
            }
            this.f47210e.f47208j.b();
            if (this.f47210e.k == null || TextUtils.isEmpty(this.f47210e.k.getScheme()) || TextUtils.isEmpty(this.f47210e.k.getAppKey())) {
                return;
            }
            SchemeRouter.invokeSchemeForInner(this.f47210e.f47203e, Uri.parse(this.f47210e.k.getScheme()));
            this.f47210e.l.b(3, "popview", this.f47210e.k.getAppKey(), "");
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GameCloseGuidePopView f47211e;

        public c(GameCloseGuidePopView gameCloseGuidePopView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameCloseGuidePopView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47211e = gameCloseGuidePopView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f47211e.f47208j == null) {
                return;
            }
            this.f47211e.f47208j.c();
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GameCloseGuidePopView f47212a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ List f47213e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.h.o0.g.e.a f47214f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ d f47215g;

            public a(d dVar, List list, c.a.p0.h.o0.g.e.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, list, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47215g = dVar;
                this.f47213e = list;
                this.f47214f = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f47215g.f47212a.f47207i.setAdapter(new GameGuideAdapter(this.f47215g.f47212a.f47203e, this.f47213e));
                    this.f47215g.f47212a.l.c(3, this.f47214f);
                }
            }
        }

        public d(GameCloseGuidePopView gameCloseGuidePopView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameCloseGuidePopView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47212a = gameCloseGuidePopView;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) && GameCloseGuidePopView.m) {
                iOException.printStackTrace();
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) || response == null || response.body() == null) {
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
                this.f47212a.k = (RecommendItemModel) gson.fromJson(optString, (Class<Object>) RecommendItemModel.class);
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
                this.f47212a.post(new a(this, arrayList, new c.a.p0.h.o0.g.e.a(this.f47212a.k, arrayList)));
            } catch (JSONException e2) {
                if (GameCloseGuidePopView.m) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface e {
        void a();

        void b();

        void c();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-233330573, "Lcom/baidu/swan/games/view/recommend/popview/GameCloseGuidePopView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-233330573, "Lcom/baidu/swan/games/view/recommend/popview/GameCloseGuidePopView;");
                return;
            }
        }
        m = k.f7085a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameCloseGuidePopView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f47203e = context;
        i();
        h();
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.l = new c.a.p0.h.o0.g.b.c();
            c.a.p0.h.o0.g.f.a.a(new d(this));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(this.f47203e).inflate(f.swangame_game_close_guide_view, this);
            this.f47204f = findViewById(c.a.p0.f.e.tv_exit_game);
            this.f47205g = findViewById(c.a.p0.f.e.tv_more_game);
            this.f47206h = findViewById(c.a.p0.f.e.rl_guide_game_bg);
            this.f47207i = (RecyclerView) findViewById(c.a.p0.f.e.rv_guide_game);
            this.f47204f.setOnClickListener(new a(this));
            this.f47205g.setOnClickListener(new b(this));
            this.f47206h.setOnClickListener(new c(this));
            c.a.p0.h.o0.g.f.d.a(this.f47204f);
            c.a.p0.h.o0.g.f.d.a(this.f47205g);
            this.f47207i.setLayoutManager(new GridLayoutManager(this.f47203e, 3));
        }
    }

    public void setOnClickListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            this.f47208j = eVar;
        }
    }
}
