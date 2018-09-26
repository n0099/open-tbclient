package com.baidu.sapi2.shell.result;

import android.app.Activity;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.AccountType;
/* loaded from: classes2.dex */
public class WebAuthResult extends SapiResult {
    public static final int ERROR_CODE_NEED_BACK_PHONE_NO_REG = 12;
    public static final String ERROR_MSG_NEED_BACK_PHONE_NO_REG = "手机号未注册";
    public Activity activity;
    public AccountType accountType = AccountType.UNKNOWN;
    public boolean isAccountFreeze = false;

    public void finishActivity() {
    }

    public void finishActivity(boolean z) {
    }

    public WebAuthResult() {
        this.msgMap.put(12, ERROR_MSG_NEED_BACK_PHONE_NO_REG);
    }

    public String getLoginType() {
        return SapiUtils.getLoginType();
    }

    /* loaded from: classes2.dex */
    public enum LoginType {
        PHONE_REG("phonereg"),
        LOGIN("login"),
        LOGIN_PROTECT("apilogin"),
        FORCE_BIND("AccountBind"),
        GUIDE_BIND("apibind"),
        SHARE_V1_CHOICE(ShareCallPacking.LOGIN_TYPE_SHARE_V1_CHOICE),
        SHARE_V2_CHOICE(ShareCallPacking.LOGIN_TYPE_SHARE_V2_CHOICE);
        
        private String loginType;

        LoginType(String str) {
            this.loginType = str;
        }

        public String getLoginType() {
            return this.loginType;
        }
    }
}
