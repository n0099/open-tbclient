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
    private Paint dML;
    private int dMM;
    private boolean dMN;
    private boolean dMO;
    private int dMP;
    private State dMQ;
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
        this.dML = new Paint();
        this.mTextPaint = new Paint();
        this.mTextColor = -1;
        this.dMP = 100;
        this.dMQ = State.PREPARE;
        this.mRadius = -1.0f;
        this.dML.setAntiAlias(true);
        this.mTextPaint.setAntiAlias(true);
        this.mTextSize = getResources().getDimensionPixelOffset(c.C0519c.swanapp_ad_dimens_14dp);
        this.mBgColor = context.getResources().getColor(c.b.swanapp_ad_download_button_default_bg_color);
        this.dMM = context.getResources().getColor(c.b.swanapp_ad_download_button_default_fg_color);
    }

    public SwanAdDownloadButtonView hh(boolean z) {
        this.dMO = z;
        return this;
    }

    public SwanAdDownloadButtonView hi(boolean z) {
        this.dMN = z;
        return this;
    }

    public SwanAdDownloadButtonView lL(int i) {
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
        if (i > this.dMP) {
            i = this.dMP;
        }
        this.mProgress = i;
        if (this.mProgress == 0) {
            this.dMQ = State.PREPARE;
        } else if (this.mProgress == this.dMP) {
            this.dMQ = State.FINISH;
        } else {
            this.dMQ = State.DOWNLOADING;
        }
    }

    public void setText(String str) {
        this.mText = str;
    }

    public int getMax() {
        return this.dMP;
    }

    public void setMax(int i) {
        this.dMP = i;
    }

    public SwanAdDownloadButtonView lM(int i) {
        this.mTextColor = i;
        return this;
    }

    public SwanAdDownloadButtonView U(float f) {
        this.mTextSize = f;
        return this;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (getWidth() != 0 && getHeight() != 0 && !TextUtils.isEmpty(this.mText)) {
            if (!this.dMO) {
                A(canvas);
            } else {
                B(canvas);
            }
        }
    }

    private void A(Canvas canvas) {
        float f = 0.0f;
        RectF rectF = new RectF(0, 0, getWidth() + 0, getHeight() + 0);
        this.dML.setColor(this.mBgColor);
        this.dML.setStyle(Paint.Style.FILL);
        if (this.mRadius > 0.0f) {
            f = this.mRadius;
        } else if (this.dMN) {
            f = rectF.height() / 2.0f;
        }
        canvas.drawRoundRect(rectF, f, f, this.dML);
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
        this.dML.setColor(this.mBgColor);
        this.dML.setStyle(Paint.Style.FILL);
        if (this.mRadius > 0.0f) {
            f = this.mRadius;
        } else if (this.dMN) {
            f = rectF.height() / 2.0f;
        }
        canvas.drawRoundRect(rectF, f, f, this.dML);
    }

    private void b(Canvas canvas, RectF rectF) {
        float f = 0.0f;
        switch (this.dMQ) {
            case DOWNLOADING:
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.FILL);
                float f2 = this.mProgress / this.dMP;
                paint.setShader(new LinearGradient(0.0f, 0.0f, rectF.width(), 0.0f, new int[]{this.dMM, 0}, new float[]{f2, f2 + 1.0E-4f}, Shader.TileMode.CLAMP));
                if (this.mRadius > 0.0f) {
                    f = this.mRadius;
                } else if (this.dMN) {
                    f = rectF.height() / 2.0f;
                }
                canvas.drawRoundRect(rectF, f, f, paint);
                return;
            case FINISH:
                this.dML.setColor(this.dMM);
                this.dML.setStyle(Paint.Style.FILL);
                if (this.mRadius > 0.0f) {
                    f = this.mRadius;
                } else if (this.dMN) {
                    f = rectF.height() / 2.0f;
                }
                canvas.drawRoundRect(rectF, f, f, this.dML);
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
