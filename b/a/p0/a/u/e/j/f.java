package b.a.p0.a.u.e.j;

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
public class f extends b.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f8234e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8235f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f8236g;

        public a(f fVar, b.a.p0.a.a2.e eVar, String str) {
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
            this.f8236g = fVar;
            this.f8234e = eVar;
            this.f8235f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8234e.O().b(this.f8236g.a().g(), this.f8235f);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NonNull b.a.p0.a.u.c.b bVar) {
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

    public b.a.p0.a.u.h.b q() {
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
                if (b.a.p0.a.u.c.d.f8000c) {
                    String str = "getNetworkType:  " + jSONObject;
                }
                return new b.a.p0.a.u.h.b(0, jSONObject);
            } catch (JSONException e3) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    e3.printStackTrace();
                }
                return new b.a.p0.a.u.h.b(202);
            }
        }
        return (b.a.p0.a.u.h.b) invokeV.objValue;
    }

    public b.a.p0.a.u.h.b r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            b.a.p0.a.a2.e i2 = b.a.p0.a.a2.e.i();
            if (i2 == null) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    b.a.p0.a.e0.d.b("Api-Network", "swan app is null");
                }
                return new b.a.p0.a.u.h.b(202, "swan app is null");
            }
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-Network", str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    b.a.p0.a.e0.d.b("Api-Network", "parse fail");
                }
                return bVar;
            }
            String optString = ((JSONObject) b2.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    b.a.p0.a.e0.d.b("Api-Network", "callback is null");
                }
                return new b.a.p0.a.u.h.b(1001, "callback is null");
            }
            b.a.p0.a.a2.d.i().post(new a(this, i2, optString));
            return new b.a.p0.a.u.h.b(0);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }
}
