package com;

import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.oauth.FacebookAuthHandler;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import com.baidu.cloudsdk.social.oauth.TwitterAuthHandler;
/* loaded from: classes.dex */
public class aw {
    private String b;
    private SocialOAuthActivity gdE;
    private IBaiduListener gdF;

    public aw(SocialOAuthActivity socialOAuthActivity, String str, IBaiduListener iBaiduListener) {
        this.gdE = socialOAuthActivity;
        this.b = str;
        this.gdF = iBaiduListener;
    }

    public av sd(String str) {
        switch (MediaType.fromString(str)) {
            case SINAWEIBO:
                return new as(this.gdE, this.b, this.gdF);
            case QZONE:
                return new ar(this.gdE, this.b, this.gdF);
            case FACEBOOK:
                return new FacebookAuthHandler(this.gdE, this.b, this.gdF);
            case TWITTER:
                return new TwitterAuthHandler(this.gdE, this.b, this.gdF);
            default:
                return new av(this.gdE, this.b, str, this.gdF);
        }
    }
}
