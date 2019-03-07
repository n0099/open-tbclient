package com.baidu.pass.biometrics.face.liveness.stat;

import android.content.Context;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.utils.NetworkUtils;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.pass.biometrics.base.utils.StatService;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LivenessStat {
    public static final int DEFAULT_INT_NUM = 0;
    public static final String KEY_NAME_LIVENESS_STAT = "living_recog";
    public static final String TAG = LivenessStat.class.getSimpleName();
    public static final int TYPE_BOOLEAN_DEFAULT = -1;
    public static final String TYPE_CLOSE_FIND_EYE = "find_eye";
    public static final String TYPE_CLOSE_FIND_FACE = "find_face";
    public static final String TYPE_CLOSE_FIND_MOUTH = "find_mouth";
    public static final String TYPE_FACE_MATCH_FAIL = "fail";
    public static final String TYPE_FACE_MATCH_PASS = "pass";
    public static final int TYPE_FALSE = 0;
    public static final String TYPE_LIVING_EYE = "eye";
    public static final String TYPE_LIVING_MOUTH = "mouth";
    public static final String TYPE_STRING_DEFAULT = "-1";
    public static final int TYPE_TRUE = 1;
    public static final String TYPE_VOICE_CLOSE = "close";
    public static final String TYPE_VOICE_OPEN = "open";
    public String previewSize;
    public long timePointStart;
    public String recogType = "";
    public String subPro = "";
    public int withCameraPermission = -1;
    public int openCameraPermissionSuc = -1;
    public int asyncGetPortraitType = -1;
    public int findFaceLast = -1;
    public int findFaceNum = 0;
    public int livingPassEyesNum = 0;
    public int livingPassMouthNum = 0;
    public String livingPassType = TYPE_STRING_DEFAULT;
    public int whiteBg = -1;
    public float illumValue = -1.0f;
    public String livingPassPeriod = TYPE_STRING_DEFAULT;
    public int getIDLPicture = -1;
    public String faceMatchType = TYPE_STRING_DEFAULT;
    public String clickCloseType = TYPE_STRING_DEFAULT;
    public String clickVoiceType = TYPE_STRING_DEFAULT;
    public int tipDistanceNearNum = 0;
    public int tipDistanceFarNum = 0;
    public int tipEyeSlopeNum = 0;
    public int tipPutFaceRoundNum = 0;
    public int tipLightLowNum = 0;
    public int tipOverTime = -1;
    public int tipOverTimeCancel = -1;
    public int tipOverTimeRetry = -1;
    public int tipOverTimeAgain = -1;
    public int tipOverTimeSure = -1;
    public long timePointStartRecog = 0;
    public long timePointCameraReady = 0;
    public long timePointIdlTrackTimeAll = 0;
    public int timePointIdlTrackCounts = 0;
    public long timePointStartFindFace = 0;
    public long timePointFindFaceDone = 0;
    public long timePointLivingEyeStart = 0;
    public long timePointLivingEyePass = 0;
    public long timePointLivingMouthStart = 0;
    public long timePointLivingMouthPass = 0;
    public long timePointEnd = 0;
    public int errCode = 0;
    public boolean isLivenessSuc = false;

    public void resetTimePoint() {
        this.timePointStartFindFace = 0L;
        this.timePointFindFaceDone = 0L;
        this.timePointLivingEyeStart = 0L;
        this.timePointLivingEyePass = 0L;
        this.timePointLivingMouthStart = 0L;
        this.timePointLivingMouthPass = 0L;
    }

    public void onStat(Context context) {
        HashMap hashMap = new HashMap();
        Log.w(TAG, "onStat");
        if (this.withCameraPermission != -1) {
            hashMap.put("camera_with_per", this.withCameraPermission + "");
        }
        if (this.openCameraPermissionSuc != -1) {
            hashMap.put("camera_open_per", this.openCameraPermissionSuc + "");
        }
        if (this.asyncGetPortraitType != -1) {
            hashMap.put("net_get_potrt", this.asyncGetPortraitType + "");
        }
        if (this.findFaceLast != -1) {
            hashMap.put("find_face_last", this.findFaceLast + "");
        }
        if (this.findFaceNum != 0) {
            hashMap.put("find_face_num", this.findFaceNum + "");
        }
        if (this.livingPassEyesNum != 0) {
            hashMap.put("living_pass_eye_num", this.livingPassEyesNum + "");
        }
        if (this.livingPassMouthNum != 0) {
            hashMap.put("living_pass_mouth_num", this.livingPassMouthNum + "");
        }
        if (this.livingPassType != TYPE_STRING_DEFAULT && this.isLivenessSuc) {
            hashMap.put("living_pass_type", this.livingPassType + "");
        }
        if (this.livingPassPeriod != TYPE_STRING_DEFAULT) {
            hashMap.put("living_pass_period", this.livingPassPeriod + "");
        }
        if (this.getIDLPicture != -1) {
            hashMap.put("get_idl_pic", this.getIDLPicture + "");
        }
        if (this.faceMatchType != TYPE_STRING_DEFAULT) {
            hashMap.put("face_match_type", this.faceMatchType + "");
        }
        if (this.clickCloseType != TYPE_STRING_DEFAULT) {
            hashMap.put("click_close_type", this.clickCloseType + "");
        }
        if (this.clickVoiceType != TYPE_STRING_DEFAULT) {
            hashMap.put("click_voice_type", this.clickVoiceType + "");
        }
        if (this.tipLightLowNum != 0) {
            hashMap.put("tip_light_low_num", this.tipLightLowNum + "");
        }
        if (this.tipDistanceNearNum != 0) {
            hashMap.put("tip_distance_near_num", this.tipDistanceNearNum + "");
        }
        if (this.tipDistanceFarNum != 0) {
            hashMap.put("tip_distance_far_num", this.tipDistanceFarNum + "");
        }
        if (this.tipEyeSlopeNum != 0) {
            hashMap.put("tip_eye_slope_num", this.tipEyeSlopeNum + "");
        }
        if (this.tipPutFaceRoundNum != 0) {
            hashMap.put("tip_put_face_round_num", this.tipPutFaceRoundNum + "");
        }
        if (this.tipOverTime != -1) {
            hashMap.put("tip_overtime", this.tipOverTime + "");
        }
        if (this.tipOverTimeCancel != -1) {
            hashMap.put("tip_overtime_cancel", this.tipOverTimeCancel + "");
        }
        if (this.tipOverTimeRetry != -1) {
            hashMap.put("tip_overtime_retry", this.tipOverTimeRetry + "");
        }
        if (this.tipOverTimeAgain != -1) {
            hashMap.put("tip_overtime_again", this.tipOverTimeAgain + "");
        }
        if (this.tipOverTimeSure != -1) {
            hashMap.put("tip_overtime_sure", this.tipOverTimeSure + "");
        }
        if (this.timePointCameraReady != 0) {
            hashMap.put("time_camera_ready", (this.timePointCameraReady - this.timePointStartRecog) + "");
        }
        if (this.timePointFindFaceDone != 0) {
            hashMap.put("time_find_face", (this.timePointFindFaceDone - this.timePointStartFindFace) + "");
        }
        if (this.timePointLivingMouthStart != 0 && this.timePointLivingMouthPass != 0) {
            hashMap.put("time_mouth_pass", (this.timePointLivingMouthPass - this.timePointLivingMouthStart) + "");
        } else if (this.timePointLivingEyeStart != 0 && this.timePointLivingEyePass != 0) {
            Log.w(TAG, "timePointLivingEyePass:" + this.timePointLivingEyePass + ",timePointStartFindFace" + this.timePointLivingEyeStart);
            hashMap.put("time_eyes_pass", (this.timePointLivingEyePass - this.timePointLivingEyeStart) + "");
        }
        if (this.timePointIdlTrackTimeAll != 0 && this.timePointIdlTrackCounts != 0) {
            hashMap.put("time_idl_face_track", (this.timePointIdlTrackTimeAll / this.timePointIdlTrackCounts) + "");
        }
        if (this.timePointLivingMouthPass != 0) {
            hashMap.put("time_contrast", (this.timePointEnd - this.timePointLivingMouthPass) + "");
        } else if (this.timePointLivingEyePass != 0) {
            hashMap.put("time_contrast", (this.timePointEnd - this.timePointLivingEyePass) + "");
        }
        if (this.whiteBg != -1) {
            hashMap.put("white_bg", this.whiteBg + "");
        }
        hashMap.put("illum", this.illumValue + "");
        hashMap.put("time_whole", (this.timePointEnd - this.timePointStart) + "");
        hashMap.put(WXLoginActivity.KEY_BASE_RESP_ERROR_CODE, this.errCode + "");
        hashMap.put("recog_type", this.recogType);
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        hashMap.put("screen_size", defaultDisplay.getWidth() + Constants.ACCEPT_TIME_SEPARATOR_SP + defaultDisplay.getHeight());
        hashMap.put("os_ver", PassBiometricUtil.getOSVersion());
        if (!TextUtils.isEmpty(this.subPro)) {
            hashMap.put("subpro", this.subPro);
        }
        hashMap.put("net_type", NetworkUtils.getNetworkClass(context));
        if (!TextUtils.isEmpty(this.previewSize)) {
            hashMap.put("pre_size", this.previewSize);
        }
        Log.w(TAG, "onStat|map|" + new JSONObject(hashMap));
        StatService.onEvent(context, KEY_NAME_LIVENESS_STAT, hashMap);
    }
}
