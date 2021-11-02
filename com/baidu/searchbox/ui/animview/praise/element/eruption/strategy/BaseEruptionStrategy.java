package com.baidu.searchbox.ui.animview.praise.element.eruption.strategy;

import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategy;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
/* loaded from: classes7.dex */
public abstract class BaseEruptionStrategy implements IEruptionStrategy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Random mRandom;

    public BaseEruptionStrategy() {
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
        this.mRandom = new Random();
    }

    public static Pair<Integer, Integer> getSectionAngle(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            if (i2 >= IEruptionStrategy.sSectionAngle.length / 2) {
                return null;
            }
            int i3 = i2 * 2;
            return new Pair<>(Integer.valueOf(IEruptionStrategy.sSectionAngle[i3]), Integer.valueOf(IEruptionStrategy.sSectionAngle[i3 + 1]));
        }
        return (Pair) invokeI.objValue;
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategy
    public List<BaseAnimatedElement> generateEruptionElementList(IResourceProvider iResourceProvider, IEruptionStrategy.IHostCallback iHostCallback) {
        InterceptResult invokeLL;
        int resourceCounts;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, iResourceProvider, iHostCallback)) == null) {
            if (iResourceProvider == null || iHostCallback == null || (resourceCounts = iResourceProvider.getResourceCounts(ComboPraiseProvider.RES_KEY_SUFFIX_ERUPTION)) <= 0) {
                return null;
            }
            int elementStrategyCounts = getElementStrategyCounts();
            ArrayList arrayList = new ArrayList();
            List<Integer> randomNoDuplicateList = randomNoDuplicateList(0, resourceCounts - 1, elementStrategyCounts);
            for (int i2 = 0; i2 < elementStrategyCounts; i2++) {
                BaseAnimatedElement createAndInitEruption = iHostCallback.createAndInitEruption(i2, randomNoDuplicateList.get(i2).intValue(), iResourceProvider);
                if (createAndInitEruption != null) {
                    arrayList.add(createAndInitEruption);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategy
    public List<Float> generateEruptionRotateAngleList() {
        InterceptResult invokeV;
        int[] sectionCntArray;
        List<Float> generateSectionRotateAngle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (IEruptionStrategy.sSectionAngle == null || (sectionCntArray = getSectionCntArray()) == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < IEruptionStrategy.sSectionAngle.length / 2; i2++) {
                Pair<Integer, Integer> sectionAngle = getSectionAngle(i2);
                if (sectionAngle != null && i2 < sectionCntArray.length && (generateSectionRotateAngle = generateSectionRotateAngle(((Integer) sectionAngle.first).intValue(), ((Integer) sectionAngle.second).intValue(), sectionCntArray[i2])) != null) {
                    arrayList.addAll(arrayList.size(), generateSectionRotateAngle);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public List<Float> generateSectionRotateAngle(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4)) == null) {
            if (i2 < 0 || i3 < 0 || i4 <= 0) {
                return null;
            }
            if (i2 > i3) {
                i3 += 360;
            }
            int i5 = (i3 - i2) / i4;
            ArrayList arrayList = new ArrayList();
            int i6 = 0;
            while (i6 < i4) {
                int i7 = i2 + i5;
                arrayList.add(Float.valueOf(random(i2, i7)));
                i6++;
                i2 = i7;
            }
            return arrayList;
        }
        return (List) invokeIII.objValue;
    }

    public abstract int getElementStrategyCounts();

    public abstract int[] getSectionCntArray();

    public int random(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048581, this, i2, i3)) == null) ? (this.mRandom.nextInt(i3 + 1) % ((i3 - i2) + 1)) + i2 : invokeII.intValue;
    }

    public List<Integer> randomNoDuplicateList(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048582, this, i2, i3, i4)) == null) {
            int i5 = (i3 - i2) + 1;
            ArrayList arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            boolean z = false;
            while (i4 > 0) {
                int random = random(i2, i3);
                if (z || !hashSet.contains(Integer.valueOf(random))) {
                    if (!z) {
                        hashSet.add(Integer.valueOf(random));
                    }
                    arrayList.add(Integer.valueOf(random));
                    if (arrayList.size() >= i5) {
                        z = true;
                    }
                    i4--;
                }
            }
            return arrayList;
        }
        return (List) invokeIII.objValue;
    }
}
