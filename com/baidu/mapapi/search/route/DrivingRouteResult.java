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
    private List<DrivingRouteLine> a;
    private List<TaxiInfo> b;
    private TaxiInfo c;
    private SuggestAddrInfo d;

    public DrivingRouteResult() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DrivingRouteResult(Parcel parcel) {
        this.a = new ArrayList();
        parcel.readTypedList(this.a, DrivingRouteLine.CREATOR);
        this.b = new ArrayList();
        parcel.readTypedList(this.b, TaxiInfo.CREATOR);
        this.d = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<DrivingRouteLine> getRouteLines() {
        return this.a;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.d;
    }

    @Deprecated
    public TaxiInfo getTaxiInfo() {
        return this.c;
    }

    public List<TaxiInfo> getTaxiInfos() {
        return this.b;
    }

    public void setRouteLines(List<DrivingRouteLine> list) {
        this.a = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.d = suggestAddrInfo;
    }

    public void setTaxiInfos(List<TaxiInfo> list) {
        this.b = list;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.a);
        parcel.writeTypedList(this.b);
        parcel.writeParcelable(this.d, 1);
    }
}
