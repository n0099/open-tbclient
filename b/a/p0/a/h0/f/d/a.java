package b.a.p0.a.h0.f.d;

import b.a.p0.a.k;
import b.a.p0.a.p.e.h;
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
    public static final boolean f5176g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<b.a.p0.a.h0.f.d.b> f5177a;

    /* renamed from: b  reason: collision with root package name */
    public final Lock f5178b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f5179c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f5180d;

    /* renamed from: e  reason: collision with root package name */
    public c f5181e;

    /* renamed from: f  reason: collision with root package name */
    public WebKitFactory.IForceInitZeusListener f5182f;

    /* renamed from: b.a.p0.a.h0.f.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0194a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f5183a;

        public C0194a(a aVar) {
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
            this.f5183a = aVar;
        }

        @Override // b.a.p0.a.h0.f.d.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f5183a.f5178b.lock();
                    this.f5183a.f5180d = true;
                    this.f5183a.j();
                    this.f5183a.p();
                } finally {
                    this.f5183a.f5178b.unlock();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements WebKitFactory.IForceInitZeusListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f5184a;

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
            this.f5184a = aVar;
        }

        @Override // com.baidu.webkit.sdk.WebKitFactory.IForceInitZeusListener
        public void onForceInitZeusFinish(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                try {
                    this.f5184a.f5178b.lock();
                    this.f5184a.f5179c = true;
                    this.f5184a.p();
                    this.f5184a.f5178b.unlock();
                    BdSailor.getInstance().removeForceInitListener(this.f5184a.f5182f);
                } catch (Throwable th) {
                    this.f5184a.f5178b.unlock();
                    throw th;
                }
            }
        }

        @Override // com.baidu.webkit.sdk.WebKitFactory.IForceInitZeusListener
        public void onForceInitZeusStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                boolean unused = a.f5176g;
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
        public static final a f5185a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1968325697, "Lb/a/p0/a/h0/f/d/a$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1968325697, "Lb/a/p0/a/h0/f/d/a$d;");
                    return;
                }
            }
            f5185a = new a(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1772251519, "Lb/a/p0/a/h0/f/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1772251519, "Lb/a/p0/a/h0/f/d/a;");
                return;
            }
        }
        f5176g = k.f6397a;
    }

    public /* synthetic */ a(C0194a c0194a) {
        this();
    }

    public static a k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? d.f5185a : (a) invokeV.objValue;
    }

    @Override // b.a.p0.a.p.e.h
    public void a(b.a.p0.a.h0.f.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            try {
                this.f5178b.lock();
                if (bVar != null && this.f5177a.contains(bVar)) {
                    this.f5177a.remove(bVar);
                }
            } finally {
                this.f5178b.unlock();
            }
        }
    }

    @Override // b.a.p0.a.p.e.h
    public void b(b.a.p0.a.h0.f.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            try {
                this.f5178b.lock();
                if (bVar == null) {
                    return;
                }
                if (!this.f5177a.contains(bVar)) {
                    this.f5177a.add(bVar);
                }
                if (n()) {
                    p();
                }
            } finally {
                this.f5178b.unlock();
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
            b.a.p0.a.c1.a.f().d(z);
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
                this.f5178b.lock();
                if (f5176g) {
                    String str = "isLoaded() mIsBlinkInited: " + this.f5180d;
                    String str2 = "isLoaded() mIsZeusForceInited: " + this.f5179c + " ,isZeusForceInited: " + o();
                }
                if (this.f5180d) {
                    if (!this.f5179c) {
                    }
                    z = true;
                    return z;
                }
                z = false;
                return z;
            } finally {
                this.f5178b.unlock();
            }
        }
        return invokeV.booleanValue;
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (f5176g) {
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
                this.f5178b.lock();
                if (n()) {
                    Iterator<b.a.p0.a.h0.f.d.b> it = this.f5177a.iterator();
                    while (it.hasNext()) {
                        b.a.p0.a.h0.f.d.b next = it.next();
                        if (next != null) {
                            next.a();
                        }
                    }
                    this.f5177a.clear();
                }
            } finally {
                this.f5178b.unlock();
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
        this.f5177a = new ArrayList<>();
        this.f5178b = new ReentrantLock();
        this.f5179c = false;
        this.f5180d = false;
        this.f5181e = new C0194a(this);
        b bVar = new b(this);
        this.f5182f = bVar;
        BdSailor.addForceInitListener(bVar);
        b.a.p0.a.c1.a.f().h(this.f5181e);
    }
}
