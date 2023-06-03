package com.baidu.searchbox.network.support.okhttp.converters;

import com.baidu.searchbox.network.outback.core.MediaType;
/* loaded from: classes4.dex */
public final class MediaTypeConverter {
    public static MediaType fromOks(okhttp3.MediaType mediaType) {
        if (mediaType != null) {
            return MediaType.parse(mediaType.toString());
        }
        return null;
    }

    public static okhttp3.MediaType toOks(MediaType mediaType) {
        if (mediaType != null) {
            return okhttp3.MediaType.parse(mediaType.toString());
        }
        return null;
    }
}
