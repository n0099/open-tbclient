package c.a.r0.a.p0.h;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.e0.d;
import c.a.r0.a.k;
import c.a.r0.a.o2.g.h;
import c.a.r0.a.p0.g.c.a;
import c.a.r0.a.z2.g1.c;
import c.a.r0.a.z2.q0;
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
public abstract class b<T extends c.a.r0.a.p0.g.c.a> extends c.a.r0.a.p0.d.a<T> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f8394c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public CopyOnWriteArrayList<c<Exception>> f8395b;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f8396e;

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
            this.f8396e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.k("ExtCore-PresetControl", "run: tryUpdateAsync start doUpdate");
                c.a.r0.a.p0.h.a b2 = c.a.r0.a.p0.h.a.b(this.f8396e.a);
                c.a.r0.a.p0.g.a aVar = new c.a.r0.a.p0.g.a();
                aVar.a = b2.a;
                aVar.f8387b = b2.f8393b;
                aVar.f8388c = this.f8396e.a.a();
                b bVar = this.f8396e;
                bVar.l(bVar.g(aVar));
            }
        }
    }

    /* renamed from: c.a.r0.a.p0.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0514b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f8397e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Exception f8398f;

        public RunnableC0514b(b bVar, c cVar, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, cVar, exc};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8397e = cVar;
            this.f8398f = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8397e.onCallback(this.f8398f);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-144841226, "Lc/a/r0/a/p0/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-144841226, "Lc/a/r0/a/p0/h/b;");
                return;
            }
        }
        f8394c = k.a;
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
                super((c.a.r0.a.p0.g.c.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f8395b = new CopyOnWriteArrayList<>();
    }

    @Override // c.a.r0.a.p0.d.a
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

    /* JADX WARN: Incorrect types in method signature: <T:Lc/a/r0/a/p0/g/a;>(TT;)Ljava/lang/Exception; */
    public Exception g(@NonNull c.a.r0.a.p0.g.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
            boolean z = f8394c;
            if (TextUtils.isEmpty(aVar.f8388c)) {
                boolean z2 = f8394c;
                return new IllegalStateException("ExtCore-PresetControl doUpdate: failed by updateInfo.coreFilePath is empty");
            }
            long j2 = aVar.f8387b;
            if (c.a.r0.w.d.V(aVar.f8388c, b(j2).getPath())) {
                c.a.r0.a.p0.j.a.b(a(), j2);
                n(j2);
                o(aVar.a);
                c.a.r0.a.p0.j.a.i(this.a.c(), false);
                return null;
            }
            Exception exc = new Exception("ExtCore-PresetControl doUpdate: failed by can not unzip coreFile = " + aVar.f8388c);
            if (f8394c) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? h.a().getLong(this.a.b(), 0L) : invokeV.longValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? h.a().getString(this.a.e(), "") : (String) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!h().isAvailable()) {
                boolean z = f8394c;
                return true;
            } else if (!c.a.r0.a.p0.j.a.h(this.a.c())) {
                boolean z2 = f8394c;
                return false;
            } else {
                c.a.r0.a.p0.h.a b2 = c.a.r0.a.p0.h.a.b(this.a);
                long i2 = i();
                long j2 = b2.f8393b;
                if (f8394c) {
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
            Iterator<c<Exception>> it = this.f8395b.iterator();
            while (it.hasNext()) {
                m(it.next(), exc);
            }
            this.f8395b.clear();
        }
    }

    public final void m(@Nullable c<Exception> cVar, Exception exc) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar, exc) == null) || cVar == null) {
            return;
        }
        q0.e0(new RunnableC0514b(this, cVar, exc));
    }

    public void n(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j2) == null) {
            h.a().putLong(this.a.b(), j2);
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            h.a().putString(this.a.e(), str);
        }
    }

    @SuppressLint({"SwanNewThread"})
    public void p(@Nullable c<Exception> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            d.k("ExtCore-PresetControl", "tryUpdateAsync: start");
            if (!k()) {
                d.k("ExtCore-PresetControl", "tryUpdateAsync: isNeedUpdate = false");
                m(cVar, null);
                return;
            }
            if (this.f8395b.isEmpty()) {
                new Thread(new a(this), "updateExtensionCoreAsync").start();
            }
            if (cVar != null) {
                this.f8395b.add(cVar);
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && k()) {
            c.a.r0.a.p0.h.a b2 = c.a.r0.a.p0.h.a.b(this.a);
            c.a.r0.a.p0.g.a aVar = new c.a.r0.a.p0.g.a();
            aVar.a = b2.a;
            aVar.f8387b = b2.f8393b;
            aVar.f8388c = this.a.a();
            l(g(aVar));
        }
    }
}
