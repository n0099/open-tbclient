package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public final class TransitRouteResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<TransitRouteResult> CREATOR = new q();

    /* renamed from: a  reason: collision with root package name */
    private TaxiInfo f3048a;

    /* renamed from: b  reason: collision with root package name */
    private List<TransitRouteLine> f3049b;
    private SuggestAddrInfo c;

    public TransitRouteResult() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TransitRouteResult(Parcel parcel) {
        this.f3048a = (TaxiInfo) parcel.readParcelable(TaxiInfo.class.getClassLoader());
        this.f3049b = new ArrayList();
        parcel.readList(this.f3049b, TransitRouteLine.class.getClassLoader());
        this.c = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<TransitRouteLine> getRouteLines() {
        return this.f3049b;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.c;
    }

    public TaxiInfo getTaxiInfo() {
        return this.f3048a;
    }

    public void setRoutelines(List<TransitRouteLine> list) {
        this.f3049b = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.c = suggestAddrInfo;
    }

    public void setTaxiInfo(TaxiInfo taxiInfo) {
        this.f3048a = taxiInfo;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f3048a, 1);
        parcel.writeList(this.f3049b);
        parcel.writeParcelable(this.c, 1);
    }
}
