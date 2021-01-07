package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;
/* loaded from: classes3.dex */
public class IndoorRouteResult extends SearchResult {
    public static final Parcelable.Creator<IndoorRouteResult> CREATOR = new h();

    /* renamed from: a  reason: collision with root package name */
    private List<IndoorRouteLine> f3027a;

    public IndoorRouteResult() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IndoorRouteResult(Parcel parcel) {
        super(parcel);
        this.f3027a = parcel.createTypedArrayList(IndoorRouteLine.CREATOR);
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<IndoorRouteLine> getRouteLines() {
        return this.f3027a;
    }

    public void setRouteLines(List<IndoorRouteLine> list) {
        this.f3027a = list;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.f3027a);
    }
}
