package com.baidu.swan.games.audio.b;

import android.media.SoundPool;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class d extends SoundPool implements SoundPool.OnLoadCompleteListener {
    private int baA;
    private ConcurrentHashMap<String, Integer> bay;
    private ConcurrentHashMap<Integer, c> baz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d() {
        super(10, 3, 0);
        this.bay = new ConcurrentHashMap<>();
        this.baz = new ConcurrentHashMap<>();
        setOnLoadCompleteListener(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c P(long j) {
        return new c(this, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ib(String str) {
        return this.bay.containsKey(str);
    }

    private void J(String str, int i) {
        this.bay.put(str, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int ic(String str) {
        return this.bay.get(str).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, c cVar) {
        this.baz.put(Integer.valueOf(i), cVar);
    }

    public boolean Ny() {
        return 200 <= this.baA;
    }

    @Override // android.media.SoundPool.OnLoadCompleteListener
    public void onLoadComplete(SoundPool soundPool, int i, int i2) {
        c remove = this.baz.remove(Integer.valueOf(i));
        if (remove != null) {
            if (i2 == 0) {
                J(remove.Nx(), i);
                if (!remove.isPaused()) {
                    remove.play();
                }
                int Nw = remove.Nw();
                if (this.baA < Nw) {
                    this.baA = Nw;
                    return;
                }
                return;
            }
            remove.I(i2, i2);
        }
    }
}
