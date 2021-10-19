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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f39813a;

    /* renamed from: b  reason: collision with root package name */
    public C1654a f39814b;

    /* renamed from: com.baidu.fsg.face.base.b.a$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.baidu.fsg.face.base.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1654a {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: b  reason: collision with root package name */
        public static final String f39815b = "load_so_zip_version";

        /* renamed from: c  reason: collision with root package name */
        public static final String f39816c = "load_so_modle_name";

        /* renamed from: d  reason: collision with root package name */
        public static final String f39817d = "load_default_so";

        /* renamed from: e  reason: collision with root package name */
        public static final String f39818e = "load_so_success";

        /* renamed from: f  reason: collision with root package name */
        public static final String f39819f = "load_download_so_suc";

        /* renamed from: g  reason: collision with root package name */
        public static final String f39820g = "load_so_exception_info";

        /* renamed from: h  reason: collision with root package name */
        public static final String f39821h = "load_so_execption_zip_version";
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f39822a;

        /* renamed from: i  reason: collision with root package name */
        public String f39823i;

        /* renamed from: j  reason: collision with root package name */
        public String f39824j;
        public boolean k;
        public boolean l;
        public boolean m;
        public String n;
        public String o;

        public C1654a(a aVar) {
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
            this.f39822a = aVar;
            this.l = false;
            this.m = true;
        }

        public /* synthetic */ C1654a(a aVar, AnonymousClass1 anonymousClass1) {
            this(aVar);
        }

        private Map<String, String> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put(f39815b, this.f39823i);
                hashMap.put(f39816c, this.f39824j);
                hashMap.put(f39817d, this.l ? "1" : "-1");
                hashMap.put(f39818e, this.k ? "1" : "-1");
                hashMap.put(f39819f, this.m ? "1" : "-1");
                hashMap.put(f39820g, this.n);
                hashMap.put(f39821h, this.o);
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
            this.f39813a = context;
            this.f39814b = new C1654a(this, null);
            b.a a2 = b.a(i2);
            c a3 = b.a(context).a(context.getApplicationContext(), a2.f39835a);
            this.f39814b.f39824j = a2.f39835a;
            try {
                if (a3.q && a3.r) {
                    if (a3.p) {
                        if (a2.f39836b.compareTo(a3.n) > 0) {
                            this.f39814b.f39823i = a2.f39836b;
                            a(a2.f39838d, a2);
                        } else {
                            a(a2, a3, a2.f39838d);
                        }
                    } else {
                        a(a2, a3, a2.f39838d);
                    }
                    this.f39814b.k = true;
                    return true;
                }
                this.f39814b.f39823i = a2.f39836b;
                this.f39814b.k = true;
                a(a2.f39838d, a2);
                return true;
            } catch (Throwable th) {
                try {
                    this.f39814b.n = Log.getStackTraceString(th);
                    this.f39814b.o = this.f39814b.f39823i;
                    this.f39814b.k = false;
                    return false;
                } finally {
                    this.f39814b.b();
                }
            }
        }
        return invokeLIL.booleanValue;
    }

    private void a(String[] strArr, b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, strArr, aVar) == null) {
            for (String str : strArr) {
                String str2 = b.b(this.f39813a, aVar) + "/lib" + str + ".so";
                if (g.b(str2)) {
                    g.c(str2);
                }
                System.loadLibrary(str);
            }
            this.f39814b.l = true;
        }
    }

    private void a(b.a aVar, c cVar, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, this, aVar, cVar, strArr) == null) {
            boolean z = false;
            try {
                for (String str : strArr) {
                    System.load(b.b(this.f39813a, aVar) + "/lib" + str + ".so");
                }
                this.f39814b.f39823i = cVar.n;
                z = true;
            } catch (Throwable th) {
                this.f39814b.m = false;
                this.f39814b.f39823i = aVar.f39836b;
                this.f39814b.n = Log.getStackTraceString(th);
                this.f39814b.o = cVar.n;
            }
            if (z) {
                return;
            }
            a(strArr, aVar);
        }
    }
}
