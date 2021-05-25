package com.baidu.mapapi.search.busline;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.Date;
import java.util.List;
/* loaded from: classes2.dex */
public class BusLineResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<BusLineResult> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public String f7135a;

    /* renamed from: b  reason: collision with root package name */
    public String f7136b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f7137c;

    /* renamed from: d  reason: collision with root package name */
    public Date f7138d;

    /* renamed from: e  reason: collision with root package name */
    public Date f7139e;

    /* renamed from: f  reason: collision with root package name */
    public String f7140f;

    /* renamed from: g  reason: collision with root package name */
    public List<BusStation> f7141g;

    /* renamed from: h  reason: collision with root package name */
    public List<BusStep> f7142h;

    /* renamed from: i  reason: collision with root package name */
    public float f7143i;
    public float j;
    public String k;

    /* loaded from: classes2.dex */
    public static class BusStation extends RouteNode {
    }

    /* loaded from: classes2.dex */
    public static class BusStep extends RouteStep {
    }

    public BusLineResult() {
        this.f7135a = null;
        this.f7136b = null;
        this.f7141g = null;
        this.f7142h = null;
        this.k = null;
    }

    public BusLineResult(Parcel parcel) {
        this.f7135a = null;
        this.f7136b = null;
        this.f7141g = null;
        this.f7142h = null;
        this.k = null;
        this.f7135a = parcel.readString();
        this.f7136b = parcel.readString();
        this.f7137c = ((Boolean) parcel.readValue(Boolean.class.getClassLoader())).booleanValue();
        this.f7138d = (Date) parcel.readValue(Date.class.getClassLoader());
        this.f7139e = (Date) parcel.readValue(Date.class.getClassLoader());
        this.f7140f = parcel.readString();
        this.f7141g = parcel.readArrayList(BusStation.class.getClassLoader());
        this.f7142h = parcel.readArrayList(RouteStep.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getBasePrice() {
        return this.f7143i;
    }

    public String getBusCompany() {
        return this.f7135a;
    }

    public String getBusLineName() {
        return this.f7136b;
    }

    public Date getEndTime() {
        return this.f7139e;
    }

    public String getLineDirection() {
        return this.k;
    }

    public float getMaxPrice() {
        return this.j;
    }

    public Date getStartTime() {
        return this.f7138d;
    }

    public List<BusStation> getStations() {
        return this.f7141g;
    }

    public List<BusStep> getSteps() {
        return this.f7142h;
    }

    public String getUid() {
        return this.f7140f;
    }

    public boolean isMonthTicket() {
        return this.f7137c;
    }

    public void setBasePrice(float f2) {
        this.f7143i = f2;
    }

    public void setBusLineName(String str) {
        this.f7136b = str;
    }

    public void setEndTime(Date date) {
        this.f7139e = date;
    }

    public void setLineDirection(String str) {
        this.k = str;
    }

    public void setMaxPrice(float f2) {
        this.j = f2;
    }

    public void setMonthTicket(boolean z) {
        this.f7137c = z;
    }

    public void setStartTime(Date date) {
        this.f7138d = date;
    }

    public void setStations(List<BusStation> list) {
        this.f7141g = list;
    }

    public void setSteps(List<BusStep> list) {
        this.f7142h = list;
    }

    public void setUid(String str) {
        this.f7140f = str;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f7135a);
        parcel.writeString(this.f7136b);
        parcel.writeValue(Boolean.valueOf(this.f7137c));
        parcel.writeValue(this.f7138d);
        parcel.writeValue(this.f7139e);
        parcel.writeString(this.f7140f);
        parcel.writeList(this.f7141g);
        parcel.writeList(this.f7142h);
    }
}
