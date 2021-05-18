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
    public String f7235a;

    /* renamed from: b  reason: collision with root package name */
    public String f7236b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f7237c;

    /* renamed from: d  reason: collision with root package name */
    public Date f7238d;

    /* renamed from: e  reason: collision with root package name */
    public Date f7239e;

    /* renamed from: f  reason: collision with root package name */
    public String f7240f;

    /* renamed from: g  reason: collision with root package name */
    public List<BusStation> f7241g;

    /* renamed from: h  reason: collision with root package name */
    public List<BusStep> f7242h;

    /* renamed from: i  reason: collision with root package name */
    public float f7243i;
    public float j;
    public String k;

    /* loaded from: classes2.dex */
    public static class BusStation extends RouteNode {
    }

    /* loaded from: classes2.dex */
    public static class BusStep extends RouteStep {
    }

    public BusLineResult() {
        this.f7235a = null;
        this.f7236b = null;
        this.f7241g = null;
        this.f7242h = null;
        this.k = null;
    }

    public BusLineResult(Parcel parcel) {
        this.f7235a = null;
        this.f7236b = null;
        this.f7241g = null;
        this.f7242h = null;
        this.k = null;
        this.f7235a = parcel.readString();
        this.f7236b = parcel.readString();
        this.f7237c = ((Boolean) parcel.readValue(Boolean.class.getClassLoader())).booleanValue();
        this.f7238d = (Date) parcel.readValue(Date.class.getClassLoader());
        this.f7239e = (Date) parcel.readValue(Date.class.getClassLoader());
        this.f7240f = parcel.readString();
        this.f7241g = parcel.readArrayList(BusStation.class.getClassLoader());
        this.f7242h = parcel.readArrayList(RouteStep.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getBasePrice() {
        return this.f7243i;
    }

    public String getBusCompany() {
        return this.f7235a;
    }

    public String getBusLineName() {
        return this.f7236b;
    }

    public Date getEndTime() {
        return this.f7239e;
    }

    public String getLineDirection() {
        return this.k;
    }

    public float getMaxPrice() {
        return this.j;
    }

    public Date getStartTime() {
        return this.f7238d;
    }

    public List<BusStation> getStations() {
        return this.f7241g;
    }

    public List<BusStep> getSteps() {
        return this.f7242h;
    }

    public String getUid() {
        return this.f7240f;
    }

    public boolean isMonthTicket() {
        return this.f7237c;
    }

    public void setBasePrice(float f2) {
        this.f7243i = f2;
    }

    public void setBusLineName(String str) {
        this.f7236b = str;
    }

    public void setEndTime(Date date) {
        this.f7239e = date;
    }

    public void setLineDirection(String str) {
        this.k = str;
    }

    public void setMaxPrice(float f2) {
        this.j = f2;
    }

    public void setMonthTicket(boolean z) {
        this.f7237c = z;
    }

    public void setStartTime(Date date) {
        this.f7238d = date;
    }

    public void setStations(List<BusStation> list) {
        this.f7241g = list;
    }

    public void setSteps(List<BusStep> list) {
        this.f7242h = list;
    }

    public void setUid(String str) {
        this.f7240f = str;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f7235a);
        parcel.writeString(this.f7236b);
        parcel.writeValue(Boolean.valueOf(this.f7237c));
        parcel.writeValue(this.f7238d);
        parcel.writeValue(this.f7239e);
        parcel.writeString(this.f7240f);
        parcel.writeList(this.f7241g);
        parcel.writeList(this.f7242h);
    }
}
