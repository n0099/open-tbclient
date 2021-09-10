package c.f.b.a.a.a;

import android.hardware.Camera;
import android.view.SurfaceHolder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.List;
/* loaded from: classes4.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile Camera f32323a;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.f.b.a.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1471b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f32324a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1087275571, "Lc/f/b/a/a/a/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1087275571, "Lc/f/b/a/a/a/b$b;");
                    return;
                }
            }
            f32324a = new b(null);
        }
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static final b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? C1471b.f32324a : (b) invokeV.objValue;
    }

    public void b(Camera.AutoFocusCallback autoFocusCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, autoFocusCallback) == null) || this.f32323a == null) {
            return;
        }
        this.f32323a.autoFocus(autoFocusCallback);
    }

    public void c(Camera.AutoFocusCallback autoFocusCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, autoFocusCallback, str) == null) {
            n();
            Camera.Parameters k = k();
            List<String> supportedFocusModes = k.getSupportedFocusModes();
            if (supportedFocusModes == null || !supportedFocusModes.contains(str)) {
                return;
            }
            k.setFocusMode(str);
            d(k);
            b(autoFocusCallback);
        }
    }

    public void d(Camera.Parameters parameters) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, parameters) == null) {
            if (parameters != null) {
                parameters.setRotation(0);
            }
            if (this.f32323a != null) {
                this.f32323a.setParameters(parameters);
            }
        }
    }

    public void e(Camera.PreviewCallback previewCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, previewCallback) == null) || this.f32323a == null) {
            return;
        }
        this.f32323a.setPreviewCallbackWithBuffer(previewCallback);
    }

    public void f(Camera.ShutterCallback shutterCallback, Camera.PictureCallback pictureCallback, Camera.PictureCallback pictureCallback2, Camera.PictureCallback pictureCallback3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048580, this, shutterCallback, pictureCallback, pictureCallback2, pictureCallback3) == null) || this.f32323a == null) {
            return;
        }
        this.f32323a.takePicture(shutterCallback, pictureCallback, pictureCallback2, pictureCallback3);
    }

    public void g(SurfaceHolder surfaceHolder) throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, surfaceHolder) == null) || this.f32323a == null) {
            return;
        }
        this.f32323a.setPreviewDisplay(surfaceHolder);
    }

    public void h(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bArr) == null) || this.f32323a == null) {
            return;
        }
        this.f32323a.addCallbackBuffer(bArr);
    }

    public Camera i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f32323a == null) {
                synchronized (b.class) {
                    if (this.f32323a == null) {
                        this.f32323a = Camera.open();
                    }
                }
            }
            return this.f32323a;
        }
        return (Camera) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f32323a == null) {
            return;
        }
        this.f32323a.stopPreview();
    }

    public Camera.Parameters k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.f32323a != null) {
                return this.f32323a.getParameters();
            }
            return null;
        }
        return (Camera.Parameters) invokeV.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f32323a == null) {
            return;
        }
        this.f32323a.startPreview();
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f32323a == null) {
            return;
        }
        this.f32323a.release();
        this.f32323a = null;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f32323a == null) {
            return;
        }
        this.f32323a.cancelAutoFocus();
    }

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
}
