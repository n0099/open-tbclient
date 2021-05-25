package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class DriverPosition implements Parcelable {
    public static final Parcelable.Creator<DriverPosition> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public String f7767a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f7768b;

    /* renamed from: c  reason: collision with root package name */
    public double f7769c;

    /* renamed from: d  reason: collision with root package name */
    public double f7770d;

    /* renamed from: e  reason: collision with root package name */
    public int f7771e;

    public DriverPosition() {
        this.f7767a = null;
        this.f7768b = null;
        this.f7769c = 0.0d;
        this.f7770d = 0.0d;
        this.f7771e = 0;
    }

    public DriverPosition(Parcel parcel) {
        this.f7767a = parcel.readString();
        this.f7768b = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f7769c = parcel.readDouble();
        this.f7770d = parcel.readDouble();
        this.f7771e = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double getAngle() {
        return this.f7769c;
    }

    public int getOrderStateInPosition() {
        return this.f7771e;
    }

    public LatLng getPoint() {
        return this.f7768b;
    }

    public double getSpeed() {
        return this.f7770d;
    }

    public String getTimeStamp() {
        return this.f7767a;
    }

    public void setAngle(double d2) {
        double d3 = 0.0d;
        if (d2 >= 0.0d) {
            d3 = 360.0d;
            if (d2 < 360.0d) {
                this.f7769c = d2;
                return;
            }
        }
        this.f7769c = d3;
    }

    public void setOrderStateInPosition(int i2) {
        this.f7771e = i2;
    }

    public void setPoint(LatLng latLng) {
        this.f7768b = latLng;
    }

    public void setSpeed(double d2) {
        this.f7770d = d2;
    }

    public void setTimeStamp(String str) {
        this.f7767a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f7767a);
        parcel.writeParcelable(this.f7768b, i2);
        parcel.writeDouble(this.f7769c);
        parcel.writeDouble(this.f7770d);
        parcel.writeInt(this.f7771e);
    }
}
