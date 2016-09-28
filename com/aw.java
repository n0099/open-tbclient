package com;

import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.oauth.FacebookAuthHandler;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import com.baidu.cloudsdk.social.oauth.TwitterAuthHandler;
/* loaded from: classes.dex */
public class aw {
    private String b;
    private SocialOAuthActivity goa;
    private IBaiduListener gob;

    public aw(SocialOAuthActivity socialOAuthActivity, String str, IBaiduListener iBaiduListener) {
        this.goa = socialOAuthActivity;
        this.b = str;
        this.gob = iBaiduListener;
    }

    public av sS(String str) {
        switch (MediaType.fromString(str)) {
            case SINAWEIBO:
                return new as(this.goa, this.b, this.gob);
            case QZONE:
                return new ar(this.goa, this.b, this.gob);
            case FACEBOOK:
                return new FacebookAuthHandler(this.goa, this.b, this.gob);
            case TWITTER:
                return new TwitterAuthHandler(this.goa, this.b, this.gob);
            default:
                return new av(this.goa, this.b, str, this.gob);
        }
    }
}
