package c.a.j.m;

import android.text.TextUtils;
import c.a.j.h.d.i;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.write.write.WriteActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.i1;
import com.kuaishou.weapon.un.w0;
import java.util.ArrayList;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
/* loaded from: classes.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f4149b;

    /* renamed from: c  reason: collision with root package name */
    public static final e f4150c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1357029693, "Lc/a/j/m/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1357029693, "Lc/a/j/m/e;");
                return;
            }
        }
        f4150c = new e();
        a = new int[]{219, 74, 195, 53, 166, 242, 116, 193, 174, 134, 57, Opcodes.ARETURN, 41, 16, 150, 94, WriteActivity.CONTENT_MAX_COUNT, 21, 62, 77, 117, 76, 201, w0.c1, 66, 209, 249, 34, 66, 113, 52, 203};
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.length() % 2 == 0) {
                try {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 1; i2 < str.length(); i2 += 2) {
                        arrayList.add(Byte.valueOf((byte) Integer.parseInt("" + str.charAt(i2 - 1) + "" + str.charAt(i2), CharsKt__CharJVMKt.checkRadix(16))));
                    }
                    if (arrayList.size() <= 16) {
                        return "";
                    }
                    if (f4149b == null) {
                        f4149b = new byte[a.length];
                        int length = a.length;
                        for (int i3 = 0; i3 < length; i3++) {
                            byte[] bArr = f4149b;
                            if (bArr == null) {
                                Intrinsics.throwNpe();
                            }
                            bArr[i3] = (byte) a[i3];
                        }
                    }
                    byte[] byteArray = CollectionsKt___CollectionsKt.toByteArray(arrayList.subList(0, 16));
                    byte[] bArr2 = f4149b;
                    if (bArr2 == null) {
                        Intrinsics.throwNpe();
                    }
                    String a2 = i.a(b(byteArray, bArr2, CollectionsKt___CollectionsKt.toByteArray(arrayList.subList(16, arrayList.size()))));
                    Intrinsics.checkExpressionValueIsNotNull(a2, "StringUtils.bytes2Str(decodeBytes)");
                    return a2;
                } catch (Exception unused) {
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public final byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, bArr2, bArr3)) == null) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance(i1.f57242c);
            cipher.init(2, secretKeySpec, new IvParameterSpec(bArr));
            return cipher.doFinal(bArr3);
        }
        return (byte[]) invokeLLL.objValue;
    }
}
