package com.baidu.searchbox.ui.animview.praise.element.eruption;

import android.graphics.drawable.Drawable;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.searchbox.ui.animview.praise.element.IPraiseElementBuilder;
import com.baidu.searchbox.ui.animview.praise.element.eruption.EruptionElementBuilder;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class EruptionAnimatedGroupEx extends EruptionAnimatedGroup {
    public static final boolean DEBUG = false;
    public IPraiseElementBuilder.FetchConfig mConfig;

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.EruptionAnimatedGroup, com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void releaseResouces() {
    }

    public EruptionAnimatedGroupEx(BaseAnimatedElement.ScaleType scaleType) {
        super(null, scaleType);
        this.mConfig = new IPraiseElementBuilder.FetchConfig();
    }

    private void parseOtherParams(Object... objArr) {
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Drawable.Callback)) {
            setDrawableCallback((Drawable.Callback) objArr[0]);
        }
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.EruptionAnimatedGroup, com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    public void onInit(Object... objArr) {
        parseOtherParams(objArr);
        this.mConfig.setLeft(this.mLeft).setTop(this.mTop).setWidth(this.mWidth).setHeight(this.mHeight).setDrawableCallback(this.mDrawableCallback.get());
        enableDrawDebugBound(false, -7829368);
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.EruptionAnimatedGroup
    public void updateCurrentStrategy(String str) {
        this.mConfig.setStrategyTag(str);
        EruptionElementBuilder.BuildResult result = EruptionElementBuilder.getInstance().getResult(this.mConfig);
        if (result == null) {
            return;
        }
        this.mElementList = result.eruptionElementList;
        this.mElementAngleList = result.eruptionRotateAngleList;
        this.mElementFactorList = result.transformedFactorList;
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.EruptionAnimatedGroup, com.baidu.searchbox.ui.animview.base.BaseAnimatedElement, com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public BaseAnimatedElement cloneInstance() {
        return new EruptionAnimatedGroupEx(this.mScaleType);
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement, com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void copyAttribute(BaseAnimatedElement baseAnimatedElement) {
        if (baseAnimatedElement != null && (baseAnimatedElement instanceof EruptionAnimatedGroupEx)) {
            EruptionAnimatedGroupEx eruptionAnimatedGroupEx = (EruptionAnimatedGroupEx) baseAnimatedElement;
            this.mLeft = eruptionAnimatedGroupEx.mLeft;
            this.mTop = eruptionAnimatedGroupEx.mTop;
            this.mWidth = eruptionAnimatedGroupEx.mWidth;
            this.mHeight = eruptionAnimatedGroupEx.mHeight;
            this.mResourceProvider = eruptionAnimatedGroupEx.mResourceProvider;
            WeakReference<Drawable.Callback> weakReference = eruptionAnimatedGroupEx.mDrawableCallback;
            if (weakReference != null) {
                setDrawableCallback(weakReference.get());
            }
            init(this.mLeft, this.mTop, this.mWidth, this.mHeight, this.mResourceProvider, new Object[0]);
        }
    }
}
