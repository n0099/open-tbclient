package c.i.b.a.d0.w;

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
/* loaded from: classes4.dex */
public final class a implements c.i.b.a.h0.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c.i.b.a.h0.e f33320a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f33321b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f33322c;

    /* renamed from: d  reason: collision with root package name */
    public CipherInputStream f33323d;

    public a(c.i.b.a.h0.e eVar, byte[] bArr, byte[] bArr2) {
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
        this.f33320a = eVar;
        this.f33321b = bArr;
        this.f33322c = bArr2;
    }

    @Override // c.i.b.a.h0.e
    public long a(c.i.b.a.h0.g gVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
                try {
                    cipher.init(2, new SecretKeySpec(this.f33321b, "AES"), new IvParameterSpec(this.f33322c));
                    this.f33323d = new CipherInputStream(new c.i.b.a.h0.f(this.f33320a, gVar), cipher);
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

    @Override // c.i.b.a.h0.e
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f33323d = null;
            this.f33320a.close();
        }
    }

    @Override // c.i.b.a.h0.e
    public Uri getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33320a.getUri() : (Uri) invokeV.objValue;
    }

    @Override // c.i.b.a.h0.e
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i2, i3)) == null) {
            c.i.b.a.i0.a.f(this.f33323d != null);
            int read = this.f33323d.read(bArr, i2, i3);
            if (read < 0) {
                return -1;
            }
            return read;
        }
        return invokeLII.intValue;
    }
}
