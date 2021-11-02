package b.a.p0.a.u.e.m;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.SavedStateHandle;
import b.a.p0.a.a2.e;
import b.a.p0.a.k2.c;
import b.a.p0.a.u.c.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.u.e.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0409a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f8332a;

        public C0409a(a aVar) {
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
            this.f8332a = aVar;
        }

        @Override // b.a.p0.a.u.e.m.a.b
        public b.a.p0.a.u.h.b a(e eVar, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, eVar, str)) == null) {
                JSONObject z = a.z(this.f8332a.u(eVar).getString(str, null));
                if (z == null) {
                    return new b.a.p0.a.u.h.b(202, "JSONException");
                }
                return new b.a.p0.a.u.h.b(0, z);
            }
            return (b.a.p0.a.u.h.b) invokeLL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        b.a.p0.a.u.h.b a(e eVar, String str);
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

    @Nullable
    public static String A(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject.isNull("data")) {
                return null;
            }
            return jSONObject.optString("data");
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public static String B(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject.isNull("key")) {
                return null;
            }
            return jSONObject.optString("key");
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public static JSONObject z(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("key")) {
                        jSONObject.remove("key");
                    }
                    return jSONObject;
                } catch (JSONException unused) {
                    boolean z = d.f8000c;
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            if (str == null) {
                str = "";
            }
            try {
                jSONObject2.put("data", str);
                return jSONObject2;
            } catch (JSONException unused2) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public b.a.p0.a.u.h.b C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            boolean z = d.f8000c;
            e i2 = e.i();
            if (x() && i2 == null) {
                return new b.a.p0.a.u.h.b(1001, "swan app is null");
            }
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-Storage", str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (d.f8000c) {
                    b.a.p0.a.e0.d.b("Api-Storage", "parse fail");
                }
                return bVar;
            }
            String B = B((JSONObject) b2.second);
            if (B == null) {
                return new b.a.p0.a.u.h.b(202);
            }
            u(i2).remove(B);
            G();
            return new b.a.p0.a.u.h.b(0);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public b.a.p0.a.u.h.b D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            boolean z = d.f8000c;
            return C(str);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public b.a.p0.a.u.h.b E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            boolean z = d.f8000c;
            if (str != null && str.length() > 3145728) {
                return new b.a.p0.a.u.h.b(1001, "exceed storage item max length");
            }
            e i2 = e.i();
            if (x() && i2 == null) {
                return new b.a.p0.a.u.h.b(1001, "swan app is null");
            }
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-Storage", str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (d.f8000c) {
                    b.a.p0.a.e0.d.b("Api-Storage", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String B = B(jSONObject);
            if (B == null) {
                return new b.a.p0.a.u.h.b(202);
            }
            if (c.b(B)) {
                return new b.a.p0.a.u.h.b(1001, "exceed storage key max length");
            }
            String A = A(jSONObject);
            if (A == null) {
                return new b.a.p0.a.u.h.b(202);
            }
            if (c.c(A)) {
                return new b.a.p0.a.u.h.b(1001, "exceed storage item max length");
            }
            if (y(i2, B, A)) {
                if (d.f8000c) {
                    b.a.p0.a.e0.d.b("Api-Storage", "exceed storage max length");
                }
                return new b.a.p0.a.u.h.b(1003, "exceed storage max length");
            }
            u(i2).putString(B, A);
            G();
            return new b.a.p0.a.u.h.b(0);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public b.a.p0.a.u.h.b F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            boolean z = d.f8000c;
            return E(str);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            b.a.p0.a.q2.d.f7425h.update();
        }
    }

    public b.a.p0.a.u.h.b q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            boolean z = d.f8000c;
            e i2 = e.i();
            if (x() && i2 == null) {
                return new b.a.p0.a.u.h.b(1001, "swan app is null");
            }
            u(i2).edit().clear().apply();
            G();
            return new b.a.p0.a.u.h.b(0);
        }
        return (b.a.p0.a.u.h.b) invokeV.objValue;
    }

    public b.a.p0.a.u.h.b r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            boolean z = d.f8000c;
            return q();
        }
        return (b.a.p0.a.u.h.b) invokeV.objValue;
    }

    public b.a.p0.a.u.h.b s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            boolean z = d.f8000c;
            return t(str, new C0409a(this));
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final b.a.p0.a.u.h.b t(String str, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, bVar)) == null) {
            e i2 = e.i();
            if (x() && i2 == null) {
                return new b.a.p0.a.u.h.b(1001, "swan app is null");
            }
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-Storage", str);
            b.a.p0.a.u.h.b bVar2 = (b.a.p0.a.u.h.b) b2.first;
            if (!bVar2.isSuccess()) {
                if (d.f8000c) {
                    b.a.p0.a.e0.d.b("Api-Storage", "parse fail");
                }
                return bVar2;
            }
            String B = B((JSONObject) b2.second);
            if (B == null) {
                return new b.a.p0.a.u.h.b(202);
            }
            return bVar.a(i2, B);
        }
        return (b.a.p0.a.u.h.b) invokeLL.objValue;
    }

    public b.a.p0.t.b u(@NonNull e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, eVar)) == null) ? eVar.T().g() : (b.a.p0.t.b) invokeL.objValue;
    }

    public b.a.p0.a.u.h.b v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            e i2 = e.i();
            if (i2 == null) {
                return new b.a.p0.a.u.h.b(1001, "swan app is null");
            }
            c T = i2.T();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(SavedStateHandle.KEYS, new JSONArray((Collection) T.g().a()));
                jSONObject.put("currentSize", T.e() / 1024);
                jSONObject.put("limitSize", T.n() / 1024);
                return new b.a.p0.a.u.h.b(0, jSONObject);
            } catch (JSONException e2) {
                if (d.f8000c) {
                    e2.printStackTrace();
                }
                return new b.a.p0.a.u.h.b(202, "JSONException");
            }
        }
        return (b.a.p0.a.u.h.b) invokeV.objValue;
    }

    public b.a.p0.a.u.h.b w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            boolean z = d.f8000c;
            return s(str);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean y(@Nullable e eVar, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, eVar, str, str2)) == null) {
            if (eVar == null) {
                return false;
            }
            return eVar.T().m(str, str2);
        }
        return invokeLLL.booleanValue;
    }
}
