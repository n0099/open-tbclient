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
    public Context f5583a;

    /* renamed from: b  reason: collision with root package name */
    public C0098a f5584b;

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
        public static final String f5585b = "load_so_zip_version";

        /* renamed from: c  reason: collision with root package name */
        public static final String f5586c = "load_so_modle_name";

        /* renamed from: d  reason: collision with root package name */
        public static final String f5587d = "load_default_so";

        /* renamed from: e  reason: collision with root package name */
        public static final String f5588e = "load_so_success";

        /* renamed from: f  reason: collision with root package name */
        public static final String f5589f = "load_download_so_suc";

        /* renamed from: g  reason: collision with root package name */
        public static final String f5590g = "load_so_exception_info";

        /* renamed from: h  reason: collision with root package name */
        public static final String f5591h = "load_so_execption_zip_version";
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f5592a;

        /* renamed from: i  reason: collision with root package name */
        public String f5593i;
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
            this.f5592a = aVar;
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
                hashMap.put(f5585b, this.f5593i);
                hashMap.put(f5586c, this.j);
                hashMap.put(f5587d, this.l ? "1" : "-1");
                hashMap.put(f5588e, this.k ? "1" : "-1");
                hashMap.put(f5589f, this.m ? "1" : "-1");
                hashMap.put(f5590g, this.n);
                hashMap.put(f5591h, this.o);
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
            this.f5583a = context;
            this.f5584b = new C0098a(this, null);
            b.a a2 = b.a(i2);
            c a3 = b.a(context).a(context.getApplicationContext(), a2.f5603a);
            this.f5584b.j = a2.f5603a;
            try {
                if (a3.q && a3.r) {
                    if (a3.p) {
                        if (a2.f5604b.compareTo(a3.n) > 0) {
                            this.f5584b.f5593i = a2.f5604b;
                            a(a2.f5606d, a2);
                        } else {
                            a(a2, a3, a2.f5606d);
                        }
                    } else {
                        a(a2, a3, a2.f5606d);
                    }
                    this.f5584b.k = true;
                    return true;
                }
                this.f5584b.f5593i = a2.f5604b;
                this.f5584b.k = true;
                a(a2.f5606d, a2);
                return true;
            } catch (Throwable th) {
                try {
                    this.f5584b.n = Log.getStackTraceString(th);
                    this.f5584b.o = this.f5584b.f5593i;
                    this.f5584b.k = false;
                    return false;
                } finally {
                    this.f5584b.b();
                }
            }
        }
        return invokeLIL.booleanValue;
    }

    private void a(String[] strArr, b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, strArr, aVar) == null) {
            for (String str : strArr) {
                String str2 = b.b(this.f5583a, aVar) + "/lib" + str + ".so";
                if (g.a(str2)) {
                    g.b(str2);
                }
                System.loadLibrary(str);
            }
            this.f5584b.l = true;
        }
    }

    private void a(b.a aVar, c cVar, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, this, aVar, cVar, strArr) == null) {
            boolean z = false;
            try {
                for (String str : strArr) {
                    System.load(b.b(this.f5583a, aVar) + "/lib" + str + ".so");
                }
                this.f5584b.f5593i = cVar.n;
                z = true;
            } catch (Throwable th) {
                this.f5584b.m = false;
                this.f5584b.f5593i = aVar.f5604b;
                this.f5584b.n = Log.getStackTraceString(th);
                this.f5584b.o = cVar.n;
            }
            if (z) {
                return;
            }
            a(strArr, aVar);
        }
    }
}
