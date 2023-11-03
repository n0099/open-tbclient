package com.baidu.nadcore.player.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tieba.R;
import com.baidu.tieba.ex0;
import com.baidu.tieba.ix0;
/* loaded from: classes3.dex */
public class BdThumbSeekBarView extends View {
    public BdSeeBarStatus a;
    public final Paint b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public Bitmap h;
    public final int i;
    public Bitmap j;
    public boolean k;
    public float l;
    public float m;
    public int n;
    public final Paint o;
    public final Paint p;
    public final BdSeekBarStyle q;
    public b r;
    public final RectF s;
    public SeekBarDirect t;
    public boolean u;

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
        void a(BdThumbSeekBarView bdThumbSeekBarView);

        void b(BdThumbSeekBarView bdThumbSeekBarView, int i, boolean z);

        void c(BdThumbSeekBarView bdThumbSeekBarView);
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

    public BdThumbSeekBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, BdSeekBarStyle.LINE, 1);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        e();
        setMeasuredDimension(c(i), b(i2));
        a();
    }

    public BdThumbSeekBarView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, BdSeekBarStyle.LINE, 1);
    }

    public BdThumbSeekBarView(Context context, AttributeSet attributeSet, int i, BdSeekBarStyle bdSeekBarStyle, int i2) {
        super(context, attributeSet, i);
        this.a = BdSeeBarStatus.None;
        this.k = true;
        this.t = SeekBarDirect.Horizontal;
        this.u = true;
        setClickable(true);
        this.q = bdSeekBarStyle;
        Paint paint = new Paint();
        this.b = paint;
        paint.setAntiAlias(true);
        this.b.setColor(getResources().getColor(R.color.nad_bdvideoplayer_seek_bar_bg_color));
        Paint paint2 = new Paint();
        this.o = paint2;
        paint2.setAntiAlias(true);
        this.o.setColor(getResources().getColor(R.color.nad_bdvideoplayer_seek_bar_played_color));
        Paint paint3 = new Paint();
        this.p = paint3;
        paint3.setAntiAlias(true);
        this.p.setColor(getResources().getColor(R.color.nad_bdvideoplayer_seek_bar_buffered_color));
        this.l = 100.0f;
        this.m = 0.0f;
        this.n = 0;
        if (this.h == null) {
            this.h = BitmapFactory.decodeResource(context.getResources(), R.drawable.nad_bdvideoplayer_seekbar_thumb);
        }
        this.i = ex0.a(this, 0.0f);
        if (this.j == null) {
            d(1.5f);
        }
        this.s = new RectF();
        float f = getResources().getDisplayMetrics().density;
        this.c = (int) (0.0f * f);
        this.d = (int) (5.0f * f);
        this.e = (int) ((i2 * f) + 0.5d);
        this.f = (int) (50.0f * f);
        this.g = (int) (f * 3.0f);
        ix0.b(com.baidu.searchbox.player.widget.BdThumbSeekBarView.TAG, "mUITraceHeight: " + this.e);
    }

    public BdThumbSeekBarView(Context context, AttributeSet attributeSet, BdSeekBarStyle bdSeekBarStyle, int i) {
        this(context, attributeSet, 0, bdSeekBarStyle, i);
    }

    public final void a() {
        int i = a.a[this.q.ordinal()];
        if (i != 1) {
            if (i == 2) {
                this.s.top = (((getMeasuredHeight() - this.g) + getPaddingTop()) - getPaddingBottom()) >> 1;
                RectF rectF = this.s;
                rectF.bottom = rectF.top + this.g;
            }
        } else if (this.t == SeekBarDirect.Horizontal) {
            this.s.left = getPaddingLeft();
            this.s.right = getMeasuredWidth() - getPaddingRight();
            this.s.top = (((getMeasuredHeight() - this.e) + getPaddingTop()) - getPaddingBottom()) >> 1;
            RectF rectF2 = this.s;
            rectF2.bottom = rectF2.top + this.e;
        } else {
            this.s.top = getPaddingTop();
            this.s.bottom = getMeasuredHeight() - getPaddingBottom();
            this.s.left = (((getMeasuredWidth() - this.e) + getPaddingLeft()) - getPaddingRight()) >> 1;
            RectF rectF3 = this.s;
            rectF3.right = rectF3.left + this.e;
        }
    }

    public final int b(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int height = this.h.getHeight() + getPaddingTop() + getPaddingBottom();
        if (mode == Integer.MIN_VALUE) {
            if (height > size) {
                d(((size - getPaddingTop()) - getPaddingBottom()) / this.h.getHeight());
                return size;
            }
        } else if (mode == 1073741824) {
            if (height > size) {
                d(((size - getPaddingTop()) - getPaddingBottom()) / this.h.getHeight());
                return size;
            }
            return size;
        }
        return height;
    }

    public final int c(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int width = this.h.getWidth() + getPaddingLeft() + getPaddingRight();
        int i2 = this.f;
        int i3 = width + i2;
        if (mode == Integer.MIN_VALUE) {
            if (i3 - i2 > size) {
                d(((size - getPaddingLeft()) - getPaddingRight()) / this.h.getWidth());
                return size;
            }
        } else if (mode == 1073741824) {
            if (i3 - i2 > size) {
                d(((size - getPaddingLeft()) - getPaddingRight()) / this.h.getHeight());
                return size;
            }
            return size;
        }
        return i3;
    }

    public final void d(float f) {
        if (f > 0.0f) {
            Matrix matrix = new Matrix();
            matrix.postScale(f, f);
            Bitmap bitmap = this.h;
            this.j = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.h.getHeight(), matrix, true);
        }
    }

    public void setBufferColor(int i) {
        Paint paint = this.p;
        if (paint != null) {
            paint.setColor(i);
        }
    }

    public void setBufferingProgress(int i) {
        this.n = i;
    }

    public void setDragable(boolean z) {
        this.u = z;
    }

    public void setMax(float f) {
        this.l = f;
    }

    public void setMaxDuration(int i) {
        setMax(i);
    }

    public void setOnSeekBarChangeListener(b bVar) {
        this.r = bVar;
    }

    public void setProgress(float f) {
        this.m = f;
        invalidate();
    }

    public void setProgressBackgroundColor(int i) {
        this.b.setColor(i);
    }

    public void setProgressColor(int i) {
        this.o.setColor(i);
    }

    public void setScaleThumbBitmap(Bitmap bitmap) {
        this.j = bitmap;
    }

    public void setSeekBarDirect(SeekBarDirect seekBarDirect) {
        this.t = seekBarDirect;
    }

    public void setThumbBitmap(Bitmap bitmap) {
        this.h = bitmap;
    }

    public void setThumbScaleVisible(boolean z) {
        this.k = z;
    }

    public final void e() {
        int paddingLeft = getPaddingLeft();
        if (paddingLeft <= 0) {
            paddingLeft = this.c;
        }
        int paddingTop = getPaddingTop();
        if (paddingTop <= 0) {
            paddingTop = this.c;
        }
        int paddingRight = getPaddingRight();
        if (paddingRight <= 0) {
            if (this.k) {
                paddingRight = this.c + this.d;
            } else {
                paddingRight = this.c;
            }
        }
        int paddingBottom = getPaddingBottom();
        if (paddingBottom <= 0) {
            paddingBottom = this.c;
        }
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public float getMax() {
        return this.l;
    }

    public int getProgress() {
        return (int) this.m;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x017e  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onDraw(Canvas canvas) {
        float f;
        float width;
        float f2;
        int i;
        int i2;
        Bitmap bitmap;
        int i3 = a.a[this.q.ordinal()];
        float f3 = 0.0f;
        if (i3 != 1) {
            if (i3 == 2) {
                this.b.setColor(com.baidu.searchbox.player.widget.BdThumbSeekBarView.UI_TRACE_COLOR);
                canvas.drawRoundRect(this.s, i >> 1, this.g, this.b);
                this.b.setColor(com.baidu.searchbox.player.widget.BdThumbSeekBarView.UI_SELECT_COLOR_START);
                float f4 = this.l;
                if (f4 > 0.1f) {
                    float f5 = this.m;
                    RectF rectF = this.s;
                    f3 = (f5 * (rectF.right - rectF.left)) / f4;
                }
                RectF rectF2 = this.s;
                rectF2.right = rectF2.left + f3;
                canvas.drawRoundRect(rectF2, i2 >> 1, this.g, this.b);
                canvas.drawBitmap(this.h, this.s.right - (bitmap.getWidth() >> 1), (int) (this.s.top + ((this.g - this.h.getHeight()) >> 1)), (Paint) null);
            }
        } else {
            if (this.k) {
                this.b.setColor(com.baidu.searchbox.player.widget.BdThumbSeekBarView.UI_DRAG_TRACE_COLOR);
            }
            canvas.drawRect(this.s, this.b);
            RectF rectF3 = this.s;
            float f6 = rectF3.left;
            float abs = Math.abs(rectF3.right - f6);
            RectF rectF4 = this.s;
            float abs2 = Math.abs(rectF4.top - rectF4.bottom);
            if (this.t == SeekBarDirect.Horizontal) {
                if (this.l > 0.1f) {
                    f2 = (this.n * abs) / 100.0f;
                } else {
                    f2 = 0.0f;
                }
                RectF rectF5 = this.s;
                rectF5.right = rectF5.left + f2;
            } else {
                if (this.l > 0.1f) {
                    f = this.n;
                } else {
                    f = 0.0f;
                }
                RectF rectF6 = this.s;
                rectF6.top = rectF6.bottom - f;
            }
            canvas.drawRect(this.s, this.p);
            if (this.t == SeekBarDirect.Horizontal) {
                float f7 = this.l;
                if (f7 > 0.1f) {
                    f3 = (this.m * abs) / f7;
                }
                RectF rectF7 = this.s;
                rectF7.right = rectF7.left + f3;
            } else {
                float f8 = this.l;
                if (f8 > 0.1f) {
                    f3 = (this.m * abs2) / f8;
                }
                RectF rectF8 = this.s;
                rectF8.top = rectF8.bottom - f3;
            }
            canvas.drawRect(this.s, this.o);
            if (this.k) {
                if (this.t == SeekBarDirect.Horizontal) {
                    int width2 = (int) (this.s.right - (this.h.getWidth() >> 1));
                    int i4 = this.i;
                    if (width2 < (-i4) + f6) {
                        width = (-i4) + f6;
                    } else {
                        float f9 = abs + f6;
                        if ((this.h.getWidth() + width2) - this.i > f9) {
                            width = (f9 - this.h.getWidth()) + this.i;
                        }
                        if (this.a != BdSeeBarStatus.Seek) {
                            canvas.drawBitmap(this.j, width2, ((((getMeasuredHeight() - this.j.getHeight()) + getPaddingTop()) - getPaddingBottom()) >> 1) + ((int) (0 * 1.5f)), (Paint) null);
                        } else {
                            canvas.drawBitmap(this.h, Math.max(width2, -this.i), ((((getMeasuredHeight() - this.h.getHeight()) + getPaddingTop()) - getPaddingBottom()) >> 1) + 0, (Paint) null);
                        }
                    }
                    width2 = (int) width;
                    if (this.a != BdSeeBarStatus.Seek) {
                    }
                } else {
                    int height = (int) (this.s.top - (this.h.getHeight() >> 1));
                    if (this.a == BdSeeBarStatus.Seek) {
                        canvas.drawBitmap(this.j, (((getMeasuredWidth() - this.j.getWidth()) + getPaddingLeft()) - getPaddingRight()) >> 1, height, (Paint) null);
                    } else {
                        canvas.drawBitmap(this.h, (((getMeasuredWidth() - this.h.getWidth()) + getPaddingLeft()) - getPaddingRight()) >> 1, height, (Paint) null);
                    }
                }
            }
        }
        a();
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
        if (!this.u) {
            return true;
        }
        if (this.t == SeekBarDirect.Horizontal) {
            float x = motionEvent.getX();
            RectF rectF = this.s;
            float f = rectF.left;
            if (x < f) {
                x = f;
            } else {
                float f2 = rectF.right;
                if (x > f2) {
                    x = f2;
                }
            }
            RectF rectF2 = this.s;
            float f3 = rectF2.left;
            setProgress(((x - f3) * this.l) / (rectF2.right - f3));
        } else {
            float y = motionEvent.getY();
            RectF rectF3 = this.s;
            float f4 = rectF3.top;
            if (y < f4) {
                y = f4;
            } else {
                float f5 = rectF3.bottom;
                if (y > f5) {
                    y = f5;
                }
            }
            RectF rectF4 = this.s;
            float f6 = rectF4.bottom;
            setProgress(((f6 - y) * this.l) / (f6 - rectF4.top));
        }
        b bVar = this.r;
        if (bVar != null) {
            this.a = BdSeeBarStatus.Seek;
            bVar.b(this, (int) this.m, true);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
            }
            b bVar2 = this.r;
            if (bVar2 != null) {
                bVar2.c(this);
                this.a = BdSeeBarStatus.None;
            }
            getParent().requestDisallowInterceptTouchEvent(false);
        } else {
            b bVar3 = this.r;
            if (bVar3 != null) {
                bVar3.a(this);
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
