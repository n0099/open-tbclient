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
    public boolean f7249b;

    /* renamed from: c  reason: collision with root package name */
    public List<RouteNode> f7250c;

    /* renamed from: d  reason: collision with root package name */
    public int f7251d;

    /* renamed from: e  reason: collision with root package name */
    public int f7252e;

    /* loaded from: classes2.dex */
    public static class DrivingStep extends RouteStep implements Parcelable {
        public static final Parcelable.Creator<DrivingStep> CREATOR = new e();

        /* renamed from: d  reason: collision with root package name */
        public List<LatLng> f7253d;

        /* renamed from: e  reason: collision with root package name */
        public int[] f7254e;

        /* renamed from: f  reason: collision with root package name */
        public int f7255f;

        /* renamed from: g  reason: collision with root package name */
        public RouteNode f7256g;

        /* renamed from: h  reason: collision with root package name */
        public RouteNode f7257h;
        public String i;
        public String j;
        public String k;
        public String l;
        public int m;

        public DrivingStep() {
        }

        public DrivingStep(Parcel parcel) {
            super(parcel);
            this.f7255f = parcel.readInt();
            this.f7256g = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.f7257h = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.i = parcel.readString();
            this.j = parcel.readString();
            this.k = parcel.readString();
            this.l = parcel.readString();
            this.m = parcel.readInt();
            this.f7253d = parcel.createTypedArrayList(LatLng.CREATOR);
            this.f7254e = parcel.createIntArray();
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int getDirection() {
            return this.f7255f;
        }

        public RouteNode getEntrance() {
            return this.f7256g;
        }

        public String getEntranceInstructions() {
            return this.j;
        }

        public RouteNode getExit() {
            return this.f7257h;
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
            return this.f7254e;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep
        public List<LatLng> getWayPoints() {
            if (this.mWayPoints == null) {
                this.mWayPoints = CoordUtil.decodeLocationList(this.i);
            }
            return this.f7253d;
        }

        public void setDirection(int i) {
            this.f7255f = i;
        }

        public void setEntrance(RouteNode routeNode) {
            this.f7256g = routeNode;
        }

        public void setEntranceInstructions(String str) {
            this.j = str;
        }

        public void setExit(RouteNode routeNode) {
            this.f7257h = routeNode;
        }

        public void setExitInstructions(String str) {
            this.k = str;
        }

        public void setInstructions(String str) {
            this.l = str;
        }

        public void setNumTurns(int i) {
            this.m = i;
        }

        public void setPathList(List<LatLng> list) {
            this.f7253d = list;
        }

        public void setPathString(String str) {
            this.i = str;
        }

        public void setTrafficList(int[] iArr) {
            this.f7254e = iArr;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f7255f);
            parcel.writeParcelable(this.f7256g, 1);
            parcel.writeParcelable(this.f7257h, 1);
            parcel.writeString(this.i);
            parcel.writeString(this.j);
            parcel.writeString(this.k);
            parcel.writeString(this.l);
            parcel.writeInt(this.m);
            parcel.writeTypedList(this.f7253d);
            parcel.writeIntArray(this.f7254e);
        }
    }

    public DrivingRouteLine() {
    }

    public DrivingRouteLine(Parcel parcel) {
        super(parcel);
        this.f7249b = parcel.readByte() != 0;
        ArrayList arrayList = new ArrayList();
        this.f7250c = arrayList;
        parcel.readList(arrayList, RouteNode.class.getClassLoader());
        this.f7251d = parcel.readInt();
        this.f7252e = parcel.readInt();
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCongestionDistance() {
        return this.f7251d;
    }

    public int getLightNum() {
        return this.f7252e;
    }

    public List<RouteNode> getWayPoints() {
        return this.f7250c;
    }

    @Deprecated
    public boolean isSupportTraffic() {
        return this.f7249b;
    }

    public void setCongestionDistance(int i) {
        this.f7251d = i;
    }

    public void setLightNum(int i) {
        this.f7252e = i;
    }

    public void setSupportTraffic(boolean z) {
        this.f7249b = z;
    }

    public void setWayPoints(List<RouteNode> list) {
        this.f7250c = list;
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.setType(RouteLine.TYPE.DRIVESTEP);
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.f7249b ? (byte) 1 : (byte) 0);
        parcel.writeList(this.f7250c);
        parcel.writeInt(this.f7251d);
        parcel.writeInt(this.f7252e);
    }
}
