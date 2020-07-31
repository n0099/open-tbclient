package com.baidu.ar.arplay.a;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.Surface;
import com.baidu.ar.arplay.c.e;
import com.baidu.ar.arplay.core.engine.ARPEngine;
import com.baidu.ar.arplay.core.message.ARPMessage;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.down.manage.DownloadConstants;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes11.dex */
public class e {
    public static final String TAG = e.class.getSimpleName();
    private static e dO;
    private Timer dn;

    /* renamed from: do  reason: not valid java name */
    private TimerTask f1do;
    private int df = 0;
    private boolean dg = false;
    private ConcurrentHashMap<String, b> dP = new ConcurrentHashMap<>();
    private com.baidu.ar.arplay.c.a dR = new com.baidu.ar.arplay.c.a() { // from class: com.baidu.ar.arplay.a.e.1
        @Override // com.baidu.ar.arplay.c.a
        public void a(e.a aVar) {
            e.this.b((a) null, true);
        }

        @Override // com.baidu.ar.arplay.c.a
        public void aN() {
            e.this.a((a) null, true);
        }
    };
    private Map<String, Integer> dQ = new Hashtable();

    /* loaded from: classes11.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class b {
        String dV;
        SurfaceTexture dW;
        int dX;
        MediaPlayer dy;
        boolean dY = false;
        com.baidu.ar.arplay.a.a.b dz = new com.baidu.ar.arplay.a.a.b();

        b() {
        }
    }

    private e() {
        com.baidu.ar.arplay.c.d.a(this.dR);
    }

    private void a(a aVar, String str, String str2, int i, MediaPlayer.OnCompletionListener onCompletionListener, boolean z, String str3, final long j) {
        if (this.dP.containsKey(str)) {
            b bVar = this.dP.get(str);
            if (bVar != null) {
                try {
                    if (bVar.dy != null) {
                        bVar.dy.reset();
                        bVar.dy.setDataSource(str2);
                        bVar.dy.setLooping(z);
                        bVar.dy.setOnCompletionListener(onCompletionListener);
                        bVar.dy.prepareAsync();
                        bVar.dV = str2;
                        return;
                    }
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            final b bVar2 = new b();
            bVar2.dV = str2;
            bVar2.dy = new MediaPlayer();
            bVar2.dy.setDataSource(str2);
            bVar2.dX = i;
            bVar2.dW = new SurfaceTexture(i);
            bVar2.dz.ee = Long.valueOf(str).longValue();
            bVar2.dz.ef = str3;
            bVar2.dy.setSurface(new Surface(bVar2.dW));
            bVar2.dy.setOnCompletionListener(onCompletionListener);
            bVar2.dy.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.ar.arplay.a.e.4
                @Override // android.media.MediaPlayer.OnErrorListener
                public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                    bVar2.dz.ei = "ERROR";
                    bVar2.dz.ej = i2;
                    e.a(bVar2);
                    return true;
                }
            });
            bVar2.dy.setLooping(z);
            bVar2.dy.prepareAsync();
            com.baidu.ar.arplay.c.b.b(TAG, "wrapper.mMediaPlayer.prepareAsync()");
            bVar2.dy.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.ar.arplay.a.e.5
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    com.baidu.ar.arplay.c.b.b(e.TAG, "mMediaPlayer onPrepared");
                    bVar2.dz.ei = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                    bVar2.dz.ek = DpStatConstants.KEY_PREPARED;
                    e.a(bVar2);
                    if (ARPEngine.getInstance().isEngineCanAccess() && !ARPEngine.getInstance().isPaused()) {
                        e.this.aD();
                        try {
                            if (bVar2.dy.getDuration() >= 0) {
                                if (bVar2.dy.getDuration() <= j || j < 0) {
                                    bVar2.dy.seekTo(0);
                                } else {
                                    bVar2.dy.seekTo((int) j);
                                }
                            }
                            com.baidu.ar.arplay.c.b.b(e.TAG, "mMediaPlayer start");
                            bVar2.dy.start();
                            bVar2.dz.ek = "playing";
                        } catch (Exception e2) {
                            e2.fillInStackTrace();
                        }
                    }
                }
            });
            bVar2.dy.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.ar.arplay.a.e.6
                @Override // android.media.MediaPlayer.OnBufferingUpdateListener
                public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
                    bVar2.dz.ei = "INFO";
                    bVar2.dz.em = i2;
                    e.a(bVar2);
                }
            });
            bVar2.dy.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.ar.arplay.a.e.7
                @Override // android.media.MediaPlayer.OnInfoListener
                public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
                    bVar2.dz.ei = "INFO";
                    switch (i2) {
                        case 701:
                            bVar2.dz.el = "buffer_start";
                            e.a(bVar2);
                            return false;
                        case CyberPlayerManager.MEDIA_INFO_BUFFERING_END /* 702 */:
                            bVar2.dz.el = "buffer_end";
                            e.a(bVar2);
                            return false;
                        default:
                            return false;
                    }
                }
            });
            if (this.dP == null || str == null) {
                return;
            }
            this.dP.put(str, bVar2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(b bVar) {
        if (bVar == null) {
            return;
        }
        b(bVar);
        b(bVar.dz);
        com.baidu.ar.arplay.a.a.b bVar2 = bVar.dz;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", Integer.valueOf((int) ARPMessageType.MSG_TYPE_VIDEO));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("action_id", String.valueOf(bVar2.ee));
        hashMap2.put("platform", "android");
        hashMap2.put("type", bVar2.ei);
        HashMap hashMap3 = new HashMap();
        hashMap3.put("error_code", Integer.valueOf(bVar2.ej));
        hashMap3.put("buffer_status", bVar2.el);
        hashMap3.put("buffer_progress", Integer.valueOf(bVar2.em));
        hashMap3.put("play_status", bVar2.ek);
        hashMap3.put("play_progress", Integer.valueOf((int) (bVar2.en * 100.0f)));
        hashMap2.put("data", hashMap3);
        hashMap.put("msg_data", hashMap2);
        ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aD() {
        if (this.dn == null) {
            this.dn = new Timer();
            this.f1do = new TimerTask() { // from class: com.baidu.ar.arplay.a.e.8
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    b bVar;
                    if (e.this.dP != null) {
                        for (Map.Entry entry : e.this.dP.entrySet()) {
                            if (entry != null && (bVar = (b) entry.getValue()) != null && bVar.dz != null && bVar.dz.ek == "playing") {
                                e.a((b) entry.getValue());
                            }
                        }
                    }
                }
            };
            this.dn.scheduleAtFixedRate(this.f1do, 0L, 200L);
        }
    }

    public static synchronized e aM() {
        e eVar;
        synchronized (e.class) {
            if (dO == null) {
                dO = new e();
            }
            eVar = dO;
        }
        return eVar;
    }

    private static void b(com.baidu.ar.arplay.a.a.b bVar) {
        if (bVar == null) {
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", String.valueOf(bVar.ee));
        hashMap.put("target", bVar.ef);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("play_status", bVar.ek);
        hashMap2.put("buffer_status", bVar.el);
        hashMap2.put("duration", String.valueOf(bVar.eg));
        hashMap2.put("buffer_progress", String.valueOf(bVar.em));
        hashMap2.put("play_progress", String.valueOf((int) (100.0f * bVar.en)));
        hashMap.put("msg_data", hashMap2);
        ARPMessage.getInstance().sendMessage(1031, hashMap);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x004a -> B:27:0x0029). Please submit an issue!!! */
    private static void b(b bVar) {
        if (bVar == null || bVar.dy == null) {
            return;
        }
        com.baidu.ar.arplay.a.a.b bVar2 = bVar.dz;
        if (bVar2.ek == "playing" || bVar2.ek == "paused") {
            try {
                bVar2.eg = bVar.dy.getDuration();
                if (bVar2.eg <= 0) {
                    bVar2.en = 0.0f;
                } else {
                    bVar2.en = (bVar.dy.getCurrentPosition() * 1.0f) / bVar2.eg;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (bVar2.ek == "finished") {
            bVar2.en = 1.0f;
        }
        if (bVar2.en > 1.0f) {
            bVar2.en = 1.0f;
        }
        if (bVar2.en < 0.0f) {
            bVar2.en = 0.0f;
        }
    }

    private static void releaseInstance() {
        dO = null;
    }

    private void w(String str) {
        if (this.dP == null || this.dP.get(str) == null) {
            return;
        }
        this.dP.remove(str);
    }

    private MediaPlayer x(String str) {
        if (this.dP == null || this.dP.get(str) == null) {
            return null;
        }
        return this.dP.get(str).dy;
    }

    public SurfaceTexture A(String str) {
        if (this.dP == null) {
            return null;
        }
        b bVar = this.dP.get(str);
        return bVar != null ? bVar.dW : null;
    }

    public int a(Map<String, Integer> map, String str) {
        Integer num = map.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void a(final com.baidu.ar.arplay.a.a.e eVar, final HashMap<String, Object> hashMap) {
        if (eVar.aO() > 1) {
            this.dQ.put(eVar.getId(), Integer.valueOf(eVar.aO()));
        }
        c(1022, hashMap);
        a(new a() { // from class: com.baidu.ar.arplay.a.e.9
        }, eVar.getId(), eVar.getUrl(), new MediaPlayer.OnCompletionListener() { // from class: com.baidu.ar.arplay.a.e.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (e.this.dQ == null || eVar == null) {
                    return;
                }
                b y = e.this.y(eVar.getId());
                if (y != null) {
                    y.dz.ei = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                    y.dz.ek = "finished";
                    e.a(y);
                    if (eVar.aR()) {
                        e.this.a(eVar, hashMap);
                        return;
                    }
                }
                if (e.this.dQ.size() <= 0) {
                    e.this.c(1030, hashMap);
                    return;
                }
                int a2 = e.this.a(e.this.dQ, eVar.getId());
                if (a2 <= 1) {
                    e.this.c(1030, hashMap);
                    return;
                }
                int i = a2 - 1;
                e.this.dQ.put(eVar.getId(), Integer.valueOf(i));
                eVar.j(i);
                e.this.a(eVar, hashMap);
            }
        }, eVar.aS(), eVar.aO(), eVar.aQ(), eVar.aP());
    }

    public void a(a aVar, String str) {
        b y = y(str);
        if (y != null) {
            y.dz.ei = DownloadConstants.DownloadColumns.COLUMN_STATUS;
            y.dz.ek = "unstarted";
            a(y);
        }
        MediaPlayer x = x(str);
        if (x != null) {
            com.baidu.ar.arplay.c.b.b(TAG, "mMediaPlayer stopPlay");
            com.baidu.ar.arplay.a.a.a(x);
            w(str);
        }
    }

    public void a(a aVar, String str, String str2, MediaPlayer.OnCompletionListener onCompletionListener, int i, int i2, String str3, long j) {
        a(aVar, str, str2, i, onCompletionListener, false, str3, j);
    }

    public void a(a aVar, String str, boolean z) {
        MediaPlayer x = x(str);
        if (x != null) {
            try {
                if (x.isPlaying()) {
                    b y = y(str);
                    if (y != null) {
                        y.dz.ei = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                        y.dz.ek = "paused";
                        y.dY = z;
                        a(y);
                    }
                    com.baidu.ar.arplay.c.b.b(TAG, "mMediaPlayer pause");
                    x.pause();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(a aVar, boolean z) {
        if (this.dP != null) {
            for (Map.Entry<String, b> entry : this.dP.entrySet()) {
                a(aVar, entry.getKey(), z);
            }
        }
    }

    public void a(String str, int i) {
        b bVar = this.dP.get(str);
        if (bVar != null) {
            bVar.dW = new SurfaceTexture(i);
            try {
                bVar.dy.setSurface(new Surface(bVar.dW));
            } catch (Exception e) {
                Log.i("VideoPlayerManager", "MediaPlayer setSurface failed.");
            }
            bVar.dX = i;
        }
    }

    public void aC() {
        if (this.dP != null) {
            for (Map.Entry<String, b> entry : this.dP.entrySet()) {
                if (entry != null) {
                    a((a) null, entry.getKey());
                    entry.getValue().dW = null;
                    entry.getValue().dz.ei = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                    entry.getValue().dz.ek = "unstarted";
                    entry.getValue().dY = false;
                    a(entry.getValue());
                    MediaPlayer mediaPlayer = entry.getValue().dy;
                    if (mediaPlayer != null) {
                        try {
                            mediaPlayer.release();
                        } catch (Exception e) {
                            System.out.println("player release Exception");
                        }
                    }
                }
            }
            this.dP.clear();
        }
    }

    public void b(com.baidu.ar.arplay.a.a.e eVar, final HashMap<String, Object> hashMap) {
        c(1024, hashMap);
        a(new a() { // from class: com.baidu.ar.arplay.a.e.11
        }, eVar.getId(), false);
    }

    public void b(a aVar, String str) {
        if (ARPEngine.getInstance().isPaused()) {
            return;
        }
        MediaPlayer x = x(str);
        b y = y(str);
        if (y != null) {
            if ((y.dz.ek == "paused" || y.dz.ek == DpStatConstants.KEY_PREPARED) && x != null) {
                com.baidu.ar.arplay.c.b.b(TAG, "mMediaPlayer start");
                x.start();
                y.dz.ei = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                y.dz.ek = "playing";
                a(y);
            }
        }
    }

    public void b(a aVar, boolean z) {
        if (this.dP != null) {
            for (Map.Entry<String, b> entry : this.dP.entrySet()) {
                if (!z) {
                    b(aVar, entry.getKey());
                } else if (entry != null && entry.getValue() != null && entry.getValue().dY) {
                    b(aVar, entry.getKey());
                }
            }
        }
    }

    public void c(int i, HashMap<String, Object> hashMap) {
        ARPMessage.getInstance().sendMessage(i, hashMap);
    }

    public void c(com.baidu.ar.arplay.a.a.e eVar, final HashMap<String, Object> hashMap) {
        c(ARPMessageType.MSG_TYPE_VIDEO_RESUME_RES, hashMap);
        com.baidu.ar.arplay.c.b.b(TAG, "mMediaPlayer resumeVideo");
        b(new a() { // from class: com.baidu.ar.arplay.a.e.2
        }, eVar.getId());
    }

    public void d(com.baidu.ar.arplay.a.a.e eVar, final HashMap<String, Object> hashMap) {
        c(ARPMessageType.MSG_TYPE_VIDEO_STOP_RES, hashMap);
        a(new a() { // from class: com.baidu.ar.arplay.a.e.3
        }, eVar.getId());
    }

    public synchronized void release() {
        if (this.dn != null) {
            this.dn.cancel();
            this.dn.purge();
            this.dn = null;
            if (this.f1do != null) {
                this.f1do.cancel();
                this.f1do = null;
            }
        }
        com.baidu.ar.arplay.c.d.b(this.dR);
        aC();
        releaseInstance();
    }

    public b y(String str) {
        if (this.dP != null) {
            return this.dP.get(str);
        }
        return null;
    }

    public int z(String str) {
        b y = y(str);
        if (y != null) {
            return y.dX;
        }
        return 0;
    }
}
