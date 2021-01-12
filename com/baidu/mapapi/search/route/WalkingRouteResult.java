package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class WalkingRouteResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<WalkingRouteResult> CREATOR = new t();

    /* renamed from: a  reason: collision with root package name */
    private List<WalkingRouteLine> f2929a;

    /* renamed from: b  reason: collision with root package name */
    private TaxiInfo f2930b;
    private SuggestAddrInfo c;

    public WalkingRouteResult() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public WalkingRouteResult(Parcel parcel) {
        this.f2929a = new ArrayList();
        parcel.readList(this.f2929a, WalkingRouteLine.class.getClassLoader());
        this.f2930b = (TaxiInfo) parcel.readParcelable(TaxiInfo.class.getClassLoader());
        this.c = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<WalkingRouteLine> getRouteLines() {
        return this.f2929a;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.c;
    }

    public TaxiInfo getTaxiInfo() {
        return this.f2930b;
    }

    public void setRouteLines(List<WalkingRouteLine> list) {
        this.f2929a = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.c = suggestAddrInfo;
    }

    public void setTaxiInfo(TaxiInfo taxiInfo) {
        this.f2930b = taxiInfo;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f2929a);
        parcel.writeParcelable(this.f2930b, 1);
        parcel.writeParcelable(this.c, 1);
    }
}
