package b.a.p0.a.h0.r;

import android.os.Environment;
import b.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.Channels;
/* loaded from: classes.dex */
public class e extends b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f5746c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public File f5747b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597730660, "Lb/a/p0/a/h0/r/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597730660, "Lb/a/p0/a/h0/r/e;");
                return;
            }
        }
        f5746c = k.f6397a;
    }

    public e() {
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
        this.f5747b = o();
    }

    @Override // b.a.p0.a.h0.r.b
    public boolean e(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            if (cVar != null && this.f5747b.exists()) {
                File file = this.f5747b;
                File file2 = new File(file, cVar.f11076g + File.separator + cVar.q);
                if (file2.exists()) {
                    try {
                        if (!d(Channels.newChannel(new FileInputStream(file2)), cVar.m)) {
                            boolean z = f5746c;
                            return false;
                        }
                        File j = j(cVar.f11077h, cVar.f11076g, cVar.f11078i);
                        if (j == null) {
                            boolean z2 = f5746c;
                            return false;
                        }
                        return n(new BufferedInputStream(new FileInputStream(file2)), j);
                    } catch (IOException e2) {
                        if (f5746c) {
                            e2.printStackTrace();
                        }
                        return false;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.p0.a.h0.r.b
    public String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (this.f5747b.exists()) {
                File file = this.f5747b;
                File file2 = new File(file, str + File.separator + "app_info.json");
                if (file2.exists()) {
                    return b.a.p0.t.d.D(file2);
                }
                return null;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // b.a.p0.a.h0.r.b
    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f5747b.exists()) {
                File file = new File(this.f5747b, "preset_list.json");
                if (file.exists()) {
                    return b.a.p0.t.d.D(file);
                }
                return null;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final File o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new File(Environment.getExternalStorageDirectory().getPath(), "baidu/swan_preset/") : (File) invokeV.objValue;
    }
}
