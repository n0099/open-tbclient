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
    public boolean f7359b;

    /* renamed from: c  reason: collision with root package name */
    public List<RouteNode> f7360c;

    /* renamed from: d  reason: collision with root package name */
    public int f7361d;

    /* renamed from: e  reason: collision with root package name */
    public int f7362e;

    /* loaded from: classes2.dex */
    public static class DrivingStep extends RouteStep implements Parcelable {
        public static final Parcelable.Creator<DrivingStep> CREATOR = new e();

        /* renamed from: d  reason: collision with root package name */
        public List<LatLng> f7363d;

        /* renamed from: e  reason: collision with root package name */
        public int[] f7364e;

        /* renamed from: f  reason: collision with root package name */
        public int f7365f;

        /* renamed from: g  reason: collision with root package name */
        public RouteNode f7366g;

        /* renamed from: h  reason: collision with root package name */
        public RouteNode f7367h;

        /* renamed from: i  reason: collision with root package name */
        public String f7368i;
        public String j;
        public String k;
        public String l;
        public int m;

        public DrivingStep() {
        }

        public DrivingStep(Parcel parcel) {
            super(parcel);
            this.f7365f = parcel.readInt();
            this.f7366g = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.f7367h = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.f7368i = parcel.readString();
            this.j = parcel.readString();
            this.k = parcel.readString();
            this.l = parcel.readString();
            this.m = parcel.readInt();
            this.f7363d = parcel.createTypedArrayList(LatLng.CREATOR);
            this.f7364e = parcel.createIntArray();
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int getDirection() {
            return this.f7365f;
        }

        public RouteNode getEntrance() {
            return this.f7366g;
        }

        public String getEntranceInstructions() {
            return this.j;
        }

        public RouteNode getExit() {
            return this.f7367h;
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
            return this.f7364e;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep
        public List<LatLng> getWayPoints() {
            if (this.mWayPoints == null) {
                this.mWayPoints = CoordUtil.decodeLocationList(this.f7368i);
            }
            return this.f7363d;
        }

        public void setDirection(int i2) {
            this.f7365f = i2;
        }

        public void setEntrance(RouteNode routeNode) {
            this.f7366g = routeNode;
        }

        public void setEntranceInstructions(String str) {
            this.j = str;
        }

        public void setExit(RouteNode routeNode) {
            this.f7367h = routeNode;
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
            this.f7363d = list;
        }

        public void setPathString(String str) {
            this.f7368i = str;
        }

        public void setTrafficList(int[] iArr) {
            this.f7364e = iArr;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f7365f);
            parcel.writeParcelable(this.f7366g, 1);
            parcel.writeParcelable(this.f7367h, 1);
            parcel.writeString(this.f7368i);
            parcel.writeString(this.j);
            parcel.writeString(this.k);
            parcel.writeString(this.l);
            parcel.writeInt(this.m);
            parcel.writeTypedList(this.f7363d);
            parcel.writeIntArray(this.f7364e);
        }
    }

    public DrivingRouteLine() {
    }

    public DrivingRouteLine(Parcel parcel) {
        super(parcel);
        this.f7359b = parcel.readByte() != 0;
        ArrayList arrayList = new ArrayList();
        this.f7360c = arrayList;
        parcel.readList(arrayList, RouteNode.class.getClassLoader());
        this.f7361d = parcel.readInt();
        this.f7362e = parcel.readInt();
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCongestionDistance() {
        return this.f7361d;
    }

    public int getLightNum() {
        return this.f7362e;
    }

    public List<RouteNode> getWayPoints() {
        return this.f7360c;
    }

    @Deprecated
    public boolean isSupportTraffic() {
        return this.f7359b;
    }

    public void setCongestionDistance(int i2) {
        this.f7361d = i2;
    }

    public void setLightNum(int i2) {
        this.f7362e = i2;
    }

    public void setSupportTraffic(boolean z) {
        this.f7359b = z;
    }

    public void setWayPoints(List<RouteNode> list) {
        this.f7360c = list;
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.setType(RouteLine.TYPE.DRIVESTEP);
        super.writeToParcel(parcel, i2);
        parcel.writeByte(this.f7359b ? (byte) 1 : (byte) 0);
        parcel.writeList(this.f7360c);
        parcel.writeInt(this.f7361d);
        parcel.writeInt(this.f7362e);
    }
}
