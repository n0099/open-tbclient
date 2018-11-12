package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public final class o implements Parcelable {
    public static final Parcelable.Creator<o> a = new p();
    private boolean b;
    private String c;
    private ArrayList<Integer> d;

    public o() {
        this.b = false;
        this.c = null;
        this.b = false;
        this.c = null;
        this.d = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public o(Parcel parcel) {
        this.b = false;
        this.c = null;
        this.b = parcel.readByte() != 0;
        this.c = parcel.readString();
    }

    public String a() {
        return this.c;
    }

    public void a(String str) {
        this.c = str;
    }

    public void a(ArrayList<Integer> arrayList) {
        this.d = arrayList;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public ArrayList<Integer> b() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (this.b ? 1 : 0));
        parcel.writeString(this.c);
    }
}
