package com.baidu.searchbox.ui.animview.praise.element;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import com.baidu.searchbox.ui.animview.praise.element.eruption.EruptionAnimatedGroup;
import com.baidu.searchbox.ui.animview.praise.layout.ILayoutStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes11.dex */
public class PraiseAnimElementBuilder {
    private int mCanvasHeight;
    private int mCanvasWidth;
    private Context mCtx;
    private Drawable.Callback mDrawableCallback;
    private Map<Integer, Integer> mElementCntsMap;
    private ILayoutStrategy mLayoutStrategy;
    private IResourceProvider mProvider;
    private int mSourceType;
    private int mStrategy;
    private Rect mBaseRect = new Rect();
    private Map<Integer, IAnimatedElement> mElementSingleMap = new HashMap();
    private Map<Integer, List<IAnimatedElement>> mElementListMap = new HashMap();

    public PraiseAnimElementBuilder(Context context, int i) {
        this.mCtx = context;
        this.mSourceType = i;
    }

    public PraiseAnimElementBuilder setDrawableCallback(Drawable.Callback callback) {
        this.mDrawableCallback = callback;
        return this;
    }

    public PraiseAnimElementBuilder setBaseLeft(int i) {
        this.mBaseRect.left = i;
        return this;
    }

    public PraiseAnimElementBuilder setBaseTop(int i) {
        this.mBaseRect.top = i;
        return this;
    }

    public PraiseAnimElementBuilder setBaseWidth(int i) {
        this.mBaseRect.right = this.mBaseRect.left + i;
        return this;
    }

    public PraiseAnimElementBuilder setBaseHeight(int i) {
        this.mBaseRect.bottom = this.mBaseRect.top + i;
        return this;
    }

    public PraiseAnimElementBuilder setResourceProvider(IResourceProvider iResourceProvider) {
        this.mProvider = iResourceProvider;
        return this;
    }

    public PraiseAnimElementBuilder setLayoutStrategy(int i) {
        this.mStrategy = i;
        return this;
    }

    public PraiseAnimElementBuilder setCanvasSize(int i, int i2) {
        this.mCanvasWidth = i;
        this.mCanvasHeight = i2;
        return this;
    }

    public PraiseAnimElementBuilder setElementCnts(Map<Integer, Integer> map) {
        this.mElementCntsMap = map;
        return this;
    }

    private void initLayoutStrategy() {
        this.mLayoutStrategy = ILayoutStrategy.Factory.getLayoutStrategy(this.mStrategy, this.mBaseRect, this.mCanvasWidth, this.mCanvasHeight, this.mProvider);
    }

    private void generateElement(int i) {
        IAnimatedElement eruptionAnimatedGroup;
        switch (i) {
            case 0:
                eruptionAnimatedGroup = new WaveAnimElement(this.mDrawableCallback, BaseAnimatedElement.ScaleType.FIT_CENTER);
                break;
            case 1:
                eruptionAnimatedGroup = new ShakeAnimElement(this.mDrawableCallback, BaseAnimatedElement.ScaleType.FIT_CENTER);
                break;
            case 2:
                eruptionAnimatedGroup = new PraiseLevelAnimElement(this.mDrawableCallback, BaseAnimatedElement.ScaleType.FIT_XY);
                break;
            case 3:
                eruptionAnimatedGroup = new PraiseNumberAnimElement();
                break;
            case 4:
                eruptionAnimatedGroup = new EruptionAnimatedGroup(this.mDrawableCallback, BaseAnimatedElement.ScaleType.FIT_XY);
                break;
            default:
                return;
        }
        if (eruptionAnimatedGroup != null && this.mLayoutStrategy != null) {
            this.mElementSingleMap.put(Integer.valueOf(i), eruptionAnimatedGroup);
            this.mLayoutStrategy.layout(i, this.mElementSingleMap);
            addToElementListMap(i);
        }
    }

    private void addToElementListMap(int i) {
        int intValue = (this.mElementCntsMap == null || this.mElementCntsMap.isEmpty() || !this.mElementCntsMap.containsKey(Integer.valueOf(i))) ? 0 : this.mElementCntsMap.get(Integer.valueOf(i)).intValue();
        ArrayList arrayList = new ArrayList();
        IAnimatedElement iAnimatedElement = this.mElementSingleMap.get(Integer.valueOf(i));
        if (iAnimatedElement != null) {
            arrayList.add(iAnimatedElement);
            if (intValue <= 1) {
                this.mElementListMap.put(Integer.valueOf(i), arrayList);
                return;
            }
            for (int i2 = 0; i2 < intValue - 1; i2++) {
                BaseAnimatedElement cloneInstance = iAnimatedElement.cloneInstance();
                if (cloneInstance != null) {
                    arrayList.add(cloneInstance);
                } else {
                    return;
                }
            }
            this.mElementListMap.put(Integer.valueOf(i), arrayList);
        }
    }

    public Map<Integer, List<IAnimatedElement>> build() {
        initLayoutStrategy();
        generateElement(0);
        generateElement(1);
        generateElement(2);
        generateElement(3);
        generateElement(4);
        return this.mElementListMap;
    }
}
