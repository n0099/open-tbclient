package com.baidu.swan.impl.map.a.a.a;

import android.animation.TypeEvaluator;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes24.dex */
public class a implements TypeEvaluator<LatLng> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public LatLng evaluate(float f, LatLng latLng, LatLng latLng2) {
        return new LatLng(latLng.latitude + (f * (latLng2.latitude - latLng.latitude)), latLng.longitude + (f * (latLng2.longitude - latLng.longitude)));
    }
}
