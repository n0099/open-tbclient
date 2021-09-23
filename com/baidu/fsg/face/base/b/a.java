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
    public Context f39809a;

    /* renamed from: b  reason: collision with root package name */
    public C1652a f39810b;

    /* renamed from: com.baidu.fsg.face.base.b.a$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.baidu.fsg.face.base.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1652a {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: b  reason: collision with root package name */
        public static final String f39811b = "load_so_zip_version";

        /* renamed from: c  reason: collision with root package name */
        public static final String f39812c = "load_so_modle_name";

        /* renamed from: d  reason: collision with root package name */
        public static final String f39813d = "load_default_so";

        /* renamed from: e  reason: collision with root package name */
        public static final String f39814e = "load_so_success";

        /* renamed from: f  reason: collision with root package name */
        public static final String f39815f = "load_download_so_suc";

        /* renamed from: g  reason: collision with root package name */
        public static final String f39816g = "load_so_exception_info";

        /* renamed from: h  reason: collision with root package name */
        public static final String f39817h = "load_so_execption_zip_version";
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f39818a;

        /* renamed from: i  reason: collision with root package name */
        public String f39819i;

        /* renamed from: j  reason: collision with root package name */
        public String f39820j;
        public boolean k;
        public boolean l;
        public boolean m;
        public String n;
        public String o;

        public C1652a(a aVar) {
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
            this.f39818a = aVar;
            this.l = false;
            this.m = true;
        }

        public /* synthetic */ C1652a(a aVar, AnonymousClass1 anonymousClass1) {
            this(aVar);
        }

        private Map<String, String> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put(f39811b, this.f39819i);
                hashMap.put(f39812c, this.f39820j);
                hashMap.put(f39813d, this.l ? "1" : "-1");
                hashMap.put(f39814e, this.k ? "1" : "-1");
                hashMap.put(f39815f, this.m ? "1" : "-1");
                hashMap.put(f39816g, this.n);
                hashMap.put(f39817h, this.o);
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
            this.f39809a = context;
            this.f39810b = new C1652a(this, null);
            b.a a2 = b.a(i2);
            c a3 = b.a(context).a(context.getApplicationContext(), a2.f39831a);
            this.f39810b.f39820j = a2.f39831a;
            try {
                if (a3.q && a3.r) {
                    if (a3.p) {
                        if (a2.f39832b.compareTo(a3.n) > 0) {
                            this.f39810b.f39819i = a2.f39832b;
                            a(a2.f39834d, a2);
                        } else {
                            a(a2, a3, a2.f39834d);
                        }
                    } else {
                        a(a2, a3, a2.f39834d);
                    }
                    this.f39810b.k = true;
                    return true;
                }
                this.f39810b.f39819i = a2.f39832b;
                this.f39810b.k = true;
                a(a2.f39834d, a2);
                return true;
            } catch (Throwable th) {
                try {
                    this.f39810b.n = Log.getStackTraceString(th);
                    this.f39810b.o = this.f39810b.f39819i;
                    this.f39810b.k = false;
                    return false;
                } finally {
                    this.f39810b.b();
                }
            }
        }
        return invokeLIL.booleanValue;
    }

    private void a(String[] strArr, b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, strArr, aVar) == null) {
            for (String str : strArr) {
                String str2 = b.b(this.f39809a, aVar) + "/lib" + str + ".so";
                if (g.b(str2)) {
                    g.c(str2);
                }
                System.loadLibrary(str);
            }
            this.f39810b.l = true;
        }
    }

    private void a(b.a aVar, c cVar, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, this, aVar, cVar, strArr) == null) {
            boolean z = false;
            try {
                for (String str : strArr) {
                    System.load(b.b(this.f39809a, aVar) + "/lib" + str + ".so");
                }
                this.f39810b.f39819i = cVar.n;
                z = true;
            } catch (Throwable th) {
                this.f39810b.m = false;
                this.f39810b.f39819i = aVar.f39832b;
                this.f39810b.n = Log.getStackTraceString(th);
                this.f39810b.o = cVar.n;
            }
            if (z) {
                return;
            }
            a(strArr, aVar);
        }
    }
}
