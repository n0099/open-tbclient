package b.a.p0.a.u.e.p;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import b.a.p0.a.h0.i.a;
import b.a.p0.a.h0.i.g;
import b.a.p0.a.h0.i.i;
import b.a.p0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends b.a.p0.a.u.c.d {
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

        @Override // b.a.p0.a.h0.i.g.a
        public void a(@NonNull b.a.p0.a.h0.i.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                b.a.p0.a.h0.i.f.a("exit_skeleton");
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

        @Override // b.a.p0.a.h0.i.g.a
        public void a(@NonNull b.a.p0.a.h0.i.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                int d2 = gVar.d();
                if (d2 == 0) {
                    i.i(b.a.p0.a.h0.i.c.b("业务数据初始化异常；", gVar));
                    b.a.p0.a.h0.i.f.d("data_init", "good");
                    b.a.p0.a.h0.i.e.f(b.a.p0.a.h.swanapp_tip_waiting_and_retry);
                } else if (d2 == 1) {
                    i.i(b.a.p0.a.h0.i.c.b("业务数据初始化异常；", gVar));
                    b.a.p0.a.h0.i.f.d("data_init", "bad");
                    b.a.p0.a.h0.i.e.f(b.a.p0.a.h.swanapp_tip_net_unavailable);
                } else if (d2 != 2) {
                    i.i(b.a.p0.a.h0.i.c.b("业务数据初始化异常；", gVar));
                    b.a.p0.a.h0.i.f.d("data_init", "unknown");
                    b.a.p0.a.h0.i.e.f(b.a.p0.a.h.swanapp_tip_waiting_and_retry);
                } else {
                    i.i(b.a.p0.a.h0.i.c.b("业务数据初始化异常；", gVar));
                    b.a.p0.a.h0.i.f.d("data_init", "offline");
                    b.a.p0.a.h0.i.e.f(b.a.p0.a.h.swanapp_tip_net_unavailable);
                }
            }
        }
    }

    /* renamed from: b.a.p0.a.u.e.p.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0416c implements g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f8386a;

        public C0416c(c cVar, String str) {
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
            this.f8386a = str;
        }

        @Override // b.a.p0.a.h0.i.g.a
        public void a(@NonNull b.a.p0.a.h0.i.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                b.a.p0.a.h0.i.d.b(this.f8386a);
                i.q(1);
                b.a.p0.a.h0.i.f.c("skeleton", gVar);
                i.i(b.a.p0.a.h0.i.c.b("5秒内未触发骨架屏移除；", gVar));
                i.k();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull b.a.p0.a.u.c.b bVar) {
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

    public final b.a.p0.a.u.h.b q(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            i.d(new b(this));
            return new b.a.p0.a.u.h.b(0);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public b.a.p0.a.u.h.b r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (b.a.p0.a.u.c.d.f8000c) {
                String str2 = "params = " + str;
            }
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-HandleException", str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    b.a.p0.a.e0.d.b("Api-HandleException", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String optString = jSONObject.optString("code");
            if (TextUtils.isEmpty(optString)) {
                return new b.a.p0.a.u.h.b(202, "code is required");
            }
            if (b.a.p0.a.u.c.d.f8000c) {
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
                            return new b.a.p0.a.u.h.b(202, "unsupported code");
                        }
                        return t(jSONObject);
                    }
                    return s(jSONObject);
                }
                return q(jSONObject);
            }
            return u(jSONObject);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0058, code lost:
        if (r2 == 1) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0061, code lost:
        return new b.a.p0.a.u.h.b(202, "status value is invalid");
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0062, code lost:
        b.a.p0.a.h0.i.d.c();
        b.a.p0.a.h0.i.i.q(0);
        b.a.p0.a.h0.i.i.d(new b.a.p0.a.u.e.p.c.a(r7));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final b.a.p0.a.u.h.b s(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
            String optString = jSONObject.optString("data");
            if (TextUtils.isEmpty(optString)) {
                return new b.a.p0.a.u.h.b(202, "data is required");
            }
            try {
                String optString2 = new JSONObject(optString).optString("status");
                if (TextUtils.isEmpty(optString2)) {
                    return new b.a.p0.a.u.h.b(202, "status is required");
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
                return new b.a.p0.a.u.h.b(0);
            } catch (JSONException e2) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    e2.printStackTrace();
                }
                return new b.a.p0.a.u.h.b(202, "invalid json data: " + optString);
            }
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final b.a.p0.a.u.h.b t(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                return new b.a.p0.a.u.h.b(202);
            }
            String optString = optJSONObject.optString("content");
            String optString2 = optJSONObject.optString("type");
            String optString3 = optJSONObject.optString("source");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                b.a.p0.a.e0.d.h("Api-HandleException", String.format("发生jserror: type = %s, source = %s, content = %s", optString2, optString3, optString));
                i.m(a.C0213a.a(optString2, optString, optString3));
                return new b.a.p0.a.u.h.b(0);
            }
            return new b.a.p0.a.u.h.b(202);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final b.a.p0.a.u.h.b u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jSONObject)) == null) {
            if (v()) {
                boolean z = b.a.p0.a.u.c.d.f8000c;
                return new b.a.p0.a.u.h.b(0);
            }
            String optString = jSONObject.optString("data");
            if (TextUtils.isEmpty(optString)) {
                return new b.a.p0.a.u.h.b(202, "data is required");
            }
            try {
                String optString2 = new JSONObject(optString).optString("path");
                if (TextUtils.isEmpty(optString2)) {
                    return new b.a.p0.a.u.h.b(202, "path is required");
                }
                if (q0.I(optString2) && q0.H()) {
                    i.s(new C0416c(this, optString2));
                } else if (b.a.p0.a.u.c.d.f8000c) {
                    String str = "path is not first page: " + optString2;
                }
                return new b.a.p0.a.u.h.b(0);
            } catch (JSONException e2) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    e2.printStackTrace();
                }
                return new b.a.p0.a.u.h.b(202, "invalid json data: " + optString);
            }
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final boolean v() {
        InterceptResult invokeV;
        b.a.p0.a.h0.g.f o;
        b.a.p0.a.p.e.b V2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            b.a.p0.a.h0.g.g U = b.a.p0.a.g1.f.T().U();
            if (U == null || (o = U.o()) == null || (V2 = o.V2()) == null) {
                return false;
            }
            return V2.g0();
        }
        return invokeV.booleanValue;
    }
}
