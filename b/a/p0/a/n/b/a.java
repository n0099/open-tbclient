package b.a.p0.a.n.b;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.e2.c.j.b;
import b.a.p0.a.v2.q0;
import b.a.p0.a.v2.w;
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
public class a extends b.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static String f6732d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.n.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0298a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f6733e;

        public RunnableC0298a(a aVar) {
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
            this.f6733e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.z1.b.f.e f2 = b.a.p0.a.z1.b.f.e.f(this.f6733e.getContext(), b.a.p0.a.h.swan_bookshelf_insert_async);
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
        public final /* synthetic */ boolean f6734a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.j.b f6735b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f6736c;

        /* renamed from: b.a.p0.a.n.b.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0299a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public RunnableC0299a(b bVar) {
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
                    b.a.p0.a.z1.b.f.e.a();
                }
            }
        }

        /* renamed from: b.a.p0.a.n.b.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0300b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public RunnableC0300b(b bVar) {
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
                    b.a.p0.a.z1.b.f.e.f(b.a.p0.a.c1.a.b(), b.a.p0.a.h.swan_bookshelf_insert_failed).F();
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
                    b.a.p0.a.z1.b.f.e.a();
                }
            }
        }

        public b(a aVar, boolean z, b.a.p0.a.h0.j.b bVar) {
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
            this.f6736c = aVar;
            this.f6734a = z;
            this.f6735b = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) {
                if (this.f6734a) {
                    q0.b0(new RunnableC0299a(this));
                }
                if (jSONObject == null) {
                    this.f6736c.G(this.f6735b, 1001, "server response fail", this.f6734a);
                    return;
                }
                int optInt = jSONObject.optInt("errno", -1);
                if (optInt != 0) {
                    if (this.f6734a) {
                        q0.b0(new RunnableC0300b(this));
                    }
                    this.f6736c.G(this.f6735b, optInt, jSONObject.optString("errmsg"), false);
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    this.f6736c.G(this.f6735b, 0, jSONObject.optString("errmsg"), this.f6734a);
                } else {
                    this.f6736c.H(this.f6735b, optJSONObject, this.f6734a);
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
                if (this.f6734a) {
                    q0.b0(new c(this));
                }
                a aVar = this.f6736c;
                b.a.p0.a.h0.j.b bVar = this.f6735b;
                aVar.G(bVar, 1001, "operation fail, msg = " + exc.getMessage(), this.f6734a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6737e;

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
            this.f6737e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.z1.b.f.e.g(b.a.p0.a.c1.a.b(), this.f6737e).F();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f6738e;

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
            this.f6738e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.z1.b.f.e.f(this.f6738e.getContext(), b.a.p0.a.h.aiapps_net_error).F();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f6739e;

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
            this.f6739e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.z1.b.f.e.f(this.f6739e.getContext(), b.a.p0.a.h.aiapps_net_error).F();
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements b.a.p0.a.v2.e1.b<b.a.p0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f6740e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6741f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f6742g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f6743h;

        /* renamed from: b.a.p0.a.n.b.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0301a implements b.a.p0.a.h0.j.b<b.a.p0.a.u.h.b> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f6744a;

            public C0301a(f fVar) {
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
                this.f6744a = fVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.p0.a.h0.j.b
            /* renamed from: b */
            public void a(b.a.p0.a.u.h.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                    f fVar = this.f6744a;
                    fVar.f6743h.d(fVar.f6742g, bVar);
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f6745e;

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
                this.f6745e = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b.a.p0.a.z1.b.f.e.f(this.f6745e.f6743h.getContext(), b.a.p0.a.h.swan_bookshelf_authorize_fail).F();
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
            this.f6743h = aVar;
            this.f6740e = jSONArray;
            this.f6741f = str;
            this.f6742g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(b.a.p0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (b.a.p0.a.e2.c.d.h(iVar)) {
                    int type = b.a.p0.a.a2.d.g().r().K().getType();
                    String s1 = b.a.p0.a.a2.d.g().r().K().s1();
                    String k = b.a.p0.a.a2.d.g().r().k();
                    HashMap hashMap = new HashMap();
                    hashMap.put("appKey", k);
                    hashMap.put("contentIds", this.f6740e);
                    hashMap.put("category", this.f6741f);
                    hashMap.put("pkg_type", Integer.valueOf(type));
                    hashMap.put("version_code", s1);
                    this.f6743h.P("INSERT", hashMap, new C0301a(this));
                    return;
                }
                this.f6743h.d(this.f6742g, new b.a.p0.a.u.h.b(iVar.b(), b.a.p0.a.e2.c.d.f(iVar.b())));
                q0.b0(new b(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements b.a.p0.a.v2.e1.b<b.a.p0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f6746e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6747f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f6748g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f6749h;

        /* renamed from: b.a.p0.a.n.b.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0302a implements b.a.p0.a.h0.j.b<b.a.p0.a.u.h.b> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f6750a;

            public C0302a(g gVar) {
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
                this.f6750a = gVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.p0.a.h0.j.b
            /* renamed from: b */
            public void a(b.a.p0.a.u.h.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                    g gVar = this.f6750a;
                    gVar.f6749h.d(gVar.f6748g, bVar);
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f6751e;

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
                this.f6751e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b.a.p0.a.z1.b.f.e.f(this.f6751e.f6749h.getContext(), b.a.p0.a.h.swan_bookshelf_authorize_fail).F();
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
            this.f6749h = aVar;
            this.f6746e = jSONArray;
            this.f6747f = str;
            this.f6748g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(b.a.p0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (b.a.p0.a.e2.c.d.h(iVar)) {
                    int type = b.a.p0.a.a2.d.g().r().K().getType();
                    String s1 = b.a.p0.a.a2.d.g().r().K().s1();
                    String k = b.a.p0.a.a2.d.g().r().k();
                    HashMap hashMap = new HashMap();
                    hashMap.put("appKey", k);
                    hashMap.put("contentIds", this.f6746e);
                    hashMap.put("category", this.f6747f);
                    hashMap.put("pkg_type", Integer.valueOf(type));
                    hashMap.put("version_code", s1);
                    this.f6749h.P(HttpDelete.METHOD_NAME, hashMap, new C0302a(this));
                    return;
                }
                this.f6749h.d(this.f6748g, new b.a.p0.a.u.h.b(iVar.b(), b.a.p0.a.e2.c.d.f(iVar.b())));
                q0.b0(new b(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements b.a.p0.a.h0.j.b<b.a.p0.a.u.h.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6752a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f6753b;

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
            this.f6753b = aVar;
            this.f6752a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.h0.j.b
        /* renamed from: b */
        public void a(b.a.p0.a.u.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                this.f6753b.d(this.f6752a, bVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements b.a.p0.a.h0.j.b<b.a.p0.a.u.h.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6754a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f6755b;

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
            this.f6755b = aVar;
            this.f6754a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.h0.j.b
        /* renamed from: b */
        public void a(b.a.p0.a.u.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                this.f6755b.d(this.f6754a, bVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements b.a.p0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f6756e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6757f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f6758g;

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
            this.f6758g = aVar;
            this.f6756e = z;
            this.f6757f = str;
        }

        @Override // b.a.p0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 != 0) {
                    if (!this.f6756e) {
                        b.a.p0.a.j2.k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 10, RetrieveTaskManager.KEY);
                    }
                    this.f6758g.d(this.f6757f, new b.a.p0.a.u.h.b(1001, "user is not login"));
                    return;
                }
                if (!this.f6756e) {
                    b.a.p0.a.j2.k.M("success", 10, RetrieveTaskManager.KEY);
                }
                this.f6758g.L(this.f6757f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class k implements CallbackHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6759e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f6760f;

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
            this.f6760f = aVar;
            this.f6759e = str;
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
                this.f6760f.J(str2, this.f6759e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6761e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6762f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f6763g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f6764h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f6765i;

        /* renamed from: b.a.p0.a.n.b.a$l$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class DialogInterface$OnClickListenerC0303a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public DialogInterface$OnClickListenerC0303a(l lVar) {
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
                    b.a.p0.a.a2.d.g().r().S().E();
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
            this.f6765i = aVar;
            this.f6761e = str;
            this.f6762f = str2;
            this.f6763g = str3;
            this.f6764h = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(this.f6765i.getContext());
                aVar.V(this.f6761e);
                aVar.x(this.f6762f);
                aVar.y();
                aVar.n(new b.a.p0.a.w2.h.a());
                aVar.m(false);
                aVar.P(this.f6763g, new b(this));
                aVar.C(this.f6764h, new DialogInterface$OnClickListenerC0303a(this));
                aVar.X();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull b.a.p0.a.u.c.b bVar) {
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
                super((b.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void B(JSONArray jSONArray, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, jSONArray, str, str2) == null) {
            b.a.p0.a.a2.d.g().r().S().g(getContext(), "scope_insert_bookshelf", new g(this, jSONArray, str, str2));
        }
    }

    public final void C(JSONArray jSONArray, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray, str, str2) == null) {
            b.a.p0.a.a2.d.g().r().S().g(getContext(), "scope_insert_bookshelf", new f(this, jSONArray, str, str2));
        }
    }

    public b.a.p0.a.u.h.b D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-Base", str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) b2.first;
            JSONObject jSONObject = (JSONObject) b2.second;
            if (!bVar.isSuccess() || jSONObject == null) {
                return bVar;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("contentIds");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                String optString = jSONObject.optString("category");
                if (TextUtils.isEmpty(optString)) {
                    return new b.a.p0.a.u.h.b(201, "category is invalid");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new b.a.p0.a.u.h.b(202, "cb is invalid");
                }
                if (!SwanAppNetworkUtils.i(getContext())) {
                    q0.b0(new e(this));
                    return new b.a.p0.a.u.h.b(1001, "network is not connected");
                } else if (K()) {
                    F();
                    return new b.a.p0.a.u.h.b(10003, b.a.p0.a.e2.c.d.f(10003));
                } else {
                    B(optJSONArray, optString, optString2);
                    return new b.a.p0.a.u.h.b(0);
                }
            }
            return new b.a.p0.a.u.h.b(201, "contentIds is invalid");
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final String E(String str) {
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
                        return b.a.p0.a.c1.a.n().E();
                    }
                    return b.a.p0.a.c1.a.n().w();
                }
                return b.a.p0.a.c1.a.n().h();
            }
            return b.a.p0.a.c1.a.n().u();
        }
        return (String) invokeL.objValue;
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            q0.b0(new l(this, getContext().getString(b.a.p0.a.h.swan_bookshelf_setting_dialog_title), getContext().getString(b.a.p0.a.h.swan_bookshelf_setting_dialog_content), getContext().getString(b.a.p0.a.h.swanapp_string_go_settings), getContext().getString(b.a.p0.a.h.swanapp_close)));
        }
    }

    public final void G(b.a.p0.a.h0.j.b<b.a.p0.a.u.h.b> bVar, int i2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{bVar, Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
            if (bVar != null) {
                bVar.a(new b.a.p0.a.u.h.b(i2, str));
            }
            if (z) {
                q0.b0(new c(this, str));
            }
        }
    }

    public final void H(b.a.p0.a.h0.j.b<b.a.p0.a.u.h.b> bVar, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048582, this, bVar, jSONObject, z) == null) {
            if (bVar != null && jSONObject != null) {
                bVar.a(new b.a.p0.a.u.h.b(0, jSONObject));
            }
            if (z) {
                b.a.p0.a.c1.a.e0().b(getContext());
            }
        }
    }

    public b.a.p0.a.u.h.b I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-Base", str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) b2.first;
            JSONObject jSONObject = (JSONObject) b2.second;
            if (!bVar.isSuccess() || jSONObject == null) {
                return bVar;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("contentIds");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                String optString = jSONObject.optString("category");
                f6732d = optString;
                if (TextUtils.isEmpty(optString)) {
                    return new b.a.p0.a.u.h.b(201, "category is invalid");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new b.a.p0.a.u.h.b(202, "cb is invalid");
                }
                if (!SwanAppNetworkUtils.i(getContext())) {
                    q0.b0(new d(this));
                    return new b.a.p0.a.u.h.b(1001, "network is not connected");
                } else if (K()) {
                    F();
                    return new b.a.p0.a.u.h.b(10003, b.a.p0.a.e2.c.d.f(10003));
                } else {
                    C(optJSONArray, f6732d, optString2);
                    return new b.a.p0.a.u.h.b(0);
                }
            }
            return new b.a.p0.a.u.h.b(201, "contentIds is invalid");
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final void J(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            int i2 = 1001;
            if (TextUtils.isEmpty(str)) {
                d(str2, new b.a.p0.a.u.h.b(1001, "navigateToBookshelf fail"));
            }
            try {
                i2 = new JSONObject(str).optInt("status", 1001);
            } catch (JSONException e2) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    e2.printStackTrace();
                }
            }
            if (i2 == 0) {
                d(str2, new b.a.p0.a.u.h.b(i2, "navigateToBookshelf success"));
            } else {
                d(str2, new b.a.p0.a.u.h.b(i2, "navigateToBookshelf fail"));
            }
        }
    }

    public final boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            b.a.p0.a.e2.c.f fVar = b.a.p0.a.n1.q.c.a.g(true).get("scope_insert_bookshelf");
            if (fVar != null) {
                return fVar.j < 0 && !fVar.f4907d;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void L(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            b.a.p0.a.c1.a.e0().d(new k(this, str));
        }
    }

    public final void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            b.a.p0.a.a2.e r = b.a.p0.a.a2.d.g().r();
            r.j().f(r.x(), null, new j(this, r.j().e(getContext()), str));
        }
    }

    public b.a.p0.a.u.h.b N(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-Base", str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) b2.first;
            JSONObject jSONObject = (JSONObject) b2.second;
            if (!bVar.isSuccess() || jSONObject == null) {
                return bVar;
            }
            f6732d = jSONObject.optString("category");
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new b.a.p0.a.u.h.b(202, "cb is invalid");
            }
            if (!b.a.p0.a.a2.d.g().r().j().e(getContext())) {
                b.a.p0.a.j2.k.M("show", 10, RetrieveTaskManager.KEY);
                M(optString);
                return new b.a.p0.a.u.h.b(0);
            }
            L(optString);
            return new b.a.p0.a.u.h.b(0);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public b.a.p0.a.u.h.b O(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-Base", str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) b2.first;
            JSONObject jSONObject = (JSONObject) b2.second;
            if (!bVar.isSuccess() || jSONObject == null) {
                return bVar;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("contentIds");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new b.a.p0.a.u.h.b(202, "cb is invalid");
                }
                if (!SwanAppNetworkUtils.i(getContext())) {
                    return new b.a.p0.a.u.h.b(1001, "network is not connected");
                }
                if (!b.a.p0.a.a2.d.g().r().j().e(getContext())) {
                    return new b.a.p0.a.u.h.b(1001, "user is not login");
                }
                Object k2 = b.a.p0.a.a2.d.g().r().k();
                int type = b.a.p0.a.a2.d.g().r().K().getType();
                Object s1 = b.a.p0.a.a2.d.g().r().K().s1();
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("appKey", k2);
                hashMap.put("contentIds", optJSONArray);
                hashMap.put("pkg_type", Integer.valueOf(type));
                hashMap.put("version_code", s1);
                P("QUERY", hashMap, new h(this, optString));
                return new b.a.p0.a.u.h.b(0);
            }
            return new b.a.p0.a.u.h.b(201, "contentIds is invalid");
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final void P(String str, HashMap<String, Object> hashMap, b.a.p0.a.h0.j.b<b.a.p0.a.u.h.b> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, str, hashMap, bVar) == null) {
            boolean equals = TextUtils.equals(str, "INSERT");
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Exception e2) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    e2.printStackTrace();
                }
            }
            RequestBody create = RequestBody.create(b.a.p0.a.n1.f.f6891a, jSONObject.toString());
            String E = E(str);
            if (TextUtils.isEmpty(E)) {
                G(bVar, 1001, "operation fail, msg = url is null", equals);
                return;
            }
            if (equals) {
                q0.b0(new RunnableC0298a(this));
            }
            b.a.p0.m.d.a aVar = new b.a.p0.m.d.a(E, create, new b(this, equals, bVar));
            if (b.a.p0.m.e.a.g().c()) {
                aVar.f11038f = true;
            }
            aVar.f11039g = true;
            b.a.p0.m.e.a.g().e(aVar);
        }
    }

    public b.a.p0.a.u.h.b Q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-Base", str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) b2.first;
            JSONObject jSONObject = (JSONObject) b2.second;
            if (!bVar.isSuccess() || jSONObject == null) {
                return bVar;
            }
            String optString = jSONObject.optString("contentId");
            if (TextUtils.isEmpty(optString)) {
                return new b.a.p0.a.u.h.b(201, "contentId is invalid");
            }
            String optString2 = jSONObject.optString("category");
            if (TextUtils.isEmpty(optString2)) {
                return new b.a.p0.a.u.h.b(201, "category is invalid");
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                return new b.a.p0.a.u.h.b(202, "cb is invalid");
            }
            if (!SwanAppNetworkUtils.i(getContext())) {
                return new b.a.p0.a.u.h.b(1001, "network is not connected");
            }
            if (!b.a.p0.a.a2.d.g().r().j().e(getContext())) {
                return new b.a.p0.a.u.h.b(1001, "user is not login");
            }
            Object k2 = b.a.p0.a.a2.d.g().r().k();
            int type = b.a.p0.a.a2.d.g().r().K().getType();
            Object s1 = b.a.p0.a.a2.d.g().r().K().s1();
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("appKey", k2);
            hashMap.put("contentId", optString);
            hashMap.put("category", optString2);
            hashMap.put("pkg_type", Integer.valueOf(type));
            hashMap.put("version_code", s1);
            P("UPDATE_READ_TIME", hashMap, new i(this, optString3));
            return new b.a.p0.a.u.h.b(0);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }
}
