package c.a.r.f.c;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[][] a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.r.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0239a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public byte[] a;

        public C0239a(byte[] bArr, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bArr, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bArr;
        }

        public byte[] a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (byte[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1873335598, "Lc/a/r/f/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1873335598, "Lc/a/r/f/c/a;");
                return;
            }
        }
        a = new byte[][]{new byte[]{0, 0}, new byte[]{0, 1}, new byte[]{0, 2}, new byte[]{1, 0}, new byte[]{1, 1}, new byte[]{1, 2}, new byte[]{2, 0}, new byte[]{2, 1}};
    }

    public static int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            int i3 = i2 % 3;
            char c2 = 1;
            if (i3 == 1) {
                i2 += 2;
                c2 = 2;
            } else if (i3 == 2) {
                i2++;
            } else {
                c2 = 0;
            }
            int i4 = (i2 / 3) * 2;
            return c2 > 0 ? i4 + 1 : i4;
        }
        return invokeI.intValue;
    }

    public static C0239a b(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            int length = (((bArr.length - 1) / 2) * 3) - (bArr.length % 2 != 0 ? bArr[bArr.length - 1] : 0);
            int i2 = length / 8;
            if (length % 8 > 0) {
                i2++;
            }
            byte[] bArr2 = new byte[i2];
            int i3 = 0;
            int i4 = 8;
            for (int i5 = 0; i5 < bArr.length - 1; i5 += 2) {
                byte b2 = (byte) (((bArr[i5] * 3) + bArr[i5 + 1]) & 255);
                for (int i6 = 2; i6 >= 0; i6--) {
                    if (i4 <= 0) {
                        i3++;
                        i4 = 8;
                    }
                    if (i3 >= i2) {
                        break;
                    }
                    bArr2[i3] = (byte) ((bArr2[i3] << 1) | ((b2 >> i6) & 1));
                    i4--;
                }
            }
            if (i4 > 0 && i3 < i2) {
                bArr2[i3] = (byte) (bArr2[i3] << i4);
            }
            return new C0239a(bArr2, length);
        }
        return (C0239a) invokeL.objValue;
    }

    public static byte[] c(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        int i3;
        byte b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, bArr, i2)) == null) {
            int i4 = i2 % 3;
            if (i4 == 1) {
                i3 = i2 + 2;
                b2 = 2;
            } else if (i4 == 2) {
                i3 = i2 + 1;
                b2 = 1;
            } else {
                i3 = i2;
                b2 = 0;
            }
            int i5 = (i3 / 3) * 2;
            if (b2 > 0) {
                i5++;
            }
            byte[] bArr2 = new byte[i5];
            int i6 = 0;
            int i7 = 0;
            for (byte b3 : bArr) {
                for (int i8 = 7; i8 >= 0; i8--) {
                    bArr2[i6] = (byte) ((bArr2[i6] << 1) | ((b3 >> i8) & 1));
                    if (i7 % 3 == 2) {
                        byte[][] bArr3 = a;
                        bArr2[i6 + 1] = bArr3[bArr2[i6]][1];
                        bArr2[i6] = bArr3[bArr2[i6]][0];
                        i6 += 2;
                    }
                    i7++;
                    if (i7 == i2) {
                        break;
                    }
                }
                if (i7 == i2) {
                    break;
                }
            }
            if (b2 > 0) {
                bArr2[i6] = (byte) (bArr2[i6] << b2);
                byte[][] bArr4 = a;
                bArr2[i6 + 1] = bArr4[bArr2[i6]][1];
                bArr2[i6] = bArr4[bArr2[i6]][0];
                bArr2[i6 + 2] = b2;
            }
            return bArr2;
        }
        return (byte[]) invokeLI.objValue;
    }
}
