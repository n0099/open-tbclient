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
    public String f7128a;

    /* renamed from: b  reason: collision with root package name */
    public String f7129b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f7130c;

    /* renamed from: d  reason: collision with root package name */
    public Date f7131d;

    /* renamed from: e  reason: collision with root package name */
    public Date f7132e;

    /* renamed from: f  reason: collision with root package name */
    public String f7133f;

    /* renamed from: g  reason: collision with root package name */
    public List<BusStation> f7134g;

    /* renamed from: h  reason: collision with root package name */
    public List<BusStep> f7135h;
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
        this.f7128a = null;
        this.f7129b = null;
        this.f7134g = null;
        this.f7135h = null;
        this.k = null;
    }

    public BusLineResult(Parcel parcel) {
        this.f7128a = null;
        this.f7129b = null;
        this.f7134g = null;
        this.f7135h = null;
        this.k = null;
        this.f7128a = parcel.readString();
        this.f7129b = parcel.readString();
        this.f7130c = ((Boolean) parcel.readValue(Boolean.class.getClassLoader())).booleanValue();
        this.f7131d = (Date) parcel.readValue(Date.class.getClassLoader());
        this.f7132e = (Date) parcel.readValue(Date.class.getClassLoader());
        this.f7133f = parcel.readString();
        this.f7134g = parcel.readArrayList(BusStation.class.getClassLoader());
        this.f7135h = parcel.readArrayList(RouteStep.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getBasePrice() {
        return this.i;
    }

    public String getBusCompany() {
        return this.f7128a;
    }

    public String getBusLineName() {
        return this.f7129b;
    }

    public Date getEndTime() {
        return this.f7132e;
    }

    public String getLineDirection() {
        return this.k;
    }

    public float getMaxPrice() {
        return this.j;
    }

    public Date getStartTime() {
        return this.f7131d;
    }

    public List<BusStation> getStations() {
        return this.f7134g;
    }

    public List<BusStep> getSteps() {
        return this.f7135h;
    }

    public String getUid() {
        return this.f7133f;
    }

    public boolean isMonthTicket() {
        return this.f7130c;
    }

    public void setBasePrice(float f2) {
        this.i = f2;
    }

    public void setBusLineName(String str) {
        this.f7129b = str;
    }

    public void setEndTime(Date date) {
        this.f7132e = date;
    }

    public void setLineDirection(String str) {
        this.k = str;
    }

    public void setMaxPrice(float f2) {
        this.j = f2;
    }

    public void setMonthTicket(boolean z) {
        this.f7130c = z;
    }

    public void setStartTime(Date date) {
        this.f7131d = date;
    }

    public void setStations(List<BusStation> list) {
        this.f7134g = list;
    }

    public void setSteps(List<BusStep> list) {
        this.f7135h = list;
    }

    public void setUid(String str) {
        this.f7133f = str;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7128a);
        parcel.writeString(this.f7129b);
        parcel.writeValue(Boolean.valueOf(this.f7130c));
        parcel.writeValue(this.f7131d);
        parcel.writeValue(this.f7132e);
        parcel.writeString(this.f7133f);
        parcel.writeList(this.f7134g);
        parcel.writeList(this.f7135h);
    }
}
