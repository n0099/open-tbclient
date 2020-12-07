package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes26.dex */
public class WalkingRouteResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<WalkingRouteResult> CREATOR = new t();

    /* renamed from: a  reason: collision with root package name */
    private List<WalkingRouteLine> f2152a;
    private TaxiInfo b;
    private SuggestAddrInfo c;

    public WalkingRouteResult() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public WalkingRouteResult(Parcel parcel) {
        this.f2152a = new ArrayList();
        parcel.readList(this.f2152a, WalkingRouteLine.class.getClassLoader());
        this.b = (TaxiInfo) parcel.readParcelable(TaxiInfo.class.getClassLoader());
        this.c = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<WalkingRouteLine> getRouteLines() {
        return this.f2152a;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.c;
    }

    public TaxiInfo getTaxiInfo() {
        return this.b;
    }

    public void setRouteLines(List<WalkingRouteLine> list) {
        this.f2152a = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.c = suggestAddrInfo;
    }

    public void setTaxiInfo(TaxiInfo taxiInfo) {
        this.b = taxiInfo;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f2152a);
        parcel.writeParcelable(this.b, 1);
        parcel.writeParcelable(this.c, 1);
    }
}
