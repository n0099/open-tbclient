package com.baidu.cloudsdk.social.share.handler;

import com.af;
import com.ag;
import com.ai;
import com.aj;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.util.Validator;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.core.SocialConfig;
/* loaded from: classes.dex */
public class LocalShareHandlerFactory {
    private LocalShareActivity a;

    public LocalShareHandlerFactory(LocalShareActivity localShareActivity) {
        Validator.notNull(localShareActivity, "activity");
        this.a = localShareActivity;
    }

    public ag newInstance(String str, int i, IBaiduListener iBaiduListener) {
        SocialConfig socialConfig = SocialConfig.getInstance(this.a);
        switch (MediaType.fromString(str)) {
            case QQFRIEND:
                return new ai(this.a, iBaiduListener, i, socialConfig.getClientId(MediaType.QQFRIEND), socialConfig.getClientName(MediaType.QQFRIEND));
            case SMS:
                return new aj(this.a, iBaiduListener, i);
            case EMAIL:
                return new af(this.a, iBaiduListener, i);
            case OTHERS:
                return new OthersShareHandler(this.a, iBaiduListener, i);
            default:
                return null;
        }
    }
}
