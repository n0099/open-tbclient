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
    public boolean f7758a;

    /* renamed from: b  reason: collision with root package name */
    public String f7759b;

    /* renamed from: c  reason: collision with root package name */
    public CopyOnWriteArrayList<RouteSectionInfo> f7760c;

    /* loaded from: classes2.dex */
    public static final class RouteSectionInfo implements Parcelable {
        public static final Parcelable.Creator<RouteSectionInfo> CREATOR = new c();

        /* renamed from: a  reason: collision with root package name */
        public LatLng f7761a;

        /* renamed from: b  reason: collision with root package name */
        public LatLng f7762b;

        public RouteSectionInfo() {
            this.f7761a = null;
            this.f7762b = null;
            this.f7761a = null;
            this.f7762b = null;
        }

        public RouteSectionInfo(Parcel parcel) {
            this.f7761a = null;
            this.f7762b = null;
            this.f7761a = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.f7762b = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        }

        public LatLng a() {
            return this.f7761a;
        }

        public void a(LatLng latLng) {
            this.f7761a = latLng;
        }

        public LatLng b() {
            return this.f7762b;
        }

        public void b(LatLng latLng) {
            this.f7762b = latLng;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f7761a, i);
            parcel.writeParcelable(this.f7762b, i);
        }
    }

    public RouteLineInfo() {
        this.f7758a = false;
        this.f7759b = null;
        this.f7760c = new CopyOnWriteArrayList<>();
    }

    public RouteLineInfo(Parcel parcel) {
        this.f7758a = parcel.readByte() != 0;
        this.f7759b = parcel.readString();
    }

    public String a() {
        return this.f7759b;
    }

    public void a(RouteSectionInfo routeSectionInfo) {
        CopyOnWriteArrayList<RouteSectionInfo> copyOnWriteArrayList = this.f7760c;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.add(routeSectionInfo);
        }
    }

    public void a(String str) {
        this.f7759b = str;
    }

    public void a(boolean z) {
        this.f7758a = z;
    }

    public List<RouteSectionInfo> b() {
        return this.f7760c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.f7758a ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f7759b);
        parcel.writeTypedList(this.f7760c);
    }
}
