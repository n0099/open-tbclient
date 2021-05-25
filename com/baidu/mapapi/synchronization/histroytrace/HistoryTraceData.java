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
    public int f7379a;

    /* renamed from: b  reason: collision with root package name */
    public double f7380b;

    /* renamed from: c  reason: collision with root package name */
    public double f7381c;

    /* renamed from: d  reason: collision with root package name */
    public int f7382d;

    /* renamed from: e  reason: collision with root package name */
    public LatLng f7383e;

    /* renamed from: f  reason: collision with root package name */
    public LatLng f7384f;

    /* renamed from: g  reason: collision with root package name */
    public SyncCoordinateConverter.CoordType f7385g = SyncCoordinateConverter.CoordType.BD09LL;

    /* renamed from: h  reason: collision with root package name */
    public List<HistoryTracePoint> f7386h;

    /* renamed from: i  reason: collision with root package name */
    public int f7387i;

    /* loaded from: classes2.dex */
    public static class HistoryTracePoint implements Parcelable {
        public static final Parcelable.Creator<HistoryTracePoint> CREATOR = new b();

        /* renamed from: a  reason: collision with root package name */
        public LatLng f7388a;

        /* renamed from: b  reason: collision with root package name */
        public long f7389b;

        /* renamed from: c  reason: collision with root package name */
        public String f7390c;

        public HistoryTracePoint() {
        }

        public HistoryTracePoint(Parcel parcel) {
            this.f7388a = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.f7389b = parcel.readLong();
            this.f7390c = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getCreateTime() {
            return this.f7390c;
        }

        public long getLocationTime() {
            return this.f7389b;
        }

        public LatLng getPoint() {
            return this.f7388a;
        }

        public void setCreateTime(String str) {
            this.f7390c = str;
        }

        public void setLocationTime(long j) {
            this.f7389b = j;
        }

        public void setPoint(LatLng latLng) {
            this.f7388a = latLng;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeParcelable(this.f7388a, i2);
            parcel.writeLong(this.f7389b);
            parcel.writeString(this.f7390c);
        }
    }

    public HistoryTraceData() {
    }

    public HistoryTraceData(Parcel parcel) {
        this.f7379a = parcel.readInt();
        this.f7380b = parcel.readDouble();
        this.f7381c = parcel.readDouble();
        this.f7382d = parcel.readInt();
        this.f7383e = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f7384f = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f7386h = parcel.createTypedArrayList(HistoryTracePoint.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SyncCoordinateConverter.CoordType getCoordType() {
        return this.f7385g;
    }

    public int getCurrentOrderState() {
        return this.f7382d;
    }

    public int getCurrentPageIndex() {
        return this.f7387i;
    }

    public double getDistance() {
        return this.f7380b;
    }

    public LatLng getOrderEndPosition() {
        return this.f7384f;
    }

    public LatLng getOrderStartPosition() {
        return this.f7383e;
    }

    public List<HistoryTracePoint> getPointsList() {
        return this.f7386h;
    }

    public double getTollDiatance() {
        return this.f7381c;
    }

    public int getTotalPoints() {
        return this.f7379a;
    }

    public void setCoordType(SyncCoordinateConverter.CoordType coordType) {
        this.f7385g = coordType;
    }

    public void setCurrentOrderState(int i2) {
        this.f7382d = i2;
    }

    public void setCurrentPageIndex(int i2) {
        this.f7387i = i2;
    }

    public void setDistance(double d2) {
        this.f7380b = d2;
    }

    public void setOrderEndPosition(LatLng latLng) {
        this.f7384f = latLng;
    }

    public void setOrderStartPosition(LatLng latLng) {
        this.f7383e = latLng;
    }

    public void setPointsList(List<HistoryTracePoint> list) {
        this.f7386h = list;
    }

    public void setTollDiatance(double d2) {
        this.f7381c = d2;
    }

    public void setTotalPoints(int i2) {
        this.f7379a = i2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("HistoryTraceData: \n");
        stringBuffer.append("TotalPoints = ");
        stringBuffer.append(this.f7379a);
        stringBuffer.append("; Distance = ");
        stringBuffer.append(this.f7380b);
        stringBuffer.append("; TollDistance = ");
        stringBuffer.append(this.f7381c);
        stringBuffer.append("; CurrentOrderState = ");
        stringBuffer.append(this.f7382d);
        stringBuffer.append("; OrderStartPosition = ");
        stringBuffer.append(this.f7383e);
        stringBuffer.append("; OrderEndPosition = ");
        stringBuffer.append(this.f7384f);
        List<HistoryTracePoint> list = this.f7386h;
        if (list != null && !list.isEmpty()) {
            stringBuffer.append("\n#History Trace Points Info BEGIN# \n");
            for (int i2 = 0; i2 < this.f7386h.size(); i2++) {
                HistoryTracePoint historyTracePoint = this.f7386h.get(i2);
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
        parcel.writeInt(this.f7379a);
        parcel.writeDouble(this.f7380b);
        parcel.writeDouble(this.f7381c);
        parcel.writeInt(this.f7382d);
        parcel.writeParcelable(this.f7383e, i2);
        parcel.writeParcelable(this.f7384f, i2);
        parcel.writeTypedList(this.f7386h);
    }
}
