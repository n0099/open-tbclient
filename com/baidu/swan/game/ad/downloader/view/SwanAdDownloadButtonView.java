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
    private Paint bex;
    private Paint dWl;
    private int dWm;
    private boolean dWn;
    private boolean dWo;
    private int dWp;
    private State dWq;
    private int mBgColor;
    private int mProgress;
    private float mRadius;
    private String mText;
    private int mTextColor;
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
        this.dWl = new Paint();
        this.bex = new Paint();
        this.mTextColor = -1;
        this.dWp = 100;
        this.dWq = State.PREPARE;
        this.mRadius = -1.0f;
        this.dWl.setAntiAlias(true);
        this.bex.setAntiAlias(true);
        this.mTextSize = getResources().getDimensionPixelOffset(c.C0505c.swanapp_ad_dimens_14dp);
        this.mBgColor = context.getResources().getColor(c.b.swanapp_ad_download_button_default_bg_color);
        this.dWm = context.getResources().getColor(c.b.swanapp_ad_download_button_default_fg_color);
    }

    public SwanAdDownloadButtonView hN(boolean z) {
        this.dWo = z;
        return this;
    }

    public SwanAdDownloadButtonView hO(boolean z) {
        this.dWn = z;
        return this;
    }

    public SwanAdDownloadButtonView kH(int i) {
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
        if (i > this.dWp) {
            i = this.dWp;
        }
        this.mProgress = i;
        if (this.mProgress == 0) {
            this.dWq = State.PREPARE;
        } else if (this.mProgress == this.dWp) {
            this.dWq = State.FINISH;
        } else {
            this.dWq = State.DOWNLOADING;
        }
    }

    public void setText(String str) {
        this.mText = str;
    }

    public int getMax() {
        return this.dWp;
    }

    public void setMax(int i) {
        this.dWp = i;
    }

    public SwanAdDownloadButtonView kI(int i) {
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
            if (!this.dWo) {
                H(canvas);
            } else {
                I(canvas);
            }
        }
    }

    private void H(Canvas canvas) {
        float f = 0.0f;
        RectF rectF = new RectF(0, 0, getWidth() + 0, getHeight() + 0);
        this.dWl.setColor(this.mBgColor);
        this.dWl.setStyle(Paint.Style.FILL);
        if (this.mRadius > 0.0f) {
            f = this.mRadius;
        } else if (this.dWn) {
            f = rectF.height() / 2.0f;
        }
        canvas.drawRoundRect(rectF, f, f, this.dWl);
        this.bex.setColor(this.mTextColor);
        this.bex.setTextSize(this.mTextSize);
        Paint.FontMetrics fontMetrics = this.bex.getFontMetrics();
        canvas.drawText(this.mText, (getMeasuredWidth() - this.bex.measureText(this.mText)) / 2.0f, ((fontMetrics.descent - fontMetrics.ascent) / 2.0f) + ((getHeight() / 2) - fontMetrics.descent), this.bex);
    }

    private void I(Canvas canvas) {
        RectF rectF = new RectF(0, 0, getWidth(), getHeight());
        a(canvas, rectF);
        b(canvas, rectF);
        J(canvas);
    }

    private void a(Canvas canvas, RectF rectF) {
        float f = 0.0f;
        this.dWl.setColor(this.mBgColor);
        this.dWl.setStyle(Paint.Style.FILL);
        if (this.mRadius > 0.0f) {
            f = this.mRadius;
        } else if (this.dWn) {
            f = rectF.height() / 2.0f;
        }
        canvas.drawRoundRect(rectF, f, f, this.dWl);
    }

    private void b(Canvas canvas, RectF rectF) {
        float f = 0.0f;
        switch (this.dWq) {
            case DOWNLOADING:
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.FILL);
                float f2 = this.mProgress / this.dWp;
                paint.setShader(new LinearGradient(0.0f, 0.0f, rectF.width(), 0.0f, new int[]{this.dWm, 0}, new float[]{f2, f2 + 1.0E-4f}, Shader.TileMode.CLAMP));
                if (this.mRadius > 0.0f) {
                    f = this.mRadius;
                } else if (this.dWn) {
                    f = rectF.height() / 2.0f;
                }
                canvas.drawRoundRect(rectF, f, f, paint);
                return;
            case FINISH:
                this.dWl.setColor(this.dWm);
                this.dWl.setStyle(Paint.Style.FILL);
                if (this.mRadius > 0.0f) {
                    f = this.mRadius;
                } else if (this.dWn) {
                    f = rectF.height() / 2.0f;
                }
                canvas.drawRoundRect(rectF, f, f, this.dWl);
                return;
            default:
                return;
        }
    }

    private void J(Canvas canvas) {
        this.bex.setTextSize(this.mTextSize);
        float height = (canvas.getHeight() / 2) - ((this.bex.descent() / 2.0f) + (this.bex.ascent() / 2.0f));
        float measureText = this.bex.measureText(this.mText);
        this.bex.setColor(this.mTextColor);
        canvas.drawText(this.mText, (getMeasuredWidth() - measureText) / 2.0f, height, this.bex);
    }
}
