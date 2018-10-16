package com.baidu.searchbox.ng.ai.apps.setting.actions;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PrivateGetUserInfoAction extends AiAppAction {
    private static final String ACCOUNT_BDUSS = "bduss";
    private static final String ACCOUNT_NICKNAME = "displayname";
    private static final String ACCOUNT_UID = "uid";
    private static final String ACTION_TYPE = "/swan/privateGetUserInfo";
    private static final int ERROR_NOLOGIN = 10003;
    public static final String KEY_AGE = "key_age";
    public static final String KEY_CITY = "key_city";
    public static final String KEY_GENDER = "key_gender";
    public static final String KEY_HOROSCOPE = "key_horoscope";
    public static final String KEY_LEVEL = "key_level";
    public static final String KEY_PROVINCE = "key_province";
    public static final String KEY_SIGNATURE = "key_signature";
    public static final String KEY_UID = "key_uid";
    public static final String KEY_VIP = "key_vip";

    public PrivateGetUserInfoAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        if (aiApp == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty aiApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            return false;
        }
        String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            return false;
        }
        handleWithIpc(context, callbackHandler, aiApp, optString);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    private void handleWithIpc(Context context, CallbackHandler callbackHandler, AiApp aiApp, String str) {
        HashSet hashSet = new HashSet();
        hashSet.add("uid");
        hashSet.add("bduss");
        hashSet.add("displayname");
        Map<String, String> sessions = aiApp.getAccount().getSessions(context, hashSet);
        String str2 = sessions.get("uid");
        if (TextUtils.isEmpty(sessions.get("bduss")) || TextUtils.isEmpty(str2)) {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(10003).toString());
            return;
        }
        Bundle userInfo = aiApp.getAccount().getUserInfo(context, str2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("displayname", sessions.get("displayname"));
            jSONObject.put(IntentConfig.PORTRAIT, AiAppsRuntime.getAiAppAccountRuntime().getPortraitUrl());
            if (userInfo.containsKey(KEY_GENDER)) {
                jSONObject.put("gender", String.valueOf(userInfo.getInt(KEY_GENDER)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
    }
}
