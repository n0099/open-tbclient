package com;

import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.oauth.FacebookAuthHandler;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import com.baidu.cloudsdk.social.oauth.TwitterAuthHandler;
/* loaded from: classes.dex */
public class aw {
    private String b;
    private SocialOAuthActivity fRa;
    private IBaiduListener fRb;

    public aw(SocialOAuthActivity socialOAuthActivity, String str, IBaiduListener iBaiduListener) {
        this.fRa = socialOAuthActivity;
        this.b = str;
        this.fRb = iBaiduListener;
    }

    public av rT(String str) {
        switch (MediaType.fromString(str)) {
            case SINAWEIBO:
                return new as(this.fRa, this.b, this.fRb);
            case QZONE:
                return new ar(this.fRa, this.b, this.fRb);
            case FACEBOOK:
                return new FacebookAuthHandler(this.fRa, this.b, this.fRb);
            case TWITTER:
                return new TwitterAuthHandler(this.fRa, this.b, this.fRb);
            default:
                return new av(this.fRa, this.b, str, this.fRb);
        }
    }
}
