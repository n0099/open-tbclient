package com.baidu.location;

import android.os.Handler;
/* loaded from: classes.dex */
class al implements a0, n {
    private static al hG = null;
    private Handler hH;
    private boolean hF = false;
    private boolean hI = false;

    /* renamed from: com.baidu.location.al$2  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            al.this.hI = false;
            if (al.this.hF && az.m252do().m255int()) {
                q.y().B();
                al.this.hH.postDelayed(this, c.aV);
                al.this.hI = true;
            }
        }
    }

    private al() {
        this.hH = null;
        this.hH = new Handler();
    }

    public static al bP() {
        if (hG == null) {
            hG = new al();
        }
        return hG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bR() {
    }

    public void bO() {
        this.hH.post(new Runnable() { // from class: com.baidu.location.al.1
            @Override // java.lang.Runnable
            public void run() {
                al.this.bR();
            }
        });
    }

    public void bQ() {
        this.hF = false;
    }
}
