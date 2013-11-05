package com.baidu.cloudsdk.social.share.handler;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.cloudsdk.common.util.Validator;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.core.SocialConfig;
import com.baidu.cloudsdk.social.share.SocialShare;
/* loaded from: classes.dex */
public class SocialShareHandlerFactory {

    /* renamed from: a  reason: collision with root package name */
    private Context f852a;
    private String b;
    private String c;
    private SocialShare.Theme d;

    public SocialShareHandlerFactory(Context context, String str, SocialShare.Theme theme) {
        Validator.notNull(context, "context");
        Validator.notNullOrEmpty(str, "clientId");
        this.f852a = context;
        this.b = str;
        this.c = SocialConfig.getInstance(context).getClientId(MediaType.WEIXIN);
        this.d = theme;
    }

    public ISocialShareHandler newInstance(String str) {
        MediaType fromString = MediaType.fromString(str);
        switch (fromString) {
            case WEIXIN:
                return new ap(this.f852a, this.d);
            case WEIXIN_FRIEND:
            case WEIXIN_TIMELINE:
                if (TextUtils.isEmpty(this.c)) {
                    throw new IllegalArgumentException("no client_id provided for weixin");
                }
                return new aq(this.f852a, this.c, fromString == MediaType.WEIXIN_TIMELINE);
            case QQFRIEND:
            case SMS:
            case EMAIL:
            case OTHERS:
                return new ai(this.f852a, str);
            case BATCHSHARE:
                return new CloudBatchShareHandler(this.f852a, this.b, null);
            case COPYLINK:
                return new ag(this.f852a);
            default:
                return new ae(this.f852a, this.b, fromString);
        }
    }
}
