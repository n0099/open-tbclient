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
    public List<BikingRouteLine> f7357a;

    /* renamed from: b  reason: collision with root package name */
    public SuggestAddrInfo f7358b;

    public BikingRouteResult() {
    }

    public BikingRouteResult(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        this.f7357a = arrayList;
        parcel.readList(arrayList, BikingRouteLine.class.getClassLoader());
        this.f7358b = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<BikingRouteLine> getRouteLines() {
        return this.f7357a;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.f7358b;
    }

    public void setRouteLines(List<BikingRouteLine> list) {
        this.f7357a = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.f7358b = suggestAddrInfo;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeList(this.f7357a);
        parcel.writeParcelable(this.f7358b, 1);
    }
}
