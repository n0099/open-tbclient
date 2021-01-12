package com.baidu.mapsdkplatform.comapi.synchronization.render;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes6.dex */
public final class LinkPointPolyLineInfo implements Parcelable {
    public static final Parcelable.Creator<LinkPointPolyLineInfo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private long f3135a;

    /* renamed from: b  reason: collision with root package name */
    private LatLng f3136b;
    private LatLng c;
    private int d;

    public LinkPointPolyLineInfo() {
        this.f3135a = 0L;
        this.d = 0;
        this.f3135a = 0L;
        this.f3136b = null;
        this.c = null;
        this.d = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LinkPointPolyLineInfo(Parcel parcel) {
        this.f3135a = 0L;
        this.d = 0;
        this.f3135a = parcel.readLong();
        this.f3136b = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.c = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.d = parcel.readInt();
    }

    public LatLng a() {
        return this.f3136b;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(LatLng latLng) {
        this.f3136b = latLng;
    }

    public LatLng b() {
        return this.c;
    }

    public void b(LatLng latLng) {
        this.c = latLng;
    }

    public int c() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f3135a);
        parcel.writeParcelable(this.f3136b, i);
        parcel.writeParcelable(this.c, i);
        parcel.writeInt(this.d);
    }
}
