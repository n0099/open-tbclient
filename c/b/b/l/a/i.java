package c.b.b.l.a;

import android.opengl.GLES20;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
/* loaded from: classes7.dex */
public class i implements c.b.b.n.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f27418b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f27419c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f27420d;

    public i() {
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
        this.a = new int[1];
        this.f27418b = new int[1];
        this.f27419c = new int[1];
        this.f27420d = new byte[512];
    }

    @Override // c.b.b.n.c
    public void B(int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            GLES20.glFramebufferTexture2D(i2, i3, i4, i5, i6);
        }
    }

    @Override // c.b.b.n.c
    public void C(int i2, IntBuffer intBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, intBuffer) == null) {
            GLES20.glGetIntegerv(i2, intBuffer);
        }
    }

    @Override // c.b.b.n.c
    public String D(int i2, int i3, IntBuffer intBuffer, IntBuffer intBuffer2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), intBuffer, intBuffer2})) == null) {
            byte[] bArr = this.f27420d;
            GLES20.glGetActiveAttrib(i2, i3, bArr.length, this.a, 0, this.f27418b, 0, this.f27419c, 0, bArr, 0);
            intBuffer.put(this.f27418b[0]);
            intBuffer2.put(this.f27419c[0]);
            return new String(this.f27420d, 0, this.a[0]);
        }
        return (String) invokeCommon.objValue;
    }

    @Override // c.b.b.n.c
    public void E(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            GLES20.glBindBuffer(i2, i3);
        }
    }

    @Override // c.b.b.n.c
    public void F(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            GLES20.glGenerateMipmap(i2);
        }
    }

    @Override // c.b.b.n.c
    public void G(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            GLES20.glLinkProgram(i2);
        }
    }

    @Override // c.b.b.n.c
    public void H(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            GLES20.glDeleteProgram(i2);
        }
    }

    @Override // c.b.b.n.c
    public void I(int i2, int i3, IntBuffer intBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048583, this, i2, i3, intBuffer) == null) {
            GLES20.glGetShaderiv(i2, i3, intBuffer);
        }
    }

    @Override // c.b.b.n.c
    public String J(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? GLES20.glGetProgramInfoLog(i2) : (String) invokeI.objValue;
    }

    @Override // c.b.b.n.c
    public void K(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            GLES20.glDeleteShader(i2);
        }
    }

    @Override // c.b.b.n.c
    public void L(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i2, i3) == null) {
            GLES20.glAttachShader(i2, i3);
        }
    }

    @Override // c.b.b.n.c
    public int M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? GLES20.glCreateProgram() : invokeV.intValue;
    }

    @Override // c.b.b.n.c
    public void N(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i2, i3) == null) {
            GLES20.glBindTexture(i2, i3);
        }
    }

    @Override // c.b.b.n.c
    public int P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            GLES20.glGenRenderbuffers(1, this.a, 0);
            return this.a[0];
        }
        return invokeV.intValue;
    }

    @Override // c.b.b.n.c
    public int Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            GLES20.glGenFramebuffers(1, this.a, 0);
            return this.a[0];
        }
        return invokeV.intValue;
    }

    @Override // c.b.b.n.c
    public int R(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048591, this, i2, str)) == null) ? GLES20.glGetAttribLocation(i2, str) : invokeIL.intValue;
    }

    @Override // c.b.b.n.c
    public void S(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            int[] iArr = this.a;
            iArr[0] = i2;
            GLES20.glDeleteTextures(1, iArr, 0);
        }
    }

    @Override // c.b.b.n.c
    public int T(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) ? GLES20.glCreateShader(i2) : invokeI.intValue;
    }

    @Override // c.b.b.n.c
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            GLES20.glGenTextures(1, this.a, 0);
            return this.a[0];
        }
        return invokeV.intValue;
    }

    @Override // c.b.b.n.c
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            int[] iArr = this.a;
            iArr[0] = i2;
            GLES20.glDeleteBuffers(1, iArr, 0);
        }
    }

    @Override // c.b.b.n.c
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            GLES20.glUseProgram(i2);
        }
    }

    @Override // c.b.b.n.c
    public void e(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048597, this, i2, i3, i4, i5) == null) {
            GLES20.glRenderbufferStorage(i2, i3, i4, i5);
        }
    }

    @Override // c.b.b.n.c
    public void f(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048598, this, i2, i3) == null) {
            GLES20.glBindFramebuffer(i2, i3);
        }
    }

    @Override // c.b.b.n.c
    public void g(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048599, this, i2, i3) == null) {
            GLES20.glPixelStorei(i2, i3);
        }
    }

    @Override // c.b.b.n.c
    public void h(int i2, int i3, int i4, int i5, int i6, int i7, int i8, Buffer buffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), buffer}) == null) {
            GLES20.glCompressedTexImage2D(i2, i3, i4, i5, i6, i7, i8, buffer);
        }
    }

    @Override // c.b.b.n.c
    public void i(int i2, FloatBuffer floatBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048601, this, i2, floatBuffer) == null) {
            GLES20.glGetFloatv(i2, floatBuffer);
        }
    }

    @Override // c.b.b.n.c
    public void j(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048602, this, i2, i3, i4) == null) {
            GLES20.glTexParameteri(i2, i3, i4);
        }
    }

    @Override // c.b.b.n.c
    public void k(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048603, this, i2, i3, i4, i5) == null) {
            GLES20.glFramebufferRenderbuffer(i2, i3, i4, i5);
        }
    }

    @Override // c.b.b.n.c
    public void l(int i2, int i3, IntBuffer intBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048604, this, i2, i3, intBuffer) == null) {
            GLES20.glGetProgramiv(i2, i3, intBuffer);
        }
    }

    @Override // c.b.b.n.c
    public void m(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048605, this, i2, i3) == null) {
            GLES20.glBindRenderbuffer(i2, i3);
        }
    }

    @Override // c.b.b.n.c
    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            GLES20.glGenBuffers(1, this.a, 0);
            return this.a[0];
        }
        return invokeV.intValue;
    }

    @Override // c.b.b.n.c
    public String o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i2)) == null) ? GLES20.glGetString(i2) : (String) invokeI.objValue;
    }

    @Override // c.b.b.n.c
    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            int[] iArr = this.a;
            iArr[0] = i2;
            GLES20.glDeleteRenderbuffers(1, iArr, 0);
        }
    }

    @Override // c.b.b.n.c
    public void q(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, Buffer buffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), buffer}) == null) {
            GLES20.glTexImage2D(i2, i3, i4, i5, i6, i7, i8, i9, buffer);
        }
    }

    @Override // c.b.b.n.c
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            int[] iArr = this.a;
            iArr[0] = i2;
            GLES20.glDeleteFramebuffers(1, iArr, 0);
        }
    }

    @Override // c.b.b.n.c
    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            GLES20.glCompileShader(i2);
        }
    }

    @Override // c.b.b.n.c
    public int t(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048612, this, i2)) == null) ? GLES20.glCheckFramebufferStatus(i2) : invokeI.intValue;
    }

    @Override // c.b.b.n.c
    public void u(int i2, int i3, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2)}) == null) {
            GLES20.glTexParameterf(i2, i3, f2);
        }
    }

    @Override // c.b.b.n.c
    public int w(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048614, this, i2, str)) == null) ? GLES20.glGetUniformLocation(i2, str) : invokeIL.intValue;
    }

    @Override // c.b.b.n.c
    public String x(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048615, this, i2)) == null) ? GLES20.glGetShaderInfoLog(i2) : (String) invokeI.objValue;
    }

    @Override // c.b.b.n.c
    public void y(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048616, this, i2, str) == null) {
            GLES20.glShaderSource(i2, str);
        }
    }

    @Override // c.b.b.n.c
    public String z(int i2, int i3, IntBuffer intBuffer, IntBuffer intBuffer2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048617, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), intBuffer, intBuffer2})) == null) {
            byte[] bArr = this.f27420d;
            GLES20.glGetActiveUniform(i2, i3, bArr.length, this.a, 0, this.f27418b, 0, this.f27419c, 0, bArr, 0);
            intBuffer.put(this.f27418b[0]);
            intBuffer2.put(this.f27419c[0]);
            return new String(this.f27420d, 0, this.a[0]);
        }
        return (String) invokeCommon.objValue;
    }
}
