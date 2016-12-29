package com;

import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.oauth.FacebookAuthHandler;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import com.baidu.cloudsdk.social.oauth.TwitterAuthHandler;
/* loaded from: classes.dex */
public class aw {
    private String b;
    private SocialOAuthActivity fIH;
    private IBaiduListener fII;

    public aw(SocialOAuthActivity socialOAuthActivity, String str, IBaiduListener iBaiduListener) {
        this.fIH = socialOAuthActivity;
        this.b = str;
        this.fII = iBaiduListener;
    }

    public av rA(String str) {
        switch (MediaType.fromString(str)) {
            case SINAWEIBO:
                return new as(this.fIH, this.b, this.fII);
            case QZONE:
                return new ar(this.fIH, this.b, this.fII);
            case FACEBOOK:
                return new FacebookAuthHandler(this.fIH, this.b, this.fII);
            case TWITTER:
                return new TwitterAuthHandler(this.fIH, this.b, this.fII);
            default:
                return new av(this.fIH, this.b, str, this.fII);
        }
    }
}
