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
        public RouteNode f7379d;

        /* renamed from: e  reason: collision with root package name */
        public RouteNode f7380e;

        /* renamed from: f  reason: collision with root package name */
        public String f7381f;

        /* renamed from: g  reason: collision with root package name */
        public String f7382g;

        /* renamed from: h  reason: collision with root package name */
        public String f7383h;

        /* renamed from: i  reason: collision with root package name */
        public List<IndoorStepNode> f7384i;
        public List<Double> j;

        /* loaded from: classes2.dex */
        public static class IndoorStepNode {

            /* renamed from: a  reason: collision with root package name */
            public String f7385a;

            /* renamed from: b  reason: collision with root package name */
            public int f7386b;

            /* renamed from: c  reason: collision with root package name */
            public LatLng f7387c;

            /* renamed from: d  reason: collision with root package name */
            public String f7388d;

            public String getDetail() {
                return this.f7388d;
            }

            public LatLng getLocation() {
                return this.f7387c;
            }

            public String getName() {
                return this.f7385a;
            }

            public int getType() {
                return this.f7386b;
            }

            public void setDetail(String str) {
                this.f7388d = str;
            }

            public void setLocation(LatLng latLng) {
                this.f7387c = latLng;
            }

            public void setName(String str) {
                this.f7385a = str;
            }

            public void setType(int i2) {
                this.f7386b = i2;
            }
        }

        private List<LatLng> a(List<Double> list) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2 += 2) {
                arrayList.add(new LatLng(list.get(i2).doubleValue(), list.get(i2 + 1).doubleValue()));
            }
            return arrayList;
        }

        public String getBuildingId() {
            return this.f7383h;
        }

        public RouteNode getEntrace() {
            return this.f7379d;
        }

        public RouteNode getExit() {
            return this.f7380e;
        }

        public String getFloorId() {
            return this.f7382g;
        }

        public String getInstructions() {
            return this.f7381f;
        }

        public List<IndoorStepNode> getStepNodes() {
            return this.f7384i;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep
        public List<LatLng> getWayPoints() {
            if (this.mWayPoints == null) {
                this.mWayPoints = a(this.j);
            }
            return this.mWayPoints;
        }

        public void setBuildingId(String str) {
            this.f7383h = str;
        }

        public void setEntrace(RouteNode routeNode) {
            this.f7379d = routeNode;
        }

        public void setExit(RouteNode routeNode) {
            this.f7380e = routeNode;
        }

        public void setFloorId(String str) {
            this.f7382g = str;
        }

        public void setInstructions(String str) {
            this.f7381f = str;
        }

        public void setPath(List<Double> list) {
            this.j = list;
        }

        public void setStepNodes(List<IndoorStepNode> list) {
            this.f7384i = list;
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
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
    }
}
