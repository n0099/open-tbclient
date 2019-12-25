package com.baidu.cyberplayer.sdk.remote;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.PlayerProvider;
import com.baidu.cyberplayer.sdk.remote.a;
import com.baidu.cyberplayer.sdk.remote.c;
import com.baidu.cyberplayer.sdk.remote.f;
import java.io.FileDescriptor;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class g extends PlayerProvider implements f.b {
    private a a;
    private CyberPlayerManager.HttpDNS b;
    private CyberPlayerManager.OnPreparedListener c;
    private CyberPlayerManager.OnCompletionListener d;
    private CyberPlayerManager.OnBufferingUpdateListener e;
    private CyberPlayerManager.OnSeekCompleteListener f;
    private CyberPlayerManager.OnVideoSizeChangedListener g;
    private CyberPlayerManager.OnErrorListener h;
    private CyberPlayerManager.OnInfoListener i;
    private Handler j;
    private c.a k = new c.a() { // from class: com.baidu.cyberplayer.sdk.remote.g.1
        @Override // com.baidu.cyberplayer.sdk.remote.c
        public void a() {
            if (g.this.j != null) {
                g.this.j.sendEmptyMessage(0);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.c
        public void a(int i) {
            if (g.this.j != null) {
                Message obtain = Message.obtain(g.this.j, 2);
                obtain.arg1 = i;
                g.this.j.sendMessage(obtain);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.c
        public void a(int i, int i2, int i3, int i4) {
            if (g.this.j != null) {
                Message obtain = Message.obtain(g.this.j, 4);
                obtain.obj = new int[]{i, i2, i3, i4};
                g.this.j.sendMessage(obtain);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.c
        public void a(String str, List<String> list) {
            if (!str.equals("onHttpDNS") || g.this.b == null || list == null || list.size() <= 0) {
                return;
            }
            list.clear();
            List<String> ipList = g.this.b.getIpList(list.get(0));
            if (ipList != null) {
                list.addAll(ipList);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.c
        public boolean a(int i, int i2, String str) {
            if (g.this.j != null) {
                Message obtain = Message.obtain(g.this.j, 5);
                obtain.arg1 = i;
                obtain.arg2 = i2;
                obtain.obj = str;
                g.this.j.sendMessage(obtain);
                return true;
            }
            return true;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.c
        public void b() {
            if (g.this.j != null) {
                g.this.j.sendEmptyMessage(1);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.c
        public boolean b(int i, int i2, String str) {
            if (g.this.j != null) {
                Message obtain = Message.obtain(g.this.j, 6);
                obtain.arg1 = i;
                obtain.arg2 = i2;
                obtain.obj = str;
                g.this.j.sendMessage(obtain);
                return true;
            }
            return true;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.c
        public void c() {
            if (g.this.j != null) {
                g.this.j.sendEmptyMessage(3);
            }
        }
    };

    private g(a aVar, CyberPlayerManager.HttpDNS httpDNS) {
        this.a = aVar;
        this.b = httpDNS;
        b();
        if (this.a != null) {
            try {
                this.a.a(this.k);
                f.a().a(this);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public static g a(int i, CyberPlayerManager.HttpDNS httpDNS) {
        a a = a.AbstractBinderC0055a.a(f.a().a(i));
        if (a != null) {
            return new g(a, httpDNS);
        }
        return null;
    }

    private void a(Uri uri, Map<String, String> map) {
        if (this.a == null) {
            return;
        }
        try {
            this.a.a(new d(uri, map));
        } catch (RemoteException e) {
            e.printStackTrace();
            if (this.h != null) {
                this.h.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @SuppressLint({"HandlerLeak"})
    private void b() {
        this.j = new Handler() { // from class: com.baidu.cyberplayer.sdk.remote.g.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (g.this.a == null) {
                    return;
                }
                switch (message.what) {
                    case 0:
                        if (g.this.c != null) {
                            g.this.c.onPrepared();
                            return;
                        }
                        return;
                    case 1:
                        if (g.this.d != null) {
                            g.this.d.onCompletion();
                            return;
                        }
                        return;
                    case 2:
                        if (g.this.e != null) {
                            g.this.e.onBufferingUpdate(message.arg1);
                            return;
                        }
                        return;
                    case 3:
                        if (g.this.f != null) {
                            g.this.f.onSeekComplete();
                            return;
                        }
                        return;
                    case 4:
                        if (g.this.g != null) {
                            int[] iArr = (int[]) message.obj;
                            g.this.g.onVideoSizeChanged(iArr[0], iArr[1], iArr[2], iArr[3]);
                            return;
                        }
                        return;
                    case 5:
                        if (g.this.h != null) {
                            g.this.h.onError(message.arg1, message.arg2, message.obj);
                            return;
                        }
                        return;
                    case 6:
                        if (g.this.i != null) {
                            g.this.i.onInfo(message.arg1, message.arg2, message.obj);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
    }

    @Override // com.baidu.cyberplayer.sdk.remote.f.b
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
    public void muteOrUnmuteAudio(boolean z) {
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

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void release() {
        if (this.a == null) {
            return;
        }
        try {
            this.a.l();
            this.a.b(this.k);
        } catch (RemoteException e) {
            e.printStackTrace();
        } finally {
            f.a().b(this);
            this.a = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void reset() {
        if (this.a == null) {
            return;
        }
        try {
            this.a.m();
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
        try {
            this.a.a(surface);
        } catch (RemoteException e) {
            e.printStackTrace();
            if (this.h != null) {
                this.h.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
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
