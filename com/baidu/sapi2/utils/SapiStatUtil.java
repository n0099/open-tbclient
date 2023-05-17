package com.baidu.sapi2.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.share.ShareStatKey;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.stat.OneKeyLoginStat;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.sapi2.utils.enums.Enums;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.facebook.cache.disk.DefaultDiskStorage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class SapiStatUtil {
    public static final int CLOUND_SHARE_ACCOUNT_STAT_INVOKE_START = 3;
    public static final int CLOUND_SHARE_ACCOUNT_STAT_LOGIN_FAIL = 5;
    public static final int CLOUND_SHARE_ACCOUNT_STAT_LOGIN_SUCCESS = 4;
    public static final int CLOUND_SHARE_ACCOUNT_STAT_SET_FAIL = 2;
    public static final int CLOUND_SHARE_ACCOUNT_STAT_SET_START = 0;
    public static final int CLOUND_SHARE_ACCOUNT_STAT_SET_SUCCESS = 1;
    public static final String LOGIN_STATUS_BDUSS_INVALIDATE = "2";
    public static final String LOGIN_STATUS_BDUSS_VALIDATE = "0";
    public static final String LOGIN_STATUS_NO_LOGIN = "1";
    public static final String LOGIN_STATUS_UNKNOWN = "3";
    public static final String TAG = "SapiStatUtil";

    public static void buildStatExtraMap(Map<String, String> map, List<PassNameValuePair> list) {
        if (list != null && !list.isEmpty()) {
            for (PassNameValuePair passNameValuePair : list) {
                if (passNameValuePair.name.equals("extrajson") && SapiUtils.statExtraValid(passNameValuePair.getValue())) {
                    map.put("extrajson", passNameValuePair.getValue());
                }
            }
        }
    }

    public static void statShareV1Login(SapiAccount sapiAccount, List<PassNameValuePair> list) {
        if (ShareCallPacking.LOGIN_TYPE_SHARE_V1_CHOICE.equals(SapiContext.getInstance().getAccountActionType())) {
            SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.CHOICE_SHARE.getName());
            HashMap hashMap = new HashMap();
            buildStatExtraMap(hashMap, list);
            hashMap.put(ShareCallPacking.StatModel.KEY_ACCOUNT_TPL, sapiAccount.getShareAccountTpl());
            hashMap.put(ShareCallPacking.StatModel.KEY_ACCOUNT_APP, sapiAccount.app);
            hashMap.put("uid", sapiAccount.uid);
            StatService.onEvent("share_v1_account_suc", hashMap);
        }
    }

    public static void statExplainCamera(String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(2);
        linkedHashMap.put("face-privacy", str);
        linkedHashMap.put("sub-pro", str2);
        StatService.onEventAutoStatistic(linkedHashMap);
    }

    public static void statShareClickOther(String str, List<PassNameValuePair> list) {
        HashMap hashMap = new HashMap();
        buildStatExtraMap(hashMap, list);
        if (str.equals(DefaultDiskStorage.DEFAULT_DISK_STORAGE_VERSION_PREFIX)) {
            StatService.onEvent("share_v2_click_other", hashMap);
        } else if (str.equals("v1")) {
            StatService.onEvent("share_v1_click_other", hashMap);
        }
    }

    public static void statSmsCodeClip(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("cuid", SapiUtils.getClientId(context));
        hashMap.put(Config.DEVICE_PART, "android");
        hashMap.put(HttpConstants.OS_VERSION, Build.VERSION.RELEASE);
        hashMap.put("success", str);
        StatService.onEvent("get_sms_check_code_from_clip", hashMap);
    }

    public static void statInvokeCloudShareAccount(int i) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(1);
        if (i != 3) {
            if (i != 4) {
                if (i == 5) {
                    linkedHashMap.put("eventType", "cloud_share_account_login_fail");
                }
            } else {
                linkedHashMap.put("eventType", "cloud_share_account_login_success");
            }
        } else {
            linkedHashMap.put("eventType", "cloud_share_account_invoke");
        }
        StatService.onEventAutoStatistic(linkedHashMap);
    }

    public static void statLoadLogin(String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("scene", str);
        }
        StatService.onEvent("load_login", hashMap);
    }

    public static void statOneKeyCheckAbility(int i, int i2, boolean z, String str) {
        String str2;
        HashMap hashMap = new HashMap();
        hashMap.put("code", i + "");
        hashMap.put("subCode", i2 + "");
        if (z) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        hashMap.put("enable", str2);
        hashMap.put("operator", str);
        StatService.onEvent(OneKeyLoginStat.CheckAbility.VALUE_PAGE, hashMap);
    }

    public static void statOneKeyLoginPassAction(int i, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("jsExecuteResult", i + "");
        hashMap.put("code", str);
        hashMap.put("msg", str2);
        StatService.onEvent(OneKeyLoginStat.LoadLogin.VALUE_PAGE, hashMap);
    }

    public static void statOneKeyLoginSDKAction(int i, int i2, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("code", i + "");
        hashMap.put("subCode", i2 + "");
        hashMap.put("hasToken", i3 + "");
        StatService.onEvent("one_key_login_sdk", hashMap);
    }

    public static void statOneKeyOauthToken(int i, int i2, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("code", i + "");
        hashMap.put("subCode", i2 + "");
        hashMap.put("hasToken", i3 + "");
        StatService.onEvent(OneKeyLoginStat.OauthToken.VALUE_PAGE, hashMap);
    }

    public static void statOneKeyPreGetPhone(int i, int i2, String str, String str2, String str3, String str4) {
        String str5;
        HashMap hashMap = new HashMap();
        hashMap.put("code", i + "");
        hashMap.put("subCode", i2 + "");
        hashMap.put("phoneNum", str);
        hashMap.put("operator", str2);
        if (str4.contains("G")) {
            str5 = "data";
        } else if ("WIFI".equals(str4)) {
            str5 = "wifi";
        } else {
            str5 = "unknown";
        }
        hashMap.put("scene", str3);
        hashMap.put("netType", str5);
        StatService.onEvent(OneKeyLoginStat.PreGetPhoneStat.VALUE_PAGE, hashMap);
    }

    public static void statSetCloudShareAccount(int i, int i2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(1);
        if (i2 == 0) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        linkedHashMap.put("eventType", "cloud_share_account_reset_start");
                    }
                } else {
                    linkedHashMap.put("eventType", "cloud_share_account_delete_start");
                }
            } else {
                linkedHashMap.put("eventType", "cloud_share_account_insert_start");
            }
        } else if (i2 == 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        linkedHashMap.put("eventType", "cloud_share_account_reset_success");
                    }
                } else {
                    linkedHashMap.put("eventType", "cloud_share_account_delete_success");
                }
            } else {
                linkedHashMap.put("eventType", "cloud_share_account_insert_success");
            }
        } else if (i2 == 2) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        linkedHashMap.put("eventType", "cloud_share_account_reset_fail");
                    }
                } else {
                    linkedHashMap.put("eventType", "cloud_share_account_delete_fail");
                }
            } else {
                linkedHashMap.put("eventType", "cloud_share_account_insert_fail");
            }
        }
        StatService.onEventAutoStatistic(linkedHashMap);
    }

    public static void statShareV2Click(ShareCallPacking.StatModel statModel, List<PassNameValuePair> list, String str) {
        HashMap hashMap = new HashMap();
        buildStatExtraMap(hashMap, list);
        hashMap.put("index", statModel.index + "");
        hashMap.put(ShareCallPacking.StatModel.KEY_ACCOUNT_TPL, statModel.accountTpl);
        hashMap.put(ShareCallPacking.StatModel.KEY_ACCOUNT_APP, statModel.appName);
        hashMap.put(ShareCallPacking.StatModel.KEY_CALL_TYPE, str);
        StatService.onEventAutoStat(ShareStatKey.SHARE_V2_LOGIN_INVOKE, hashMap);
    }

    public static void statShareV2Fail(ShareCallPacking.StatModel statModel, String str, String str2, String str3, List<PassNameValuePair> list, String str4) {
        HashMap hashMap = new HashMap();
        buildStatExtraMap(hashMap, list);
        hashMap.put("fail_code", str);
        hashMap.put("fail_reason", str2);
        if (ShareCallPacking.statModel != null) {
            hashMap.put(ShareCallPacking.StatModel.KEY_ACCOUNT_TPL, statModel.accountTpl);
            hashMap.put(ShareCallPacking.StatModel.KEY_ACCOUNT_APP, statModel.appName);
        }
        hashMap.put("uid", str3);
        hashMap.put(ShareCallPacking.StatModel.KEY_CALL_TYPE, str4);
        StatService.onEventAutoStat(ShareStatKey.SHARE_V2_LOGIN_FAIL, hashMap);
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
            hashMap.put("scene", str);
        }
        hashMap.put(Config.DEVICE_PART, "android");
        hashMap.put(ShareLoginStat.GetShareListStat.KEY_ACCOUNT_SIZE, list.size() + "");
        hashMap.put(ShareLoginStat.GetShareListStat.KEY_ACCOUNT_TPLS, TextUtils.join(",", arrayList));
        hashMap.put(ShareLoginStat.GetShareListStat.KEY_ACCOUNT_APPS, TextUtils.join(",", arrayList2));
        StatService.onEvent("share_account_open", hashMap);
    }

    public static void statShareV2OpenMax(Context context, int i, int i2, int i3, int i4, ShareStorage shareStorage, List<ShareStorage.StorageModel> list) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("cuid", SapiUtils.getClientId(context));
        hashMap.put(Config.DEVICE_PART, "android");
        hashMap.put("read_failure_count", i + "");
        hashMap.put("read_sp_count", i2 + "");
        hashMap.put("read_sd_count", i3 + "");
        hashMap.put("app_count", i4 + "");
        hashMap.put("share_count", list.size() + "");
        hashMap.put(HttpConstants.OS_VERSION, Build.VERSION.RELEASE);
        if (shareStorage.readSpFromChmodFile) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("chmod", str);
        StatService.onEvent("share_read", hashMap);
    }

    public static void statShareV2Success(ShareCallPacking.StatModel statModel, String str, List<PassNameValuePair> list, String str2) {
        HashMap hashMap = new HashMap();
        buildStatExtraMap(hashMap, list);
        if (ShareCallPacking.statModel != null) {
            hashMap.put(ShareCallPacking.StatModel.KEY_ACCOUNT_TPL, statModel.accountTpl);
            hashMap.put(ShareCallPacking.StatModel.KEY_ACCOUNT_APP, statModel.appName);
        }
        hashMap.put("uid", str);
        hashMap.put(ShareCallPacking.StatModel.KEY_CALL_TYPE, str2);
        StatService.onEventAutoStat(ShareStatKey.SHARE_V2_LOGIN_SUCCESS, hashMap);
    }

    public static void statThirdLoginEnter(SocialType socialType) {
        HashMap hashMap = new HashMap();
        hashMap.put(DnsModel.CLIENTIP_KEY, SapiUtils.getLocalIpAddress());
        hashMap.put(CommandUBCHelper.COMMAND_UBC_STATISTICS_SOURCE_VALUE_CLIENT, "android");
        hashMap.put("social_type", socialType.getType() + "");
        if (SocialType.SINA_WEIBO_SSO == socialType) {
            hashMap.put("is_sso", "1");
        }
        hashMap.put("social_type", socialType.getType() + "");
        StatService.onEvent("thirdlogin_enter", hashMap);
    }
}
