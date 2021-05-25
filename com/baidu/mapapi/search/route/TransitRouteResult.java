package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class TransitRouteResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<TransitRouteResult> CREATOR = new q();

    /* renamed from: a  reason: collision with root package name */
    public TaxiInfo f7335a;

    /* renamed from: b  reason: collision with root package name */
    public List<TransitRouteLine> f7336b;

    /* renamed from: c  reason: collision with root package name */
    public SuggestAddrInfo f7337c;

    public TransitRouteResult() {
    }

    public TransitRouteResult(Parcel parcel) {
        this.f7335a = (TaxiInfo) parcel.readParcelable(TaxiInfo.class.getClassLoader());
        ArrayList arrayList = new ArrayList();
        this.f7336b = arrayList;
        parcel.readList(arrayList, TransitRouteLine.class.getClassLoader());
        this.f7337c = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<TransitRouteLine> getRouteLines() {
        return this.f7336b;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.f7337c;
    }

    public TaxiInfo getTaxiInfo() {
        return this.f7335a;
    }

    public void setRoutelines(List<TransitRouteLine> list) {
        this.f7336b = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.f7337c = suggestAddrInfo;
    }

    public void setTaxiInfo(TaxiInfo taxiInfo) {
        this.f7335a = taxiInfo;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f7335a, 1);
        parcel.writeList(this.f7336b);
        parcel.writeParcelable(this.f7337c, 1);
    }
}
