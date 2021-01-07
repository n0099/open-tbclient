package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public final class DrivingRouteResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<DrivingRouteResult> CREATOR = new f();

    /* renamed from: a  reason: collision with root package name */
    private List<DrivingRouteLine> f3021a;

    /* renamed from: b  reason: collision with root package name */
    private List<TaxiInfo> f3022b;
    private TaxiInfo c;
    private SuggestAddrInfo d;

    public DrivingRouteResult() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DrivingRouteResult(Parcel parcel) {
        this.f3021a = new ArrayList();
        parcel.readTypedList(this.f3021a, DrivingRouteLine.CREATOR);
        this.f3022b = new ArrayList();
        parcel.readTypedList(this.f3022b, TaxiInfo.CREATOR);
        this.d = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<DrivingRouteLine> getRouteLines() {
        return this.f3021a;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.d;
    }

    @Deprecated
    public TaxiInfo getTaxiInfo() {
        return this.c;
    }

    public List<TaxiInfo> getTaxiInfos() {
        return this.f3022b;
    }

    public void setRouteLines(List<DrivingRouteLine> list) {
        this.f3021a = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.d = suggestAddrInfo;
    }

    public void setTaxiInfos(List<TaxiInfo> list) {
        this.f3022b = list;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f3021a);
        parcel.writeTypedList(this.f3022b);
        parcel.writeParcelable(this.d, 1);
    }
}
