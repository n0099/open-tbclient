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
    private boolean f3106a;

    /* renamed from: b  reason: collision with root package name */
    private String f3107b;
    private CopyOnWriteArrayList<RouteSectionInfo> c;

    /* loaded from: classes4.dex */
    public static final class RouteSectionInfo implements Parcelable {
        public static final Parcelable.Creator<RouteSectionInfo> CREATOR = new c();

        /* renamed from: a  reason: collision with root package name */
        private LatLng f3108a;

        /* renamed from: b  reason: collision with root package name */
        private LatLng f3109b;

        public RouteSectionInfo() {
            this.f3108a = null;
            this.f3109b = null;
            this.f3108a = null;
            this.f3109b = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public RouteSectionInfo(Parcel parcel) {
            this.f3108a = null;
            this.f3109b = null;
            this.f3108a = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.f3109b = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        }

        public LatLng a() {
            return this.f3108a;
        }

        public void a(LatLng latLng) {
            this.f3108a = latLng;
        }

        public LatLng b() {
            return this.f3109b;
        }

        public void b(LatLng latLng) {
            this.f3109b = latLng;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f3108a, i);
            parcel.writeParcelable(this.f3109b, i);
        }
    }

    public RouteLineInfo() {
        this.f3106a = false;
        this.f3107b = null;
        this.c = new CopyOnWriteArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RouteLineInfo(Parcel parcel) {
        this.f3106a = parcel.readByte() != 0;
        this.f3107b = parcel.readString();
    }

    public String a() {
        return this.f3107b;
    }

    public void a(RouteSectionInfo routeSectionInfo) {
        if (this.c != null) {
            this.c.add(routeSectionInfo);
        }
    }

    public void a(String str) {
        this.f3107b = str;
    }

    public void a(boolean z) {
        this.f3106a = z;
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
        parcel.writeByte((byte) (this.f3106a ? 1 : 0));
        parcel.writeString(this.f3107b);
        parcel.writeTypedList(this.c);
    }
}
