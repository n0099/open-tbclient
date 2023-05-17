package com.baidu.cyberplayer.sdk.remote;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
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
/* loaded from: classes3.dex */
public class h extends PlayerProvider implements g.b {
    public com.baidu.cyberplayer.sdk.remote.b a;
    public CyberPlayerManager.HttpDNS b;
    public CyberPlayerManager.OnPreparedListener c;
    public CyberPlayerManager.OnCompletionListener d;
    public CyberPlayerManager.OnBufferingUpdateListener e;
    public CyberPlayerManager.OnSeekCompleteListener f;
    public CyberPlayerManager.OnVideoSizeChangedListener g;
    public CyberPlayerManager.OnErrorListener h;
    public CyberPlayerManager.OnInfoListener i;
    public CyberPlayerManager.OnMediaSourceChangedListener j;
    public Surface l;
    public b m;
    public int n = -1;
    public int o = -1;
    public boolean p = false;
    public a k = new a(this);

    /* loaded from: classes3.dex */
    public static class a extends Handler {
        public final WeakReference<h> a;

        public a(h hVar) {
            this.a = new WeakReference<>(hVar);
        }

        public static void a(h hVar, String str) {
            Object obj;
            try {
                if (TextUtils.isEmpty(str) || (obj = new JSONObject(str).get("first_disp_notify_time")) == null || !(obj instanceof String)) {
                    return;
                }
                long parseLong = Long.parseLong((String) obj);
                if (parseLong > 0) {
                    long currentTimeMillis = System.currentTimeMillis() - parseLong;
                    CyberLog.i("RemotePlayerProxy", "costTime:" + currentTimeMillis);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("notify_fsp_thread_cost", currentTimeMillis);
                    hVar.sendCommand(1003, DpStatConstants.SESSION_TYPE_FIRST_SCREEN, 0L, jSONObject.toString());
                }
            } catch (JSONException unused) {
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
                    int i = message.arg1;
                    if (904 == i) {
                        a(hVar, (String) message.obj);
                        return;
                    } else if (910 == i) {
                        hVar.o = message.arg2;
                        return;
                    } else {
                        return;
                    }
                case 7:
                    if (hVar.j != null) {
                        hVar.j.onMediaSourceChanged(message.arg1, message.arg2, message.obj);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends d.a {
        public a a;
        public CyberPlayerManager.HttpDNS b;

        public b(a aVar, CyberPlayerManager.HttpDNS httpDNS) {
            this.a = aVar;
            this.b = httpDNS;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public void a() {
            a aVar = this.a;
            if (aVar != null) {
                aVar.sendEmptyMessage(0);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public void a(int i) {
            a aVar = this.a;
            if (aVar != null) {
                Message obtain = Message.obtain(aVar, 2);
                obtain.arg1 = i;
                this.a.sendMessage(obtain);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public void a(int i, int i2, int i3, int i4) {
            a aVar = this.a;
            if (aVar != null) {
                Message obtain = Message.obtain(aVar, 4);
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
            a aVar = this.a;
            if (aVar != null) {
                Message obtain = Message.obtain(aVar, 5);
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
            a aVar = this.a;
            if (aVar != null) {
                Message obtain = Message.obtain(aVar, 6);
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
            a aVar = this.a;
            if (aVar != null) {
                aVar.sendEmptyMessage(3);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public boolean c(int i, int i2, String str) {
            a aVar = this.a;
            if (aVar != null) {
                Message obtain = Message.obtain(aVar, 7);
                obtain.arg1 = i;
                obtain.arg2 = i2;
                obtain.obj = str;
                this.a.sendMessage(obtain);
                return true;
            }
            return true;
        }

        public void d() {
            this.a = null;
            this.b = null;
        }
    }

    public h(com.baidu.cyberplayer.sdk.remote.b bVar, CyberPlayerManager.HttpDNS httpDNS) {
        this.a = bVar;
        this.b = httpDNS;
        b bVar2 = new b(this.k, httpDNS);
        this.m = bVar2;
        com.baidu.cyberplayer.sdk.remote.b bVar3 = this.a;
        if (bVar3 != null) {
            try {
                bVar3.a(bVar2);
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
        com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.a(new e(uri, map));
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setDataSource(Uri, Map)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.g.b
    public void a() {
        a aVar = this.k;
        if (aVar != null) {
            Message obtain = Message.obtain(aVar, 5);
            obtain.arg1 = CyberPlayerManager.MEDIA_ERROR_REMOTE_DIED;
            obtain.arg2 = CyberPlayerManager.MEDIA_ERROR_REMOTE_DIED;
            obtain.obj = "binderDied";
            this.p = true;
            this.k.sendMessage(obtain);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void changeProxyDynamic(String str, boolean z) {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.a(str, z);
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "changeProxyDynamic(String, boolean)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPosition() {
        int i = this.o;
        if (i > -1) {
            return i;
        }
        com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
        if (bVar != null) {
            try {
                return bVar.i();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPositionSync() {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
        if (bVar != null) {
            try {
                return bVar.j();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getDecodeMode() {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
        if (bVar != null) {
            try {
                return bVar.a();
            } catch (RemoteException e) {
                e.printStackTrace();
                CyberPlayerManager.OnErrorListener onErrorListener = this.h;
                if (onErrorListener != null) {
                    onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "getDecodeMode() mIsBinderDied:" + this.p);
                }
            }
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getDownloadSpeed() {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
        if (bVar != null) {
            try {
                return bVar.p();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getDuration() {
        int i = this.n;
        if (i > -1) {
            return i;
        }
        com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
        if (bVar != null) {
            try {
                int k = bVar.k();
                this.n = k;
                return k;
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getPlayedTime() {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
        if (bVar != null) {
            try {
                return bVar.o();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoHeight() {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
        if (bVar != null) {
            try {
                return bVar.g();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoWidth() {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
        if (bVar != null) {
            try {
                return bVar.f();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isLooping() {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
        if (bVar != null) {
            try {
                return bVar.n();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isPlaying() {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
        if (bVar != null) {
            try {
                return bVar.h();
            } catch (RemoteException e) {
                e.printStackTrace();
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
        com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.d(z);
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "muteOrUnmuteAudio(boolean)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void pause() {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.e();
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "pause()");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void prepareAsync() {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.b();
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "prepareAsync()");
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.cyberplayer.sdk.remote.h$a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.baidu.cyberplayer.sdk.CyberPlayerManager$OnCompletionListener, android.view.Surface, com.baidu.cyberplayer.sdk.CyberPlayerManager$OnPreparedListener, com.baidu.cyberplayer.sdk.CyberPlayerManager$OnMediaSourceChangedListener, com.baidu.cyberplayer.sdk.CyberPlayerManager$OnInfoListener, com.baidu.cyberplayer.sdk.CyberPlayerManager$OnBufferingUpdateListener, com.baidu.cyberplayer.sdk.CyberPlayerManager$OnErrorListener, com.baidu.cyberplayer.sdk.CyberPlayerManager$OnVideoSizeChangedListener, com.baidu.cyberplayer.sdk.CyberPlayerManager$HttpDNS, com.baidu.cyberplayer.sdk.remote.b, com.baidu.cyberplayer.sdk.remote.h$b, java.lang.Object, com.baidu.cyberplayer.sdk.remote.h$a, com.baidu.cyberplayer.sdk.CyberPlayerManager$OnSeekCompleteListener] */
    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void release() {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
        if (bVar == null) {
            return;
        }
        try {
            try {
                bVar.b(this.m);
                this.a.l();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } finally {
            g.a().b(this);
            this.a = null;
            this.l = null;
            this.k.removeCallbacksAndMessages(null);
            this.m.d();
            this.m = null;
            this.k = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = null;
            this.i = null;
            this.j = null;
            this.n = -1;
            this.o = -1;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void reset() {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.m();
            this.k.removeCallbacksAndMessages(null);
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "reset()");
            }
        }
        this.n = -1;
        this.o = -1;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void seekTo(long j) {
        seekTo(j, 3);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void seekTo(long j, int i) {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.a(j, i);
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "seekTo(long)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void sendCommand(int i, int i2, long j, String str) {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.a(i, i2, j, str);
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "sendCommand what:" + i + " arg1:" + i2 + " arg2:" + j + " isBinderDied:" + this.p);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setClarityInfo(String str) {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
        if (bVar != null) {
            try {
                bVar.a(str);
            } catch (RemoteException e) {
                e.printStackTrace();
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
        CyberPlayerManager.OnErrorListener onErrorListener = this.h;
        if (onErrorListener != null) {
            onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setDataSource(FileDescriptor)");
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(String str) {
        a(Uri.parse(str), (Map<String, String>) null);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(String str, Map<String, String> map) {
        a(Uri.parse(str), map);
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
                CyberPlayerManager.OnErrorListener onErrorListener = this.h;
                if (onErrorListener != null) {
                    onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setDisplay()");
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
        com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.c(z);
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setEnableDumediaUA(boolean)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setLooping(boolean z) {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.b(z);
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setLooping(boolean)");
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
    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        this.j = onMediaSourceChangedListener;
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
        com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.a(str, str2);
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setOption(String, String)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setPlayJson(String str) {
        try {
            if (this.a != null) {
                this.a.b(str);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setPlayJson(String)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setScreenOnWhilePlaying(boolean z) {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.a(z);
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setScreenOnWhilePlaying(boolean)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSpeed(float f) {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.a(f);
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setSpeed(float)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSurface(Surface surface) {
        if (this.a == null) {
            return;
        }
        Surface surface2 = this.l;
        if (surface2 != surface || surface2 == null) {
            try {
                this.a.a(surface);
                this.l = surface;
            } catch (RemoteException e) {
                e.printStackTrace();
                CyberPlayerManager.OnErrorListener onErrorListener = this.h;
                if (onErrorListener != null) {
                    onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setSurface()");
                }
                this.l = null;
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setVolume(float f, float f2) {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.a(f, f2);
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setVolume(float, float)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setWakeMode(Context context, int i) {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.a(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setWakeMode()");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void start() {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.c();
        } catch (RemoteException e) {
            e.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "start()");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void stop() {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.d();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void switchMediaSource(int i) {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.a;
        if (bVar != null) {
            try {
                bVar.b(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void updateDisplaySize(int i, int i2) {
        try {
            if (this.a != null) {
                this.a.a(i, i2);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
