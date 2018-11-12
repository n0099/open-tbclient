package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class BikingRouteLine extends RouteLine<BikingStep> implements Parcelable {
    public static final Parcelable.Creator<BikingRouteLine> CREATOR = new a();

    /* loaded from: classes4.dex */
    public static class BikingStep extends RouteStep implements Parcelable {
        public static final Parcelable.Creator<BikingStep> CREATOR = new b();
        private int d;
        private RouteNode e;
        private RouteNode f;
        private String g;
        private String h;
        private String i;
        private String j;
        private String k;

        public BikingStep() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public BikingStep(Parcel parcel) {
            super(parcel);
            this.d = parcel.readInt();
            this.e = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.f = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.g = parcel.readString();
            this.h = parcel.readString();
            this.i = parcel.readString();
            this.j = parcel.readString();
            this.k = parcel.readString();
        }

        private List<LatLng> a(String str) {
            if (str == null || str.length() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            String[] split = str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            if (split == null || split.length == 0) {
                return null;
            }
            for (String str2 : split) {
                String[] split2 = str2.split(",");
                if (split2 != null && split2.length >= 2) {
                    LatLng latLng = new LatLng(Double.valueOf(split2[1]).doubleValue(), Double.valueOf(split2[0]).doubleValue());
                    if (latLng != null && SDKInitializer.getCoordType() == CoordType.GCJ02) {
                        latLng = CoordTrans.baiduToGcj(latLng);
                    }
                    arrayList.add(latLng);
                }
            }
            return arrayList;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int getDirection() {
            return this.d;
        }

        public RouteNode getEntrance() {
            return this.e;
        }

        public String getEntranceInstructions() {
            return this.h;
        }

        public RouteNode getExit() {
            return this.f;
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
                this.mWayPoints = a(this.g);
            }
            return this.mWayPoints;
        }

        public void setDirection(int i) {
            this.d = i;
        }

        public void setEntrance(RouteNode routeNode) {
            this.e = routeNode;
        }

        public void setEntranceInstructions(String str) {
            this.h = str;
        }

        public void setExit(RouteNode routeNode) {
            this.f = routeNode;
        }

        public void setExitInstructions(String str) {
            this.i = str;
        }

        public void setInstructions(String str) {
            this.j = str;
        }

        public void setPathString(String str) {
            this.g = str;
        }

        public void setTurnType(String str) {
            this.k = str;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, 1);
            parcel.writeInt(this.d);
            parcel.writeParcelable(this.e, 1);
            parcel.writeParcelable(this.f, 1);
            parcel.writeString(this.g);
            parcel.writeString(this.h);
            parcel.writeString(this.i);
            parcel.writeString(this.j);
            parcel.writeString(this.k);
        }
    }

    public BikingRouteLine() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
