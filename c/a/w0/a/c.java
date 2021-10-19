package c.a.w0.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes4.dex */
public class c implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PublicKey f30624a;

    public c(String str) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b(str);
    }

    @Override // c.a.w0.a.a
    public String a(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!c.a.w0.c.a.a(str)) {
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(1, this.f30624a);
                return c.a.w0.b.a.r(cipher.doFinal(str.getBytes()));
            }
            throw new Exception("Plaintext can not be blank.");
        }
        return (String) invokeL.objValue;
    }

    public final void b(String str) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (!c.a.w0.c.a.a(str)) {
                this.f30624a = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(c.a.w0.b.a.n(str.replaceAll("-----BEGIN PUBLIC KEY-----", "").replaceAll("-----END PUBLIC KEY-----", ""))));
                return;
            }
            throw new Exception("PubKey can not be blank.");
        }
    }
}
