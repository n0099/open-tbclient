package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class TrafficInfo implements Parcelable {
    public static final Parcelable.Creator<TrafficInfo> CREATOR = new n();

    /* renamed from: a  reason: collision with root package name */
    public boolean f7771a;

    /* renamed from: b  reason: collision with root package name */
    public String f7772b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<Integer> f7773c;

    public TrafficInfo() {
        this.f7771a = false;
        this.f7772b = null;
        this.f7771a = false;
        this.f7772b = null;
        this.f7773c = new ArrayList<>();
    }

    public TrafficInfo(Parcel parcel) {
        this.f7771a = false;
        this.f7772b = null;
        this.f7771a = parcel.readByte() != 0;
        this.f7772b = parcel.readString();
    }

    public String a() {
        return this.f7772b;
    }

    public void a(String str) {
        this.f7772b = str;
    }

    public void a(ArrayList<Integer> arrayList) {
        this.f7773c = arrayList;
    }

    public void a(boolean z) {
        this.f7771a = z;
    }

    public ArrayList<Integer> b() {
        return this.f7773c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.f7771a ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f7772b);
    }
}
