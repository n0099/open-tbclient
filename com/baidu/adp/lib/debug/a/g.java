package com.baidu.adp.lib.debug.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.SystemClock;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f450a;
    private long b;
    private int c;
    private final Paint d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(e eVar, Context context) {
        super(context);
        this.f450a = eVar;
        this.b = -1L;
        this.c = 0;
        this.d = new Paint();
        this.d.setColor(0);
        this.d.setAlpha(0);
        this.d.setAntiAlias(true);
        this.d.setTextSize(1.0f);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.b == -1) {
            this.b = SystemClock.elapsedRealtime();
            this.c = 0;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        super.draw(canvas);
        if (elapsedRealtime - this.b > 1000) {
            this.b = elapsedRealtime;
            com.baidu.adp.lib.debug.b.a(this.c);
            this.c = 0;
        }
        this.c++;
    }
}
