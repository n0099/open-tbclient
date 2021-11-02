package b.i.b.a.d0.w;

import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes6.dex */
public final class a implements b.i.b.a.h0.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final b.i.b.a.h0.e f32149a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f32150b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f32151c;

    /* renamed from: d  reason: collision with root package name */
    public CipherInputStream f32152d;

    public a(b.i.b.a.h0.e eVar, byte[] bArr, byte[] bArr2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, bArr, bArr2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32149a = eVar;
        this.f32150b = bArr;
        this.f32151c = bArr2;
    }

    @Override // b.i.b.a.h0.e
    public long a(b.i.b.a.h0.g gVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
                try {
                    cipher.init(2, new SecretKeySpec(this.f32150b, "AES"), new IvParameterSpec(this.f32151c));
                    this.f32152d = new CipherInputStream(new b.i.b.a.h0.f(this.f32149a, gVar), cipher);
                    return -1L;
                } catch (InvalidAlgorithmParameterException | InvalidKeyException e2) {
                    throw new RuntimeException(e2);
                }
            } catch (NoSuchAlgorithmException | NoSuchPaddingException e3) {
                throw new RuntimeException(e3);
            }
        }
        return invokeL.longValue;
    }

    @Override // b.i.b.a.h0.e
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f32152d = null;
            this.f32149a.close();
        }
    }

    @Override // b.i.b.a.h0.e
    public Uri getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32149a.getUri() : (Uri) invokeV.objValue;
    }

    @Override // b.i.b.a.h0.e
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i2, i3)) == null) {
            b.i.b.a.i0.a.f(this.f32152d != null);
            int read = this.f32152d.read(bArr, i2, i3);
            if (read < 0) {
                return -1;
            }
            return read;
        }
        return invokeLII.intValue;
    }
}
