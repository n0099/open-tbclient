package aegon.chrome.net.impl;

import aegon.chrome.net.UploadDataProvider;
import aegon.chrome.net.UploadDataSink;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public final class VersionSafeCallbacks$UploadDataProviderWrapper extends UploadDataProvider {
    public final UploadDataProvider mWrappedProvider;

    public VersionSafeCallbacks$UploadDataProviderWrapper(UploadDataProvider uploadDataProvider) {
        this.mWrappedProvider = uploadDataProvider;
    }

    @Override // aegon.chrome.net.UploadDataProvider, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mWrappedProvider.close();
    }

    @Override // aegon.chrome.net.UploadDataProvider
    public long getLength() {
        return this.mWrappedProvider.getLength();
    }

    @Override // aegon.chrome.net.UploadDataProvider
    public void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
        this.mWrappedProvider.read(uploadDataSink, byteBuffer);
    }

    @Override // aegon.chrome.net.UploadDataProvider
    public void rewind(UploadDataSink uploadDataSink) {
        this.mWrappedProvider.rewind(uploadDataSink);
    }
}
