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
    public String f7178a;

    /* renamed from: b  reason: collision with root package name */
    public String f7179b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f7180c;

    /* renamed from: d  reason: collision with root package name */
    public Date f7181d;

    /* renamed from: e  reason: collision with root package name */
    public Date f7182e;

    /* renamed from: f  reason: collision with root package name */
    public String f7183f;

    /* renamed from: g  reason: collision with root package name */
    public List<BusStation> f7184g;

    /* renamed from: h  reason: collision with root package name */
    public List<BusStep> f7185h;

    /* renamed from: i  reason: collision with root package name */
    public float f7186i;
    public float j;
    public String k;

    /* loaded from: classes2.dex */
    public static class BusStation extends RouteNode {
    }

    /* loaded from: classes2.dex */
    public static class BusStep extends RouteStep {
    }

    public BusLineResult() {
        this.f7178a = null;
        this.f7179b = null;
        this.f7184g = null;
        this.f7185h = null;
        this.k = null;
    }

    public BusLineResult(Parcel parcel) {
        this.f7178a = null;
        this.f7179b = null;
        this.f7184g = null;
        this.f7185h = null;
        this.k = null;
        this.f7178a = parcel.readString();
        this.f7179b = parcel.readString();
        this.f7180c = ((Boolean) parcel.readValue(Boolean.class.getClassLoader())).booleanValue();
        this.f7181d = (Date) parcel.readValue(Date.class.getClassLoader());
        this.f7182e = (Date) parcel.readValue(Date.class.getClassLoader());
        this.f7183f = parcel.readString();
        this.f7184g = parcel.readArrayList(BusStation.class.getClassLoader());
        this.f7185h = parcel.readArrayList(RouteStep.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getBasePrice() {
        return this.f7186i;
    }

    public String getBusCompany() {
        return this.f7178a;
    }

    public String getBusLineName() {
        return this.f7179b;
    }

    public Date getEndTime() {
        return this.f7182e;
    }

    public String getLineDirection() {
        return this.k;
    }

    public float getMaxPrice() {
        return this.j;
    }

    public Date getStartTime() {
        return this.f7181d;
    }

    public List<BusStation> getStations() {
        return this.f7184g;
    }

    public List<BusStep> getSteps() {
        return this.f7185h;
    }

    public String getUid() {
        return this.f7183f;
    }

    public boolean isMonthTicket() {
        return this.f7180c;
    }

    public void setBasePrice(float f2) {
        this.f7186i = f2;
    }

    public void setBusLineName(String str) {
        this.f7179b = str;
    }

    public void setEndTime(Date date) {
        this.f7182e = date;
    }

    public void setLineDirection(String str) {
        this.k = str;
    }

    public void setMaxPrice(float f2) {
        this.j = f2;
    }

    public void setMonthTicket(boolean z) {
        this.f7180c = z;
    }

    public void setStartTime(Date date) {
        this.f7181d = date;
    }

    public void setStations(List<BusStation> list) {
        this.f7184g = list;
    }

    public void setSteps(List<BusStep> list) {
        this.f7185h = list;
    }

    public void setUid(String str) {
        this.f7183f = str;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f7178a);
        parcel.writeString(this.f7179b);
        parcel.writeValue(Boolean.valueOf(this.f7180c));
        parcel.writeValue(this.f7181d);
        parcel.writeValue(this.f7182e);
        parcel.writeString(this.f7183f);
        parcel.writeList(this.f7184g);
        parcel.writeList(this.f7185h);
    }
}
