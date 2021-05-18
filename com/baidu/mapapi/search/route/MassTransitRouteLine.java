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
    public String f7390b;

    /* renamed from: c  reason: collision with root package name */
    public double f7391c;

    /* renamed from: d  reason: collision with root package name */
    public List<PriceInfo> f7392d;

    /* renamed from: e  reason: collision with root package name */
    public List<List<TransitStep>> f7393e;

    /* loaded from: classes2.dex */
    public static class TransitStep extends RouteStep implements Parcelable {
        public static final Parcelable.Creator<TransitStep> CREATOR = new j();

        /* renamed from: d  reason: collision with root package name */
        public List<TrafficCondition> f7394d;

        /* renamed from: e  reason: collision with root package name */
        public LatLng f7395e;

        /* renamed from: f  reason: collision with root package name */
        public LatLng f7396f;

        /* renamed from: g  reason: collision with root package name */
        public TrainInfo f7397g;

        /* renamed from: h  reason: collision with root package name */
        public PlaneInfo f7398h;

        /* renamed from: i  reason: collision with root package name */
        public CoachInfo f7399i;
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
            public int f7400a;

            StepVehicleInfoType(int i2) {
                this.f7400a = 0;
                this.f7400a = i2;
            }

            public int getInt() {
                return this.f7400a;
            }
        }

        /* loaded from: classes2.dex */
        public static class TrafficCondition implements Parcelable {
            public static final Parcelable.Creator<TrafficCondition> CREATOR = new k();

            /* renamed from: a  reason: collision with root package name */
            public int f7401a;

            /* renamed from: b  reason: collision with root package name */
            public int f7402b;

            public TrafficCondition() {
            }

            public TrafficCondition(Parcel parcel) {
                this.f7401a = parcel.readInt();
                this.f7402b = parcel.readInt();
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public int getTrafficGeoCnt() {
                return this.f7402b;
            }

            public int getTrafficStatus() {
                return this.f7401a;
            }

            public void setTrafficGeoCnt(int i2) {
                this.f7402b = i2;
            }

            public void setTrafficStatus(int i2) {
                this.f7401a = i2;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i2) {
                parcel.writeInt(this.f7401a);
                parcel.writeInt(this.f7402b);
            }
        }

        public TransitStep() {
        }

        public TransitStep(Parcel parcel) {
            super(parcel);
            StepVehicleInfoType stepVehicleInfoType;
            this.f7394d = parcel.createTypedArrayList(TrafficCondition.CREATOR);
            this.f7395e = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.f7396f = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.f7397g = (TrainInfo) parcel.readParcelable(TrainInfo.class.getClassLoader());
            this.f7398h = (PlaneInfo) parcel.readParcelable(PlaneInfo.class.getClassLoader());
            this.f7399i = (CoachInfo) parcel.readParcelable(CoachInfo.class.getClassLoader());
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
                for (int i2 = 0; i2 < split2.length; i2++) {
                    if (split2[i2] != null && split2[i2] != "" && (split = split2[i2].split(",")) != null && split[1] != "" && split[0] != "") {
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
            return this.f7399i;
        }

        public LatLng getEndLocation() {
            return this.f7396f;
        }

        public String getInstructions() {
            return this.l;
        }

        public PlaneInfo getPlaneInfo() {
            return this.f7398h;
        }

        public LatLng getStartLocation() {
            return this.f7395e;
        }

        public List<TrafficCondition> getTrafficConditions() {
            return this.f7394d;
        }

        public TrainInfo getTrainInfo() {
            return this.f7397g;
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
            this.f7399i = coachInfo;
        }

        public void setEndLocation(LatLng latLng) {
            this.f7396f = latLng;
        }

        public void setInstructions(String str) {
            this.l = str;
        }

        public void setPathString(String str) {
            this.m = str;
        }

        public void setPlaneInfo(PlaneInfo planeInfo) {
            this.f7398h = planeInfo;
        }

        public void setStartLocation(LatLng latLng) {
            this.f7395e = latLng;
        }

        public void setTrafficConditions(List<TrafficCondition> list) {
            this.f7394d = list;
        }

        public void setTrainInfo(TrainInfo trainInfo) {
            this.f7397g = trainInfo;
        }

        public void setVehileType(StepVehicleInfoType stepVehicleInfoType) {
            this.k = stepVehicleInfoType;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeTypedList(this.f7394d);
            parcel.writeParcelable(this.f7395e, i2);
            parcel.writeParcelable(this.f7396f, i2);
            parcel.writeParcelable(this.f7397g, i2);
            parcel.writeParcelable(this.f7398h, i2);
            parcel.writeParcelable(this.f7399i, i2);
            parcel.writeParcelable(this.j, i2);
            parcel.writeInt(this.k.getInt());
            parcel.writeString(this.l);
            parcel.writeString(this.m);
        }
    }

    public MassTransitRouteLine() {
        this.f7393e = null;
    }

    public MassTransitRouteLine(Parcel parcel) {
        super(parcel);
        this.f7393e = null;
        int readInt = parcel.readInt();
        this.f7390b = parcel.readString();
        this.f7391c = parcel.readDouble();
        this.f7392d = parcel.createTypedArrayList(PriceInfo.CREATOR);
        if (readInt > 0) {
            this.f7393e = new ArrayList();
            for (int i2 = 0; i2 < readInt; i2++) {
                this.f7393e.add(parcel.createTypedArrayList(TransitStep.CREATOR));
            }
        }
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getArriveTime() {
        return this.f7390b;
    }

    public List<List<TransitStep>> getNewSteps() {
        return this.f7393e;
    }

    public double getPrice() {
        return this.f7391c;
    }

    public List<PriceInfo> getPriceInfo() {
        return this.f7392d;
    }

    public void setArriveTime(String str) {
        this.f7390b = str;
    }

    public void setNewSteps(List<List<TransitStep>> list) {
        this.f7393e = list;
    }

    public void setPrice(double d2) {
        this.f7391c = d2;
    }

    public void setPriceInfo(List<PriceInfo> list) {
        this.f7392d = list;
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        List<List<TransitStep>> list = this.f7393e;
        parcel.writeInt(list == null ? 0 : list.size());
        parcel.writeString(this.f7390b);
        parcel.writeDouble(this.f7391c);
        parcel.writeTypedList(this.f7392d);
        for (List<TransitStep> list2 : this.f7393e) {
            parcel.writeTypedList(list2);
        }
    }
}
