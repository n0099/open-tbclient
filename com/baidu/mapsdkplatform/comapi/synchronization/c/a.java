package com.baidu.mapsdkplatform.comapi.synchronization.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes4.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> a = new b();
    private long b;
    private LatLng c;
    private LatLng d;
    private int e;

    public a() {
        this.b = 0L;
        this.e = 0;
        this.b = 0L;
        this.c = null;
        this.d = null;
        this.e = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Parcel parcel) {
        this.b = 0L;
        this.e = 0;
        this.b = parcel.readLong();
        this.c = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.d = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.e = parcel.readInt();
    }

    public LatLng a() {
        return this.c;
    }

    public void a(int i) {
        this.e = i;
    }

    public void a(LatLng latLng) {
        this.c = latLng;
    }

    public LatLng b() {
        return this.d;
    }

    public void b(LatLng latLng) {
        this.d = latLng;
    }

    public int c() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.b);
        parcel.writeParcelable(this.c, i);
        parcel.writeParcelable(this.d, i);
        parcel.writeInt(this.e);
    }
}
