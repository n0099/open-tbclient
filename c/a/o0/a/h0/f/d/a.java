package c.a.o0.a.h0.f.d;

import c.a.o0.a.k;
import c.a.o0.a.p.e.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.sdk.WebKitFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public class a implements h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f5790g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<c.a.o0.a.h0.f.d.b> f5791a;

    /* renamed from: b  reason: collision with root package name */
    public final Lock f5792b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f5793c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f5794d;

    /* renamed from: e  reason: collision with root package name */
    public c f5795e;

    /* renamed from: f  reason: collision with root package name */
    public WebKitFactory.IForceInitZeusListener f5796f;

    /* renamed from: c.a.o0.a.h0.f.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0197a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f5797a;

        public C0197a(a aVar) {
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
            this.f5797a = aVar;
        }

        @Override // c.a.o0.a.h0.f.d.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f5797a.f5792b.lock();
                    this.f5797a.f5794d = true;
                    this.f5797a.j();
                    this.f5797a.p();
                } finally {
                    this.f5797a.f5792b.unlock();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements WebKitFactory.IForceInitZeusListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f5798a;

        public b(a aVar) {
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
            this.f5798a = aVar;
        }

        @Override // com.baidu.webkit.sdk.WebKitFactory.IForceInitZeusListener
        public void onForceInitZeusFinish(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                try {
                    this.f5798a.f5792b.lock();
                    this.f5798a.f5793c = true;
                    this.f5798a.p();
                    this.f5798a.f5792b.unlock();
                    BdSailor.getInstance().removeForceInitListener(this.f5798a.f5796f);
                } catch (Throwable th) {
                    this.f5798a.f5792b.unlock();
                    throw th;
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebKitFactory.IForceInitZeusListener
        public void onForceInitZeusStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                boolean unused = a.f5790g;
            }
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a();
    }

    /* loaded from: classes.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f5799a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1866615745, "Lc/a/o0/a/h0/f/d/a$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1866615745, "Lc/a/o0/a/h0/f/d/a$d;");
                    return;
                }
            }
            f5799a = new a(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1280737791, "Lc/a/o0/a/h0/f/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1280737791, "Lc/a/o0/a/h0/f/d/a;");
                return;
            }
        }
        f5790g = k.f7049a;
    }

    public /* synthetic */ a(C0197a c0197a) {
        this();
    }

    public static a k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? d.f5799a : (a) invokeV.objValue;
    }

    @Override // c.a.o0.a.p.e.h
    public void a(c.a.o0.a.h0.f.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            try {
                this.f5792b.lock();
                if (bVar != null && this.f5791a.contains(bVar)) {
                    this.f5791a.remove(bVar);
                }
            } finally {
                this.f5792b.unlock();
            }
        }
    }

    @Override // c.a.o0.a.p.e.h
    public void b(c.a.o0.a.h0.f.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            try {
                this.f5792b.lock();
                if (bVar == null) {
                    return;
                }
                if (!this.f5791a.contains(bVar)) {
                    this.f5791a.add(bVar);
                }
                if (n()) {
                    p();
                }
            } finally {
                this.f5792b.unlock();
            }
        }
    }

    public final synchronized void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (!ProcessUtils.isMainProcess()) {
                    WebSettingsGlobalBlink.setFileInIOEnabled(true);
                }
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            m(false);
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            c.a.o0.a.c1.a.f().d(z);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0049, code lost:
        if (o() != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean n() {
        boolean z;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                this.f5792b.lock();
                if (f5790g) {
                    String str = "isLoaded() mIsBlinkInited: " + this.f5794d;
                    String str2 = "isLoaded() mIsZeusForceInited: " + this.f5793c + " ,isZeusForceInited: " + o();
                }
                if (this.f5794d) {
                    if (!this.f5793c) {
                    }
                    z = true;
                    return z;
                }
                z = false;
                return z;
            } finally {
                this.f5792b.unlock();
            }
        }
        return invokeV.booleanValue;
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (f5790g) {
                String str = "checkZeusForceInit: " + BdSailor.getInstance().checkZeusForceInit();
                String str2 = "isZeusForceInited: " + BdSailor.getInstance().isZeusForceInited();
            }
            return !BdSailor.getInstance().checkZeusForceInit() || (BdSailor.getInstance().checkZeusForceInit() && BdSailor.getInstance().isZeusForceInited());
        }
        return invokeV.booleanValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            try {
                this.f5792b.lock();
                if (n()) {
                    Iterator<c.a.o0.a.h0.f.d.b> it = this.f5791a.iterator();
                    while (it.hasNext()) {
                        c.a.o0.a.h0.f.d.b next = it.next();
                        if (next != null) {
                            next.a();
                        }
                    }
                    this.f5791a.clear();
                }
            } finally {
                this.f5792b.unlock();
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f5791a = new ArrayList<>();
        this.f5792b = new ReentrantLock();
        this.f5793c = false;
        this.f5794d = false;
        this.f5795e = new C0197a(this);
        b bVar = new b(this);
        this.f5796f = bVar;
        BdSailor.addForceInitListener(bVar);
        c.a.o0.a.c1.a.f().h(this.f5795e);
    }
}
