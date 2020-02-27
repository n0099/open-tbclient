package com.baidu.searchbox.ui.animview.praise.element.eruption;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.EruptionStrategyGroup;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategy;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategyGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes13.dex */
public class EruptionAnimatedGroup extends BaseAnimatedElement {
    private static final boolean DEBUG = false;
    private static final float ERUPTION_RANDOM_DURATION_FACTOR = 0.6f;
    private Context mCtx;
    private List<Float> mElementAngleList;
    private List<Float> mElementFactorList;
    private List<BaseAnimatedElement> mElementList;
    private IEruptionStrategyGroup mEruptionStrategyGrp;
    private IEruptionStrategy.IHostCallback mHostCallback;

    public EruptionAnimatedGroup(Context context, Drawable.Callback callback, BaseAnimatedElement.ScaleType scaleType) {
        super(callback, scaleType);
        this.mHostCallback = new IEruptionStrategy.IHostCallback() { // from class: com.baidu.searchbox.ui.animview.praise.element.eruption.EruptionAnimatedGroup.1
            @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategy.IHostCallback
            public BaseAnimatedElement createAndInitEruption(int i, int i2) {
                EruptionAnimElement eruptionAnimElement = new EruptionAnimElement(EruptionAnimatedGroup.this.mCtx, i2, EruptionAnimatedGroup.this.mDrawableCallback, EruptionAnimatedGroup.this.mScaleType);
                eruptionAnimElement.init(EruptionAnimatedGroup.this.mLeft, EruptionAnimatedGroup.this.mTop, EruptionAnimatedGroup.this.mWidth, EruptionAnimatedGroup.this.mHeight, EruptionAnimatedGroup.this.mResourceProvider, new Object[0]);
                return eruptionAnimElement;
            }
        };
        this.mCtx = context;
        this.mEruptionStrategyGrp = new EruptionStrategyGroup();
    }

    private static float getTransformedFraction(float f, float f2) {
        float f3 = f * f2;
        if (f3 >= 1.0f) {
            return 1.0f;
        }
        return f3;
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    protected void onInit(Object... objArr) {
        enableDrawDebugBound(false, -7829368);
    }

    public void updateCurrentStrategy(String str) {
        if (this.mEruptionStrategyGrp != null) {
            this.mEruptionStrategyGrp.setCurrentStrategy(str);
            generatedElements();
        }
    }

    private void generatedElements() {
        List<Float> transformedFactorList;
        if (this.mEruptionStrategyGrp != null) {
            List<BaseAnimatedElement> generateEruptionElementList = this.mEruptionStrategyGrp.generateEruptionElementList(this.mResourceProvider, this.mHostCallback);
            List<Float> generateEruptionRotateAngleList = this.mEruptionStrategyGrp.generateEruptionRotateAngleList();
            if (generateEruptionElementList != null && !generateEruptionElementList.isEmpty() && generateEruptionRotateAngleList != null && !generateEruptionRotateAngleList.isEmpty() && (transformedFactorList = getTransformedFactorList(generateEruptionElementList.size())) != null && !transformedFactorList.isEmpty()) {
                releaseResouces();
                this.mElementList = generateEruptionElementList;
                this.mElementAngleList = generateEruptionRotateAngleList;
                this.mElementFactorList = transformedFactorList;
            }
        }
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement, com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void dispatchAnimate(Canvas canvas, float f, long j) {
        super.dispatchAnimate(canvas, f, j);
        if (this.mElementList != null && !this.mElementList.isEmpty() && this.mVisibility) {
            int i = 0;
            Iterator<BaseAnimatedElement> it = this.mElementList.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    BaseAnimatedElement next = it.next();
                    canvas.save();
                    if (this.mElementAngleList != null && i2 < this.mElementAngleList.size() && (next instanceof EruptionAnimElement)) {
                        ((EruptionAnimElement) next).setRotate(this.mElementAngleList.get(i2).floatValue(), this.mWidth / 2, this.mHeight);
                    }
                    next.dispatchAnimate(canvas, getTransformedFraction(f, this.mElementFactorList.get(i2).floatValue()), j);
                    i = i2 + 1;
                    canvas.restore();
                } else {
                    return;
                }
            }
        }
    }

    private List<Float> getTransformedFactorList(int i) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(Float.valueOf(1.0f / ((float) ((0.3999999761581421d * Math.random()) + 0.6000000238418579d))));
        }
        return arrayList;
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    protected void onDispatchAnimate(Canvas canvas, float f, long j) {
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void releaseResouces() {
        if (this.mElementList != null && this.mElementList.size() > 0) {
            for (BaseAnimatedElement baseAnimatedElement : this.mElementList) {
                baseAnimatedElement.releaseResouces();
            }
        }
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement, com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public BaseAnimatedElement cloneInstance() {
        EruptionAnimatedGroup eruptionAnimatedGroup = new EruptionAnimatedGroup(this.mCtx, this.mDrawableCallback, this.mScaleType);
        eruptionAnimatedGroup.init(this.mLeft, this.mTop, this.mWidth, this.mHeight, this.mResourceProvider, new Object[0]);
        return eruptionAnimatedGroup;
    }
}
