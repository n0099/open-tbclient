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
    public TransitResultNode f7297a;

    /* renamed from: b  reason: collision with root package name */
    public TransitResultNode f7298b;

    /* renamed from: c  reason: collision with root package name */
    public TaxiInfo f7299c;

    /* renamed from: d  reason: collision with root package name */
    public int f7300d;

    /* renamed from: e  reason: collision with root package name */
    public List<MassTransitRouteLine> f7301e;

    /* renamed from: f  reason: collision with root package name */
    public SuggestAddrInfo f7302f;

    public MassTransitRouteResult() {
    }

    public MassTransitRouteResult(Parcel parcel) {
        this.f7297a = (TransitResultNode) parcel.readParcelable(TransitResultNode.class.getClassLoader());
        this.f7298b = (TransitResultNode) parcel.readParcelable(TransitResultNode.class.getClassLoader());
        this.f7299c = (TaxiInfo) parcel.readParcelable(TaxiInfo.class.getClassLoader());
        this.f7300d = parcel.readInt();
        ArrayList arrayList = new ArrayList();
        this.f7301e = arrayList;
        parcel.readList(arrayList, MassTransitRouteLine.class.getClassLoader());
        this.f7302f = (SuggestAddrInfo) parcel.readParcelable(SuggestAddrInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TransitResultNode getDestination() {
        return this.f7298b;
    }

    public TransitResultNode getOrigin() {
        return this.f7297a;
    }

    public List<MassTransitRouteLine> getRouteLines() {
        return this.f7301e;
    }

    public SuggestAddrInfo getSuggestAddrInfo() {
        return this.f7302f;
    }

    public TaxiInfo getTaxiInfo() {
        return this.f7299c;
    }

    public int getTotal() {
        return this.f7300d;
    }

    public void setDestination(TransitResultNode transitResultNode) {
        this.f7298b = transitResultNode;
    }

    public void setOrigin(TransitResultNode transitResultNode) {
        this.f7297a = transitResultNode;
    }

    public void setRoutelines(List<MassTransitRouteLine> list) {
        this.f7301e = list;
    }

    public void setSuggestAddrInfo(SuggestAddrInfo suggestAddrInfo) {
        this.f7302f = suggestAddrInfo;
    }

    public void setTaxiInfo(TaxiInfo taxiInfo) {
        this.f7299c = taxiInfo;
    }

    public void setTotal(int i) {
        this.f7300d = i;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f7297a, 1);
        parcel.writeParcelable(this.f7298b, 1);
        parcel.writeParcelable(this.f7299c, 1);
        parcel.writeInt(this.f7300d);
        parcel.writeList(this.f7301e);
        parcel.writeParcelable(this.f7302f, 1);
    }
}
