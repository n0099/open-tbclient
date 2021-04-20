package com.baidu.cyberplayer.sdk.extractor;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.cyberplayer.sdk.Keep;
import java.io.FileDescriptor;
import java.util.Map;
@Keep
/* loaded from: classes.dex */
public class CyberExtractor {
    public static final String KEY_DURATION = "duration";
    public static final String KEY_HEIGHT = "height";
    public static final String KEY_WIDTH = "width";
    public static final int OPT_CATEGORY_FORMAT = 1;
    public static final String OPT_KEY_PREPARE_TIME_OUT = "prepare_time_out";

    /* renamed from: a  reason: collision with root package name */
    public ExtractorProvider f4964a;

    public CyberExtractor() {
        this(true);
    }

    public CyberExtractor(boolean z) {
        this.f4964a = a.a().a(z);
    }

    public Bundle getMetaData() {
        ExtractorProvider extractorProvider = this.f4964a;
        if (extractorProvider != null) {
            return extractorProvider.getMediaMeta();
        }
        return null;
    }

    public void release() {
        ExtractorProvider extractorProvider = this.f4964a;
        if (extractorProvider != null) {
            extractorProvider.release();
            this.f4964a = null;
        }
    }

    public void setDataSource(Context context, Uri uri) {
        ExtractorProvider extractorProvider = this.f4964a;
        if (extractorProvider != null) {
            extractorProvider.setDataSource(context, uri);
        }
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        ExtractorProvider extractorProvider = this.f4964a;
        if (extractorProvider != null) {
            extractorProvider.setDataSource(context, uri, map);
        }
    }

    public void setDataSource(FileDescriptor fileDescriptor) {
        ExtractorProvider extractorProvider = this.f4964a;
        if (extractorProvider != null) {
            extractorProvider.setDataSource(fileDescriptor);
        }
    }

    public void setDataSource(String str) {
        ExtractorProvider extractorProvider = this.f4964a;
        if (extractorProvider != null) {
            extractorProvider.setDataSource(str);
        }
    }

    public void setOption(int i, String str, long j) {
        ExtractorProvider extractorProvider = this.f4964a;
        if (extractorProvider != null) {
            extractorProvider.setOption(i, str, j);
        }
    }
}
