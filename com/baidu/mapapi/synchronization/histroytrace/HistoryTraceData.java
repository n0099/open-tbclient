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
    public int f7662a;

    /* renamed from: b  reason: collision with root package name */
    public double f7663b;

    /* renamed from: c  reason: collision with root package name */
    public double f7664c;

    /* renamed from: d  reason: collision with root package name */
    public int f7665d;

    /* renamed from: e  reason: collision with root package name */
    public LatLng f7666e;

    /* renamed from: f  reason: collision with root package name */
    public LatLng f7667f;

    /* renamed from: g  reason: collision with root package name */
    public SyncCoordinateConverter.CoordType f7668g = SyncCoordinateConverter.CoordType.BD09LL;

    /* renamed from: h  reason: collision with root package name */
    public List<HistoryTracePoint> f7669h;

    /* renamed from: i  reason: collision with root package name */
    public int f7670i;

    /* loaded from: classes2.dex */
    public static class HistoryTracePoint implements Parcelable {
        public static final Parcelable.Creator<HistoryTracePoint> CREATOR = new b();

        /* renamed from: a  reason: collision with root package name */
        public LatLng f7671a;

        /* renamed from: b  reason: collision with root package name */
        public long f7672b;

        /* renamed from: c  reason: collision with root package name */
        public String f7673c;

        public HistoryTracePoint() {
        }

        public HistoryTracePoint(Parcel parcel) {
            this.f7671a = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.f7672b = parcel.readLong();
            this.f7673c = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getCreateTime() {
            return this.f7673c;
        }

        public long getLocationTime() {
            return this.f7672b;
        }

        public LatLng getPoint() {
            return this.f7671a;
        }

        public void setCreateTime(String str) {
            this.f7673c = str;
        }

        public void setLocationTime(long j) {
            this.f7672b = j;
        }

        public void setPoint(LatLng latLng) {
            this.f7671a = latLng;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeParcelable(this.f7671a, i2);
            parcel.writeLong(this.f7672b);
            parcel.writeString(this.f7673c);
        }
    }

    public HistoryTraceData() {
    }

    public HistoryTraceData(Parcel parcel) {
        this.f7662a = parcel.readInt();
        this.f7663b = parcel.readDouble();
        this.f7664c = parcel.readDouble();
        this.f7665d = parcel.readInt();
        this.f7666e = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f7667f = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f7669h = parcel.createTypedArrayList(HistoryTracePoint.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SyncCoordinateConverter.CoordType getCoordType() {
        return this.f7668g;
    }

    public int getCurrentOrderState() {
        return this.f7665d;
    }

    public int getCurrentPageIndex() {
        return this.f7670i;
    }

    public double getDistance() {
        return this.f7663b;
    }

    public LatLng getOrderEndPosition() {
        return this.f7667f;
    }

    public LatLng getOrderStartPosition() {
        return this.f7666e;
    }

    public List<HistoryTracePoint> getPointsList() {
        return this.f7669h;
    }

    public double getTollDiatance() {
        return this.f7664c;
    }

    public int getTotalPoints() {
        return this.f7662a;
    }

    public void setCoordType(SyncCoordinateConverter.CoordType coordType) {
        this.f7668g = coordType;
    }

    public void setCurrentOrderState(int i2) {
        this.f7665d = i2;
    }

    public void setCurrentPageIndex(int i2) {
        this.f7670i = i2;
    }

    public void setDistance(double d2) {
        this.f7663b = d2;
    }

    public void setOrderEndPosition(LatLng latLng) {
        this.f7667f = latLng;
    }

    public void setOrderStartPosition(LatLng latLng) {
        this.f7666e = latLng;
    }

    public void setPointsList(List<HistoryTracePoint> list) {
        this.f7669h = list;
    }

    public void setTollDiatance(double d2) {
        this.f7664c = d2;
    }

    public void setTotalPoints(int i2) {
        this.f7662a = i2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("HistoryTraceData: \n");
        stringBuffer.append("TotalPoints = ");
        stringBuffer.append(this.f7662a);
        stringBuffer.append("; Distance = ");
        stringBuffer.append(this.f7663b);
        stringBuffer.append("; TollDistance = ");
        stringBuffer.append(this.f7664c);
        stringBuffer.append("; CurrentOrderState = ");
        stringBuffer.append(this.f7665d);
        stringBuffer.append("; OrderStartPosition = ");
        stringBuffer.append(this.f7666e);
        stringBuffer.append("; OrderEndPosition = ");
        stringBuffer.append(this.f7667f);
        List<HistoryTracePoint> list = this.f7669h;
        if (list != null && !list.isEmpty()) {
            stringBuffer.append("\n#History Trace Points Info BEGIN# \n");
            for (int i2 = 0; i2 < this.f7669h.size(); i2++) {
                HistoryTracePoint historyTracePoint = this.f7669h.get(i2);
                if (historyTracePoint != null) {
                    stringBuffer.append("The ");
                    stringBuffer.append(i2);
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
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f7662a);
        parcel.writeDouble(this.f7663b);
        parcel.writeDouble(this.f7664c);
        parcel.writeInt(this.f7665d);
        parcel.writeParcelable(this.f7666e, i2);
        parcel.writeParcelable(this.f7667f, i2);
        parcel.writeTypedList(this.f7669h);
    }
}
