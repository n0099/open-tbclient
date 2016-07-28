package com;

import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.oauth.FacebookAuthHandler;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import com.baidu.cloudsdk.social.oauth.TwitterAuthHandler;
/* loaded from: classes.dex */
public class aw {
    private String b;
    private SocialOAuthActivity gbJ;
    private IBaiduListener gbK;

    public aw(SocialOAuthActivity socialOAuthActivity, String str, IBaiduListener iBaiduListener) {
        this.gbJ = socialOAuthActivity;
        this.b = str;
        this.gbK = iBaiduListener;
    }

    public av rT(String str) {
        switch (MediaType.fromString(str)) {
            case SINAWEIBO:
                return new as(this.gbJ, this.b, this.gbK);
            case QZONE:
                return new ar(this.gbJ, this.b, this.gbK);
            case FACEBOOK:
                return new FacebookAuthHandler(this.gbJ, this.b, this.gbK);
            case TWITTER:
                return new TwitterAuthHandler(this.gbJ, this.b, this.gbK);
            default:
                return new av(this.gbJ, this.b, str, this.gbK);
        }
    }
}
