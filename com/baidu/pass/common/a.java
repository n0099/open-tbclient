package com.baidu.pass.common;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f9305a = "Security";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.pass.common.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0135a {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static final String f9306a = "UTF-8";

        /* renamed from: b  reason: collision with root package name */
        public static final String f9307b = "AES/CBC/NoPadding";

        /* renamed from: c  reason: collision with root package name */
        public static final String f9308c = "AES";
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public String f9309d;

        /* renamed from: e  reason: collision with root package name */
        public String f9310e;

        /* renamed from: f  reason: collision with root package name */
        public String f9311f;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public C0135a() {
            this("AES", "AES/CBC/NoPadding", "UTF-8");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr = newInitContext.callArgs;
                    this((String) objArr[0], (String) objArr[1], (String) objArr[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public byte[] a(String str, String str2, String str3) throws Exception {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, str2, str3)) == null) {
                if (str != null && str.length() != 0) {
                    try {
                        IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes(this.f9309d));
                        SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), this.f9311f);
                        Cipher cipher = Cipher.getInstance(this.f9310e);
                        cipher.init(1, secretKeySpec, ivParameterSpec);
                        return cipher.doFinal(a(str).getBytes());
                    } catch (NoSuchAlgorithmException e2) {
                        Log.e(e2);
                        return null;
                    } catch (NoSuchPaddingException e3) {
                        Log.e(e3);
                        return null;
                    }
                }
                throw new Exception("Empty string");
            }
            return (byte[]) invokeLLL.objValue;
        }

        public C0135a(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f9309d = "UTF-8";
            this.f9310e = "AES/CBC/NoPadding";
            this.f9311f = "AES";
            this.f9311f = str;
            this.f9310e = str2;
            this.f9309d = str3;
        }

        public byte[] a(byte[] bArr, String str, String str2) throws Exception {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, str, str2)) == null) {
                if (bArr != null && bArr.length != 0) {
                    byte[] bArr2 = new byte[0];
                    try {
                        IvParameterSpec ivParameterSpec = new IvParameterSpec(str.getBytes(this.f9309d));
                        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), this.f9311f);
                        Cipher cipher = Cipher.getInstance(this.f9310e);
                        cipher.init(2, secretKeySpec, ivParameterSpec);
                        return cipher.doFinal(bArr);
                    } catch (Throwable th) {
                        Log.e(th);
                        return bArr2;
                    }
                }
                throw new Exception("Empty string");
            }
            return (byte[]) invokeLLL.objValue;
        }

        private String a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
                int length = 16 - (str.getBytes().length % 16);
                for (int i2 = 0; i2 < length; i2++) {
                    str = str + ' ';
                }
                return str;
            }
            return (String) invokeL.objValue;
        }
    }

    public a() {
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

    public String a(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, z)) == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.reset();
                messageDigest.update(bArr);
                return a(messageDigest.digest(), "", z);
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
        return (String) invokeLZ.objValue;
    }

    private String a(byte[] bArr, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65537, this, bArr, str, z)) == null) {
            StringBuilder sb = new StringBuilder();
            try {
                for (byte b2 : bArr) {
                    String hexString = Integer.toHexString(b2 & 255);
                    if (z) {
                        hexString = hexString.toUpperCase();
                    }
                    if (hexString.length() == 1) {
                        sb.append("0");
                    }
                    sb.append(hexString);
                    sb.append(str);
                }
            } catch (Exception unused) {
                Log.e(f9305a, "toHexString is error");
            }
            return sb.toString();
        }
        return (String) invokeLLZ.objValue;
    }

    public String a(byte[] bArr) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
            if (bArr == null || bArr.length == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            int length = bArr.length * 8;
            int i3 = 0;
            int i4 = 6;
            int i5 = 0;
            int i6 = 0;
            byte b2 = 0;
            do {
                if (i3 > 0 && i4 > 0) {
                    int i7 = (bArr[i5] & 255) << i4;
                    int i8 = 8 - i4;
                    b2 = (byte) (((byte) (i7 | ((bArr[i5 + 1] & 255) >> i8))) & 63);
                    i4 = 6 - i8;
                    i3 = i8;
                } else if (i3 == 0) {
                    b2 = (byte) ((bArr[i5] & 255) >> (8 - i4));
                    i3 = 2;
                    i4 = 4;
                } else if (i4 == 0) {
                    b2 = (byte) (bArr[i5] & 63);
                    i3 = 0;
                    i4 = 6;
                }
                sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(b2));
                i6 += 6;
                i5 = i6 / 8;
                i2 = length - i6;
            } while (i2 >= 6);
            if (i2 > 0) {
                sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((byte) ((bArr[bArr.length - 1] << (6 - i2)) & 63)));
            }
            int i9 = length % 3;
            for (int i10 = 0; i10 < i9; i10++) {
                sb.append("=");
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }
}
