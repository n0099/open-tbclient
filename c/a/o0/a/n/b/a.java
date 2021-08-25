package c.a.o0.a.n.b;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.e2.c.j.b;
import c.a.o0.a.v2.q0;
import c.a.o0.a.v2.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.http.client.methods.HttpDelete;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends c.a.o0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static String f7388d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.o0.a.n.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0301a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f7389e;

        public RunnableC0301a(a aVar) {
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
            this.f7389e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.o0.a.z1.b.f.e f2 = c.a.o0.a.z1.b.f.e.f(this.f7389e.i(), c.a.o0.a.h.swan_bookshelf_insert_async);
                f2.l(10);
                f2.r(false);
                f2.y();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f7390a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.h0.j.b f7391b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f7392c;

        /* renamed from: c.a.o0.a.n.b.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0302a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public RunnableC0302a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.o0.a.z1.b.f.e.a();
                }
            }
        }

        /* renamed from: c.a.o0.a.n.b.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0303b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public RunnableC0303b(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.o0.a.z1.b.f.e.f(c.a.o0.a.c1.a.b(), c.a.o0.a.h.swan_bookshelf_insert_failed).F();
                }
            }
        }

        /* loaded from: classes.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public c(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.o0.a.z1.b.f.e.a();
                }
            }
        }

        public b(a aVar, boolean z, c.a.o0.a.h0.j.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Boolean.valueOf(z), bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7392c = aVar;
            this.f7390a = z;
            this.f7391b = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) {
                if (this.f7390a) {
                    q0.b0(new RunnableC0302a(this));
                }
                if (jSONObject == null) {
                    this.f7392c.H(this.f7391b, 1001, "server response fail", this.f7390a);
                    return;
                }
                int optInt = jSONObject.optInt("errno", -1);
                if (optInt != 0) {
                    if (this.f7390a) {
                        q0.b0(new RunnableC0303b(this));
                    }
                    this.f7392c.H(this.f7391b, optInt, jSONObject.optString("errmsg"), false);
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    this.f7392c.H(this.f7391b, 0, jSONObject.optString("errmsg"), this.f7390a);
                } else {
                    this.f7392c.I(this.f7391b, optJSONObject, this.f7390a);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i2)) == null) {
                if (response == null || response.body() == null) {
                    return null;
                }
                return w.d(response.body().string());
            }
            return (JSONObject) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (this.f7390a) {
                    q0.b0(new c(this));
                }
                a aVar = this.f7392c;
                c.a.o0.a.h0.j.b bVar = this.f7391b;
                aVar.H(bVar, 1001, "operation fail, msg = " + exc.getMessage(), this.f7390a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7393e;

        public c(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7393e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.o0.a.z1.b.f.e.g(c.a.o0.a.c1.a.b(), this.f7393e).F();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f7394e;

        public d(a aVar) {
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
            this.f7394e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.o0.a.z1.b.f.e.f(this.f7394e.i(), c.a.o0.a.h.aiapps_net_error).F();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f7395e;

        public e(a aVar) {
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
            this.f7395e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.o0.a.z1.b.f.e.f(this.f7395e.i(), c.a.o0.a.h.aiapps_net_error).F();
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.o0.a.v2.e1.b<c.a.o0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f7396e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7397f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f7398g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f7399h;

        /* renamed from: c.a.o0.a.n.b.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0304a implements c.a.o0.a.h0.j.b<c.a.o0.a.u.h.b> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f7400a;

            public C0304a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7400a = fVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.o0.a.h0.j.b
            /* renamed from: b */
            public void a(c.a.o0.a.u.h.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                    f fVar = this.f7400a;
                    fVar.f7399h.d(fVar.f7398g, bVar);
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f7401e;

            public b(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7401e = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.o0.a.z1.b.f.e.f(this.f7401e.f7399h.i(), c.a.o0.a.h.swan_bookshelf_authorize_fail).F();
                }
            }
        }

        public f(a aVar, JSONArray jSONArray, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, jSONArray, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7399h = aVar;
            this.f7396e = jSONArray;
            this.f7397f = str;
            this.f7398g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(c.a.o0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.o0.a.e2.c.d.h(iVar)) {
                    int t1 = c.a.o0.a.a2.d.g().r().L().t1();
                    String u1 = c.a.o0.a.a2.d.g().r().L().u1();
                    String D = c.a.o0.a.a2.d.g().r().D();
                    HashMap hashMap = new HashMap();
                    hashMap.put("appKey", D);
                    hashMap.put("contentIds", this.f7396e);
                    hashMap.put("category", this.f7397f);
                    hashMap.put("pkg_type", Integer.valueOf(t1));
                    hashMap.put("version_code", u1);
                    this.f7399h.Q("INSERT", hashMap, new C0304a(this));
                    return;
                }
                this.f7399h.d(this.f7398g, new c.a.o0.a.u.h.b(iVar.b(), c.a.o0.a.e2.c.d.f(iVar.b())));
                q0.b0(new b(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements c.a.o0.a.v2.e1.b<c.a.o0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f7402e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7403f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f7404g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f7405h;

        /* renamed from: c.a.o0.a.n.b.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0305a implements c.a.o0.a.h0.j.b<c.a.o0.a.u.h.b> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f7406a;

            public C0305a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7406a = gVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.o0.a.h0.j.b
            /* renamed from: b */
            public void a(c.a.o0.a.u.h.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                    g gVar = this.f7406a;
                    gVar.f7405h.d(gVar.f7404g, bVar);
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f7407e;

            public b(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7407e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.o0.a.z1.b.f.e.f(this.f7407e.f7405h.i(), c.a.o0.a.h.swan_bookshelf_authorize_fail).F();
                }
            }
        }

        public g(a aVar, JSONArray jSONArray, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, jSONArray, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7405h = aVar;
            this.f7402e = jSONArray;
            this.f7403f = str;
            this.f7404g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(c.a.o0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.o0.a.e2.c.d.h(iVar)) {
                    int t1 = c.a.o0.a.a2.d.g().r().L().t1();
                    String u1 = c.a.o0.a.a2.d.g().r().L().u1();
                    String D = c.a.o0.a.a2.d.g().r().D();
                    HashMap hashMap = new HashMap();
                    hashMap.put("appKey", D);
                    hashMap.put("contentIds", this.f7402e);
                    hashMap.put("category", this.f7403f);
                    hashMap.put("pkg_type", Integer.valueOf(t1));
                    hashMap.put("version_code", u1);
                    this.f7405h.Q(HttpDelete.METHOD_NAME, hashMap, new C0305a(this));
                    return;
                }
                this.f7405h.d(this.f7404g, new c.a.o0.a.u.h.b(iVar.b(), c.a.o0.a.e2.c.d.f(iVar.b())));
                q0.b0(new b(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements c.a.o0.a.h0.j.b<c.a.o0.a.u.h.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f7408a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f7409b;

        public h(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7409b = aVar;
            this.f7408a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.h0.j.b
        /* renamed from: b */
        public void a(c.a.o0.a.u.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                this.f7409b.d(this.f7408a, bVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements c.a.o0.a.h0.j.b<c.a.o0.a.u.h.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f7410a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f7411b;

        public i(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7411b = aVar;
            this.f7410a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.h0.j.b
        /* renamed from: b */
        public void a(c.a.o0.a.u.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                this.f7411b.d(this.f7410a, bVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements c.a.o0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f7412e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7413f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f7414g;

        public j(a aVar, boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7414g = aVar;
            this.f7412e = z;
            this.f7413f = str;
        }

        @Override // c.a.o0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 != 0) {
                    if (!this.f7412e) {
                        c.a.o0.a.j2.k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 10, RetrieveTaskManager.KEY);
                    }
                    this.f7414g.d(this.f7413f, new c.a.o0.a.u.h.b(1001, "user is not login"));
                    return;
                }
                if (!this.f7412e) {
                    c.a.o0.a.j2.k.M("success", 10, RetrieveTaskManager.KEY);
                }
                this.f7414g.M(this.f7413f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class k implements CallbackHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7415e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f7416f;

        public k(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7416f = aVar;
            this.f7415e = str;
        }

        @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
        public String getCurrentPageUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
        public void handleSchemeDispatchCallback(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
                this.f7416f.K(str2, this.f7415e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7417e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7418f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f7419g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f7420h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f7421i;

        /* renamed from: c.a.o0.a.n.b.a$l$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class DialogInterface$OnClickListenerC0306a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public DialogInterface$OnClickListenerC0306a(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    c.a.o0.a.a2.d.g().r().T().E();
                }
            }
        }

        public l(a aVar, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7421i = aVar;
            this.f7417e = str;
            this.f7418f = str2;
            this.f7419g = str3;
            this.f7420h = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(this.f7421i.i());
                aVar.V(this.f7417e);
                aVar.x(this.f7418f);
                aVar.y();
                aVar.n(new c.a.o0.a.w2.h.a());
                aVar.m(false);
                aVar.P(this.f7419g, new b(this));
                aVar.C(this.f7420h, new DialogInterface$OnClickListenerC0306a(this));
                aVar.X();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull c.a.o0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.o0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void C(JSONArray jSONArray, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, jSONArray, str, str2) == null) {
            c.a.o0.a.a2.d.g().r().T().g(i(), "scope_insert_bookshelf", new g(this, jSONArray, str, str2));
        }
    }

    public final void D(JSONArray jSONArray, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray, str, str2) == null) {
            c.a.o0.a.a2.d.g().r().T().g(i(), "scope_insert_bookshelf", new f(this, jSONArray, str, str2));
        }
    }

    public c.a.o0.a.u.h.b E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            Pair<c.a.o0.a.u.h.b, JSONObject> b2 = c.a.o0.a.u.i.b.b("Api-Base", str);
            c.a.o0.a.u.h.b bVar = (c.a.o0.a.u.h.b) b2.first;
            JSONObject jSONObject = (JSONObject) b2.second;
            if (!bVar.isSuccess() || jSONObject == null) {
                return bVar;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("contentIds");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                String optString = jSONObject.optString("category");
                if (TextUtils.isEmpty(optString)) {
                    return new c.a.o0.a.u.h.b(201, "category is invalid");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new c.a.o0.a.u.h.b(202, "cb is invalid");
                }
                if (!SwanAppNetworkUtils.i(i())) {
                    q0.b0(new e(this));
                    return new c.a.o0.a.u.h.b(1001, "network is not connected");
                } else if (L()) {
                    G();
                    return new c.a.o0.a.u.h.b(10003, c.a.o0.a.e2.c.d.f(10003));
                } else {
                    C(optJSONArray, optString, optString2);
                    return new c.a.o0.a.u.h.b(0);
                }
            }
            return new c.a.o0.a.u.h.b(201, "contentIds is invalid");
        }
        return (c.a.o0.a.u.h.b) invokeL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final String F(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            switch (str.hashCode()) {
                case -2130463047:
                    if (str.equals("INSERT")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 77406376:
                    if (str.equals("QUERY")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1020968928:
                    if (str.equals("UPDATE_READ_TIME")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2012838315:
                    if (str.equals(HttpDelete.METHOD_NAME)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        if (c2 != 3) {
                            return null;
                        }
                        return c.a.o0.a.c1.a.n().E();
                    }
                    return c.a.o0.a.c1.a.n().w();
                }
                return c.a.o0.a.c1.a.n().h();
            }
            return c.a.o0.a.c1.a.n().u();
        }
        return (String) invokeL.objValue;
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            q0.b0(new l(this, i().getString(c.a.o0.a.h.swan_bookshelf_setting_dialog_title), i().getString(c.a.o0.a.h.swan_bookshelf_setting_dialog_content), i().getString(c.a.o0.a.h.swanapp_string_go_settings), i().getString(c.a.o0.a.h.swanapp_close)));
        }
    }

    public final void H(c.a.o0.a.h0.j.b<c.a.o0.a.u.h.b> bVar, int i2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{bVar, Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
            if (bVar != null) {
                bVar.a(new c.a.o0.a.u.h.b(i2, str));
            }
            if (z) {
                q0.b0(new c(this, str));
            }
        }
    }

    public final void I(c.a.o0.a.h0.j.b<c.a.o0.a.u.h.b> bVar, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048582, this, bVar, jSONObject, z) == null) {
            if (bVar != null && jSONObject != null) {
                bVar.a(new c.a.o0.a.u.h.b(0, jSONObject));
            }
            if (z) {
                c.a.o0.a.c1.a.e0().b(i());
            }
        }
    }

    public c.a.o0.a.u.h.b J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            Pair<c.a.o0.a.u.h.b, JSONObject> b2 = c.a.o0.a.u.i.b.b("Api-Base", str);
            c.a.o0.a.u.h.b bVar = (c.a.o0.a.u.h.b) b2.first;
            JSONObject jSONObject = (JSONObject) b2.second;
            if (!bVar.isSuccess() || jSONObject == null) {
                return bVar;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("contentIds");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                String optString = jSONObject.optString("category");
                f7388d = optString;
                if (TextUtils.isEmpty(optString)) {
                    return new c.a.o0.a.u.h.b(201, "category is invalid");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new c.a.o0.a.u.h.b(202, "cb is invalid");
                }
                if (!SwanAppNetworkUtils.i(i())) {
                    q0.b0(new d(this));
                    return new c.a.o0.a.u.h.b(1001, "network is not connected");
                } else if (L()) {
                    G();
                    return new c.a.o0.a.u.h.b(10003, c.a.o0.a.e2.c.d.f(10003));
                } else {
                    D(optJSONArray, f7388d, optString2);
                    return new c.a.o0.a.u.h.b(0);
                }
            }
            return new c.a.o0.a.u.h.b(201, "contentIds is invalid");
        }
        return (c.a.o0.a.u.h.b) invokeL.objValue;
    }

    public final void K(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            int i2 = 1001;
            if (TextUtils.isEmpty(str)) {
                d(str2, new c.a.o0.a.u.h.b(1001, "navigateToBookshelf fail"));
            }
            try {
                i2 = new JSONObject(str).optInt("status", 1001);
            } catch (JSONException e2) {
                if (c.a.o0.a.u.c.d.f8699c) {
                    e2.printStackTrace();
                }
            }
            if (i2 == 0) {
                d(str2, new c.a.o0.a.u.h.b(i2, "navigateToBookshelf success"));
            } else {
                d(str2, new c.a.o0.a.u.h.b(i2, "navigateToBookshelf fail"));
            }
        }
    }

    public final boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            c.a.o0.a.e2.c.f fVar = c.a.o0.a.n1.q.c.a.g(true).get("scope_insert_bookshelf");
            if (fVar != null) {
                return fVar.f5519j < 0 && !fVar.f5513d;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            c.a.o0.a.c1.a.e0().d(new k(this, str));
        }
    }

    public final void N(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            c.a.o0.a.a2.e r = c.a.o0.a.a2.d.g().r();
            r.j().f(r.x(), null, new j(this, r.j().e(i()), str));
        }
    }

    public c.a.o0.a.u.h.b O(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            Pair<c.a.o0.a.u.h.b, JSONObject> b2 = c.a.o0.a.u.i.b.b("Api-Base", str);
            c.a.o0.a.u.h.b bVar = (c.a.o0.a.u.h.b) b2.first;
            JSONObject jSONObject = (JSONObject) b2.second;
            if (!bVar.isSuccess() || jSONObject == null) {
                return bVar;
            }
            f7388d = jSONObject.optString("category");
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new c.a.o0.a.u.h.b(202, "cb is invalid");
            }
            if (!c.a.o0.a.a2.d.g().r().j().e(i())) {
                c.a.o0.a.j2.k.M("show", 10, RetrieveTaskManager.KEY);
                N(optString);
                return new c.a.o0.a.u.h.b(0);
            }
            M(optString);
            return new c.a.o0.a.u.h.b(0);
        }
        return (c.a.o0.a.u.h.b) invokeL.objValue;
    }

    public c.a.o0.a.u.h.b P(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            Pair<c.a.o0.a.u.h.b, JSONObject> b2 = c.a.o0.a.u.i.b.b("Api-Base", str);
            c.a.o0.a.u.h.b bVar = (c.a.o0.a.u.h.b) b2.first;
            JSONObject jSONObject = (JSONObject) b2.second;
            if (!bVar.isSuccess() || jSONObject == null) {
                return bVar;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("contentIds");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new c.a.o0.a.u.h.b(202, "cb is invalid");
                }
                if (!SwanAppNetworkUtils.i(i())) {
                    return new c.a.o0.a.u.h.b(1001, "network is not connected");
                }
                if (!c.a.o0.a.a2.d.g().r().j().e(i())) {
                    return new c.a.o0.a.u.h.b(1001, "user is not login");
                }
                Object D = c.a.o0.a.a2.d.g().r().D();
                int t1 = c.a.o0.a.a2.d.g().r().L().t1();
                Object u1 = c.a.o0.a.a2.d.g().r().L().u1();
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("appKey", D);
                hashMap.put("contentIds", optJSONArray);
                hashMap.put("pkg_type", Integer.valueOf(t1));
                hashMap.put("version_code", u1);
                Q("QUERY", hashMap, new h(this, optString));
                return new c.a.o0.a.u.h.b(0);
            }
            return new c.a.o0.a.u.h.b(201, "contentIds is invalid");
        }
        return (c.a.o0.a.u.h.b) invokeL.objValue;
    }

    public final void Q(String str, HashMap<String, Object> hashMap, c.a.o0.a.h0.j.b<c.a.o0.a.u.h.b> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, str, hashMap, bVar) == null) {
            boolean equals = TextUtils.equals(str, "INSERT");
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Exception e2) {
                if (c.a.o0.a.u.c.d.f8699c) {
                    e2.printStackTrace();
                }
            }
            RequestBody create = RequestBody.create(c.a.o0.a.n1.f.f7552a, jSONObject.toString());
            String F = F(str);
            if (TextUtils.isEmpty(F)) {
                H(bVar, 1001, "operation fail, msg = url is null", equals);
                return;
            }
            if (equals) {
                q0.b0(new RunnableC0301a(this));
            }
            c.a.o0.m.d.a aVar = new c.a.o0.m.d.a(F, create, new b(this, equals, bVar));
            if (c.a.o0.m.e.a.g().c()) {
                aVar.f11817f = true;
            }
            aVar.f11818g = true;
            c.a.o0.m.e.a.g().e(aVar);
        }
    }

    public c.a.o0.a.u.h.b R(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            Pair<c.a.o0.a.u.h.b, JSONObject> b2 = c.a.o0.a.u.i.b.b("Api-Base", str);
            c.a.o0.a.u.h.b bVar = (c.a.o0.a.u.h.b) b2.first;
            JSONObject jSONObject = (JSONObject) b2.second;
            if (!bVar.isSuccess() || jSONObject == null) {
                return bVar;
            }
            String optString = jSONObject.optString("contentId");
            if (TextUtils.isEmpty(optString)) {
                return new c.a.o0.a.u.h.b(201, "contentId is invalid");
            }
            String optString2 = jSONObject.optString("category");
            if (TextUtils.isEmpty(optString2)) {
                return new c.a.o0.a.u.h.b(201, "category is invalid");
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                return new c.a.o0.a.u.h.b(202, "cb is invalid");
            }
            if (!SwanAppNetworkUtils.i(i())) {
                return new c.a.o0.a.u.h.b(1001, "network is not connected");
            }
            if (!c.a.o0.a.a2.d.g().r().j().e(i())) {
                return new c.a.o0.a.u.h.b(1001, "user is not login");
            }
            Object D = c.a.o0.a.a2.d.g().r().D();
            int t1 = c.a.o0.a.a2.d.g().r().L().t1();
            Object u1 = c.a.o0.a.a2.d.g().r().L().u1();
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("appKey", D);
            hashMap.put("contentId", optString);
            hashMap.put("category", optString2);
            hashMap.put("pkg_type", Integer.valueOf(t1));
            hashMap.put("version_code", u1);
            Q("UPDATE_READ_TIME", hashMap, new i(this, optString3));
            return new c.a.o0.a.u.h.b(0);
        }
        return (c.a.o0.a.u.h.b) invokeL.objValue;
    }
}
