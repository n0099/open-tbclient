package com.baidu.nadcore.video.videoplayer.ui.full;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.baidu.tieba.R;
import com.baidu.tieba.l51;
/* loaded from: classes2.dex */
public class BdVideoPopImageView extends View {
    public static final int l = l51.a(12.0f);
    public static final int m = l51.d(30.0f);
    public static final int n = l51.a(16.0f);
    public static final int o = l51.a(9.0f) + n;
    public static final int p = l51.b(90.0f);
    public static final int q = l51.b(90.0f);
    public final Context a;
    public int b;
    public int c;
    public String d;
    public String e;
    public Paint f;
    public Drawable g;
    public Rect h;
    public int i;
    public int j;
    public Bitmap k;

    public BdVideoPopImageView(Context context) {
        super(context);
        this.b = p;
        this.c = q;
        this.d = "";
        this.e = "";
        this.i = m;
        this.j = l;
        this.a = context;
        a();
    }

    public void setBackground(int i) {
        this.g = this.a.getResources().getDrawable(i);
    }

    public void setHeight(int i) {
        this.c = i;
    }

    public void setIcon(int i) {
        this.k = BitmapFactory.decodeResource(this.a.getResources(), i);
    }

    public void setMsg(int i) {
        this.e = this.a.getResources().getString(i);
    }

    public void setMsgFontSize(int i) {
        this.j = i;
    }

    public void setTitle(String str) {
        this.d = str;
    }

    public void setTitleFontSize(int i) {
        this.i = i;
    }

    public void setWidth(int i) {
        this.b = i;
    }

    public final void a() {
        Paint paint = new Paint();
        this.f = paint;
        paint.setAntiAlias(true);
        this.f.setTextSize(l);
        this.f.setColor(-1);
        this.f.setTextAlign(Paint.Align.CENTER);
        this.h = new Rect();
        this.g = this.a.getResources().getDrawable(R.drawable.nad_videoplayer_play_pop_bg);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        Drawable drawable = this.g;
        if (drawable != null) {
            this.h.set(0, 0, measuredWidth, measuredHeight);
            drawable.setBounds(this.h);
            drawable.draw(canvas);
        }
        Bitmap bitmap = this.k;
        if (bitmap != null) {
            canvas.drawBitmap(this.k, (measuredWidth - bitmap.getWidth()) / 2, n, this.f);
        } else {
            this.f.setTextSize(this.i);
            canvas.drawText(this.d, measuredWidth >> 1, n * 2, this.f);
        }
        int i = (measuredHeight / 2) + o;
        this.f.setTextSize(this.j);
        canvas.drawText(this.e, measuredWidth >> 1, i, this.f);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(this.b, this.c);
    }

    public void setMsg(String str) {
        this.e = str;
        invalidate();
    }
}
