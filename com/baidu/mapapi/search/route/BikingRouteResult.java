package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class BikingRouteResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<BikingRouteLine> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    public List<BikingRouteLine> f7540a;

    /* renamed from: b  reason: collision with root package name */
    public SuggestAddrInfo f7541b;

    public BikingRouteResult() {
    }

    public BikingRouteResult(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        this.f7540a = arrayList;
        parcel.readList(arrayList, BikingRouteLine.class.getClassLoader());
        this.f7541b = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<BikingRouteLine> getRouteLines() {
        return this.f7540a;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.f7541b;
    }

    public void setRouteLines(List<BikingRouteLine> list) {
        this.f7540a = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.f7541b = suggestAddrInfo;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeList(this.f7540a);
        parcel.writeParcelable(this.f7541b, 1);
    }
}
