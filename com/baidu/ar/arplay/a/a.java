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

    /* renamed from: de  reason: collision with root package name */
    private static a f978de;
    private static ConcurrentHashMap<String, C0075a> dh;
    private static HandlerThread di;
    private static b dk;
    private static Map<String, Integer> dm;
    private static Timer dn;

    /* renamed from: do  reason: not valid java name */
    private static TimerTask f0do;
    private Map<String, Integer> dl;
    private Handler mHandler;
    private static Handler dj = new Handler(Looper.getMainLooper());
    public static final String TAG = a.class.getSimpleName();
    private static Runnable dp = new Runnable() { // from class: com.baidu.ar.arplay.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.di != null) {
                a.di.quit();
                HandlerThread unused = a.di = null;
            }
        }
    };
    private int df = 0;
    private boolean dg = false;
    private Handler.Callback dq = new Handler.Callback() { // from class: com.baidu.ar.arplay.a.a.8
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
    public static class C0075a {
        MediaPlayer dy;
        com.baidu.ar.arplay.a.a.b dz = new com.baidu.ar.arplay.a.a.b();

        C0075a() {
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(Exception exc);

        void onResult(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements b {
        c(b bVar) {
            b unused = a.dk = bVar;
        }

        @Override // com.baidu.ar.arplay.a.a.b
        public void a(final Exception exc) {
            if (a.dk == null) {
                return;
            }
            a.dj.post(new Runnable() { // from class: com.baidu.ar.arplay.a.a.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.dk != null) {
                        a.dk.a(exc);
                    }
                }
            });
        }

        @Override // com.baidu.ar.arplay.a.a.b
        public void onResult(final boolean z) {
            if (a.dk == null) {
                return;
            }
            a.dj.post(new Runnable() { // from class: com.baidu.ar.arplay.a.a.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.dk != null) {
                        a.dk.onResult(z);
                    }
                }
            });
        }
    }

    private a() {
        synchronized (a.class) {
            if (di == null) {
                di = new HandlerThread("MediaPlayerThread");
                di.start();
            } else {
                dj.removeCallbacks(dp);
            }
        }
        this.mHandler = new Handler(di.getLooper(), this.dq);
        this.dl = new Hashtable();
        dm = new Hashtable();
    }

    public static int a(Map<String, Integer> map, String str) {
        Integer num = map.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private C0075a a(MediaPlayer.OnCompletionListener onCompletionListener, MediaPlayer.OnErrorListener onErrorListener) {
        try {
            final C0075a c0075a = new C0075a();
            MediaPlayer mediaPlayer = new MediaPlayer();
            c0075a.dy = mediaPlayer;
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
                        c0075a.dz.ei = "ERROR";
                        c0075a.dz.ej = i;
                        a.a(c0075a);
                        a.this.b(new b() { // from class: com.baidu.ar.arplay.a.a.10.1
                            @Override // com.baidu.ar.arplay.a.a.b
                            public void a(Exception exc) {
                                a.this.c(1010, (HashMap<String, Object>) null);
                            }

                            @Override // com.baidu.ar.arplay.a.a.b
                            public void onResult(boolean z) {
                            }
                        }, c0075a.dz.eh);
                        return false;
                    }
                };
            }
            mediaPlayer.setOnErrorListener(onErrorListener);
            return c0075a;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static C0075a a(final C0075a c0075a, final String str, String str2, AssetFileDescriptor assetFileDescriptor, MediaPlayer.OnCompletionListener onCompletionListener, int i, String str3, final long j) {
        if ((!TextUtils.isEmpty(str2) || assetFileDescriptor != null) && c0075a != null) {
            c0075a.dz.ee = com.baidu.ar.arplay.c.c.a((Object) str, 0L);
            c0075a.dz.eh = str;
            c0075a.dz.ef = str3;
            MediaPlayer mediaPlayer = c0075a.dy;
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
                        C0075a.this.dz.ei = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                        C0075a.this.dz.ek = DpStatConstants.KEY_PREPARED;
                        a.a(C0075a.this);
                        if (ARPEngine.getInstance().isPaused() || a.dm == null || a.dm.get(str) == null) {
                            return;
                        }
                        if (((Integer) a.dm.get(str)).intValue() == 3004 || ((Integer) a.dm.get(str)).intValue() == 3007) {
                            a.aD();
                            try {
                                if (C0075a.this.dy.getDuration() >= 0) {
                                    if (C0075a.this.dy.getDuration() <= j || j < 0) {
                                        C0075a.this.dy.seekTo(0);
                                    } else {
                                        C0075a.this.dy.seekTo((int) j);
                                    }
                                }
                                com.baidu.ar.arplay.c.b.b(a.TAG, "mMediaPlayer start");
                                C0075a.this.dy.start();
                                C0075a.this.dz.ek = "playing";
                            } catch (Exception e) {
                                a.a(C0075a.this.dy);
                                e.printStackTrace();
                            }
                        }
                    }
                });
                c0075a.dy.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.ar.arplay.a.a.12
                    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
                    public void onBufferingUpdate(MediaPlayer mediaPlayer2, int i2) {
                        C0075a.this.dz.ei = "INFO";
                        C0075a.this.dz.em = i2;
                        a.a(C0075a.this);
                    }
                });
                c0075a.dy.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.ar.arplay.a.a.13
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i2, int i3) {
                        C0075a.this.dz.ei = "INFO";
                        switch (i2) {
                            case 701:
                                C0075a.this.dz.el = "buffer_start";
                                a.a(C0075a.this);
                                return false;
                            case CyberPlayerManager.MEDIA_INFO_BUFFERING_END /* 702 */:
                                C0075a.this.dz.el = "buffer_end";
                                a.a(C0075a.this);
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
        return c0075a;
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
    public static void a(C0075a c0075a) {
        if (c0075a == null) {
            return;
        }
        b(c0075a);
        a(c0075a.dz);
        com.baidu.ar.arplay.a.a.b bVar = c0075a.dz;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", Integer.valueOf((int) ARPMessageType.MSG_TYPE_AUDIO));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("action_id", String.valueOf(bVar.ee));
        hashMap2.put("platform", "android");
        hashMap2.put("type", bVar.ei);
        HashMap hashMap3 = new HashMap();
        hashMap3.put("error_code", Integer.valueOf(bVar.ej));
        hashMap3.put("buffer_status", bVar.el);
        hashMap3.put("buffer_progress", Integer.valueOf(bVar.em));
        hashMap3.put("play_status", bVar.ek);
        hashMap3.put("play_progress", Integer.valueOf((int) (bVar.en * 100.0f)));
        hashMap2.put("data", hashMap3);
        hashMap.put("msg_data", hashMap2);
        ARPMessage.getInstance().sendMessage(ARPMessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
    }

    private void a(b bVar, String str, String str2, AssetFileDescriptor assetFileDescriptor, MediaPlayer.OnCompletionListener onCompletionListener, MediaPlayer.OnErrorListener onErrorListener, int i, String str3, long j) {
        try {
            C0075a a = a(str, onCompletionListener, onErrorListener);
            if (a != null) {
                a(a, str, str2, assetFileDescriptor, onCompletionListener, i, str3, j);
            }
            if (bVar != null) {
                bVar.onResult(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            C0075a v = v(str);
            w(str);
            try {
                if (v.dy != null) {
                    v.dy.release();
                }
                try {
                    C0075a a2 = aB().a(str, onCompletionListener, onErrorListener);
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

    private static void a(com.baidu.ar.arplay.a.a.b bVar) {
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
        ARPMessage.getInstance().sendMessage(1011, hashMap);
    }

    public static synchronized a aB() {
        a aVar;
        synchronized (a.class) {
            if (f978de == null) {
                f978de = new a();
            }
            aVar = f978de;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void aD() {
        synchronized (a.class) {
            if (dn == null) {
                dn = new Timer();
                f0do = new TimerTask() { // from class: com.baidu.ar.arplay.a.a.14
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        C0075a c0075a;
                        if (a.dh != null) {
                            for (Map.Entry entry : a.dh.entrySet()) {
                                if (entry != null && (c0075a = (C0075a) entry.getValue()) != null && c0075a.dz != null && c0075a.dz.ek == "playing") {
                                    a.a((C0075a) entry.getValue());
                                }
                            }
                        }
                    }
                };
                dn.scheduleAtFixedRate(f0do, 0L, 200L);
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x004a -> B:27:0x0029). Please submit an issue!!! */
    private static void b(C0075a c0075a) {
        if (c0075a == null || c0075a.dy == null) {
            return;
        }
        com.baidu.ar.arplay.a.a.b bVar = c0075a.dz;
        if (bVar.ek == "playing" || bVar.ek == "paused") {
            try {
                bVar.eg = c0075a.dy.getDuration();
                if (bVar.eg <= 0) {
                    bVar.en = 0.0f;
                } else {
                    bVar.en = (c0075a.dy.getCurrentPosition() * 1.0f) / bVar.eg;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (bVar.ek == "finished") {
            bVar.en = 1.0f;
        }
        if (bVar.en > 1.0f) {
            bVar.en = 1.0f;
        }
        if (bVar.en < 0.0f) {
            bVar.en = 0.0f;
        }
    }

    private void b(b bVar, String str, String str2, MediaPlayer.OnCompletionListener onCompletionListener, int i, String str3, long j) {
        C0075a v = v(str);
        w(str);
        if (v != null) {
            try {
                if (v.dy != null) {
                    v.dy.release();
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
            C0075a a = a(str, onCompletionListener, null);
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

    public C0075a a(String str, MediaPlayer.OnCompletionListener onCompletionListener, MediaPlayer.OnErrorListener onErrorListener) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (dh == null || !dh.containsKey(str)) {
            C0075a a = a(onCompletionListener, onErrorListener);
            if (a != null) {
                if (dh == null) {
                    dh = new ConcurrentHashMap<>();
                }
                dh.put(str, a);
                return a;
            }
            return null;
        }
        return dh.get(str);
    }

    public void a(Message message) {
        Object[] objArr = (Object[]) message.obj;
        String str = (String) objArr[1];
        long longValue = ((Long) objArr[6]).longValue();
        dm.put(str, Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_RTMP_IO_FAIL));
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
        if (aVar.aO() > 1) {
            this.dl.put(aVar.getId(), Integer.valueOf(aVar.aO()));
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
                if (a.this.dl == null) {
                    return;
                }
                C0075a v = a.this.v(aVar.getId());
                if (v == null || v.dz.ek != "paused") {
                    if (v != null) {
                        v.dz.ei = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                        v.dz.ek = "finished";
                        a.a(v);
                        if (aVar.aR()) {
                            com.baidu.ar.arplay.c.b.b(a.TAG, "mMediaPlayer onCompletion  isLoopForever open！");
                            a.this.a(aVar, hashMap);
                            return;
                        }
                    }
                    if (a.this.dl.size() <= 0) {
                        a.this.c(1009, hashMap);
                        return;
                    }
                    int a = a.a(a.this.dl, aVar.getId());
                    if (a <= 1) {
                        a.this.c(1009, hashMap);
                        return;
                    }
                    com.baidu.ar.arplay.c.b.b(a.TAG, "mMediaPlayer onCompletion  count open ！");
                    a.this.a(aVar, hashMap);
                    int i = a - 1;
                    a.this.dl.put(aVar.getId(), Integer.valueOf(i));
                    aVar.j(i);
                }
            }
        }, aVar.aO(), aVar.aQ(), aVar.aP());
    }

    public void aC() {
        this.dq = null;
        if (dn != null) {
            dn.cancel();
            dn.purge();
            dn = null;
            f0do.cancel();
            f0do = null;
        }
        if (dm != null) {
            dm.clear();
        }
        if (dh != null) {
            try {
                for (C0075a c0075a : dh.values()) {
                    c0075a.dz.ei = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                    c0075a.dz.ek = "unstarted";
                    a(c0075a.dy);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (dh != null) {
                dh.clear();
            }
        }
        if (this.dl != null) {
            this.dl.clear();
        }
    }

    public void b(Message message) {
        Object[] objArr = (Object[]) message.obj;
        b bVar = (b) objArr[0];
        String str = (String) objArr[1];
        dm.put(str, 3005);
        C0075a v = v(str);
        if (v != null) {
            try {
                v.dz.ei = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                v.dz.ek = "unstarted";
                a(v);
                com.baidu.ar.arplay.c.b.b(TAG, "mMediaPlayer stopPlay");
                a(v.dy);
                v.dy = null;
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
        dm.put(str, 3006);
        try {
            C0075a v = v(str);
            if (v.dy != null && v.dz.ek != "unstarted" && v.dy.isPlaying()) {
                v.dz.ei = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                v.dz.ek = "paused";
                a(v);
                com.baidu.ar.arplay.c.b.b(TAG, "mMediaPlayer pause");
                v.dy.pause();
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
                if (a.this.dl == null) {
                    return;
                }
                C0075a v = a.this.v(aVar.getId());
                if (v != null) {
                    v.dz.ei = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                    v.dz.ek = "finished";
                    a.a(v);
                    if (aVar.aR()) {
                        a.this.a(aVar, hashMap);
                        return;
                    }
                }
                if (a.this.dl.size() <= 0) {
                    a.this.c(1009, hashMap);
                    return;
                }
                int a = a.a(a.this.dl, aVar.getId());
                if (a <= 1) {
                    a.this.c(1009, hashMap);
                    return;
                }
                a.this.a(aVar, hashMap);
                int i = a - 1;
                a.this.dl.put(aVar.getId(), Integer.valueOf(i));
                aVar.j(i);
            }
        }, aVar.aO());
    }

    public void d(Message message) {
        Object[] objArr = (Object[]) message.obj;
        if (objArr.length < 2) {
            return;
        }
        b bVar = (b) objArr[0];
        String str = (String) objArr[1];
        dm.put(str, 3009);
        try {
            C0075a v = v(str);
            if (v == null || v.dz.ek == "unstarted") {
                return;
            }
            v.dy.seekTo(0);
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
            dm.put(str, 3007);
            try {
                C0075a v = v(str);
                if (v != null && !v.dy.isPlaying() && v.dz.ek != "unstarted") {
                    v.dz.ei = DownloadConstants.DownloadColumns.COLUMN_STATUS;
                    v.dz.ek = "playing";
                    a(v);
                    com.baidu.ar.arplay.c.b.b(TAG, "MediaPlayer resume");
                    v.dy.seekTo(v.dy.getCurrentPosition());
                    v.dy.start();
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
        this.dg = false;
        this.df = 0;
        if (dh != null) {
            try {
                for (C0075a c0075a : dh.values()) {
                    if (c0075a != null) {
                        c0075a.dy.release();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            dh.clear();
        }
        if (bVar != null) {
            bVar.onResult(true);
        }
    }

    public C0075a v(String str) {
        if (dh == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return dh.get(str);
    }

    public void w(String str) {
        if (dh == null || TextUtils.isEmpty(str) || !dh.containsKey(str)) {
            return;
        }
        dh.remove(str);
    }
}
