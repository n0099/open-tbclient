package c.a.o0.o.a.a;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.o.a.a.p;
import c.a.o0.o.a.b.d;
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
    public static boolean f12118g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c.a.o0.o.a.c.g<a> f12119a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.o0.o.a.c.g<a> f12120b;

    /* renamed from: c  reason: collision with root package name */
    public final String f12121c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f12122d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f12123e;

    /* renamed from: f  reason: collision with root package name */
    public k f12124f;

    /* loaded from: classes3.dex */
    public final class a implements d.b<Object>, d.a<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f12125a;

        /* renamed from: b  reason: collision with root package name */
        public final Bundle f12126b;

        /* renamed from: c  reason: collision with root package name */
        public p.a<Object> f12127c;

        /* renamed from: d  reason: collision with root package name */
        public c.a.o0.o.a.b.d<Object> f12128d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f12129e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f12130f;

        /* renamed from: g  reason: collision with root package name */
        public Object f12131g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f12132h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f12133i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f12134j;
        public boolean k;
        public boolean l;
        public boolean m;
        public a n;
        public final /* synthetic */ q o;

        public void a(c.a.o0.o.a.b.d<Object> dVar, Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, dVar, obj) == null) || this.f12127c == null) {
                return;
            }
            String str = null;
            if (this.o.f12124f != null) {
                str = this.o.f12124f.f12076d.s;
                this.o.f12124f.f12076d.s = "onLoadFinished";
            }
            try {
                if (q.f12118g) {
                    String str2 = "  onLoadFinished in " + dVar + ": " + dVar.a(obj);
                }
                this.f12127c.b(dVar, obj);
                this.f12130f = true;
            } finally {
                if (this.o.f12124f != null) {
                    this.o.f12124f.f12076d.s = str;
                }
            }
        }

        public void b() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (q.f12118g) {
                    String str2 = "  Destroying: " + this;
                }
                this.l = true;
                boolean z = this.f12130f;
                this.f12130f = false;
                if (this.f12127c != null && this.f12128d != null && this.f12129e && z) {
                    if (q.f12118g) {
                        String str3 = "  Reseting: " + this;
                    }
                    if (this.o.f12124f != null) {
                        str = this.o.f12124f.f12076d.s;
                        this.o.f12124f.f12076d.s = "onLoaderReset";
                    } else {
                        str = null;
                    }
                    try {
                        this.f12127c.a(this.f12128d);
                    } finally {
                        if (this.o.f12124f != null) {
                            this.o.f12124f.f12076d.s = str;
                        }
                    }
                }
                this.f12127c = null;
                this.f12131g = null;
                this.f12129e = false;
                c.a.o0.o.a.b.d<Object> dVar = this.f12128d;
                if (dVar != null) {
                    if (this.m) {
                        this.m = false;
                        dVar.h(this);
                        this.f12128d.i(this);
                    }
                    this.f12128d.e();
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
                printWriter.print(this.f12125a);
                printWriter.print(" mArgs=");
                printWriter.println(this.f12126b);
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f12127c);
                printWriter.print(str);
                printWriter.print("mLoader=");
                printWriter.println(this.f12128d);
                c.a.o0.o.a.b.d<Object> dVar = this.f12128d;
                if (dVar != null) {
                    dVar.b(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
                }
                if (this.f12129e || this.f12130f) {
                    printWriter.print(str);
                    printWriter.print("mHaveData=");
                    printWriter.print(this.f12129e);
                    printWriter.print("  mDeliveredData=");
                    printWriter.println(this.f12130f);
                    printWriter.print(str);
                    printWriter.print("mData=");
                    printWriter.println(this.f12131g);
                }
                printWriter.print(str);
                printWriter.print("mStarted=");
                printWriter.print(this.f12132h);
                printWriter.print(" mReportNextStart=");
                printWriter.print(this.k);
                printWriter.print(" mDestroyed=");
                printWriter.println(this.l);
                printWriter.print(str);
                printWriter.print("mRetaining=");
                printWriter.print(this.f12133i);
                printWriter.print(" mRetainingStarted=");
                printWriter.print(this.f12134j);
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
                if (this.f12133i) {
                    if (q.f12118g) {
                        String str = "  Finished Retaining: " + this;
                    }
                    this.f12133i = false;
                    boolean z = this.f12132h;
                    if (z != this.f12134j && !z) {
                        h();
                    }
                }
                if (this.f12132h && this.f12129e && !this.k) {
                    a(this.f12128d, this.f12131g);
                }
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f12132h && this.k) {
                this.k = false;
                if (this.f12129e) {
                    a(this.f12128d, this.f12131g);
                }
            }
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (q.f12118g) {
                    String str = "  Retaining: " + this;
                }
                this.f12133i = true;
                this.f12134j = this.f12132h;
                this.f12132h = false;
                this.f12127c = null;
            }
        }

        public void g() {
            p.a<Object> aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                if (this.f12133i && this.f12134j) {
                    this.f12132h = true;
                } else if (this.f12132h) {
                } else {
                    this.f12132h = true;
                    if (q.f12118g) {
                        String str = "  Starting: " + this;
                    }
                    if (this.f12128d == null && (aVar = this.f12127c) != null) {
                        this.f12128d = aVar.onCreateLoader(this.f12125a, this.f12126b);
                    }
                    c.a.o0.o.a.b.d<Object> dVar = this.f12128d;
                    if (dVar != null) {
                        if (dVar.getClass().isMemberClass() && !Modifier.isStatic(this.f12128d.getClass().getModifiers())) {
                            throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f12128d);
                        }
                        if (!this.m) {
                            this.f12128d.c(this.f12125a, this);
                            this.f12128d.d(this);
                            this.m = true;
                        }
                        this.f12128d.f();
                        throw null;
                    }
                }
            }
        }

        public void h() {
            c.a.o0.o.a.b.d<Object> dVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                if (q.f12118g) {
                    String str = "  Stopping: " + this;
                }
                this.f12132h = false;
                if (this.f12133i || (dVar = this.f12128d) == null || !this.m) {
                    return;
                }
                this.m = false;
                dVar.h(this);
                this.f12128d.i(this);
                this.f12128d.g();
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
                sb.append(this.f12125a);
                sb.append(ZeusCrashHandler.NAME_SEPERATOR);
                c.a.o0.o.a.c.c.a(this.f12128d, sb);
                sb.append("}}");
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-153979282, "Lc/a/o0/o/a/a/q;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-153979282, "Lc/a/o0/o/a/a/q;");
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
        this.f12119a = new c.a.o0.o.a.c.g<>();
        this.f12120b = new c.a.o0.o.a.c.g<>();
        this.f12121c = str;
        this.f12124f = kVar;
        this.f12122d = z;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!this.f12123e) {
                if (f12118g) {
                    String str = "Destroying Active in " + this;
                }
                for (int h2 = this.f12119a.h() - 1; h2 >= 0; h2--) {
                    this.f12119a.i(h2).b();
                }
                this.f12119a.d();
            }
            if (f12118g) {
                String str2 = "Destroying Inactive in " + this;
            }
            for (int h3 = this.f12120b.h() - 1; h3 >= 0; h3--) {
                this.f12120b.i(h3).b();
            }
            this.f12120b.d();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int h2 = this.f12119a.h() - 1; h2 >= 0; h2--) {
                this.f12119a.i(h2).k = true;
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (int h2 = this.f12119a.h() - 1; h2 >= 0; h2--) {
                this.f12119a.i(h2).e();
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (f12118g) {
                String str = "Retaining in " + this;
            }
            if (!this.f12122d) {
                new RuntimeException("here").fillInStackTrace();
                String str2 = "Called doRetain when not started: " + this;
                return;
            }
            this.f12123e = true;
            this.f12122d = false;
            for (int h2 = this.f12119a.h() - 1; h2 >= 0; h2--) {
                this.f12119a.i(h2).f();
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (f12118g) {
                String str = "Starting in " + this;
            }
            if (this.f12122d) {
                new RuntimeException("here").fillInStackTrace();
                String str2 = "Called doStart when already started: " + this;
                return;
            }
            this.f12122d = true;
            for (int h2 = this.f12119a.h() - 1; h2 >= 0; h2--) {
                this.f12119a.i(h2).g();
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (f12118g) {
                String str = "Stopping in " + this;
            }
            if (!this.f12122d) {
                new RuntimeException("here").fillInStackTrace();
                String str2 = "Called doStop when not started: " + this;
                return;
            }
            for (int h2 = this.f12119a.h() - 1; h2 >= 0; h2--) {
                this.f12119a.i(h2).h();
            }
            this.f12122d = false;
        }
    }

    public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, str, fileDescriptor, printWriter, strArr) == null) {
            if (this.f12119a.h() > 0) {
                printWriter.print(str);
                printWriter.println("Active Loaders:");
                String str2 = str + "    ";
                for (int i2 = 0; i2 < this.f12119a.h(); i2++) {
                    a i3 = this.f12119a.i(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f12119a.g(i2));
                    printWriter.print(": ");
                    printWriter.println(i3.toString());
                    i3.c(str2, fileDescriptor, printWriter, strArr);
                }
            }
            if (this.f12120b.h() > 0) {
                printWriter.print(str);
                printWriter.println("Inactive Loaders:");
                String str3 = str + "    ";
                for (int i4 = 0; i4 < this.f12120b.h(); i4++) {
                    a i5 = this.f12120b.i(i4);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f12120b.g(i4));
                    printWriter.print(": ");
                    printWriter.println(i5.toString());
                    i5.c(str3, fileDescriptor, printWriter, strArr);
                }
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f12123e) {
            if (f12118g) {
                String str = "Finished Retaining in " + this;
            }
            this.f12123e = false;
            for (int h2 = this.f12119a.h() - 1; h2 >= 0; h2--) {
                this.f12119a.i(h2).d();
            }
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int h2 = this.f12119a.h();
            boolean z = false;
            for (int i2 = 0; i2 < h2; i2++) {
                a i3 = this.f12119a.i(i2);
                z |= i3.f12132h && !i3.f12130f;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void k(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, kVar) == null) {
            this.f12124f = kVar;
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
            c.a.o0.o.a.c.c.a(this.f12124f, sb);
            sb.append("}}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
