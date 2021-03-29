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
    public boolean f7250b;

    /* renamed from: c  reason: collision with root package name */
    public List<RouteNode> f7251c;

    /* renamed from: d  reason: collision with root package name */
    public int f7252d;

    /* renamed from: e  reason: collision with root package name */
    public int f7253e;

    /* loaded from: classes2.dex */
    public static class DrivingStep extends RouteStep implements Parcelable {
        public static final Parcelable.Creator<DrivingStep> CREATOR = new e();

        /* renamed from: d  reason: collision with root package name */
        public List<LatLng> f7254d;

        /* renamed from: e  reason: collision with root package name */
        public int[] f7255e;

        /* renamed from: f  reason: collision with root package name */
        public int f7256f;

        /* renamed from: g  reason: collision with root package name */
        public RouteNode f7257g;

        /* renamed from: h  reason: collision with root package name */
        public RouteNode f7258h;
        public String i;
        public String j;
        public String k;
        public String l;
        public int m;

        public DrivingStep() {
        }

        public DrivingStep(Parcel parcel) {
            super(parcel);
            this.f7256f = parcel.readInt();
            this.f7257g = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.f7258h = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.i = parcel.readString();
            this.j = parcel.readString();
            this.k = parcel.readString();
            this.l = parcel.readString();
            this.m = parcel.readInt();
            this.f7254d = parcel.createTypedArrayList(LatLng.CREATOR);
            this.f7255e = parcel.createIntArray();
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int getDirection() {
            return this.f7256f;
        }

        public RouteNode getEntrance() {
            return this.f7257g;
        }

        public String getEntranceInstructions() {
            return this.j;
        }

        public RouteNode getExit() {
            return this.f7258h;
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
            return this.f7255e;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep
        public List<LatLng> getWayPoints() {
            if (this.mWayPoints == null) {
                this.mWayPoints = CoordUtil.decodeLocationList(this.i);
            }
            return this.f7254d;
        }

        public void setDirection(int i) {
            this.f7256f = i;
        }

        public void setEntrance(RouteNode routeNode) {
            this.f7257g = routeNode;
        }

        public void setEntranceInstructions(String str) {
            this.j = str;
        }

        public void setExit(RouteNode routeNode) {
            this.f7258h = routeNode;
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
            this.f7254d = list;
        }

        public void setPathString(String str) {
            this.i = str;
        }

        public void setTrafficList(int[] iArr) {
            this.f7255e = iArr;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f7256f);
            parcel.writeParcelable(this.f7257g, 1);
            parcel.writeParcelable(this.f7258h, 1);
            parcel.writeString(this.i);
            parcel.writeString(this.j);
            parcel.writeString(this.k);
            parcel.writeString(this.l);
            parcel.writeInt(this.m);
            parcel.writeTypedList(this.f7254d);
            parcel.writeIntArray(this.f7255e);
        }
    }

    public DrivingRouteLine() {
    }

    public DrivingRouteLine(Parcel parcel) {
        super(parcel);
        this.f7250b = parcel.readByte() != 0;
        ArrayList arrayList = new ArrayList();
        this.f7251c = arrayList;
        parcel.readList(arrayList, RouteNode.class.getClassLoader());
        this.f7252d = parcel.readInt();
        this.f7253e = parcel.readInt();
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCongestionDistance() {
        return this.f7252d;
    }

    public int getLightNum() {
        return this.f7253e;
    }

    public List<RouteNode> getWayPoints() {
        return this.f7251c;
    }

    @Deprecated
    public boolean isSupportTraffic() {
        return this.f7250b;
    }

    public void setCongestionDistance(int i) {
        this.f7252d = i;
    }

    public void setLightNum(int i) {
        this.f7253e = i;
    }

    public void setSupportTraffic(boolean z) {
        this.f7250b = z;
    }

    public void setWayPoints(List<RouteNode> list) {
        this.f7251c = list;
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.setType(RouteLine.TYPE.DRIVESTEP);
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.f7250b ? (byte) 1 : (byte) 0);
        parcel.writeList(this.f7251c);
        parcel.writeInt(this.f7252d);
        parcel.writeInt(this.f7253e);
    }
}
