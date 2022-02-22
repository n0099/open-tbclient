package com.baidu.searchbox.download.center.clearcache;

import com.baidu.searchbox.download.center.clearcache.DiskManager;
import com.baidu.webkit.sdk.WebChromeClient;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J)\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/BDDiskUsageLevelChangedCallback;", "Lkotlin/Any;", "Lcom/baidu/searchbox/download/center/clearcache/DiskManager$DiskLevel;", "oldState", "newState", "Lcom/baidu/searchbox/download/center/clearcache/NotifyCompletionBack;", WebChromeClient.KEY_ARG_CALLBACK, "", "onChange", "(Lcom/baidu/searchbox/download/center/clearcache/DiskManager$DiskLevel;Lcom/baidu/searchbox/download/center/clearcache/DiskManager$DiskLevel;Lcom/baidu/searchbox/download/center/clearcache/NotifyCompletionBack;)V", "lib-clearcache-base_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes11.dex */
public interface BDDiskUsageLevelChangedCallback {
    void onChange(DiskManager.DiskLevel diskLevel, DiskManager.DiskLevel diskLevel2, NotifyCompletionBack notifyCompletionBack);
}
