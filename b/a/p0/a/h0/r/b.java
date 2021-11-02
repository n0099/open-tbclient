package b.a.p0.a.h0.r;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a1.e;
import b.a.p0.a.a1.h.a;
import b.a.p0.a.k;
import b.a.p0.a.r1.h;
import b.a.p0.a.v2.j0;
import b.a.p0.a.v2.q;
import b.a.p0.a.v2.w;
import b.a.p0.t.g;
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

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f5741a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HybridUbcFlow f5742e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f5743f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f5744g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f5745h;

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
            this.f5745h = bVar;
            this.f5742e = hybridUbcFlow;
            this.f5743f = cVar;
            this.f5744g = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HybridUbcFlow hybridUbcFlow = this.f5742e;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("loadPresetApp#run-start");
                ubcFlowEvent.a(true);
                hybridUbcFlow.C(ubcFlowEvent);
                String f2 = this.f5745h.f(this.f5743f.f11076g);
                if (TextUtils.isEmpty(f2)) {
                    this.f5744g.onFailed(0);
                    return;
                }
                JSONObject d2 = w.d(f2);
                HybridUbcFlow hybridUbcFlow2 = this.f5742e;
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("loadPresetApp#run-appInfoJson");
                ubcFlowEvent2.a(true);
                hybridUbcFlow2.C(ubcFlowEvent2);
                PMSAppInfo l = this.f5745h.l(this.f5743f, d2);
                if (l == null) {
                    this.f5744g.onFailed(1);
                    return;
                }
                HybridUbcFlow hybridUbcFlow3 = this.f5742e;
                UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("loadPresetApp#run-PMSAppInfo");
                ubcFlowEvent3.a(true);
                hybridUbcFlow3.C(ubcFlowEvent3);
                this.f5744g.a(l);
                long currentTimeMillis = System.currentTimeMillis();
                boolean e2 = this.f5745h.e(this.f5743f);
                if (b.f5741a) {
                    String str = "签名+解压 耗时：" + (System.currentTimeMillis() - currentTimeMillis);
                }
                HybridUbcFlow hybridUbcFlow4 = this.f5742e;
                UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("loadPresetApp#run-doUnzipBundle");
                ubcFlowEvent4.a(true);
                hybridUbcFlow4.C(ubcFlowEvent4);
                if (e2) {
                    b bVar = this.f5745h;
                    c cVar = this.f5743f;
                    l.setOrientation(bVar.g(cVar.f11077h, cVar.f11076g, cVar.f11078i));
                    l.updateInstallSrc(3);
                    b.a.p0.n.g.a.h().a(this.f5743f, l);
                    HybridUbcFlow hybridUbcFlow5 = this.f5742e;
                    UbcFlowEvent ubcFlowEvent5 = new UbcFlowEvent("loadPresetApp#run-bulkInsert");
                    ubcFlowEvent5.a(true);
                    hybridUbcFlow5.C(ubcFlowEvent5);
                    this.f5744g.b(l);
                } else {
                    this.f5744g.onFailed(2);
                }
                HybridUbcFlow hybridUbcFlow6 = this.f5742e;
                UbcFlowEvent ubcFlowEvent6 = new UbcFlowEvent("loadPresetApp#run-return");
                ubcFlowEvent6.a(true);
                hybridUbcFlow6.C(ubcFlowEvent6);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597730567, "Lb/a/p0/a/h0/r/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597730567, "Lb/a/p0/a/h0/r/b;");
                return;
            }
        }
        f5741a = k.f6397a;
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
                        if (f5741a) {
                            String str2 = "签名校验结果：" + c2 + " ,耗时：" + (System.currentTimeMillis() - currentTimeMillis);
                        }
                        return c2;
                    }
                } catch (IOException e2) {
                    if (f5741a) {
                        e2.printStackTrace();
                    }
                    return false;
                } finally {
                    b.a.p0.t.d.d(readableByteChannel);
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public abstract boolean e(c cVar);

    public abstract String f(String str);

    public final int g(int i2, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j)})) == null) {
            if (i2 == 1) {
                return b.a.p0.a.c1.b.i().v(str, j);
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
                    hashMap.put(m.f11076g, m);
                }
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public abstract String i();

    public File j(int i2, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j)})) == null) {
            if (i2 == 0) {
                return e.C0109e.i(str, String.valueOf(j));
            }
            if (i2 == 1) {
                return b.a.p0.a.c1.b.g().a(str, String.valueOf(j));
            }
            return null;
        }
        return (File) invokeCommon.objValue;
    }

    public void k(c cVar, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, cVar, dVar) == null) {
            HybridUbcFlow p = h.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("loadPresetApp-start");
            ubcFlowEvent.a(true);
            p.C(ubcFlowEvent);
            if (dVar == null) {
                return;
            }
            if (cVar == null) {
                dVar.onFailed(0);
                return;
            }
            q.j(new a(this, p, cVar, dVar), "加载小程序预置包");
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("loadPresetApp-return");
            ubcFlowEvent2.a(true);
            p.C(ubcFlowEvent2);
        }
    }

    public final PMSAppInfo l(c cVar, JSONObject jSONObject) {
        InterceptResult invokeLL;
        PMSAppInfo a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar, jSONObject)) == null) {
            if (jSONObject == null || cVar == null || (a2 = b.a.p0.n.o.e.a(jSONObject)) == null) {
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
            if (jSONObject == null || (cVar = (c) b.a.p0.n.o.e.i(jSONObject, new c())) == null) {
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
                        a.b h2 = b.a.p0.a.a1.h.a.h(bufferedInputStream);
                        if ((h2 == null || h2.f3927b == -1) ? false : true) {
                            return b.a.p0.a.a1.h.a.c(bufferedInputStream, file, h2.f3927b).f3924a;
                        }
                        return g.d(bufferedInputStream, file.getPath());
                    }
                } catch (IOException e2) {
                    if (f5741a) {
                        e2.printStackTrace();
                    }
                    return false;
                } finally {
                    b.a.p0.t.d.d(bufferedInputStream);
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
