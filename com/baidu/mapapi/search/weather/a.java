package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public final class a implements Parcelable.Creator<WeatherLifeIndexes> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public WeatherLifeIndexes createFromParcel(Parcel parcel) {
        return new WeatherLifeIndexes(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public WeatherLifeIndexes[] newArray(int i) {
        return new WeatherLifeIndexes[i];
    }
}
