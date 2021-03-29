package com.baidu.mapapi.search.route;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ParcelCreator"})
/* loaded from: classes2.dex */
public class IndoorRouteLine extends RouteLine<IndoorRouteStep> {
    public static final Parcelable.Creator<IndoorRouteLine> CREATOR = new g();

    /* loaded from: classes2.dex */
    public static class IndoorRouteStep extends RouteStep {

        /* renamed from: d  reason: collision with root package name */
        public RouteNode f7269d;

        /* renamed from: e  reason: collision with root package name */
        public RouteNode f7270e;

        /* renamed from: f  reason: collision with root package name */
        public String f7271f;

        /* renamed from: g  reason: collision with root package name */
        public String f7272g;

        /* renamed from: h  reason: collision with root package name */
        public String f7273h;
        public List<IndoorStepNode> i;
        public List<Double> j;

        /* loaded from: classes2.dex */
        public static class IndoorStepNode {

            /* renamed from: a  reason: collision with root package name */
            public String f7274a;

            /* renamed from: b  reason: collision with root package name */
            public int f7275b;

            /* renamed from: c  reason: collision with root package name */
            public LatLng f7276c;

            /* renamed from: d  reason: collision with root package name */
            public String f7277d;

            public String getDetail() {
                return this.f7277d;
            }

            public LatLng getLocation() {
                return this.f7276c;
            }

            public String getName() {
                return this.f7274a;
            }

            public int getType() {
                return this.f7275b;
            }

            public void setDetail(String str) {
                this.f7277d = str;
            }

            public void setLocation(LatLng latLng) {
                this.f7276c = latLng;
            }

            public void setName(String str) {
                this.f7274a = str;
            }

            public void setType(int i) {
                this.f7275b = i;
            }
        }

        private List<LatLng> a(List<Double> list) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i += 2) {
                arrayList.add(new LatLng(list.get(i).doubleValue(), list.get(i + 1).doubleValue()));
            }
            return arrayList;
        }

        public String getBuildingId() {
            return this.f7273h;
        }

        public RouteNode getEntrace() {
            return this.f7269d;
        }

        public RouteNode getExit() {
            return this.f7270e;
        }

        public String getFloorId() {
            return this.f7272g;
        }

        public String getInstructions() {
            return this.f7271f;
        }

        public List<IndoorStepNode> getStepNodes() {
            return this.i;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep
        public List<LatLng> getWayPoints() {
            if (this.mWayPoints == null) {
                this.mWayPoints = a(this.j);
            }
            return this.mWayPoints;
        }

        public void setBuildingId(String str) {
            this.f7273h = str;
        }

        public void setEntrace(RouteNode routeNode) {
            this.f7269d = routeNode;
        }

        public void setExit(RouteNode routeNode) {
            this.f7270e = routeNode;
        }

        public void setFloorId(String str) {
            this.f7272g = str;
        }

        public void setInstructions(String str) {
            this.f7271f = str;
        }

        public void setPath(List<Double> list) {
            this.j = list;
        }

        public void setStepNodes(List<IndoorStepNode> list) {
            this.i = list;
        }
    }

    public IndoorRouteLine() {
        setType(RouteLine.TYPE.WALKSTEP);
    }

    public IndoorRouteLine(Parcel parcel) {
        super(parcel);
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.baidu.mapapi.search.core.RouteLine
    public List<IndoorRouteStep> getAllStep() {
        return super.getAllStep();
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}
