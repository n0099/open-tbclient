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
    public boolean b;
    public List<RouteNode> c;
    public int d;
    public int e;
    public int f;

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* loaded from: classes2.dex */
    public static class DrivingStep extends RouteStep implements Parcelable {
        public static final Parcelable.Creator<DrivingStep> CREATOR = new e();
        public List<LatLng> d;
        public int[] e;
        public int f;
        public RouteNode g;
        public RouteNode h;
        public String i;
        public String j;
        public String k;
        public String l;
        public int m;
        public int n;
        public String o;

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public DrivingStep() {
        }

        public int getDirection() {
            return this.f;
        }

        public RouteNode getEntrance() {
            return this.g;
        }

        public String getEntranceInstructions() {
            return this.j;
        }

        public RouteNode getExit() {
            return this.h;
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

        public int getRoadLevel() {
            return this.n;
        }

        public String getRoadName() {
            return this.o;
        }

        public int[] getTrafficList() {
            return this.e;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep
        public List<LatLng> getWayPoints() {
            if (this.mWayPoints == null) {
                this.mWayPoints = CoordUtil.decodeLocationList(this.i);
            }
            return this.d;
        }

        public DrivingStep(Parcel parcel) {
            super(parcel);
            this.f = parcel.readInt();
            this.g = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.h = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.i = parcel.readString();
            this.j = parcel.readString();
            this.k = parcel.readString();
            this.l = parcel.readString();
            this.m = parcel.readInt();
            this.d = parcel.createTypedArrayList(LatLng.CREATOR);
            this.e = parcel.createIntArray();
            this.n = parcel.readInt();
            this.o = parcel.readString();
        }

        public void setDirection(int i) {
            this.f = i;
        }

        public void setEntrance(RouteNode routeNode) {
            this.g = routeNode;
        }

        public void setEntranceInstructions(String str) {
            this.j = str;
        }

        public void setExit(RouteNode routeNode) {
            this.h = routeNode;
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
            this.d = list;
        }

        public void setPathString(String str) {
            this.i = str;
        }

        public void setRoadLevel(int i) {
            this.n = i;
        }

        public void setRoadName(String str) {
            this.o = str;
        }

        public void setTrafficList(int[] iArr) {
            this.e = iArr;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f);
            parcel.writeParcelable(this.g, 1);
            parcel.writeParcelable(this.h, 1);
            parcel.writeString(this.i);
            parcel.writeString(this.j);
            parcel.writeString(this.k);
            parcel.writeString(this.l);
            parcel.writeInt(this.m);
            parcel.writeTypedList(this.d);
            parcel.writeIntArray(this.e);
            parcel.writeInt(this.n);
            parcel.writeString(this.o);
        }
    }

    public DrivingRouteLine() {
    }

    public int getCongestionDistance() {
        return this.d;
    }

    public int getLightNum() {
        return this.e;
    }

    public int getToll() {
        return this.f;
    }

    public List<RouteNode> getWayPoints() {
        return this.c;
    }

    @Deprecated
    public boolean isSupportTraffic() {
        return this.b;
    }

    public DrivingRouteLine(Parcel parcel) {
        super(parcel);
        boolean z;
        if (parcel.readByte() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.b = z;
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        parcel.readList(arrayList, RouteNode.class.getClassLoader());
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
    }

    public void setCongestionDistance(int i) {
        this.d = i;
    }

    public void setLightNum(int i) {
        this.e = i;
    }

    public void setSupportTraffic(boolean z) {
        this.b = z;
    }

    public void setToll(int i) {
        this.f = i;
    }

    public void setWayPoints(List<RouteNode> list) {
        this.c = list;
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.setType(RouteLine.TYPE.DRIVESTEP);
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
        parcel.writeList(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
    }
}
