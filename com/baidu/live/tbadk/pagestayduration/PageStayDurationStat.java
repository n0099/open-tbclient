package com.baidu.live.tbadk.pagestayduration;

import android.content.Context;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
@Deprecated
/* loaded from: classes4.dex */
public class PageStayDurationStat {
    private static PageStayDurationStat stayDurationStat = new PageStayDurationStat();
    private boolean isSmallFlowOpen = false;
    private int maxCost;

    private PageStayDurationStat() {
    }

    public static PageStayDurationStat getInstance() {
        return stayDurationStat;
    }

    public void stat(Context context, PageStayDurationItem pageStayDurationItem) {
        stat(context, pageStayDurationItem, null);
    }

    public void stat(Context context, PageStayDurationItem pageStayDurationItem, PageStayDurationFilter pageStayDurationFilter) {
        if (pageStayDurationItem != null && !StringUtils.isNull(pageStayDurationItem.getCurrentPageKey())) {
            if (pageStayDurationItem.isRouteStat) {
                if (pageStayDurationFilter == null) {
                    pageStayDurationFilter = new PageStayDurationFilter() { // from class: com.baidu.live.tbadk.pagestayduration.PageStayDurationStat.1
                        @Override // com.baidu.live.tbadk.pagestayduration.PageStayDurationFilter
                        public boolean isCurrentPageCanBeAddToSourceTrace() {
                            return true;
                        }

                        @Override // com.baidu.live.tbadk.pagestayduration.PageStayDurationFilter
                        public int getMaxCost() {
                            return 6;
                        }
                    };
                }
                if (pageStayDurationFilter.canStat(pageStayDurationItem)) {
                    StatisticItem statisticItem = new StatisticItem(PageStayDurationConstants.ROUTE_URL_KEY);
                    statisticItem.param("obj_source", PageStayDurationHelper.toSourceTraceString(pageStayDurationItem.getSorceKeyList()));
                    statisticItem.param("obj_locate", pageStayDurationItem.getCurrentPageKey());
                    statisticItem.param("obj_type", "0");
                    if (!StringUtils.isNull(pageStayDurationItem.objID)) {
                        statisticItem.param("obj_id", pageStayDurationItem.objID);
                    }
                    TiebaInitialize.log(statisticItem);
                    return;
                }
                return;
            }
            if (pageStayDurationFilter == null) {
                pageStayDurationFilter = new PageStayDurationFilter() { // from class: com.baidu.live.tbadk.pagestayduration.PageStayDurationStat.2
                    @Override // com.baidu.live.tbadk.pagestayduration.PageStayDurationFilter
                    public boolean isCurrentPageCanBeAddToSourceTrace() {
                        return true;
                    }

                    @Override // com.baidu.live.tbadk.pagestayduration.PageStayDurationFilter
                    public int getMaxCost() {
                        return PageStayDurationStat.this.maxCost;
                    }
                };
            }
            if (pageStayDurationFilter.isSwitchOpen() && pageStayDurationFilter.canStat(pageStayDurationItem)) {
                StatisticItem statisticItem2 = new StatisticItem(PageStayDurationConstants.URL_KEY);
                statisticItem2.param("obj_source", PageStayDurationHelper.toSourceTraceString(pageStayDurationItem.getSorceKeyList()));
                statisticItem2.param("obj_type", pageStayDurationItem.getCurrentPageKey());
                statisticItem2.param("obj_duration", String.valueOf(pageStayDurationItem.getStayDurationTime()));
                if (pageStayDurationItem.getFid() > 0) {
                    statisticItem2.param("fid", String.valueOf(pageStayDurationItem.getFid()));
                }
                if (pageStayDurationItem.getTid() > 0) {
                    statisticItem2.param("tid", String.valueOf(pageStayDurationItem.getTid()));
                }
                if (pageStayDurationItem.getPid() > 0) {
                    statisticItem2.param("pid", String.valueOf(pageStayDurationItem.getPid()));
                }
                if (!StringUtils.isNull(pageStayDurationItem.objParam1)) {
                    statisticItem2.param("obj_param1", pageStayDurationItem.objParam1);
                }
                if (!StringUtils.isNull(pageStayDurationItem.isVertical)) {
                    statisticItem2.param("is_vertical", pageStayDurationItem.isVertical);
                }
                TiebaInitialize.log(statisticItem2);
            }
        }
    }

    public boolean isSmallFlowOpen() {
        return this.isSmallFlowOpen;
    }

    public void setSamllFlowOpen(boolean z) {
        this.isSmallFlowOpen = z;
    }

    public int getMaxCostFromServer() {
        return !TbadkCoreApplication.getInst().isMainProcess(true) ? SharedPrefHelper.getInstance().getInt(SharedPrefConfig.PAGE_STY_MAX_COST, 0) : this.maxCost;
    }

    public void setMaxCostFromServer(int i) {
        this.maxCost = i;
        SharedPrefHelper.getInstance().putInt(SharedPrefConfig.PAGE_STY_MAX_COST, this.maxCost);
    }
}
