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
    public int f7479a;

    /* renamed from: b  reason: collision with root package name */
    public double f7480b;

    /* renamed from: c  reason: collision with root package name */
    public double f7481c;

    /* renamed from: d  reason: collision with root package name */
    public int f7482d;

    /* renamed from: e  reason: collision with root package name */
    public LatLng f7483e;

    /* renamed from: f  reason: collision with root package name */
    public LatLng f7484f;

    /* renamed from: g  reason: collision with root package name */
    public SyncCoordinateConverter.CoordType f7485g = SyncCoordinateConverter.CoordType.BD09LL;

    /* renamed from: h  reason: collision with root package name */
    public List<HistoryTracePoint> f7486h;

    /* renamed from: i  reason: collision with root package name */
    public int f7487i;

    /* loaded from: classes2.dex */
    public static class HistoryTracePoint implements Parcelable {
        public static final Parcelable.Creator<HistoryTracePoint> CREATOR = new b();

        /* renamed from: a  reason: collision with root package name */
        public LatLng f7488a;

        /* renamed from: b  reason: collision with root package name */
        public long f7489b;

        /* renamed from: c  reason: collision with root package name */
        public String f7490c;

        public HistoryTracePoint() {
        }

        public HistoryTracePoint(Parcel parcel) {
            this.f7488a = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.f7489b = parcel.readLong();
            this.f7490c = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getCreateTime() {
            return this.f7490c;
        }

        public long getLocationTime() {
            return this.f7489b;
        }

        public LatLng getPoint() {
            return this.f7488a;
        }

        public void setCreateTime(String str) {
            this.f7490c = str;
        }

        public void setLocationTime(long j) {
            this.f7489b = j;
        }

        public void setPoint(LatLng latLng) {
            this.f7488a = latLng;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeParcelable(this.f7488a, i2);
            parcel.writeLong(this.f7489b);
            parcel.writeString(this.f7490c);
        }
    }

    public HistoryTraceData() {
    }

    public HistoryTraceData(Parcel parcel) {
        this.f7479a = parcel.readInt();
        this.f7480b = parcel.readDouble();
        this.f7481c = parcel.readDouble();
        this.f7482d = parcel.readInt();
        this.f7483e = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f7484f = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f7486h = parcel.createTypedArrayList(HistoryTracePoint.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SyncCoordinateConverter.CoordType getCoordType() {
        return this.f7485g;
    }

    public int getCurrentOrderState() {
        return this.f7482d;
    }

    public int getCurrentPageIndex() {
        return this.f7487i;
    }

    public double getDistance() {
        return this.f7480b;
    }

    public LatLng getOrderEndPosition() {
        return this.f7484f;
    }

    public LatLng getOrderStartPosition() {
        return this.f7483e;
    }

    public List<HistoryTracePoint> getPointsList() {
        return this.f7486h;
    }

    public double getTollDiatance() {
        return this.f7481c;
    }

    public int getTotalPoints() {
        return this.f7479a;
    }

    public void setCoordType(SyncCoordinateConverter.CoordType coordType) {
        this.f7485g = coordType;
    }

    public void setCurrentOrderState(int i2) {
        this.f7482d = i2;
    }

    public void setCurrentPageIndex(int i2) {
        this.f7487i = i2;
    }

    public void setDistance(double d2) {
        this.f7480b = d2;
    }

    public void setOrderEndPosition(LatLng latLng) {
        this.f7484f = latLng;
    }

    public void setOrderStartPosition(LatLng latLng) {
        this.f7483e = latLng;
    }

    public void setPointsList(List<HistoryTracePoint> list) {
        this.f7486h = list;
    }

    public void setTollDiatance(double d2) {
        this.f7481c = d2;
    }

    public void setTotalPoints(int i2) {
        this.f7479a = i2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("HistoryTraceData: \n");
        stringBuffer.append("TotalPoints = ");
        stringBuffer.append(this.f7479a);
        stringBuffer.append("; Distance = ");
        stringBuffer.append(this.f7480b);
        stringBuffer.append("; TollDistance = ");
        stringBuffer.append(this.f7481c);
        stringBuffer.append("; CurrentOrderState = ");
        stringBuffer.append(this.f7482d);
        stringBuffer.append("; OrderStartPosition = ");
        stringBuffer.append(this.f7483e);
        stringBuffer.append("; OrderEndPosition = ");
        stringBuffer.append(this.f7484f);
        List<HistoryTracePoint> list = this.f7486h;
        if (list != null && !list.isEmpty()) {
            stringBuffer.append("\n#History Trace Points Info BEGIN# \n");
            for (int i2 = 0; i2 < this.f7486h.size(); i2++) {
                HistoryTracePoint historyTracePoint = this.f7486h.get(i2);
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
        parcel.writeInt(this.f7479a);
        parcel.writeDouble(this.f7480b);
        parcel.writeDouble(this.f7481c);
        parcel.writeInt(this.f7482d);
        parcel.writeParcelable(this.f7483e, i2);
        parcel.writeParcelable(this.f7484f, i2);
        parcel.writeTypedList(this.f7486h);
    }
}
