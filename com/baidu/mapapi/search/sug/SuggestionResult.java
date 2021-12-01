package com.baidu.mapapi.search.sug;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiChildrenInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class SuggestionResult extends SearchResult implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<SuggestionResult> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<SuggestionInfo> suggestionList;

    /* loaded from: classes8.dex */
    public static class SuggestionInfo implements Parcelable {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SuggestionInfo> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public String address;
        public String city;
        public String district;
        public String key;
        public List<PoiChildrenInfo> poiChildrenInfoList;
        public LatLng pt;
        public String tag;
        public String uid;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(358116116, "Lcom/baidu/mapapi/search/sug/SuggestionResult$SuggestionInfo;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(358116116, "Lcom/baidu/mapapi/search/sug/SuggestionResult$SuggestionInfo;");
                    return;
                }
            }
            CREATOR = new b();
        }

        public SuggestionInfo() {
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

        public SuggestionInfo(Parcel parcel) {
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
            this.key = parcel.readString();
            this.city = parcel.readString();
            this.district = parcel.readString();
            this.pt = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.uid = parcel.readString();
            this.tag = parcel.readString();
            this.address = parcel.readString();
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

        public String getCity() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.city : (String) invokeV.objValue;
        }

        public String getDistrict() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.district : (String) invokeV.objValue;
        }

        public String getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.key : (String) invokeV.objValue;
        }

        public List<PoiChildrenInfo> getPoiChildrenInfoList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.poiChildrenInfoList : (List) invokeV.objValue;
        }

        public LatLng getPt() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.pt : (LatLng) invokeV.objValue;
        }

        public String getTag() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.tag : (String) invokeV.objValue;
        }

        public String getUid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.uid : (String) invokeV.objValue;
        }

        public void setAddress(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                this.address = str;
            }
        }

        public void setCity(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
                this.city = str;
            }
        }

        public void setDistrict(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
                this.district = str;
            }
        }

        public void setKey(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
                this.key = str;
            }
        }

        public void setPoiChildrenInfoList(List<PoiChildrenInfo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
                this.poiChildrenInfoList = list;
            }
        }

        public void setPt(LatLng latLng) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, latLng) == null) {
                this.pt = latLng;
            }
        }

        public void setTag(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
                this.tag = str;
            }
        }

        public void setUid(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
                this.uid = str;
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                StringBuffer stringBuffer = new StringBuffer("SuggestionInfo: ");
                stringBuffer.append("key = ");
                stringBuffer.append(this.key);
                stringBuffer.append("; city = ");
                stringBuffer.append(this.city);
                stringBuffer.append("; district = ");
                stringBuffer.append(this.district);
                stringBuffer.append("; pt = ");
                LatLng latLng = this.pt;
                if (latLng != null) {
                    stringBuffer.append(latLng.toString());
                } else {
                    stringBuffer.append(StringUtil.NULL_STRING);
                }
                stringBuffer.append("; uid = ");
                stringBuffer.append(this.uid);
                stringBuffer.append("; tag = ");
                stringBuffer.append(this.tag);
                stringBuffer.append("; address = ");
                stringBuffer.append(this.address);
                stringBuffer.append("; childrenInfo = ");
                List<PoiChildrenInfo> list = this.poiChildrenInfoList;
                if (list == null || list.isEmpty()) {
                    stringBuffer.append(StringUtil.NULL_STRING);
                } else {
                    for (int i2 = 0; i2 < this.poiChildrenInfoList.size(); i2++) {
                        stringBuffer.append(" ");
                        stringBuffer.append(i2);
                        stringBuffer.append(" ");
                        PoiChildrenInfo poiChildrenInfo = this.poiChildrenInfoList.get(i2);
                        if (poiChildrenInfo == null) {
                            stringBuffer.append(StringUtil.NULL_STRING);
                        } else {
                            stringBuffer.append(poiChildrenInfo.toString());
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
            if (interceptable == null || interceptable.invokeLI(1048594, this, parcel, i2) == null) {
                parcel.writeString(this.key);
                parcel.writeString(this.city);
                parcel.writeString(this.district);
                parcel.writeParcelable(this.pt, i2);
                parcel.writeString(this.uid);
                parcel.writeString(this.tag);
                parcel.writeString(this.address);
                parcel.writeTypedList(this.poiChildrenInfoList);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1439702548, "Lcom/baidu/mapapi/search/sug/SuggestionResult;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1439702548, "Lcom/baidu/mapapi/search/sug/SuggestionResult;");
                return;
            }
        }
        CREATOR = new a();
    }

    public SuggestionResult() {
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

    public SuggestionResult(Parcel parcel) {
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
        this.suggestionList = parcel.readArrayList(SuggestionInfo.class.getClassLoader());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuggestionResult(SearchResult.ERRORNO errorno) {
        super(errorno);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {errorno};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((SearchResult.ERRORNO) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
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

    public List<SuggestionInfo> getAllSuggestions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.suggestionList : (List) invokeV.objValue;
    }

    public void setSuggestionInfo(ArrayList<SuggestionInfo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.suggestionList = arrayList;
        }
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, parcel, i2) == null) {
            parcel.writeList(this.suggestionList);
        }
    }
}
