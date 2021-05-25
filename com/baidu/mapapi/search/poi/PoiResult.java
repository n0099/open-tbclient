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
    public int f7239a;

    /* renamed from: b  reason: collision with root package name */
    public int f7240b;

    /* renamed from: c  reason: collision with root package name */
    public int f7241c;

    /* renamed from: d  reason: collision with root package name */
    public int f7242d;

    /* renamed from: e  reason: collision with root package name */
    public List<PoiInfo> f7243e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7244f;

    /* renamed from: g  reason: collision with root package name */
    public List<PoiAddrInfo> f7245g;

    /* renamed from: h  reason: collision with root package name */
    public List<CityInfo> f7246h;

    public PoiResult() {
        this.f7239a = 0;
        this.f7240b = 0;
        this.f7241c = 0;
        this.f7242d = 0;
        this.f7244f = false;
    }

    public PoiResult(Parcel parcel) {
        super(parcel);
        this.f7239a = 0;
        this.f7240b = 0;
        this.f7241c = 0;
        this.f7242d = 0;
        this.f7244f = false;
        this.f7239a = parcel.readInt();
        this.f7240b = parcel.readInt();
        this.f7241c = parcel.readInt();
        this.f7242d = parcel.readInt();
        this.f7243e = parcel.createTypedArrayList(PoiInfo.CREATOR);
        this.f7244f = parcel.readByte() != 0;
        this.f7246h = parcel.createTypedArrayList(CityInfo.CREATOR);
    }

    public PoiResult(SearchResult.ERRORNO errorno) {
        super(errorno);
        this.f7239a = 0;
        this.f7240b = 0;
        this.f7241c = 0;
        this.f7242d = 0;
        this.f7244f = false;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<PoiAddrInfo> getAllAddr() {
        return this.f7245g;
    }

    public List<PoiInfo> getAllPoi() {
        return this.f7243e;
    }

    public int getCurrentPageCapacity() {
        return this.f7241c;
    }

    public int getCurrentPageNum() {
        return this.f7239a;
    }

    public List<CityInfo> getSuggestCityList() {
        return this.f7246h;
    }

    public int getTotalPageNum() {
        return this.f7240b;
    }

    public int getTotalPoiNum() {
        return this.f7242d;
    }

    public boolean isHasAddrInfo() {
        return this.f7244f;
    }

    public void setAddrInfo(List<PoiAddrInfo> list) {
        this.f7245g = list;
    }

    public void setCurrentPageCapacity(int i2) {
        this.f7241c = i2;
    }

    public void setCurrentPageNum(int i2) {
        this.f7239a = i2;
    }

    public void setHasAddrInfo(boolean z) {
        this.f7244f = z;
    }

    public void setPoiInfo(List<PoiInfo> list) {
        this.f7243e = list;
    }

    public void setSuggestCityList(List<CityInfo> list) {
        this.f7246h = list;
    }

    public void setTotalPageNum(int i2) {
        this.f7240b = i2;
    }

    public void setTotalPoiNum(int i2) {
        this.f7242d = i2;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeInt(this.f7239a);
        parcel.writeInt(this.f7240b);
        parcel.writeInt(this.f7241c);
        parcel.writeInt(this.f7242d);
        parcel.writeTypedList(this.f7243e);
        parcel.writeByte(this.f7244f ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.f7246h);
    }
}
