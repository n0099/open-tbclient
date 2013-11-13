package com.baidu.cloudsdk.social.share.handler;

import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.util.Validator;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.core.SocialConfig;
/* loaded from: classes.dex */
public class LocalShareHandlerFactory {

    /* renamed from: a  reason: collision with root package name */
    private LocalShareActivity f862a;

    public LocalShareHandlerFactory(LocalShareActivity localShareActivity) {
        Validator.notNull(localShareActivity, "activity");
        this.f862a = localShareActivity;
    }

    public ai newInstance(String str, int i, IBaiduListener iBaiduListener) {
        SocialConfig socialConfig = SocialConfig.getInstance(this.f862a);
        switch (MediaType.fromString(str)) {
            case QQFRIEND:
                return new ak(this.f862a, iBaiduListener, i, socialConfig.getClientId(MediaType.QQFRIEND), socialConfig.getClientName(MediaType.QQFRIEND));
            case SMS:
                return new al(this.f862a, iBaiduListener, i);
            case EMAIL:
                return new ah(this.f862a, iBaiduListener, i);
            case OTHERS:
                return new OthersShareHandler(this.f862a, iBaiduListener, i);
            default:
                return null;
        }
    }
}
