package com.baidu.searchbox.ui.animview.praise.element;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.searchbox.ui.animview.util.PraiseLevelUtil;
import java.util.Stack;
/* loaded from: classes6.dex */
public class PraiseNumberAnimElement extends BaseAnimatedElement {
    private static final boolean DEBUG = false;
    private static final int OFFSET_Y_DP = 2;
    private static int[] mNumberDrawableOffsetX;
    private boolean mIsAlignRight;
    private Stack<Drawable> mNumDrawableStack;

    public PraiseNumberAnimElement() {
        super(null, null);
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    protected void onInit(Object... objArr) {
        parseOtherParams(objArr);
        setAlignRight(true);
        enableDrawDebugBound(false, -16776961);
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    protected void onDispatchAnimate(Canvas canvas, float f, long j) {
        setNumber(j);
        drawNumber(canvas, j);
    }

    private void parseOtherParams(Object... objArr) {
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Integer)) {
            int intValue = ((Integer) objArr[0]).intValue();
            mNumberDrawableOffsetX = new int[]{0, 0, -intValue, (-intValue) * 2, (-intValue) * 3};
        }
    }

    private void setNumber(long j) {
        long abs = Math.abs(j);
        if (this.mNumDrawableStack == null) {
            this.mNumDrawableStack = new Stack<>();
        }
        this.mNumDrawableStack.clear();
        do {
            Drawable drawable = this.mResourceProvider.getDrawable("number", Integer.valueOf((int) (abs % 10)), Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight));
            if (drawable != null) {
                drawable.setBounds(0, 0, this.mWidth, this.mHeight);
                this.mNumDrawableStack.push(drawable);
            }
            abs /= 10;
        } while (abs > 0);
    }

    private int getSafetyIndex(int i) {
        if (i < 0) {
            return 0;
        }
        int length = mNumberDrawableOffsetX == null ? 1 : mNumberDrawableOffsetX.length;
        return i >= length ? length - 1 : i;
    }

    private void drawNumber(Canvas canvas, long j) {
        if (this.mNumDrawableStack != null && this.mNumDrawableStack.size() > 0) {
            if (mNumberDrawableOffsetX != null && mNumberDrawableOffsetX.length > 0) {
                canvas.translate(mNumberDrawableOffsetX[getSafetyIndex(PraiseLevelUtil.matchPraiseLevel(j).mTextCount)], 0.0f);
            }
            int i = this.mNumDrawableStack.peek().getBounds().right;
            int dp2px = DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 2.0f);
            while (!this.mNumDrawableStack.empty()) {
                if (!this.mIsAlignRight) {
                    this.mNumDrawableStack.pop().draw(canvas);
                    canvas.translate(i, 0.0f);
                } else {
                    canvas.save();
                    canvas.translate((-i) * (this.mNumDrawableStack.size() - 1), (this.mNumDrawableStack.size() - 1) * dp2px);
                    this.mNumDrawableStack.pop().draw(canvas);
                    canvas.restore();
                }
            }
        }
    }

    private void setAlignRight(boolean z) {
        this.mIsAlignRight = z;
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void releaseResouces() {
        if (this.mNumDrawableStack != null) {
            this.mNumDrawableStack.clear();
        }
    }
}
