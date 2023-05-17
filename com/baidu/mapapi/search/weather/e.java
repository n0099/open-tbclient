package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public final class e implements Parcelable.Creator<WeatherSearchForecasts> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public WeatherSearchForecasts createFromParcel(Parcel parcel) {
        return new WeatherSearchForecasts(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public WeatherSearchForecasts[] newArray(int i) {
        return new WeatherSearchForecasts[i];
    }
}
