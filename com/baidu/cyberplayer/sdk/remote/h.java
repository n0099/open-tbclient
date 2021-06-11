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
/* loaded from: classes2.dex */
public class h extends PlayerProvider implements g.b {

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.cyberplayer.sdk.remote.b f4961a;

    /* renamed from: b  reason: collision with root package name */
    public CyberPlayerManager.HttpDNS f4962b;

    /* renamed from: c  reason: collision with root package name */
    public CyberPlayerManager.OnPreparedListener f4963c;

    /* renamed from: d  reason: collision with root package name */
    public CyberPlayerManager.OnCompletionListener f4964d;

    /* renamed from: e  reason: collision with root package name */
    public CyberPlayerManager.OnBufferingUpdateListener f4965e;

    /* renamed from: f  reason: collision with root package name */
    public CyberPlayerManager.OnSeekCompleteListener f4966f;

    /* renamed from: g  reason: collision with root package name */
    public CyberPlayerManager.OnVideoSizeChangedListener f4967g;

    /* renamed from: h  reason: collision with root package name */
    public CyberPlayerManager.OnErrorListener f4968h;

    /* renamed from: i  reason: collision with root package name */
    public CyberPlayerManager.OnInfoListener f4969i;
    public CyberPlayerManager.OnMediaSourceChangedListener j;
    public Surface l;
    public b m;
    public int n = -1;
    public int o = -1;
    public a k = new a(this);

    /* loaded from: classes2.dex */
    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<h> f4970a;

