package com.baidu.ar.arplay.a;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.Surface;
import com.baidu.ar.arplay.c.e;
import com.baidu.ar.arplay.core.engine.ARPEngine;
import com.baidu.ar.arplay.core.message.ARPMessage;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.download.util.LocalDataScanHelper;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class e {
    public static final String TAG = "e";
    public static e dD;
    public Timer cU;
    public TimerTask cV;
    public int cM = 0;
    public boolean cN = false;
    public ConcurrentHashMap<String, b> dE = new ConcurrentHashMap<>();
    public com.baidu.ar.arplay.c.a dG = new com.baidu.ar.arplay.c.a() { // from class: com.baidu.ar.arplay.a.e.1
        @Override // com.baidu.ar.arplay.c.a
        public void a(e.a aVar) {
            e.this.b((a) null, true);
        }

        @Override // com.baidu.ar.arplay.c.a
        public void aM() {
            e.this.a((a) null, true);
        }
    };
    public Map<String, Integer> dF = new Hashtable();

    /* loaded from: classes.dex */
    public interface a {
    }

    /* loaded from: classes.dex */
    public static class b {
        public String dK;
        public SurfaceTexture dL;
        public int dM;
        public MediaPlayer df;
        public boolean dN = false;
        public com.baidu.ar.arplay.a.a.b dg = new com.baidu.ar.arplay.a.a.b();
    }

    public e() {
        com.baidu.ar.arplay.c.d.a(this.dG);
    }

    private void A(String str) {
        ConcurrentHashMap<String, b> concurrentHashMap = this.dE;
        if (concurrentHashMap == null || concurrentHashMap.get(str) == null) {
            return;
        }
        this.dE.remove(str);
    }

    private MediaPlayer B(String str) {
        ConcurrentHashMap<String, b> concurrentHashMap = this.dE;
        if (concurrentHashMap == null || concurrentHashMap.get(str) == null) {
            return null;
        }
        return this.dE.get(str).df;
    }

    private void a(a aVar, String str, String str2, int i, MediaPlayer.OnCompletionListener onCompletionListener, boolean z, String str3, final long j) {
        try {
            if (this.dE.containsKey(str)) {
                b bVar = this.dE.get(str);
                if (bVar == null) {
                    return;
                }
                if (bVar.df != null) {
                    bVar.df.reset();
                    bVar.df.setDataSource(str2);
                    bVar.df.setLooping(z);
                    bVar.df.setOnCompletionListener(onCompletionListener);
                    bVar.df.prepareAsync();
                    bVar.dK = str2;
                }
            } else {
                final b bVar2 = new b();
                bVar2.dK = str2;
                MediaPlayer mediaPlayer = new MediaPlayer();
                bVar2.df = mediaPlayer;
                mediaPlayer.setDataSource(str2);
                bVar2.dM = i;
                bVar2.dL = new SurfaceTexture(i);
                bVar2.dg.dT = Long.valueOf(str).longValue();
                bVar2.dg.dU = str3;
                bVar2.df.setSurface(new Surface(bVar2.dL));
                bVar2.df.setOnCompletionListener(onCompletionListener);
                bVar2.df.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.ar.arplay.a.e.4
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer2, int i2, int i3) {
                        b bVar3 = bVar2;
                        com.baidu.ar.arplay.a.a.b bVar4 = bVar3.dg;
                        bVar4.dX = "ERROR";
                        bVar4.dY = i2;
                        e.a(bVar3);
                        return true;
                    }
                });
                bVar2.df.setLooping(z);
                bVar2.df.prepareAsync();
                com.baidu.ar.arplay.c.b.b(TAG, "wrapper.mMediaPlayer.prepareAsync()");
                bVar2.df.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.ar.arplay.a.e.5
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer2) {
                        com.baidu.ar.arplay.c.b.b(e.TAG, "mMediaPlayer onPrepared");
                        b bVar3 = bVar2;
                        com.baidu.ar.arplay.a.a.b bVar4 = bVar3.dg;
                        bVar4.dX = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                        bVar4.dZ = DpStatConstants.KEY_PREPARED;
                        e.a(bVar3);
                        if (ARPEngine.getInstance().isEngineCanAccess() && !ARPEngine.getInstance().isPaused()) {
                            e.this.aC();
                            try {
                                if (bVar2.df.getDuration() >= 0) {
                                    if (bVar2.df.getDuration() > j && j >= 0) {
                                        bVar2.df.seekTo((int) j);
                                    }
                                    bVar2.df.seekTo(0);
                                }
                                com.baidu.ar.arplay.c.b.b(e.TAG, "mMediaPlayer start");
                                bVar2.df.start();
                                bVar2.dg.dZ = "playing";
                            } catch (Exception e) {
                                e.fillInStackTrace();
                            }
                        }
                    }
                });
                bVar2.df.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.ar.arplay.a.e.6
                    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
                    public void onBufferingUpdate(MediaPlayer mediaPlayer2, int i2) {
                        b bVar3 = bVar2;
                        com.baidu.ar.arplay.a.a.b bVar4 = bVar3.dg;
                        bVar4.dX = "INFO";
                        bVar4.eb = i2;
                        e.a(bVar3);
                    }
                });
                bVar2.df.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.ar.arplay.a.e.7
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i2, int i3) {
                        String str4;
                        b bVar3 = bVar2;
                        com.baidu.ar.arplay.a.a.b bVar4 = bVar3.dg;
                        bVar4.dX = "INFO";
                        if (i2 == 701) {
                            str4 = "buffer_start";
                        } else if (i2 != 702) {
                            return false;
                        } else {
                            str4 = "buffer_end";
                        }
                        bVar4.ea = str4;
                        e.a(bVar3);
                        return false;
                    }
                });
                if (this.dE != null && str != null) {
                    this.dE.put(str, bVar2);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(b bVar) {
        if (bVar == null) {
            return;
        }
        b(bVar);
        b(bVar.dg);
        com.baidu.ar.arplay.a.a.b bVar2 = bVar.dg;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", Integer.valueOf((int) ARPMessageType.MSG_TYPE_VIDEO));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("action_id", String.valueOf(bVar2.dT));
        hashMap2.put(Constants.PARAM_PLATFORM, "android");
        hashMap2.put("type", bVar2.dX);
        HashMap hashMap3 = new HashMap();
        hashMap3.put("error_code", Integer.valueOf(bVar2.dY));
        hashMap3.put("buffer_status", bVar2.ea);
        hashMap3.put("buffer_progress", Integer.valueOf(bVar2.eb));
        hashMap3.put("play_status", bVar2.dZ);
        hashMap3.put(LocalDataScanHelper.EXT_KEY_PLAY_PROGRESS, Integer.valueOf((int) (bVar2.ec * 100.0f)));
        hashMap2.put("data", hashMap3);
        hashMap.put("msg_data", hashMap2);
        ARPMessage.getInstance().sendMessage(1902, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aC() {
        if (this.cU == null) {
            this.cU = new Timer();
            TimerTask timerTask = new TimerTask() { // from class: com.baidu.ar.arplay.a.e.8
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    b bVar;
                    com.baidu.ar.arplay.a.a.b bVar2;
                    if (e.this.dE != null) {
                        for (Map.Entry entry : e.this.dE.entrySet()) {
                            if (entry != null && (bVar = (b) entry.getValue()) != null && (bVar2 = bVar.dg) != null && bVar2.dZ == "playing") {
                                e.a((b) entry.getValue());
                            }
                        }
                    }
                }
            };
            this.cV = timerTask;
            this.cU.scheduleAtFixedRate(timerTask, 0L, 200L);
        }
    }

    public static synchronized e aL() {
        e eVar;
        synchronized (e.class) {
            if (dD == null) {
                dD = new e();
            }
            eVar = dD;
        }
        return eVar;
    }

    public static void b(com.baidu.ar.arplay.a.a.b bVar) {
        if (bVar == null) {
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", String.valueOf(bVar.dT));
        hashMap.put("target", bVar.dU);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("play_status", bVar.dZ);
        hashMap2.put("buffer_status", bVar.ea);
        hashMap2.put("duration", String.valueOf(bVar.dV));
        hashMap2.put("buffer_progress", String.valueOf(bVar.eb));
        hashMap2.put(LocalDataScanHelper.EXT_KEY_PLAY_PROGRESS, String.valueOf((int) (bVar.ec * 100.0f)));
        hashMap.put("msg_data", hashMap2);
        ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_VIDEO_PLAY_INFO_UPDATE, hashMap);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x003c -> B:28:0x003f). Please submit an issue!!! */
    public static void b(b bVar) {
        if (bVar == null || bVar.df == null) {
            return;
        }
        com.baidu.ar.arplay.a.a.b bVar2 = bVar.dg;
        String str = bVar2.dZ;
        if (str == "playing" || str == "paused") {
            try {
                int duration = bVar.df.getDuration();
                bVar2.dV = duration;
                if (duration <= 0) {
                    bVar2.ec = 0.0f;
                } else {
                    bVar2.ec = (bVar.df.getCurrentPosition() * 1.0f) / bVar2.dV;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (str == DownloadStatisticConstants.UBC_TYPE_FINISHED) {
            bVar2.ec = 1.0f;
        }
        if (bVar2.ec > 1.0f) {
            bVar2.ec = 1.0f;
        }
        if (bVar2.ec < 0.0f) {
            bVar2.ec = 0.0f;
        }
    }

    public static void releaseInstance() {
        dD = null;
    }

    public b C(String str) {
        ConcurrentHashMap<String, b> concurrentHashMap = this.dE;
        if (concurrentHashMap != null) {
            return concurrentHashMap.get(str);
        }
        return null;
    }

    public int D(String str) {
        b C = C(str);
        if (C != null) {
            return C.dM;
        }
        return 0;
    }

    public SurfaceTexture E(String str) {
        b bVar;
        ConcurrentHashMap<String, b> concurrentHashMap = this.dE;
        if (concurrentHashMap == null || (bVar = concurrentHashMap.get(str)) == null) {
            return null;
        }
        return bVar.dL;
    }

    public int a(Map<String, Integer> map, String str) {
        Integer num = map.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void a(final com.baidu.ar.arplay.a.a.e eVar, final HashMap<String, Object> hashMap) {
        if (eVar.aN() > 1) {
            this.dF.put(eVar.getId(), Integer.valueOf(eVar.aN()));
        }
        c(1022, hashMap);
        a(new a() { // from class: com.baidu.ar.arplay.a.e.9
        }, eVar.getId(), eVar.getUrl(), new MediaPlayer.OnCompletionListener() { // from class: com.baidu.ar.arplay.a.e.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                com.baidu.ar.arplay.a.a.e eVar2;
                e eVar3;
                int a2;
                if (e.this.dF == null || (eVar2 = eVar) == null) {
                    return;
                }
                b C = e.this.C(eVar2.getId());
                if (C != null) {
                    com.baidu.ar.arplay.a.a.b bVar = C.dg;
                    bVar.dX = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                    bVar.dZ = DownloadStatisticConstants.UBC_TYPE_FINISHED;
                    e.a(C);
                    if (eVar.aQ()) {
                        e.this.a(eVar, hashMap);
                        return;
                    }
                }
                if (e.this.dF.size() <= 0 || (a2 = (eVar3 = e.this).a(eVar3.dF, eVar.getId())) <= 1) {
                    e.this.c(1030, hashMap);
                    return;
                }
                int i = a2 - 1;
                e.this.dF.put(eVar.getId(), Integer.valueOf(i));
                eVar.i(i);
                e.this.a(eVar, hashMap);
            }
        }, eVar.aR(), eVar.aN(), eVar.aP(), eVar.aO());
    }

    public void a(a aVar, String str) {
        b C = C(str);
        if (C != null) {
            com.baidu.ar.arplay.a.a.b bVar = C.dg;
            bVar.dX = DownloadConstants.DownloadColumns.COLUMN_STATUS;
            bVar.dZ = "unstarted";
            a(C);
        }
        MediaPlayer B = B(str);
        if (B != null) {
            com.baidu.ar.arplay.c.b.b(TAG, "mMediaPlayer stopPlay");
            com.baidu.ar.arplay.a.a.a(B);
            A(str);
        }
    }

    public void a(a aVar, String str, String str2, MediaPlayer.OnCompletionListener onCompletionListener, int i, int i2, String str3, long j) {
        a(aVar, str, str2, i, onCompletionListener, false, str3, j);
    }

    public void a(a aVar, String str, boolean z) {
        MediaPlayer B = B(str);
        if (B != null) {
            try {
                if (B.isPlaying()) {
                    b C = C(str);
                    if (C != null) {
                        C.dg.dX = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                        C.dg.dZ = "paused";
                        C.dN = z;
                        a(C);
                    }
                    com.baidu.ar.arplay.c.b.b(TAG, "mMediaPlayer pause");
                    B.pause();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(a aVar, boolean z) {
        ConcurrentHashMap<String, b> concurrentHashMap = this.dE;
        if (concurrentHashMap != null) {
            for (Map.Entry<String, b> entry : concurrentHashMap.entrySet()) {
                a(aVar, entry.getKey(), z);
            }
        }
    }

    public void a(String str, int i) {
        b bVar = this.dE.get(str);
        if (bVar != null) {
            bVar.dL = new SurfaceTexture(i);
            try {
                bVar.df.setSurface(new Surface(bVar.dL));
            } catch (Exception unused) {
                Log.i("VideoPlayerManager", "MediaPlayer setSurface failed.");
            }
            bVar.dM = i;
        }
    }

    public void aB() {
        ConcurrentHashMap<String, b> concurrentHashMap = this.dE;
        if (concurrentHashMap != null) {
            for (Map.Entry<String, b> entry : concurrentHashMap.entrySet()) {
                if (entry != null) {
                    a((a) null, entry.getKey());
                    entry.getValue().dL = null;
                    entry.getValue().dg.dX = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                    entry.getValue().dg.dZ = "unstarted";
                    entry.getValue().dN = false;
                    a(entry.getValue());
                    MediaPlayer mediaPlayer = entry.getValue().df;
                    if (mediaPlayer != null) {
                        try {
                            com.baidu.ar.arplay.c.b.b(TAG, "releaseMediaPlayer");
                            mediaPlayer.release();
                        } catch (Exception unused) {
                            System.out.println("player release Exception");
                        }
                    }
                }
            }
            this.dE.clear();
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
        MediaPlayer B = B(str);
        b C = C(str);
        if (C == null) {
            return;
        }
        String str2 = C.dg.dZ;
        if ((str2 == "paused" || str2 == DpStatConstants.KEY_PREPARED) && B != null) {
            com.baidu.ar.arplay.c.b.b(TAG, "mMediaPlayer start");
            aC();
            B.start();
            com.baidu.ar.arplay.a.a.b bVar = C.dg;
            bVar.dX = DownloadConstants.DownloadColumns.COLUMN_STATUS;
            bVar.dZ = "playing";
            a(C);
        }
    }

    public void b(a aVar, boolean z) {
        ConcurrentHashMap<String, b> concurrentHashMap = this.dE;
        if (concurrentHashMap != null) {
            for (Map.Entry<String, b> entry : concurrentHashMap.entrySet()) {
                if (!z || (entry != null && entry.getValue() != null && entry.getValue().dN)) {
                    b(aVar, entry.getKey());
                }
            }
        }
    }

    public void c(int i, HashMap<String, Object> hashMap) {
        ARPMessage.getInstance().sendMessage(i, hashMap);
    }

    public void c(com.baidu.ar.arplay.a.a.e eVar, final HashMap<String, Object> hashMap) {
        c(1026, hashMap);
        com.baidu.ar.arplay.c.b.b(TAG, "mMediaPlayer resumeVideo");
        b(new a() { // from class: com.baidu.ar.arplay.a.e.2
        }, eVar.getId());
    }

    public void d(com.baidu.ar.arplay.a.a.e eVar, final HashMap<String, Object> hashMap) {
        c(1028, hashMap);
        a(new a() { // from class: com.baidu.ar.arplay.a.e.3
        }, eVar.getId());
    }

    public synchronized void release() {
        if (this.cU != null) {
            this.cU.cancel();
            this.cU.purge();
            this.cU = null;
            if (this.cV != null) {
                this.cV.cancel();
                this.cV = null;
            }
        }
        com.baidu.ar.arplay.c.d.b(this.dG);
        aB();
        releaseInstance();
    }
}
