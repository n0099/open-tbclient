package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class g implements Parcelable.Creator<WeatherSearchRealTime> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public WeatherSearchRealTime createFromParcel(Parcel parcel) {
        return new WeatherSearchRealTime(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public WeatherSearchRealTime[] newArray(int i) {
        return new WeatherSearchRealTime[i];
    }
}
