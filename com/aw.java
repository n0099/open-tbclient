package com;

import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.oauth.FacebookAuthHandler;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import com.baidu.cloudsdk.social.oauth.TwitterAuthHandler;
/* loaded from: classes.dex */
public class aw {
    private String b;
    private SocialOAuthActivity gvM;
    private IBaiduListener gvN;

    public aw(SocialOAuthActivity socialOAuthActivity, String str, IBaiduListener iBaiduListener) {
        this.gvM = socialOAuthActivity;
        this.b = str;
        this.gvN = iBaiduListener;
    }

    public av tp(String str) {
        switch (MediaType.fromString(str)) {
            case SINAWEIBO:
                return new as(this.gvM, this.b, this.gvN);
            case QZONE:
                return new ar(this.gvM, this.b, this.gvN);
            case FACEBOOK:
                return new FacebookAuthHandler(this.gvM, this.b, this.gvN);
            case TWITTER:
                return new TwitterAuthHandler(this.gvM, this.b, this.gvN);
            default:
                return new av(this.gvM, this.b, str, this.gvN);
        }
    }
}
