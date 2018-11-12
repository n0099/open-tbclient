package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes4.dex */
public class m extends TransitBaseInfo {
    public static final Parcelable.Creator<m> a = new n();
    private double b;
    private String c;

    public m() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public m(Parcel parcel) {
        super(parcel);
        this.b = parcel.readDouble();
        this.c = parcel.readString();
    }

    public void a(double d) {
        this.b = d;
    }

    public void a(String str) {
        this.c = str;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeDouble(this.b);
        parcel.writeString(this.c);
    }
}
