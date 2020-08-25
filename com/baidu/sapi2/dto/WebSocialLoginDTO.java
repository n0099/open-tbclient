package com.baidu.sapi2.dto;

import android.content.Context;
import com.baidu.sapi2.utils.enums.SocialType;
/* loaded from: classes12.dex */
public class WebSocialLoginDTO extends SapiWebDTO {
    public Context context;
    public boolean finishActivityAfterSuc = true;
    public SocialType socialType;
    public String statExtra;
}
