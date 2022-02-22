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
    public C1818a f34208b;

    /* renamed from: com.baidu.fsg.face.base.b.a$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.baidu.fsg.face.base.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C1818a {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: b  reason: collision with root package name */
        public static final String f34209b = "load_so_zip_version";

        /* renamed from: c  reason: collision with root package name */
        public static final String f34210c = "load_so_modle_name";

        /* renamed from: d  reason: collision with root package name */
        public static final String f34211d = "load_default_so";

        /* renamed from: e  reason: collision with root package name */
        public static final String f34212e = "load_so_success";

        /* renamed from: f  reason: collision with root package name */
        public static final String f34213f = "load_download_so_suc";

        /* renamed from: g  reason: collision with root package name */
        public static final String f34214g = "load_so_exception_info";

        /* renamed from: h  reason: collision with root package name */
        public static final String f34215h = "load_so_execption_zip_version";
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: i  reason: collision with root package name */
        public String f34216i;

        /* renamed from: j  reason: collision with root package name */
        public String f34217j;
        public boolean k;
        public boolean l;
        public boolean m;
        public String n;
        public String o;

        public C1818a(a aVar) {
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

        public /* synthetic */ C1818a(a aVar, AnonymousClass1 anonymousClass1) {
            this(aVar);
        }

        private Map<String, String> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put(f34209b, this.f34216i);
                hashMap.put(f34210c, this.f34217j);
                hashMap.put(f34211d, this.l ? "1" : "-1");
                hashMap.put(f34212e, this.k ? "1" : "-1");
                hashMap.put(f34213f, this.m ? "1" : "-1");
                hashMap.put(f34214g, this.n);
                hashMap.put(f34215h, this.o);
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
            this.f34208b = new C1818a(this, null);
            b.a a = b.a(i2);
            c a2 = b.a(context).a(context.getApplicationContext(), a.a);
            this.f34208b.f34217j = a.a;
            try {
                if (a2.q && a2.r) {
                    if (a2.p) {
                        if (a.f34227b.compareTo(a2.n) > 0) {
                            this.f34208b.f34216i = a.f34227b;
                            a(a.f34229d, a);
                        } else {
                            a(a, a2, a.f34229d);
                        }
                    } else {
                        a(a, a2, a.f34229d);
                    }
                    this.f34208b.k = true;
                    return true;
                }
                this.f34208b.f34216i = a.f34227b;
                this.f34208b.k = true;
                a(a.f34229d, a);
                return true;
            } catch (Throwable th) {
                try {
                    this.f34208b.n = Log.getStackTraceString(th);
                    this.f34208b.o = this.f34208b.f34216i;
                    this.f34208b.k = false;
                    return false;
                } finally {
                    this.f34208b.b();
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
            this.f34208b.l = true;
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
                this.f34208b.f34216i = cVar.n;
                z = true;
            } catch (Throwable th) {
                this.f34208b.m = false;
                this.f34208b.f34216i = aVar.f34227b;
                this.f34208b.n = Log.getStackTraceString(th);
                this.f34208b.o = cVar.n;
            }
            if (z) {
                return;
            }
            a(strArr, aVar);
        }
    }
}
