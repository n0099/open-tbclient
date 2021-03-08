package com.baidu.live.tbadk.coreextra.data;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
@Deprecated
/* loaded from: classes10.dex */
public class ListItemsRule {
    private static final int MAX_CACHE_DEFAULT = Integer.MAX_VALUE;
    private int FrsMaxCache;
    private int FrsPn;
    private int maxCache;

    public int getMaxCache() {
        if (this.maxCache == 0) {
            return Integer.MAX_VALUE;
        }
        return this.maxCache;
    }

    public void setMaxCache(String str) {
        this.maxCache = JavaTypesHelper.toInt(str, 0);
    }

    public int getFrsMaxCache() {
        return this.FrsMaxCache;
    }

    public void setFrsMaxCache(String str) {
        this.FrsMaxCache = JavaTypesHelper.toInt(str, 0);
    }

    public int getFrsPn() {
        return this.FrsPn;
    }

    public void setFrsPn(String str) {
        this.FrsPn = JavaTypesHelper.toInt(str, 0);
    }
}
