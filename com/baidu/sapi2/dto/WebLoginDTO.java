package com.baidu.sapi2.dto;

import android.text.TextUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class WebLoginDTO extends SapiWebDTO {
    public static final String EXTRA_JOIN_LOGIN_WITHOUT_THIRD_ACCOUNT = "extra_join_login_without_third_account";
    public static final String EXTRA_JOIN_LOGIN_WITH_THIRD_ACCOUNT = "extra_join_login_with_third_account";
    public static final String EXTRA_LOGIN_WITH_SMS = "extra_login_with_sms";
    public static final String EXTRA_LOGIN_WITH_USERNAME = "extra_login_with_username";
    public static final String EXTRA_STAT_EXTRA = "extrajson";
    public LinkedHashMap<String, String> agreement;
    public Config config;
    public String encryptedId;
    public String preSetUname;
    public String statExtra;
    public String loginType = EXTRA_LOGIN_WITH_USERNAME;
    public boolean finishActivityAfterSuc = true;
    public List<PassNameValuePair> extraParams = new ArrayList();
    public boolean shareV2Disable = false;

    /* loaded from: classes2.dex */
    public static class Config {
        public List<FastLoginFeature> fastLoginFeatureList;
    }

    public static boolean statExtraValid(String str) {
        return !TextUtils.isEmpty(str) && str.getBytes().length <= SapiContext.getInstance(SapiAccountManager.getInstance().getSapiConfiguration().context).getLoginStatExtraLimitLen();
    }

    public static String getStatExtraDecode(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return URLDecoder.decode(str, HTTP.UTF_8);
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}
