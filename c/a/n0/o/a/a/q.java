package c.a.n0.o.a.a;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.o.a.a.p;
import c.a.n0.o.a.b.d;
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
    public static boolean f11872g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c.a.n0.o.a.c.g<a> f11873a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.n0.o.a.c.g<a> f11874b;

    /* renamed from: c  reason: collision with root package name */
    public final String f11875c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f11876d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f11877e;

    /* renamed from: f  reason: collision with root package name */
    public k f11878f;

    /* loaded from: classes3.dex */
    public final class a implements d.b<Object>, d.a<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f11879a;

        /* renamed from: b  reason: collision with root package name */
        public final Bundle f11880b;

        /* renamed from: c  reason: collision with root package name */
        public p.a<Object> f11881c;

        /* renamed from: d  reason: collision with root package name */
        public c.a.n0.o.a.b.d<Object> f11882d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f11883e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f11884f;

        /* renamed from: g  reason: collision with root package name */
        public Object f11885g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f11886h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f11887i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f11888j;
        public boolean k;
        public boolean l;
        public boolean m;
        public a n;
        public final /* synthetic */ q o;

        public void a(c.a.n0.o.a.b.d<Object> dVar, Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, dVar, obj) == null) || this.f11881c == null) {
                return;
            }
            String str = null;
            if (this.o.f11878f != null) {
                str = this.o.f11878f.f11830d.s;
                this.o.f11878f.f11830d.s = "onLoadFinished";
            }
            try {
                if (q.f11872g) {
                    String str2 = "  onLoadFinished in " + dVar + ": " + dVar.a(obj);
                }
                this.f11881c.b(dVar, obj);
                this.f11884f = true;
            } finally {
                if (this.o.f11878f != null) {
                    this.o.f11878f.f11830d.s = str;
                }
            }
        }

        public void b() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (q.f11872g) {
                    String str2 = "  Destroying: " + this;
                }
                this.l = true;
                boolean z = this.f11884f;
                this.f11884f = false;
                if (this.f11881c != null && this.f11882d != null && this.f11883e && z) {
                    if (q.f11872g) {
                        String str3 = "  Reseting: " + this;
                    }
                    if (this.o.f11878f != null) {
                        str = this.o.f11878f.f11830d.s;
                        this.o.f11878f.f11830d.s = "onLoaderReset";
                    } else {
                        str = null;
                    }
                    try {
                        this.f11881c.a(this.f11882d);
                    } finally {
                        if (this.o.f11878f != null) {
                            this.o.f11878f.f11830d.s = str;
                        }
                    }
                }
                this.f11881c = null;
                this.f11885g = null;
                this.f11883e = false;
                c.a.n0.o.a.b.d<Object> dVar = this.f11882d;
                if (dVar != null) {
                    if (this.m) {
                        this.m = false;
                        dVar.h(this);
                        this.f11882d.i(this);
                    }
                    this.f11882d.e();
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
                printWriter.print(this.f11879a);
                printWriter.print(" mArgs=");
                printWriter.println(this.f11880b);
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f11881c);
                printWriter.print(str);
                printWriter.print("mLoader=");
                printWriter.println(this.f11882d);
                c.a.n0.o.a.b.d<Object> dVar = this.f11882d;
                if (dVar != null) {
                    dVar.b(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
                }
                if (this.f11883e || this.f11884f) {
                    printWriter.print(str);
                    printWriter.print("mHaveData=");
                    printWriter.print(this.f11883e);
                    printWriter.print("  mDeliveredData=");
                    printWriter.println(this.f11884f);
                    printWriter.print(str);
                    printWriter.print("mData=");
                    printWriter.println(this.f11885g);
                }
                printWriter.print(str);
                printWriter.print("mStarted=");
                printWriter.print(this.f11886h);
                printWriter.print(" mReportNextStart=");
                printWriter.print(this.k);
                printWriter.print(" mDestroyed=");
                printWriter.println(this.l);
                printWriter.print(str);
                printWriter.print("mRetaining=");
                printWriter.print(this.f11887i);
                printWriter.print(" mRetainingStarted=");
                printWriter.print(this.f11888j);
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
                if (this.f11887i) {
                    if (q.f11872g) {
                        String str = "  Finished Retaining: " + this;
                    }
                    this.f11887i = false;
                    boolean z = this.f11886h;
                    if (z != this.f11888j && !z) {
                        h();
                    }
                }
                if (this.f11886h && this.f11883e && !this.k) {
                    a(this.f11882d, this.f11885g);
                }
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f11886h && this.k) {
                this.k = false;
                if (this.f11883e) {
                    a(this.f11882d, this.f11885g);
                }
            }
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (q.f11872g) {
                    String str = "  Retaining: " + this;
                }
                this.f11887i = true;
                this.f11888j = this.f11886h;
                this.f11886h = false;
                this.f11881c = null;
            }
        }

        public void g() {
            p.a<Object> aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                if (this.f11887i && this.f11888j) {
                    this.f11886h = true;
                } else if (this.f11886h) {
                } else {
                    this.f11886h = true;
                    if (q.f11872g) {
                        String str = "  Starting: " + this;
                    }
                    if (this.f11882d == null && (aVar = this.f11881c) != null) {
                        this.f11882d = aVar.onCreateLoader(this.f11879a, this.f11880b);
                    }
                    c.a.n0.o.a.b.d<Object> dVar = this.f11882d;
                    if (dVar != null) {
                        if (dVar.getClass().isMemberClass() && !Modifier.isStatic(this.f11882d.getClass().getModifiers())) {
                            throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f11882d);
                        }
                        if (!this.m) {
                            this.f11882d.c(this.f11879a, this);
                            this.f11882d.d(this);
                            this.m = true;
                        }
                        this.f11882d.f();
                        throw null;
                    }
                }
            }
        }

        public void h() {
            c.a.n0.o.a.b.d<Object> dVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                if (q.f11872g) {
                    String str = "  Stopping: " + this;
                }
                this.f11886h = false;
                if (this.f11887i || (dVar = this.f11882d) == null || !this.m) {
                    return;
                }
                this.m = false;
                dVar.h(this);
                this.f11882d.i(this);
                this.f11882d.g();
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
                sb.append(this.f11879a);
                sb.append(ZeusCrashHandler.NAME_SEPERATOR);
                c.a.n0.o.a.c.c.a(this.f11882d, sb);
                sb.append("}}");
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1642972077, "Lc/a/n0/o/a/a/q;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1642972077, "Lc/a/n0/o/a/a/q;");
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
        this.f11873a = new c.a.n0.o.a.c.g<>();
        this.f11874b = new c.a.n0.o.a.c.g<>();
        this.f11875c = str;
        this.f11878f = kVar;
        this.f11876d = z;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!this.f11877e) {
                if (f11872g) {
                    String str = "Destroying Active in " + this;
                }
                for (int h2 = this.f11873a.h() - 1; h2 >= 0; h2--) {
                    this.f11873a.i(h2).b();
                }
                this.f11873a.d();
            }
            if (f11872g) {
                String str2 = "Destroying Inactive in " + this;
            }
            for (int h3 = this.f11874b.h() - 1; h3 >= 0; h3--) {
                this.f11874b.i(h3).b();
            }
            this.f11874b.d();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int h2 = this.f11873a.h() - 1; h2 >= 0; h2--) {
                this.f11873a.i(h2).k = true;
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (int h2 = this.f11873a.h() - 1; h2 >= 0; h2--) {
                this.f11873a.i(h2).e();
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (f11872g) {
                String str = "Retaining in " + this;
            }
            if (!this.f11876d) {
                new RuntimeException("here").fillInStackTrace();
                String str2 = "Called doRetain when not started: " + this;
                return;
            }
            this.f11877e = true;
            this.f11876d = false;
            for (int h2 = this.f11873a.h() - 1; h2 >= 0; h2--) {
                this.f11873a.i(h2).f();
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (f11872g) {
                String str = "Starting in " + this;
            }
            if (this.f11876d) {
                new RuntimeException("here").fillInStackTrace();
                String str2 = "Called doStart when already started: " + this;
                return;
            }
            this.f11876d = true;
            for (int h2 = this.f11873a.h() - 1; h2 >= 0; h2--) {
                this.f11873a.i(h2).g();
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (f11872g) {
                String str = "Stopping in " + this;
            }
            if (!this.f11876d) {
                new RuntimeException("here").fillInStackTrace();
                String str2 = "Called doStop when not started: " + this;
                return;
            }
            for (int h2 = this.f11873a.h() - 1; h2 >= 0; h2--) {
                this.f11873a.i(h2).h();
            }
            this.f11876d = false;
        }
    }

    public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, str, fileDescriptor, printWriter, strArr) == null) {
            if (this.f11873a.h() > 0) {
                printWriter.print(str);
                printWriter.println("Active Loaders:");
                String str2 = str + "    ";
                for (int i2 = 0; i2 < this.f11873a.h(); i2++) {
                    a i3 = this.f11873a.i(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f11873a.g(i2));
                    printWriter.print(": ");
                    printWriter.println(i3.toString());
                    i3.c(str2, fileDescriptor, printWriter, strArr);
                }
            }
            if (this.f11874b.h() > 0) {
                printWriter.print(str);
                printWriter.println("Inactive Loaders:");
                String str3 = str + "    ";
                for (int i4 = 0; i4 < this.f11874b.h(); i4++) {
                    a i5 = this.f11874b.i(i4);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f11874b.g(i4));
                    printWriter.print(": ");
                    printWriter.println(i5.toString());
                    i5.c(str3, fileDescriptor, printWriter, strArr);
                }
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f11877e) {
            if (f11872g) {
                String str = "Finished Retaining in " + this;
            }
            this.f11877e = false;
            for (int h2 = this.f11873a.h() - 1; h2 >= 0; h2--) {
                this.f11873a.i(h2).d();
            }
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int h2 = this.f11873a.h();
            boolean z = false;
            for (int i2 = 0; i2 < h2; i2++) {
                a i3 = this.f11873a.i(i2);
                z |= i3.f11886h && !i3.f11884f;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void k(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, kVar) == null) {
            this.f11878f = kVar;
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
            c.a.n0.o.a.c.c.a(this.f11878f, sb);
            sb.append("}}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
