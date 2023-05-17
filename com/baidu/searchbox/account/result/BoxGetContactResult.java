package com.baidu.searchbox.account.result;

import java.util.List;
/* loaded from: classes3.dex */
public class BoxGetContactResult extends BoxSapiResult {
    public static final int ERROR_CODE_CONTACT_NULL = -903;
    public static final int ERROR_CODE_NO_ACCOUNT = -902;
    public static final int ERROR_CODE_NO_PERMISSION = -901;
    public static final String ERROR_MSG_CONTACT_NULL = "通讯录为空，获取失败";
    public static final String ERROR_MSG_NO_ACCOUNT = "该用户信息无效，请重新登录";
    public static final String ERROR_MSG_NO_PERMISSION = "无权限";
    public static final int RESULT_CODE_FAIL_ACCOUNT = 2;
    public int itemCount;
    public String name;
    public int pageCount;
    public int pageNo;
    public int pageSize;
    public String phone;
    public List<BoxUserPhoneBean> userPhoneBeans;

    public BoxGetContactResult() {
        this.msgMap.put(-901, "无权限");
        this.msgMap.put(ERROR_CODE_NO_ACCOUNT, ERROR_MSG_NO_ACCOUNT);
        this.msgMap.put(ERROR_CODE_CONTACT_NULL, ERROR_MSG_CONTACT_NULL);
    }
}
