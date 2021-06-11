package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class DriverPosition implements Parcelable {
    public static final Parcelable.Creator<DriverPosition> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public String f7810a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f7811b;

    /* renamed from: c  reason: collision with root package name */
    public double f7812c;

    /* renamed from: d  reason: collision with root package name */
    public double f7813d;

    /* renamed from: e  reason: collision with root package name */
    public int f7814e;

    public DriverPosition() {
        this.f7810a = null;
        this.f7811b = null;
        this.f7812c = 0.0d;
        this.f7813d = 0.0d;
        this.f7814e = 0;
    }

    public DriverPosition(Parcel parcel) {
        this.f7810a = parcel.readString();
        this.f7811b = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f7812c = parcel.readDouble();
        this.f7813d = parcel.readDouble();
        this.f7814e = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double getAngle() {
        return this.f7812c;
    }

    public int getOrderStateInPosition() {
        return this.f7814e;
    }

    public LatLng getPoint() {
        return this.f7811b;
    }

    public double getSpeed() {
        return this.f7813d;
    }

    public String getTimeStamp() {
        return this.f7810a;
    }

    public void setAngle(double d2) {
        double d3 = 0.0d;
        if (d2 >= 0.0d) {
            d3 = 360.0d;
            if (d2 < 360.0d) {
                this.f7812c = d2;
                return;
            }
        }
        this.f7812c = d3;
    }

    public void setOrderStateInPosition(int i2) {
        this.f7814e = i2;
    }

    public void setPoint(LatLng latLng) {
        this.f7811b = latLng;
    }

    public void setSpeed(double d2) {
        this.f7813d = d2;
    }

    public void setTimeStamp(String str) {
        this.f7810a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f7810a);
        parcel.writeParcelable(this.f7811b, i2);
        parcel.writeDouble(this.f7812c);
        parcel.writeDouble(this.f7813d);
        parcel.writeInt(this.f7814e);
    }
}
