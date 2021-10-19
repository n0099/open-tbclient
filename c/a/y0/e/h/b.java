package c.a.y0.e.h;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f31309a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f31310b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f31311c;

    public b(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31309a = str;
        this.f31310b = z;
        this.f31311c = z2;
    }

    public static int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            return i2 != 5 ? -1 : 0;
                        }
                        return 1;
                    }
                    return 3;
                }
                return 4;
            }
            return 6;
        }
        return invokeI.intValue;
    }

    public String b(byte[] bArr) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (int i3 = 0; i3 < (bArr.length + 4) / 5; i3++) {
                short[] sArr = new short[5];
                int[] iArr = new int[8];
                int i4 = 5;
                for (int i5 = 0; i5 < 5; i5++) {
                    int i6 = (i3 * 5) + i5;
                    if (i6 < bArr.length) {
                        sArr[i5] = (short) (bArr[i6] & 255);
                    } else {
                        sArr[i5] = 0;
                        i4--;
                    }
                }
                int a2 = a(i4);
                iArr[0] = (byte) ((sArr[0] >> 3) & 31);
                iArr[1] = (byte) (((sArr[0] & 7) << 2) | ((sArr[1] >> 6) & 3));
                iArr[2] = (byte) ((sArr[1] >> 1) & 31);
                iArr[3] = (byte) (((sArr[1] & 1) << 4) | ((sArr[2] >> 4) & 15));
                iArr[4] = (byte) (((sArr[2] & 15) << 1) | ((sArr[3] >> 7) & 1));
                iArr[5] = (byte) ((sArr[3] >> 2) & 31);
                iArr[6] = (byte) (((sArr[4] >> 5) & 7) | ((sArr[3] & 3) << 3));
                iArr[7] = (byte) (sArr[4] & 31);
                int i7 = 0;
                while (true) {
                    i2 = 8 - a2;
                    if (i7 >= i2) {
                        break;
                    }
                    char charAt = this.f31309a.charAt(iArr[i7]);
                    if (this.f31311c) {
                        charAt = Character.toLowerCase(charAt);
                    }
                    byteArrayOutputStream.write(charAt);
                    i7++;
                }
                if (this.f31310b) {
                    while (i2 < 8) {
                        byteArrayOutputStream.write(61);
                        i2++;
                    }
                }
            }
            return new String(byteArrayOutputStream.toByteArray());
        }
        return (String) invokeL.objValue;
    }
}
