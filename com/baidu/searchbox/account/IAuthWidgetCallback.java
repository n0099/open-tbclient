package com.baidu.searchbox.account;

import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.account.result.BoxSapiResult;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/account/IAuthWidgetCallback;", "Lcom/baidu/searchbox/NoProGuard;", "onFailure", "", "result", "Lcom/baidu/searchbox/account/result/BoxSapiResult;", "onSuccess", "content", "", "lib-account-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IAuthWidgetCallback extends NoProGuard {
    void onFailure(BoxSapiResult boxSapiResult);

    void onSuccess(String str);
}
