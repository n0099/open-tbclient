package com.baidu.swan.apps.res.ui.wheelview3d;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.wheelview3d.a.c;
import com.baidu.swan.apps.res.ui.wheelview3d.c.b;
import com.baidu.swan.apps.runtime.e;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class WheelView3d extends View {
    private static final int[] dAI = {-1, 452984831};
    private float centerY;
    private int change;
    private Context context;
    private float dAA;
    private int dAB;
    private int dAC;
    private int dAD;
    private float dAE;
    private Drawable dAF;
    private Drawable dAG;
    private Paint dAH;
    private int dAJ;
    private ScheduledExecutorService dAa;
    private ScheduledFuture<?> dAb;
    private Paint dAc;
    private Paint dAd;
    private Paint dAe;
    private c dAf;
    private int dAg;
    private int dAh;
    private int dAi;
    private int dAj;
    private int dAk;
    private float dAl;
    private int dAm;
    private int dAn;
    private int dAo;
    private float dAp;
    private boolean dAq;
    private float dAr;
    private float dAs;
    private float dAt;
    private int dAu;
    private int dAv;
    private int dAw;
    private int dAx;
    private int dAy;
    private int dAz;
    private DividerType dzW;
    private b dzX;
    private boolean dzY;
    private boolean dzZ;
    private GestureDetector gestureDetector;
    private Handler handler;
    private String label;
    private int mGravity;
    private int mOffset;
    private int radius;
    private long startTime;
    private Typeface typeface;

    /* loaded from: classes9.dex */
    public enum ACTION {
        CLICK,
        FLING,
        DAGGLE
    }

    /* loaded from: classes9.dex */
    public enum DividerType {
        FILL,
        WRAP
    }

    public WheelView3d(Context context) {
        this(context, null);
    }

    public WheelView3d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dzY = false;
        this.dzZ = true;
        this.dAa = Executors.newSingleThreadScheduledExecutor();
        this.typeface = Typeface.SANS_SERIF;
        this.dAp = 1.6f;
        this.dAx = 5;
        this.mOffset = 0;
        this.dAA = 0.0f;
        this.startTime = 0L;
        this.mGravity = 17;
        this.dAC = 0;
        this.dAD = 0;
        this.dAJ = 0;
        this.dAg = 20;
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.dAE = 2.4f;
        } else if (1.0f <= f && f < 2.0f) {
            this.dAE = 3.6f;
        } else if (1.0f <= f && f < 2.0f) {
            this.dAE = 4.5f;
        } else if (2.0f <= f && f < 3.0f) {
            this.dAE = 6.0f;
        } else if (f >= 3.0f) {
            this.dAE = f * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.pickerview, 0, 0);
            this.mGravity = obtainStyledAttributes.getInt(a.j.pickerview_wheelview_gravity, 17);
            this.dAm = obtainStyledAttributes.getColor(a.j.pickerview_wheelview_textColorOut, -5723992);
            this.dAn = obtainStyledAttributes.getColor(a.j.pickerview_wheelview_textColorCenter, -14013910);
            this.dAo = obtainStyledAttributes.getColor(a.j.pickerview_wheelview_dividerColor, -2763307);
            this.dAg = obtainStyledAttributes.getDimensionPixelOffset(a.j.pickerview_wheelview_textSize, this.dAg);
            this.dAp = obtainStyledAttributes.getFloat(a.j.pickerview_wheelview_lineSpacingMultiplier, this.dAp);
            obtainStyledAttributes.recycle();
        }
        aHz();
        dh(context);
    }

    private void aHz() {
        if (this.dAp < 1.0f) {
            this.dAp = 1.0f;
        } else if (this.dAp > 4.0f) {
            this.dAp = 4.0f;
        }
    }

    private void dh(Context context) {
        this.context = context;
        this.handler = new com.baidu.swan.apps.res.ui.wheelview3d.d.b(this);
        this.gestureDetector = new GestureDetector(context, new com.baidu.swan.apps.res.ui.wheelview3d.c.a(this));
        this.gestureDetector.setIsLongpressEnabled(false);
        this.dAq = true;
        this.dAt = 0.0f;
        this.dAu = -1;
        this.dAF = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, dAI);
        this.dAG = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, dAI);
        aHA();
    }

    private void aHA() {
        this.dAc = new Paint();
        this.dAc.setColor(this.dAm);
        this.dAc.setAntiAlias(true);
        this.dAc.setTypeface(this.typeface);
        this.dAc.setTextSize(this.dAg);
        this.dAd = new Paint();
        this.dAd.setColor(this.dAn);
        this.dAd.setAntiAlias(true);
        this.dAd.setTextScaleX(1.1f);
        this.dAd.setTypeface(this.typeface);
        this.dAd.setTextSize(this.dAg);
        this.dAe = new Paint();
        this.dAe.setColor(this.dAo);
        this.dAe.setAntiAlias(true);
        this.dAH = new Paint();
        this.dAH.setColor(-460552);
        setLayerType(1, null);
    }

    private void aHB() {
        if (this.dAf != null) {
            aHC();
            int i = (int) (this.dAl * (this.dAx - 1));
            this.dAy = (int) ((i * 2) / 3.141592653589793d);
            this.radius = (int) (i / 3.141592653589793d);
            this.dAz = View.MeasureSpec.getSize(this.dAB);
            this.dAr = (this.dAy - this.dAl) / 2.0f;
            this.dAs = (this.dAy + this.dAl) / 2.0f;
            this.centerY = (this.dAs - ((this.dAl - this.dAj) / 2.0f)) - this.dAE;
            if (this.dAu == -1) {
                if (this.dAq) {
                    this.dAu = (this.dAf.getItemsCount() + 1) / 2;
                } else {
                    this.dAu = 0;
                }
            }
            this.dAw = this.dAu;
        }
    }

    private void aHC() {
        Rect rect = new Rect();
        for (int i = 0; i < this.dAf.getItemsCount(); i++) {
            String Y = Y(this.dAf.getItem(i));
            this.dAd.getTextBounds(Y, 0, Y.length(), rect);
            int width = rect.width();
            if (width > this.dAi) {
                this.dAi = width;
            }
            this.dAd.getTextBounds("星期", 0, 2, rect);
            this.dAj = rect.height() + 2;
        }
        this.dAl = this.dAp * this.dAj;
    }

    public void a(ACTION action) {
        aHD();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            this.mOffset = (int) (((this.dAt % this.dAl) + this.dAl) % this.dAl);
            if (this.mOffset > this.dAl / 2.0f) {
                this.mOffset = (int) (this.dAl - this.mOffset);
            } else {
                this.mOffset = -this.mOffset;
            }
        }
        this.dAb = this.dAa.scheduleWithFixedDelay(new com.baidu.swan.apps.res.ui.wheelview3d.d.c(this, this.mOffset), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public final void N(float f) {
        aHD();
        this.dAb = this.dAa.scheduleWithFixedDelay(new com.baidu.swan.apps.res.ui.wheelview3d.d.a(this, f), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public void aHD() {
        if (this.dAb != null && !this.dAb.isCancelled()) {
            this.dAb.cancel(true);
            this.dAb = null;
        }
    }

    public final void setCyclic(boolean z) {
        this.dAq = z;
    }

    public final void setTypeface(Typeface typeface) {
        this.typeface = typeface;
        this.dAc.setTypeface(this.typeface);
        this.dAd.setTypeface(this.typeface);
    }

    public final void setCenterTextSize(int i) {
        if (i > 0.0f) {
            this.dAg = i;
            this.dAd.setTextSize(i);
        }
    }

    public final void setOuterTextSize(int i) {
        if (i > 0.0f) {
            this.dAh = i;
            this.dAc.setTextSize(i);
        }
    }

    public final void setCurrentItem(int i) {
        this.dAv = i;
        this.dAu = i;
        this.dAt = 0.0f;
        invalidate();
    }

    public final void setOnItemSelectedListener(b bVar) {
        this.dzX = bVar;
    }

    public final void setAdapter(c cVar) {
        this.dAf = cVar;
        aHB();
        invalidate();
    }

    public final c getAdapter() {
        return this.dAf;
    }

    public final int getCurrentItem() {
        if (this.dAf == null) {
            return 0;
        }
        if (this.dAq && (this.dAv < 0 || this.dAv >= this.dAf.getItemsCount())) {
            return Math.max(0, Math.min(Math.abs(Math.abs(this.dAv) - this.dAf.getItemsCount()), this.dAf.getItemsCount() - 1));
        }
        return Math.max(0, Math.min(this.dAv, this.dAf.getItemsCount() - 1));
    }

    public final void aHE() {
        if (this.dzX != null) {
            postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d.1
                @Override // java.lang.Runnable
                public void run() {
                    WheelView3d.this.dzX.a(WheelView3d.this, WheelView3d.this.getCurrentItem());
                }
            }, 200L);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String Y;
        int i;
        if (this.dAf != null) {
            this.dAu = Math.min(Math.max(0, this.dAu), this.dAf.getItemsCount() - 1);
            Object[] objArr = new Object[this.dAx];
            this.change = (int) (this.dAt / this.dAl);
            try {
                this.dAw = this.dAu + (this.change % this.dAf.getItemsCount());
            } catch (ArithmeticException e) {
                if (e.DEBUG) {
                    Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
                }
            }
            if (!this.dAq) {
                if (this.dAw < 0) {
                    this.dAw = 0;
                }
                if (this.dAw > this.dAf.getItemsCount() - 1) {
                    this.dAw = this.dAf.getItemsCount() - 1;
                }
            } else {
                if (this.dAw < 0) {
                    this.dAw = this.dAf.getItemsCount() + this.dAw;
                }
                if (this.dAw > this.dAf.getItemsCount() - 1) {
                    this.dAw -= this.dAf.getItemsCount();
                }
            }
            float f = this.dAt % this.dAl;
            for (int i2 = 0; i2 < this.dAx; i2++) {
                int i3 = this.dAw - ((this.dAx / 2) - i2);
                if (this.dAq) {
                    objArr[i2] = this.dAf.getItem(iK(i3));
                } else if (i3 < 0) {
                    objArr[i2] = "";
                } else if (i3 > this.dAf.getItemsCount() - 1) {
                    objArr[i2] = "";
                } else {
                    objArr[i2] = this.dAf.getItem(i3);
                }
            }
            if (this.dzW == DividerType.WRAP) {
                float f2 = TextUtils.isEmpty(this.label) ? ((this.dAz - this.dAi) / 2) - 12 : ((this.dAz - this.dAi) / 4) - 12;
                if (f2 <= 0.0f) {
                    f2 = 10.0f;
                }
                float f3 = this.dAz - f2;
                canvas.drawLine(f2, this.dAr, f3, this.dAr, this.dAe);
                canvas.drawLine(f2, this.dAs, f3, this.dAs, this.dAe);
            } else {
                canvas.drawLine(0.0f, this.dAr, this.dAz, this.dAr, this.dAe);
                canvas.drawLine(0.0f, this.dAs, this.dAz, this.dAs, this.dAe);
            }
            canvas.drawRect(0.0f, this.dAr, this.dAz, this.dAs, this.dAH);
            if (!TextUtils.isEmpty(this.label) && this.dzZ) {
                canvas.drawText(this.label, (this.dAz - getTextWidth(this.dAd, this.label)) - this.dAE, this.centerY, this.dAd);
            }
            for (int i4 = 0; i4 < this.dAx; i4++) {
                canvas.save();
                double d = ((this.dAl * i4) - f) / this.radius;
                float f4 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
                if (f4 >= 90.0f || f4 <= -90.0f) {
                    canvas.restore();
                } else {
                    float pow = (float) Math.pow(Math.abs(f4) / 90.0f, 2.2d);
                    if (!this.dzZ && !TextUtils.isEmpty(this.label) && !TextUtils.isEmpty(Y(objArr[i4]))) {
                        Y = Y(objArr[i4]) + this.label;
                    } else {
                        Y = Y(objArr[i4]);
                    }
                    String ro = ro(Y);
                    rp(ro);
                    rq(ro);
                    float cos = (float) ((this.radius - (Math.cos(d) * this.radius)) - ((Math.sin(d) * this.dAj) / 2.0d));
                    canvas.translate(0.0f, cos);
                    if (cos <= this.dAr && this.dAj + cos >= this.dAr) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.dAz, this.dAr - cos);
                        canvas.drawText(ro, this.dAD, this.dAj, this.dAc);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.dAr - cos, this.dAz, (int) this.dAl);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(ro, this.dAC, this.dAj - this.dAE, this.dAd);
                        canvas.restore();
                    } else if (cos <= this.dAs && this.dAj + cos >= this.dAs) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.dAz, this.dAs - cos);
                        canvas.drawText(ro, this.dAC, this.dAj - this.dAE, this.dAd);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.dAs - cos, this.dAz, (int) this.dAl);
                        canvas.drawText(ro, this.dAD, this.dAj, this.dAc);
                        canvas.restore();
                    } else if (cos >= this.dAr && cos + this.dAj <= this.dAs) {
                        canvas.drawText(ro, this.dAC, this.dAj - this.dAE, this.dAd);
                        this.dAv = this.dAw - ((this.dAx / 2) - i4);
                    } else {
                        canvas.save();
                        canvas.clipRect(0, 0, this.dAz, (int) this.dAl);
                        Paint paint = this.dAc;
                        if (this.dAk == 0) {
                            i = 0;
                        } else {
                            i = this.dAk > 0 ? 1 : -1;
                        }
                        paint.setTextSkewX((f4 > 0.0f ? -1 : 1) * i * 0.0f * pow);
                        this.dAc.setAlpha((int) ((1.0f - pow) * 255.0f));
                        canvas.drawText(ro, this.dAD + (this.dAk * pow), this.dAj, this.dAc);
                        canvas.restore();
                    }
                    canvas.restore();
                    this.dAd.setTextSize(this.dAg);
                }
            }
            a(this.dAF, canvas, 0, (int) this.dAr);
            a(this.dAG, canvas, (int) this.dAs, this.dAy);
        }
    }

    private String ro(String str) {
        float[] fArr = {0.0f};
        Rect rect = new Rect();
        this.dAd.getTextBounds(str, 0, str.length(), rect);
        if (rect.width() > this.dAz) {
            return str.substring(0, this.dAd.breakText(str, 0, str.length(), true, this.dAz, fArr) - 2) + StringHelper.STRING_MORE;
        }
        return str;
    }

    private int iK(int i) {
        if (i < 0) {
            return iK(this.dAf.getItemsCount() + i);
        }
        if (i > this.dAf.getItemsCount() - 1) {
            return iK(i - this.dAf.getItemsCount());
        }
        return i;
    }

    private String Y(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof com.baidu.swan.apps.res.ui.wheelview3d.b.a) {
            return ((com.baidu.swan.apps.res.ui.wheelview3d.b.a) obj).aHG();
        }
        return obj instanceof Integer ? String.format(Locale.getDefault(), "%02d", Integer.valueOf(((Integer) obj).intValue())) : obj.toString();
    }

    private void rp(String str) {
        Rect rect = new Rect();
        this.dAd.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.dAC = this.dAJ;
                return;
            case 5:
                this.dAC = ((this.dAz - rect.width()) - ((int) this.dAE)) - this.dAJ;
                return;
            case 17:
                if (this.dzY || this.label == null || this.label.equals("") || !this.dzZ) {
                    this.dAC = (int) (((this.dAz - rect.width()) - this.dAJ) * 0.5d);
                    return;
                } else {
                    this.dAC = (int) (((this.dAz - rect.width()) - this.dAJ) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    private void rq(String str) {
        Rect rect = new Rect();
        this.dAc.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.dAD = this.dAJ;
                return;
            case 5:
                this.dAD = ((this.dAz - rect.width()) - ((int) this.dAE)) - this.dAJ;
                return;
            case 17:
                if (this.dzY || this.label == null || this.label.equals("") || !this.dzZ) {
                    this.dAD = (int) (((this.dAz - rect.width()) - this.dAJ) * 0.5d);
                    return;
                } else {
                    this.dAD = (int) (((this.dAz - rect.width()) - this.dAJ) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.dAB = i;
        aHB();
        setMeasuredDimension(this.dAz, this.dAy);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        boolean onTouchEvent = this.gestureDetector.onTouchEvent(motionEvent);
        float f = (-this.dAu) * this.dAl;
        float itemsCount = ((this.dAf.getItemsCount() - 1) - this.dAu) * this.dAl;
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                aHD();
                this.dAA = motionEvent.getRawY();
                break;
            case 1:
            default:
                if (!onTouchEvent) {
                    float y = motionEvent.getY();
                    this.mOffset = (int) (((((int) (((Math.acos((this.radius - y) / this.radius) * this.radius) + (this.dAl / 2.0f)) / this.dAl)) - (this.dAx / 2)) * this.dAl) - (((this.dAt % this.dAl) + this.dAl) % this.dAl));
                    if (System.currentTimeMillis() - this.startTime > 120) {
                        a(ACTION.DAGGLE);
                        break;
                    } else {
                        a(ACTION.CLICK);
                        break;
                    }
                }
                break;
            case 2:
                float rawY = this.dAA - motionEvent.getRawY();
                this.dAA = motionEvent.getRawY();
                this.dAt += rawY;
                if (!this.dAq && ((this.dAt - (this.dAl * 0.25f) < f && rawY < 0.0f) || (this.dAt + (0.25f * this.dAl) > itemsCount && rawY > 0.0f))) {
                    this.dAt -= rawY;
                    z = true;
                    break;
                }
                break;
        }
        if (!z && motionEvent.getAction() != 0) {
            invalidate();
        }
        return true;
    }

    public int getItemsCount() {
        if (this.dAf != null) {
            return this.dAf.getItemsCount();
        }
        return 0;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setGravity(int i) {
        this.mGravity = i;
    }

    public int getTextWidth(Paint paint, String str) {
        float[] fArr;
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        paint.getTextWidths(str, new float[length]);
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i += (int) Math.ceil(fArr[i2]);
        }
        return i;
    }

    public void setIsOptions(boolean z) {
        this.dzY = z;
    }

    public void setTextColorOut(int i) {
        this.dAm = i;
        this.dAc.setColor(this.dAm);
    }

    public void setTextColorCenter(int i) {
        this.dAn = i;
        this.dAd.setColor(this.dAn);
    }

    public void setTextXOffset(int i) {
        this.dAk = i;
        if (i != 0) {
            this.dAd.setTextScaleX(1.0f);
        }
    }

    public void setDividerColor(int i) {
        this.dAo = i;
        this.dAe.setColor(i);
    }

    public void setDividerType(DividerType dividerType) {
        this.dzW = dividerType;
    }

    public void setLineSpacingMultiplier(float f) {
        if (f != 0.0f) {
            this.dAp = f;
            aHz();
        }
    }

    public boolean aHF() {
        return this.dAq;
    }

    public float getTotalScrollY() {
        return this.dAt;
    }

    public void setTotalScrollY(float f) {
        this.dAt = f;
    }

    public float getItemHeight() {
        return this.dAl;
    }

    public int getInitPosition() {
        return this.dAu;
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.handler;
    }

    public void setVisibleItem(int i) {
        this.dAx = i;
    }

    private void a(Drawable drawable, Canvas canvas, int i, int i2) {
        drawable.setBounds(0, i, this.dAz, i2);
        drawable.draw(canvas);
    }

    public void setGravityOffset(int i) {
        this.dAJ = i;
    }

    public float getCenterContentOffset() {
        return this.dAE;
    }
}
