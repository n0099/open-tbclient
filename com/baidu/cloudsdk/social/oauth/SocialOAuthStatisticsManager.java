package com.baidu.cloudsdk.social.oauth;

import android.content.Context;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.core.SocialConfig;
import com.baidu.cloudsdk.social.core.WidgetStatisticsManager;
/* loaded from: classes.dex */
public class SocialOAuthStatisticsManager extends WidgetStatisticsManager {

    /* renamed from: a  reason: collision with root package name */
    private static SocialOAuthStatisticsManager f840a;

    private SocialOAuthStatisticsManager(Context context) {
        super(context, SocialConfig.getInstance(context).getClientId(MediaType.BAIDU));
    }

    public static SocialOAuthStatisticsManager getInstance(Context context) {
        if (f840a == null) {
            f840a = new SocialOAuthStatisticsManager(context);
        }
        return f840a;
    }

    @Override // com.baidu.cloudsdk.social.core.WidgetStatisticsManager
    protected String getWidgetName() {
        return "share";
    }

    @Override // com.baidu.cloudsdk.social.core.WidgetStatisticsManager
    protected String getWidgetVersion() {
        return "2.1.0";
    }

    @Override // com.baidu.cloudsdk.social.core.WidgetStatisticsManager
    protected String getWidgetVersionFlag() {
        return "i";
    }
}
