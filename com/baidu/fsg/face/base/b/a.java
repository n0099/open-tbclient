package com.baidu.fsg.face.base.b;

import android.content.Context;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.logging.Log;
import com.baidu.fsg.base.statistics.RimStatisticsUtil;
import com.baidu.fsg.face.base.b.b;
import com.baidu.fsg.face.base.d.g;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public C1791a f35108b;

    /* renamed from: com.baidu.fsg.face.base.b.a$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.baidu.fsg.face.base.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C1791a {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: b  reason: collision with root package name */
        public static final String f35109b = "load_so_zip_version";

        /* renamed from: c  reason: collision with root package name */
        public static final String f35110c = "load_so_modle_name";

        /* renamed from: d  reason: collision with root package name */
        public static final String f35111d = "load_default_so";

        /* renamed from: e  reason: collision with root package name */
        public static final String f35112e = "load_so_success";

        /* renamed from: f  reason: collision with root package name */
        public static final String f35113f = "load_download_so_suc";

        /* renamed from: g  reason: collision with root package name */
        public static final String f35114g = "load_so_exception_info";

        /* renamed from: h  reason: collision with root package name */
        public static final String f35115h = "load_so_execption_zip_version";
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: i  reason: collision with root package name */
        public String f35116i;

        /* renamed from: j  reason: collision with root package name */
        public String f35117j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f35118k;
        public boolean l;
        public boolean m;
        public String n;
        public String o;

        public C1791a(a aVar) {
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
            this.a = aVar;
            this.l = false;
            this.m = true;
        }

        public /* synthetic */ C1791a(a aVar, AnonymousClass1 anonymousClass1) {
            this(aVar);
        }

        private Map<String, String> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put(f35109b, this.f35116i);
                hashMap.put(f35110c, this.f35117j);
                hashMap.put(f35111d, this.l ? "1" : "-1");
                hashMap.put(f35112e, this.f35118k ? "1" : "-1");
                hashMap.put(f35113f, this.m ? "1" : "-1");
                hashMap.put(f35114g, this.n);
                hashMap.put(f35115h, this.o);
                return hashMap;
            }
            return (Map) invokeV.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65543, this) == null) {
                for (Map.Entry<String, String> entry : a().entrySet()) {
                    RimStatisticsUtil.onEventWithValue(entry.getKey(), entry.getValue());
                }
                RimStatisticsUtil.getInstance().triggerSending();
            }
        }
    }

    public a() {
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

    public boolean a(Context context, int i2, Bundle bundle) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, context, i2, bundle)) == null) {
            this.a = context;
            this.f35108b = new C1791a(this, null);
            b.a a = b.a(i2);
            c a2 = b.a(context).a(context.getApplicationContext(), a.a);
            this.f35108b.f35117j = a.a;
            try {
                if (a2.q && a2.r) {
                    if (a2.p) {
                        if (a.f35128b.compareTo(a2.n) > 0) {
                            this.f35108b.f35116i = a.f35128b;
                            a(a.f35130d, a);
                        } else {
                            a(a, a2, a.f35130d);
                        }
                    } else {
                        a(a, a2, a.f35130d);
                    }
                    this.f35108b.f35118k = true;
                    return true;
                }
                this.f35108b.f35116i = a.f35128b;
                this.f35108b.f35118k = true;
                a(a.f35130d, a);
                return true;
            } catch (Throwable th) {
                try {
                    this.f35108b.n = Log.getStackTraceString(th);
                    this.f35108b.o = this.f35108b.f35116i;
                    this.f35108b.f35118k = false;
                    return false;
                } finally {
                    this.f35108b.b();
                }
            }
        }
        return invokeLIL.booleanValue;
    }

    private void a(String[] strArr, b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, strArr, aVar) == null) {
            for (String str : strArr) {
                String str2 = b.b(this.a, aVar) + "/lib" + str + ".so";
                if (g.b(str2)) {
                    g.c(str2);
                }
                System.loadLibrary(str);
            }
            this.f35108b.l = true;
        }
    }

    private void a(b.a aVar, c cVar, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, this, aVar, cVar, strArr) == null) {
            boolean z = false;
            try {
                for (String str : strArr) {
                    System.load(b.b(this.a, aVar) + "/lib" + str + ".so");
                }
                this.f35108b.f35116i = cVar.n;
                z = true;
            } catch (Throwable th) {
                this.f35108b.m = false;
                this.f35108b.f35116i = aVar.f35128b;
                this.f35108b.n = Log.getStackTraceString(th);
                this.f35108b.o = cVar.n;
            }
            if (z) {
                return;
            }
            a(strArr, aVar);
        }
    }
}
