package com.baidu.ar.arplay.a;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.ar.arplay.core.engine.ARPEngine;
import com.baidu.ar.arplay.core.message.ARPMessage;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.down.manage.DownloadConstants;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes14.dex */
public final class a {
    private static a cG;
    private static ConcurrentHashMap<String, C0074a> cJ;
    private static HandlerThread cK;
    private static b cM;
    private static Map<String, Integer> cO;
    private static Timer cP;
    private static TimerTask cQ;
    private Map<String, Integer> cN;
    private Handler mHandler;
    private static Handler cL = new Handler(Looper.getMainLooper());
    public static final String TAG = a.class.getSimpleName();
    private static Runnable cR = new Runnable() { // from class: com.baidu.ar.arplay.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.cK != null) {
                a.cK.quit();
                HandlerThread unused = a.cK = null;
            }
        }
    };
    private int cH = 0;
    private boolean cI = false;
    private Handler.Callback cS = new Handler.Callback() { // from class: com.baidu.ar.arplay.a.a.8
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (ARPEngine.getInstance().isEngineCanAccess()) {
                switch (message.what) {
                    case CyberPlayerManager.MEDIA_INFO_RTMP_IO_FAIL /* 3004 */:
                        a.this.a(message);
                        break;
                    case 3005:
                        a.this.b(message);
                        break;
                    case 3006:
                        a.this.c(message);
                        break;
                    case 3007:
                        a.this.e(message);
                        break;
                    case 3008:
                        a.this.f(message);
                        break;
                    case 3009:
                        a.this.d(message);
                        break;
                }
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.ar.arplay.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static class C0074a {
        MediaPlayer da;
        com.baidu.ar.arplay.a.a.b db = new com.baidu.ar.arplay.a.a.b();

        C0074a() {
        }
    }

    /* loaded from: classes14.dex */
    public interface b {
        void a(Exception exc);

        void onResult(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class c implements b {
        c(b bVar) {
            b unused = a.cM = bVar;
        }

        @Override // com.baidu.ar.arplay.a.a.b
        public void a(final Exception exc) {
            if (a.cM == null) {
                return;
            }
            a.cL.post(new Runnable() { // from class: com.baidu.ar.arplay.a.a.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.cM != null) {
                        a.cM.a(exc);
                    }
                }
            });
        }

        @Override // com.baidu.ar.arplay.a.a.b
        public void onResult(final boolean z) {
            if (a.cM == null) {
                return;
            }
            a.cL.post(new Runnable() { // from class: com.baidu.ar.arplay.a.a.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.cM != null) {
                        a.cM.onResult(z);
                    }
                }
            });
        }
    }

    private a() {
        synchronized (a.class) {
            if (cK == null) {
                cK = new HandlerThread("MediaPlayerThread");
                cK.start();
            } else {
                cL.removeCallbacks(cR);
            }
        }
        this.mHandler = new Handler(cK.getLooper(), this.cS);
        this.cN = new Hashtable();
        cO = new Hashtable();
    }

    public static int a(Map<String, Integer> map, String str) {
        Integer num = map.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private C0074a a(MediaPlayer.OnCompletionListener onCompletionListener, MediaPlayer.OnErrorListener onErrorListener) {
        try {
            final C0074a c0074a = new C0074a();
            MediaPlayer mediaPlayer = new MediaPlayer();
            c0074a.da = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
            if (onCompletionListener == null) {
                onCompletionListener = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.ar.arplay.a.a.9
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer2) {
                    }
                };
            }
            mediaPlayer.setOnCompletionListener(onCompletionListener);
            if (onErrorListener == null) {
                onErrorListener = new MediaPlayer.OnErrorListener() { // from class: com.baidu.ar.arplay.a.a.10
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer2, int i, int i2) {
                        com.baidu.ar.arplay.c.b.b(a.TAG, "onError: " + i);
                        c0074a.db.dK = "ERROR";
                        c0074a.db.dL = i;
                        a.a(c0074a);
                        a.this.b(new b() { // from class: com.baidu.ar.arplay.a.a.10.1
                            @Override // com.baidu.ar.arplay.a.a.b
                            public void a(Exception exc) {
                                a.this.c(1010, (HashMap<String, Object>) null);
                            }

                            @Override // com.baidu.ar.arplay.a.a.b
                            public void onResult(boolean z) {
                            }
                        }, c0074a.db.dJ);
                        return false;
                    }
                };
            }
            mediaPlayer.setOnErrorListener(onErrorListener);
            return c0074a;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static C0074a a(final C0074a c0074a, final String str, String str2, AssetFileDescriptor assetFileDescriptor, MediaPlayer.OnCompletionListener onCompletionListener, int i, String str3, final long j) {
        if ((!TextUtils.isEmpty(str2) || assetFileDescriptor != null) && c0074a != null) {
            c0074a.db.dG = com.baidu.ar.arplay.c.c.a((Object) str, 0L);
            c0074a.db.dJ = str;
            c0074a.db.dH = str3;
            MediaPlayer mediaPlayer = c0074a.da;
            if (onCompletionListener != null) {
                mediaPlayer.setOnCompletionListener(onCompletionListener);
            }
            try {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.seekTo(0);
                    mediaPlayer.stop();
                }
                mediaPlayer.setAudioStreamType(3);
                mediaPlayer.reset();
                if (!TextUtils.isEmpty(str2)) {
                    mediaPlayer.setDataSource(str2);
                } else if (assetFileDescriptor != null) {
                    mediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
                }
                mediaPlayer.prepareAsync();
                mediaPlayer.setLooping(false);
                com.baidu.ar.arplay.c.b.b(TAG, "wrapper.mMediaPlayer.prepareAsync()");
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.ar.arplay.a.a.11
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer2) {
                        com.baidu.ar.arplay.c.b.b(a.TAG, "mMediaPlayer onPrepared");
                        C0074a.this.db.dK = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                        C0074a.this.db.dM = DpStatConstants.KEY_PREPARED;
                        a.a(C0074a.this);
                        if (ARPEngine.getInstance().isPaused() || a.cO == null || a.cO.get(str) == null) {
                            return;
                        }
                        if (((Integer) a.cO.get(str)).intValue() == 3004 || ((Integer) a.cO.get(str)).intValue() == 3007) {
                            a.aB();
                            try {
                                if (C0074a.this.da.getDuration() >= 0) {
                                    if (C0074a.this.da.getDuration() <= j || j < 0) {
                                        C0074a.this.da.seekTo(0);
                                    } else {
                                        C0074a.this.da.seekTo((int) j);
                                    }
                                }
                                com.baidu.ar.arplay.c.b.b(a.TAG, "mMediaPlayer start");
                                C0074a.this.da.start();
                                C0074a.this.db.dM = "playing";
                            } catch (Exception e) {
                                a.a(C0074a.this.da);
                                e.printStackTrace();
                            }
                        }
                    }
                });
                c0074a.da.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.ar.arplay.a.a.12
                    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
                    public void onBufferingUpdate(MediaPlayer mediaPlayer2, int i2) {
                        C0074a.this.db.dK = "INFO";
                        C0074a.this.db.dO = i2;
                        a.a(C0074a.this);
                    }
                });
                c0074a.da.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.ar.arplay.a.a.13
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i2, int i3) {
                        C0074a.this.db.dK = "INFO";
                        switch (i2) {
                            case 701:
                                C0074a.this.db.dN = "buffer_start";
                                a.a(C0074a.this);
                                return false;
                            case CyberPlayerManager.MEDIA_INFO_BUFFERING_END /* 702 */:
                                C0074a.this.db.dN = "buffer_end";
                                a.a(C0074a.this);
                                return false;
                            default:
                                return false;
                        }
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            } catch (IllegalStateException e3) {
                e3.printStackTrace();
            } catch (SecurityException e4) {
                e4.printStackTrace();
            }
        }
        return c0074a;
    }

    public static void a(MediaPlayer mediaPlayer) {
        if (mediaPlayer != null) {
            try {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                mediaPlayer.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(C0074a c0074a) {
        if (c0074a == null) {
            return;
        }
        b(c0074a);
        a(c0074a.db);
        com.baidu.ar.arplay.a.a.b bVar = c0074a.db;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", Integer.valueOf((int) ARPMessageType.MSG_TYPE_AUDIO));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("action_id", String.valueOf(bVar.dG));
        hashMap2.put("platform", "android");
        hashMap2.put("type", bVar.dK);
        HashMap hashMap3 = new HashMap();
        hashMap3.put("error_code", Integer.valueOf(bVar.dL));
        hashMap3.put("buffer_status", bVar.dN);
        hashMap3.put("buffer_progress", Integer.valueOf(bVar.dO));
        hashMap3.put("play_status", bVar.dM);
        hashMap3.put("play_progress", Integer.valueOf((int) (bVar.dP * 100.0f)));
        hashMap2.put("data", hashMap3);
        hashMap.put("msg_data", hashMap2);
        ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
    }

    private void a(b bVar, String str, String str2, AssetFileDescriptor assetFileDescriptor, MediaPlayer.OnCompletionListener onCompletionListener, MediaPlayer.OnErrorListener onErrorListener, int i, String str3, long j) {
        try {
            C0074a a2 = a(str, onCompletionListener, onErrorListener);
            if (a2 != null) {
                a(a2, str, str2, assetFileDescriptor, onCompletionListener, i, str3, j);
            }
            if (bVar != null) {
                bVar.onResult(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            C0074a w = w(str);
            x(str);
            try {
                if (w.da != null) {
                    w.da.release();
                }
                try {
                    C0074a a3 = az().a(str, onCompletionListener, onErrorListener);
                    if (a3 != null) {
                        a(a3, str, str2, assetFileDescriptor, onCompletionListener, i, str3, j);
                    }
                    if (bVar != null) {
                        bVar.onResult(true);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    if (bVar != null) {
                        bVar.a(e2);
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                if (bVar != null) {
                    bVar.a(e3);
                }
            }
        }
    }

    private static void a(com.baidu.ar.arplay.a.a.b bVar) {
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
        ARPMessage.getInstance().sendMessage(1011, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void aB() {
        synchronized (a.class) {
            if (cP == null) {
                cP = new Timer();
                cQ = new TimerTask() { // from class: com.baidu.ar.arplay.a.a.14
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        C0074a c0074a;
                        if (a.cJ != null) {
                            for (Map.Entry entry : a.cJ.entrySet()) {
                                if (entry != null && (c0074a = (C0074a) entry.getValue()) != null && c0074a.db != null && c0074a.db.dM == "playing") {
                                    a.a((C0074a) entry.getValue());
                                }
                            }
                        }
                    }
                };
                cP.scheduleAtFixedRate(cQ, 0L, 200L);
            }
        }
    }

    public static synchronized a az() {
        a aVar;
        synchronized (a.class) {
            if (cG == null) {
                cG = new a();
            }
            aVar = cG;
        }
        return aVar;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x004a -> B:27:0x0029). Please submit an issue!!! */
    private static void b(C0074a c0074a) {
        if (c0074a == null || c0074a.da == null) {
            return;
        }
        com.baidu.ar.arplay.a.a.b bVar = c0074a.db;
        if (bVar.dM == "playing" || bVar.dM == "paused") {
            try {
                bVar.dI = c0074a.da.getDuration();
                if (bVar.dI <= 0) {
                    bVar.dP = 0.0f;
                } else {
                    bVar.dP = (c0074a.da.getCurrentPosition() * 1.0f) / bVar.dI;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (bVar.dM == "finished") {
            bVar.dP = 1.0f;
        }
        if (bVar.dP > 1.0f) {
            bVar.dP = 1.0f;
        }
        if (bVar.dP < 0.0f) {
            bVar.dP = 0.0f;
        }
    }

    private void b(b bVar, String str, String str2, MediaPlayer.OnCompletionListener onCompletionListener, int i, String str3, long j) {
        C0074a w = w(str);
        x(str);
        if (w != null) {
            try {
                if (w.da != null) {
                    w.da.release();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (bVar != null) {
                    bVar.a(e);
                    return;
                }
                return;
            }
        }
        try {
            C0074a a2 = a(str, onCompletionListener, null);
            if (a2 != null) {
                a(a2, str, str2, null, onCompletionListener, i, str3, j);
            }
            if (bVar != null) {
                bVar.onResult(true);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (bVar != null) {
                bVar.a(e2);
            }
        }
    }

    public C0074a a(String str, MediaPlayer.OnCompletionListener onCompletionListener, MediaPlayer.OnErrorListener onErrorListener) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (cJ == null || !cJ.containsKey(str)) {
            C0074a a2 = a(onCompletionListener, onErrorListener);
            if (a2 != null) {
                if (cJ == null) {
                    cJ = new ConcurrentHashMap<>();
                }
                cJ.put(str, a2);
                return a2;
            }
            return null;
        }
        return cJ.get(str);
    }

    public void a(Message message) {
        Object[] objArr = (Object[]) message.obj;
        String str = (String) objArr[1];
        long longValue = ((Long) objArr[6]).longValue();
        cO.put(str, Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_RTMP_IO_FAIL));
        a((b) objArr[0], str, (String) objArr[2], null, (MediaPlayer.OnCompletionListener) objArr[3], null, ((Integer) objArr[4]).intValue(), (String) objArr[5], longValue);
    }

    public void a(b bVar, String str) {
        Message obtainMessage = this.mHandler.obtainMessage(3006);
        obtainMessage.obj = new Object[]{new c(bVar), str};
        obtainMessage.sendToTarget();
    }

    public void a(b bVar, String str, String str2, MediaPlayer.OnCompletionListener onCompletionListener, int i) {
        Message obtainMessage = this.mHandler.obtainMessage(3007);
        obtainMessage.obj = new Object[]{new c(bVar), str, str2, onCompletionListener, Integer.valueOf(i)};
        obtainMessage.sendToTarget();
    }

    public void a(b bVar, String str, String str2, MediaPlayer.OnCompletionListener onCompletionListener, int i, String str3, long j) {
        Message obtainMessage = this.mHandler.obtainMessage(CyberPlayerManager.MEDIA_INFO_RTMP_IO_FAIL);
        obtainMessage.obj = new Object[]{new c(bVar), str, str2, onCompletionListener, Integer.valueOf(i), str3, Long.valueOf(j)};
        obtainMessage.sendToTarget();
    }

    public void a(final com.baidu.ar.arplay.a.a.a aVar, final HashMap<String, Object> hashMap) {
        if (aVar.aM() > 1) {
            this.cN.put(aVar.getId(), Integer.valueOf(aVar.aM()));
        }
        c(1002, hashMap);
        a(new b() { // from class: com.baidu.ar.arplay.a.a.15
            @Override // com.baidu.ar.arplay.a.a.b
            public void a(Exception exc) {
                a.this.c(1010, hashMap);
            }

            @Override // com.baidu.ar.arplay.a.a.b
            public void onResult(boolean z) {
            }
        }, aVar.getId(), aVar.getUrl(), new MediaPlayer.OnCompletionListener() { // from class: com.baidu.ar.arplay.a.a.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                com.baidu.ar.arplay.c.b.b(a.TAG, "mMediaPlayer onCompletion");
                if (a.this.cN == null) {
                    return;
                }
                C0074a w = a.this.w(aVar.getId());
                if (w == null || w.db.dM != "paused") {
                    if (w != null) {
                        w.db.dK = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                        w.db.dM = "finished";
                        a.a(w);
                        if (aVar.aP()) {
                            com.baidu.ar.arplay.c.b.b(a.TAG, "mMediaPlayer onCompletion  isLoopForever open！");
                            a.this.a(aVar, hashMap);
                            return;
                        }
                    }
                    if (a.this.cN.size() <= 0) {
                        a.this.c(1009, hashMap);
                        return;
                    }
                    int a2 = a.a(a.this.cN, aVar.getId());
                    if (a2 <= 1) {
                        a.this.c(1009, hashMap);
                        return;
                    }
                    com.baidu.ar.arplay.c.b.b(a.TAG, "mMediaPlayer onCompletion  count open ！");
                    a.this.a(aVar, hashMap);
                    int i = a2 - 1;
                    a.this.cN.put(aVar.getId(), Integer.valueOf(i));
                    aVar.g(i);
                }
            }
        }, aVar.aM(), aVar.aO(), aVar.aN());
    }

    public void aA() {
        this.cS = null;
        if (cP != null) {
            cP.cancel();
            cP.purge();
            cP = null;
            cQ.cancel();
            cQ = null;
        }
        if (cO != null) {
            cO.clear();
        }
        if (cJ != null) {
            try {
                for (C0074a c0074a : cJ.values()) {
                    c0074a.db.dK = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                    c0074a.db.dM = "unstarted";
                    a(c0074a.da);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (cJ != null) {
                cJ.clear();
            }
        }
        if (this.cN != null) {
            this.cN.clear();
        }
    }

    public void b(Message message) {
        Object[] objArr = (Object[]) message.obj;
        b bVar = (b) objArr[0];
        String str = (String) objArr[1];
        cO.put(str, 3005);
        C0074a w = w(str);
        if (w != null) {
            try {
                w.db.dK = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                w.db.dM = "unstarted";
                a(w);
                com.baidu.ar.arplay.c.b.b(TAG, "mMediaPlayer stopPlay");
                a(w.da);
                w.da = null;
                x(str);
            } catch (Exception e) {
                e.printStackTrace();
                if (bVar != null) {
                    bVar.a(e);
                    return;
                }
                return;
            }
        }
        if (bVar != null) {
            bVar.onResult(true);
        }
    }

    public void b(b bVar, String str) {
        Message obtainMessage = this.mHandler.obtainMessage(3005);
        obtainMessage.obj = new Object[]{new c(bVar), str};
        obtainMessage.sendToTarget();
    }

    public void b(com.baidu.ar.arplay.a.a.a aVar, final HashMap<String, Object> hashMap) {
        c(1004, hashMap);
        a(new b() { // from class: com.baidu.ar.arplay.a.a.3
            @Override // com.baidu.ar.arplay.a.a.b
            public void a(Exception exc) {
                a.this.c(1010, hashMap);
            }

            @Override // com.baidu.ar.arplay.a.a.b
            public void onResult(boolean z) {
            }
        }, aVar.getId());
    }

    public void c(int i, HashMap<String, Object> hashMap) {
        ARPMessage.getInstance().sendMessage(i, hashMap);
    }

    public void c(Message message) {
        Object[] objArr = (Object[]) message.obj;
        b bVar = (b) objArr[0];
        String str = (String) objArr[1];
        cO.put(str, 3006);
        try {
            C0074a w = w(str);
            if (w.da != null && w.db.dM != "unstarted" && w.da.isPlaying()) {
                w.db.dK = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                w.db.dM = "paused";
                a(w);
                com.baidu.ar.arplay.c.b.b(TAG, "mMediaPlayer pause");
                w.da.pause();
            }
            if (bVar != null) {
                bVar.onResult(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (bVar != null) {
                bVar.a(e);
            }
        }
    }

    public void c(b bVar, String str) {
        Message obtainMessage = this.mHandler.obtainMessage(3009);
        obtainMessage.obj = new Object[]{new c(bVar), str};
        obtainMessage.sendToTarget();
    }

    public void c(final com.baidu.ar.arplay.a.a.a aVar, final HashMap<String, Object> hashMap) {
        c(1006, hashMap);
        a(new b() { // from class: com.baidu.ar.arplay.a.a.4
            @Override // com.baidu.ar.arplay.a.a.b
            public void a(Exception exc) {
                a.this.c(1010, hashMap);
            }

            @Override // com.baidu.ar.arplay.a.a.b
            public void onResult(boolean z) {
            }
        }, aVar.getId(), aVar.getUrl(), new MediaPlayer.OnCompletionListener() { // from class: com.baidu.ar.arplay.a.a.5
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (a.this.cN == null) {
                    return;
                }
                C0074a w = a.this.w(aVar.getId());
                if (w != null) {
                    w.db.dK = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                    w.db.dM = "finished";
                    a.a(w);
                    if (aVar.aP()) {
                        a.this.a(aVar, hashMap);
                        return;
                    }
                }
                if (a.this.cN.size() <= 0) {
                    a.this.c(1009, hashMap);
                    return;
                }
                int a2 = a.a(a.this.cN, aVar.getId());
                if (a2 <= 1) {
                    a.this.c(1009, hashMap);
                    return;
                }
                a.this.a(aVar, hashMap);
                int i = a2 - 1;
                a.this.cN.put(aVar.getId(), Integer.valueOf(i));
                aVar.g(i);
            }
        }, aVar.aM());
    }

    public void d(Message message) {
        Object[] objArr = (Object[]) message.obj;
        if (objArr.length < 2) {
            return;
        }
        b bVar = (b) objArr[0];
        String str = (String) objArr[1];
        cO.put(str, 3009);
        try {
            C0074a w = w(str);
            if (w == null || w.db.dM == "unstarted") {
                return;
            }
            w.da.seekTo(0);
        } catch (Exception e) {
            e.printStackTrace();
            if (bVar != null) {
                bVar.a(e);
            }
        }
    }

    public void d(com.baidu.ar.arplay.a.a.a aVar, final HashMap<String, Object> hashMap) {
        c(1008, hashMap);
        b(new b() { // from class: com.baidu.ar.arplay.a.a.6
            @Override // com.baidu.ar.arplay.a.a.b
            public void a(Exception exc) {
                a.this.c(1010, hashMap);
            }

            @Override // com.baidu.ar.arplay.a.a.b
            public void onResult(boolean z) {
            }
        }, aVar.getId());
    }

    public void e(Message message) {
        if (ARPEngine.getInstance().isPaused()) {
            return;
        }
        Object[] objArr = (Object[]) message.obj;
        if (objArr.length >= 5) {
            b bVar = (b) objArr[0];
            String str = (String) objArr[1];
            String str2 = (String) objArr[2];
            MediaPlayer.OnCompletionListener onCompletionListener = (MediaPlayer.OnCompletionListener) objArr[3];
            int intValue = ((Integer) objArr[4]).intValue();
            String str3 = null;
            long j = 0;
            if (objArr.length > 6) {
                j = ((Long) objArr[6]).longValue();
                str3 = (String) objArr[5];
            }
            cO.put(str, 3007);
            try {
                C0074a w = w(str);
                if (w != null && !w.da.isPlaying() && w.db.dM != "unstarted") {
                    w.db.dK = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                    w.db.dM = "playing";
                    a(w);
                    com.baidu.ar.arplay.c.b.b(TAG, "MediaPlayer resume");
                    w.da.seekTo(w.da.getCurrentPosition());
                    w.da.start();
                }
                if (bVar != null) {
                    bVar.onResult(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
                b(bVar, str, str2, onCompletionListener, intValue, str3, j);
            }
        }
    }

    public void e(com.baidu.ar.arplay.a.a.a aVar, final HashMap<String, Object> hashMap) {
        c(1013, hashMap);
        c(new b() { // from class: com.baidu.ar.arplay.a.a.7
            @Override // com.baidu.ar.arplay.a.a.b
            public void a(Exception exc) {
                a.this.c(1010, hashMap);
            }

            @Override // com.baidu.ar.arplay.a.a.b
            public void onResult(boolean z) {
            }
        }, aVar.getId());
    }

    public void f(Message message) {
        b bVar = (b) ((Object[]) message.obj)[0];
        this.cI = false;
        this.cH = 0;
        if (cJ != null) {
            try {
                for (C0074a c0074a : cJ.values()) {
                    if (c0074a != null) {
                        c0074a.da.release();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            cJ.clear();
        }
        if (bVar != null) {
            bVar.onResult(true);
        }
    }

    public C0074a w(String str) {
        if (cJ == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return cJ.get(str);
    }

    public void x(String str) {
        if (cJ == null || TextUtils.isEmpty(str) || !cJ.containsKey(str)) {
            return;
        }
        cJ.remove(str);
    }
}
