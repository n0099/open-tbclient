package c.a.r0.r.a.a;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.r.a.a.q;
import c.a.r0.r.a.b.d;
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
/* loaded from: classes6.dex */
public class r extends q {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f11709g;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.r0.r.a.c.g<a> a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.r0.r.a.c.g<a> f11710b;

    /* renamed from: c  reason: collision with root package name */
    public final String f11711c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f11712d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f11713e;

    /* renamed from: f  reason: collision with root package name */
    public l f11714f;

    /* loaded from: classes6.dex */
    public final class a implements d.b<Object>, d.a<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final Bundle f11715b;

        /* renamed from: c  reason: collision with root package name */
        public q.a<Object> f11716c;

        /* renamed from: d  reason: collision with root package name */
        public c.a.r0.r.a.b.d<Object> f11717d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f11718e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f11719f;

        /* renamed from: g  reason: collision with root package name */
        public Object f11720g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f11721h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f11722i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f11723j;
        public boolean k;
        public boolean l;
        public boolean m;
        public a n;
        public final /* synthetic */ r o;

        public void a(c.a.r0.r.a.b.d<Object> dVar, Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, dVar, obj) == null) || this.f11716c == null) {
                return;
            }
            String str = null;
            if (this.o.f11714f != null) {
                str = this.o.f11714f.f11673e.s;
                this.o.f11714f.f11673e.s = "onLoadFinished";
            }
            try {
                if (r.f11709g) {
                    String str2 = "  onLoadFinished in " + dVar + ": " + dVar.a(obj);
                }
                this.f11716c.b(dVar, obj);
                this.f11719f = true;
            } finally {
                if (this.o.f11714f != null) {
                    this.o.f11714f.f11673e.s = str;
                }
            }
        }

        public void b() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (r.f11709g) {
                    String str2 = "  Destroying: " + this;
                }
                this.l = true;
                boolean z = this.f11719f;
                this.f11719f = false;
                if (this.f11716c != null && this.f11717d != null && this.f11718e && z) {
                    if (r.f11709g) {
                        String str3 = "  Reseting: " + this;
                    }
                    if (this.o.f11714f != null) {
                        str = this.o.f11714f.f11673e.s;
                        this.o.f11714f.f11673e.s = "onLoaderReset";
                    } else {
                        str = null;
                    }
                    try {
                        this.f11716c.a(this.f11717d);
                    } finally {
                        if (this.o.f11714f != null) {
                            this.o.f11714f.f11673e.s = str;
                        }
                    }
                }
                this.f11716c = null;
                this.f11720g = null;
                this.f11718e = false;
                c.a.r0.r.a.b.d<Object> dVar = this.f11717d;
                if (dVar != null) {
                    if (this.m) {
                        this.m = false;
                        dVar.k(this);
                        this.f11717d.l(this);
                    }
                    this.f11717d.h();
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
                printWriter.println(this.f11715b);
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f11716c);
                printWriter.print(str);
                printWriter.print("mLoader=");
                printWriter.println(this.f11717d);
                c.a.r0.r.a.b.d<Object> dVar = this.f11717d;
                if (dVar != null) {
                    dVar.b(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
                }
                if (this.f11718e || this.f11719f) {
                    printWriter.print(str);
                    printWriter.print("mHaveData=");
                    printWriter.print(this.f11718e);
                    printWriter.print("  mDeliveredData=");
                    printWriter.println(this.f11719f);
                    printWriter.print(str);
                    printWriter.print("mData=");
                    printWriter.println(this.f11720g);
                }
                printWriter.print(str);
                printWriter.print("mStarted=");
                printWriter.print(this.f11721h);
                printWriter.print(" mReportNextStart=");
                printWriter.print(this.k);
                printWriter.print(" mDestroyed=");
                printWriter.println(this.l);
                printWriter.print(str);
                printWriter.print("mRetaining=");
                printWriter.print(this.f11722i);
                printWriter.print(" mRetainingStarted=");
                printWriter.print(this.f11723j);
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
                if (this.f11722i) {
                    if (r.f11709g) {
                        String str = "  Finished Retaining: " + this;
                    }
                    this.f11722i = false;
                    boolean z = this.f11721h;
                    if (z != this.f11723j && !z) {
                        h();
                    }
                }
                if (this.f11721h && this.f11718e && !this.k) {
                    a(this.f11717d, this.f11720g);
                }
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f11721h && this.k) {
                this.k = false;
                if (this.f11718e) {
                    a(this.f11717d, this.f11720g);
                }
            }
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (r.f11709g) {
                    String str = "  Retaining: " + this;
                }
                this.f11722i = true;
                this.f11723j = this.f11721h;
                this.f11721h = false;
                this.f11716c = null;
            }
        }

        public void g() {
            q.a<Object> aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                if (this.f11722i && this.f11723j) {
                    this.f11721h = true;
                } else if (this.f11721h) {
                } else {
                    this.f11721h = true;
                    if (r.f11709g) {
                        String str = "  Starting: " + this;
                    }
                    if (this.f11717d == null && (aVar = this.f11716c) != null) {
                        this.f11717d = aVar.onCreateLoader(this.a, this.f11715b);
                    }
                    c.a.r0.r.a.b.d<Object> dVar = this.f11717d;
                    if (dVar != null) {
                        if (dVar.getClass().isMemberClass() && !Modifier.isStatic(this.f11717d.getClass().getModifiers())) {
                            throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f11717d);
                        }
                        if (!this.m) {
                            this.f11717d.f(this.a, this);
                            this.f11717d.g(this);
                            this.m = true;
                        }
                        this.f11717d.i();
                    }
                }
            }
        }

        public void h() {
            c.a.r0.r.a.b.d<Object> dVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                if (r.f11709g) {
                    String str = "  Stopping: " + this;
                }
                this.f11721h = false;
                if (this.f11722i || (dVar = this.f11717d) == null || !this.m) {
                    return;
                }
                this.m = false;
                dVar.k(this);
                this.f11717d.l(this);
                this.f11717d.j();
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
                c.a.r0.r.a.c.c.a(this.f11717d, sb);
                sb.append("}}");
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-316402323, "Lc/a/r0/r/a/a/r;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-316402323, "Lc/a/r0/r/a/a/r;");
        }
    }

    public r(String str, l lVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, lVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new c.a.r0.r.a.c.g<>();
        this.f11710b = new c.a.r0.r.a.c.g<>();
        this.f11711c = str;
        this.f11714f = lVar;
        this.f11712d = z;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!this.f11713e) {
                if (f11709g) {
                    String str = "Destroying Active in " + this;
                }
                for (int f2 = this.a.f() - 1; f2 >= 0; f2--) {
                    this.a.g(f2).b();
                }
                this.a.a();
            }
            if (f11709g) {
                String str2 = "Destroying Inactive in " + this;
            }
            for (int f3 = this.f11710b.f() - 1; f3 >= 0; f3--) {
                this.f11710b.g(f3).b();
            }
            this.f11710b.a();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int f2 = this.a.f() - 1; f2 >= 0; f2--) {
                this.a.g(f2).k = true;
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (int f2 = this.a.f() - 1; f2 >= 0; f2--) {
                this.a.g(f2).e();
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (f11709g) {
                String str = "Retaining in " + this;
            }
            if (!this.f11712d) {
                new RuntimeException("here").fillInStackTrace();
                String str2 = "Called doRetain when not started: " + this;
                return;
            }
            this.f11713e = true;
            this.f11712d = false;
            for (int f2 = this.a.f() - 1; f2 >= 0; f2--) {
                this.a.g(f2).f();
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (f11709g) {
                String str = "Starting in " + this;
            }
            if (this.f11712d) {
                new RuntimeException("here").fillInStackTrace();
                String str2 = "Called doStart when already started: " + this;
                return;
            }
            this.f11712d = true;
            for (int f2 = this.a.f() - 1; f2 >= 0; f2--) {
                this.a.g(f2).g();
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (f11709g) {
                String str = "Stopping in " + this;
            }
            if (!this.f11712d) {
                new RuntimeException("here").fillInStackTrace();
                String str2 = "Called doStop when not started: " + this;
                return;
            }
            for (int f2 = this.a.f() - 1; f2 >= 0; f2--) {
                this.a.g(f2).h();
            }
            this.f11712d = false;
        }
    }

    public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, str, fileDescriptor, printWriter, strArr) == null) {
            if (this.a.f() > 0) {
                printWriter.print(str);
                printWriter.println("Active Loaders:");
                String str2 = str + "    ";
                for (int i2 = 0; i2 < this.a.f(); i2++) {
                    a g2 = this.a.g(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.a.e(i2));
                    printWriter.print(": ");
                    printWriter.println(g2.toString());
                    g2.c(str2, fileDescriptor, printWriter, strArr);
                }
            }
            if (this.f11710b.f() > 0) {
                printWriter.print(str);
                printWriter.println("Inactive Loaders:");
                String str3 = str + "    ";
                for (int i3 = 0; i3 < this.f11710b.f(); i3++) {
                    a g3 = this.f11710b.g(i3);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f11710b.e(i3));
                    printWriter.print(": ");
                    printWriter.println(g3.toString());
                    g3.c(str3, fileDescriptor, printWriter, strArr);
                }
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f11713e) {
            if (f11709g) {
                String str = "Finished Retaining in " + this;
            }
            this.f11713e = false;
            for (int f2 = this.a.f() - 1; f2 >= 0; f2--) {
                this.a.g(f2).d();
            }
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int f2 = this.a.f();
            boolean z = false;
            for (int i2 = 0; i2 < f2; i2++) {
                a g2 = this.a.g(i2);
                z |= g2.f11721h && !g2.f11719f;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void k(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, lVar) == null) {
            this.f11714f = lVar;
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
            c.a.r0.r.a.c.c.a(this.f11714f, sb);
            sb.append("}}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
