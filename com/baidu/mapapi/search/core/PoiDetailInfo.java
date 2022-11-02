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
/* loaded from: classes2.dex */
public class PoiDetailInfo implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<PoiDetailInfo> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public LatLng b;
    public String c;
    public int checkinNum;
    public int commentNum;
    public String d;
    public String detailUrl;
    public int discountNum;
    public int distance;
    public String e;
    public double environmentRating;
    public String f;
    public double facilityRating;
    public int favoriteNum;
    public int g;
    public int grouponNum;
    public String h;
    public double hygieneRating;
    public String i;
    public int imageNum;
    public String j;
    public int k;
    public List<PoiChildrenInfo> l;
    public LatLng naviLocation;
    public double overallRating;
    public double price;
    public double serviceRating;
    public String shopHours;
    public String tag;
    public double tasteRating;
    public double technologyRating;
    public String type;

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
        CREATOR = new g();
    }

    public PoiDetailInfo() {
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

    public int getAdCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public String getAddress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public String getArea() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public int getCheckinNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.checkinNum;
        }
        return invokeV.intValue;
    }

    public String getCity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public int getCommentNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.commentNum;
        }
        return invokeV.intValue;
    }

    public int getDetail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.k;
        }
        return invokeV.intValue;
    }

    public String getDetailUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.detailUrl;
        }
        return (String) invokeV.objValue;
    }

    public int getDiscountNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.discountNum;
        }
        return invokeV.intValue;
    }

    public int getDistance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.distance;
        }
        return invokeV.intValue;
    }

    public double getEnvironmentRating() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.environmentRating;
        }
        return invokeV.doubleValue;
    }

    public double getFacilityRating() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.facilityRating;
        }
        return invokeV.doubleValue;
    }

    public int getFavoriteNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.favoriteNum;
        }
        return invokeV.intValue;
    }

    public int getGrouponNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.grouponNum;
        }
        return invokeV.intValue;
    }

    public double getHygieneRating() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.hygieneRating;
        }
        return invokeV.doubleValue;
    }

    public int getImageNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.imageNum;
        }
        return invokeV.intValue;
    }

    public LatLng getLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.b;
        }
        return (LatLng) invokeV.objValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public LatLng getNaviLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.naviLocation;
        }
        return (LatLng) invokeV.objValue;
    }

    public double getOverallRating() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.overallRating;
        }
        return invokeV.doubleValue;
    }

    public List<PoiChildrenInfo> getPoiChildrenInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.l;
        }
        return (List) invokeV.objValue;
    }

    public double getPrice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.price;
        }
        return invokeV.doubleValue;
    }

    public String getProvince() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public double getServiceRating() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.serviceRating;
        }
        return invokeV.doubleValue;
    }

    public String getShopHours() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.shopHours;
        }
        return (String) invokeV.objValue;
    }

    public String getStreetId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.j;
        }
        return (String) invokeV.objValue;
    }

    public String getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.tag;
        }
        return (String) invokeV.objValue;
    }

    public double getTasteRating() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.tasteRating;
        }
        return invokeV.doubleValue;
    }

    public double getTechnologyRating() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.technologyRating;
        }
        return invokeV.doubleValue;
    }

    public String getTelephone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.type;
        }
        return (String) invokeV.objValue;
    }

    public String getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.i;
        }
        return (String) invokeV.objValue;
    }

    public PoiDetailInfo(Parcel parcel) {
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
        this.a = parcel.readString();
        this.b = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.readString();
        this.j = parcel.readString();
        this.k = parcel.readInt();
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
        this.l = parcel.createTypedArrayList(PoiChildrenInfo.CREATOR);
    }

    public void setAdCode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            this.g = i;
        }
    }

    public void setAddress(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            this.c = str;
        }
    }

    public void setArea(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.f = str;
        }
    }

    public void setCheckinNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            this.checkinNum = i;
        }
    }

    public void setCity(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.e = str;
        }
    }

    public void setCommentNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            this.commentNum = i;
        }
    }

    public void setDetail(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            try {
                this.k = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                this.k = 0;
            }
        }
    }

    public void setDetailUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            this.detailUrl = str;
        }
    }

    public void setDiscountNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i) == null) {
            this.discountNum = i;
        }
    }

    public void setDistance(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i) == null) {
            this.distance = i;
        }
    }

    public void setEnvironmentRating(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{Double.valueOf(d)}) == null) {
            this.environmentRating = d;
        }
    }

    public void setFacilityRating(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{Double.valueOf(d)}) == null) {
            this.facilityRating = d;
        }
    }

    public void setFavoriteNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            this.favoriteNum = i;
        }
    }

    public void setGrouponNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i) == null) {
            this.grouponNum = i;
        }
    }

    public void setHygieneRating(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{Double.valueOf(d)}) == null) {
            this.hygieneRating = d;
        }
    }

    public void setImageNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i) == null) {
            this.imageNum = i;
        }
    }

    public void setLocation(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, latLng) == null) {
            this.b = latLng;
        }
    }

    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, str) == null) {
            this.a = str;
        }
    }

    public void setNaviLocation(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, latLng) == null) {
            this.naviLocation = latLng;
        }
    }

    public void setOverallRating(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048628, this, new Object[]{Double.valueOf(d)}) == null) {
            this.overallRating = d;
        }
    }

    public void setPoiChildrenInfoList(List<PoiChildrenInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, list) == null) {
            this.l = list;
        }
    }

    public void setPrice(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048630, this, new Object[]{Double.valueOf(d)}) == null) {
            this.price = d;
        }
    }

    public void setProvince(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, str) == null) {
            this.d = str;
        }
    }

    public void setServiceRating(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048632, this, new Object[]{Double.valueOf(d)}) == null) {
            this.serviceRating = d;
        }
    }

    public void setShopHours(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, str) == null) {
            this.shopHours = str;
        }
    }

    public void setStreetId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, str) == null) {
            this.j = str;
        }
    }

    public void setTag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, str) == null) {
            this.tag = str;
        }
    }

    public void setTasteRating(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048636, this, new Object[]{Double.valueOf(d)}) == null) {
            this.tasteRating = d;
        }
    }

    public void setTechnologyRating(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048637, this, new Object[]{Double.valueOf(d)}) == null) {
            this.technologyRating = d;
        }
    }

    public void setTelephone(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, str) == null) {
            this.h = str;
        }
    }

    public void setType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, str) == null) {
            this.type = str;
        }
    }

    public void setUid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, str) == null) {
            this.i = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer("PoiDetailInfo: ");
            stringBuffer.append("name = ");
            stringBuffer.append(this.a);
            stringBuffer.append("; location = ");
            LatLng latLng = this.b;
            if (latLng != null) {
                stringBuffer.append(latLng.toString());
            } else {
                stringBuffer.append(StringUtil.NULL_STRING);
            }
            stringBuffer.append("; address = ");
            stringBuffer.append(this.c);
            stringBuffer.append("; province = ");
            stringBuffer.append(this.d);
            stringBuffer.append("; city = ");
            stringBuffer.append(this.e);
            stringBuffer.append("; area = ");
            stringBuffer.append(this.f);
            stringBuffer.append("; telephone = ");
            stringBuffer.append(this.h);
            stringBuffer.append("; uid = ");
            stringBuffer.append(this.i);
            stringBuffer.append("; detail = ");
            stringBuffer.append(this.k);
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
            List<PoiChildrenInfo> list = this.l;
            if (list != null && !list.isEmpty()) {
                for (int i = 0; i < this.l.size(); i++) {
                    stringBuffer.append("; The ");
                    stringBuffer.append(i);
                    stringBuffer.append(" poiChildrenInfo is: ");
                    PoiChildrenInfo poiChildrenInfo = this.l.get(i);
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
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048642, this, parcel, i) == null) {
            parcel.writeString(this.a);
            parcel.writeParcelable(this.b, i);
            parcel.writeString(this.c);
            parcel.writeString(this.d);
            parcel.writeString(this.e);
            parcel.writeString(this.f);
            parcel.writeString(this.h);
            parcel.writeString(this.i);
            parcel.writeString(this.j);
            parcel.writeInt(this.k);
            parcel.writeInt(this.distance);
            parcel.writeString(this.type);
            parcel.writeString(this.tag);
            parcel.writeParcelable(this.naviLocation, i);
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
            parcel.writeTypedList(this.l);
        }
    }
}
