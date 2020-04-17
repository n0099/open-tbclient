package com.baidu.media.extractor;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.extractor.CyberExtractor;
import com.baidu.cyberplayer.sdk.extractor.ExtractorProvider;
import com.xiaomi.mipush.sdk.Constants;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
/* loaded from: classes.dex */
public class a extends ExtractorProvider {
    private DuMediaExtractor bil;

    public a() {
        try {
            this.bil = new DuMediaExtractor();
            b();
        } catch (Throwable th) {
            th.printStackTrace();
            throw th;
        }
    }

    public static ExtractorProvider a() {
        if (CyberPlayerManager.isCoreLoaded(CyberPlayerManager.getInstallType())) {
            return new a();
        }
        return null;
    }

    private void b() {
        setOption(1, CyberExtractor.OPT_KEY_PREPARE_TIME_OUT, 5000L);
        setOption(1, "proxytcp-enable", 0L);
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public Bundle getMediaMeta() {
        if (this.bil != null) {
            try {
                return this.bil.b();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void release() {
        try {
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } finally {
            this.bil = null;
        }
        if (this.bil != null) {
            this.bil.a();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setDataSource(Context context, Uri uri) {
        if (this.bil != null) {
            try {
                this.bil.a(context, uri, (Map<String, String>) null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        if (this.bil != null) {
            try {
                this.bil.a(context, uri, map);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setDataSource(FileDescriptor fileDescriptor) {
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setDataSource(String str) {
        if (this.bil != null) {
            try {
                this.bil.a(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setOption(int i, String str, long j) {
        CyberLog.i("CyberExtractorImpl", "setOption: " + str + Constants.ACCEPT_TIME_SEPARATOR_SP + j);
        if (this.bil != null) {
            try {
                this.bil.a(i, str, j);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
