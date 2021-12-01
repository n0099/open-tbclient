package c.a.p0.r.a.a;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.r.a.a.q;
import c.a.p0.r.a.b.d;
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
/* loaded from: classes5.dex */
public class r extends q {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f10941g;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.p0.r.a.c.g<a> a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.p0.r.a.c.g<a> f10942b;

    /* renamed from: c  reason: collision with root package name */
    public final String f10943c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f10944d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f10945e;

    /* renamed from: f  reason: collision with root package name */
    public l f10946f;

    /* loaded from: classes5.dex */
    public final class a implements d.b<Object>, d.a<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final Bundle f10947b;

        /* renamed from: c  reason: collision with root package name */
        public q.a<Object> f10948c;

        /* renamed from: d  reason: collision with root package name */
        public c.a.p0.r.a.b.d<Object> f10949d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f10950e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f10951f;

        /* renamed from: g  reason: collision with root package name */
        public Object f10952g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f10953h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f10954i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f10955j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f10956k;
        public boolean l;
        public boolean m;
        public a n;
        public final /* synthetic */ r o;

        public void a(c.a.p0.r.a.b.d<Object> dVar, Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, dVar, obj) == null) || this.f10948c == null) {
                return;
            }
            String str = null;
            if (this.o.f10946f != null) {
                str = this.o.f10946f.f10902e.s;
                this.o.f10946f.f10902e.s = "onLoadFinished";
            }
            try {
                if (r.f10941g) {
                    String str2 = "  onLoadFinished in " + dVar + ": " + dVar.a(obj);
                }
                this.f10948c.b(dVar, obj);
                this.f10951f = true;
            } finally {
                if (this.o.f10946f != null) {
                    this.o.f10946f.f10902e.s = str;
                }
            }
        }

        public void b() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (r.f10941g) {
                    String str2 = "  Destroying: " + this;
                }
                this.l = true;
                boolean z = this.f10951f;
                this.f10951f = false;
                if (this.f10948c != null && this.f10949d != null && this.f10950e && z) {
                    if (r.f10941g) {
                        String str3 = "  Reseting: " + this;
                    }
                    if (this.o.f10946f != null) {
                        str = this.o.f10946f.f10902e.s;
                        this.o.f10946f.f10902e.s = "onLoaderReset";
                    } else {
                        str = null;
                    }
                    try {
                        this.f10948c.a(this.f10949d);
                    } finally {
                        if (this.o.f10946f != null) {
                            this.o.f10946f.f10902e.s = str;
                        }
                    }
                }
                this.f10948c = null;
                this.f10952g = null;
                this.f10950e = false;
                c.a.p0.r.a.b.d<Object> dVar = this.f10949d;
                if (dVar != null) {
                    if (this.m) {
                        this.m = false;
                        dVar.k(this);
                        this.f10949d.l(this);
                    }
                    this.f10949d.h();
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
                printWriter.println(this.f10947b);
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f10948c);
                printWriter.print(str);
                printWriter.print("mLoader=");
                printWriter.println(this.f10949d);
                c.a.p0.r.a.b.d<Object> dVar = this.f10949d;
                if (dVar != null) {
                    dVar.b(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
                }
                if (this.f10950e || this.f10951f) {
                    printWriter.print(str);
                    printWriter.print("mHaveData=");
                    printWriter.print(this.f10950e);
                    printWriter.print("  mDeliveredData=");
                    printWriter.println(this.f10951f);
                    printWriter.print(str);
                    printWriter.print("mData=");
                    printWriter.println(this.f10952g);
                }
                printWriter.print(str);
                printWriter.print("mStarted=");
                printWriter.print(this.f10953h);
                printWriter.print(" mReportNextStart=");
                printWriter.print(this.f10956k);
                printWriter.print(" mDestroyed=");
                printWriter.println(this.l);
                printWriter.print(str);
                printWriter.print("mRetaining=");
                printWriter.print(this.f10954i);
                printWriter.print(" mRetainingStarted=");
                printWriter.print(this.f10955j);
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
                if (this.f10954i) {
                    if (r.f10941g) {
                        String str = "  Finished Retaining: " + this;
                    }
                    this.f10954i = false;
                    boolean z = this.f10953h;
                    if (z != this.f10955j && !z) {
                        h();
                    }
                }
                if (this.f10953h && this.f10950e && !this.f10956k) {
                    a(this.f10949d, this.f10952g);
                }
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f10953h && this.f10956k) {
                this.f10956k = false;
                if (this.f10950e) {
                    a(this.f10949d, this.f10952g);
                }
            }
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (r.f10941g) {
                    String str = "  Retaining: " + this;
                }
                this.f10954i = true;
                this.f10955j = this.f10953h;
                this.f10953h = false;
                this.f10948c = null;
            }
        }

        public void g() {
            q.a<Object> aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                if (this.f10954i && this.f10955j) {
                    this.f10953h = true;
                } else if (this.f10953h) {
                } else {
                    this.f10953h = true;
                    if (r.f10941g) {
                        String str = "  Starting: " + this;
                    }
                    if (this.f10949d == null && (aVar = this.f10948c) != null) {
                        this.f10949d = aVar.onCreateLoader(this.a, this.f10947b);
                    }
                    c.a.p0.r.a.b.d<Object> dVar = this.f10949d;
                    if (dVar != null) {
                        if (dVar.getClass().isMemberClass() && !Modifier.isStatic(this.f10949d.getClass().getModifiers())) {
                            throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f10949d);
                        }
                        if (!this.m) {
                            this.f10949d.f(this.a, this);
                            this.f10949d.g(this);
                            this.m = true;
                        }
                        this.f10949d.i();
                    }
                }
            }
        }

        public void h() {
            c.a.p0.r.a.b.d<Object> dVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                if (r.f10941g) {
                    String str = "  Stopping: " + this;
                }
                this.f10953h = false;
                if (this.f10954i || (dVar = this.f10949d) == null || !this.m) {
                    return;
                }
                this.m = false;
                dVar.k(this);
                this.f10949d.l(this);
                this.f10949d.j();
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
                c.a.p0.r.a.c.c.a(this.f10949d, sb);
                sb.append("}}");
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1017466901, "Lc/a/p0/r/a/a/r;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1017466901, "Lc/a/p0/r/a/a/r;");
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
        this.a = new c.a.p0.r.a.c.g<>();
        this.f10942b = new c.a.p0.r.a.c.g<>();
        this.f10943c = str;
        this.f10946f = lVar;
        this.f10944d = z;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!this.f10945e) {
                if (f10941g) {
                    String str = "Destroying Active in " + this;
                }
                for (int f2 = this.a.f() - 1; f2 >= 0; f2--) {
                    this.a.g(f2).b();
                }
                this.a.a();
            }
            if (f10941g) {
                String str2 = "Destroying Inactive in " + this;
            }
            for (int f3 = this.f10942b.f() - 1; f3 >= 0; f3--) {
                this.f10942b.g(f3).b();
            }
            this.f10942b.a();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int f2 = this.a.f() - 1; f2 >= 0; f2--) {
                this.a.g(f2).f10956k = true;
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
            if (f10941g) {
                String str = "Retaining in " + this;
            }
            if (!this.f10944d) {
                new RuntimeException("here").fillInStackTrace();
                String str2 = "Called doRetain when not started: " + this;
                return;
            }
            this.f10945e = true;
            this.f10944d = false;
            for (int f2 = this.a.f() - 1; f2 >= 0; f2--) {
                this.a.g(f2).f();
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (f10941g) {
                String str = "Starting in " + this;
            }
            if (this.f10944d) {
                new RuntimeException("here").fillInStackTrace();
                String str2 = "Called doStart when already started: " + this;
                return;
            }
            this.f10944d = true;
            for (int f2 = this.a.f() - 1; f2 >= 0; f2--) {
                this.a.g(f2).g();
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (f10941g) {
                String str = "Stopping in " + this;
            }
            if (!this.f10944d) {
                new RuntimeException("here").fillInStackTrace();
                String str2 = "Called doStop when not started: " + this;
                return;
            }
            for (int f2 = this.a.f() - 1; f2 >= 0; f2--) {
                this.a.g(f2).h();
            }
            this.f10944d = false;
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
            if (this.f10942b.f() > 0) {
                printWriter.print(str);
                printWriter.println("Inactive Loaders:");
                String str3 = str + "    ";
                for (int i3 = 0; i3 < this.f10942b.f(); i3++) {
                    a g3 = this.f10942b.g(i3);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f10942b.e(i3));
                    printWriter.print(": ");
                    printWriter.println(g3.toString());
                    g3.c(str3, fileDescriptor, printWriter, strArr);
                }
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f10945e) {
            if (f10941g) {
                String str = "Finished Retaining in " + this;
            }
            this.f10945e = false;
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
                z |= g2.f10953h && !g2.f10951f;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void k(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, lVar) == null) {
            this.f10946f = lVar;
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
            c.a.p0.r.a.c.c.a(this.f10946f, sb);
            sb.append("}}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
