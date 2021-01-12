package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class BikingRouteResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<BikingRouteLine> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    private List<BikingRouteLine> f2892a;

    /* renamed from: b  reason: collision with root package name */
    private SuggestAddrInfo f2893b;

    public BikingRouteResult() {
    }

    protected BikingRouteResult(Parcel parcel) {
        this.f2892a = new ArrayList();
        parcel.readList(this.f2892a, BikingRouteLine.class.getClassLoader());
        this.f2893b = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<BikingRouteLine> getRouteLines() {
        return this.f2892a;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.f2893b;
    }

    public void setRouteLines(List<BikingRouteLine> list) {
        this.f2892a = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.f2893b = suggestAddrInfo;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f2892a);
        parcel.writeParcelable(this.f2893b, 1);
    }
}
