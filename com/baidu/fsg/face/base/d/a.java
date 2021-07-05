package com.baidu.fsg.face.base.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f5611a = "UTF-8";

    /* renamed from: b  reason: collision with root package name */
    public static final String f5612b = "AES/CBC/NoPadding";

    /* renamed from: c  reason: collision with root package name */
    public static final String f5613c = "AES";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public String f5614d;

    /* renamed from: e  reason: collision with root package name */
    public String f5615e;

    /* renamed from: f  reason: collision with root package name */
    public String f5616f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a() {
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
                    IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes(this.f5614d));
                    SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), this.f5616f);
                    Cipher cipher = Cipher.getInstance(this.f5615e);
                    cipher.init(1, secretKeySpec, ivParameterSpec);
                    return cipher.doFinal(a(str).getBytes());
                } catch (NoSuchAlgorithmException e2) {
                    d.a(e2);
                    return null;
                } catch (NoSuchPaddingException e3) {
                    d.a(e3);
                    return null;
                }
            }
            throw new Exception("Empty string");
        }
        return (byte[]) invokeLLL.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(String str, String str2) {
        this(str, str2, "UTF-8");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (String) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f5614d = "UTF-8";
        this.f5615e = "AES/CBC/NoPadding";
        this.f5616f = "AES";
        this.f5616f = str;
        this.f5615e = str2;
        this.f5614d = str3;
    }

    public byte[] a(byte[] bArr, String str, String str2) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, str, str2)) == null) {
            if (bArr != null && bArr.length != 0) {
                byte[] bArr2 = new byte[0];
                try {
                    IvParameterSpec ivParameterSpec = new IvParameterSpec(str.getBytes(this.f5614d));
                    SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), this.f5616f);
                    Cipher cipher = Cipher.getInstance(this.f5615e);
                    cipher.init(2, secretKeySpec, ivParameterSpec);
                    return cipher.doFinal(bArr);
                } catch (Throwable th) {
                    d.a(th);
                    return bArr2;
                }
            }
            throw new Exception("Empty string");
        }
        return (byte[]) invokeLLL.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            int length = 16 - (str.length() % 16);
            for (int i2 = 0; i2 < length; i2++) {
                str = str + ' ';
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
