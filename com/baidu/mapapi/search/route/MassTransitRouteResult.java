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
    public TransitResultNode f7409a;

    /* renamed from: b  reason: collision with root package name */
    public TransitResultNode f7410b;

    /* renamed from: c  reason: collision with root package name */
    public TaxiInfo f7411c;

    /* renamed from: d  reason: collision with root package name */
    public int f7412d;

    /* renamed from: e  reason: collision with root package name */
    public List<MassTransitRouteLine> f7413e;

    /* renamed from: f  reason: collision with root package name */
    public SuggestAddrInfo f7414f;

    public MassTransitRouteResult() {
    }

    public MassTransitRouteResult(Parcel parcel) {
        this.f7409a = (TransitResultNode) parcel.readParcelable(TransitResultNode.class.getClassLoader());
        this.f7410b = (TransitResultNode) parcel.readParcelable(TransitResultNode.class.getClassLoader());
        this.f7411c = (TaxiInfo) parcel.readParcelable(TaxiInfo.class.getClassLoader());
        this.f7412d = parcel.readInt();
        ArrayList arrayList = new ArrayList();
        this.f7413e = arrayList;
        parcel.readList(arrayList, MassTransitRouteLine.class.getClassLoader());
        this.f7414f = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TransitResultNode getDestination() {
        return this.f7410b;
    }

    public TransitResultNode getOrigin() {
        return this.f7409a;
    }

    public List<MassTransitRouteLine> getRouteLines() {
        return this.f7413e;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.f7414f;
    }

    public TaxiInfo getTaxiInfo() {
        return this.f7411c;
    }

    public int getTotal() {
        return this.f7412d;
    }

    public void setDestination(TransitResultNode transitResultNode) {
        this.f7410b = transitResultNode;
    }

    public void setOrigin(TransitResultNode transitResultNode) {
        this.f7409a = transitResultNode;
    }

    public void setRoutelines(List<MassTransitRouteLine> list) {
        this.f7413e = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.f7414f = suggestAddrInfo;
    }

    public void setTaxiInfo(TaxiInfo taxiInfo) {
        this.f7411c = taxiInfo;
    }

    public void setTotal(int i2) {
        this.f7412d = i2;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f7409a, 1);
        parcel.writeParcelable(this.f7410b, 1);
        parcel.writeParcelable(this.f7411c, 1);
        parcel.writeInt(this.f7412d);
        parcel.writeList(this.f7413e);
        parcel.writeParcelable(this.f7414f, 1);
    }
}
