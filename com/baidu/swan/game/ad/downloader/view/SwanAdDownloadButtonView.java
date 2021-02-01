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
    private Paint bhF;
    private Paint dYs;
    private int dYt;
    private boolean dYu;
    private boolean dYv;
    private int dYw;
    private State dYx;
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
        this.dYs = new Paint();
        this.bhF = new Paint();
        this.mTextColor = -1;
        this.dYw = 100;
        this.dYx = State.PREPARE;
        this.mRadius = -1.0f;
        this.dYs.setAntiAlias(true);
        this.bhF.setAntiAlias(true);
        this.mTextSize = getResources().getDimensionPixelOffset(c.C0502c.swanapp_ad_dimens_14dp);
        this.mBgColor = context.getResources().getColor(c.b.swanapp_ad_download_button_default_bg_color);
        this.dYt = context.getResources().getColor(c.b.swanapp_ad_download_button_default_fg_color);
    }

    public SwanAdDownloadButtonView hP(boolean z) {
        this.dYv = z;
        return this;
    }

    public SwanAdDownloadButtonView hQ(boolean z) {
        this.dYu = z;
        return this;
    }

    public SwanAdDownloadButtonView kK(int i) {
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
        if (i > this.dYw) {
            i = this.dYw;
        }
        this.mProgress = i;
        if (this.mProgress == 0) {
            this.dYx = State.PREPARE;
        } else if (this.mProgress == this.dYw) {
            this.dYx = State.FINISH;
        } else {
            this.dYx = State.DOWNLOADING;
        }
    }

    public void setText(String str) {
        this.mText = str;
    }

    public int getMax() {
        return this.dYw;
    }

    public void setMax(int i) {
        this.dYw = i;
    }

    public SwanAdDownloadButtonView kL(int i) {
        this.mTextColor = i;
        return this;
    }

    public SwanAdDownloadButtonView W(float f) {
        this.mTextSize = f;
        return this;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (getWidth() != 0 && getHeight() != 0 && !TextUtils.isEmpty(this.mText)) {
            if (!this.dYv) {
                H(canvas);
            } else {
                I(canvas);
            }
        }
    }

    private void H(Canvas canvas) {
        float f = 0.0f;
        RectF rectF = new RectF(0, 0, getWidth() + 0, getHeight() + 0);
        this.dYs.setColor(this.mBgColor);
        this.dYs.setStyle(Paint.Style.FILL);
        if (this.mRadius > 0.0f) {
            f = this.mRadius;
        } else if (this.dYu) {
            f = rectF.height() / 2.0f;
        }
        canvas.drawRoundRect(rectF, f, f, this.dYs);
        this.bhF.setColor(this.mTextColor);
        this.bhF.setTextSize(this.mTextSize);
        Paint.FontMetrics fontMetrics = this.bhF.getFontMetrics();
        canvas.drawText(this.mText, (getMeasuredWidth() - this.bhF.measureText(this.mText)) / 2.0f, ((fontMetrics.descent - fontMetrics.ascent) / 2.0f) + ((getHeight() / 2) - fontMetrics.descent), this.bhF);
    }

    private void I(Canvas canvas) {
        RectF rectF = new RectF(0, 0, getWidth(), getHeight());
        a(canvas, rectF);
        b(canvas, rectF);
        J(canvas);
    }

    private void a(Canvas canvas, RectF rectF) {
        float f = 0.0f;
        this.dYs.setColor(this.mBgColor);
        this.dYs.setStyle(Paint.Style.FILL);
        if (this.mRadius > 0.0f) {
            f = this.mRadius;
        } else if (this.dYu) {
            f = rectF.height() / 2.0f;
        }
        canvas.drawRoundRect(rectF, f, f, this.dYs);
    }

    private void b(Canvas canvas, RectF rectF) {
        float f = 0.0f;
        switch (this.dYx) {
            case DOWNLOADING:
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.FILL);
                float f2 = this.mProgress / this.dYw;
                paint.setShader(new LinearGradient(0.0f, 0.0f, rectF.width(), 0.0f, new int[]{this.dYt, 0}, new float[]{f2, f2 + 1.0E-4f}, Shader.TileMode.CLAMP));
                if (this.mRadius > 0.0f) {
                    f = this.mRadius;
                } else if (this.dYu) {
                    f = rectF.height() / 2.0f;
                }
                canvas.drawRoundRect(rectF, f, f, paint);
                return;
            case FINISH:
                this.dYs.setColor(this.dYt);
                this.dYs.setStyle(Paint.Style.FILL);
                if (this.mRadius > 0.0f) {
                    f = this.mRadius;
                } else if (this.dYu) {
                    f = rectF.height() / 2.0f;
                }
                canvas.drawRoundRect(rectF, f, f, this.dYs);
                return;
            default:
                return;
        }
    }

    private void J(Canvas canvas) {
        this.bhF.setTextSize(this.mTextSize);
        float height = (canvas.getHeight() / 2) - ((this.bhF.descent() / 2.0f) + (this.bhF.ascent() / 2.0f));
        float measureText = this.bhF.measureText(this.mText);
        this.bhF.setColor(this.mTextColor);
        canvas.drawText(this.mText, (getMeasuredWidth() - measureText) / 2.0f, height, this.bhF);
    }
}
