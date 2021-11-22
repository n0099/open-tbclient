package b.a.p0.a.h0.o.j;

import android.text.TextUtils;
import b.a.p0.a.u1.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.core.prefetch.statistics.item.RecordType;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<b.a.p0.a.h0.o.j.e.a> f5999a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6000b;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f6001a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1003870034, "Lb/a/p0/a/h0/o/j/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1003870034, "Lb/a/p0/a/h0/o/j/b$a;");
                    return;
                }
            }
            int[] iArr = new int[RecordType.values().length];
            f6001a = iArr;
            try {
                iArr[RecordType.APP_ID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6001a[RecordType.APP_VERSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6001a[RecordType.PREFETCH_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6001a[RecordType.PREFETCH_EVENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6001a[RecordType.PREFETCH_OTHER_MSG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6001a[RecordType.PREFETCH_PRELINK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f5999a = new ArrayList();
        this.f6000b = false;
    }

    public void a(String str, UbcFlowEvent ubcFlowEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, ubcFlowEvent) == null) && b(str)) {
            h.q(PrefetchEvent.MODULE, str).F(ubcFlowEvent);
        }
    }

    public final boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? !TextUtils.isEmpty(str) : invokeL.booleanValue;
    }

    public final void c(HybridUbcFlow hybridUbcFlow, b.a.p0.a.h0.o.j.e.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, hybridUbcFlow, aVar) == null) || hybridUbcFlow == null || aVar == null) {
            return;
        }
        switch (a.f6001a[aVar.f6006a.ordinal()]) {
            case 1:
                hybridUbcFlow.D("app_id", aVar.f6007b);
                return;
            case 2:
                hybridUbcFlow.D("app_version", aVar.f6007b);
                return;
            case 3:
                hybridUbcFlow.E("type", aVar.f6008c ? ThreadAchievementShareDialogView.HOT_LIST_VIEW_TYPE : "cold");
                return;
            case 4:
                hybridUbcFlow.E("source", aVar.f6007b);
                return;
            case 5:
                hybridUbcFlow.D("msg", aVar.f6007b);
                return;
            case 6:
                synchronized (this.f5999a) {
                    this.f5999a.add(aVar);
                }
                return;
            default:
                return;
        }
    }

    public void d(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048579, this, str, z) == null) && b(str)) {
            h.q(PrefetchEvent.MODULE, str).E("value", z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0);
        }
    }

    public void e(String str, b.a.p0.a.h0.o.j.e.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, aVar) == null) && b(str)) {
            c(h.q(PrefetchEvent.MODULE, str), aVar);
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, str) == null) && b(str)) {
            h.s(PrefetchEvent.MODULE, str);
            h.q(PrefetchEvent.MODULE, str);
        }
    }

    public final void g(HybridUbcFlow hybridUbcFlow) {
        List<b.a.p0.a.h0.o.j.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, hybridUbcFlow) == null) || hybridUbcFlow == null || (list = this.f5999a) == null || list.size() <= 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        synchronized (this.f5999a) {
            try {
                for (b.a.p0.a.h0.o.j.e.a aVar : this.f5999a) {
                    String str = aVar.f6007b;
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("url", str);
                    jSONObject2.put("link", aVar.f6008c ? "1" : "0");
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("links", jSONArray);
            } catch (JSONException unused) {
            }
            this.f5999a.clear();
        }
        if (jSONObject.length() > 0) {
            hybridUbcFlow.D("prelink", jSONObject.toString());
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && b(str) && !this.f6000b) {
            this.f6000b = true;
            HybridUbcFlow q = h.q(PrefetchEvent.MODULE, str);
            g(q);
            q.A();
            h.s(PrefetchEvent.MODULE, str);
        }
    }
}
