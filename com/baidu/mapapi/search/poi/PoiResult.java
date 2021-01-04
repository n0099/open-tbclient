package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.CityInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;
/* loaded from: classes15.dex */
public class PoiResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<PoiResult> CREATOR = new f();

    /* renamed from: a  reason: collision with root package name */
    private int f3007a;

    /* renamed from: b  reason: collision with root package name */
    private int f3008b;
    private int c;
    private int d;
    private List<PoiInfo> e;
    private boolean f;
    private List<PoiAddrInfo> g;
    private List<CityInfo> h;

    public PoiResult() {
        this.f3007a = 0;
        this.f3008b = 0;
        this.c = 0;
        this.d = 0;
        this.f = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PoiResult(Parcel parcel) {
        super(parcel);
        this.f3007a = 0;
        this.f3008b = 0;
        this.c = 0;
        this.d = 0;
        this.f = false;
        this.f3007a = parcel.readInt();
        this.f3008b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.createTypedArrayList(PoiInfo.CREATOR);
        this.f = parcel.readByte() != 0;
        this.h = parcel.createTypedArrayList(CityInfo.CREATOR);
    }

    public PoiResult(SearchResult.ERRORNO errorno) {
        super(errorno);
        this.f3007a = 0;
        this.f3008b = 0;
        this.c = 0;
        this.d = 0;
        this.f = false;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<PoiAddrInfo> getAllAddr() {
        return this.g;
    }

    public List<PoiInfo> getAllPoi() {
        return this.e;
    }

    public int getCurrentPageCapacity() {
        return this.c;
    }

    public int getCurrentPageNum() {
        return this.f3007a;
    }

    public List<CityInfo> getSuggestCityList() {
        return this.h;
    }

    public int getTotalPageNum() {
        return this.f3008b;
    }

    public int getTotalPoiNum() {
        return this.d;
    }

    public boolean isHasAddrInfo() {
        return this.f;
    }

    public void setAddrInfo(List<PoiAddrInfo> list) {
        this.g = list;
    }

    public void setCurrentPageCapacity(int i) {
        this.c = i;
    }

    public void setCurrentPageNum(int i) {
        this.f3007a = i;
    }

    public void setHasAddrInfo(boolean z) {
        this.f = z;
    }

    public void setPoiInfo(List<PoiInfo> list) {
        this.e = list;
    }

    public void setSuggestCityList(List<CityInfo> list) {
        this.h = list;
    }

    public void setTotalPageNum(int i) {
        this.f3008b = i;
    }

    public void setTotalPoiNum(int i) {
        this.d = i;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f3007a);
        parcel.writeInt(this.f3008b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeTypedList(this.e);
        parcel.writeByte((byte) (this.f ? 1 : 0));
        parcel.writeTypedList(this.h);
    }
}
