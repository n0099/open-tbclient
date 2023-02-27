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
    public String a;
    public String b;
    public boolean c;
    public Date d;
    public Date e;
    public String f;
    public List<BusStation> g;
    public List<BusStep> h;
    public float i;
    public float j;
    public String k;

    /* loaded from: classes2.dex */
    public static class BusStation extends RouteNode {
    }

    /* loaded from: classes2.dex */
    public static class BusStep extends RouteStep {
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BusLineResult() {
        this.a = null;
        this.b = null;
        this.g = null;
        this.h = null;
        this.k = null;
    }

    public float getBasePrice() {
        return this.i;
    }

    public String getBusCompany() {
        return this.a;
    }

    public String getBusLineName() {
        return this.b;
    }

    public Date getEndTime() {
        return this.e;
    }

    public String getLineDirection() {
        return this.k;
    }

    public float getMaxPrice() {
        return this.j;
    }

    public Date getStartTime() {
        return this.d;
    }

    public List<BusStation> getStations() {
        return this.g;
    }

    public List<BusStep> getSteps() {
        return this.h;
    }

    public String getUid() {
        return this.f;
    }

    public boolean isMonthTicket() {
        return this.c;
    }

    public BusLineResult(Parcel parcel) {
        this.a = null;
        this.b = null;
        this.g = null;
        this.h = null;
        this.k = null;
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = ((Boolean) parcel.readValue(Boolean.class.getClassLoader())).booleanValue();
        this.d = (Date) parcel.readValue(Date.class.getClassLoader());
        this.e = (Date) parcel.readValue(Date.class.getClassLoader());
        this.f = parcel.readString();
        this.g = parcel.readArrayList(BusStation.class.getClassLoader());
        this.h = parcel.readArrayList(RouteStep.class.getClassLoader());
    }

    public void setBasePrice(float f) {
        this.i = f;
    }

    public void setBusLineName(String str) {
        this.b = str;
    }

    public void setEndTime(Date date) {
        this.e = date;
    }

    public void setLineDirection(String str) {
        this.k = str;
    }

    public void setMaxPrice(float f) {
        this.j = f;
    }

    public void setMonthTicket(boolean z) {
        this.c = z;
    }

    public void setStartTime(Date date) {
        this.d = date;
    }

    public void setStations(List<BusStation> list) {
        this.g = list;
    }

    public void setSteps(List<BusStep> list) {
        this.h = list;
    }

    public void setUid(String str) {
        this.f = str;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeValue(Boolean.valueOf(this.c));
        parcel.writeValue(this.d);
        parcel.writeValue(this.e);
        parcel.writeString(this.f);
        parcel.writeList(this.g);
        parcel.writeList(this.h);
    }
}
