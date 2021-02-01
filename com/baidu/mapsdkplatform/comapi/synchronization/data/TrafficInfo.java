package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public final class TrafficInfo implements Parcelable {
    public static final Parcelable.Creator<TrafficInfo> CREATOR = new n();

    /* renamed from: a  reason: collision with root package name */
    private boolean f3112a;

    /* renamed from: b  reason: collision with root package name */
    private String f3113b;
    private ArrayList<Integer> c;

    public TrafficInfo() {
        this.f3112a = false;
        this.f3113b = null;
        this.f3112a = false;
        this.f3113b = null;
        this.c = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TrafficInfo(Parcel parcel) {
        this.f3112a = false;
        this.f3113b = null;
        this.f3112a = parcel.readByte() != 0;
        this.f3113b = parcel.readString();
    }

    public String a() {
        return this.f3113b;
    }

    public void a(String str) {
        this.f3113b = str;
    }

    public void a(ArrayList<Integer> arrayList) {
        this.c = arrayList;
    }

    public void a(boolean z) {
        this.f3112a = z;
    }

    public ArrayList<Integer> b() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (this.f3112a ? 1 : 0));
        parcel.writeString(this.f3113b);
    }
}
