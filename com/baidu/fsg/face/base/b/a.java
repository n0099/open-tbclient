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
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f38574a;

    /* renamed from: b  reason: collision with root package name */
    public C1648a f38575b;

    /* renamed from: com.baidu.fsg.face.base.b.a$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.baidu.fsg.face.base.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1648a {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: b  reason: collision with root package name */
        public static final String f38576b = "load_so_zip_version";

        /* renamed from: c  reason: collision with root package name */
        public static final String f38577c = "load_so_modle_name";

        /* renamed from: d  reason: collision with root package name */
        public static final String f38578d = "load_default_so";

        /* renamed from: e  reason: collision with root package name */
        public static final String f38579e = "load_so_success";

        /* renamed from: f  reason: collision with root package name */
        public static final String f38580f = "load_download_so_suc";

        /* renamed from: g  reason: collision with root package name */
        public static final String f38581g = "load_so_exception_info";

        /* renamed from: h  reason: collision with root package name */
        public static final String f38582h = "load_so_execption_zip_version";
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f38583a;

        /* renamed from: i  reason: collision with root package name */
        public String f38584i;
        public String j;
        public boolean k;
        public boolean l;
        public boolean m;
        public String n;
        public String o;

        public C1648a(a aVar) {
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
            this.f38583a = aVar;
            this.l = false;
            this.m = true;
        }

        public /* synthetic */ C1648a(a aVar, AnonymousClass1 anonymousClass1) {
            this(aVar);
        }

        private Map<String, String> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put(f38576b, this.f38584i);
                hashMap.put(f38577c, this.j);
                hashMap.put(f38578d, this.l ? "1" : "-1");
                hashMap.put(f38579e, this.k ? "1" : "-1");
                hashMap.put(f38580f, this.m ? "1" : "-1");
                hashMap.put(f38581g, this.n);
                hashMap.put(f38582h, this.o);
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
            this.f38574a = context;
            this.f38575b = new C1648a(this, null);
            b.a a2 = b.a(i2);
            c a3 = b.a(context).a(context.getApplicationContext(), a2.f38594a);
            this.f38575b.j = a2.f38594a;
            try {
                if (a3.q && a3.r) {
                    if (a3.p) {
                        if (a2.f38595b.compareTo(a3.n) > 0) {
                            this.f38575b.f38584i = a2.f38595b;
                            a(a2.f38597d, a2);
                        } else {
                            a(a2, a3, a2.f38597d);
                        }
                    } else {
                        a(a2, a3, a2.f38597d);
                    }
                    this.f38575b.k = true;
                    return true;
                }
                this.f38575b.f38584i = a2.f38595b;
                this.f38575b.k = true;
                a(a2.f38597d, a2);
                return true;
            } catch (Throwable th) {
                try {
                    this.f38575b.n = Log.getStackTraceString(th);
                    this.f38575b.o = this.f38575b.f38584i;
                    this.f38575b.k = false;
                    return false;
                } finally {
                    this.f38575b.b();
                }
            }
        }
        return invokeLIL.booleanValue;
    }

    private void a(String[] strArr, b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, strArr, aVar) == null) {
            for (String str : strArr) {
                String str2 = b.b(this.f38574a, aVar) + "/lib" + str + ".so";
                if (g.b(str2)) {
                    g.c(str2);
                }
                System.loadLibrary(str);
            }
            this.f38575b.l = true;
        }
    }

    private void a(b.a aVar, c cVar, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, this, aVar, cVar, strArr) == null) {
            boolean z = false;
            try {
                for (String str : strArr) {
                    System.load(b.b(this.f38574a, aVar) + "/lib" + str + ".so");
                }
                this.f38575b.f38584i = cVar.n;
                z = true;
            } catch (Throwable th) {
                this.f38575b.m = false;
                this.f38575b.f38584i = aVar.f38595b;
                this.f38575b.n = Log.getStackTraceString(th);
                this.f38575b.o = cVar.n;
            }
            if (z) {
                return;
            }
            a(strArr, aVar);
        }
    }
}
