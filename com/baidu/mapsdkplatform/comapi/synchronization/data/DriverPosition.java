package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes6.dex */
public final class DriverPosition implements Parcelable {
    public static final Parcelable.Creator<DriverPosition> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f3106a;

    /* renamed from: b  reason: collision with root package name */
    private LatLng f3107b;
    private double c;
    private double d;
    private int e;

    public DriverPosition() {
        this.f3106a = null;
        this.f3107b = null;
        this.c = 0.0d;
        this.d = 0.0d;
        this.e = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DriverPosition(Parcel parcel) {
        this.f3106a = parcel.readString();
        this.f3107b = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
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
        return this.f3107b;
    }

    public double getSpeed() {
        return this.d;
    }

    public String getTimeStamp() {
        return this.f3106a;
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
        this.f3107b = latLng;
    }

    public void setSpeed(double d) {
        this.d = d;
    }

    public void setTimeStamp(String str) {
        this.f3106a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3106a);
        parcel.writeParcelable(this.f3107b, i);
        parcel.writeDouble(this.c);
        parcel.writeDouble(this.d);
        parcel.writeInt(this.e);
    }
}
