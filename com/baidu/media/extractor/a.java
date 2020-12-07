package com.baidu.media.extractor;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.extractor.CyberExtractor;
import com.baidu.cyberplayer.sdk.extractor.ExtractorProvider;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
/* loaded from: classes18.dex */
public class a extends ExtractorProvider {
    private DuMediaExtractor ccB;

    public a() {
        try {
            this.ccB = new DuMediaExtractor();
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
        if (this.ccB != null) {
            try {
                return this.ccB.b();
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
            this.ccB = null;
        }
        if (this.ccB != null) {
            this.ccB.a();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setDataSource(Context context, Uri uri) {
        if (this.ccB != null) {
            try {
                this.ccB.a(context, uri, (Map<String, String>) null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        if (this.ccB != null) {
            try {
                this.ccB.a(context, uri, map);
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
        if (this.ccB != null) {
            try {
                this.ccB.a(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.extractor.ExtractorProvider
    public void setOption(int i, String str, long j) {
        CyberLog.i("CyberExtractorImpl", "setOption: " + str + "," + j);
        if (this.ccB != null) {
            try {
                this.ccB.a(i, str, j);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
