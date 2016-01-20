package com;

import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.oauth.FacebookAuthHandler;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import com.baidu.cloudsdk.social.oauth.TwitterAuthHandler;
/* loaded from: classes.dex */
public class aw {
    private String b;
    private SocialOAuthActivity edD;
    private IBaiduListener edE;

    public aw(SocialOAuthActivity socialOAuthActivity, String str, IBaiduListener iBaiduListener) {
        this.edD = socialOAuthActivity;
        this.b = str;
        this.edE = iBaiduListener;
    }

    public av nC(String str) {
        switch (MediaType.fromString(str)) {
            case SINAWEIBO:
                return new as(this.edD, this.b, this.edE);
            case QZONE:
                return new ar(this.edD, this.b, this.edE);
            case FACEBOOK:
                return new FacebookAuthHandler(this.edD, this.b, this.edE);
            case TWITTER:
                return new TwitterAuthHandler(this.edD, this.b, this.edE);
            default:
                return new av(this.edD, this.b, str, this.edE);
        }
    }
}
