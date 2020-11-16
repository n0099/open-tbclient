package com.baidu.searchbox.ui.animview.util;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
/* loaded from: classes14.dex */
public class PraiseLevelUtil {
    private static Set<IResourceProvider.PraiseLevelConfig> sLevelConfigSet;

    public static void updateLevelConfig(Set<IResourceProvider.PraiseLevelConfig> set) {
        if (set == null || set.isEmpty()) {
            genDefaultLevelConfig();
            return;
        }
        if (sLevelConfigSet == null) {
            sLevelConfigSet = new TreeSet(new IResourceProvider.PraiseLevelConfig.DefaultComparator());
        } else {
            sLevelConfigSet.clear();
        }
        for (IResourceProvider.PraiseLevelConfig praiseLevelConfig : set) {
            if (praiseLevelConfig.mBound > 0 && praiseLevelConfig.mTextCount >= 1 && praiseLevelConfig.mLevelImgIndex >= 0) {
                if (praiseLevelConfig.mTextCount > 4) {
                    sLevelConfigSet.add(new IResourceProvider.PraiseLevelConfig(praiseLevelConfig.mBound, 4, praiseLevelConfig.mLevelImgIndex));
                } else {
                    sLevelConfigSet.add(praiseLevelConfig);
                }
            }
        }
        if (sLevelConfigSet.isEmpty()) {
            genDefaultLevelConfig();
            return;
        }
        sLevelConfigSet.add(new IResourceProvider.PraiseLevelConfig(2147483647L, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED));
        validateLevel0Config();
    }

    private static void genDefaultLevelConfig() {
        if (sLevelConfigSet == null) {
            sLevelConfigSet = new TreeSet(new IResourceProvider.PraiseLevelConfig.DefaultComparator());
        } else {
            sLevelConfigSet.clear();
        }
        sLevelConfigSet.add(new IResourceProvider.PraiseLevelConfig(9L, 1, 1));
        sLevelConfigSet.add(new IResourceProvider.PraiseLevelConfig(99L, 2, 2));
        sLevelConfigSet.add(new IResourceProvider.PraiseLevelConfig(499L, 3, 3));
        sLevelConfigSet.add(new IResourceProvider.PraiseLevelConfig(999L, 3, 4));
        sLevelConfigSet.add(new IResourceProvider.PraiseLevelConfig(1499L, 4, 5));
        sLevelConfigSet.add(new IResourceProvider.PraiseLevelConfig(2147483647L, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED));
        validateLevel0Config();
    }

    private static void validateLevel0Config() {
        if (sLevelConfigSet != null && !sLevelConfigSet.isEmpty()) {
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

    public static IResourceProvider.PraiseLevelConfig matchPraiseLevel(long j) {
        if (sLevelConfigSet == null || sLevelConfigSet.isEmpty()) {
            genDefaultLevelConfig();
        }
        for (IResourceProvider.PraiseLevelConfig praiseLevelConfig : sLevelConfigSet) {
            if (j <= praiseLevelConfig.mBound) {
                return praiseLevelConfig;
            }
        }
        return new IResourceProvider.PraiseLevelConfig(2147483647L, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }
}
