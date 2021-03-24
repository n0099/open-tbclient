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
    public int f7362a;

    /* renamed from: b  reason: collision with root package name */
    public double f7363b;

    /* renamed from: c  reason: collision with root package name */
    public double f7364c;

    /* renamed from: d  reason: collision with root package name */
    public int f7365d;

    /* renamed from: e  reason: collision with root package name */
    public LatLng f7366e;

    /* renamed from: f  reason: collision with root package name */
    public LatLng f7367f;

    /* renamed from: g  reason: collision with root package name */
    public SyncCoordinateConverter.CoordType f7368g = SyncCoordinateConverter.CoordType.BD09LL;

    /* renamed from: h  reason: collision with root package name */
    public List<HistoryTracePoint> f7369h;
    public int i;

    /* loaded from: classes2.dex */
    public static class HistoryTracePoint implements Parcelable {
        public static final Parcelable.Creator<HistoryTracePoint> CREATOR = new b();

        /* renamed from: a  reason: collision with root package name */
        public LatLng f7370a;

        /* renamed from: b  reason: collision with root package name */
        public long f7371b;

        /* renamed from: c  reason: collision with root package name */
        public String f7372c;

        public HistoryTracePoint() {
        }

        public HistoryTracePoint(Parcel parcel) {
            this.f7370a = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.f7371b = parcel.readLong();
            this.f7372c = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getCreateTime() {
            return this.f7372c;
        }

        public long getLocationTime() {
            return this.f7371b;
        }

        public LatLng getPoint() {
            return this.f7370a;
        }

        public void setCreateTime(String str) {
            this.f7372c = str;
        }

        public void setLocationTime(long j) {
            this.f7371b = j;
        }

        public void setPoint(LatLng latLng) {
            this.f7370a = latLng;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f7370a, i);
            parcel.writeLong(this.f7371b);
            parcel.writeString(this.f7372c);
        }
    }

    public HistoryTraceData() {
    }

    public HistoryTraceData(Parcel parcel) {
        this.f7362a = parcel.readInt();
        this.f7363b = parcel.readDouble();
        this.f7364c = parcel.readDouble();
        this.f7365d = parcel.readInt();
        this.f7366e = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f7367f = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f7369h = parcel.createTypedArrayList(HistoryTracePoint.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SyncCoordinateConverter.CoordType getCoordType() {
        return this.f7368g;
    }

    public int getCurrentOrderState() {
        return this.f7365d;
    }

    public int getCurrentPageIndex() {
        return this.i;
    }

    public double getDistance() {
        return this.f7363b;
    }

    public LatLng getOrderEndPosition() {
        return this.f7367f;
    }

    public LatLng getOrderStartPosition() {
        return this.f7366e;
    }

    public List<HistoryTracePoint> getPointsList() {
        return this.f7369h;
    }

    public double getTollDiatance() {
        return this.f7364c;
    }

    public int getTotalPoints() {
        return this.f7362a;
    }

    public void setCoordType(SyncCoordinateConverter.CoordType coordType) {
        this.f7368g = coordType;
    }

    public void setCurrentOrderState(int i) {
        this.f7365d = i;
    }

    public void setCurrentPageIndex(int i) {
        this.i = i;
    }

    public void setDistance(double d2) {
        this.f7363b = d2;
    }

    public void setOrderEndPosition(LatLng latLng) {
        this.f7367f = latLng;
    }

    public void setOrderStartPosition(LatLng latLng) {
        this.f7366e = latLng;
    }

    public void setPointsList(List<HistoryTracePoint> list) {
        this.f7369h = list;
    }

    public void setTollDiatance(double d2) {
        this.f7364c = d2;
    }

    public void setTotalPoints(int i) {
        this.f7362a = i;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("HistoryTraceData: \n");
        stringBuffer.append("TotalPoints = ");
        stringBuffer.append(this.f7362a);
        stringBuffer.append("; Distance = ");
        stringBuffer.append(this.f7363b);
        stringBuffer.append("; TollDistance = ");
        stringBuffer.append(this.f7364c);
        stringBuffer.append("; CurrentOrderState = ");
        stringBuffer.append(this.f7365d);
        stringBuffer.append("; OrderStartPosition = ");
        stringBuffer.append(this.f7366e);
        stringBuffer.append("; OrderEndPosition = ");
        stringBuffer.append(this.f7367f);
        List<HistoryTracePoint> list = this.f7369h;
        if (list != null && !list.isEmpty()) {
            stringBuffer.append("\n#History Trace Points Info BEGIN# \n");
            for (int i = 0; i < this.f7369h.size(); i++) {
                HistoryTracePoint historyTracePoint = this.f7369h.get(i);
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
        parcel.writeInt(this.f7362a);
        parcel.writeDouble(this.f7363b);
        parcel.writeDouble(this.f7364c);
        parcel.writeInt(this.f7365d);
        parcel.writeParcelable(this.f7366e, i);
        parcel.writeParcelable(this.f7367f, i);
        parcel.writeTypedList(this.f7369h);
    }
}
