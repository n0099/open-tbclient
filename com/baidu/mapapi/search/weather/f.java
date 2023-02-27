package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class f implements Parcelable.Creator<WeatherSearchLocation> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public WeatherSearchLocation createFromParcel(Parcel parcel) {
        return new WeatherSearchLocation(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public WeatherSearchLocation[] newArray(int i) {
        return new WeatherSearchLocation[i];
    }
}
