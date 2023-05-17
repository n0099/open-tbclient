package com.baidu.location;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class LocationConst {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class SceneType {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int SCENE_TYPE_RECOGNITION_SUBWAY = 1;
        public static final int SCENE_TYPE_RECOGNITION_TRAFFIC_TYPE = 2;
        public transient /* synthetic */ FieldHolder $fh;

        public SceneType() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class SubWayErrorCode {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int SUBWAY_ERROR_LOC_ENGINE_INTERNAL = -5;
        public static final int SUBWAY_ERROR_LOC_ENGINE_MISS_DATA = -4;
        public static final int SUBWAY_ERROR_LOC_KNOWN = -6;
        public static final int SUBWAY_ERROR_NONSUPPORT_PRESSURE = -2;
        public static final int SUBWAY_ERROR_SWITCH_CLOSE = -1;
        public static final int SUBWAY_LOC_SDK_ERROR = -3;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LocationConst this$0;

        public SubWayErrorCode(LocationConst locationConst) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {locationConst};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = locationConst;
        }
    }

    /* loaded from: classes3.dex */
    public class TrafficStatus {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int TRAFFIC_ERROR_LOC_ENGINE_INTERNAL = -6;
        public static final int TRAFFIC_ERROR_LOC_ENGINE_MISS_DATA = -5;
        public static final int TRAFFIC_ERROR_LOC_KNOWN = -7;
        public static final int TRAFFIC_ERROR_LOC_SDK = -4;
        public static final int TRAFFIC_ERROR_MODEL_LOAD_FAILED = -8;
        public static final int TRAFFIC_ERROR_NONSUPPORT_BLUETOOTH = -2;
        public static final int TRAFFIC_ERROR_NON_OPEN_BLUETOOTH = -3;
        public static final int TRAFFIC_ERROR_PREDICT_GPS_NO_DATA = 112;
        public static final int TRAFFIC_ERROR_PREDICT_MODEL_CUL_FAILED = 113;
        public static final int TRAFFIC_ERROR_SWITCH_CLOSE = -1;
        public static final int TRAFFIC_SCAN_BLUETOOTH_FINISH = 101;
        public static final int TRAFFIC_SCAN_BLUETOOTH_NO_DATA = 102;
        public static final int TRAFFIC_STATUS_BUS = 2;
        public static final int TRAFFIC_STATUS_DRIVE = 0;
        public static final int TRAFFIC_STATUS_SUBWAY = 3;
        public static final int TRAFFIC_STATUS_WALK = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LocationConst this$0;

        public TrafficStatus(LocationConst locationConst) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {locationConst};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = locationConst;
        }
    }

    public LocationConst() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
