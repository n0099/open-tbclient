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
    public String f7127a;

    /* renamed from: b  reason: collision with root package name */
    public String f7128b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f7129c;

    /* renamed from: d  reason: collision with root package name */
    public Date f7130d;

    /* renamed from: e  reason: collision with root package name */
    public Date f7131e;

    /* renamed from: f  reason: collision with root package name */
    public String f7132f;

    /* renamed from: g  reason: collision with root package name */
    public List<BusStation> f7133g;

    /* renamed from: h  reason: collision with root package name */
    public List<BusStep> f7134h;
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
        this.f7127a = null;
        this.f7128b = null;
        this.f7133g = null;
        this.f7134h = null;
        this.k = null;
    }

    public BusLineResult(Parcel parcel) {
        this.f7127a = null;
        this.f7128b = null;
        this.f7133g = null;
        this.f7134h = null;
        this.k = null;
        this.f7127a = parcel.readString();
        this.f7128b = parcel.readString();
        this.f7129c = ((Boolean) parcel.readValue(Boolean.class.getClassLoader())).booleanValue();
        this.f7130d = (Date) parcel.readValue(Date.class.getClassLoader());
        this.f7131e = (Date) parcel.readValue(Date.class.getClassLoader());
        this.f7132f = parcel.readString();
        this.f7133g = parcel.readArrayList(BusStation.class.getClassLoader());
        this.f7134h = parcel.readArrayList(RouteStep.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getBasePrice() {
        return this.i;
    }

    public String getBusCompany() {
        return this.f7127a;
    }

    public String getBusLineName() {
        return this.f7128b;
    }

    public Date getEndTime() {
        return this.f7131e;
    }

    public String getLineDirection() {
        return this.k;
    }

    public float getMaxPrice() {
        return this.j;
    }

    public Date getStartTime() {
        return this.f7130d;
    }

    public List<BusStation> getStations() {
        return this.f7133g;
    }

    public List<BusStep> getSteps() {
        return this.f7134h;
    }

    public String getUid() {
        return this.f7132f;
    }

    public boolean isMonthTicket() {
        return this.f7129c;
    }

    public void setBasePrice(float f2) {
        this.i = f2;
    }

    public void setBusLineName(String str) {
        this.f7128b = str;
    }

    public void setEndTime(Date date) {
        this.f7131e = date;
    }

    public void setLineDirection(String str) {
        this.k = str;
    }

    public void setMaxPrice(float f2) {
        this.j = f2;
    }

    public void setMonthTicket(boolean z) {
        this.f7129c = z;
    }

    public void setStartTime(Date date) {
        this.f7130d = date;
    }

    public void setStations(List<BusStation> list) {
        this.f7133g = list;
    }

    public void setSteps(List<BusStep> list) {
        this.f7134h = list;
    }

    public void setUid(String str) {
        this.f7132f = str;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7127a);
        parcel.writeString(this.f7128b);
        parcel.writeValue(Boolean.valueOf(this.f7129c));
        parcel.writeValue(this.f7130d);
        parcel.writeValue(this.f7131e);
        parcel.writeString(this.f7132f);
        parcel.writeList(this.f7133g);
        parcel.writeList(this.f7134h);
    }
}
