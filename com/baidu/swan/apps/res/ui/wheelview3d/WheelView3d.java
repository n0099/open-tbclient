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
    private static final int[] dDp = {-1, 452984831};
    private float centerY;
    private int change;
    private Context context;
    private DividerType dCD;
    private b dCE;
    private boolean dCF;
    private boolean dCG;
    private ScheduledExecutorService dCH;
    private ScheduledFuture<?> dCI;
    private Paint dCJ;
    private Paint dCK;
    private Paint dCL;
    private c dCM;
    private int dCN;
    private int dCO;
    private int dCP;
    private int dCQ;
    private int dCR;
    private float dCS;
    private int dCT;
    private int dCU;
    private int dCV;
    private float dCW;
    private boolean dCX;
    private float dCY;
    private float dCZ;
    private float dDa;
    private int dDb;
    private int dDc;
    private int dDd;
    private int dDe;
    private int dDf;
    private int dDg;
    private float dDh;
    private int dDi;
    private int dDj;
    private int dDk;
    private float dDl;
    private Drawable dDm;
    private Drawable dDn;
    private Paint dDo;
    private int dDq;
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
        this.dCF = false;
        this.dCG = true;
        this.dCH = Executors.newSingleThreadScheduledExecutor();
        this.typeface = Typeface.SANS_SERIF;
        this.dCW = 1.6f;
        this.dDe = 5;
        this.mOffset = 0;
        this.dDh = 0.0f;
        this.startTime = 0L;
        this.mGravity = 17;
        this.dDj = 0;
        this.dDk = 0;
        this.dDq = 0;
        this.dCN = 20;
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.dDl = 2.4f;
        } else if (1.0f <= f && f < 2.0f) {
            this.dDl = 3.6f;
        } else if (1.0f <= f && f < 2.0f) {
            this.dDl = 4.5f;
        } else if (2.0f <= f && f < 3.0f) {
            this.dDl = 6.0f;
        } else if (f >= 3.0f) {
            this.dDl = f * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.pickerview, 0, 0);
            this.mGravity = obtainStyledAttributes.getInt(a.j.pickerview_wheelview_gravity, 17);
            this.dCT = obtainStyledAttributes.getColor(a.j.pickerview_wheelview_textColorOut, -5723992);
            this.dCU = obtainStyledAttributes.getColor(a.j.pickerview_wheelview_textColorCenter, -14013910);
            this.dCV = obtainStyledAttributes.getColor(a.j.pickerview_wheelview_dividerColor, -2763307);
            this.dCN = obtainStyledAttributes.getDimensionPixelOffset(a.j.pickerview_wheelview_textSize, this.dCN);
            this.dCW = obtainStyledAttributes.getFloat(a.j.pickerview_wheelview_lineSpacingMultiplier, this.dCW);
            obtainStyledAttributes.recycle();
        }
        aKZ();
        dj(context);
    }

    private void aKZ() {
        if (this.dCW < 1.0f) {
            this.dCW = 1.0f;
        } else if (this.dCW > 4.0f) {
            this.dCW = 4.0f;
        }
    }

    private void dj(Context context) {
        this.context = context;
        this.handler = new com.baidu.swan.apps.res.ui.wheelview3d.d.b(this);
        this.gestureDetector = new GestureDetector(context, new com.baidu.swan.apps.res.ui.wheelview3d.c.a(this));
        this.gestureDetector.setIsLongpressEnabled(false);
        this.dCX = true;
        this.dDa = 0.0f;
        this.dDb = -1;
        this.dDm = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, dDp);
        this.dDn = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, dDp);
        aLa();
    }

    private void aLa() {
        this.dCJ = new Paint();
        this.dCJ.setColor(this.dCT);
        this.dCJ.setAntiAlias(true);
        this.dCJ.setTypeface(this.typeface);
        this.dCJ.setTextSize(this.dCN);
        this.dCK = new Paint();
        this.dCK.setColor(this.dCU);
        this.dCK.setAntiAlias(true);
        this.dCK.setTextScaleX(1.1f);
        this.dCK.setTypeface(this.typeface);
        this.dCK.setTextSize(this.dCN);
        this.dCL = new Paint();
        this.dCL.setColor(this.dCV);
        this.dCL.setAntiAlias(true);
        this.dDo = new Paint();
        this.dDo.setColor(-460552);
        setLayerType(1, null);
    }

    private void aLb() {
        if (this.dCM != null) {
            aLc();
            int i = (int) (this.dCS * (this.dDe - 1));
            this.dDf = (int) ((i * 2) / 3.141592653589793d);
            this.radius = (int) (i / 3.141592653589793d);
            this.dDg = View.MeasureSpec.getSize(this.dDi);
            this.dCY = (this.dDf - this.dCS) / 2.0f;
            this.dCZ = (this.dDf + this.dCS) / 2.0f;
            this.centerY = (this.dCZ - ((this.dCS - this.dCQ) / 2.0f)) - this.dDl;
            if (this.dDb == -1) {
                if (this.dCX) {
                    this.dDb = (this.dCM.getItemsCount() + 1) / 2;
                } else {
                    this.dDb = 0;
                }
            }
            this.dDd = this.dDb;
        }
    }

    private void aLc() {
        Rect rect = new Rect();
        for (int i = 0; i < this.dCM.getItemsCount(); i++) {
            String Y = Y(this.dCM.getItem(i));
            this.dCK.getTextBounds(Y, 0, Y.length(), rect);
            int width = rect.width();
            if (width > this.dCP) {
                this.dCP = width;
            }
            this.dCK.getTextBounds("星期", 0, 2, rect);
            this.dCQ = rect.height() + 2;
        }
        this.dCS = this.dCW * this.dCQ;
    }

    public void a(ACTION action) {
        aLd();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            this.mOffset = (int) (((this.dDa % this.dCS) + this.dCS) % this.dCS);
            if (this.mOffset > this.dCS / 2.0f) {
                this.mOffset = (int) (this.dCS - this.mOffset);
            } else {
                this.mOffset = -this.mOffset;
            }
        }
        this.dCI = this.dCH.scheduleWithFixedDelay(new com.baidu.swan.apps.res.ui.wheelview3d.d.c(this, this.mOffset), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public final void M(float f) {
        aLd();
        this.dCI = this.dCH.scheduleWithFixedDelay(new com.baidu.swan.apps.res.ui.wheelview3d.d.a(this, f), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public void aLd() {
        if (this.dCI != null && !this.dCI.isCancelled()) {
            this.dCI.cancel(true);
            this.dCI = null;
        }
    }

    public final void setCyclic(boolean z) {
        this.dCX = z;
    }

    public final void setTypeface(Typeface typeface) {
        this.typeface = typeface;
        this.dCJ.setTypeface(this.typeface);
        this.dCK.setTypeface(this.typeface);
    }

    public final void setCenterTextSize(int i) {
        if (i > 0.0f) {
            this.dCN = i;
            this.dCK.setTextSize(i);
        }
    }

    public final void setOuterTextSize(int i) {
        if (i > 0.0f) {
            this.dCO = i;
            this.dCJ.setTextSize(i);
        }
    }

    public final void setCurrentItem(int i) {
        this.dDc = i;
        this.dDb = i;
        this.dDa = 0.0f;
        invalidate();
    }

    public final void setOnItemSelectedListener(b bVar) {
        this.dCE = bVar;
    }

    public final void setAdapter(c cVar) {
        this.dCM = cVar;
        aLb();
        invalidate();
    }

    public final c getAdapter() {
        return this.dCM;
    }

    public final int getCurrentItem() {
        if (this.dCM == null) {
            return 0;
        }
        if (this.dCX && (this.dDc < 0 || this.dDc >= this.dCM.getItemsCount())) {
            return Math.max(0, Math.min(Math.abs(Math.abs(this.dDc) - this.dCM.getItemsCount()), this.dCM.getItemsCount() - 1));
        }
        return Math.max(0, Math.min(this.dDc, this.dCM.getItemsCount() - 1));
    }

    public final void aLe() {
        if (this.dCE != null) {
            postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d.1
                @Override // java.lang.Runnable
                public void run() {
                    WheelView3d.this.dCE.a(WheelView3d.this, WheelView3d.this.getCurrentItem());
                }
            }, 200L);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String Y;
        int i;
        if (this.dCM != null) {
            this.dDb = Math.min(Math.max(0, this.dDb), this.dCM.getItemsCount() - 1);
            Object[] objArr = new Object[this.dDe];
            this.change = (int) (this.dDa / this.dCS);
            try {
                this.dDd = this.dDb + (this.change % this.dCM.getItemsCount());
            } catch (ArithmeticException e) {
                if (e.DEBUG) {
                    Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
                }
            }
            if (!this.dCX) {
                if (this.dDd < 0) {
                    this.dDd = 0;
                }
                if (this.dDd > this.dCM.getItemsCount() - 1) {
                    this.dDd = this.dCM.getItemsCount() - 1;
                }
            } else {
                if (this.dDd < 0) {
                    this.dDd = this.dCM.getItemsCount() + this.dDd;
                }
                if (this.dDd > this.dCM.getItemsCount() - 1) {
                    this.dDd -= this.dCM.getItemsCount();
                }
            }
            float f = this.dDa % this.dCS;
            for (int i2 = 0; i2 < this.dDe; i2++) {
                int i3 = this.dDd - ((this.dDe / 2) - i2);
                if (this.dCX) {
                    objArr[i2] = this.dCM.getItem(kn(i3));
                } else if (i3 < 0) {
                    objArr[i2] = "";
                } else if (i3 > this.dCM.getItemsCount() - 1) {
                    objArr[i2] = "";
                } else {
                    objArr[i2] = this.dCM.getItem(i3);
                }
            }
            if (this.dCD == DividerType.WRAP) {
                float f2 = TextUtils.isEmpty(this.label) ? ((this.dDg - this.dCP) / 2) - 12 : ((this.dDg - this.dCP) / 4) - 12;
                if (f2 <= 0.0f) {
                    f2 = 10.0f;
                }
                float f3 = this.dDg - f2;
                canvas.drawLine(f2, this.dCY, f3, this.dCY, this.dCL);
                canvas.drawLine(f2, this.dCZ, f3, this.dCZ, this.dCL);
            } else {
                canvas.drawLine(0.0f, this.dCY, this.dDg, this.dCY, this.dCL);
                canvas.drawLine(0.0f, this.dCZ, this.dDg, this.dCZ, this.dCL);
            }
            canvas.drawRect(0.0f, this.dCY, this.dDg, this.dCZ, this.dDo);
            if (!TextUtils.isEmpty(this.label) && this.dCG) {
                canvas.drawText(this.label, (this.dDg - getTextWidth(this.dCK, this.label)) - this.dDl, this.centerY, this.dCK);
            }
            for (int i4 = 0; i4 < this.dDe; i4++) {
                canvas.save();
                double d = ((this.dCS * i4) - f) / this.radius;
                float f4 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
                if (f4 >= 90.0f || f4 <= -90.0f) {
                    canvas.restore();
                } else {
                    float pow = (float) Math.pow(Math.abs(f4) / 90.0f, 2.2d);
                    if (!this.dCG && !TextUtils.isEmpty(this.label) && !TextUtils.isEmpty(Y(objArr[i4]))) {
                        Y = Y(objArr[i4]) + this.label;
                    } else {
                        Y = Y(objArr[i4]);
                    }
                    String sg = sg(Y);
                    sh(sg);
                    si(sg);
                    float cos = (float) ((this.radius - (Math.cos(d) * this.radius)) - ((Math.sin(d) * this.dCQ) / 2.0d));
                    canvas.translate(0.0f, cos);
                    if (cos <= this.dCY && this.dCQ + cos >= this.dCY) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.dDg, this.dCY - cos);
                        canvas.drawText(sg, this.dDk, this.dCQ, this.dCJ);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.dCY - cos, this.dDg, (int) this.dCS);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(sg, this.dDj, this.dCQ - this.dDl, this.dCK);
                        canvas.restore();
                    } else if (cos <= this.dCZ && this.dCQ + cos >= this.dCZ) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.dDg, this.dCZ - cos);
                        canvas.drawText(sg, this.dDj, this.dCQ - this.dDl, this.dCK);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.dCZ - cos, this.dDg, (int) this.dCS);
                        canvas.drawText(sg, this.dDk, this.dCQ, this.dCJ);
                        canvas.restore();
                    } else if (cos >= this.dCY && cos + this.dCQ <= this.dCZ) {
                        canvas.drawText(sg, this.dDj, this.dCQ - this.dDl, this.dCK);
                        this.dDc = this.dDd - ((this.dDe / 2) - i4);
                    } else {
                        canvas.save();
                        canvas.clipRect(0, 0, this.dDg, (int) this.dCS);
                        Paint paint = this.dCJ;
                        if (this.dCR == 0) {
                            i = 0;
                        } else {
                            i = this.dCR > 0 ? 1 : -1;
                        }
                        paint.setTextSkewX((f4 > 0.0f ? -1 : 1) * i * 0.0f * pow);
                        this.dCJ.setAlpha((int) ((1.0f - pow) * 255.0f));
                        canvas.drawText(sg, this.dDk + (this.dCR * pow), this.dCQ, this.dCJ);
                        canvas.restore();
                    }
                    canvas.restore();
                    this.dCK.setTextSize(this.dCN);
                }
            }
            a(this.dDm, canvas, 0, (int) this.dCY);
            a(this.dDn, canvas, (int) this.dCZ, this.dDf);
        }
    }

    private String sg(String str) {
        float[] fArr = {0.0f};
        Rect rect = new Rect();
        this.dCK.getTextBounds(str, 0, str.length(), rect);
        if (rect.width() > this.dDg) {
            return str.substring(0, this.dCK.breakText(str, 0, str.length(), true, this.dDg, fArr) - 2) + StringHelper.STRING_MORE;
        }
        return str;
    }

    private int kn(int i) {
        if (i < 0) {
            return kn(this.dCM.getItemsCount() + i);
        }
        if (i > this.dCM.getItemsCount() - 1) {
            return kn(i - this.dCM.getItemsCount());
        }
        return i;
    }

    private String Y(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof com.baidu.swan.apps.res.ui.wheelview3d.b.a) {
            return ((com.baidu.swan.apps.res.ui.wheelview3d.b.a) obj).aLg();
        }
        return obj instanceof Integer ? String.format(Locale.getDefault(), "%02d", Integer.valueOf(((Integer) obj).intValue())) : obj.toString();
    }

    private void sh(String str) {
        Rect rect = new Rect();
        this.dCK.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.dDj = this.dDq;
                return;
            case 5:
                this.dDj = ((this.dDg - rect.width()) - ((int) this.dDl)) - this.dDq;
                return;
            case 17:
                if (this.dCF || this.label == null || this.label.equals("") || !this.dCG) {
                    this.dDj = (int) (((this.dDg - rect.width()) - this.dDq) * 0.5d);
                    return;
                } else {
                    this.dDj = (int) (((this.dDg - rect.width()) - this.dDq) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    private void si(String str) {
        Rect rect = new Rect();
        this.dCJ.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.dDk = this.dDq;
                return;
            case 5:
                this.dDk = ((this.dDg - rect.width()) - ((int) this.dDl)) - this.dDq;
                return;
            case 17:
                if (this.dCF || this.label == null || this.label.equals("") || !this.dCG) {
                    this.dDk = (int) (((this.dDg - rect.width()) - this.dDq) * 0.5d);
                    return;
                } else {
                    this.dDk = (int) (((this.dDg - rect.width()) - this.dDq) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.dDi = i;
        aLb();
        setMeasuredDimension(this.dDg, this.dDf);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        boolean onTouchEvent = this.gestureDetector.onTouchEvent(motionEvent);
        float f = (-this.dDb) * this.dCS;
        float itemsCount = ((this.dCM.getItemsCount() - 1) - this.dDb) * this.dCS;
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                aLd();
                this.dDh = motionEvent.getRawY();
                break;
            case 1:
            default:
                if (!onTouchEvent) {
                    float y = motionEvent.getY();
                    this.mOffset = (int) (((((int) (((Math.acos((this.radius - y) / this.radius) * this.radius) + (this.dCS / 2.0f)) / this.dCS)) - (this.dDe / 2)) * this.dCS) - (((this.dDa % this.dCS) + this.dCS) % this.dCS));
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
                float rawY = this.dDh - motionEvent.getRawY();
                this.dDh = motionEvent.getRawY();
                this.dDa += rawY;
                if (!this.dCX && ((this.dDa - (this.dCS * 0.25f) < f && rawY < 0.0f) || (this.dDa + (0.25f * this.dCS) > itemsCount && rawY > 0.0f))) {
                    this.dDa -= rawY;
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
        if (this.dCM != null) {
            return this.dCM.getItemsCount();
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
        this.dCF = z;
    }

    public void setTextColorOut(int i) {
        this.dCT = i;
        this.dCJ.setColor(this.dCT);
    }

    public void setTextColorCenter(int i) {
        this.dCU = i;
        this.dCK.setColor(this.dCU);
    }

    public void setTextXOffset(int i) {
        this.dCR = i;
        if (i != 0) {
            this.dCK.setTextScaleX(1.0f);
        }
    }

    public void setDividerColor(int i) {
        this.dCV = i;
        this.dCL.setColor(i);
    }

    public void setDividerType(DividerType dividerType) {
        this.dCD = dividerType;
    }

    public void setLineSpacingMultiplier(float f) {
        if (f != 0.0f) {
            this.dCW = f;
            aKZ();
        }
    }

    public boolean aLf() {
        return this.dCX;
    }

    public float getTotalScrollY() {
        return this.dDa;
    }

    public void setTotalScrollY(float f) {
        this.dDa = f;
    }

    public float getItemHeight() {
        return this.dCS;
    }

    public int getInitPosition() {
        return this.dDb;
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.handler;
    }

    public void setVisibleItem(int i) {
        this.dDe = i;
    }

    private void a(Drawable drawable, Canvas canvas, int i, int i2) {
        drawable.setBounds(0, i, this.dDg, i2);
        drawable.draw(canvas);
    }

    public void setGravityOffset(int i) {
        this.dDq = i;
    }

    public float getCenterContentOffset() {
        return this.dDl;
    }
}
