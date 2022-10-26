package com.baidu.sapi2;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.sapi2.dto.loginhistory.AccountLoginAction;
import com.baidu.sapi2.dto.loginhistory.LoginHistoryItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class LoginHistoryLoginModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long SECONDS_OF_ONE_DAY = 86400;
    public transient /* synthetic */ FieldHolder $fh;

    public LoginHistoryLoginModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void updateLoginHistoryInfo() {
        SapiAccount currentAccount;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) && (currentAccount = SapiContext.getInstance().getCurrentAccount()) != null) {
            updateLoginHistoryInfo(currentAccount);
        }
    }

    public static void delBdussLoginHistoryInfo(String str) {
        List loadHistoryAccounts;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, str) != null) || TextUtils.isEmpty(str) || (loadHistoryAccounts = loadHistoryAccounts()) == null) {
            return;
        }
        Iterator it = loadHistoryAccounts.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(str, SecurityUtil.md5(((AccountLoginAction) it.next()).sapiAccount.bduss.getBytes(), false))) {
                it.remove();
            }
        }
        SapiContext.getInstance().setLoginHistoryUserInfo(AccountLoginAction.convertActionList2Json(loadHistoryAccounts));
    }

    public static List getAvailableLoginHistoryItems() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            List loadHistoryAccounts = loadHistoryAccounts();
            if (loadHistoryAccounts != null && loadHistoryAccounts.size() != 0) {
                ArrayList arrayList = new ArrayList();
                int size = loadHistoryAccounts.size();
                for (int i = 0; i < size; i++) {
                    AccountLoginAction accountLoginAction = (AccountLoginAction) loadHistoryAccounts.get(i);
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
        return (List) invokeV.objValue;
    }

    public static List loadHistoryAccounts() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
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
        return (List) invokeV.objValue;
    }

    public static void updateLoginHistoryInfo(SapiAccount sapiAccount) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, sapiAccount) == null) {
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
}
