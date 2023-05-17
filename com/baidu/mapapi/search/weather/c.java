package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public final class c implements Parcelable.Creator<WeatherSearchAlerts> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public WeatherSearchAlerts createFromParcel(Parcel parcel) {
        return new WeatherSearchAlerts(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public WeatherSearchAlerts[] newArray(int i) {
        return new WeatherSearchAlerts[i];
    }
}
