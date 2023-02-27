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
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class AccountToolsActivity extends Activity {
    public static final String EXTRA_ACCOUNT_TOOLS_TYPE = "ACCOUNT_TOOLS_TYPE";
    public static final String EXTRA_SWEEP_LIGHT_LOADING = "sweepLightLoading";
    public AccountToolsResult a = new AccountToolsResult();
    public AccountToolsCallback b;

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        AccountToolsCallback accountToolsCallback = this.b;
        if (accountToolsCallback != null) {
            accountToolsCallback.onFinish(this.a);
        }
        finish();
    }

    private String a(int i) {
        String str;
        HashMap hashMap = new HashMap();
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i == 5) {
                            hashMap.put("u", SapiHost.getHost(SapiHost.DOMAIN_BAIDU_HTTPS_URL) + "?__wp-action=modify-pwd");
                            hashMap.put(SpeedStatsUtils.UBC_VALUE_BANNER, "1");
                            str = "/wp/wappassword";
                        } else {
                            throw new RuntimeException("account tools type is not support");
                        }
                    } else {
                        str = "/v4/appeal/";
                    }
                } else {
                    str = "/wp/v3/ucenter/accountcancelpage";
                }
            } else {
                str = "/wp/v3/ucenter/findaccback";
            }
        } else {
            str = "/wp/v3/ucenter/accountfreezeapply";
        }
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        String str2 = sapiConfiguration.environment.getWap() + str + "?" + ParamsUtil.buildH5CommonParams(sapiConfiguration);
        if (!hashMap.isEmpty()) {
            return ParamsUtil.addExtras(str2, hashMap);
        }
        return str2;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra(EXTRA_ACCOUNT_TOOLS_TYPE, -1);
        this.b = CoreViewRouter.getInstance().getAccountToolsCallback();
        AccountCenterDTO accountCenterDTO = new AccountCenterDTO();
        accountCenterDTO.accountToolsUrl = a(intExtra);
        accountCenterDTO.isFromAccountTools = true;
        accountCenterDTO.sweepLightLoading = getIntent().getBooleanExtra(EXTRA_SWEEP_LIGHT_LOADING, false);
        CoreViewRouter.getInstance().loadAccountCenter(new AccountCenterCallback() { // from class: com.baidu.sapi2.activity.AccountToolsActivity.1
            @Override // com.baidu.sapi2.callback.AccountCenterCallback
            public void onSocialBind(String str) {
            }

            @Override // com.baidu.sapi2.callback.AccountCenterCallback
            public void onFinish(AccountCenterResult accountCenterResult) {
                AccountToolsActivity.this.a.setResultCode(accountCenterResult.getResultCode());
                AccountToolsActivity.this.a.setResultMsg(accountCenterResult.getResultMsg());
                AccountToolsActivity.this.a();
            }
        }, accountCenterDTO);
    }
}
