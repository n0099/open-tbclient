package com.baidu.sapi2.result;
/* loaded from: classes6.dex */
public class WebBindWidgetResult extends SapiResult {
    public static final int ERROR_CODE_HANDLE_LOGIN = -10001;
    public static final String ERROR_MSG_HANDLE_LOGIN = "请登录";

    public WebBindWidgetResult() {
        this.msgMap.put(-10001, "请登录");
    }

    public void loginSuc() {
    }
}
