package com.baidu.cyberplayer.sdk.extractor;

import android.content.Context;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.sina.weibo.sdk.utils.FileUtils;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
/* loaded from: classes3.dex */
public class b extends ExtractorProvider {
    public MediaExtractor a = new MediaExtractor();

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void release() {
        CyberLog.i("MediaExtractorImpl", "release");
        MediaExtractor mediaExtractor = this.a;
        if (mediaExtractor != null) {
            mediaExtractor.release();
            this.a = null;
        }
    }

    private Integer a(String str) {
        Integer num;
        int i;
        MediaExtractor mediaExtractor = this.a;
        if (mediaExtractor != null && Build.VERSION.SDK_INT >= 16) {
            int trackCount = mediaExtractor.getTrackCount();
            for (int i2 = 0; i2 < trackCount; i2++) {
                if (this.a.getTrackFormat(i2).getString("mime").startsWith(str)) {
                    num = Integer.valueOf(i2);
                    break;
                }
            }
        }
        num = null;
        if (num != null) {
            i = num.intValue();
        } else {
            i = -1;
        }
        return Integer.valueOf(i);
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public Bundle getMediaMeta() {
        MediaFormat trackFormat;
        Bundle bundle = new Bundle();
        if (this.a != null) {
            int intValue = a(FileUtils.VIDEO_FILE_START).intValue();
            int intValue2 = a("audio/").intValue();
            if (intValue != -1) {
                intValue2 = intValue;
            }
            if (intValue2 != -1 && (trackFormat = this.a.getTrackFormat(intValue2)) != null) {
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
    public void setDataSource(Context context, Uri uri) {
        MediaExtractor mediaExtractor = this.a;
        if (mediaExtractor != null) {
            try {
                mediaExtractor.setDataSource(context, uri, (Map<String, String>) null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        MediaExtractor mediaExtractor = this.a;
        if (mediaExtractor != null) {
            try {
                mediaExtractor.setDataSource(context, uri, map);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setDataSource(FileDescriptor fileDescriptor) {
        MediaExtractor mediaExtractor = this.a;
        if (mediaExtractor != null) {
            try {
                mediaExtractor.setDataSource(fileDescriptor);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setDataSource(String str) {
        MediaExtractor mediaExtractor = this.a;
        if (mediaExtractor != null) {
            try {
                mediaExtractor.setDataSource(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
