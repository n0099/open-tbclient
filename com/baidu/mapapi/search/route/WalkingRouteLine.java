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
        public int f7438d;

        /* renamed from: e  reason: collision with root package name */
        public RouteNode f7439e;

        /* renamed from: f  reason: collision with root package name */
        public RouteNode f7440f;

        /* renamed from: g  reason: collision with root package name */
        public String f7441g;

        /* renamed from: h  reason: collision with root package name */
        public String f7442h;

        /* renamed from: i  reason: collision with root package name */
        public String f7443i;
        public String j;

        public WalkingStep() {
        }

        public WalkingStep(Parcel parcel) {
            super(parcel);
            this.f7438d = parcel.readInt();
            this.f7439e = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.f7440f = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.f7441g = parcel.readString();
            this.f7442h = parcel.readString();
            this.f7443i = parcel.readString();
            this.j = parcel.readString();
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int getDirection() {
            return this.f7438d;
        }

        public RouteNode getEntrance() {
            return this.f7439e;
        }

        public String getEntranceInstructions() {
            return this.f7442h;
        }

        public RouteNode getExit() {
            return this.f7440f;
        }

        public String getExitInstructions() {
            return this.f7443i;
        }

        public String getInstructions() {
            return this.j;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep
        public List<LatLng> getWayPoints() {
            if (this.mWayPoints == null) {
                this.mWayPoints = CoordUtil.decodeLocationList(this.f7441g);
            }
            return this.mWayPoints;
        }

        public void setDirection(int i2) {
            this.f7438d = i2;
        }

        public void setEntrance(RouteNode routeNode) {
            this.f7439e = routeNode;
        }

        public void setEntranceInstructions(String str) {
            this.f7442h = str;
        }

        public void setExit(RouteNode routeNode) {
            this.f7440f = routeNode;
        }

        public void setExitInstructions(String str) {
            this.f7443i = str;
        }

        public void setInstructions(String str) {
            this.j = str;
        }

        public void setPathString(String str) {
            this.f7441g = str;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, 1);
            parcel.writeInt(this.f7438d);
            parcel.writeParcelable(this.f7439e, 1);
            parcel.writeParcelable(this.f7440f, 1);
            parcel.writeString(this.f7441g);
            parcel.writeString(this.f7442h);
            parcel.writeString(this.f7443i);
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
    public void writeToParcel(Parcel parcel, int i2) {
        super.setType(RouteLine.TYPE.WALKSTEP);
        super.writeToParcel(parcel, 1);
    }
}
