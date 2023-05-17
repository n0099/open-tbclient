package com.baidu.searchbox.ui.animview.util;

import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
/* loaded from: classes4.dex */
public class PraiseLevelUtil {
    public static Set<IResourceProvider.PraiseLevelConfig> sLevelConfigSet;

    public static void genDefaultLevelConfig() {
        Set<IResourceProvider.PraiseLevelConfig> set = sLevelConfigSet;
        if (set == null) {
            sLevelConfigSet = new TreeSet(new IResourceProvider.PraiseLevelConfig.DefaultComparator());
        } else {
            set.clear();
        }
        sLevelConfigSet.add(new IResourceProvider.PraiseLevelConfig(9L, 1, 1));
        sLevelConfigSet.add(new IResourceProvider.PraiseLevelConfig(99L, 2, 2));
        sLevelConfigSet.add(new IResourceProvider.PraiseLevelConfig(499L, 3, 3));
        sLevelConfigSet.add(new IResourceProvider.PraiseLevelConfig(999L, 3, 4));
        sLevelConfigSet.add(new IResourceProvider.PraiseLevelConfig(1499L, 4, 5));
        sLevelConfigSet.add(new IResourceProvider.PraiseLevelConfig(2147483647L, Integer.MAX_VALUE, Integer.MAX_VALUE));
        validateLevel0Config();
    }

    public static IResourceProvider.PraiseLevelConfig matchPraiseLevel(long j) {
        Set<IResourceProvider.PraiseLevelConfig> set = sLevelConfigSet;
        if (set == null || set.isEmpty()) {
            genDefaultLevelConfig();
        }
        for (IResourceProvider.PraiseLevelConfig praiseLevelConfig : sLevelConfigSet) {
            if (j <= praiseLevelConfig.mBound) {
                return praiseLevelConfig;
            }
        }
        return new IResourceProvider.PraiseLevelConfig(2147483647L, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    public static void updateLevelConfig(Set<IResourceProvider.PraiseLevelConfig> set) {
        int i;
        int i2;
        if (set != null && !set.isEmpty()) {
            Set<IResourceProvider.PraiseLevelConfig> set2 = sLevelConfigSet;
            if (set2 == null) {
                sLevelConfigSet = new TreeSet(new IResourceProvider.PraiseLevelConfig.DefaultComparator());
            } else {
                set2.clear();
            }
            for (IResourceProvider.PraiseLevelConfig praiseLevelConfig : set) {
                long j = praiseLevelConfig.mBound;
                if (j > 0 && (i = praiseLevelConfig.mTextCount) >= 1 && (i2 = praiseLevelConfig.mLevelImgIndex) >= 0) {
                    if (i > 4) {
                        sLevelConfigSet.add(new IResourceProvider.PraiseLevelConfig(j, 4, i2));
                    } else {
                        sLevelConfigSet.add(praiseLevelConfig);
                    }
                }
            }
            if (sLevelConfigSet.isEmpty()) {
                genDefaultLevelConfig();
                return;
            }
            sLevelConfigSet.add(new IResourceProvider.PraiseLevelConfig(2147483647L, Integer.MAX_VALUE, Integer.MAX_VALUE));
            validateLevel0Config();
            return;
        }
        genDefaultLevelConfig();
    }

    public static void validateLevel0Config() {
        Set<IResourceProvider.PraiseLevelConfig> set = sLevelConfigSet;
        if (set != null && !set.isEmpty()) {
            Iterator<IResourceProvider.PraiseLevelConfig> it = sLevelConfigSet.iterator();
            while (it.hasNext()) {
                IResourceProvider.PraiseLevelConfig next = it.next();
                if (next.mBound == 1 && next.mTextCount == 1) {
                    it.remove();
                }
            }
            sLevelConfigSet.add(new IResourceProvider.PraiseLevelConfig(1L, 1, 0));
        }
    }
}
