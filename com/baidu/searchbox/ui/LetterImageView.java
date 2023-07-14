package com.baidu.searchbox.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.searchbox.skin.NightModeHelper;
/* loaded from: classes4.dex */
public class LetterImageView extends ImageView {
    public static final boolean DEBUG = false;
    public static final String TAG = "LetterImageView";
    public static float[] mHsb = null;
    public static int sNightModeAlpha = 115;
    public static float sSaturation = 0.41f;
    public static float sValue = 1.0f;
    public boolean isOval;
    public Paint mBackgroundPaint;
    public String mLetter;
    public String mShowLetter;
    public final Rect mTempRect;
    public int mTextColor;
    public Paint mTextPaint;
    public int mTextSize;

    static {
        mHsb = r0;
        float[] fArr = {0.0f, 0.41f, 1.0f};
    }

    private float getTextPadding() {
        return getResources().getDisplayMetrics().density * 16.0f;
    }

    private int randomColor() {
        return Color.parseColor(ShareLoginStat.GetShareListStat.KEY_GRAY);
    }

    public String getLetter() {
        return this.mLetter;
    }

    public int getTextColor() {
        return this.mTextColor;
    }

    public int getTextSize() {
        return this.mTextSize;
    }

    public boolean isOval() {
        return this.isOval;
    }

    public LetterImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTextColor = -1;
        this.mShowLetter = null;
        this.mTempRect = new Rect();
        init();
    }

    public static synchronized int generateColorBylong(long j) {
        int realGenerateColor;
        synchronized (LetterImageView.class) {
            realGenerateColor = realGenerateColor(j);
        }
        return realGenerateColor;
    }

    private String generateShowLetter(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.substring(0, 1);
        }
        return null;
    }

    public static int realGenerateColor(long j) {
        return Color.parseColor(new String[]{"#63D2FB", "#4DA3FA", "#FFAB43", "#FF7C78", "#91E257", "#FFC93C", "#50D5D2", "#DC85FF", "#FD7CB6", "#9988FF"}[(int) (j % 10)]);
    }

    public void setBackgroundColorMark(long j) {
        if (j > 0) {
            this.mBackgroundPaint.setColor(generateColorBylong(j));
            if (NightModeHelper.getNightModeSwitcherState()) {
                this.mBackgroundPaint.setAlpha(sNightModeAlpha);
            }
            invalidate();
        }
    }

    public void setLetter(String str) {
        this.mLetter = str;
        this.mShowLetter = generateShowLetter(str);
        invalidate();
    }

    public void setOval(boolean z) {
        this.isOval = z;
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        invalidate();
    }

    public void setTextSize(int i) {
        this.mTextSize = i;
        this.mTextPaint.setTextSize(i);
    }

    private void init() {
        boolean nightModeSwitcherState = NightModeHelper.getNightModeSwitcherState();
        if (this.mTextSize <= 0) {
            this.mTextSize = UIRuntime.getAppContext().getResources().getDimensionPixelSize(com.baidu.tieba.R.dimen.obfuscated_res_0x7f07058c);
        }
        Paint paint = new Paint(1);
        this.mTextPaint = paint;
        paint.setColor(this.mTextColor);
        this.mTextPaint.setTextSize(this.mTextSize);
        if (nightModeSwitcherState) {
            this.mTextPaint.setAlpha(sNightModeAlpha);
        }
        Paint paint2 = new Paint(1);
        this.mBackgroundPaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.mBackgroundPaint.setColor(randomColor());
        if (nightModeSwitcherState) {
            this.mBackgroundPaint.setAlpha(sNightModeAlpha);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    @SuppressLint({"CanvasSize"})
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getDrawable() == null) {
            if (isOval()) {
                canvas.drawCircle(canvas.getWidth() / 2.0f, canvas.getHeight() / 2.0f, Math.min(canvas.getWidth(), canvas.getHeight()) / 2.0f, this.mBackgroundPaint);
            } else {
                canvas.drawRect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), this.mBackgroundPaint);
            }
            if (TextUtils.isEmpty(this.mShowLetter)) {
                return;
            }
            Rect rect = this.mTempRect;
            this.mTextPaint.getTextBounds(this.mShowLetter, 0, 1, rect);
            float measureText = this.mTextPaint.measureText(String.valueOf(this.mShowLetter));
            rect.height();
            canvas.getHeight();
            canvas.drawText(String.valueOf(this.mShowLetter), (canvas.getWidth() / 2.0f) - (measureText / 2.0f), (canvas.getHeight() / 2) - ((this.mTextPaint.descent() + this.mTextPaint.ascent()) / 2.0f), this.mTextPaint);
        }
    }
}
