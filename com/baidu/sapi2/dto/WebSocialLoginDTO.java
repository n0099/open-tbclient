package com.baidu.sapi2.dto;

import android.content.Context;
import com.baidu.sapi2.utils.enums.SocialType;
/* loaded from: classes3.dex */
public class WebSocialLoginDTO extends SapiWebDTO {
    public Context context;
    public boolean finishActivityAfterSuc = true;
    public Boolean isReleaseAllCallback = Boolean.TRUE;
    public SocialType socialType;
    public String statExtra;
}
