package com.baidu.searchbox.ng.ai.apps.canvas.action.draw;

import android.graphics.Paint;
import android.graphics.Path;
import android.text.TextPaint;
import com.baidu.searchbox.ng.ai.apps.canvas.view.CanvasView;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import java.util.Stack;
/* loaded from: classes2.dex */
public class CanvasContext implements Cloneable {
    CanvasView mAttachedView;
    DaShadow mShadow;
    private Stack<CanvasContext> mFrameStack = new Stack<>();
    Paint mFillPaint = new Paint();
    Paint mStrokePaint = new Paint();
    Paint mBitmapPaint = new Paint();
    TextPaint mFontPaint = new TextPaint();
    Path mPath = new Path();
    boolean mIsClip = false;
    int mGlobalAlpha = -1;
    int mTextBaseLine = 0;
    int mMatrixOrigin = 0;
    int mStrokeColor = -16777216;

    /* loaded from: classes2.dex */
    class TextBaseLine {
        static final int BOTTOM = 3;
        static final int MIDDLE = 2;
        static final int NORMAL = 0;
        static final int TOP = 1;

        TextBaseLine() {
        }
    }

    public CanvasContext(CanvasView canvasView) {
        this.mAttachedView = canvasView;
        init();
    }

    public void save() throws CloneNotSupportedException {
        CanvasContext canvasContext = (CanvasContext) super.clone();
        canvasContext.mFillPaint = new Paint(this.mFillPaint);
        canvasContext.mStrokePaint = new Paint(this.mStrokePaint);
        canvasContext.mBitmapPaint = new Paint(this.mBitmapPaint);
        canvasContext.mFontPaint = new TextPaint(this.mFontPaint);
        canvasContext.mPath = new Path(this.mPath);
        canvasContext.mTextBaseLine = this.mTextBaseLine;
        canvasContext.mMatrixOrigin = this.mMatrixOrigin;
        canvasContext.mStrokeColor = this.mStrokeColor;
        this.mFrameStack.push(canvasContext);
    }

    public void restore() {
        if (!this.mFrameStack.empty()) {
            CanvasContext pop = this.mFrameStack.pop();
            this.mFillPaint = pop.mFillPaint;
            this.mStrokePaint = pop.mStrokePaint;
            this.mBitmapPaint = pop.mBitmapPaint;
            this.mFontPaint = pop.mFontPaint;
            this.mPath = pop.mPath;
            this.mIsClip = pop.mIsClip;
            this.mFrameStack = pop.mFrameStack;
            this.mShadow = pop.mShadow;
            this.mGlobalAlpha = pop.mGlobalAlpha;
            this.mTextBaseLine = pop.mTextBaseLine;
            this.mMatrixOrigin = pop.mMatrixOrigin;
            this.mStrokeColor = pop.mStrokeColor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void applyGlobal(Paint paint) {
        if (paint != null) {
            if (this.mAttachedView != null && this.mShadow != null && this.mShadow.mColor != null && !this.mShadow.mColor.isShader()) {
                paint.setShadowLayer(this.mShadow.mBlur, this.mShadow.mOffsetX, this.mShadow.mOffsetY, this.mShadow.mColor.getColor());
            }
            if (this.mGlobalAlpha >= 0 && this.mGlobalAlpha <= 255) {
                paint.setAlpha(Math.min((paint.getAlpha() * this.mGlobalAlpha) >> 8, 255));
            }
        }
    }

    public TextPaint getTextPaint() {
        return this.mFontPaint;
    }

    public void SaveMatrixOrigin(int i) {
        this.mMatrixOrigin = i;
    }

    public int GetMatrixOrigin() {
        return this.mMatrixOrigin;
    }

    public void init() {
        this.mStrokeColor = -16777216;
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mFillPaint.setColor(-16777216);
        this.mStrokePaint.setColor(-16777216);
        this.mBitmapPaint.setColor(-16777216);
        this.mFontPaint.setColor(-16777216);
        this.mStrokePaint.setStrokeWidth(AiAppsUIUtils.dp2px(1.0f));
        this.mStrokePaint.setAntiAlias(true);
        this.mFontPaint.setAntiAlias(true);
        this.mBitmapPaint.setAntiAlias(true);
        this.mPath.reset();
    }
}
