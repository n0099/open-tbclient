package c.a.t0.k0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.codec.binary4util.bdapp.Base64InputStream;
/* loaded from: classes4.dex */
public class b extends Base64InputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30048e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f30049f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(InputStream inputStream, int i2) {
        super(inputStream, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((InputStream) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30048e = false;
        this.f30049f = false;
    }

    @Override // org.apache.commons.codec.binary4util.bdapp.Base64InputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int read = super.read();
            if (!this.f30048e && read == 117) {
                this.f30048e = true;
                return 31;
            } else if (this.f30049f || read != 123) {
                return read;
            } else {
                this.f30049f = true;
                return 139;
            }
        }
        return invokeV.intValue;
    }

    @Override // org.apache.commons.codec.binary4util.bdapp.Base64InputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i2, i3)) == null) {
            int read = super.read(bArr, i2, i3);
            if (!this.f30048e && read >= 2) {
                bArr[i2] = 31;
                bArr[i2 + 1] = -117;
                this.f30048e = true;
            }
            return read;
        }
        return invokeLII.intValue;
    }
}
