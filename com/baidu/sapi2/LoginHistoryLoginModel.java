package com.baidu.sapi2;

import android.text.TextUtils;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.sapi2.dto.loginhistory.AccountLoginAction;
import com.baidu.sapi2.dto.loginhistory.LoginHistoryItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class LoginHistoryLoginModel {
    public static final long SECONDS_OF_ONE_DAY = 86400;

    public static List<AccountLoginAction> loadHistoryAccounts() {
        String loginHistoryUserInfoJson = SapiContext.getInstance().getLoginHistoryUserInfoJson();
        JSONArray jSONArray = null;
        if (TextUtils.isEmpty(loginHistoryUserInfoJson)) {
            return null;
        }
        try {
            jSONArray = new JSONArray(loginHistoryUserInfoJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AccountLoginAction.convertJson2ActionList(jSONArray);
    }

    public static void updateLoginHistoryInfo() {
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (currentAccount != null) {
            updateLoginHistoryInfo(currentAccount);
        }
    }

    public static void delBdussLoginHistoryInfo(String str) {
        List<AccountLoginAction> loadHistoryAccounts;
        if (TextUtils.isEmpty(str) || (loadHistoryAccounts = loadHistoryAccounts()) == null) {
            return;
        }
        Iterator<AccountLoginAction> it = loadHistoryAccounts.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(str, SecurityUtil.md5(it.next().sapiAccount.bduss.getBytes(), false))) {
                it.remove();
            }
        }
        SapiContext.getInstance().setLoginHistoryUserInfo(AccountLoginAction.convertActionList2Json(loadHistoryAccounts));
    }

    public static List<LoginHistoryItem> getAvailableLoginHistoryItems() {
        boolean z;
        List<AccountLoginAction> loadHistoryAccounts = loadHistoryAccounts();
        if (loadHistoryAccounts != null && loadHistoryAccounts.size() != 0) {
            ArrayList arrayList = new ArrayList();
            int size = loadHistoryAccounts.size();
            for (int i = 0; i < size; i++) {
                AccountLoginAction accountLoginAction = loadHistoryAccounts.get(i);
                int i2 = 0;
                while (true) {
                    if (i2 < arrayList.size()) {
                        LoginHistoryItem loginHistoryItem = (LoginHistoryItem) arrayList.get(i2);
                        if (TextUtils.equals(loginHistoryItem.bduss, accountLoginAction.sapiAccount.bduss)) {
                            loginHistoryItem.actionTimes.add(String.valueOf(accountLoginAction.loginTimeSecond));
                            z = true;
                            break;
                        }
                        i2++;
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    LoginHistoryItem loginHistoryItem2 = new LoginHistoryItem();
                    loginHistoryItem2.bduss = accountLoginAction.sapiAccount.bduss;
                    loginHistoryItem2.actionTimes.add(String.valueOf(accountLoginAction.loginTimeSecond));
                    arrayList.add(loginHistoryItem2);
                }
            }
            return arrayList;
        }
        return null;
    }

    public static void updateLoginHistoryInfo(SapiAccount sapiAccount) {
        boolean z;
        List loadHistoryAccounts = loadHistoryAccounts();
        if (loadHistoryAccounts == null) {
            loadHistoryAccounts = new ArrayList();
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long j = currentTimeMillis / 86400;
        int i = -1;
        int i2 = 0;
        while (true) {
            if (i2 >= loadHistoryAccounts.size()) {
                break;
            }
            AccountLoginAction accountLoginAction = (AccountLoginAction) loadHistoryAccounts.get(i2);
            long j2 = accountLoginAction.loginTimeSecond;
            if (currentTimeMillis - j2 <= 5) {
                z = true;
                break;
            }
            long j3 = j2 / 86400;
            if (TextUtils.equals(sapiAccount.bduss, accountLoginAction.sapiAccount.bduss) && j == j3) {
                i = i2;
                break;
            }
            i2++;
        }
        z = false;
        if (z) {
            return;
        }
        if (i >= 0) {
            loadHistoryAccounts.remove(i);
        }
        loadHistoryAccounts.add(0, new AccountLoginAction(currentTimeMillis, sapiAccount));
        if (loadHistoryAccounts.size() > 30) {
            loadHistoryAccounts.remove(loadHistoryAccounts.size() - 1);
        }
        SapiContext.getInstance().setLoginHistoryUserInfo(AccountLoginAction.convertActionList2Json(loadHistoryAccounts));
    }
}
