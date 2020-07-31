package com.baidu.mapapi.bikenavi.adapter;

import android.graphics.drawable.Drawable;
import com.baidu.mapapi.bikenavi.model.BikeRouteDetailInfo;
import com.baidu.mapapi.walknavi.model.RouteGuideKind;
/* loaded from: classes10.dex */
public interface IBRouteGuidanceListener {
    void onArriveDest();

    void onGetRouteDetailInfo(BikeRouteDetailInfo bikeRouteDetailInfo);

    void onGpsStatusChange(CharSequence charSequence, Drawable drawable);

    void onReRouteComplete();

    void onRemainDistanceUpdate(CharSequence charSequence);

    void onRemainTimeUpdate(CharSequence charSequence);

    void onRoadGuideTextUpdate(CharSequence charSequence, CharSequence charSequence2);

    void onRouteFarAway(CharSequence charSequence, Drawable drawable);

    void onRouteGuideIconUpdate(Drawable drawable);

    void onRouteGuideKind(RouteGuideKind routeGuideKind);

    void onRoutePlanYawing(CharSequence charSequence, Drawable drawable);

    void onVibrate();
}
