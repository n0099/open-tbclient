package com.baidu.tbadk.core.a;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.switchs.StokenEnableSwitch;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes2.dex */
public class d {

    /* loaded from: classes2.dex */
    public interface a {
        void onFailed();

        void onSuccess(String str);
    }

    public static boolean isVerification() {
        return SwitchManager.getInstance().findType(StokenEnableSwitch.KEY) == 1;
    }

    public static String c(AccountData accountData) {
        if (accountData != null && isVerification()) {
            return accountData.getStoken();
        }
        return null;
    }

    public void a(String str, final a aVar) {
        if (!StringUtils.isNull(str)) {
            LinkedList linkedList = new LinkedList();
            linkedList.add("tb");
            if (SapiAccountManager.getInstance().getAccountService() != null) {
                SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() { // from class: com.baidu.tbadk.core.a.d.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onSuccess(GetTplStokenResult getTplStokenResult) {
                        if (getTplStokenResult == null) {
                            if (aVar != null) {
                                aVar.onFailed();
                                return;
                            }
                            return;
                        }
                        Map<String, String> map = getTplStokenResult.tplStokenMap;
                        if (map == null || map.size() <= 0) {
                            if (aVar != null) {
                                aVar.onFailed();
                                return;
                            }
                            return;
                        }
                        String str2 = map.get("tb");
                        if (StringUtils.isNULL(str2)) {
                            if (aVar != null) {
                                aVar.onFailed();
                            }
                        } else if (aVar != null) {
                            aVar.onSuccess(str2);
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFailure(GetTplStokenResult getTplStokenResult) {
                        if (aVar != null) {
                            aVar.onFailed();
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                    }
                }, str, linkedList);
            }
        }
    }
}
