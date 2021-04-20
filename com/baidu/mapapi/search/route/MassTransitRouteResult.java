package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.core.TransitResultNode;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class MassTransitRouteResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<MassTransitRouteResult> CREATOR = new l();

    /* renamed from: a  reason: collision with root package name */
    public TransitResultNode f7332a;

    /* renamed from: b  reason: collision with root package name */
    public TransitResultNode f7333b;

    /* renamed from: c  reason: collision with root package name */
    public TaxiInfo f7334c;

    /* renamed from: d  reason: collision with root package name */
    public int f7335d;

    /* renamed from: e  reason: collision with root package name */
    public List<MassTransitRouteLine> f7336e;

    /* renamed from: f  reason: collision with root package name */
    public SuggestAddrInfo f7337f;

    public MassTransitRouteResult() {
    }

    public MassTransitRouteResult(Parcel parcel) {
        this.f7332a = (TransitResultNode) parcel.readParcelable(TransitResultNode.class.getClassLoader());
        this.f7333b = (TransitResultNode) parcel.readParcelable(TransitResultNode.class.getClassLoader());
        this.f7334c = (TaxiInfo) parcel.readParcelable(TaxiInfo.class.getClassLoader());
        this.f7335d = parcel.readInt();
        ArrayList arrayList = new ArrayList();
        this.f7336e = arrayList;
        parcel.readList(arrayList, MassTransitRouteLine.class.getClassLoader());
        this.f7337f = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TransitResultNode getDestination() {
        return this.f7333b;
    }

    public TransitResultNode getOrigin() {
        return this.f7332a;
    }

    public List<MassTransitRouteLine> getRouteLines() {
        return this.f7336e;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.f7337f;
    }

    public TaxiInfo getTaxiInfo() {
        return this.f7334c;
    }

    public int getTotal() {
        return this.f7335d;
    }

    public void setDestination(TransitResultNode transitResultNode) {
        this.f7333b = transitResultNode;
    }

    public void setOrigin(TransitResultNode transitResultNode) {
        this.f7332a = transitResultNode;
    }

    public void setRoutelines(List<MassTransitRouteLine> list) {
        this.f7336e = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.f7337f = suggestAddrInfo;
    }

    public void setTaxiInfo(TaxiInfo taxiInfo) {
        this.f7334c = taxiInfo;
    }

    public void setTotal(int i) {
        this.f7335d = i;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f7332a, 1);
        parcel.writeParcelable(this.f7333b, 1);
        parcel.writeParcelable(this.f7334c, 1);
        parcel.writeInt(this.f7335d);
        parcel.writeList(this.f7336e);
        parcel.writeParcelable(this.f7337f, 1);
    }
}
