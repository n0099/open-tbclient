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
    private static final int[] cOC = {-1, 452984831};
    private Drawable cOA;
    private Paint cOB;
    private int cOD;
    private DividerType cOu;
    private b cOv;
    private c cOw;
    private int cOx;
    private int cOy;
    private Drawable cOz;
    private float centerContentOffset;
    private float centerY;
    private int change;
    private Context context;
    private int dividerColor;
    private int drawCenterContentStart;
    private int drawOutContentStart;
    private float firstLineY;
    private GestureDetector gestureDetector;
    private Handler handler;
    private int initPosition;
    private boolean isCenterLabel;
    private boolean isLoop;
    private boolean isOptions;
    private float itemHeight;
    private int itemsVisible;
    private String label;
    private float lineSpacingMultiplier;
    private ScheduledExecutorService mExecutor;
    private ScheduledFuture<?> mFuture;
    private int mGravity;
    private int mOffset;
    private int maxTextHeight;
    private int maxTextWidth;
    private int measuredHeight;
    private int measuredWidth;
    private Paint paintCenterText;
    private Paint paintIndicator;
    private Paint paintOuterText;
    private int preCurrentIndex;
    private float previousY;
    private int radius;
    private float secondLineY;
    private int selectedItem;
    private long startTime;
    private int textColorCenter;
    private int textColorOut;
    private int textXOffset;
    private float totalScrollY;
    private Typeface typeface;
    private int widthMeasureSpec;

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
        this.isOptions = false;
        this.isCenterLabel = true;
        this.mExecutor = Executors.newSingleThreadScheduledExecutor();
        this.typeface = Typeface.SANS_SERIF;
        this.lineSpacingMultiplier = 1.6f;
        this.itemsVisible = 5;
        this.mOffset = 0;
        this.previousY = 0.0f;
        this.startTime = 0L;
        this.mGravity = 17;
        this.drawCenterContentStart = 0;
        this.drawOutContentStart = 0;
        this.cOD = 0;
        this.cOx = 20;
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.centerContentOffset = 2.4f;
        } else if (1.0f <= f && f < 2.0f) {
            this.centerContentOffset = 3.6f;
        } else if (1.0f <= f && f < 2.0f) {
            this.centerContentOffset = 4.5f;
        } else if (2.0f <= f && f < 3.0f) {
            this.centerContentOffset = 6.0f;
        } else if (f >= 3.0f) {
            this.centerContentOffset = f * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.pickerview, 0, 0);
            this.mGravity = obtainStyledAttributes.getInt(a.j.pickerview_wheelview_gravity, 17);
            this.textColorOut = obtainStyledAttributes.getColor(a.j.pickerview_wheelview_textColorOut, -5723992);
            this.textColorCenter = obtainStyledAttributes.getColor(a.j.pickerview_wheelview_textColorCenter, -14013910);
            this.dividerColor = obtainStyledAttributes.getColor(a.j.pickerview_wheelview_dividerColor, -2763307);
            this.cOx = obtainStyledAttributes.getDimensionPixelOffset(a.j.pickerview_wheelview_textSize, this.cOx);
            this.lineSpacingMultiplier = obtainStyledAttributes.getFloat(a.j.pickerview_wheelview_lineSpacingMultiplier, this.lineSpacingMultiplier);
            obtainStyledAttributes.recycle();
        }
        judgeLineSpace();
        initLoopView(context);
    }

    private void judgeLineSpace() {
        if (this.lineSpacingMultiplier < 1.0f) {
            this.lineSpacingMultiplier = 1.0f;
        } else if (this.lineSpacingMultiplier > 4.0f) {
            this.lineSpacingMultiplier = 4.0f;
        }
    }

    private void initLoopView(Context context) {
        this.context = context;
        this.handler = new com.baidu.swan.apps.res.ui.wheelview3d.d.b(this);
        this.gestureDetector = new GestureDetector(context, new com.baidu.swan.apps.res.ui.wheelview3d.c.a(this));
        this.gestureDetector.setIsLongpressEnabled(false);
        this.isLoop = true;
        this.totalScrollY = 0.0f;
        this.initPosition = -1;
        this.cOz = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, cOC);
        this.cOA = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, cOC);
        initPaints();
    }

    private void initPaints() {
        this.paintOuterText = new Paint();
        this.paintOuterText.setColor(this.textColorOut);
        this.paintOuterText.setAntiAlias(true);
        this.paintOuterText.setTypeface(this.typeface);
        this.paintOuterText.setTextSize(this.cOx);
        this.paintCenterText = new Paint();
        this.paintCenterText.setColor(this.textColorCenter);
        this.paintCenterText.setAntiAlias(true);
        this.paintCenterText.setTextScaleX(1.1f);
        this.paintCenterText.setTypeface(this.typeface);
        this.paintCenterText.setTextSize(this.cOx);
        this.paintIndicator = new Paint();
        this.paintIndicator.setColor(this.dividerColor);
        this.paintIndicator.setAntiAlias(true);
        this.cOB = new Paint();
        this.cOB.setColor(-460552);
        setLayerType(1, null);
    }

    private void remeasure() {
        if (this.cOw != null) {
            measureTextWidthHeight();
            int i = (int) (this.itemHeight * (this.itemsVisible - 1));
            this.measuredHeight = (int) ((i * 2) / 3.141592653589793d);
            this.radius = (int) (i / 3.141592653589793d);
            this.measuredWidth = View.MeasureSpec.getSize(this.widthMeasureSpec);
            this.firstLineY = (this.measuredHeight - this.itemHeight) / 2.0f;
            this.secondLineY = (this.measuredHeight + this.itemHeight) / 2.0f;
            this.centerY = (this.secondLineY - ((this.itemHeight - this.maxTextHeight) / 2.0f)) - this.centerContentOffset;
            if (this.initPosition == -1) {
                if (this.isLoop) {
                    this.initPosition = (this.cOw.getItemsCount() + 1) / 2;
                } else {
                    this.initPosition = 0;
                }
            }
            this.preCurrentIndex = this.initPosition;
        }
    }

    private void measureTextWidthHeight() {
        Rect rect = new Rect();
        for (int i = 0; i < this.cOw.getItemsCount(); i++) {
            String contentText = getContentText(this.cOw.getItem(i));
            this.paintCenterText.getTextBounds(contentText, 0, contentText.length(), rect);
            int width = rect.width();
            if (width > this.maxTextWidth) {
                this.maxTextWidth = width;
            }
            this.paintCenterText.getTextBounds("星期", 0, 2, rect);
            this.maxTextHeight = rect.height() + 2;
        }
        this.itemHeight = this.lineSpacingMultiplier * this.maxTextHeight;
    }

    public void a(ACTION action) {
        cancelFuture();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            this.mOffset = (int) (((this.totalScrollY % this.itemHeight) + this.itemHeight) % this.itemHeight);
            if (this.mOffset > this.itemHeight / 2.0f) {
                this.mOffset = (int) (this.itemHeight - this.mOffset);
            } else {
                this.mOffset = -this.mOffset;
            }
        }
        this.mFuture = this.mExecutor.scheduleWithFixedDelay(new com.baidu.swan.apps.res.ui.wheelview3d.d.c(this, this.mOffset), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public final void scrollBy(float f) {
        cancelFuture();
        this.mFuture = this.mExecutor.scheduleWithFixedDelay(new com.baidu.swan.apps.res.ui.wheelview3d.d.a(this, f), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public void cancelFuture() {
        if (this.mFuture != null && !this.mFuture.isCancelled()) {
            this.mFuture.cancel(true);
            this.mFuture = null;
        }
    }

    public final void setCyclic(boolean z) {
        this.isLoop = z;
    }

    public final void setTypeface(Typeface typeface) {
        this.typeface = typeface;
        this.paintOuterText.setTypeface(this.typeface);
        this.paintCenterText.setTypeface(this.typeface);
    }

    public final void setCenterTextSize(int i) {
        if (i > 0.0f) {
            this.cOx = i;
            this.paintCenterText.setTextSize(i);
        }
    }

    public final void setOuterTextSize(int i) {
        if (i > 0.0f) {
            this.cOy = i;
            this.paintOuterText.setTextSize(i);
        }
    }

    public final void setCurrentItem(int i) {
        this.selectedItem = i;
        this.initPosition = i;
        this.totalScrollY = 0.0f;
        invalidate();
    }

    public final void setOnItemSelectedListener(b bVar) {
        this.cOv = bVar;
    }

    public final void setAdapter(c cVar) {
        this.cOw = cVar;
        remeasure();
        invalidate();
    }

    public final c getAdapter() {
        return this.cOw;
    }

    public final int getCurrentItem() {
        if (this.cOw == null) {
            return 0;
        }
        if (this.isLoop && (this.selectedItem < 0 || this.selectedItem >= this.cOw.getItemsCount())) {
            return Math.max(0, Math.min(Math.abs(Math.abs(this.selectedItem) - this.cOw.getItemsCount()), this.cOw.getItemsCount() - 1));
        }
        return Math.max(0, Math.min(this.selectedItem, this.cOw.getItemsCount() - 1));
    }

    public final void onItemSelected() {
        if (this.cOv != null) {
            postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d.1
                @Override // java.lang.Runnable
                public void run() {
                    WheelView3d.this.cOv.a(WheelView3d.this, WheelView3d.this.getCurrentItem());
                }
            }, 200L);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String contentText;
        int i;
        if (this.cOw != null) {
            this.initPosition = Math.min(Math.max(0, this.initPosition), this.cOw.getItemsCount() - 1);
            Object[] objArr = new Object[this.itemsVisible];
            this.change = (int) (this.totalScrollY / this.itemHeight);
            try {
                this.preCurrentIndex = this.initPosition + (this.change % this.cOw.getItemsCount());
            } catch (ArithmeticException e) {
                if (e.DEBUG) {
                    Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
                }
            }
            if (!this.isLoop) {
                if (this.preCurrentIndex < 0) {
                    this.preCurrentIndex = 0;
                }
                if (this.preCurrentIndex > this.cOw.getItemsCount() - 1) {
                    this.preCurrentIndex = this.cOw.getItemsCount() - 1;
                }
            } else {
                if (this.preCurrentIndex < 0) {
                    this.preCurrentIndex = this.cOw.getItemsCount() + this.preCurrentIndex;
                }
                if (this.preCurrentIndex > this.cOw.getItemsCount() - 1) {
                    this.preCurrentIndex -= this.cOw.getItemsCount();
                }
            }
            float f = this.totalScrollY % this.itemHeight;
            for (int i2 = 0; i2 < this.itemsVisible; i2++) {
                int i3 = this.preCurrentIndex - ((this.itemsVisible / 2) - i2);
                if (this.isLoop) {
                    objArr[i2] = this.cOw.getItem(getLoopMappingIndex(i3));
                } else if (i3 < 0) {
                    objArr[i2] = "";
                } else if (i3 > this.cOw.getItemsCount() - 1) {
                    objArr[i2] = "";
                } else {
                    objArr[i2] = this.cOw.getItem(i3);
                }
            }
            if (this.cOu == DividerType.WRAP) {
                float f2 = TextUtils.isEmpty(this.label) ? ((this.measuredWidth - this.maxTextWidth) / 2) - 12 : ((this.measuredWidth - this.maxTextWidth) / 4) - 12;
                if (f2 <= 0.0f) {
                    f2 = 10.0f;
                }
                float f3 = this.measuredWidth - f2;
                canvas.drawLine(f2, this.firstLineY, f3, this.firstLineY, this.paintIndicator);
                canvas.drawLine(f2, this.secondLineY, f3, this.secondLineY, this.paintIndicator);
            } else {
                canvas.drawLine(0.0f, this.firstLineY, this.measuredWidth, this.firstLineY, this.paintIndicator);
                canvas.drawLine(0.0f, this.secondLineY, this.measuredWidth, this.secondLineY, this.paintIndicator);
            }
            canvas.drawRect(0.0f, this.firstLineY, this.measuredWidth, this.secondLineY, this.cOB);
            if (!TextUtils.isEmpty(this.label) && this.isCenterLabel) {
                canvas.drawText(this.label, (this.measuredWidth - getTextWidth(this.paintCenterText, this.label)) - this.centerContentOffset, this.centerY, this.paintCenterText);
            }
            for (int i4 = 0; i4 < this.itemsVisible; i4++) {
                canvas.save();
                double d = ((this.itemHeight * i4) - f) / this.radius;
                float f4 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
                if (f4 >= 90.0f || f4 <= -90.0f) {
                    canvas.restore();
                } else {
                    float pow = (float) Math.pow(Math.abs(f4) / 90.0f, 2.2d);
                    if (!this.isCenterLabel && !TextUtils.isEmpty(this.label) && !TextUtils.isEmpty(getContentText(objArr[i4]))) {
                        contentText = getContentText(objArr[i4]) + this.label;
                    } else {
                        contentText = getContentText(objArr[i4]);
                    }
                    String pZ = pZ(contentText);
                    measuredCenterContentStart(pZ);
                    measuredOutContentStart(pZ);
                    float cos = (float) ((this.radius - (Math.cos(d) * this.radius)) - ((Math.sin(d) * this.maxTextHeight) / 2.0d));
                    canvas.translate(0.0f, cos);
                    if (cos <= this.firstLineY && this.maxTextHeight + cos >= this.firstLineY) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.measuredWidth, this.firstLineY - cos);
                        canvas.drawText(pZ, this.drawOutContentStart, this.maxTextHeight, this.paintOuterText);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.firstLineY - cos, this.measuredWidth, (int) this.itemHeight);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(pZ, this.drawCenterContentStart, this.maxTextHeight - this.centerContentOffset, this.paintCenterText);
                        canvas.restore();
                    } else if (cos <= this.secondLineY && this.maxTextHeight + cos >= this.secondLineY) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.measuredWidth, this.secondLineY - cos);
                        canvas.drawText(pZ, this.drawCenterContentStart, this.maxTextHeight - this.centerContentOffset, this.paintCenterText);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.secondLineY - cos, this.measuredWidth, (int) this.itemHeight);
                        canvas.drawText(pZ, this.drawOutContentStart, this.maxTextHeight, this.paintOuterText);
                        canvas.restore();
                    } else if (cos >= this.firstLineY && cos + this.maxTextHeight <= this.secondLineY) {
                        canvas.drawText(pZ, this.drawCenterContentStart, this.maxTextHeight - this.centerContentOffset, this.paintCenterText);
                        this.selectedItem = this.preCurrentIndex - ((this.itemsVisible / 2) - i4);
                    } else {
                        canvas.save();
                        canvas.clipRect(0, 0, this.measuredWidth, (int) this.itemHeight);
                        Paint paint = this.paintOuterText;
                        if (this.textXOffset == 0) {
                            i = 0;
                        } else {
                            i = this.textXOffset > 0 ? 1 : -1;
                        }
                        paint.setTextSkewX((f4 > 0.0f ? -1 : 1) * i * 0.0f * pow);
                        this.paintOuterText.setAlpha((int) ((1.0f - pow) * 255.0f));
                        canvas.drawText(pZ, this.drawOutContentStart + (this.textXOffset * pow), this.maxTextHeight, this.paintOuterText);
                        canvas.restore();
                    }
                    canvas.restore();
                    this.paintCenterText.setTextSize(this.cOx);
                }
            }
            a(this.cOz, canvas, 0, (int) this.firstLineY);
            a(this.cOA, canvas, (int) this.secondLineY, this.measuredHeight);
        }
    }

    private String pZ(String str) {
        float[] fArr = {0.0f};
        Rect rect = new Rect();
        this.paintCenterText.getTextBounds(str, 0, str.length(), rect);
        if (rect.width() > this.measuredWidth) {
            return str.substring(0, this.paintCenterText.breakText(str, 0, str.length(), true, this.measuredWidth, fArr) - 2) + StringHelper.STRING_MORE;
        }
        return str;
    }

    private int getLoopMappingIndex(int i) {
        if (i < 0) {
            return getLoopMappingIndex(this.cOw.getItemsCount() + i);
        }
        if (i > this.cOw.getItemsCount() - 1) {
            return getLoopMappingIndex(i - this.cOw.getItemsCount());
        }
        return i;
    }

    private String getContentText(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof com.baidu.swan.apps.res.ui.wheelview3d.b.a) {
            return ((com.baidu.swan.apps.res.ui.wheelview3d.b.a) obj).getPickerViewText();
        }
        return obj instanceof Integer ? String.format(Locale.getDefault(), "%02d", Integer.valueOf(((Integer) obj).intValue())) : obj.toString();
    }

    private void measuredCenterContentStart(String str) {
        Rect rect = new Rect();
        this.paintCenterText.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.drawCenterContentStart = this.cOD;
                return;
            case 5:
                this.drawCenterContentStart = ((this.measuredWidth - rect.width()) - ((int) this.centerContentOffset)) - this.cOD;
                return;
            case 17:
                if (this.isOptions || this.label == null || this.label.equals("") || !this.isCenterLabel) {
                    this.drawCenterContentStart = (int) (((this.measuredWidth - rect.width()) - this.cOD) * 0.5d);
                    return;
                } else {
                    this.drawCenterContentStart = (int) (((this.measuredWidth - rect.width()) - this.cOD) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    private void measuredOutContentStart(String str) {
        Rect rect = new Rect();
        this.paintOuterText.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.drawOutContentStart = this.cOD;
                return;
            case 5:
                this.drawOutContentStart = ((this.measuredWidth - rect.width()) - ((int) this.centerContentOffset)) - this.cOD;
                return;
            case 17:
                if (this.isOptions || this.label == null || this.label.equals("") || !this.isCenterLabel) {
                    this.drawOutContentStart = (int) (((this.measuredWidth - rect.width()) - this.cOD) * 0.5d);
                    return;
                } else {
                    this.drawOutContentStart = (int) (((this.measuredWidth - rect.width()) - this.cOD) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.widthMeasureSpec = i;
        remeasure();
        setMeasuredDimension(this.measuredWidth, this.measuredHeight);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        boolean onTouchEvent = this.gestureDetector.onTouchEvent(motionEvent);
        float f = (-this.initPosition) * this.itemHeight;
        float itemsCount = ((this.cOw.getItemsCount() - 1) - this.initPosition) * this.itemHeight;
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                cancelFuture();
                this.previousY = motionEvent.getRawY();
                break;
            case 1:
            default:
                if (!onTouchEvent) {
                    float y = motionEvent.getY();
                    this.mOffset = (int) (((((int) (((Math.acos((this.radius - y) / this.radius) * this.radius) + (this.itemHeight / 2.0f)) / this.itemHeight)) - (this.itemsVisible / 2)) * this.itemHeight) - (((this.totalScrollY % this.itemHeight) + this.itemHeight) % this.itemHeight));
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
                float rawY = this.previousY - motionEvent.getRawY();
                this.previousY = motionEvent.getRawY();
                this.totalScrollY += rawY;
                if (!this.isLoop && ((this.totalScrollY - (this.itemHeight * 0.25f) < f && rawY < 0.0f) || (this.totalScrollY + (0.25f * this.itemHeight) > itemsCount && rawY > 0.0f))) {
                    this.totalScrollY -= rawY;
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
        if (this.cOw != null) {
            return this.cOw.getItemsCount();
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
        int i = 0;
        if (str != null && str.length() > 0) {
            int length = str.length();
            paint.getTextWidths(str, new float[length]);
            int i2 = 0;
            while (i2 < length) {
                int ceil = ((int) Math.ceil(fArr[i2])) + i;
                i2++;
                i = ceil;
            }
        }
        return i;
    }

    public void setIsOptions(boolean z) {
        this.isOptions = z;
    }

    public void setTextColorOut(int i) {
        this.textColorOut = i;
        this.paintOuterText.setColor(this.textColorOut);
    }

    public void setTextColorCenter(int i) {
        this.textColorCenter = i;
        this.paintCenterText.setColor(this.textColorCenter);
    }

    public void setTextXOffset(int i) {
        this.textXOffset = i;
        if (i != 0) {
            this.paintCenterText.setTextScaleX(1.0f);
        }
    }

    public void setDividerColor(int i) {
        this.dividerColor = i;
        this.paintIndicator.setColor(i);
    }

    public void setDividerType(DividerType dividerType) {
        this.cOu = dividerType;
    }

    public void setLineSpacingMultiplier(float f) {
        if (f != 0.0f) {
            this.lineSpacingMultiplier = f;
            judgeLineSpace();
        }
    }

    public boolean isLoop() {
        return this.isLoop;
    }

    public float getTotalScrollY() {
        return this.totalScrollY;
    }

    public void setTotalScrollY(float f) {
        this.totalScrollY = f;
    }

    public float getItemHeight() {
        return this.itemHeight;
    }

    public int getInitPosition() {
        return this.initPosition;
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.handler;
    }

    public void setVisibleItem(int i) {
        this.itemsVisible = i;
    }

    private void a(Drawable drawable, Canvas canvas, int i, int i2) {
        drawable.setBounds(0, i, this.measuredWidth, i2);
        drawable.draw(canvas);
    }

    public void setGravityOffset(int i) {
        this.cOD = i;
    }

    public float getCenterContentOffset() {
        return this.centerContentOffset;
    }
}
