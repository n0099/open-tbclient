package com.baidu.sapi2.dto.loginhistory;

import com.baidu.sapi2.SapiAccount;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AccountLoginAction {
    public long loginTimeSecond;
    public SapiAccount sapiAccount;

    public AccountLoginAction() {
    }

    public AccountLoginAction(long j, SapiAccount sapiAccount) {
        this.loginTimeSecond = j;
        this.sapiAccount = sapiAccount;
    }

    public static JSONObject convertAction2Json(AccountLoginAction accountLoginAction) {
        if (accountLoginAction == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("loginTimeSecond", accountLoginAction.loginTimeSecond);
            jSONObject.put("sapiAccount", accountLoginAction.sapiAccount.toJSONObject());
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String convertActionList2Json(List<AccountLoginAction> list) {
        if (list != null && list.size() != 0) {
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < list.size(); i++) {
                JSONObject convertAction2Json = convertAction2Json(list.get(i));
                if (convertAction2Json != null) {
                    jSONArray.put(convertAction2Json);
                }
            }
            return jSONArray.toString();
        }
        return "";
    }

    public static AccountLoginAction convertJson2Action(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        long optLong = jSONObject.optLong("loginTimeSecond");
        SapiAccount fromJSONObject = SapiAccount.fromJSONObject(jSONObject.optJSONObject("sapiAccount"));
        if (fromJSONObject == null) {
            return null;
        }
        return new AccountLoginAction(optLong, fromJSONObject);
    }

    public static List<AccountLoginAction> convertJson2ActionList(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                AccountLoginAction accountLoginAction = null;
                try {
                    accountLoginAction = convertJson2Action(jSONArray.getJSONObject(i));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (accountLoginAction != null) {
                    arrayList.add(accountLoginAction);
                }
            }
            return arrayList;
        }
        return new ArrayList();
    }
}
