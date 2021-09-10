package c.p.a.e.b.n;

import c.p.a.e.b.l.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.datamodel.ScanCodeConstant;
import com.ss.android.socialbase.downloader.exception.BaseException;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes4.dex */
public class c implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BufferedOutputStream f35380e;

    /* renamed from: f  reason: collision with root package name */
    public FileDescriptor f35381f;

    /* renamed from: g  reason: collision with root package name */
    public RandomAccessFile f35382g;

    public c(File file, int i2) throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.f35382g = randomAccessFile;
            this.f35381f = randomAccessFile.getFD();
            if (i2 > 0) {
                if (i2 < 8192) {
                    i2 = 8192;
                } else if (i2 > 131072) {
                    i2 = 131072;
                }
                this.f35380e = new BufferedOutputStream(new FileOutputStream(this.f35382g.getFD()), i2);
                return;
            }
            this.f35380e = new BufferedOutputStream(new FileOutputStream(this.f35382g.getFD()));
        } catch (IOException e2) {
            throw new BaseException((int) ScanCodeConstant.B_SAO_C_NORMAL_AUTH_SERVICE_TYPE, e2);
        }
    }

    public void a(byte[] bArr, int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i2, i3) == null) {
            this.f35380e.write(bArr, i2, i3);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            f.E(this.f35382g, this.f35380e);
        }
    }

    public void g() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            BufferedOutputStream bufferedOutputStream = this.f35380e;
            if (bufferedOutputStream != null) {
                bufferedOutputStream.flush();
            }
            FileDescriptor fileDescriptor = this.f35381f;
            if (fileDescriptor != null) {
                fileDescriptor.sync();
            }
        }
    }

    public void n() throws IOException {
        BufferedOutputStream bufferedOutputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bufferedOutputStream = this.f35380e) == null) {
            return;
        }
        bufferedOutputStream.flush();
    }

    public void o(long j2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
            this.f35382g.setLength(j2);
        }
    }

    public void r() throws IOException {
        FileDescriptor fileDescriptor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (fileDescriptor = this.f35381f) == null) {
            return;
        }
        fileDescriptor.sync();
    }

    public void a(long j2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
            this.f35382g.seek(j2);
        }
    }
}
