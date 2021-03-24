package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.BusInfo;
import com.baidu.mapapi.search.core.CoachInfo;
import com.baidu.mapapi.search.core.PlaneInfo;
import com.baidu.mapapi.search.core.PriceInfo;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapapi.search.core.TrainInfo;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class MassTransitRouteLine extends RouteLine<TransitStep> implements Parcelable {
    public static final Parcelable.Creator<MassTransitRouteLine> CREATOR = new i();

    /* renamed from: b  reason: collision with root package name */
    public String f7278b;

    /* renamed from: c  reason: collision with root package name */
    public double f7279c;

    /* renamed from: d  reason: collision with root package name */
    public List<PriceInfo> f7280d;

    /* renamed from: e  reason: collision with root package name */
    public List<List<TransitStep>> f7281e;

    /* loaded from: classes2.dex */
    public static class TransitStep extends RouteStep implements Parcelable {
        public static final Parcelable.Creator<TransitStep> CREATOR = new j();

        /* renamed from: d  reason: collision with root package name */
        public List<TrafficCondition> f7282d;

        /* renamed from: e  reason: collision with root package name */
        public LatLng f7283e;

        /* renamed from: f  reason: collision with root package name */
        public LatLng f7284f;

        /* renamed from: g  reason: collision with root package name */
        public TrainInfo f7285g;

        /* renamed from: h  reason: collision with root package name */
        public PlaneInfo f7286h;
        public CoachInfo i;
        public BusInfo j;
        public StepVehicleInfoType k;
        public String l;
        public String m;

        /* loaded from: classes2.dex */
        public enum StepVehicleInfoType {
            ESTEP_TRAIN(1),
            ESTEP_PLANE(2),
            ESTEP_BUS(3),
            ESTEP_DRIVING(4),
            ESTEP_WALK(5),
            ESTEP_COACH(6);
            

            /* renamed from: a  reason: collision with root package name */
            public int f7287a;

            StepVehicleInfoType(int i) {
                this.f7287a = 0;
                this.f7287a = i;
            }

            public int getInt() {
                return this.f7287a;
            }
        }

        /* loaded from: classes2.dex */
        public static class TrafficCondition implements Parcelable {
            public static final Parcelable.Creator<TrafficCondition> CREATOR = new k();

            /* renamed from: a  reason: collision with root package name */
            public int f7288a;

            /* renamed from: b  reason: collision with root package name */
            public int f7289b;

            public TrafficCondition() {
            }

            public TrafficCondition(Parcel parcel) {
                this.f7288a = parcel.readInt();
                this.f7289b = parcel.readInt();
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public int getTrafficGeoCnt() {
                return this.f7289b;
            }

            public int getTrafficStatus() {
                return this.f7288a;
            }

            public void setTrafficGeoCnt(int i) {
                this.f7289b = i;
            }

            public void setTrafficStatus(int i) {
                this.f7288a = i;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f7288a);
                parcel.writeInt(this.f7289b);
            }
        }

        public TransitStep() {
        }

        public TransitStep(Parcel parcel) {
            super(parcel);
            StepVehicleInfoType stepVehicleInfoType;
            this.f7282d = parcel.createTypedArrayList(TrafficCondition.CREATOR);
            this.f7283e = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.f7284f = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.f7285g = (TrainInfo) parcel.readParcelable(TrainInfo.class.getClassLoader());
            this.f7286h = (PlaneInfo) parcel.readParcelable(PlaneInfo.class.getClassLoader());
            this.i = (CoachInfo) parcel.readParcelable(CoachInfo.class.getClassLoader());
            this.j = (BusInfo) parcel.readParcelable(BusInfo.class.getClassLoader());
            switch (parcel.readInt()) {
                case 1:
                    stepVehicleInfoType = StepVehicleInfoType.ESTEP_TRAIN;
                    break;
                case 2:
                    stepVehicleInfoType = StepVehicleInfoType.ESTEP_PLANE;
                    break;
                case 3:
                    stepVehicleInfoType = StepVehicleInfoType.ESTEP_BUS;
                    break;
                case 4:
                    stepVehicleInfoType = StepVehicleInfoType.ESTEP_DRIVING;
                    break;
                case 5:
                    stepVehicleInfoType = StepVehicleInfoType.ESTEP_WALK;
                    break;
                case 6:
                    stepVehicleInfoType = StepVehicleInfoType.ESTEP_COACH;
                    break;
                default:
                    this.l = parcel.readString();
                    this.m = parcel.readString();
            }
            this.k = stepVehicleInfoType;
            this.l = parcel.readString();
            this.m = parcel.readString();
        }

        private List<LatLng> a(String str) {
            String[] split;
            ArrayList arrayList = new ArrayList();
            String[] split2 = str.split(";");
            if (split2 != null) {
                for (int i = 0; i < split2.length; i++) {
                    if (split2[i] != null && split2[i] != "" && (split = split2[i].split(",")) != null && split[1] != "" && split[0] != "") {
                        LatLng latLng = new LatLng(Double.parseDouble(split[1]), Double.parseDouble(split[0]));
                        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                            latLng = CoordTrans.baiduToGcj(latLng);
                        }
                        arrayList.add(latLng);
                    }
                }
            }
            return arrayList;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public BusInfo getBusInfo() {
            return this.j;
        }

        public CoachInfo getCoachInfo() {
            return this.i;
        }

        public LatLng getEndLocation() {
            return this.f7284f;
        }

        public String getInstructions() {
            return this.l;
        }

        public PlaneInfo getPlaneInfo() {
            return this.f7286h;
        }

        public LatLng getStartLocation() {
            return this.f7283e;
        }

        public List<TrafficCondition> getTrafficConditions() {
            return this.f7282d;
        }

        public TrainInfo getTrainInfo() {
            return this.f7285g;
        }

        public StepVehicleInfoType getVehileType() {
            return this.k;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep
        public List<LatLng> getWayPoints() {
            if (this.mWayPoints == null) {
                this.mWayPoints = a(this.m);
            }
            return this.mWayPoints;
        }

        public void setBusInfo(BusInfo busInfo) {
            this.j = busInfo;
        }

        public void setCoachInfo(CoachInfo coachInfo) {
            this.i = coachInfo;
        }

        public void setEndLocation(LatLng latLng) {
            this.f7284f = latLng;
        }

        public void setInstructions(String str) {
            this.l = str;
        }

        public void setPathString(String str) {
            this.m = str;
        }

        public void setPlaneInfo(PlaneInfo planeInfo) {
            this.f7286h = planeInfo;
        }

        public void setStartLocation(LatLng latLng) {
            this.f7283e = latLng;
        }

        public void setTrafficConditions(List<TrafficCondition> list) {
            this.f7282d = list;
        }

        public void setTrainInfo(TrainInfo trainInfo) {
            this.f7285g = trainInfo;
        }

        public void setVehileType(StepVehicleInfoType stepVehicleInfoType) {
            this.k = stepVehicleInfoType;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeTypedList(this.f7282d);
            parcel.writeParcelable(this.f7283e, i);
            parcel.writeParcelable(this.f7284f, i);
            parcel.writeParcelable(this.f7285g, i);
            parcel.writeParcelable(this.f7286h, i);
            parcel.writeParcelable(this.i, i);
            parcel.writeParcelable(this.j, i);
            parcel.writeInt(this.k.getInt());
            parcel.writeString(this.l);
            parcel.writeString(this.m);
        }
    }

    public MassTransitRouteLine() {
        this.f7281e = null;
    }

    public MassTransitRouteLine(Parcel parcel) {
        super(parcel);
        this.f7281e = null;
        int readInt = parcel.readInt();
        this.f7278b = parcel.readString();
        this.f7279c = parcel.readDouble();
        this.f7280d = parcel.createTypedArrayList(PriceInfo.CREATOR);
        if (readInt > 0) {
            this.f7281e = new ArrayList();
            for (int i = 0; i < readInt; i++) {
                this.f7281e.add(parcel.createTypedArrayList(TransitStep.CREATOR));
            }
        }
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getArriveTime() {
        return this.f7278b;
    }

    public List<List<TransitStep>> getNewSteps() {
        return this.f7281e;
    }

    public double getPrice() {
        return this.f7279c;
    }

    public List<PriceInfo> getPriceInfo() {
        return this.f7280d;
    }

    public void setArriveTime(String str) {
        this.f7278b = str;
    }

    public void setNewSteps(List<List<TransitStep>> list) {
        this.f7281e = list;
    }

    public void setPrice(double d2) {
        this.f7279c = d2;
    }

    public void setPriceInfo(List<PriceInfo> list) {
        this.f7280d = list;
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        List<List<TransitStep>> list = this.f7281e;
        parcel.writeInt(list == null ? 0 : list.size());
        parcel.writeString(this.f7278b);
        parcel.writeDouble(this.f7279c);
        parcel.writeTypedList(this.f7280d);
        for (List<TransitStep> list2 : this.f7281e) {
            parcel.writeTypedList(list2);
        }
    }
}
