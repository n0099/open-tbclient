package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes6.dex */
public final class RouteLineInfo implements Parcelable {
    public static final Parcelable.Creator<RouteLineInfo> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    private boolean f3108a;

    /* renamed from: b  reason: collision with root package name */
    private String f3109b;
    private CopyOnWriteArrayList<RouteSectionInfo> c;

    /* loaded from: classes6.dex */
    public static final class RouteSectionInfo implements Parcelable {
        public static final Parcelable.Creator<RouteSectionInfo> CREATOR = new c();

        /* renamed from: a  reason: collision with root package name */
        private LatLng f3110a;

        /* renamed from: b  reason: collision with root package name */
        private LatLng f3111b;

        public RouteSectionInfo() {
            this.f3110a = null;
            this.f3111b = null;
            this.f3110a = null;
            this.f3111b = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public RouteSectionInfo(Parcel parcel) {
            this.f3110a = null;
            this.f3111b = null;
            this.f3110a = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.f3111b = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        }

        public LatLng a() {
            return this.f3110a;
        }

        public void a(LatLng latLng) {
            this.f3110a = latLng;
        }

        public LatLng b() {
            return this.f3111b;
        }

        public void b(LatLng latLng) {
            this.f3111b = latLng;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f3110a, i);
            parcel.writeParcelable(this.f3111b, i);
        }
    }

    public RouteLineInfo() {
        this.f3108a = false;
        this.f3109b = null;
        this.c = new CopyOnWriteArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RouteLineInfo(Parcel parcel) {
        this.f3108a = parcel.readByte() != 0;
        this.f3109b = parcel.readString();
    }

    public String a() {
        return this.f3109b;
    }

    public void a(RouteSectionInfo routeSectionInfo) {
        if (this.c != null) {
            this.c.add(routeSectionInfo);
        }
    }

    public void a(String str) {
        this.f3109b = str;
    }

    public void a(boolean z) {
        this.f3108a = z;
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
        parcel.writeByte((byte) (this.f3108a ? 1 : 0));
        parcel.writeString(this.f3109b);
        parcel.writeTypedList(this.c);
    }
}
