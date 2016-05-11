package com.baidu.sapi2.shell.response;

import com.baidu.sapi2.utils.enums.SocialType;
/* loaded from: classes.dex */
public class SocialResponse extends SapiAccountResponse {
    public boolean isBinded = false;
    public String baiduUname = "";
    public String socialUname = "";
    public String socialPortraitUrl = "";
    public SocialType socialType = SocialType.UNKNOWN;
    public boolean bindGuide = false;
    public boolean offlineNotice = false;
}
