package com.baidu.swan.games.audio.b;

import android.media.SoundPool;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class d extends SoundPool implements SoundPool.OnLoadCompleteListener {
    private ConcurrentHashMap<String, Integer> bax;
    private ConcurrentHashMap<Integer, c> bay;
    private int baz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d() {
        super(10, 3, 0);
        this.bax = new ConcurrentHashMap<>();
        this.bay = new ConcurrentHashMap<>();
        setOnLoadCompleteListener(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c P(long j) {
        return new c(this, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ib(String str) {
        return this.bax.containsKey(str);
    }

    private void J(String str, int i) {
        this.bax.put(str, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int ic(String str) {
        return this.bax.get(str).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, c cVar) {
        this.bay.put(Integer.valueOf(i), cVar);
    }

    public boolean Ny() {
        return 200 <= this.baz;
    }

    @Override // android.media.SoundPool.OnLoadCompleteListener
    public void onLoadComplete(SoundPool soundPool, int i, int i2) {
        c remove = this.bay.remove(Integer.valueOf(i));
        if (remove != null) {
            if (i2 == 0) {
                J(remove.Nx(), i);
                if (!remove.isPaused()) {
                    remove.play();
                }
                int Nw = remove.Nw();
                if (this.baz < Nw) {
                    this.baz = Nw;
                    return;
                }
                return;
            }
            remove.I(i2, i2);
        }
    }
}
