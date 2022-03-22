package com.baidu.bdtask.service.cache.storage.encrypter.aes;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u0013:\u0001\u0013B\u0019\b\u0002\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/baidu/bdtask/service/cache/storage/encrypter/aes/AEStorageEncrypter;", "", "data", "decrypt", "([B)[B", "encrypt", "", "mode", "", "initCipher", "(I)V", "Ljavax/crypto/Cipher;", "cipher", "Ljavax/crypto/Cipher;", "Ljava/security/Key;", "cipherKey", "Ljava/security/Key;", "<init>", "(Ljavax/crypto/Cipher;Ljava/security/Key;)V", "Companion", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f24955c;

    /* renamed from: d  reason: collision with root package name */
    public static byte[] f24956d;

    /* renamed from: e  reason: collision with root package name */
    public static final C1736a f24957e;
    public transient /* synthetic */ FieldHolder $fh;
    public final Cipher a;

    /* renamed from: b  reason: collision with root package name */
    public final Key f24958b;

    /* renamed from: com.baidu.bdtask.service.cache.storage.encrypter.aes.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C1736a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1736a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (e() == null) {
                    c(new byte[d().length]);
                    int length = d().length;
                    for (int i = 0; i < length; i++) {
                        byte[] e2 = e();
                        if (e2 == null) {
                            Intrinsics.throwNpe();
                        }
                        e2[i] = (byte) d()[i];
                    }
                }
                SecretKeySpec secretKeySpec = new SecretKeySpec(e(), "AES");
                Cipher cipher = Cipher.getInstance("AES");
                Intrinsics.checkExpressionValueIsNotNull(cipher, "Cipher.getInstance(TRANSFORMATION)");
                return b(cipher, secretKeySpec);
            }
            return (a) invokeV.objValue;
        }

        public final a b(Cipher cipher, Key key) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cipher, key)) == null) ? new a(cipher, key, null) : (a) invokeLL.objValue;
        }

        public final void c(byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr) == null) {
                a.f24956d = bArr;
            }
        }

        public final int[] d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? a.f24955c : (int[]) invokeV.objValue;
        }

        public final byte[] e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? a.f24956d : (byte[]) invokeV.objValue;
        }

        public /* synthetic */ C1736a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-186976340, "Lcom/baidu/bdtask/service/cache/storage/encrypter/aes/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-186976340, "Lcom/baidu/bdtask/service/cache/storage/encrypter/aes/a;");
                return;
            }
        }
        f24957e = new C1736a(null);
        f24955c = new int[]{40, 114, -31, -94, OneKeyLoginResult.ONE_KEY_LOGIN_CODE_NOT_MEET_GRAY, -82, -95, -82, -96, 126, -85, 0, -116, -104, 44, -39};
    }

    public a(Cipher cipher, Key key) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cipher, key};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = cipher;
        this.f24958b = key;
    }

    public final void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.a.init(i, this.f24958b);
        }
    }

    public byte[] b(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr)) == null) {
            try {
                Cipher cipher = this.a;
                a(1);
                byte[] doFinal = cipher.doFinal(bArr);
                Intrinsics.checkExpressionValueIsNotNull(doFinal, "doFinal(data)");
                Intrinsics.checkExpressionValueIsNotNull(doFinal, "cipher.run {\n           …Final(data)\n            }");
                return doFinal;
            } catch (Throwable th) {
                DebugTrace.a.c(new AEStorageEncrypter$encrypt$2(th));
                return new byte[0];
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public byte[] e(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr)) == null) {
            try {
                if (bArr.length == 0) {
                    return bArr;
                }
                Cipher cipher = this.a;
                a(2);
                byte[] doFinal = cipher.doFinal(bArr);
                Intrinsics.checkExpressionValueIsNotNull(doFinal, "cipher.run {\n           …l(data)\n                }");
                return doFinal;
            } catch (Throwable th) {
                DebugTrace.a.c(new AEStorageEncrypter$decrypt$2(th));
                return new byte[0];
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public /* synthetic */ a(Cipher cipher, Key key, DefaultConstructorMarker defaultConstructorMarker) {
        this(cipher, key);
    }
}
