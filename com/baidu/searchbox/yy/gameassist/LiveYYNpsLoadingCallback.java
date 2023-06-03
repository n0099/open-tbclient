package com.baidu.searchbox.yy.gameassist;

import com.baidu.down.request.task.ProgressInfo;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/yy/gameassist/LiveYYNpsLoadingCallback;", "Lkotlin/Any;", "", "retCode", "", "onLoadingEnd", "(I)V", "", ProgressInfo.JSON_KEY_CURRENT, "total", "onLoadingProgress", "(JJ)V", "onLoadingStart", "()V", "lib-gameassist-host_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public interface LiveYYNpsLoadingCallback {
    void onLoadingEnd(int i);

    void onLoadingProgress(long j, long j2);

    void onLoadingStart();
}
