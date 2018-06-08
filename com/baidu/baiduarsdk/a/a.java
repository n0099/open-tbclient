package com.baidu.baiduarsdk.a;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.msghandler.ComponentMessageType;
import com.baidu.baiduarsdk.ArBridge;
import com.baidu.baiduarsdk.util.MsgParamsUtil;
import com.baidu.fsg.base.BaiduRimConstants;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public final class a {
    private static a a;
    private static ConcurrentHashMap<String, C0056a> d;
    private static HandlerThread e;
    private static b h;
    private static Map<String, Integer> j;
    private static Timer k;
    private static TimerTask l;
    private Handler f;
    private Map<String, Integer> i;
    private static Handler g = new Handler(Looper.getMainLooper());
    private static Runnable m = new Runnable() { // from class: com.baidu.baiduarsdk.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.e != null) {
                a.e.quit();
                HandlerThread unused = a.e = null;
            }
        }
    };
    private int b = 0;
    private boolean c = false;
    private Handler.Callback n = new Handler.Callback() { // from class: com.baidu.baiduarsdk.a.a.7
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 3004:
                    a.this.a(message);
                    return false;
                case ComponentMessageType.MSG_TYPE_LOGO_START /* 3005 */:
                    a.this.b(message);
                    return false;
                case ComponentMessageType.MSG_TYPE_LOGO_STOP /* 3006 */:
                    a.this.c(message);
                    return false;
                case ComponentMessageType.MSG_TYPE_LOGO_HIT /* 3007 */:
                    a.this.d(message);
                    return false;
                case 3008:
                    a.this.e(message);
                    return false;
                default:
                    return false;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.baiduarsdk.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0056a {
        MediaPlayer a;
        com.baidu.baiduarsdk.a.a.b b = new com.baidu.baiduarsdk.a.a.b();

        C0056a() {
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(Exception exc);

        void a(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements b {
        c(b bVar) {
            b unused = a.h = bVar;
        }

        @Override // com.baidu.baiduarsdk.a.a.b
        public void a(final Exception exc) {
            if (a.h == null) {
                return;
            }
            a.g.post(new Runnable() { // from class: com.baidu.baiduarsdk.a.a.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.h != null) {
                        a.h.a(exc);
                    }
                }
            });
        }

        @Override // com.baidu.baiduarsdk.a.a.b
        public void a(final boolean z) {
            if (a.h == null) {
                return;
            }
            a.g.post(new Runnable() { // from class: com.baidu.baiduarsdk.a.a.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.h != null) {
                        a.h.a(z);
                    }
                }
            });
        }
    }

    private a() {
        synchronized (a.class) {
            if (e == null) {
                e = new HandlerThread("MediaPlayerThread");
                e.start();
            } else {
                g.removeCallbacks(m);
            }
        }
        this.f = new Handler(e.getLooper(), this.n);
        this.i = new Hashtable();
        j = new Hashtable();
    }

    public static int a(Map<String, Integer> map, String str) {
        Integer num = map.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private C0056a a(MediaPlayer.OnCompletionListener onCompletionListener, MediaPlayer.OnErrorListener onErrorListener) {
        try {
            final C0056a c0056a = new C0056a();
            MediaPlayer mediaPlayer = new MediaPlayer();
            c0056a.a = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
            if (onCompletionListener == null) {
                onCompletionListener = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.baiduarsdk.a.a.8
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer2) {
                    }
                };
            }
            mediaPlayer.setOnCompletionListener(onCompletionListener);
            if (onErrorListener == null) {
                onErrorListener = new MediaPlayer.OnErrorListener() { // from class: com.baidu.baiduarsdk.a.a.9
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer2, int i, int i2) {
                        c0056a.b.e = "ERROR";
                        c0056a.b.f = i;
                        a.b(c0056a);
                        return false;
                    }
                };
            }
            mediaPlayer.setOnErrorListener(onErrorListener);
            return c0056a;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static C0056a a(final C0056a c0056a, final String str, String str2, AssetFileDescriptor assetFileDescriptor, MediaPlayer.OnCompletionListener onCompletionListener, int i, String str3, final long j2) {
        if ((!TextUtils.isEmpty(str2) || assetFileDescriptor != null) && c0056a != null) {
            c0056a.b.a = MsgParamsUtil.obj2Long(str, 0L);
            c0056a.b.d = str;
            c0056a.b.b = str3;
            MediaPlayer mediaPlayer = c0056a.a;
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
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.baiduarsdk.a.a.10
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer2) {
                        if (a.j == null || ((Integer) a.j.get(str)).intValue() != 3004) {
                            return;
                        }
                        a.j();
                        c0056a.b.e = "STATUS";
                        c0056a.b.g = 1;
                        a.b(c0056a);
                        if (c0056a.a.getDuration() >= 0) {
                            if (c0056a.a.getDuration() <= j2 || j2 < 0) {
                                c0056a.a.seekTo(0);
                            } else {
                                c0056a.a.seekTo((int) j2);
                            }
                        }
                        c0056a.a.start();
                        c0056a.b.g = 2;
                    }
                });
                c0056a.a.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.baiduarsdk.a.a.11
                    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
                    public void onBufferingUpdate(MediaPlayer mediaPlayer2, int i2) {
                        C0056a.this.b.e = "INFO";
                        C0056a.this.b.i = i2;
                        a.b(C0056a.this);
                    }
                });
                c0056a.a.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.baiduarsdk.a.a.12
                    @Override // android.media.MediaPlayer.OnInfoListener
                    public boolean onInfo(MediaPlayer mediaPlayer2, int i2, int i3) {
                        C0056a.this.b.e = "INFO";
                        switch (i2) {
                            case 701:
                                C0056a.this.b.h = 0;
                                a.b(C0056a.this);
                                break;
                            case 702:
                                C0056a.this.b.h = 1;
                                a.b(C0056a.this);
                                break;
                        }
                        return false;
                    }
                });
            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
            } catch (IllegalStateException e4) {
                e4.printStackTrace();
            } catch (SecurityException e5) {
                e5.printStackTrace();
            }
        }
        return c0056a;
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    public static void a(MediaPlayer mediaPlayer) {
        if (mediaPlayer != null) {
            try {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                mediaPlayer.release();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void a(b bVar, String str, String str2, AssetFileDescriptor assetFileDescriptor, MediaPlayer.OnCompletionListener onCompletionListener, MediaPlayer.OnErrorListener onErrorListener, int i, String str3, long j2) {
        try {
            C0056a a2 = a(str, onCompletionListener, onErrorListener);
            if (a2 != null) {
                a(a2, str, str2, assetFileDescriptor, onCompletionListener, i, str3, j2);
            }
            if (bVar != null) {
                bVar.a(true);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            C0056a a3 = a(str);
            b(str);
            try {
                if (a3.a != null) {
                    a3.a.release();
                }
                try {
                    C0056a a4 = a().a(str, onCompletionListener, onErrorListener);
                    if (a4 != null) {
                        a(a4, str, str2, assetFileDescriptor, onCompletionListener, i, str3, j2);
                    }
                    if (bVar != null) {
                        bVar.a(true);
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    if (bVar != null) {
                        bVar.a(e3);
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                if (bVar != null) {
                    bVar.a(e4);
                }
            }
        }
    }

    private static void a(com.baidu.baiduarsdk.a.a.b bVar) {
        if (bVar == null) {
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", String.valueOf(bVar.a));
        hashMap.put(BaiduRimConstants.ACTION_TARGET, bVar.b);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("play_status", Integer.valueOf(bVar.g));
        hashMap2.put("buffer_status", Integer.valueOf(bVar.h));
        hashMap2.put("duration", Integer.valueOf(bVar.c));
        hashMap2.put("buffer_progress", Integer.valueOf(bVar.i));
        hashMap2.put("play_progress", Integer.valueOf((int) (100.0f * bVar.j)));
        hashMap.put("msg_data", hashMap2);
        ArBridge.getInstance().sendMessage(1011, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(C0056a c0056a) {
        if (c0056a == null) {
            return;
        }
        c(c0056a);
        a(c0056a.b);
        com.baidu.baiduarsdk.a.a.b bVar = c0056a.b;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", Integer.valueOf((int) ArBridge.MessageType.MSG_TYPE_AUDIO));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("action_id", String.valueOf(bVar.a));
        hashMap2.put("platform", HttpConstants.OS_TYPE_VALUE);
        hashMap2.put("type", bVar.e);
        HashMap hashMap3 = new HashMap();
        hashMap3.put("error_code", Integer.valueOf(bVar.f));
        hashMap3.put("buffer_status", Integer.valueOf(bVar.h));
        hashMap3.put("buffer_progress", Integer.valueOf(bVar.i));
        hashMap3.put("play_status", Integer.valueOf(bVar.g));
        hashMap3.put("play_progress", Integer.valueOf((int) (bVar.j * 100.0f)));
        hashMap2.put("data", hashMap3);
        hashMap.put("msg_data", hashMap2);
        ArBridge.getInstance().sendMessage(ArBridge.MessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
    }

    private void b(b bVar, String str, String str2, MediaPlayer.OnCompletionListener onCompletionListener, int i, String str3, long j2) {
        C0056a a2 = a(str);
        b(str);
        try {
            if (a2.a != null) {
                a2.a.release();
            }
            try {
                C0056a a3 = a(str, onCompletionListener, null);
                if (a3 != null) {
                    a(a3, str, str2, null, onCompletionListener, i, str3, j2);
                }
                if (bVar != null) {
                    bVar.a(true);
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

    public static synchronized void c() {
        synchronized (a.class) {
            if (a != null) {
                a.b();
            }
            a = null;
            g.postDelayed(m, 10000L);
            if (h != null) {
                h = null;
            }
        }
    }

    private static void c(C0056a c0056a) {
        if (c0056a == null || c0056a.a == null) {
            return;
        }
        com.baidu.baiduarsdk.a.a.b bVar = c0056a.b;
        switch (bVar.g) {
            case 2:
            case 3:
                try {
                    bVar.c = c0056a.a.getDuration();
                    if (bVar.c <= 0) {
                        bVar.j = 0.0f;
                    } else {
                        bVar.j = (c0056a.a.getCurrentPosition() * 1.0f) / bVar.c;
                    }
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    break;
                }
            case 4:
                bVar.j = 1.0f;
                break;
        }
        if (bVar.j > 1.0f) {
            bVar.j = 1.0f;
        }
        if (bVar.j < 0.0f) {
            bVar.j = 0.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j() {
        if (k == null) {
            k = new Timer();
            l = new TimerTask() { // from class: com.baidu.baiduarsdk.a.a.13
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    C0056a c0056a;
                    if (a.d != null) {
                        for (Map.Entry entry : a.d.entrySet()) {
                            if (entry != null && (c0056a = (C0056a) entry.getValue()) != null && c0056a.b != null && c0056a.b.g == 2) {
                                a.b((C0056a) entry.getValue());
                            }
                        }
                    }
                }
            };
            k.scheduleAtFixedRate(l, 0L, 200L);
        }
    }

    public C0056a a(String str) {
        if (d == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return d.get(str);
    }

    public C0056a a(String str, MediaPlayer.OnCompletionListener onCompletionListener, MediaPlayer.OnErrorListener onErrorListener) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (d == null || !d.containsKey(str)) {
            C0056a a2 = a(onCompletionListener, onErrorListener);
            if (a2 != null) {
                if (d == null) {
                    d = new ConcurrentHashMap<>();
                }
                d.put(str, a2);
                return a2;
            }
            return null;
        }
        return d.get(str);
    }

    public void a(int i, HashMap<String, Object> hashMap) {
        ArBridge.getInstance().sendMessage(i, hashMap);
    }

    public void a(Message message) {
        Object[] objArr = (Object[]) message.obj;
        String str = (String) objArr[1];
        long longValue = ((Long) objArr[6]).longValue();
        j.put(str, 3004);
        a((b) objArr[0], str, (String) objArr[2], null, (MediaPlayer.OnCompletionListener) objArr[3], null, ((Integer) objArr[4]).intValue(), (String) objArr[5], longValue);
    }

    public void a(b bVar) {
        Message obtainMessage = this.f.obtainMessage(3008);
        obtainMessage.obj = new Object[]{new c(bVar)};
        obtainMessage.sendToTarget();
    }

    public void a(b bVar, String str) {
        Message obtainMessage = this.f.obtainMessage(ComponentMessageType.MSG_TYPE_LOGO_STOP);
        obtainMessage.obj = new Object[]{new c(bVar), str};
        obtainMessage.sendToTarget();
    }

    public void a(b bVar, String str, String str2, MediaPlayer.OnCompletionListener onCompletionListener, int i) {
        Message obtainMessage = this.f.obtainMessage(ComponentMessageType.MSG_TYPE_LOGO_HIT);
        obtainMessage.obj = new Object[]{new c(bVar), str, str2, onCompletionListener, Integer.valueOf(i)};
        obtainMessage.sendToTarget();
    }

    public void a(b bVar, String str, String str2, MediaPlayer.OnCompletionListener onCompletionListener, int i, String str3, long j2) {
        Message obtainMessage = this.f.obtainMessage(3004);
        obtainMessage.obj = new Object[]{new c(bVar), str, str2, onCompletionListener, Integer.valueOf(i), str3, Long.valueOf(j2)};
        obtainMessage.sendToTarget();
    }

    public void a(final com.baidu.baiduarsdk.a.a.a aVar, final HashMap<String, Object> hashMap) {
        if (aVar.b() > 1) {
            this.i.put(aVar.a(), Integer.valueOf(aVar.b()));
        }
        a(1002, hashMap);
        a(new b() { // from class: com.baidu.baiduarsdk.a.a.14
            @Override // com.baidu.baiduarsdk.a.a.b
            public void a(Exception exc) {
                a.this.a(1010, hashMap);
            }

            @Override // com.baidu.baiduarsdk.a.a.b
            public void a(boolean z) {
            }
        }, aVar.a(), aVar.c(), new MediaPlayer.OnCompletionListener() { // from class: com.baidu.baiduarsdk.a.a.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (a.this.i == null) {
                    return;
                }
                C0056a a2 = a.this.a(aVar.a());
                if (a2 != null) {
                    a2.b.e = "STATUS";
                    a2.b.g = 4;
                    a.b(a2);
                    if (aVar.f()) {
                        a.this.a(aVar, hashMap);
                        return;
                    }
                }
                if (a.this.i.size() <= 0) {
                    a.this.a(1009, hashMap);
                    return;
                }
                int a3 = a.a(a.this.i, aVar.a());
                if (a3 <= 1) {
                    a.this.a(1009, hashMap);
                    return;
                }
                a.this.a(aVar, hashMap);
                int i = a3 - 1;
                a.this.i.put(aVar.a(), Integer.valueOf(i));
                aVar.a(i);
            }
        }, aVar.b(), aVar.e(), aVar.d());
    }

    public void b() {
        if (k != null) {
            k.cancel();
            k.purge();
            k = null;
            l.cancel();
            l = null;
        }
        if (j != null) {
            j.clear();
        }
        if (d != null) {
            try {
                for (C0056a c0056a : d.values()) {
                    c0056a.b.e = "STATUS";
                    c0056a.b.g = 0;
                    a(c0056a.a);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (d != null) {
                d.clear();
            }
        }
        if (this.i != null) {
            this.i.clear();
        }
    }

    public void b(Message message) {
        Object[] objArr = (Object[]) message.obj;
        b bVar = (b) objArr[0];
        String str = (String) objArr[1];
        j.put(str, Integer.valueOf((int) ComponentMessageType.MSG_TYPE_LOGO_START));
        C0056a a2 = a(str);
        if (a2 != null) {
            try {
                a2.b.e = "STATUS";
                a2.b.g = 0;
                b(a2);
                a(a2.a);
                a2.a = null;
                b(str);
            } catch (Exception e2) {
                e2.printStackTrace();
                if (bVar != null) {
                    bVar.a(e2);
                    return;
                }
                return;
            }
        }
        if (bVar != null) {
            bVar.a(true);
        }
    }

    public void b(b bVar, String str) {
        Message obtainMessage = this.f.obtainMessage(ComponentMessageType.MSG_TYPE_LOGO_START);
        obtainMessage.obj = new Object[]{new c(bVar), str};
        obtainMessage.sendToTarget();
    }

    public void b(com.baidu.baiduarsdk.a.a.a aVar, final HashMap<String, Object> hashMap) {
        a(1004, hashMap);
        a(new b() { // from class: com.baidu.baiduarsdk.a.a.3
            @Override // com.baidu.baiduarsdk.a.a.b
            public void a(Exception exc) {
                a.this.a(1010, hashMap);
            }

            @Override // com.baidu.baiduarsdk.a.a.b
            public void a(boolean z) {
            }
        }, aVar.a());
    }

    public void b(String str) {
        if (d == null || TextUtils.isEmpty(str) || !d.containsKey(str)) {
            return;
        }
        d.remove(str);
    }

    public void c(Message message) {
        Object[] objArr = (Object[]) message.obj;
        b bVar = (b) objArr[0];
        String str = (String) objArr[1];
        j.put(str, Integer.valueOf((int) ComponentMessageType.MSG_TYPE_LOGO_STOP));
        try {
            C0056a a2 = a(str);
            if (a2.a != null && a2.a.isPlaying()) {
                a2.b.e = "STATUS";
                a2.b.g = 3;
                b(a2);
                a2.a.pause();
            }
            if (bVar != null) {
                bVar.a(true);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (bVar != null) {
                bVar.a(e2);
            }
        }
    }

    public void c(final com.baidu.baiduarsdk.a.a.a aVar, final HashMap<String, Object> hashMap) {
        a(1006, hashMap);
        a(new b() { // from class: com.baidu.baiduarsdk.a.a.4
            @Override // com.baidu.baiduarsdk.a.a.b
            public void a(Exception exc) {
                a.this.a(1010, hashMap);
            }

            @Override // com.baidu.baiduarsdk.a.a.b
            public void a(boolean z) {
            }
        }, aVar.a(), aVar.c(), new MediaPlayer.OnCompletionListener() { // from class: com.baidu.baiduarsdk.a.a.5
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (a.this.i == null) {
                    return;
                }
                C0056a a2 = a.this.a(aVar.a());
                if (a2 != null) {
                    a2.b.e = "STATUS";
                    a2.b.g = 4;
                    a.b(a2);
                    if (aVar.f()) {
                        a.this.a(aVar, hashMap);
                        return;
                    }
                }
                if (a.this.i.size() <= 0) {
                    a.this.a(1009, hashMap);
                    return;
                }
                int a3 = a.a(a.this.i, aVar.a());
                if (a3 <= 1) {
                    a.this.a(1009, hashMap);
                    return;
                }
                a.this.a(aVar, hashMap);
                int i = a3 - 1;
                a.this.i.put(aVar.a(), Integer.valueOf(i));
                aVar.a(i);
            }
        }, aVar.b());
    }

    public void d(Message message) {
        Object[] objArr = (Object[]) message.obj;
        b bVar = (b) objArr[0];
        String str = (String) objArr[1];
        String str2 = (String) objArr[2];
        MediaPlayer.OnCompletionListener onCompletionListener = (MediaPlayer.OnCompletionListener) objArr[3];
        int intValue = ((Integer) objArr[4]).intValue();
        String str3 = null;
        long j2 = 0;
        if (objArr.length > 5) {
            j2 = ((Long) objArr[6]).longValue();
            str3 = (String) objArr[5];
        }
        j.put(str, Integer.valueOf((int) ComponentMessageType.MSG_TYPE_LOGO_HIT));
        try {
            C0056a a2 = a(str);
            if (a2 != null && !a2.a.isPlaying()) {
                a2.b.e = "STATUS";
                a2.b.g = 2;
                b(a2);
                a2.a.start();
            }
            if (bVar != null) {
                bVar.a(true);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            b(bVar, str, str2, onCompletionListener, intValue, str3, j2);
        }
    }

    public void d(com.baidu.baiduarsdk.a.a.a aVar, final HashMap<String, Object> hashMap) {
        a(1008, hashMap);
        b(new b() { // from class: com.baidu.baiduarsdk.a.a.6
            @Override // com.baidu.baiduarsdk.a.a.b
            public void a(Exception exc) {
                a.this.a(1010, hashMap);
            }

            @Override // com.baidu.baiduarsdk.a.a.b
            public void a(boolean z) {
            }
        }, aVar.a());
    }

    public void e(Message message) {
        b bVar = (b) ((Object[]) message.obj)[0];
        this.c = false;
        this.b = 0;
        if (d != null) {
            try {
                for (C0056a c0056a : d.values()) {
                    if (c0056a != null) {
                        c0056a.a.release();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            d.clear();
        }
        if (bVar != null) {
            bVar.a(true);
        }
    }
}
