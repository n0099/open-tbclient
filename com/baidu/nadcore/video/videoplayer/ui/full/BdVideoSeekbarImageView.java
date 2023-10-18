package com.baidu.nadcore.video.videoplayer.ui.full;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.baidu.tieba.q21;
/* loaded from: classes3.dex */
public class BdVideoSeekbarImageView extends View {
    public static final int A;
    public static final int B;
    public static final int C;
    public static final int D;
    public static final int E;
    public static final int F;
    public static final int G;
    public static final int H;
    public static final int p = q21.a(12.0f);
    public static final int q = q21.d(30.0f);
    public static final int r = q21.a(17.0f);
    public static final int s = q21.a(13.0f);
    public static final int t = q21.a(2.0f);
    public static final int u;
    public static final int v;
    public static final int w;
    public static final int x;
    public static final int y;
    public static final int z;
    public BdThumbSeekBar a;
    public final Context b;
    public Paint c;
    public Paint d;
    public int e;
    public int f;
    public String g;
    public String h;
    public String i;
    public Drawable j;
    public Rect k;
    public int l;
    public int m;
    public Bitmap n;
    public boolean o;

    static {
        q21.a(9.0f);
        u = q21.b(90.0f);
        v = q21.b(90.0f);
        w = q21.a(77.0f);
        x = q21.a(7.0f);
        y = q21.a(1.0f);
        z = q21.a(23.0f);
        A = q21.a(21.0f);
        B = q21.a(64.0f);
        C = q21.a(34.0f);
        D = q21.a(27.0f);
        E = q21.a(25.0f);
        F = q21.a(11.0f);
        G = q21.a(9.0f);
        H = q21.a(60.0f);
    }

    public BdVideoSeekbarImageView(Context context) {
        this(context, null);
    }

    public void setBackground(int i) {
        this.j = this.b.getResources().getDrawable(i);
    }

    public void setDuration(int i) {
        BdThumbSeekBar bdThumbSeekBar = this.a;
        if (bdThumbSeekBar != null) {
            bdThumbSeekBar.setMax(i);
        }
    }

    public void setHeight(int i) {
        this.f = i;
    }

    public void setIcon(int i) {
        this.n = BitmapFactory.decodeResource(this.b.getResources(), i);
    }

    public void setIconVisible(boolean z2) {
        this.o = z2;
    }

    public void setMsgFontSize(int i) {
        this.m = i;
    }

    public void setPosition(int i) {
        BdThumbSeekBar bdThumbSeekBar = this.a;
        if (bdThumbSeekBar != null) {
            bdThumbSeekBar.setProgress(i);
        }
    }

    public void setTitle(String str) {
        this.g = str;
    }

    public void setTitleFontSize(int i) {
        this.l = i;
    }

    public void setWidth(int i) {
        this.e = i;
    }

    public BdVideoSeekbarImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = u;
        this.f = v;
        this.g = "";
        this.h = "";
        this.i = "";
        this.l = q;
        this.m = p;
        this.o = true;
        this.b = context;
        b();
    }

    public void c(int i, int i2) {
        setDuration(i2);
        setPosition(i);
        invalidate();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(this.e, this.f);
    }

    public void setMsg(String str, String str2) {
        this.h = str;
        this.i = str2;
        invalidate();
    }

    public Bitmap a(View view2) {
        view2.setDrawingCacheEnabled(true);
        view2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view2.layout(0, 0, view2.getMeasuredWidth(), view2.getMeasuredHeight());
        view2.buildDrawingCache();
        Bitmap drawingCache = view2.getDrawingCache();
        int width = drawingCache.getWidth();
        int height = drawingCache.getHeight();
        int i = w;
        Matrix matrix = new Matrix();
        matrix.postScale(i / width, x / height);
        return Bitmap.createBitmap(drawingCache, 0, 0, width, height, matrix, true);
    }

    public final void b() {
        Paint paint = new Paint();
        this.c = paint;
        paint.setAntiAlias(true);
        this.c.setTextSize(p);
        this.c.setColor(-1);
        Paint paint2 = new Paint();
        this.d = paint2;
        paint2.setAntiAlias(true);
        this.d.setTextSize(p);
        this.d.setColor(-7829368);
        this.k = new Rect();
        this.j = this.b.getResources().getDrawable(R.drawable.nad_videoplayer_play_seekbar_background);
        BdThumbSeekBar bdThumbSeekBar = new BdThumbSeekBar(this.b, y);
        this.a = bdThumbSeekBar;
        bdThumbSeekBar.setDragable(false);
        this.a.setProgressBackgroundColor(-1);
        this.a.setThumbScaleVisible(false);
    }

    public float d() {
        int i;
        int i2;
        if (this.i.length() < 6) {
            if (this.o) {
                i2 = D;
            } else {
                i2 = E;
            }
            return i2;
        }
        if (this.o) {
            i = F;
        } else {
            i = G;
        }
        return i;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        int i;
        super.onDraw(canvas);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        Drawable drawable = this.j;
        if (drawable != null) {
            this.k.set(0, 0, measuredWidth, measuredHeight);
            drawable.setBounds(this.k);
            drawable.draw(canvas);
        }
        if (this.n == null) {
            this.c.setTextSize(this.l);
            canvas.drawText(this.g, measuredWidth >> 1, r * 2, this.c);
        } else if (this.o) {
            canvas.drawBitmap(this.n, (measuredWidth - bitmap.getWidth()) / 2, r, this.c);
        }
        if (this.o) {
            i = (measuredHeight / 2) + s;
        } else {
            i = (measuredHeight / 2) - t;
        }
        this.c.setTextSize(this.m);
        float f = i;
        canvas.drawText(this.h + " ", d(), f, this.c);
        canvas.drawText("/ " + this.i, H, f, this.d);
        BdThumbSeekBar bdThumbSeekBar = this.a;
        if (bdThumbSeekBar != null) {
            Bitmap a = a(bdThumbSeekBar);
            if (this.o) {
                canvas.drawBitmap(a, z, B, this.c);
            } else {
                canvas.drawBitmap(a, A, C, this.c);
            }
        }
    }
}
