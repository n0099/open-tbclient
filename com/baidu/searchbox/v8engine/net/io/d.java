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
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes7.dex */
public class d implements Serializable, Comparable<d> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f43795a;

    /* renamed from: b  reason: collision with root package name */
    public static final d f43796b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f43797c;

    /* renamed from: d  reason: collision with root package name */
    public transient int f43798d;

    /* renamed from: e  reason: collision with root package name */
    public transient String f43799e;

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
        f43795a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        f43796b = a(new byte[0]);
    }

    public d(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f43797c = bArr;
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
            byte[] bArr = this.f43797c;
            char[] cArr = new char[bArr.length * 2];
            int i2 = 0;
            for (byte b2 : bArr) {
                int i3 = i2 + 1;
                char[] cArr2 = f43795a;
                cArr[i2] = cArr2[(b2 >> 4) & 15];
                i2 = i3 + 1;
                cArr[i3] = cArr2[b2 & 15];
            }
            return new String(cArr);
        }
        return (String) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f43797c.length : invokeV.intValue;
    }

    public byte[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (byte[]) this.f43797c.clone() : (byte[]) invokeV.objValue;
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
                byte[] bArr = this.f43797c;
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
            int i2 = this.f43798d;
            if (i2 != 0) {
                return i2;
            }
            int hashCode = Arrays.hashCode(this.f43797c);
            this.f43798d = hashCode;
            return hashCode;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.f43797c.length == 0) {
                return "[size=0]";
            }
            String a2 = a();
            int a3 = a(a2, 64);
            if (a3 == -1) {
                if (this.f43797c.length <= 64) {
                    return "[hex=" + b() + PreferencesUtil.RIGHT_MOUNT;
                }
                return "[size=" + this.f43797c.length + " hex=" + a(0, 64).b() + "…]";
            }
            String replace = a2.substring(0, a3).replace(IStringUtil.WINDOWS_FOLDER_SEPARATOR, "\\\\").replace(StringUtils.LF, "\\n").replace(StringUtils.CR, "\\r");
            if (a3 < a2.length()) {
                sb = new StringBuilder();
                sb.append("[size=");
                sb.append(this.f43797c.length);
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
            String str = this.f43799e;
            if (str != null) {
                return str;
            }
            String str2 = new String(this.f43797c, com.baidu.searchbox.v8engine.net.b.f43791a);
            this.f43799e = str2;
            return str2;
        }
        return (String) invokeV.objValue;
    }

    public d a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3)) == null) {
            if (i2 >= 0) {
                byte[] bArr = this.f43797c;
                if (i3 > bArr.length) {
                    throw new IllegalArgumentException("endIndex > length(" + this.f43797c.length + SmallTailInfo.EMOTION_SUFFIX);
                }
                int i4 = i3 - i2;
                if (i4 >= 0) {
                    if (i2 == 0 && i3 == bArr.length) {
                        return this;
                    }
                    byte[] bArr2 = new byte[i4];
                    System.arraycopy(this.f43797c, i2, bArr2, 0, i4);
                    return new d(bArr2);
                }
                throw new IllegalArgumentException("endIndex < beginIndex");
            }
            throw new IllegalArgumentException("beginIndex < 0");
        }
        return (d) invokeII.objValue;
    }

    public byte a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f43797c[i2] : invokeI.byteValue;
    }

    public boolean a(int i2, d dVar, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), dVar, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) ? dVar.a(i3, this.f43797c, i2, i4) : invokeCommon.booleanValue;
    }

    public boolean a(int i2, byte[] bArr, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), bArr, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (i2 >= 0) {
                byte[] bArr2 = this.f43797c;
                if (i2 <= bArr2.length - i4 && i3 >= 0 && i3 <= bArr.length - i4 && j.a(bArr2, i2, bArr, i3, i4)) {
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
            for (int i2 = 0; i2 < min; i2++) {
                int a2 = a(i2) & 255;
                int a3 = dVar.a(i2) & 255;
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

    public static int a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i2)) == null) {
            int length = str.length();
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                if (i4 == i2) {
                    return i3;
                }
                int codePointAt = str.codePointAt(i3);
                if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                    return -1;
                }
                i4++;
                i3 += Character.charCount(codePointAt);
            }
            return str.length();
        }
        return invokeLI.intValue;
    }
}
