package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class DriverPosition implements Parcelable {
    public static final Parcelable.Creator<DriverPosition> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public String f7754a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f7755b;

    /* renamed from: c  reason: collision with root package name */
    public double f7756c;

    /* renamed from: d  reason: collision with root package name */
    public double f7757d;

    /* renamed from: e  reason: collision with root package name */
    public int f7758e;

    public DriverPosition() {
        this.f7754a = null;
        this.f7755b = null;
        this.f7756c = 0.0d;
        this.f7757d = 0.0d;
        this.f7758e = 0;
    }

    public DriverPosition(Parcel parcel) {
        this.f7754a = parcel.readString();
        this.f7755b = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f7756c = parcel.readDouble();
        this.f7757d = parcel.readDouble();
        this.f7758e = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double getAngle() {
        return this.f7756c;
    }

    public int getOrderStateInPosition() {
        return this.f7758e;
    }

    public LatLng getPoint() {
        return this.f7755b;
    }

    public double getSpeed() {
        return this.f7757d;
    }

    public String getTimeStamp() {
        return this.f7754a;
    }

    public void setAngle(double d2) {
        double d3 = 0.0d;
        if (d2 >= 0.0d) {
            d3 = 360.0d;
            if (d2 < 360.0d) {
                this.f7756c = d2;
                return;
            }
        }
        this.f7756c = d3;
    }

    public void setOrderStateInPosition(int i) {
        this.f7758e = i;
    }

    public void setPoint(LatLng latLng) {
        this.f7755b = latLng;
    }

    public void setSpeed(double d2) {
        this.f7757d = d2;
    }

    public void setTimeStamp(String str) {
        this.f7754a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7754a);
        parcel.writeParcelable(this.f7755b, i);
        parcel.writeDouble(this.f7756c);
        parcel.writeDouble(this.f7757d);
        parcel.writeInt(this.f7758e);
    }
}
