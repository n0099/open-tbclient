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
    public boolean f7815a;

    /* renamed from: b  reason: collision with root package name */
    public String f7816b;

    /* renamed from: c  reason: collision with root package name */
    public CopyOnWriteArrayList<RouteSectionInfo> f7817c;

    /* loaded from: classes2.dex */
    public static final class RouteSectionInfo implements Parcelable {
        public static final Parcelable.Creator<RouteSectionInfo> CREATOR = new c();

        /* renamed from: a  reason: collision with root package name */
        public LatLng f7818a;

        /* renamed from: b  reason: collision with root package name */
        public LatLng f7819b;

        public RouteSectionInfo() {
            this.f7818a = null;
            this.f7819b = null;
            this.f7818a = null;
            this.f7819b = null;
        }

        public RouteSectionInfo(Parcel parcel) {
            this.f7818a = null;
            this.f7819b = null;
            this.f7818a = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.f7819b = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        }

        public LatLng a() {
            return this.f7818a;
        }

        public void a(LatLng latLng) {
            this.f7818a = latLng;
        }

        public LatLng b() {
            return this.f7819b;
        }

        public void b(LatLng latLng) {
            this.f7819b = latLng;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeParcelable(this.f7818a, i2);
            parcel.writeParcelable(this.f7819b, i2);
        }
    }

    public RouteLineInfo() {
        this.f7815a = false;
        this.f7816b = null;
        this.f7817c = new CopyOnWriteArrayList<>();
    }

    public RouteLineInfo(Parcel parcel) {
        this.f7815a = parcel.readByte() != 0;
        this.f7816b = parcel.readString();
    }

    public String a() {
        return this.f7816b;
    }

    public void a(RouteSectionInfo routeSectionInfo) {
        CopyOnWriteArrayList<RouteSectionInfo> copyOnWriteArrayList = this.f7817c;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.add(routeSectionInfo);
        }
    }

    public void a(String str) {
        this.f7816b = str;
    }

    public void a(boolean z) {
        this.f7815a = z;
    }

    public List<RouteSectionInfo> b() {
        return this.f7817c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByte(this.f7815a ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f7816b);
        parcel.writeTypedList(this.f7817c);
    }
}
