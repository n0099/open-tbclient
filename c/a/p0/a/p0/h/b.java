package c.a.p0.a.p0.h;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.e0.d;
import c.a.p0.a.k;
import c.a.p0.a.k2.g.h;
import c.a.p0.a.p0.g.c.a;
import c.a.p0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public abstract class b<T extends c.a.p0.a.p0.g.c.a> extends c.a.p0.a.p0.d.a<T> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f7998c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public CopyOnWriteArrayList<c.a.p0.a.v2.e1.b<Exception>> f7999b;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f8000e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8000e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.h("ExtCore-PresetControl", "run: tryUpdateAsync start doUpdate");
                c.a.p0.a.p0.h.a b2 = c.a.p0.a.p0.h.a.b(this.f8000e.f7912a);
                c.a.p0.a.p0.g.a aVar = new c.a.p0.a.p0.g.a();
                aVar.f7988a = b2.f7996a;
                aVar.f7989b = b2.f7997b;
                aVar.f7990c = this.f8000e.f7912a.a();
                b bVar = this.f8000e;
                bVar.l(bVar.g(aVar));
            }
        }
    }

    /* renamed from: c.a.p0.a.p0.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0349b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.v2.e1.b f8001e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Exception f8002f;

        public RunnableC0349b(b bVar, c.a.p0.a.v2.e1.b bVar2, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bVar2, exc};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8001e = bVar2;
            this.f8002f = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8001e.onCallback(this.f8002f);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-403006664, "Lc/a/p0/a/p0/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-403006664, "Lc/a/p0/a/p0/h/b;");
                return;
            }
        }
        f7998c = k.f7085a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull T t) {
        super(t);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.p0.a.p0.g.c.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f7999b = new CopyOnWriteArrayList<>();
    }

    @Override // c.a.p0.a.p0.d.a
    public File a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new File(super.a(), "preset") : (File) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            o("0");
            n(0L);
        }
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lc/a/p0/a/p0/g/a;>(TT;)Ljava/lang/Exception; */
    public Exception g(@NonNull c.a.p0.a.p0.g.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
            boolean z = f7998c;
            if (TextUtils.isEmpty(aVar.f7990c)) {
                boolean z2 = f7998c;
                return new IllegalStateException("ExtCore-PresetControl doUpdate: failed by updateInfo.coreFilePath is empty");
            }
            long j2 = aVar.f7989b;
            if (c.a.p0.t.d.U(aVar.f7990c, b(j2).getPath())) {
                c.a.p0.a.p0.j.a.b(a(), j2);
                n(j2);
                o(aVar.f7988a);
                c.a.p0.a.p0.j.a.i(this.f7912a.c(), false);
                return null;
            }
            Exception exc = new Exception("ExtCore-PresetControl doUpdate: failed by can not unzip coreFile = " + aVar.f7990c);
            if (f7998c) {
                String str = "doUpdate preset unzip failed: " + Log.getStackTraceString(exc);
            }
            return exc;
        }
        return (Exception) invokeL.objValue;
    }

    @NonNull
    public ExtensionCore h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ExtensionCore extensionCore = new ExtensionCore();
            long i2 = i();
            extensionCore.extensionCoreVersionCode = i2;
            extensionCore.extensionCoreVersionName = j();
            extensionCore.extensionCorePath = b(i2).getPath();
            extensionCore.extensionCoreType = 0;
            return extensionCore;
        }
        return (ExtensionCore) invokeV.objValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? h.a().getLong(this.f7912a.b(), 0L) : invokeV.longValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? h.a().getString(this.f7912a.e(), "") : (String) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!h().isAvailable()) {
                boolean z = f7998c;
                return true;
            } else if (!c.a.p0.a.p0.j.a.h(this.f7912a.c())) {
                boolean z2 = f7998c;
                return false;
            } else {
                c.a.p0.a.p0.h.a b2 = c.a.p0.a.p0.h.a.b(this.f7912a);
                long i2 = i();
                long j2 = b2.f7997b;
                if (f7998c) {
                    String str = "isNeedUpdate curVer: " + i2 + " newVer: " + j2;
                }
                return i2 < j2;
            }
        }
        return invokeV.booleanValue;
    }

    public final void l(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, exc) == null) {
            Iterator<c.a.p0.a.v2.e1.b<Exception>> it = this.f7999b.iterator();
            while (it.hasNext()) {
                m(it.next(), exc);
            }
            this.f7999b.clear();
        }
    }

    public final void m(@Nullable c.a.p0.a.v2.e1.b<Exception> bVar, Exception exc) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, exc) == null) || bVar == null) {
            return;
        }
        q0.b0(new RunnableC0349b(this, bVar, exc));
    }

    public void n(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j2) == null) {
            h.a().putLong(this.f7912a.b(), j2);
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            h.a().putString(this.f7912a.e(), str);
        }
    }

    @SuppressLint({"SwanNewThread"})
    public void p(@Nullable c.a.p0.a.v2.e1.b<Exception> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            d.h("ExtCore-PresetControl", "tryUpdateAsync: start");
            if (!k()) {
                d.h("ExtCore-PresetControl", "tryUpdateAsync: isNeedUpdate = false");
                m(bVar, null);
                return;
            }
            if (this.f7999b.isEmpty()) {
                new Thread(new a(this), "updateExtensionCoreAsync").start();
            }
            if (bVar != null) {
                this.f7999b.add(bVar);
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && k()) {
            c.a.p0.a.p0.h.a b2 = c.a.p0.a.p0.h.a.b(this.f7912a);
            c.a.p0.a.p0.g.a aVar = new c.a.p0.a.p0.g.a();
            aVar.f7988a = b2.f7996a;
            aVar.f7989b = b2.f7997b;
            aVar.f7990c = this.f7912a.a();
            l(g(aVar));
        }
    }
}
