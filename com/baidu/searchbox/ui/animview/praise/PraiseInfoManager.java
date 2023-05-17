package com.baidu.searchbox.ui.animview.praise;

import android.text.TextUtils;
import android.util.LruCache;
/* loaded from: classes4.dex */
public class PraiseInfoManager {
    public static final int LRU_MAX_COUNT = 10;
    public LruCache<String, PraiseInfo> mPraiseInfoMap;

    /* loaded from: classes4.dex */
    public static final class Holder {
        public static final PraiseInfoManager INSTANCE = new PraiseInfoManager();
    }

    /* loaded from: classes4.dex */
    public static class PraiseInfo {
        public long mCounts;
        public int mOffsetY;

        public PraiseInfo(long j, int i) {
            this.mCounts = j;
            this.mOffsetY = i;
        }
    }

    public PraiseInfoManager() {
        this.mPraiseInfoMap = new LruCache<>(10);
    }

    public static final PraiseInfoManager getInstance() {
        return Holder.INSTANCE;
    }

    public int getOffsetY(String str) {
        PraiseInfo praiseInfo;
        LruCache<String, PraiseInfo> lruCache = this.mPraiseInfoMap;
        if (lruCache == null || lruCache.size() <= 0 || TextUtils.isEmpty(str) || (praiseInfo = this.mPraiseInfoMap.get(str)) == null) {
            return -1;
        }
        return praiseInfo.mOffsetY;
    }

    public long getPraiseCounts(String str) {
        PraiseInfo praiseInfo;
        LruCache<String, PraiseInfo> lruCache = this.mPraiseInfoMap;
        if (lruCache == null || lruCache.size() <= 0 || TextUtils.isEmpty(str) || (praiseInfo = this.mPraiseInfoMap.get(str)) == null) {
            return -1L;
        }
        return praiseInfo.mCounts;
    }

    public static String makePraiseInfoKey(String str, String str2) {
        return str + "_" + str2;
    }

    public void updateOffsetY(String str, int i) {
        if (this.mPraiseInfoMap != null && !TextUtils.isEmpty(str)) {
            PraiseInfo praiseInfo = this.mPraiseInfoMap.get(str);
            if (praiseInfo != null) {
                praiseInfo.mOffsetY = i;
            } else {
                this.mPraiseInfoMap.put(str, new PraiseInfo(0L, i));
            }
        }
    }

    public void updatePraiseCounts(String str, long j) {
        if (this.mPraiseInfoMap != null && !TextUtils.isEmpty(str)) {
            PraiseInfo praiseInfo = this.mPraiseInfoMap.get(str);
            if (praiseInfo != null) {
                praiseInfo.mCounts = j;
            } else {
                this.mPraiseInfoMap.put(str, new PraiseInfo(j, 0));
            }
        }
    }
}
