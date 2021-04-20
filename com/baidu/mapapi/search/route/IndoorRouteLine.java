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
        public RouteNode f7304d;

        /* renamed from: e  reason: collision with root package name */
        public RouteNode f7305e;

        /* renamed from: f  reason: collision with root package name */
        public String f7306f;

        /* renamed from: g  reason: collision with root package name */
        public String f7307g;

        /* renamed from: h  reason: collision with root package name */
        public String f7308h;
        public List<IndoorStepNode> i;
        public List<Double> j;

        /* loaded from: classes2.dex */
        public static class IndoorStepNode {

            /* renamed from: a  reason: collision with root package name */
            public String f7309a;

            /* renamed from: b  reason: collision with root package name */
            public int f7310b;

            /* renamed from: c  reason: collision with root package name */
            public LatLng f7311c;

            /* renamed from: d  reason: collision with root package name */
            public String f7312d;

            public String getDetail() {
                return this.f7312d;
            }

            public LatLng getLocation() {
                return this.f7311c;
            }

            public String getName() {
                return this.f7309a;
            }

            public int getType() {
                return this.f7310b;
            }

            public void setDetail(String str) {
                this.f7312d = str;
            }

            public void setLocation(LatLng latLng) {
                this.f7311c = latLng;
            }

            public void setName(String str) {
                this.f7309a = str;
            }

            public void setType(int i) {
                this.f7310b = i;
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
            return this.f7308h;
        }

        public RouteNode getEntrace() {
            return this.f7304d;
        }

        public RouteNode getExit() {
            return this.f7305e;
        }

        public String getFloorId() {
            return this.f7307g;
        }

        public String getInstructions() {
            return this.f7306f;
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
            this.f7308h = str;
        }

        public void setEntrace(RouteNode routeNode) {
            this.f7304d = routeNode;
        }

        public void setExit(RouteNode routeNode) {
            this.f7305e = routeNode;
        }

        public void setFloorId(String str) {
            this.f7307g = str;
        }

        public void setInstructions(String str) {
            this.f7306f = str;
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
