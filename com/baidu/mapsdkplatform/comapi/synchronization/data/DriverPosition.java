package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class DriverPosition implements Parcelable {
    public static final Parcelable.Creator<DriverPosition> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public String f7789a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f7790b;

    /* renamed from: c  reason: collision with root package name */
    public double f7791c;

    /* renamed from: d  reason: collision with root package name */
    public double f7792d;

    /* renamed from: e  reason: collision with root package name */
    public int f7793e;

    public DriverPosition() {
        this.f7789a = null;
        this.f7790b = null;
        this.f7791c = 0.0d;
        this.f7792d = 0.0d;
        this.f7793e = 0;
    }

    public DriverPosition(Parcel parcel) {
        this.f7789a = parcel.readString();
        this.f7790b = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f7791c = parcel.readDouble();
        this.f7792d = parcel.readDouble();
        this.f7793e = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double getAngle() {
        return this.f7791c;
    }

    public int getOrderStateInPosition() {
        return this.f7793e;
    }

    public LatLng getPoint() {
        return this.f7790b;
    }

    public double getSpeed() {
        return this.f7792d;
    }

    public String getTimeStamp() {
        return this.f7789a;
    }

    public void setAngle(double d2) {
        double d3 = 0.0d;
        if (d2 >= 0.0d) {
            d3 = 360.0d;
            if (d2 < 360.0d) {
                this.f7791c = d2;
                return;
            }
        }
        this.f7791c = d3;
    }

    public void setOrderStateInPosition(int i) {
        this.f7793e = i;
    }

    public void setPoint(LatLng latLng) {
        this.f7790b = latLng;
    }

    public void setSpeed(double d2) {
        this.f7792d = d2;
    }

    public void setTimeStamp(String str) {
        this.f7789a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7789a);
        parcel.writeParcelable(this.f7790b, i);
        parcel.writeDouble(this.f7791c);
        parcel.writeDouble(this.f7792d);
        parcel.writeInt(this.f7793e);
    }
}
