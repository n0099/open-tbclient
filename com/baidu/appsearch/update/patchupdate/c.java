package com.baidu.appsearch.update.patchupdate;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class c implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RandomAccessFile a;

    public c(RandomAccessFile randomAccessFile) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {randomAccessFile};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (randomAccessFile == null) {
            throw new NullPointerException("input RandomAccessFile is null");
        }
        this.a = randomAccessFile;
    }

    @Override // com.baidu.appsearch.update.patchupdate.d
    public int a(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, byteBuffer)) == null) {
            int read = this.a.read(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining());
            if (read == -1) {
                return -1;
            }
            byteBuffer.position(byteBuffer.position() + read);
            return read;
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.appsearch.update.patchupdate.d
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.a.seek(j);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.close();
        }
    }
}
