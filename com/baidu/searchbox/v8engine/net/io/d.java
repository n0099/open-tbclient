package com.baidu.searchbox.v8engine.net.io;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.Arrays;
/* loaded from: classes4.dex */
public class d implements Serializable, Comparable<d> {
    public static /* synthetic */ Interceptable $ic;
    public static final char[] a;

    /* renamed from: b  reason: collision with root package name */
    public static final d f28687b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f28688c;

    /* renamed from: d  reason: collision with root package name */
    public transient int f28689d;

    /* renamed from: e  reason: collision with root package name */
    public transient String f28690e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-351173027, "Lcom/baidu/searchbox/v8engine/net/io/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-351173027, "Lcom/baidu/searchbox/v8engine/net/io/d;");
                return;
            }
        }
        a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        f28687b = a(new byte[0]);
    }

    public d(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f28688c = bArr;
    }

    public static d a(byte... bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            if (bArr != null) {
                return new d((byte[]) bArr.clone());
            }
            throw new IllegalArgumentException("data == null");
        }
        return (d) invokeL.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            byte[] bArr = this.f28688c;
            char[] cArr = new char[bArr.length * 2];
            int i = 0;
            for (byte b2 : bArr) {
                int i2 = i + 1;
                char[] cArr2 = a;
                cArr[i] = cArr2[(b2 >> 4) & 15];
                i = i2 + 1;
                cArr[i2] = cArr2[b2 & 15];
            }
            return new String(cArr);
        }
        return (String) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f28688c.length : invokeV.intValue;
    }

    public byte[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (byte[]) this.f28688c.clone() : (byte[]) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof d) {
                d dVar = (d) obj;
                int c2 = dVar.c();
                byte[] bArr = this.f28688c;
                if (c2 == bArr.length && dVar.a(0, bArr, 0, bArr.length)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            int i = this.f28689d;
            if (i != 0) {
                return i;
            }
            int hashCode = Arrays.hashCode(this.f28688c);
            this.f28689d = hashCode;
            return hashCode;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.f28688c.length == 0) {
                return "[size=0]";
            }
            String a2 = a();
            int a3 = a(a2, 64);
            if (a3 == -1) {
                if (this.f28688c.length <= 64) {
                    return "[hex=" + b() + PreferencesUtil.RIGHT_MOUNT;
                }
                return "[size=" + this.f28688c.length + " hex=" + a(0, 64).b() + "…]";
            }
            String replace = a2.substring(0, a3).replace(IStringUtil.WINDOWS_FOLDER_SEPARATOR, "\\\\").replace("\n", "\\n").replace("\r", "\\r");
            if (a3 < a2.length()) {
                sb = new StringBuilder();
                sb.append("[size=");
                sb.append(this.f28688c.length);
                sb.append(" text=");
                sb.append(replace);
                sb.append("…]");
            } else {
                sb = new StringBuilder();
                sb.append("[text=");
                sb.append(replace);
                sb.append(PreferencesUtil.RIGHT_MOUNT);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String str = this.f28690e;
            if (str != null) {
                return str;
            }
            String str2 = new String(this.f28688c, com.baidu.searchbox.v8engine.net.b.a);
            this.f28690e = str2;
            return str2;
        }
        return (String) invokeV.objValue;
    }

    public d a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2)) == null) {
            if (i >= 0) {
                byte[] bArr = this.f28688c;
                if (i2 > bArr.length) {
                    throw new IllegalArgumentException("endIndex > length(" + this.f28688c.length + SmallTailInfo.EMOTION_SUFFIX);
                }
                int i3 = i2 - i;
                if (i3 >= 0) {
                    if (i == 0 && i2 == bArr.length) {
                        return this;
                    }
                    byte[] bArr2 = new byte[i3];
                    System.arraycopy(this.f28688c, i, bArr2, 0, i3);
                    return new d(bArr2);
                }
                throw new IllegalArgumentException("endIndex < beginIndex");
            }
            throw new IllegalArgumentException("beginIndex < 0");
        }
        return (d) invokeII.objValue;
    }

    public byte a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? this.f28688c[i] : invokeI.byteValue;
    }

    public boolean a(int i, d dVar, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), dVar, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) ? dVar.a(i2, this.f28688c, i, i3) : invokeCommon.booleanValue;
    }

    public boolean a(int i, byte[] bArr, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), bArr, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (i >= 0) {
                byte[] bArr2 = this.f28688c;
                if (i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && j.a(bArr2, i, bArr, i2, i3)) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar)) == null) {
            int c2 = c();
            int c3 = dVar.c();
            int min = Math.min(c2, c3);
            for (int i = 0; i < min; i++) {
                int a2 = a(i) & 255;
                int a3 = dVar.a(i) & 255;
                if (a2 != a3) {
                    return a2 < a3 ? -1 : 1;
                }
            }
            if (c2 == c3) {
                return 0;
            }
            return c2 < c3 ? -1 : 1;
        }
        return invokeL.intValue;
    }

    public static int a(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            int length = str.length();
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                if (i3 == i) {
                    return i2;
                }
                int codePointAt = str.codePointAt(i2);
                if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                    return -1;
                }
                i3++;
                i2 += Character.charCount(codePointAt);
            }
            return str.length();
        }
        return invokeLI.intValue;
    }
}
