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
    private int dyA;
    private State dyB;
    private Paint dyw;
    private int dyx;
    private boolean dyy;
    private boolean dyz;
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
        this.dyw = new Paint();
        this.mTextPaint = new Paint();
        this.mTextColor = -1;
        this.dyA = 100;
        this.dyB = State.PREPARE;
        this.mRadius = -1.0f;
        this.dyw.setAntiAlias(true);
        this.mTextPaint.setAntiAlias(true);
        this.mTextSize = getResources().getDimensionPixelOffset(c.C0493c.swanapp_ad_dimens_14dp);
        this.mBgColor = context.getResources().getColor(c.b.swanapp_ad_download_button_default_bg_color);
        this.dyx = context.getResources().getColor(c.b.swanapp_ad_download_button_default_fg_color);
    }

    public SwanAdDownloadButtonView gL(boolean z) {
        this.dyz = z;
        return this;
    }

    public SwanAdDownloadButtonView gM(boolean z) {
        this.dyy = z;
        return this;
    }

    public SwanAdDownloadButtonView lq(int i) {
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
        if (i > this.dyA) {
            i = this.dyA;
        }
        this.mProgress = i;
        if (this.mProgress == 0) {
            this.dyB = State.PREPARE;
        } else if (this.mProgress == this.dyA) {
            this.dyB = State.FINISH;
        } else {
            this.dyB = State.DOWNLOADING;
        }
    }

    public void setText(String str) {
        this.mText = str;
    }

    public int getMax() {
        return this.dyA;
    }

    public void setMax(int i) {
        this.dyA = i;
    }

    public SwanAdDownloadButtonView lr(int i) {
        this.mTextColor = i;
        return this;
    }

    public SwanAdDownloadButtonView Q(float f) {
        this.mTextSize = f;
        return this;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (getWidth() != 0 && getHeight() != 0 && !TextUtils.isEmpty(this.mText)) {
            if (!this.dyz) {
                A(canvas);
            } else {
                B(canvas);
            }
        }
    }

    private void A(Canvas canvas) {
        float f = 0.0f;
        RectF rectF = new RectF(0, 0, getWidth() + 0, getHeight() + 0);
        this.dyw.setColor(this.mBgColor);
        this.dyw.setStyle(Paint.Style.FILL);
        if (this.mRadius > 0.0f) {
            f = this.mRadius;
        } else if (this.dyy) {
            f = rectF.height() / 2.0f;
        }
        canvas.drawRoundRect(rectF, f, f, this.dyw);
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
        this.dyw.setColor(this.mBgColor);
        this.dyw.setStyle(Paint.Style.FILL);
        if (this.mRadius > 0.0f) {
            f = this.mRadius;
        } else if (this.dyy) {
            f = rectF.height() / 2.0f;
        }
        canvas.drawRoundRect(rectF, f, f, this.dyw);
    }

    private void b(Canvas canvas, RectF rectF) {
        float f = 0.0f;
        switch (this.dyB) {
            case DOWNLOADING:
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.FILL);
                float f2 = this.mProgress / this.dyA;
                paint.setShader(new LinearGradient(0.0f, 0.0f, rectF.width(), 0.0f, new int[]{this.dyx, 0}, new float[]{f2, f2 + 1.0E-4f}, Shader.TileMode.CLAMP));
                if (this.mRadius > 0.0f) {
                    f = this.mRadius;
                } else if (this.dyy) {
                    f = rectF.height() / 2.0f;
                }
                canvas.drawRoundRect(rectF, f, f, paint);
                return;
            case FINISH:
                this.dyw.setColor(this.dyx);
                this.dyw.setStyle(Paint.Style.FILL);
                if (this.mRadius > 0.0f) {
                    f = this.mRadius;
                } else if (this.dyy) {
                    f = rectF.height() / 2.0f;
                }
                canvas.drawRoundRect(rectF, f, f, this.dyw);
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
