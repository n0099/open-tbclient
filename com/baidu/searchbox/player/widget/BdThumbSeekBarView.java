package com.baidu.searchbox.player.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class BdThumbSeekBarView extends View {
    public static final int BUFFERING_PAINT_COLOR = -2039584;
    public static final float DEFAULT_MAX = 100.0f;
    public static final int PLAYED_PAINT_COLOR = -16738561;
    public static final boolean SEEKBAR_SCALE_FLAG = true;
    public static final String TAG = "BdThumbSeekBarView";
    public static final int UI_DRAG_TRACE_COLOR = -2130706433;
    public static final int UI_SEEKBAR_DEFAULT_PADDING = 0;
    public static final int UI_SEEKBAR_DEFAULT_WIDTH = 50;
    public static final int UI_SEEKBAR_RIGHT_PADDING = 5;
    public static final int UI_SEEKBAR_SELECT_HEGHT = 3;
    public static final int UI_SEEKBAR_THUMB_PADDING = 0;
    public static final int UI_SEEKBAR_TRACE_HEIGHT = 1;
    public static final int UI_SELECT_COLOR_START = -16366706;
    public static final float UI_THUMB_SCALE = 1.5f;
    public static final int UI_TRACE_COLOR = 1291845632;
    public static final int UI_TRANSLATE_Y = 0;
    public final Paint mBufferingPaint;
    public int mBufferingProgress;
    public final int mDefaultWidth;
    public SeekBarDirect mDirect;
    public final RectF mDrawRectF;
    public boolean mIsDragable;
    public OnBdSeekBarChangeListener mListener;
    public float mMax;
    public boolean mNeedThumbScale;
    public final Paint mPaint;
    public float mProgress;
    public BdSeeBarStatus mSeeBarStatus;
    public final Paint mSeekPaint;
    public LinearGradient mSeekShader;
    public final BdSeekBarStyle mStyle;
    public Bitmap mThumb;
    public final int mThumbPadding;
    public Bitmap mThumbScale;
    public final int mUIRightSpace;
    public final int mUISelectHeight;
    public final int mUISpace;
    public final int mUITraceHeight;

    /* loaded from: classes4.dex */
    public enum BdSeeBarStatus {
        None,
        Seek
    }

    /* loaded from: classes4.dex */
    public enum BdSeekBarStyle {
        LINE,
        ROUND_RECT
    }

    /* loaded from: classes4.dex */
    public interface OnBdSeekBarChangeListener {
        void onProgressChanged(BdThumbSeekBarView bdThumbSeekBarView, int i, boolean z);

        void onStartTrackingTouch(BdThumbSeekBarView bdThumbSeekBarView);

        void onStopTrackingTouch(BdThumbSeekBarView bdThumbSeekBarView);
    }

    /* loaded from: classes4.dex */
    public enum SeekBarDirect {
        Vertical,
        Horizontal
    }

    /* renamed from: com.baidu.searchbox.player.widget.BdThumbSeekBarView$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$player$widget$BdThumbSeekBarView$BdSeekBarStyle;

        static {
            int[] iArr = new int[BdSeekBarStyle.values().length];
            $SwitchMap$com$baidu$searchbox$player$widget$BdThumbSeekBarView$BdSeekBarStyle = iArr;
            try {
                iArr[BdSeekBarStyle.LINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$player$widget$BdThumbSeekBarView$BdSeekBarStyle[BdSeekBarStyle.ROUND_RECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public BdThumbSeekBarView(Context context, int i) {
        this(context, BdSeekBarStyle.LINE, i);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        specifyPadding();
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
        computeDrawRect();
    }

    public void syncPos(int i, int i2) {
        setBufferingProgress(i2);
        setProgress(i);
    }

    public BdThumbSeekBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, BdSeekBarStyle.LINE, 1);
    }

    public BdThumbSeekBarView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, BdSeekBarStyle.LINE, 1);
    }

    public void syncPos(int i, int i2, int i3) {
        setMax(i2);
        setBufferingProgress(i3);
        setProgress(i);
    }

    public BdThumbSeekBarView(Context context, AttributeSet attributeSet, int i, BdSeekBarStyle bdSeekBarStyle, int i2) {
        super(context, attributeSet, i);
        this.mSeeBarStatus = BdSeeBarStatus.None;
        this.mNeedThumbScale = true;
        this.mDirect = SeekBarDirect.Horizontal;
        this.mIsDragable = true;
        setClickable(true);
        this.mStyle = bdSeekBarStyle;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setColor(getResources().getColor(R.color.obfuscated_res_0x7f0604a1));
        Paint paint2 = new Paint();
        this.mSeekPaint = paint2;
        paint2.setAntiAlias(true);
        this.mSeekPaint.setColor(getResources().getColor(R.color.obfuscated_res_0x7f0604a3));
        Paint paint3 = new Paint();
        this.mBufferingPaint = paint3;
        paint3.setAntiAlias(true);
        this.mBufferingPaint.setColor(getResources().getColor(R.color.obfuscated_res_0x7f0604a2));
        this.mMax = 100.0f;
        this.mProgress = 0.0f;
        this.mBufferingProgress = 0;
        if (this.mThumb == null) {
            this.mThumb = BitmapFactory.decodeResource(context.getResources(), R.drawable.obfuscated_res_0x7f080282);
        }
        this.mThumbPadding = BdPlayerUtils.dp2px(this, 0.0f);
        if (this.mThumbScale == null) {
            scaleThumb(1.5f);
        }
        this.mDrawRectF = new RectF();
        float f = getResources().getDisplayMetrics().density;
        this.mUISpace = (int) (0.0f * f);
        this.mUIRightSpace = (int) (5.0f * f);
        this.mUITraceHeight = (int) ((i2 * f) + 0.5d);
        this.mDefaultWidth = (int) (50.0f * f);
        this.mUISelectHeight = (int) (f * 3.0f);
        BdVideoLog.d(TAG, "mUITraceHeight: " + this.mUITraceHeight);
    }

    public BdThumbSeekBarView(Context context, AttributeSet attributeSet, BdSeekBarStyle bdSeekBarStyle, int i) {
        this(context, attributeSet, 0, bdSeekBarStyle, i);
    }

    public BdThumbSeekBarView(Context context, BdSeekBarStyle bdSeekBarStyle, int i) {
        this(context, null, bdSeekBarStyle, i);
    }

    private void computeDrawRect() {
        int i = AnonymousClass1.$SwitchMap$com$baidu$searchbox$player$widget$BdThumbSeekBarView$BdSeekBarStyle[this.mStyle.ordinal()];
        if (i != 1) {
            if (i == 2) {
                this.mDrawRectF.top = (((getMeasuredHeight() - this.mUISelectHeight) + getPaddingTop()) - getPaddingBottom()) >> 1;
                RectF rectF = this.mDrawRectF;
                rectF.bottom = rectF.top + this.mUISelectHeight;
            }
        } else if (this.mDirect == SeekBarDirect.Horizontal) {
            this.mDrawRectF.left = getPaddingLeft();
            this.mDrawRectF.right = getMeasuredWidth() - getPaddingRight();
            this.mDrawRectF.top = (((getMeasuredHeight() - this.mUITraceHeight) + getPaddingTop()) - getPaddingBottom()) >> 1;
            RectF rectF2 = this.mDrawRectF;
            rectF2.bottom = rectF2.top + this.mUITraceHeight;
        } else {
            this.mDrawRectF.top = getPaddingTop();
            this.mDrawRectF.bottom = getMeasuredHeight() - getPaddingBottom();
            this.mDrawRectF.left = (((getMeasuredWidth() - this.mUITraceHeight) + getPaddingLeft()) - getPaddingRight()) >> 1;
            RectF rectF3 = this.mDrawRectF;
            rectF3.right = rectF3.left + this.mUITraceHeight;
        }
    }

    private int measureHeight(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int height = this.mThumb.getHeight() + getPaddingTop() + getPaddingBottom();
        if (mode == Integer.MIN_VALUE) {
            if (height > size) {
                scaleThumb(((size - getPaddingTop()) - getPaddingBottom()) / this.mThumb.getHeight());
                return size;
            }
        } else if (mode == 1073741824) {
            if (height > size) {
                scaleThumb(((size - getPaddingTop()) - getPaddingBottom()) / this.mThumb.getHeight());
                return size;
            }
            return size;
        }
        return height;
    }

    private int measureWidth(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int width = this.mThumb.getWidth() + getPaddingLeft() + getPaddingRight();
        int i2 = this.mDefaultWidth;
        int i3 = width + i2;
        if (mode == Integer.MIN_VALUE) {
            if (i3 - i2 > size) {
                scaleThumb(((size - getPaddingLeft()) - getPaddingRight()) / this.mThumb.getWidth());
                return size;
            }
        } else if (mode == 1073741824) {
            if (i3 - i2 > size) {
                scaleThumb(((size - getPaddingLeft()) - getPaddingRight()) / this.mThumb.getHeight());
                return size;
            }
            return size;
        }
        return i3;
    }

    private void scaleThumb(float f) {
        if (f > 0.0f) {
            Matrix matrix = new Matrix();
            matrix.postScale(f, f);
            Bitmap bitmap = this.mThumb;
            this.mThumbScale = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.mThumb.getHeight(), matrix, true);
        }
    }

    public void setBufferColor(int i) {
        Paint paint = this.mBufferingPaint;
        if (paint != null) {
            paint.setColor(i);
        }
    }

    public void setBufferingProgress(int i) {
        this.mBufferingProgress = i;
    }

    public void setDragable(boolean z) {
        this.mIsDragable = z;
    }

    public void setMax(float f) {
        this.mMax = f;
    }

    public void setMaxDuration(int i) {
        setMax(i);
    }

    public void setOnSeekBarChangeListener(OnBdSeekBarChangeListener onBdSeekBarChangeListener) {
        this.mListener = onBdSeekBarChangeListener;
    }

    public void setProgress(float f) {
        this.mProgress = f;
        invalidate();
    }

    public void setProgressBackgroundColor(int i) {
        this.mPaint.setColor(i);
    }

    public void setProgressColor(int i) {
        this.mSeekPaint.setColor(i);
    }

    public void setScaleThumbBitmap(Bitmap bitmap) {
        this.mThumbScale = bitmap;
    }

    public void setSeekBarDirect(SeekBarDirect seekBarDirect) {
        this.mDirect = seekBarDirect;
    }

    public void setThumbBitmap(Bitmap bitmap) {
        this.mThumb = bitmap;
    }

    public void setThumbScaleVisible(boolean z) {
        this.mNeedThumbScale = z;
    }

    private void specifyPadding() {
        int paddingLeft = getPaddingLeft();
        if (paddingLeft <= 0) {
            paddingLeft = this.mUISpace;
        }
        int paddingTop = getPaddingTop();
        if (paddingTop <= 0) {
            paddingTop = this.mUISpace;
        }
        int paddingRight = getPaddingRight();
        if (paddingRight <= 0) {
            if (this.mNeedThumbScale) {
                paddingRight = this.mUISpace + this.mUIRightSpace;
            } else {
                paddingRight = this.mUISpace;
            }
        }
        int paddingBottom = getPaddingBottom();
        if (paddingBottom <= 0) {
            paddingBottom = this.mUISpace;
        }
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public float getMax() {
        return this.mMax;
    }

    public int getProgress() {
        return (int) this.mProgress;
    }

    public boolean isDragble() {
        return this.mIsDragable;
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
        int i3 = AnonymousClass1.$SwitchMap$com$baidu$searchbox$player$widget$BdThumbSeekBarView$BdSeekBarStyle[this.mStyle.ordinal()];
        float f3 = 0.0f;
        if (i3 != 1) {
            if (i3 == 2) {
                this.mPaint.setColor(UI_TRACE_COLOR);
                canvas.drawRoundRect(this.mDrawRectF, i >> 1, this.mUISelectHeight, this.mPaint);
                this.mPaint.setColor(UI_SELECT_COLOR_START);
                float f4 = this.mMax;
                if (f4 > 0.1f) {
                    float f5 = this.mProgress;
                    RectF rectF = this.mDrawRectF;
                    f3 = (f5 * (rectF.right - rectF.left)) / f4;
                }
                RectF rectF2 = this.mDrawRectF;
                rectF2.right = rectF2.left + f3;
                canvas.drawRoundRect(rectF2, i2 >> 1, this.mUISelectHeight, this.mPaint);
                canvas.drawBitmap(this.mThumb, this.mDrawRectF.right - (bitmap.getWidth() >> 1), (int) (this.mDrawRectF.top + ((this.mUISelectHeight - this.mThumb.getHeight()) >> 1)), (Paint) null);
            }
        } else {
            if (this.mNeedThumbScale) {
                this.mPaint.setColor(UI_DRAG_TRACE_COLOR);
            }
            canvas.drawRect(this.mDrawRectF, this.mPaint);
            RectF rectF3 = this.mDrawRectF;
            float f6 = rectF3.left;
            float abs = Math.abs(rectF3.right - f6);
            RectF rectF4 = this.mDrawRectF;
            float abs2 = Math.abs(rectF4.top - rectF4.bottom);
            if (this.mDirect == SeekBarDirect.Horizontal) {
                if (this.mMax > 0.1f) {
                    f2 = (this.mBufferingProgress * abs) / 100.0f;
                } else {
                    f2 = 0.0f;
                }
                RectF rectF5 = this.mDrawRectF;
                rectF5.right = rectF5.left + f2;
            } else {
                if (this.mMax > 0.1f) {
                    f = this.mBufferingProgress;
                } else {
                    f = 0.0f;
                }
                RectF rectF6 = this.mDrawRectF;
                rectF6.top = rectF6.bottom - f;
            }
            canvas.drawRect(this.mDrawRectF, this.mBufferingPaint);
            if (this.mDirect == SeekBarDirect.Horizontal) {
                float f7 = this.mMax;
                if (f7 > 0.1f) {
                    f3 = (this.mProgress * abs) / f7;
                }
                RectF rectF7 = this.mDrawRectF;
                rectF7.right = rectF7.left + f3;
            } else {
                float f8 = this.mMax;
                if (f8 > 0.1f) {
                    f3 = (this.mProgress * abs2) / f8;
                }
                RectF rectF8 = this.mDrawRectF;
                rectF8.top = rectF8.bottom - f3;
            }
            canvas.drawRect(this.mDrawRectF, this.mSeekPaint);
            if (this.mNeedThumbScale) {
                if (this.mDirect == SeekBarDirect.Horizontal) {
                    int width2 = (int) (this.mDrawRectF.right - (this.mThumb.getWidth() >> 1));
                    int i4 = this.mThumbPadding;
                    if (width2 < (-i4) + f6) {
                        width = (-i4) + f6;
                    } else {
                        float f9 = abs + f6;
                        if ((this.mThumb.getWidth() + width2) - this.mThumbPadding > f9) {
                            width = (f9 - this.mThumb.getWidth()) + this.mThumbPadding;
                        }
                        if (this.mSeeBarStatus != BdSeeBarStatus.Seek) {
                            canvas.drawBitmap(this.mThumbScale, width2, ((((getMeasuredHeight() - this.mThumbScale.getHeight()) + getPaddingTop()) - getPaddingBottom()) >> 1) + ((int) (0 * 1.5f)), (Paint) null);
                        } else {
                            canvas.drawBitmap(this.mThumb, Math.max(width2, -this.mThumbPadding), ((((getMeasuredHeight() - this.mThumb.getHeight()) + getPaddingTop()) - getPaddingBottom()) >> 1) + 0, (Paint) null);
                        }
                    }
                    width2 = (int) width;
                    if (this.mSeeBarStatus != BdSeeBarStatus.Seek) {
                    }
                } else {
                    int height = (int) (this.mDrawRectF.top - (this.mThumb.getHeight() >> 1));
                    if (this.mSeeBarStatus == BdSeeBarStatus.Seek) {
                        canvas.drawBitmap(this.mThumbScale, (((getMeasuredWidth() - this.mThumbScale.getWidth()) + getPaddingLeft()) - getPaddingRight()) >> 1, height, (Paint) null);
                    } else {
                        canvas.drawBitmap(this.mThumb, (((getMeasuredWidth() - this.mThumb.getWidth()) + getPaddingLeft()) - getPaddingRight()) >> 1, height, (Paint) null);
                    }
                }
            }
        }
        computeDrawRect();
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
        if (!this.mIsDragable) {
            return true;
        }
        if (this.mDirect == SeekBarDirect.Horizontal) {
            float x = motionEvent.getX();
            RectF rectF = this.mDrawRectF;
            float f = rectF.left;
            if (x < f) {
                x = f;
            } else {
                float f2 = rectF.right;
                if (x > f2) {
                    x = f2;
                }
            }
            RectF rectF2 = this.mDrawRectF;
            float f3 = rectF2.left;
            setProgress(((x - f3) * this.mMax) / (rectF2.right - f3));
        } else {
            float y = motionEvent.getY();
            RectF rectF3 = this.mDrawRectF;
            float f4 = rectF3.top;
            if (y < f4) {
                y = f4;
            } else {
                float f5 = rectF3.bottom;
                if (y > f5) {
                    y = f5;
                }
            }
            RectF rectF4 = this.mDrawRectF;
            float f6 = rectF4.bottom;
            setProgress(((f6 - y) * this.mMax) / (f6 - rectF4.top));
        }
        OnBdSeekBarChangeListener onBdSeekBarChangeListener = this.mListener;
        if (onBdSeekBarChangeListener != null) {
            this.mSeeBarStatus = BdSeeBarStatus.Seek;
            onBdSeekBarChangeListener.onProgressChanged(this, (int) this.mProgress, true);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
            }
            OnBdSeekBarChangeListener onBdSeekBarChangeListener2 = this.mListener;
            if (onBdSeekBarChangeListener2 != null) {
                onBdSeekBarChangeListener2.onStopTrackingTouch(this);
                this.mSeeBarStatus = BdSeeBarStatus.None;
            }
            getParent().requestDisallowInterceptTouchEvent(false);
        } else {
            OnBdSeekBarChangeListener onBdSeekBarChangeListener3 = this.mListener;
            if (onBdSeekBarChangeListener3 != null) {
                onBdSeekBarChangeListener3.onStartTrackingTouch(this);
                this.mSeeBarStatus = BdSeeBarStatus.Seek;
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
