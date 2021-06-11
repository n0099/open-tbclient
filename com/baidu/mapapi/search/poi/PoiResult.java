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
    public int f7282a;

    /* renamed from: b  reason: collision with root package name */
    public int f7283b;

    /* renamed from: c  reason: collision with root package name */
    public int f7284c;

    /* renamed from: d  reason: collision with root package name */
    public int f7285d;

    /* renamed from: e  reason: collision with root package name */
    public List<PoiInfo> f7286e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7287f;

    /* renamed from: g  reason: collision with root package name */
    public List<PoiAddrInfo> f7288g;

    /* renamed from: h  reason: collision with root package name */
    public List<CityInfo> f7289h;

    public PoiResult() {
        this.f7282a = 0;
        this.f7283b = 0;
        this.f7284c = 0;
        this.f7285d = 0;
        this.f7287f = false;
    }

    public PoiResult(Parcel parcel) {
        super(parcel);
        this.f7282a = 0;
        this.f7283b = 0;
        this.f7284c = 0;
        this.f7285d = 0;
        this.f7287f = false;
        this.f7282a = parcel.readInt();
        this.f7283b = parcel.readInt();
        this.f7284c = parcel.readInt();
        this.f7285d = parcel.readInt();
        this.f7286e = parcel.createTypedArrayList(PoiInfo.CREATOR);
        this.f7287f = parcel.readByte() != 0;
        this.f7289h = parcel.createTypedArrayList(CityInfo.CREATOR);
    }

    public PoiResult(SearchResult.ERRORNO errorno) {
        super(errorno);
        this.f7282a = 0;
        this.f7283b = 0;
        this.f7284c = 0;
        this.f7285d = 0;
        this.f7287f = false;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<PoiAddrInfo> getAllAddr() {
        return this.f7288g;
    }

    public List<PoiInfo> getAllPoi() {
        return this.f7286e;
    }

    public int getCurrentPageCapacity() {
        return this.f7284c;
    }

    public int getCurrentPageNum() {
        return this.f7282a;
    }

    public List<CityInfo> getSuggestCityList() {
        return this.f7289h;
    }

    public int getTotalPageNum() {
        return this.f7283b;
    }

    public int getTotalPoiNum() {
        return this.f7285d;
    }

    public boolean isHasAddrInfo() {
        return this.f7287f;
    }

    public void setAddrInfo(List<PoiAddrInfo> list) {
        this.f7288g = list;
    }

    public void setCurrentPageCapacity(int i2) {
        this.f7284c = i2;
    }

    public void setCurrentPageNum(int i2) {
        this.f7282a = i2;
    }

    public void setHasAddrInfo(boolean z) {
        this.f7287f = z;
    }

    public void setPoiInfo(List<PoiInfo> list) {
        this.f7286e = list;
    }

    public void setSuggestCityList(List<CityInfo> list) {
        this.f7289h = list;
    }

    public void setTotalPageNum(int i2) {
        this.f7283b = i2;
    }

    public void setTotalPoiNum(int i2) {
        this.f7285d = i2;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeInt(this.f7282a);
        parcel.writeInt(this.f7283b);
        parcel.writeInt(this.f7284c);
        parcel.writeInt(this.f7285d);
        parcel.writeTypedList(this.f7286e);
        parcel.writeByte(this.f7287f ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.f7289h);
    }
}
