package com.baidu.swan.games.view.recommend.popview;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
import d.a.o0.a.k;
import d.a.o0.f.f;
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
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f11982e;

    /* renamed from: f  reason: collision with root package name */
    public View f11983f;

    /* renamed from: g  reason: collision with root package name */
    public View f11984g;

    /* renamed from: h  reason: collision with root package name */
    public View f11985h;

    /* renamed from: i  reason: collision with root package name */
    public RecyclerView f11986i;
    public e j;
    public RecommendItemModel k;
    public d.a.o0.h.o0.g.b.c l;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GameCloseGuidePopView f11987e;

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
            this.f11987e = gameCloseGuidePopView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f11987e.j == null) {
                return;
            }
            this.f11987e.j.a();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GameCloseGuidePopView f11988e;

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
            this.f11988e = gameCloseGuidePopView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f11988e.j == null) {
                return;
            }
            this.f11988e.j.b();
            if (this.f11988e.k == null || TextUtils.isEmpty(this.f11988e.k.getScheme()) || TextUtils.isEmpty(this.f11988e.k.getAppKey())) {
                return;
            }
            SchemeRouter.invokeSchemeForInner(this.f11988e.f11982e, Uri.parse(this.f11988e.k.getScheme()));
            this.f11988e.l.b(3, "popview", this.f11988e.k.getAppKey(), "");
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GameCloseGuidePopView f11989e;

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
            this.f11989e = gameCloseGuidePopView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f11989e.j == null) {
                return;
            }
            this.f11989e.j.c();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GameCloseGuidePopView f11990a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ List f11991e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d.a.o0.h.o0.g.e.a f11992f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ d f11993g;

            public a(d dVar, List list, d.a.o0.h.o0.g.e.a aVar) {
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
                this.f11993g = dVar;
                this.f11991e = list;
                this.f11992f = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f11993g.f11990a.f11986i.setAdapter(new GameGuideAdapter(this.f11993g.f11990a.f11982e, this.f11991e));
                    this.f11993g.f11990a.l.c(3, this.f11992f);
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
            this.f11990a = gameCloseGuidePopView;
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
                this.f11990a.k = (RecommendItemModel) gson.fromJson(optString, (Class<Object>) RecommendItemModel.class);
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
                this.f11990a.post(new a(this, arrayList, new d.a.o0.h.o0.g.e.a(this.f11990a.k, arrayList)));
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
        m = k.f46335a;
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
        this.f11982e = context;
        i();
        h();
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.l = new d.a.o0.h.o0.g.b.c();
            d.a.o0.h.o0.g.f.a.a(new d(this));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(this.f11982e).inflate(f.swangame_game_close_guide_view, this);
            this.f11983f = findViewById(d.a.o0.f.e.tv_exit_game);
            this.f11984g = findViewById(d.a.o0.f.e.tv_more_game);
            this.f11985h = findViewById(d.a.o0.f.e.rl_guide_game_bg);
            this.f11986i = (RecyclerView) findViewById(d.a.o0.f.e.rv_guide_game);
            this.f11983f.setOnClickListener(new a(this));
            this.f11984g.setOnClickListener(new b(this));
            this.f11985h.setOnClickListener(new c(this));
            d.a.o0.h.o0.g.f.e.a(this.f11983f);
            d.a.o0.h.o0.g.f.e.a(this.f11984g);
            this.f11986i.setLayoutManager(new GridLayoutManager(this.f11982e, 3));
        }
    }

    public void setOnClickListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            this.j = eVar;
        }
    }
}
