package com.baidu.mapapi.search.geocode;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class ReverseGeoCodeResult extends SearchResult {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<ReverseGeoCodeResult> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public AddressComponent c;
    public LatLng d;
    public int e;
    public List<PoiInfo> f;
    public String g;
    public List<PoiRegionsInfo> h;
    public List<RoadInfo> i;
    public int j;

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes2.dex */
    public static class AddressComponent implements Parcelable {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<AddressComponent> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public int adcode;
        public String city;
        public int cityLevel;
        public int countryCode;
        public String countryCodeIso;
        public String countryCodeIso2;
        public String countryName;
        public String direction;
        public String distance;
        public String district;
        public String province;
        public String street;
        public String streetNumber;
        public String town;
        public String townCode;

        @Override // android.os.Parcelable
        public int describeContents() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(357134492, "Lcom/baidu/mapapi/search/geocode/ReverseGeoCodeResult$AddressComponent;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(357134492, "Lcom/baidu/mapapi/search/geocode/ReverseGeoCodeResult$AddressComponent;");
                    return;
                }
            }
            CREATOR = new c();
        }

        public AddressComponent() {
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

        public String getDirection() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.direction;
            }
            return (String) invokeV.objValue;
        }

        public String getDistance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.distance;
            }
            return (String) invokeV.objValue;
        }

        public String getTown() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.town;
            }
            return (String) invokeV.objValue;
        }

        public AddressComponent(Parcel parcel) {
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
            this.streetNumber = parcel.readString();
            this.street = parcel.readString();
            this.town = parcel.readString();
            this.district = parcel.readString();
            this.city = parcel.readString();
            this.province = parcel.readString();
            this.countryName = parcel.readString();
            this.countryCode = parcel.readInt();
            this.adcode = parcel.readInt();
            this.direction = parcel.readString();
            this.distance = parcel.readString();
            this.countryCodeIso = parcel.readString();
            this.countryCodeIso2 = parcel.readString();
            this.townCode = parcel.readString();
            this.cityLevel = parcel.readInt();
        }

        public void setDirection(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.direction = str;
            }
        }

        public void setDistance(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                this.distance = str;
            }
        }

        public void setTown(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                this.town = str;
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048583, this, parcel, i) == null) {
                parcel.writeString(this.streetNumber);
                parcel.writeString(this.street);
                parcel.writeString(this.town);
                parcel.writeString(this.district);
                parcel.writeString(this.city);
                parcel.writeString(this.province);
                parcel.writeString(this.countryName);
                parcel.writeInt(this.countryCode);
                parcel.writeInt(this.adcode);
                parcel.writeString(this.direction);
                parcel.writeString(this.distance);
                parcel.writeString(this.countryCodeIso);
                parcel.writeString(this.countryCodeIso2);
                parcel.writeString(this.townCode);
                parcel.writeInt(this.cityLevel);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class PoiRegionsInfo implements Parcelable {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<PoiRegionsInfo> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public String directionDesc;
        public String regionName;
        public String regionTag;

        @Override // android.os.Parcelable
        public int describeContents() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(771494178, "Lcom/baidu/mapapi/search/geocode/ReverseGeoCodeResult$PoiRegionsInfo;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(771494178, "Lcom/baidu/mapapi/search/geocode/ReverseGeoCodeResult$PoiRegionsInfo;");
                    return;
                }
            }
            CREATOR = new d();
        }

        public PoiRegionsInfo() {
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

        public String getDirectionDesc() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.directionDesc;
            }
            return (String) invokeV.objValue;
        }

        public String getRegionName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.regionName;
            }
            return (String) invokeV.objValue;
        }

        public String getRegionTag() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.regionTag;
            }
            return (String) invokeV.objValue;
        }

        public PoiRegionsInfo(Parcel parcel) {
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
            this.directionDesc = parcel.readString();
            this.regionName = parcel.readString();
            this.regionTag = parcel.readString();
        }

        public void setDirectionDesc(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.directionDesc = str;
            }
        }

        public void setRegionName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                this.regionName = str;
            }
        }

        public void setRegionTag(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                this.regionTag = str;
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048583, this, parcel, i) == null) {
                parcel.writeString(this.directionDesc);
                parcel.writeString(this.regionName);
                parcel.writeString(this.regionTag);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class RoadInfo implements Parcelable {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<RoadInfo> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public String distance;
        public String name;

        @Override // android.os.Parcelable
        public int describeContents() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1224365751, "Lcom/baidu/mapapi/search/geocode/ReverseGeoCodeResult$RoadInfo;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1224365751, "Lcom/baidu/mapapi/search/geocode/ReverseGeoCodeResult$RoadInfo;");
                    return;
                }
            }
            CREATOR = new e();
        }

        public RoadInfo() {
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

        public RoadInfo(Parcel parcel) {
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
            this.name = parcel.readString();
            this.distance = parcel.readString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i) == null) {
                parcel.writeString(this.name);
                parcel.writeString(this.distance);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-918219763, "Lcom/baidu/mapapi/search/geocode/ReverseGeoCodeResult;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-918219763, "Lcom/baidu/mapapi/search/geocode/ReverseGeoCodeResult;");
                return;
            }
        }
        CREATOR = new b();
    }

    public ReverseGeoCodeResult() {
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

    public int getAdcode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    public String getAddress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public AddressComponent getAddressDetail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (AddressComponent) invokeV.objValue;
    }

    public String getBusinessCircle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public int getCityCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public LatLng getLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.d;
        }
        return (LatLng) invokeV.objValue;
    }

    public List<PoiInfo> getPoiList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.f;
        }
        return (List) invokeV.objValue;
    }

    public List<PoiRegionsInfo> getPoiRegionsInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.h;
        }
        return (List) invokeV.objValue;
    }

    public List<RoadInfo> getRoadInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.i;
        }
        return (List) invokeV.objValue;
    }

    public String getSematicDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReverseGeoCodeResult(Parcel parcel) {
        super(parcel);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Parcel) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = (AddressComponent) parcel.readParcelable(AddressComponent.class.getClassLoader());
        this.d = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.f = parcel.createTypedArrayList(PoiInfo.CREATOR);
        this.g = parcel.readString();
        this.h = parcel.createTypedArrayList(PoiRegionsInfo.CREATOR);
        this.i = parcel.createTypedArrayList(RoadInfo.CREATOR);
    }

    public void setAdcode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.j = i;
        }
    }

    public void setAddress(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.b = str;
        }
    }

    public void setAddressDetail(AddressComponent addressComponent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, addressComponent) == null) {
            this.c = addressComponent;
        }
    }

    public void setBusinessCircle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.a = str;
        }
    }

    public void setCityCode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.e = i;
        }
    }

    public void setLocation(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, latLng) == null) {
            this.d = latLng;
        }
    }

    public void setPoiList(List<PoiInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
            this.f = list;
        }
    }

    public void setPoiRegionsInfoList(List<PoiRegionsInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, list) == null) {
            this.h = list;
        }
    }

    public void setRoadInfoList(List<RoadInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, list) == null) {
            this.i = list;
        }
    }

    public void setSematicDescription(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.g = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer("ReverseGeoCodeResult: \n");
            stringBuffer.append("businessCircle = ");
            stringBuffer.append(this.a);
            stringBuffer.append("; address = ");
            stringBuffer.append(this.b);
            stringBuffer.append("; location = ");
            stringBuffer.append(this.d);
            stringBuffer.append("; sematicDescription = ");
            stringBuffer.append(this.g);
            if (this.c != null) {
                stringBuffer.append("\n#AddressComponent Info BEGIN# \n");
                stringBuffer.append("streetNumber = ");
                stringBuffer.append(this.c.streetNumber);
                stringBuffer.append("; street = ");
                stringBuffer.append(this.c.street);
                stringBuffer.append("; town = ");
                stringBuffer.append(this.c.town);
                stringBuffer.append("; district = ");
                stringBuffer.append(this.c.district);
                stringBuffer.append("; city = ");
                stringBuffer.append(this.c.city);
                stringBuffer.append("; province = ");
                stringBuffer.append(this.c.province);
                stringBuffer.append("; countryName = ");
                stringBuffer.append(this.c.countryName);
                stringBuffer.append("; countryCode = ");
                stringBuffer.append(this.c.countryCode);
                stringBuffer.append("; adcode = ");
                stringBuffer.append(this.c.adcode);
                stringBuffer.append("; direction = ");
                stringBuffer.append(this.c.direction);
                stringBuffer.append("; distance = ");
                stringBuffer.append(this.c.distance);
                stringBuffer.append("; countryCodeIso = ");
                stringBuffer.append(this.c.countryCodeIso);
                stringBuffer.append("; countryCodeIso2 = ");
                stringBuffer.append(this.c.countryCodeIso2);
                stringBuffer.append("; townCode = ");
                stringBuffer.append(this.c.townCode);
                stringBuffer.append("; cityLevel = ");
                stringBuffer.append(this.c.cityLevel);
                stringBuffer.append("\n#AddressComponent Info END# \n");
            }
            List<PoiRegionsInfo> list = this.h;
            if (list != null && !list.isEmpty()) {
                stringBuffer.append("\n#PoiRegions Info  BEGIN#");
                for (int i = 0; i < this.h.size(); i++) {
                    PoiRegionsInfo poiRegionsInfo = this.h.get(i);
                    if (poiRegionsInfo != null) {
                        stringBuffer.append("\ndirectionDesc = ");
                        stringBuffer.append(poiRegionsInfo.getDirectionDesc());
                        stringBuffer.append("; regionName = ");
                        stringBuffer.append(poiRegionsInfo.getRegionName());
                        stringBuffer.append("; regionTag = ");
                        stringBuffer.append(poiRegionsInfo.getRegionTag());
                    }
                }
                stringBuffer.append("\n#PoiRegions Info  END# \n");
            }
            List<PoiInfo> list2 = this.f;
            if (list2 != null && !list2.isEmpty()) {
                stringBuffer.append("\n #PoiList Info  BEGIN#");
                for (int i2 = 0; i2 < this.f.size(); i2++) {
                    PoiInfo poiInfo = this.f.get(i2);
                    if (poiInfo != null) {
                        stringBuffer.append("\n address = ");
                        stringBuffer.append(poiInfo.getAddress());
                        stringBuffer.append("; phoneNumber = ");
                        stringBuffer.append(poiInfo.getPhoneNum());
                        stringBuffer.append("; uid = ");
                        stringBuffer.append(poiInfo.getUid());
                        stringBuffer.append("; postCode = ");
                        stringBuffer.append(poiInfo.getPostCode());
                        stringBuffer.append("; name = ");
                        stringBuffer.append(poiInfo.getName());
                        stringBuffer.append("; location = ");
                        stringBuffer.append(poiInfo.getLocation());
                        stringBuffer.append("; city = ");
                        stringBuffer.append(poiInfo.getCity());
                        stringBuffer.append("; direction = ");
                        stringBuffer.append(poiInfo.getDirection());
                        stringBuffer.append("; distance = ");
                        stringBuffer.append(poiInfo.getDistance());
                        if (poiInfo.getParentPoi() != null) {
                            stringBuffer.append("\n parentPoiAddress = ");
                            stringBuffer.append(poiInfo.getParentPoi().getParentPoiAddress());
                            stringBuffer.append("; parentPoiDirection = ");
                            stringBuffer.append(poiInfo.getParentPoi().getParentPoiDirection());
                            stringBuffer.append("; parentPoiDistance = ");
                            stringBuffer.append(poiInfo.getParentPoi().getParentPoiDistance());
                            stringBuffer.append("; parentPoiName = ");
                            stringBuffer.append(poiInfo.getParentPoi().getParentPoiName());
                            stringBuffer.append("; parentPoiTag = ");
                            stringBuffer.append(poiInfo.getParentPoi().getParentPoiTag());
                            stringBuffer.append("; parentPoiUid = ");
                            stringBuffer.append(poiInfo.getParentPoi().getParentPoiUid());
                            stringBuffer.append("; parentPoiLocation = ");
                            stringBuffer.append(poiInfo.getParentPoi().getParentPoiLocation());
                        }
                    }
                }
                stringBuffer.append("\n #PoiList Info  END# \n");
            }
            List<RoadInfo> list3 = this.i;
            if (list3 != null && !list3.isEmpty()) {
                stringBuffer.append("\n #RoadInfoList Info  BEGIN#");
                for (int i3 = 0; i3 < this.i.size(); i3++) {
                    RoadInfo roadInfo = this.i.get(i3);
                    if (roadInfo != null) {
                        stringBuffer.append("; name = ");
                        stringBuffer.append(roadInfo.name);
                        stringBuffer.append("; distance = ");
                        stringBuffer.append(roadInfo.distance);
                    }
                }
                stringBuffer.append("\n #RoadInfoList Info  END# \n");
            }
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048598, this, parcel, i) == null) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.a);
            parcel.writeString(this.b);
            parcel.writeParcelable(this.c, 0);
            parcel.writeValue(this.d);
            parcel.writeTypedList(this.f);
            parcel.writeString(this.g);
            parcel.writeTypedList(this.h);
            parcel.writeTypedList(this.i);
        }
    }
}
