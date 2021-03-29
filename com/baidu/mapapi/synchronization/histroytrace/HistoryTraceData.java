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
    public int f7363a;

    /* renamed from: b  reason: collision with root package name */
    public double f7364b;

    /* renamed from: c  reason: collision with root package name */
    public double f7365c;

    /* renamed from: d  reason: collision with root package name */
    public int f7366d;

    /* renamed from: e  reason: collision with root package name */
    public LatLng f7367e;

    /* renamed from: f  reason: collision with root package name */
    public LatLng f7368f;

    /* renamed from: g  reason: collision with root package name */
    public SyncCoordinateConverter.CoordType f7369g = SyncCoordinateConverter.CoordType.BD09LL;

    /* renamed from: h  reason: collision with root package name */
    public List<HistoryTracePoint> f7370h;
    public int i;

    /* loaded from: classes2.dex */
    public static class HistoryTracePoint implements Parcelable {
        public static final Parcelable.Creator<HistoryTracePoint> CREATOR = new b();

        /* renamed from: a  reason: collision with root package name */
        public LatLng f7371a;

        /* renamed from: b  reason: collision with root package name */
        public long f7372b;

        /* renamed from: c  reason: collision with root package name */
        public String f7373c;

        public HistoryTracePoint() {
        }

        public HistoryTracePoint(Parcel parcel) {
            this.f7371a = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.f7372b = parcel.readLong();
            this.f7373c = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getCreateTime() {
            return this.f7373c;
        }

        public long getLocationTime() {
            return this.f7372b;
        }

        public LatLng getPoint() {
            return this.f7371a;
        }

        public void setCreateTime(String str) {
            this.f7373c = str;
        }

        public void setLocationTime(long j) {
            this.f7372b = j;
        }

        public void setPoint(LatLng latLng) {
            this.f7371a = latLng;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f7371a, i);
            parcel.writeLong(this.f7372b);
            parcel.writeString(this.f7373c);
        }
    }

    public HistoryTraceData() {
    }

    public HistoryTraceData(Parcel parcel) {
        this.f7363a = parcel.readInt();
        this.f7364b = parcel.readDouble();
        this.f7365c = parcel.readDouble();
        this.f7366d = parcel.readInt();
        this.f7367e = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f7368f = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f7370h = parcel.createTypedArrayList(HistoryTracePoint.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SyncCoordinateConverter.CoordType getCoordType() {
        return this.f7369g;
    }

    public int getCurrentOrderState() {
        return this.f7366d;
    }

    public int getCurrentPageIndex() {
        return this.i;
    }

    public double getDistance() {
        return this.f7364b;
    }

    public LatLng getOrderEndPosition() {
        return this.f7368f;
    }

    public LatLng getOrderStartPosition() {
        return this.f7367e;
    }

    public List<HistoryTracePoint> getPointsList() {
        return this.f7370h;
    }

    public double getTollDiatance() {
        return this.f7365c;
    }

    public int getTotalPoints() {
        return this.f7363a;
    }

    public void setCoordType(SyncCoordinateConverter.CoordType coordType) {
        this.f7369g = coordType;
    }

    public void setCurrentOrderState(int i) {
        this.f7366d = i;
    }

    public void setCurrentPageIndex(int i) {
        this.i = i;
    }

    public void setDistance(double d2) {
        this.f7364b = d2;
    }

    public void setOrderEndPosition(LatLng latLng) {
        this.f7368f = latLng;
    }

    public void setOrderStartPosition(LatLng latLng) {
        this.f7367e = latLng;
    }

    public void setPointsList(List<HistoryTracePoint> list) {
        this.f7370h = list;
    }

    public void setTollDiatance(double d2) {
        this.f7365c = d2;
    }

    public void setTotalPoints(int i) {
        this.f7363a = i;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("HistoryTraceData: \n");
        stringBuffer.append("TotalPoints = ");
        stringBuffer.append(this.f7363a);
        stringBuffer.append("; Distance = ");
        stringBuffer.append(this.f7364b);
        stringBuffer.append("; TollDistance = ");
        stringBuffer.append(this.f7365c);
        stringBuffer.append("; CurrentOrderState = ");
        stringBuffer.append(this.f7366d);
        stringBuffer.append("; OrderStartPosition = ");
        stringBuffer.append(this.f7367e);
        stringBuffer.append("; OrderEndPosition = ");
        stringBuffer.append(this.f7368f);
        List<HistoryTracePoint> list = this.f7370h;
        if (list != null && !list.isEmpty()) {
            stringBuffer.append("\n#History Trace Points Info BEGIN# \n");
            for (int i = 0; i < this.f7370h.size(); i++) {
                HistoryTracePoint historyTracePoint = this.f7370h.get(i);
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
        parcel.writeInt(this.f7363a);
        parcel.writeDouble(this.f7364b);
        parcel.writeDouble(this.f7365c);
        parcel.writeInt(this.f7366d);
        parcel.writeParcelable(this.f7367e, i);
        parcel.writeParcelable(this.f7368f, i);
        parcel.writeTypedList(this.f7370h);
    }
}
