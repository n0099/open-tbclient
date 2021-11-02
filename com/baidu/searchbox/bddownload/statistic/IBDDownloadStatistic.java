package com.baidu.searchbox.bddownload.statistic;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/bddownload/statistic/IBDDownloadStatistic;", "Lkotlin/Any;", "Lcom/baidu/searchbox/bddownload/statistic/StatisticsInfo;", "info", "", "downloadFailedReport", "(Lcom/baidu/searchbox/bddownload/statistic/StatisticsInfo;)V", "downloadHijackReport", "downloadPauseReport", "downloadResumeReport", "downloadStartReport", "downloadSuccessReport", "lib-bddownload_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public interface IBDDownloadStatistic {
    void downloadFailedReport(StatisticsInfo statisticsInfo);

    void downloadHijackReport(StatisticsInfo statisticsInfo);

    void downloadPauseReport(StatisticsInfo statisticsInfo);

    void downloadResumeReport(StatisticsInfo statisticsInfo);

    void downloadStartReport(StatisticsInfo statisticsInfo);

    void downloadSuccessReport(StatisticsInfo statisticsInfo);
}
