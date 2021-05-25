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
    public boolean f7772a;

    /* renamed from: b  reason: collision with root package name */
    public String f7773b;

    /* renamed from: c  reason: collision with root package name */
    public CopyOnWriteArrayList<RouteSectionInfo> f7774c;

    /* loaded from: classes2.dex */
    public static final class RouteSectionInfo implements Parcelable {
        public static final Parcelable.Creator<RouteSectionInfo> CREATOR = new c();

        /* renamed from: a  reason: collision with root package name */
        public LatLng f7775a;

        /* renamed from: b  reason: collision with root package name */
        public LatLng f7776b;

        public RouteSectionInfo() {
            this.f7775a = null;
            this.f7776b = null;
            this.f7775a = null;
            this.f7776b = null;
        }

        public RouteSectionInfo(Parcel parcel) {
            this.f7775a = null;
            this.f7776b = null;
            this.f7775a = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.f7776b = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        }

        public LatLng a() {
            return this.f7775a;
        }

        public void a(LatLng latLng) {
            this.f7775a = latLng;
        }

        public LatLng b() {
            return this.f7776b;
        }

        public void b(LatLng latLng) {
            this.f7776b = latLng;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeParcelable(this.f7775a, i2);
            parcel.writeParcelable(this.f7776b, i2);
        }
    }

    public RouteLineInfo() {
        this.f7772a = false;
        this.f7773b = null;
        this.f7774c = new CopyOnWriteArrayList<>();
    }

    public RouteLineInfo(Parcel parcel) {
        this.f7772a = parcel.readByte() != 0;
        this.f7773b = parcel.readString();
    }

    public String a() {
        return this.f7773b;
    }

    public void a(RouteSectionInfo routeSectionInfo) {
        CopyOnWriteArrayList<RouteSectionInfo> copyOnWriteArrayList = this.f7774c;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.add(routeSectionInfo);
        }
    }

    public void a(String str) {
        this.f7773b = str;
    }

    public void a(boolean z) {
        this.f7772a = z;
    }

    public List<RouteSectionInfo> b() {
        return this.f7774c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByte(this.f7772a ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f7773b);
        parcel.writeTypedList(this.f7774c);
    }
}
