package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class SearchResult implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ERRORNO error;
    public int status;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public final class ERRORNO {
        public static final /* synthetic */ ERRORNO[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ERRORNO AMBIGUOUS_KEYWORD;
        public static final ERRORNO AMBIGUOUS_ROURE_ADDR;
        public static final ERRORNO INDOOR_ROUTE_NO_IN_BUILDING;
        public static final ERRORNO INDOOR_ROUTE_NO_IN_SAME_BUILDING;
        public static final ERRORNO KEY_ERROR;
        public static final ERRORNO MASS_TRANSIT_NO_POI_ERROR;
        public static final ERRORNO MASS_TRANSIT_OPTION_ERROR;
        public static final ERRORNO MASS_TRANSIT_SERVER_ERROR;
        public static final ERRORNO NETWORK_ERROR;
        public static final ERRORNO NETWORK_TIME_OUT;
        public static final ERRORNO NOT_SUPPORT_BUS;
        public static final ERRORNO NOT_SUPPORT_BUS_2CITY;
        public static final ERRORNO NO_ERROR;
        public static final ERRORNO PERMISSION_UNFINISHED;
        public static final ERRORNO POIINDOOR_BID_ERROR;
        public static final ERRORNO POIINDOOR_FLOOR_ERROR;
        public static final ERRORNO POIINDOOR_SERVER_ERROR;
        public static final ERRORNO REQUEST_ERROR;
        public static final ERRORNO RESULT_NOT_FOUND;
        public static final ERRORNO SEARCH_OPTION_ERROR;
        public static final ERRORNO SEARCH_SERVER_INTERNAL_ERROR;
        public static final ERRORNO ST_EN_TOO_NEAR;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1997977019, "Lcom/baidu/mapapi/search/core/SearchResult$ERRORNO;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1997977019, "Lcom/baidu/mapapi/search/core/SearchResult$ERRORNO;");
                    return;
                }
            }
            NO_ERROR = new ERRORNO("NO_ERROR", 0);
            RESULT_NOT_FOUND = new ERRORNO("RESULT_NOT_FOUND", 1);
            AMBIGUOUS_KEYWORD = new ERRORNO("AMBIGUOUS_KEYWORD", 2);
            AMBIGUOUS_ROURE_ADDR = new ERRORNO("AMBIGUOUS_ROURE_ADDR", 3);
            NOT_SUPPORT_BUS = new ERRORNO("NOT_SUPPORT_BUS", 4);
            NOT_SUPPORT_BUS_2CITY = new ERRORNO("NOT_SUPPORT_BUS_2CITY", 5);
            ST_EN_TOO_NEAR = new ERRORNO("ST_EN_TOO_NEAR", 6);
            KEY_ERROR = new ERRORNO("KEY_ERROR", 7);
            PERMISSION_UNFINISHED = new ERRORNO("PERMISSION_UNFINISHED", 8);
            NETWORK_TIME_OUT = new ERRORNO("NETWORK_TIME_OUT", 9);
            NETWORK_ERROR = new ERRORNO("NETWORK_ERROR", 10);
            POIINDOOR_BID_ERROR = new ERRORNO("POIINDOOR_BID_ERROR", 11);
            POIINDOOR_FLOOR_ERROR = new ERRORNO("POIINDOOR_FLOOR_ERROR", 12);
            POIINDOOR_SERVER_ERROR = new ERRORNO("POIINDOOR_SERVER_ERROR", 13);
            INDOOR_ROUTE_NO_IN_BUILDING = new ERRORNO("INDOOR_ROUTE_NO_IN_BUILDING", 14);
            INDOOR_ROUTE_NO_IN_SAME_BUILDING = new ERRORNO("INDOOR_ROUTE_NO_IN_SAME_BUILDING", 15);
            MASS_TRANSIT_SERVER_ERROR = new ERRORNO("MASS_TRANSIT_SERVER_ERROR", 16);
            MASS_TRANSIT_OPTION_ERROR = new ERRORNO("MASS_TRANSIT_OPTION_ERROR", 17);
            MASS_TRANSIT_NO_POI_ERROR = new ERRORNO("MASS_TRANSIT_NO_POI_ERROR", 18);
            SEARCH_SERVER_INTERNAL_ERROR = new ERRORNO("SEARCH_SERVER_INTERNAL_ERROR", 19);
            SEARCH_OPTION_ERROR = new ERRORNO("SEARCH_OPTION_ERROR", 20);
            ERRORNO errorno = new ERRORNO("REQUEST_ERROR", 21);
            REQUEST_ERROR = errorno;
            $VALUES = new ERRORNO[]{NO_ERROR, RESULT_NOT_FOUND, AMBIGUOUS_KEYWORD, AMBIGUOUS_ROURE_ADDR, NOT_SUPPORT_BUS, NOT_SUPPORT_BUS_2CITY, ST_EN_TOO_NEAR, KEY_ERROR, PERMISSION_UNFINISHED, NETWORK_TIME_OUT, NETWORK_ERROR, POIINDOOR_BID_ERROR, POIINDOOR_FLOOR_ERROR, POIINDOOR_SERVER_ERROR, INDOOR_ROUTE_NO_IN_BUILDING, INDOOR_ROUTE_NO_IN_SAME_BUILDING, MASS_TRANSIT_SERVER_ERROR, MASS_TRANSIT_OPTION_ERROR, MASS_TRANSIT_NO_POI_ERROR, SEARCH_SERVER_INTERNAL_ERROR, SEARCH_OPTION_ERROR, errorno};
        }

        public ERRORNO(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ERRORNO valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ERRORNO) Enum.valueOf(ERRORNO.class, str) : (ERRORNO) invokeL.objValue;
        }

        public static ERRORNO[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ERRORNO[]) $VALUES.clone() : (ERRORNO[]) invokeV.objValue;
        }
    }

    public SearchResult() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.status = 0;
        this.error = ERRORNO.NO_ERROR;
    }

    public SearchResult(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.status = 0;
        int readInt = parcel.readInt();
        this.error = readInt == -1 ? null : ERRORNO.values()[readInt];
    }

    public SearchResult(ERRORNO errorno) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {errorno};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.status = 0;
        this.error = errorno;
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

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i) == null) {
            ERRORNO errorno = this.error;
            parcel.writeInt(errorno == null ? -1 : errorno.ordinal());
        }
    }
}
