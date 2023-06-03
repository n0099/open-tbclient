package com.baidu.cyberplayer.sdk.remote;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.Surface;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayer;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.remote.c;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends c.a implements CyberPlayerManager.HttpDNS, CyberPlayerManager.OnBufferingUpdateListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnMediaRuntimeInfoListener, CyberPlayerManager.OnMediaSourceChangedListener, CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnSeekCompleteListener, CyberPlayerManager.OnVideoSizeChangedListener {
    public CyberPlayer a;
    public int b;
    public RemotePlayerService c;
    public Surface e;
    public RemoteCallbackList<e> d = new RemoteCallbackList<>();
    public final Object f = new Object();

    public g(int i, RemotePlayerService remotePlayerService) {
        this.b = i;
        this.c = remotePlayerService;
        CyberPlayer cyberPlayer = new CyberPlayer(i, this, false);
        this.a = cyberPlayer;
        cyberPlayer.setIsInMainProcess(false);
        this.a.setOnPreparedListener(this);
        this.a.setOnCompletionListener(this);
        this.a.setOnBufferingUpdateListener(this);
        this.a.setOnVideoSizeChangedListener(this);
        this.a.setOnSeekCompleteListener(this);
        this.a.setOnErrorListener(this);
        this.a.setOnInfoListener(this);
        this.a.setOnMediaSourceChangedListener(this);
        com.baidu.cyberplayer.sdk.f.m();
        com.baidu.cyberplayer.sdk.f.n();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.c
    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.equals(CyberPlayerManager.OPT_PCDN_NETHANDLE)) {
            if (!TextUtils.isEmpty(str2) && this.c != null) {
                t().setOption(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(this.c.getPCDNNetHandle()));
            }
        } else if (str.equals(CyberPlayerManager.OPT_KERNEL_NET_NETHANDLE)) {
            if (!TextUtils.isEmpty(str2) && this.c != null) {
                t().setOption(CyberPlayerManager.OPT_KERNEL_NET_NETHANDLE, String.valueOf(this.c.getKernelNetHandle()));
            }
        } else {
            t().setOption(str, str2);
        }
    }

    private CyberPlayer t() {
        return this.a;
    }

    @Override // com.baidu.cyberplayer.sdk.remote.c
    public int a() {
        return t().getDecodeMode();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.c
    public void b() {
        t().prepareAsync();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.c
    public void c() {
        t().start();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.c
    public void d() {
        t().stop();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.c
    public void e() {
        t().pause();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.c
    public void f() {
        t().stepToNextFrame();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.c
    public int g() {
        return t().getVideoWidth();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.c
    public int h() {
        return t().getVideoHeight();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.c
    public boolean i() {
        return t().isPlaying();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.c
    public int j() {
        return t().getCurrentPosition();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.c
    public int k() {
        return t().getCurrentPositionSync();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.c
    public int l() {
        return t().getDuration();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.c
    public void n() {
        t().reset();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.c
    public boolean o() {
        return t().isLooping();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        synchronized (this.d) {
            int beginBroadcast = this.d.beginBroadcast();
            for (int i = 0; i < beginBroadcast; i++) {
                e broadcastItem = this.d.getBroadcastItem(i);
                if (broadcastItem != null) {
                    try {
                        broadcastItem.b();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
            this.d.finishBroadcast();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        synchronized (this.d) {
            int beginBroadcast = this.d.beginBroadcast();
            for (int i = 0; i < beginBroadcast; i++) {
                e broadcastItem = this.d.getBroadcastItem(i);
                if (broadcastItem != null) {
                    try {
                        broadcastItem.a();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
            this.d.finishBroadcast();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        synchronized (this.d) {
            int beginBroadcast = this.d.beginBroadcast();
            for (int i = 0; i < beginBroadcast; i++) {
                e broadcastItem = this.d.getBroadcastItem(i);
                if (broadcastItem != null) {
                    try {
                        broadcastItem.c();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
            this.d.finishBroadcast();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.c
    public long p() {
        return t().getPlayedTime();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.c
    public long q() {
        return t().getDownloadSpeed();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.c
    public void r() {
        t().getMediaRuntimeInfo(this);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.c
    public String s() {
        return t().getPlayerConfigOptions();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.c
    public void a(float f) {
        t().setSpeed(f);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.c
    public void b(e eVar) {
        this.d.unregister(eVar);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.c
    public void c(boolean z) {
        t().setEnableDumediaUA(z);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.c
    public void d(boolean z) {
        t().muteOrUnmuteAudio(z);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
    public void onBufferingUpdate(int i) {
        synchronized (this.d) {
            int beginBroadcast = this.d.beginBroadcast();
            for (int i2 = 0; i2 < beginBroadcast; i2++) {
                e broadcastItem = this.d.getBroadcastItem(i2);
                if (broadcastItem != null) {
                    try {
                        broadcastItem.a(i);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
            this.d.finishBroadcast();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnMediaRuntimeInfoListener
    public void onRuntimeInfo(String str) {
        synchronized (this.d) {
            int beginBroadcast = this.d.beginBroadcast();
            for (int i = 0; i < beginBroadcast; i++) {
                e broadcastItem = this.d.getBroadcastItem(i);
                if (broadcastItem != null) {
                    try {
                        broadcastItem.a(str);
                    } catch (RemoteException unused) {
                    }
                }
            }
            this.d.finishBroadcast();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.c
    public void a(float f, float f2) {
        t().setVolume(f, f2);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.c
    public void b(int i, int i2) {
        t().updateDisplaySize(i, i2);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.c
    public void a(int i) {
        t().setWakeMode(CyberPlayerManager.getApplicationContext(), i);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.c
    public void b(String str) {
        t().setPlayJson(str);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.c
    public void a(int i, int i2) {
        t().switchMediaSource(i, CyberPlayerManager.MediaSourceSwitchMode.values()[i2]);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.c
    public void a(int i, int i2, long j, String str) {
        t().sendCommand(i, i2, j, str);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        synchronized (this.d) {
            int beginBroadcast = this.d.beginBroadcast();
            for (int i5 = 0; i5 < beginBroadcast; i5++) {
                e broadcastItem = this.d.getBroadcastItem(i5);
                if (broadcastItem != null) {
                    try {
                        broadcastItem.a(i, i2, i3, i4);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
            this.d.finishBroadcast();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.c
    public void a(long j, int i) {
        t().seekTo(j, i);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.c
    public void a(Surface surface) {
        t().setSurface(surface);
        synchronized (this.f) {
            if (this.e != null && this.e != surface) {
                this.e.release();
            }
            this.e = surface;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.c
    public void b(boolean z) {
        t().setLooping(z);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.c
    public void a(e eVar) {
        this.d.register(eVar);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.c
    public void a(f fVar) {
        t().setDataSource(CyberPlayerManager.getApplicationContext(), fVar.a(), fVar.b());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("is_remote_play", 1);
            a(1003, DpStatConstants.SESSION_TYPE_PLAY_COMMON, 0L, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.c
    public void a(String str) throws RemoteException {
        if (str != null) {
            t().setClarityInfo(str);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.c
    public void a(String str, boolean z) {
        t().changeProxyDynamic(str, z);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.c
    public void a(boolean z) {
        t().setScreenOnWhilePlaying(z);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.HttpDNS
    public List<String> getIpList(String str) {
        ArrayList arrayList;
        synchronized (this.d) {
            int beginBroadcast = this.d.beginBroadcast();
            arrayList = null;
            for (int i = 0; i < beginBroadcast; i++) {
                e broadcastItem = this.d.getBroadcastItem(i);
                if (broadcastItem != null) {
                    try {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(str);
                        broadcastItem.a("onHttpDNS", arrayList2);
                        if (arrayList2.size() > 0) {
                            arrayList = arrayList2;
                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
            this.d.finishBroadcast();
        }
        return arrayList;
    }

    @Override // com.baidu.cyberplayer.sdk.remote.c
    public void m() {
        synchronized (this) {
            if (this.a != null) {
                this.a.release();
            }
        }
        synchronized (this.d) {
            this.d.kill();
        }
        if (this.e != null) {
            synchronized (this.f) {
                if (this.e != null && this.e.isValid()) {
                    CyberLog.i("remotePlayer", "release mSurface");
                    this.e.release();
                    this.e = null;
                }
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        boolean z;
        String str;
        synchronized (this.d) {
            int beginBroadcast = this.d.beginBroadcast();
            z = false;
            for (int i3 = 0; i3 < beginBroadcast; i3++) {
                e broadcastItem = this.d.getBroadcastItem(i3);
                if (broadcastItem != null) {
                    try {
                        if (obj instanceof String) {
                            str = (String) obj;
                        } else {
                            str = null;
                        }
                        z = broadcastItem.a(i, i2, str);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
            this.d.finishBroadcast();
        }
        return z;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        boolean z;
        String str;
        synchronized (this.d) {
            int beginBroadcast = this.d.beginBroadcast();
            z = false;
            for (int i3 = 0; i3 < beginBroadcast; i3++) {
                e broadcastItem = this.d.getBroadcastItem(i3);
                if (broadcastItem != null) {
                    try {
                        if (obj instanceof String) {
                            str = (String) obj;
                        } else {
                            str = null;
                        }
                        z = broadcastItem.b(i, i2, str);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
            this.d.finishBroadcast();
        }
        return z;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnMediaSourceChangedListener
    public boolean onMediaSourceChanged(int i, int i2, Object obj) {
        boolean z;
        String str;
        synchronized (this.d) {
            int beginBroadcast = this.d.beginBroadcast();
            z = false;
            for (int i3 = 0; i3 < beginBroadcast; i3++) {
                e broadcastItem = this.d.getBroadcastItem(i3);
                if (broadcastItem != null) {
                    try {
                        if (obj instanceof String) {
                            str = (String) obj;
                        } else {
                            str = null;
                        }
                        z = broadcastItem.c(i, i2, str);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
            this.d.finishBroadcast();
        }
        return z;
    }
}
