package c.a.l.j.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.crypto.ShortBufferException;
/* loaded from: classes.dex */
public final class h implements i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    public h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i2;
    }

    @Override // c.a.l.j.a.i
    public int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int i3 = this.a;
            return i3 - (i2 % i3);
        }
        return invokeI.intValue;
    }

    @Override // c.a.l.j.a.i
    public int a(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i2, i3)) == null) {
            if (bArr == null || i3 == 0) {
                return 0;
            }
            int i5 = i3 + i2;
            int i6 = bArr[i5 - 1];
            int i7 = i6 & 255;
            if (i7 < 1 || i7 > this.a || (i4 = i5 - i7) < i2) {
                return -1;
            }
            for (int i8 = 0; i8 < i7; i8++) {
                if (bArr[i4 + i8] != i6) {
                    return -1;
                }
            }
            return i4;
        }
        return invokeLII.intValue;
    }

    @Override // c.a.l.j.a.i
    public void b(byte[] bArr, int i2, int i3) throws ShortBufferException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, bArr, i2, i3) == null) || bArr == null) {
            return;
        }
        if (i2 + i3 > bArr.length) {
            throw new ShortBufferException("Buffer too small to hold padding");
        }
        byte b2 = (byte) (i3 & 255);
        for (int i4 = 0; i4 < i3; i4++) {
            bArr[i4 + i2] = b2;
        }
    }
}
