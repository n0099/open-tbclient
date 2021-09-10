package c.a.p0.o.a.a;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.o.a.a.p;
import c.a.p0.o.a.b.d;
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
/* loaded from: classes3.dex */
public class q extends p {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f12146g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c.a.p0.o.a.c.g<a> f12147a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.p0.o.a.c.g<a> f12148b;

    /* renamed from: c  reason: collision with root package name */
    public final String f12149c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f12150d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f12151e;

    /* renamed from: f  reason: collision with root package name */
    public k f12152f;

    /* loaded from: classes3.dex */
    public final class a implements d.b<Object>, d.a<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f12153a;

        /* renamed from: b  reason: collision with root package name */
        public final Bundle f12154b;

        /* renamed from: c  reason: collision with root package name */
        public p.a<Object> f12155c;

        /* renamed from: d  reason: collision with root package name */
        public c.a.p0.o.a.b.d<Object> f12156d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f12157e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f12158f;

        /* renamed from: g  reason: collision with root package name */
        public Object f12159g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f12160h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f12161i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f12162j;
        public boolean k;
        public boolean l;
        public boolean m;
        public a n;
        public final /* synthetic */ q o;

        public void a(c.a.p0.o.a.b.d<Object> dVar, Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, dVar, obj) == null) || this.f12155c == null) {
                return;
            }
            String str = null;
            if (this.o.f12152f != null) {
                str = this.o.f12152f.f12104d.s;
                this.o.f12152f.f12104d.s = "onLoadFinished";
            }
            try {
                if (q.f12146g) {
                    String str2 = "  onLoadFinished in " + dVar + ": " + dVar.a(obj);
                }
                this.f12155c.b(dVar, obj);
                this.f12158f = true;
            } finally {
                if (this.o.f12152f != null) {
                    this.o.f12152f.f12104d.s = str;
                }
            }
        }

        public void b() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (q.f12146g) {
                    String str2 = "  Destroying: " + this;
                }
                this.l = true;
                boolean z = this.f12158f;
                this.f12158f = false;
                if (this.f12155c != null && this.f12156d != null && this.f12157e && z) {
                    if (q.f12146g) {
                        String str3 = "  Reseting: " + this;
                    }
                    if (this.o.f12152f != null) {
                        str = this.o.f12152f.f12104d.s;
                        this.o.f12152f.f12104d.s = "onLoaderReset";
                    } else {
                        str = null;
                    }
                    try {
                        this.f12155c.a(this.f12156d);
                    } finally {
                        if (this.o.f12152f != null) {
                            this.o.f12152f.f12104d.s = str;
                        }
                    }
                }
                this.f12155c = null;
                this.f12159g = null;
                this.f12157e = false;
                c.a.p0.o.a.b.d<Object> dVar = this.f12156d;
                if (dVar != null) {
                    if (this.m) {
                        this.m = false;
                        dVar.h(this);
                        this.f12156d.i(this);
                    }
                    this.f12156d.e();
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
                printWriter.print(this.f12153a);
                printWriter.print(" mArgs=");
                printWriter.println(this.f12154b);
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f12155c);
                printWriter.print(str);
                printWriter.print("mLoader=");
                printWriter.println(this.f12156d);
                c.a.p0.o.a.b.d<Object> dVar = this.f12156d;
                if (dVar != null) {
                    dVar.b(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
                }
                if (this.f12157e || this.f12158f) {
                    printWriter.print(str);
                    printWriter.print("mHaveData=");
                    printWriter.print(this.f12157e);
                    printWriter.print("  mDeliveredData=");
                    printWriter.println(this.f12158f);
                    printWriter.print(str);
                    printWriter.print("mData=");
                    printWriter.println(this.f12159g);
                }
                printWriter.print(str);
                printWriter.print("mStarted=");
                printWriter.print(this.f12160h);
                printWriter.print(" mReportNextStart=");
                printWriter.print(this.k);
                printWriter.print(" mDestroyed=");
                printWriter.println(this.l);
                printWriter.print(str);
                printWriter.print("mRetaining=");
                printWriter.print(this.f12161i);
                printWriter.print(" mRetainingStarted=");
                printWriter.print(this.f12162j);
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
                if (this.f12161i) {
                    if (q.f12146g) {
                        String str = "  Finished Retaining: " + this;
                    }
                    this.f12161i = false;
                    boolean z = this.f12160h;
                    if (z != this.f12162j && !z) {
                        h();
                    }
                }
                if (this.f12160h && this.f12157e && !this.k) {
                    a(this.f12156d, this.f12159g);
                }
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f12160h && this.k) {
                this.k = false;
                if (this.f12157e) {
                    a(this.f12156d, this.f12159g);
                }
            }
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (q.f12146g) {
                    String str = "  Retaining: " + this;
                }
                this.f12161i = true;
                this.f12162j = this.f12160h;
                this.f12160h = false;
                this.f12155c = null;
            }
        }

        public void g() {
            p.a<Object> aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                if (this.f12161i && this.f12162j) {
                    this.f12160h = true;
                } else if (this.f12160h) {
                } else {
                    this.f12160h = true;
                    if (q.f12146g) {
                        String str = "  Starting: " + this;
                    }
                    if (this.f12156d == null && (aVar = this.f12155c) != null) {
                        this.f12156d = aVar.onCreateLoader(this.f12153a, this.f12154b);
                    }
                    c.a.p0.o.a.b.d<Object> dVar = this.f12156d;
                    if (dVar != null) {
                        if (dVar.getClass().isMemberClass() && !Modifier.isStatic(this.f12156d.getClass().getModifiers())) {
                            throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f12156d);
                        }
                        if (!this.m) {
                            this.f12156d.c(this.f12153a, this);
                            this.f12156d.d(this);
                            this.m = true;
                        }
                        this.f12156d.f();
                        throw null;
                    }
                }
            }
        }

        public void h() {
            c.a.p0.o.a.b.d<Object> dVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                if (q.f12146g) {
                    String str = "  Stopping: " + this;
                }
                this.f12160h = false;
                if (this.f12161i || (dVar = this.f12156d) == null || !this.m) {
                    return;
                }
                this.m = false;
                dVar.h(this);
                this.f12156d.i(this);
                this.f12156d.g();
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
                sb.append(this.f12153a);
                sb.append(ZeusCrashHandler.NAME_SEPERATOR);
                c.a.p0.o.a.c.c.a(this.f12156d, sb);
                sb.append("}}");
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1950930641, "Lc/a/p0/o/a/a/q;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1950930641, "Lc/a/p0/o/a/a/q;");
        }
    }

    public q(String str, k kVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, kVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f12147a = new c.a.p0.o.a.c.g<>();
        this.f12148b = new c.a.p0.o.a.c.g<>();
        this.f12149c = str;
        this.f12152f = kVar;
        this.f12150d = z;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!this.f12151e) {
                if (f12146g) {
                    String str = "Destroying Active in " + this;
                }
                for (int h2 = this.f12147a.h() - 1; h2 >= 0; h2--) {
                    this.f12147a.i(h2).b();
                }
                this.f12147a.d();
            }
            if (f12146g) {
                String str2 = "Destroying Inactive in " + this;
            }
            for (int h3 = this.f12148b.h() - 1; h3 >= 0; h3--) {
                this.f12148b.i(h3).b();
            }
            this.f12148b.d();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int h2 = this.f12147a.h() - 1; h2 >= 0; h2--) {
                this.f12147a.i(h2).k = true;
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (int h2 = this.f12147a.h() - 1; h2 >= 0; h2--) {
                this.f12147a.i(h2).e();
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (f12146g) {
                String str = "Retaining in " + this;
            }
            if (!this.f12150d) {
                new RuntimeException("here").fillInStackTrace();
                String str2 = "Called doRetain when not started: " + this;
                return;
            }
            this.f12151e = true;
            this.f12150d = false;
            for (int h2 = this.f12147a.h() - 1; h2 >= 0; h2--) {
                this.f12147a.i(h2).f();
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (f12146g) {
                String str = "Starting in " + this;
            }
            if (this.f12150d) {
                new RuntimeException("here").fillInStackTrace();
                String str2 = "Called doStart when already started: " + this;
                return;
            }
            this.f12150d = true;
            for (int h2 = this.f12147a.h() - 1; h2 >= 0; h2--) {
                this.f12147a.i(h2).g();
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (f12146g) {
                String str = "Stopping in " + this;
            }
            if (!this.f12150d) {
                new RuntimeException("here").fillInStackTrace();
                String str2 = "Called doStop when not started: " + this;
                return;
            }
            for (int h2 = this.f12147a.h() - 1; h2 >= 0; h2--) {
                this.f12147a.i(h2).h();
            }
            this.f12150d = false;
        }
    }

    public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, str, fileDescriptor, printWriter, strArr) == null) {
            if (this.f12147a.h() > 0) {
                printWriter.print(str);
                printWriter.println("Active Loaders:");
                String str2 = str + "    ";
                for (int i2 = 0; i2 < this.f12147a.h(); i2++) {
                    a i3 = this.f12147a.i(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f12147a.g(i2));
                    printWriter.print(": ");
                    printWriter.println(i3.toString());
                    i3.c(str2, fileDescriptor, printWriter, strArr);
                }
            }
            if (this.f12148b.h() > 0) {
                printWriter.print(str);
                printWriter.println("Inactive Loaders:");
                String str3 = str + "    ";
                for (int i4 = 0; i4 < this.f12148b.h(); i4++) {
                    a i5 = this.f12148b.i(i4);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f12148b.g(i4));
                    printWriter.print(": ");
                    printWriter.println(i5.toString());
                    i5.c(str3, fileDescriptor, printWriter, strArr);
                }
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f12151e) {
            if (f12146g) {
                String str = "Finished Retaining in " + this;
            }
            this.f12151e = false;
            for (int h2 = this.f12147a.h() - 1; h2 >= 0; h2--) {
                this.f12147a.i(h2).d();
            }
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int h2 = this.f12147a.h();
            boolean z = false;
            for (int i2 = 0; i2 < h2; i2++) {
                a i3 = this.f12147a.i(i2);
                z |= i3.f12160h && !i3.f12158f;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void k(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, kVar) == null) {
            this.f12152f = kVar;
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
            c.a.p0.o.a.c.c.a(this.f12152f, sb);
            sb.append("}}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
