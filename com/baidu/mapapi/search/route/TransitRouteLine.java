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
    public TaxiInfo f7314b;

    /* loaded from: classes2.dex */
    public static class TransitStep extends RouteStep implements Parcelable {
        public static final Parcelable.Creator<TransitStep> CREATOR = new p();

        /* renamed from: d  reason: collision with root package name */
        public VehicleInfo f7315d;

        /* renamed from: e  reason: collision with root package name */
        public RouteNode f7316e;

        /* renamed from: f  reason: collision with root package name */
        public RouteNode f7317f;

        /* renamed from: g  reason: collision with root package name */
        public TransitRouteStepType f7318g;

        /* renamed from: h  reason: collision with root package name */
        public String f7319h;
        public String i;

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
            this.f7315d = (VehicleInfo) parcel.readParcelable(VehicleInfo.class.getClassLoader());
            this.f7316e = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.f7317f = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            int readInt = parcel.readInt();
            this.f7318g = readInt == -1 ? null : TransitRouteStepType.values()[readInt];
            this.f7319h = parcel.readString();
            this.i = parcel.readString();
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public RouteNode getEntrance() {
            return this.f7316e;
        }

        public RouteNode getExit() {
            return this.f7317f;
        }

        public String getInstructions() {
            return this.f7319h;
        }

        public TransitRouteStepType getStepType() {
            return this.f7318g;
        }

        public VehicleInfo getVehicleInfo() {
            return this.f7315d;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep
        public List<LatLng> getWayPoints() {
            if (this.mWayPoints == null) {
                this.mWayPoints = CoordUtil.decodeLocationList(this.i);
            }
            return this.mWayPoints;
        }

        public void setEntrace(RouteNode routeNode) {
            this.f7316e = routeNode;
        }

        public void setExit(RouteNode routeNode) {
            this.f7317f = routeNode;
        }

        public void setInstructions(String str) {
            this.f7319h = str;
        }

        public void setPathString(String str) {
            this.i = str;
        }

        public void setStepType(TransitRouteStepType transitRouteStepType) {
            this.f7318g = transitRouteStepType;
        }

        public void setVehicleInfo(VehicleInfo vehicleInfo) {
            this.f7315d = vehicleInfo;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f7315d, 1);
            parcel.writeParcelable(this.f7316e, 1);
            parcel.writeParcelable(this.f7317f, 1);
            TransitRouteStepType transitRouteStepType = this.f7318g;
            parcel.writeInt(transitRouteStepType == null ? -1 : transitRouteStepType.ordinal());
            parcel.writeString(this.f7319h);
            parcel.writeString(this.i);
        }
    }

    public TransitRouteLine() {
    }

    public TransitRouteLine(Parcel parcel) {
        super(parcel);
        this.f7314b = (TaxiInfo) parcel.readParcelable(TaxiInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public TaxiInfo getTaxitInfo() {
        return this.f7314b;
    }

    public void setTaxitInfo(TaxiInfo taxiInfo) {
        this.f7314b = taxiInfo;
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.setType(RouteLine.TYPE.TRANSITSTEP);
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f7314b, 1);
    }
}
