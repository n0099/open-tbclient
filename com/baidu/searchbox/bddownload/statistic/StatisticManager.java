package com.baidu.searchbox.bddownload.statistic;

import androidx.transition.Transition;
import com.baidu.searchbox.bddownload.BdDownload;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0006R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/bddownload/statistic/StatisticManager;", "Lcom/baidu/searchbox/bddownload/statistic/IBDDownloadStatistic;", "Lcom/baidu/searchbox/bddownload/statistic/StatisticsInfo;", "info", "", "downloadFailedReport", "(Lcom/baidu/searchbox/bddownload/statistic/StatisticsInfo;)V", "downloadHijackReport", "downloadPauseReport", "downloadResumeReport", "downloadStartReport", "downloadSuccessReport", "mDownloadReport", "Lcom/baidu/searchbox/bddownload/statistic/IBDDownloadStatistic;", "<init>", "()V", "Companion", "lib-bddownload_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class StatisticManager implements IBDDownloadStatistic {
    public static final Companion Companion = new Companion(null);
    public static StatisticManager instance;
    public IBDDownloadStatistic mDownloadReport;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0004\u001a\u0004\u0018\u00010\u00018B@\u0002X\u0082\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0003\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/bddownload/statistic/StatisticManager$Companion;", "Lcom/baidu/searchbox/bddownload/statistic/StatisticManager;", CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, "()Lcom/baidu/searchbox/bddownload/statistic/StatisticManager;", Transition.MATCH_INSTANCE_STR, "Lcom/baidu/searchbox/bddownload/statistic/StatisticManager;", "getInstance", "setInstance", "(Lcom/baidu/searchbox/bddownload/statistic/StatisticManager;)V", "<init>", "()V", "lib-bddownload_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class Companion {
        public Companion() {
        }

        private final StatisticManager getInstance() {
            if (StatisticManager.instance == null) {
                StatisticManager.instance = new StatisticManager(null);
            }
            return StatisticManager.instance;
        }

        public final StatisticManager get() {
            StatisticManager companion = getInstance();
            Intrinsics.checkNotNull(companion);
            return companion;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void setInstance(StatisticManager statisticManager) {
            StatisticManager.instance = statisticManager;
        }
    }

    public StatisticManager() {
        BdDownload with = BdDownload.with();
        Intrinsics.checkNotNullExpressionValue(with, "BdDownload.with()");
        this.mDownloadReport = with.getStatistic();
    }

    public /* synthetic */ StatisticManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.baidu.searchbox.bddownload.statistic.IBDDownloadStatistic
    public void downloadFailedReport(StatisticsInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        IBDDownloadStatistic iBDDownloadStatistic = this.mDownloadReport;
        if (iBDDownloadStatistic != null) {
            iBDDownloadStatistic.downloadFailedReport(info);
        }
    }

    @Override // com.baidu.searchbox.bddownload.statistic.IBDDownloadStatistic
    public void downloadHijackReport(StatisticsInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        IBDDownloadStatistic iBDDownloadStatistic = this.mDownloadReport;
        if (iBDDownloadStatistic != null) {
            iBDDownloadStatistic.downloadHijackReport(info);
        }
    }

    @Override // com.baidu.searchbox.bddownload.statistic.IBDDownloadStatistic
    public void downloadPauseReport(StatisticsInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        IBDDownloadStatistic iBDDownloadStatistic = this.mDownloadReport;
        if (iBDDownloadStatistic != null) {
            iBDDownloadStatistic.downloadPauseReport(info);
        }
    }

    @Override // com.baidu.searchbox.bddownload.statistic.IBDDownloadStatistic
    public void downloadResumeReport(StatisticsInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        IBDDownloadStatistic iBDDownloadStatistic = this.mDownloadReport;
        if (iBDDownloadStatistic != null) {
            iBDDownloadStatistic.downloadResumeReport(info);
        }
    }

    @Override // com.baidu.searchbox.bddownload.statistic.IBDDownloadStatistic
    public void downloadStartReport(StatisticsInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        IBDDownloadStatistic iBDDownloadStatistic = this.mDownloadReport;
        if (iBDDownloadStatistic != null) {
            iBDDownloadStatistic.downloadStartReport(info);
        }
    }

    @Override // com.baidu.searchbox.bddownload.statistic.IBDDownloadStatistic
    public void downloadSuccessReport(StatisticsInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        IBDDownloadStatistic iBDDownloadStatistic = this.mDownloadReport;
        if (iBDDownloadStatistic != null) {
            iBDDownloadStatistic.downloadSuccessReport(info);
        }
    }
}
