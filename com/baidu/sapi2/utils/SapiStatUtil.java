package com.baidu.sapi2.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.fsg.face.base.b.c;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.share.ShareStatKey;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.sapi2.utils.enums.Enums;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class SapiStatUtil {
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;

    public SapiStatUtil() {
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

    public static void buildStatExtraMap(Map<String, String> map, List<PassNameValuePair> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, map, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        for (PassNameValuePair passNameValuePair : list) {
            if (passNameValuePair.name.equals("extrajson") && SapiUtils.statExtraValid(passNameValuePair.getValue())) {
                map.put("extrajson", passNameValuePair.getValue());
            }
        }
    }

    public static void statExplainCamera(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(2);
            linkedHashMap.put("face-privacy", str);
            linkedHashMap.put("sub-pro", str2);
            StatService.onEventAutoStatistic(linkedHashMap);
        }
    }

    public static void statInvokeCloudShareAccount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, null, i2) == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(1);
            if (i2 == 3) {
                linkedHashMap.put("eventType", "cloud_share_account_invoke");
            } else if (i2 == 4) {
                linkedHashMap.put("eventType", "cloud_share_account_login_success");
            } else if (i2 == 5) {
                linkedHashMap.put("eventType", "cloud_share_account_login_fail");
            }
            StatService.onEventAutoStatistic(linkedHashMap);
        }
    }

    public static void statLoadLogin(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("scene", str);
            }
            StatService.onEvent("load_login", hashMap);
        }
    }

    public static void statOneKeyCheckAbility(int i2, int i3, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), str}) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("code", i2 + "");
            hashMap.put("subCode", i3 + "");
            hashMap.put(c.l, z ? "1" : "0");
            hashMap.put("operator", str);
            StatService.onEvent("one_key_check_ability", hashMap);
        }
    }

    public static void statOneKeyLoginPassAction(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65542, null, i2, str, str2) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("jsExecuteResult", i2 + "");
            hashMap.put("code", str);
            hashMap.put("msg", str2);
            StatService.onEvent("one_key_load_login", hashMap);
        }
    }

    public static void statOneKeyLoginSDKAction(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(65543, null, i2, i3, i4) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("code", i2 + "");
            hashMap.put("subCode", i3 + "");
            hashMap.put("hasToken", i4 + "");
            StatService.onEvent("one_key_login_sdk", hashMap);
        }
    }

    public static void statOneKeyOauthToken(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(65544, null, i2, i3, i4) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("code", i2 + "");
            hashMap.put("subCode", i3 + "");
            hashMap.put("hasToken", i4 + "");
            StatService.onEvent("one_key_oauth_token", hashMap);
        }
    }

    public static void statOneKeyPreGetPhone(int i2, int i3, String str, String str2, String str3, String str4) {
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, str2, str3, str4}) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("code", i2 + "");
            hashMap.put("subCode", i3 + "");
            hashMap.put("phoneNum", str);
            hashMap.put("operator", str2);
            if (str4.contains("G")) {
                str5 = "data";
            } else {
                str5 = CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING.equals(str4) ? "wifi" : "unknown";
            }
            hashMap.put("scene", str3);
            hashMap.put("netType", str5);
            StatService.onEvent("one_key_pre_get_phone", hashMap);
        }
    }

    public static void statSetCloudShareAccount(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65546, null, i2, i3) == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(1);
            if (i3 == 0) {
                if (i2 == 2) {
                    linkedHashMap.put("eventType", "cloud_share_account_insert_start");
                } else if (i2 == 3) {
                    linkedHashMap.put("eventType", "cloud_share_account_delete_start");
                } else if (i2 == 4) {
                    linkedHashMap.put("eventType", "cloud_share_account_reset_start");
                }
            } else if (i3 == 1) {
                if (i2 == 2) {
                    linkedHashMap.put("eventType", "cloud_share_account_insert_success");
                } else if (i2 == 3) {
                    linkedHashMap.put("eventType", "cloud_share_account_delete_success");
                } else if (i2 == 4) {
                    linkedHashMap.put("eventType", "cloud_share_account_reset_success");
                }
            } else if (i3 == 2) {
                if (i2 == 2) {
                    linkedHashMap.put("eventType", "cloud_share_account_insert_fail");
                } else if (i2 == 3) {
                    linkedHashMap.put("eventType", "cloud_share_account_delete_fail");
                } else if (i2 == 4) {
                    linkedHashMap.put("eventType", "cloud_share_account_reset_fail");
                }
            }
            StatService.onEventAutoStatistic(linkedHashMap);
        }
    }

    public static void statShareClickOther(String str, List<PassNameValuePair> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, str, list) == null) {
            HashMap hashMap = new HashMap();
            buildStatExtraMap(hashMap, list);
            if (str.equals("v2")) {
                StatService.onEvent("share_v2_click_other", hashMap);
            } else if (str.equals("v1")) {
                StatService.onEvent("share_v1_click_other", hashMap);
            }
        }
    }

    public static void statShareV1Login(SapiAccount sapiAccount, List<PassNameValuePair> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65548, null, sapiAccount, list) == null) && ShareCallPacking.LOGIN_TYPE_SHARE_V1_CHOICE.equals(SapiContext.getInstance().getAccountActionType())) {
            SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.CHOICE_SHARE.getName());
            HashMap hashMap = new HashMap();
            buildStatExtraMap(hashMap, list);
            hashMap.put(ShareCallPacking.StatModel.KEY_ACCOUNT_TPL, sapiAccount.getShareAccountTpl());
            hashMap.put(ShareCallPacking.StatModel.KEY_ACCOUNT_APP, sapiAccount.app);
            hashMap.put("uid", sapiAccount.uid);
            StatService.onEvent("share_v1_account_suc", hashMap);
        }
    }

    public static void statShareV2Click(ShareCallPacking.StatModel statModel, List<PassNameValuePair> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, null, statModel, list, str) == null) {
            HashMap hashMap = new HashMap();
            buildStatExtraMap(hashMap, list);
            hashMap.put("index", statModel.index + "");
            hashMap.put(ShareCallPacking.StatModel.KEY_ACCOUNT_TPL, statModel.accountTpl);
            hashMap.put(ShareCallPacking.StatModel.KEY_ACCOUNT_APP, statModel.appName);
            hashMap.put(ShareCallPacking.StatModel.KEY_CALL_TYPE, str);
            StatService.onEventAutoStat(ShareStatKey.SHARE_V2_LOGIN_INVOKE, hashMap);
        }
    }

    public static void statShareV2Fail(ShareCallPacking.StatModel statModel, String str, String str2, String str3, List<PassNameValuePair> list, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{statModel, str, str2, str3, list, str4}) == null) {
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
    }

    public static void statShareV2Open(List<ShareStorage.StorageModel> list, String str, List<PassNameValuePair> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, list, str, list2) == null) {
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
            hashMap.put("device", Build.MODEL);
            hashMap.put(ShareLoginStat.GetShareListStat.KEY_ACCOUNT_SIZE, list.size() + "");
            hashMap.put(ShareLoginStat.GetShareListStat.KEY_ACCOUNT_TPLS, TextUtils.join(",", arrayList));
            hashMap.put(ShareLoginStat.GetShareListStat.KEY_ACCOUNT_APPS, TextUtils.join(",", arrayList2));
            StatService.onEvent("share_account_open", hashMap);
        }
    }

    public static void statShareV2OpenMax(Context context, int i2, int i3, int i4, int i5, ShareStorage shareStorage, List<ShareStorage.StorageModel> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), shareStorage, list}) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("cuid", SapiUtils.getClientId(context));
            hashMap.put("device", Build.MODEL);
            hashMap.put("read_failure_count", i2 + "");
            hashMap.put("read_sp_count", i3 + "");
            hashMap.put("read_sd_count", i4 + "");
            hashMap.put("app_count", i5 + "");
            hashMap.put("share_count", list.size() + "");
            hashMap.put(HttpConstants.OS_VERSION, Build.VERSION.RELEASE);
            hashMap.put("chmod", shareStorage.readSpFromChmodFile ? "1" : "0");
            StatService.onEvent("share_read", hashMap);
        }
    }

    public static void statShareV2Success(ShareCallPacking.StatModel statModel, String str, List<PassNameValuePair> list, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65553, null, statModel, str, list, str2) == null) {
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
    }

    public static void statSmsCodeClip(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, context, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("cuid", SapiUtils.getClientId(context));
            hashMap.put("device", Build.MODEL);
            hashMap.put(HttpConstants.OS_VERSION, Build.VERSION.RELEASE);
            hashMap.put("success", str);
            StatService.onEvent("get_sms_check_code_from_clip", hashMap);
        }
    }

    public static void statThirdLoginEnter(SocialType socialType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, socialType) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("clientip", SapiUtils.getLocalIpAddress());
            hashMap.put("client", "android");
            hashMap.put("social_type", socialType.getType() + "");
            if (SocialType.SINA_WEIBO_SSO == socialType) {
                hashMap.put("is_sso", "1");
            }
            hashMap.put("social_type", socialType.getType() + "");
            StatService.onEvent("thirdlogin_enter", hashMap);
        }
    }
}
