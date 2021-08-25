package c.a.o0.a.u.e.j;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f extends c.a.o0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.a2.e f8940e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8941f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f8942g;

        public a(f fVar, c.a.o0.a.a2.e eVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, eVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8942g = fVar;
            this.f8940e = eVar;
            this.f8941f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8940e.P().b(this.f8942g.a().h(), this.f8941f);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NonNull c.a.o0.a.u.c.b bVar) {
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

    public c.a.o0.a.u.h.b r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String e2 = SwanAppNetworkUtils.e();
            if (TextUtils.isEmpty(e2)) {
                e2 = "unknown";
            } else if ("no".equals(e2)) {
                e2 = "none";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("networkType", e2);
                if (c.a.o0.a.u.c.d.f8699c) {
                    String str = "getNetworkType:  " + jSONObject;
                }
                return new c.a.o0.a.u.h.b(0, jSONObject);
            } catch (JSONException e3) {
                if (c.a.o0.a.u.c.d.f8699c) {
                    e3.printStackTrace();
                }
                return new c.a.o0.a.u.h.b(202);
            }
        }
        return (c.a.o0.a.u.h.b) invokeV.objValue;
    }

    public c.a.o0.a.u.h.b s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            c.a.o0.a.a2.e i2 = c.a.o0.a.a2.e.i();
            if (i2 == null) {
                if (c.a.o0.a.u.c.d.f8699c) {
                    c.a.o0.a.e0.d.b("Api-Network", "swan app is null");
                }
                return new c.a.o0.a.u.h.b(202, "swan app is null");
            }
            Pair<c.a.o0.a.u.h.b, JSONObject> b2 = c.a.o0.a.u.i.b.b("Api-Network", str);
            c.a.o0.a.u.h.b bVar = (c.a.o0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (c.a.o0.a.u.c.d.f8699c) {
                    c.a.o0.a.e0.d.b("Api-Network", "parse fail");
                }
                return bVar;
            }
            String optString = ((JSONObject) b2.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                if (c.a.o0.a.u.c.d.f8699c) {
                    c.a.o0.a.e0.d.b("Api-Network", "callback is null");
                }
                return new c.a.o0.a.u.h.b(1001, "callback is null");
            }
            c.a.o0.a.a2.d.i().post(new a(this, i2, optString));
            return new c.a.o0.a.u.h.b(0);
        }
        return (c.a.o0.a.u.h.b) invokeL.objValue;
    }
}
