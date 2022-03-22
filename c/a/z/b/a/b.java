package c.a.z.b.a;

import android.opengl.GLES20;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.Rotation;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.faceunity.gles.GeneratedTexture;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f22252b;

    /* renamed from: c  reason: collision with root package name */
    public final FloatBuffer f22253c;

    /* renamed from: d  reason: collision with root package name */
    public final FloatBuffer f22254d;

    /* renamed from: e  reason: collision with root package name */
    public final FloatBuffer f22255e;

    /* renamed from: f  reason: collision with root package name */
    public int f22256f;

    /* renamed from: g  reason: collision with root package name */
    public int f22257g;

    /* renamed from: h  reason: collision with root package name */
    public int f22258h;
    public float[] i;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(g.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f22253c = asFloatBuffer;
        asFloatBuffer.put(g.a).position(0);
        FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(i.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f22254d = asFloatBuffer2;
        asFloatBuffer2.put(i.a).position(0);
        float[] b2 = i.b(Rotation.NORMAL, false, true);
        FloatBuffer asFloatBuffer3 = ByteBuffer.allocateDirect(b2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f22255e = asFloatBuffer3;
        asFloatBuffer3.put(b2).position(0);
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int[] iArr = this.a;
            return iArr == null || this.f22258h >= iArr.length;
        }
        return invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int[] iArr = this.f22252b;
            if (iArr != null) {
                GLES20.glDeleteTextures(iArr.length, iArr, 0);
                this.f22252b = null;
            }
            int[] iArr2 = this.a;
            if (iArr2 != null) {
                GLES20.glDeleteFramebuffers(iArr2.length, iArr2, 0);
                this.a = null;
            }
        }
    }

    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) || i == 0 || i2 == 0) {
            return;
        }
        if (this.f22256f == i && this.f22257g == i2) {
            return;
        }
        if (this.a != null) {
            b();
        }
        this.f22256f = i;
        this.f22257g = i2;
        d(2);
    }

    public final void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            int[] iArr = this.a;
            int length = iArr != null ? i + iArr.length : i;
            int[] iArr2 = new int[length];
            int[] iArr3 = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                int[] iArr4 = this.a;
                if (iArr4 != null && iArr4.length > i2) {
                    iArr2[i2] = iArr4[i2];
                }
                int[] iArr5 = this.f22252b;
                if (iArr5 != null && iArr5.length > i2) {
                    iArr3[i2] = iArr5[i2];
                }
                if (iArr3[i2] == 0) {
                    GLES20.glGenFramebuffers(1, iArr2, i2);
                    GLES20.glGenTextures(1, iArr3, i2);
                    GLES20.glBindTexture(3553, iArr3[i2]);
                    GLES20.glTexImage2D(3553, 0, GeneratedTexture.FORMAT, this.f22256f, this.f22257g, 0, GeneratedTexture.FORMAT, 5121, null);
                    GLES20.glTexParameterf(3553, 10240, 9729.0f);
                    GLES20.glTexParameterf(3553, 10241, 9729.0f);
                    GLES20.glTexParameterf(3553, 10242, 33071.0f);
                    GLES20.glTexParameterf(3553, 10243, 33071.0f);
                    GLES20.glBindFramebuffer(36160, iArr2[i2]);
                    GLES20.glFramebufferTexture2D(36160, 36064, 3553, iArr3[i2], 0);
                    GLES20.glBindTexture(3553, 0);
                    GLES20.glBindFramebuffer(36160, 0);
                }
            }
            this.a = iArr2;
            this.f22252b = iArr3;
        }
    }

    public int e(int i, a aVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048580, this, i, aVar)) == null) {
            if (aVar == null) {
                return i;
            }
            try {
                if (a()) {
                    d(2);
                }
                aVar.s();
                GLES20.glBindFramebuffer(36160, this.a[this.f22258h]);
                GLES20.glViewport(0, 0, this.f22256f, this.f22257g);
                GLES20.glClearColor(this.i[0], this.i[1], this.i[2], this.i[3]);
                GLES20.glClear(16640);
                aVar.p(i, this.f22253c, this.f22255e);
                GLES20.glBindFramebuffer(36160, 0);
                i = this.f22252b[this.f22258h];
                this.f22258h++;
                return i;
            } catch (Exception e2) {
                e2.printStackTrace();
                return i;
            }
        }
        return invokeIL.intValue;
    }

    public int f(int i, List<a> list) {
        InterceptResult invokeIL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i, list)) == null) {
            if (list != null) {
                int size = list.size();
                if (size == 0) {
                    return i;
                }
                if (this.a.length - this.f22258h <= size) {
                    d(size);
                }
                int i3 = this.f22258h;
                while (true) {
                    i2 = this.f22258h;
                    if (i3 >= i2 + size) {
                        break;
                    }
                    a aVar = list.get(i3 - i2);
                    aVar.s();
                    GLES20.glBindFramebuffer(36160, this.a[i3]);
                    GLES20.glViewport(0, 0, this.f22256f, this.f22257g);
                    float[] fArr = this.i;
                    GLES20.glClearColor(fArr[0], fArr[1], fArr[2], fArr[3]);
                    GLES20.glClear(16640);
                    aVar.p(i, this.f22253c, this.f22255e);
                    GLES20.glBindFramebuffer(36160, 0);
                    i = this.f22252b[i3];
                    i3++;
                }
                this.f22258h = i2 + size;
            }
            return i;
        }
        return invokeIL.intValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f22258h = 0;
        }
    }

    public void h(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            float[] fArr = this.i;
            fArr[0] = f2;
            fArr[1] = f3;
            fArr[2] = f4;
            fArr[3] = f5;
        }
    }
}
