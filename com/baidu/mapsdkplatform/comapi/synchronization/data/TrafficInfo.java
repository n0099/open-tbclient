package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class TrafficInfo implements Parcelable {
    public static final Parcelable.Creator<TrafficInfo> CREATOR = new n();
    private boolean a;
    private String b;
    private ArrayList<Integer> c;

    public TrafficInfo() {
        this.a = false;
        this.b = null;
        this.a = false;
        this.b = null;
        this.c = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TrafficInfo(Parcel parcel) {
        this.a = false;
        this.b = null;
        this.a = parcel.readByte() != 0;
        this.b = parcel.readString();
    }

    public String a() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(ArrayList<Integer> arrayList) {
        this.c = arrayList;
    }

    public void a(boolean z) {
        this.a = z;
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
        parcel.writeByte((byte) (this.a ? 1 : 0));
        parcel.writeString(this.b);
    }
}
