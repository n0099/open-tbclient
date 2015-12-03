package com;

import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.oauth.FacebookAuthHandler;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import com.baidu.cloudsdk.social.oauth.TwitterAuthHandler;
/* loaded from: classes.dex */
public class aw {
    private String b;
    private SocialOAuthActivity dWf;
    private IBaiduListener dWg;

    public aw(SocialOAuthActivity socialOAuthActivity, String str, IBaiduListener iBaiduListener) {
        this.dWf = socialOAuthActivity;
        this.b = str;
        this.dWg = iBaiduListener;
    }

    public av nD(String str) {
        switch (MediaType.fromString(str)) {
            case SINAWEIBO:
                return new as(this.dWf, this.b, this.dWg);
            case QZONE:
                return new ar(this.dWf, this.b, this.dWg);
            case FACEBOOK:
                return new FacebookAuthHandler(this.dWf, this.b, this.dWg);
            case TWITTER:
                return new TwitterAuthHandler(this.dWf, this.b, this.dWg);
            default:
                return new av(this.dWf, this.b, str, this.dWg);
        }
    }
}
