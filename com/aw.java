package com;

import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.oauth.FacebookAuthHandler;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import com.baidu.cloudsdk.social.oauth.TwitterAuthHandler;
/* loaded from: classes.dex */
public class aw {
    private String b;
    private SocialOAuthActivity fjY;
    private IBaiduListener fjZ;

    public aw(SocialOAuthActivity socialOAuthActivity, String str, IBaiduListener iBaiduListener) {
        this.fjY = socialOAuthActivity;
        this.b = str;
        this.fjZ = iBaiduListener;
    }

    public av pz(String str) {
        switch (MediaType.fromString(str)) {
            case SINAWEIBO:
                return new as(this.fjY, this.b, this.fjZ);
            case QZONE:
                return new ar(this.fjY, this.b, this.fjZ);
            case FACEBOOK:
                return new FacebookAuthHandler(this.fjY, this.b, this.fjZ);
            case TWITTER:
                return new TwitterAuthHandler(this.fjY, this.b, this.fjZ);
            default:
                return new av(this.fjY, this.b, str, this.fjZ);
        }
    }
}
