package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes4.dex */
public final class RouteLineInfo implements Parcelable {
    public static final Parcelable.Creator<RouteLineInfo> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    private boolean f2253a;
    private String b;
    private CopyOnWriteArrayList<RouteSectionInfo> c;

    /* loaded from: classes4.dex */
    public static final class RouteSectionInfo implements Parcelable {
        public static final Parcelable.Creator<RouteSectionInfo> CREATOR = new c();

        /* renamed from: a  reason: collision with root package name */
        private LatLng f2254a;
        private LatLng b;

        public RouteSectionInfo() {
            this.f2254a = null;
            this.b = null;
            this.f2254a = null;
            this.b = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public RouteSectionInfo(Parcel parcel) {
            this.f2254a = null;
            this.b = null;
            this.f2254a = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.b = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        }

        public LatLng a() {
            return this.f2254a;
        }

        public void a(LatLng latLng) {
            this.f2254a = latLng;
        }

        public LatLng b() {
            return this.b;
        }

        public void b(LatLng latLng) {
            this.b = latLng;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f2254a, i);
            parcel.writeParcelable(this.b, i);
        }
    }

    public RouteLineInfo() {
        this.f2253a = false;
        this.b = null;
        this.c = new CopyOnWriteArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RouteLineInfo(Parcel parcel) {
        this.f2253a = parcel.readByte() != 0;
        this.b = parcel.readString();
    }

    public String a() {
        return this.b;
    }

    public void a(RouteSectionInfo routeSectionInfo) {
        if (this.c != null) {
            this.c.add(routeSectionInfo);
        }
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(boolean z) {
        this.f2253a = z;
    }

    public List<RouteSectionInfo> b() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (this.f2253a ? 1 : 0));
        parcel.writeString(this.b);
        parcel.writeTypedList(this.c);
    }
}
