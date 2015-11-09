package com;

import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.oauth.FacebookAuthHandler;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import com.baidu.cloudsdk.social.oauth.TwitterAuthHandler;
/* loaded from: classes.dex */
public class aw {
    private String b;
    private SocialOAuthActivity dxN;
    private IBaiduListener dxO;

    public aw(SocialOAuthActivity socialOAuthActivity, String str, IBaiduListener iBaiduListener) {
        this.dxN = socialOAuthActivity;
        this.b = str;
        this.dxO = iBaiduListener;
    }

    public av mH(String str) {
        switch (MediaType.fromString(str)) {
            case SINAWEIBO:
                return new as(this.dxN, this.b, this.dxO);
            case QZONE:
                return new ar(this.dxN, this.b, this.dxO);
            case FACEBOOK:
                return new FacebookAuthHandler(this.dxN, this.b, this.dxO);
            case TWITTER:
                return new TwitterAuthHandler(this.dxN, this.b, this.dxO);
            default:
                return new av(this.dxN, this.b, str, this.dxO);
        }
    }
}
