package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class DriverPosition implements Parcelable {
    public static final Parcelable.Creator<DriverPosition> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public String f8070a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f8071b;

    /* renamed from: c  reason: collision with root package name */
    public double f8072c;

    /* renamed from: d  reason: collision with root package name */
    public double f8073d;

    /* renamed from: e  reason: collision with root package name */
    public int f8074e;

    public DriverPosition() {
        this.f8070a = null;
        this.f8071b = null;
        this.f8072c = 0.0d;
        this.f8073d = 0.0d;
        this.f8074e = 0;
    }

    public DriverPosition(Parcel parcel) {
        this.f8070a = parcel.readString();
        this.f8071b = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f8072c = parcel.readDouble();
        this.f8073d = parcel.readDouble();
        this.f8074e = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double getAngle() {
        return this.f8072c;
    }

    public int getOrderStateInPosition() {
        return this.f8074e;
    }

    public LatLng getPoint() {
        return this.f8071b;
    }

    public double getSpeed() {
        return this.f8073d;
    }

    public String getTimeStamp() {
        return this.f8070a;
    }

    public void setAngle(double d2) {
        double d3 = 0.0d;
        if (d2 >= 0.0d) {
            d3 = 360.0d;
            if (d2 < 360.0d) {
                this.f8072c = d2;
                return;
            }
        }
        this.f8072c = d3;
    }

    public void setOrderStateInPosition(int i2) {
        this.f8074e = i2;
    }

    public void setPoint(LatLng latLng) {
        this.f8071b = latLng;
    }

    public void setSpeed(double d2) {
        this.f8073d = d2;
    }

    public void setTimeStamp(String str) {
        this.f8070a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f8070a);
        parcel.writeParcelable(this.f8071b, i2);
        parcel.writeDouble(this.f8072c);
        parcel.writeDouble(this.f8073d);
        parcel.writeInt(this.f8074e);
    }
}
