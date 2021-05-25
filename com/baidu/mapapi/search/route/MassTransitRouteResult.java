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
    public TransitResultNode f7309a;

    /* renamed from: b  reason: collision with root package name */
    public TransitResultNode f7310b;

    /* renamed from: c  reason: collision with root package name */
    public TaxiInfo f7311c;

    /* renamed from: d  reason: collision with root package name */
    public int f7312d;

    /* renamed from: e  reason: collision with root package name */
    public List<MassTransitRouteLine> f7313e;

    /* renamed from: f  reason: collision with root package name */
    public SuggestAddrInfo f7314f;

    public MassTransitRouteResult() {
    }

    public MassTransitRouteResult(Parcel parcel) {
        this.f7309a = (TransitResultNode) parcel.readParcelable(TransitResultNode.class.getClassLoader());
        this.f7310b = (TransitResultNode) parcel.readParcelable(TransitResultNode.class.getClassLoader());
        this.f7311c = (TaxiInfo) parcel.readParcelable(TaxiInfo.class.getClassLoader());
        this.f7312d = parcel.readInt();
        ArrayList arrayList = new ArrayList();
        this.f7313e = arrayList;
        parcel.readList(arrayList, MassTransitRouteLine.class.getClassLoader());
        this.f7314f = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TransitResultNode getDestination() {
        return this.f7310b;
    }

    public TransitResultNode getOrigin() {
        return this.f7309a;
    }

    public List<MassTransitRouteLine> getRouteLines() {
        return this.f7313e;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.f7314f;
    }

    public TaxiInfo getTaxiInfo() {
        return this.f7311c;
    }

    public int getTotal() {
        return this.f7312d;
    }

    public void setDestination(TransitResultNode transitResultNode) {
        this.f7310b = transitResultNode;
    }

    public void setOrigin(TransitResultNode transitResultNode) {
        this.f7309a = transitResultNode;
    }

    public void setRoutelines(List<MassTransitRouteLine> list) {
        this.f7313e = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.f7314f = suggestAddrInfo;
    }

    public void setTaxiInfo(TaxiInfo taxiInfo) {
        this.f7311c = taxiInfo;
    }

    public void setTotal(int i2) {
        this.f7312d = i2;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f7309a, 1);
        parcel.writeParcelable(this.f7310b, 1);
        parcel.writeParcelable(this.f7311c, 1);
        parcel.writeInt(this.f7312d);
        parcel.writeList(this.f7313e);
        parcel.writeParcelable(this.f7314f, 1);
    }
}
