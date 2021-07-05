package aegon.chrome.net;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public final class UploadDataProviders$ByteBufferUploadProvider extends UploadDataProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ByteBuffer mUploadBuffer;

    @Override // aegon.chrome.net.UploadDataProvider
    public long getLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mUploadBuffer.limit() : invokeV.longValue;
    }

    @Override // aegon.chrome.net.UploadDataProvider
    public void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uploadDataSink, byteBuffer) == null) {
            if (!byteBuffer.hasRemaining()) {
                throw new IllegalStateException("Cronet passed a buffer with no bytes remaining");
            }
            if (byteBuffer.remaining() >= this.mUploadBuffer.remaining()) {
                byteBuffer.put(this.mUploadBuffer);
            } else {
                int limit = this.mUploadBuffer.limit();
                ByteBuffer byteBuffer2 = this.mUploadBuffer;
                byteBuffer2.limit(byteBuffer.remaining() + byteBuffer2.position());
                byteBuffer.put(this.mUploadBuffer);
                this.mUploadBuffer.limit(limit);
            }
            uploadDataSink.onReadSucceeded(false);
        }
    }

    @Override // aegon.chrome.net.UploadDataProvider
    public void rewind(UploadDataSink uploadDataSink) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uploadDataSink) == null) {
            this.mUploadBuffer.position(0);
            uploadDataSink.onRewindSucceeded();
        }
    }
}
