package com.baidu.baiduarsdk.a;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.Surface;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.baiduarsdk.ArBridge;
import com.baidu.fsg.base.BaiduRimConstants;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class e {
    private static e a;
    private Timer f;
    private int b = 0;
    private boolean c = false;
    private ConcurrentHashMap<String, b> d = new ConcurrentHashMap<>();
    private TimerTask g = new TimerTask() { // from class: com.baidu.baiduarsdk.a.e.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            b bVar;
            if (e.this.d != null) {
                for (Map.Entry entry : e.this.d.entrySet()) {
                    if (entry != null && (bVar = (b) entry.getValue()) != null && bVar.e != null && bVar.e.g == 2) {
                        e.b((b) entry.getValue());
                    }
                }
            }
        }
    };
    private Map<String, Integer> e = new Hashtable();

    /* loaded from: classes3.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class b {
        String a;
        MediaPlayer b;
        SurfaceTexture c;
        int d;
        com.baidu.baiduarsdk.a.a.b e = new com.baidu.baiduarsdk.a.a.b();

        b() {
        }
    }

    private e() {
    }

    public static synchronized e a() {
        e eVar;
        synchronized (e.class) {
            if (a == null) {
                a = new e();
            }
            eVar = a;
        }
        return eVar;
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
        ArBridge.getInstance().sendMessage(ArBridge.MessageType.MSG_TYPE_VIDEO_PLAY_INFO_UPDATE, hashMap);
    }

    private void a(a aVar, String str, String str2, int i, MediaPlayer.OnCompletionListener onCompletionListener, boolean z, String str3, final long j) {
        if (this.d.containsKey(str)) {
            b bVar = this.d.get(str);
            if (bVar != null) {
                try {
                    if (bVar.b != null) {
                        bVar.b.reset();
                        bVar.b.setDataSource(str2);
                        bVar.b.setLooping(z);
                        bVar.b.setOnCompletionListener(onCompletionListener);
                        bVar.b.prepareAsync();
                        bVar.a = str2;
                        return;
                    }
                    return;
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            final b bVar2 = new b();
            bVar2.a = str2;
            bVar2.b = new MediaPlayer();
            bVar2.b.setDataSource(str2);
            bVar2.d = i;
            bVar2.c = new SurfaceTexture(i);
            bVar2.e.a = Long.valueOf(str).longValue();
            bVar2.e.b = str3;
            bVar2.b.setSurface(new Surface(bVar2.c));
            bVar2.b.setOnCompletionListener(onCompletionListener);
            bVar2.b.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.baidu.baiduarsdk.a.e.3
                @Override // android.media.MediaPlayer.OnErrorListener
                public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                    bVar2.e.e = "ERROR";
                    bVar2.e.f = i2;
                    e.b(bVar2);
                    return false;
                }
            });
            bVar2.b.setLooping(z);
            bVar2.b.prepareAsync();
            bVar2.b.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.baiduarsdk.a.e.4
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    e.this.d();
                    bVar2.e.e = "STATUS";
                    bVar2.e.g = 1;
                    e.b(bVar2);
                    if (bVar2.b.getDuration() >= 0) {
                        if (bVar2.b.getDuration() <= j || j < 0) {
                            bVar2.b.seekTo(0);
                        } else {
                            bVar2.b.seekTo((int) j);
                        }
                    }
                    bVar2.b.start();
                    bVar2.e.g = 2;
                }
            });
            bVar2.b.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() { // from class: com.baidu.baiduarsdk.a.e.5
                @Override // android.media.MediaPlayer.OnBufferingUpdateListener
                public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
                    bVar2.e.e = "INFO";
                    bVar2.e.i = i2;
                    e.b(bVar2);
                }
            });
            bVar2.b.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.baidu.baiduarsdk.a.e.6
                @Override // android.media.MediaPlayer.OnInfoListener
                public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
                    bVar2.e.e = "INFO";
                    switch (i2) {
                        case 701:
                            bVar2.e.h = 0;
                            e.b(bVar2);
                            break;
                        case 702:
                            bVar2.e.h = 1;
                            e.b(bVar2);
                            break;
                    }
                    return false;
                }
            });
            if (this.d == null || str == null) {
                return;
            }
            this.d.put(str, bVar2);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(b bVar) {
        if (bVar == null) {
            return;
        }
        c(bVar);
        a(bVar.e);
        com.baidu.baiduarsdk.a.a.b bVar2 = bVar.e;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", Integer.valueOf((int) ArBridge.MessageType.MSG_TYPE_VIDEO));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("action_id", String.valueOf(bVar2.a));
        hashMap2.put("platform", HttpConstants.OS_TYPE_VALUE);
        hashMap2.put("type", bVar2.e);
        HashMap hashMap3 = new HashMap();
        hashMap3.put("error_code", Integer.valueOf(bVar2.f));
        hashMap3.put("buffer_status", Integer.valueOf(bVar2.h));
        hashMap3.put("buffer_progress", Integer.valueOf(bVar2.i));
        hashMap3.put("play_status", Integer.valueOf(bVar2.g));
        hashMap3.put("play_progress", Integer.valueOf((int) (bVar2.j * 100.0f)));
        hashMap2.put("data", hashMap3);
        hashMap.put("msg_data", hashMap2);
        ArBridge.getInstance().sendMessage(ArBridge.MessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
    }

    private static void c(b bVar) {
        if (bVar == null || bVar.b == null) {
            return;
        }
        com.baidu.baiduarsdk.a.a.b bVar2 = bVar.e;
        switch (bVar2.g) {
            case 2:
            case 3:
                try {
                    bVar2.c = bVar.b.getDuration();
                    if (bVar2.c <= 0) {
                        bVar2.j = 0.0f;
                    } else {
                        bVar2.j = (bVar.b.getCurrentPosition() * 1.0f) / bVar2.c;
                    }
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            case 4:
                bVar2.j = 1.0f;
                break;
        }
        if (bVar2.j > 1.0f) {
            bVar2.j = 1.0f;
        }
        if (bVar2.j < 0.0f) {
            bVar2.j = 0.0f;
        }
    }

    private MediaPlayer d(String str) {
        if (this.d == null || this.d.get(str) == null) {
            return null;
        }
        return this.d.get(str).b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.f == null) {
            this.f = new Timer();
            this.f.scheduleAtFixedRate(this.g, 0L, 200L);
        }
    }

    private static void e() {
        a = null;
    }

    private void e(String str) {
        if (this.d == null || this.d.get(str) == null) {
            return;
        }
        this.d.remove(str);
    }

    public int a(Map<String, Integer> map, String str) {
        Integer num = map.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public b a(String str) {
        if (this.d != null) {
            return this.d.get(str);
        }
        return null;
    }

    public void a(int i, HashMap<String, Object> hashMap) {
        ArBridge.getInstance().sendMessage(i, hashMap);
    }

    public void a(final com.baidu.baiduarsdk.a.a.e eVar, final HashMap<String, Object> hashMap) {
        if (eVar.d() > 1) {
            this.e.put(eVar.a(), Integer.valueOf(eVar.d()));
        }
        a(ArBridge.MessageType.MSG_TYPE_VIDEO_PLAY_RES, hashMap);
        a(new a() { // from class: com.baidu.baiduarsdk.a.e.7
        }, eVar.a(), eVar.c(), new MediaPlayer.OnCompletionListener() { // from class: com.baidu.baiduarsdk.a.e.8
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (e.this.e == null || eVar == null) {
                    return;
                }
                b a2 = e.this.a(eVar.a());
                if (a2 != null) {
                    a2.e.e = "STATUS";
                    a2.e.g = 4;
                    e.b(a2);
                    if (eVar.e()) {
                        e.this.a(eVar, hashMap);
                        return;
                    }
                }
                if (e.this.e.size() <= 0) {
                    e.this.a(ArBridge.MessageType.MSG_TYPE_VIDEO_PLAY_FINISH, hashMap);
                    return;
                }
                int a3 = e.this.a(e.this.e, eVar.a());
                if (a3 <= 1) {
                    e.this.a(ArBridge.MessageType.MSG_TYPE_VIDEO_PLAY_FINISH, hashMap);
                    return;
                }
                int i = a3 - 1;
                e.this.e.put(eVar.a(), Integer.valueOf(i));
                eVar.b(i);
                e.this.a(eVar, hashMap);
            }
        }, eVar.b(), eVar.d(), eVar.g(), eVar.f());
    }

    public void a(a aVar, String str) {
        MediaPlayer d = d(str);
        if (d == null || !d.isPlaying()) {
            return;
        }
        b a2 = a(str);
        if (a2 != null) {
            a2.e.e = "STATUS";
            a2.e.g = 3;
            b(a2);
        }
        d.pause();
    }

    public void a(a aVar, String str, String str2, MediaPlayer.OnCompletionListener onCompletionListener, int i, int i2, String str3, long j) {
        a(aVar, str, str2, i, onCompletionListener, false, str3, j);
    }

    public void a(String str, int i) {
        b bVar = this.d.get(str);
        if (bVar != null) {
            bVar.c = new SurfaceTexture(i);
            try {
                bVar.b.setSurface(new Surface(bVar.c));
            } catch (Exception e) {
                Log.i("VideoPlayerManager", "MediaPlayer setSurface failed.");
            }
            bVar.d = i;
        }
    }

    public int b(String str) {
        b a2 = a(str);
        if (a2 != null) {
            return a2.d;
        }
        return 0;
    }

    public void b() {
        if (this.d != null) {
            for (Map.Entry<String, b> entry : this.d.entrySet()) {
                if (entry != null) {
                    b((a) null, entry.getKey());
                    entry.getValue().c = null;
                    entry.getValue().e.e = "STATUS";
                    entry.getValue().e.g = 0;
                    b(entry.getValue());
                    MediaPlayer mediaPlayer = entry.getValue().b;
                    if (mediaPlayer != null) {
                        try {
                            mediaPlayer.release();
                        } catch (Exception e) {
                            System.out.println("player release Exception");
                        }
                    }
                }
            }
            this.d.clear();
        }
    }

    public void b(com.baidu.baiduarsdk.a.a.e eVar, final HashMap<String, Object> hashMap) {
        a(1024, hashMap);
        a(new a() { // from class: com.baidu.baiduarsdk.a.e.9
        }, eVar.a());
    }

    public void b(a aVar, String str) {
        b a2 = a(str);
        if (a2 != null) {
            a2.e.e = "STATUS";
            a2.e.g = 0;
            b(a2);
        }
        MediaPlayer d = d(str);
        if (d != null) {
            com.baidu.baiduarsdk.a.a.a(d);
            e(str);
        }
    }

    public SurfaceTexture c(String str) {
        if (this.d == null) {
            return null;
        }
        b bVar = this.d.get(str);
        return bVar != null ? bVar.c : null;
    }

    public void c() {
        if (this.f != null) {
            this.f.cancel();
            this.f.purge();
            this.f = null;
            if (this.g != null) {
                this.g.cancel();
                this.g = null;
            }
        }
        b();
        e();
    }

    public void c(com.baidu.baiduarsdk.a.a.e eVar, final HashMap<String, Object> hashMap) {
        a(ArBridge.MessageType.MSG_TYPE_VIDEO_RESUME_RES, hashMap);
        c(new a() { // from class: com.baidu.baiduarsdk.a.e.10
        }, eVar.a());
    }

    public void c(a aVar, String str) {
        MediaPlayer d = d(str);
        b a2 = a(str);
        if (d != null) {
            d.start();
            if (a2 != null) {
                a2.e.e = "STATUS";
                a2.e.g = 2;
                b(a2);
            }
        }
    }

    public void d(com.baidu.baiduarsdk.a.a.e eVar, final HashMap<String, Object> hashMap) {
        a(ArBridge.MessageType.MSG_TYPE_VIDEO_STOP_RES, hashMap);
        b(new a() { // from class: com.baidu.baiduarsdk.a.e.2
        }, eVar.a());
    }
}
