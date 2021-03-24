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

    /* renamed from: a  reason: collision with root package name */
    public CyberPlayer f5013a;

    /* renamed from: b  reason: collision with root package name */
    public int f5014b;

    /* renamed from: c  reason: collision with root package name */
    public RemotePlayerService f5015c;

    /* renamed from: e  reason: collision with root package name */
    public Surface f5017e;

    /* renamed from: d  reason: collision with root package name */
    public RemoteCallbackList<d> f5016d = new RemoteCallbackList<>();

    /* renamed from: f  reason: collision with root package name */
    public final Object f5018f = new Object();

    public f(int i, RemotePlayerService remotePlayerService) {
        this.f5014b = i;
        this.f5015c = remotePlayerService;
        CyberPlayer cyberPlayer = new CyberPlayer(i, this, false);
        this.f5013a = cyberPlayer;
        cyberPlayer.setIsInMainProcess(false);
        this.f5013a.setOnPreparedListener(this);
        this.f5013a.setOnCompletionListener(this);
        this.f5013a.setOnBufferingUpdateListener(this);
        this.f5013a.setOnVideoSizeChangedListener(this);
        this.f5013a.setOnSeekCompleteListener(this);
        this.f5013a.setOnErrorListener(this);
        this.f5013a.setOnInfoListener(this);
        this.f5013a.setOnMediaSourceChangedListener(this);
    }

    private CyberPlayer q() {
        return this.f5013a;
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
    public void a(int i) {
        q().setWakeMode(CyberPlayerManager.getApplicationContext(), i);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void a(int i, int i2, long j, String str) {
        q().sendCommand(i, i2, j, str);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void a(long j) {
        q().seekTo(j);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void a(Surface surface) {
        q().setSurface(surface);
        synchronized (this.f5018f) {
            if (this.f5017e != null && this.f5017e != surface) {
                this.f5017e.release();
            }
            this.f5017e = surface;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void a(d dVar) {
        this.f5016d.register(dVar);
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
            } else if (TextUtils.isEmpty(str2) || this.f5015c == null) {
                return;
            } else {
                q = q();
                kernelNetHandle = this.f5015c.getKernelNetHandle();
            }
        } else if (TextUtils.isEmpty(str2) || this.f5015c == null) {
            return;
        } else {
            q = q();
            kernelNetHandle = this.f5015c.getPCDNNetHandle();
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
    public void b(int i) {
        q().switchMediaSource(i);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public void b(d dVar) {
        this.f5016d.unregister(dVar);
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
        synchronized (this.f5016d) {
            int beginBroadcast = this.f5016d.beginBroadcast();
            arrayList = null;
            for (int i = 0; i < beginBroadcast; i++) {
                d broadcastItem = this.f5016d.getBroadcastItem(i);
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
            this.f5016d.finishBroadcast();
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
            if (this.f5013a != null) {
                this.f5013a.release();
            }
        }
        synchronized (this.f5016d) {
            this.f5016d.kill();
        }
        if (this.f5017e != null) {
            synchronized (this.f5018f) {
                if (this.f5017e != null && this.f5017e.isValid()) {
                    CyberLog.i("remotePlayer", "release mSurface");
                    this.f5017e.release();
                    this.f5017e = null;
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
    public void onBufferingUpdate(int i) {
        synchronized (this.f5016d) {
            int beginBroadcast = this.f5016d.beginBroadcast();
            for (int i2 = 0; i2 < beginBroadcast; i2++) {
                d broadcastItem = this.f5016d.getBroadcastItem(i2);
                if (broadcastItem != null) {
                    try {
                        broadcastItem.a(i);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            this.f5016d.finishBroadcast();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        synchronized (this.f5016d) {
            int beginBroadcast = this.f5016d.beginBroadcast();
            for (int i = 0; i < beginBroadcast; i++) {
                d broadcastItem = this.f5016d.getBroadcastItem(i);
                if (broadcastItem != null) {
                    try {
                        broadcastItem.b();
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            this.f5016d.finishBroadcast();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        boolean z;
        synchronized (this.f5016d) {
            int beginBroadcast = this.f5016d.beginBroadcast();
            z = false;
            for (int i3 = 0; i3 < beginBroadcast; i3++) {
                d broadcastItem = this.f5016d.getBroadcastItem(i3);
                if (broadcastItem != null) {
                    try {
                        z = broadcastItem.a(i, i2, obj instanceof String ? (String) obj : null);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            this.f5016d.finishBroadcast();
        }
        return z;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        boolean z;
        synchronized (this.f5016d) {
            int beginBroadcast = this.f5016d.beginBroadcast();
            z = false;
            for (int i3 = 0; i3 < beginBroadcast; i3++) {
                d broadcastItem = this.f5016d.getBroadcastItem(i3);
                if (broadcastItem != null) {
                    try {
                        z = broadcastItem.b(i, i2, obj instanceof String ? (String) obj : null);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            this.f5016d.finishBroadcast();
        }
        return z;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnMediaSourceChangedListener
    public boolean onMediaSourceChanged(int i, int i2, Object obj) {
        boolean z;
        synchronized (this.f5016d) {
            int beginBroadcast = this.f5016d.beginBroadcast();
            z = false;
            for (int i3 = 0; i3 < beginBroadcast; i3++) {
                d broadcastItem = this.f5016d.getBroadcastItem(i3);
                if (broadcastItem != null) {
                    try {
                        z = broadcastItem.c(i, i2, obj instanceof String ? (String) obj : null);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            this.f5016d.finishBroadcast();
        }
        return z;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        synchronized (this.f5016d) {
            int beginBroadcast = this.f5016d.beginBroadcast();
            for (int i = 0; i < beginBroadcast; i++) {
                d broadcastItem = this.f5016d.getBroadcastItem(i);
                if (broadcastItem != null) {
                    try {
                        broadcastItem.a();
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            this.f5016d.finishBroadcast();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        synchronized (this.f5016d) {
            int beginBroadcast = this.f5016d.beginBroadcast();
            for (int i = 0; i < beginBroadcast; i++) {
                d broadcastItem = this.f5016d.getBroadcastItem(i);
                if (broadcastItem != null) {
                    try {
                        broadcastItem.c();
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            this.f5016d.finishBroadcast();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        synchronized (this.f5016d) {
            int beginBroadcast = this.f5016d.beginBroadcast();
            for (int i5 = 0; i5 < beginBroadcast; i5++) {
                d broadcastItem = this.f5016d.getBroadcastItem(i5);
                if (broadcastItem != null) {
                    try {
                        broadcastItem.a(i, i2, i3, i4);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            this.f5016d.finishBroadcast();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.b
    public long p() {
        return q().getDownloadSpeed();
    }
}
