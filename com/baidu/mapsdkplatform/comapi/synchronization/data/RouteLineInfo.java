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
    public boolean f7794a;

    /* renamed from: b  reason: collision with root package name */
    public String f7795b;

    /* renamed from: c  reason: collision with root package name */
    public CopyOnWriteArrayList<RouteSectionInfo> f7796c;

    /* loaded from: classes2.dex */
    public static final class RouteSectionInfo implements Parcelable {
        public static final Parcelable.Creator<RouteSectionInfo> CREATOR = new c();

        /* renamed from: a  reason: collision with root package name */
        public LatLng f7797a;

        /* renamed from: b  reason: collision with root package name */
        public LatLng f7798b;

        public RouteSectionInfo() {
            this.f7797a = null;
            this.f7798b = null;
            this.f7797a = null;
            this.f7798b = null;
        }

        public RouteSectionInfo(Parcel parcel) {
            this.f7797a = null;
            this.f7798b = null;
            this.f7797a = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.f7798b = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        }

        public LatLng a() {
            return this.f7797a;
        }

        public void a(LatLng latLng) {
            this.f7797a = latLng;
        }

        public LatLng b() {
            return this.f7798b;
        }

        public void b(LatLng latLng) {
            this.f7798b = latLng;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f7797a, i);
            parcel.writeParcelable(this.f7798b, i);
        }
    }

    public RouteLineInfo() {
        this.f7794a = false;
        this.f7795b = null;
        this.f7796c = new CopyOnWriteArrayList<>();
    }

    public RouteLineInfo(Parcel parcel) {
        this.f7794a = parcel.readByte() != 0;
        this.f7795b = parcel.readString();
    }

    public String a() {
        return this.f7795b;
    }

    public void a(RouteSectionInfo routeSectionInfo) {
        CopyOnWriteArrayList<RouteSectionInfo> copyOnWriteArrayList = this.f7796c;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.add(routeSectionInfo);
        }
    }

    public void a(String str) {
        this.f7795b = str;
    }

    public void a(boolean z) {
        this.f7794a = z;
    }

    public List<RouteSectionInfo> b() {
        return this.f7796c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.f7794a ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f7795b);
        parcel.writeTypedList(this.f7796c);
    }
}
