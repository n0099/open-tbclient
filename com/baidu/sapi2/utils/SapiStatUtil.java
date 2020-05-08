package com.baidu.sapi2.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.m;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidubce.AbstractBceClient;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class SapiStatUtil {
    public static final String LOGIN_STATUS_BDUSS_INVALIDATE = "2";
    public static final String LOGIN_STATUS_BDUSS_VALIDATE = "0";
    public static final String LOGIN_STATUS_NO_LOGIN = "1";
    public static final String LOGIN_STATUS_UNKNOWN = "3";

    public static void buildStatExtraMap(Map<String, String> map, List<PassNameValuePair> list) {
        if (list != null && !list.isEmpty()) {
            for (PassNameValuePair passNameValuePair : list) {
                if (passNameValuePair.name.equals("extrajson") && SapiUtils.statExtraValid(passNameValuePair.getValue())) {
                    map.put("extrajson", passNameValuePair.getValue());
                }
            }
        }
    }

    public static void statLoadLogin(String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, str);
        }
        t.a("load_login", hashMap);
    }

    public static void statPreGetPhoneInfo(int i, String str, String str2, String str3, String str4) {
        String str5;
        HashMap hashMap = new HashMap();
        hashMap.put("cm_pre_phone", i + "");
        hashMap.put("cm_pre_phone_errno", str + "");
        hashMap.put("operator", str2);
        if ("1".equals(str4)) {
            str5 = "data";
        } else if ("2".equals(str4)) {
            str5 = "wifi";
        } else {
            str5 = "3".equals(str4) ? "dataAndWifi" : "unknown";
        }
        hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, str3);
        hashMap.put("netType", str5);
        t.a("pass_sdk_init", hashMap);
    }

    public static void statShareClickOther(String str, List<PassNameValuePair> list) {
        HashMap hashMap = new HashMap();
        buildStatExtraMap(hashMap, list);
        if (str.equals("v2")) {
            t.a("share_v2_click_other", hashMap);
        } else if (str.equals(AbstractBceClient.URL_PREFIX)) {
            t.a("share_v1_click_other", hashMap);
        }
    }

    public static void statShareV1AccountClick(int i, String str, String str2, List<PassNameValuePair> list) {
        HashMap hashMap = new HashMap();
        buildStatExtraMap(hashMap, list);
        hashMap.put("index", i + "");
        hashMap.put(m.b.b, str);
        hashMap.put(m.b.c, str2);
        t.a("share_v1_account_click", hashMap);
    }

    public static void statShareV1Login(SapiAccount sapiAccount, List<PassNameValuePair> list) {
        if (com.baidu.sapi2.share.m.i.equals(SapiContext.getInstance().getAccountActionType())) {
            SapiContext.getInstance().put(SapiContext.KEY_PRE_LOGIN_TYPE, com.baidu.sapi2.share.m.i);
            HashMap hashMap = new HashMap();
            buildStatExtraMap(hashMap, list);
            hashMap.put(m.b.b, sapiAccount.getShareAccountTpl());
            hashMap.put(m.b.c, sapiAccount.app);
            hashMap.put("uid", sapiAccount.uid);
            t.a("share_v1_account_suc", hashMap);
        }
    }

    public static void statShareV1OpenPage(List<SapiAccount> list, List<PassNameValuePair> list2) {
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
        buildStatExtraMap(hashMap, list2);
        hashMap.put("account_size", list.size() + "");
        hashMap.put("account_tpls", TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, arrayList));
        hashMap.put("account_apps", TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, arrayList2));
        t.a("share_v1_account_open", hashMap);
    }

    public static void statShareV2ActiveLoginSuc() {
        t.a("share_v2_active_login_suc", new HashMap());
    }

    public static void statShareV2Click(m.b bVar, List<PassNameValuePair> list) {
        HashMap hashMap = new HashMap();
        buildStatExtraMap(hashMap, list);
        hashMap.put("index", bVar.d + "");
        hashMap.put(m.b.b, bVar.e);
        hashMap.put(m.b.c, bVar.f);
        t.a("share_account_click", hashMap);
    }

    public static void statShareV2Invoke(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(com.baidu.sapi2.outsdk.c.k, str);
        t.a("share_v2_invoke", hashMap);
    }

    public static void statShareV2Oauth() {
        t.a("share_v2_oauth", new HashMap());
    }

    public static void statShareV2OauthSuc() {
        t.a("share_v2_oauth_suc", new HashMap());
    }

    public static void statShareV2Open(List<ShareStorage.StorageModel> list, String str, List<PassNameValuePair> list2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (ShareStorage.StorageModel storageModel : list) {
            if (!TextUtils.isEmpty(storageModel.tpl)) {
                arrayList.add(storageModel.tpl);
            }
            if (!TextUtils.isEmpty(storageModel.app)) {
                arrayList2.add(storageModel.app);
            }
        }
        HashMap hashMap = new HashMap();
        buildStatExtraMap(hashMap, list2);
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, str);
        }
        hashMap.put(Config.DEVICE_PART, Build.MODEL);
        hashMap.put("account_size", list.size() + "");
        hashMap.put("account_tpls", TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, arrayList));
        hashMap.put("account_apps", TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, arrayList2));
        t.a("share_account_open", hashMap);
    }

    public static void statShareV2OpenMax(Context context, int i, int i2, int i3, int i4, ShareStorage shareStorage, List<ShareStorage.StorageModel> list) {
        HashMap hashMap = new HashMap();
        hashMap.put("cuid", SapiUtils.getClientId(context));
        hashMap.put(Config.DEVICE_PART, Build.MODEL);
        hashMap.put("read_failure_count", i + "");
        hashMap.put("read_sp_count", i2 + "");
        hashMap.put("read_sd_count", i3 + "");
        hashMap.put("app_count", i4 + "");
        hashMap.put("share_count", list.size() + "");
        hashMap.put("os_version", Build.VERSION.RELEASE);
        hashMap.put("chmod", shareStorage.readSpFromChmodFile ? "1" : "0");
        t.a("share_read", hashMap);
    }

    public static void statShareV2OtherFail(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("error_code", i + "");
        t.a("share_v2_oauth_fail", hashMap);
    }

    public static void statShareV2Result(m.b bVar, String str, int i, String str2, List<PassNameValuePair> list) {
        HashMap hashMap = new HashMap();
        buildStatExtraMap(hashMap, list);
        hashMap.put("share_result", i + "");
        hashMap.put("fail_reason", str);
        if (com.baidu.sapi2.share.m.k != null) {
            hashMap.put(m.b.b, bVar.e);
            hashMap.put(m.b.c, bVar.f);
        }
        hashMap.put("uid", str2);
        t.a("share_account_result", hashMap);
    }

    public static void statSmsCodeClip(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("cuid", SapiUtils.getClientId(context));
        hashMap.put(Config.DEVICE_PART, Build.MODEL);
        hashMap.put("os_version", Build.VERSION.RELEASE);
        hashMap.put("success", str);
        t.a("get_sms_check_code_from_clip", hashMap);
    }

    public static void statThirdLoginEnter(SocialType socialType) {
        HashMap hashMap = new HashMap();
        hashMap.put("clientip", SapiUtils.getLocalIpAddress());
        hashMap.put("client", "android");
        hashMap.put(LoginActivityConfig.SOCIAL_TYPE, socialType.getType() + "");
        if (SocialType.SINA_WEIBO_SSO == socialType) {
            hashMap.put("is_sso", "1");
        }
        hashMap.put(LoginActivityConfig.SOCIAL_TYPE, socialType.getType() + "");
        t.a("thirdlogin_enter", hashMap);
    }
}
