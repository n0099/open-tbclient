package com.baidu.searchbox.ng.ai.apps.network;

import com.baidu.searchbox.ng.ai.apps.network.interfaces.IUploadProgressListener;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import java.io.File;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;
/* loaded from: classes2.dex */
public class CountingFileRequestBody extends RequestBody {
    private static final long SEGMENT_SIZE = 2048;
    private final String mContentType;
    private final File mUploadFile;
    private final IUploadProgressListener mUploadListener;

    public CountingFileRequestBody(File file, String str, IUploadProgressListener iUploadProgressListener) {
        this.mUploadFile = file;
        this.mContentType = str;
        this.mUploadListener = iUploadProgressListener;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return this.mUploadFile.length();
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return MediaType.parse(this.mContentType);
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Source source = null;
        try {
            source = Okio.source(this.mUploadFile);
            long j = 0;
            while (true) {
                long read = source.read(bufferedSink.buffer(), 2048L);
                if (read != -1) {
                    j += read;
                    bufferedSink.flush();
                    this.mUploadListener.transferred(j);
                } else {
                    return;
                }
            }
        } finally {
            AiAppsFileUtils.closeSafely(source);
        }
    }
}
