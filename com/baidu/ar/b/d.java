package com.baidu.ar.b;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.view.Surface;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class d {
    private static d a;
    private int b = 0;
    private boolean c = false;
    private HashMap<String, b> d = new HashMap<>();

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

        b() {
        }
    }

    private d() {
    }

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (a == null) {
                a = new d();
            }
            dVar = a;
        }
        return dVar;
    }

    private void a(a aVar, String str, String str2, int i, MediaPlayer.OnCompletionListener onCompletionListener, MediaPlayer.OnErrorListener onErrorListener, boolean z) {
        if (this.d.containsKey(str)) {
            b bVar = this.d.get(str);
            if (bVar != null) {
                try {
                    if (bVar.b != null) {
                        bVar.b.reset();
                        bVar.b.setDataSource(str2);
                        bVar.b.setLooping(z);
                        bVar.b.prepare();
                        bVar.b.start();
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
            b bVar2 = new b();
            bVar2.a = str2;
            bVar2.b = new MediaPlayer();
            bVar2.b.setDataSource(str2);
            bVar2.d = i;
            bVar2.c = new SurfaceTexture(i);
            bVar2.b.setSurface(new Surface(bVar2.c));
            bVar2.b.setOnCompletionListener(onCompletionListener);
            bVar2.b.setOnErrorListener(onErrorListener);
            bVar2.b.setLooping(z);
            bVar2.b.prepare();
            bVar2.b.start();
            this.d.put(str, bVar2);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private MediaPlayer d(String str) {
        if (this.d == null || this.d.get(str) == null) {
            return null;
        }
        return this.d.get(str).b;
    }

    public b a(String str) {
        if (this.d != null) {
            return this.d.get(str);
        }
        return null;
    }

    public void a(a aVar, String str) {
        MediaPlayer d = d(str);
        a(str);
        if (d == null || !d.isPlaying()) {
            return;
        }
        d.pause();
    }

    public void a(a aVar, String str, String str2, MediaPlayer.OnCompletionListener onCompletionListener, int i, int i2) {
        a(aVar, str, str2, i, onCompletionListener, null, i2 <= 0);
    }

    public void a(String str, int i) {
        b bVar = this.d.get(str);
        if (bVar != null) {
            bVar.c = new SurfaceTexture(i);
            bVar.b.setSurface(new Surface(bVar.c));
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
                    b(null, entry.getKey());
                    entry.getValue().c = null;
                    entry.getValue().b = null;
                }
            }
            this.d.clear();
            this.d = null;
        }
        a = null;
    }

    public void b(a aVar, String str) {
        MediaPlayer d = d(str);
        if (d == null || !d.isPlaying()) {
            return;
        }
        d.stop();
    }

    public SurfaceTexture c(String str) {
        b bVar = this.d.get(str);
        if (bVar != null) {
            return bVar.c;
        }
        return null;
    }

    public void c(a aVar, String str) {
        MediaPlayer d = d(str);
        a(str);
        if (d != null) {
            d.start();
        }
    }
}
