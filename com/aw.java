package com;

import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.oauth.FacebookAuthHandler;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import com.baidu.cloudsdk.social.oauth.TwitterAuthHandler;
/* loaded from: classes.dex */
public class aw {
    private String b;
    private IBaiduListener djA;
    private SocialOAuthActivity djz;

    public aw(SocialOAuthActivity socialOAuthActivity, String str, IBaiduListener iBaiduListener) {
        this.djz = socialOAuthActivity;
        this.b = str;
        this.djA = iBaiduListener;
    }

    public av lS(String str) {
        switch (MediaType.fromString(str)) {
            case SINAWEIBO:
                return new as(this.djz, this.b, this.djA);
            case QZONE:
                return new ar(this.djz, this.b, this.djA);
            case FACEBOOK:
                return new FacebookAuthHandler(this.djz, this.b, this.djA);
            case TWITTER:
                return new TwitterAuthHandler(this.djz, this.b, this.djA);
            default:
                return new av(this.djz, this.b, str, this.djA);
        }
    }
}
