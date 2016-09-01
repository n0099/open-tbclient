package com;

import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.oauth.FacebookAuthHandler;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import com.baidu.cloudsdk.social.oauth.TwitterAuthHandler;
/* loaded from: classes.dex */
public class aw {
    private String b;
    private SocialOAuthActivity glP;
    private IBaiduListener glQ;

    public aw(SocialOAuthActivity socialOAuthActivity, String str, IBaiduListener iBaiduListener) {
        this.glP = socialOAuthActivity;
        this.b = str;
        this.glQ = iBaiduListener;
    }

    public av sD(String str) {
        switch (MediaType.fromString(str)) {
            case SINAWEIBO:
                return new as(this.glP, this.b, this.glQ);
            case QZONE:
                return new ar(this.glP, this.b, this.glQ);
            case FACEBOOK:
                return new FacebookAuthHandler(this.glP, this.b, this.glQ);
            case TWITTER:
                return new TwitterAuthHandler(this.glP, this.b, this.glQ);
            default:
                return new av(this.glP, this.b, str, this.glQ);
        }
    }
}
