package com.baidu.ar.marker.a;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.baidu.ar.marker.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: O */
        public a[] newArray(int i) {
            return new a[i];
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }
    };
    public int position;
    public String tm;
    public String tn;
    public String to;
    public double[] tp;
    public String tq;
    public float tr;
    public float ts;
    public int tt;
    public String tu;

    public a(Parcel parcel) {
        this.tm = parcel.readString();
        this.tn = parcel.readString();
        this.to = parcel.readString();
        this.tp = parcel.createDoubleArray();
        this.tq = parcel.readString();
        this.tr = parcel.readFloat();
        this.ts = parcel.readFloat();
        this.tt = parcel.readInt();
        this.position = parcel.readInt();
        this.tu = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.tm);
        parcel.writeString(this.tn);
        parcel.writeString(this.to);
        parcel.writeDoubleArray(this.tp);
        parcel.writeString(this.tq);
        parcel.writeFloat(this.tr);
        parcel.writeFloat(this.ts);
        parcel.writeInt(this.tt);
        parcel.writeInt(this.position);
        parcel.writeString(this.tu);
    }
}
