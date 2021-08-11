package c.a.n0.a.u.e.o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.n0.a.v2.q0;
import c.a.n0.a.v2.r0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends c.a.n0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f8809e;

        public a(c cVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8809e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || c.a.n0.a.z1.b.f.e.d()) {
                return;
            }
            c.a.n0.a.z1.b.f.e.f(this.f8809e, c.a.n0.a.h.clipboardapi_tip_content).F();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull c.a.n0.a.u.c.b bVar) {
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
                super((c.a.n0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public c.a.n0.a.u.h.b r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            boolean z = c.a.n0.a.u.c.d.f8453c;
            JSONObject jSONObject = new JSONObject();
            try {
                CharSequence a2 = r0.b(i()).a();
                jSONObject.put("data", TextUtils.isEmpty(a2) ? "" : a2.toString());
                if (c.a.n0.a.u.c.d.f8453c) {
                    String str = "getClipboardData:  " + jSONObject;
                }
                return new c.a.n0.a.u.h.b(0, jSONObject);
            } catch (JSONException e2) {
                if (c.a.n0.a.u.c.d.f8453c) {
                    e2.printStackTrace();
                }
                return new c.a.n0.a.u.h.b(1001, "JSONException");
            }
        }
        return (c.a.n0.a.u.h.b) invokeV.objValue;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public c.a.n0.a.u.h.b s(String str) {
        InterceptResult invokeL;
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            boolean z = c.a.n0.a.u.c.d.f8453c;
            Pair<c.a.n0.a.u.h.b, JSONObject> b2 = c.a.n0.a.u.i.b.b("Api-ClipboardApi", str);
            c.a.n0.a.u.h.b bVar = (c.a.n0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (c.a.n0.a.u.c.d.f8453c) {
                    c.a.n0.a.e0.d.b("Api-ClipboardApi", "parse fail");
                }
                return bVar;
            }
            r0.b(i()).c(((JSONObject) b2.second).optString("data"));
            c.a.n0.a.a2.e r = c.a.n0.a.a2.d.g().r();
            if (r != null && (x = r.x()) != null) {
                q0.c0(new a(this, x), 200L);
            }
            return new c.a.n0.a.u.h.b(0);
        }
        return (c.a.n0.a.u.h.b) invokeL.objValue;
    }
}
