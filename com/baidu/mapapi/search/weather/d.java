package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class d implements Parcelable.Creator<WeatherSearchForecastForHours> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public WeatherSearchForecastForHours createFromParcel(Parcel parcel) {
        return new WeatherSearchForecastForHours(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public WeatherSearchForecastForHours[] newArray(int i) {
        return new WeatherSearchForecastForHours[i];
    }
}
