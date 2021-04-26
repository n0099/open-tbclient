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
    public TransitResultNode f7592a;

    /* renamed from: b  reason: collision with root package name */
    public TransitResultNode f7593b;

    /* renamed from: c  reason: collision with root package name */
    public TaxiInfo f7594c;

    /* renamed from: d  reason: collision with root package name */
    public int f7595d;

    /* renamed from: e  reason: collision with root package name */
    public List<MassTransitRouteLine> f7596e;

    /* renamed from: f  reason: collision with root package name */
    public SuggestAddrInfo f7597f;

    public MassTransitRouteResult() {
    }

    public MassTransitRouteResult(Parcel parcel) {
        this.f7592a = (TransitResultNode) parcel.readParcelable(TransitResultNode.class.getClassLoader());
        this.f7593b = (TransitResultNode) parcel.readParcelable(TransitResultNode.class.getClassLoader());
        this.f7594c = (TaxiInfo) parcel.readParcelable(TaxiInfo.class.getClassLoader());
        this.f7595d = parcel.readInt();
        ArrayList arrayList = new ArrayList();
        this.f7596e = arrayList;
        parcel.readList(arrayList, MassTransitRouteLine.class.getClassLoader());
        this.f7597f = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TransitResultNode getDestination() {
        return this.f7593b;
    }

    public TransitResultNode getOrigin() {
        return this.f7592a;
    }

    public List<MassTransitRouteLine> getRouteLines() {
        return this.f7596e;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.f7597f;
    }

    public TaxiInfo getTaxiInfo() {
        return this.f7594c;
    }

    public int getTotal() {
        return this.f7595d;
    }

    public void setDestination(TransitResultNode transitResultNode) {
        this.f7593b = transitResultNode;
    }

    public void setOrigin(TransitResultNode transitResultNode) {
        this.f7592a = transitResultNode;
    }

    public void setRoutelines(List<MassTransitRouteLine> list) {
        this.f7596e = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.f7597f = suggestAddrInfo;
    }

    public void setTaxiInfo(TaxiInfo taxiInfo) {
        this.f7594c = taxiInfo;
    }

    public void setTotal(int i2) {
        this.f7595d = i2;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f7592a, 1);
        parcel.writeParcelable(this.f7593b, 1);
        parcel.writeParcelable(this.f7594c, 1);
        parcel.writeInt(this.f7595d);
        parcel.writeList(this.f7596e);
        parcel.writeParcelable(this.f7597f, 1);
    }
}
