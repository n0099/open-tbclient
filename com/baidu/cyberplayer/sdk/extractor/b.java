package com.baidu.cyberplayer.sdk.extractor;

import android.content.Context;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.baidu.cyberplayer.sdk.CyberLog;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
/* loaded from: classes12.dex */
public class b extends ExtractorProvider {

    /* renamed from: a  reason: collision with root package name */
    private MediaExtractor f1381a = new MediaExtractor();

    private Integer a(String str) {
        Integer num = null;
        if (this.f1381a != null && Build.VERSION.SDK_INT >= 16) {
            int trackCount = this.f1381a.getTrackCount();
            int i = 0;
            while (true) {
                if (i >= trackCount) {
                    break;
                } else if (this.f1381a.getTrackFormat(i).getString("mime").startsWith(str)) {
                    num = Integer.valueOf(i);
                    break;
                } else {
                    i++;
                }
            }
        }
        return Integer.valueOf(num != null ? num.intValue() : -1);
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public Bundle getMediaMeta() {
        MediaFormat trackFormat;
        Bundle bundle = new Bundle();
        if (this.f1381a != null) {
            int intValue = a("video/").intValue();
            int intValue2 = a("audio/").intValue();
            if (intValue != -1) {
                intValue2 = intValue;
            }
            if (intValue2 != -1 && (trackFormat = this.f1381a.getTrackFormat(intValue2)) != null) {
                try {
                    bundle.putLong("duration", trackFormat.getLong("durationUs") / 1000);
                    if (intValue != -1) {
                        bundle.putInt("width", trackFormat.getInteger("width"));
                        bundle.putInt("height", trackFormat.getInteger("height"));
                    }
                } catch (Exception e) {
                    CyberLog.e("MediaExtractorImpl", "getMediaMeta Exception");
                    e.printStackTrace();
                }
            }
        }
        return bundle;
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void release() {
        CyberLog.i("MediaExtractorImpl", "release");
        if (this.f1381a != null) {
            this.f1381a.release();
            this.f1381a = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setDataSource(Context context, Uri uri) {
        if (this.f1381a != null) {
            try {
                this.f1381a.setDataSource(context, uri, (Map<String, String>) null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        if (this.f1381a != null) {
            try {
                this.f1381a.setDataSource(context, uri, map);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setDataSource(FileDescriptor fileDescriptor) {
        if (this.f1381a != null) {
            try {
                this.f1381a.setDataSource(fileDescriptor);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setDataSource(String str) {
        if (this.f1381a != null) {
            try {
                this.f1381a.setDataSource(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
