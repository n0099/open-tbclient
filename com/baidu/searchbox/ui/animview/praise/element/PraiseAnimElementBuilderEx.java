package com.baidu.searchbox.ui.animview.praise.element;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import com.baidu.searchbox.ui.animview.praise.element.IPraiseElementBuilder;
import com.baidu.searchbox.ui.animview.praise.element.eruption.EruptionAnimatedGroupEx;
import com.baidu.searchbox.ui.animview.praise.layout.ILayoutStrategy;
import com.baidu.searchbox.ui.animview.praise.view.ComboPraiseView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class PraiseAnimElementBuilderEx implements IPraiseElementBuilder<Map<Integer, List<IAnimatedElement>>> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CACHEDATA_MAX_CONCURRENT_CNT = 2;
    public static String[] sPkgNightTag;
    public static String[] sPkgTag;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, List<CacheData>> mCacheMap;
    public WeakReference<Drawable.Callback> mDrawableCallback;
    public int mLastCacheDataIndex;
    public ILayoutStrategy.ICallback mLayoutCallback;
    public IPraiseElementBuilder.PreBuildConfig mPreBuildCng;

    /* loaded from: classes7.dex */
    public static class CacheData {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Map<Integer, List<IAnimatedElement>> elementListMap;
        public Map<Integer, IAnimatedElement> elementSingleMap;

        public CacheData() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.elementSingleMap = new LinkedHashMap();
            this.elementListMap = new LinkedHashMap();
        }
    }

    /* loaded from: classes7.dex */
    public static final class Holder {
        public static /* synthetic */ Interceptable $ic;
        public static final PraiseAnimElementBuilderEx sINSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1293883720, "Lcom/baidu/searchbox/ui/animview/praise/element/PraiseAnimElementBuilderEx$Holder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1293883720, "Lcom/baidu/searchbox/ui/animview/praise/element/PraiseAnimElementBuilderEx$Holder;");
                    return;
                }
            }
            sINSTANCE = new PraiseAnimElementBuilderEx();
        }

        public Holder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1788787054, "Lcom/baidu/searchbox/ui/animview/praise/element/PraiseAnimElementBuilderEx;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1788787054, "Lcom/baidu/searchbox/ui/animview/praise/element/PraiseAnimElementBuilderEx;");
                return;
            }
        }
        sPkgTag = new String[]{ComboPraiseView.PKG_TAG_DAY_L, ComboPraiseView.PKG_TAG_DAY_M, ComboPraiseView.PKG_TAG_DAY_R};
        sPkgNightTag = new String[]{ComboPraiseView.PKG_TAG_NIGHT_L, ComboPraiseView.PKG_TAG_NIGHT_M, ComboPraiseView.PKG_TAG_NIGHT_R};
    }

    private void addToElementListMap(int i2, CacheData cacheData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, this, i2, cacheData) == null) {
            IPraiseElementBuilder.PreBuildConfig preBuildConfig = this.mPreBuildCng;
            Map<Integer, Integer> elementCntsMap = preBuildConfig == null ? null : preBuildConfig.getElementCntsMap();
            int intValue = (elementCntsMap == null || elementCntsMap.isEmpty() || !elementCntsMap.containsKey(Integer.valueOf(i2))) ? 0 : elementCntsMap.get(Integer.valueOf(i2)).intValue();
            ArrayList arrayList = new ArrayList();
            IAnimatedElement iAnimatedElement = cacheData.elementSingleMap.get(Integer.valueOf(i2));
            if (iAnimatedElement == null) {
                return;
            }
            arrayList.add(iAnimatedElement);
            if (intValue <= 1) {
                cacheData.elementListMap.put(Integer.valueOf(i2), arrayList);
                return;
            }
            for (int i3 = 0; i3 < intValue - 1; i3++) {
                BaseAnimatedElement cloneInstance = iAnimatedElement.cloneInstance();
                if (cloneInstance == null) {
                    return;
                }
                arrayList.add(cloneInstance);
            }
            cacheData.elementListMap.put(Integer.valueOf(i2), arrayList);
        }
    }

    private void generateElement(int i2, CacheData cacheData) {
        IAnimatedElement waveAnimElementEx;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(AdIconUtil.AD_TEXT_ID, this, i2, cacheData) == null) {
            if (i2 == 0) {
                waveAnimElementEx = new WaveAnimElementEx(BaseAnimatedElement.ScaleType.FIT_CENTER, this.mPreBuildCng.getResourceProvider());
            } else if (i2 == 1) {
                waveAnimElementEx = new ShakeAnimElementEx(BaseAnimatedElement.ScaleType.FIT_CENTER, this.mPreBuildCng.getResourceProvider());
            } else if (i2 == 2) {
                waveAnimElementEx = new PraiseLevelAnimElementEx(BaseAnimatedElement.ScaleType.FIT_XY, this.mPreBuildCng.getResourceProvider());
            } else if (i2 == 3) {
                waveAnimElementEx = new PraiseNumberAnimElementEx();
            } else if (i2 != 4) {
                return;
            } else {
                waveAnimElementEx = new EruptionAnimatedGroupEx(BaseAnimatedElement.ScaleType.FIT_XY);
            }
            cacheData.elementSingleMap.put(Integer.valueOf(i2), waveAnimElementEx);
            addToElementListMap(i2, cacheData);
        }
    }

    public static final PraiseAnimElementBuilderEx getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? Holder.sINSTANCE : (PraiseAnimElementBuilderEx) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.IPraiseElementBuilder
    public IPraiseElementBuilder.PreBuildConfig getPreBuildConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mPreBuildCng : (IPraiseElementBuilder.PreBuildConfig) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.IPraiseElementBuilder
    public void preBuild(IPraiseElementBuilder.PreBuildConfig preBuildConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, preBuildConfig) == null) {
            this.mPreBuildCng = preBuildConfig;
            if (preBuildConfig == null || preBuildConfig.getResourceProvider() == null) {
                return;
            }
            this.mLayoutCallback = new ILayoutStrategy.ICallback(this) { // from class: com.baidu.searchbox.ui.animview.praise.element.PraiseAnimElementBuilderEx.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PraiseAnimElementBuilderEx this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.searchbox.ui.animview.praise.layout.ILayoutStrategy.ICallback
                public void init(IAnimatedElement iAnimatedElement, int i2, int i3, int i4, int i5, IResourceProvider iResourceProvider, Object... objArr) {
                    Object[] objArr2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{iAnimatedElement, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iResourceProvider, objArr}) == null) || iAnimatedElement == null || this.this$0.mDrawableCallback == null || this.this$0.mDrawableCallback.get() == null) {
                        return;
                    }
                    if (objArr == null) {
                        objArr2 = new Object[]{this.this$0.mDrawableCallback.get()};
                    } else {
                        int length = objArr.length + 1;
                        Object[] objArr3 = new Object[length];
                        System.arraycopy(objArr, 0, objArr3, 0, objArr.length);
                        objArr3[length - 1] = this.this$0.mDrawableCallback.get();
                        objArr2 = objArr3;
                    }
                    iAnimatedElement.init(i2, i3, i4, i5, iResourceProvider, objArr2);
                }
            };
            String[] strArr = NightModeHelper.getNightModeSwitcherState() ? sPkgNightTag : sPkgTag;
            this.mCacheMap.clear();
            for (String str : strArr) {
                this.mPreBuildCng.getResourceProvider().setCurrentPackage(str);
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < 2; i2++) {
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

    public PraiseAnimElementBuilderEx() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mCacheMap = new HashMap();
        this.mLastCacheDataIndex = 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.animview.praise.element.IPraiseElementBuilder
    public Map<Integer, List<IAnimatedElement>> getResult(IPraiseElementBuilder.FetchConfig fetchConfig) {
        InterceptResult invokeL;
        List<CacheData> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fetchConfig)) == null) {
            if (fetchConfig == null || this.mPreBuildCng == null || this.mCacheMap.isEmpty() || (list = this.mCacheMap.get(fetchConfig.getPkgTag())) == null || list.isEmpty()) {
                return null;
            }
            CacheData cacheData = list.get(this.mLastCacheDataIndex);
            int i2 = this.mLastCacheDataIndex + 1;
            this.mLastCacheDataIndex = i2;
            if (i2 == 2) {
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
                    for (int i3 = 1; i3 < value.size(); i3++) {
                        value.get(i3).copyAttribute((BaseAnimatedElement) iAnimatedElement);
                    }
                }
            }
            return cacheData.elementListMap;
        }
        return (Map) invokeL.objValue;
    }
}
