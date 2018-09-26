package com.baidu.sapi2.dto;

import com.baidu.sapi2.SapiWebView;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes2.dex */
public class AccountCenterDTO extends SapiWebDTO {
    public String bduss;
    public static String REFER_ACCOUNT_CHECK = SapiWebView.ACCOUNT_CENTER_CHECK;
    public static String REFER_ACCOUNT_CENTER = SapiWebView.ACCOUNT_CENTER;
    public static final NameValuePair HIDE_PERSONAL_DATA = new BasicNameValuePair("personalData", "0");
    public static final NameValuePair HIDE_REAL_NAME = new BasicNameValuePair("realname", "0");
    public List<NameValuePair> paramsList = new ArrayList();
    public String refer = REFER_ACCOUNT_CENTER;
    public boolean logoutAfterBdussInvalid = true;
    public boolean handleLogin = false;
}
