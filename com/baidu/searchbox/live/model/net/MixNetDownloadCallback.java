package com.baidu.searchbox.live.model.net;

import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J3\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u000f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/live/model/net/MixNetDownloadCallback;", "Lkotlin/Any;", "", "key", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, StatConstants.KEY_EXT_ERR_CODE, "", "exception", "", "onFileDownloaded", "(Ljava/lang/Object;IILjava/lang/String;)V", "", "downloadLength", "totalLength", "onFileUpdateProgress", "(Ljava/lang/Object;JJ)V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface MixNetDownloadCallback {
    void onFileDownloaded(Object obj, int i, int i2, String str);

    void onFileUpdateProgress(Object obj, long j, long j2);
}
