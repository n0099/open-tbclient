package com.baidu.adp.lib.debug.a;

import android.content.Context;
import java.io.IOException;
/* loaded from: classes.dex */
public class p extends a implements Runnable {
    private d gI;
    private m gJ;

    public p(Context context) {
        this.gI = new d(context);
        this.gJ = new m(context);
    }

    @Override // com.baidu.adp.lib.debug.a.a
    public void stop() {
        super.stop();
        this.gI.stop();
        this.gJ.stop();
    }

    @Override // java.lang.Runnable
    public void run() {
        super.start();
        while (true) {
            try {
                com.baidu.adp.lib.debug.d.M(this.gI.cK());
                com.baidu.adp.lib.debug.d.L(this.gJ.cM());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (!cJ()) {
                return;
            }
            Thread.sleep(300L);
        }
    }
}
