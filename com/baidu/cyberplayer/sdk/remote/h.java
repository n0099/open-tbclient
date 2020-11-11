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
/* loaded from: classes12.dex */
public class h extends PlayerProvider implements g.b {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.cyberplayer.sdk.remote.b f1414a;
    private CyberPlayerManager.HttpDNS b;
    private CyberPlayerManager.OnPreparedListener c;
    private CyberPlayerManager.OnCompletionListener d;
    private CyberPlayerManager.OnBufferingUpdateListener e;
    private CyberPlayerManager.OnSeekCompleteListener f;
    private CyberPlayerManager.OnVideoSizeChangedListener g;
    private CyberPlayerManager.OnErrorListener h;
    private CyberPlayerManager.OnInfoListener i;
    private CyberPlayerManager.OnMediaSourceChangedListener j;
    private a k = new a(this);
    private Surface l;
    private b m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<h> f1415a;

        public a(h hVar) {
            this.f1415a = new WeakReference<>(hVar);
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
            h hVar = this.f1415a.get();
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

    /* loaded from: classes12.dex */
    private static class b extends d.a {

        /* renamed from: a  reason: collision with root package name */
        private a f1416a;
        private CyberPlayerManager.HttpDNS b;

        public b(a aVar, CyberPlayerManager.HttpDNS httpDNS) {
            this.f1416a = aVar;
            this.b = httpDNS;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public void a() {
            if (this.f1416a != null) {
                this.f1416a.sendEmptyMessage(0);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public void a(int i) {
            if (this.f1416a != null) {
                Message obtain = Message.obtain(this.f1416a, 2);
                obtain.arg1 = i;
                this.f1416a.sendMessage(obtain);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public void a(int i, int i2, int i3, int i4) {
            if (this.f1416a != null) {
                Message obtain = Message.obtain(this.f1416a, 4);
                obtain.obj = new int[]{i, i2, i3, i4};
                this.f1416a.sendMessage(obtain);
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
            if (this.f1416a != null) {
                Message obtain = Message.obtain(this.f1416a, 5);
                obtain.arg1 = i;
                obtain.arg2 = i2;
                obtain.obj = str;
                this.f1416a.sendMessage(obtain);
                return true;
            }
            return true;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public synchronized void b() {
            if (this.f1416a != null) {
                this.f1416a.sendEmptyMessage(1);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public boolean b(int i, int i2, String str) {
            if (this.f1416a != null) {
                Message obtain = Message.obtain(this.f1416a, 6);
                obtain.arg1 = i;
                obtain.arg2 = i2;
                obtain.obj = str;
                this.f1416a.sendMessage(obtain);
                return true;
            }
            return true;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public void c() {
            if (this.f1416a != null) {
                this.f1416a.sendEmptyMessage(3);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.remote.d
        public boolean c(int i, int i2, String str) {
            if (this.f1416a != null) {
                Message obtain = Message.obtain(this.f1416a, 7);
                obtain.arg1 = i;
                obtain.arg2 = i2;
                obtain.obj = str;
                this.f1416a.sendMessage(obtain);
                return true;
            }
            return true;
        }

        public void d() {
            this.f1416a = null;
            this.b = null;
        }
    }

    private h(com.baidu.cyberplayer.sdk.remote.b bVar, CyberPlayerManager.HttpDNS httpDNS) {
        this.f1414a = bVar;
        this.b = httpDNS;
        this.m = new b(this.k, httpDNS);
        if (this.f1414a != null) {
            try {
                this.f1414a.a(this.m);
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
        if (this.f1414a == null) {
            return;
        }
        try {
            this.f1414a.a(new e(uri, map));
        } catch (RemoteException e) {
            e.printStackTrace();
            if (this.h != null) {
                this.h.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.g.b
    public void a() {
        if (this.k != null) {
            Message obtain = Message.obtain(this.k, 5);
            obtain.arg1 = CyberPlayerManager.MEDIA_ERROR_REMOTE_DIED;
            obtain.arg2 = 0;
            obtain.obj = null;
            this.k.sendMessage(obtain);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void changeProxyDynamic(String str, boolean z) {
        if (this.f1414a == null) {
            return;
        }
        try {
            this.f1414a.a(str, z);
        } catch (RemoteException e) {
            e.printStackTrace();
            if (this.h != null) {
                this.h.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPosition() {
        if (this.f1414a != null) {
            try {
                return this.f1414a.i();
            } catch (RemoteException e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPositionSync() {
        if (this.f1414a != null) {
            try {
                return this.f1414a.j();
            } catch (RemoteException e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getDecodeMode() {
        if (this.f1414a != null) {
            try {
                return this.f1414a.a();
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
        if (this.f1414a != null) {
            try {
                return this.f1414a.p();
            } catch (RemoteException e) {
                e.printStackTrace();
                return 0L;
            }
        }
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getDuration() {
        if (this.f1414a != null) {
            try {
                return this.f1414a.k();
            } catch (RemoteException e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getPlayedTime() {
        if (this.f1414a != null) {
            try {
                return this.f1414a.o();
            } catch (RemoteException e) {
                e.printStackTrace();
                return 0L;
            }
        }
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoHeight() {
        if (this.f1414a != null) {
            try {
                return this.f1414a.g();
            } catch (RemoteException e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoWidth() {
        if (this.f1414a != null) {
            try {
                return this.f1414a.f();
            } catch (RemoteException e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isLooping() {
        if (this.f1414a != null) {
            try {
                return this.f1414a.n();
            } catch (RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isPlaying() {
        if (this.f1414a != null) {
            try {
                return this.f1414a.h();
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
        if (this.f1414a == null) {
            return;
        }
        try {
            this.f1414a.d(z);
        } catch (RemoteException e) {
            e.printStackTrace();
            if (this.h != null) {
                this.h.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void pause() {
        if (this.f1414a == null) {
            return;
        }
        try {
            this.f1414a.e();
        } catch (RemoteException e) {
            e.printStackTrace();
            if (this.h != null) {
                this.h.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void prepareAsync() {
        if (this.f1414a == null) {
            return;
        }
        try {
            this.f1414a.b();
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
    /* JADX WARN: Type inference failed for: r2v0, types: [com.baidu.cyberplayer.sdk.CyberPlayerManager$OnCompletionListener, android.view.Surface, com.baidu.cyberplayer.sdk.CyberPlayerManager$OnPreparedListener, com.baidu.cyberplayer.sdk.CyberPlayerManager$OnMediaSourceChangedListener, com.baidu.cyberplayer.sdk.CyberPlayerManager$OnInfoListener, com.baidu.cyberplayer.sdk.CyberPlayerManager$OnBufferingUpdateListener, com.baidu.cyberplayer.sdk.CyberPlayerManager$OnErrorListener, com.baidu.cyberplayer.sdk.CyberPlayerManager$OnVideoSizeChangedListener, com.baidu.cyberplayer.sdk.CyberPlayerManager$HttpDNS, com.baidu.cyberplayer.sdk.remote.b, com.baidu.cyberplayer.sdk.remote.h$b, java.lang.Object, com.baidu.cyberplayer.sdk.remote.h$a, com.baidu.cyberplayer.sdk.CyberPlayerManager$OnSeekCompleteListener] */
    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void release() {
        if (this.f1414a == null) {
            return;
        }
        try {
            this.f1414a.b(this.m);
            this.f1414a.l();
        } catch (RemoteException e) {
            e.printStackTrace();
        } finally {
            g.a().b(this);
            this.f1414a = null;
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
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void reset() {
        if (this.f1414a == null) {
            return;
        }
        try {
            this.f1414a.m();
            this.k.removeCallbacksAndMessages(null);
        } catch (RemoteException e) {
            e.printStackTrace();
            if (this.h != null) {
                this.h.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void seekTo(long j) {
        if (this.f1414a == null) {
            return;
        }
        try {
            this.f1414a.a(j);
        } catch (RemoteException e) {
            e.printStackTrace();
            if (this.h != null) {
                this.h.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void sendCommand(int i, int i2, long j, String str) {
        if (this.f1414a == null) {
            return;
        }
        try {
            this.f1414a.a(i, i2, j, str);
        } catch (RemoteException e) {
            e.printStackTrace();
            if (this.h != null) {
                this.h.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setClarityInfo(String str) {
        if (this.f1414a != null) {
            try {
                this.f1414a.a(str);
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
        if (this.h != null) {
            this.h.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
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
        if (this.f1414a == null) {
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
        this.f1414a.a(surface);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setEnableDumediaUA(boolean z) {
        if (this.f1414a == null) {
            return;
        }
        try {
            this.f1414a.c(z);
        } catch (RemoteException e) {
            e.printStackTrace();
            if (this.h != null) {
                this.h.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setLooping(boolean z) {
        if (this.f1414a == null) {
            return;
        }
        try {
            this.f1414a.b(z);
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
        if (this.f1414a == null) {
            return;
        }
        try {
            this.f1414a.a(str, str2);
        } catch (RemoteException e) {
            e.printStackTrace();
            if (this.h != null) {
                this.h.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setPlayJson(String str) {
        try {
            if (this.f1414a != null) {
                this.f1414a.b(str);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
            if (this.h != null) {
                this.h.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setScreenOnWhilePlaying(boolean z) {
        if (this.f1414a == null) {
            return;
        }
        try {
            this.f1414a.a(z);
        } catch (RemoteException e) {
            e.printStackTrace();
            if (this.h != null) {
                this.h.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSpeed(float f) {
        if (this.f1414a == null) {
            return;
        }
        try {
            this.f1414a.a(f);
        } catch (RemoteException e) {
            e.printStackTrace();
            if (this.h != null) {
                this.h.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSurface(Surface surface) {
        if (this.f1414a == null) {
            return;
        }
        if (this.l != surface || this.l == null) {
            try {
                this.f1414a.a(surface);
                this.l = surface;
            } catch (RemoteException e) {
                e.printStackTrace();
                if (this.h != null) {
                    this.h.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
                }
                this.l = null;
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setVolume(float f, float f2) {
        if (this.f1414a == null) {
            return;
        }
        try {
            this.f1414a.a(f, f2);
        } catch (RemoteException e) {
            e.printStackTrace();
            if (this.h != null) {
                this.h.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setWakeMode(Context context, int i) {
        if (this.f1414a == null) {
            return;
        }
        try {
            this.f1414a.a(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            if (this.h != null) {
                this.h.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void start() {
        if (this.f1414a == null) {
            return;
        }
        try {
            this.f1414a.c();
        } catch (RemoteException e) {
            e.printStackTrace();
            if (this.h != null) {
                this.h.onError(CyberPlayerManager.MEDIA_ERROR_REMOTE_EXCEPTION, 0, null);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void stop() {
        if (this.f1414a == null) {
            return;
        }
        try {
            this.f1414a.d();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void switchMediaSource(int i) {
        if (this.f1414a != null) {
            try {
                this.f1414a.b(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
