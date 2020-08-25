package com.baidu.searchbox.network.core.http;

import android.support.annotation.Nullable;
import com.baidu.searchbox.network.core.MediaType;
import com.baidu.searchbox.network.core.ResponseBody;
import okio.BufferedSource;
/* loaded from: classes14.dex */
public final class RealResponseBody extends ResponseBody {
    private final long contentLength;
    @Nullable
    private final String contentTypeString;
    private final BufferedSource source;

    public RealResponseBody(@Nullable String str, long j, BufferedSource bufferedSource) {
        this.contentTypeString = str;
        this.contentLength = j;
        this.source = bufferedSource;
    }

    @Override // com.baidu.searchbox.network.core.ResponseBody
    public MediaType contentType() {
        if (this.contentTypeString != null) {
            return MediaType.parse(this.contentTypeString);
        }
        return null;
    }

    @Override // com.baidu.searchbox.network.core.ResponseBody
    public long contentLength() {
        return this.contentLength;
    }

    @Override // com.baidu.searchbox.network.core.ResponseBody
    public BufferedSource source() {
        return this.source;
    }
}
