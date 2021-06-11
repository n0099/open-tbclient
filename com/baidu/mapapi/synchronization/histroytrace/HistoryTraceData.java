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
    public int f7422a;

    /* renamed from: b  reason: collision with root package name */
    public double f7423b;

    /* renamed from: c  reason: collision with root package name */
    public double f7424c;

    /* renamed from: d  reason: collision with root package name */
    public int f7425d;

    /* renamed from: e  reason: collision with root package name */
    public LatLng f7426e;

    /* renamed from: f  reason: collision with root package name */
    public LatLng f7427f;

    /* renamed from: g  reason: collision with root package name */
    public SyncCoordinateConverter.CoordType f7428g = SyncCoordinateConverter.CoordType.BD09LL;

    /* renamed from: h  reason: collision with root package name */
    public List<HistoryTracePoint> f7429h;

    /* renamed from: i  reason: collision with root package name */
    public int f7430i;

    /* loaded from: classes2.dex */
    public static class HistoryTracePoint implements Parcelable {
        public static final Parcelable.Creator<HistoryTracePoint> CREATOR = new b();

        /* renamed from: a  reason: collision with root package name */
        public LatLng f7431a;

        /* renamed from: b  reason: collision with root package name */
        public long f7432b;

        /* renamed from: c  reason: collision with root package name */
        public String f7433c;

        public HistoryTracePoint() {
        }

        public HistoryTracePoint(Parcel parcel) {
            this.f7431a = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.f7432b = parcel.readLong();
            this.f7433c = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getCreateTime() {
            return this.f7433c;
        }

        public long getLocationTime() {
            return this.f7432b;
        }

        public LatLng getPoint() {
            return this.f7431a;
        }

        public void setCreateTime(String str) {
            this.f7433c = str;
        }

        public void setLocationTime(long j) {
            this.f7432b = j;
        }

        public void setPoint(LatLng latLng) {
            this.f7431a = latLng;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeParcelable(this.f7431a, i2);
            parcel.writeLong(this.f7432b);
            parcel.writeString(this.f7433c);
        }
    }

    public HistoryTraceData() {
    }

    public HistoryTraceData(Parcel parcel) {
        this.f7422a = parcel.readInt();
        this.f7423b = parcel.readDouble();
        this.f7424c = parcel.readDouble();
        this.f7425d = parcel.readInt();
        this.f7426e = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f7427f = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f7429h = parcel.createTypedArrayList(HistoryTracePoint.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SyncCoordinateConverter.CoordType getCoordType() {
        return this.f7428g;
    }

    public int getCurrentOrderState() {
        return this.f7425d;
    }

    public int getCurrentPageIndex() {
        return this.f7430i;
    }

    public double getDistance() {
        return this.f7423b;
    }

    public LatLng getOrderEndPosition() {
        return this.f7427f;
    }

    public LatLng getOrderStartPosition() {
        return this.f7426e;
    }

    public List<HistoryTracePoint> getPointsList() {
        return this.f7429h;
    }

    public double getTollDiatance() {
        return this.f7424c;
    }

    public int getTotalPoints() {
        return this.f7422a;
    }

    public void setCoordType(SyncCoordinateConverter.CoordType coordType) {
        this.f7428g = coordType;
    }

    public void setCurrentOrderState(int i2) {
        this.f7425d = i2;
    }

    public void setCurrentPageIndex(int i2) {
        this.f7430i = i2;
    }

    public void setDistance(double d2) {
        this.f7423b = d2;
    }

    public void setOrderEndPosition(LatLng latLng) {
        this.f7427f = latLng;
    }

    public void setOrderStartPosition(LatLng latLng) {
        this.f7426e = latLng;
    }

    public void setPointsList(List<HistoryTracePoint> list) {
        this.f7429h = list;
    }

    public void setTollDiatance(double d2) {
        this.f7424c = d2;
    }

    public void setTotalPoints(int i2) {
        this.f7422a = i2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("HistoryTraceData: \n");
        stringBuffer.append("TotalPoints = ");
        stringBuffer.append(this.f7422a);
        stringBuffer.append("; Distance = ");
        stringBuffer.append(this.f7423b);
        stringBuffer.append("; TollDistance = ");
        stringBuffer.append(this.f7424c);
        stringBuffer.append("; CurrentOrderState = ");
        stringBuffer.append(this.f7425d);
        stringBuffer.append("; OrderStartPosition = ");
        stringBuffer.append(this.f7426e);
        stringBuffer.append("; OrderEndPosition = ");
        stringBuffer.append(this.f7427f);
        List<HistoryTracePoint> list = this.f7429h;
        if (list != null && !list.isEmpty()) {
            stringBuffer.append("\n#History Trace Points Info BEGIN# \n");
            for (int i2 = 0; i2 < this.f7429h.size(); i2++) {
                HistoryTracePoint historyTracePoint = this.f7429h.get(i2);
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
        parcel.writeInt(this.f7422a);
        parcel.writeDouble(this.f7423b);
        parcel.writeDouble(this.f7424c);
        parcel.writeInt(this.f7425d);
        parcel.writeParcelable(this.f7426e, i2);
        parcel.writeParcelable(this.f7427f, i2);
        parcel.writeTypedList(this.f7429h);
    }
}
