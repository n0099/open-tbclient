package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.CityInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;
/* loaded from: classes2.dex */
public class PoiResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<PoiResult> CREATOR = new f();

    /* renamed from: a  reason: collision with root package name */
    public int f7339a;

    /* renamed from: b  reason: collision with root package name */
    public int f7340b;

    /* renamed from: c  reason: collision with root package name */
    public int f7341c;

    /* renamed from: d  reason: collision with root package name */
    public int f7342d;

    /* renamed from: e  reason: collision with root package name */
    public List<PoiInfo> f7343e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7344f;

    /* renamed from: g  reason: collision with root package name */
    public List<PoiAddrInfo> f7345g;

    /* renamed from: h  reason: collision with root package name */
    public List<CityInfo> f7346h;

    public PoiResult() {
        this.f7339a = 0;
        this.f7340b = 0;
        this.f7341c = 0;
        this.f7342d = 0;
        this.f7344f = false;
    }

    public PoiResult(Parcel parcel) {
        super(parcel);
        this.f7339a = 0;
        this.f7340b = 0;
        this.f7341c = 0;
        this.f7342d = 0;
        this.f7344f = false;
        this.f7339a = parcel.readInt();
        this.f7340b = parcel.readInt();
        this.f7341c = parcel.readInt();
        this.f7342d = parcel.readInt();
        this.f7343e = parcel.createTypedArrayList(PoiInfo.CREATOR);
        this.f7344f = parcel.readByte() != 0;
        this.f7346h = parcel.createTypedArrayList(CityInfo.CREATOR);
    }

    public PoiResult(SearchResult.ERRORNO errorno) {
        super(errorno);
        this.f7339a = 0;
        this.f7340b = 0;
        this.f7341c = 0;
        this.f7342d = 0;
        this.f7344f = false;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<PoiAddrInfo> getAllAddr() {
        return this.f7345g;
    }

    public List<PoiInfo> getAllPoi() {
        return this.f7343e;
    }

    public int getCurrentPageCapacity() {
        return this.f7341c;
    }

    public int getCurrentPageNum() {
        return this.f7339a;
    }

    public List<CityInfo> getSuggestCityList() {
        return this.f7346h;
    }

    public int getTotalPageNum() {
        return this.f7340b;
    }

    public int getTotalPoiNum() {
        return this.f7342d;
    }

    public boolean isHasAddrInfo() {
        return this.f7344f;
    }

    public void setAddrInfo(List<PoiAddrInfo> list) {
        this.f7345g = list;
    }

    public void setCurrentPageCapacity(int i2) {
        this.f7341c = i2;
    }

    public void setCurrentPageNum(int i2) {
        this.f7339a = i2;
    }

    public void setHasAddrInfo(boolean z) {
        this.f7344f = z;
    }

    public void setPoiInfo(List<PoiInfo> list) {
        this.f7343e = list;
    }

    public void setSuggestCityList(List<CityInfo> list) {
        this.f7346h = list;
    }

    public void setTotalPageNum(int i2) {
        this.f7340b = i2;
    }

    public void setTotalPoiNum(int i2) {
        this.f7342d = i2;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeInt(this.f7339a);
        parcel.writeInt(this.f7340b);
        parcel.writeInt(this.f7341c);
        parcel.writeInt(this.f7342d);
        parcel.writeTypedList(this.f7343e);
        parcel.writeByte(this.f7344f ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.f7346h);
    }
}
