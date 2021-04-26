package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class TrafficInfo implements Parcelable {
    public static final Parcelable.Creator<TrafficInfo> CREATOR = new n();

    /* renamed from: a  reason: collision with root package name */
    public boolean f8089a;

    /* renamed from: b  reason: collision with root package name */
    public String f8090b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<Integer> f8091c;

    public TrafficInfo() {
        this.f8089a = false;
        this.f8090b = null;
        this.f8089a = false;
        this.f8090b = null;
        this.f8091c = new ArrayList<>();
    }

    public TrafficInfo(Parcel parcel) {
        this.f8089a = false;
        this.f8090b = null;
        this.f8089a = parcel.readByte() != 0;
        this.f8090b = parcel.readString();
    }

    public String a() {
        return this.f8090b;
    }

    public void a(String str) {
        this.f8090b = str;
    }

    public void a(ArrayList<Integer> arrayList) {
        this.f8091c = arrayList;
    }

    public void a(boolean z) {
        this.f8089a = z;
    }

    public ArrayList<Integer> b() {
        return this.f8091c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByte(this.f8089a ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f8090b);
    }
}
