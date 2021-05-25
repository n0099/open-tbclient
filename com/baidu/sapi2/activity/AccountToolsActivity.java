package com.baidu.sapi2.activity;

import android.app.Activity;
import android.os.Bundle;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.callback.AccountCenterCallback;
import com.baidu.sapi2.callback.AccountToolsCallback;
import com.baidu.sapi2.dto.AccountCenterDTO;
import com.baidu.sapi2.result.AccountCenterResult;
import com.baidu.sapi2.result.AccountToolsResult;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.SapiHost;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class AccountToolsActivity extends Activity {
    public static final String EXTRA_ACCOUNT_TOOLS_TYPE = "ACCOUNT_TOOLS_TYPE";
    public static final String EXTRA_SWEEP_LIGHT_LOADING = "sweepLightLoading";

    /* renamed from: a  reason: collision with root package name */
    public AccountToolsResult f9528a = new AccountToolsResult();

    /* renamed from: b  reason: collision with root package name */
    public AccountToolsCallback f9529b;

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra(EXTRA_ACCOUNT_TOOLS_TYPE, -1);
        this.f9529b = CoreViewRouter.getInstance().getAccountToolsCallback();
        AccountCenterDTO accountCenterDTO = new AccountCenterDTO();
        accountCenterDTO.accountToolsUrl = a(intExtra);
        accountCenterDTO.sweepLightLoading = getIntent().getBooleanExtra(EXTRA_SWEEP_LIGHT_LOADING, false);
        CoreViewRouter.getInstance().loadAccountCenter(new AccountCenterCallback() { // from class: com.baidu.sapi2.activity.AccountToolsActivity.1
            @Override // com.baidu.sapi2.callback.AccountCenterCallback
            public void onFinish(AccountCenterResult accountCenterResult) {
                AccountToolsActivity.this.f9528a.setResultCode(accountCenterResult.getResultCode());
                AccountToolsActivity.this.f9528a.setResultMsg(accountCenterResult.getResultMsg());
                AccountToolsActivity.this.a();
            }

            @Override // com.baidu.sapi2.callback.AccountCenterCallback
            public void onSocialBind(String str) {
            }
        }, accountCenterDTO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.f9529b.onFinish(this.f9528a);
        finish();
    }

    private String a(int i2) {
        String str;
        HashMap hashMap = new HashMap();
        if (i2 == 1) {
            str = "/wp/v3/ucenter/accountfreezeapply";
        } else if (i2 == 2) {
            str = "/wp/v3/ucenter/findaccback";
        } else if (i2 == 3) {
            str = "/wp/v3/ucenter/accountcancelpage";
        } else if (i2 == 4) {
            str = "/v4/appeal/";
        } else if (i2 == 5) {
            hashMap.put("u", SapiHost.getHost(SapiHost.DOMAIN_BAIDU_HTTPS_URL) + "?__wp-action=modify-pwd");
            hashMap.put("banner", "1");
            str = "/wp/wappassword";
        } else {
            throw new RuntimeException("account tools type is not support");
        }
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        String str2 = sapiConfiguration.environment.getWap() + str + "?" + ParamsUtil.buildH5CommonParams(sapiConfiguration);
        return !hashMap.isEmpty() ? ParamsUtil.addExtras(str2, hashMap) : str2;
    }
}
