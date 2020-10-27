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
    private Paint dGT;
    private int dGU;
    private boolean dGV;
    private boolean dGW;
    private int dGX;
    private State dGY;
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
        this.dGT = new Paint();
        this.mTextPaint = new Paint();
        this.mTextColor = -1;
        this.dGX = 100;
        this.dGY = State.PREPARE;
        this.mRadius = -1.0f;
        this.dGT.setAntiAlias(true);
        this.mTextPaint.setAntiAlias(true);
        this.mTextSize = getResources().getDimensionPixelOffset(c.C0507c.swanapp_ad_dimens_14dp);
        this.mBgColor = context.getResources().getColor(c.b.swanapp_ad_download_button_default_bg_color);
        this.dGU = context.getResources().getColor(c.b.swanapp_ad_download_button_default_fg_color);
    }

    public SwanAdDownloadButtonView gY(boolean z) {
        this.dGW = z;
        return this;
    }

    public SwanAdDownloadButtonView gZ(boolean z) {
        this.dGV = z;
        return this;
    }

    public SwanAdDownloadButtonView lB(int i) {
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
        if (i > this.dGX) {
            i = this.dGX;
        }
        this.mProgress = i;
        if (this.mProgress == 0) {
            this.dGY = State.PREPARE;
        } else if (this.mProgress == this.dGX) {
            this.dGY = State.FINISH;
        } else {
            this.dGY = State.DOWNLOADING;
        }
    }

    public void setText(String str) {
        this.mText = str;
    }

    public int getMax() {
        return this.dGX;
    }

    public void setMax(int i) {
        this.dGX = i;
    }

    public SwanAdDownloadButtonView lC(int i) {
        this.mTextColor = i;
        return this;
    }

    public SwanAdDownloadButtonView S(float f) {
        this.mTextSize = f;
        return this;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (getWidth() != 0 && getHeight() != 0 && !TextUtils.isEmpty(this.mText)) {
            if (!this.dGW) {
                A(canvas);
            } else {
                B(canvas);
            }
        }
    }

    private void A(Canvas canvas) {
        float f = 0.0f;
        RectF rectF = new RectF(0, 0, getWidth() + 0, getHeight() + 0);
        this.dGT.setColor(this.mBgColor);
        this.dGT.setStyle(Paint.Style.FILL);
        if (this.mRadius > 0.0f) {
            f = this.mRadius;
        } else if (this.dGV) {
            f = rectF.height() / 2.0f;
        }
        canvas.drawRoundRect(rectF, f, f, this.dGT);
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
        this.dGT.setColor(this.mBgColor);
        this.dGT.setStyle(Paint.Style.FILL);
        if (this.mRadius > 0.0f) {
            f = this.mRadius;
        } else if (this.dGV) {
            f = rectF.height() / 2.0f;
        }
        canvas.drawRoundRect(rectF, f, f, this.dGT);
    }

    private void b(Canvas canvas, RectF rectF) {
        float f = 0.0f;
        switch (this.dGY) {
            case DOWNLOADING:
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.FILL);
                float f2 = this.mProgress / this.dGX;
                paint.setShader(new LinearGradient(0.0f, 0.0f, rectF.width(), 0.0f, new int[]{this.dGU, 0}, new float[]{f2, f2 + 1.0E-4f}, Shader.TileMode.CLAMP));
                if (this.mRadius > 0.0f) {
                    f = this.mRadius;
                } else if (this.dGV) {
                    f = rectF.height() / 2.0f;
                }
                canvas.drawRoundRect(rectF, f, f, paint);
                return;
            case FINISH:
                this.dGT.setColor(this.dGU);
                this.dGT.setStyle(Paint.Style.FILL);
                if (this.mRadius > 0.0f) {
                    f = this.mRadius;
                } else if (this.dGV) {
                    f = rectF.height() / 2.0f;
                }
                canvas.drawRoundRect(rectF, f, f, this.dGT);
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
