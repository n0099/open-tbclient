package com.baidu.cyberplayer.sdk.remote;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.Surface;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayer;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.remote.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends b.a implements CyberPlayerManager.HttpDNS, CyberPlayerManager.OnBufferingUpdateListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnMediaSourceChangedListener, CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnSeekCompleteListener, CyberPlayerManager.OnVideoSizeChangedListener {

    /* renamed from: g  reason: collision with root package name */
    public static boolean f4942g = false;

    /* renamed from: a  reason: collision with root package name */
    public CyberPlayer f4943a;

    /* renamed from: b  reason: collision with root package name */
    public int f4944b;

    /* renamed from: c  reason: collision with root package name */
    public RemotePlayerService f4945c;

    /* renamed from: e  reason: collision with root package name */
    public Surface f4947e;

    /* renamed from: d  reason: collision with root package name */
    public RemoteCallbackList<d> f4946d = new RemoteCallbackList<>();

    /* renamed from: f  reason: collision with root package name */
    public final Object f4948f = new Object();

    public f(int i2, RemotePlayerService remotePlayerService) {
        RemotePlayerService remotePlayerService2;
        this.f4944b = i2;
        this.f4945c = remotePlayerService;
        CyberPlayer cyberPlayer = new CyberPlayer(i2, this, false);
        this.f4943a = cyberPlayer;
        cyberPlayer.setIsInMainProcess(false);
        this.f4943a.setOnPreparedListener(this);
        this.f4943a.setOnCompletionListener(this);
        this.f4943a.setOnBufferingUpdateListener(this);
        this.f4943a.setOnVideoSizeChangedListener(this);
        this.f4943a.setOnSeekCompleteListener(this);
        this.f4943a.setOnErrorListener(this);
        this.f4943a.setOnInfoListener(this);
        this.f4943a.setOnMediaSourceChangedListener(this);
        if (f4942g || (remotePlayerService2 = this.f4945c) == null) {
            return;
        }
        long kernelNetHandle = remotePlayerService2.getKernelNetHandle();
        if (kernelNetHandle == 0 || com.baidu.cyberplayer.sdk.d.c(kernelNetHandle) != 0) {
            return;
        }
        f4942g = true;
    }

    private CyberPlayer q() {
        return this.f4943a;
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public int a() {
        return q().getDecodeMode();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void a(float f2) {
        q().setSpeed(f2);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void a(float f2, float f3) {
        q().setVolume(f2, f3);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void a(int i2) {
        q().setWakeMode(CyberPlayerManager.getApplicationContext(), i2);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void a(int i2, int i3) {
        q().updateDisplaySize(i2, i3);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void a(int i2, int i3, long j, String str) {
        q().sendCommand(i2, i3, j, str);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void a(long j, int i2) {
        q().seekTo(j, i2);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void a(Surface surface) {
        q().setSurface(surface);
        synchronized (this.f4948f) {
            if (this.f4947e != null && this.f4947e != surface) {
                this.f4947e.release();
            }
            this.f4947e = surface;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void a(d dVar) {
        this.f4946d.register(dVar);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void a(e eVar) {
        q().setDataSource(CyberPlayerManager.getApplicationContext(), eVar.a(), eVar.b());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("is_remote_play", 1);
            a(1003, 0, 0L, jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void a(String str) throws RemoteException {
        if (str != null) {
            q().setClarityInfo(str);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void a(String str, String str2) {
        CyberPlayer q;
        long kernelNetHandle;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str3 = CyberPlayerManager.OPT_PCDN_NETHANDLE;
        if (!str.equals(CyberPlayerManager.OPT_PCDN_NETHANDLE)) {
            str3 = CyberPlayerManager.OPT_KERNEL_NET_NETHANDLE;
            if (!str.equals(CyberPlayerManager.OPT_KERNEL_NET_NETHANDLE)) {
                q().setOption(str, str2);
                return;
            } else if (TextUtils.isEmpty(str2) || this.f4945c == null) {
                return;
            } else {
                q = q();
                kernelNetHandle = this.f4945c.getKernelNetHandle();
            }
        } else if (TextUtils.isEmpty(str2) || this.f4945c == null) {
            return;
        } else {
            q = q();
            kernelNetHandle = this.f4945c.getPCDNNetHandle();
        }
        q.setOption(str3, String.valueOf(kernelNetHandle));
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void a(String str, boolean z) {
        q().changeProxyDynamic(str, z);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void a(boolean z) {
        q().setScreenOnWhilePlaying(z);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void b() {
        q().prepareAsync();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void b(int i2) {
        q().switchMediaSource(i2);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void b(d dVar) {
        this.f4946d.unregister(dVar);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void b(String str) {
        q().setPlayJson(str);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void b(boolean z) {
        q().setLooping(z);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void c() {
        q().start();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void c(boolean z) {
        q().setEnableDumediaUA(z);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void d() {
        q().stop();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void d(boolean z) {
        q().muteOrUnmuteAudio(z);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void e() {
        q().pause();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public int f() {
        return q().getVideoWidth();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public int g() {
        return q().getVideoHeight();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.HttpDNS
    public List<String> getIpList(String str) {
        ArrayList arrayList;
        synchronized (this.f4946d) {
            int beginBroadcast = this.f4946d.beginBroadcast();
            arrayList = null;
            for (int i2 = 0; i2 < beginBroadcast; i2++) {
                d broadcastItem = this.f4946d.getBroadcastItem(i2);
                if (broadcastItem != null) {
                    try {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(str);
                        broadcastItem.a("onHttpDNS", arrayList2);
                        if (arrayList2.size() > 0) {
                            arrayList = arrayList2;
                        }
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            this.f4946d.finishBroadcast();
        }
        return arrayList;
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public boolean h() {
        return q().isPlaying();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public int i() {
        return q().getCurrentPosition();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public int j() {
        return q().getCurrentPositionSync();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public int k() {
        return q().getDuration();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void l() {
        synchronized (this) {
            if (this.f4943a != null) {
                this.f4943a.release();
            }
        }
        synchronized (this.f4946d) {
            this.f4946d.kill();
        }
        if (this.f4947e != null) {
            synchronized (this.f4948f) {
                if (this.f4947e != null && this.f4947e.isValid()) {
                    CyberLog.i("remotePlayer", "release mSurface");
                    this.f4947e.release();
                    this.f4947e = null;
                }
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void m() {
        q().reset();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public boolean n() {
        return q().isLooping();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public long o() {
        return q().getPlayedTime();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
    public void onBufferingUpdate(int i2) {
        synchronized (this.f4946d) {
            int beginBroadcast = this.f4946d.beginBroadcast();
            for (int i3 = 0; i3 < beginBroadcast; i3++) {
                d broadcastItem = this.f4946d.getBroadcastItem(i3);
                if (broadcastItem != null) {
                    try {
                        broadcastItem.a(i2);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            this.f4946d.finishBroadcast();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        synchronized (this.f4946d) {
            int beginBroadcast = this.f4946d.beginBroadcast();
            for (int i2 = 0; i2 < beginBroadcast; i2++) {
                d broadcastItem = this.f4946d.getBroadcastItem(i2);
                if (broadcastItem != null) {
                    try {
                        broadcastItem.b();
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            this.f4946d.finishBroadcast();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i2, int i3, Object obj) {
        boolean z;
        synchronized (this.f4946d) {
            int beginBroadcast = this.f4946d.beginBroadcast();
            z = false;
            for (int i4 = 0; i4 < beginBroadcast; i4++) {
                d broadcastItem = this.f4946d.getBroadcastItem(i4);
                if (broadcastItem != null) {
                    try {
                        z = broadcastItem.a(i2, i3, obj instanceof String ? (String) obj : null);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            this.f4946d.finishBroadcast();
        }
        return z;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i2, int i3, Object obj) {
        boolean z;
        synchronized (this.f4946d) {
            int beginBroadcast = this.f4946d.beginBroadcast();
            z = false;
            for (int i4 = 0; i4 < beginBroadcast; i4++) {
                d broadcastItem = this.f4946d.getBroadcastItem(i4);
                if (broadcastItem != null) {
                    try {
                        z = broadcastItem.b(i2, i3, obj instanceof String ? (String) obj : null);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            this.f4946d.finishBroadcast();
        }
        return z;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnMediaSourceChangedListener
    public boolean onMediaSourceChanged(int i2, int i3, Object obj) {
        boolean z;
        synchronized (this.f4946d) {
            int beginBroadcast = this.f4946d.beginBroadcast();
            z = false;
            for (int i4 = 0; i4 < beginBroadcast; i4++) {
                d broadcastItem = this.f4946d.getBroadcastItem(i4);
                if (broadcastItem != null) {
                    try {
                        z = broadcastItem.c(i2, i3, obj instanceof String ? (String) obj : null);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            this.f4946d.finishBroadcast();
        }
        return z;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        synchronized (this.f4946d) {
            int beginBroadcast = this.f4946d.beginBroadcast();
            for (int i2 = 0; i2 < beginBroadcast; i2++) {
                d broadcastItem = this.f4946d.getBroadcastItem(i2);
                if (broadcastItem != null) {
                    try {
                        broadcastItem.a();
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            this.f4946d.finishBroadcast();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        synchronized (this.f4946d) {
            int beginBroadcast = this.f4946d.beginBroadcast();
            for (int i2 = 0; i2 < beginBroadcast; i2++) {
                d broadcastItem = this.f4946d.getBroadcastItem(i2);
                if (broadcastItem != null) {
                    try {
                        broadcastItem.c();
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            this.f4946d.finishBroadcast();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
    public void onVideoSizeChanged(int i2, int i3, int i4, int i5) {
        synchronized (this.f4946d) {
            int beginBroadcast = this.f4946d.beginBroadcast();
            for (int i6 = 0; i6 < beginBroadcast; i6++) {
                d broadcastItem = this.f4946d.getBroadcastItem(i6);
                if (broadcastItem != null) {
                    try {
                        broadcastItem.a(i2, i3, i4, i5);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            this.f4946d.finishBroadcast();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public long p() {
        return q().getDownloadSpeed();
    }
}
