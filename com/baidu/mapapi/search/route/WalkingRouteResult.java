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
    public List<WalkingRouteLine> f7365a;

    /* renamed from: b  reason: collision with root package name */
    public TaxiInfo f7366b;

    /* renamed from: c  reason: collision with root package name */
    public SuggestAddrInfo f7367c;

    public WalkingRouteResult() {
    }

    public WalkingRouteResult(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        this.f7365a = arrayList;
        parcel.readList(arrayList, WalkingRouteLine.class.getClassLoader());
        this.f7366b = (TaxiInfo) parcel.readParcelable(TaxiInfo.class.getClassLoader());
        this.f7367c = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<WalkingRouteLine> getRouteLines() {
        return this.f7365a;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.f7367c;
    }

    public TaxiInfo getTaxiInfo() {
        return this.f7366b;
    }

    public void setRouteLines(List<WalkingRouteLine> list) {
        this.f7365a = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.f7367c = suggestAddrInfo;
    }

    public void setTaxiInfo(TaxiInfo taxiInfo) {
        this.f7366b = taxiInfo;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f7365a);
        parcel.writeParcelable(this.f7366b, 1);
        parcel.writeParcelable(this.f7367c, 1);
    }
}
