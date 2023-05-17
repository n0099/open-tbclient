package com.baidu.searchbox.live.interfaces.yy.plugin;

import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginInstallCallback;", "Lkotlin/Any;", "", "packageName", "", "code", StatConstants.KEY_EXT_ERR_MSG, "", "onError", "(Ljava/lang/String;ILjava/lang/String;)V", "Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginBundleInfo;", "bundleInfo", "onLoaded", "(Lcom/baidu/searchbox/live/interfaces/yy/plugin/YYPluginBundleInfo;)V", "", "downloadedSize", CommonTbJsBridge.FILE_DOWNLOAD_TOTAL_SIZE, "onProgress", "(Ljava/lang/String;JJ)V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public interface YYPluginInstallCallback {
    void onError(String str, int i, String str2);

    void onLoaded(YYPluginBundleInfo yYPluginBundleInfo);

    void onProgress(String str, long j, long j2);
}
