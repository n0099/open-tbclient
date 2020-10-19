package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class BikingRouteResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<BikingRouteResult> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    private List<BikingRouteLine> f2130a;
    private SuggestAddrInfo b;

    public BikingRouteResult() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BikingRouteResult(Parcel parcel) {
        this.f2130a = new ArrayList();
        parcel.readList(this.f2130a, BikingRouteLine.class.getClassLoader());
        this.b = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<BikingRouteLine> getRouteLines() {
        return this.f2130a;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.b;
    }

    public void setRouteLines(List<BikingRouteLine> list) {
        this.f2130a = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.b = suggestAddrInfo;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f2130a);
        parcel.writeParcelable(this.b, 1);
    }
}
