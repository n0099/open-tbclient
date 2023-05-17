package com.baidu.searchbox.ui.animview.praise.element.eruption.strategy;

import android.util.Pair;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategy;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
/* loaded from: classes4.dex */
public abstract class BaseEruptionStrategy implements IEruptionStrategy {
    public Random mRandom = new Random();

    public abstract int getElementStrategyCounts();

    public abstract int[] getSectionCntArray();

    public static Pair<Integer, Integer> getSectionAngle(int i) {
        if (i >= IEruptionStrategy.sSectionAngle.length / 2) {
            return null;
        }
        int i2 = i * 2;
        return new Pair<>(Integer.valueOf(IEruptionStrategy.sSectionAngle[i2]), Integer.valueOf(IEruptionStrategy.sSectionAngle[i2 + 1]));
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategy
    public List<BaseAnimatedElement> generateEruptionElementList(IResourceProvider iResourceProvider, IEruptionStrategy.IHostCallback iHostCallback) {
        int resourceCounts;
        if (iResourceProvider == null || iHostCallback == null || (resourceCounts = iResourceProvider.getResourceCounts(ComboPraiseProvider.RES_KEY_SUFFIX_ERUPTION)) <= 0) {
            return null;
        }
        int elementStrategyCounts = getElementStrategyCounts();
        ArrayList arrayList = new ArrayList();
        List<Integer> randomNoDuplicateList = randomNoDuplicateList(0, resourceCounts - 1, elementStrategyCounts);
        for (int i = 0; i < elementStrategyCounts; i++) {
            BaseAnimatedElement createAndInitEruption = iHostCallback.createAndInitEruption(i, randomNoDuplicateList.get(i).intValue(), iResourceProvider);
            if (createAndInitEruption != null) {
                arrayList.add(createAndInitEruption);
            }
        }
        return arrayList;
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategy
    public List<Float> generateEruptionRotateAngleList() {
        int[] sectionCntArray;
        List<Float> generateSectionRotateAngle;
        if (IEruptionStrategy.sSectionAngle == null || (sectionCntArray = getSectionCntArray()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < IEruptionStrategy.sSectionAngle.length / 2; i++) {
            Pair<Integer, Integer> sectionAngle = getSectionAngle(i);
            if (sectionAngle != null && i < sectionCntArray.length && (generateSectionRotateAngle = generateSectionRotateAngle(((Integer) sectionAngle.first).intValue(), ((Integer) sectionAngle.second).intValue(), sectionCntArray[i])) != null) {
                arrayList.addAll(arrayList.size(), generateSectionRotateAngle);
            }
        }
        return arrayList;
    }

    public List<Float> generateSectionRotateAngle(int i, int i2, int i3) {
        if (i >= 0 && i2 >= 0 && i3 > 0) {
            if (i > i2) {
                i2 += 360;
            }
            int i4 = (i2 - i) / i3;
            ArrayList arrayList = new ArrayList();
            int i5 = 0;
            while (i5 < i3) {
                int i6 = i + i4;
                arrayList.add(Float.valueOf(random(i, i6)));
                i5++;
                i = i6;
            }
            return arrayList;
        }
        return null;
    }

    public int random(int i, int i2) {
        return (this.mRandom.nextInt(i2 + 1) % ((i2 - i) + 1)) + i;
    }

    public List<Integer> randomNoDuplicateList(int i, int i2, int i3) {
        int i4 = (i2 - i) + 1;
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        boolean z = false;
        while (i3 > 0) {
            int random = random(i, i2);
            if (z || !hashSet.contains(Integer.valueOf(random))) {
                if (!z) {
                    hashSet.add(Integer.valueOf(random));
                }
                arrayList.add(Integer.valueOf(random));
                if (arrayList.size() >= i4) {
                    z = true;
                }
                i3--;
            }
        }
        return arrayList;
    }
}
