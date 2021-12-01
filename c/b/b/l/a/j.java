package c.b.b.l.a;

import android.annotation.TargetApi;
import android.opengl.GLES30;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.Buffer;
import java.nio.IntBuffer;
@TargetApi(18)
/* loaded from: classes7.dex */
public class j extends i implements c.b.b.n.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public j() {
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

    @Override // c.b.b.n.d
    public void A(int i2, IntBuffer intBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, intBuffer) == null) {
            GLES30.glDeleteVertexArrays(i2, intBuffer);
        }
    }

    @Override // c.b.b.n.d
    public void O(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, Buffer buffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), buffer}) == null) {
            if (buffer == null) {
                GLES30.glTexImage3D(i2, i3, i4, i5, i6, i7, i8, i9, i10, 0);
            } else {
                GLES30.glTexImage3D(i2, i3, i4, i5, i6, i7, i8, i9, i10, buffer);
            }
        }
    }

    @Override // c.b.b.n.d
    public void c(int i2, IntBuffer intBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, intBuffer) == null) {
            GLES30.glDrawBuffers(i2, intBuffer);
        }
    }

    @Override // c.b.b.n.d
    public void v(int i2, IntBuffer intBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, intBuffer) == null) {
            GLES30.glGenVertexArrays(i2, intBuffer);
        }
    }
}
