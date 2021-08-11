package com.baidu.mapapi.synchronization.histroytrace;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class HistoryTraceConstant {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LBS_HISTORY_TRACE_CODE_BAIDUMAP_NULL = 10007;
    public static final int LBS_HISTORY_TRACE_CODE_CAR_POINT_ICON_NULL = 100023;
    public static final int LBS_HISTORY_TRACE_CODE_CAR_POINT_NULL = 100024;
    public static final int LBS_HISTORY_TRACE_CODE_CURRENT_ORDER_STATE_NOT_COMPLETE = 100014;
    public static final int LBS_HISTORY_TRACE_CODE_DISPLAY_OPTIONS_NULL = 100015;
    public static final int LBS_HISTORY_TRACE_CODE_END_POINT_ICON_NULL = 100021;
    public static final int LBS_HISTORY_TRACE_CODE_END_POINT_NULL = 100022;
    public static final int LBS_HISTORY_TRACE_CODE_NETWORK_ERROR = 100010;
    public static final int LBS_HISTORY_TRACE_CODE_POINTS_LESS = 100017;
    public static final int LBS_HISTORY_TRACE_CODE_POINTS_NULL = 100016;
    public static final int LBS_HISTORY_TRACE_CODE_QUERY_DRIVER_ID_NULL = 10006;
    public static final int LBS_HISTORY_TRACE_CODE_QUERY_OPTIONS_NULL = 10001;
    public static final int LBS_HISTORY_TRACE_CODE_QUERY_ORDER_ID_NULL = 10003;
    public static final int LBS_HISTORY_TRACE_CODE_QUERY_RESULT_NULL = 10008;
    public static final int LBS_HISTORY_TRACE_CODE_QUERY_RESULT_PARSER_FAILED = 10009;
    public static final int LBS_HISTORY_TRACE_CODE_QUERY_ROLE_TYPE_ERROR = 10004;
    public static final int LBS_HISTORY_TRACE_CODE_QUERY_URL_NULL = 10002;
    public static final int LBS_HISTORY_TRACE_CODE_QUERY_USER_ID_NULL = 10005;
    public static final int LBS_HISTORY_TRACE_CODE_REQUEST_OVER_SIZE = 10;
    public static final int LBS_HISTORY_TRACE_CODE_REQUEST_PARAMETER_ERROR = 100012;
    public static final int LBS_HISTORY_TRACE_CODE_ROUTE_TEXTURE_NULL = 100018;
    public static final int LBS_HISTORY_TRACE_CODE_SERVER_ERROR = 1;
    public static final int LBS_HISTORY_TRACE_CODE_SERVER_INNER_ERROR = 100011;
    public static final int LBS_HISTORY_TRACE_CODE_START_POINT_ICON_NULL = 100019;
    public static final int LBS_HISTORY_TRACE_CODE_START_POINT_NULL = 100020;
    public static final int LBS_HISTORY_TRACE_CODE_SUCCESS = 0;
    public static final int LBS_HISTORY_TRACE_CODE_UNDEFINE_ERROR = 100013;
    public static final String LBS_HISTORY_TRACE_MESSAGE_BAIDUMAP_NULL = "BaiduMap instance is null, please check.";
    public static final String LBS_HISTORY_TRACE_MESSAGE_CAR_POINT_ICON_NULL = "History trace car point icon is null, can't render start point marker";
    public static final String LBS_HISTORY_TRACE_MESSAGE_CAR_POINT_NULL = "History trace car point is null, can't render start point marker";
    public static final String LBS_HISTORY_TRACE_MESSAGE_CURRENT_ORDER_STATE_NOT_COMPLETE = "Current order state not complete state";
    public static final String LBS_HISTORY_TRACE_MESSAGE_DISPLAY_OPTIONS_NULL = "DisplayOptions instance is null, user default display options render";
    public static final String LBS_HISTORY_TRACE_MESSAGE_END_POINT_ICON_NULL = "History trace end point icon is null, can't render start point marker";
    public static final String LBS_HISTORY_TRACE_MESSAGE_END_POINT_NULL = "History trace end point is null, can't render start point marker";
    public static final String LBS_HISTORY_TRACE_MESSAGE_NETWORK_ERROR = "Network error";
    public static final String LBS_HISTORY_TRACE_MESSAGE_POINTS_LESS = "History trace points less than 2, can't render route line";
    public static final String LBS_HISTORY_TRACE_MESSAGE_POINTS_NULL = "History trace points data is null, can't render route line";
    public static final String LBS_HISTORY_TRACE_MESSAGE_QUERY_DRIVER_ID_NULL = "Driver ID is null, please check.";
    public static final String LBS_HISTORY_TRACE_MESSAGE_QUERY_OPTIONS_NULL = "QueryOptions is null, please check.";
    public static final String LBS_HISTORY_TRACE_MESSAGE_QUERY_ORDER_ID_NULL = "Order ID is null, please check.";
    public static final String LBS_HISTORY_TRACE_MESSAGE_QUERY_RESULT_NULL = "Query result is null, please check.";
    public static final String LBS_HISTORY_TRACE_MESSAGE_QUERY_RESULT_PARSER_FAILED = "Query result parser failed, please check.";
    public static final String LBS_HISTORY_TRACE_MESSAGE_QUERY_ROLE_TYPE_ERROR = "Role type is not passenger, please check.";
    public static final String LBS_HISTORY_TRACE_MESSAGE_QUERY_URL_NULL = "QueryOptions is null, please check.";
    public static final String LBS_HISTORY_TRACE_MESSAGE_QUERY_USER_ID_NULL = "User ID is null, please check.";
    public static final String LBS_HISTORY_TRACE_MESSAGE_REQUEST_PARAMETER_ERROR = "Request parameters error";
    public static final String LBS_HISTORY_TRACE_MESSAGE_ROUTE_TEXTURE_NULL = "History trace route line texture is null, can't render route line";
    public static final String LBS_HISTORY_TRACE_MESSAGE_SERVER_INNER_ERROR = "Server inner error";
    public static final String LBS_HISTORY_TRACE_MESSAGE_START_POINT_ICON_NULL = "History trace end point icon is null, can't render start point marker";
    public static final String LBS_HISTORY_TRACE_MESSAGE_START_POINT_NULL = "History trace end point is null, can't render start point marker";
    public static final String LBS_HISTORY_TRACE_MESSAGE_SUCCESS = "Success";
    public static final String LBS_HISTORY_TRACE_MESSAGE_UNDEFINE_ERROR = "Undefine error";
    public transient /* synthetic */ FieldHolder $fh;

    public HistoryTraceConstant() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
