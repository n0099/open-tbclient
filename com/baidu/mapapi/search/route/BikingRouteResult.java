package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class BikingRouteResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<BikingRouteResult> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    private List<BikingRouteLine> f3014a;

    /* renamed from: b  reason: collision with root package name */
    private SuggestAddrInfo f3015b;

    public BikingRouteResult() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BikingRouteResult(Parcel parcel) {
        this.f3014a = new ArrayList();
        parcel.readList(this.f3014a, BikingRouteLine.class.getClassLoader());
        this.f3015b = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<BikingRouteLine> getRouteLines() {
        return this.f3014a;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.f3015b;
    }

    public void setRouteLines(List<BikingRouteLine> list) {
        this.f3014a = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.f3015b = suggestAddrInfo;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f3014a);
        parcel.writeParcelable(this.f3015b, 1);
    }
}
