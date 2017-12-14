package com.baidu.sapi2.dto;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes2.dex */
public class AccountCenterDTO extends SapiDTO {
    public static final NameValuePair HIDE_PERSONAL_DATA = new BasicNameValuePair("personalData", "0");
    public static final NameValuePair HIDE_REAL_NAME = new BasicNameValuePair("realname", "0");
    public String bduss;
    public List<NameValuePair> paramsList = new ArrayList();
}
