package b.a.p0.a.p0;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.e0.d;
import b.a.p0.a.k;
import b.a.p0.a.p0.f.c;
import b.a.p0.a.v1.b.f;
import b.a.p0.a.v2.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a extends b.a.p0.a.p0.d.b<b.a.p0.a.p0.h.c.a, b.a.p0.a.p0.i.b.a> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f7199d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f7200e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f7201f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.p0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0338a extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0338a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final ExtensionCore a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (b() == null) {
                    return null;
                }
                ExtensionCore d2 = b().d();
                if (d2.isAvailable()) {
                    return d2;
                }
                b().h();
                return b().d();
            }
            return (ExtensionCore) invokeV.objValue;
        }

        public final b.a.p0.a.p0.d.b b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? b.a.p0.a.p0.b.f(c()) : (b.a.p0.a.p0.d.b) invokeV.objValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bundle)) == null) {
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("aiapps_extension_core", a());
                return bundle2;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("swan_preset_extension", a.f7201f);
                d.h("ExtCore-AppsManager", "is extension file exists : " + a.n());
                return bundle2;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1331953779, "Lb/a/p0/a/p0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1331953779, "Lb/a/p0/a/p0/a;");
                return;
            }
        }
        f7199d = k.f6397a;
        b.a.p0.a.c1.a.Z().getSwitch("swan_preset_extension", true);
        f7201f = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a() {
        super(m(), new b.a.p0.a.p0.i.b.a());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super((b.a.p0.a.p0.h.b) objArr[0], (b.a.p0.a.p0.i.a) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (ProcessUtils.isMainProcess()) {
                d.h("ExtCore-AppsManager", "MainProcess mPresetExtension: " + f7201f);
                return f7201f;
            }
            f b2 = b.a.p0.a.v1.b.d.b(b.class, null);
            boolean z = true;
            if (b2.a() && !b2.f8485a.getBoolean("swan_preset_extension", true)) {
                z = false;
            }
            d.h("ExtCore-AppsManager", "swanProcess mPresetExtension: " + z);
            return z;
        }
        return invokeV.booleanValue;
    }

    public static a l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (f7200e == null) {
                synchronized (a.class) {
                    if (f7200e == null) {
                        f7200e = new a();
                    }
                }
            }
            return f7200e;
        }
        return (a) invokeV.objValue;
    }

    public static b.a.p0.a.p0.h.c.a m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? k() ? new b.a.p0.a.p0.h.c.a() : new b.a.p0.a.p0.h.c.b() : (b.a.p0.a.p0.h.c.a) invokeV.objValue;
    }

    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            b.a.p0.a.p0.g.b.a aVar = new b.a.p0.a.p0.g.b.a();
            boolean z = h.a(AppRuntime.getAppContext(), aVar.d()) && h.a(AppRuntime.getAppContext(), aVar.a());
            d.h("ExtCore-AppsManager", "preset extension isFileExists : " + z);
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.p0.d.b
    public String b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 != 1) {
                return c.b().getPath();
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    @Override // b.a.p0.a.p0.d.b
    @Nullable
    public ExtensionCore c() {
        InterceptResult invokeV;
        ExtensionCore extensionCore;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (ProcessUtils.isMainProcess()) {
                extensionCore = d();
            } else {
                Bundle bundle = b.a.p0.a.v1.b.d.b(C0338a.class, null).f8485a;
                bundle.setClassLoader(ExtensionCore.class.getClassLoader());
                extensionCore = (ExtensionCore) bundle.getParcelable("aiapps_extension_core");
                if (f7199d) {
                    String str = "getExtensionCore:" + ProcessUtils.getCurProcessName() + " extension core: " + extensionCore;
                }
            }
            return (extensionCore == null || !b.a.p0.a.u1.a.a.W() || extensionCore.extensionCoreVersionCode >= 4294967297L) ? extensionCore : b.a.p0.a.u1.a.a.a(extensionCore);
        }
        return (ExtensionCore) invokeV.objValue;
    }
}
