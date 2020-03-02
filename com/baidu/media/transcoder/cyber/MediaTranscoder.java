package com.baidu.media.transcoder.cyber;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.media.transcoder.c;
import com.baidu.media.transcoder.d;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes6.dex */
public class MediaTranscoder extends c {
    private static final com.baidu.media.transcoder.cyber.a b = new com.baidu.media.transcoder.cyber.a() { // from class: com.baidu.media.transcoder.cyber.MediaTranscoder.1
        @Override // com.baidu.media.transcoder.cyber.a
        public void a(String str) {
            System.loadLibrary(str);
        }
    };
    private static volatile boolean c = false;
    private static volatile boolean d = false;
    private a a;
    private long mNativeTranscoder;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a extends Handler {
        private final MediaTranscoder aMJ;

        public a(MediaTranscoder mediaTranscoder, Looper looper) {
            super(looper);
            this.aMJ = mediaTranscoder;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            MediaTranscoder mediaTranscoder = this.aMJ;
            if (mediaTranscoder == null) {
                d.c("MediaTranscoder", "MediaTranscoder went away with unhandled events.");
                return;
            }
            switch (message.what) {
                case 0:
                    return;
                case 1:
                    d.b("MediaTranscoder", "MEDIA_PREPARED (" + message.arg1 + Constants.ACCEPT_TIME_SEPARATOR_SP + message.arg2 + ")");
                    mediaTranscoder.b();
                    return;
                case 2:
                    d.b("MediaTranscoder", "MEDIA_TRANSCODER_COMPLETE (" + message.arg1 + Constants.ACCEPT_TIME_SEPARATOR_SP + message.arg2 + ")");
                    mediaTranscoder.c();
                    return;
                case 3:
                    d.b("MediaTranscoder", "MEDIA_TRANSCODER_TERMINAL (" + message.arg1 + Constants.ACCEPT_TIME_SEPARATOR_SP + message.arg2 + ")");
                    mediaTranscoder.d();
                    return;
                case 100:
                    d.b("MediaTranscoder", "MEDIA_ERROR (" + message.arg1 + Constants.ACCEPT_TIME_SEPARATOR_SP + message.arg2 + ")");
                    if (!mediaTranscoder.a(message.arg1, message.arg2)) {
                    }
                    return;
                case 200:
                    d.b("MediaTranscoder", "MEDIA_INFO (" + message.arg1 + Constants.ACCEPT_TIME_SEPARATOR_SP + message.arg2 + message.obj + ")");
                    mediaTranscoder.a(message.arg1, message.arg2, message.obj);
                    return;
                default:
                    d.d("MediaTranscoder", "Unknown message type " + message.what);
                    return;
            }
        }
    }

    public MediaTranscoder() {
        this(b);
        d.b("MediaTranscoder", "Software decoder mode. SDK Version:" + getSDKVersion() + " Core Version:" + getCoreVersion());
    }

    public MediaTranscoder(com.baidu.media.transcoder.cyber.a aVar) {
        b(aVar);
    }

    private native String _getNativeVersion();

    private native int _getProgress();

    private native void _pause();

    private native void _prepareAsync();

    private native void _release();

    private native void _reset();

    private native void _setDataSource(String str);

    private native void _setOption(String str);

    private native void _setOption(String str, String str2);

    private native void _setOutputFile(String str);

    private native void _start();

    private native void _stop();

    public static void a(com.baidu.media.transcoder.cyber.a aVar) {
        synchronized (MediaTranscoder.class) {
            if (!c) {
                if (aVar == null) {
                    aVar = b;
                }
                d.b("MediaTranscoder", "loadLibrariesOnce ....");
                aVar.a("cbffmpeg");
                aVar.a("sdl");
                aVar.a("transcoder");
                c = true;
            }
        }
    }

    private boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        return split.length == 4 && split2.length == 4 && split[0].equalsIgnoreCase(split2[0]) && split[1].equalsIgnoreCase(split2[1]) && split[2].equalsIgnoreCase(split2[2]);
    }

    private void b(com.baidu.media.transcoder.cyber.a aVar) {
        a(aVar);
        e();
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.a = new a(this, myLooper);
        } else {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper != null) {
                this.a = new a(this, mainLooper);
            } else {
                this.a = null;
            }
        }
        native_setup(this);
    }

    private static void e() {
        synchronized (MediaTranscoder.class) {
            if (!d) {
                native_init();
                d = true;
            }
        }
    }

    private native void native_finalize();

    private static native void native_init();

    private native void native_setLogLevel(int i);

    private native void native_setup(Object obj);

    private static void postEventFromNative(Object obj, int i, int i2, int i3, Object obj2) {
        if (obj == null) {
            d.d("MediaTranscoder", "postEventFromNative weakThiz is null");
            return;
        }
        MediaTranscoder mediaTranscoder = (MediaTranscoder) obj;
        if (mediaTranscoder == null) {
            d.d("MediaTranscoder", "postEventFromNative weakThiz reference is null");
        } else if (mediaTranscoder.a != null) {
            d.a("MediaTranscoder", "postEventFromNative message type:" + i + ", arg1:" + i2 + ", arg2:" + i3 + ", obj:" + obj2);
            mediaTranscoder.a.sendMessage(mediaTranscoder.a.obtainMessage(i, i2, i3, obj2));
        }
    }

    public String getCoreVersion() {
        if (c) {
            return "1.0.2.153";
        }
        return null;
    }

    public int getCurrentPosition() {
        int i = 0;
        try {
            i = _getProgress();
        } catch (Exception e) {
        }
        d.b("MediaTranscoder", "getCurrentPosition: " + i);
        return i;
    }

    public int getMode() {
        return 1;
    }

    public String getSDKVersion() {
        return "1.0.2.153";
    }

    public int getTotalSize() {
        return 100;
    }

    public void pause() {
        _pause();
    }

    @Override // com.baidu.media.transcoder.a
    public void prepareAsync() {
        _prepareAsync();
    }

    @Override // com.baidu.media.transcoder.a
    public int probe() {
        return a(getSDKVersion(), getCoreVersion()) ? 90 : 0;
    }

    @Override // com.baidu.media.transcoder.a
    public void release() {
        a();
        _release();
    }

    public void reset() {
        _reset();
    }

    @Override // com.baidu.media.transcoder.a
    public void setDataSource(String str) {
        _setDataSource(str);
    }

    @Override // com.baidu.media.transcoder.a
    public void setNativeLogLevel(int i) {
        native_setLogLevel(i);
    }

    public void setOption(String str) {
        _setOption(str);
    }

    @Override // com.baidu.media.transcoder.a
    public void setOption(String str, String str2) {
        _setOption(str, str2);
    }

    @Override // com.baidu.media.transcoder.a
    public void setOutputFile(String str) {
        _setOutputFile(str);
    }

    @Override // com.baidu.media.transcoder.a
    public void start() {
        _start();
    }

    @Override // com.baidu.media.transcoder.a
    public void stop() {
        _stop();
    }
}
