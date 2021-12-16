package com.baidu.ar.statistic;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class StatisticConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AUTH_FAILURE = "event_auth_fail";
    public static final String CLOUD_SEARCH_SUCCESS = "cloud_imgsearch_success";
    public static final String DEVICE_SEARCH_SUCCESS = "ondevice_imgsearch_success";
    public static final String DOWNLOAD_3D_RES_FAILURE = "download_3d_res_failure";
    public static final String DOWNLOAD_3D_RES_SUCCESS = "download_3d_res_success";
    public static final String EVENT_BEAUTIFY_ADJUST = "event_beautify_adjust";
    public static final String EVENT_CASE_END = "event_case_end";
    public static final String EVENT_CASE_FIRST = "event_case_first";
    public static final String EVENT_CASE_START = "event_case_start";
    public static final String EVENT_FACE2ANIME_CASEUSE = "event_face2comic_caseuse";
    public static final String EVENT_FACE2CHILD_CASEUSE = "event_face2kid_caseuse";
    public static final String EVENT_FACE_EXPRESSION = "event_face_expression";
    public static final String EVENT_FACE_MASKS_OFF = "event_face_masks_off";
    public static final String EVENT_FACE_MASKS_ON = "event_face_masks_on";
    public static final String EVENT_FEATURE_AUTH = "feature_auth";
    public static final String EVENT_FILTER_ADJUST = "event_filter_adjust";
    public static final String EVENT_FILTER_SWITCH = "event_filter_switch";
    public static final String EVENT_LBSNPC_ACTIVITY = "event_lbsnpc_activties";
    public static final String EVENT_MAKEUP_BLUSHER_ENTER = "event_makeup_blusher_enter";
    public static final String EVENT_MAKEUP_HIGHLIGHT_ENTER = "event_makeup_highlight_enter";
    public static final String EVENT_MAKEUP_LIPSTICK_ENTER = "event_makeup_lipstick_enter";
    public static final String EVENT_SDK_END = "event_sdk_end";
    public static final String EVENT_SDK_START = "event_sdk_start";
    public static final String FIRST_LOAD_FILE_MANAGE_FAILURE = "first_load_file_manage_failure";
    public static final String FIRST_LOAD_FILE_MANAGE_SUCCESS = "first_load_file_manage_success";
    public static final String FIRST_LOAD_QUERY_FAILURE = "first_load_query_failure";
    public static final String FIRST_LOAD_QUERY_SUCCESS = "first_load_query_success";
    public static final String FIRST_LOAD_START_QUERY = "first_load_start_query";
    public static final String FRAME_DATA_FROM = "frame_data_from";
    public static final String IMU_SET_SUCCESS = "imu_set_success";
    public static final String LOAD_DOWNLOAD_FAILURE = "load_download_failure";
    public static final String LOAD_DOWNLOAD_SUCCESS = "load_download_success";
    public static final String LOAD_FILE_MANAGE_FAILURE = "load_file_manage_failure";
    public static final String LOAD_QUERY_FAILURE = "load_query_failure";
    public static final String LOAD_START_DOWNLOAD = "load_start_download";
    public static final String LOAD_START_QUERY = "load_start_query";
    public static final String MDL_GESTURE_CLOSE = "paddle_gesture_close";
    public static final String MDL_GESTURE_OPEN = "paddle_gesture_open";
    public static final String MDL_HAIR_SEG_OPEN = "event_hairseg_on";
    public static final String MDL_HEAD_SEG_OPEN = "event_head_on";
    public static final String MDL_IMG_SEG_OPEN = "event_seg_on";
    public static final String MDL_SKY_SEG_OPEN = "event_skyseg_on";
    public static final String MIC_PERMISSION_NO = "event_micpermission_no";
    public static final String MIC_PERMISSION_SHOW = "event_micpermission_show";
    public static final String MIC_PERMISSION_YES = "event_micpermission_yes";
    public static final String MODEL_CAMERA_SWITCH = "model_camera_switch";
    public static final String MODEL_PHONE_SHAKE = "model_phone_shake";
    public static final String ONCLICK_CAPTURE_SCREEN = "capture_screen";
    public static final String ONCLICK_CAPTURE_SCREEN_SAVE = "capture_screen_save";
    public static final String ONCLICK_CAPTURE_SCREEN_SHARE = "capture_screen_share";
    public static final String ONCLICK_CAPTURE_VIDEO = "capture_video";
    public static final String ONCLICK_CAPTURE_VIDEO_SAVE = "capture_video_save";
    public static final String ONCLICK_CAPTURE_VIDEO_SHARE = "capture_video_share";
    public static final String OPEN_CAMERA_FAILURE = "open_camera_failure";
    public static final String RECOMMEND_CASE_CLICK = "recommend_case_click";
    public static final String RECOMMEND_ENTRANCE_CLICK = "recommend_entrance_click";
    public static final String SCREENSHOT = "screenshot";
    public static final String SLAM_TRACK_ON = "slam_track_on";
    public static final String SOLOAD_DOWNLOAD_FAILURE = "soload_download_failure";
    public static final String SOLOAD_LOAD_FAILURE = "soload_load_failure";
    public static final String SPEECH_TYPE_HIT = "speech_type_hit";
    public static final String SPEECH_TYPE_LISTENER = "speech_type_listener";
    public static final String SPEECH_TYPE_OPEN = "speech_type_open";
    public static final String SPEECH_TYPE_RESULT = "speech_type_result";
    public static final String START_DOWNLOAD_3D_RES = "start_download_3d_res";
    public static final String SYSTEM_CAMERA_PERMISSION_DENY = "event_opencamera_no";
    public static final String SYSTEM_CAMERA_PERMISSION_GRANTED = "event_campermission_yes";
    public static final String SYSTEM_REQUEST_CAMERA_PERMISSION = "event_campermission_show";
    public static final String TRACKED = "tracked";
    public static final String UNTRACKED = "untracked";
    public static final String USER_MIC_PERMISSION_TYPE_CANCEL = "user_mic_permission_type_cancel";
    public static final String USER_MIC_PERMISSION_TYPE_IKNOW = "user_mic_permission_type_iknow";
    public static final String USER_MIC_PERMISSION_TYPE_SETTING = "user_mic_permission_type_setting";
    public static final String VPS_BESTAREA_OUT = "vps_bestarea_out";
    public static final String VPS_GET_LOC_DURATION = "get_loc_duration";
    public static final String VPS_INDOOR_GET_LOC_DURATION = "vps_indoor_get_loc_duration";
    public static final String VPS_INDOOR_NAVIGATE_DURATION = "vps_indoor_navigate_duration";
    public static final String VPS_INDOOR_SDK_RECALL_SUCCESS = "vps_indoor_service_create";
    public static final String VPS_INDOOR_SERVICE_DURATION = "vps_indoor_service_duration";
    public static final String VPS_INDOOR_SUCCESS_RESULT = "vps_indoor_get_loc_success";
    public static final String VPS_NAVIGATE_DURATION = "navigate_duration";
    public static final String VPS_SDKRECALL_SUCCESS = "vps_sdkrecall_success";
    public static final String VPS_SESSION_ID = "session_id";
    public static final String VPS_SUB_INDOOR_SERVICE_DURATION = "indoor_service_duration";
    public static final String VPS_TRACK_ON = "vps_track_on";
    public transient /* synthetic */ FieldHolder $fh;

    public StatisticConstants() {
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
