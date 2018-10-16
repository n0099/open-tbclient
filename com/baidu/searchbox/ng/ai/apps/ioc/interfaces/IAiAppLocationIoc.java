package com.baidu.searchbox.ng.ai.apps.ioc.interfaces;

import android.content.Context;
import android.support.annotation.Nullable;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.location.LocationResult;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.recommend.model.AiAppsLocationInfo;
import rx.d;
/* loaded from: classes2.dex */
public interface IAiAppLocationIoc {

    /* loaded from: classes2.dex */
    public interface LocationListener {
        void onFailed(int i);

        void onSuccess(LocationResult locationResult);
    }

    @Nullable
    d<AiAppsLocationInfo> getLocationInfo(Context context);

    void preInitLocation();

    void requestLocation(String str, boolean z, boolean z2, LocationListener locationListener);
}
