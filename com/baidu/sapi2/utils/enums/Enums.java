package com.baidu.sapi2.utils.enums;

import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.searchbox.ugc.transcoder.interfaces.UgcTranscoderConstant;
/* loaded from: classes3.dex */
public class Enums {

    /* loaded from: classes3.dex */
    public static class FingerprintAuthType {
        public static final int LOGIN = 3;
    }

    /* loaded from: classes3.dex */
    public static class NormalizeWay {
        public static final int NONE = 0;
        public static final int PWD = 3;
        public static final int SMS = 1;
        public static final int SMS_EXIST = 2;
    }

    /* loaded from: classes3.dex */
    public static class PreLoginType {
        public static final int CHINA_MOBILE_OAUTH = 12;
        public static final int CHOICE_SHARE = 8;
        public static final int CHOICE_SHARE_V2 = 9;
        public static final int CM = 16;
        public static final int CT = 18;
        public static final int CU = 17;
        public static final int FACE = 3;
        public static final int HISTORY = 21;
        public static final int HUAWEI = 10;
        public static final int IQIYI = 22;
        public static final int MEIZU = 14;
        public static final int NA_QR_LOGIN = 20;
        public static final int NONE = 0;
        public static final int OTHER = 11;
        public static final int PWD = 1;
        public static final int QQ = 6;
        public static final int SLIENT_SHARE = 7;
        public static final int SMS = 2;
        public static final int SWITCH = 19;
        public static final int TOUCHID = 15;
        public static final int WECHAT = 4;
        public static final int WEIBO = 5;
        public static final int XIAOMI = 13;
        public static final int YY = 100;
    }

    /* loaded from: classes3.dex */
    public enum LastLoginType {
        NONE("none", 0),
        PWD("pwd", 1),
        SMS(LoginConstants.SMS_LOGIN, 2),
        FACE(UgcTranscoderConstant.URL_GET_FACE, 3),
        TOUCHID(SapiOptions.Gray.FUN_NAME_GINGER, 15),
        WECHAT("wechat", 4),
        WEIBO("weibo", 5),
        QQ(LoginConstants.QQ_LOGIN, 6),
        HUAWEI(RomUtils.MANUFACTURER_HUAWEI, 10),
        HONOR("honor", 23),
        CFO("cfo", 60),
        YY("yy", 100),
        XIAOMI(RomUtils.MANUFACTURER_XIAOMI, 13),
        MEIZU("meizu", 14),
        SLIENT_SHARE("slient_share", 7),
        CHOICE_SHARE(ShareCallPacking.LOGIN_TYPE_SHARE_V1_CHOICE, 8),
        CHOICE_SHARE_V2(ShareCallPacking.LOGIN_TYPE_SHARE_V2_CHOICE, 9),
        ONEKEYLOGIN_CM("onekeylogin_cm", 16),
        ONEKEYLOGIN_CU("onekeylogin_cu", 17),
        ONEKEYLOGIN_CT("onekeylogin_ct", 18),
        SWITCH("switch", 19),
        QR("qr", 20),
        HISTORY("history", 21),
        IQIYI("iqiyi", 22),
        OTHER("other", -1);
        
        public String key;
        public int value;

        LastLoginType(String str, int i) {
            this.key = str;
            this.value = i;
        }

        public static String getNameByValue(int i) {
            LastLoginType[] values;
            for (LastLoginType lastLoginType : values()) {
                if (lastLoginType.getValue() == i) {
                    return lastLoginType.getName();
                }
            }
            return OTHER.getName();
        }

        public static int getValueByName(String str) {
            LastLoginType[] values;
            if (TextUtils.isEmpty(str)) {
                return NONE.getValue();
            }
            for (LastLoginType lastLoginType : values()) {
                if (lastLoginType.getName().equals(str)) {
                    return lastLoginType.getValue();
                }
            }
            return OTHER.getValue();
        }

        public String getName() {
            return this.key;
        }

        public int getValue() {
            return this.value;
        }
    }
}
