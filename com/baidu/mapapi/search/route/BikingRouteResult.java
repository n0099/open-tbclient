package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class BikingRouteResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<BikingRouteResult> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    private List<BikingRouteLine> f3013a;

    /* renamed from: b  reason: collision with root package name */
    private SuggestAddrInfo f3014b;

    public BikingRouteResult() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BikingRouteResult(Parcel parcel) {
        this.f3013a = new ArrayList();
        parcel.readList(this.f3013a, BikingRouteLine.class.getClassLoader());
        this.f3014b = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<BikingRouteLine> getRouteLines() {
        return this.f3013a;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.f3014b;
    }

    public void setRouteLines(List<BikingRouteLine> list) {
        this.f3013a = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.f3014b = suggestAddrInfo;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f3013a);
        parcel.writeParcelable(this.f3014b, 1);
    }
}
