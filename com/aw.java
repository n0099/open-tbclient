package com;

import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.oauth.FacebookAuthHandler;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import com.baidu.cloudsdk.social.oauth.TwitterAuthHandler;
/* loaded from: classes.dex */
public class aw {
    private String b;
    private SocialOAuthActivity fjX;
    private IBaiduListener fjY;

    public aw(SocialOAuthActivity socialOAuthActivity, String str, IBaiduListener iBaiduListener) {
        this.fjX = socialOAuthActivity;
        this.b = str;
        this.fjY = iBaiduListener;
    }

    public av pz(String str) {
        switch (MediaType.fromString(str)) {
            case SINAWEIBO:
                return new as(this.fjX, this.b, this.fjY);
            case QZONE:
                return new ar(this.fjX, this.b, this.fjY);
            case FACEBOOK:
                return new FacebookAuthHandler(this.fjX, this.b, this.fjY);
            case TWITTER:
                return new TwitterAuthHandler(this.fjX, this.b, this.fjY);
            default:
                return new av(this.fjX, this.b, str, this.fjY);
        }
    }
}
