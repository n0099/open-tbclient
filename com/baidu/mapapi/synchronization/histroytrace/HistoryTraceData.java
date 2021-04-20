package com.baidu.mapapi.synchronization.histroytrace;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.synchronization.SyncCoordinateConverter;
import java.util.List;
/* loaded from: classes2.dex */
public class HistoryTraceData implements Parcelable {
    public static final Parcelable.Creator<HistoryTraceData> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f7398a;

    /* renamed from: b  reason: collision with root package name */
    public double f7399b;

    /* renamed from: c  reason: collision with root package name */
    public double f7400c;

    /* renamed from: d  reason: collision with root package name */
    public int f7401d;

    /* renamed from: e  reason: collision with root package name */
    public LatLng f7402e;

    /* renamed from: f  reason: collision with root package name */
    public LatLng f7403f;

    /* renamed from: g  reason: collision with root package name */
    public SyncCoordinateConverter.CoordType f7404g = SyncCoordinateConverter.CoordType.BD09LL;

    /* renamed from: h  reason: collision with root package name */
    public List<HistoryTracePoint> f7405h;
    public int i;

    /* loaded from: classes2.dex */
    public static class HistoryTracePoint implements Parcelable {
        public static final Parcelable.Creator<HistoryTracePoint> CREATOR = new b();

        /* renamed from: a  reason: collision with root package name */
        public LatLng f7406a;

        /* renamed from: b  reason: collision with root package name */
        public long f7407b;

        /* renamed from: c  reason: collision with root package name */
        public String f7408c;

        public HistoryTracePoint() {
        }

        public HistoryTracePoint(Parcel parcel) {
            this.f7406a = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.f7407b = parcel.readLong();
            this.f7408c = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getCreateTime() {
            return this.f7408c;
        }

        public long getLocationTime() {
            return this.f7407b;
        }

        public LatLng getPoint() {
            return this.f7406a;
        }

        public void setCreateTime(String str) {
            this.f7408c = str;
        }

        public void setLocationTime(long j) {
            this.f7407b = j;
        }

        public void setPoint(LatLng latLng) {
            this.f7406a = latLng;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f7406a, i);
            parcel.writeLong(this.f7407b);
            parcel.writeString(this.f7408c);
        }
    }

    public HistoryTraceData() {
    }

    public HistoryTraceData(Parcel parcel) {
        this.f7398a = parcel.readInt();
        this.f7399b = parcel.readDouble();
        this.f7400c = parcel.readDouble();
        this.f7401d = parcel.readInt();
        this.f7402e = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f7403f = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f7405h = parcel.createTypedArrayList(HistoryTracePoint.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SyncCoordinateConverter.CoordType getCoordType() {
        return this.f7404g;
    }

    public int getCurrentOrderState() {
        return this.f7401d;
    }

    public int getCurrentPageIndex() {
        return this.i;
    }

    public double getDistance() {
        return this.f7399b;
    }

    public LatLng getOrderEndPosition() {
        return this.f7403f;
    }

    public LatLng getOrderStartPosition() {
        return this.f7402e;
    }

    public List<HistoryTracePoint> getPointsList() {
        return this.f7405h;
    }

    public double getTollDiatance() {
        return this.f7400c;
    }

    public int getTotalPoints() {
        return this.f7398a;
    }

    public void setCoordType(SyncCoordinateConverter.CoordType coordType) {
        this.f7404g = coordType;
    }

    public void setCurrentOrderState(int i) {
        this.f7401d = i;
    }

    public void setCurrentPageIndex(int i) {
        this.i = i;
    }

    public void setDistance(double d2) {
        this.f7399b = d2;
    }

    public void setOrderEndPosition(LatLng latLng) {
        this.f7403f = latLng;
    }

    public void setOrderStartPosition(LatLng latLng) {
        this.f7402e = latLng;
    }

    public void setPointsList(List<HistoryTracePoint> list) {
        this.f7405h = list;
    }

    public void setTollDiatance(double d2) {
        this.f7400c = d2;
    }

    public void setTotalPoints(int i) {
        this.f7398a = i;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("HistoryTraceData: \n");
        stringBuffer.append("TotalPoints = ");
        stringBuffer.append(this.f7398a);
        stringBuffer.append("; Distance = ");
        stringBuffer.append(this.f7399b);
        stringBuffer.append("; TollDistance = ");
        stringBuffer.append(this.f7400c);
        stringBuffer.append("; CurrentOrderState = ");
        stringBuffer.append(this.f7401d);
        stringBuffer.append("; OrderStartPosition = ");
        stringBuffer.append(this.f7402e);
        stringBuffer.append("; OrderEndPosition = ");
        stringBuffer.append(this.f7403f);
        List<HistoryTracePoint> list = this.f7405h;
        if (list != null && !list.isEmpty()) {
            stringBuffer.append("\n#History Trace Points Info BEGIN# \n");
            for (int i = 0; i < this.f7405h.size(); i++) {
                HistoryTracePoint historyTracePoint = this.f7405h.get(i);
                if (historyTracePoint != null) {
                    stringBuffer.append("The ");
                    stringBuffer.append(i);
                    stringBuffer.append(" Point Info: ");
                    stringBuffer.append("Point = ");
                    stringBuffer.append(historyTracePoint.getPoint().toString());
                    stringBuffer.append("; LocationTime = ");
                    stringBuffer.append(historyTracePoint.getLocationTime());
                    stringBuffer.append("; CreateTime = ");
                    stringBuffer.append(historyTracePoint.getCreateTime());
                    stringBuffer.append("\n");
                }
            }
        }
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f7398a);
        parcel.writeDouble(this.f7399b);
        parcel.writeDouble(this.f7400c);
        parcel.writeInt(this.f7401d);
        parcel.writeParcelable(this.f7402e, i);
        parcel.writeParcelable(this.f7403f, i);
        parcel.writeTypedList(this.f7405h);
    }
}
