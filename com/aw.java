package com;

import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.oauth.FacebookAuthHandler;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import com.baidu.cloudsdk.social.oauth.TwitterAuthHandler;
/* loaded from: classes.dex */
public class aw {
    private String b;
    private SocialOAuthActivity dvV;
    private IBaiduListener dvW;

    public aw(SocialOAuthActivity socialOAuthActivity, String str, IBaiduListener iBaiduListener) {
        this.dvV = socialOAuthActivity;
        this.b = str;
        this.dvW = iBaiduListener;
    }

    public av mD(String str) {
        switch (MediaType.fromString(str)) {
            case SINAWEIBO:
                return new as(this.dvV, this.b, this.dvW);
            case QZONE:
                return new ar(this.dvV, this.b, this.dvW);
            case FACEBOOK:
                return new FacebookAuthHandler(this.dvV, this.b, this.dvW);
            case TWITTER:
                return new TwitterAuthHandler(this.dvV, this.b, this.dvW);
            default:
                return new av(this.dvV, this.b, str, this.dvW);
        }
    }
}
