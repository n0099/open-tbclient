package com.baidu.cyberplayer.sdk.extractor;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.cyberplayer.sdk.Keep;
import java.io.FileDescriptor;
import java.util.Map;
@Keep
/* loaded from: classes12.dex */
public class CyberExtractor {
    public static final String KEY_DURATION = "duration";
    public static final String KEY_HEIGHT = "height";
    public static final String KEY_WIDTH = "width";
    public static final int OPT_CATEGORY_FORMAT = 1;
    public static final String OPT_KEY_PREPARE_TIME_OUT = "prepare_time_out";

    /* renamed from: a  reason: collision with root package name */
    private ExtractorProvider f1382a;

    public CyberExtractor() {
        this(true);
    }

    public CyberExtractor(boolean z) {
        this.f1382a = a.a().a(z);
    }

    public Bundle getMetaData() {
        if (this.f1382a != null) {
            return this.f1382a.getMediaMeta();
        }
        return null;
    }

    public void release() {
        if (this.f1382a != null) {
            this.f1382a.release();
            this.f1382a = null;
        }
    }

    public void setDataSource(Context context, Uri uri) {
        if (this.f1382a != null) {
            this.f1382a.setDataSource(context, uri);
        }
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        if (this.f1382a != null) {
            this.f1382a.setDataSource(context, uri, map);
        }
    }

    public void setDataSource(FileDescriptor fileDescriptor) {
        if (this.f1382a != null) {
            this.f1382a.setDataSource(fileDescriptor);
        }
    }

    public void setDataSource(String str) {
        if (this.f1382a != null) {
            this.f1382a.setDataSource(str);
        }
    }

    public void setOption(int i, String str, long j) {
        if (this.f1382a != null) {
            this.f1382a.setOption(i, str, j);
        }
    }
}
