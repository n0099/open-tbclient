package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class TrafficInfo implements Parcelable {
    public static final Parcelable.Creator<TrafficInfo> CREATOR = new n();

    /* renamed from: a  reason: collision with root package name */
    public boolean f7786a;

    /* renamed from: b  reason: collision with root package name */
    public String f7787b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<Integer> f7788c;

    public TrafficInfo() {
        this.f7786a = false;
        this.f7787b = null;
        this.f7786a = false;
        this.f7787b = null;
        this.f7788c = new ArrayList<>();
    }

    public TrafficInfo(Parcel parcel) {
        this.f7786a = false;
        this.f7787b = null;
        this.f7786a = parcel.readByte() != 0;
        this.f7787b = parcel.readString();
    }

    public String a() {
        return this.f7787b;
    }

    public void a(String str) {
        this.f7787b = str;
    }

    public void a(ArrayList<Integer> arrayList) {
        this.f7788c = arrayList;
    }

    public void a(boolean z) {
        this.f7786a = z;
    }

    public ArrayList<Integer> b() {
        return this.f7788c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByte(this.f7786a ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f7787b);
    }
}
