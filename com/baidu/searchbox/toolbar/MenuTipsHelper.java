package com.baidu.searchbox.toolbar;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class MenuTipsHelper {
    public static final int TYPE_DOWNLOAD_UNREAD = 2;
    public static final int TYPE_IM_MESSAGE = 1;
    public Map<Integer, TipsInfo> mTipsInfo = new HashMap();

    /* loaded from: classes4.dex */
    public static final class TipsInfo {
        public int count;
        public boolean isShow;

        public TipsInfo() {
        }
    }

    public int getMenuTipsCount() {
        int i = 0;
        for (TipsInfo tipsInfo : this.mTipsInfo.values()) {
            i += tipsInfo.count;
        }
        return i;
    }

    public boolean isShowMenuTips() {
        for (TipsInfo tipsInfo : this.mTipsInfo.values()) {
            if (tipsInfo.isShow) {
                return true;
            }
        }
        return false;
    }

    public void refreshMenuTips(int i, boolean z, int i2) {
        TipsInfo tipsInfo = this.mTipsInfo.get(Integer.valueOf(i));
        if (tipsInfo == null) {
            tipsInfo = new TipsInfo();
            this.mTipsInfo.put(Integer.valueOf(i), tipsInfo);
        }
        tipsInfo.isShow = z;
        tipsInfo.count = i2;
    }
}
