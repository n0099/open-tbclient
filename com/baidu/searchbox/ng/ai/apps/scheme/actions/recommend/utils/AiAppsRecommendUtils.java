package com.baidu.searchbox.ng.ai.apps.scheme.actions.recommend.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.ar.util.IoUtils;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.searchbox.ng.ai.apps.network.AiAppNetworkUtils;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.recommend.model.AiAppsLocationInfo;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.recommend.model.RecommendRequestParam;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes2.dex */
public class AiAppsRecommendUtils {
    public static final String AES_IV = "2018052121248000";
    public static final String AES_KEY = "baidusmartad@mic";
    public static final int NETWORK_TYPE_CELL_2G = 2;
    public static final int NETWORK_TYPE_CELL_3G = 3;
    public static final int NETWORK_TYPE_CELL_4G = 4;
    public static final int NETWORK_TYPE_CELL_UNKNOWN = 0;
    public static final int NETWORK_TYPE_WIFI = 1;
    public static final int OPERATOR_CHINA_MOBILE = 1;
    public static final int OPERATOR_CHINA_TELECOM = 2;
    public static final int OPERATOR_CHINA_UNICOM = 3;
    private static final String OPERATOR_STRING_CHINA_MOBILE_A = "46000";
    private static final String OPERATOR_STRING_CHINA_MOBILE_B = "46002";
    private static final String OPERATOR_STRING_CHINA_MOBILE_C = "46007";
    private static final String OPERATOR_STRING_CHINA_TELECOM_A = "46003";
    private static final String OPERATOR_STRING_CHINA_UNICOM_A = "46001";
    public static final int OPERATOR_UNKNOWN = 0;

    public static boolean isPad(@NonNull Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public static int getSimOperator(Context context) {
        TelephonyManager telephonyManager;
        String simOperator;
        if (context != null && (telephonyManager = (TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)) != null && (simOperator = telephonyManager.getSimOperator()) != null) {
            if (OPERATOR_STRING_CHINA_MOBILE_A.equals(simOperator) || OPERATOR_STRING_CHINA_MOBILE_B.equals(simOperator) || OPERATOR_STRING_CHINA_MOBILE_C.equals(simOperator)) {
                return 1;
            }
            if (OPERATOR_STRING_CHINA_UNICOM_A.equals(simOperator)) {
                return 3;
            }
            return OPERATOR_STRING_CHINA_TELECOM_A.equals(simOperator) ? 2 : 0;
        }
        return 0;
    }

    public static int getNetType() {
        String networkClass = AiAppNetworkUtils.getNetworkClass();
        if ("wifi".equals(networkClass)) {
            return 1;
        }
        if ("2g".equals(networkClass)) {
            return 2;
        }
        if ("3g".equals(networkClass)) {
            return 3;
        }
        if ("4g".equals(networkClass)) {
            return 4;
        }
        return 0;
    }

    @Nullable
    public static String encrypt(String str, String str2, String str3) {
        try {
            Cipher cipher = Cipher.getInstance(SapiEnv.SHARE_AES_MODE);
            cipher.init(1, new SecretKeySpec(str2.getBytes(), SapiEnv.SHARE_ALGORITHM), new IvParameterSpec(str3.getBytes()));
            return Base64.encodeToString(cipher.doFinal(str.getBytes(IoUtils.UTF_8)), 2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void fillRequestParamLocationInfo(RecommendRequestParam recommendRequestParam, AiAppsLocationInfo aiAppsLocationInfo) {
        boolean z;
        int i;
        if (recommendRequestParam != null && aiAppsLocationInfo != null) {
            String str = TextUtils.isEmpty(aiAppsLocationInfo.coordType) ? "unknown" : aiAppsLocationInfo.coordType;
            switch (str.hashCode()) {
                case -1395470197:
                    if (str.equals("bd09ll")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 3017163:
                    if (str.equals("bd09")) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case 98175376:
                    if (str.equals("gcj02")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 113079775:
                    if (str.equals("wgs84")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                default:
                    z = true;
                    break;
            }
            switch (z) {
                case false:
                    i = 0;
                    break;
                case true:
                    i = 1;
                    break;
                case true:
                    i = 2;
                    break;
                case true:
                    i = 3;
                    break;
                default:
                    i = -1;
                    break;
            }
            recommendRequestParam.userinfo.coordType = i;
            recommendRequestParam.userinfo.latitude = aiAppsLocationInfo.latitude;
            recommendRequestParam.userinfo.longitude = aiAppsLocationInfo.longitude;
        }
    }
}
