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
    public String f7163a;

    /* renamed from: b  reason: collision with root package name */
    public String f7164b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f7165c;

    /* renamed from: d  reason: collision with root package name */
    public Date f7166d;

    /* renamed from: e  reason: collision with root package name */
    public Date f7167e;

    /* renamed from: f  reason: collision with root package name */
    public String f7168f;

    /* renamed from: g  reason: collision with root package name */
    public List<BusStation> f7169g;

    /* renamed from: h  reason: collision with root package name */
    public List<BusStep> f7170h;
    public float i;
    public float j;
    public String k;

    /* loaded from: classes2.dex */
    public static class BusStation extends RouteNode {
    }

    /* loaded from: classes2.dex */
    public static class BusStep extends RouteStep {
    }

    public BusLineResult() {
        this.f7163a = null;
        this.f7164b = null;
        this.f7169g = null;
        this.f7170h = null;
        this.k = null;
    }

    public BusLineResult(Parcel parcel) {
        this.f7163a = null;
        this.f7164b = null;
        this.f7169g = null;
        this.f7170h = null;
        this.k = null;
        this.f7163a = parcel.readString();
        this.f7164b = parcel.readString();
        this.f7165c = ((Boolean) parcel.readValue(Boolean.class.getClassLoader())).booleanValue();
        this.f7166d = (Date) parcel.readValue(Date.class.getClassLoader());
        this.f7167e = (Date) parcel.readValue(Date.class.getClassLoader());
        this.f7168f = parcel.readString();
        this.f7169g = parcel.readArrayList(BusStation.class.getClassLoader());
        this.f7170h = parcel.readArrayList(RouteStep.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getBasePrice() {
        return this.i;
    }

    public String getBusCompany() {
        return this.f7163a;
    }

    public String getBusLineName() {
        return this.f7164b;
    }

    public Date getEndTime() {
        return this.f7167e;
    }

    public String getLineDirection() {
        return this.k;
    }

    public float getMaxPrice() {
        return this.j;
    }

    public Date getStartTime() {
        return this.f7166d;
    }

    public List<BusStation> getStations() {
        return this.f7169g;
    }

    public List<BusStep> getSteps() {
        return this.f7170h;
    }

    public String getUid() {
        return this.f7168f;
    }

    public boolean isMonthTicket() {
        return this.f7165c;
    }

    public void setBasePrice(float f2) {
        this.i = f2;
    }

    public void setBusLineName(String str) {
        this.f7164b = str;
    }

    public void setEndTime(Date date) {
        this.f7167e = date;
    }

    public void setLineDirection(String str) {
        this.k = str;
    }

    public void setMaxPrice(float f2) {
        this.j = f2;
    }

    public void setMonthTicket(boolean z) {
        this.f7165c = z;
    }

    public void setStartTime(Date date) {
        this.f7166d = date;
    }

    public void setStations(List<BusStation> list) {
        this.f7169g = list;
    }

    public void setSteps(List<BusStep> list) {
        this.f7170h = list;
    }

    public void setUid(String str) {
        this.f7168f = str;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7163a);
        parcel.writeString(this.f7164b);
        parcel.writeValue(Boolean.valueOf(this.f7165c));
        parcel.writeValue(this.f7166d);
        parcel.writeValue(this.f7167e);
        parcel.writeString(this.f7168f);
        parcel.writeList(this.f7169g);
        parcel.writeList(this.f7170h);
    }
}
