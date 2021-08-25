package c.a.o0.a.p0.i;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.k;
import c.a.o0.a.k2.g.h;
import c.a.o0.a.p0.g.c.a;
import c.a.o0.a.v2.j0;
import c.a.o0.t.d;
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
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes.dex */
public class a<T extends c.a.o0.a.p0.g.c.a> extends c.a.o0.a.p0.d.a<T> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f7969b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.o0.a.p0.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0348a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f7970a;

        /* renamed from: b  reason: collision with root package name */
        public String f7971b;

        public C0348a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7970a = 0;
        }

        public static C0348a a(int i2, String str) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i2, str)) == null) {
                C0348a c0348a = new C0348a();
                c0348a.f7970a = i2;
                c0348a.f7971b = str;
                return c0348a;
            }
            return (C0348a) invokeIL.objValue;
        }

        public static C0348a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? a(1, str) : (C0348a) invokeL.objValue;
        }

        public static C0348a d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a(0, "") : (C0348a) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f7970a == 0 : invokeV.booleanValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return "RemoteExtensionCoreUpdateStatus{statusCode=" + this.f7970a + ", message='" + this.f7971b + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-532059623, "Lc/a/o0/a/p0/i/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-532059623, "Lc/a/o0/a/p0/i/a;");
                return;
            }
        }
        f7969b = k.f7049a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull T t) {
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
                super((c.a.o0.a.p0.g.c.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.o0.a.p0.d.a
    public File a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new File(super.a(), "remote") : (File) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            k("0");
            j(0L);
        }
    }

    public final void d(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        d.j(str);
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lc/a/o0/a/p0/g/a;>(TT;)Ljava/lang/Exception; */
    public Exception e(@NonNull c.a.o0.a.p0.g.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) {
            boolean z = f7969b;
            if (TextUtils.isEmpty(aVar.f7954c)) {
                boolean z2 = f7969b;
                return new Exception("ExtCore-RemoteControl doUpdate: failed by updateInfo.coreFilePath empty");
            }
            C0348a i2 = i(aVar);
            if (f7969b) {
                r0 = "doUpdate: remote status: " + i2;
            }
            d(aVar.f7954c);
            if (i2.c()) {
                return null;
            }
            return new Exception("ExtCore-RemoteControl doUpdate: failed by " + i2.toString());
        }
        return (Exception) invokeL.objValue;
    }

    @NonNull
    public ExtensionCore f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ExtensionCore extensionCore = new ExtensionCore();
            long g2 = g();
            extensionCore.extensionCoreVersionCode = g2;
            extensionCore.extensionCoreVersionName = h();
            extensionCore.extensionCorePath = b(g2).getPath();
            extensionCore.extensionCoreType = 1;
            return extensionCore;
        }
        return (ExtensionCore) invokeV.objValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? h.a().getLong(this.f7876a.b(), 0L) : invokeV.longValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? h.a().getString(this.f7876a.e(), "0") : (String) invokeV.objValue;
    }

    public final C0348a i(@NonNull c.a.o0.a.p0.g.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, aVar)) == null) {
            if (f7969b) {
                String str = "doRemoteUpdate version: " + aVar.f7952a + " ,filePath: " + aVar.f7954c + " ,sign:" + aVar.f7955d;
            }
            long j2 = aVar.f7953b;
            if (j2 == 0) {
                return C0348a.b("invalid version code : " + aVar.f7952a);
            } else if (!j0.a(new File(aVar.f7954c), aVar.f7955d)) {
                return C0348a.b("sign failed.");
            } else {
                if (!d.T(aVar.f7954c, b(j2).getPath())) {
                    return C0348a.b("unzip bundle failed.");
                }
                c.a.o0.a.p0.j.a.b(a(), g(), j2);
                j(j2);
                k(aVar.f7952a);
                if (f7969b) {
                    String str2 = "doRemoteUpdate end. version = " + j2;
                }
                return C0348a.d();
            }
        }
        return (C0348a) invokeL.objValue;
    }

    public void j(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2) == null) {
            h.a().putLong(this.f7876a.b(), j2);
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            h.a().putString(this.f7876a.e(), str);
        }
    }
}
