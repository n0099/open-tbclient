package aegon.chrome.net;

import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public final class UploadDataProviders$ByteBufferUploadProvider extends UploadDataProvider {
    public final ByteBuffer mUploadBuffer;

    @Override // aegon.chrome.net.UploadDataProvider
    public long getLength() {
        return this.mUploadBuffer.limit();
    }

    @Override // aegon.chrome.net.UploadDataProvider
    public void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            throw new IllegalStateException("Cronet passed a buffer with no bytes remaining");
        }
        if (byteBuffer.remaining() >= this.mUploadBuffer.remaining()) {
            byteBuffer.put(this.mUploadBuffer);
        } else {
            int limit = this.mUploadBuffer.limit();
            ByteBuffer byteBuffer2 = this.mUploadBuffer;
            byteBuffer2.limit(byteBuffer2.position() + byteBuffer.remaining());
            byteBuffer.put(this.mUploadBuffer);
            this.mUploadBuffer.limit(limit);
        }
        uploadDataSink.onReadSucceeded(false);
    }

    @Override // aegon.chrome.net.UploadDataProvider
    public void rewind(UploadDataSink uploadDataSink) {
        this.mUploadBuffer.position(0);
        uploadDataSink.onRewindSucceeded();
    }
}
