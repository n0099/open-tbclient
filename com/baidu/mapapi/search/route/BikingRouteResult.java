package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class BikingRouteResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<BikingRouteResult> CREATOR = new c();
    private List<BikingRouteLine> a;
    private SuggestAddrInfo b;

    public BikingRouteResult() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BikingRouteResult(Parcel parcel) {
        this.a = new ArrayList();
        parcel.readList(this.a, BikingRouteLine.class.getClassLoader());
        this.b = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<BikingRouteLine> getRouteLines() {
        return this.a;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.b;
    }

    public void setRouteLines(List<BikingRouteLine> list) {
        this.a = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.b = suggestAddrInfo;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.a);
        parcel.writeParcelable(this.b, 1);
    }
}
