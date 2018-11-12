package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes4.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> a = new c();
    private boolean b;
    private String c;
    private CopyOnWriteArrayList<a> d;

    /* loaded from: classes4.dex */
    public static final class a implements Parcelable {
        public static final Parcelable.Creator<a> a = new d();
        private LatLng b;
        private LatLng c;

        public a() {
            this.b = null;
            this.c = null;
            this.b = null;
            this.c = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public a(Parcel parcel) {
            this.b = null;
            this.c = null;
            this.b = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.c = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        }

        public LatLng a() {
            return this.b;
        }

        public void a(LatLng latLng) {
            this.b = latLng;
        }

        public LatLng b() {
            return this.c;
        }

        public void b(LatLng latLng) {
            this.c = latLng;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.b, i);
            parcel.writeParcelable(this.c, i);
        }
    }

    public b() {
        this.b = false;
        this.c = null;
        this.d = new CopyOnWriteArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Parcel parcel) {
        this.b = parcel.readByte() != 0;
        this.c = parcel.readString();
    }

    public String a() {
        return this.c;
    }

    public void a(a aVar) {
        if (this.d != null) {
            this.d.add(aVar);
        }
    }

    public void a(String str) {
        this.c = str;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public List<a> b() {
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
        parcel.writeTypedList(this.d);
    }
}
