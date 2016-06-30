package com;

import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.oauth.FacebookAuthHandler;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import com.baidu.cloudsdk.social.oauth.TwitterAuthHandler;
/* loaded from: classes.dex */
public class aw {
    private String b;
    private SocialOAuthActivity fPW;
    private IBaiduListener fPX;

    public aw(SocialOAuthActivity socialOAuthActivity, String str, IBaiduListener iBaiduListener) {
        this.fPW = socialOAuthActivity;
        this.b = str;
        this.fPX = iBaiduListener;
    }

    public av rk(String str) {
        switch (MediaType.fromString(str)) {
            case SINAWEIBO:
                return new as(this.fPW, this.b, this.fPX);
            case QZONE:
                return new ar(this.fPW, this.b, this.fPX);
            case FACEBOOK:
                return new FacebookAuthHandler(this.fPW, this.b, this.fPX);
            case TWITTER:
                return new TwitterAuthHandler(this.fPW, this.b, this.fPX);
            default:
                return new av(this.fPW, this.b, str, this.fPX);
        }
    }
}
