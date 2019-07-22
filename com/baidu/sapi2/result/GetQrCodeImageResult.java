package com.baidu.sapi2.result;

import java.net.URLEncoder;
/* loaded from: classes3.dex */
public class GetQrCodeImageResult extends SapiResult {
    public String channelId;
    public String contentUrl;
    public String imageUrl;
    public String prompt;

    public String getJoinCode(String str) {
        return this.imageUrl + "&appName=" + URLEncoder.encode(str);
    }
}
