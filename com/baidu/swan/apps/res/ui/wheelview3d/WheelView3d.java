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
/* loaded from: classes8.dex */
public class WheelView3d extends View {
    private static final int[] dCj = {-1, 452984831};
    private float centerY;
    private int change;
    private Context context;
    private boolean dBA;
    private ScheduledExecutorService dBB;
    private ScheduledFuture<?> dBC;
    private Paint dBD;
    private Paint dBE;
    private Paint dBF;
    private c dBG;
    private int dBH;
    private int dBI;
    private int dBJ;
    private int dBK;
    private int dBL;
    private float dBM;
    private int dBN;
    private int dBO;
    private int dBP;
    private float dBQ;
    private boolean dBR;
    private float dBS;
    private float dBT;
    private float dBU;
    private int dBV;
    private int dBW;
    private int dBX;
    private int dBY;
    private int dBZ;
    private DividerType dBx;
    private b dBy;
    private boolean dBz;
    private int dCa;
    private float dCb;
    private int dCc;
    private int dCd;
    private int dCe;
    private float dCf;
    private Drawable dCg;
    private Drawable dCh;
    private Paint dCi;
    private int dCk;
    private GestureDetector gestureDetector;
    private Handler handler;
    private String label;
    private int mGravity;
    private int mOffset;
    private int radius;
    private long startTime;
    private Typeface typeface;

    /* loaded from: classes8.dex */
    public enum ACTION {
        CLICK,
        FLING,
        DAGGLE
    }

    /* loaded from: classes8.dex */
    public enum DividerType {
        FILL,
        WRAP
    }

    public WheelView3d(Context context) {
        this(context, null);
    }

