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
    public int f7231a;

    /* renamed from: b  reason: collision with root package name */
    public int f7232b;

    /* renamed from: c  reason: collision with root package name */
    public int f7233c;

    /* renamed from: d  reason: collision with root package name */
    public int f7234d;

    /* renamed from: e  reason: collision with root package name */
    public List<PoiInfo> f7235e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7236f;

    /* renamed from: g  reason: collision with root package name */
    public List<PoiAddrInfo> f7237g;

    /* renamed from: h  reason: collision with root package name */
    public List<CityInfo> f7238h;

    public PoiResult() {
        this.f7231a = 0;
        this.f7232b = 0;
        this.f7233c = 0;
        this.f7234d = 0;
        this.f7236f = false;
    }

    public PoiResult(Parcel parcel) {
        super(parcel);
        this.f7231a = 0;
        this.f7232b = 0;
        this.f7233c = 0;
        this.f7234d = 0;
        this.f7236f = false;
        this.f7231a = parcel.readInt();
        this.f7232b = parcel.readInt();
        this.f7233c = parcel.readInt();
        this.f7234d = parcel.readInt();
        this.f7235e = parcel.createTypedArrayList(PoiInfo.CREATOR);
        this.f7236f = parcel.readByte() != 0;
        this.f7238h = parcel.createTypedArrayList(CityInfo.CREATOR);
    }

    public PoiResult(SearchResult.ERRORNO errorno) {
        super(errorno);
        this.f7231a = 0;
        this.f7232b = 0;
        this.f7233c = 0;
        this.f7234d = 0;
        this.f7236f = false;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<PoiAddrInfo> getAllAddr() {
        return this.f7237g;
    }

    public List<PoiInfo> getAllPoi() {
        return this.f7235e;
    }

    public int getCurrentPageCapacity() {
        return this.f7233c;
    }

    public int getCurrentPageNum() {
        return this.f7231a;
    }

    public List<CityInfo> getSuggestCityList() {
        return this.f7238h;
    }

    public int getTotalPageNum() {
        return this.f7232b;
    }

    public int getTotalPoiNum() {
        return this.f7234d;
    }

    public boolean isHasAddrInfo() {
        return this.f7236f;
    }

    public void setAddrInfo(List<PoiAddrInfo> list) {
        this.f7237g = list;
    }

    public void setCurrentPageCapacity(int i) {
        this.f7233c = i;
    }

    public void setCurrentPageNum(int i) {
        this.f7231a = i;
    }

    public void setHasAddrInfo(boolean z) {
        this.f7236f = z;
    }

    public void setPoiInfo(List<PoiInfo> list) {
        this.f7235e = list;
    }

    public void setSuggestCityList(List<CityInfo> list) {
        this.f7238h = list;
    }

    public void setTotalPageNum(int i) {
        this.f7232b = i;
    }

    public void setTotalPoiNum(int i) {
        this.f7234d = i;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f7231a);
        parcel.writeInt(this.f7232b);
        parcel.writeInt(this.f7233c);
        parcel.writeInt(this.f7234d);
        parcel.writeTypedList(this.f7235e);
        parcel.writeByte(this.f7236f ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.f7238h);
    }
}
