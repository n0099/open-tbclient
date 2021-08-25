package c.a.o0.h.m;

import android.os.Bundle;
import androidx.annotation.Nullable;
import c.a.o0.a.k;
import c.a.o0.a.p0.a;
import c.a.o0.a.p0.d.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a extends b<c.a.o0.h.m.d.a, c.a.o0.h.m.e.a> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f11289d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f11290e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.o0.h.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0574a extends a.C0341a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0574a() {
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

        @Override // c.a.o0.a.p0.a.C0341a
        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 1;
            }
            return invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(648954283, "Lc/a/o0/h/m/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(648954283, "Lc/a/o0/h/m/a;");
                return;
            }
        }
        f11289d = k.f7049a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a() {
        super(new c.a.o0.h.m.d.a(), new c.a.o0.h.m.e.a());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super((c.a.o0.a.p0.h.b) objArr[0], (c.a.o0.a.p0.i.a) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f11290e == null) {
                synchronized (a.class) {
                    if (f11290e == null) {
                        f11290e = new a();
                    }
                }
            }
            return f11290e;
        }
        return (a) invokeV.objValue;
    }

    @Override // c.a.o0.a.p0.d.b
    public String b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 == 1) {
                return c.a.o0.h.m.b.b.b().getPath();
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    @Override // c.a.o0.a.p0.d.b
    @Nullable
    public ExtensionCore c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return d();
            }
            Bundle bundle = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), C0574a.class, null).mResult;
            bundle.setClassLoader(ExtensionCore.class.getClassLoader());
            ExtensionCore extensionCore = (ExtensionCore) bundle.getParcelable("aiapps_extension_core");
            if (f11289d) {
                String str = "getExtensionCore:" + ProcessUtils.getCurProcessName() + " extension core: " + extensionCore;
                return extensionCore;
            }
            return extensionCore;
        }
        return (ExtensionCore) invokeV.objValue;
    }
}
