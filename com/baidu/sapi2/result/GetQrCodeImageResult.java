package com.baidu.sapi2.result;

import com.baidu.sapi2.NoProguard;
import java.net.URLEncoder;
/* loaded from: classes2.dex */
public class GetQrCodeImageResult extends SapiResult implements NoProguard {
    public String channelId;
    public String contentUrl;
    public String imageUrl;
    public String prompt;

    public String getJoinCode(String str) {
        return this.imageUrl + "&appName=" + URLEncoder.encode(str);
    }
}
