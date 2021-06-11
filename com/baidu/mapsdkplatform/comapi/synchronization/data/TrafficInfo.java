package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class TrafficInfo implements Parcelable {
    public static final Parcelable.Creator<TrafficInfo> CREATOR = new n();

    /* renamed from: a  reason: collision with root package name */
    public boolean f7829a;

    /* renamed from: b  reason: collision with root package name */
    public String f7830b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<Integer> f7831c;

    public TrafficInfo() {
        this.f7829a = false;
        this.f7830b = null;
        this.f7829a = false;
        this.f7830b = null;
        this.f7831c = new ArrayList<>();
    }

    public TrafficInfo(Parcel parcel) {
        this.f7829a = false;
        this.f7830b = null;
        this.f7829a = parcel.readByte() != 0;
        this.f7830b = parcel.readString();
    }

    public String a() {
        return this.f7830b;
    }

    public void a(String str) {
        this.f7830b = str;
    }

    public void a(ArrayList<Integer> arrayList) {
        this.f7831c = arrayList;
    }

    public void a(boolean z) {
        this.f7829a = z;
    }

    public ArrayList<Integer> b() {
        return this.f7831c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByte(this.f7829a ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f7830b);
    }
}
