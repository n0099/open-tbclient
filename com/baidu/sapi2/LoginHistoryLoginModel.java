package com.baidu.sapi2;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.face.platform.utils.MD5Utils;
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
/* loaded from: classes4.dex */
public class LoginHistoryLoginModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long SECONDS_OF_ONE_DAY = 86400;
    public transient /* synthetic */ FieldHolder $fh;

    public LoginHistoryLoginModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void delBdussLoginHistoryInfo(String str) {
        List<AccountLoginAction> loadHistoryAccounts;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, str) == null) || TextUtils.isEmpty(str) || (loadHistoryAccounts = loadHistoryAccounts()) == null) {
            return;
        }
        Iterator<AccountLoginAction> it = loadHistoryAccounts.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(str, MD5Utils.encryption(it.next().sapiAccount.bduss.getBytes()))) {
                it.remove();
            }
        }
        SapiContext.getInstance().setLoginHistoryUserInfo(AccountLoginAction.convertActionList2Json(loadHistoryAccounts));
    }

    public static List<LoginHistoryItem> getAvailableLoginHistoryItems() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            List<AccountLoginAction> loadHistoryAccounts = loadHistoryAccounts();
            if (loadHistoryAccounts == null || loadHistoryAccounts.size() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = loadHistoryAccounts.size();
            for (int i2 = 0; i2 < size; i2++) {
                AccountLoginAction accountLoginAction = loadHistoryAccounts.get(i2);
                int i3 = 0;
                while (true) {
                    if (i3 >= arrayList.size()) {
                        z = false;
                        break;
                    }
                    LoginHistoryItem loginHistoryItem = (LoginHistoryItem) arrayList.get(i3);
                    if (TextUtils.equals(loginHistoryItem.bduss, accountLoginAction.sapiAccount.bduss)) {
                        loginHistoryItem.actionTimes.add(String.valueOf(accountLoginAction.loginTimeSecond));
                        z = true;
                        break;
                    }
                    i3++;
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
        return (List) invokeV.objValue;
    }

    public static List<AccountLoginAction> loadHistoryAccounts() {
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
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return AccountLoginAction.convertJson2ActionList(jSONArray);
        }
        return (List) invokeV.objValue;
    }

    public static void updateLoginHistoryInfo() {
        SapiAccount currentAccount;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) || (currentAccount = SapiContext.getInstance().getCurrentAccount()) == null) {
            return;
        }
        updateLoginHistoryInfo(currentAccount);
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
            long j2 = currentTimeMillis / 86400;
            int i2 = -1;
            int i3 = 0;
            while (true) {
                if (i3 >= loadHistoryAccounts.size()) {
                    break;
                }
                AccountLoginAction accountLoginAction = (AccountLoginAction) loadHistoryAccounts.get(i3);
                long j3 = accountLoginAction.loginTimeSecond;
                if (currentTimeMillis - j3 > 5) {
                    long j4 = j3 / 86400;
                    if (TextUtils.equals(sapiAccount.bduss, accountLoginAction.sapiAccount.bduss) && j2 == j4) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                } else {
                    z = true;
                    break;
                }
            }
            z = false;
            if (z) {
                return;
            }
            if (i2 >= 0) {
                loadHistoryAccounts.remove(i2);
            }
            loadHistoryAccounts.add(0, new AccountLoginAction(currentTimeMillis, sapiAccount));
            if (loadHistoryAccounts.size() > 30) {
                loadHistoryAccounts.remove(loadHistoryAccounts.size() - 1);
            }
            SapiContext.getInstance().setLoginHistoryUserInfo(AccountLoginAction.convertActionList2Json(loadHistoryAccounts));
        }
    }
}
