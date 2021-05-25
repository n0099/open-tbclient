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
    public boolean f7259b;

    /* renamed from: c  reason: collision with root package name */
    public List<RouteNode> f7260c;

    /* renamed from: d  reason: collision with root package name */
    public int f7261d;

    /* renamed from: e  reason: collision with root package name */
    public int f7262e;

    /* loaded from: classes2.dex */
    public static class DrivingStep extends RouteStep implements Parcelable {
        public static final Parcelable.Creator<DrivingStep> CREATOR = new e();

        /* renamed from: d  reason: collision with root package name */
        public List<LatLng> f7263d;

        /* renamed from: e  reason: collision with root package name */
        public int[] f7264e;

        /* renamed from: f  reason: collision with root package name */
        public int f7265f;

        /* renamed from: g  reason: collision with root package name */
        public RouteNode f7266g;

        /* renamed from: h  reason: collision with root package name */
        public RouteNode f7267h;

        /* renamed from: i  reason: collision with root package name */
        public String f7268i;
        public String j;
        public String k;
        public String l;
        public int m;

        public DrivingStep() {
        }

        public DrivingStep(Parcel parcel) {
            super(parcel);
            this.f7265f = parcel.readInt();
            this.f7266g = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.f7267h = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.f7268i = parcel.readString();
            this.j = parcel.readString();
            this.k = parcel.readString();
            this.l = parcel.readString();
            this.m = parcel.readInt();
            this.f7263d = parcel.createTypedArrayList(LatLng.CREATOR);
            this.f7264e = parcel.createIntArray();
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int getDirection() {
            return this.f7265f;
        }

        public RouteNode getEntrance() {
            return this.f7266g;
        }

        public String getEntranceInstructions() {
            return this.j;
        }

        public RouteNode getExit() {
            return this.f7267h;
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
            return this.f7264e;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep
        public List<LatLng> getWayPoints() {
            if (this.mWayPoints == null) {
                this.mWayPoints = CoordUtil.decodeLocationList(this.f7268i);
            }
            return this.f7263d;
        }

        public void setDirection(int i2) {
            this.f7265f = i2;
        }

        public void setEntrance(RouteNode routeNode) {
            this.f7266g = routeNode;
        }

        public void setEntranceInstructions(String str) {
            this.j = str;
        }

        public void setExit(RouteNode routeNode) {
            this.f7267h = routeNode;
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
            this.f7263d = list;
        }

        public void setPathString(String str) {
            this.f7268i = str;
        }

        public void setTrafficList(int[] iArr) {
            this.f7264e = iArr;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f7265f);
            parcel.writeParcelable(this.f7266g, 1);
            parcel.writeParcelable(this.f7267h, 1);
            parcel.writeString(this.f7268i);
            parcel.writeString(this.j);
            parcel.writeString(this.k);
            parcel.writeString(this.l);
            parcel.writeInt(this.m);
            parcel.writeTypedList(this.f7263d);
            parcel.writeIntArray(this.f7264e);
        }
    }

    public DrivingRouteLine() {
    }

    public DrivingRouteLine(Parcel parcel) {
        super(parcel);
        this.f7259b = parcel.readByte() != 0;
        ArrayList arrayList = new ArrayList();
        this.f7260c = arrayList;
        parcel.readList(arrayList, RouteNode.class.getClassLoader());
        this.f7261d = parcel.readInt();
        this.f7262e = parcel.readInt();
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCongestionDistance() {
        return this.f7261d;
    }

    public int getLightNum() {
        return this.f7262e;
    }

    public List<RouteNode> getWayPoints() {
        return this.f7260c;
    }

    @Deprecated
    public boolean isSupportTraffic() {
        return this.f7259b;
    }

    public void setCongestionDistance(int i2) {
        this.f7261d = i2;
    }

    public void setLightNum(int i2) {
        this.f7262e = i2;
    }

    public void setSupportTraffic(boolean z) {
        this.f7259b = z;
    }

    public void setWayPoints(List<RouteNode> list) {
        this.f7260c = list;
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.setType(RouteLine.TYPE.DRIVESTEP);
        super.writeToParcel(parcel, i2);
        parcel.writeByte(this.f7259b ? (byte) 1 : (byte) 0);
        parcel.writeList(this.f7260c);
        parcel.writeInt(this.f7261d);
        parcel.writeInt(this.f7262e);
    }
}
