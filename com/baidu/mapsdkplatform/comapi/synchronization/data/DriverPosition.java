package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes10.dex */
public final class DriverPosition implements Parcelable {
    public static final Parcelable.Creator<DriverPosition> CREATOR = new a();
    private String a;
    private LatLng b;
    private double c;
    private double d;
    private int e;

    public DriverPosition() {
        this.a = null;
        this.b = null;
        this.c = 0.0d;
        this.d = 0.0d;
        this.e = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DriverPosition(Parcel parcel) {
        this.a = parcel.readString();
        this.b = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.c = parcel.readDouble();
        this.d = parcel.readDouble();
        this.e = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double getAngle() {
        return this.c;
    }

    public int getOrderStateInPosition() {
        return this.e;
    }

    public LatLng getPoint() {
        return this.b;
    }

    public double getSpeed() {
        return this.d;
    }

    public String getTimeStamp() {
        return this.a;
    }

    public void setAngle(double d) {
        if (d < 0.0d) {
            this.c = 0.0d;
        } else if (d >= 360.0d) {
            this.c = 360.0d;
        } else {
            this.c = d;
        }
    }

    public void setOrderStateInPosition(int i) {
        this.e = i;
    }

    public void setPoint(LatLng latLng) {
        this.b = latLng;
    }

    public void setSpeed(double d) {
        this.d = d;
    }

    public void setTimeStamp(String str) {
        this.a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeParcelable(this.b, i);
        parcel.writeDouble(this.c);
        parcel.writeDouble(this.d);
        parcel.writeInt(this.e);
    }
}
