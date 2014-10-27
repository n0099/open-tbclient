package com.baidu.adp.lib.debug.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.SystemClock;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends ImageView {
    final /* synthetic */ e gq;
    private int gr;
    private final Paint gs;
    private long mStartTime;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(e eVar, Context context) {
        super(context);
        this.gq = eVar;
        this.mStartTime = -1L;
        this.gr = 0;
        this.gs = new Paint();
        this.gs.setColor(0);
        this.gs.setAlpha(0);
        this.gs.setAntiAlias(true);
        this.gs.setTextSize(1.0f);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        g gVar;
        g gVar2;
        if (this.mStartTime == -1) {
            this.mStartTime = SystemClock.elapsedRealtime();
            this.gr = 0;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        super.draw(canvas);
        if (elapsedRealtime - this.mStartTime > 1000) {
            this.mStartTime = elapsedRealtime;
            gVar = this.gq.gp;
            if (gVar != null) {
                gVar2 = this.gq.gp;
                gVar2.r(this.gr);
            } else {
                com.baidu.adp.lib.debug.d.o(this.gr);
            }
            this.gr = 0;
        }
        this.gr++;
    }
}
