package c.a.r0.a.n.b;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.h2.c.j.b;
import c.a.r0.a.n2.n;
import c.a.r0.a.z2.q0;
import c.a.r0.a.z2.w;
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
public class a extends c.a.r0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static String f7853f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.r0.a.n.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0468a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f7854e;

        public RunnableC0468a(a aVar) {
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
            this.f7854e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.a.c2.b.f.e f2 = c.a.r0.a.c2.b.f.e.f(this.f7854e.getContext(), c.a.r0.a.h.swan_bookshelf_insert_async);
                f2.l(10);
                f2.s(false);
                f2.z();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.h0.j.b f7855b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f7856c;

        /* renamed from: c.a.r0.a.n.b.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0469a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public RunnableC0469a(b bVar) {
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
                    c.a.r0.a.c2.b.f.e.a();
                }
            }
        }

        /* renamed from: c.a.r0.a.n.b.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0470b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public RunnableC0470b(b bVar) {
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
                    c.a.r0.a.c2.b.f.e.f(c.a.r0.a.c1.a.c(), c.a.r0.a.h.swan_bookshelf_insert_failed).G();
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
                    c.a.r0.a.c2.b.f.e.a();
                }
            }
        }

        public b(a aVar, boolean z, c.a.r0.a.h0.j.b bVar) {
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
            this.f7856c = aVar;
            this.a = z;
            this.f7855b = bVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (this.a) {
                    q0.e0(new c(this));
                }
                a aVar = this.f7856c;
                c.a.r0.a.h0.j.b bVar = this.f7855b;
                aVar.N(bVar, 1001, "operation fail, msg = " + exc.getMessage(), this.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i2) == null) {
                if (this.a) {
                    q0.e0(new RunnableC0469a(this));
                }
                if (jSONObject == null) {
                    this.f7856c.N(this.f7855b, 1001, "server response fail", this.a);
                    return;
                }
                int optInt = jSONObject.optInt("errno", -1);
                if (optInt != 0) {
                    if (this.a) {
                        q0.e0(new RunnableC0470b(this));
                    }
                    this.f7856c.N(this.f7855b, optInt, jSONObject.optString("errmsg"), false);
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    this.f7856c.N(this.f7855b, 0, jSONObject.optString("errmsg"), this.a);
                } else {
                    this.f7856c.O(this.f7855b, optJSONObject, this.a);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i2)) == null) {
                if (response == null || response.body() == null) {
                    return null;
                }
                return w.d(response.body().string());
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7857e;

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
            this.f7857e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.a.c2.b.f.e.g(c.a.r0.a.c1.a.c(), this.f7857e).G();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f7858e;

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
            this.f7858e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.a.c2.b.f.e.f(this.f7858e.getContext(), c.a.r0.a.h.aiapps_net_error).G();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f7859e;

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
            this.f7859e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.a.c2.b.f.e.f(this.f7859e.getContext(), c.a.r0.a.h.aiapps_net_error).G();
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.r0.a.z2.g1.c<c.a.r0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f7860e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7861f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f7862g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f7863h;

        /* renamed from: c.a.r0.a.n.b.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0471a implements c.a.r0.a.h0.j.b<c.a.r0.a.u.h.b> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public C0471a(f fVar) {
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
                this.a = fVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.r0.a.h0.j.b
            /* renamed from: b */
            public void a(c.a.r0.a.u.h.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                    f fVar = this.a;
                    fVar.f7863h.d(fVar.f7862g, bVar);
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f7864e;

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
                this.f7864e = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.r0.a.c2.b.f.e.f(this.f7864e.f7863h.getContext(), c.a.r0.a.h.swan_bookshelf_authorize_fail).G();
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
            this.f7863h = aVar;
            this.f7860e = jSONArray;
            this.f7861f = str;
            this.f7862g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.r0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.r0.a.h2.c.d.h(iVar)) {
                    int type = c.a.r0.a.d2.d.J().r().V().getType();
                    String v1 = c.a.r0.a.d2.d.J().r().V().v1();
                    String N = c.a.r0.a.d2.d.J().r().N();
                    HashMap hashMap = new HashMap();
                    hashMap.put("appKey", N);
                    hashMap.put("contentIds", this.f7860e);
                    hashMap.put("category", this.f7861f);
                    hashMap.put("pkg_type", Integer.valueOf(type));
                    hashMap.put("version_code", v1);
                    this.f7863h.W("INSERT", hashMap, new C0471a(this));
                    return;
                }
                this.f7863h.d(this.f7862g, new c.a.r0.a.u.h.b(iVar.b(), c.a.r0.a.h2.c.d.f(iVar.b())));
                q0.e0(new b(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements c.a.r0.a.z2.g1.c<c.a.r0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f7865e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7866f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f7867g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f7868h;

        /* renamed from: c.a.r0.a.n.b.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0472a implements c.a.r0.a.h0.j.b<c.a.r0.a.u.h.b> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public C0472a(g gVar) {
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
                this.a = gVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.r0.a.h0.j.b
            /* renamed from: b */
            public void a(c.a.r0.a.u.h.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                    g gVar = this.a;
                    gVar.f7868h.d(gVar.f7867g, bVar);
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f7869e;

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
                this.f7869e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.r0.a.c2.b.f.e.f(this.f7869e.f7868h.getContext(), c.a.r0.a.h.swan_bookshelf_authorize_fail).G();
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
            this.f7868h = aVar;
            this.f7865e = jSONArray;
            this.f7866f = str;
            this.f7867g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.r0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.r0.a.h2.c.d.h(iVar)) {
                    int type = c.a.r0.a.d2.d.J().r().V().getType();
                    String v1 = c.a.r0.a.d2.d.J().r().V().v1();
                    String N = c.a.r0.a.d2.d.J().r().N();
                    HashMap hashMap = new HashMap();
                    hashMap.put("appKey", N);
                    hashMap.put("contentIds", this.f7865e);
                    hashMap.put("category", this.f7866f);
                    hashMap.put("pkg_type", Integer.valueOf(type));
                    hashMap.put("version_code", v1);
                    this.f7868h.W(HttpDelete.METHOD_NAME, hashMap, new C0472a(this));
                    return;
                }
                this.f7868h.d(this.f7867g, new c.a.r0.a.u.h.b(iVar.b(), c.a.r0.a.h2.c.d.f(iVar.b())));
                q0.e0(new b(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements c.a.r0.a.h0.j.b<c.a.r0.a.u.h.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f7870b;

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
            this.f7870b = aVar;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.h0.j.b
        /* renamed from: b */
        public void a(c.a.r0.a.u.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                this.f7870b.d(this.a, bVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements c.a.r0.a.h0.j.b<c.a.r0.a.u.h.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f7871b;

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
            this.f7871b = aVar;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.h0.j.b
        /* renamed from: b */
        public void a(c.a.r0.a.u.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                this.f7871b.d(this.a, bVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements c.a.r0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f7872e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7873f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f7874g;

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
            this.f7874g = aVar;
            this.f7872e = z;
            this.f7873f = str;
        }

        @Override // c.a.r0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 != 0) {
                    if (!this.f7872e) {
                        n.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 10, RetrieveTaskManager.KEY);
                    }
                    this.f7874g.d(this.f7873f, new c.a.r0.a.u.h.b(1001, "user is not login"));
                    return;
                }
                if (!this.f7872e) {
                    n.S("success", 10, RetrieveTaskManager.KEY);
                }
                this.f7874g.S(this.f7873f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class k implements CallbackHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7875e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f7876f;

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
            this.f7876f = aVar;
            this.f7875e = str;
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
                this.f7876f.Q(str2, this.f7875e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7877e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7878f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f7879g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f7880h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f7881i;

        /* renamed from: c.a.r0.a.n.b.a$l$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class DialogInterface$OnClickListenerC0473a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public DialogInterface$OnClickListenerC0473a(l lVar) {
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
                    c.a.r0.a.d2.d.J().r().d0().E();
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
            this.f7881i = aVar;
            this.f7877e = str;
            this.f7878f = str2;
            this.f7879g = str3;
            this.f7880h = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(this.f7881i.getContext());
                aVar.V(this.f7877e);
                aVar.x(this.f7878f);
                aVar.y();
                aVar.n(new c.a.r0.a.a3.h.a());
                aVar.m(false);
                aVar.P(this.f7879g, new b(this));
                aVar.C(this.f7880h, new DialogInterface$OnClickListenerC0473a(this));
                aVar.X();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull c.a.r0.a.u.c.b bVar) {
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
                super((c.a.r0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void I(JSONArray jSONArray, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, jSONArray, str, str2) == null) {
            c.a.r0.a.d2.d.J().r().d0().g(getContext(), "scope_insert_bookshelf", new g(this, jSONArray, str, str2));
        }
    }

    public final void J(JSONArray jSONArray, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray, str, str2) == null) {
            c.a.r0.a.d2.d.J().r().d0().g(getContext(), "scope_insert_bookshelf", new f(this, jSONArray, str, str2));
        }
    }

    public c.a.r0.a.u.h.b K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#deleteBookshelf", false);
            Pair<c.a.r0.a.u.h.b, JSONObject> s = s(str);
            c.a.r0.a.u.h.b bVar = (c.a.r0.a.u.h.b) s.first;
            JSONObject jSONObject = (JSONObject) s.second;
            if (!bVar.isSuccess() || jSONObject == null) {
                return bVar;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("contentIds");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                String optString = jSONObject.optString("category");
                if (TextUtils.isEmpty(optString)) {
                    return new c.a.r0.a.u.h.b(201, "category is invalid");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new c.a.r0.a.u.h.b(202, "cb is invalid");
                }
                if (!SwanAppNetworkUtils.i(getContext())) {
                    q0.e0(new e(this));
                    return new c.a.r0.a.u.h.b(1001, "network is not connected");
                } else if (R()) {
                    M();
                    return new c.a.r0.a.u.h.b(10003, c.a.r0.a.h2.c.d.f(10003));
                } else {
                    I(optJSONArray, optString, optString2);
                    return c.a.r0.a.u.h.b.f();
                }
            }
            return new c.a.r0.a.u.h.b(201, "contentIds is invalid");
        }
        return (c.a.r0.a.u.h.b) invokeL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final String L(String str) {
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
                        return c.a.r0.a.c1.a.o().H();
                    }
                    return c.a.r0.a.c1.a.o().y();
                }
                return c.a.r0.a.c1.a.o().h();
            }
            return c.a.r0.a.c1.a.o().w();
        }
        return (String) invokeL.objValue;
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            q0.e0(new l(this, getContext().getString(c.a.r0.a.h.swan_bookshelf_setting_dialog_title), getContext().getString(c.a.r0.a.h.swan_bookshelf_setting_dialog_content), getContext().getString(c.a.r0.a.h.swanapp_string_go_settings), getContext().getString(c.a.r0.a.h.swanapp_close)));
        }
    }

    public final void N(c.a.r0.a.h0.j.b<c.a.r0.a.u.h.b> bVar, int i2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{bVar, Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
            if (bVar != null) {
                bVar.a(new c.a.r0.a.u.h.b(i2, str));
            }
            if (z) {
                q0.e0(new c(this, str));
            }
        }
    }

    public final void O(c.a.r0.a.h0.j.b<c.a.r0.a.u.h.b> bVar, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048582, this, bVar, jSONObject, z) == null) {
            if (bVar != null && jSONObject != null) {
                bVar.a(new c.a.r0.a.u.h.b(0, jSONObject));
            }
            if (z) {
                c.a.r0.a.c1.a.l0().b(getContext());
            }
        }
    }

    public c.a.r0.a.u.h.b P(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#insertBookshelf", false);
            Pair<c.a.r0.a.u.h.b, JSONObject> s = s(str);
            c.a.r0.a.u.h.b bVar = (c.a.r0.a.u.h.b) s.first;
            JSONObject jSONObject = (JSONObject) s.second;
            if (!bVar.isSuccess() || jSONObject == null) {
                return bVar;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("contentIds");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                String optString = jSONObject.optString("category");
                f7853f = optString;
                if (TextUtils.isEmpty(optString)) {
                    return new c.a.r0.a.u.h.b(201, "category is invalid");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new c.a.r0.a.u.h.b(202, "cb is invalid");
                }
                if (!SwanAppNetworkUtils.i(getContext())) {
                    q0.e0(new d(this));
                    return new c.a.r0.a.u.h.b(1001, "network is not connected");
                } else if (R()) {
                    M();
                    return new c.a.r0.a.u.h.b(10003, c.a.r0.a.h2.c.d.f(10003));
                } else {
                    J(optJSONArray, f7853f, optString2);
                    return c.a.r0.a.u.h.b.f();
                }
            }
            return new c.a.r0.a.u.h.b(201, "contentIds is invalid");
        }
        return (c.a.r0.a.u.h.b) invokeL.objValue;
    }

    public final void Q(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            int i2 = 1001;
            if (TextUtils.isEmpty(str)) {
                d(str2, new c.a.r0.a.u.h.b(1001, "navigateToBookshelf fail"));
            }
            try {
                i2 = new JSONObject(str).optInt("status", 1001);
            } catch (JSONException e2) {
                p("json put data fail", e2, false);
            }
            if (i2 == 0) {
                d(str2, new c.a.r0.a.u.h.b(i2, "navigateToBookshelf success"));
            } else {
                d(str2, new c.a.r0.a.u.h.b(i2, "navigateToBookshelf fail"));
            }
        }
    }

    public final boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            c.a.r0.a.h2.c.f fVar = c.a.r0.a.p1.r.c.a.g(true).get("scope_insert_bookshelf");
            if (fVar != null) {
                return fVar.f7273j < 0 && !fVar.f7267d;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void S(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            c.a.r0.a.c1.a.l0().d(new k(this, str));
        }
    }

    public final void T(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            c.a.r0.a.d2.e r = c.a.r0.a.d2.d.J().r();
            r.M().f(r.x(), null, new j(this, r.M().e(getContext()), str));
        }
    }

    public c.a.r0.a.u.h.b U(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            q("#navigateToBookshelf", false);
            Pair<c.a.r0.a.u.h.b, JSONObject> s = s(str);
            c.a.r0.a.u.h.b bVar = (c.a.r0.a.u.h.b) s.first;
            JSONObject jSONObject = (JSONObject) s.second;
            if (!bVar.isSuccess() || jSONObject == null) {
                return bVar;
            }
            f7853f = jSONObject.optString("category");
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new c.a.r0.a.u.h.b(202, "cb is invalid");
            }
            if (!c.a.r0.a.d2.d.J().r().M().e(getContext())) {
                n.S("show", 10, RetrieveTaskManager.KEY);
                T(optString);
                return c.a.r0.a.u.h.b.f();
            }
            S(optString);
            return c.a.r0.a.u.h.b.f();
        }
        return (c.a.r0.a.u.h.b) invokeL.objValue;
    }

    public c.a.r0.a.u.h.b V(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            q("#queryBookshelf", false);
            Pair<c.a.r0.a.u.h.b, JSONObject> s = s(str);
            c.a.r0.a.u.h.b bVar = (c.a.r0.a.u.h.b) s.first;
            JSONObject jSONObject = (JSONObject) s.second;
            if (!bVar.isSuccess() || jSONObject == null) {
                return bVar;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("contentIds");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new c.a.r0.a.u.h.b(202, "cb is invalid");
                }
                if (!SwanAppNetworkUtils.i(getContext())) {
                    return new c.a.r0.a.u.h.b(1001, "network is not connected");
                }
                if (!c.a.r0.a.d2.d.J().r().M().e(getContext())) {
                    return new c.a.r0.a.u.h.b(1001, "user is not login");
                }
                Object N = c.a.r0.a.d2.d.J().r().N();
                int type = c.a.r0.a.d2.d.J().r().V().getType();
                Object v1 = c.a.r0.a.d2.d.J().r().V().v1();
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("appKey", N);
                hashMap.put("contentIds", optJSONArray);
                hashMap.put("pkg_type", Integer.valueOf(type));
                hashMap.put("version_code", v1);
                W("QUERY", hashMap, new h(this, optString));
                return c.a.r0.a.u.h.b.f();
            }
            return new c.a.r0.a.u.h.b(201, "contentIds is invalid");
        }
        return (c.a.r0.a.u.h.b) invokeL.objValue;
    }

    public final void W(String str, HashMap<String, Object> hashMap, c.a.r0.a.h0.j.b<c.a.r0.a.u.h.b> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, str, hashMap, bVar) == null) {
            boolean equals = TextUtils.equals(str, "INSERT");
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Exception unused) {
            }
            RequestBody create = RequestBody.create(c.a.r0.a.p1.f.a, jSONObject.toString());
            String L = L(str);
            if (TextUtils.isEmpty(L)) {
                N(bVar, 1001, "operation fail, msg = url is null", equals);
                return;
            }
            if (equals) {
                q0.e0(new RunnableC0468a(this));
            }
            c.a.r0.p.d.a aVar = new c.a.r0.p.d.a(L, create, new b(this, equals, bVar));
            if (c.a.r0.p.e.a.g().c()) {
                aVar.f11595f = true;
            }
            aVar.f11596g = true;
            c.a.r0.p.e.a.g().e(aVar);
        }
    }

    public c.a.r0.a.u.h.b X(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            q("#updateBookshelfReadTime", false);
            Pair<c.a.r0.a.u.h.b, JSONObject> s = s(str);
            c.a.r0.a.u.h.b bVar = (c.a.r0.a.u.h.b) s.first;
            JSONObject jSONObject = (JSONObject) s.second;
            if (!bVar.isSuccess() || jSONObject == null) {
                return bVar;
            }
            String optString = jSONObject.optString("contentId");
            if (TextUtils.isEmpty(optString)) {
                return new c.a.r0.a.u.h.b(201, "contentId is invalid");
            }
            String optString2 = jSONObject.optString("category");
            if (TextUtils.isEmpty(optString2)) {
                return new c.a.r0.a.u.h.b(201, "category is invalid");
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                return new c.a.r0.a.u.h.b(202, "cb is invalid");
            }
            if (!SwanAppNetworkUtils.i(getContext())) {
                return new c.a.r0.a.u.h.b(1001, "network is not connected");
            }
            if (!c.a.r0.a.d2.d.J().r().M().e(getContext())) {
                return new c.a.r0.a.u.h.b(1001, "user is not login");
            }
            Object N = c.a.r0.a.d2.d.J().r().N();
            int type = c.a.r0.a.d2.d.J().r().V().getType();
            Object v1 = c.a.r0.a.d2.d.J().r().V().v1();
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("appKey", N);
            hashMap.put("contentId", optString);
            hashMap.put("category", optString2);
            hashMap.put("pkg_type", Integer.valueOf(type));
            hashMap.put("version_code", v1);
            W("UPDATE_READ_TIME", hashMap, new i(this, optString3));
            return c.a.r0.a.u.h.b.f();
        }
        return (c.a.r0.a.u.h.b) invokeL.objValue;
    }

    @Override // c.a.r0.a.u.c.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? "Bookshelf" : (String) invokeV.objValue;
    }

    @Override // c.a.r0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? "SwanAppBookshelfApi" : (String) invokeV.objValue;
    }
}
