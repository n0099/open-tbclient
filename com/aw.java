package com;

import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.oauth.FacebookAuthHandler;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import com.baidu.cloudsdk.social.oauth.TwitterAuthHandler;
/* loaded from: classes.dex */
public class aw {
    private String b;
    private SocialOAuthActivity dvU;
    private IBaiduListener dvV;

    public aw(SocialOAuthActivity socialOAuthActivity, String str, IBaiduListener iBaiduListener) {
        this.dvU = socialOAuthActivity;
        this.b = str;
        this.dvV = iBaiduListener;
    }

    public av mD(String str) {
        switch (MediaType.fromString(str)) {
            case SINAWEIBO:
                return new as(this.dvU, this.b, this.dvV);
            case QZONE:
                return new ar(this.dvU, this.b, this.dvV);
            case FACEBOOK:
                return new FacebookAuthHandler(this.dvU, this.b, this.dvV);
            case TWITTER:
                return new TwitterAuthHandler(this.dvU, this.b, this.dvV);
            default:
                return new av(this.dvU, this.b, str, this.dvV);
        }
    }
}
