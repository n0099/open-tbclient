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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f5557a;

    /* renamed from: b  reason: collision with root package name */
    public C0098a f5558b;

    /* renamed from: com.baidu.fsg.face.base.b.a$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.baidu.fsg.face.base.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0098a {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: b  reason: collision with root package name */
        public static final String f5559b = "load_so_zip_version";

        /* renamed from: c  reason: collision with root package name */
        public static final String f5560c = "load_so_modle_name";

        /* renamed from: d  reason: collision with root package name */
        public static final String f5561d = "load_default_so";

        /* renamed from: e  reason: collision with root package name */
        public static final String f5562e = "load_so_success";

        /* renamed from: f  reason: collision with root package name */
        public static final String f5563f = "load_download_so_suc";

        /* renamed from: g  reason: collision with root package name */
        public static final String f5564g = "load_so_exception_info";

        /* renamed from: h  reason: collision with root package name */
        public static final String f5565h = "load_so_execption_zip_version";
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f5566a;

        /* renamed from: i  reason: collision with root package name */
        public String f5567i;
        public String j;
        public boolean k;
        public boolean l;
        public boolean m;
        public String n;
        public String o;

        public C0098a(a aVar) {
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
            this.f5566a = aVar;
            this.l = false;
            this.m = true;
        }

        public /* synthetic */ C0098a(a aVar, AnonymousClass1 anonymousClass1) {
            this(aVar);
        }

        private Map<String, String> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put(f5559b, this.f5567i);
                hashMap.put(f5560c, this.j);
                hashMap.put(f5561d, this.l ? "1" : "-1");
                hashMap.put(f5562e, this.k ? "1" : "-1");
                hashMap.put(f5563f, this.m ? "1" : "-1");
                hashMap.put(f5564g, this.n);
                hashMap.put(f5565h, this.o);
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
            this.f5557a = context;
            this.f5558b = new C0098a(this, null);
            b.a a2 = b.a(i2);
            c a3 = b.a(context).a(context.getApplicationContext(), a2.f5577a);
            this.f5558b.j = a2.f5577a;
            try {
                if (a3.q && a3.r) {
                    if (a3.p) {
                        if (a2.f5578b.compareTo(a3.n) > 0) {
                            this.f5558b.f5567i = a2.f5578b;
                            a(a2.f5580d, a2);
                        } else {
                            a(a2, a3, a2.f5580d);
                        }
                    } else {
                        a(a2, a3, a2.f5580d);
                    }
                    this.f5558b.k = true;
                    return true;
                }
                this.f5558b.f5567i = a2.f5578b;
                this.f5558b.k = true;
                a(a2.f5580d, a2);
                return true;
            } catch (Throwable th) {
                try {
                    this.f5558b.n = Log.getStackTraceString(th);
                    this.f5558b.o = this.f5558b.f5567i;
                    this.f5558b.k = false;
                    return false;
                } finally {
                    this.f5558b.b();
                }
            }
        }
        return invokeLIL.booleanValue;
    }

    private void a(String[] strArr, b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, strArr, aVar) == null) {
            for (String str : strArr) {
                String str2 = b.b(this.f5557a, aVar) + "/lib" + str + ".so";
                if (g.a(str2)) {
                    g.b(str2);
                }
                System.loadLibrary(str);
            }
            this.f5558b.l = true;
        }
    }

    private void a(b.a aVar, c cVar, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, this, aVar, cVar, strArr) == null) {
            boolean z = false;
            try {
                for (String str : strArr) {
                    System.load(b.b(this.f5557a, aVar) + "/lib" + str + ".so");
                }
                this.f5558b.f5567i = cVar.n;
                z = true;
            } catch (Throwable th) {
                this.f5558b.m = false;
                this.f5558b.f5567i = aVar.f5578b;
                this.f5558b.n = Log.getStackTraceString(th);
                this.f5558b.o = cVar.n;
            }
            if (z) {
                return;
            }
            a(strArr, aVar);
        }
    }
}
