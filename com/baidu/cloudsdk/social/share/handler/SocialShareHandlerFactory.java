package com.baidu.cloudsdk.social.share.handler;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.cloudsdk.common.util.Validator;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.core.SocialConfig;
import com.baidu.cloudsdk.social.share.SocialShare;
import com.bb;
import com.be;
import com.c;
import com.m;
import com.n;
/* loaded from: classes.dex */
public class SocialShareHandlerFactory {
    private Context a;
    private String b;
    private String c;
    private String d;
    private SocialShare.Theme e;

    public SocialShareHandlerFactory(Context context, String str, SocialShare.Theme theme) {
        Validator.notNull(context, "context");
        Validator.notNullOrEmpty(str, "clientId");
        this.a = context;
        this.b = str;
        this.c = SocialConfig.getInstance(context).getClientId(MediaType.WEIXIN);
        this.d = SocialConfig.getInstance(context).getClientId(MediaType.FACEBOOK);
        this.e = theme;
    }

    public ISocialShareHandler newInstance(String str) {
        MediaType fromString = MediaType.fromString(str);
        switch (fromString) {
            case WEIXIN:
                return new m(this.a, this.e);
            case WEIXIN_FRIEND:
            case WEIXIN_TIMELINE:
                if (TextUtils.isEmpty(this.c)) {
                    throw new IllegalArgumentException("no client_id provided for weixin");
                }
                return new n(this.a, this.c, fromString == MediaType.WEIXIN_TIMELINE);
            case QZONE:
            case QQFRIEND:
            case SMS:
            case EMAIL:
            case OTHERS:
                return new c(this.a, str);
            case BATCHSHARE:
                return new CloudBatchShareHandler(this.a, this.b, null);
            case COPYLINK:
                return new be(this.a);
            case FACEBOOK:
                return new FacebookShareHandler(this.a, this.d, true);
            case TWITTER:
                return new TwitterShareHandler(this.a, this.b, true);
            default:
                return new bb(this.a, this.b, fromString);
        }
    }
}
