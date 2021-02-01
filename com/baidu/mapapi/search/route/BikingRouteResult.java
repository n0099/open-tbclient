package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class BikingRouteResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<BikingRouteLine> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    private List<BikingRouteLine> f2890a;

    /* renamed from: b  reason: collision with root package name */
    private SuggestAddrInfo f2891b;

    public BikingRouteResult() {
    }

    protected BikingRouteResult(Parcel parcel) {
        this.f2890a = new ArrayList();
        parcel.readList(this.f2890a, BikingRouteLine.class.getClassLoader());
        this.f2891b = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<BikingRouteLine> getRouteLines() {
        return this.f2890a;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.f2891b;
    }

    public void setRouteLines(List<BikingRouteLine> list) {
        this.f2890a = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.f2891b = suggestAddrInfo;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f2890a);
        parcel.writeParcelable(this.f2891b, 1);
    }
}
