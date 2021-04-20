package com.baidu.media.extractor;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.android.internal.http.multipart.Part;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.media.duplayer.Keep;
import com.baidu.mobstat.Config;
import java.lang.ref.WeakReference;
import java.util.Map;
/* loaded from: classes2.dex */
public class DuMediaExtractor {
    @Keep
    public long mNativeDuMediaExtractor;

    /* loaded from: classes2.dex */
    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<DuMediaExtractor> f8011a;

        public a(DuMediaExtractor duMediaExtractor, Looper looper) {
            super(looper);
            this.f8011a = new WeakReference<>(duMediaExtractor);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            DuMediaExtractor duMediaExtractor = this.f8011a.get();
            if (duMediaExtractor == null || duMediaExtractor.mNativeDuMediaExtractor == 0) {
                CyberLog.w("DuMediaExtractor", "IjkMediaPlayer went away with unhandled events");
            } else {
                int i = message.what;
            }
        }
    }

    public DuMediaExtractor() {
        nativeSetup(new WeakReference(this));
        i();
    }

    private native Bundle nativeGetMediaMeta();

    private native void nativePrepare();

    private native void nativeRelease();

    private native void nativeSetDataSource(String str, String[] strArr, String[] strArr2);

    private native void nativeSetOption(int i, String str, long j);

    private native void nativeSetOption(int i, String str, String str2);

    private native void nativeSetup(Object obj);

    @Keep
    public static boolean onNativeInvoke(Object obj, int i, Bundle bundle) {
        if (obj == null || !(obj instanceof WeakReference)) {
            CyberLog.e("DuMediaExtractor", "<null weakThiz>.onNativeInvoke()");
            return false;
        }
        return false;
    }

    public void b() {
        synchronized (this) {
            nativeRelease();
            this.mNativeDuMediaExtractor = 0L;
        }
    }

    public void c(int i, String str, long j) {
        nativeSetOption(i, str, j);
    }

    public void d(int i, String str, String str2) {
        nativeSetOption(i, str, str2);
    }

    public void e(Context context, Uri uri, Map<String, String> map) {
        g(uri.toString(), map);
    }

    public void f(String str) {
        nativeSetDataSource(str, null, null);
        nativePrepare();
    }

    public void g(String str, Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey().equals("Referer")) {
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(value)) {
                        d(1, Config.LAUNCH_REFERER, value);
                    }
                } else {
                    sb.append(entry.getKey());
                    sb.append(": ");
                    if (!TextUtils.isEmpty(entry.getValue())) {
                        sb.append(entry.getValue());
                    }
                    sb.append(Part.CRLF);
                }
            }
            d(1, "headers", sb.toString());
        }
        f(str);
    }

    public Bundle h() {
        return nativeGetMediaMeta();
    }

    public final void i() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            new a(this, myLooper);
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            new a(this, mainLooper);
        }
    }
}
