package com.baidu.searchbox.bddownload.core.interceptor;

import androidx.annotation.NonNull;
import com.baidu.searchbox.bddownload.BdDownload;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.dispatcher.CallbackDispatcher;
import com.baidu.searchbox.bddownload.core.download.DownloadChain;
import com.baidu.searchbox.bddownload.core.exception.InterruptException;
import com.baidu.searchbox.bddownload.core.file.MultiPointOutputStream;
import com.baidu.searchbox.bddownload.core.interceptor.Interceptor;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class FetchDataInterceptor implements Interceptor.Fetch {
    public final int blockIndex;
    public final CallbackDispatcher dispatcher = BdDownload.with().callbackDispatcher();
    public final InputStream inputStream;
    public final MultiPointOutputStream outputStream;
    public final byte[] readBuffer;
    public final DownloadTask task;

    public FetchDataInterceptor(int i, @NonNull InputStream inputStream, @NonNull MultiPointOutputStream multiPointOutputStream, DownloadTask downloadTask) {
        this.blockIndex = i;
        this.inputStream = inputStream;
        this.readBuffer = new byte[downloadTask.getReadBufferSize()];
        this.outputStream = multiPointOutputStream;
        this.task = downloadTask;
    }

    @Override // com.baidu.searchbox.bddownload.core.interceptor.Interceptor.Fetch
    public long interceptFetch(DownloadChain downloadChain) throws IOException {
        if (!downloadChain.getCache().isInterrupt()) {
            BdDownload.with().downloadStrategy().inspectNetworkOnWifi(downloadChain.getTask());
            int read = this.inputStream.read(this.readBuffer);
            if (read == -1) {
                return read;
            }
            this.outputStream.write(this.blockIndex, this.readBuffer, read);
            long j = read;
            downloadChain.increaseCallbackBytes(j);
            if (this.dispatcher.isFetchProcessMoment(this.task)) {
                downloadChain.flushNoCallbackIncreaseBytes();
            }
            return j;
        }
        throw InterruptException.SIGNAL;
    }
}
