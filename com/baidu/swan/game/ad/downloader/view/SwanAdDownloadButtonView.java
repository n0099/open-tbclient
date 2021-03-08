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
/* loaded from: classes5.dex */
public class SwanAdDownloadButtonView extends View {
    private Paint bjh;
    private Paint dZT;
    private int dZU;
    private boolean dZV;
    private boolean dZW;
    private int dZX;
    private State dZY;
    private int mBgColor;
    private int mProgress;
    private float mRadius;
    private String mText;
    private int mTextColor;
    private float mTextSize;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public enum State {
        PREPARE,
        DOWNLOADING,
        FINISH
    }

    public SwanAdDownloadButtonView(Context context) {
        super(context);
        this.dZT = new Paint();
        this.bjh = new Paint();
        this.mTextColor = -1;
        this.dZX = 100;
        this.dZY = State.PREPARE;
        this.mRadius = -1.0f;
        this.dZT.setAntiAlias(true);
        this.bjh.setAntiAlias(true);
        this.mTextSize = getResources().getDimensionPixelOffset(c.C0508c.swanapp_ad_dimens_14dp);
        this.mBgColor = context.getResources().getColor(c.b.swanapp_ad_download_button_default_bg_color);
        this.dZU = context.getResources().getColor(c.b.swanapp_ad_download_button_default_fg_color);
    }

    public SwanAdDownloadButtonView hP(boolean z) {
        this.dZW = z;
        return this;
    }

    public SwanAdDownloadButtonView hQ(boolean z) {
        this.dZV = z;
        return this;
    }

    public SwanAdDownloadButtonView kL(int i) {
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
        if (i > this.dZX) {
            i = this.dZX;
        }
        this.mProgress = i;
        if (this.mProgress == 0) {
            this.dZY = State.PREPARE;
        } else if (this.mProgress == this.dZX) {
            this.dZY = State.FINISH;
        } else {
            this.dZY = State.DOWNLOADING;
        }
    }

    public void setText(String str) {
        this.mText = str;
    }

    public int getMax() {
        return this.dZX;
    }

    public void setMax(int i) {
        this.dZX = i;
    }

    public SwanAdDownloadButtonView kM(int i) {
        this.mTextColor = i;
        return this;
    }

    public SwanAdDownloadButtonView aa(float f) {
        this.mTextSize = f;
        return this;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (getWidth() != 0 && getHeight() != 0 && !TextUtils.isEmpty(this.mText)) {
            if (!this.dZW) {
                H(canvas);
            } else {
                I(canvas);
            }
        }
    }

    private void H(Canvas canvas) {
        float f = 0.0f;
        RectF rectF = new RectF(0, 0, getWidth() + 0, getHeight() + 0);
        this.dZT.setColor(this.mBgColor);
        this.dZT.setStyle(Paint.Style.FILL);
        if (this.mRadius > 0.0f) {
            f = this.mRadius;
        } else if (this.dZV) {
            f = rectF.height() / 2.0f;
        }
        canvas.drawRoundRect(rectF, f, f, this.dZT);
        this.bjh.setColor(this.mTextColor);
        this.bjh.setTextSize(this.mTextSize);
        Paint.FontMetrics fontMetrics = this.bjh.getFontMetrics();
        canvas.drawText(this.mText, (getMeasuredWidth() - this.bjh.measureText(this.mText)) / 2.0f, ((fontMetrics.descent - fontMetrics.ascent) / 2.0f) + ((getHeight() / 2) - fontMetrics.descent), this.bjh);
    }

    private void I(Canvas canvas) {
        RectF rectF = new RectF(0, 0, getWidth(), getHeight());
        a(canvas, rectF);
        b(canvas, rectF);
        J(canvas);
    }

    private void a(Canvas canvas, RectF rectF) {
        float f = 0.0f;
        this.dZT.setColor(this.mBgColor);
        this.dZT.setStyle(Paint.Style.FILL);
        if (this.mRadius > 0.0f) {
            f = this.mRadius;
        } else if (this.dZV) {
            f = rectF.height() / 2.0f;
        }
        canvas.drawRoundRect(rectF, f, f, this.dZT);
    }

    private void b(Canvas canvas, RectF rectF) {
        float f = 0.0f;
        switch (this.dZY) {
            case DOWNLOADING:
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.FILL);
                float f2 = this.mProgress / this.dZX;
                paint.setShader(new LinearGradient(0.0f, 0.0f, rectF.width(), 0.0f, new int[]{this.dZU, 0}, new float[]{f2, f2 + 1.0E-4f}, Shader.TileMode.CLAMP));
                if (this.mRadius > 0.0f) {
                    f = this.mRadius;
                } else if (this.dZV) {
                    f = rectF.height() / 2.0f;
                }
                canvas.drawRoundRect(rectF, f, f, paint);
                return;
            case FINISH:
                this.dZT.setColor(this.dZU);
                this.dZT.setStyle(Paint.Style.FILL);
                if (this.mRadius > 0.0f) {
                    f = this.mRadius;
                } else if (this.dZV) {
                    f = rectF.height() / 2.0f;
                }
                canvas.drawRoundRect(rectF, f, f, this.dZT);
                return;
            default:
                return;
        }
    }

    private void J(Canvas canvas) {
        this.bjh.setTextSize(this.mTextSize);
        float height = (canvas.getHeight() / 2) - ((this.bjh.descent() / 2.0f) + (this.bjh.ascent() / 2.0f));
        float measureText = this.bjh.measureText(this.mText);
        this.bjh.setColor(this.mTextColor);
        canvas.drawText(this.mText, (getMeasuredWidth() - measureText) / 2.0f, height, this.bjh);
    }
}
