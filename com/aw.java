package com;

import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.oauth.FacebookAuthHandler;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import com.baidu.cloudsdk.social.oauth.TwitterAuthHandler;
/* loaded from: classes.dex */
public class aw {
    private String b;
    private SocialOAuthActivity eDY;
    private IBaiduListener eDZ;

    public aw(SocialOAuthActivity socialOAuthActivity, String str, IBaiduListener iBaiduListener) {
        this.eDY = socialOAuthActivity;
        this.b = str;
        this.eDZ = iBaiduListener;
    }

    public av ob(String str) {
        switch (MediaType.fromString(str)) {
            case SINAWEIBO:
                return new as(this.eDY, this.b, this.eDZ);
            case QZONE:
                return new ar(this.eDY, this.b, this.eDZ);
            case FACEBOOK:
                return new FacebookAuthHandler(this.eDY, this.b, this.eDZ);
            case TWITTER:
                return new TwitterAuthHandler(this.eDY, this.b, this.eDZ);
            default:
                return new av(this.eDY, this.b, str, this.eDZ);
        }
    }
}
