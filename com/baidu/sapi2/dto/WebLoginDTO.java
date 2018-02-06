package com.baidu.sapi2.dto;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
/* loaded from: classes2.dex */
public class WebLoginDTO extends SapiDTO {
    public static final String EXTRA_LOGIN_WITH_SMS = "extra_login_with_sms";
    public static final String EXTRA_LOGIN_WITH_USERNAME = "extra_login_with_username";
    public String loginType = EXTRA_LOGIN_WITH_USERNAME;
    public boolean finishActivityAfterSuc = true;
    public List<NameValuePair> extraParams = new ArrayList();
    public int openEnterAnimId = 0;
    public int openExitAnimId = 0;
    public int closeEnterAnimId = 0;
    public int closeExitAnimId = 0;
}
