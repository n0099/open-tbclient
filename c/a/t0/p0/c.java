package c.a.t0.p0;

import android.util.Base64OutputStream;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes7.dex */
public class c extends Base64OutputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f26450e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f26451f;

    /* renamed from: g  reason: collision with root package name */
    public long f26452g;

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
        this.f26450e = false;
        this.f26451f = false;
        this.f26452g = 0L;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f26452g : invokeV.longValue;
    }

    @Override // android.util.Base64OutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, bArr, i2, i3) == null) {
            if (this.f26450e && !this.f26451f && i3 > 0 && bArr.length - i2 > 0) {
                bArr[i2] = LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_2;
                this.f26451f = true;
            } else if (!this.f26450e && i3 == 1 && bArr.length - i2 > 0) {
                bArr[i2] = LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1;
                this.f26450e = true;
            } else if (!this.f26450e && i3 > 1 && bArr.length - i2 > 1) {
                bArr[i2] = LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1;
                this.f26450e = true;
                bArr[i2 + 1] = LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_2;
                this.f26451f = true;
            }
            if (i3 > 0) {
                this.f26452g += i3;
            }
            super.write(bArr, i2, i3);
        }
    }

    @Override // android.util.Base64OutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (!this.f26450e) {
                super.write(117);
                this.f26450e = true;
            } else if (!this.f26451f) {
                super.write(123);
                this.f26451f = true;
            } else {
                super.write(i2);
            }
        }
    }
}
