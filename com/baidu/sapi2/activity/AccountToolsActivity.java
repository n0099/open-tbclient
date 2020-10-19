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
import com.baidu.sapi2.utils.f;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class AccountToolsActivity extends Activity {
    public static final String EXTRA_ACCOUNT_TOOLS_TYPE = "ACCOUNT_TOOLS_TYPE";

    /* renamed from: a  reason: collision with root package name */
    private AccountToolsResult f3311a = new AccountToolsResult();
    private AccountToolsCallback b;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra(EXTRA_ACCOUNT_TOOLS_TYPE, -1);
        this.b = CoreViewRouter.getInstance().getAccountToolsCallback();
        AccountCenterDTO accountCenterDTO = new AccountCenterDTO();
        accountCenterDTO.accountToolsUrl = a(intExtra);
        CoreViewRouter.getInstance().loadAccountCenter(new AccountCenterCallback() { // from class: com.baidu.sapi2.activity.AccountToolsActivity.1
            @Override // com.baidu.sapi2.callback.AccountCenterCallback
            public void onFinish(AccountCenterResult accountCenterResult) {
                AccountToolsActivity.this.f3311a.setResultCode(accountCenterResult.getResultCode());
                AccountToolsActivity.this.f3311a.setResultMsg(accountCenterResult.getResultMsg());
                AccountToolsActivity.this.a();
            }

            @Override // com.baidu.sapi2.callback.AccountCenterCallback
            public void onSocialBind(String str) {
            }
        }, accountCenterDTO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.b.onFinish(this.f3311a);
        finish();
    }

    private String a(int i) {
        String str;
        HashMap hashMap = new HashMap();
        switch (i) {
            case 1:
                str = "/wp/v3/ucenter/accountfreezeapply";
                break;
            case 2:
                str = "/wp/v3/ucenter/findaccback";
                break;
            case 3:
                str = "/wp/v3/ucenter/accountcancelpage";
                break;
            case 4:
                str = "/v4/appeal/";
                break;
            case 5:
                str = "/wp/wappassword";
                hashMap.put("u", f.a(f.l) + "?__wp-action=modify-pwd");
                hashMap.put("banner", "1");
                break;
            default:
                throw new RuntimeException("account tools type is not support");
        }
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        String str2 = sapiConfiguration.environment.getWap() + str + "?" + ParamsUtil.buildH5CommonParams(sapiConfiguration);
        return !hashMap.isEmpty() ? ParamsUtil.addExtras(str2, hashMap) : str2;
    }
}
