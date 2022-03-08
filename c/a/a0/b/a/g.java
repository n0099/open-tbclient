package c.a.a0.b.a;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static final float[] a;

    /* renamed from: b  reason: collision with root package name */
    public static final float[] f1269b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(11380777, "Lc/a/a0/b/a/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(11380777, "Lc/a/a0/b/a/g;");
                return;
            }
        }
        a = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        float[] fArr = new float[16];
        f1269b = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            int glGetError = GLES20.glGetError();
            if (glGetError == 1281) {
                String str2 = "---> GL_INVALID_VALUE : glError 0x" + Integer.toHexString(glGetError);
            } else if (glGetError != 0) {
                String str3 = str + ": glError 0x" + Integer.toHexString(glGetError);
            }
        }
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            int i2 = iArr[0];
            GLES20.glBindTexture(3553, i2);
            GLES20.glTexParameterf(3553, 10241, 9728.0f);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            return i2;
        }
        return invokeV.intValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            int i2 = iArr[0];
            GLES20.glBindTexture(3553, i2);
            GLES20.glTexParameterf(3553, 10241, 9985.0f);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            return i2;
        }
        return invokeV.intValue;
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            int i2 = iArr[0];
            GLES20.glBindTexture(36197, i2);
            GLES20.glTexParameterf(36197, 10241, 9728.0f);
            GLES20.glTexParameterf(36197, 10240, 9729.0f);
            GLES20.glTexParameteri(36197, 10242, 33071);
            GLES20.glTexParameteri(36197, 10243, 33071);
            return i2;
        }
        return invokeV.intValue;
    }

    public static int e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            int[] iArr = new int[1];
            int f2 = f(str, 35633);
            if (f2 != 0) {
                int f3 = f(str2, 35632);
                if (f3 != 0) {
                    int glCreateProgram = GLES20.glCreateProgram();
                    a("glCreateProgram");
                    GLES20.glAttachShader(glCreateProgram, f2);
                    a("glAttachShader");
                    GLES20.glAttachShader(glCreateProgram, f3);
                    a("glAttachShader");
                    GLES20.glLinkProgram(glCreateProgram);
                    GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
                    if (iArr[0] > 0) {
                        GLES20.glDeleteShader(f2);
                        GLES20.glDeleteShader(f3);
                        return glCreateProgram;
                    }
                    GLES20.glDeleteProgram(glCreateProgram);
                    throw new RuntimeException("gl Load Program Linking Failed");
                }
                throw new RuntimeException("gl Load Program Fragment Shader Failed");
            }
            throw new RuntimeException("gl Load Program Vertex Shader Failed");
        }
        return invokeLL.intValue;
    }

    public static int f(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i2)) == null) {
            int[] iArr = new int[1];
            int glCreateShader = GLES20.glCreateShader(i2);
            a("glCreateShader type=" + i2 + " source : " + str + StringUtils.LF);
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                String str2 = "Compilation\n" + GLES20.glGetShaderInfoLog(glCreateShader);
                GLES20.glDeleteShader(glCreateShader);
                return 0;
            }
            return glCreateShader;
        }
        return invokeLI.intValue;
    }

    public static int g(Bitmap bitmap, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{bitmap, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            int[] iArr = new int[1];
            if (i2 == -1) {
                GLES20.glGenTextures(1, iArr, 0);
                GLES20.glBindTexture(3553, iArr[0]);
                GLES20.glTexParameterf(3553, 10240, 9729.0f);
                GLES20.glTexParameterf(3553, 10241, 9729.0f);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
                GLUtils.texImage2D(3553, 0, bitmap, 0);
            } else {
                GLES20.glBindTexture(3553, i2);
                GLUtils.texSubImage2D(3553, 0, 0, 0, bitmap);
                iArr[0] = i2;
            }
            if (z) {
                bitmap.recycle();
            }
            return iArr[0];
        }
        return invokeCommon.intValue;
    }
}
