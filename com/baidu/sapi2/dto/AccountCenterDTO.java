package com.baidu.sapi2.dto;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class AccountCenterDTO extends SapiWebDTO {
    public static final PassNameValuePair HIDE_PERSONAL_DATA = new PassNameValuePair("personalData", "0");
    public static final PassNameValuePair HIDE_REAL_NAME = new PassNameValuePair("realname", "0");
    public static String REFER_ACCOUNT_CENTER = "account_center";
    public static String REFER_ACCOUNT_CHECK = "account_check";
    public String bduss;
    public List<PassNameValuePair> paramsList = new ArrayList();
    public String refer = REFER_ACCOUNT_CENTER;
    public boolean logoutAfterBdussInvalid = true;
    public boolean handleLogin = false;
}
