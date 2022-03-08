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
import java.util.List;
/* loaded from: classes4.dex */
public class PoiDetailInfo implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<PoiDetailInfo> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public String address;
    public String area;
    public int checkinNum;
    public String city;
    public int commentNum;
    public int detail;
    public String detailUrl;
    public int discountNum;
    public int distance;
    public double environmentRating;
    public double facilityRating;
    public int favoriteNum;
    public int grouponNum;
    public double hygieneRating;
    public int imageNum;
    public LatLng location;
    public String name;
    public LatLng naviLocation;
    public double overallRating;
    public List<PoiChildrenInfo> poiChildrenInfoList;
    public double price;
    public String province;
    public double serviceRating;
    public String shopHours;
    public String streetId;
    public String tag;
    public double tasteRating;
    public double technologyRating;
    public String telephone;
    public String type;
    public String uid;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2125081758, "Lcom/baidu/mapapi/search/core/PoiDetailInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2125081758, "Lcom/baidu/mapapi/search/core/PoiDetailInfo;");
                return;
            }
        }
        CREATOR = new f();
    }

    public PoiDetailInfo() {
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

    public PoiDetailInfo(Parcel parcel) {
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
        this.location = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.address = parcel.readString();
        this.province = parcel.readString();
        this.city = parcel.readString();
        this.area = parcel.readString();
        this.telephone = parcel.readString();
        this.uid = parcel.readString();
        this.streetId = parcel.readString();
        this.detail = parcel.readInt();
        this.distance = parcel.readInt();
        this.type = parcel.readString();
        this.tag = parcel.readString();
        this.naviLocation = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.detailUrl = parcel.readString();
        this.price = parcel.readDouble();
        this.shopHours = parcel.readString();
        this.overallRating = parcel.readDouble();
        this.tasteRating = parcel.readDouble();
        this.serviceRating = parcel.readDouble();
        this.environmentRating = parcel.readDouble();
        this.facilityRating = parcel.readDouble();
        this.hygieneRating = parcel.readDouble();
        this.technologyRating = parcel.readDouble();
        this.imageNum = parcel.readInt();
        this.grouponNum = parcel.readInt();
        this.discountNum = parcel.readInt();
        this.commentNum = parcel.readInt();
        this.favoriteNum = parcel.readInt();
        this.checkinNum = parcel.readInt();
        this.poiChildrenInfoList = parcel.createTypedArrayList(PoiChildrenInfo.CREATOR);
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

    public int getCheckinNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.checkinNum : invokeV.intValue;
    }

    public String getCity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.city : (String) invokeV.objValue;
    }

    public int getCommentNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.commentNum : invokeV.intValue;
    }

    public int getDetail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.detail : invokeV.intValue;
    }

    public String getDetailUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.detailUrl : (String) invokeV.objValue;
    }

    public int getDiscountNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.discountNum : invokeV.intValue;
    }

    public int getDistance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.distance : invokeV.intValue;
    }

    public double getEnvironmentRating() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.environmentRating : invokeV.doubleValue;
    }

    public double getFacilityRating() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.facilityRating : invokeV.doubleValue;
    }

    public int getFavoriteNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.favoriteNum : invokeV.intValue;
    }

    public int getGrouponNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.grouponNum : invokeV.intValue;
    }

    public double getHygieneRating() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.hygieneRating : invokeV.doubleValue;
    }

    public int getImageNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.imageNum : invokeV.intValue;
    }

    public LatLng getLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.location : (LatLng) invokeV.objValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.name : (String) invokeV.objValue;
    }

    public LatLng getNaviLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.naviLocation : (LatLng) invokeV.objValue;
    }

    public double getOverallRating() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.overallRating : invokeV.doubleValue;
    }

    public List<PoiChildrenInfo> getPoiChildrenInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.poiChildrenInfoList : (List) invokeV.objValue;
    }

    public double getPrice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.price : invokeV.doubleValue;
    }

    public String getProvince() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.province : (String) invokeV.objValue;
    }

    public double getServiceRating() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.serviceRating : invokeV.doubleValue;
    }

    public String getShopHours() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.shopHours : (String) invokeV.objValue;
    }

    public String getStreetId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.streetId : (String) invokeV.objValue;
    }

    public String getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.tag : (String) invokeV.objValue;
    }

    public double getTasteRating() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.tasteRating : invokeV.doubleValue;
    }

    public double getTechnologyRating() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.technologyRating : invokeV.doubleValue;
    }

    public String getTelephone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.telephone : (String) invokeV.objValue;
    }

    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.type : (String) invokeV.objValue;
    }

    public String getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.uid : (String) invokeV.objValue;
    }

    public void setAddress(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            this.address = str;
        }
    }

    public void setArea(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            this.area = str;
        }
    }

    public void setCheckinNum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            this.checkinNum = i2;
        }
    }

    public void setCity(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.city = str;
        }
    }

    public void setCommentNum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            this.commentNum = i2;
        }
    }

    public void setDetail(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            try {
                this.detail = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                this.detail = 0;
            }
        }
    }

    public void setDetailUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            this.detailUrl = str;
        }
    }

    public void setDiscountNum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            this.discountNum = i2;
        }
    }

    public void setDistance(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            this.distance = i2;
        }
    }

    public void setEnvironmentRating(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.environmentRating = d2;
        }
    }

    public void setFacilityRating(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.facilityRating = d2;
        }
    }

    public void setFavoriteNum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
            this.favoriteNum = i2;
        }
    }

    public void setGrouponNum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i2) == null) {
            this.grouponNum = i2;
        }
    }

    public void setHygieneRating(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.hygieneRating = d2;
        }
    }

    public void setImageNum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i2) == null) {
            this.imageNum = i2;
        }
    }

    public void setLocation(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, latLng) == null) {
            this.location = latLng;
        }
    }

    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            this.name = str;
        }
    }

    public void setNaviLocation(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, latLng) == null) {
            this.naviLocation = latLng;
        }
    }

    public void setOverallRating(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.overallRating = d2;
        }
    }

    public void setPoiChildrenInfoList(List<PoiChildrenInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, list) == null) {
            this.poiChildrenInfoList = list;
        }
    }

    public void setPrice(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048628, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.price = d2;
        }
    }

    public void setProvince(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, str) == null) {
            this.province = str;
        }
    }

    public void setServiceRating(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048630, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.serviceRating = d2;
        }
    }

    public void setShopHours(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, str) == null) {
            this.shopHours = str;
        }
    }

    public void setStreetId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, str) == null) {
            this.streetId = str;
        }
    }

    public void setTag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, str) == null) {
            this.tag = str;
        }
    }

    public void setTasteRating(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.tasteRating = d2;
        }
    }

    public void setTechnologyRating(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048635, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.technologyRating = d2;
        }
    }

    public void setTelephone(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, str) == null) {
            this.telephone = str;
        }
    }

    public void setType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, str) == null) {
            this.type = str;
        }
    }

    public void setUid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, str) == null) {
            this.uid = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer("PoiDetailInfo: ");
            stringBuffer.append("name = ");
            stringBuffer.append(this.name);
            stringBuffer.append("; location = ");
            LatLng latLng = this.location;
            if (latLng != null) {
                stringBuffer.append(latLng.toString());
            } else {
                stringBuffer.append(StringUtil.NULL_STRING);
            }
            stringBuffer.append("; address = ");
            stringBuffer.append(this.address);
            stringBuffer.append("; province = ");
            stringBuffer.append(this.province);
            stringBuffer.append("; city = ");
            stringBuffer.append(this.city);
            stringBuffer.append("; area = ");
            stringBuffer.append(this.area);
            stringBuffer.append("; telephone = ");
            stringBuffer.append(this.telephone);
            stringBuffer.append("; uid = ");
            stringBuffer.append(this.uid);
            stringBuffer.append("; detail = ");
            stringBuffer.append(this.detail);
            stringBuffer.append("; distance = ");
            stringBuffer.append(this.distance);
            stringBuffer.append("; type = ");
            stringBuffer.append(this.type);
            stringBuffer.append("; tag = ");
            stringBuffer.append(this.tag);
            stringBuffer.append("; naviLocation = ");
            LatLng latLng2 = this.naviLocation;
            if (latLng2 != null) {
                stringBuffer.append(latLng2.toString());
            } else {
                stringBuffer.append(StringUtil.NULL_STRING);
            }
            stringBuffer.append("; detailUrl = ");
            stringBuffer.append(this.detailUrl);
            stringBuffer.append("; price = ");
            stringBuffer.append(this.price);
            stringBuffer.append("; shopHours = ");
            stringBuffer.append(this.shopHours);
            stringBuffer.append("; overallRating = ");
            stringBuffer.append(this.overallRating);
            stringBuffer.append("; tasteRating = ");
            stringBuffer.append(this.tasteRating);
            stringBuffer.append("; serviceRating = ");
            stringBuffer.append(this.serviceRating);
            stringBuffer.append("; environmentRating = ");
            stringBuffer.append(this.environmentRating);
            stringBuffer.append("; facilityRating = ");
            stringBuffer.append(this.facilityRating);
            stringBuffer.append("; hygieneRating = ");
            stringBuffer.append(this.hygieneRating);
            stringBuffer.append("; technologyRating = ");
            stringBuffer.append(this.technologyRating);
            stringBuffer.append("; imageNum = ");
            stringBuffer.append(this.imageNum);
            stringBuffer.append("; grouponNum = ");
            stringBuffer.append(this.grouponNum);
            stringBuffer.append("; discountNum = ");
            stringBuffer.append(this.discountNum);
            stringBuffer.append("; commentNum = ");
            stringBuffer.append(this.commentNum);
            stringBuffer.append("; favoriteNum = ");
            stringBuffer.append(this.favoriteNum);
            stringBuffer.append("; checkinNum = ");
            stringBuffer.append(this.checkinNum);
            List<PoiChildrenInfo> list = this.poiChildrenInfoList;
            if (list != null && !list.isEmpty()) {
                for (int i2 = 0; i2 < this.poiChildrenInfoList.size(); i2++) {
                    stringBuffer.append("; The ");
                    stringBuffer.append(i2);
                    stringBuffer.append(" poiChildrenInfo is: ");
                    PoiChildrenInfo poiChildrenInfo = this.poiChildrenInfoList.get(i2);
                    if (poiChildrenInfo != null) {
                        stringBuffer.append(poiChildrenInfo.toString());
                    } else {
                        stringBuffer.append(StringUtil.NULL_STRING);
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
        if (interceptable == null || interceptable.invokeLI(1048640, this, parcel, i2) == null) {
            parcel.writeString(this.name);
            parcel.writeParcelable(this.location, i2);
            parcel.writeString(this.address);
            parcel.writeString(this.province);
            parcel.writeString(this.city);
            parcel.writeString(this.area);
            parcel.writeString(this.telephone);
            parcel.writeString(this.uid);
            parcel.writeString(this.streetId);
            parcel.writeInt(this.detail);
            parcel.writeInt(this.distance);
            parcel.writeString(this.type);
            parcel.writeString(this.tag);
            parcel.writeParcelable(this.naviLocation, i2);
            parcel.writeString(this.detailUrl);
            parcel.writeDouble(this.price);
            parcel.writeString(this.shopHours);
            parcel.writeDouble(this.overallRating);
            parcel.writeDouble(this.tasteRating);
            parcel.writeDouble(this.serviceRating);
            parcel.writeDouble(this.environmentRating);
            parcel.writeDouble(this.facilityRating);
            parcel.writeDouble(this.hygieneRating);
            parcel.writeDouble(this.technologyRating);
            parcel.writeInt(this.imageNum);
            parcel.writeInt(this.grouponNum);
            parcel.writeInt(this.discountNum);
            parcel.writeInt(this.commentNum);
            parcel.writeInt(this.favoriteNum);
            parcel.writeInt(this.checkinNum);
            parcel.writeTypedList(this.poiChildrenInfoList);
        }
    }
}
