package c.a.a0.a.h;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.utils.FileUtils;
import java.io.File;
import java.util.Objects;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static d f1143h;
    public transient /* synthetic */ FieldHolder $fh;
    public File a;

    /* renamed from: b  reason: collision with root package name */
    public File f1144b;

    /* renamed from: c  reason: collision with root package name */
    public File f1145c;

    /* renamed from: d  reason: collision with root package name */
    public File f1146d;

    /* renamed from: e  reason: collision with root package name */
    public File f1147e;

    /* renamed from: f  reason: collision with root package name */
    public File f1148f;

    /* renamed from: g  reason: collision with root package name */
    public File f1149g;

    public d() {
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

    public static synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            synchronized (d.class) {
                if (f1143h == null) {
                    f1143h = new d();
                }
            }
        }
    }

    public static File b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65538, null, z)) == null) {
            if (z) {
                return d().f1148f;
            }
            return d().f1147e;
        }
        return (File) invokeZ.objValue;
    }

    public static d d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f1143h == null) {
                a();
            }
            return f1143h;
        }
        return (d) invokeV.objValue;
    }

    public static File e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            File file = new File(context.getFilesDir(), FileUtils.DIR_DUAR);
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return (File) invokeL.objValue;
    }

    public static File f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? d().f1149g : (File) invokeV.objValue;
    }

    @SuppressLint({"NewApi"})
    public File c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            if (Environment.getExternalStorageState().equals("mounted")) {
                return ((Context) Objects.requireNonNull(context)).getExternalFilesDir(FileUtils.DIR_DUAR);
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    public File g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f1145c : (File) invokeV.objValue;
    }

    public File h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f1146d : (File) invokeV.objValue;
    }

    public void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.a = e(context);
            File c2 = c(context);
            this.f1144b = c2;
            if (c2 == null) {
                this.f1144b = this.a;
            }
            if (this.f1144b != null) {
                this.f1145c = new File(this.f1144b, "sdk");
                File file = new File(this.f1145c, "arsource");
                this.f1146d = file;
                if (!file.exists()) {
                    this.f1146d.mkdirs();
                }
            }
            if (this.a != null) {
                new File(this.a, "sdk");
                File file2 = new File(this.a, "sdklibs/armeabi-v7a");
                this.f1147e = file2;
                if (!file2.exists()) {
                    this.f1147e.mkdirs();
                }
                File file3 = new File(this.a, "sdklibs/arm64-v8a");
                this.f1148f = file3;
                if (!file3.exists()) {
                    this.f1148f.mkdirs();
                }
                File file4 = new File(this.a, "sdklibs/armeabi-v7a-2");
                this.f1149g = file4;
                if (file4.exists()) {
                    return;
                }
                this.f1149g.mkdirs();
            }
        }
    }
}
