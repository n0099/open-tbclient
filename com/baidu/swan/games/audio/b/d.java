package com.baidu.swan.games.audio.b;

import android.media.SoundPool;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class d extends SoundPool implements SoundPool.OnLoadCompleteListener {
    private ConcurrentHashMap<String, Integer> baB;
    private ConcurrentHashMap<Integer, c> baC;
    private int baD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d() {
        super(10, 3, 0);
        this.baB = new ConcurrentHashMap<>();
        this.baC = new ConcurrentHashMap<>();
        setOnLoadCompleteListener(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c P(long j) {
        return new c(this, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ic(String str) {
        return this.baB.containsKey(str);
    }

    private void J(String str, int i) {
        this.baB.put(str, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int ie(String str) {
        return this.baB.get(str).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, c cVar) {
        this.baC.put(Integer.valueOf(i), cVar);
    }

    public boolean Nw() {
        return 200 <= this.baD;
    }

    @Override // android.media.SoundPool.OnLoadCompleteListener
    public void onLoadComplete(SoundPool soundPool, int i, int i2) {
        c remove = this.baC.remove(Integer.valueOf(i));
        if (remove != null) {
            if (i2 == 0) {
                J(remove.Nv(), i);
                if (!remove.isPaused()) {
                    remove.play();
                }
                int Nu = remove.Nu();
                if (this.baD < Nu) {
                    this.baD = Nu;
                    return;
                }
                return;
            }
            remove.I(i2, i2);
        }
    }
}
