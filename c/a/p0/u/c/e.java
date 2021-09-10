package c.a.p0.u.c;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.system.Os;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
/* loaded from: classes3.dex */
public class e implements b<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f12394a;

    public e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12394a = context.getApplicationContext();
    }

    @Override // c.a.p0.u.c.b
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !new File(this.f12394a.getFilesDir(), "libuuid.so").exists() : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.u.c.b
    /* renamed from: b */
    public String get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? d() : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.u.c.b
    /* renamed from: c */
    public void put(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            e(str);
        }
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            File file = new File(this.f12394a.getFilesDir(), "libuuid.so");
            if (file.exists()) {
                return c.a.p0.u.d.a.c(file);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @SuppressLint({"WorldReadableFiles"})
    @TargetApi(21)
    public final void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            File file = new File(this.f12394a.getFilesDir(), "libuuid.so");
            int i2 = Build.VERSION.SDK_INT >= 24 ? 1 : 0;
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    fileOutputStream = this.f12394a.openFileOutput("libuuid.so", i2 ^ 1);
                    fileOutputStream.write(str.getBytes());
                    fileOutputStream.flush();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (i2 != 0) {
                    try {
                        Os.chmod(file.getAbsolutePath(), 436);
                    } catch (Exception unused) {
                    }
                }
            } finally {
                c.a.p0.u.d.a.a(fileOutputStream);
            }
        }
    }
}
