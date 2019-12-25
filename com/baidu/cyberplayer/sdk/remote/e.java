package com.baidu.cyberplayer.sdk.remote;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.Surface;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayer;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.remote.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e extends a.AbstractBinderC0055a implements CyberPlayerManager.HttpDNS, CyberPlayerManager.OnBufferingUpdateListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnSeekCompleteListener, CyberPlayerManager.OnVideoSizeChangedListener {
    private CyberPlayer a;
    private int b;
    private RemotePlayerService c;
    private Surface e;
    private RemoteCallbackList<c> d = new RemoteCallbackList<>();
    private final Object f = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(int i, RemotePlayerService remotePlayerService) {
        this.b = i;
        this.c = remotePlayerService;
    }

    private CyberPlayer q() {
        if (this.a == null) {
            synchronized (this) {
                if (this.a == null) {
                    this.a = new CyberPlayer(this.b, this, false);
                    this.a.setOnPreparedListener(this);
                    this.a.setOnCompletionListener(this);
                    this.a.setOnBufferingUpdateListener(this);
                    this.a.setOnVideoSizeChangedListener(this);
                    this.a.setOnSeekCompleteListener(this);
                    this.a.setOnErrorListener(this);
                    this.a.setOnInfoListener(this);
                }
            }
        }
        return this.a;
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public int a() {
        return q().getDecodeMode();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public void a(float f) {
        q().setSpeed(f);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public void a(float f, float f2) {
        q().setVolume(f, f2);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public void a(int i) {
        q().setWakeMode(CyberPlayerManager.getApplicationContext(), i);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public void a(int i, int i2, long j, String str) {
        q().sendCommand(i, i2, j, str);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public void a(long j) {
        q().seekTo(j);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public void a(Surface surface) {
        q().setSurface(surface);
        synchronized (this.f) {
            this.e = surface;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public void a(c cVar) {
        this.d.register(cVar);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public void a(d dVar) {
        q().setDataSource(CyberPlayerManager.getApplicationContext(), dVar.a(), dVar.b());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("is_remote_play", 1);
            a(1003, 0, 0L, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!str.equals(CyberPlayerManager.OPT_PCDN_NETHANDLE)) {
            q().setOption(str, str2);
        } else if (TextUtils.isEmpty(str2) || this.c == null) {
        } else {
            q().setOption(CyberPlayerManager.OPT_PCDN_NETHANDLE, String.valueOf(this.c.getPCDNNetHandle()));
        }
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public void a(String str, boolean z) {
        q().changeProxyDynamic(str, z);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public void a(boolean z) {
        q().setScreenOnWhilePlaying(z);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public void b() {
        q().prepareAsync();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public void b(c cVar) {
        this.d.unregister(cVar);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public void b(boolean z) {
        q().setLooping(z);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public void c() {
        q().start();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public void c(boolean z) {
        q().muteOrUnmuteAudio(z);
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public void d() {
        q().stop();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public void e() {
        q().pause();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public int f() {
        return q().getVideoWidth();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public int g() {
        return q().getVideoHeight();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.HttpDNS
    public List<String> getIpList(String str) {
        ArrayList arrayList = null;
        int beginBroadcast = this.d.beginBroadcast();
        for (int i = 0; i < beginBroadcast; i++) {
            c broadcastItem = this.d.getBroadcastItem(i);
            if (broadcastItem != null) {
                try {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(str);
                    broadcastItem.a("onHttpDNS", arrayList2);
                    arrayList = arrayList2.size() > 0 ? arrayList2 : arrayList;
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        this.d.finishBroadcast();
        return arrayList;
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public boolean h() {
        return q().isPlaying();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public int i() {
        return q().getCurrentPosition();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public int j() {
        return q().getCurrentPositionSync();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public int k() {
        return q().getDuration();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public void l() {
        q().release();
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

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public void m() {
        q().reset();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public boolean n() {
        return q().isLooping();
    }

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public long o() {
        return q().getPlayedTime();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
    public void onBufferingUpdate(int i) {
        int beginBroadcast = this.d.beginBroadcast();
        for (int i2 = 0; i2 < beginBroadcast; i2++) {
            c broadcastItem = this.d.getBroadcastItem(i2);
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

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        int beginBroadcast = this.d.beginBroadcast();
        for (int i = 0; i < beginBroadcast; i++) {
            c broadcastItem = this.d.getBroadcastItem(i);
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

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        boolean a;
        int beginBroadcast = this.d.beginBroadcast();
        int i3 = 0;
        boolean z = false;
        while (i3 < beginBroadcast) {
            c broadcastItem = this.d.getBroadcastItem(i3);
            if (broadcastItem != null) {
                try {
                    a = broadcastItem.a(i, i2, obj instanceof String ? (String) obj : null);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                i3++;
                z = a;
            }
            a = z;
            i3++;
            z = a;
        }
        this.d.finishBroadcast();
        return z;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        boolean b;
        int beginBroadcast = this.d.beginBroadcast();
        int i3 = 0;
        boolean z = false;
        while (i3 < beginBroadcast) {
            c broadcastItem = this.d.getBroadcastItem(i3);
            if (broadcastItem != null) {
                try {
                    b = broadcastItem.b(i, i2, obj instanceof String ? (String) obj : null);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                i3++;
                z = b;
            }
            b = z;
            i3++;
            z = b;
        }
        this.d.finishBroadcast();
        return z;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        int beginBroadcast = this.d.beginBroadcast();
        for (int i = 0; i < beginBroadcast; i++) {
            c broadcastItem = this.d.getBroadcastItem(i);
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

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        int beginBroadcast = this.d.beginBroadcast();
        for (int i = 0; i < beginBroadcast; i++) {
            c broadcastItem = this.d.getBroadcastItem(i);
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

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        int beginBroadcast = this.d.beginBroadcast();
        for (int i5 = 0; i5 < beginBroadcast; i5++) {
            c broadcastItem = this.d.getBroadcastItem(i5);
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

    @Override // com.baidu.cyberplayer.sdk.remote.a
    public long p() {
        return q().getDownloadSpeed();
    }
}
