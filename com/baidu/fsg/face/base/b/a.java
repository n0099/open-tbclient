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
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public C1725a f34484b;

    /* renamed from: com.baidu.fsg.face.base.b.a$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.baidu.fsg.face.base.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1725a {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: b  reason: collision with root package name */
        public static final String f34485b = "load_so_zip_version";

        /* renamed from: c  reason: collision with root package name */
        public static final String f34486c = "load_so_modle_name";

        /* renamed from: d  reason: collision with root package name */
        public static final String f34487d = "load_default_so";

        /* renamed from: e  reason: collision with root package name */
        public static final String f34488e = "load_so_success";

        /* renamed from: f  reason: collision with root package name */
        public static final String f34489f = "load_download_so_suc";

        /* renamed from: g  reason: collision with root package name */
        public static final String f34490g = "load_so_exception_info";

        /* renamed from: h  reason: collision with root package name */
        public static final String f34491h = "load_so_execption_zip_version";
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: i  reason: collision with root package name */
        public String f34492i;

        /* renamed from: j  reason: collision with root package name */
        public String f34493j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f34494k;
        public boolean l;
        public boolean m;
        public String n;
        public String o;

        public C1725a(a aVar) {
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

        public /* synthetic */ C1725a(a aVar, AnonymousClass1 anonymousClass1) {
            this(aVar);
        }

        private Map<String, String> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put(f34485b, this.f34492i);
                hashMap.put(f34486c, this.f34493j);
                hashMap.put(f34487d, this.l ? "1" : "-1");
                hashMap.put(f34488e, this.f34494k ? "1" : "-1");
                hashMap.put(f34489f, this.m ? "1" : "-1");
                hashMap.put(f34490g, this.n);
                hashMap.put(f34491h, this.o);
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
            this.f34484b = new C1725a(this, null);
            b.a a = b.a(i2);
            c a2 = b.a(context).a(context.getApplicationContext(), a.a);
            this.f34484b.f34493j = a.a;
            try {
                if (a2.q && a2.r) {
                    if (a2.p) {
                        if (a.f34504b.compareTo(a2.n) > 0) {
                            this.f34484b.f34492i = a.f34504b;
                            a(a.f34506d, a);
                        } else {
                            a(a, a2, a.f34506d);
                        }
                    } else {
                        a(a, a2, a.f34506d);
                    }
                    this.f34484b.f34494k = true;
                    return true;
                }
                this.f34484b.f34492i = a.f34504b;
                this.f34484b.f34494k = true;
                a(a.f34506d, a);
                return true;
            } catch (Throwable th) {
                try {
                    this.f34484b.n = Log.getStackTraceString(th);
                    this.f34484b.o = this.f34484b.f34492i;
                    this.f34484b.f34494k = false;
                    return false;
                } finally {
                    this.f34484b.b();
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
            this.f34484b.l = true;
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
                this.f34484b.f34492i = cVar.n;
                z = true;
            } catch (Throwable th) {
                this.f34484b.m = false;
                this.f34484b.f34492i = aVar.f34504b;
                this.f34484b.n = Log.getStackTraceString(th);
                this.f34484b.o = cVar.n;
            }
            if (z) {
                return;
            }
            a(strArr, aVar);
        }
    }
}
