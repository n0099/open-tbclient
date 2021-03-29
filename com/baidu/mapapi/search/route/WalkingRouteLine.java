package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import java.util.List;
/* loaded from: classes2.dex */
public class WalkingRouteLine extends RouteLine<WalkingStep> implements Parcelable {
    public static final Parcelable.Creator<WalkingRouteLine> CREATOR = new r();

    /* loaded from: classes2.dex */
    public static class WalkingStep extends RouteStep implements Parcelable {
        public static final Parcelable.Creator<WalkingStep> CREATOR = new s();

        /* renamed from: d  reason: collision with root package name */
        public int f7325d;

        /* renamed from: e  reason: collision with root package name */
        public RouteNode f7326e;

        /* renamed from: f  reason: collision with root package name */
        public RouteNode f7327f;

        /* renamed from: g  reason: collision with root package name */
        public String f7328g;

        /* renamed from: h  reason: collision with root package name */
        public String f7329h;
        public String i;
        public String j;

        public WalkingStep() {
        }

        public WalkingStep(Parcel parcel) {
            super(parcel);
            this.f7325d = parcel.readInt();
            this.f7326e = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.f7327f = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.f7328g = parcel.readString();
            this.f7329h = parcel.readString();
            this.i = parcel.readString();
            this.j = parcel.readString();
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int getDirection() {
            return this.f7325d;
        }

        public RouteNode getEntrance() {
            return this.f7326e;
        }

        public String getEntranceInstructions() {
            return this.f7329h;
        }

        public RouteNode getExit() {
            return this.f7327f;
        }

        public String getExitInstructions() {
            return this.i;
        }

        public String getInstructions() {
            return this.j;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep
        public List<LatLng> getWayPoints() {
            if (this.mWayPoints == null) {
                this.mWayPoints = CoordUtil.decodeLocationList(this.f7328g);
            }
            return this.mWayPoints;
        }

        public void setDirection(int i) {
            this.f7325d = i;
        }

        public void setEntrance(RouteNode routeNode) {
            this.f7326e = routeNode;
        }

        public void setEntranceInstructions(String str) {
            this.f7329h = str;
        }

        public void setExit(RouteNode routeNode) {
            this.f7327f = routeNode;
        }

        public void setExitInstructions(String str) {
            this.i = str;
        }

        public void setInstructions(String str) {
            this.j = str;
        }

        public void setPathString(String str) {
            this.f7328g = str;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, 1);
            parcel.writeInt(this.f7325d);
            parcel.writeParcelable(this.f7326e, 1);
            parcel.writeParcelable(this.f7327f, 1);
            parcel.writeString(this.f7328g);
            parcel.writeString(this.f7329h);
            parcel.writeString(this.i);
            parcel.writeString(this.j);
        }
    }

    public WalkingRouteLine() {
    }

    public WalkingRouteLine(Parcel parcel) {
        super(parcel);
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.baidu.mapapi.search.core.RouteLine
    public List<WalkingStep> getAllStep() {
        return super.getAllStep();
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.setType(RouteLine.TYPE.WALKSTEP);
        super.writeToParcel(parcel, 1);
    }
}
