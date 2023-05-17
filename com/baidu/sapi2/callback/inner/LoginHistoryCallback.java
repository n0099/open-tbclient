package com.baidu.sapi2.callback.inner;

import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.common.LoginHistoryModel;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public abstract class LoginHistoryCallback implements NoProguard {
    public void onFailure() {
    }

    public void onLoginFailure() {
    }

    public void onLoginSuccess(SapiAccount sapiAccount) {
    }

    public void onResult(JSONArray jSONArray) {
    }

    public void onSuccess(List<LoginHistoryModel> list) {
    }
}
