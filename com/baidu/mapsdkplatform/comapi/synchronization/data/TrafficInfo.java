package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class TrafficInfo implements Parcelable {
    public static final Parcelable.Creator<TrafficInfo> CREATOR = new n();

    /* renamed from: a  reason: collision with root package name */
    public boolean f7772a;

    /* renamed from: b  reason: collision with root package name */
    public String f7773b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<Integer> f7774c;

    public TrafficInfo() {
        this.f7772a = false;
        this.f7773b = null;
        this.f7772a = false;
        this.f7773b = null;
        this.f7774c = new ArrayList<>();
    }

    public TrafficInfo(Parcel parcel) {
        this.f7772a = false;
        this.f7773b = null;
        this.f7772a = parcel.readByte() != 0;
        this.f7773b = parcel.readString();
    }

    public String a() {
        return this.f7773b;
    }

    public void a(String str) {
        this.f7773b = str;
    }

    public void a(ArrayList<Integer> arrayList) {
        this.f7774c = arrayList;
    }

    public void a(boolean z) {
        this.f7772a = z;
    }

    public ArrayList<Integer> b() {
        return this.f7774c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.f7772a ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f7773b);
    }
}
