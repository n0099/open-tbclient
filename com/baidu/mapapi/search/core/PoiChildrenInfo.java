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
/* loaded from: classes3.dex */
public class PoiChildrenInfo implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<PoiChildrenInfo> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public String address;
    public LatLng location;
    public String name;
    public String showName;
    public String tag;
    public String uid;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(272532272, "Lcom/baidu/mapapi/search/core/PoiChildrenInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(272532272, "Lcom/baidu/mapapi/search/core/PoiChildrenInfo;");
                return;
            }
        }
        CREATOR = new e();
    }

    public PoiChildrenInfo() {
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

    public PoiChildrenInfo(Parcel parcel) {
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
        this.uid = parcel.readString();
        this.name = parcel.readString();
        this.showName = parcel.readString();
        this.tag = parcel.readString();
        this.location = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.address = parcel.readString();
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

    public LatLng getLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.location : (LatLng) invokeV.objValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.name : (String) invokeV.objValue;
    }

    public String getShowName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.showName : (String) invokeV.objValue;
    }

    public String getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.tag : (String) invokeV.objValue;
    }

    public String getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.uid : (String) invokeV.objValue;
    }

    public void setAddress(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.address = str;
        }
    }

    public void setLocation(LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, latLng) == null) {
            this.location = latLng;
        }
    }

    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.name = str;
        }
    }

    public void setShowName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.showName = str;
        }
    }

    public void setTag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.tag = str;
        }
    }

    public void setUid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.uid = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer("PoiChildrenInfo: ");
            stringBuffer.append("uid = ");
            stringBuffer.append(this.uid);
            stringBuffer.append("; name = ");
            stringBuffer.append(this.name);
            stringBuffer.append("; showName = ");
            stringBuffer.append(this.showName);
            stringBuffer.append("; tag = ");
            stringBuffer.append(this.tag);
            stringBuffer.append("; location = ");
            LatLng latLng = this.location;
            stringBuffer.append(latLng != null ? latLng.toString() : StringUtil.NULL_STRING);
            stringBuffer.append("; address = ");
            stringBuffer.append(this.address);
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, parcel, i2) == null) {
            parcel.writeString(this.uid);
            parcel.writeString(this.name);
            parcel.writeString(this.showName);
            parcel.writeString(this.tag);
            parcel.writeParcelable(this.location, i2);
            parcel.writeString(this.address);
        }
    }
}
