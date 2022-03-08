package c.a.m.j.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
/* loaded from: classes.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static volatile byte[] a;
    public transient /* synthetic */ FieldHolder $fh;

    public g() {
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

    public static byte[] a() throws InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (g.class) {
                    if (a == null) {
                        byte[] bArr = new byte[16];
                        System.arraycopy(c.a.m.j.c.b.a(), 0, bArr, 0, 16);
                        c cVar = new c();
                        cVar.a(2, bArr, bArr);
                        a = cVar.b(new byte[]{-71, -100, -115, 26, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, -124, 14, 14, -31, -46, -56, 1, 25, -127, -99, -107, -54, 51, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, 14, 68, -68, -19, 28, 66, 19, -113, 5, 25, -11, -123, 50});
                    }
                }
            }
            return a;
        }
        return (byte[]) invokeV.objValue;
    }
}
