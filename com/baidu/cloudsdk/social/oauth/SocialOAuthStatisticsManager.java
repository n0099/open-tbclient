package com.baidu.cloudsdk.social.oauth;

import android.content.Context;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.core.SocialConfig;
import com.baidu.cloudsdk.social.core.WidgetStatisticsManager;
/* loaded from: classes.dex */
public class SocialOAuthStatisticsManager extends WidgetStatisticsManager {
    public SocialOAuthStatisticsManager(Context context) {
        super(context, SocialConfig.getInstance(context).getClientId(MediaType.BAIDU));
    }
}
