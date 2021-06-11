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
    public TaxiInfo f7378a;

    /* renamed from: b  reason: collision with root package name */
    public List<TransitRouteLine> f7379b;

    /* renamed from: c  reason: collision with root package name */
    public SuggestAddrInfo f7380c;

    public TransitRouteResult() {
    }

    public TransitRouteResult(Parcel parcel) {
        this.f7378a = (TaxiInfo) parcel.readParcelable(TaxiInfo.class.getClassLoader());
        ArrayList arrayList = new ArrayList();
        this.f7379b = arrayList;
        parcel.readList(arrayList, TransitRouteLine.class.getClassLoader());
        this.f7380c = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<TransitRouteLine> getRouteLines() {
        return this.f7379b;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.f7380c;
    }

    public TaxiInfo getTaxiInfo() {
        return this.f7378a;
    }

    public void setRoutelines(List<TransitRouteLine> list) {
        this.f7379b = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.f7380c = suggestAddrInfo;
    }

    public void setTaxiInfo(TaxiInfo taxiInfo) {
        this.f7378a = taxiInfo;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f7378a, 1);
        parcel.writeList(this.f7379b);
        parcel.writeParcelable(this.f7380c, 1);
    }
}
