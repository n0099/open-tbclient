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
    public Context f39755a;

    /* renamed from: b  reason: collision with root package name */
    public C1650a f39756b;

    /* renamed from: com.baidu.fsg.face.base.b.a$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.baidu.fsg.face.base.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1650a {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: b  reason: collision with root package name */
        public static final String f39757b = "load_so_zip_version";

        /* renamed from: c  reason: collision with root package name */
        public static final String f39758c = "load_so_modle_name";

        /* renamed from: d  reason: collision with root package name */
        public static final String f39759d = "load_default_so";

        /* renamed from: e  reason: collision with root package name */
        public static final String f39760e = "load_so_success";

        /* renamed from: f  reason: collision with root package name */
        public static final String f39761f = "load_download_so_suc";

        /* renamed from: g  reason: collision with root package name */
        public static final String f39762g = "load_so_exception_info";

        /* renamed from: h  reason: collision with root package name */
        public static final String f39763h = "load_so_execption_zip_version";
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f39764a;

        /* renamed from: i  reason: collision with root package name */
        public String f39765i;

        /* renamed from: j  reason: collision with root package name */
        public String f39766j;
        public boolean k;
        public boolean l;
        public boolean m;
        public String n;
        public String o;

        public C1650a(a aVar) {
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
            this.f39764a = aVar;
            this.l = false;
            this.m = true;
        }

        public /* synthetic */ C1650a(a aVar, AnonymousClass1 anonymousClass1) {
            this(aVar);
        }

        private Map<String, String> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put(f39757b, this.f39765i);
                hashMap.put(f39758c, this.f39766j);
                hashMap.put(f39759d, this.l ? "1" : "-1");
                hashMap.put(f39760e, this.k ? "1" : "-1");
                hashMap.put(f39761f, this.m ? "1" : "-1");
                hashMap.put(f39762g, this.n);
                hashMap.put(f39763h, this.o);
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
            this.f39755a = context;
            this.f39756b = new C1650a(this, null);
            b.a a2 = b.a(i2);
            c a3 = b.a(context).a(context.getApplicationContext(), a2.f39777a);
            this.f39756b.f39766j = a2.f39777a;
            try {
                if (a3.q && a3.r) {
                    if (a3.p) {
                        if (a2.f39778b.compareTo(a3.n) > 0) {
                            this.f39756b.f39765i = a2.f39778b;
                            a(a2.f39780d, a2);
                        } else {
                            a(a2, a3, a2.f39780d);
                        }
                    } else {
                        a(a2, a3, a2.f39780d);
                    }
                    this.f39756b.k = true;
                    return true;
                }
                this.f39756b.f39765i = a2.f39778b;
                this.f39756b.k = true;
                a(a2.f39780d, a2);
                return true;
            } catch (Throwable th) {
                try {
                    this.f39756b.n = Log.getStackTraceString(th);
                    this.f39756b.o = this.f39756b.f39765i;
                    this.f39756b.k = false;
                    return false;
                } finally {
                    this.f39756b.b();
                }
            }
        }
        return invokeLIL.booleanValue;
    }

    private void a(String[] strArr, b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, strArr, aVar) == null) {
            for (String str : strArr) {
                String str2 = b.b(this.f39755a, aVar) + "/lib" + str + ".so";
                if (g.a(str2)) {
                    g.b(str2);
                }
                System.loadLibrary(str);
            }
            this.f39756b.l = true;
        }
    }

    private void a(b.a aVar, c cVar, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, this, aVar, cVar, strArr) == null) {
            boolean z = false;
            try {
                for (String str : strArr) {
                    System.load(b.b(this.f39755a, aVar) + "/lib" + str + ".so");
                }
                this.f39756b.f39765i = cVar.n;
                z = true;
            } catch (Throwable th) {
                this.f39756b.m = false;
                this.f39756b.f39765i = aVar.f39778b;
                this.f39756b.n = Log.getStackTraceString(th);
                this.f39756b.o = cVar.n;
            }
            if (z) {
                return;
            }
            a(strArr, aVar);
        }
    }
}
