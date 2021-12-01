package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class PoiInfo implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<PoiInfo> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public String address;
    public String area;
    public String city;
    public int detail;
    public String direction;
    public int distance;
    public boolean hasCaterDetails;
    public boolean isPano;
    public LatLng location;
    public String name;
    public ParentPoiInfo parentPoiInfo;
    public String phoneNum;
    public PoiDetailInfo poiDetailInfo;
    public String postCode;
    public String province;
    public String street_id;
    public POITYPE type;
    public String uid;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class POITYPE {
        public static final /* synthetic */ POITYPE[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final POITYPE BUS_LINE;
        public static final POITYPE BUS_STATION;
        public static final POITYPE POINT;
        public static final POITYPE SUBWAY_LINE;
        public static final POITYPE SUBWAY_STATION;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1279903791, "Lcom/baidu/mapapi/search/core/PoiInfo$POITYPE;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1279903791, "Lcom/baidu/mapapi/search/core/PoiInfo$POITYPE;");
                    return;
                }
            }
            POINT = new POITYPE("POINT", 0, 0);
            BUS_STATION = new POITYPE("BUS_STATION", 1, 1);
            BUS_LINE = new POITYPE("BUS_LINE", 2, 2);
            SUBWAY_STATION = new POITYPE("SUBWAY_STATION", 3, 3);
            POITYPE poitype = new POITYPE("SUBWAY_LINE", 4, 4);
            SUBWAY_LINE = poitype;
            $VALUES = new POITYPE[]{POINT, BUS_STATION, BUS_LINE, SUBWAY_STATION, poitype};
        }

        public POITYPE(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = i3;
        }

        public static POITYPE fromInt(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                if (i2 != 4) {
                                    return null;
                                }
                                return SUBWAY_LINE;
                            }
                            return SUBWAY_STATION;
                        }
                        return BUS_LINE;
                    }
                    return BUS_STATION;
                }
                return POINT;
            }
            return (POITYPE) invokeI.objValue;
        }

        public static POITYPE valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (POITYPE) Enum.valueOf(POITYPE.class, str) : (POITYPE) invokeL.objValue;
        }

        public static POITYPE[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (POITYPE[]) $VALUES.clone() : (POITYPE[]) invokeV.objValue;
        }

        public int getInt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class ParentPoiInfo implements Parcelable {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<ParentPoiInfo> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public String parentPoiAddress;
        public String parentPoiDirection;
        public int parentPoiDistance;
        public LatLng parentPoiLocation;
        public String parentPoiName;
        public String parentPoiTag;
        public String parentPoiUid;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2054057445, "Lcom/baidu/mapapi/search/core/PoiInfo$ParentPoiInfo;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2054057445, "Lcom/baidu/mapapi/search/core/PoiInfo$ParentPoiInfo;");
                    return;
                }
            }
            CREATOR = new h();
        }

        public ParentPoiInfo() {
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

        public ParentPoiInfo(Parcel parcel) {
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
            this.parentPoiName = parcel.readString();
            this.parentPoiTag = parcel.readString();
            this.parentPoiAddress = parcel.readString();
            this.parentPoiLocation = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.parentPoiDirection = parcel.readString();
            this.parentPoiDistance = parcel.readInt();
            this.parentPoiUid = parcel.readString();
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

        public String getParentPoiAddress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.parentPoiAddress : (String) invokeV.objValue;
        }

        public String getParentPoiDirection() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.parentPoiDirection : (String) invokeV.objValue;
        }

        public int getParentPoiDistance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.parentPoiDistance : invokeV.intValue;
        }

        public LatLng getParentPoiLocation() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.parentPoiLocation : (LatLng) invokeV.objValue;
        }

        public String getParentPoiName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.parentPoiName : (String) invokeV.objValue;
        }

        public String getParentPoiTag() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.parentPoiTag : (String) invokeV.objValue;
        }

        public String getParentPoiUid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.parentPoiUid : (String) invokeV.objValue;
        }

        public void setParentPoiAddress(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                this.parentPoiAddress = str;
            }
        }

        public void setParentPoiDirection(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                this.parentPoiDirection = str;
            }
        }

        public void setParentPoiDistance(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
                this.parentPoiDistance = i2;
            }
        }

        public void setParentPoiLocation(LatLng latLng) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, latLng) == null) {
                this.parentPoiLocation = latLng;
            }
        }

        public void setParentPoiName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
                this.parentPoiName = str;
            }
        }

        public void setParentPoiTag(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
                this.parentPoiTag = str;
            }
        }

        public void setParentPoiUid(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
                this.parentPoiUid = str;
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048591, this, parcel, i2) == null) {
                parcel.writeString(this.parentPoiName);
                parcel.writeString(this.parentPoiTag);
                parcel.writeString(this.parentPoiAddress);
                parcel.writeParcelable(this.parentPoiLocation, i2);
                parcel.writeString(this.parentPoiDirection);
                parcel.writeInt(this.parentPoiDistance);
                parcel.writeString(this.parentPoiUid);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1654762479, "Lcom/baidu/mapapi/search/core/PoiInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1654762479, "Lcom/baidu/mapapi/search/core/PoiInfo;");
                return;
            }
        }
        CREATOR = new g();
    }

    public PoiInfo() {
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

    public PoiInfo(Parcel parcel) {
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
        this.name = parcel.readString();
        this.uid = parcel.readString();
        this.address = parcel.readString();
        this.province = parcel.readString();
        this.city = parcel.readString();
        this.area = parcel.readString();
        this.street_id = parcel.readString();
        this.phoneNum = parcel.readString();
        this.postCode = parcel.readString();
        this.detail = ((Integer) parcel.readValue(Integer.class.getClassLoader())).intValue();
        this.type = (POITYPE) parcel.readValue(POITYPE.class.getClassLoader());
        this.location = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.hasCaterDetails = ((Boolean) parcel.readValue(Boolean.class.getClassLoader())).booleanValue();
        this.isPano = ((Boolean) parcel.readValue(Boolean.class.getClassLoader())).booleanValue();
        this.poiDetailInfo = (PoiDetailInfo) parcel.readParcelable(PoiDetailInfo.class.getClassLoader());
        this.direction = parcel.readString();
        this.distance = parcel.readInt();
        this.parentPoiInfo = (ParentPoiInfo) parcel.readParcelable(ParentPoiInfo.class.getClassLoader());
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

    public String getAddress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.address : (String) invokeV.objValue;
    }

    public String getArea() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.area : (String) invokeV.objValue;
    }

    public String getCity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.city : (String) invokeV.objValue;
    }

    public int getDetail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.detail : invokeV.intValue;
    }

    public String getDirection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.direction : (String) invokeV.objValue;
    }

    public int getDistance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.distance : invokeV.intValue;
    }

    public LatLng getLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.location : (LatLng) invokeV.objValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.name : (String) invokeV.objValue;
    }

    public ParentPoiInfo getParentPoi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.parentPoiInfo : (ParentPoiInfo) invokeV.objValue;
    }

    public String getPhoneNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.phoneNum : (String) invokeV.objValue;
    }

    public PoiDetailInfo getPoiDetailInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.poiDetailInfo : (PoiDetailInfo) invokeV.objValue;
    }

    public String getPostCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.postCode : (String) invokeV.objValue;
    }

    public String getProvince() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.province : (String) invokeV.objValue;
    }

    public String getStreetId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.street_id : (String) invokeV.objValue;
    }

    public POITYPE getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.type : (POITYPE) invokeV.objValue;
    }

    public String getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.uid : (String) invokeV.objValue;
    }

    public boolean isHasCaterDetails() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.hasCaterDetails : invokeV.booleanValue;
    }

    public boolean isPano() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.isPano : invokeV.booleanValue;
    }

    public void setAddress(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.address = str;
        }
    }

    public void setArea(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.area = str;
        }
    }

    public void setCity(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.city = str;
        }
    }

    public void setDetail(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.detail = i2;
        }
    }

    public void setDirection(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.direction = str;
        }
    }

    public void setDistance(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.distance = i2;
        }
    }

    public void setHasCaterDetails(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.hasCaterDetails = z;
        }
    }

    public void setLocation(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, latLng) == null) {
            this.location = latLng;
        }
    }

    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.name = str;
        }
    }

    public void setPano(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.isPano = z;
        }
    }

    public void setParentPoi(ParentPoiInfo parentPoiInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, parentPoiInfo) == null) {
            this.parentPoiInfo = parentPoiInfo;
        }
    }

    public void setPhoneNum(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.phoneNum = str;
        }
    }

    public void setPoiDetailInfo(PoiDetailInfo poiDetailInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, poiDetailInfo) == null) {
            this.poiDetailInfo = poiDetailInfo;
        }
    }

    public void setPostCode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            this.postCode = str;
        }
    }

    public void setProvince(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            this.province = str;
        }
    }

    public void setStreetId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            this.street_id = str;
        }
    }

    public void setType(POITYPE poitype) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, poitype) == null) {
            this.type = poitype;
        }
    }

    public void setUid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.uid = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer("PoiInfo: ");
            stringBuffer.append("name = ");
            stringBuffer.append(this.name);
            stringBuffer.append("; uid = ");
            stringBuffer.append(this.uid);
            stringBuffer.append("; address = ");
            stringBuffer.append(this.address);
            stringBuffer.append("; province = ");
            stringBuffer.append(this.province);
            stringBuffer.append("; city = ");
            stringBuffer.append(this.city);
            stringBuffer.append("; area = ");
            stringBuffer.append(this.area);
            stringBuffer.append("; street_id = ");
            stringBuffer.append(this.street_id);
            stringBuffer.append("; phoneNum = ");
            stringBuffer.append(this.phoneNum);
            stringBuffer.append("; postCode = ");
            stringBuffer.append(this.postCode);
            stringBuffer.append("; detail = ");
            stringBuffer.append(this.detail);
            stringBuffer.append("; location = ");
            LatLng latLng = this.location;
            if (latLng != null) {
                stringBuffer.append(latLng.toString());
            } else {
                stringBuffer.append(StringUtil.NULL_STRING);
            }
            stringBuffer.append("; hasCaterDetails = ");
            stringBuffer.append(this.hasCaterDetails);
            stringBuffer.append("; isPano = ");
            stringBuffer.append(this.isPano);
            stringBuffer.append("; poiDetailInfo = ");
            PoiDetailInfo poiDetailInfo = this.poiDetailInfo;
            if (poiDetailInfo != null) {
                stringBuffer.append(poiDetailInfo.toString());
            } else {
                stringBuffer.append(StringUtil.NULL_STRING);
            }
            stringBuffer.append("; direction = ");
            stringBuffer.append(this.direction);
            stringBuffer.append("; distance = ");
            stringBuffer.append(this.distance);
            if (this.parentPoiInfo != null) {
                stringBuffer.append("; parentPoiAddress = ");
                stringBuffer.append(this.parentPoiInfo.getParentPoiAddress());
                stringBuffer.append("; parentPoiDirection = ");
                stringBuffer.append(this.parentPoiInfo.getParentPoiDirection());
                stringBuffer.append("; parentPoiDistance = ");
                stringBuffer.append(this.parentPoiInfo.getParentPoiDistance());
                stringBuffer.append("; parentPoiName = ");
                stringBuffer.append(this.parentPoiInfo.getParentPoiName());
                stringBuffer.append("; parentPoiTag = ");
                stringBuffer.append(this.parentPoiInfo.getParentPoiTag());
                stringBuffer.append("; parentPoiUid = ");
                stringBuffer.append(this.parentPoiInfo.getParentPoiUid());
                stringBuffer.append("; parentPoiLocation = ");
                stringBuffer.append(this.parentPoiInfo.getParentPoiLocation());
            }
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048614, this, parcel, i2) == null) {
            parcel.writeString(this.name);
            parcel.writeString(this.uid);
            parcel.writeString(this.address);
            parcel.writeString(this.province);
            parcel.writeString(this.city);
            parcel.writeString(this.area);
            parcel.writeString(this.street_id);
            parcel.writeString(this.phoneNum);
            parcel.writeString(this.postCode);
            parcel.writeValue(Integer.valueOf(this.detail));
            parcel.writeValue(this.type);
            parcel.writeParcelable(this.location, 1);
            parcel.writeValue(Boolean.valueOf(this.hasCaterDetails));
            parcel.writeValue(Boolean.valueOf(this.isPano));
            parcel.writeParcelable(this.poiDetailInfo, 1);
            parcel.writeString(this.direction);
            parcel.writeInt(this.distance);
            parcel.writeParcelable(this.parentPoiInfo, 1);
        }
    }
}
