package com.baidu.searchbox.ui.animview.praise.element.eruption;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.EruptionStrategyGroup;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategy;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategyGroup;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class EruptionAnimatedGroup extends BaseAnimatedElement {
    public static final boolean DEBUG = false;
    public static final float ERUPTION_RANDOM_DURATION_FACTOR = 0.6f;
    public List<Float> mElementAngleList;
    public List<Float> mElementFactorList;
    public List<BaseAnimatedElement> mElementList;
    public IEruptionStrategyGroup mEruptionStrategyGrp;
    public IEruptionStrategy.IHostCallback mHostCallback;
    public Object[] mOtherInitParams;

    public static float getTransformedFraction(float f, float f2) {
        float f3 = f * f2;
        if (f3 >= 1.0f) {
            return 1.0f;
        }
        return f3;
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    public void onDispatchAnimate(Canvas canvas, float f, long j) {
    }

    public EruptionAnimatedGroup(Drawable.Callback callback, BaseAnimatedElement.ScaleType scaleType) {
        super(callback, scaleType);
    }

    private List<Float> getTransformedFactorList(int i) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(Float.valueOf(1.0f / ((float) ((Math.random() * 0.3999999761581421d) + 0.6000000238418579d))));
        }
        return arrayList;
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    public void onInit(Object... objArr) {
        enableDrawDebugBound(false, -7829368);
    }

    public void updateCurrentStrategy(String str) {
        if (this.mEruptionStrategyGrp == null) {
            this.mEruptionStrategyGrp = new EruptionStrategyGroup();
        }
        this.mEruptionStrategyGrp.setCurrentStrategy(str);
        generatedElements();
    }

    private void generatedElements() {
        List<Float> transformedFactorList;
        if (this.mHostCallback == null) {
            this.mHostCallback = new IEruptionStrategy.IHostCallback() { // from class: com.baidu.searchbox.ui.animview.praise.element.eruption.EruptionAnimatedGroup.1
                @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategy.IHostCallback
                public BaseAnimatedElement createAndInitEruption(int i, int i2, IResourceProvider iResourceProvider) {
                    EruptionAnimElement eruptionAnimElement = new EruptionAnimElement(i2, (Drawable.Callback) EruptionAnimatedGroup.this.mDrawableCallback.get(), EruptionAnimatedGroup.this.mScaleType);
                    eruptionAnimElement.init(EruptionAnimatedGroup.this.mLeft, EruptionAnimatedGroup.this.mTop, EruptionAnimatedGroup.this.mWidth, EruptionAnimatedGroup.this.mHeight, iResourceProvider, new Object[0]);
                    return eruptionAnimElement;
                }
            };
        }
        List<BaseAnimatedElement> generateEruptionElementList = this.mEruptionStrategyGrp.generateEruptionElementList(this.mResourceProvider, this.mHostCallback);
        List<Float> generateEruptionRotateAngleList = this.mEruptionStrategyGrp.generateEruptionRotateAngleList();
        if (generateEruptionElementList != null && !generateEruptionElementList.isEmpty() && generateEruptionRotateAngleList != null && !generateEruptionRotateAngleList.isEmpty() && (transformedFactorList = getTransformedFactorList(generateEruptionElementList.size())) != null && !transformedFactorList.isEmpty()) {
            releaseResouces();
            this.mElementList = generateEruptionElementList;
            this.mElementAngleList = generateEruptionRotateAngleList;
            this.mElementFactorList = transformedFactorList;
        }
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement, com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public BaseAnimatedElement cloneInstance() {
        EruptionAnimatedGroup eruptionAnimatedGroup = new EruptionAnimatedGroup(this.mDrawableCallback.get(), this.mScaleType);
        eruptionAnimatedGroup.init(this.mLeft, this.mTop, this.mWidth, this.mHeight, this.mResourceProvider, new Object[0]);
        return eruptionAnimatedGroup;
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void releaseResouces() {
        List<BaseAnimatedElement> list = this.mElementList;
        if (list != null && list.size() > 0) {
            for (BaseAnimatedElement baseAnimatedElement : this.mElementList) {
                baseAnimatedElement.releaseResouces();
            }
        }
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement, com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void dispatchAnimate(Canvas canvas, float f, long j) {
        super.dispatchAnimate(canvas, f, j);
        List<BaseAnimatedElement> list = this.mElementList;
        if (list != null && !list.isEmpty() && this.mVisibility) {
            int i = 0;
            for (BaseAnimatedElement baseAnimatedElement : this.mElementList) {
                canvas.save();
                List<Float> list2 = this.mElementAngleList;
                if (list2 != null && i < list2.size() && (baseAnimatedElement instanceof EruptionAnimElement)) {
                    ((EruptionAnimElement) baseAnimatedElement).setRotate(this.mElementAngleList.get(i).floatValue(), 0.5f, 1.0f);
                }
                baseAnimatedElement.dispatchAnimate(canvas, getTransformedFraction(f, this.mElementFactorList.get(i).floatValue()), j);
                i++;
                canvas.restore();
            }
        }
    }
}
