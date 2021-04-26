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
    public int f7522a;

    /* renamed from: b  reason: collision with root package name */
    public int f7523b;

    /* renamed from: c  reason: collision with root package name */
    public int f7524c;

    /* renamed from: d  reason: collision with root package name */
    public int f7525d;

    /* renamed from: e  reason: collision with root package name */
    public List<PoiInfo> f7526e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7527f;

    /* renamed from: g  reason: collision with root package name */
    public List<PoiAddrInfo> f7528g;

    /* renamed from: h  reason: collision with root package name */
    public List<CityInfo> f7529h;

    public PoiResult() {
        this.f7522a = 0;
        this.f7523b = 0;
        this.f7524c = 0;
        this.f7525d = 0;
        this.f7527f = false;
    }

    public PoiResult(Parcel parcel) {
        super(parcel);
        this.f7522a = 0;
        this.f7523b = 0;
        this.f7524c = 0;
        this.f7525d = 0;
        this.f7527f = false;
        this.f7522a = parcel.readInt();
        this.f7523b = parcel.readInt();
        this.f7524c = parcel.readInt();
        this.f7525d = parcel.readInt();
        this.f7526e = parcel.createTypedArrayList(PoiInfo.CREATOR);
        this.f7527f = parcel.readByte() != 0;
        this.f7529h = parcel.createTypedArrayList(CityInfo.CREATOR);
    }

    public PoiResult(SearchResult.ERRORNO errorno) {
        super(errorno);
        this.f7522a = 0;
        this.f7523b = 0;
        this.f7524c = 0;
        this.f7525d = 0;
        this.f7527f = false;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<PoiAddrInfo> getAllAddr() {
        return this.f7528g;
    }

    public List<PoiInfo> getAllPoi() {
        return this.f7526e;
    }

    public int getCurrentPageCapacity() {
        return this.f7524c;
    }

    public int getCurrentPageNum() {
        return this.f7522a;
    }

    public List<CityInfo> getSuggestCityList() {
        return this.f7529h;
    }

    public int getTotalPageNum() {
        return this.f7523b;
    }

    public int getTotalPoiNum() {
        return this.f7525d;
    }

    public boolean isHasAddrInfo() {
        return this.f7527f;
    }

    public void setAddrInfo(List<PoiAddrInfo> list) {
        this.f7528g = list;
    }

    public void setCurrentPageCapacity(int i2) {
        this.f7524c = i2;
    }

    public void setCurrentPageNum(int i2) {
        this.f7522a = i2;
    }

    public void setHasAddrInfo(boolean z) {
        this.f7527f = z;
    }

    public void setPoiInfo(List<PoiInfo> list) {
        this.f7526e = list;
    }

    public void setSuggestCityList(List<CityInfo> list) {
        this.f7529h = list;
    }

    public void setTotalPageNum(int i2) {
        this.f7523b = i2;
    }

    public void setTotalPoiNum(int i2) {
        this.f7525d = i2;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeInt(this.f7522a);
        parcel.writeInt(this.f7523b);
        parcel.writeInt(this.f7524c);
        parcel.writeInt(this.f7525d);
        parcel.writeTypedList(this.f7526e);
        parcel.writeByte(this.f7527f ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.f7529h);
    }
}
