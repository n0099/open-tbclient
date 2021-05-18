package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class DriverPosition implements Parcelable {
    public static final Parcelable.Creator<DriverPosition> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public String f7867a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f7868b;

    /* renamed from: c  reason: collision with root package name */
    public double f7869c;

    /* renamed from: d  reason: collision with root package name */
    public double f7870d;

    /* renamed from: e  reason: collision with root package name */
    public int f7871e;

    public DriverPosition() {
        this.f7867a = null;
        this.f7868b = null;
        this.f7869c = 0.0d;
        this.f7870d = 0.0d;
        this.f7871e = 0;
    }

    public DriverPosition(Parcel parcel) {
        this.f7867a = parcel.readString();
        this.f7868b = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f7869c = parcel.readDouble();
        this.f7870d = parcel.readDouble();
        this.f7871e = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double getAngle() {
        return this.f7869c;
    }

    public int getOrderStateInPosition() {
        return this.f7871e;
    }

    public LatLng getPoint() {
        return this.f7868b;
    }

    public double getSpeed() {
        return this.f7870d;
    }

    public String getTimeStamp() {
        return this.f7867a;
    }

    public void setAngle(double d2) {
        double d3 = 0.0d;
        if (d2 >= 0.0d) {
            d3 = 360.0d;
            if (d2 < 360.0d) {
                this.f7869c = d2;
                return;
            }
        }
        this.f7869c = d3;
    }

    public void setOrderStateInPosition(int i2) {
        this.f7871e = i2;
    }

    public void setPoint(LatLng latLng) {
        this.f7868b = latLng;
    }

    public void setSpeed(double d2) {
        this.f7870d = d2;
    }

    public void setTimeStamp(String str) {
        this.f7867a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f7867a);
        parcel.writeParcelable(this.f7868b, i2);
        parcel.writeDouble(this.f7869c);
        parcel.writeDouble(this.f7870d);
        parcel.writeInt(this.f7871e);
    }
}
