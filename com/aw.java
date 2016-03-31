package com;

import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.oauth.FacebookAuthHandler;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import com.baidu.cloudsdk.social.oauth.TwitterAuthHandler;
/* loaded from: classes.dex */
public class aw {
    private String b;
    private SocialOAuthActivity eXR;
    private IBaiduListener eXS;

    public aw(SocialOAuthActivity socialOAuthActivity, String str, IBaiduListener iBaiduListener) {
        this.eXR = socialOAuthActivity;
        this.b = str;
        this.eXS = iBaiduListener;
    }

    public av pr(String str) {
        switch (MediaType.fromString(str)) {
            case SINAWEIBO:
                return new as(this.eXR, this.b, this.eXS);
            case QZONE:
                return new ar(this.eXR, this.b, this.eXS);
            case FACEBOOK:
                return new FacebookAuthHandler(this.eXR, this.b, this.eXS);
            case TWITTER:
                return new TwitterAuthHandler(this.eXR, this.b, this.eXS);
            default:
                return new av(this.eXR, this.b, str, this.eXS);
        }
    }
}
