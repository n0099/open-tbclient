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
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.down.manage.DownloadConstants;
import com.tencent.connect.common.Constants;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public final class a {
    public static a cL;
    public static ConcurrentHashMap<String, C0047a> cO;
    public static HandlerThread cP;
    public static b cR;
    public static Map<String, Integer> cT;
    public static Timer cU;
    public static TimerTask cV;
    public Map<String, Integer> cS;
    public Handler mHandler;
    public static Handler cQ = new Handler(Looper.getMainLooper());
    public static final String TAG = a.class.getSimpleName();
    public static Runnable cW = new Runnable() { // from class: com.baidu.ar.arplay.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.cP != null) {
                a.cP.quit();
                HandlerThread unused = a.cP = null;
            }
        }
    };
    public int cM = 0;
    public boolean cN = false;
    public Handler.Callback cX = new Handler.Callback() { // from class: com.baidu.ar.arplay.a.a.8
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (ARPEngine.getInstance().isEngineCanAccess()) {
                switch (message.what) {
                    case 3004:
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
                return false;
            }
            return false;
        }
    };

    /* renamed from: com.baidu.ar.arplay.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0047a {
        public MediaPlayer df;
        public com.baidu.ar.arplay.a.a.b dg = new com.baidu.ar.arplay.a.a.b();
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(Exception exc);

        void onResult(boolean z);
    }

    /* loaded from: classes.dex */
    public class c implements b {
        public c(b bVar) {
            b unused = a.cR = bVar;
        }

        @Override // com.baidu.ar.arplay.a.a.b
        public void a(final Exception exc) {
            if (a.cR == null) {
                return;
            }
            a.cQ.post(new Runnable() { // from class: com.baidu.ar.arplay.a.a.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.cR != null) {
                        a.cR.a(exc);
                    }
                }
            });
        }

        @Override // com.baidu.ar.arplay.a.a.b
        public void onResult(final boolean z) {
            if (a.cR == null) {
                return;
            }
            a.cQ.post(new Runnable() { // from class: com.baidu.ar.arplay.a.a.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.cR != null) {
                        a.cR.onResult(z);
                    }
                }
            });
        }
    }

    public a() {
        synchronized (a.class) {
            if (cP == null) {
                HandlerThread handlerThread = new HandlerThread("MediaPlayerThread");
                cP = handlerThread;
                handlerThread.start();
            } else {
                cQ.removeCallbacks(cW);
            }
        }
        this.mHandler = new Handler(cP.getLooper(), this.cX);
        this.cS = new Hashtable();
        cT = new Hashtable();
    }

    public static int a(Map<String, Integer> map, String str) {
        Integer num = map.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private C0047a a(MediaPlayer.OnCompletionListener onCompletionListener, MediaPlayer.OnErrorListener onErrorListener) {
        com.baidu.ar.arplay.c.b.b(TAG, "initMediaPlayerInMsg start()");
        try {
            final C0047a c0047a = new C0047a();
            MediaPlayer mediaPlayer = new MediaPlayer();
            c0047a.df = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
            if (onCompletionListener == null) {
                onCompletionListener = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.ar.arplay.a.a.9
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer2) {
                        com.baidu.ar.arplay.c.b.b(a.TAG, "initMediaPlayerInMsg onCompletion()");
                        if (mediaPlayer2 != null) {
                            mediaPlayer2.release();
                        }
                    }
                };
            }
            mediaPlayer.setOnCompletionListener(onCompletionListener);
            if (onErrorListener == null) {
                onErrorListener = new MediaPlayer.OnErrorListener() { // from class: com.baidu.ar.arplay.a.a.10
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer2, int i, int i2) {
                        String str = a.TAG;
                        com.baidu.ar.arplay.c.b.b(str, "onError: " + i);
                        C0047a c0047a2 = c0047a;
                        com.baidu.ar.arplay.a.a.b bVar = c0047a2.dg;
                        bVar.dX = "ERROR";
                        bVar.dY = i;
                        a.a(c0047a2);
                        a.this.b(new b() { // from class: com.baidu.ar.arplay.a.a.10.1
                            @Override // com.baidu.ar.arplay.a.a.b
                            public void a(Exception exc) {
                                a.this.c(1010, (HashMap<String, Object>) null);
                            }

                            @Override // com.baidu.ar.arplay.a.a.b
                            public void onResult(boolean z) {
                            }
                        }, c0047a.dg.dW);
                        return false;
                    }
                };
            }
            mediaPlayer.setOnErrorListener(onErrorListener);
            return c0047a;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static C0047a a(final C0047a c0047a, final String str, String str2, AssetFileDescriptor assetFileDescriptor, MediaPlayer.OnCompletionListener onCompletionListener, int i, String str3, final long j) {
        if ((TextUtils.isEmpty(str2) && assetFileDescriptor == null) || c0047a == null) {
            return c0047a;
        }
        c0047a.dg.dT = com.baidu.ar.arplay.c.c.a((Object) str, 0L);
        com.baidu.ar.arplay.a.a.b bVar = c0047a.dg;
        bVar.dW = str;
        bVar.dU = str3;
        MediaPlayer mediaPlayer = c0047a.df;
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
                    C0047a c0047a2 = C0047a.this;
                    com.baidu.ar.arplay.a.a.b bVar2 = c0047a2.dg;
                    bVar2.dX = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                    bVar2.dZ = DpStatConstants.KEY_PREPARED;
                    a.a(c0047a2);
                    if (ARPEngine.getInstance().isPaused() || a.cT == null || a.cT.get(str) == null) {
                        return;
                    }
                    if (((Integer) a.cT.get(str)).intValue() == 3004 || ((Integer) a.cT.get(str)).intValue() == 3007) {
                        a.aC();
                        try {
                            if (C0047a.this.df.getDuration() >= 0) {
                                if (C0047a.this.df.getDuration() > j && j >= 0) {
                                    C0047a.this.df.seekTo((int) j);
                                }
                                C0047a.this.df.seekTo(0);
                            }
                            com.baidu.ar.arplay.c.b.b(a.TAG, "mMediaPlayer start");
                            C0047a.this.df.start();
                            C0047a.this.dg.dZ = "playing";
                        } catch (Exception e) {
                            a.a(C0047a.this.df);
                            e.printStackTrace();
                        }
                    }
                }
            });
            c0047a.df.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.ar.arplay.a.a.12
                @Override // android.media.MediaPlayer.OnBufferingUpdateListener
                public void onBufferingUpdate(MediaPlayer mediaPlayer2, int i2) {
                    C0047a c0047a2 = C0047a.this;
                    com.baidu.ar.arplay.a.a.b bVar2 = c0047a2.dg;
                    bVar2.dX = "INFO";
                    bVar2.eb = i2;
                    a.a(c0047a2);
                }
            });
            c0047a.df.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.ar.arplay.a.a.13
                @Override // android.media.MediaPlayer.OnInfoListener
                public boolean onInfo(MediaPlayer mediaPlayer2, int i2, int i3) {
                    String str4;
                    C0047a c0047a2 = C0047a.this;
                    com.baidu.ar.arplay.a.a.b bVar2 = c0047a2.dg;
                    bVar2.dX = "INFO";
                    if (i2 == 701) {
                        str4 = "buffer_start";
                    } else if (i2 != 702) {
                        return false;
                    } else {
                        str4 = "buffer_end";
                    }
                    bVar2.ea = str4;
                    a.a(c0047a2);
                    return false;
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
        return c0047a;
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

    public static void a(C0047a c0047a) {
        if (c0047a == null) {
            return;
        }
        b(c0047a);
        a(c0047a.dg);
        com.baidu.ar.arplay.a.a.b bVar = c0047a.dg;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", Integer.valueOf((int) ARPMessageType.MSG_TYPE_AUDIO));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("action_id", String.valueOf(bVar.dT));
        hashMap2.put(Constants.PARAM_PLATFORM, "android");
        hashMap2.put("type", bVar.dX);
        HashMap hashMap3 = new HashMap();
        hashMap3.put("error_code", Integer.valueOf(bVar.dY));
        hashMap3.put("buffer_status", bVar.ea);
        hashMap3.put("buffer_progress", Integer.valueOf(bVar.eb));
        hashMap3.put("play_status", bVar.dZ);
        hashMap3.put("play_progress", Integer.valueOf((int) (bVar.ec * 100.0f)));
        hashMap2.put("data", hashMap3);
        hashMap.put("msg_data", hashMap2);
        ARPMessage.getInstance().sendMessage(1902, hashMap);
    }

    private void a(b bVar, String str, String str2, AssetFileDescriptor assetFileDescriptor, MediaPlayer.OnCompletionListener onCompletionListener, MediaPlayer.OnErrorListener onErrorListener, int i, String str3, long j) {
        try {
            C0047a a = a(str, onCompletionListener, onErrorListener);
            if (a != null) {
                a(a, str, str2, assetFileDescriptor, onCompletionListener, i, str3, j);
            }
            if (bVar != null) {
                bVar.onResult(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            C0047a z = z(str);
            A(str);
            try {
                if (z.df != null) {
                    z.df.release();
                }
                try {
                    C0047a a2 = aA().a(str, onCompletionListener, onErrorListener);
                    if (a2 != null) {
                        a(a2, str, str2, assetFileDescriptor, onCompletionListener, i, str3, j);
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

    public static void a(com.baidu.ar.arplay.a.a.b bVar) {
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
        hashMap2.put("play_progress", String.valueOf((int) (bVar.ec * 100.0f)));
        hashMap.put("msg_data", hashMap2);
        ARPMessage.getInstance().sendMessage(1011, hashMap);
    }

    public static synchronized a aA() {
        a aVar;
        synchronized (a.class) {
            if (cL == null) {
                cL = new a();
            }
            aVar = cL;
        }
        return aVar;
    }

    public static synchronized void aC() {
        synchronized (a.class) {
            if (cU == null) {
                cU = new Timer();
                TimerTask timerTask = new TimerTask() { // from class: com.baidu.ar.arplay.a.a.14
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        C0047a c0047a;
                        com.baidu.ar.arplay.a.a.b bVar;
                        if (a.cO != null) {
                            for (Map.Entry entry : a.cO.entrySet()) {
                                if (entry != null && (c0047a = (C0047a) entry.getValue()) != null && (bVar = c0047a.dg) != null && bVar.dZ == "playing") {
                                    a.a((C0047a) entry.getValue());
                                }
                            }
                        }
                    }
                };
                cV = timerTask;
                cU.scheduleAtFixedRate(timerTask, 0L, 200L);
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x003c -> B:28:0x003f). Please submit an issue!!! */
    public static void b(C0047a c0047a) {
        if (c0047a == null || c0047a.df == null) {
            return;
        }
        com.baidu.ar.arplay.a.a.b bVar = c0047a.dg;
        String str = bVar.dZ;
        if (str == "playing" || str == "paused") {
            try {
                int duration = c0047a.df.getDuration();
                bVar.dV = duration;
                if (duration <= 0) {
                    bVar.ec = 0.0f;
                } else {
                    bVar.ec = (c0047a.df.getCurrentPosition() * 1.0f) / bVar.dV;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (str == "finished") {
            bVar.ec = 1.0f;
        }
        if (bVar.ec > 1.0f) {
            bVar.ec = 1.0f;
        }
        if (bVar.ec < 0.0f) {
            bVar.ec = 0.0f;
        }
    }

    private void b(b bVar, String str, String str2, MediaPlayer.OnCompletionListener onCompletionListener, int i, String str3, long j) {
        C0047a z = z(str);
        A(str);
        if (z != null) {
            try {
                if (z.df != null) {
                    z.df.release();
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
            C0047a a = a(str, onCompletionListener, null);
            if (a != null) {
                a(a, str, str2, null, onCompletionListener, i, str3, j);
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

    public void A(String str) {
        if (cO == null || TextUtils.isEmpty(str) || !cO.containsKey(str)) {
            return;
        }
        cO.remove(str);
    }

    public C0047a a(String str, MediaPlayer.OnCompletionListener onCompletionListener, MediaPlayer.OnErrorListener onErrorListener) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ConcurrentHashMap<String, C0047a> concurrentHashMap = cO;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str)) {
            C0047a a = a(onCompletionListener, onErrorListener);
            if (a == null) {
                return null;
            }
            if (cO == null) {
                cO = new ConcurrentHashMap<>();
            }
            cO.put(str, a);
            return a;
        }
        return cO.get(str);
    }

    public void a(Message message) {
        Object[] objArr = (Object[]) message.obj;
        b bVar = (b) objArr[0];
        String str = (String) objArr[1];
        long longValue = ((Long) objArr[6]).longValue();
        cT.put(str, 3004);
        a(bVar, str, (String) objArr[2], null, (MediaPlayer.OnCompletionListener) objArr[3], null, ((Integer) objArr[4]).intValue(), (String) objArr[5], longValue);
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
        Message obtainMessage = this.mHandler.obtainMessage(3004);
        obtainMessage.obj = new Object[]{new c(bVar), str, str2, onCompletionListener, Integer.valueOf(i), str3, Long.valueOf(j)};
        obtainMessage.sendToTarget();
    }

    public void a(final com.baidu.ar.arplay.a.a.a aVar, final HashMap<String, Object> hashMap) {
        if (aVar.aN() > 1) {
            this.cS.put(aVar.getId(), Integer.valueOf(aVar.aN()));
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
                int a;
                com.baidu.ar.arplay.c.b.b(a.TAG, "openAudio mMediaPlayer onCompletion");
                if (a.this.cS == null) {
                    return;
                }
                C0047a z = a.this.z(aVar.getId());
                if (z == null || z.dg.dZ != "paused") {
                    if (z != null) {
                        com.baidu.ar.arplay.a.a.b bVar = z.dg;
                        bVar.dX = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                        bVar.dZ = "finished";
                        a.a(z);
                        if (aVar.aQ()) {
                            com.baidu.ar.arplay.c.b.b(a.TAG, "openAudio mMediaPlayer onCompletion  isLoopForever open！");
                            a.this.a(aVar, hashMap);
                            return;
                        }
                    }
                    if (a.this.cS.size() <= 0 || (a = a.a(a.this.cS, aVar.getId())) <= 1) {
                        a.this.c(1009, hashMap);
                        mediaPlayer.release();
                        return;
                    }
                    com.baidu.ar.arplay.c.b.b(a.TAG, "openAudio mMediaPlayer onCompletion  count open ！");
                    a.this.a(aVar, hashMap);
                    int i = a - 1;
                    a.this.cS.put(aVar.getId(), Integer.valueOf(i));
                    aVar.i(i);
                }
            }
        }, aVar.aN(), aVar.aP(), aVar.aO());
    }

    public void aB() {
        this.cX = null;
        Timer timer = cU;
        if (timer != null) {
            timer.cancel();
            cU.purge();
            cU = null;
            cV.cancel();
            cV = null;
        }
        Map<String, Integer> map = cT;
        if (map != null) {
            map.clear();
        }
        ConcurrentHashMap<String, C0047a> concurrentHashMap = cO;
        if (concurrentHashMap != null) {
            try {
                for (C0047a c0047a : concurrentHashMap.values()) {
                    c0047a.dg.dX = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                    c0047a.dg.dZ = "unstarted";
                    a(c0047a.df);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            ConcurrentHashMap<String, C0047a> concurrentHashMap2 = cO;
            if (concurrentHashMap2 != null) {
                concurrentHashMap2.clear();
            }
        }
        Map<String, Integer> map2 = this.cS;
        if (map2 != null) {
            map2.clear();
        }
    }

    public void b(Message message) {
        Object[] objArr = (Object[]) message.obj;
        b bVar = (b) objArr[0];
        String str = (String) objArr[1];
        cT.put(str, 3005);
        C0047a z = z(str);
        if (z != null) {
            try {
                z.dg.dX = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                z.dg.dZ = "unstarted";
                a(z);
                com.baidu.ar.arplay.c.b.b(TAG, "mMediaPlayer stopPlay");
                a(z.df);
                z.df = null;
                A(str);
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
        cT.put(str, 3006);
        try {
            C0047a z = z(str);
            if (z.df != null && z.dg.dZ != "unstarted" && z.df.isPlaying()) {
                z.dg.dX = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                z.dg.dZ = "paused";
                a(z);
                com.baidu.ar.arplay.c.b.b(TAG, "mMediaPlayer pause");
                z.df.pause();
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
                int a;
                if (a.this.cS == null) {
                    return;
                }
                C0047a z = a.this.z(aVar.getId());
                if (z != null) {
                    com.baidu.ar.arplay.a.a.b bVar = z.dg;
                    bVar.dX = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                    bVar.dZ = "finished";
                    a.a(z);
                    if (aVar.aQ()) {
                        a.this.a(aVar, hashMap);
                        return;
                    }
                }
                if (a.this.cS.size() <= 0 || (a = a.a(a.this.cS, aVar.getId())) <= 1) {
                    a.this.c(1009, hashMap);
                    return;
                }
                a.this.a(aVar, hashMap);
                int i = a - 1;
                a.this.cS.put(aVar.getId(), Integer.valueOf(i));
                aVar.i(i);
            }
        }, aVar.aN());
    }

    public void d(Message message) {
        Object[] objArr = (Object[]) message.obj;
        if (objArr.length < 2) {
            return;
        }
        b bVar = (b) objArr[0];
        String str = (String) objArr[1];
        cT.put(str, 3009);
        try {
            C0047a z = z(str);
            if (z == null || z.dg.dZ == "unstarted") {
                return;
            }
            z.df.seekTo(0);
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
        long j;
        String str;
        if (ARPEngine.getInstance().isPaused()) {
            return;
        }
        Object[] objArr = (Object[]) message.obj;
        if (objArr.length < 5) {
            return;
        }
        b bVar = (b) objArr[0];
        String str2 = (String) objArr[1];
        String str3 = (String) objArr[2];
        MediaPlayer.OnCompletionListener onCompletionListener = (MediaPlayer.OnCompletionListener) objArr[3];
        int intValue = ((Integer) objArr[4]).intValue();
        if (objArr.length > 6) {
            j = ((Long) objArr[6]).longValue();
            str = (String) objArr[5];
        } else {
            j = 0;
            str = null;
        }
        cT.put(str2, 3007);
        try {
            C0047a z = z(str2);
            if (z != null && !z.df.isPlaying() && z.dg.dZ != "unstarted") {
                z.dg.dX = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                z.dg.dZ = "playing";
                a(z);
                com.baidu.ar.arplay.c.b.b(TAG, "MediaPlayer resume");
                z.df.seekTo(z.df.getCurrentPosition());
                z.df.start();
            }
            if (bVar != null) {
                bVar.onResult(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            b(bVar, str2, str3, onCompletionListener, intValue, str, j);
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
        this.cN = false;
        this.cM = 0;
        ConcurrentHashMap<String, C0047a> concurrentHashMap = cO;
        if (concurrentHashMap != null) {
            try {
                for (C0047a c0047a : concurrentHashMap.values()) {
                    if (c0047a != null) {
                        c0047a.df.release();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            cO.clear();
        }
        if (bVar != null) {
            bVar.onResult(true);
        }
    }

    public C0047a z(String str) {
        if (cO == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return cO.get(str);
    }
}
