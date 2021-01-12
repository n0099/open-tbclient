package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public final class DrivingRouteResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<DrivingRouteResult> CREATOR = new f();

    /* renamed from: a  reason: collision with root package name */
    private List<DrivingRouteLine> f2899a;

    /* renamed from: b  reason: collision with root package name */
    private List<TaxiInfo> f2900b;
    private TaxiInfo c;
    private SuggestAddrInfo d;

    public DrivingRouteResult() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DrivingRouteResult(Parcel parcel) {
        this.f2899a = new ArrayList();
        parcel.readTypedList(this.f2899a, DrivingRouteLine.CREATOR);
        this.f2900b = new ArrayList();
        parcel.readTypedList(this.f2900b, TaxiInfo.CREATOR);
        this.d = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<DrivingRouteLine> getRouteLines() {
        return this.f2899a;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.d;
    }

    @Deprecated
    public TaxiInfo getTaxiInfo() {
        return this.c;
    }

    public List<TaxiInfo> getTaxiInfos() {
        return this.f2900b;
    }

    public void setRouteLines(List<DrivingRouteLine> list) {
        this.f2899a = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.d = suggestAddrInfo;
    }

    public void setTaxiInfos(List<TaxiInfo> list) {
        this.f2900b = list;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f2899a);
        parcel.writeTypedList(this.f2900b);
        parcel.writeParcelable(this.d, 1);
    }
}
