package com.baidu.mobads.sdk.api;

import android.view.View;
import java.util.List;
/* loaded from: classes3.dex */
public interface IBasicCPUAggregation {

    /* loaded from: classes3.dex */
    public interface ICpuHotNativeStatus {
        void onNotifyPerformance(String str);
    }

    String getContentId();

    List<String> getImagesList();

    String getLongTitle();

    String getShortTitle();

    String getTitle();

    void registerViewForInteraction(View view2, List<View> list, ICpuHotNativeStatus iCpuHotNativeStatus);
}
