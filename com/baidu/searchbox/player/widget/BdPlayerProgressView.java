package com.baidu.searchbox.player.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.videoplayer.framework.R;
/* loaded from: classes2.dex */
public class BdPlayerProgressView extends View {
    public static final int CENTER = 0;
    public static final int DEFAULT_GRAVITY = 1;
    public static final String DEFAULT_PROGRESS_TIME_TEXT = "00:00:00";
    public static final float DEFAULT_TEXT_SIZE = 15.0f;
    public static final String DEFAULT_TIME_TEXT = "00:00";
    public static final int LEFT = 1;
    public static final int PROGRESS_MODE = 1;
    public static final int RIGHT = 2;
    public static final String TAG = "BdPlayerProgressView";
    public static final int TIME_MODE = 2;
    public int DEFAULT_HEIGHT;
    public int DEFAULT_WIDTH;
    public final int mGravity;
    public final Paint mPaint;
    public String mPositionText;
    public final int mProgressMode;
    public int mTextColor;
    public float mTextSize;
    public String mTimeText;

    public BdPlayerProgressView(Context context) {
        this(context, null);
    }

    private void drawProgressText(Canvas canvas) {
        Paint.FontMetricsInt fontMetricsInt = this.mPaint.getFontMetricsInt();
        int i = fontMetricsInt.top;
        int measuredHeight = (((getMeasuredHeight() - fontMetricsInt.bottom) + i) / 2) - i;
        canvas.drawText(this.mPositionText, calculateLeftOffest(this.mGravity, (int) this.mPaint.measureText(this.mPositionText)), measuredHeight, this.mPaint);
    }

    private void drawTimeText(Canvas canvas) {
        Paint.FontMetricsInt fontMetricsInt = this.mPaint.getFontMetricsInt();
        int i = fontMetricsInt.top;
        int measuredHeight = (((getMeasuredHeight() - fontMetricsInt.bottom) + i) / 2) - i;
        canvas.drawText(this.mTimeText, calculateLeftOffest(this.mGravity, (int) this.mPaint.measureText(this.mTimeText)), measuredHeight, this.mPaint);
    }

    private int setMeasuredHeight(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return this.DEFAULT_HEIGHT;
        }
        if (mode == Integer.MIN_VALUE) {
            return Math.min(this.DEFAULT_HEIGHT, size);
        }
        return this.DEFAULT_HEIGHT;
    }

    private int setMeasuredWidth(int i) {
        String str;
        if (this.mProgressMode == 1) {
            str = DEFAULT_PROGRESS_TIME_TEXT;
        } else {
            str = DEFAULT_TIME_TEXT;
        }
        int measureText = (int) this.mPaint.measureText(str);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        if (mode != Integer.MIN_VALUE) {
            return this.DEFAULT_WIDTH;
        }
        return measureText;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = this.mProgressMode;
        if (i == 1) {
            drawProgressText(canvas);
        } else if (i == 2) {
            drawTimeText(canvas);
        }
    }

    public void setPositionText(@NonNull String str) {
        if (this.mProgressMode == 1) {
            this.mPositionText = str;
            postInvalidate();
        }
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void setTextSize(float f) {
        this.mTextSize = f;
        this.mPaint.setTextSize(f);
        invalidate();
    }

    public void setTimeText(String str) {
        if (this.mProgressMode == 2) {
            this.mTimeText = str;
            postInvalidate();
        }
    }

    public BdPlayerProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private int calculateLeftOffest(int i, int i2) {
        int i3 = this.mGravity;
        if (i3 != 0) {
            if (i3 == 1 || i3 != 2) {
                return 0;
            }
            return getMeasuredWidth() - i2;
        }
        return (getMeasuredWidth() - i2) / 2;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(setMeasuredWidth(i), setMeasuredHeight(i2));
    }

    @SuppressLint({"CustomViewStyleable"})
    public BdPlayerProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPositionText = DEFAULT_PROGRESS_TIME_TEXT;
        this.DEFAULT_WIDTH = 0;
        this.DEFAULT_HEIGHT = 0;
        this.DEFAULT_WIDTH = BdPlayerUtils.dp2px(this, 120.0f);
        this.DEFAULT_HEIGHT = BdPlayerUtils.dp2px(this, 15.0f);
        TypedArray typedArray = null;
        try {
            typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.bdvideoplayer_bdPlayerProgressView);
            this.mTextSize = typedArray.getDimension(3, 15.0f);
            this.mTextColor = typedArray.getColor(1, -1);
            this.mGravity = typedArray.getInt(0, 1);
            this.mProgressMode = typedArray.getInt(2, 1);
            Paint paint = new Paint();
            this.mPaint = paint;
            paint.setAntiAlias(true);
            this.mPaint.setColor(this.mTextColor);
            this.mPaint.setTextSize(this.mTextSize);
            if (this.mProgressMode == 2) {
                this.mPaint.setFakeBoldText(true);
            }
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
    }

    public String getPositionText() {
        return this.mPositionText;
    }

    public int getTextColor() {
        return this.mTextColor;
    }

    public float getTextSize() {
        return this.mTextSize;
    }

    public String getTimeText() {
        return this.mTimeText;
    }
}
