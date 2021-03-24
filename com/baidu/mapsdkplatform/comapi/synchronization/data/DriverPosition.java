package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class DriverPosition implements Parcelable {
    public static final Parcelable.Creator<DriverPosition> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public String f7753a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f7754b;

    /* renamed from: c  reason: collision with root package name */
    public double f7755c;

    /* renamed from: d  reason: collision with root package name */
    public double f7756d;

    /* renamed from: e  reason: collision with root package name */
    public int f7757e;

    public DriverPosition() {
        this.f7753a = null;
        this.f7754b = null;
        this.f7755c = 0.0d;
        this.f7756d = 0.0d;
        this.f7757e = 0;
    }

    public DriverPosition(Parcel parcel) {
        this.f7753a = parcel.readString();
        this.f7754b = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f7755c = parcel.readDouble();
        this.f7756d = parcel.readDouble();
        this.f7757e = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double getAngle() {
        return this.f7755c;
    }

    public int getOrderStateInPosition() {
        return this.f7757e;
    }

    public LatLng getPoint() {
        return this.f7754b;
    }

    public double getSpeed() {
        return this.f7756d;
    }

    public String getTimeStamp() {
        return this.f7753a;
    }

    public void setAngle(double d2) {
        double d3 = 0.0d;
        if (d2 >= 0.0d) {
            d3 = 360.0d;
            if (d2 < 360.0d) {
                this.f7755c = d2;
                return;
            }
        }
        this.f7755c = d3;
    }

    public void setOrderStateInPosition(int i) {
        this.f7757e = i;
    }

    public void setPoint(LatLng latLng) {
        this.f7754b = latLng;
    }

    public void setSpeed(double d2) {
        this.f7756d = d2;
    }

    public void setTimeStamp(String str) {
        this.f7753a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7753a);
        parcel.writeParcelable(this.f7754b, i);
        parcel.writeDouble(this.f7755c);
        parcel.writeDouble(this.f7756d);
        parcel.writeInt(this.f7757e);
    }
}
