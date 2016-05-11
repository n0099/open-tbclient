package com;

import com.baidu.cloudsdk.common.http.HttpResponseHandler;
import com.baidu.cloudsdk.social.core.WidgetPreferenceManager;
import com.baidu.cloudsdk.social.core.WidgetStatisticsManager;
/* loaded from: classes.dex */
public class aq extends HttpResponseHandler {
    final /* synthetic */ String b;
    final /* synthetic */ WidgetPreferenceManager fjU;
    final /* synthetic */ WidgetStatisticsManager fjV;

    public aq(WidgetStatisticsManager widgetStatisticsManager, WidgetPreferenceManager widgetPreferenceManager, String str) {
        this.fjV = widgetStatisticsManager;
        this.fjU = widgetPreferenceManager;
        this.b = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
    public void onSuccess(int i, String str) {
        this.fjU.setWidgetActivated(this.b);
    }
}
