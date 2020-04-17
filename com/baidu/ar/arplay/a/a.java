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
/* loaded from: classes3.dex */
public final class a {
    private static a cR;
    private static ConcurrentHashMap<String, C0051a> cU;
    private static HandlerThread cV;
    private static b cX;
    private static Map<String, Integer> cZ;
    private static Timer da;
    private static TimerTask db;
    private Map<String, Integer> cY;
    private Handler mHandler;
    private static Handler cW = new Handler(Looper.getMainLooper());
    private static Runnable dc = new Runnable() { // from class: com.baidu.ar.arplay.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.cV != null) {
                a.cV.quit();
                HandlerThread unused = a.cV = null;
            }
        }
    };
    private int cS = 0;
    private boolean cT = false;
    private Handler.Callback dd = new Handler.Callback() { // from class: com.baidu.ar.arplay.a.a.8
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
    /* loaded from: classes3.dex */
    public static class C0051a {
        MediaPlayer dl;
        com.baidu.ar.arplay.a.a.b dm = new com.baidu.ar.arplay.a.a.b();

        C0051a() {
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(Exception exc);

        void f(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements b {
        c(b bVar) {
            b unused = a.cX = bVar;
        }

        @Override // com.baidu.ar.arplay.a.a.b
        public void a(final Exception exc) {
            if (a.cX == null) {
                return;
            }
            a.cW.post(new Runnable() { // from class: com.baidu.ar.arplay.a.a.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.cX != null) {
                        a.cX.a(exc);
                    }
                }
            });
        }

        @Override // com.baidu.ar.arplay.a.a.b
        public void f(final boolean z) {
            if (a.cX == null) {
                return;
            }
            a.cW.post(new Runnable() { // from class: com.baidu.ar.arplay.a.a.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.cX != null) {
                        a.cX.f(z);
                    }
                }
            });
        }
    }

    private a() {
        synchronized (a.class) {
            if (cV == null) {
                cV = new HandlerThread("MediaPlayerThread");
                cV.start();
            } else {
                cW.removeCallbacks(dc);
            }
        }
        this.mHandler = new Handler(cV.getLooper(), this.dd);
        this.cY = new Hashtable();
        cZ = new Hashtable();
    }

    public static int a(Map<String, Integer> map, String str) {
        Integer num = map.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private C0051a a(MediaPlayer.OnCompletionListener onCompletionListener, MediaPlayer.OnErrorListener onErrorListener) {
        try {
            final C0051a c0051a = new C0051a();
            MediaPlayer mediaPlayer = new MediaPlayer();
            c0051a.dl = mediaPlayer;
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
                        c0051a.dm.dW = "ERROR";
                        c0051a.dm.dX = i;
                        a.a(c0051a);
                        a.this.b(new b() { // from class: com.baidu.ar.arplay.a.a.10.1
                            @Override // com.baidu.ar.arplay.a.a.b
                            public void a(Exception exc) {
                                a.this.c(1010, (HashMap<String, Object>) null);
                            }

                            @Override // com.baidu.ar.arplay.a.a.b
                            public void f(boolean z) {
                            }
                        }, c0051a.dm.dV);
                        return false;
                    }
                };
            }
            mediaPlayer.setOnErrorListener(onErrorListener);
            return c0051a;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static C0051a a(final C0051a c0051a, final String str, String str2, AssetFileDescriptor assetFileDescriptor, MediaPlayer.OnCompletionListener onCompletionListener, int i, String str3, final long j) {
        if ((!TextUtils.isEmpty(str2) || assetFileDescriptor != null) && c0051a != null) {
            c0051a.dm.dS = com.baidu.ar.arplay.c.c.a((Object) str, 0L);
            c0051a.dm.dV = str;
            c0051a.dm.dT = str3;
            MediaPlayer mediaPlayer = c0051a.dl;
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
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.ar.arplay.a.a.11
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer2) {
                        C0051a.this.dm.dW = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                        C0051a.this.dm.dY = DpStatConstants.KEY_PREPARED;
                        a.a(C0051a.this);
                        if (ARPEngine.getInstance().isPaused() || a.cZ == null || a.cZ.get(str) == null) {
                            return;
                        }
                        if (((Integer) a.cZ.get(str)).intValue() == 3004 || ((Integer) a.cZ.get(str)).intValue() == 3007) {
                            a.ap();
                            try {
                                if (C0051a.this.dl.getDuration() >= 0) {
                                    if (C0051a.this.dl.getDuration() <= j || j < 0) {
                                        C0051a.this.dl.seekTo(0);
                                    } else {
                                        C0051a.this.dl.seekTo((int) j);
                                    }
                                }
                                C0051a.this.dl.start();
                                C0051a.this.dm.dY = "playing";
                            } catch (Exception e) {
                                a.a(C0051a.this.dl);
                                e.printStackTrace();
                            }
                        }
                    }
                });
                c0051a.dl.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.ar.arplay.a.a.12
                    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
                    public void onBufferingUpdate(MediaPlayer mediaPlayer2, int i2) {
                        C0051a.this.dm.dW = "INFO";
                        C0051a.this.dm.ea = i2;
                        a.a(C0051a.this);
                    }
                });
                c0051a.dl.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.ar.arplay.a.a.13
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i2, int i3) {
                        C0051a.this.dm.dW = "INFO";
                        switch (i2) {
                            case 701:
                                C0051a.this.dm.dZ = "buffer_start";
                                a.a(C0051a.this);
                                return false;
                            case CyberPlayerManager.MEDIA_INFO_BUFFERING_END /* 702 */:
                                C0051a.this.dm.dZ = "buffer_end";
                                a.a(C0051a.this);
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
        return c0051a;
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
    public static void a(C0051a c0051a) {
        if (c0051a == null) {
            return;
        }
        b(c0051a);
        a(c0051a.dm);
        com.baidu.ar.arplay.a.a.b bVar = c0051a.dm;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", Integer.valueOf((int) ARPMessageType.MSG_TYPE_AUDIO));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("action_id", String.valueOf(bVar.dS));
        hashMap2.put("platform", "android");
        hashMap2.put("type", bVar.dW);
        HashMap hashMap3 = new HashMap();
        hashMap3.put("error_code", Integer.valueOf(bVar.dX));
        hashMap3.put("buffer_status", bVar.dZ);
        hashMap3.put("buffer_progress", Integer.valueOf(bVar.ea));
        hashMap3.put("play_status", bVar.dY);
        hashMap3.put("play_progress", Integer.valueOf((int) (bVar.eb * 100.0f)));
        hashMap2.put("data", hashMap3);
        hashMap.put("msg_data", hashMap2);
        ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
    }

    private void a(b bVar, String str, String str2, AssetFileDescriptor assetFileDescriptor, MediaPlayer.OnCompletionListener onCompletionListener, MediaPlayer.OnErrorListener onErrorListener, int i, String str3, long j) {
        try {
            C0051a a = a(str, onCompletionListener, onErrorListener);
            if (a != null) {
                a(a, str, str2, assetFileDescriptor, onCompletionListener, i, str3, j);
            }
            if (bVar != null) {
                bVar.f(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            C0051a v = v(str);
            w(str);
            try {
                if (v.dl != null) {
                    v.dl.release();
                }
                try {
                    C0051a a2 = an().a(str, onCompletionListener, onErrorListener);
                    if (a2 != null) {
                        a(a2, str, str2, assetFileDescriptor, onCompletionListener, i, str3, j);
                    }
                    if (bVar != null) {
                        bVar.f(true);
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
        hashMap.put("id", String.valueOf(bVar.dS));
        hashMap.put("target", bVar.dT);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("play_status", bVar.dY);
        hashMap2.put("buffer_status", bVar.dZ);
        hashMap2.put("duration", String.valueOf(bVar.dU));
        hashMap2.put("buffer_progress", String.valueOf(bVar.ea));
        hashMap2.put("play_progress", String.valueOf((int) (100.0f * bVar.eb)));
        hashMap.put("msg_data", hashMap2);
        ARPMessage.getInstance().sendMessage(1011, hashMap);
    }

    public static synchronized a an() {
        a aVar;
        synchronized (a.class) {
            if (cR == null) {
                cR = new a();
            }
            aVar = cR;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void ap() {
        synchronized (a.class) {
            if (da == null) {
                da = new Timer();
                db = new TimerTask() { // from class: com.baidu.ar.arplay.a.a.14
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        C0051a c0051a;
                        if (a.cU != null) {
                            for (Map.Entry entry : a.cU.entrySet()) {
                                if (entry != null && (c0051a = (C0051a) entry.getValue()) != null && c0051a.dm != null && c0051a.dm.dY == "playing") {
                                    a.a((C0051a) entry.getValue());
                                }
                            }
                        }
                    }
                };
                da.scheduleAtFixedRate(db, 0L, 200L);
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x004a -> B:27:0x0029). Please submit an issue!!! */
    private static void b(C0051a c0051a) {
        if (c0051a == null || c0051a.dl == null) {
            return;
        }
        com.baidu.ar.arplay.a.a.b bVar = c0051a.dm;
        if (bVar.dY == "playing" || bVar.dY == "paused") {
            try {
                bVar.dU = c0051a.dl.getDuration();
                if (bVar.dU <= 0) {
                    bVar.eb = 0.0f;
                } else {
                    bVar.eb = (c0051a.dl.getCurrentPosition() * 1.0f) / bVar.dU;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (bVar.dY == "finished") {
            bVar.eb = 1.0f;
        }
        if (bVar.eb > 1.0f) {
            bVar.eb = 1.0f;
        }
        if (bVar.eb < 0.0f) {
            bVar.eb = 0.0f;
        }
    }

    private void b(b bVar, String str, String str2, MediaPlayer.OnCompletionListener onCompletionListener, int i, String str3, long j) {
        C0051a v = v(str);
        w(str);
        if (v != null) {
            try {
                if (v.dl != null) {
                    v.dl.release();
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
            C0051a a = a(str, onCompletionListener, null);
            if (a != null) {
                a(a, str, str2, null, onCompletionListener, i, str3, j);
            }
            if (bVar != null) {
                bVar.f(true);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (bVar != null) {
                bVar.a(e2);
            }
        }
    }

    public C0051a a(String str, MediaPlayer.OnCompletionListener onCompletionListener, MediaPlayer.OnErrorListener onErrorListener) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (cU == null || !cU.containsKey(str)) {
            C0051a a = a(onCompletionListener, onErrorListener);
            if (a != null) {
                if (cU == null) {
                    cU = new ConcurrentHashMap<>();
                }
                cU.put(str, a);
                return a;
            }
            return null;
        }
        return cU.get(str);
    }

    public void a(Message message) {
        Object[] objArr = (Object[]) message.obj;
        String str = (String) objArr[1];
        long longValue = ((Long) objArr[6]).longValue();
        cZ.put(str, Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_RTMP_IO_FAIL));
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
        if (aVar.aA() > 1) {
            this.cY.put(aVar.getId(), Integer.valueOf(aVar.aA()));
        }
        c(1002, hashMap);
        a(new b() { // from class: com.baidu.ar.arplay.a.a.15
            @Override // com.baidu.ar.arplay.a.a.b
            public void a(Exception exc) {
                a.this.c(1010, hashMap);
            }

            @Override // com.baidu.ar.arplay.a.a.b
            public void f(boolean z) {
            }
        }, aVar.getId(), aVar.getUrl(), new MediaPlayer.OnCompletionListener() { // from class: com.baidu.ar.arplay.a.a.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (a.this.cY == null) {
                    return;
                }
                C0051a v = a.this.v(aVar.getId());
                if (v == null || v.dm.dY != "paused") {
                    if (v != null) {
                        v.dm.dW = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                        v.dm.dY = "finished";
                        a.a(v);
                        if (aVar.aD()) {
                            a.this.a(aVar, hashMap);
                            return;
                        }
                    }
                    if (a.this.cY.size() <= 0) {
                        a.this.c(1009, hashMap);
                        return;
                    }
                    int a = a.a(a.this.cY, aVar.getId());
                    if (a <= 1) {
                        a.this.c(1009, hashMap);
                        return;
                    }
                    a.this.a(aVar, hashMap);
                    int i = a - 1;
                    a.this.cY.put(aVar.getId(), Integer.valueOf(i));
                    aVar.i(i);
                }
            }
        }, aVar.aA(), aVar.aC(), aVar.aB());
    }

    public void ao() {
        this.dd = null;
        if (da != null) {
            da.cancel();
            da.purge();
            da = null;
            db.cancel();
            db = null;
        }
        if (cZ != null) {
            cZ.clear();
        }
        if (cU != null) {
            try {
                for (C0051a c0051a : cU.values()) {
                    c0051a.dm.dW = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                    c0051a.dm.dY = "unstarted";
                    a(c0051a.dl);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (cU != null) {
                cU.clear();
            }
        }
        if (this.cY != null) {
            this.cY.clear();
        }
    }

    public void b(Message message) {
        Object[] objArr = (Object[]) message.obj;
        b bVar = (b) objArr[0];
        String str = (String) objArr[1];
        cZ.put(str, 3005);
        C0051a v = v(str);
        if (v != null) {
            try {
                v.dm.dW = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                v.dm.dY = "unstarted";
                a(v);
                a(v.dl);
                v.dl = null;
                w(str);
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
            bVar.f(true);
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
            public void f(boolean z) {
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
        cZ.put(str, 3006);
        try {
            C0051a v = v(str);
            if (v.dl != null && v.dm.dY != "unstarted" && v.dl.isPlaying()) {
                v.dm.dW = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                v.dm.dY = "paused";
                a(v);
                v.dl.pause();
            }
            if (bVar != null) {
                bVar.f(true);
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
            public void f(boolean z) {
            }
        }, aVar.getId(), aVar.getUrl(), new MediaPlayer.OnCompletionListener() { // from class: com.baidu.ar.arplay.a.a.5
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (a.this.cY == null) {
                    return;
                }
                C0051a v = a.this.v(aVar.getId());
                if (v != null) {
                    v.dm.dW = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                    v.dm.dY = "finished";
                    a.a(v);
                    if (aVar.aD()) {
                        a.this.a(aVar, hashMap);
                        return;
                    }
                }
                if (a.this.cY.size() <= 0) {
                    a.this.c(1009, hashMap);
                    return;
                }
                int a = a.a(a.this.cY, aVar.getId());
                if (a <= 1) {
                    a.this.c(1009, hashMap);
                    return;
                }
                a.this.a(aVar, hashMap);
                int i = a - 1;
                a.this.cY.put(aVar.getId(), Integer.valueOf(i));
                aVar.i(i);
            }
        }, aVar.aA());
    }

    public void d(Message message) {
        Object[] objArr = (Object[]) message.obj;
        if (objArr.length < 2) {
            return;
        }
        b bVar = (b) objArr[0];
        String str = (String) objArr[1];
        cZ.put(str, 3009);
        try {
            C0051a v = v(str);
            if (v == null || v.dm.dY == "unstarted") {
                return;
            }
            v.dl.seekTo(0);
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
            public void f(boolean z) {
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
            cZ.put(str, 3007);
            try {
                C0051a v = v(str);
                if (v != null && !v.dl.isPlaying() && v.dm.dY != "unstarted") {
                    v.dm.dW = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                    v.dm.dY = "playing";
                    a(v);
                    v.dl.start();
                }
                if (bVar != null) {
                    bVar.f(true);
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
            public void f(boolean z) {
            }
        }, aVar.getId());
    }

    public void f(Message message) {
        b bVar = (b) ((Object[]) message.obj)[0];
        this.cT = false;
        this.cS = 0;
        if (cU != null) {
            try {
                for (C0051a c0051a : cU.values()) {
                    if (c0051a != null) {
                        c0051a.dl.release();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            cU.clear();
        }
        if (bVar != null) {
            bVar.f(true);
        }
    }

    public C0051a v(String str) {
        if (cU == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return cU.get(str);
    }

    public void w(String str) {
        if (cU == null || TextUtils.isEmpty(str) || !cU.containsKey(str)) {
            return;
        }
        cU.remove(str);
    }
}
