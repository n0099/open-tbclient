package com.baidu.mapapi.map;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public final class MapBaseIndoorMapInfo {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: d  reason: collision with root package name */
    public static final String f35293d = "MapBaseIndoorMapInfo";
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f35294b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f35295c;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class SwitchFloorError {
        public static /* synthetic */ Interceptable $ic;
        public static final SwitchFloorError FLOOR_INFO_ERROR;
        public static final SwitchFloorError FLOOR_OVERLFLOW;
        public static final SwitchFloorError FOCUSED_ID_ERROR;
        public static final SwitchFloorError SWITCH_ERROR;
        public static final SwitchFloorError SWITCH_OK;
        public static final /* synthetic */ SwitchFloorError[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(729239463, "Lcom/baidu/mapapi/map/MapBaseIndoorMapInfo$SwitchFloorError;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(729239463, "Lcom/baidu/mapapi/map/MapBaseIndoorMapInfo$SwitchFloorError;");
                    return;
                }
            }
            SWITCH_OK = new SwitchFloorError("SWITCH_OK", 0);
            FLOOR_INFO_ERROR = new SwitchFloorError("FLOOR_INFO_ERROR", 1);
            FLOOR_OVERLFLOW = new SwitchFloorError("FLOOR_OVERLFLOW", 2);
            FOCUSED_ID_ERROR = new SwitchFloorError("FOCUSED_ID_ERROR", 3);
            SwitchFloorError switchFloorError = new SwitchFloorError("SWITCH_ERROR", 4);
            SWITCH_ERROR = switchFloorError;
            a = new SwitchFloorError[]{SWITCH_OK, FLOOR_INFO_ERROR, FLOOR_OVERLFLOW, FOCUSED_ID_ERROR, switchFloorError};
        }

        public SwitchFloorError(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static SwitchFloorError valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SwitchFloorError) Enum.valueOf(SwitchFloorError.class, str) : (SwitchFloorError) invokeL.objValue;
        }

        public static SwitchFloorError[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (SwitchFloorError[]) a.clone() : (SwitchFloorError[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2115653467, "Lcom/baidu/mapapi/map/MapBaseIndoorMapInfo;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2115653467, "Lcom/baidu/mapapi/map/MapBaseIndoorMapInfo;");
        }
    }

    public MapBaseIndoorMapInfo() {
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

    public MapBaseIndoorMapInfo(MapBaseIndoorMapInfo mapBaseIndoorMapInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mapBaseIndoorMapInfo};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = mapBaseIndoorMapInfo.a;
        this.f35294b = mapBaseIndoorMapInfo.f35294b;
        this.f35295c = mapBaseIndoorMapInfo.f35295c;
    }

    public MapBaseIndoorMapInfo(String str, String str2, ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, arrayList};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = str;
        this.f35294b = str2;
        this.f35295c = arrayList;
    }

    public String getCurFloor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f35294b : (String) invokeV.objValue;
    }

    public ArrayList<String> getFloors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f35295c : (ArrayList) invokeV.objValue;
    }

    public String getID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (String) invokeV.objValue;
    }
}
