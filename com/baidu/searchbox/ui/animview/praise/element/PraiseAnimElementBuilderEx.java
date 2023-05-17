package com.baidu.searchbox.ui.animview.praise.element;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import com.baidu.searchbox.ui.animview.praise.element.IPraiseElementBuilder;
import com.baidu.searchbox.ui.animview.praise.element.eruption.EruptionAnimatedGroupEx;
import com.baidu.searchbox.ui.animview.praise.layout.ILayoutStrategy;
import com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class PraiseAnimElementBuilderEx implements IPraiseElementBuilder<Map<Integer, List<IAnimatedElement>>> {
    public static final int CACHEDATA_MAX_CONCURRENT_CNT = 2;
    public Map<String, List<CacheData>> mCacheMap;
    public WeakReference<Drawable.Callback> mDrawableCallback;
    public int mLastCacheDataIndex;
    public ILayoutStrategy.ICallback mLayoutCallback;
    public IPraiseElementBuilder.PreBuildConfig mPreBuildCng;
    public static String[] sPkgTag = {ComboPraiseView.PKG_TAG_DAY_L, ComboPraiseView.PKG_TAG_DAY_M, ComboPraiseView.PKG_TAG_DAY_R};
    public static String[] sPkgNightTag = {ComboPraiseView.PKG_TAG_NIGHT_L, ComboPraiseView.PKG_TAG_NIGHT_M, ComboPraiseView.PKG_TAG_NIGHT_R};

    /* loaded from: classes4.dex */
    public static class CacheData {
        public Map<Integer, List<IAnimatedElement>> elementListMap;
        public Map<Integer, IAnimatedElement> elementSingleMap;

        public CacheData() {
            this.elementSingleMap = new LinkedHashMap();
            this.elementListMap = new LinkedHashMap();
        }
    }

    /* loaded from: classes4.dex */
    public static final class Holder {
        public static final PraiseAnimElementBuilderEx INSTANCE = new PraiseAnimElementBuilderEx();
    }

    public PraiseAnimElementBuilderEx() {
        this.mCacheMap = new HashMap();
        this.mLastCacheDataIndex = 0;
    }

    public static final PraiseAnimElementBuilderEx getInstance() {
        return Holder.INSTANCE;
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.IPraiseElementBuilder
    public IPraiseElementBuilder.PreBuildConfig getPreBuildConfig() {
        return this.mPreBuildCng;
    }

    private void addToElementListMap(int i, CacheData cacheData) {
        Map<Integer, Integer> elementCntsMap;
        int i2;
        IPraiseElementBuilder.PreBuildConfig preBuildConfig = this.mPreBuildCng;
        if (preBuildConfig == null) {
            elementCntsMap = null;
        } else {
            elementCntsMap = preBuildConfig.getElementCntsMap();
        }
        if (elementCntsMap != null && !elementCntsMap.isEmpty() && elementCntsMap.containsKey(Integer.valueOf(i))) {
            i2 = elementCntsMap.get(Integer.valueOf(i)).intValue();
        } else {
            i2 = 0;
        }
        ArrayList arrayList = new ArrayList();
        IAnimatedElement iAnimatedElement = cacheData.elementSingleMap.get(Integer.valueOf(i));
        if (iAnimatedElement == null) {
            return;
        }
        arrayList.add(iAnimatedElement);
        if (i2 <= 1) {
            cacheData.elementListMap.put(Integer.valueOf(i), arrayList);
            return;
        }
        for (int i3 = 0; i3 < i2 - 1; i3++) {
            BaseAnimatedElement cloneInstance = iAnimatedElement.cloneInstance();
            if (cloneInstance == null) {
                return;
            }
            arrayList.add(cloneInstance);
        }
        cacheData.elementListMap.put(Integer.valueOf(i), arrayList);
    }

    private void generateElement(int i, CacheData cacheData) {
        IAnimatedElement waveAnimElementEx;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return;
                        }
                        waveAnimElementEx = new EruptionAnimatedGroupEx(BaseAnimatedElement.ScaleType.FIT_XY);
                    } else {
                        waveAnimElementEx = new PraiseNumberAnimElementEx();
                    }
                } else {
                    waveAnimElementEx = new PraiseLevelAnimElementEx(BaseAnimatedElement.ScaleType.FIT_XY, this.mPreBuildCng.getResourceProvider());
                }
            } else {
                waveAnimElementEx = new ShakeAnimElementEx(BaseAnimatedElement.ScaleType.FIT_CENTER, this.mPreBuildCng.getResourceProvider());
            }
        } else {
            waveAnimElementEx = new WaveAnimElementEx(BaseAnimatedElement.ScaleType.FIT_CENTER, this.mPreBuildCng.getResourceProvider());
        }
        cacheData.elementSingleMap.put(Integer.valueOf(i), waveAnimElementEx);
        addToElementListMap(i, cacheData);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.animview.praise.element.IPraiseElementBuilder
    public Map<Integer, List<IAnimatedElement>> getResult(IPraiseElementBuilder.FetchConfig fetchConfig) {
        List<CacheData> list;
        if (fetchConfig == null || this.mPreBuildCng == null || this.mCacheMap.isEmpty() || (list = this.mCacheMap.get(fetchConfig.getPkgTag())) == null || list.isEmpty()) {
            return null;
        }
        CacheData cacheData = list.get(this.mLastCacheDataIndex);
        int i = this.mLastCacheDataIndex + 1;
        this.mLastCacheDataIndex = i;
        if (i == 2) {
            this.mLastCacheDataIndex = 0;
        }
        this.mDrawableCallback = new WeakReference<>(fetchConfig.getDrawableCallback());
        ILayoutStrategy layoutStrategy = ILayoutStrategy.Factory.getLayoutStrategy(fetchConfig.getStrategy(), new Rect(fetchConfig.getLeft(), fetchConfig.getTop(), fetchConfig.getLeft() + fetchConfig.getWidth(), fetchConfig.getTop() + fetchConfig.getHeight()), fetchConfig.getCanvasWidth(), fetchConfig.getCanvasHeight(), this.mPreBuildCng.getResourceProvider());
        for (Map.Entry<Integer, List<IAnimatedElement>> entry : cacheData.elementListMap.entrySet()) {
            int intValue = entry.getKey().intValue();
            List<IAnimatedElement> value = entry.getValue();
            layoutStrategy.layout(intValue, cacheData.elementSingleMap, this.mLayoutCallback);
            if (value != null && value.size() > 1) {
                IAnimatedElement iAnimatedElement = value.get(0);
                for (int i2 = 1; i2 < value.size(); i2++) {
                    value.get(i2).copyAttribute((BaseAnimatedElement) iAnimatedElement);
                }
            }
        }
        return cacheData.elementListMap;
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.IPraiseElementBuilder
    public void preBuild(IPraiseElementBuilder.PreBuildConfig preBuildConfig) {
        String[] strArr;
        this.mPreBuildCng = preBuildConfig;
        if (preBuildConfig != null && preBuildConfig.getResourceProvider() != null) {
            this.mLayoutCallback = new ILayoutStrategy.ICallback() { // from class: com.baidu.searchbox.ui.animview.praise.element.PraiseAnimElementBuilderEx.1
                @Override // com.baidu.searchbox.ui.animview.praise.layout.ILayoutStrategy.ICallback
                public void init(IAnimatedElement iAnimatedElement, int i, int i2, int i3, int i4, IResourceProvider iResourceProvider, Object... objArr) {
                    Object[] objArr2;
                    if (iAnimatedElement != null && PraiseAnimElementBuilderEx.this.mDrawableCallback != null && PraiseAnimElementBuilderEx.this.mDrawableCallback.get() != null) {
                        if (objArr == null) {
                            objArr2 = new Object[]{PraiseAnimElementBuilderEx.this.mDrawableCallback.get()};
                        } else {
                            int length = objArr.length + 1;
                            Object[] objArr3 = new Object[length];
                            System.arraycopy(objArr, 0, objArr3, 0, objArr.length);
                            objArr3[length - 1] = PraiseAnimElementBuilderEx.this.mDrawableCallback.get();
                            objArr2 = objArr3;
                        }
                        iAnimatedElement.init(i, i2, i3, i4, iResourceProvider, objArr2);
                    }
                }
            };
            if (NightModeHelper.getNightModeSwitcherState()) {
                strArr = sPkgNightTag;
            } else {
                strArr = sPkgTag;
            }
            this.mCacheMap.clear();
            for (String str : strArr) {
                IResourceProvider resourceProvider = this.mPreBuildCng.getResourceProvider();
                if (resourceProvider != null) {
                    resourceProvider.setCurrentPackage(str);
                }
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < 2; i++) {
                    CacheData cacheData = new CacheData();
                    generateElement(0, cacheData);
                    generateElement(1, cacheData);
                    generateElement(2, cacheData);
                    generateElement(3, cacheData);
                    generateElement(4, cacheData);
                    arrayList.add(cacheData);
                }
                this.mCacheMap.put(str, arrayList);
            }
        }
    }
}
