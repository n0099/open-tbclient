package com.baidu.sapi2.result;

import java.net.URLEncoder;
/* loaded from: classes6.dex */
public class GetQrCodeImageResult extends SapiResult {
    public String channelId;
    public String contentUrl;
    public String imageUrl;
    public String prompt;

    public String getJoinCode() {
        return this.imageUrl + "&prompt=" + URLEncoder.encode(this.prompt);
    }
}
