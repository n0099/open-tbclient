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
    public int f7266a;

    /* renamed from: b  reason: collision with root package name */
    public int f7267b;

    /* renamed from: c  reason: collision with root package name */
    public int f7268c;

    /* renamed from: d  reason: collision with root package name */
    public int f7269d;

    /* renamed from: e  reason: collision with root package name */
    public List<PoiInfo> f7270e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7271f;

    /* renamed from: g  reason: collision with root package name */
    public List<PoiAddrInfo> f7272g;

    /* renamed from: h  reason: collision with root package name */
    public List<CityInfo> f7273h;

    public PoiResult() {
        this.f7266a = 0;
        this.f7267b = 0;
        this.f7268c = 0;
        this.f7269d = 0;
        this.f7271f = false;
    }

    public PoiResult(Parcel parcel) {
        super(parcel);
        this.f7266a = 0;
        this.f7267b = 0;
        this.f7268c = 0;
        this.f7269d = 0;
        this.f7271f = false;
        this.f7266a = parcel.readInt();
        this.f7267b = parcel.readInt();
        this.f7268c = parcel.readInt();
        this.f7269d = parcel.readInt();
        this.f7270e = parcel.createTypedArrayList(PoiInfo.CREATOR);
        this.f7271f = parcel.readByte() != 0;
        this.f7273h = parcel.createTypedArrayList(CityInfo.CREATOR);
    }

    public PoiResult(SearchResult.ERRORNO errorno) {
        super(errorno);
        this.f7266a = 0;
        this.f7267b = 0;
        this.f7268c = 0;
        this.f7269d = 0;
        this.f7271f = false;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<PoiAddrInfo> getAllAddr() {
        return this.f7272g;
    }

    public List<PoiInfo> getAllPoi() {
        return this.f7270e;
    }

    public int getCurrentPageCapacity() {
        return this.f7268c;
    }

    public int getCurrentPageNum() {
        return this.f7266a;
    }

    public List<CityInfo> getSuggestCityList() {
        return this.f7273h;
    }

    public int getTotalPageNum() {
        return this.f7267b;
    }

    public int getTotalPoiNum() {
        return this.f7269d;
    }

    public boolean isHasAddrInfo() {
        return this.f7271f;
    }

    public void setAddrInfo(List<PoiAddrInfo> list) {
        this.f7272g = list;
    }

    public void setCurrentPageCapacity(int i) {
        this.f7268c = i;
    }

    public void setCurrentPageNum(int i) {
        this.f7266a = i;
    }

    public void setHasAddrInfo(boolean z) {
        this.f7271f = z;
    }

    public void setPoiInfo(List<PoiInfo> list) {
        this.f7270e = list;
    }

    public void setSuggestCityList(List<CityInfo> list) {
        this.f7273h = list;
    }

    public void setTotalPageNum(int i) {
        this.f7267b = i;
    }

    public void setTotalPoiNum(int i) {
        this.f7269d = i;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f7266a);
        parcel.writeInt(this.f7267b);
        parcel.writeInt(this.f7268c);
        parcel.writeInt(this.f7269d);
        parcel.writeTypedList(this.f7270e);
        parcel.writeByte(this.f7271f ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.f7273h);
    }
}
