package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class WalkingRouteResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<WalkingRouteResult> CREATOR = new t();

    /* renamed from: a  reason: collision with root package name */
    public List<WalkingRouteLine> f7344a;

    /* renamed from: b  reason: collision with root package name */
    public TaxiInfo f7345b;

    /* renamed from: c  reason: collision with root package name */
    public SuggestAddrInfo f7346c;

    public WalkingRouteResult() {
    }

    public WalkingRouteResult(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        this.f7344a = arrayList;
        parcel.readList(arrayList, WalkingRouteLine.class.getClassLoader());
        this.f7345b = (TaxiInfo) parcel.readParcelable(TaxiInfo.class.getClassLoader());
        this.f7346c = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<WalkingRouteLine> getRouteLines() {
        return this.f7344a;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.f7346c;
    }

    public TaxiInfo getTaxiInfo() {
        return this.f7345b;
    }

    public void setRouteLines(List<WalkingRouteLine> list) {
        this.f7344a = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.f7346c = suggestAddrInfo;
    }

    public void setTaxiInfo(TaxiInfo taxiInfo) {
        this.f7345b = taxiInfo;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeList(this.f7344a);
        parcel.writeParcelable(this.f7345b, 1);
        parcel.writeParcelable(this.f7346c, 1);
    }
}
