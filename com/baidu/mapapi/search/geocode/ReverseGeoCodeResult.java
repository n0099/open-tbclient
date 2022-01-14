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
/* loaded from: classes10.dex */
public class ReverseGeoCodeResult extends SearchResult {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<ReverseGeoCodeResult> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f35545b;

    /* renamed from: c  reason: collision with root package name */
    public AddressComponent f35546c;

    /* renamed from: d  reason: collision with root package name */
    public LatLng f35547d;

    /* renamed from: e  reason: collision with root package name */
    public int f35548e;

    /* renamed from: f  reason: collision with root package name */
    public List<PoiInfo> f35549f;

    /* renamed from: g  reason: collision with root package name */
    public String f35550g;

    /* renamed from: h  reason: collision with root package name */
    public List<PoiRegionsInfo> f35551h;

    /* renamed from: i  reason: collision with root package name */
    public int f35552i;

    /* loaded from: classes10.dex */
    public static class AddressComponent implements Parcelable {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<AddressComponent> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public int adcode;
        public String city;
        public int countryCode;
        public String countryName;
        public String direction;
        public String distance;
        public String district;
        public String province;
        public String street;
        public String streetNumber;
        public String town;

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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public AddressComponent(Parcel parcel) {
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

        public String getDirection() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.direction : (String) invokeV.objValue;
        }

        public String getDistance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.distance : (String) invokeV.objValue;
        }

        public String getTown() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.town : (String) invokeV.objValue;
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
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048583, this, parcel, i2) == null) {
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
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class PoiRegionsInfo implements Parcelable {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<PoiRegionsInfo> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public String directionDesc;
        public String regionName;
        public String regionTag;

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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public PoiRegionsInfo(Parcel parcel) {
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
            this.directionDesc = parcel.readString();
            this.regionName = parcel.readString();
            this.regionTag = parcel.readString();
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

        public String getDirectionDesc() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.directionDesc : (String) invokeV.objValue;
        }

        public String getRegionName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.regionName : (String) invokeV.objValue;
        }

        public String getRegionTag() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.regionTag : (String) invokeV.objValue;
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
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048583, this, parcel, i2) == null) {
                parcel.writeString(this.directionDesc);
                parcel.writeString(this.regionName);
                parcel.writeString(this.regionTag);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Parcel) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = parcel.readString();
        this.f35545b = parcel.readString();
        this.f35546c = (AddressComponent) parcel.readParcelable(AddressComponent.class.getClassLoader());
        this.f35547d = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.f35549f = parcel.createTypedArrayList(PoiInfo.CREATOR);
        this.f35550g = parcel.readString();
        this.f35551h = parcel.createTypedArrayList(PoiRegionsInfo.CREATOR);
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public int getAdcode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f35552i : invokeV.intValue;
    }

    public String getAddress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f35545b : (String) invokeV.objValue;
    }

    public AddressComponent getAddressDetail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f35546c : (AddressComponent) invokeV.objValue;
    }

    public String getBusinessCircle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public int getCityCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f35548e : invokeV.intValue;
    }

    public LatLng getLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f35547d : (LatLng) invokeV.objValue;
    }

    public List<PoiInfo> getPoiList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f35549f : (List) invokeV.objValue;
    }

    public List<PoiRegionsInfo> getPoiRegionsInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f35551h : (List) invokeV.objValue;
    }

    public String getSematicDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f35550g : (String) invokeV.objValue;
    }

    public void setAdcode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f35552i = i2;
        }
    }

    public void setAddress(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f35545b = str;
        }
    }

    public void setAddressDetail(AddressComponent addressComponent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, addressComponent) == null) {
            this.f35546c = addressComponent;
        }
    }

    public void setBusinessCircle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.a = str;
        }
    }

    public void setCityCode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f35548e = i2;
        }
    }

    public void setLocation(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, latLng) == null) {
            this.f35547d = latLng;
        }
    }

    public void setPoiList(List<PoiInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, list) == null) {
            this.f35549f = list;
        }
    }

    public void setPoiRegionsInfoList(List<PoiRegionsInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
            this.f35551h = list;
        }
    }

    public void setSematicDescription(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.f35550g = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer("ReverseGeoCodeResult: \n");
            stringBuffer.append("businessCircle = ");
            stringBuffer.append(this.a);
            stringBuffer.append("; address = ");
            stringBuffer.append(this.f35545b);
            stringBuffer.append("; location = ");
            stringBuffer.append(this.f35547d);
            stringBuffer.append("; sematicDescription = ");
            stringBuffer.append(this.f35550g);
            if (this.f35546c != null) {
                stringBuffer.append("\n#AddressComponent Info BEGIN# \n");
                stringBuffer.append("streetNumber = ");
                stringBuffer.append(this.f35546c.streetNumber);
                stringBuffer.append("; street = ");
                stringBuffer.append(this.f35546c.street);
                stringBuffer.append("; town = ");
                stringBuffer.append(this.f35546c.town);
                stringBuffer.append("; district = ");
                stringBuffer.append(this.f35546c.district);
                stringBuffer.append("; city = ");
                stringBuffer.append(this.f35546c.city);
                stringBuffer.append("; province = ");
                stringBuffer.append(this.f35546c.province);
                stringBuffer.append("; countryName = ");
                stringBuffer.append(this.f35546c.countryName);
                stringBuffer.append("; countryCode = ");
                stringBuffer.append(this.f35546c.countryCode);
                stringBuffer.append("; adcode = ");
                stringBuffer.append(this.f35546c.adcode);
                stringBuffer.append("; direction = ");
                stringBuffer.append(this.f35546c.direction);
                stringBuffer.append("; distance = ");
                stringBuffer.append(this.f35546c.distance);
                stringBuffer.append("\n#AddressComponent Info END# \n");
            }
            List<PoiRegionsInfo> list = this.f35551h;
            if (list != null && !list.isEmpty()) {
                stringBuffer.append("\n#PoiRegions Info  BEGIN#");
                for (int i2 = 0; i2 < this.f35551h.size(); i2++) {
                    PoiRegionsInfo poiRegionsInfo = this.f35551h.get(i2);
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
            List<PoiInfo> list2 = this.f35549f;
            if (list2 != null && !list2.isEmpty()) {
                stringBuffer.append("\n #PoiList Info  BEGIN#");
                for (int i3 = 0; i3 < this.f35549f.size(); i3++) {
                    PoiInfo poiInfo = this.f35549f.get(i3);
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
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048596, this, parcel, i2) == null) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.a);
            parcel.writeString(this.f35545b);
            parcel.writeParcelable(this.f35546c, 0);
            parcel.writeValue(this.f35547d);
            parcel.writeTypedList(this.f35549f);
            parcel.writeString(this.f35550g);
            parcel.writeTypedList(this.f35551h);
        }
    }
}
