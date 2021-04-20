package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;
/* loaded from: classes2.dex */
public class IndoorRouteResult extends SearchResult {
    public static final Parcelable.Creator<IndoorRouteResult> CREATOR = new h();

    /* renamed from: a  reason: collision with root package name */
    public List<IndoorRouteLine> f7313a;

    public IndoorRouteResult() {
    }

    public IndoorRouteResult(Parcel parcel) {
        super(parcel);
        this.f7313a = parcel.createTypedArrayList(IndoorRouteLine.CREATOR);
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<IndoorRouteLine> getRouteLines() {
        return this.f7313a;
    }

    public void setRouteLines(List<IndoorRouteLine> list) {
        this.f7313a = list;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.f7313a);
    }
}
