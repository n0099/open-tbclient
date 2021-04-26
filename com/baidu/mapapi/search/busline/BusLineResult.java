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
    public String f7418a;

    /* renamed from: b  reason: collision with root package name */
    public String f7419b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f7420c;

    /* renamed from: d  reason: collision with root package name */
    public Date f7421d;

    /* renamed from: e  reason: collision with root package name */
    public Date f7422e;

    /* renamed from: f  reason: collision with root package name */
    public String f7423f;

    /* renamed from: g  reason: collision with root package name */
    public List<BusStation> f7424g;

    /* renamed from: h  reason: collision with root package name */
    public List<BusStep> f7425h;

    /* renamed from: i  reason: collision with root package name */
    public float f7426i;
    public float j;
    public String k;

    /* loaded from: classes2.dex */
    public static class BusStation extends RouteNode {
    }

    /* loaded from: classes2.dex */
    public static class BusStep extends RouteStep {
    }

    public BusLineResult() {
        this.f7418a = null;
        this.f7419b = null;
        this.f7424g = null;
        this.f7425h = null;
        this.k = null;
    }

    public BusLineResult(Parcel parcel) {
        this.f7418a = null;
        this.f7419b = null;
        this.f7424g = null;
        this.f7425h = null;
        this.k = null;
        this.f7418a = parcel.readString();
        this.f7419b = parcel.readString();
        this.f7420c = ((Boolean) parcel.readValue(Boolean.class.getClassLoader())).booleanValue();
        this.f7421d = (Date) parcel.readValue(Date.class.getClassLoader());
        this.f7422e = (Date) parcel.readValue(Date.class.getClassLoader());
        this.f7423f = parcel.readString();
        this.f7424g = parcel.readArrayList(BusStation.class.getClassLoader());
        this.f7425h = parcel.readArrayList(RouteStep.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getBasePrice() {
        return this.f7426i;
    }

    public String getBusCompany() {
        return this.f7418a;
    }

    public String getBusLineName() {
        return this.f7419b;
    }

    public Date getEndTime() {
        return this.f7422e;
    }

    public String getLineDirection() {
        return this.k;
    }

    public float getMaxPrice() {
        return this.j;
    }

    public Date getStartTime() {
        return this.f7421d;
    }

    public List<BusStation> getStations() {
        return this.f7424g;
    }

    public List<BusStep> getSteps() {
        return this.f7425h;
    }

    public String getUid() {
        return this.f7423f;
    }

    public boolean isMonthTicket() {
        return this.f7420c;
    }

    public void setBasePrice(float f2) {
        this.f7426i = f2;
    }

    public void setBusLineName(String str) {
        this.f7419b = str;
    }

    public void setEndTime(Date date) {
        this.f7422e = date;
    }

    public void setLineDirection(String str) {
        this.k = str;
    }

    public void setMaxPrice(float f2) {
        this.j = f2;
    }

    public void setMonthTicket(boolean z) {
        this.f7420c = z;
    }

    public void setStartTime(Date date) {
        this.f7421d = date;
    }

    public void setStations(List<BusStation> list) {
        this.f7424g = list;
    }

    public void setSteps(List<BusStep> list) {
        this.f7425h = list;
    }

    public void setUid(String str) {
        this.f7423f = str;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f7418a);
        parcel.writeString(this.f7419b);
        parcel.writeValue(Boolean.valueOf(this.f7420c));
        parcel.writeValue(this.f7421d);
        parcel.writeValue(this.f7422e);
        parcel.writeString(this.f7423f);
        parcel.writeList(this.f7424g);
        parcel.writeList(this.f7425h);
    }
}
