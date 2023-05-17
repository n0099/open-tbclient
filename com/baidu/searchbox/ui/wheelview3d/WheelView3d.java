package com.baidu.searchbox.ui.wheelview3d;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.android.common.ui.style.R;
import com.baidu.searchbox.ui.wheelview3d.adapter.WheelAdapter;
import com.baidu.searchbox.ui.wheelview3d.interfaces.IPickerViewData;
import com.baidu.searchbox.ui.wheelview3d.listener.LoopViewGestureListener;
import com.baidu.searchbox.ui.wheelview3d.listener.OnItemSelectedListener;
import com.baidu.searchbox.ui.wheelview3d.timer.InertiaTimerTask;
import com.baidu.searchbox.ui.wheelview3d.timer.MessageHandler;
import com.baidu.searchbox.ui.wheelview3d.timer.SmoothScrollTimerTask;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class WheelView3d extends View {
    public static final float DEFAULT_TEXT_TARGET_SKEWX = 0.5f;
    public static final float SCALE_CONTENT = 0.8f;
    public static final int VELOCITY_FLING = 5;
    public WheelAdapter adapter;
    public float centerContentOffset;
    public float centerY;
    public int change;
    public Context context;
    public int dividerColor;
    public DividerType dividerType;
    public int drawCenterContentStart;
    public int drawOutContentStart;
    public float firstLineY;
    public GestureDetector gestureDetector;
    public Handler handler;
    public int initPosition;
    public boolean isCenterLabel;
    public boolean isLoop;
    public boolean isOptions;
    public float itemHeight;
    public int itemsVisible;
    public String label;
    public float lineSpacingMultiplier;
    public ScheduledExecutorService mExecutor;
    public ScheduledFuture<?> mFuture;
    public int mGravity;
    public int mOffset;
    public int maxTextHeight;
    public int maxTextWidth;
    public int measuredHeight;
    public int measuredWidth;
    public OnItemSelectedListener onItemSelectedListener;
    public Paint paintCenterText;
    public Paint paintIndicator;
    public Paint paintOuterText;
    public int preCurrentIndex;
    public float previousY;
    public int radius;
    public float secondLineY;
    public int selectedItem;
    public long startTime;
    public int textColorCenter;
    public int textColorOut;
    public int textSize;
    public int textXOffset;
    public float totalScrollY;
    public Typeface typeface;
    public int widthMeasureSpec;

    /* loaded from: classes4.dex */
    public enum ACTION {
        CLICK,
        FLING,
        DAGGLE
    }

    /* loaded from: classes4.dex */
    public enum DividerType {
        FILL,
        WRAP
    }

    public WheelView3d(Context context) {
        this(context, null);
    }

    private int getLoopMappingIndex(int i) {
        if (i < 0) {
            return getLoopMappingIndex(i + this.adapter.getItemsCount());
        }
        if (i > this.adapter.getItemsCount() - 1) {
            return getLoopMappingIndex(i - this.adapter.getItemsCount());
        }
        return i;
    }

    private void initLoopView(Context context) {
        this.context = context;
        this.handler = new MessageHandler(this);
        GestureDetector gestureDetector = new GestureDetector(context, new LoopViewGestureListener(this));
        this.gestureDetector = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.isLoop = true;
        this.totalScrollY = 0.0f;
        this.initPosition = -1;
        initPaints();
    }

    public void isCenterLabel(boolean z) {
        this.isCenterLabel = z;
    }

    public final void scrollBy(float f) {
        cancelFuture();
        this.mFuture = this.mExecutor.scheduleWithFixedDelay(new InertiaTimerTask(this, f), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public final void setAdapter(WheelAdapter wheelAdapter) {
        this.adapter = wheelAdapter;
        remeasure();
        invalidate();
    }

    public final void setCurrentItem(int i) {
        this.selectedItem = i;
        this.initPosition = i;
        this.totalScrollY = 0.0f;
        invalidate();
    }

    public final void setCyclic(boolean z) {
        this.isLoop = z;
    }

    public void setDividerColor(int i) {
        this.dividerColor = i;
        this.paintIndicator.setColor(i);
    }

    public void setDividerType(DividerType dividerType) {
        this.dividerType = dividerType;
    }

    public void setGravity(int i) {
        this.mGravity = i;
    }

    public void setIsOptions(boolean z) {
        this.isOptions = z;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setLineSpacingMultiplier(float f) {
        if (f != 0.0f) {
            this.lineSpacingMultiplier = f;
            judgeLineSpace();
        }
    }

    public final void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.onItemSelectedListener = onItemSelectedListener;
    }

    public void setTextColorCenter(int i) {
        this.textColorCenter = i;
        this.paintCenterText.setColor(i);
    }

    public void setTextColorOut(int i) {
        this.textColorOut = i;
        this.paintOuterText.setColor(i);
    }

    public final void setTextSize(int i) {
        float f = i;
        if (f > 0.0f) {
            this.textSize = i;
            this.paintOuterText.setTextSize(f);
            this.paintCenterText.setTextSize(f);
        }
    }

    public void setTextXOffset(int i) {
        this.textXOffset = i;
        if (i != 0) {
            this.paintCenterText.setTextScaleX(1.0f);
        }
    }

    public void setTotalScrollY(float f) {
        this.totalScrollY = f;
    }

    public final void setTypeface(Typeface typeface) {
        this.typeface = typeface;
        this.paintOuterText.setTypeface(typeface);
        this.paintCenterText.setTypeface(this.typeface);
    }

    public WheelView3d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isOptions = false;
        this.isCenterLabel = true;
        this.mExecutor = Executors.newSingleThreadScheduledExecutor();
        this.typeface = Typeface.MONOSPACE;
        this.lineSpacingMultiplier = 1.6f;
        this.itemsVisible = 5;
        this.mOffset = 0;
        this.previousY = 0.0f;
        this.startTime = 0L;
        this.mGravity = 17;
        this.drawCenterContentStart = 0;
        this.drawOutContentStart = 0;
        this.textSize = 20;
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.centerContentOffset = 2.4f;
        } else {
            int i = (1.0f > f ? 1 : (1.0f == f ? 0 : -1));
            if (i <= 0 && f < 2.0f) {
                this.centerContentOffset = 3.6f;
            } else if (i <= 0 && f < 2.0f) {
                this.centerContentOffset = 4.5f;
            } else if (2.0f <= f && f < 3.0f) {
                this.centerContentOffset = 6.0f;
            } else if (f >= 3.0f) {
                this.centerContentOffset = f * 2.5f;
            }
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.pickerview, 0, 0);
            this.mGravity = obtainStyledAttributes.getInt(1, 17);
            this.textColorOut = obtainStyledAttributes.getColor(4, -5723992);
            this.textColorCenter = obtainStyledAttributes.getColor(3, -14013910);
            this.dividerColor = obtainStyledAttributes.getColor(0, -2763307);
            this.textSize = obtainStyledAttributes.getDimensionPixelOffset(5, this.textSize);
            this.lineSpacingMultiplier = obtainStyledAttributes.getFloat(2, this.lineSpacingMultiplier);
            obtainStyledAttributes.recycle();
        }
        judgeLineSpace();
        initLoopView(context);
    }

    private String getContentText(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof IPickerViewData) {
            return ((IPickerViewData) obj).getPickerViewText();
        }
        if (obj instanceof Integer) {
            return String.format(Locale.getDefault(), "%02d", Integer.valueOf(((Integer) obj).intValue()));
        }
        return obj.toString();
    }

    private void reMeasureTextSize(String str) {
        Rect rect = new Rect();
        this.paintCenterText.getTextBounds(str, 0, str.length(), rect);
        int i = this.textSize;
        for (int width = rect.width(); width > this.measuredWidth; width = rect.width()) {
            i--;
            this.paintCenterText.setTextSize(i);
            this.paintCenterText.getTextBounds(str, 0, str.length(), rect);
        }
        this.paintOuterText.setTextSize(i);
    }

    public void smoothScroll(ACTION action) {
        cancelFuture();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            float f = this.totalScrollY;
            float f2 = this.itemHeight;
            int i = (int) (((f % f2) + f2) % f2);
            this.mOffset = i;
            if (i > f2 / 2.0f) {
                this.mOffset = (int) (f2 - i);
            } else {
                this.mOffset = -i;
            }
        }
        this.mFuture = this.mExecutor.scheduleWithFixedDelay(new SmoothScrollTimerTask(this, this.mOffset), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    private void initPaints() {
        Paint paint = new Paint();
        this.paintOuterText = paint;
        paint.setColor(this.textColorOut);
        this.paintOuterText.setAntiAlias(true);
        this.paintOuterText.setTypeface(this.typeface);
        this.paintOuterText.setTextSize(this.textSize);
        Paint paint2 = new Paint();
        this.paintCenterText = paint2;
        paint2.setColor(this.textColorCenter);
        this.paintCenterText.setAntiAlias(true);
        this.paintCenterText.setTextScaleX(1.1f);
        this.paintCenterText.setTypeface(this.typeface);
        this.paintCenterText.setTextSize(this.textSize);
        Paint paint3 = new Paint();
        this.paintIndicator = paint3;
        paint3.setColor(this.dividerColor);
        this.paintIndicator.setAntiAlias(true);
        setLayerType(1, null);
    }

    private void measureTextWidthHeight() {
        Rect rect = new Rect();
        for (int i = 0; i < this.adapter.getItemsCount(); i++) {
            String contentText = getContentText(this.adapter.getItem(i));
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

    private void remeasure() {
        if (this.adapter == null) {
            return;
        }
        measureTextWidthHeight();
        int i = (int) (this.itemHeight * (this.itemsVisible - 1));
        this.measuredHeight = (int) ((i * 2) / 3.141592653589793d);
        this.radius = (int) (i / 3.141592653589793d);
        this.measuredWidth = View.MeasureSpec.getSize(this.widthMeasureSpec);
        int i2 = this.measuredHeight;
        float f = this.itemHeight;
        this.firstLineY = (i2 - f) / 2.0f;
        float f2 = (i2 + f) / 2.0f;
        this.secondLineY = f2;
        this.centerY = (f2 - ((f - this.maxTextHeight) / 2.0f)) - this.centerContentOffset;
        if (this.initPosition == -1) {
            if (this.isLoop) {
                this.initPosition = (this.adapter.getItemsCount() + 1) / 2;
            } else {
                this.initPosition = 0;
            }
        }
        this.preCurrentIndex = this.initPosition;
    }

    public final int getCurrentItem() {
        int i;
        WheelAdapter wheelAdapter = this.adapter;
        if (wheelAdapter == null) {
            return 0;
        }
        if (this.isLoop && ((i = this.selectedItem) < 0 || i >= wheelAdapter.getItemsCount())) {
            return Math.max(0, Math.min(Math.abs(Math.abs(this.selectedItem) - this.adapter.getItemsCount()), this.adapter.getItemsCount() - 1));
        }
        return Math.max(0, Math.min(this.selectedItem, this.adapter.getItemsCount() - 1));
    }

    private void judgeLineSpace() {
        float f = this.lineSpacingMultiplier;
        if (f < 1.0f) {
            this.lineSpacingMultiplier = 1.0f;
        } else if (f > 4.0f) {
            this.lineSpacingMultiplier = 4.0f;
        }
    }

    public void cancelFuture() {
        ScheduledFuture<?> scheduledFuture = this.mFuture;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            this.mFuture.cancel(true);
            this.mFuture = null;
        }
    }

    public final WheelAdapter getAdapter() {
        return this.adapter;
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.handler;
    }

    public int getInitPosition() {
        return this.initPosition;
    }

    public float getItemHeight() {
        return this.itemHeight;
    }

    public int getItemsCount() {
        WheelAdapter wheelAdapter = this.adapter;
        if (wheelAdapter != null) {
            return wheelAdapter.getItemsCount();
        }
        return 0;
    }

    public float getTotalScrollY() {
        return this.totalScrollY;
    }

    public boolean isLoop() {
        return this.isLoop;
    }

    public final void onItemSelected() {
        if (this.onItemSelectedListener != null) {
            postDelayed(new Runnable() { // from class: com.baidu.searchbox.ui.wheelview3d.WheelView3d.1
                @Override // java.lang.Runnable
                public void run() {
                    WheelView3d.this.onItemSelectedListener.onItemSelected(WheelView3d.this.getCurrentItem());
                }
            }, 200L);
        }
    }

    private void measuredCenterContentStart(String str) {
        String str2;
        Rect rect = new Rect();
        this.paintCenterText.getTextBounds(str, 0, str.length(), rect);
        int i = this.mGravity;
        if (i != 3) {
            if (i != 5) {
                if (i == 17) {
                    if (!this.isOptions && (str2 = this.label) != null && !str2.equals("") && this.isCenterLabel) {
                        this.drawCenterContentStart = (int) ((this.measuredWidth - rect.width()) * 0.25d);
                        return;
                    } else {
                        this.drawCenterContentStart = (int) ((this.measuredWidth - rect.width()) * 0.5d);
                        return;
                    }
                }
                return;
            }
            this.drawCenterContentStart = (this.measuredWidth - rect.width()) - ((int) this.centerContentOffset);
            return;
        }
        this.drawCenterContentStart = 0;
    }

    private void measuredOutContentStart(String str) {
        String str2;
        Rect rect = new Rect();
        this.paintOuterText.getTextBounds(str, 0, str.length(), rect);
        int i = this.mGravity;
        if (i != 3) {
            if (i != 5) {
                if (i == 17) {
                    if (!this.isOptions && (str2 = this.label) != null && !str2.equals("") && this.isCenterLabel) {
                        this.drawOutContentStart = (int) ((this.measuredWidth - rect.width()) * 0.25d);
                        return;
                    } else {
                        this.drawOutContentStart = (int) ((this.measuredWidth - rect.width()) * 0.5d);
                        return;
                    }
                }
                return;
            }
            this.drawOutContentStart = (this.measuredWidth - rect.width()) - ((int) this.centerContentOffset);
            return;
        }
        this.drawOutContentStart = 0;
    }

    public int getTextWidth(Paint paint, String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        float[] fArr = new float[length];
        paint.getTextWidths(str, fArr);
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i += (int) Math.ceil(fArr[i2]);
        }
        return i;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        this.widthMeasureSpec = i;
        remeasure();
        setMeasuredDimension(this.measuredWidth, this.measuredHeight);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        String contentText;
        int i;
        int i2;
        float f;
        if (this.adapter == null) {
            return;
        }
        int min = Math.min(Math.max(0, this.initPosition), this.adapter.getItemsCount() - 1);
        this.initPosition = min;
        Object[] objArr = new Object[this.itemsVisible];
        int i3 = (int) (this.totalScrollY / this.itemHeight);
        this.change = i3;
        try {
            this.preCurrentIndex = min + (i3 % this.adapter.getItemsCount());
        } catch (ArithmeticException unused) {
            Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
        }
        if (!this.isLoop) {
            if (this.preCurrentIndex < 0) {
                this.preCurrentIndex = 0;
            }
            if (this.preCurrentIndex > this.adapter.getItemsCount() - 1) {
                this.preCurrentIndex = this.adapter.getItemsCount() - 1;
            }
        } else {
            if (this.preCurrentIndex < 0) {
                this.preCurrentIndex = this.adapter.getItemsCount() + this.preCurrentIndex;
            }
            if (this.preCurrentIndex > this.adapter.getItemsCount() - 1) {
                this.preCurrentIndex -= this.adapter.getItemsCount();
            }
        }
        float f2 = this.totalScrollY % this.itemHeight;
        int i4 = 0;
        while (true) {
            int i5 = this.itemsVisible;
            if (i4 >= i5) {
                break;
            }
            int i6 = this.preCurrentIndex - ((i5 / 2) - i4);
            if (this.isLoop) {
                objArr[i4] = this.adapter.getItem(getLoopMappingIndex(i6));
            } else if (i6 < 0) {
                objArr[i4] = "";
            } else if (i6 > this.adapter.getItemsCount() - 1) {
                objArr[i4] = "";
            } else {
                objArr[i4] = this.adapter.getItem(i6);
            }
            i4++;
        }
        if (this.dividerType == DividerType.WRAP) {
            if (TextUtils.isEmpty(this.label)) {
                i2 = (this.measuredWidth - this.maxTextWidth) / 2;
            } else {
                i2 = (this.measuredWidth - this.maxTextWidth) / 4;
            }
            float f3 = i2 - 12;
            if (f3 <= 0.0f) {
                f = 10.0f;
            } else {
                f = f3;
            }
            float f4 = this.measuredWidth - f;
            float f5 = this.firstLineY;
            float f6 = f;
            canvas.drawLine(f6, f5, f4, f5, this.paintIndicator);
            float f7 = this.secondLineY;
            canvas.drawLine(f6, f7, f4, f7, this.paintIndicator);
        } else {
            float f8 = this.firstLineY;
            canvas.drawLine(0.0f, f8, this.measuredWidth, f8, this.paintIndicator);
            float f9 = this.secondLineY;
            canvas.drawLine(0.0f, f9, this.measuredWidth, f9, this.paintIndicator);
        }
        if (!TextUtils.isEmpty(this.label) && this.isCenterLabel) {
            canvas.drawText(this.label, (this.measuredWidth - getTextWidth(this.paintCenterText, this.label)) - this.centerContentOffset, this.centerY, this.paintCenterText);
        }
        for (int i7 = 0; i7 < this.itemsVisible; i7++) {
            canvas.save();
            double d = ((this.itemHeight * i7) - f2) / this.radius;
            float f10 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
            if (f10 < 90.0f && f10 > -90.0f) {
                float pow = (float) Math.pow(Math.abs(f10) / 90.0f, 2.2d);
                if (!this.isCenterLabel && !TextUtils.isEmpty(this.label) && !TextUtils.isEmpty(getContentText(objArr[i7]))) {
                    contentText = getContentText(objArr[i7]) + this.label;
                } else {
                    contentText = getContentText(objArr[i7]);
                }
                reMeasureTextSize(contentText);
                measuredCenterContentStart(contentText);
                measuredOutContentStart(contentText);
                float cos = (float) ((this.radius - (Math.cos(d) * this.radius)) - ((Math.sin(d) * this.maxTextHeight) / 2.0d));
                canvas.translate(0.0f, cos);
                float f11 = this.firstLineY;
                if (cos <= f11 && this.maxTextHeight + cos >= f11) {
                    canvas.save();
                    canvas.clipRect(0.0f, 0.0f, this.measuredWidth, this.firstLineY - cos);
                    canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                    canvas.drawText(contentText, this.drawOutContentStart, this.maxTextHeight, this.paintOuterText);
                    canvas.restore();
                    canvas.save();
                    canvas.clipRect(0.0f, this.firstLineY - cos, this.measuredWidth, (int) this.itemHeight);
                    canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                    canvas.drawText(contentText, this.drawCenterContentStart, this.maxTextHeight - this.centerContentOffset, this.paintCenterText);
                    canvas.restore();
                } else {
                    float f12 = this.secondLineY;
                    if (cos <= f12 && this.maxTextHeight + cos >= f12) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.measuredWidth, this.secondLineY - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(contentText, this.drawCenterContentStart, this.maxTextHeight - this.centerContentOffset, this.paintCenterText);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.secondLineY - cos, this.measuredWidth, (int) this.itemHeight);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(contentText, this.drawOutContentStart, this.maxTextHeight, this.paintOuterText);
                        canvas.restore();
                    } else {
                        if (cos >= this.firstLineY) {
                            int i8 = this.maxTextHeight;
                            if (i8 + cos <= this.secondLineY) {
                                canvas.drawText(contentText, this.drawCenterContentStart, i8 - this.centerContentOffset, this.paintCenterText);
                                this.selectedItem = this.preCurrentIndex - ((this.itemsVisible / 2) - i7);
                            }
                        }
                        canvas.save();
                        canvas.clipRect(0, 0, this.measuredWidth, (int) this.itemHeight);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        Paint paint = this.paintOuterText;
                        int i9 = this.textXOffset;
                        int i10 = -1;
                        if (i9 == 0) {
                            i = 0;
                        } else if (i9 > 0) {
                            i = 1;
                        } else {
                            i = -1;
                        }
                        if (f10 <= 0.0f) {
                            i10 = 1;
                        }
                        paint.setTextSkewX(i * i10 * 0.5f * pow);
                        this.paintOuterText.setAlpha((int) ((1.0f - pow) * 255.0f));
                        canvas.drawText(contentText, this.drawOutContentStart + (this.textXOffset * pow), this.maxTextHeight, this.paintOuterText);
                        canvas.restore();
                        canvas.restore();
                        this.paintCenterText.setTextSize(this.textSize);
                    }
                }
                canvas.restore();
                this.paintCenterText.setTextSize(this.textSize);
            } else {
                canvas.restore();
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.gestureDetector.onTouchEvent(motionEvent);
        float f = (-this.initPosition) * this.itemHeight;
        float itemsCount = ((this.adapter.getItemsCount() - 1) - this.initPosition) * this.itemHeight;
        int action = motionEvent.getAction();
        boolean z = false;
        if (action != 0) {
            if (action != 2) {
                if (!onTouchEvent) {
                    float y = motionEvent.getY();
                    int i = this.radius;
                    float f2 = this.itemHeight;
                    this.mOffset = (int) (((((int) (((Math.acos((i - y) / i) * this.radius) + (f2 / 2.0f)) / f2)) - (this.itemsVisible / 2)) * f2) - (((this.totalScrollY % f2) + f2) % f2));
                    if (System.currentTimeMillis() - this.startTime > 120) {
                        smoothScroll(ACTION.DAGGLE);
                    } else {
                        smoothScroll(ACTION.CLICK);
                    }
                }
            } else {
                float rawY = this.previousY - motionEvent.getRawY();
                this.previousY = motionEvent.getRawY();
                float f3 = this.totalScrollY + rawY;
                this.totalScrollY = f3;
                if (!this.isLoop && ((f3 - (this.itemHeight * 0.25f) < f && rawY < 0.0f) || (this.totalScrollY + (this.itemHeight * 0.25f) > itemsCount && rawY > 0.0f))) {
                    this.totalScrollY -= rawY;
                    z = true;
                }
            }
        } else {
            this.startTime = System.currentTimeMillis();
            cancelFuture();
            this.previousY = motionEvent.getRawY();
        }
        if (!z && motionEvent.getAction() != 0) {
            invalidate();
        }
        return true;
    }
}
