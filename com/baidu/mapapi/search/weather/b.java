package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class b implements Parcelable.Creator<WeatherResult> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public WeatherResult createFromParcel(Parcel parcel) {
        return new WeatherResult(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public WeatherResult[] newArray(int i) {
        return new WeatherResult[i];
    }
}
