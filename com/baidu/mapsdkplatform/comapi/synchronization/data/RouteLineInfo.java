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
    public boolean f7872a;

    /* renamed from: b  reason: collision with root package name */
    public String f7873b;

    /* renamed from: c  reason: collision with root package name */
    public CopyOnWriteArrayList<RouteSectionInfo> f7874c;

    /* loaded from: classes2.dex */
    public static final class RouteSectionInfo implements Parcelable {
        public static final Parcelable.Creator<RouteSectionInfo> CREATOR = new c();

        /* renamed from: a  reason: collision with root package name */
        public LatLng f7875a;

        /* renamed from: b  reason: collision with root package name */
        public LatLng f7876b;

        public RouteSectionInfo() {
            this.f7875a = null;
            this.f7876b = null;
            this.f7875a = null;
            this.f7876b = null;
        }

        public RouteSectionInfo(Parcel parcel) {
            this.f7875a = null;
            this.f7876b = null;
            this.f7875a = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.f7876b = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        }

        public LatLng a() {
            return this.f7875a;
        }

        public void a(LatLng latLng) {
            this.f7875a = latLng;
        }

        public LatLng b() {
            return this.f7876b;
        }

        public void b(LatLng latLng) {
            this.f7876b = latLng;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeParcelable(this.f7875a, i2);
            parcel.writeParcelable(this.f7876b, i2);
        }
    }

    public RouteLineInfo() {
        this.f7872a = false;
        this.f7873b = null;
        this.f7874c = new CopyOnWriteArrayList<>();
    }

    public RouteLineInfo(Parcel parcel) {
        this.f7872a = parcel.readByte() != 0;
        this.f7873b = parcel.readString();
    }

    public String a() {
        return this.f7873b;
    }

    public void a(RouteSectionInfo routeSectionInfo) {
        CopyOnWriteArrayList<RouteSectionInfo> copyOnWriteArrayList = this.f7874c;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.add(routeSectionInfo);
        }
    }

    public void a(String str) {
        this.f7873b = str;
    }

    public void a(boolean z) {
        this.f7872a = z;
    }

    public List<RouteSectionInfo> b() {
        return this.f7874c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByte(this.f7872a ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f7873b);
        parcel.writeTypedList(this.f7874c);
    }
}
