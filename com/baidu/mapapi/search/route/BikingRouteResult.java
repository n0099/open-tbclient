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
    public List<BikingRouteLine> f7283a;

    /* renamed from: b  reason: collision with root package name */
    public SuggestAddrInfo f7284b;

    public BikingRouteResult() {
    }

    public BikingRouteResult(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        this.f7283a = arrayList;
        parcel.readList(arrayList, BikingRouteLine.class.getClassLoader());
        this.f7284b = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<BikingRouteLine> getRouteLines() {
        return this.f7283a;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.f7284b;
    }

    public void setRouteLines(List<BikingRouteLine> list) {
        this.f7283a = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.f7284b = suggestAddrInfo;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f7283a);
        parcel.writeParcelable(this.f7284b, 1);
    }
}
