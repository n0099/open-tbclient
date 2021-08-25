package c.a.s0.k0;

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
    public boolean f29933e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f29934f;

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
        this.f29933e = false;
        this.f29934f = false;
    }

    @Override // org.apache.commons.codec.binary4util.bdapp.Base64OutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i2, i3) == null) {
            if (this.f29933e && !this.f29934f && i3 > 0 && bArr.length - i2 > 0) {
                bArr[i2] = LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_2;
                this.f29934f = true;
            } else if (!this.f29933e && i3 == 1 && bArr.length - i2 > 0) {
                bArr[i2] = LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1;
                this.f29933e = true;
            } else if (!this.f29933e && i3 > 1 && bArr.length - i2 > 1) {
                bArr[i2] = LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1;
                this.f29933e = true;
                bArr[i2 + 1] = LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_2;
                this.f29934f = true;
            }
            super.write(bArr, i2, i3);
        }
    }

    @Override // org.apache.commons.codec.binary4util.bdapp.Base64OutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (!this.f29933e) {
                super.write(117);
                this.f29933e = true;
            } else if (!this.f29934f) {
                super.write(123);
                this.f29934f = true;
            } else {
                super.write(i2);
            }
        }
    }
}
