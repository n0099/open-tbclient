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
/* loaded from: classes12.dex */
public class e {
    public static final String TAG = e.class.getSimpleName();
    private static e dq;
    private Timer cP;
    private TimerTask cQ;
    private int cH = 0;
    private boolean cI = false;
    private ConcurrentHashMap<String, b> dr = new ConcurrentHashMap<>();
    private com.baidu.ar.arplay.c.a dt = new com.baidu.ar.arplay.c.a() { // from class: com.baidu.ar.arplay.a.e.1
        @Override // com.baidu.ar.arplay.c.a
        public void a(e.a aVar) {
            e.this.b((a) null, true);
        }

        @Override // com.baidu.ar.arplay.c.a
        public void aL() {
            e.this.a((a) null, true);
        }
    };
    private Map<String, Integer> ds = new Hashtable();

    /* loaded from: classes12.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static class b {
        MediaPlayer da;
        String dx;
        SurfaceTexture dy;
        int dz;
        boolean dA = false;
        com.baidu.ar.arplay.a.a.b db = new com.baidu.ar.arplay.a.a.b();

        b() {
        }
    }

    private e() {
        com.baidu.ar.arplay.c.d.a(this.dt);
    }

    private void a(a aVar, String str, String str2, int i, MediaPlayer.OnCompletionListener onCompletionListener, boolean z, String str3, final long j) {
        if (this.dr.containsKey(str)) {
            b bVar = this.dr.get(str);
            if (bVar != null) {
                try {
                    if (bVar.da != null) {
                        bVar.da.reset();
                        bVar.da.setDataSource(str2);
                        bVar.da.setLooping(z);
                        bVar.da.setOnCompletionListener(onCompletionListener);
                        bVar.da.prepareAsync();
                        bVar.dx = str2;
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
            bVar2.dx = str2;
            bVar2.da = new MediaPlayer();
            bVar2.da.setDataSource(str2);
            bVar2.dz = i;
            bVar2.dy = new SurfaceTexture(i);
            bVar2.db.dG = Long.valueOf(str).longValue();
            bVar2.db.dH = str3;
            bVar2.da.setSurface(new Surface(bVar2.dy));
            bVar2.da.setOnCompletionListener(onCompletionListener);
            bVar2.da.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.ar.arplay.a.e.4
                @Override // android.media.MediaPlayer.OnErrorListener
                public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                    bVar2.db.dK = "ERROR";
                    bVar2.db.dL = i2;
                    e.a(bVar2);
                    return true;
                }
            });
            bVar2.da.setLooping(z);
            bVar2.da.prepareAsync();
            com.baidu.ar.arplay.c.b.b(TAG, "wrapper.mMediaPlayer.prepareAsync()");
            bVar2.da.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.ar.arplay.a.e.5
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    com.baidu.ar.arplay.c.b.b(e.TAG, "mMediaPlayer onPrepared");
                    bVar2.db.dK = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                    bVar2.db.dM = DpStatConstants.KEY_PREPARED;
                    e.a(bVar2);
                    if (ARPEngine.getInstance().isEngineCanAccess() && !ARPEngine.getInstance().isPaused()) {
                        e.this.aB();
                        try {
                            if (bVar2.da.getDuration() >= 0) {
                                if (bVar2.da.getDuration() <= j || j < 0) {
                                    bVar2.da.seekTo(0);
                                } else {
                                    bVar2.da.seekTo((int) j);
                                }
                            }
                            com.baidu.ar.arplay.c.b.b(e.TAG, "mMediaPlayer start");
                            bVar2.da.start();
                            bVar2.db.dM = "playing";
                        } catch (Exception e2) {
                            e2.fillInStackTrace();
                        }
                    }
                }
            });
            bVar2.da.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.ar.arplay.a.e.6
                @Override // android.media.MediaPlayer.OnBufferingUpdateListener
                public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
                    bVar2.db.dK = "INFO";
                    bVar2.db.dO = i2;
                    e.a(bVar2);
                }
            });
            bVar2.da.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.ar.arplay.a.e.7
                @Override // android.media.MediaPlayer.OnInfoListener
                public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
                    bVar2.db.dK = "INFO";
                    switch (i2) {
                        case 701:
                            bVar2.db.dN = "buffer_start";
                            e.a(bVar2);
                            return false;
                        case CyberPlayerManager.MEDIA_INFO_BUFFERING_END /* 702 */:
                            bVar2.db.dN = "buffer_end";
                            e.a(bVar2);
                            return false;
                        default:
                            return false;
                    }
                }
            });
            if (this.dr == null || str == null) {
                return;
            }
            this.dr.put(str, bVar2);
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
        b(bVar.db);
        com.baidu.ar.arplay.a.a.b bVar2 = bVar.db;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", Integer.valueOf((int) ARPMessageType.MSG_TYPE_VIDEO));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("action_id", String.valueOf(bVar2.dG));
        hashMap2.put("platform", "android");
        hashMap2.put("type", bVar2.dK);
        HashMap hashMap3 = new HashMap();
        hashMap3.put("error_code", Integer.valueOf(bVar2.dL));
        hashMap3.put("buffer_status", bVar2.dN);
        hashMap3.put("buffer_progress", Integer.valueOf(bVar2.dO));
        hashMap3.put("play_status", bVar2.dM);
        hashMap3.put("play_progress", Integer.valueOf((int) (bVar2.dP * 100.0f)));
        hashMap2.put("data", hashMap3);
        hashMap.put("msg_data", hashMap2);
        ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aB() {
        if (this.cP == null) {
            this.cP = new Timer();
            this.cQ = new TimerTask() { // from class: com.baidu.ar.arplay.a.e.8
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    b bVar;
                    if (e.this.dr != null) {
                        for (Map.Entry entry : e.this.dr.entrySet()) {
                            if (entry != null && (bVar = (b) entry.getValue()) != null && bVar.db != null && bVar.db.dM == "playing") {
                                e.a((b) entry.getValue());
                            }
                        }
                    }
                }
            };
            this.cP.scheduleAtFixedRate(this.cQ, 0L, 200L);
        }
    }

    public static synchronized e aK() {
        e eVar;
        synchronized (e.class) {
            if (dq == null) {
                dq = new e();
            }
            eVar = dq;
        }
        return eVar;
    }

    private static void b(com.baidu.ar.arplay.a.a.b bVar) {
        if (bVar == null) {
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", String.valueOf(bVar.dG));
        hashMap.put("target", bVar.dH);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("play_status", bVar.dM);
        hashMap2.put("buffer_status", bVar.dN);
        hashMap2.put("duration", String.valueOf(bVar.dI));
        hashMap2.put("buffer_progress", String.valueOf(bVar.dO));
        hashMap2.put("play_progress", String.valueOf((int) (100.0f * bVar.dP)));
        hashMap.put("msg_data", hashMap2);
        ARPMessage.getInstance().sendMessage(1031, hashMap);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x004a -> B:27:0x0029). Please submit an issue!!! */
    private static void b(b bVar) {
        if (bVar == null || bVar.da == null) {
            return;
        }
        com.baidu.ar.arplay.a.a.b bVar2 = bVar.db;
        if (bVar2.dM == "playing" || bVar2.dM == "paused") {
            try {
                bVar2.dI = bVar.da.getDuration();
                if (bVar2.dI <= 0) {
                    bVar2.dP = 0.0f;
                } else {
                    bVar2.dP = (bVar.da.getCurrentPosition() * 1.0f) / bVar2.dI;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (bVar2.dM == "finished") {
            bVar2.dP = 1.0f;
        }
        if (bVar2.dP > 1.0f) {
            bVar2.dP = 1.0f;
        }
        if (bVar2.dP < 0.0f) {
            bVar2.dP = 0.0f;
        }
    }

    private static void releaseInstance() {
        dq = null;
    }

    private void x(String str) {
        if (this.dr == null || this.dr.get(str) == null) {
            return;
        }
        this.dr.remove(str);
    }

    private MediaPlayer y(String str) {
        if (this.dr == null || this.dr.get(str) == null) {
            return null;
        }
        return this.dr.get(str).da;
    }

    public int A(String str) {
        b z = z(str);
        if (z != null) {
            return z.dz;
        }
        return 0;
    }

    public SurfaceTexture B(String str) {
        if (this.dr == null) {
            return null;
        }
        b bVar = this.dr.get(str);
        return bVar != null ? bVar.dy : null;
    }

    public int a(Map<String, Integer> map, String str) {
        Integer num = map.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void a(final com.baidu.ar.arplay.a.a.e eVar, final HashMap<String, Object> hashMap) {
        if (eVar.aM() > 1) {
            this.ds.put(eVar.getId(), Integer.valueOf(eVar.aM()));
        }
        c(1022, hashMap);
        a(new a() { // from class: com.baidu.ar.arplay.a.e.9
        }, eVar.getId(), eVar.getUrl(), new MediaPlayer.OnCompletionListener() { // from class: com.baidu.ar.arplay.a.e.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (e.this.ds == null || eVar == null) {
                    return;
                }
                b z = e.this.z(eVar.getId());
                if (z != null) {
                    z.db.dK = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                    z.db.dM = "finished";
                    e.a(z);
                    if (eVar.aP()) {
                        e.this.a(eVar, hashMap);
                        return;
                    }
                }
                if (e.this.ds.size() <= 0) {
                    e.this.c(1030, hashMap);
                    return;
                }
                int a2 = e.this.a(e.this.ds, eVar.getId());
                if (a2 <= 1) {
                    e.this.c(1030, hashMap);
                    return;
                }
                int i = a2 - 1;
                e.this.ds.put(eVar.getId(), Integer.valueOf(i));
                eVar.g(i);
                e.this.a(eVar, hashMap);
            }
        }, eVar.aQ(), eVar.aM(), eVar.aO(), eVar.aN());
    }

    public void a(a aVar, String str) {
        b z = z(str);
        if (z != null) {
            z.db.dK = DownloadConstants.DownloadColumns.COLUMN_STATUS;
            z.db.dM = "unstarted";
            a(z);
        }
        MediaPlayer y = y(str);
        if (y != null) {
            com.baidu.ar.arplay.c.b.b(TAG, "mMediaPlayer stopPlay");
            com.baidu.ar.arplay.a.a.a(y);
            x(str);
        }
    }

    public void a(a aVar, String str, String str2, MediaPlayer.OnCompletionListener onCompletionListener, int i, int i2, String str3, long j) {
        a(aVar, str, str2, i, onCompletionListener, false, str3, j);
    }

    public void a(a aVar, String str, boolean z) {
        MediaPlayer y = y(str);
        if (y != null) {
            try {
                if (y.isPlaying()) {
                    b z2 = z(str);
                    if (z2 != null) {
                        z2.db.dK = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                        z2.db.dM = "paused";
                        z2.dA = z;
                        a(z2);
                    }
                    com.baidu.ar.arplay.c.b.b(TAG, "mMediaPlayer pause");
                    y.pause();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(a aVar, boolean z) {
        if (this.dr != null) {
            for (Map.Entry<String, b> entry : this.dr.entrySet()) {
                a(aVar, entry.getKey(), z);
            }
        }
    }

    public void a(String str, int i) {
        b bVar = this.dr.get(str);
        if (bVar != null) {
            bVar.dy = new SurfaceTexture(i);
            try {
                bVar.da.setSurface(new Surface(bVar.dy));
            } catch (Exception e) {
                Log.i("VideoPlayerManager", "MediaPlayer setSurface failed.");
            }
            bVar.dz = i;
        }
    }

    public void aA() {
        if (this.dr != null) {
            for (Map.Entry<String, b> entry : this.dr.entrySet()) {
                if (entry != null) {
                    a((a) null, entry.getKey());
                    entry.getValue().dy = null;
                    entry.getValue().db.dK = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                    entry.getValue().db.dM = "unstarted";
                    entry.getValue().dA = false;
                    a(entry.getValue());
                    MediaPlayer mediaPlayer = entry.getValue().da;
                    if (mediaPlayer != null) {
                        try {
                            mediaPlayer.release();
                        } catch (Exception e) {
                            System.out.println("player release Exception");
                        }
                    }
                }
            }
            this.dr.clear();
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
        MediaPlayer y = y(str);
        b z = z(str);
        if (z != null) {
            if ((z.db.dM == "paused" || z.db.dM == DpStatConstants.KEY_PREPARED) && y != null) {
                com.baidu.ar.arplay.c.b.b(TAG, "mMediaPlayer start");
                aB();
                y.start();
                z.db.dK = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                z.db.dM = "playing";
                a(z);
            }
        }
    }

    public void b(a aVar, boolean z) {
        if (this.dr != null) {
            for (Map.Entry<String, b> entry : this.dr.entrySet()) {
                if (!z) {
                    b(aVar, entry.getKey());
                } else if (entry != null && entry.getValue() != null && entry.getValue().dA) {
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
        if (this.cP != null) {
            this.cP.cancel();
            this.cP.purge();
            this.cP = null;
            if (this.cQ != null) {
                this.cQ.cancel();
                this.cQ = null;
            }
        }
        com.baidu.ar.arplay.c.d.b(this.dt);
        aA();
        releaseInstance();
    }

    public b z(String str) {
        if (this.dr != null) {
            return this.dr.get(str);
        }
        return null;
    }
}