        public a(h hVar) {
            this.f4970a = new WeakReference<>(hVar);
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
            h hVar = this.f4970a.get();
            if (hVar == null) {
                return;
            }
            switch (message.what) {
                case 0:
                    if (hVar.f4963c != null) {
                        hVar.f4963c.onPrepared();
                        return;
                    }
                    return;
                case 1:
                    if (hVar.f4964d != null) {
                        hVar.f4964d.onCompletion();
                        return;
                    }
                    return;
                case 2:
                    if (hVar.f4965e != null) {
                        hVar.f4965e.onBufferingUpdate(message.arg1);
                        return;
                    }
                    return;
                case 3:
                    if (hVar.f4966f != null) {
                        hVar.f4966f.onSeekComplete();
                        return;
                    }
                    return;
                case 4:
                    if (hVar.f4967g != null) {
                        int[] iArr = (int[]) message.obj;
                        hVar.f4967g.onVideoSizeChanged(iArr[0], iArr[1], iArr[2], iArr[3]);
                        return;
                    }
                    return;
                case 5:
                    if (hVar.f4968h != null) {
                        hVar.f4968h.onError(message.arg1, message.arg2, message.obj);
                        return;
                    }
                    return;
                case 6:
                    if (hVar.f4969i != null) {
                        hVar.f4969i.onInfo(message.arg1, message.arg2, message.obj);
                    }
                    int i2 = message.arg1;
                    if (904 == i2) {
                        a(hVar, (String) message.obj);
                        return;
                    } else if (910 == i2) {
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

    /* loaded from: classes2.dex */
    public static class b extends d.a {

        /* renamed from: a  reason: collision with root package name */
        public a f4971a;

        /* renamed from: b  reason: collision with root package name */
        public CyberPlayerManager.HttpDNS f4972b;

        public b(a aVar, CyberPlayerManager.HttpDNS httpDNS) {
            this.f4971a = aVar;
            this.f4972b = httpDNS;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public void a() {
            a aVar = this.f4971a;
            if (aVar != null) {
                aVar.sendEmptyMessage(0);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public void a(int i2) {
            a aVar = this.f4971a;
            if (aVar != null) {
                Message obtain = Message.obtain(aVar, 2);
                obtain.arg1 = i2;
                this.f4971a.sendMessage(obtain);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public void a(int i2, int i3, int i4, int i5) {
            a aVar = this.f4971a;
            if (aVar != null) {
                Message obtain = Message.obtain(aVar, 4);
                obtain.obj = new int[]{i2, i3, i4, i5};
                this.f4971a.sendMessage(obtain);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public void a(String str, List<String> list) {
            if (str.equals("onHttpDNS")) {
                if (this.f4972b == null || list == null || list.size() <= 0) {
                    if (list != null) {
                        list.clear();
                        return;
                    }
                    return;
                }
                list.clear();
                List<String> ipList = this.f4972b.getIpList(list.get(0));
                if (ipList != null) {
                    list.addAll(ipList);
                }
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public boolean a(int i2, int i3, String str) {
            a aVar = this.f4971a;
            if (aVar != null) {
                Message obtain = Message.obtain(aVar, 5);
                obtain.arg1 = i2;
                obtain.arg2 = i3;
                obtain.obj = str;
                this.f4971a.sendMessage(obtain);
                return true;
            }
            return true;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public synchronized void b() {
            if (this.f4971a != null) {
                this.f4971a.sendEmptyMessage(1);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public boolean b(int i2, int i3, String str) {
            a aVar = this.f4971a;
            if (aVar != null) {
                Message obtain = Message.obtain(aVar, 6);
                obtain.arg1 = i2;
                obtain.arg2 = i3;
                obtain.obj = str;
                this.f4971a.sendMessage(obtain);
                return true;
            }
            return true;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public void c() {
            a aVar = this.f4971a;
            if (aVar != null) {
                aVar.sendEmptyMessage(3);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public boolean c(int i2, int i3, String str) {
            a aVar = this.f4971a;
            if (aVar != null) {
                Message obtain = Message.obtain(aVar, 7);
                obtain.arg1 = i2;
                obtain.arg2 = i3;
                obtain.obj = str;
                this.f4971a.sendMessage(obtain);
                return true;
            }
            return true;
        }

        public void d() {
            this.f4971a = null;
            this.f4972b = null;
        }
    }

    public h(com.baidu.cyberplayer.sdk.remote.b bVar, CyberPlayerManager.HttpDNS httpDNS) {
        this.f4961a = bVar;
        this.f4962b = httpDNS;
        b bVar2 = new b(this.k, httpDNS);
        this.m = bVar2;
        com.baidu.cyberplayer.sdk.remote.b bVar3 = this.f4961a;
        if (bVar3 != null) {
            try {
                bVar3.a(bVar2);
                g.a().a(this);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static h a(int i2, CyberPlayerManager.HttpDNS httpDNS) {
        com.baidu.cyberplayer.sdk.remote.b a2 = b.a.a(g.a().a(i2));
        if (a2 != null) {
            return new h(a2, httpDNS);
        }
        return null;
    }

    private void a(Uri uri, Map<String, String> map) {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f4961a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.a(new e(uri, map));
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f4968h;
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
            this.k.sendMessage(obtain);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void changeProxyDynamic(String str, boolean z) {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f4961a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.a(str, z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f4968h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "changeProxyDynamic(String, boolean)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPosition() {
        int i2 = this.o;
        if (i2 > -1) {
            return i2;
        }
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f4961a;
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
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f4961a;
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
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f4961a;
        if (bVar != null) {
            try {
                return bVar.a();
            } catch (RemoteException e2) {
                e2.printStackTrace();
                CyberPlayerManager.OnErrorListener onErrorListener = this.f4968h;
                if (onErrorListener != null) {
                    onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "getDecodeMode()");
                }
            }
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getDownloadSpeed() {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f4961a;
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
        int i2 = this.n;
        if (i2 > -1) {
            return i2;
        }
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f4961a;
        if (bVar != null) {
            try {
                int k = bVar.k();
                this.n = k;
                return k;
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getPlayedTime() {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f4961a;
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
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f4961a;
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
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f4961a;
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
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f4961a;
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
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f4961a;
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
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f4961a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.d(z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f4968h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "muteOrUnmuteAudio(boolean)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void pause() {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f4961a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.e();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f4968h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "pause()");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void prepareAsync() {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f4961a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.b();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f4968h;
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
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f4961a;
        if (bVar == null) {
            return;
        }
        try {
            try {
                bVar.b(this.m);
                this.f4961a.l();
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        } finally {
            g.a().b(this);
            this.f4961a = null;
            this.l = null;
            this.k.removeCallbacksAndMessages(null);
            this.m.d();
            this.m = null;
            this.k = null;
            this.f4962b = null;
            this.f4963c = null;
            this.f4964d = null;
            this.f4965e = null;
            this.f4966f = null;
            this.f4967g = null;
            this.f4968h = null;
            this.f4969i = null;
            this.j = null;
            this.n = -1;
            this.o = -1;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void reset() {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f4961a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.m();
            this.k.removeCallbacksAndMessages(null);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f4968h;
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
    public void seekTo(long j, int i2) {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f4961a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.a(j, i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f4968h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "seekTo(long)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void sendCommand(int i2, int i3, long j, String str) {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f4961a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.a(i2, i3, j, str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f4968h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "sendCommand(int, int, long, String)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setClarityInfo(String str) {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f4961a;
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
        CyberPlayerManager.OnErrorListener onErrorListener = this.f4968h;
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
        if (this.f4961a == null) {
            return;
        }
        if (surfaceHolder != null) {
            try {
                surface = surfaceHolder.getSurface();
            } catch (RemoteException e2) {
                e2.printStackTrace();
                CyberPlayerManager.OnErrorListener onErrorListener = this.f4968h;
                if (onErrorListener != null) {
                    onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setDisplay()");
                    return;
                }
                return;
            }
        } else {
            surface = null;
        }
        this.f4961a.a(surface);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setEnableDumediaUA(boolean z) {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f4961a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.c(z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f4968h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setEnableDumediaUA(boolean)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setLooping(boolean z) {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f4961a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.b(z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f4968h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setLooping(boolean)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.f4965e = onBufferingUpdateListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.f4964d = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.f4968h = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.f4969i = onInfoListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        this.j = onMediaSourceChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.f4963c = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.f4966f = onSeekCompleteListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.f4967g = onVideoSizeChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOption(String str, long j) {
        setOption(str, String.valueOf(j));
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOption(String str, String str2) {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f4961a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.a(str, str2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f4968h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setOption(String, String)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setPlayJson(String str) {
        try {
            if (this.f4961a != null) {
                this.f4961a.b(str);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f4968h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setPlayJson(String)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setScreenOnWhilePlaying(boolean z) {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f4961a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.a(z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f4968h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setScreenOnWhilePlaying(boolean)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSpeed(float f2) {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f4961a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.a(f2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f4968h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setSpeed(float)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSurface(Surface surface) {
        if (this.f4961a == null) {
            return;
        }
        Surface surface2 = this.l;
        if (surface2 != surface || surface2 == null) {
            try {
                this.f4961a.a(surface);
                this.l = surface;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                CyberPlayerManager.OnErrorListener onErrorListener = this.f4968h;
                if (onErrorListener != null) {
                    onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setSurface()");
                }
                this.l = null;
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setVolume(float f2, float f3) {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f4961a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.a(f2, f3);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f4968h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setVolume(float, float)");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setWakeMode(Context context, int i2) {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f4961a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.a(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f4968h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "setWakeMode()");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void start() {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f4961a;
        if (bVar == null) {
            return;
        }
        try {
            bVar.c();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            CyberPlayerManager.OnErrorListener onErrorListener = this.f4968h;
            if (onErrorListener != null) {
                onErrorListener.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, "start()");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void stop() {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f4961a;
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
    public void switchMediaSource(int i2) {
        com.baidu.cyberplayer.sdk.remote.b bVar = this.f4961a;
        if (bVar != null) {
            try {
                bVar.b(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void updateDisplaySize(int i2, int i3) {
        try {
            if (this.f4961a != null) {
                this.f4961a.a(i2, i3);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }
}
