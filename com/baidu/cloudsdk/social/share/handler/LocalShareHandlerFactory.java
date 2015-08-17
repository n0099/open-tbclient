package com.baidu.cloudsdk.social.share.handler;

import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.util.Validator;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.core.SocialConfig;
import com.bf;
import com.c;
import com.e;
import com.f;
import com.g;
/* loaded from: classes.dex */
public class LocalShareHandlerFactory {
    private LocalShareActivity a;

    public LocalShareHandlerFactory(LocalShareActivity localShareActivity) {
        Validator.notNull(localShareActivity, "activity");
        this.a = localShareActivity;
    }

    public c newInstance(String str, int i, IBaiduListener iBaiduListener) {
        SocialConfig socialConfig = SocialConfig.getInstance(this.a);
        switch (MediaType.fromString(str)) {
            case QQFRIEND:
                return new e(this.a, iBaiduListener, i, socialConfig.getClientId(MediaType.QQFRIEND), socialConfig.getClientName(MediaType.QQFRIEND));
            case QZONE:
                return new f(this.a, iBaiduListener, i, socialConfig.getClientId(MediaType.QQFRIEND), socialConfig.getClientName(MediaType.QQFRIEND));
            case SMS:
                return new g(this.a, iBaiduListener, i);
            case EMAIL:
                return new bf(this.a, iBaiduListener, i);
            case OTHERS:
                return new OthersShareHandler(this.a, iBaiduListener, i);
            default:
                return null;
        }
    }
}
