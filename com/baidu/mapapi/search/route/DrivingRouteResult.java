package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class DrivingRouteResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<DrivingRouteResult> CREATOR = new f();

    /* renamed from: a  reason: collision with root package name */
    public List<DrivingRouteLine> f7556a;

    /* renamed from: b  reason: collision with root package name */
    public List<TaxiInfo> f7557b;

    /* renamed from: c  reason: collision with root package name */
    public TaxiInfo f7558c;

    /* renamed from: d  reason: collision with root package name */
    public SuggestAddrInfo f7559d;

    public DrivingRouteResult() {
    }

    public DrivingRouteResult(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        this.f7556a = arrayList;
        parcel.readTypedList(arrayList, DrivingRouteLine.CREATOR);
        ArrayList arrayList2 = new ArrayList();
        this.f7557b = arrayList2;
        parcel.readTypedList(arrayList2, TaxiInfo.CREATOR);
        this.f7559d = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<DrivingRouteLine> getRouteLines() {
        return this.f7556a;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.f7559d;
    }

    @Deprecated
    public TaxiInfo getTaxiInfo() {
        return this.f7558c;
    }

    public List<TaxiInfo> getTaxiInfos() {
        return this.f7557b;
    }

    public void setRouteLines(List<DrivingRouteLine> list) {
        this.f7556a = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.f7559d = suggestAddrInfo;
    }

    public void setTaxiInfos(List<TaxiInfo> list) {
        this.f7557b = list;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.f7556a);
        parcel.writeTypedList(this.f7557b);
        parcel.writeParcelable(this.f7559d, 1);
    }
}
