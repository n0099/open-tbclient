package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class TrafficInfo implements Parcelable {
    public static final Parcelable.Creator<TrafficInfo> CREATOR = new n();

    /* renamed from: a  reason: collision with root package name */
    public boolean f7886a;

    /* renamed from: b  reason: collision with root package name */
    public String f7887b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<Integer> f7888c;

    public TrafficInfo() {
        this.f7886a = false;
        this.f7887b = null;
        this.f7886a = false;
        this.f7887b = null;
        this.f7888c = new ArrayList<>();
    }

    public TrafficInfo(Parcel parcel) {
        this.f7886a = false;
        this.f7887b = null;
        this.f7886a = parcel.readByte() != 0;
        this.f7887b = parcel.readString();
    }

    public String a() {
        return this.f7887b;
    }

    public void a(String str) {
        this.f7887b = str;
    }

    public void a(ArrayList<Integer> arrayList) {
        this.f7888c = arrayList;
    }

    public void a(boolean z) {
        this.f7886a = z;
    }

    public ArrayList<Integer> b() {
        return this.f7888c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByte(this.f7886a ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f7887b);
    }
}
