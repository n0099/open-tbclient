package b.a.p0.r.a.a;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.r.a.a.q;
import b.a.p0.r.a.b.d;
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
/* loaded from: classes4.dex */
public class r extends q {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f12053g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final b.a.p0.r.a.c.g<a> f12054a;

    /* renamed from: b  reason: collision with root package name */
    public final b.a.p0.r.a.c.g<a> f12055b;

    /* renamed from: c  reason: collision with root package name */
    public final String f12056c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f12057d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f12058e;

    /* renamed from: f  reason: collision with root package name */
    public l f12059f;

    /* loaded from: classes4.dex */
    public final class a implements d.b<Object>, d.a<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f12060a;

        /* renamed from: b  reason: collision with root package name */
        public final Bundle f12061b;

        /* renamed from: c  reason: collision with root package name */
        public q.a<Object> f12062c;

        /* renamed from: d  reason: collision with root package name */
        public b.a.p0.r.a.b.d<Object> f12063d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f12064e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f12065f;

        /* renamed from: g  reason: collision with root package name */
        public Object f12066g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f12067h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f12068i;
        public boolean j;
        public boolean k;
        public boolean l;
        public boolean m;
        public a n;
        public final /* synthetic */ r o;

        public void a(b.a.p0.r.a.b.d<Object> dVar, Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, dVar, obj) == null) || this.f12062c == null) {
                return;
            }
            String str = null;
            if (this.o.f12059f != null) {
                str = this.o.f12059f.f12014e.s;
                this.o.f12059f.f12014e.s = "onLoadFinished";
            }
            try {
                if (r.f12053g) {
                    String str2 = "  onLoadFinished in " + dVar + ": " + dVar.a(obj);
                }
                this.f12062c.b(dVar, obj);
                this.f12065f = true;
            } finally {
                if (this.o.f12059f != null) {
                    this.o.f12059f.f12014e.s = str;
                }
            }
        }

        public void b() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (r.f12053g) {
                    String str2 = "  Destroying: " + this;
                }
                this.l = true;
                boolean z = this.f12065f;
                this.f12065f = false;
                if (this.f12062c != null && this.f12063d != null && this.f12064e && z) {
                    if (r.f12053g) {
                        String str3 = "  Reseting: " + this;
                    }
                    if (this.o.f12059f != null) {
                        str = this.o.f12059f.f12014e.s;
                        this.o.f12059f.f12014e.s = "onLoaderReset";
                    } else {
                        str = null;
                    }
                    try {
                        this.f12062c.a(this.f12063d);
                    } finally {
                        if (this.o.f12059f != null) {
                            this.o.f12059f.f12014e.s = str;
                        }
                    }
                }
                this.f12062c = null;
                this.f12066g = null;
                this.f12064e = false;
                b.a.p0.r.a.b.d<Object> dVar = this.f12063d;
                if (dVar != null) {
                    if (this.m) {
                        this.m = false;
                        dVar.k(this);
                        this.f12063d.l(this);
                    }
                    this.f12063d.h();
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
                printWriter.print(this.f12060a);
                printWriter.print(" mArgs=");
                printWriter.println(this.f12061b);
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f12062c);
                printWriter.print(str);
                printWriter.print("mLoader=");
                printWriter.println(this.f12063d);
                b.a.p0.r.a.b.d<Object> dVar = this.f12063d;
                if (dVar != null) {
                    dVar.b(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
                }
                if (this.f12064e || this.f12065f) {
                    printWriter.print(str);
                    printWriter.print("mHaveData=");
                    printWriter.print(this.f12064e);
                    printWriter.print("  mDeliveredData=");
                    printWriter.println(this.f12065f);
                    printWriter.print(str);
                    printWriter.print("mData=");
                    printWriter.println(this.f12066g);
                }
                printWriter.print(str);
                printWriter.print("mStarted=");
                printWriter.print(this.f12067h);
                printWriter.print(" mReportNextStart=");
                printWriter.print(this.k);
                printWriter.print(" mDestroyed=");
                printWriter.println(this.l);
                printWriter.print(str);
                printWriter.print("mRetaining=");
                printWriter.print(this.f12068i);
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
                if (this.f12068i) {
                    if (r.f12053g) {
                        String str = "  Finished Retaining: " + this;
                    }
                    this.f12068i = false;
                    boolean z = this.f12067h;
                    if (z != this.j && !z) {
                        h();
                    }
                }
                if (this.f12067h && this.f12064e && !this.k) {
                    a(this.f12063d, this.f12066g);
                }
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f12067h && this.k) {
                this.k = false;
                if (this.f12064e) {
                    a(this.f12063d, this.f12066g);
                }
            }
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (r.f12053g) {
                    String str = "  Retaining: " + this;
                }
                this.f12068i = true;
                this.j = this.f12067h;
                this.f12067h = false;
                this.f12062c = null;
            }
        }

        public void g() {
            q.a<Object> aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                if (this.f12068i && this.j) {
                    this.f12067h = true;
                } else if (this.f12067h) {
                } else {
                    this.f12067h = true;
                    if (r.f12053g) {
                        String str = "  Starting: " + this;
                    }
                    if (this.f12063d == null && (aVar = this.f12062c) != null) {
                        this.f12063d = aVar.onCreateLoader(this.f12060a, this.f12061b);
                    }
                    b.a.p0.r.a.b.d<Object> dVar = this.f12063d;
                    if (dVar != null) {
                        if (dVar.getClass().isMemberClass() && !Modifier.isStatic(this.f12063d.getClass().getModifiers())) {
                            throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f12063d);
                        }
                        if (!this.m) {
                            this.f12063d.f(this.f12060a, this);
                            this.f12063d.g(this);
                            this.m = true;
                        }
                        this.f12063d.i();
                    }
                }
            }
        }

        public void h() {
            b.a.p0.r.a.b.d<Object> dVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                if (r.f12053g) {
                    String str = "  Stopping: " + this;
                }
                this.f12067h = false;
                if (this.f12068i || (dVar = this.f12063d) == null || !this.m) {
                    return;
                }
                this.m = false;
                dVar.k(this);
                this.f12063d.l(this);
                this.f12063d.j();
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
                sb.append(this.f12060a);
                sb.append(ZeusCrashHandler.NAME_SEPERATOR);
                b.a.p0.r.a.c.c.a(this.f12063d, sb);
                sb.append("}}");
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1769948586, "Lb/a/p0/r/a/a/r;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1769948586, "Lb/a/p0/r/a/a/r;");
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
        this.f12054a = new b.a.p0.r.a.c.g<>();
        this.f12055b = new b.a.p0.r.a.c.g<>();
        this.f12056c = str;
        this.f12059f = lVar;
        this.f12057d = z;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!this.f12058e) {
                if (f12053g) {
                    String str = "Destroying Active in " + this;
                }
                for (int f2 = this.f12054a.f() - 1; f2 >= 0; f2--) {
                    this.f12054a.g(f2).b();
                }
                this.f12054a.a();
            }
            if (f12053g) {
                String str2 = "Destroying Inactive in " + this;
            }
            for (int f3 = this.f12055b.f() - 1; f3 >= 0; f3--) {
                this.f12055b.g(f3).b();
            }
            this.f12055b.a();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int f2 = this.f12054a.f() - 1; f2 >= 0; f2--) {
                this.f12054a.g(f2).k = true;
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (int f2 = this.f12054a.f() - 1; f2 >= 0; f2--) {
                this.f12054a.g(f2).e();
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (f12053g) {
                String str = "Retaining in " + this;
            }
            if (!this.f12057d) {
                new RuntimeException("here").fillInStackTrace();
                String str2 = "Called doRetain when not started: " + this;
                return;
            }
            this.f12058e = true;
            this.f12057d = false;
            for (int f2 = this.f12054a.f() - 1; f2 >= 0; f2--) {
                this.f12054a.g(f2).f();
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (f12053g) {
                String str = "Starting in " + this;
            }
            if (this.f12057d) {
                new RuntimeException("here").fillInStackTrace();
                String str2 = "Called doStart when already started: " + this;
                return;
            }
            this.f12057d = true;
            for (int f2 = this.f12054a.f() - 1; f2 >= 0; f2--) {
                this.f12054a.g(f2).g();
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (f12053g) {
                String str = "Stopping in " + this;
            }
            if (!this.f12057d) {
                new RuntimeException("here").fillInStackTrace();
                String str2 = "Called doStop when not started: " + this;
                return;
            }
            for (int f2 = this.f12054a.f() - 1; f2 >= 0; f2--) {
                this.f12054a.g(f2).h();
            }
            this.f12057d = false;
        }
    }

    public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, str, fileDescriptor, printWriter, strArr) == null) {
            if (this.f12054a.f() > 0) {
                printWriter.print(str);
                printWriter.println("Active Loaders:");
                String str2 = str + "    ";
                for (int i2 = 0; i2 < this.f12054a.f(); i2++) {
                    a g2 = this.f12054a.g(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f12054a.e(i2));
                    printWriter.print(": ");
                    printWriter.println(g2.toString());
                    g2.c(str2, fileDescriptor, printWriter, strArr);
                }
            }
            if (this.f12055b.f() > 0) {
                printWriter.print(str);
                printWriter.println("Inactive Loaders:");
                String str3 = str + "    ";
                for (int i3 = 0; i3 < this.f12055b.f(); i3++) {
                    a g3 = this.f12055b.g(i3);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f12055b.e(i3));
                    printWriter.print(": ");
                    printWriter.println(g3.toString());
                    g3.c(str3, fileDescriptor, printWriter, strArr);
                }
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f12058e) {
            if (f12053g) {
                String str = "Finished Retaining in " + this;
            }
            this.f12058e = false;
            for (int f2 = this.f12054a.f() - 1; f2 >= 0; f2--) {
                this.f12054a.g(f2).d();
            }
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int f2 = this.f12054a.f();
            boolean z = false;
            for (int i2 = 0; i2 < f2; i2++) {
                a g2 = this.f12054a.g(i2);
                z |= g2.f12067h && !g2.f12065f;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void k(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, lVar) == null) {
            this.f12059f = lVar;
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
            b.a.p0.r.a.c.c.a(this.f12059f, sb);
            sb.append("}}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
