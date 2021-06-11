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
    public TransitResultNode f7352a;

    /* renamed from: b  reason: collision with root package name */
    public TransitResultNode f7353b;

    /* renamed from: c  reason: collision with root package name */
    public TaxiInfo f7354c;

    /* renamed from: d  reason: collision with root package name */
    public int f7355d;

    /* renamed from: e  reason: collision with root package name */
    public List<MassTransitRouteLine> f7356e;

    /* renamed from: f  reason: collision with root package name */
    public SuggestAddrInfo f7357f;

    public MassTransitRouteResult() {
    }

    public MassTransitRouteResult(Parcel parcel) {
        this.f7352a = (TransitResultNode) parcel.readParcelable(TransitResultNode.class.getClassLoader());
        this.f7353b = (TransitResultNode) parcel.readParcelable(TransitResultNode.class.getClassLoader());
        this.f7354c = (TaxiInfo) parcel.readParcelable(TaxiInfo.class.getClassLoader());
        this.f7355d = parcel.readInt();
        ArrayList arrayList = new ArrayList();
        this.f7356e = arrayList;
        parcel.readList(arrayList, MassTransitRouteLine.class.getClassLoader());
        this.f7357f = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TransitResultNode getDestination() {
        return this.f7353b;
    }

    public TransitResultNode getOrigin() {
        return this.f7352a;
    }

    public List<MassTransitRouteLine> getRouteLines() {
        return this.f7356e;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.f7357f;
    }

    public TaxiInfo getTaxiInfo() {
        return this.f7354c;
    }

    public int getTotal() {
        return this.f7355d;
    }

    public void setDestination(TransitResultNode transitResultNode) {
        this.f7353b = transitResultNode;
    }

    public void setOrigin(TransitResultNode transitResultNode) {
        this.f7352a = transitResultNode;
    }

    public void setRoutelines(List<MassTransitRouteLine> list) {
        this.f7356e = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.f7357f = suggestAddrInfo;
    }

    public void setTaxiInfo(TaxiInfo taxiInfo) {
        this.f7354c = taxiInfo;
    }

    public void setTotal(int i2) {
        this.f7355d = i2;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f7352a, 1);
        parcel.writeParcelable(this.f7353b, 1);
        parcel.writeParcelable(this.f7354c, 1);
        parcel.writeInt(this.f7355d);
        parcel.writeList(this.f7356e);
        parcel.writeParcelable(this.f7357f, 1);
    }
}
