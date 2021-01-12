package com.baidu.mapapi.synchronization.histroytrace;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.synchronization.SyncCoordinateConverter;
import java.util.List;
/* loaded from: classes6.dex */
public class HistoryTraceData implements Parcelable {
    public static final Parcelable.Creator<HistoryTraceData> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private int f2949a;

    /* renamed from: b  reason: collision with root package name */
    private double f2950b;
    private double c;
    private int d;
    private LatLng e;
    private LatLng f;
    private SyncCoordinateConverter.CoordType g = SyncCoordinateConverter.CoordType.BD09LL;
    private List<HistoryTracePoint> h;
    private int i;

    /* loaded from: classes6.dex */
    public static class HistoryTracePoint implements Parcelable {
        public static final Parcelable.Creator<HistoryTracePoint> CREATOR = new b();

        /* renamed from: a  reason: collision with root package name */
        private LatLng f2951a;

        /* renamed from: b  reason: collision with root package name */
        private long f2952b;
        private String c;

        public HistoryTracePoint() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public HistoryTracePoint(Parcel parcel) {
            this.f2951a = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.f2952b = parcel.readLong();
            this.c = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getCreateTime() {
            return this.c;
        }

        public long getLocationTime() {
            return this.f2952b;
        }

        public LatLng getPoint() {
            return this.f2951a;
        }

        public void setCreateTime(String str) {
            this.c = str;
        }

        public void setLocationTime(long j) {
            this.f2952b = j;
        }

        public void setPoint(LatLng latLng) {
            this.f2951a = latLng;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f2951a, i);
            parcel.writeLong(this.f2952b);
            parcel.writeString(this.c);
        }
    }

    public HistoryTraceData() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HistoryTraceData(Parcel parcel) {
        this.f2949a = parcel.readInt();
        this.f2950b = parcel.readDouble();
        this.c = parcel.readDouble();
        this.d = parcel.readInt();
        this.e = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.h = parcel.createTypedArrayList(HistoryTracePoint.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SyncCoordinateConverter.CoordType getCoordType() {
        return this.g;
    }

    public int getCurrentOrderState() {
        return this.d;
    }

    public int getCurrentPageIndex() {
        return this.i;
    }

    public double getDistance() {
        return this.f2950b;
    }

    public LatLng getOrderEndPosition() {
        return this.f;
    }

    public LatLng getOrderStartPosition() {
        return this.e;
    }

    public List<HistoryTracePoint> getPointsList() {
        return this.h;
    }

    public double getTollDiatance() {
        return this.c;
    }

    public int getTotalPoints() {
        return this.f2949a;
    }

    public void setCoordType(SyncCoordinateConverter.CoordType coordType) {
        this.g = coordType;
    }

    public void setCurrentOrderState(int i) {
        this.d = i;
    }

    public void setCurrentPageIndex(int i) {
        this.i = i;
    }

    public void setDistance(double d) {
        this.f2950b = d;
    }

    public void setOrderEndPosition(LatLng latLng) {
        this.f = latLng;
    }

    public void setOrderStartPosition(LatLng latLng) {
        this.e = latLng;
    }

    public void setPointsList(List<HistoryTracePoint> list) {
        this.h = list;
    }

    public void setTollDiatance(double d) {
        this.c = d;
    }

    public void setTotalPoints(int i) {
        this.f2949a = i;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("HistoryTraceData: \n");
        stringBuffer.append("TotalPoints = ").append(this.f2949a);
        stringBuffer.append("; Distance = ").append(this.f2950b);
        stringBuffer.append("; TollDistance = ").append(this.c);
        stringBuffer.append("; CurrentOrderState = ").append(this.d);
        stringBuffer.append("; OrderStartPosition = ").append(this.e);
        stringBuffer.append("; OrderEndPosition = ").append(this.f);
        if (this.h != null && !this.h.isEmpty()) {
            stringBuffer.append("\n#History Trace Points Info BEGIN# \n");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.h.size()) {
                    break;
                }
                HistoryTracePoint historyTracePoint = this.h.get(i2);
                if (historyTracePoint != null) {
                    stringBuffer.append("The ").append(i2).append(" Point Info: ");
                    stringBuffer.append("Point = ").append(historyTracePoint.getPoint().toString());
                    stringBuffer.append("; LocationTime = ").append(historyTracePoint.getLocationTime());
                    stringBuffer.append("; CreateTime = ").append(historyTracePoint.getCreateTime());
                    stringBuffer.append("\n");
                }
                i = i2 + 1;
            }
        }
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f2949a);
        parcel.writeDouble(this.f2950b);
        parcel.writeDouble(this.c);
        parcel.writeInt(this.d);
        parcel.writeParcelable(this.e, i);
        parcel.writeParcelable(this.f, i);
        parcel.writeTypedList(this.h);
    }
}
