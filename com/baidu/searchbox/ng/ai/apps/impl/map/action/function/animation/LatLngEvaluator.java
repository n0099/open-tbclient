package com.baidu.searchbox.ng.ai.apps.impl.map.action.function.animation;

import android.animation.TypeEvaluator;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes4.dex */
public class LatLngEvaluator implements TypeEvaluator<LatLng> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    public LatLng evaluate(float f, LatLng latLng, LatLng latLng2) {
        return new LatLng(latLng.latitude + (f * (latLng2.latitude - latLng.latitude)), latLng.longitude + (f * (latLng2.longitude - latLng.longitude)));
    }
}
