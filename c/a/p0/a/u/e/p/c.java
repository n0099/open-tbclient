package c.a.p0.a.u.e.p;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.p0.a.h0.i.a;
import c.a.p0.a.h0.i.g;
import c.a.p0.a.h0.i.i;
import c.a.p0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends c.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.p0.a.h0.i.g.a
        public void a(@NonNull c.a.p0.a.h0.i.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                c.a.p0.a.h0.i.f.a("exit_skeleton");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.p0.a.h0.i.g.a
        public void a(@NonNull c.a.p0.a.h0.i.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                int d2 = gVar.d();
                if (d2 == 0) {
                    i.i(c.a.p0.a.h0.i.c.b("业务数据初始化异常；", gVar));
                    c.a.p0.a.h0.i.f.d("data_init", "good");
                    c.a.p0.a.h0.i.e.f(c.a.p0.a.h.swanapp_tip_waiting_and_retry);
                } else if (d2 == 1) {
                    i.i(c.a.p0.a.h0.i.c.b("业务数据初始化异常；", gVar));
                    c.a.p0.a.h0.i.f.d("data_init", "bad");
                    c.a.p0.a.h0.i.e.f(c.a.p0.a.h.swanapp_tip_net_unavailable);
                } else if (d2 != 2) {
                    i.i(c.a.p0.a.h0.i.c.b("业务数据初始化异常；", gVar));
                    c.a.p0.a.h0.i.f.d("data_init", "unknown");
                    c.a.p0.a.h0.i.e.f(c.a.p0.a.h.swanapp_tip_waiting_and_retry);
                } else {
                    i.i(c.a.p0.a.h0.i.c.b("业务数据初始化异常；", gVar));
                    c.a.p0.a.h0.i.f.d("data_init", "offline");
                    c.a.p0.a.h0.i.e.f(c.a.p0.a.h.swanapp_tip_net_unavailable);
                }
            }
        }
    }

    /* renamed from: c.a.p0.a.u.e.p.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0421c implements g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f9127a;

        public C0421c(c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9127a = str;
        }

        @Override // c.a.p0.a.h0.i.g.a
        public void a(@NonNull c.a.p0.a.h0.i.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                c.a.p0.a.h0.i.d.b(this.f9127a);
                i.q(1);
                c.a.p0.a.h0.i.f.c("skeleton", gVar);
                i.i(c.a.p0.a.h0.i.c.b("5秒内未触发骨架屏移除；", gVar));
                i.k();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull c.a.p0.a.u.c.b bVar) {
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
                super((c.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final c.a.p0.a.u.h.b r(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            i.d(new b(this));
            return new c.a.p0.a.u.h.b(0);
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    public c.a.p0.a.u.h.b s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (c.a.p0.a.u.c.d.f8727c) {
                String str2 = "params = " + str;
            }
            Pair<c.a.p0.a.u.h.b, JSONObject> b2 = c.a.p0.a.u.i.b.b("Api-HandleException", str);
            c.a.p0.a.u.h.b bVar = (c.a.p0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (c.a.p0.a.u.c.d.f8727c) {
                    c.a.p0.a.e0.d.b("Api-HandleException", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String optString = jSONObject.optString("code");
            if (TextUtils.isEmpty(optString)) {
                return new c.a.p0.a.u.h.b(202, "code is required");
            }
            if (c.a.p0.a.u.c.d.f8727c) {
                String str3 = "code: " + optString + "msg: " + jSONObject.optString("msg");
            }
            char c2 = 65535;
            switch (optString.hashCode()) {
                case 48:
                    if (optString.equals("0")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 49:
                    if (optString.equals("1")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 50:
                    if (optString.equals("2")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 51:
                    if (optString.equals("3")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        if (c2 != 3) {
                            return new c.a.p0.a.u.h.b(202, "unsupported code");
                        }
                        return u(jSONObject);
                    }
                    return t(jSONObject);
                }
                return r(jSONObject);
            }
            return v(jSONObject);
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0058, code lost:
        if (r2 == 1) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0061, code lost:
        return new c.a.p0.a.u.h.b(202, "status value is invalid");
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0062, code lost:
        c.a.p0.a.h0.i.d.c();
        c.a.p0.a.h0.i.i.q(0);
        c.a.p0.a.h0.i.i.d(new c.a.p0.a.u.e.p.c.a(r7));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final c.a.p0.a.u.h.b t(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
            String optString = jSONObject.optString("data");
            if (TextUtils.isEmpty(optString)) {
                return new c.a.p0.a.u.h.b(202, "data is required");
            }
            try {
                String optString2 = new JSONObject(optString).optString("status");
                if (TextUtils.isEmpty(optString2)) {
                    return new c.a.p0.a.u.h.b(202, "status is required");
                }
                char c2 = 65535;
                int hashCode = optString2.hashCode();
                if (hashCode != 48) {
                    if (hashCode == 49 && optString2.equals("1")) {
                        c2 = 0;
                    }
                } else if (optString2.equals("0")) {
                    c2 = 1;
                }
                return new c.a.p0.a.u.h.b(0);
            } catch (JSONException e2) {
                if (c.a.p0.a.u.c.d.f8727c) {
                    e2.printStackTrace();
                }
                return new c.a.p0.a.u.h.b(202, "invalid json data: " + optString);
            }
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final c.a.p0.a.u.h.b u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                return new c.a.p0.a.u.h.b(202);
            }
            String optString = optJSONObject.optString("content");
            String optString2 = optJSONObject.optString("type");
            String optString3 = optJSONObject.optString("source");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                c.a.p0.a.e0.d.h("Api-HandleException", String.format("发生jserror: type = %s, source = %s, content = %s", optString2, optString3, optString));
                i.m(a.C0218a.a(optString2, optString, optString3));
                return new c.a.p0.a.u.h.b(0);
            }
            return new c.a.p0.a.u.h.b(202);
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final c.a.p0.a.u.h.b v(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jSONObject)) == null) {
            if (w()) {
                boolean z = c.a.p0.a.u.c.d.f8727c;
                return new c.a.p0.a.u.h.b(0);
            }
            String optString = jSONObject.optString("data");
            if (TextUtils.isEmpty(optString)) {
                return new c.a.p0.a.u.h.b(202, "data is required");
            }
            try {
                String optString2 = new JSONObject(optString).optString("path");
                if (TextUtils.isEmpty(optString2)) {
                    return new c.a.p0.a.u.h.b(202, "path is required");
                }
                if (q0.I(optString2) && q0.H()) {
                    i.s(new C0421c(this, optString2));
                } else if (c.a.p0.a.u.c.d.f8727c) {
                    String str = "path is not first page: " + optString2;
                }
                return new c.a.p0.a.u.h.b(0);
            } catch (JSONException e2) {
                if (c.a.p0.a.u.c.d.f8727c) {
                    e2.printStackTrace();
                }
                return new c.a.p0.a.u.h.b(202, "invalid json data: " + optString);
            }
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final boolean w() {
        InterceptResult invokeV;
        c.a.p0.a.h0.g.f o;
        c.a.p0.a.p.e.b Z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.p0.a.h0.g.g W = c.a.p0.a.g1.f.V().W();
            if (W == null || (o = W.o()) == null || (Z2 = o.Z2()) == null) {
                return false;
            }
            return Z2.h0();
        }
        return invokeV.booleanValue;
    }
}
