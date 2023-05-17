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
/* loaded from: classes4.dex */
public class PraiseAnimElementBuilder {
    public int mCanvasHeight;
    public int mCanvasWidth;
    public Context mCtx;
    public Drawable.Callback mDrawableCallback;
    public Map<Integer, Integer> mElementCntsMap;
    public ILayoutStrategy mLayoutStrategy;
    public IResourceProvider mProvider;
    public int mSourceType;
    public int mStrategy;
    public Rect mBaseRect = new Rect();
    public Map<Integer, IAnimatedElement> mElementSingleMap = new HashMap();
    public Map<Integer, List<IAnimatedElement>> mElementListMap = new HashMap();

    public PraiseAnimElementBuilder(Context context, int i) {
        this.mCtx = context;
        this.mSourceType = i;
    }

    public PraiseAnimElementBuilder setCanvasSize(int i, int i2) {
        this.mCanvasWidth = i;
        this.mCanvasHeight = i2;
        return this;
    }

    private void addToElementListMap(int i) {
        int i2;
        Map<Integer, Integer> map = this.mElementCntsMap;
        if (map != null && !map.isEmpty() && this.mElementCntsMap.containsKey(Integer.valueOf(i))) {
            i2 = this.mElementCntsMap.get(Integer.valueOf(i)).intValue();
        } else {
            i2 = 0;
        }
        ArrayList arrayList = new ArrayList();
        IAnimatedElement iAnimatedElement = this.mElementSingleMap.get(Integer.valueOf(i));
        if (iAnimatedElement == null) {
            return;
        }
        arrayList.add(iAnimatedElement);
        if (i2 <= 1) {
            this.mElementListMap.put(Integer.valueOf(i), arrayList);
            return;
        }
        for (int i3 = 0; i3 < i2 - 1; i3++) {
            BaseAnimatedElement cloneInstance = iAnimatedElement.cloneInstance();
            if (cloneInstance == null) {
                return;
            }
            arrayList.add(cloneInstance);
        }
        this.mElementListMap.put(Integer.valueOf(i), arrayList);
    }

    private void generateElement(int i) {
        IAnimatedElement waveAnimElement;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return;
                        }
                        waveAnimElement = new EruptionAnimatedGroup(this.mDrawableCallback, BaseAnimatedElement.ScaleType.FIT_XY);
                    } else {
                        waveAnimElement = new PraiseNumberAnimElement();
                    }
                } else {
                    waveAnimElement = new PraiseLevelAnimElement(this.mDrawableCallback, BaseAnimatedElement.ScaleType.FIT_XY);
                }
            } else {
                waveAnimElement = new ShakeAnimElement(this.mDrawableCallback, BaseAnimatedElement.ScaleType.FIT_CENTER);
            }
        } else {
            waveAnimElement = new WaveAnimElement(this.mDrawableCallback, BaseAnimatedElement.ScaleType.FIT_CENTER);
        }
        if (this.mLayoutStrategy != null) {
            this.mElementSingleMap.put(Integer.valueOf(i), waveAnimElement);
            this.mLayoutStrategy.layout(i, this.mElementSingleMap);
            addToElementListMap(i);
        }
    }

    private void initLayoutStrategy() {
        this.mLayoutStrategy = ILayoutStrategy.Factory.getLayoutStrategy(this.mStrategy, this.mBaseRect, this.mCanvasWidth, this.mCanvasHeight, this.mProvider);
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

    public PraiseAnimElementBuilder setBaseHeight(int i) {
        Rect rect = this.mBaseRect;
        rect.bottom = rect.top + i;
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
        Rect rect = this.mBaseRect;
        rect.right = rect.left + i;
        return this;
    }

    public PraiseAnimElementBuilder setDrawableCallback(Drawable.Callback callback) {
        this.mDrawableCallback = callback;
        return this;
    }

    public PraiseAnimElementBuilder setElementCnts(Map<Integer, Integer> map) {
        this.mElementCntsMap = map;
        return this;
    }

    public PraiseAnimElementBuilder setLayoutStrategy(int i) {
        this.mStrategy = i;
        return this;
    }

    public PraiseAnimElementBuilder setResourceProvider(IResourceProvider iResourceProvider) {
        this.mProvider = iResourceProvider;
        return this;
    }
}
