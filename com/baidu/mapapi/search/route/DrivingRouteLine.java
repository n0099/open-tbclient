package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class DrivingRouteLine extends RouteLine<DrivingStep> implements Parcelable {
    public static final Parcelable.Creator<DrivingRouteLine> CREATOR = new d();

    /* renamed from: b  reason: collision with root package name */
    public boolean f7542b;

    /* renamed from: c  reason: collision with root package name */
    public List<RouteNode> f7543c;

    /* renamed from: d  reason: collision with root package name */
    public int f7544d;

    /* renamed from: e  reason: collision with root package name */
    public int f7545e;

    /* loaded from: classes2.dex */
    public static class DrivingStep extends RouteStep implements Parcelable {
        public static final Parcelable.Creator<DrivingStep> CREATOR = new e();

        /* renamed from: d  reason: collision with root package name */
        public List<LatLng> f7546d;

        /* renamed from: e  reason: collision with root package name */
        public int[] f7547e;

        /* renamed from: f  reason: collision with root package name */
        public int f7548f;

        /* renamed from: g  reason: collision with root package name */
        public RouteNode f7549g;

        /* renamed from: h  reason: collision with root package name */
        public RouteNode f7550h;

        /* renamed from: i  reason: collision with root package name */
        public String f7551i;
        public String j;
        public String k;
        public String l;
        public int m;

        public DrivingStep() {
        }

        public DrivingStep(Parcel parcel) {
            super(parcel);
            this.f7548f = parcel.readInt();
            this.f7549g = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.f7550h = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.f7551i = parcel.readString();
            this.j = parcel.readString();
            this.k = parcel.readString();
            this.l = parcel.readString();
            this.m = parcel.readInt();
            this.f7546d = parcel.createTypedArrayList(LatLng.CREATOR);
            this.f7547e = parcel.createIntArray();
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int getDirection() {
            return this.f7548f;
        }

        public RouteNode getEntrance() {
            return this.f7549g;
        }

        public String getEntranceInstructions() {
            return this.j;
        }

        public RouteNode getExit() {
            return this.f7550h;
        }

        public String getExitInstructions() {
            return this.k;
        }

        public String getInstructions() {
            return this.l;
        }

        public int getNumTurns() {
            return this.m;
        }

        public int[] getTrafficList() {
            return this.f7547e;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep
        public List<LatLng> getWayPoints() {
            if (this.mWayPoints == null) {
                this.mWayPoints = CoordUtil.decodeLocationList(this.f7551i);
            }
            return this.f7546d;
        }

        public void setDirection(int i2) {
            this.f7548f = i2;
        }

        public void setEntrance(RouteNode routeNode) {
            this.f7549g = routeNode;
        }

        public void setEntranceInstructions(String str) {
            this.j = str;
        }

        public void setExit(RouteNode routeNode) {
            this.f7550h = routeNode;
        }

        public void setExitInstructions(String str) {
            this.k = str;
        }

        public void setInstructions(String str) {
            this.l = str;
        }

        public void setNumTurns(int i2) {
            this.m = i2;
        }

        public void setPathList(List<LatLng> list) {
            this.f7546d = list;
        }

        public void setPathString(String str) {
            this.f7551i = str;
        }

        public void setTrafficList(int[] iArr) {
            this.f7547e = iArr;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f7548f);
            parcel.writeParcelable(this.f7549g, 1);
            parcel.writeParcelable(this.f7550h, 1);
            parcel.writeString(this.f7551i);
            parcel.writeString(this.j);
            parcel.writeString(this.k);
            parcel.writeString(this.l);
            parcel.writeInt(this.m);
            parcel.writeTypedList(this.f7546d);
            parcel.writeIntArray(this.f7547e);
        }
    }

    public DrivingRouteLine() {
    }

    public DrivingRouteLine(Parcel parcel) {
        super(parcel);
        this.f7542b = parcel.readByte() != 0;
        ArrayList arrayList = new ArrayList();
        this.f7543c = arrayList;
        parcel.readList(arrayList, RouteNode.class.getClassLoader());
        this.f7544d = parcel.readInt();
        this.f7545e = parcel.readInt();
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCongestionDistance() {
        return this.f7544d;
    }

    public int getLightNum() {
        return this.f7545e;
    }

    public List<RouteNode> getWayPoints() {
        return this.f7543c;
    }

    @Deprecated
    public boolean isSupportTraffic() {
        return this.f7542b;
    }

    public void setCongestionDistance(int i2) {
        this.f7544d = i2;
    }

    public void setLightNum(int i2) {
        this.f7545e = i2;
    }

    public void setSupportTraffic(boolean z) {
        this.f7542b = z;
    }

    public void setWayPoints(List<RouteNode> list) {
        this.f7543c = list;
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.setType(RouteLine.TYPE.DRIVESTEP);
        super.writeToParcel(parcel, i2);
        parcel.writeByte(this.f7542b ? (byte) 1 : (byte) 0);
        parcel.writeList(this.f7543c);
        parcel.writeInt(this.f7544d);
        parcel.writeInt(this.f7545e);
    }
}