    public WheelView3d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dBz = false;
        this.dBA = true;
        this.dBB = Executors.newSingleThreadScheduledExecutor();
        this.typeface = Typeface.SANS_SERIF;
        this.dBQ = 1.6f;
        this.dBY = 5;
        this.mOffset = 0;
        this.dCb = 0.0f;
        this.startTime = 0L;
        this.mGravity = 17;
        this.dCd = 0;
        this.dCe = 0;
        this.dCk = 0;
        this.dBH = 20;
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.dCf = 2.4f;
        } else if (1.0f <= f && f < 2.0f) {
            this.dCf = 3.6f;
        } else if (1.0f <= f && f < 2.0f) {
            this.dCf = 4.5f;
        } else if (2.0f <= f && f < 3.0f) {
            this.dCf = 6.0f;
        } else if (f >= 3.0f) {
            this.dCf = f * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.pickerview, 0, 0);
            this.mGravity = obtainStyledAttributes.getInt(a.j.pickerview_wheelview_gravity, 17);
            this.dBN = obtainStyledAttributes.getColor(a.j.pickerview_wheelview_textColorOut, -5723992);
            this.dBO = obtainStyledAttributes.getColor(a.j.pickerview_wheelview_textColorCenter, -14013910);
            this.dBP = obtainStyledAttributes.getColor(a.j.pickerview_wheelview_dividerColor, -2763307);
            this.dBH = obtainStyledAttributes.getDimensionPixelOffset(a.j.pickerview_wheelview_textSize, this.dBH);
            this.dBQ = obtainStyledAttributes.getFloat(a.j.pickerview_wheelview_lineSpacingMultiplier, this.dBQ);
            obtainStyledAttributes.recycle();
        }
        aHC();
        dg(context);
    }

    private void aHC() {
        if (this.dBQ < 1.0f) {
            this.dBQ = 1.0f;
        } else if (this.dBQ > 4.0f) {
            this.dBQ = 4.0f;
        }
    }

    private void dg(Context context) {
        this.context = context;
        this.handler = new com.baidu.swan.apps.res.ui.wheelview3d.d.b(this);
        this.gestureDetector = new GestureDetector(context, new com.baidu.swan.apps.res.ui.wheelview3d.c.a(this));
        this.gestureDetector.setIsLongpressEnabled(false);
        this.dBR = true;
        this.dBU = 0.0f;
        this.dBV = -1;
        this.dCg = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, dCj);
        this.dCh = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, dCj);
        aHD();
    }

    private void aHD() {
        this.dBD = new Paint();
        this.dBD.setColor(this.dBN);
        this.dBD.setAntiAlias(true);
        this.dBD.setTypeface(this.typeface);
        this.dBD.setTextSize(this.dBH);
        this.dBE = new Paint();
        this.dBE.setColor(this.dBO);
        this.dBE.setAntiAlias(true);
        this.dBE.setTextScaleX(1.1f);
        this.dBE.setTypeface(this.typeface);
        this.dBE.setTextSize(this.dBH);
        this.dBF = new Paint();
        this.dBF.setColor(this.dBP);
        this.dBF.setAntiAlias(true);
        this.dCi = new Paint();
        this.dCi.setColor(-460552);
        setLayerType(1, null);
    }

    private void aHE() {
        if (this.dBG != null) {
            aHF();
            int i = (int) (this.dBM * (this.dBY - 1));
            this.dBZ = (int) ((i * 2) / 3.141592653589793d);
            this.radius = (int) (i / 3.141592653589793d);
            this.dCa = View.MeasureSpec.getSize(this.dCc);
            this.dBS = (this.dBZ - this.dBM) / 2.0f;
            this.dBT = (this.dBZ + this.dBM) / 2.0f;
            this.centerY = (this.dBT - ((this.dBM - this.dBK) / 2.0f)) - this.dCf;
            if (this.dBV == -1) {
                if (this.dBR) {
                    this.dBV = (this.dBG.getItemsCount() + 1) / 2;
                } else {
                    this.dBV = 0;
                }
            }
            this.dBX = this.dBV;
        }
    }

    private void aHF() {
        Rect rect = new Rect();
        for (int i = 0; i < this.dBG.getItemsCount(); i++) {
            String aa = aa(this.dBG.getItem(i));
            this.dBE.getTextBounds(aa, 0, aa.length(), rect);
            int width = rect.width();
            if (width > this.dBJ) {
                this.dBJ = width;
            }
            this.dBE.getTextBounds("星期", 0, 2, rect);
            this.dBK = rect.height() + 2;
        }
        this.dBM = this.dBQ * this.dBK;
    }

    public void a(ACTION action) {
        aHG();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            this.mOffset = (int) (((this.dBU % this.dBM) + this.dBM) % this.dBM);
            if (this.mOffset > this.dBM / 2.0f) {
                this.mOffset = (int) (this.dBM - this.mOffset);
            } else {
                this.mOffset = -this.mOffset;
            }
        }
        this.dBC = this.dBB.scheduleWithFixedDelay(new com.baidu.swan.apps.res.ui.wheelview3d.d.c(this, this.mOffset), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public final void R(float f) {
        aHG();
        this.dBC = this.dBB.scheduleWithFixedDelay(new com.baidu.swan.apps.res.ui.wheelview3d.d.a(this, f), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public void aHG() {
        if (this.dBC != null && !this.dBC.isCancelled()) {
            this.dBC.cancel(true);
            this.dBC = null;
        }
    }

    public final void setCyclic(boolean z) {
        this.dBR = z;
    }

    public final void setTypeface(Typeface typeface) {
        this.typeface = typeface;
        this.dBD.setTypeface(this.typeface);
        this.dBE.setTypeface(this.typeface);
    }

    public final void setCenterTextSize(int i) {
        if (i > 0.0f) {
            this.dBH = i;
            this.dBE.setTextSize(i);
        }
    }

    public final void setOuterTextSize(int i) {
        if (i > 0.0f) {
            this.dBI = i;
            this.dBD.setTextSize(i);
        }
    }

    public final void setCurrentItem(int i) {
        this.dBW = i;
        this.dBV = i;
        this.dBU = 0.0f;
        invalidate();
    }

    public final void setOnItemSelectedListener(b bVar) {
        this.dBy = bVar;
    }

    public final void setAdapter(c cVar) {
        this.dBG = cVar;
        aHE();
        invalidate();
    }

    public final c getAdapter() {
        return this.dBG;
    }

    public final int getCurrentItem() {
        if (this.dBG == null) {
            return 0;
        }
        if (this.dBR && (this.dBW < 0 || this.dBW >= this.dBG.getItemsCount())) {
            return Math.max(0, Math.min(Math.abs(Math.abs(this.dBW) - this.dBG.getItemsCount()), this.dBG.getItemsCount() - 1));
        }
        return Math.max(0, Math.min(this.dBW, this.dBG.getItemsCount() - 1));
    }

    public final void aHH() {
        if (this.dBy != null) {
            postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d.1
                @Override // java.lang.Runnable
                public void run() {
                    WheelView3d.this.dBy.a(WheelView3d.this, WheelView3d.this.getCurrentItem());
                }
            }, 200L);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String aa;
        int i;
        if (this.dBG != null) {
            this.dBV = Math.min(Math.max(0, this.dBV), this.dBG.getItemsCount() - 1);
            Object[] objArr = new Object[this.dBY];
            this.change = (int) (this.dBU / this.dBM);
            try {
                this.dBX = this.dBV + (this.change % this.dBG.getItemsCount());
            } catch (ArithmeticException e) {
                if (e.DEBUG) {
                    Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
                }
            }
            if (!this.dBR) {
                if (this.dBX < 0) {
                    this.dBX = 0;
                }
                if (this.dBX > this.dBG.getItemsCount() - 1) {
                    this.dBX = this.dBG.getItemsCount() - 1;
                }
            } else {
                if (this.dBX < 0) {
                    this.dBX = this.dBG.getItemsCount() + this.dBX;
                }
                if (this.dBX > this.dBG.getItemsCount() - 1) {
                    this.dBX -= this.dBG.getItemsCount();
                }
            }
            float f = this.dBU % this.dBM;
            for (int i2 = 0; i2 < this.dBY; i2++) {
                int i3 = this.dBX - ((this.dBY / 2) - i2);
                if (this.dBR) {
                    objArr[i2] = this.dBG.getItem(iL(i3));
                } else if (i3 < 0) {
                    objArr[i2] = "";
                } else if (i3 > this.dBG.getItemsCount() - 1) {
                    objArr[i2] = "";
                } else {
                    objArr[i2] = this.dBG.getItem(i3);
                }
            }
            if (this.dBx == DividerType.WRAP) {
                float f2 = TextUtils.isEmpty(this.label) ? ((this.dCa - this.dBJ) / 2) - 12 : ((this.dCa - this.dBJ) / 4) - 12;
                if (f2 <= 0.0f) {
                    f2 = 10.0f;
                }
                float f3 = this.dCa - f2;
                canvas.drawLine(f2, this.dBS, f3, this.dBS, this.dBF);
                canvas.drawLine(f2, this.dBT, f3, this.dBT, this.dBF);
            } else {
                canvas.drawLine(0.0f, this.dBS, this.dCa, this.dBS, this.dBF);
                canvas.drawLine(0.0f, this.dBT, this.dCa, this.dBT, this.dBF);
            }
            canvas.drawRect(0.0f, this.dBS, this.dCa, this.dBT, this.dCi);
            if (!TextUtils.isEmpty(this.label) && this.dBA) {
                canvas.drawText(this.label, (this.dCa - getTextWidth(this.dBE, this.label)) - this.dCf, this.centerY, this.dBE);
            }
            for (int i4 = 0; i4 < this.dBY; i4++) {
                canvas.save();
                double d = ((this.dBM * i4) - f) / this.radius;
                float f4 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
                if (f4 >= 90.0f || f4 <= -90.0f) {
                    canvas.restore();
                } else {
                    float pow = (float) Math.pow(Math.abs(f4) / 90.0f, 2.2d);
                    if (!this.dBA && !TextUtils.isEmpty(this.label) && !TextUtils.isEmpty(aa(objArr[i4]))) {
                        aa = aa(objArr[i4]) + this.label;
                    } else {
                        aa = aa(objArr[i4]);
                    }
                    String rv = rv(aa);
                    rw(rv);
                    rx(rv);
                    float cos = (float) ((this.radius - (Math.cos(d) * this.radius)) - ((Math.sin(d) * this.dBK) / 2.0d));
                    canvas.translate(0.0f, cos);
                    if (cos <= this.dBS && this.dBK + cos >= this.dBS) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.dCa, this.dBS - cos);
                        canvas.drawText(rv, this.dCe, this.dBK, this.dBD);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.dBS - cos, this.dCa, (int) this.dBM);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(rv, this.dCd, this.dBK - this.dCf, this.dBE);
                        canvas.restore();
                    } else if (cos <= this.dBT && this.dBK + cos >= this.dBT) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.dCa, this.dBT - cos);
                        canvas.drawText(rv, this.dCd, this.dBK - this.dCf, this.dBE);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.dBT - cos, this.dCa, (int) this.dBM);
                        canvas.drawText(rv, this.dCe, this.dBK, this.dBD);
                        canvas.restore();
                    } else if (cos >= this.dBS && cos + this.dBK <= this.dBT) {
                        canvas.drawText(rv, this.dCd, this.dBK - this.dCf, this.dBE);
                        this.dBW = this.dBX - ((this.dBY / 2) - i4);
                    } else {
                        canvas.save();
                        canvas.clipRect(0, 0, this.dCa, (int) this.dBM);
                        Paint paint = this.dBD;
                        if (this.dBL == 0) {
                            i = 0;
                        } else {
                            i = this.dBL > 0 ? 1 : -1;
                        }
                        paint.setTextSkewX((f4 > 0.0f ? -1 : 1) * i * 0.0f * pow);
                        this.dBD.setAlpha((int) ((1.0f - pow) * 255.0f));
                        canvas.drawText(rv, this.dCe + (this.dBL * pow), this.dBK, this.dBD);
                        canvas.restore();
                    }
                    canvas.restore();
                    this.dBE.setTextSize(this.dBH);
                }
            }
            a(this.dCg, canvas, 0, (int) this.dBS);
            a(this.dCh, canvas, (int) this.dBT, this.dBZ);
        }
    }

    private String rv(String str) {
        float[] fArr = {0.0f};
        Rect rect = new Rect();
        this.dBE.getTextBounds(str, 0, str.length(), rect);
        if (rect.width() > this.dCa) {
            return str.substring(0, this.dBE.breakText(str, 0, str.length(), true, this.dCa, fArr) - 2) + StringHelper.STRING_MORE;
        }
        return str;
    }

    private int iL(int i) {
        if (i < 0) {
            return iL(this.dBG.getItemsCount() + i);
        }
        if (i > this.dBG.getItemsCount() - 1) {
            return iL(i - this.dBG.getItemsCount());
        }
        return i;
    }

    private String aa(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof com.baidu.swan.apps.res.ui.wheelview3d.b.a) {
            return ((com.baidu.swan.apps.res.ui.wheelview3d.b.a) obj).aHJ();
        }
        return obj instanceof Integer ? String.format(Locale.getDefault(), "%02d", Integer.valueOf(((Integer) obj).intValue())) : obj.toString();
    }

    private void rw(String str) {
        Rect rect = new Rect();
        this.dBE.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.dCd = this.dCk;
                return;
            case 5:
                this.dCd = ((this.dCa - rect.width()) - ((int) this.dCf)) - this.dCk;
                return;
            case 17:
                if (this.dBz || this.label == null || this.label.equals("") || !this.dBA) {
                    this.dCd = (int) (((this.dCa - rect.width()) - this.dCk) * 0.5d);
                    return;
                } else {
                    this.dCd = (int) (((this.dCa - rect.width()) - this.dCk) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    private void rx(String str) {
        Rect rect = new Rect();
        this.dBD.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.dCe = this.dCk;
                return;
            case 5:
                this.dCe = ((this.dCa - rect.width()) - ((int) this.dCf)) - this.dCk;
                return;
            case 17:
                if (this.dBz || this.label == null || this.label.equals("") || !this.dBA) {
                    this.dCe = (int) (((this.dCa - rect.width()) - this.dCk) * 0.5d);
                    return;
                } else {
                    this.dCe = (int) (((this.dCa - rect.width()) - this.dCk) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.dCc = i;
        aHE();
        setMeasuredDimension(this.dCa, this.dBZ);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        boolean onTouchEvent = this.gestureDetector.onTouchEvent(motionEvent);
        float f = (-this.dBV) * this.dBM;
        float itemsCount = ((this.dBG.getItemsCount() - 1) - this.dBV) * this.dBM;
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                aHG();
                this.dCb = motionEvent.getRawY();
                break;
            case 1:
            default:
                if (!onTouchEvent) {
                    float y = motionEvent.getY();
                    this.mOffset = (int) (((((int) (((Math.acos((this.radius - y) / this.radius) * this.radius) + (this.dBM / 2.0f)) / this.dBM)) - (this.dBY / 2)) * this.dBM) - (((this.dBU % this.dBM) + this.dBM) % this.dBM));
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
                float rawY = this.dCb - motionEvent.getRawY();
                this.dCb = motionEvent.getRawY();
                this.dBU += rawY;
                if (!this.dBR && ((this.dBU - (this.dBM * 0.25f) < f && rawY < 0.0f) || (this.dBU + (0.25f * this.dBM) > itemsCount && rawY > 0.0f))) {
                    this.dBU -= rawY;
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
        if (this.dBG != null) {
            return this.dBG.getItemsCount();
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
        this.dBz = z;
    }

    public void setTextColorOut(int i) {
        this.dBN = i;
        this.dBD.setColor(this.dBN);
    }

    public void setTextColorCenter(int i) {
        this.dBO = i;
        this.dBE.setColor(this.dBO);
    }

    public void setTextXOffset(int i) {
        this.dBL = i;
        if (i != 0) {
            this.dBE.setTextScaleX(1.0f);
        }
    }

    public void setDividerColor(int i) {
        this.dBP = i;
        this.dBF.setColor(i);
    }

    public void setDividerType(DividerType dividerType) {
        this.dBx = dividerType;
    }

    public void setLineSpacingMultiplier(float f) {
        if (f != 0.0f) {
            this.dBQ = f;
            aHC();
        }
    }

    public boolean aHI() {
        return this.dBR;
    }

    public float getTotalScrollY() {
        return this.dBU;
    }

    public void setTotalScrollY(float f) {
        this.dBU = f;
    }

    public float getItemHeight() {
        return this.dBM;
    }

    public int getInitPosition() {
        return this.dBV;
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.handler;
    }

    public void setVisibleItem(int i) {
        this.dBY = i;
    }

    private void a(Drawable drawable, Canvas canvas, int i, int i2) {
        drawable.setBounds(0, i, this.dCa, i2);
        drawable.draw(canvas);
    }

    public void setGravityOffset(int i) {
        this.dCk = i;
    }

    public float getCenterContentOffset() {
        return this.dCf;
    }
}
