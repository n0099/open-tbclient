package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.core.VehicleInfo;
import java.util.List;
/* loaded from: classes2.dex */
public final class TransitRouteLine extends RouteLine<TransitStep> implements Parcelable {
    public static final Parcelable.Creator<TransitRouteLine> CREATOR = new o();

    /* renamed from: b  reason: collision with root package name */
    public TaxiInfo f7326b;

    /* loaded from: classes2.dex */
    public static class TransitStep extends RouteStep implements Parcelable {
        public static final Parcelable.Creator<TransitStep> CREATOR = new p();

        /* renamed from: d  reason: collision with root package name */
        public VehicleInfo f7327d;

        /* renamed from: e  reason: collision with root package name */
        public RouteNode f7328e;

        /* renamed from: f  reason: collision with root package name */
        public RouteNode f7329f;

        /* renamed from: g  reason: collision with root package name */
        public TransitRouteStepType f7330g;

        /* renamed from: h  reason: collision with root package name */
        public String f7331h;

        /* renamed from: i  reason: collision with root package name */
        public String f7332i;

        /* loaded from: classes2.dex */
        public enum TransitRouteStepType {
            BUSLINE,
            SUBWAY,
            WAKLING
        }

        public TransitStep() {
        }

        public TransitStep(Parcel parcel) {
            super(parcel);
            this.f7327d = (VehicleInfo) parcel.readParcelable(VehicleInfo.class.getClassLoader());
            this.f7328e = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.f7329f = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            int readInt = parcel.readInt();
            this.f7330g = readInt == -1 ? null : TransitRouteStepType.values()[readInt];
            this.f7331h = parcel.readString();
            this.f7332i = parcel.readString();
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public RouteNode getEntrance() {
            return this.f7328e;
        }

        public RouteNode getExit() {
            return this.f7329f;
        }

        public String getInstructions() {
            return this.f7331h;
        }

        public TransitRouteStepType getStepType() {
            return this.f7330g;
        }

        public VehicleInfo getVehicleInfo() {
            return this.f7327d;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep
        public List<LatLng> getWayPoints() {
            if (this.mWayPoints == null) {
                this.mWayPoints = CoordUtil.decodeLocationList(this.f7332i);
            }
            return this.mWayPoints;
        }

        public void setEntrace(RouteNode routeNode) {
            this.f7328e = routeNode;
        }

        public void setExit(RouteNode routeNode) {
            this.f7329f = routeNode;
        }

        public void setInstructions(String str) {
            this.f7331h = str;
        }

        public void setPathString(String str) {
            this.f7332i = str;
        }

        public void setStepType(TransitRouteStepType transitRouteStepType) {
            this.f7330g = transitRouteStepType;
        }

        public void setVehicleInfo(VehicleInfo vehicleInfo) {
            this.f7327d = vehicleInfo;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeParcelable(this.f7327d, 1);
            parcel.writeParcelable(this.f7328e, 1);
            parcel.writeParcelable(this.f7329f, 1);
            TransitRouteStepType transitRouteStepType = this.f7330g;
            parcel.writeInt(transitRouteStepType == null ? -1 : transitRouteStepType.ordinal());
            parcel.writeString(this.f7331h);
            parcel.writeString(this.f7332i);
        }
    }

    public TransitRouteLine() {
    }

    public TransitRouteLine(Parcel parcel) {
        super(parcel);
        this.f7326b = (TaxiInfo) parcel.readParcelable(TaxiInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public TaxiInfo getTaxitInfo() {
        return this.f7326b;
    }

    public void setTaxitInfo(TaxiInfo taxiInfo) {
        this.f7326b = taxiInfo;
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.setType(RouteLine.TYPE.TRANSITSTEP);
        super.writeToParcel(parcel, i2);
        parcel.writeParcelable(this.f7326b, 1);
    }
}
