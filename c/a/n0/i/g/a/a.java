package c.a.n0.i.g.a;

import android.util.Log;
import c.a.n0.a.k0.b;
import c.a.n0.a.t1.e;
import c.a.n0.a.y1.a;
import com.baidu.appsearchlib.Info;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends c.a.n0.i.d.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f8553c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.i.g.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0681a implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C0681a(a aVar, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.n0.a.y1.a.f
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == -1) {
                    a.c(this.a, "202");
                } else if (i != 1) {
                    this.a.onFail(101, "noPermission");
                } else {
                    a.c(this.a, BasicPushStatus.SUCCESS_CODE);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-52180931, "Lc/a/n0/i/g/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-52180931, "Lc/a/n0/i/g/a/a;");
                return;
            }
        }
        f8553c = c.a.n0.a.a.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a() {
        super("addShortcutToDesktop");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void c(b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, bVar, str) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("data", str);
            } catch (JSONException e2) {
                if (f8553c) {
                    e2.printStackTrace();
                }
            }
            bVar.a(jSONObject);
        }
    }

    @Override // c.a.n0.i.d.a
    public c.a.n0.a.k.h.b a(JSONObject jSONObject, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
            e a0 = e.a0();
            if (a0 != null && a0.x() != null && a0.V() != null) {
                if (c.a.n0.a.y1.a.s(a0.x(), a0.V().K(), a0.V().H()) == 1) {
                    c(bVar, Info.kBaiduPIDValue);
                    return null;
                }
                c.a.n0.a.y1.a.j(a0.x(), a0.V(), 1, new C0681a(this, bVar));
                return null;
            }
            bVar.onFail(100, "swan or activity is null");
            if (f8553c) {
                Log.d("AddShortcutToDesktop", "swan or activity is null");
                return null;
            }
            return null;
        }
        return (c.a.n0.a.k.h.b) invokeLL.objValue;
    }
}
