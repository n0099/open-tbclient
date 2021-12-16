package c.a.q0.a.w1.d.d;

import android.text.TextUtils;
import android.util.Log;
import c.a.q0.a.a1.d;
import c.a.q0.a.h0.g.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.miniapp.MiniApp;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f9015e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.w1.d.b.b f9016f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f9017g;

        public a(d dVar, String str, c.a.q0.a.w1.d.b.b bVar, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, bVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9015e = str;
            this.f9016f = bVar;
            this.f9017g = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.q0.a.m1.b bVar = new c.a.q0.a.m1.b();
                bVar.f7110g = this.f9015e;
                bVar.f7109f = c.a.q0.a.w1.d.c.a.a(this.f9016f);
                g.b i2 = this.f9017g.i("navigateTo");
                i2.n(g.f5805g, g.f5807i);
                i2.k("pluginFunPage", bVar).a();
            }
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.q0.a.w1.d.d.b
    public c.a.q0.a.u.h.b b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return new c.a.q0.a.u.h.b(201, "args params is null");
            }
            if (jSONObject.optLong("fee") < 0) {
                return new c.a.q0.a.u.h.b(201, "fee can't smaller than 0");
            }
            if (jSONObject.optJSONObject("paymentArgs") == null) {
                return new c.a.q0.a.u.h.b(201, "paymentArgs can't be null");
            }
            return null;
        }
        return (c.a.q0.a.u.h.b) invokeL.objValue;
    }

    @Override // c.a.q0.a.w1.d.d.b
    public c.a.q0.a.w1.d.b.a f(c.a.q0.a.w1.d.b.b bVar) {
        InterceptResult invokeL;
        String[] list;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) {
            File file = null;
            if (bVar == null) {
                return null;
            }
            String str = bVar.a;
            String str2 = bVar.f8991c;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            c.a.q0.a.w1.d.b.a aVar = new c.a.q0.a.w1.d.b.a();
            aVar.a = str;
            aVar.f8985b = str2;
            if (c.a.q0.a.e0.f.e.e.d()) {
                file = d.f.e();
            } else if (c.a.q0.a.x1.a.a.H()) {
                file = d.b.e();
            } else if (c.a.q0.a.x1.a.a.D()) {
                file = c.a.q0.a.e0.f.d.b.d();
            } else {
                if (TextUtils.equals(bVar.f8992d, MiniApp.MINIAPP_VERSION_DEVELOP)) {
                    String a2 = c.a.q0.a.v.a.a(str);
                    File g2 = c.a.q0.a.a1.d.g();
                    String[] list2 = g2.list();
                    if (list2 == null || g2.length() == 0) {
                        return aVar;
                    }
                    String str3 = a2 + "_dev";
                    int i3 = -1;
                    for (String str4 : list2) {
                        if (!TextUtils.isEmpty(str4) && str4.startsWith(str3)) {
                            try {
                                int parseInt = Integer.parseInt(str4.substring(str3.length()));
                                if (parseInt > i3) {
                                    i3 = parseInt;
                                }
                            } catch (NumberFormatException e2) {
                                c.a.q0.a.w1.e.a.b(Log.getStackTraceString(e2));
                            }
                        }
                    }
                    if (i3 > -1) {
                        aVar.a = str3 + i3;
                        aVar.f8988e = true;
                        File file2 = new File(g2, aVar.a + File.separator + i3);
                        aVar.f8986c = file2.getAbsolutePath();
                        aVar.f8987d = i3;
                        file = file2;
                    } else {
                        aVar.f8988e = false;
                        aVar.f8986c = null;
                    }
                } else {
                    File file3 = new File(c.a.q0.a.a1.d.g(), str);
                    if (file3.exists() && (list = file3.list()) != null && list.length != 0) {
                        String str5 = null;
                        int i4 = -1;
                        for (String str6 : list) {
                            if (!TextUtils.isEmpty(str6)) {
                                try {
                                    i2 = Integer.parseInt(str6);
                                } catch (NumberFormatException e3) {
                                    c.a.q0.a.w1.e.a.b(Log.getStackTraceString(e3));
                                    i2 = -1;
                                }
                                if (i2 > i4) {
                                    str5 = str6;
                                    i4 = i2;
                                }
                            }
                        }
                        if (i4 != -1) {
                            aVar.f8987d = i4;
                            aVar.f8988e = true;
                            file = new File(file3, str5);
                            aVar.f8986c = file.getAbsolutePath();
                        }
                    }
                    return aVar;
                }
            }
            if (file == null) {
                return aVar;
            }
            File file4 = new File(file, str2);
            if (n(file4)) {
                aVar.f8989f = true;
                aVar.f8986c = file4.getAbsolutePath();
                return aVar;
            }
            return aVar;
        }
        return (c.a.q0.a.w1.d.b.a) invokeL.objValue;
    }

    @Override // c.a.q0.a.w1.d.d.b
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.q0.a.w1.d.d.b
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.q0.a.w1.d.d.b
    public c.a.q0.a.u.h.b j(String str, c.a.q0.a.w1.d.b.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, bVar)) == null) {
            if (bVar == null) {
                return new c.a.q0.a.u.h.b(201, "pay args is null");
            }
            SwanAppActivity x = c.a.q0.a.d2.d.J().x();
            if (x == null) {
                return new c.a.q0.a.u.h.b(1001, "runtime exception, try reopen this app");
            }
            g swanAppFragmentManager = x.getSwanAppFragmentManager();
            if (swanAppFragmentManager == null) {
                return new c.a.q0.a.u.h.b(1001, "runtime exception, page manager breakdown");
            }
            c.a.q0.a.w1.e.a.b("jump to fun page");
            c.a.q0.a.d2.d.L().post(new a(this, str, bVar, swanAppFragmentManager));
            return new c.a.q0.a.u.h.b(0);
        }
        return (c.a.q0.a.u.h.b) invokeLL.objValue;
    }

    @Override // c.a.q0.a.w1.d.d.b
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.q0.a.w1.d.d.b
    public c.a.q0.a.u.h.b m(c.a.q0.a.w1.d.b.b bVar, c.a.q0.a.h0.j.b<c.a.q0.a.w1.d.c.a> bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bVar, bVar2)) == null) {
            return null;
        }
        return (c.a.q0.a.u.h.b) invokeLL.objValue;
    }

    public final boolean n(File file) {
        InterceptResult invokeL;
        String[] list;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, file)) == null) ? file != null && file.exists() && file.isDirectory() && (list = file.list()) != null && list.length > 0 : invokeL.booleanValue;
    }
}
