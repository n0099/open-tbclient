package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;
/* loaded from: classes3.dex */
public class WeatherResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<WeatherResult> CREATOR = new b();
    public WeatherSearchRealTime a;
    public WeatherSearchLocation b;
    public List<WeatherSearchForecasts> c;
    public List<WeatherSearchForecastForHours> d;
    public List<WeatherLifeIndexes> e;
    public List<WeatherSearchAlerts> f;

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public WeatherResult() {
    }

    public List<WeatherSearchForecastForHours> getForecastHours() {
        return this.d;
    }

    public List<WeatherSearchForecasts> getForecasts() {
        return this.c;
    }

    public List<WeatherLifeIndexes> getLifeIndexes() {
        return this.e;
    }

    public WeatherSearchLocation getLocation() {
        return this.b;
    }

    public WeatherSearchRealTime getRealTimeWeather() {
        return this.a;
    }

    public List<WeatherSearchAlerts> getWeatherAlerts() {
        return this.f;
    }

    public WeatherResult(Parcel parcel) {
        super(parcel);
        this.a = (WeatherSearchRealTime) parcel.readParcelable(WeatherSearchRealTime.class.getClassLoader());
        this.b = (WeatherSearchLocation) parcel.readParcelable(WeatherSearchLocation.class.getClassLoader());
        this.c = parcel.createTypedArrayList(WeatherSearchForecasts.CREATOR);
        this.d = parcel.createTypedArrayList(WeatherSearchForecastForHours.CREATOR);
        this.e = parcel.createTypedArrayList(WeatherLifeIndexes.CREATOR);
        this.f = parcel.createTypedArrayList(WeatherSearchAlerts.CREATOR);
    }

    public void setForecastHours(List<WeatherSearchForecastForHours> list) {
        this.d = list;
    }

    public void setForecasts(List<WeatherSearchForecasts> list) {
        this.c = list;
    }

    public void setLifeIndexes(List<WeatherLifeIndexes> list) {
        this.e = list;
    }

    public void setLocation(WeatherSearchLocation weatherSearchLocation) {
        this.b = weatherSearchLocation;
    }

    public void setRealTimeWeather(WeatherSearchRealTime weatherSearchRealTime) {
        this.a = weatherSearchRealTime;
    }

    public void setWeatherAlerts(List<WeatherSearchAlerts> list) {
        this.f = list;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.a, i);
        parcel.writeParcelable(this.b, i);
        parcel.writeTypedList(this.c);
        parcel.writeTypedList(this.d);
        parcel.writeTypedList(this.e);
        parcel.writeTypedList(this.f);
    }
}
