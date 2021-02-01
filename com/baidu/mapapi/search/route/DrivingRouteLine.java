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
/* loaded from: classes4.dex */
public class DrivingRouteLine extends RouteLine<DrivingStep> implements Parcelable {
    public static final Parcelable.Creator<DrivingRouteLine> CREATOR = new d();

    /* renamed from: b  reason: collision with root package name */
    private boolean f2892b;
    private List<RouteNode> c;
    private int d;
    private int e;

    /* loaded from: classes4.dex */
    public static class DrivingStep extends RouteStep implements Parcelable {
        public static final Parcelable.Creator<DrivingStep> CREATOR = new e();
        List<LatLng> d;
        int[] e;
        private int f;
        private RouteNode g;
        private RouteNode h;
        private String i;
        private String j;
        private String k;
        private String l;
        private int m;

        public DrivingStep() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
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
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public int describeContents() {
            return 0;
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
        }
    }

    public DrivingRouteLine() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DrivingRouteLine(Parcel parcel) {
        super(parcel);
        this.f2892b = parcel.readByte() != 0;
        this.c = new ArrayList();
        parcel.readList(this.c, RouteNode.class.getClassLoader());
        this.d = parcel.readInt();
        this.e = parcel.readInt();
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCongestionDistance() {
        return this.d;
    }

    public int getLightNum() {
        return this.e;
    }

    public List<RouteNode> getWayPoints() {
        return this.c;
    }

    @Deprecated
    public boolean isSupportTraffic() {
        return this.f2892b;
    }

    public void setCongestionDistance(int i) {
        this.d = i;
    }

    public void setLightNum(int i) {
        this.e = i;
    }

    public void setSupportTraffic(boolean z) {
        this.f2892b = z;
    }

    public void setWayPoints(List<RouteNode> list) {
        this.c = list;
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.setType(RouteLine.TYPE.DRIVESTEP);
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.f2892b ? (byte) 1 : (byte) 0);
        parcel.writeList(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
    }
}
