package com.baidu.ar.camera;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class CameraParams implements Parcelable {
    public static final Parcelable.Creator<CameraParams> CREATOR = new Parcelable.Creator<CameraParams>() { // from class: com.baidu.ar.camera.CameraParams.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CameraParams createFromParcel(Parcel parcel) {
            return new CameraParams(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CameraParams[] newArray(int i) {
            return new CameraParams[i];
        }
    };
    private int a;
    private boolean b;
    private boolean c;
    private double d;
    private int e;
    private int f;
    private boolean g;
    private int h;
    private boolean i;
    private boolean j;
    private int k;
    private int l;
    private int m;
    private boolean n;

    public CameraParams() {
        this.a = 0;
        this.b = true;
        this.c = true;
        this.d = 0.05d;
        this.e = 1280;
        this.f = 720;
        this.g = false;
        this.h = 30;
        this.i = false;
        this.j = true;
        this.k = 90;
        this.l = 1280;
        this.m = 720;
        this.n = true;
    }

    protected CameraParams(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readByte() != 0;
        this.c = parcel.readByte() != 0;
        this.d = parcel.readDouble();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = parcel.readByte() != 0;
        this.h = parcel.readInt();
        this.i = parcel.readByte() != 0;
        this.j = parcel.readByte() != 0;
        this.k = parcel.readInt();
        this.l = parcel.readInt();
        this.m = parcel.readInt();
        this.n = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double getAspectTolerance() {
        return this.d;
    }

    public int getCameraId() {
        return this.a;
    }

    public int getFrameRate() {
        return this.h;
    }

    public int getPictureHeight() {
        return this.m;
    }

    public int getPictureWidth() {
        return this.l;
    }

    public int getPreviewHeight() {
        return this.f;
    }

    public int getPreviewWidth() {
        return this.e;
    }

    public int getRotateDegree() {
        return this.k;
    }

    public boolean isAutoCorrectParams() {
        return this.b;
    }

    public boolean isAutoFocus() {
        return this.j;
    }

    public boolean isFrameRateCorrectUpward() {
        return this.i;
    }

    public boolean isKeepAspectRatio() {
        return this.c;
    }

    public boolean isPictureCorrectUpward() {
        return this.n;
    }

    public boolean isPreviewCorrectUpward() {
        return this.g;
    }

    public void setAspectTolerance(double d) {
        this.d = d;
    }

    public void setAutoCorrectParams(boolean z) {
        this.b = z;
    }

    public void setAutoFocus(boolean z) {
        this.j = z;
    }

    public void setCameraId(int i) {
        this.a = i;
    }

    public void setFrameRate(int i) {
        this.h = i;
    }

    public void setFrameRateCorrectUpward(boolean z) {
        this.i = z;
    }

    public void setKeepAspectRatio(boolean z) {
        this.c = z;
    }

    public void setPictureCorrectUpward(boolean z) {
        this.n = z;
    }

    public void setPictureHeight(int i) {
        this.m = i;
    }

    public void setPictureWidth(int i) {
        this.l = i;
    }

    public void setPreviewCorrectUpward(boolean z) {
        this.g = z;
    }

    public void setPreviewHeight(int i) {
        this.f = i;
    }

    public void setPreviewWidth(int i) {
        this.e = i;
    }

    public void setRotateDegree(int i) {
        this.k = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
        parcel.writeDouble(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        parcel.writeByte(this.g ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.h);
        parcel.writeByte(this.i ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.j ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m);
        parcel.writeByte(this.n ? (byte) 1 : (byte) 0);
    }
}
