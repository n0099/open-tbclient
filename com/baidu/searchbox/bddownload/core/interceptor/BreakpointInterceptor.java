package com.baidu.searchbox.bddownload.core.interceptor;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.baidu.searchbox.bddownload.BdDownload;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.breakpoint.BlockInfo;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.cause.ResumeFailedCause;
import com.baidu.searchbox.bddownload.core.connection.DownloadConnection;
import com.baidu.searchbox.bddownload.core.download.DownloadChain;
import com.baidu.searchbox.bddownload.core.exception.InterruptException;
import com.baidu.searchbox.bddownload.core.exception.RetryException;
import com.baidu.searchbox.bddownload.core.file.MultiPointOutputStream;
import com.baidu.searchbox.bddownload.core.interceptor.Interceptor;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class BreakpointInterceptor implements Interceptor.Connect, Interceptor.Fetch {
    public static final Pattern CONTENT_RANGE_RIGHT_VALUE = Pattern.compile(".*\\d+ *- *(\\d+) */ *\\d+");
    public static final String TAG = "BreakpointInterceptor";

    @IntRange(from = -1)
    public static long getRangeRightFromContentRange(@NonNull String str) {
        Matcher matcher = CONTENT_RANGE_RIGHT_VALUE.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    @IntRange(from = -1)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long getExactContentLengthRangeFrom0(@NonNull DownloadConnection.Connected connected) {
        long j;
        String responseHeaderField = connected.getResponseHeaderField("Content-Range");
        if (!Util.isEmpty(responseHeaderField)) {
            long rangeRightFromContentRange = getRangeRightFromContentRange(responseHeaderField);
            if (rangeRightFromContentRange > 0) {
                j = rangeRightFromContentRange + 1;
                if (j >= 0) {
                    String responseHeaderField2 = connected.getResponseHeaderField("Content-Length");
                    return !Util.isEmpty(responseHeaderField2) ? Long.parseLong(responseHeaderField2) : j;
                }
                return j;
            }
        }
        j = -1;
        if (j >= 0) {
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.interceptor.Interceptor.Connect
    @NonNull
    public DownloadConnection.Connected interceptConnect(DownloadChain downloadChain) throws IOException {
        DownloadConnection.Connected processConnect = downloadChain.processConnect();
        BreakpointInfo info = downloadChain.getInfo();
        if (!downloadChain.getCache().isInterrupt()) {
            if (info.getBlockCount() == 1 && !info.isChunked()) {
                long exactContentLengthRangeFrom0 = getExactContentLengthRangeFrom0(processConnect);
                long totalLength = info.getTotalLength();
                if (exactContentLengthRangeFrom0 > 0 && exactContentLengthRangeFrom0 != totalLength) {
                    Util.d(TAG, "SingleBlock special check: the response instance-length[" + exactContentLengthRangeFrom0 + "] isn't equal to the instance length from trial-connection[" + totalLength + "]");
                    boolean z = info.getBlock(0).getRangeLeft() != 0;
                    BlockInfo blockInfo = new BlockInfo(0L, exactContentLengthRangeFrom0);
                    info.resetBlockInfos();
                    info.addBlock(blockInfo);
                    if (!z) {
                        BdDownload.with().callbackDispatcher().dispatch().downloadFromBeginning(downloadChain.getTask(), info, ResumeFailedCause.CONTENT_LENGTH_CHANGED);
                    } else {
                        Util.w(TAG, "Discard breakpoint because of on this special case, we have to download from beginning");
                        throw new RetryException("Discard breakpoint because of on this special case, we have to download from beginning");
                    }
                }
            }
            try {
                if (downloadChain.getDownloadStore().update(info)) {
                    return processConnect;
                }
                throw new IOException("Update store failed!");
            } catch (Exception e2) {
                throw new IOException("Update store failed!", e2);
            }
        }
        throw InterruptException.SIGNAL;
    }

    @Override // com.baidu.searchbox.bddownload.core.interceptor.Interceptor.Fetch
    public long interceptFetch(DownloadChain downloadChain) throws IOException {
        long responseContentLength = downloadChain.getResponseContentLength();
        int blockIndex = downloadChain.getBlockIndex();
        boolean z = responseContentLength != -1;
        long j = 0;
        MultiPointOutputStream outputStream = downloadChain.getOutputStream();
        while (true) {
            try {
                long loopFetch = downloadChain.loopFetch();
                if (loopFetch == -1) {
                    break;
                }
                j += loopFetch;
            } finally {
                downloadChain.flushNoCallbackIncreaseBytes();
                if (!downloadChain.getCache().isUserCanceled()) {
                    outputStream.done(blockIndex);
                }
            }
        }
        if (z) {
            outputStream.inspectComplete(blockIndex);
            if (j != responseContentLength) {
                throw new IOException("Fetch-length isn't equal to the response content-length, " + j + "!= " + responseContentLength);
            }
        }
        return j;
    }
}
