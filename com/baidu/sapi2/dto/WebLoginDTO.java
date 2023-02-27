package com.baidu.sapi2.dto;

import android.text.TextUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class WebLoginDTO extends SapiWebDTO {
    public static final String EXTRA_JOIN_LOGIN_WITHOUT_THIRD_ACCOUNT = "extra_join_login_without_third_account";
    public static final String EXTRA_JOIN_LOGIN_WITH_THIRD_ACCOUNT = "extra_join_login_with_third_account";
    public static final String EXTRA_LOGIN_WITH_NAME_PHONE_EMAIL = "extra_login_with_name_phone_email";
    public static final String EXTRA_LOGIN_WITH_PRE_LOGIN_NAME = "extra_login_with_pre_Login_Name";
    public static final String EXTRA_LOGIN_WITH_SMS = "extra_login_with_sms";
    public static final String EXTRA_LOGIN_WITH_USERNAME = "extra_login_with_username";
    public static final String EXTRA_STAT_EXTRA = "extrajson";
    public LinkedHashMap<String, String> agreement;
    public Config config;
    public String encryptedId;
    public String extraJson;
    public boolean hideSuccessTip;
    public boolean isAcceptBrowseModeAgreement;
    public boolean isWithYouthStyle;
    public String preLoginName;
    public String preSetUname;
    public String statExtra;
    public String uid;
    public String loginType = EXTRA_LOGIN_WITH_USERNAME;
    public boolean finishActivityAfterSuc = true;
    public List<PassNameValuePair> extraParams = new ArrayList();
    public boolean shareV2Disable = false;
    public int businessType = 0;
    public int screenType = 0;

    /* loaded from: classes2.dex */
    public static class Config {
        public List<FastLoginFeature> fastLoginFeatureList;
        public boolean supportTouchGuide = true;
    }

    public static String getStatExtraDecode(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static boolean statExtraValid(String str) {
        return SapiUtils.statExtraValid(str);
    }
}
