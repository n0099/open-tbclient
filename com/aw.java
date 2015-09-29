package com;

import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.oauth.FacebookAuthHandler;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import com.baidu.cloudsdk.social.oauth.TwitterAuthHandler;
/* loaded from: classes.dex */
public class aw {
    private String b;
    private SocialOAuthActivity dvu;
    private IBaiduListener dvv;

    public aw(SocialOAuthActivity socialOAuthActivity, String str, IBaiduListener iBaiduListener) {
        this.dvu = socialOAuthActivity;
        this.b = str;
        this.dvv = iBaiduListener;
    }

    public av mA(String str) {
        switch (MediaType.fromString(str)) {
            case SINAWEIBO:
                return new as(this.dvu, this.b, this.dvv);
            case QZONE:
                return new ar(this.dvu, this.b, this.dvv);
            case FACEBOOK:
                return new FacebookAuthHandler(this.dvu, this.b, this.dvv);
            case TWITTER:
                return new TwitterAuthHandler(this.dvu, this.b, this.dvv);
            default:
                return new av(this.dvu, this.b, str, this.dvv);
        }
    }
}
