package c.a.n0.a.f0.h;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.e2.g.h;
import c.a.n0.a.f0.g.c.a;
import c.a.n0.a.p2.g1.c;
import c.a.n0.a.p2.q0;
import c.a.n0.a.u.d;
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
public abstract class b<T extends c.a.n0.a.f0.g.c.a> extends c.a.n0.a.f0.d.a<T> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f4412c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public CopyOnWriteArrayList<c<Exception>> f4413b;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.k("ExtCore-PresetControl", "run: tryUpdateAsync start doUpdate");
                c.a.n0.a.f0.h.a b2 = c.a.n0.a.f0.h.a.b(this.a.a);
                c.a.n0.a.f0.g.a aVar = new c.a.n0.a.f0.g.a();
                aVar.a = b2.a;
                aVar.f4405b = b2.f4411b;
                aVar.f4406c = this.a.a.a();
                b bVar = this.a;
                bVar.l(bVar.g(aVar));
            }
        }
    }

    /* renamed from: c.a.n0.a.f0.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0270b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Exception f4414b;

        public RunnableC0270b(b bVar, c cVar, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, cVar, exc};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
            this.f4414b = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.onCallback(this.f4414b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-946274320, "Lc/a/n0/a/f0/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-946274320, "Lc/a/n0/a/f0/h/b;");
                return;
            }
        }
        f4412c = c.a.n0.a.a.a;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c.a.n0.a.f0.g.c.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f4413b = new CopyOnWriteArrayList<>();
    }

    @Override // c.a.n0.a.f0.d.a
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

    /* JADX WARN: Incorrect types in method signature: <T:Lc/a/n0/a/f0/g/a;>(TT;)Ljava/lang/Exception; */
    public Exception g(@NonNull c.a.n0.a.f0.g.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
            if (f4412c) {
                Log.d("ExtCore-PresetControl", "doUpdate: preset");
            }
            if (TextUtils.isEmpty(aVar.f4406c)) {
                if (f4412c) {
                    Log.e("ExtCore-PresetControl", "doUpdate: preset with null coreFilePath");
                }
                return new IllegalStateException("ExtCore-PresetControl doUpdate: failed by updateInfo.coreFilePath is empty");
            }
            long j = aVar.f4405b;
            if (c.a.n0.w.d.V(aVar.f4406c, b(j).getPath())) {
                c.a.n0.a.f0.j.a.b(a(), j);
                n(j);
                o(aVar.a);
                c.a.n0.a.f0.j.a.i(this.a.c(), false);
                return null;
            }
            Exception exc = new Exception("ExtCore-PresetControl doUpdate: failed by can not unzip coreFile = " + aVar.f4406c);
            if (f4412c) {
                Log.e("ExtCore-PresetControl", "doUpdate preset unzip failed: " + Log.getStackTraceString(exc));
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
            long i = i();
            extensionCore.extensionCoreVersionCode = i;
            extensionCore.extensionCoreVersionName = j();
            extensionCore.extensionCorePath = b(i).getPath();
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
                if (f4412c) {
                    Log.d("ExtCore-PresetControl", "isNeedUpdate: true, getCurExtensionCore not available.");
                }
                return true;
            } else if (!c.a.n0.a.f0.j.a.h(this.a.c())) {
                if (f4412c) {
                    Log.d("ExtCore-PresetControl", "isNeedUpdate: false");
                }
                return false;
            } else {
                c.a.n0.a.f0.h.a b2 = c.a.n0.a.f0.h.a.b(this.a);
                long i = i();
                long j = b2.f4411b;
                if (f4412c) {
                    Log.d("ExtCore-PresetControl", "isNeedUpdate curVer: " + i + " newVer: " + j);
                }
                return i < j;
            }
        }
        return invokeV.booleanValue;
    }

    public final void l(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, exc) == null) {
            Iterator<c<Exception>> it = this.f4413b.iterator();
            while (it.hasNext()) {
                m(it.next(), exc);
            }
            this.f4413b.clear();
        }
    }

    public final void m(@Nullable c<Exception> cVar, Exception exc) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar, exc) == null) || cVar == null) {
            return;
        }
        q0.e0(new RunnableC0270b(this, cVar, exc));
    }

    public void n(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            h.a().putLong(this.a.b(), j);
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
            if (this.f4413b.isEmpty()) {
                new Thread(new a(this), "updateExtensionCoreAsync").start();
            }
            if (cVar != null) {
                this.f4413b.add(cVar);
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && k()) {
            c.a.n0.a.f0.h.a b2 = c.a.n0.a.f0.h.a.b(this.a);
            c.a.n0.a.f0.g.a aVar = new c.a.n0.a.f0.g.a();
            aVar.a = b2.a;
            aVar.f4405b = b2.f4411b;
            aVar.f4406c = this.a.a();
            l(g(aVar));
        }
    }
}
