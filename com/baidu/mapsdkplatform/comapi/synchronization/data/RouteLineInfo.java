package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public final class RouteLineInfo implements Parcelable {
    public static final Parcelable.Creator<RouteLineInfo> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    public boolean f8075a;

    /* renamed from: b  reason: collision with root package name */
    public String f8076b;

    /* renamed from: c  reason: collision with root package name */
    public CopyOnWriteArrayList<RouteSectionInfo> f8077c;

    /* loaded from: classes2.dex */
    public static final class RouteSectionInfo implements Parcelable {
        public static final Parcelable.Creator<RouteSectionInfo> CREATOR = new c();

        /* renamed from: a  reason: collision with root package name */
        public LatLng f8078a;

        /* renamed from: b  reason: collision with root package name */
        public LatLng f8079b;

        public RouteSectionInfo() {
            this.f8078a = null;
            this.f8079b = null;
            this.f8078a = null;
            this.f8079b = null;
        }

        public RouteSectionInfo(Parcel parcel) {
            this.f8078a = null;
            this.f8079b = null;
            this.f8078a = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.f8079b = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        }

        public LatLng a() {
            return this.f8078a;
        }

        public void a(LatLng latLng) {
            this.f8078a = latLng;
        }

        public LatLng b() {
            return this.f8079b;
        }

        public void b(LatLng latLng) {
            this.f8079b = latLng;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeParcelable(this.f8078a, i2);
            parcel.writeParcelable(this.f8079b, i2);
        }
    }

    public RouteLineInfo() {
        this.f8075a = false;
        this.f8076b = null;
        this.f8077c = new CopyOnWriteArrayList<>();
    }

    public RouteLineInfo(Parcel parcel) {
        this.f8075a = parcel.readByte() != 0;
        this.f8076b = parcel.readString();
    }

    public String a() {
        return this.f8076b;
    }

    public void a(RouteSectionInfo routeSectionInfo) {
        CopyOnWriteArrayList<RouteSectionInfo> copyOnWriteArrayList = this.f8077c;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.add(routeSectionInfo);
        }
    }

    public void a(String str) {
        this.f8076b = str;
    }

    public void a(boolean z) {
        this.f8075a = z;
    }

    public List<RouteSectionInfo> b() {
        return this.f8077c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByte(this.f8075a ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f8076b);
        parcel.writeTypedList(this.f8077c);
    }
}
