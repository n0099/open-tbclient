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

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.cyberplayer.sdk.remote.b f5031a;

    /* renamed from: b  reason: collision with root package name */
    public CyberPlayerManager.HttpDNS f5032b;

    /* renamed from: c  reason: collision with root package name */
    public CyberPlayerManager.OnPreparedListener f5033c;

    /* renamed from: d  reason: collision with root package name */
    public CyberPlayerManager.OnCompletionListener f5034d;

    /* renamed from: e  reason: collision with root package name */
    public CyberPlayerManager.OnBufferingUpdateListener f5035e;

    /* renamed from: f  reason: collision with root package name */
    public CyberPlayerManager.OnSeekCompleteListener f5036f;

    /* renamed from: g  reason: collision with root package name */
    public CyberPlayerManager.OnVideoSizeChangedListener f5037g;

    /* renamed from: h  reason: collision with root package name */
    public CyberPlayerManager.OnErrorListener f5038h;
    public CyberPlayerManager.OnInfoListener i;
    public CyberPlayerManager.OnMediaSourceChangedListener j;
    public a k = new a(this);
    public Surface l;
    public b m;

    /* loaded from: classes.dex */
    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<h> f5039a;

        public a(h hVar) {
            this.f5039a = new WeakReference<>(hVar);
        }

        public static void a(h hVar, String str) {
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
            } catch (JSONException unused) {
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            h hVar = this.f5039a.get();
            if (hVar == null) {
                return;
            }
            switch (message.what) {
                case 0:
                    if (hVar.f5033c != null) {
                        hVar.f5033c.onPrepared();
                        return;
                    }
                    return;
                case 1:
                    if (hVar.f5034d != null) {
                        hVar.f5034d.onCompletion();
                        return;
                    }
                    return;
                case 2:
                    if (hVar.f5035e != null) {
                        hVar.f5035e.onBufferingUpdate(message.arg1);
                        return;
                    }
                    return;
                case 3:
                    if (hVar.f5036f != null) {
                        hVar.f5036f.onSeekComplete();
                        return;
                    }
                    return;
                case 4:
                    if (hVar.f5037g != null) {
                        int[] iArr = (int[]) message.obj;
                        hVar.f5037g.onVideoSizeChanged(iArr[0], iArr[1], iArr[2], iArr[3]);
                        return;
                    }
                    return;
                case 5:
                    if (hVar.f5038h != null) {
                        hVar.f5038h.onError(message.arg1, message.arg2, message.obj);
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

    /* loaded from: classes.dex */
    public static class b extends d.a {

        /* renamed from: a  reason: collision with root package name */
        public a f5040a;

        /* renamed from: b  reason: collision with root package name */
        public CyberPlayerManager.HttpDNS f5041b;

        public b(a aVar, CyberPlayerManager.HttpDNS httpDNS) {
            this.f5040a = aVar;
            this.f5041b = httpDNS;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public void a() {
            a aVar = this.f5040a;
            if (aVar != null) {
                aVar.sendEmptyMessage(0);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public void a(int i) {
            a aVar = this.f5040a;
            if (aVar != null) {
                Message obtain = Message.obtain(aVar, 2);
                obtain.arg1 = i;
                this.f5040a.sendMessage(obtain);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public void a(int i, int i2, int i3, int i4) {
            a aVar = this.f5040a;
            if (aVar != null) {
                Message obtain = Message.obtain(aVar, 4);
                obtain.obj = new int[]{i, i2, i3, i4};
                this.f5040a.sendMessage(obtain);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public void a(String str, List<String> list) {
            if (str.equals("onHttpDNS")) {
                if (this.f5041b == null || list == null || list.size() <= 0) {
                    if (list != null) {
                        list.clear();
                        return;
                    }
                    return;
                }
                list.clear();
                List<String> ipList = this.f5041b.getIpList(list.get(0));
                if (ipList != null) {
                    list.addAll(ipList);
                }
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public boolean a(int i, int i2, String str) {
            a aVar = this.f5040a;
            if (aVar != null) {
                Message obtain = Message.obtain(aVar, 5);
                obtain.arg1 = i;
                obtain.arg2 = i2;
                obtain.obj = str;
                this.f5040a.sendMessage(obtain);
                return true;
            }
            return true;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public synchronized void b() {
            if (this.f5040a != null) {
                this.f5040a.sendEmptyMessage(1);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public boolean b(int i, int i2, String str) {
            a aVar = this.f5040a;
            if (aVar != null) {
                Message obtain = Message.obtain(aVar, 6);
                obtain.arg1 = i;
                obtain.arg2 = i2;
                obtain.obj = str;
                this.f5040a.sendMessage(obtain);
                return true;
            }
            return true;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public void c() {
            a aVar = this.f5040a;
            if (aVar != null) {
                aVar.sendEmptyMessage(3);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public boolean c(int i, int i2, String str) {
            a aVar = this.f5040a;
            if (aVar != null) {
                Message obtain = Message.obtain(aVar, 7);
                obtain.arg1 = i;
                obtain.arg2 = i2;
                obtain.obj = str;
                this.f5040a.sendMessage(obtain);
                return true;
            }
            return true;
        }

        public void d() {
            this.f5040a = null;
            this.f5041b = null;
        }
    }

    public h(com.baidu.cyberplayer.sdk.remote.b bVar, CyberPlayerManager.HttpDNS httpDNS) {
        this.f5031a = bVar;
        this.f5032b = httpDNS;
        b bVar2 = new b(this.k, httpDNS);
        this.m = bVar2;
        com.baidu.cyberplayer.sdk.remote.b bVar3 = this.f5031a;
        if (bVar3 != null) {
            try {
                bVar3.a(bVar2);
                g.a().a(this);
            } catch (RemoteException e2) {
                e2.printStackTrace();
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
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f5031a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.a(new e(uri, map));
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f5038h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.g.b
    public void a() {
        a aVar = this.k;
        if (aVar != null) {
            Message obtain = Message.obtain(aVar, 5);
            obtain.arg1 = CyberPlayerManager.MEDIA_ERROR_REMOTE_DIED;
            obtain.arg2 = 0;
            obtain.obj = null;
            this.k.sendMessage(obtain);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void changeProxyDynamic(String str, boolean z) {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f5031a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.a(str, z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f5038h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPosition() {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f5031a;
        if (bVar != null) {
            try {
                return bVar.i();
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPositionSync() {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f5031a;
        if (bVar != null) {
            try {
                return bVar.j();
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getDecodeMode() {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f5031a;
        if (bVar != null) {
            try {
                return bVar.a();
            } catch (RemoteException e2) {
                e2.printStackTrace();
                CyberPlayerManager.OnErrorListener onErrorListener = this.f5038h;
                if (onErrorListener != null) {
                    onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
                    return 0;
                }
                return 0;
            }
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getDownloadSpeed() {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f5031a;
        if (bVar != null) {
            try {
                return bVar.p();
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getDuration() {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f5031a;
        if (bVar != null) {
            try {
                return bVar.k();
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getPlayedTime() {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f5031a;
        if (bVar != null) {
            try {
                return bVar.o();
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoHeight() {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f5031a;
        if (bVar != null) {
            try {
                return bVar.g();
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoWidth() {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f5031a;
        if (bVar != null) {
            try {
                return bVar.f();
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isLooping() {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f5031a;
        if (bVar != null) {
            try {
                return bVar.n();
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isPlaying() {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f5031a;
        if (bVar != null) {
            try {
                return bVar.h();
            } catch (RemoteException e2) {
                e2.printStackTrace();
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
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f5031a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.d(z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f5038h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void pause() {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f5031a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.e();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f5038h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void prepareAsync() {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f5031a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.b();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f5038h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.cyberplayer.sdk.remote.h$a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.baidu.cyberplayer.sdk.CyberPlayerManager$OnCompletionListener, android.view.Surface, com.baidu.cyberplayer.sdk.CyberPlayerManager$OnPreparedListener, com.baidu.cyberplayer.sdk.CyberPlayerManager$OnMediaSourceChangedListener, com.baidu.cyberplayer.sdk.CyberPlayerManager$OnInfoListener, com.baidu.cyberplayer.sdk.CyberPlayerManager$OnBufferingUpdateListener, com.baidu.cyberplayer.sdk.CyberPlayerManager$OnErrorListener, com.baidu.cyberplayer.sdk.CyberPlayerManager$OnVideoSizeChangedListener, com.baidu.cyberplayer.sdk.CyberPlayerManager$HttpDNS, com.baidu.cyberplayer.sdk.remote.b, com.baidu.cyberplayer.sdk.remote.h$b, java.lang.Object, com.baidu.cyberplayer.sdk.remote.h$a, com.baidu.cyberplayer.sdk.CyberPlayerManager$OnSeekCompleteListener] */
    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void release() {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f5031a;
        if (bVar == null) {
            return;
        }
        try {
            try {
                bVar.b(this.m);
                this.f5031a.l();
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        } finally {
            g.a().b(this);
            this.f5031a = null;
            this.l = null;
            this.k.removeCallbacksAndMessages(null);
            this.m.d();
            this.m = null;
            this.k = null;
            this.f5032b = null;
            this.f5033c = null;
            this.f5034d = null;
            this.f5035e = null;
            this.f5036f = null;
            this.f5037g = null;
            this.f5038h = null;
            this.i = null;
            this.j = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void reset() {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f5031a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.m();
            this.k.removeCallbacksAndMessages(null);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f5038h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void seekTo(long j) {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f5031a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.a(j);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f5038h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void sendCommand(int i, int i2, long j, String str) {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f5031a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.a(i, i2, j, str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f5038h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setClarityInfo(String str) {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f5031a;
        if (bVar != null) {
            try {
                bVar.a(str);
            } catch (RemoteException e2) {
                e2.printStackTrace();
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
        CyberPlayerManager.OnErrorListener onErrorListener = this.f5038h;
        if (onErrorListener != null) {
            onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
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
        if (this.f5031a == null) {
            return;
        }
        if (surfaceHolder != null) {
            try {
                surface = surfaceHolder.getSurface();
            } catch (RemoteException e2) {
                e2.printStackTrace();
                CyberPlayerManager.OnErrorListener onErrorListener = this.f5038h;
                if (onErrorListener != null) {
                    onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
                    return;
                }
                return;
            }
        } else {
            surface = null;
        }
        this.f5031a.a(surface);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setEnableDumediaUA(boolean z) {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f5031a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.c(z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f5038h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setLooping(boolean z) {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f5031a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.b(z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f5038h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.f5035e = onBufferingUpdateListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.f5034d = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.f5038h = onErrorListener;
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
        this.f5033c = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.f5036f = onSeekCompleteListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.f5037g = onVideoSizeChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOption(String str, long j) {
        setOption(str, String.valueOf(j));
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOption(String str, String str2) {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f5031a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.a(str, str2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f5038h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setPlayJson(String str) {
        try {
            if (this.f5031a != null) {
                this.f5031a.b(str);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f5038h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setScreenOnWhilePlaying(boolean z) {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f5031a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.a(z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f5038h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSpeed(float f2) {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f5031a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.a(f2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f5038h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSurface(Surface surface) {
        if (this.f5031a == null) {
            return;
        }
        Surface surface2 = this.l;
        if (surface2 != surface || surface2 == null) {
            try {
                this.f5031a.a(surface);
                this.l = surface;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                CyberPlayerManager.OnErrorListener onErrorListener = this.f5038h;
                if (onErrorListener != null) {
                    onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
                }
                this.l = null;
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setVolume(float f2, float f3) {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f5031a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.a(f2, f3);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f5038h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setWakeMode(Context context, int i) {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f5031a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.a(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f5038h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void start() {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f5031a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.c();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f5038h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void stop() {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f5031a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.d();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void switchMediaSource(int i) {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f5031a;
        if (bVar != null) {
            try {
                bVar.b(i);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }
}
