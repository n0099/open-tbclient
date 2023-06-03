package com.baidu.searchbox.network.outback.core;

import androidx.annotation.Nullable;
import java.io.InputStream;
/* loaded from: classes4.dex */
public final class RealResponseBody extends ResponseBody {
    public final long contentLength;
    @Nullable
    public final String contentTypeString;
    public final InputStream inputStream;

    public RealResponseBody(@Nullable String str, long j, InputStream inputStream) {
        this.contentTypeString = str;
        this.contentLength = j;
        this.inputStream = inputStream;
    }

    @Override // com.baidu.searchbox.network.outback.core.ResponseBody
    public long contentLength() {
        return this.contentLength;
    }

    @Override // com.baidu.searchbox.network.outback.core.ResponseBody
    public MediaType contentType() {
        String str = this.contentTypeString;
        if (str != null) {
            return MediaType.parse(str);
        }
        return null;
    }

    @Override // com.baidu.searchbox.network.outback.core.ResponseBody
    public InputStream inputStream() {
        return this.inputStream;
    }
}
