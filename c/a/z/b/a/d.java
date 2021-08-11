package c.a.z.b.a;

import android.opengl.GLES20;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.Rotation;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends c.a.z.b.a.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static String G = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n";
    public static int[] H;
    public static int I;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] A;
    public int[] B;
    public int[] C;
    public FloatBuffer D;
    public List<Integer> E;
    public int F;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f31058e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f31059f;

        public a(d dVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31059f = dVar;
            this.f31058e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f31059f.E = this.f31058e;
                for (int i2 = 0; i2 < this.f31058e.size(); i2++) {
                    this.f31059f.C[i2] = ((Integer) this.f31058e.get(i2)).intValue();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-930330899, "Lc/a/z/b/a/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-930330899, "Lc/a/z/b/a/d;");
                return;
            }
        }
        H = new int[]{33987, 33988, 33989, 33990, 33991, 33992, 33993, 33994, 33995, 33996};
        I = 1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(String str, String str2) {
        super(str, str2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.F = 3553;
        if (!TextUtils.isEmpty(str2) && str2.contains("samplerExternalOES")) {
            this.F = 36197;
        }
        int i4 = I;
        this.A = new int[i4];
        this.B = new int[i4];
        this.C = new int[i4];
        for (int i5 = 0; i5 < I; i5++) {
            this.C[i5] = -1;
        }
        this.D = ByteBuffer.allocateDirect(i.f31080a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        X(Rotation.NORMAL, false, false);
    }

    public static String W(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) {
            if (I <= H.length) {
                I = i2;
                StringBuilder sb = new StringBuilder(G);
                for (int i3 = 0; i3 < i2; i3++) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("attribute vec4 inputTextureCoordinate");
                    int i4 = i3 + 2;
                    sb2.append(i4);
                    sb.append(sb2.toString());
                    sb.append(";\n");
                    sb.append("varying vec2 textureCoordinate" + i4);
                    sb.append(";\n");
                }
                sb.append("\nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n");
                for (int i5 = 0; i5 < i2; i5++) {
                    sb.append("    ");
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("textureCoordinate");
                    int i6 = i5 + 2;
                    sb3.append(i6);
                    sb.append(sb3.toString());
                    sb.append(" = ");
                    sb.append("inputTextureCoordinate" + i6);
                    sb.append(".xy");
                    sb.append(";\n");
                }
                sb.append("}");
                return sb.toString();
            }
            throw new RuntimeException("too many textures !!!");
        }
        return (String) invokeI.objValue;
    }

    public void X(Rotation rotation, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{rotation, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.D.clear();
            this.D.put(i.b(rotation, z, z2)).position(0);
        }
    }

    public void Y(List<Integer> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || list == null || list.size() == 0) {
            return;
        }
        B(new a(this, list));
    }

    @Override // c.a.z.b.a.a
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
            return;
        }
        int i2 = 0;
        while (true) {
            int[] iArr = this.A;
            if (i2 >= iArr.length) {
                return;
            }
            GLES20.glDisableVertexAttribArray(iArr[i2]);
            i2++;
        }
    }

    @Override // c.a.z.b.a.a
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048579, this) != null) {
            return;
        }
        int i2 = 0;
        while (true) {
            int[] iArr = this.A;
            if (i2 >= iArr.length) {
                return;
            }
            if (this.C[i2] != -1) {
                GLES20.glEnableVertexAttribArray(iArr[i2]);
                GLES20.glActiveTexture(H[i2]);
                GLES20.glBindTexture(this.F, this.C[i2]);
                GLES20.glUniform1i(this.B[i2], i2 + 3);
                this.D.position(0);
                GLES20.glVertexAttribPointer(this.A[i2], 2, 5126, false, 0, (Buffer) this.D);
            }
            i2++;
        }
    }

    @Override // c.a.z.b.a.a
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // c.a.z.b.a.a
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048581, this) != null) {
            return;
        }
        super.t();
        int i2 = 0;
        while (true) {
            int[] iArr = this.A;
            if (i2 >= iArr.length) {
                return;
            }
            int j2 = j();
            StringBuilder sb = new StringBuilder();
            sb.append("inputTextureCoordinate");
            int i3 = i2 + 2;
            sb.append(i3);
            iArr[i2] = GLES20.glGetAttribLocation(j2, sb.toString());
            int[] iArr2 = this.B;
            int j3 = j();
            iArr2[i2] = GLES20.glGetUniformLocation(j3, "inputImageTexture" + i3);
            i2++;
        }
    }

    @Override // c.a.z.b.a.a
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.u();
            List<Integer> list = this.E;
            if (list != null) {
                Y(list);
            }
        }
    }
}
