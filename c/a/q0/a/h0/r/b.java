package c.a.q0.a.h0.r;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.a.a1.d;
import c.a.q0.a.a1.g.a;
import c.a.q0.a.k;
import c.a.q0.a.u1.h;
import c.a.q0.a.z2.j0;
import c.a.q0.a.z2.q;
import c.a.q0.a.z2.w;
import c.a.q0.w.g;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.NodeJS;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HybridUbcFlow f6269e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f6270f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f6271g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f6272h;

        public a(b bVar, HybridUbcFlow hybridUbcFlow, c cVar, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, hybridUbcFlow, cVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6272h = bVar;
            this.f6269e = hybridUbcFlow;
            this.f6270f = cVar;
            this.f6271g = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HybridUbcFlow hybridUbcFlow = this.f6269e;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("loadPresetApp#run-start");
                ubcFlowEvent.a(true);
                hybridUbcFlow.F(ubcFlowEvent);
                String f2 = this.f6272h.f(this.f6270f.f11026g);
                if (TextUtils.isEmpty(f2)) {
                    this.f6271g.onFailed(0);
                    return;
                }
                JSONObject d2 = w.d(f2);
                HybridUbcFlow hybridUbcFlow2 = this.f6269e;
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("loadPresetApp#run-appInfoJson");
                ubcFlowEvent2.a(true);
                hybridUbcFlow2.F(ubcFlowEvent2);
                PMSAppInfo l = this.f6272h.l(this.f6270f, d2);
                if (l == null) {
                    this.f6271g.onFailed(1);
                    return;
                }
                HybridUbcFlow hybridUbcFlow3 = this.f6269e;
                UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("loadPresetApp#run-PMSAppInfo");
                ubcFlowEvent3.a(true);
                hybridUbcFlow3.F(ubcFlowEvent3);
                this.f6271g.a(l);
                long currentTimeMillis = System.currentTimeMillis();
                boolean e2 = this.f6272h.e(this.f6270f);
                if (b.a) {
                    String str = "签名+解压 耗时：" + (System.currentTimeMillis() - currentTimeMillis);
                }
                HybridUbcFlow hybridUbcFlow4 = this.f6269e;
                UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("loadPresetApp#run-doUnzipBundle");
                ubcFlowEvent4.a(true);
                hybridUbcFlow4.F(ubcFlowEvent4);
                if (e2) {
                    b bVar = this.f6272h;
                    c cVar = this.f6270f;
                    l.setOrientation(bVar.g(cVar.f11027h, cVar.f11026g, cVar.f11028i));
                    l.updateInstallSrc(3);
                    c.a.q0.q.g.a.i().a(this.f6270f, l);
                    HybridUbcFlow hybridUbcFlow5 = this.f6269e;
                    UbcFlowEvent ubcFlowEvent5 = new UbcFlowEvent("loadPresetApp#run-bulkInsert");
                    ubcFlowEvent5.a(true);
                    hybridUbcFlow5.F(ubcFlowEvent5);
                    this.f6271g.b(l);
                } else {
                    this.f6271g.onFailed(2);
                }
                HybridUbcFlow hybridUbcFlow6 = this.f6269e;
                UbcFlowEvent ubcFlowEvent6 = new UbcFlowEvent("loadPresetApp#run-return");
                ubcFlowEvent6.a(true);
                hybridUbcFlow6.F(ubcFlowEvent6);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1216279109, "Lc/a/q0/a/h0/r/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1216279109, "Lc/a/q0/a/h0/r/b;");
                return;
            }
        }
        a = k.a;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public boolean d(ReadableByteChannel readableByteChannel, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, readableByteChannel, str)) == null) {
            if (readableByteChannel != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        long currentTimeMillis = System.currentTimeMillis();
                        boolean c2 = j0.c(readableByteChannel, str);
                        if (a) {
                            String str2 = "签名校验结果：" + c2 + " ,耗时：" + (System.currentTimeMillis() - currentTimeMillis);
                        }
                        return c2;
                    }
                } catch (IOException e2) {
                    if (a) {
                        e2.printStackTrace();
                    }
                    return false;
                } finally {
                    c.a.q0.w.d.d(readableByteChannel);
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public abstract boolean e(c cVar);

    public abstract String f(String str);

    public final int g(int i2, String str, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j2)})) == null) {
            if (i2 == 1) {
                return c.a.q0.a.c1.b.i().v(str, j2);
            }
            return 0;
        }
        return invokeCommon.intValue;
    }

    public HashMap<String, c> h() {
        InterceptResult invokeV;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String i2 = i();
            if (TextUtils.isEmpty(i2) || (optJSONArray = w.d(i2).optJSONArray("list")) == null) {
                return null;
            }
            HashMap<String, c> hashMap = new HashMap<>();
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                c m = m(optJSONArray.optJSONObject(i3));
                if (m != null) {
                    hashMap.put(m.f11026g, m);
                }
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public abstract String i();

    public File j(int i2, String str, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j2)})) == null) {
            if (i2 == 0) {
                return d.e.i(str, String.valueOf(j2));
            }
            if (i2 == 1) {
                return c.a.q0.a.c1.b.g().a(str, String.valueOf(j2));
            }
            return null;
        }
        return (File) invokeCommon.objValue;
    }

    public void k(c cVar, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, cVar, dVar) == null) {
            HybridUbcFlow p = h.p(NodeJS.STARTUP_SCRIPT_NAME);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("loadPresetApp-start");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (dVar == null) {
                return;
            }
            if (cVar == null) {
                dVar.onFailed(0);
                return;
            }
            q.k(new a(this, p, cVar, dVar), "加载小程序预置包");
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("loadPresetApp-return");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
        }
    }

    public final PMSAppInfo l(c cVar, JSONObject jSONObject) {
        InterceptResult invokeLL;
        PMSAppInfo a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar, jSONObject)) == null) {
            if (jSONObject == null || cVar == null || (a2 = c.a.q0.q.p.f.a(jSONObject)) == null) {
                return null;
            }
            a2.copyMainPkgInfo(cVar);
            a2.createTime = System.currentTimeMillis();
            return a2;
        }
        return (PMSAppInfo) invokeLL.objValue;
    }

    public final c m(JSONObject jSONObject) {
        InterceptResult invokeL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, jSONObject)) == null) {
            if (jSONObject == null || (cVar = (c) c.a.q0.q.p.f.j(jSONObject, new c())) == null) {
                return null;
            }
            cVar.o = jSONObject.optInt("pkg_type");
            cVar.q = jSONObject.optString("bundle_name");
            if (cVar.a()) {
                return cVar;
            }
            return null;
        }
        return (c) invokeL.objValue;
    }

    public boolean n(BufferedInputStream bufferedInputStream, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, bufferedInputStream, file)) == null) {
            if (bufferedInputStream != null) {
                try {
                    if (file != null) {
                        a.c i2 = c.a.q0.a.a1.g.a.i(bufferedInputStream);
                        if ((i2 == null || i2.f4543b == -1) ? false : true) {
                            return c.a.q0.a.a1.g.a.d(bufferedInputStream, file, i2.f4543b).a;
                        }
                        return g.d(bufferedInputStream, file.getPath());
                    }
                } catch (IOException e2) {
                    if (a) {
                        e2.printStackTrace();
                    }
                    return false;
                } finally {
                    c.a.q0.w.d.d(bufferedInputStream);
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
