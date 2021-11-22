package b.a.p0.h.i.p;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.p0.h.i.m.b f10506a;

    /* renamed from: b  reason: collision with root package name */
    public Context f10507b;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.h.i.m.h f10508e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f10509f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f10510g;

        /* renamed from: b.a.p0.h.i.p.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0553a extends ResponseCallback<b.a.p0.h.i.l.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f10511a;

            /* renamed from: b.a.p0.h.i.p.b$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0554a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ b.a.p0.h.i.l.a f10512e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ C0553a f10513f;

                public RunnableC0554a(C0553a c0553a, b.a.p0.h.i.l.a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0553a, aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f10513f = c0553a;
                    this.f10512e = aVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10513f.f10511a.f10510g.f10506a == null) {
                        return;
                    }
                    this.f10513f.f10511a.f10510g.f10506a.g(this.f10512e);
                }
            }

            public C0553a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f10511a = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(b.a.p0.h.i.l.a aVar, int i2) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLI(1048576, this, aVar, i2) == null) || aVar == null) {
                    return;
                }
                b.a.p0.h.i.s.d.c(new RunnableC0554a(this, aVar));
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: b */
            public b.a.p0.h.i.l.a parseResponse(Response response, int i2) {
                InterceptResult invokeLI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i2)) == null) {
                    if (response == null || response.body() == null || !response.isSuccessful()) {
                        return null;
                    }
                    try {
                        String string = response.body().string();
                        if (!TextUtils.isEmpty(string)) {
                            return new b.a.p0.h.i.l.a(string);
                        }
                    } catch (Exception | OutOfMemoryError e2) {
                        e2.printStackTrace();
                    }
                    return null;
                }
                return (b.a.p0.h.i.l.a) invokeLI.objValue;
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                }
            }
        }

        public a(b bVar, b.a.p0.h.i.m.h hVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, hVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10510g = bVar;
            this.f10508e = hVar;
            this.f10509f = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                C0553a c0553a = new C0553a(this);
                if (NetworkUtils.f(this.f10510g.f10507b)) {
                    this.f10508e.b("https://afdconf.baidu.com/afd/download", this.f10509f, c0553a);
                }
            }
        }
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10507b = context;
    }

    public void c(b.a.p0.h.i.m.h hVar, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, hVar, jSONObject) == null) {
            b.a.p0.h.i.s.c.d(new a(this, hVar, jSONObject), "AdLandingDownloadRequest");
        }
    }

    public void d(b.a.p0.h.i.m.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f10506a = bVar;
        }
    }
}
