package com.baidu.searchbox.ui.animview.praise;

import android.text.TextUtils;
import android.util.LruCache;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes9.dex */
public class PraiseInfoManager {
    private static int LRU_MAX_COUNT = 10;
    private LruCache<String, PraiseInfo> mPraiseInfoMap;

    /* loaded from: classes9.dex */
    private static final class Holder {
        private static final PraiseInfoManager sINSTANCE = new PraiseInfoManager();

        private Holder() {
        }
    }

    private PraiseInfoManager() {
        this.mPraiseInfoMap = new LruCache<>(LRU_MAX_COUNT);
    }

    public static final PraiseInfoManager getInstance() {
        return Holder.sINSTANCE;
    }

    /* loaded from: classes9.dex */
    private static class PraiseInfo {
        public long mCounts;
        public int mOffsetY;

        public PraiseInfo(long j, int i) {
            this.mCounts = j;
            this.mOffsetY = i;
        }
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

    public int getOffsetY(String str) {
        if (this.mPraiseInfoMap == null || this.mPraiseInfoMap.size() <= 0 || TextUtils.isEmpty(str)) {
            return -1;
        }
        PraiseInfo praiseInfo = this.mPraiseInfoMap.get(str);
        if (praiseInfo != null) {
            return praiseInfo.mOffsetY;
        }
        return -1;
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

    public long getPraiseCounts(String str) {
        if (this.mPraiseInfoMap == null || this.mPraiseInfoMap.size() <= 0 || TextUtils.isEmpty(str)) {
            return -1L;
        }
        PraiseInfo praiseInfo = this.mPraiseInfoMap.get(str);
        if (praiseInfo != null) {
            return praiseInfo.mCounts;
        }
        return -1L;
    }

    public static String makePraiseInfoKey(String str, String str2) {
        return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2;
    }
}
