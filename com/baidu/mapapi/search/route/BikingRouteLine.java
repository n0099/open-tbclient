package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class BikingRouteLine extends RouteLine<BikingStep> implements Parcelable {
    public static final Parcelable.Creator<BikingRouteLine> CREATOR = new a();

    /* loaded from: classes2.dex */
    public static class BikingStep extends RouteStep implements Parcelable {
        public static final Parcelable.Creator<BikingStep> CREATOR = new b();

        /* renamed from: d  reason: collision with root package name */
        public int f7242d;

        /* renamed from: e  reason: collision with root package name */
        public RouteNode f7243e;

        /* renamed from: f  reason: collision with root package name */
        public RouteNode f7244f;

        /* renamed from: g  reason: collision with root package name */
        public String f7245g;

        /* renamed from: h  reason: collision with root package name */
        public String f7246h;
        public String i;
        public String j;
        public String k;

        public BikingStep() {
        }

        public BikingStep(Parcel parcel) {
            super(parcel);
            this.f7242d = parcel.readInt();
            this.f7243e = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.f7244f = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.f7245g = parcel.readString();
            this.f7246h = parcel.readString();
            this.i = parcel.readString();
            this.j = parcel.readString();
            this.k = parcel.readString();
        }

        private List<LatLng> a(String str) {
            if (str != null && str.length() != 0) {
                ArrayList arrayList = new ArrayList();
                String[] split = str.split(";");
                if (split != null && split.length != 0) {
                    for (String str2 : split) {
                        String[] split2 = str2.split(",");
                        if (split2 != null && split2.length >= 2) {
                            LatLng latLng = new LatLng(Double.valueOf(split2[1]).doubleValue(), Double.valueOf(split2[0]).doubleValue());
                            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                                latLng = CoordTrans.baiduToGcj(latLng);
                            }
                            arrayList.add(latLng);
                        }
                    }
                    return arrayList;
                }
            }
            return null;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int getDirection() {
            return this.f7242d;
        }

        public RouteNode getEntrance() {
            return this.f7243e;
        }

        public String getEntranceInstructions() {
            return this.f7246h;
        }

        public RouteNode getExit() {
            return this.f7244f;
        }

        public String getExitInstructions() {
            return this.i;
        }

        public String getInstructions() {
            return this.j;
        }

        public String getTurnType() {
            return this.k;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep
        public List<LatLng> getWayPoints() {
            if (this.mWayPoints == null) {
                this.mWayPoints = a(this.f7245g);
            }
            return this.mWayPoints;
        }

        public void setDirection(int i) {
            this.f7242d = i;
        }

        public void setEntrance(RouteNode routeNode) {
            this.f7243e = routeNode;
        }

        public void setEntranceInstructions(String str) {
            this.f7246h = str;
        }

        public void setExit(RouteNode routeNode) {
            this.f7244f = routeNode;
        }

        public void setExitInstructions(String str) {
            this.i = str;
        }

        public void setInstructions(String str) {
            this.j = str;
        }

        public void setPathString(String str) {
            this.f7245g = str;
        }

        public void setTurnType(String str) {
            this.k = str;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, 1);
            parcel.writeInt(this.f7242d);
            parcel.writeParcelable(this.f7243e, 1);
            parcel.writeParcelable(this.f7244f, 1);
            parcel.writeString(this.f7245g);
            parcel.writeString(this.f7246h);
            parcel.writeString(this.i);
            parcel.writeString(this.j);
            parcel.writeString(this.k);
        }
    }

    public BikingRouteLine() {
    }

    public BikingRouteLine(Parcel parcel) {
        super(parcel);
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.baidu.mapapi.search.core.RouteLine
    public List<BikingStep> getAllStep() {
        return super.getAllStep();
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.setType(RouteLine.TYPE.BIKINGSTEP);
        super.writeToParcel(parcel, 1);
    }
}
