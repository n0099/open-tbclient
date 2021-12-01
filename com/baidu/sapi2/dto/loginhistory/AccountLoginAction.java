package com.baidu.sapi2.dto.loginhistory;

import androidx.core.view.InputDeviceCompat;
import com.baidu.sapi2.SapiAccount;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class AccountLoginAction {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long loginTimeSecond;
    public SapiAccount sapiAccount;

    public AccountLoginAction() {
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

    public static JSONObject convertAction2Json(AccountLoginAction accountLoginAction) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, accountLoginAction)) == null) {
            if (accountLoginAction == null) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("loginTimeSecond", accountLoginAction.loginTimeSecond);
                jSONObject.put("sapiAccount", accountLoginAction.sapiAccount.toJSONObject());
                return jSONObject;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static String convertActionList2Json(List<AccountLoginAction> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            if (list == null || list.size() == 0) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < list.size(); i2++) {
                JSONObject convertAction2Json = convertAction2Json(list.get(i2));
                if (convertAction2Json != null) {
                    jSONArray.put(convertAction2Json);
                }
            }
            return jSONArray.toString();
        }
        return (String) invokeL.objValue;
    }

    public static AccountLoginAction convertJson2Action(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            long optLong = jSONObject.optLong("loginTimeSecond");
            SapiAccount fromJSONObject = SapiAccount.fromJSONObject(jSONObject.optJSONObject("sapiAccount"));
            if (fromJSONObject != null) {
                return new AccountLoginAction(optLong, fromJSONObject);
            }
            return null;
        }
        return (AccountLoginAction) invokeL.objValue;
    }

    public static List<AccountLoginAction> convertJson2ActionList(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, jSONArray)) == null) {
            if (jSONArray != null && jSONArray.length() != 0) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    AccountLoginAction accountLoginAction = null;
                    try {
                        accountLoginAction = convertJson2Action(jSONArray.getJSONObject(i2));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    if (accountLoginAction != null) {
                        arrayList.add(accountLoginAction);
                    }
                }
                return arrayList;
            }
            return new ArrayList();
        }
        return (List) invokeL.objValue;
    }

    public AccountLoginAction(long j2, SapiAccount sapiAccount) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), sapiAccount};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.loginTimeSecond = j2;
        this.sapiAccount = sapiAccount;
    }
}
