package com.baidu.mobads.cid.cesium.c.d;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
/* loaded from: classes5.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final Map<String, byte[]> f42869e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f42870a;

    /* renamed from: b  reason: collision with root package name */
    public final int f42871b;

    /* renamed from: c  reason: collision with root package name */
    public SecureRandom f42872c;

    /* renamed from: d  reason: collision with root package name */
    public final int f42873d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1962342217, "Lcom/baidu/mobads/cid/cesium/c/d/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1962342217, "Lcom/baidu/mobads/cid/cesium/c/d/f;");
                return;
            }
        }
        f42869e = Collections.synchronizedMap(new HashMap());
    }

    public f(int i2, int i3, SecureRandom secureRandom) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), secureRandom};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f42870a = i2;
        this.f42871b = i3;
        this.f42872c = secureRandom;
        if (i3 < 64) {
            throw new InvalidKeyException("Padded size must be at least 64");
        }
        if (i2 == 1 || i2 == 2) {
            i3 -= 11;
        } else if (i2 != 3) {
            throw new InvalidKeyException("Invalid padding: " + i2);
        }
        this.f42873d = i3;
    }

    public static f a(int i2, int i3, SecureRandom secureRandom) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(65538, null, i2, i3, secureRandom)) == null) ? new f(i2, i3, secureRandom) : (f) invokeIIL.objValue;
    }

    private byte[] c(byte[] bArr) {
        InterceptResult invokeL;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, bArr)) == null) {
            int i4 = this.f42871b;
            byte[] bArr2 = new byte[i4];
            System.arraycopy(bArr, 0, bArr2, i4 - bArr.length, bArr.length);
            int length = (this.f42871b - 3) - bArr.length;
            bArr2[0] = 0;
            int i5 = this.f42870a;
            bArr2[1] = (byte) i5;
            int i6 = -1;
            int i7 = 2;
            if (i5 != 1) {
                if (this.f42872c == null) {
                    this.f42872c = b.f42858a;
                }
                byte[] bArr3 = new byte[64];
                while (true) {
                    int i8 = length - 1;
                    if (length <= 0) {
                        break;
                    }
                    while (true) {
                        if (i6 < 0) {
                            this.f42872c.nextBytes(bArr3);
                            i6 = 63;
                        }
                        i2 = i6 - 1;
                        i3 = bArr3[i6] & 255;
                        if (i3 != 0) {
                            break;
                        }
                        i6 = i2;
                    }
                    bArr2[i7] = (byte) i3;
                    i6 = i2;
                    length = i8;
                    i7++;
                }
            } else {
                while (true) {
                    int i9 = length - 1;
                    if (length <= 0) {
                        break;
                    }
                    bArr2[i7] = -1;
                    i7++;
                    length = i9;
                }
            }
            return bArr2;
        }
        return (byte[]) invokeL.objValue;
    }

    private byte[] d(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        if (bArr[0] != 0) {
            throw new BadPaddingException("Data must start with zero");
        }
        int i2 = 2;
        if (bArr[1] != this.f42870a) {
            throw new BadPaddingException("Blocktype mismatch: " + ((int) bArr[1]));
        }
        while (true) {
            int i3 = i2 + 1;
            int i4 = bArr[i2] & 255;
            if (i4 == 0) {
                int length = bArr.length - i3;
                if (length <= this.f42873d) {
                    byte[] bArr2 = new byte[length];
                    System.arraycopy(bArr, bArr.length - length, bArr2, 0, length);
                    return bArr2;
                }
                throw new BadPaddingException("Padding string too short");
            } else if (i3 == bArr.length) {
                throw new BadPaddingException("Padding string not terminated");
            } else {
                if (this.f42870a == 1 && i4 != 255) {
                    throw new BadPaddingException("Padding byte not 0xff: " + i4);
                }
                i2 = i3;
            }
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f42873d : invokeV.intValue;
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr)) == null) {
            if (bArr.length > this.f42873d) {
                throw new BadPaddingException("Data must be shorter than " + (this.f42873d + 1) + " bytes");
            }
            int i2 = this.f42870a;
            if (i2 == 1 || i2 == 2) {
                return c(bArr);
            }
            if (i2 == 3) {
                return bArr;
            }
            throw new AssertionError();
        }
        return (byte[]) invokeL.objValue;
    }

    public byte[] a(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, bArr, i2, i3)) == null) ? a(b.a(bArr, i2, i3)) : (byte[]) invokeLII.objValue;
    }

    public byte[] b(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bArr)) == null) {
            if (bArr.length != this.f42871b) {
                throw new BadPaddingException("Padded length must be " + this.f42871b);
            }
            int i2 = this.f42870a;
            if (i2 == 1 || i2 == 2) {
                return d(bArr);
            }
            if (i2 == 3) {
                return bArr;
            }
            throw new AssertionError();
        }
        return (byte[]) invokeL.objValue;
    }
}
