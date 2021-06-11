package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class BikingRouteResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<BikingRouteResult> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    public List<BikingRouteLine> f7300a;

    /* renamed from: b  reason: collision with root package name */
    public SuggestAddrInfo f7301b;

    public BikingRouteResult() {
    }

    public BikingRouteResult(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        this.f7300a = arrayList;
        parcel.readList(arrayList, BikingRouteLine.class.getClassLoader());
        this.f7301b = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<BikingRouteLine> getRouteLines() {
        return this.f7300a;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.f7301b;
    }

    public void setRouteLines(List<BikingRouteLine> list) {
        this.f7300a = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.f7301b = suggestAddrInfo;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeList(this.f7300a);
        parcel.writeParcelable(this.f7301b, 1);
    }
}
