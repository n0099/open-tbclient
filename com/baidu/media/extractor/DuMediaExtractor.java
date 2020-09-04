package com.baidu.media.extractor;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.media.duplayer.Keep;
import com.baidu.media.extractor.b;
import com.baidu.mobstat.Config;
import java.lang.ref.WeakReference;
import java.util.Map;
/* loaded from: classes12.dex */
public class DuMediaExtractor implements b {
    private b.a bAO;
    private a bAP;
    @Keep
    private long mNativeDuMediaExtractor;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class a extends Handler {
        private final WeakReference<DuMediaExtractor> a;

        public a(DuMediaExtractor duMediaExtractor, Looper looper) {
            super(looper);
            this.a = new WeakReference<>(duMediaExtractor);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            DuMediaExtractor duMediaExtractor = this.a.get();
            if (duMediaExtractor == null || duMediaExtractor.mNativeDuMediaExtractor == 0) {
                CyberLog.w("DuMediaExtractor", "IjkMediaPlayer went away with unhandled events");
            } else {
                int i = message.what;
            }
        }
    }

    public DuMediaExtractor() {
        nativeSetup(new WeakReference(this));
        c();
    }

    private void c() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.bAP = new a(this, myLooper);
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            this.bAP = new a(this, mainLooper);
        } else {
            this.bAP = null;
        }
    }

    private native Bundle nativeGetMediaMeta();

    private native void nativePrepare();

    private native void nativeRelease();

    private native void nativeSetDataSource(String str, String[] strArr, String[] strArr2);

    private native void nativeSetOption(int i, String str, long j);

    private native void nativeSetOption(int i, String str, String str2);

    private native void nativeSetup(Object obj);

    @Keep
    private static boolean onNativeInvoke(Object obj, int i, Bundle bundle) {
        if (obj == null || !(obj instanceof WeakReference)) {
            throw new IllegalStateException("<null weakThiz>.onNativeInvoke()");
        }
        return false;
    }

    public void a() {
        synchronized (this) {
            nativeRelease();
            this.bAO = null;
            this.bAP = null;
            this.mNativeDuMediaExtractor = 0L;
        }
    }

    public void a(int i, String str, long j) {
        nativeSetOption(i, str, j);
    }

    public void a(int i, String str, String str2) {
        nativeSetOption(i, str, str2);
    }

    public void a(Context context, Uri uri, Map<String, String> map) {
        a(uri.toString(), map);
    }

    public void a(String str) {
        nativeSetDataSource(str, null, null);
        nativePrepare();
    }

    public void a(String str, Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey().equals("Referer")) {
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(value)) {
                        a(1, Config.LAUNCH_REFERER, value);
                    }
                } else {
                    sb.append(entry.getKey());
                    sb.append(": ");
                    if (!TextUtils.isEmpty(entry.getValue())) {
                        sb.append(entry.getValue());
                    }
                    sb.append("\r\n");
                }
            }
            a(1, "headers", sb.toString());
        }
        a(str);
    }

    public Bundle b() {
        return nativeGetMediaMeta();
    }
}
