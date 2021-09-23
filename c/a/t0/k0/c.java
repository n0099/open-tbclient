package c.a.t0.k0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.codec.binary4util.bdapp.Base64OutputStream;
/* loaded from: classes4.dex */
public class c extends Base64OutputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30071e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f30072f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(OutputStream outputStream, int i2) {
        super(outputStream, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {outputStream, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((OutputStream) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30071e = false;
        this.f30072f = false;
    }

    @Override // org.apache.commons.codec.binary4util.bdapp.Base64OutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i2, i3) == null) {
            if (this.f30071e && !this.f30072f && i3 > 0 && bArr.length - i2 > 0) {
                bArr[i2] = LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_2;
                this.f30072f = true;
            } else if (!this.f30071e && i3 == 1 && bArr.length - i2 > 0) {
                bArr[i2] = LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1;
                this.f30071e = true;
            } else if (!this.f30071e && i3 > 1 && bArr.length - i2 > 1) {
                bArr[i2] = LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1;
                this.f30071e = true;
                bArr[i2 + 1] = LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_2;
                this.f30072f = true;
            }
            super.write(bArr, i2, i3);
        }
    }

    @Override // org.apache.commons.codec.binary4util.bdapp.Base64OutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (!this.f30071e) {
                super.write(117);
                this.f30071e = true;
            } else if (!this.f30072f) {
                super.write(123);
                this.f30072f = true;
            } else {
                super.write(i2);
            }
        }
    }
}
