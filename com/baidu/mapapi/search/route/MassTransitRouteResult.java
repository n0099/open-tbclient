package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.core.TransitResultNode;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public final class MassTransitRouteResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<MassTransitRouteResult> CREATOR = new l();

    /* renamed from: a  reason: collision with root package name */
    private TransitResultNode f2916a;

    /* renamed from: b  reason: collision with root package name */
    private TransitResultNode f2917b;
    private TaxiInfo c;
    private int d;
    private List<MassTransitRouteLine> e;
    private SuggestAddrInfo f;

    public MassTransitRouteResult() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MassTransitRouteResult(Parcel parcel) {
        this.f2916a = (TransitResultNode) parcel.readParcelable(TransitResultNode.class.getClassLoader());
        this.f2917b = (TransitResultNode) parcel.readParcelable(TransitResultNode.class.getClassLoader());
        this.c = (TaxiInfo) parcel.readParcelable(TaxiInfo.class.getClassLoader());
        this.d = parcel.readInt();
        this.e = new ArrayList();
        parcel.readList(this.e, MassTransitRouteLine.class.getClassLoader());
        this.f = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TransitResultNode getDestination() {
        return this.f2917b;
    }

    public TransitResultNode getOrigin() {
        return this.f2916a;
    }

    public List<MassTransitRouteLine> getRouteLines() {
        return this.e;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.f;
    }

    public TaxiInfo getTaxiInfo() {
        return this.c;
    }

    public int getTotal() {
        return this.d;
    }

    public void setDestination(TransitResultNode transitResultNode) {
        this.f2917b = transitResultNode;
    }

    public void setOrigin(TransitResultNode transitResultNode) {
        this.f2916a = transitResultNode;
    }

    public void setRoutelines(List<MassTransitRouteLine> list) {
        this.e = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.f = suggestAddrInfo;
    }

    public void setTaxiInfo(TaxiInfo taxiInfo) {
        this.c = taxiInfo;
    }

    public void setTotal(int i) {
        this.d = i;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f2916a, 1);
        parcel.writeParcelable(this.f2917b, 1);
        parcel.writeParcelable(this.c, 1);
        parcel.writeInt(this.d);
        parcel.writeList(this.e);
        parcel.writeParcelable(this.f, 1);
    }
}
