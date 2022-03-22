package c.a.n0.r.a.a;

import android.os.Bundle;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.r.a.a.q;
import c.a.n0.r.a.b.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.bumptech.glide.load.engine.GlideException;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
/* loaded from: classes2.dex */
public class r extends q {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f9342g;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.n0.r.a.c.g<a> a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.n0.r.a.c.g<a> f9343b;

    /* renamed from: c  reason: collision with root package name */
    public final String f9344c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f9345d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f9346e;

    /* renamed from: f  reason: collision with root package name */
    public l f9347f;

    /* loaded from: classes2.dex */
    public final class a implements d.b<Object>, d.a<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final Bundle f9348b;

        /* renamed from: c  reason: collision with root package name */
        public q.a<Object> f9349c;

        /* renamed from: d  reason: collision with root package name */
        public c.a.n0.r.a.b.d<Object> f9350d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f9351e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f9352f;

        /* renamed from: g  reason: collision with root package name */
        public Object f9353g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f9354h;
        public boolean i;
        public boolean j;
        public boolean k;
        public boolean l;
        public boolean m;
        public a n;
        public final /* synthetic */ r o;

        public void a(c.a.n0.r.a.b.d<Object> dVar, Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, dVar, obj) == null) || this.f9349c == null) {
                return;
            }
            String str = null;
            if (this.o.f9347f != null) {
                str = this.o.f9347f.f9312e.s;
                this.o.f9347f.f9312e.s = "onLoadFinished";
            }
            try {
                if (r.f9342g) {
                    Log.v("LoaderManager", "  onLoadFinished in " + dVar + ": " + dVar.a(obj));
                }
                this.f9349c.b(dVar, obj);
                this.f9352f = true;
            } finally {
                if (this.o.f9347f != null) {
                    this.o.f9347f.f9312e.s = str;
                }
            }
        }

        public void b() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (r.f9342g) {
                    Log.v("LoaderManager", "  Destroying: " + this);
                }
                this.l = true;
                boolean z = this.f9352f;
                this.f9352f = false;
                if (this.f9349c != null && this.f9350d != null && this.f9351e && z) {
                    if (r.f9342g) {
                        Log.v("LoaderManager", "  Reseting: " + this);
                    }
                    if (this.o.f9347f != null) {
                        str = this.o.f9347f.f9312e.s;
                        this.o.f9347f.f9312e.s = "onLoaderReset";
                    } else {
                        str = null;
                    }
                    try {
                        this.f9349c.a(this.f9350d);
                    } finally {
                        if (this.o.f9347f != null) {
                            this.o.f9347f.f9312e.s = str;
                        }
                    }
                }
                this.f9349c = null;
                this.f9353g = null;
                this.f9351e = false;
                c.a.n0.r.a.b.d<Object> dVar = this.f9350d;
                if (dVar != null) {
                    if (this.m) {
                        this.m = false;
                        dVar.k(this);
                        this.f9350d.l(this);
                    }
                    this.f9350d.h();
                }
                a aVar = this.n;
                if (aVar != null) {
                    aVar.b();
                }
            }
        }

        public void c(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, fileDescriptor, printWriter, strArr) == null) {
                printWriter.print(str);
                printWriter.print("mId=");
                printWriter.print(this.a);
                printWriter.print(" mArgs=");
                printWriter.println(this.f9348b);
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f9349c);
                printWriter.print(str);
                printWriter.print("mLoader=");
                printWriter.println(this.f9350d);
                c.a.n0.r.a.b.d<Object> dVar = this.f9350d;
                if (dVar != null) {
                    dVar.b(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
                }
                if (this.f9351e || this.f9352f) {
                    printWriter.print(str);
                    printWriter.print("mHaveData=");
                    printWriter.print(this.f9351e);
                    printWriter.print("  mDeliveredData=");
                    printWriter.println(this.f9352f);
                    printWriter.print(str);
                    printWriter.print("mData=");
                    printWriter.println(this.f9353g);
                }
                printWriter.print(str);
                printWriter.print("mStarted=");
                printWriter.print(this.f9354h);
                printWriter.print(" mReportNextStart=");
                printWriter.print(this.k);
                printWriter.print(" mDestroyed=");
                printWriter.println(this.l);
                printWriter.print(str);
                printWriter.print("mRetaining=");
                printWriter.print(this.i);
                printWriter.print(" mRetainingStarted=");
                printWriter.print(this.j);
                printWriter.print(" mListenerRegistered=");
                printWriter.println(this.m);
                if (this.n != null) {
                    printWriter.print(str);
                    printWriter.println("Pending Loader ");
                    printWriter.print(this.n);
                    printWriter.println(":");
                    a aVar = this.n;
                    aVar.c(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
                }
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.i) {
                    if (r.f9342g) {
                        Log.v("LoaderManager", "  Finished Retaining: " + this);
                    }
                    this.i = false;
                    boolean z = this.f9354h;
                    if (z != this.j && !z) {
                        h();
                    }
                }
                if (this.f9354h && this.f9351e && !this.k) {
                    a(this.f9350d, this.f9353g);
                }
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f9354h && this.k) {
                this.k = false;
                if (this.f9351e) {
                    a(this.f9350d, this.f9353g);
                }
            }
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (r.f9342g) {
                    Log.v("LoaderManager", "  Retaining: " + this);
                }
                this.i = true;
                this.j = this.f9354h;
                this.f9354h = false;
                this.f9349c = null;
            }
        }

        public void g() {
            q.a<Object> aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                if (this.i && this.j) {
                    this.f9354h = true;
                } else if (this.f9354h) {
                } else {
                    this.f9354h = true;
                    if (r.f9342g) {
                        Log.v("LoaderManager", "  Starting: " + this);
                    }
                    if (this.f9350d == null && (aVar = this.f9349c) != null) {
                        this.f9350d = aVar.onCreateLoader(this.a, this.f9348b);
                    }
                    c.a.n0.r.a.b.d<Object> dVar = this.f9350d;
                    if (dVar != null) {
                        if (dVar.getClass().isMemberClass() && !Modifier.isStatic(this.f9350d.getClass().getModifiers())) {
                            throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f9350d);
                        }
                        if (!this.m) {
                            this.f9350d.f(this.a, this);
                            this.f9350d.g(this);
                            this.m = true;
                        }
                        this.f9350d.i();
                    }
                }
            }
        }

        public void h() {
            c.a.n0.r.a.b.d<Object> dVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                if (r.f9342g) {
                    Log.v("LoaderManager", "  Stopping: " + this);
                }
                this.f9354h = false;
                if (this.i || (dVar = this.f9350d) == null || !this.m) {
                    return;
                }
                this.m = false;
                dVar.k(this);
                this.f9350d.l(this);
                this.f9350d.j();
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                StringBuilder sb = new StringBuilder(64);
                sb.append("LoaderInfo{");
                sb.append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" #");
                sb.append(this.a);
                sb.append(ZeusCrashHandler.NAME_SEPERATOR);
                c.a.n0.r.a.c.c.a(this.f9350d, sb);
                sb.append("}}");
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1718531479, "Lc/a/n0/r/a/a/r;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1718531479, "Lc/a/n0/r/a/a/r;");
        }
    }

    public r(String str, l lVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, lVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new c.a.n0.r.a.c.g<>();
        this.f9343b = new c.a.n0.r.a.c.g<>();
        this.f9344c = str;
        this.f9347f = lVar;
        this.f9345d = z;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!this.f9346e) {
                if (f9342g) {
                    Log.v("LoaderManager", "Destroying Active in " + this);
                }
                for (int e2 = this.a.e() - 1; e2 >= 0; e2--) {
                    this.a.f(e2).b();
                }
                this.a.a();
            }
            if (f9342g) {
                Log.v("LoaderManager", "Destroying Inactive in " + this);
            }
            for (int e3 = this.f9343b.e() - 1; e3 >= 0; e3--) {
                this.f9343b.f(e3).b();
            }
            this.f9343b.a();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int e2 = this.a.e() - 1; e2 >= 0; e2--) {
                this.a.f(e2).k = true;
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (int e2 = this.a.e() - 1; e2 >= 0; e2--) {
                this.a.f(e2).e();
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (f9342g) {
                Log.v("LoaderManager", "Retaining in " + this);
            }
            if (!this.f9345d) {
                RuntimeException runtimeException = new RuntimeException("here");
                runtimeException.fillInStackTrace();
                Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
                return;
            }
            this.f9346e = true;
            this.f9345d = false;
            for (int e2 = this.a.e() - 1; e2 >= 0; e2--) {
                this.a.f(e2).f();
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (f9342g) {
                Log.v("LoaderManager", "Starting in " + this);
            }
            if (this.f9345d) {
                RuntimeException runtimeException = new RuntimeException("here");
                runtimeException.fillInStackTrace();
                Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
                return;
            }
            this.f9345d = true;
            for (int e2 = this.a.e() - 1; e2 >= 0; e2--) {
                this.a.f(e2).g();
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (f9342g) {
                Log.v("LoaderManager", "Stopping in " + this);
            }
            if (!this.f9345d) {
                RuntimeException runtimeException = new RuntimeException("here");
                runtimeException.fillInStackTrace();
                Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
                return;
            }
            for (int e2 = this.a.e() - 1; e2 >= 0; e2--) {
                this.a.f(e2).h();
            }
            this.f9345d = false;
        }
    }

    public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, str, fileDescriptor, printWriter, strArr) == null) {
            if (this.a.e() > 0) {
                printWriter.print(str);
                printWriter.println("Active Loaders:");
                String str2 = str + "    ";
                for (int i = 0; i < this.a.e(); i++) {
                    a f2 = this.a.f(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.a.d(i));
                    printWriter.print(": ");
                    printWriter.println(f2.toString());
                    f2.c(str2, fileDescriptor, printWriter, strArr);
                }
            }
            if (this.f9343b.e() > 0) {
                printWriter.print(str);
                printWriter.println("Inactive Loaders:");
                String str3 = str + "    ";
                for (int i2 = 0; i2 < this.f9343b.e(); i2++) {
                    a f3 = this.f9343b.f(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f9343b.d(i2));
                    printWriter.print(": ");
                    printWriter.println(f3.toString());
                    f3.c(str3, fileDescriptor, printWriter, strArr);
                }
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f9346e) {
            if (f9342g) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.f9346e = false;
            for (int e2 = this.a.e() - 1; e2 >= 0; e2--) {
                this.a.f(e2).d();
            }
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int e2 = this.a.e();
            boolean z = false;
            for (int i = 0; i < e2; i++) {
                a f2 = this.a.f(i);
                z |= f2.f9354h && !f2.f9352f;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void k(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, lVar) == null) {
            this.f9347f = lVar;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("LoaderManager{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" in ");
            c.a.n0.r.a.c.c.a(this.f9347f, sb);
            sb.append("}}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
