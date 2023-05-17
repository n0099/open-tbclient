package com.baidu.searchbox.account;

import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.account.data.BoxAccount;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public interface IAccountQueryListener extends NoProGuard {
    void onFailed(BoxAccount.ErrorBean errorBean);

    void onSuccess(JSONObject jSONObject);
}
