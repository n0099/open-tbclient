package com.baidu.swan.game.ad.downloader.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextUtils;
import android.view.View;
import com.baidu.swan.game.ad.c;
/* loaded from: classes14.dex */
public class SwanAdDownloadButtonView extends View {
    private Paint dSa;
    private int dSb;
    private boolean dSc;
    private boolean dSd;
    private int dSe;
    private State dSf;
    private int mBgColor;
    private int mProgress;
    private float mRadius;
    private String mText;
    private int mTextColor;
    private Paint mTextPaint;
    private float mTextSize;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public enum State {
        PREPARE,
        DOWNLOADING,
        FINISH
    }

    public SwanAdDownloadButtonView(Context context) {
        super(context);
        this.dSa = new Paint();
        this.mTextPaint = new Paint();
        this.mTextColor = -1;
        this.dSe = 100;
        this.dSf = State.PREPARE;
        this.mRadius = -1.0f;
        this.dSa.setAntiAlias(true);
        this.mTextPaint.setAntiAlias(true);
        this.mTextSize = getResources().getDimensionPixelOffset(c.C0529c.swanapp_ad_dimens_14dp);
        this.mBgColor = context.getResources().getColor(c.b.swanapp_ad_download_button_default_bg_color);
        this.dSb = context.getResources().getColor(c.b.swanapp_ad_download_button_default_fg_color);
    }

    public SwanAdDownloadButtonView hz(boolean z) {
        this.dSd = z;
        return this;
    }

    public SwanAdDownloadButtonView hA(boolean z) {
        this.dSc = z;
        return this;
    }

    public SwanAdDownloadButtonView mf(int i) {
        this.mBgColor = i;
        return this;
    }

    public void setRadius(float f) {
        this.mRadius = f;
    }

    public void setProgress(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > this.dSe) {
            i = this.dSe;
        }
        this.mProgress = i;
        if (this.mProgress == 0) {
            this.dSf = State.PREPARE;
        } else if (this.mProgress == this.dSe) {
            this.dSf = State.FINISH;
        } else {
            this.dSf = State.DOWNLOADING;
        }
    }

    public void setText(String str) {
        this.mText = str;
    }

    public int getMax() {
        return this.dSe;
    }

    public void setMax(int i) {
        this.dSe = i;
    }

    public SwanAdDownloadButtonView mg(int i) {
        this.mTextColor = i;
        return this;
    }

    public SwanAdDownloadButtonView T(float f) {
        this.mTextSize = f;
        return this;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (getWidth() != 0 && getHeight() != 0 && !TextUtils.isEmpty(this.mText)) {
            if (!this.dSd) {
                A(canvas);
            } else {
                B(canvas);
            }
        }
    }

    private void A(Canvas canvas) {
        float f = 0.0f;
        RectF rectF = new RectF(0, 0, getWidth() + 0, getHeight() + 0);
        this.dSa.setColor(this.mBgColor);
        this.dSa.setStyle(Paint.Style.FILL);
        if (this.mRadius > 0.0f) {
            f = this.mRadius;
        } else if (this.dSc) {
            f = rectF.height() / 2.0f;
        }
        canvas.drawRoundRect(rectF, f, f, this.dSa);
        this.mTextPaint.setColor(this.mTextColor);
        this.mTextPaint.setTextSize(this.mTextSize);
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        canvas.drawText(this.mText, (getMeasuredWidth() - this.mTextPaint.measureText(this.mText)) / 2.0f, ((fontMetrics.descent - fontMetrics.ascent) / 2.0f) + ((getHeight() / 2) - fontMetrics.descent), this.mTextPaint);
    }

    private void B(Canvas canvas) {
        RectF rectF = new RectF(0, 0, getWidth(), getHeight());
        a(canvas, rectF);
        b(canvas, rectF);
        C(canvas);
    }

    private void a(Canvas canvas, RectF rectF) {
        float f = 0.0f;
        this.dSa.setColor(this.mBgColor);
        this.dSa.setStyle(Paint.Style.FILL);
        if (this.mRadius > 0.0f) {
            f = this.mRadius;
        } else if (this.dSc) {
            f = rectF.height() / 2.0f;
        }
        canvas.drawRoundRect(rectF, f, f, this.dSa);
    }

    private void b(Canvas canvas, RectF rectF) {
        float f = 0.0f;
        switch (this.dSf) {
            case DOWNLOADING:
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.FILL);
                float f2 = this.mProgress / this.dSe;
                paint.setShader(new LinearGradient(0.0f, 0.0f, rectF.width(), 0.0f, new int[]{this.dSb, 0}, new float[]{f2, f2 + 1.0E-4f}, Shader.TileMode.CLAMP));
                if (this.mRadius > 0.0f) {
                    f = this.mRadius;
                } else if (this.dSc) {
                    f = rectF.height() / 2.0f;
                }
                canvas.drawRoundRect(rectF, f, f, paint);
                return;
            case FINISH:
                this.dSa.setColor(this.dSb);
                this.dSa.setStyle(Paint.Style.FILL);
                if (this.mRadius > 0.0f) {
                    f = this.mRadius;
                } else if (this.dSc) {
                    f = rectF.height() / 2.0f;
                }
                canvas.drawRoundRect(rectF, f, f, this.dSa);
                return;
            default:
                return;
        }
    }

    private void C(Canvas canvas) {
        this.mTextPaint.setTextSize(this.mTextSize);
        float height = (canvas.getHeight() / 2) - ((this.mTextPaint.descent() / 2.0f) + (this.mTextPaint.ascent() / 2.0f));
        float measureText = this.mTextPaint.measureText(this.mText);
        this.mTextPaint.setColor(this.mTextColor);
        canvas.drawText(this.mText, (getMeasuredWidth() - measureText) / 2.0f, height, this.mTextPaint);
    }
}
