package aegon.chrome.net.impl;

import aegon.chrome.net.UploadDataProvider;
import aegon.chrome.net.UploadDataSink;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public final class VersionSafeCallbacks$UploadDataProviderWrapper extends UploadDataProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final UploadDataProvider mWrappedProvider;

    public VersionSafeCallbacks$UploadDataProviderWrapper(UploadDataProvider uploadDataProvider) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uploadDataProvider};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mWrappedProvider = uploadDataProvider;
    }

    @Override // aegon.chrome.net.UploadDataProvider, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mWrappedProvider.close();
        }
    }

    @Override // aegon.chrome.net.UploadDataProvider
    public long getLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mWrappedProvider.getLength() : invokeV.longValue;
    }

    @Override // aegon.chrome.net.UploadDataProvider
    public void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, uploadDataSink, byteBuffer) == null) {
            this.mWrappedProvider.read(uploadDataSink, byteBuffer);
        }
    }

    @Override // aegon.chrome.net.UploadDataProvider
    public void rewind(UploadDataSink uploadDataSink) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, uploadDataSink) == null) {
            this.mWrappedProvider.rewind(uploadDataSink);
        }
    }
}
