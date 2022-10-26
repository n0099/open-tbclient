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
/* loaded from: classes2.dex */
public class HistoryTraceData implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public double b;
    public double c;
    public int d;
    public LatLng e;
    public LatLng f;
    public SyncCoordinateConverter.CoordType g;
    public List h;
    public int i;

    /* loaded from: classes2.dex */
    public class HistoryTracePoint implements Parcelable {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public LatLng a;
        public long b;
        public String c;

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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.a = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.b = parcel.readLong();
            this.c = parcel.readString();
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : (String) invokeV.objValue;
        }

        public long getLocationTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : invokeV.longValue;
        }

        public LatLng getPoint() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (LatLng) invokeV.objValue;
        }

        public void setCreateTime(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.c = str;
            }
        }

        public void setLocationTime(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
                this.b = j;
            }
        }

        public void setPoint(LatLng latLng) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, latLng) == null) {
                this.a = latLng;
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048583, this, parcel, i) == null) {
                parcel.writeParcelable(this.a, i);
                parcel.writeLong(this.b);
                parcel.writeString(this.c);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = SyncCoordinateConverter.CoordType.BD09LL;
    }

    public HistoryTraceData(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.g = SyncCoordinateConverter.CoordType.BD09LL;
        this.a = parcel.readInt();
        this.b = parcel.readDouble();
        this.c = parcel.readDouble();
        this.d = parcel.readInt();
        this.e = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.h = parcel.createTypedArrayList(HistoryTracePoint.CREATOR);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.g : (SyncCoordinateConverter.CoordType) invokeV.objValue;
    }

    public int getCurrentOrderState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : invokeV.intValue;
    }

    public int getCurrentPageIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.i : invokeV.intValue;
    }

    public double getDistance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : invokeV.doubleValue;
    }

    public LatLng getOrderEndPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f : (LatLng) invokeV.objValue;
    }

    public LatLng getOrderStartPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.e : (LatLng) invokeV.objValue;
    }

    public List getPointsList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.h : (List) invokeV.objValue;
    }

    public double getTollDiatance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.c : invokeV.doubleValue;
    }

    public int getTotalPoints() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.a : invokeV.intValue;
    }

    public void setCoordType(SyncCoordinateConverter.CoordType coordType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, coordType) == null) {
            this.g = coordType;
        }
    }

    public void setCurrentOrderState(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.d = i;
        }
    }

    public void setCurrentPageIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.i = i;
        }
    }

    public void setDistance(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Double.valueOf(d)}) == null) {
            this.b = d;
        }
    }

    public void setOrderEndPosition(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, latLng) == null) {
            this.f = latLng;
        }
    }

    public void setOrderStartPosition(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, latLng) == null) {
            this.e = latLng;
        }
    }

    public void setPointsList(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, list) == null) {
            this.h = list;
        }
    }

    public void setTollDiatance(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Double.valueOf(d)}) == null) {
            this.c = d;
        }
    }

    public void setTotalPoints(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.a = i;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer("HistoryTraceData: \n");
            stringBuffer.append("TotalPoints = ");
            stringBuffer.append(this.a);
            stringBuffer.append("; Distance = ");
            stringBuffer.append(this.b);
            stringBuffer.append("; TollDistance = ");
            stringBuffer.append(this.c);
            stringBuffer.append("; CurrentOrderState = ");
            stringBuffer.append(this.d);
            stringBuffer.append("; OrderStartPosition = ");
            stringBuffer.append(this.e);
            stringBuffer.append("; OrderEndPosition = ");
            stringBuffer.append(this.f);
            List list = this.h;
            if (list != null && !list.isEmpty()) {
                stringBuffer.append("\n#History Trace Points Info BEGIN# \n");
                for (int i = 0; i < this.h.size(); i++) {
                    HistoryTracePoint historyTracePoint = (HistoryTracePoint) this.h.get(i);
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
        return (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048596, this, parcel, i) == null) {
            parcel.writeInt(this.a);
            parcel.writeDouble(this.b);
            parcel.writeDouble(this.c);
            parcel.writeInt(this.d);
            parcel.writeParcelable(this.e, i);
            parcel.writeParcelable(this.f, i);
            parcel.writeTypedList(this.h);
        }
    }
}
