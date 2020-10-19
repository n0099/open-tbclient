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
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class PraiseAnimElementBuilderEx implements IPraiseElementBuilder<Map<Integer, List<IAnimatedElement>>> {
    private static final int CACHEDATA_MAX_CONCURRENT_CNT = 2;
    private Map<String, List<CacheData>> mCacheMap;
    private WeakReference<Drawable.Callback> mDrawableCallback;
    private int mLastCacheDataIndex;
    private ILayoutStrategy.ICallback mLayoutCallback;
    private IPraiseElementBuilder.PreBuildConfig mPreBuildCng;
    private static String[] sPkgTag = {"day_l", "day_m", "day_r"};
    private static String[] sPkgNightTag = {"night_l", "night_m", "night_r"};

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class CacheData {
        public Map<Integer, List<IAnimatedElement>> elementListMap;
        public Map<Integer, IAnimatedElement> elementSingleMap;

        private CacheData() {
            this.elementSingleMap = new LinkedHashMap();
            this.elementListMap = new LinkedHashMap();
        }
    }

    private PraiseAnimElementBuilderEx() {
        this.mCacheMap = new HashMap();
        this.mLastCacheDataIndex = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static final class Holder {
        private static final PraiseAnimElementBuilderEx sINSTANCE = new PraiseAnimElementBuilderEx();

        private Holder() {
        }
    }

    public static final PraiseAnimElementBuilderEx getInstance() {
        return Holder.sINSTANCE;
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.IPraiseElementBuilder
    public void preBuild(IPraiseElementBuilder.PreBuildConfig preBuildConfig) {
        this.mPreBuildCng = preBuildConfig;
        if (this.mPreBuildCng != null && this.mPreBuildCng.getResourceProvider() != null) {
            this.mLayoutCallback = new ILayoutStrategy.ICallback() { // from class: com.baidu.searchbox.ui.animview.praise.element.PraiseAnimElementBuilderEx.1
                @Override // com.baidu.searchbox.ui.animview.praise.layout.ILayoutStrategy.ICallback
                public void init(IAnimatedElement iAnimatedElement, int i, int i2, int i3, int i4, IResourceProvider iResourceProvider, Object... objArr) {
                    Object[] objArr2;
                    if (iAnimatedElement != null && PraiseAnimElementBuilderEx.this.mDrawableCallback != null && PraiseAnimElementBuilderEx.this.mDrawableCallback.get() != null) {
                        if (objArr == null) {
                            objArr2 = new Object[]{PraiseAnimElementBuilderEx.this.mDrawableCallback.get()};
                        } else {
                            objArr2 = new Object[objArr.length + 1];
                            System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
                            objArr2[objArr2.length - 1] = PraiseAnimElementBuilderEx.this.mDrawableCallback.get();
                        }
                        iAnimatedElement.init(i, i2, i3, i4, iResourceProvider, objArr2);
                    }
                }
            };
            String[] strArr = NightModeHelper.getNightModeSwitcherState() ? sPkgNightTag : sPkgTag;
            this.mCacheMap.clear();
            for (String str : strArr) {
                this.mPreBuildCng.getResourceProvider().setCurrentPackage(str);
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

    @Override // com.baidu.searchbox.ui.animview.praise.element.IPraiseElementBuilder
    public IPraiseElementBuilder.PreBuildConfig getPreBuildConfig() {
        return this.mPreBuildCng;
    }

    private void generateElement(int i, CacheData cacheData) {
        IAnimatedElement eruptionAnimatedGroupEx;
        switch (i) {
            case 0:
                eruptionAnimatedGroupEx = new WaveAnimElementEx(BaseAnimatedElement.ScaleType.FIT_CENTER, this.mPreBuildCng.getResourceProvider());
                break;
            case 1:
                eruptionAnimatedGroupEx = new ShakeAnimElementEx(BaseAnimatedElement.ScaleType.FIT_CENTER, this.mPreBuildCng.getResourceProvider());
                break;
            case 2:
                eruptionAnimatedGroupEx = new PraiseLevelAnimElementEx(BaseAnimatedElement.ScaleType.FIT_XY, this.mPreBuildCng.getResourceProvider());
                break;
            case 3:
                eruptionAnimatedGroupEx = new PraiseNumberAnimElementEx();
                break;
            case 4:
                eruptionAnimatedGroupEx = new EruptionAnimatedGroupEx(BaseAnimatedElement.ScaleType.FIT_XY);
                break;
            default:
                return;
        }
        if (eruptionAnimatedGroupEx != null) {
            cacheData.elementSingleMap.put(Integer.valueOf(i), eruptionAnimatedGroupEx);
            addToElementListMap(i, cacheData);
        }
    }

    private void addToElementListMap(int i, CacheData cacheData) {
        Map<Integer, Integer> elementCntsMap = this.mPreBuildCng == null ? null : this.mPreBuildCng.getElementCntsMap();
        int intValue = (elementCntsMap == null || elementCntsMap.isEmpty() || !elementCntsMap.containsKey(Integer.valueOf(i))) ? 0 : elementCntsMap.get(Integer.valueOf(i)).intValue();
        ArrayList arrayList = new ArrayList();
        IAnimatedElement iAnimatedElement = cacheData.elementSingleMap.get(Integer.valueOf(i));
        if (iAnimatedElement != null) {
            arrayList.add(iAnimatedElement);
            if (intValue <= 1) {
                cacheData.elementListMap.put(Integer.valueOf(i), arrayList);
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
            cacheData.elementListMap.put(Integer.valueOf(i), arrayList);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.animview.praise.element.IPraiseElementBuilder
    public Map<Integer, List<IAnimatedElement>> getResult(IPraiseElementBuilder.FetchConfig fetchConfig) {
        if (fetchConfig == null || this.mPreBuildCng == null || this.mCacheMap.isEmpty()) {
            return null;
        }
        List<CacheData> list = this.mCacheMap.get(fetchConfig.getPkgTag());
        if (list == null || list.isEmpty()) {
            return null;
        }
        CacheData cacheData = list.get(this.mLastCacheDataIndex);
        this.mLastCacheDataIndex++;
        if (this.mLastCacheDataIndex == 2) {
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
                for (int i = 1; i < value.size(); i++) {
                    value.get(i).copyAttribute((BaseAnimatedElement) iAnimatedElement);
                }
            }
        }
        return cacheData.elementListMap;
    }
}
