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
    public List<WalkingRouteLine> f7444a;

    /* renamed from: b  reason: collision with root package name */
    public TaxiInfo f7445b;

    /* renamed from: c  reason: collision with root package name */
    public SuggestAddrInfo f7446c;

    public WalkingRouteResult() {
    }

    public WalkingRouteResult(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        this.f7444a = arrayList;
        parcel.readList(arrayList, WalkingRouteLine.class.getClassLoader());
        this.f7445b = (TaxiInfo) parcel.readParcelable(TaxiInfo.class.getClassLoader());
        this.f7446c = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<WalkingRouteLine> getRouteLines() {
        return this.f7444a;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.f7446c;
    }

    public TaxiInfo getTaxiInfo() {
        return this.f7445b;
    }

    public void setRouteLines(List<WalkingRouteLine> list) {
        this.f7444a = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.f7446c = suggestAddrInfo;
    }

    public void setTaxiInfo(TaxiInfo taxiInfo) {
        this.f7445b = taxiInfo;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeList(this.f7444a);
        parcel.writeParcelable(this.f7445b, 1);
        parcel.writeParcelable(this.f7446c, 1);
    }
}
