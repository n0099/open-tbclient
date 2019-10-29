package com.baidu.live.tbadk.pagestayduration;

import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
/* loaded from: classes6.dex */
public abstract class PageStayDurationFilter {
    private static final int FIX_MAX_COST = 5;
    private boolean isSwitchOpen = SharedPrefHelper.getInstance().getBoolean(SharedPrefConfig.PAGE_STAY_DURATION_SWITCH, false);

    /* loaded from: classes6.dex */
    public interface IDirtyData {
        boolean isDirtyData();
    }

    public abstract int getMaxCost();

    public abstract boolean isCurrentPageCanBeAddToSourceTrace();

    public boolean canStat(PageStayDurationItem pageStayDurationItem) {
        if (pageStayDurationItem == null || pageStayDurationItem.isDirtyData()) {
            return false;
        }
        if (pageStayDurationItem.isRouteStat) {
            pageStayDurationItem.setSorceKeyList(PageStayDurationHelper.trimToSize(pageStayDurationItem.getSorceKeyList(), 6));
        } else {
            int maxCostFromServer = getMaxCost() > PageStayDurationStat.getInstance().getMaxCostFromServer() ? PageStayDurationStat.getInstance().getMaxCostFromServer() : getMaxCost();
            pageStayDurationItem.setSorceKeyList(PageStayDurationHelper.trimToSize(pageStayDurationItem.getSorceKeyList(), maxCostFromServer <= 5 ? maxCostFromServer : 5));
        }
        return true;
    }

    private void updataSwitchStaus(boolean z) {
        if (this.isSwitchOpen != z) {
            SharedPrefHelper.getInstance().putBoolean(SharedPrefConfig.PAGE_STAY_DURATION_SWITCH, true);
            this.isSwitchOpen = z;
        }
    }

    public boolean isSwitchOpen() {
        if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
            return this.isSwitchOpen;
        }
        if (!TbadkCoreApplication.getInst().isPageStayOpen()) {
            updataSwitchStaus(false);
            return false;
        } else if (!PageStayDurationStat.getInstance().isSmallFlowOpen()) {
            updataSwitchStaus(false);
            return false;
        } else {
            updataSwitchStaus(true);
            return true;
        }
    }
}
