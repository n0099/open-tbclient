package com.baidu.nadcore.video.videoplayer.ui.full;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.searchbox.player.widget.BdThumbSeekBarView;
import com.baidu.tieba.R;
import com.baidu.tieba.e81;
import com.baidu.tieba.jc1;
/* loaded from: classes3.dex */
public class BdThumbSeekBar extends View {
    public static final int y = e81.d(0.0f);
    public static final BdSeekBarStyle z = BdSeekBarStyle.LINE;
    public BdSeeBarStatus a;
    public final int b;
    public final Context c;
    public final Paint d;
    public float e;
    public final PorterDuffXfermode f;
    public final int g;
    public final int h;
    public int i;
    public final int j;
    public Bitmap k;
    public int l;
    public Bitmap m;
    public boolean n;
    public float o;
    public float p;
    public int q;
    public final Paint r;
    public final Paint s;
    public BdSeekBarStyle t;
    public b u;
    public final RectF v;
    public SeekBarDirect w;
    public boolean x;

    /* loaded from: classes3.dex */
    public enum BdSeeBarStatus {
        None,
        Seek
    }

    /* loaded from: classes3.dex */
    public enum BdSeekBarStyle {
        LINE,
        ROUND_RECT
    }

    /* loaded from: classes3.dex */
    public enum SeekBarDirect {
        Vertical,
        Horizontal
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(BdThumbSeekBar bdThumbSeekBar, int i, boolean z);

        void b(BdThumbSeekBar bdThumbSeekBar);

        void c(BdThumbSeekBar bdThumbSeekBar);
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[BdSeekBarStyle.values().length];
            a = iArr;
            try {
                iArr[BdSeekBarStyle.LINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BdSeekBarStyle.ROUND_RECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public final void g() {
        int paddingLeft = getPaddingLeft();
        if (paddingLeft <= 0) {
            paddingLeft = this.g;
        }
        int paddingTop = getPaddingTop();
        if (paddingTop <= 0) {
            paddingTop = this.g;
        }
        int paddingRight = getPaddingRight();
        if (paddingRight <= 0) {
            if (this.n) {
                paddingRight = this.g + this.h;
            } else {
                paddingRight = this.g;
            }
        }
        int paddingBottom = getPaddingBottom();
        if (paddingBottom <= 0) {
            paddingBottom = this.g;
        }
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public float getMax() {
        return this.o;
    }

    public int getProgress() {
        return (int) this.p;
    }

    public BdThumbSeekBar(Context context, int i) {
        this(context, z, i);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        g();
        setMeasuredDimension(e(i), d(i2));
        b();
    }

    public BdThumbSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, z, 1);
    }

    public BdThumbSeekBar(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, z, 1);
    }

    public void h(int i, int i2, int i3) {
        setMax(i2);
        setBufferingProgress(i3);
        setProgress(i);
    }

    public BdThumbSeekBar(Context context, AttributeSet attributeSet, int i, BdSeekBarStyle bdSeekBarStyle, int i2) {
        super(context, attributeSet, i);
        this.a = BdSeeBarStatus.None;
        this.b = y;
        this.n = true;
        this.w = SeekBarDirect.Horizontal;
        this.x = true;
        this.c = context;
        setClickable(true);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, jc1.NadBdThumbSeekBar);
        int i3 = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
        if (i3 != 1) {
            if (i3 != 2) {
                this.t = bdSeekBarStyle;
            } else {
                this.t = BdSeekBarStyle.ROUND_RECT;
            }
        } else {
            this.t = BdSeekBarStyle.LINE;
        }
        Paint paint = new Paint();
        this.d = paint;
        paint.setAntiAlias(true);
        this.d.setColor(getResources().getColor(R.color.nad_video_seek_bar_bg_color));
        Paint paint2 = new Paint();
        this.r = paint2;
        paint2.setAntiAlias(true);
        this.r.setColor(getResources().getColor(R.color.nad_video_seek_bar_played_color));
        Paint paint3 = new Paint();
        this.s = paint3;
        paint3.setAntiAlias(true);
        this.s.setColor(getResources().getColor(R.color.nad_video_seek_bar_buffered_color));
        this.o = 100.0f;
        this.p = 0.0f;
        this.q = 0;
        if (this.c != null) {
            if (this.k == null) {
                this.k = BitmapFactory.decodeResource(context.getResources(), R.drawable.nad_videoplayer_new_player_seekbar_thumb);
            }
            this.l = e81.a(0.0f);
        }
        if (this.m == null) {
            f(1.5f);
        }
        this.v = new RectF();
        this.e = 1.5f;
        Context context2 = this.c;
        if (context2 != null) {
            this.e = context2.getResources().getDisplayMetrics().density;
        }
        float f = this.e;
        this.g = (int) (0.0f * f);
        this.h = (int) (f * 5.0f);
        setUiTraceHeight(i2);
        this.j = (int) (this.e * 50.0f);
        this.f = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    }

