package b.a.p0.a.p0.i;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import b.a.p0.a.o2.g.h;
import b.a.p0.a.p0.g.c.a;
import b.a.p0.a.z2.j0;
import b.a.p0.w.d;
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
public class a<T extends b.a.p0.a.p0.g.c.a> extends b.a.p0.a.p0.d.a<T> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f7721b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.p0.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0357a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f7722a;

        /* renamed from: b  reason: collision with root package name */
        public String f7723b;

        public C0357a() {
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
            this.f7722a = 0;
        }

        public static C0357a a(int i2, String str) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i2, str)) == null) {
                C0357a c0357a = new C0357a();
                c0357a.f7722a = i2;
                c0357a.f7723b = str;
                return c0357a;
            }
            return (C0357a) invokeIL.objValue;
        }

        public static C0357a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? a(1, str) : (C0357a) invokeL.objValue;
        }

        public static C0357a d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a(0, "") : (C0357a) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f7722a == 0 : invokeV.booleanValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return "RemoteExtensionCoreUpdateStatus{statusCode=" + this.f7722a + ", message='" + this.f7723b + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(107557273, "Lb/a/p0/a/p0/i/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(107557273, "Lb/a/p0/a/p0/i/a;");
                return;
            }
        }
        f7721b = k.f6863a;
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
                super((b.a.p0.a.p0.g.c.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // b.a.p0.a.p0.d.a
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
        d.k(str);
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lb/a/p0/a/p0/g/a;>(TT;)Ljava/lang/Exception; */
    public Exception e(@NonNull b.a.p0.a.p0.g.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) {
            boolean z = f7721b;
            if (TextUtils.isEmpty(aVar.f7707c)) {
                boolean z2 = f7721b;
                return new Exception("ExtCore-RemoteControl doUpdate: failed by updateInfo.coreFilePath empty");
            }
            C0357a i2 = i(aVar);
            if (f7721b) {
                r0 = "doUpdate: remote status: " + i2;
            }
            d(aVar.f7707c);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? h.a().getLong(this.f7620a.b(), 0L) : invokeV.longValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? h.a().getString(this.f7620a.e(), "0") : (String) invokeV.objValue;
    }

    public final C0357a i(@NonNull b.a.p0.a.p0.g.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, aVar)) == null) {
            if (f7721b) {
                String str = "doRemoteUpdate version: " + aVar.f7705a + " ,filePath: " + aVar.f7707c + " ,sign:" + aVar.f7708d;
            }
            long j = aVar.f7706b;
            if (j == 0) {
                return C0357a.b("invalid version code : " + aVar.f7705a);
            } else if (!j0.a(new File(aVar.f7707c), aVar.f7708d)) {
                return C0357a.b("sign failed.");
            } else {
                if (!d.U(aVar.f7707c, b(j).getPath())) {
                    return C0357a.b("unzip bundle failed.");
                }
                b.a.p0.a.p0.j.a.b(a(), g(), j);
                j(j);
                k(aVar.f7705a);
                if (f7721b) {
                    String str2 = "doRemoteUpdate end. version = " + j;
                }
                return C0357a.d();
            }
        }
        return (C0357a) invokeL.objValue;
    }

    public void j(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            h.a().putLong(this.f7620a.b(), j);
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            h.a().putString(this.f7620a.e(), str);
        }
    }
}
