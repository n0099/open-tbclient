package c.a.r0.a.y1.b;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.z2.q;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.IProcessBridge;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Class f9920e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bundle f9921f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.y1.b.a f9922g;

        public a(Class cls, Bundle bundle, c.a.r0.a.y1.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cls, bundle, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9920e = cls;
            this.f9921f = bundle;
            this.f9922g = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Bundle b2 = e.b(this.f9920e, this.f9921f);
                c.a.r0.a.y1.b.a aVar = this.f9922g;
                if (aVar != null) {
                    aVar.onResult(b2);
                }
            }
        }
    }

    public static void a(@NonNull Class<? extends ProviderDelegation> cls, @Nullable Bundle bundle, @Nullable c.a.r0.a.y1.b.a<Bundle> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, cls, bundle, aVar) == null) {
            q.k(new a(cls, bundle, aVar), "asyncCallMainProcess");
        }
    }

    @NonNull
    public static Bundle b(@NonNull Class<? extends ProviderDelegation> cls, @Nullable Bundle bundle) {
        InterceptResult invokeLL;
        IProcessBridge R;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, cls, bundle)) == null) {
            if (ProcessUtils.isMainProcess()) {
                Bundle d2 = d(cls, bundle);
                return d2 == null ? new Bundle() : d2;
            }
            c.a.r0.a.y1.c.e.a z = c.a.r0.a.d2.d.J().z();
            if (z != null && (R = z.R()) != null) {
                try {
                    Bundle callMainProcessSync = R.callMainProcessSync(cls.getName(), bundle);
                    return callMainProcessSync == null ? new Bundle() : callMainProcessSync;
                } catch (Throwable th) {
                    c.a.r0.a.e0.d.d("SwanProcessCallManager", "callMainProcessSync", th);
                }
            }
            return DelegateUtils.callOnMainWithContentProvider(c.a.r0.a.c1.a.c(), cls, bundle).mResult;
        }
        return (Bundle) invokeLL.objValue;
    }

    @NonNull
    public static g c(@NonNull Class<? extends ProviderDelegation> cls, @Nullable Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, cls, bundle)) == null) ? new g(b(cls, bundle)) : (g) invokeLL.objValue;
    }

    @Nullable
    @SuppressLint({"BDThrowableCheck"})
    public static Bundle d(@NonNull Class<? extends ProviderDelegation> cls, @Nullable Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, cls, bundle)) == null) {
            if (ProcessUtils.isMainProcess()) {
                ProviderDelegation a2 = f.a(cls);
                if (a2 == null) {
                    try {
                        a2 = cls.newInstance();
                    } catch (Exception e2) {
                        c.a.r0.a.e0.d.d("SwanProcessCallManager", "callOnMainProcess", e2);
                    }
                }
                if (a2 != null) {
                    return a2.execCall(bundle);
                }
                return null;
            }
            return null;
        }
        return (Bundle) invokeLL.objValue;
    }

    @Nullable
    @SuppressLint({"BDThrowableCheck"})
    public static Bundle e(@NonNull String str, @Nullable Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, bundle)) == null) {
            if (ProcessUtils.isMainProcess()) {
                ProviderDelegation b2 = f.b(str);
                if (b2 == null) {
                    try {
                        b2 = (ProviderDelegation) Class.forName(str).newInstance();
                    } catch (Exception e2) {
                        c.a.r0.a.e0.d.d("SwanProcessCallManager", "callOnMainProcess", e2);
                    }
                }
                if (b2 != null) {
                    return b2.execCall(bundle);
                }
                return null;
            }
            return null;
        }
        return (Bundle) invokeLL.objValue;
    }
}
