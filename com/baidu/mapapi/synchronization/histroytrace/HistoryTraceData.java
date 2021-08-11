package com.baidu.mapapi.synchronization.histroytrace;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.synchronization.SyncCoordinateConverter;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes5.dex */
public class HistoryTraceData implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<HistoryTraceData> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f41761a;

    /* renamed from: b  reason: collision with root package name */
    public double f41762b;

    /* renamed from: c  reason: collision with root package name */
    public double f41763c;

    /* renamed from: d  reason: collision with root package name */
    public int f41764d;

    /* renamed from: e  reason: collision with root package name */
    public LatLng f41765e;

    /* renamed from: f  reason: collision with root package name */
    public LatLng f41766f;

    /* renamed from: g  reason: collision with root package name */
    public SyncCoordinateConverter.CoordType f41767g;

    /* renamed from: h  reason: collision with root package name */
    public List<HistoryTracePoint> f41768h;

    /* renamed from: i  reason: collision with root package name */
    public int f41769i;

    /* loaded from: classes5.dex */
    public static class HistoryTracePoint implements Parcelable {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<HistoryTracePoint> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public LatLng f41770a;

        /* renamed from: b  reason: collision with root package name */
        public long f41771b;

        /* renamed from: c  reason: collision with root package name */
        public String f41772c;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-281869389, "Lcom/baidu/mapapi/synchronization/histroytrace/HistoryTraceData$HistoryTracePoint;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-281869389, "Lcom/baidu/mapapi/synchronization/histroytrace/HistoryTraceData$HistoryTracePoint;");
                    return;
                }
            }
            CREATOR = new b();
        }

        public HistoryTracePoint() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public HistoryTracePoint(Parcel parcel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.f41770a = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.f41771b = parcel.readLong();
            this.f41772c = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        public String getCreateTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f41772c : (String) invokeV.objValue;
        }

        public long getLocationTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f41771b : invokeV.longValue;
        }

        public LatLng getPoint() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f41770a : (LatLng) invokeV.objValue;
        }

        public void setCreateTime(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.f41772c = str;
            }
        }

        public void setLocationTime(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
                this.f41771b = j2;
            }
        }

        public void setPoint(LatLng latLng) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, latLng) == null) {
                this.f41770a = latLng;
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048583, this, parcel, i2) == null) {
                parcel.writeParcelable(this.f41770a, i2);
                parcel.writeLong(this.f41771b);
                parcel.writeString(this.f41772c);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1744800178, "Lcom/baidu/mapapi/synchronization/histroytrace/HistoryTraceData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1744800178, "Lcom/baidu/mapapi/synchronization/histroytrace/HistoryTraceData;");
                return;
            }
        }
        CREATOR = new a();
    }

    public HistoryTraceData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f41767g = SyncCoordinateConverter.CoordType.BD09LL;
    }

    public HistoryTraceData(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f41767g = SyncCoordinateConverter.CoordType.BD09LL;
        this.f41761a = parcel.readInt();
        this.f41762b = parcel.readDouble();
        this.f41763c = parcel.readDouble();
        this.f41764d = parcel.readInt();
        this.f41765e = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f41766f = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f41768h = parcel.createTypedArrayList(HistoryTracePoint.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public SyncCoordinateConverter.CoordType getCoordType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f41767g : (SyncCoordinateConverter.CoordType) invokeV.objValue;
    }

    public int getCurrentOrderState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f41764d : invokeV.intValue;
    }

    public int getCurrentPageIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f41769i : invokeV.intValue;
    }

    public double getDistance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f41762b : invokeV.doubleValue;
    }

    public LatLng getOrderEndPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f41766f : (LatLng) invokeV.objValue;
    }

    public LatLng getOrderStartPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f41765e : (LatLng) invokeV.objValue;
    }

    public List<HistoryTracePoint> getPointsList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f41768h : (List) invokeV.objValue;
    }

    public double getTollDiatance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f41763c : invokeV.doubleValue;
    }

    public int getTotalPoints() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f41761a : invokeV.intValue;
    }

    public void setCoordType(SyncCoordinateConverter.CoordType coordType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, coordType) == null) {
            this.f41767g = coordType;
        }
    }

    public void setCurrentOrderState(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f41764d = i2;
        }
    }

    public void setCurrentPageIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f41769i = i2;
        }
    }

    public void setDistance(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.f41762b = d2;
        }
    }

    public void setOrderEndPosition(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, latLng) == null) {
            this.f41766f = latLng;
        }
    }

    public void setOrderStartPosition(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, latLng) == null) {
            this.f41765e = latLng;
        }
    }

    public void setPointsList(List<HistoryTracePoint> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, list) == null) {
            this.f41768h = list;
        }
    }

    public void setTollDiatance(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.f41763c = d2;
        }
    }

    public void setTotalPoints(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.f41761a = i2;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer("HistoryTraceData: \n");
            stringBuffer.append("TotalPoints = ");
            stringBuffer.append(this.f41761a);
            stringBuffer.append("; Distance = ");
            stringBuffer.append(this.f41762b);
            stringBuffer.append("; TollDistance = ");
            stringBuffer.append(this.f41763c);
            stringBuffer.append("; CurrentOrderState = ");
            stringBuffer.append(this.f41764d);
            stringBuffer.append("; OrderStartPosition = ");
            stringBuffer.append(this.f41765e);
            stringBuffer.append("; OrderEndPosition = ");
            stringBuffer.append(this.f41766f);
            List<HistoryTracePoint> list = this.f41768h;
            if (list != null && !list.isEmpty()) {
                stringBuffer.append("\n#History Trace Points Info BEGIN# \n");
                for (int i2 = 0; i2 < this.f41768h.size(); i2++) {
                    HistoryTracePoint historyTracePoint = this.f41768h.get(i2);
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
                        stringBuffer.append(StringUtils.LF);
                    }
                }
            }
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048596, this, parcel, i2) == null) {
            parcel.writeInt(this.f41761a);
            parcel.writeDouble(this.f41762b);
            parcel.writeDouble(this.f41763c);
            parcel.writeInt(this.f41764d);
            parcel.writeParcelable(this.f41765e, i2);
            parcel.writeParcelable(this.f41766f, i2);
            parcel.writeTypedList(this.f41768h);
        }
    }
}
