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
    public int f7230a;

    /* renamed from: b  reason: collision with root package name */
    public int f7231b;

    /* renamed from: c  reason: collision with root package name */
    public int f7232c;

    /* renamed from: d  reason: collision with root package name */
    public int f7233d;

    /* renamed from: e  reason: collision with root package name */
    public List<PoiInfo> f7234e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7235f;

    /* renamed from: g  reason: collision with root package name */
    public List<PoiAddrInfo> f7236g;

    /* renamed from: h  reason: collision with root package name */
    public List<CityInfo> f7237h;

    public PoiResult() {
        this.f7230a = 0;
        this.f7231b = 0;
        this.f7232c = 0;
        this.f7233d = 0;
        this.f7235f = false;
    }

    public PoiResult(Parcel parcel) {
        super(parcel);
        this.f7230a = 0;
        this.f7231b = 0;
        this.f7232c = 0;
        this.f7233d = 0;
        this.f7235f = false;
        this.f7230a = parcel.readInt();
        this.f7231b = parcel.readInt();
        this.f7232c = parcel.readInt();
        this.f7233d = parcel.readInt();
        this.f7234e = parcel.createTypedArrayList(PoiInfo.CREATOR);
        this.f7235f = parcel.readByte() != 0;
        this.f7237h = parcel.createTypedArrayList(CityInfo.CREATOR);
    }

    public PoiResult(SearchResult.ERRORNO errorno) {
        super(errorno);
        this.f7230a = 0;
        this.f7231b = 0;
        this.f7232c = 0;
        this.f7233d = 0;
        this.f7235f = false;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<PoiAddrInfo> getAllAddr() {
        return this.f7236g;
    }

    public List<PoiInfo> getAllPoi() {
        return this.f7234e;
    }

    public int getCurrentPageCapacity() {
        return this.f7232c;
    }

    public int getCurrentPageNum() {
        return this.f7230a;
    }

    public List<CityInfo> getSuggestCityList() {
        return this.f7237h;
    }

    public int getTotalPageNum() {
        return this.f7231b;
    }

    public int getTotalPoiNum() {
        return this.f7233d;
    }

    public boolean isHasAddrInfo() {
        return this.f7235f;
    }

    public void setAddrInfo(List<PoiAddrInfo> list) {
        this.f7236g = list;
    }

    public void setCurrentPageCapacity(int i) {
        this.f7232c = i;
    }

    public void setCurrentPageNum(int i) {
        this.f7230a = i;
    }

    public void setHasAddrInfo(boolean z) {
        this.f7235f = z;
    }

    public void setPoiInfo(List<PoiInfo> list) {
        this.f7234e = list;
    }

    public void setSuggestCityList(List<CityInfo> list) {
        this.f7237h = list;
    }

    public void setTotalPageNum(int i) {
        this.f7231b = i;
    }

    public void setTotalPoiNum(int i) {
        this.f7233d = i;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f7230a);
        parcel.writeInt(this.f7231b);
        parcel.writeInt(this.f7232c);
        parcel.writeInt(this.f7233d);
        parcel.writeTypedList(this.f7234e);
        parcel.writeByte(this.f7235f ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.f7237h);
    }
}
