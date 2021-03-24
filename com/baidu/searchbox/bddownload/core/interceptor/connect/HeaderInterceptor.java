package com.baidu.searchbox.bddownload.core.interceptor.connect;

import androidx.annotation.NonNull;
import com.baidu.searchbox.bddownload.BdDownload;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.breakpoint.BlockInfo;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.connection.DownloadConnection;
import com.baidu.searchbox.bddownload.core.download.DownloadChain;
import com.baidu.searchbox.bddownload.core.exception.InterruptException;
import com.baidu.searchbox.bddownload.core.interceptor.Interceptor;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class HeaderInterceptor implements Interceptor.Connect {
    public static final String TAG = "HeaderInterceptor";

    @Override // com.baidu.searchbox.bddownload.core.interceptor.Interceptor.Connect
    @NonNull
    public DownloadConnection.Connected interceptConnect(DownloadChain downloadChain) throws IOException {
        BlockInfo block;
        long parseContentLengthFromContentRange;
        BreakpointInfo info = downloadChain.getInfo();
        DownloadConnection connectionOrCreate = downloadChain.getConnectionOrCreate();
        DownloadTask task = downloadChain.getTask();
        Map<String, List<String>> headerMapFields = task.getHeaderMapFields();
        if (headerMapFields != null) {
            Util.addUserRequestHeaderField(headerMapFields, connectionOrCreate);
        }
        if (headerMapFields == null || !headerMapFields.containsKey("User-Agent")) {
            Util.addDefaultUserAgent(connectionOrCreate);
        }
        int blockIndex = downloadChain.getBlockIndex();
        if (info.getBlock(blockIndex) != null) {
            connectionOrCreate.addHeader("Range", ("bytes=" + block.getRangeLeft() + "-") + block.getRangeRight());
            Util.d(TAG, "AssembleHeaderRange (" + task.getId() + ") block(" + blockIndex + ") downloadFrom(" + block.getRangeLeft() + ") currentOffset(" + block.getCurrentOffset() + SmallTailInfo.EMOTION_SUFFIX);
            String etag = info.getEtag();
            if (!Util.isEmpty(etag)) {
                connectionOrCreate.addHeader(Util.IF_MATCH, etag);
            }
            if (!downloadChain.getCache().isInterrupt()) {
                BdDownload.with().callbackDispatcher().dispatch().connectStart(task, blockIndex, connectionOrCreate.getRequestProperties());
                DownloadConnection.Connected processConnect = downloadChain.processConnect();
                if (!downloadChain.getCache().isInterrupt()) {
                    Map<String, List<String>> responseHeaderFields = processConnect.getResponseHeaderFields();
                    if (responseHeaderFields == null) {
                        responseHeaderFields = new HashMap<>();
                    }
                    BdDownload.with().callbackDispatcher().dispatch().connectEnd(task, blockIndex, processConnect.getResponseCode(), responseHeaderFields);
                    BdDownload.with().downloadStrategy().resumeAvailableResponseCheck(processConnect, blockIndex, info).inspect();
                    String responseHeaderField = processConnect.getResponseHeaderField("Content-Length");
                    if (responseHeaderField != null && responseHeaderField.length() != 0) {
                        parseContentLengthFromContentRange = Util.parseContentLength(responseHeaderField);
                    } else {
                        parseContentLengthFromContentRange = Util.parseContentLengthFromContentRange(processConnect.getResponseHeaderField("Content-Range"));
                    }
                    downloadChain.setResponseContentLength(parseContentLengthFromContentRange);
                    return processConnect;
                }
                throw InterruptException.SIGNAL;
            }
            throw InterruptException.SIGNAL;
        }
        throw new IOException("No block-info found on " + blockIndex);
    }
}
