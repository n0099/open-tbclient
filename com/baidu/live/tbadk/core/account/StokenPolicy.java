package com.baidu.live.tbadk.core.account;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.result.GetTplStokenResult;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes4.dex */
public class StokenPolicy {

    /* loaded from: classes4.dex */
    public interface IStokenCallback {
        void onFailed();

        void onSuccess(String str);
    }

    public static boolean isVerification() {
        return false;
    }

    public static String getVerificatedStoken(AccountData accountData) {
        if (accountData != null && isVerification()) {
            return accountData.getStoken();
        }
        return null;
    }

    public static void cancelRequestStoken() {
        if (isVerification()) {
            SapiAccountManager.getInstance().getAccountService().cancelRequest();
        }
    }

    public void startRequstStoken(String str, final IStokenCallback iStokenCallback) {
        if (!StringUtils.isNull(str)) {
            LinkedList linkedList = new LinkedList();
            linkedList.add("tb");
            SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() { // from class: com.baidu.live.tbadk.core.account.StokenPolicy.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onSuccess(GetTplStokenResult getTplStokenResult) {
                    if (getTplStokenResult == null) {
                        if (iStokenCallback != null) {
                            iStokenCallback.onFailed();
                            return;
                        }
                        return;
                    }
                    Map<String, String> map = getTplStokenResult.tplStokenMap;
                    if (map == null || map.size() <= 0) {
                        if (iStokenCallback != null) {
                            iStokenCallback.onFailed();
                            return;
                        }
                        return;
                    }
                    String str2 = map.get("tb");
                    if (StringUtils.isNullObject(str2)) {
                        if (iStokenCallback != null) {
                            iStokenCallback.onFailed();
                        }
                    } else if (iStokenCallback != null) {
                        iStokenCallback.onSuccess(str2);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFailure(GetTplStokenResult getTplStokenResult) {
                    if (iStokenCallback != null) {
                        iStokenCallback.onFailed();
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
