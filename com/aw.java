package com;

import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.oauth.FacebookAuthHandler;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import com.baidu.cloudsdk.social.oauth.TwitterAuthHandler;
/* loaded from: classes.dex */
public class aw {
    private String b;
    private SocialOAuthActivity dax;
    private IBaiduListener daz;

    public aw(SocialOAuthActivity socialOAuthActivity, String str, IBaiduListener iBaiduListener) {
        this.dax = socialOAuthActivity;
        this.b = str;
        this.daz = iBaiduListener;
    }

    public av lk(String str) {
        switch (MediaType.fromString(str)) {
            case SINAWEIBO:
                return new as(this.dax, this.b, this.daz);
            case QZONE:
                return new ar(this.dax, this.b, this.daz);
            case FACEBOOK:
                return new FacebookAuthHandler(this.dax, this.b, this.daz);
            case TWITTER:
                return new TwitterAuthHandler(this.dax, this.b, this.daz);
            default:
                return new av(this.dax, this.b, str, this.daz);
        }
    }
}