    public BdThumbSeekBar(Context context, AttributeSet attributeSet, BdSeekBarStyle bdSeekBarStyle, int i) {
        this(context, attributeSet, 0, bdSeekBarStyle, i);
    }

    public BdThumbSeekBar(Context context, BdSeekBarStyle bdSeekBarStyle, int i) {
        this(context, null, bdSeekBarStyle, i);
    }

    public final void a(float f, float f2) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        float f3 = this.o;
        if (f > f3) {
            f = f3;
        }
        if (this.w == SeekBarDirect.Horizontal) {
            float f4 = this.o;
            if (f4 > 0.1f) {
                f = (f * f2) / f4;
            }
            RectF rectF = this.v;
            rectF.right = rectF.left + f;
            return;
        }
        float f5 = this.o;
        if (f5 > 0.1f) {
            f = (f * f2) / f5;
        }
        RectF rectF2 = this.v;
        rectF2.top = rectF2.bottom - f;
    }

    public final void b() {
        if (this.w == SeekBarDirect.Horizontal) {
            this.v.left = getPaddingLeft();
            this.v.right = getMeasuredWidth() - getPaddingRight();
            this.v.top = (((getMeasuredHeight() - this.i) + getPaddingTop()) - getPaddingBottom()) >> 1;
            RectF rectF = this.v;
            rectF.bottom = rectF.top + this.i;
            return;
        }
        this.v.top = getPaddingTop();
        this.v.bottom = getMeasuredHeight() - getPaddingBottom();
        this.v.left = (((getMeasuredWidth() - this.i) + getPaddingLeft()) - getPaddingRight()) >> 1;
        RectF rectF2 = this.v;
        rectF2.right = rectF2.left + this.i;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(Canvas canvas, float f, float f2) {
        float width;
        if (this.n) {
            if (this.w == SeekBarDirect.Horizontal) {
                int width2 = (int) (this.v.right - (this.k.getWidth() >> 1));
                int i = this.l;
                if (width2 < (-i) + f) {
                    width = -i;
                } else {
                    float f3 = f2 + f;
                    if ((this.k.getWidth() + width2) - this.l > f3) {
                        width = f3 - this.k.getWidth();
                        f = this.l;
                    }
                    if (this.a != BdSeeBarStatus.Seek) {
                        canvas.drawBitmap(this.m, width2, ((((getMeasuredHeight() - this.m.getHeight()) + getPaddingTop()) - getPaddingBottom()) >> 1) + ((int) (this.b * 1.5f)), (Paint) null);
                        return;
                    }
                    canvas.drawBitmap(this.k, Math.max(width2, -this.l), ((((getMeasuredHeight() - this.k.getHeight()) + getPaddingTop()) - getPaddingBottom()) >> 1) + this.b, (Paint) null);
                    return;
                }
                width2 = (int) (width + f);
                if (this.a != BdSeeBarStatus.Seek) {
                }
            } else {
                int height = (int) (this.v.top - (this.k.getHeight() >> 1));
                if (this.a == BdSeeBarStatus.Seek) {
                    canvas.drawBitmap(this.m, (((getMeasuredWidth() - this.m.getWidth()) + getPaddingLeft()) - getPaddingRight()) >> 1, height, (Paint) null);
                } else {
                    canvas.drawBitmap(this.k, (((getMeasuredWidth() - this.k.getWidth()) + getPaddingLeft()) - getPaddingRight()) >> 1, height, (Paint) null);
                }
            }
        }
    }

    public final int d(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int height = this.k.getHeight() + getPaddingTop() + getPaddingBottom();
        if (mode == Integer.MIN_VALUE) {
            if (height > size) {
                f(((size - getPaddingTop()) - getPaddingBottom()) / this.k.getHeight());
                return size;
            }
        } else if (mode == 1073741824) {
            if (height > size) {
                f(((size - getPaddingTop()) - getPaddingBottom()) / this.k.getHeight());
                return size;
            }
            return size;
        }
        return height;
    }

    public final int e(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int width = this.k.getWidth() + getPaddingLeft() + getPaddingRight();
        int i2 = this.j;
        int i3 = width + i2;
        if (mode == Integer.MIN_VALUE) {
            if (i3 - i2 > size) {
                f(((size - getPaddingLeft()) - getPaddingRight()) / this.k.getWidth());
                return size;
            }
        } else if (mode == 1073741824) {
            if (i3 - i2 > size) {
                f(((size - getPaddingLeft()) - getPaddingRight()) / this.k.getHeight());
                return size;
            }
            return size;
        }
        return i3;
    }

    public final void f(float f) {
        if (f > 0.0f) {
            Matrix matrix = new Matrix();
            matrix.postScale(f, f);
            Bitmap bitmap = this.k;
            this.m = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.k.getHeight(), matrix, true);
        }
    }

    public void setBufferColor(int i) {
        Paint paint = this.s;
        if (paint != null) {
            paint.setColor(i);
        }
    }

    public void setBufferingProgress(int i) {
        this.q = i;
    }

    public void setDragable(boolean z2) {
        this.x = z2;
    }

    public void setMax(float f) {
        this.o = f;
    }

    public void setMaxDuration(int i) {
        setMax(i);
    }

    public void setOnSeekBarChangeListener(b bVar) {
        this.u = bVar;
    }

    public void setProgress(float f) {
        this.p = f;
        invalidate();
    }

    public void setProgressBackgroundColor(int i) {
        this.d.setColor(i);
    }

    public void setProgressColor(int i) {
        this.r.setColor(i);
    }

    public void setScaleThumbBitmap(Bitmap bitmap) {
        this.m = bitmap;
    }

    public void setSeekBarDirect(SeekBarDirect seekBarDirect) {
        this.w = seekBarDirect;
    }

    public void setStyle(@NonNull BdSeekBarStyle bdSeekBarStyle) {
        this.t = bdSeekBarStyle;
    }

    public void setThumbBitmap(Bitmap bitmap) {
        this.k = bitmap;
    }

    public void setThumbScaleVisible(boolean z2) {
        this.n = z2;
    }

    public void setUiTraceHeight(int i) {
        this.i = (int) ((i * this.e) + 0.5d);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float abs;
        RectF rectF = this.v;
        float f = rectF.left;
        if (this.w == SeekBarDirect.Horizontal) {
            abs = Math.abs(rectF.right - f);
        } else {
            abs = Math.abs(rectF.bottom - rectF.top);
        }
        int i = a.a[this.t.ordinal()];
        if (i != 1) {
            if (i == 2) {
                if (this.n) {
                    this.d.setColor(BdThumbSeekBarView.UI_DRAG_TRACE_COLOR);
                }
                int i2 = this.i;
                int i3 = i2 >> 1;
                int i4 = i2 >> 1;
                if (i2 < 5) {
                    i3 = 0;
                    i4 = 0;
                }
                int save = canvas.save();
                float f2 = i3;
                float f3 = i4;
                canvas.drawRoundRect(this.v, f2, f3, this.d);
                a(this.q, abs);
                canvas.drawRoundRect(this.v, f2, f3, this.s);
                a(this.p, abs);
                this.r.setXfermode(this.f);
                canvas.drawRoundRect(this.v, f2, f3, this.r);
                canvas.restoreToCount(save);
                c(canvas, f, abs);
            }
        } else {
            if (this.n) {
                this.d.setColor(BdThumbSeekBarView.UI_DRAG_TRACE_COLOR);
            }
            canvas.drawRect(this.v, this.d);
            a(this.q, abs);
            canvas.drawRect(this.v, this.s);
            a(this.p, abs);
            canvas.drawRect(this.v, this.r);
            c(canvas, f, abs);
        }
        b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0072, code lost:
        if (r6 != 3) goto L21;
     */
    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.x) {
            return true;
        }
        if (this.w == SeekBarDirect.Horizontal) {
            float x = motionEvent.getX();
            RectF rectF = this.v;
            float f = rectF.left;
            if (x < f) {
                x = f;
            } else {
                float f2 = rectF.right;
                if (x > f2) {
                    x = f2;
                }
            }
            RectF rectF2 = this.v;
            float f3 = rectF2.left;
            setProgress(((x - f3) * this.o) / (rectF2.right - f3));
        } else {
            float y2 = motionEvent.getY();
            RectF rectF3 = this.v;
            float f4 = rectF3.top;
            if (y2 < f4) {
                y2 = f4;
            } else {
                float f5 = rectF3.bottom;
                if (y2 > f5) {
                    y2 = f5;
                }
            }
            RectF rectF4 = this.v;
            float f6 = rectF4.bottom;
            setProgress(((f6 - y2) * this.o) / (f6 - rectF4.top));
        }
        b bVar = this.u;
        if (bVar != null) {
            this.a = BdSeeBarStatus.Seek;
            bVar.a(this, (int) this.p, true);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
            }
            b bVar2 = this.u;
            if (bVar2 != null) {
                bVar2.b(this);
                this.a = BdSeeBarStatus.None;
            }
            getParent().requestDisallowInterceptTouchEvent(false);
        } else {
            b bVar3 = this.u;
            if (bVar3 != null) {
                bVar3.c(this);
                this.a = BdSeeBarStatus.Seek;
            }
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        invalidate();
        return true;
    }

    public void setProgress(int i) {
        setProgress(i);
    }
}
