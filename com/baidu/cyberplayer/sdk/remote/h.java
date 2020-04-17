package com.baidu.cyberplayer.sdk.remote;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.PlayerProvider;
import com.baidu.cyberplayer.sdk.remote.b;
import com.baidu.cyberplayer.sdk.remote.d;
import com.baidu.cyberplayer.sdk.remote.g;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h extends PlayerProvider implements g.b {
    private com.baidu.cyberplayer.sdk.remote.b a;
    private CyberPlayerManager.HttpDNS b;
    private CyberPlayerManager.OnPreparedListener c;
    private CyberPlayerManager.OnCompletionListener d;
    private CyberPlayerManager.OnBufferingUpdateListener e;
    private CyberPlayerManager.OnSeekCompleteListener f;
    private CyberPlayerManager.OnVideoSizeChangedListener g;
    private CyberPlayerManager.OnErrorListener h;
    private CyberPlayerManager.OnInfoListener i;
    private a j = new a(this);
    private Surface k;
    private b l;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends Handler {
        private final WeakReference<h> a;

        public a(h hVar) {
            this.a = new WeakReference<>(hVar);
        }

        private static void a(h hVar, String str) {
            Object obj;
            try {
                if (TextUtils.isEmpty(str) || (obj = new JSONObject(str).get("first_disp_notify_time")) == null || !(obj instanceof String)) {
                    return;
                }
                long parseLong = Long.parseLong((String) obj);
                if (parseLong > 0) {
                    long elapsedRealtime = SystemClock.elapsedRealtime() - parseLong;
                    CyberLog.i("RemotePlayerProxy", "costTime:" + elapsedRealtime);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("notify_fsp_thread_cost", elapsedRealtime);
                    hVar.sendCommand(1003, DpStatConstants.SESSION_TYPE_FIRST_SCREEN, 0L, jSONObject.toString());
                }
            } catch (JSONException e) {
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            h hVar = this.a.get();
            if (hVar == null) {
                return;
            }
            switch (message.what) {
                case 0:
                    if (hVar.c != null) {
                        hVar.c.onPrepared();
                        return;
                    }
                    return;
                case 1:
                    if (hVar.d != null) {
                        hVar.d.onCompletion();
                        return;
                    }
                    return;
                case 2:
                    if (hVar.e != null) {
                        hVar.e.onBufferingUpdate(message.arg1);
                        return;
                    }
                    return;
                case 3:
                    if (hVar.f != null) {
                        hVar.f.onSeekComplete();
                        return;
                    }
                    return;
                case 4:
                    if (hVar.g != null) {
                        int[] iArr = (int[]) message.obj;
                        hVar.g.onVideoSizeChanged(iArr[0], iArr[1], iArr[2], iArr[3]);
                        return;
                    }
                    return;
                case 5:
                    if (hVar.h != null) {
                        hVar.h.onError(message.arg1, message.arg2, message.obj);
                        return;
                    }
                    return;
                case 6:
                    if (hVar.i != null) {
                        hVar.i.onInfo(message.arg1, message.arg2, message.obj);
                    }
                    if (904 == message.arg1) {
                        a(hVar, (String) message.obj);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes.dex */
    private static class b extends d.a {
        private a a;
        private CyberPlayerManager.HttpDNS b;

        public b(a aVar, CyberPlayerManager.HttpDNS httpDNS) {
            this.a = aVar;
            this.b = httpDNS;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public void a() {
            if (this.a != null) {
                this.a.sendEmptyMessage(0);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public void a(int i) {
            if (this.a != null) {
                Message obtain = Message.obtain(this.a, 2);
                obtain.arg1 = i;
                this.a.sendMessage(obtain);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public void a(int i, int i2, int i3, int i4) {
            if (this.a != null) {
                Message obtain = Message.obtain(this.a, 4);
                obtain.obj = new int[]{i, i2, i3, i4};
                this.a.sendMessage(obtain);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public void a(String str, List<String> list) {
            if (str.equals("onHttpDNS")) {
                if (this.b == null || list == null || list.size() <= 0) {
                    if (list != null) {
                        list.clear();
                        return;
                    }
                    return;
                }
                list.clear();
                List<String> ipList = this.b.getIpList(list.get(0));
                if (ipList != null) {
                    list.addAll(ipList);
                }
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public boolean a(int i, int i2, String str) {
            if (this.a != null) {
                Message obtain = Message.obtain(this.a, 5);
                obtain.arg1 = i;
                obtain.arg2 = i2;
                obtain.obj = str;
                this.a.sendMessage(obtain);
                return true;
            }
            return true;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public synchronized void b() {
            if (this.a != null) {
                this.a.sendEmptyMessage(1);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public boolean b(int i, int i2, String str) {
            if (this.a != null) {
                Message obtain = Message.obtain(this.a, 6);
                obtain.arg1 = i;
                obtain.arg2 = i2;
                obtain.obj = str;
                this.a.sendMessage(obtain);
                return true;
            }
            return true;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public void c() {
            if (this.a != null) {
                this.a.sendEmptyMessage(3);
            }
        }

        public void d() {
            this.a = null;
            this.b = null;
        }
    }

    private h(com.baidu.cyberplayer.sdk.remote.b bVar, CyberPlayerManager.HttpDNS httpDNS) {
        this.a = bVar;
        this.b = httpDNS;
        this.l = new b(this.j, httpDNS);
        if (this.a != null) {
            try {
                this.a.a(this.l);
                g.a().a(this);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public static h a(int i, CyberPlayerManager.HttpDNS httpDNS) {
        com.baidu.cyberplayer.sdk.remote.b a2 = b.a.a(g.a().a(i));
        if (a2 != null) {
            return new h(a2, httpDNS);
        }
        return null;
    }

    private void a(Uri uri, Map<String, String> map) {
        if (this.a == null) {
            return;
        }
        try {
            this.a.a(new e(uri, map));
        } catch (RemoteException e) {
            e.printStackTrace();
            if (this.h != null) {
                this.h.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.g.b
    public void a() {
        if (this.j != null) {
            Message obtain = Message.obtain(this.j, 5);
            obtain.arg1 = CyberPlayerManager.MEDIA_ERROR_REMOTE_DIED;
            obtain.arg2 = 0;
            obtain.obj = null;
            this.j.sendMessage(obtain);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void changeProxyDynamic(String str, boolean z) {
        if (this.a == null) {
            return;
        }
        try {
            this.a.a(str, z);
        } catch (RemoteException e) {
            e.printStackTrace();
            if (this.h != null) {
                this.h.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPosition() {
        if (this.a != null) {
            try {
                return this.a.i();
            } catch (RemoteException e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPositionSync() {
        if (this.a != null) {
            try {
                return this.a.j();
            } catch (RemoteException e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getDecodeMode() {
        if (this.a != null) {
            try {
                return this.a.a();
            } catch (RemoteException e) {
                e.printStackTrace();
                if (this.h != null) {
                    this.h.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
                    return 0;
                }
                return 0;
            }
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getDownloadSpeed() {
        if (this.a != null) {
            try {
                return this.a.p();
            } catch (RemoteException e) {
                e.printStackTrace();
                return 0L;
            }
        }
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getDuration() {
        if (this.a != null) {
            try {
                return this.a.k();
            } catch (RemoteException e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getPlayedTime() {
        if (this.a != null) {
            try {
                return this.a.o();
            } catch (RemoteException e) {
                e.printStackTrace();
                return 0L;
            }
        }
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoHeight() {
        if (this.a != null) {
            try {
                return this.a.g();
            } catch (RemoteException e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoWidth() {
        if (this.a != null) {
            try {
                return this.a.f();
            } catch (RemoteException e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isLooping() {
        if (this.a != null) {
            try {
                return this.a.n();
            } catch (RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isPlaying() {
        if (this.a != null) {
            try {
                return this.a.h();
            } catch (RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isRemotePlayer() {
        return true;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void muteOrUnmuteAudio(boolean z) {
        if (this.a == null) {
            return;
        }
        try {
            this.a.d(z);
        } catch (RemoteException e) {
            e.printStackTrace();
            if (this.h != null) {
                this.h.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void pause() {
        if (this.a == null) {
            return;
        }
        try {
            this.a.e();
        } catch (RemoteException e) {
            e.printStackTrace();
            if (this.h != null) {
                this.h.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void prepareAsync() {
        if (this.a == null) {
            return;
        }
        try {
            this.a.b();
        } catch (RemoteException e) {
            e.printStackTrace();
            if (this.h != null) {
                this.h.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.cyberplayer.sdk.remote.h$a */
    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: com.baidu.cyberplayer.sdk.remote.h$a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.baidu.cyberplayer.sdk.CyberPlayerManager$OnCompletionListener, android.view.Surface, com.baidu.cyberplayer.sdk.CyberPlayerManager$OnPreparedListener, com.baidu.cyberplayer.sdk.CyberPlayerManager$OnInfoListener, com.baidu.cyberplayer.sdk.CyberPlayerManager$OnBufferingUpdateListener, com.baidu.cyberplayer.sdk.CyberPlayerManager$OnErrorListener, com.baidu.cyberplayer.sdk.CyberPlayerManager$OnVideoSizeChangedListener, com.baidu.cyberplayer.sdk.CyberPlayerManager$HttpDNS, com.baidu.cyberplayer.sdk.remote.b, com.baidu.cyberplayer.sdk.remote.h$b, java.lang.Object, com.baidu.cyberplayer.sdk.remote.h$a, com.baidu.cyberplayer.sdk.CyberPlayerManager$OnSeekCompleteListener] */
    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void release() {
        if (this.a == null) {
            return;
        }
        try {
            this.a.b(this.l);
            this.a.l();
        } catch (RemoteException e) {
            e.printStackTrace();
        } finally {
            g.a().b(this);
            this.a = null;
            this.k = null;
            this.j.removeCallbacksAndMessages(null);
            this.l.d();
            this.l = null;
            this.j = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = null;
            this.i = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void reset() {
        if (this.a == null) {
            return;
        }
        try {
            this.a.m();
            this.j.removeCallbacksAndMessages(null);
        } catch (RemoteException e) {
            e.printStackTrace();
            if (this.h != null) {
                this.h.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void seekTo(long j) {
        if (this.a == null) {
            return;
        }
        try {
            this.a.a(j);
        } catch (RemoteException e) {
            e.printStackTrace();
            if (this.h != null) {
                this.h.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void sendCommand(int i, int i2, long j, String str) {
        if (this.a == null) {
            return;
        }
        try {
            this.a.a(i, i2, j, str);
        } catch (RemoteException e) {
            e.printStackTrace();
            if (this.h != null) {
                this.h.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(Context context, Uri uri) {
        a(uri, (Map<String, String>) null);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        a(uri, map);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(FileDescriptor fileDescriptor) {
        if (this.h != null) {
            this.h.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(String str) {
        a(Uri.parse(str), (Map<String, String>) null);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDisplay(SurfaceHolder surfaceHolder) {
        Surface surface;
        if (this.a == null) {
            return;
        }
        if (surfaceHolder != null) {
            try {
                surface = surfaceHolder.getSurface();
            } catch (RemoteException e) {
                e.printStackTrace();
                if (this.h != null) {
                    this.h.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
                    return;
                }
                return;
            }
        } else {
            surface = null;
        }
        this.a.a(surface);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setEnableDumediaUA(boolean z) {
        if (this.a == null) {
            return;
        }
        try {
            this.a.c(z);
        } catch (RemoteException e) {
            e.printStackTrace();
            if (this.h != null) {
                this.h.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setLooping(boolean z) {
        if (this.a == null) {
            return;
        }
        try {
            this.a.b(z);
        } catch (RemoteException e) {
            e.printStackTrace();
            if (this.h != null) {
                this.h.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.e = onBufferingUpdateListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.d = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.h = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.i = onInfoListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.c = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.f = onSeekCompleteListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.g = onVideoSizeChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOption(String str, long j) {
        setOption(str, String.valueOf(j));
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOption(String str, String str2) {
        if (this.a == null) {
            return;
        }
        try {
            this.a.a(str, str2);
        } catch (RemoteException e) {
            e.printStackTrace();
            if (this.h != null) {
                this.h.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setScreenOnWhilePlaying(boolean z) {
        if (this.a == null) {
            return;
        }
        try {
            this.a.a(z);
        } catch (RemoteException e) {
            e.printStackTrace();
            if (this.h != null) {
                this.h.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSpeed(float f) {
        if (this.a == null) {
            return;
        }
        try {
            this.a.a(f);
        } catch (RemoteException e) {
            e.printStackTrace();
            if (this.h != null) {
                this.h.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSurface(Surface surface) {
        if (this.a == null) {
            return;
        }
        if (this.k != surface || this.k == null) {
            try {
                this.a.a(surface);
                this.k = surface;
            } catch (RemoteException e) {
                e.printStackTrace();
                if (this.h != null) {
                    this.h.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
                }
                this.k = null;
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setVolume(float f, float f2) {
        if (this.a == null) {
            return;
        }
        try {
            this.a.a(f, f2);
        } catch (RemoteException e) {
            e.printStackTrace();
            if (this.h != null) {
                this.h.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setWakeMode(Context context, int i) {
        if (this.a == null) {
            return;
        }
        try {
            this.a.a(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            if (this.h != null) {
                this.h.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void start() {
        if (this.a == null) {
            return;
        }
        try {
            this.a.c();
        } catch (RemoteException e) {
            e.printStackTrace();
            if (this.h != null) {
                this.h.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void stop() {
        if (this.a == null) {
            return;
        }
        try {
            this.a.d();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
