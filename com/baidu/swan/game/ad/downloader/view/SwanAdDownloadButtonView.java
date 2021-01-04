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
/* loaded from: classes3.dex */
public class SwanAdDownloadButtonView extends View {
    private Paint bjo;
    private Paint eaX;
    private int eaY;
    private boolean eaZ;
    private boolean eba;
    private int ebb;
    private State ebc;
    private int mBgColor;
    private int mProgress;
    private float mRadius;
    private String mText;
    private int mTextColor;
    private float mTextSize;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum State {
        PREPARE,
        DOWNLOADING,
        FINISH
    }

    public SwanAdDownloadButtonView(Context context) {
        super(context);
        this.eaX = new Paint();
        this.bjo = new Paint();
        this.mTextColor = -1;
        this.ebb = 100;
        this.ebc = State.PREPARE;
        this.mRadius = -1.0f;
        this.eaX.setAntiAlias(true);
        this.bjo.setAntiAlias(true);
        this.mTextSize = getResources().getDimensionPixelOffset(c.C0522c.swanapp_ad_dimens_14dp);
        this.mBgColor = context.getResources().getColor(c.b.swanapp_ad_download_button_default_bg_color);
        this.eaY = context.getResources().getColor(c.b.swanapp_ad_download_button_default_fg_color);
    }

    public SwanAdDownloadButtonView hR(boolean z) {
        this.eba = z;
        return this;
    }

    public SwanAdDownloadButtonView hS(boolean z) {
        this.eaZ = z;
        return this;
    }

    public SwanAdDownloadButtonView mn(int i) {
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
        if (i > this.ebb) {
            i = this.ebb;
        }
        this.mProgress = i;
        if (this.mProgress == 0) {
            this.ebc = State.PREPARE;
        } else if (this.mProgress == this.ebb) {
            this.ebc = State.FINISH;
        } else {
            this.ebc = State.DOWNLOADING;
        }
    }

    public void setText(String str) {
        this.mText = str;
    }

    public int getMax() {
        return this.ebb;
    }

    public void setMax(int i) {
        this.ebb = i;
    }

    public SwanAdDownloadButtonView mo(int i) {
        this.mTextColor = i;
        return this;
    }

    public SwanAdDownloadButtonView V(float f) {
        this.mTextSize = f;
        return this;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (getWidth() != 0 && getHeight() != 0 && !TextUtils.isEmpty(this.mText)) {
            if (!this.eba) {
                H(canvas);
            } else {
                I(canvas);
            }
        }
    }

    private void H(Canvas canvas) {
        float f = 0.0f;
        RectF rectF = new RectF(0, 0, getWidth() + 0, getHeight() + 0);
        this.eaX.setColor(this.mBgColor);
        this.eaX.setStyle(Paint.Style.FILL);
        if (this.mRadius > 0.0f) {
            f = this.mRadius;
        } else if (this.eaZ) {
            f = rectF.height() / 2.0f;
        }
        canvas.drawRoundRect(rectF, f, f, this.eaX);
        this.bjo.setColor(this.mTextColor);
        this.bjo.setTextSize(this.mTextSize);
        Paint.FontMetrics fontMetrics = this.bjo.getFontMetrics();
        canvas.drawText(this.mText, (getMeasuredWidth() - this.bjo.measureText(this.mText)) / 2.0f, ((fontMetrics.descent - fontMetrics.ascent) / 2.0f) + ((getHeight() / 2) - fontMetrics.descent), this.bjo);
    }

    private void I(Canvas canvas) {
        RectF rectF = new RectF(0, 0, getWidth(), getHeight());
        a(canvas, rectF);
        b(canvas, rectF);
        J(canvas);
    }

    private void a(Canvas canvas, RectF rectF) {
        float f = 0.0f;
        this.eaX.setColor(this.mBgColor);
        this.eaX.setStyle(Paint.Style.FILL);
        if (this.mRadius > 0.0f) {
            f = this.mRadius;
        } else if (this.eaZ) {
            f = rectF.height() / 2.0f;
        }
        canvas.drawRoundRect(rectF, f, f, this.eaX);
    }

    private void b(Canvas canvas, RectF rectF) {
        float f = 0.0f;
        switch (this.ebc) {
            case DOWNLOADING:
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.FILL);
                float f2 = this.mProgress / this.ebb;
                paint.setShader(new LinearGradient(0.0f, 0.0f, rectF.width(), 0.0f, new int[]{this.eaY, 0}, new float[]{f2, f2 + 1.0E-4f}, Shader.TileMode.CLAMP));
                if (this.mRadius > 0.0f) {
                    f = this.mRadius;
                } else if (this.eaZ) {
                    f = rectF.height() / 2.0f;
                }
                canvas.drawRoundRect(rectF, f, f, paint);
                return;
            case FINISH:
                this.eaX.setColor(this.eaY);
                this.eaX.setStyle(Paint.Style.FILL);
                if (this.mRadius > 0.0f) {
                    f = this.mRadius;
                } else if (this.eaZ) {
                    f = rectF.height() / 2.0f;
                }
                canvas.drawRoundRect(rectF, f, f, this.eaX);
                return;
            default:
                return;
        }
    }

    private void J(Canvas canvas) {
        this.bjo.setTextSize(this.mTextSize);
        float height = (canvas.getHeight() / 2) - ((this.bjo.descent() / 2.0f) + (this.bjo.ascent() / 2.0f));
        float measureText = this.bjo.measureText(this.mText);
        this.bjo.setColor(this.mTextColor);
        canvas.drawText(this.mText, (getMeasuredWidth() - measureText) / 2.0f, height, this.bjo);
    }
}
