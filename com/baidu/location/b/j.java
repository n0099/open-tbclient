package com.baidu.location.b;

import android.util.Base64;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.Jni;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes5.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public IvParameterSpec f40972a;

    /* renamed from: b  reason: collision with root package name */
    public SecretKeySpec f40973b;

    /* renamed from: c  reason: collision with root package name */
    public Cipher f40974c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f40975d;

    /* renamed from: com.baidu.location.b.j$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static j f40976a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(819911373, "Lcom/baidu/location/b/j$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(819911373, "Lcom/baidu/location/b/j$a;");
                    return;
                }
            }
            f40976a = new j(null);
        }
    }

    public j() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f40975d = false;
        try {
            String str = Jni.getldkaiv();
            if (str == null || !str.contains("|")) {
                return;
            }
            String[] split = str.split("\\|");
            this.f40972a = new IvParameterSpec(split[1].getBytes("UTF-8"));
            this.f40973b = new SecretKeySpec(split[0].getBytes("UTF-8"), "AES");
            this.f40974c = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            this.f40975d = true;
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
        } catch (NoSuchPaddingException e4) {
            e4.printStackTrace();
        }
    }

    public /* synthetic */ j(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static j a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f40976a : (j) invokeV.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.f40975d) {
                try {
                    this.f40974c.init(2, this.f40973b, this.f40972a);
                    return new String(this.f40974c.doFinal(Base64.decode(str, 0)), "UTF-8");
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f40975d : invokeV.booleanValue;
    }
}
