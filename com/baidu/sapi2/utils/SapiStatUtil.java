package com.baidu.sapi2.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.utils.enums.SocialType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class SapiStatUtil {
    public static final String LOGIN_STATUS_BDUSS_INVALIDATE = "2";
    public static final String LOGIN_STATUS_BDUSS_VALIDATE = "0";
    public static final String LOGIN_STATUS_NO_LOGIN = "1";
    public static final String LOGIN_STATUS_UNKNOWN = "3";

    public static void statShareV1Login(Context context, SapiAccount sapiAccount) {
        if (ShareCallPacking.LOGIN_TYPE_SHARE_V1_CHOICE.equals(SapiContext.getInstance(context).getAccountActionType())) {
            SapiContext.getInstance(context).put(SapiContext.KEY_PRE_LOGIN_TYPE, ShareCallPacking.LOGIN_TYPE_SHARE_V1_CHOICE);
            HashMap hashMap = new HashMap();
            hashMap.put(ShareCallPacking.StatModel.KEY_ACCOUNT_TPL, sapiAccount.getShareAccountTpl());
            hashMap.put(ShareCallPacking.StatModel.KEY_ACCOUNT_APP, sapiAccount.app);
            hashMap.put("uid", sapiAccount.uid);
            StatService.onEvent("share_v1_account_suc", hashMap, false);
        }
    }

    public static void statLoadLogin() {
        StatService.onEvent("load_login", new HashMap(), false);
    }

    public static void statShareV1OpenPage(List<SapiAccount> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (SapiAccount sapiAccount : list) {
            if (!TextUtils.isEmpty(sapiAccount.getShareAccountTpl())) {
                arrayList.add(sapiAccount.getShareAccountTpl());
            }
            if (!TextUtils.isEmpty(sapiAccount.app)) {
                arrayList2.add(sapiAccount.app);
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("account_size", list.size() + "");
        hashMap.put("account_tpls", TextUtils.join(",", arrayList));
        hashMap.put("account_apps", TextUtils.join(",", arrayList2));
        StatService.onEvent("share_v1_account_open", hashMap, false);
    }

    public static void statShareV1AccountClick(int i, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("index", i + "");
        hashMap.put(ShareCallPacking.StatModel.KEY_ACCOUNT_TPL, str);
        hashMap.put(ShareCallPacking.StatModel.KEY_ACCOUNT_APP, str2);
        StatService.onEvent("share_v1_account_click", hashMap, false);
    }

    public static void statShareClickOther(String str) {
        HashMap hashMap = new HashMap();
        if (str.equals("v2")) {
            StatService.onEvent("share_v2_click_other", hashMap, false);
        } else if (str.equals("v1")) {
            StatService.onEvent("share_v1_click_other", hashMap, false);
        }
    }

    public static void statShareV2Invoke(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("login", str);
        StatService.onEvent("share_v2_invoke", hashMap, true);
    }

    public static void statShareV2NoLogin(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("login", str);
        StatService.onEvent("share_v2_no_login", hashMap, true);
    }

    public static void statShareV2ActiveLoginSuc() {
        StatService.onEvent("share_v2_active_login_suc", new HashMap(), true);
    }

    public static void statShareV2Oauth() {
        StatService.onEvent("share_v2_oauth", new HashMap(), true);
    }

    public static void statShareV2OauthSuc(Context context) {
        StatService.onEvent("share_v2_oauth_suc", new HashMap(), true);
    }

    public static void statShareV2OtherFail(Context context, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("error_code", i + "");
        StatService.onEvent("share_v2_oauth_fail", hashMap, true);
    }

    public static void statThirdLoginEnter(SocialType socialType) {
        HashMap hashMap = new HashMap();
        hashMap.put("clientip", SapiUtils.getLocalIpAddress());
        hashMap.put("client", HttpConstants.OS_TYPE_VALUE);
        hashMap.put("social_type", socialType.getType() + "");
        if (SocialType.SINA_WEIBO_SSO == socialType) {
            hashMap.put("is_sso", "1");
        }
        hashMap.put("social_type", socialType.getType() + "");
        StatService.onEvent("thirdlogin_enter", hashMap, false);
    }
}
