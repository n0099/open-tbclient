package com.baidu.pass.biometrics.base.dynamicupdate;

import android.text.TextUtils;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class SdkConfigOptions {
    public static final String HOST_VERSION = "3.0.0";
    private static final String KEY_DISTRIBUTED_SDK = "distributedSdk";
    private static final String KEY_GLOBAL_ENABLE = "so_global_enable";
    private static final String KEY_GRAY = "gray";
    private static final String KEY_HOST_VERSION = "host_version";
    private static final String KEY_LIVENESS_CONFIG_OPTION = "liveness_config_option";
    private static final String KEY_SO_CPU = "cpu";
    private static final String KEY_SO_ENABLE = "enable";
    private static final String KEY_SO_FILE = "file";
    private static final String KEY_SO_FILES = "files";
    private static final String KEY_SO_LIST = "face_sdk";
    private static final String KEY_UPDATE_FAIL = "updateFail";
    private static final String KEY_ZIP_VERSION = "zip_version";
    public static final String TAG = "SdkConfigOptions";
    public DistributedFile distributedSdk;
    public boolean enable;
    public boolean globalEnable;
    public int grayThreshold;
    public String hostVersion;
    public LivenessConfigOption livenessConfigOption = new LivenessConfigOption();
    public boolean updateFail;
    public String zipVersion;

    /* JADX WARN: Code restructure failed: missing block: B:24:0x009e, code lost:
        r0.distributedSdk = com.baidu.pass.biometrics.base.dynamicupdate.SdkConfigOptions.DistributedFile.fromJSON(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SdkConfigOptions fromOnLineJSON(JSONObject jSONObject) {
        JSONObject jSONObject2;
        int i = 0;
        SdkConfigOptions sdkConfigOptions = new SdkConfigOptions();
        sdkConfigOptions.livenessConfigOption = LivenessConfigOption.fromJson(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray(KEY_SO_LIST);
        if (optJSONArray != null) {
            try {
                int length = optJSONArray.length();
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        jSONObject2 = null;
                        break;
                    }
                    jSONObject2 = optJSONArray.getJSONObject(i2);
                    if (jSONObject2 != null && HOST_VERSION.equals(jSONObject2.optString("host_version"))) {
                        break;
                    }
                    i2++;
                }
                if (jSONObject2 != null) {
                    sdkConfigOptions.globalEnable = jSONObject.optBoolean(KEY_GLOBAL_ENABLE, true);
                    sdkConfigOptions.hostVersion = jSONObject2.optString("host_version");
                    sdkConfigOptions.zipVersion = jSONObject2.optString("zip_version");
                    sdkConfigOptions.enable = jSONObject2.optBoolean("enable", true);
                    sdkConfigOptions.grayThreshold = jSONObject2.optInt("gray");
                    JSONArray jSONArray = jSONObject2.optJSONObject("files").getJSONArray("file");
                    if (jSONArray != null) {
                        String cpuType = PassBiometricUtil.getCpuType();
                        if ("armeabi".equals(cpuType)) {
                            cpuType = "armeabi-v7a";
                        }
                        int length2 = jSONArray.length();
                        while (true) {
                            if (i < length2) {
                                JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                                if (jSONObject3 != null && cpuType.equals(jSONObject3.optString("cpu"))) {
                                    break;
                                }
                                i++;
                            } else {
                                break;
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                Log.e("SdkConfigOptions", e);
            }
        }
        return sdkConfigOptions;
    }

    public static SdkConfigOptions fromLocalJson(JSONObject jSONObject) {
        SdkConfigOptions sdkConfigOptions = new SdkConfigOptions();
        sdkConfigOptions.hostVersion = jSONObject.optString("host_version");
        sdkConfigOptions.zipVersion = jSONObject.optString("zip_version");
        sdkConfigOptions.updateFail = jSONObject.optBoolean("updateFail");
        sdkConfigOptions.globalEnable = jSONObject.optBoolean(KEY_GLOBAL_ENABLE);
        sdkConfigOptions.enable = jSONObject.optBoolean("enable");
        sdkConfigOptions.grayThreshold = jSONObject.optInt("gray");
        sdkConfigOptions.distributedSdk = DistributedFile.fromJSON(jSONObject.optJSONObject("distributedSdk"));
        sdkConfigOptions.livenessConfigOption = LivenessConfigOption.fromJson(jSONObject.optJSONObject(KEY_LIVENESS_CONFIG_OPTION));
        return sdkConfigOptions;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(HOST_VERSION, this.hostVersion);
            jSONObject.put("zip_version", this.zipVersion);
            jSONObject.put("updateFail", this.updateFail);
            jSONObject.put(KEY_GLOBAL_ENABLE, this.globalEnable);
            jSONObject.put("enable", this.enable);
            jSONObject.put("gray", this.grayThreshold);
            jSONObject.put("distributedSdk", this.distributedSdk == null ? "" : this.distributedSdk.toJSON());
            jSONObject.put(KEY_LIVENESS_CONFIG_OPTION, this.livenessConfigOption == null ? "" : this.livenessConfigOption.toJSON());
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    /* loaded from: classes6.dex */
    public static class DistributedFile {
        private static final String KEY_FILE_DOWNLOAD_URL = "url";
        private static final String KEY_FILE_HASH = "hash";
        private static final String KEY_FILE_NAME = "name";
        public String fileName = null;
        public String downloadUrl = null;
        public String hash = null;

        public static DistributedFile fromJSON(JSONObject jSONObject) {
            DistributedFile distributedFile = new DistributedFile();
            if (jSONObject != null) {
                distributedFile.fileName = jSONObject.optString("name");
                distributedFile.downloadUrl = jSONObject.optString("url");
                distributedFile.hash = jSONObject.optString(KEY_FILE_HASH);
            }
            return distributedFile;
        }

        public JSONObject toJSON() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", this.fileName);
                jSONObject.put("url", this.downloadUrl);
                jSONObject.put(KEY_FILE_HASH, this.hash);
                return jSONObject;
            } catch (JSONException e) {
                Log.e(e);
                return null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class LivenessConfigOption {
        private static final String CROP_FACE_RATIO = "crop_face_ratio";
        private static final String CROP_FACE_SIZE = "crop_face_size";
        private static final int DEFAULT_CROP_FACE_RATIO = 3;
        private static final int DEFAULT_CROP_FACE_SIZE = 256;
        private static final int DEFAULT_DETECT_INTERVAL = 300;
        private static final int DEFAULT_FIRST_LIVENESS_RECOG_TIME = 6;
        private static final int DEFAULT_ILLUM_THR = 40;
        private static final int DEFAULT_MAX_REG_IMG_NUM = 3;
        public static final int DEFAULT_MIN_FACE_SIZE = 100;
        public static final int DEFAULT_PITCH = 15;
        private static final int DEFAULT_PREFETCH_REG_IMG_INTERVAL = 300;
        private static final int DEFAULT_RECOG_UPLOAD_PORTRAIT_COUNT = 3;
        private static final int DEFAULT_ROLL = 15;
        private static final int DEFAULT_TRACK_INTERVAL = 300;
        private static final int DEFAULT_WHITE_BG_ILLUM_THR = 10;
        public static final int DEFAULT_YAW = 15;
        private static final String DETECT_INTERVAL = "detect_interval";
        private static final String ILLUM_THR = "illum_thr";
        private static final String KEY_ABTEST_ILLUM_LIST = "abtest_illum_list";
        private static final String KEY_CLOSE_SKIP_LIVING = "close_skip_living";
        private static final String KEY_WHITE_BG_ILLUM_THR = "white_bg_illum_thr";
        public static final int LIVENESS_RECOG_TYPE_BLINK = 1;
        public static final int LIVENESS_RECOG_TYPE_OPEN_MOUTH = 2;
        private static final String MAX_REG_IMG_NUM = "max_reg_img_num";
        private static final String MIN_FACE_SIZE = "min_face_size";
        private static final String PITCH_RANGE = "pitch";
        private static final String PREFETCH_REG_IMG_INTERVAL = "prefetch_reg_img_interval";
        private static final String RECOG_ACTION_TYPE = "recog_action_type";
        private static final String RECOG_TIME_INTERVAL = "recog_time_interval";
        private static final String RECOG_UPLOAD_PORTRAIT_COUNT = "recog_upload_portrait_count";
        private static final String ROLL_RANGE = "roll";
        private static final String SWITCH_RECORD_VIDEO = "switch_record_video";
        private static final String TRACK_INTERVAL = "track_interval";
        private static final String YAW_RANGE = "yaw";
        public String recogActionType;
        public String recogTimeInterval;
        public String recogUploadPortraitCount;
        public String switchRecordVideo;
        public int whiteBgIllumThr;
        public List<Integer> illumList = new ArrayList();
        public String minFaceSize = String.valueOf(100);
        private String illumThr = String.valueOf(40);
        private String trackInterval = String.valueOf(300);
        private String detectInterval = String.valueOf(300);
        private String yaw = String.valueOf(15);
        private String pitch = String.valueOf(15);
        private String roll = String.valueOf(15);
        private String maxRegImgNum = String.valueOf(3);
        private String prefetchRegImgInterval = String.valueOf(300);
        private String cropFaceSize = String.valueOf(3);
        private String cropFaceRatio = String.valueOf(256);
        public boolean closeSkipLiving = false;

        public static LivenessConfigOption fromJson(JSONObject jSONObject) {
            LivenessConfigOption livenessConfigOption = new LivenessConfigOption();
            if (jSONObject != null) {
                livenessConfigOption.minFaceSize = jSONObject.optString(MIN_FACE_SIZE);
                livenessConfigOption.illumThr = jSONObject.optString(ILLUM_THR);
                livenessConfigOption.trackInterval = jSONObject.optString(TRACK_INTERVAL);
                livenessConfigOption.detectInterval = jSONObject.optString(DETECT_INTERVAL);
                livenessConfigOption.yaw = jSONObject.optString(YAW_RANGE);
                livenessConfigOption.pitch = jSONObject.optString(PITCH_RANGE);
                livenessConfigOption.roll = jSONObject.optString("roll");
                livenessConfigOption.maxRegImgNum = jSONObject.optString(MAX_REG_IMG_NUM);
                livenessConfigOption.prefetchRegImgInterval = jSONObject.optString(PREFETCH_REG_IMG_INTERVAL);
                livenessConfigOption.cropFaceSize = jSONObject.optString(CROP_FACE_SIZE);
                livenessConfigOption.cropFaceRatio = jSONObject.optString(CROP_FACE_RATIO);
                livenessConfigOption.switchRecordVideo = jSONObject.optString(SWITCH_RECORD_VIDEO);
                livenessConfigOption.recogActionType = jSONObject.optString(RECOG_ACTION_TYPE);
                livenessConfigOption.recogTimeInterval = jSONObject.optString(RECOG_TIME_INTERVAL);
                livenessConfigOption.recogUploadPortraitCount = jSONObject.optString(RECOG_UPLOAD_PORTRAIT_COUNT);
                livenessConfigOption.whiteBgIllumThr = jSONObject.optInt(KEY_WHITE_BG_ILLUM_THR, 10);
                livenessConfigOption.closeSkipLiving = jSONObject.optBoolean(KEY_CLOSE_SKIP_LIVING, false);
                setJsonArrayToList(jSONObject.optJSONArray(KEY_ABTEST_ILLUM_LIST), livenessConfigOption.illumList);
            }
            return livenessConfigOption;
        }

        public JSONObject toJSON() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(MIN_FACE_SIZE, this.minFaceSize);
                jSONObject.put(ILLUM_THR, this.illumThr);
                jSONObject.put(TRACK_INTERVAL, this.trackInterval);
                jSONObject.put(DETECT_INTERVAL, this.detectInterval);
                jSONObject.put(YAW_RANGE, this.yaw);
                jSONObject.put(PITCH_RANGE, this.pitch);
                jSONObject.put("roll", this.roll);
                jSONObject.put(MAX_REG_IMG_NUM, this.maxRegImgNum);
                jSONObject.put(PREFETCH_REG_IMG_INTERVAL, this.prefetchRegImgInterval);
                jSONObject.put(CROP_FACE_SIZE, this.cropFaceSize);
                jSONObject.put(CROP_FACE_RATIO, this.cropFaceRatio);
                jSONObject.put(SWITCH_RECORD_VIDEO, this.switchRecordVideo);
                jSONObject.put(RECOG_ACTION_TYPE, this.recogActionType);
                jSONObject.put(RECOG_TIME_INTERVAL, this.recogTimeInterval);
                jSONObject.put(RECOG_UPLOAD_PORTRAIT_COUNT, this.recogUploadPortraitCount);
                jSONObject.put(KEY_WHITE_BG_ILLUM_THR, this.whiteBgIllumThr);
                jSONObject.put(KEY_CLOSE_SKIP_LIVING, this.closeSkipLiving);
                setListToJsonArray(jSONObject, KEY_ABTEST_ILLUM_LIST, this.illumList);
                return jSONObject;
            } catch (JSONException e) {
                Log.e(e);
                return null;
            }
        }

        private static void setJsonArrayToList(JSONArray jSONArray, List<Integer> list) {
            if (jSONArray != null) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    if (!TextUtils.isEmpty(jSONArray.optString(i))) {
                        list.add(Integer.valueOf(jSONArray.optInt(i)));
                    }
                }
            }
        }

        private static void setListToJsonArray(JSONObject jSONObject, String str, List<Integer> list) throws JSONException {
            JSONArray jSONArray = new JSONArray();
            for (Integer num : list) {
                jSONArray.put(num.intValue());
            }
            jSONObject.put(str, jSONArray);
        }

        public int getMinFaceSize() {
            if (!TextUtils.isEmpty(this.minFaceSize)) {
                try {
                    int parseInt = Integer.parseInt(this.minFaceSize);
                    if (parseInt < 30 || parseInt > 200) {
                        return 100;
                    }
                    return parseInt;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            return 100;
        }

        public int getIllumThr() {
            if (!TextUtils.isEmpty(this.illumThr)) {
                try {
                    int parseInt = Integer.parseInt(this.illumThr);
                    if (parseInt < 0 || parseInt > 255) {
                        return 40;
                    }
                    return parseInt;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            return 40;
        }

        public int getTrackInterval() {
            if (!TextUtils.isEmpty(this.trackInterval)) {
                try {
                    int parseInt = Integer.parseInt(this.trackInterval);
                    if (parseInt < 100 || parseInt > 300) {
                        return 300;
                    }
                    return parseInt;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            return 300;
        }

        public int getDetectInterval() {
            if (!TextUtils.isEmpty(this.detectInterval)) {
                try {
                    int parseInt = Integer.parseInt(this.detectInterval);
                    if (parseInt < 100 || parseInt > 500) {
                        return 300;
                    }
                    return parseInt;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            return 300;
        }

        public int getYaw() {
            if (!TextUtils.isEmpty(this.yaw)) {
                try {
                    int parseInt = Integer.parseInt(this.yaw);
                    if (parseInt < 10 || parseInt > 15) {
                        return 15;
                    }
                    return parseInt;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            return 15;
        }

        public int getPitch() {
            if (!TextUtils.isEmpty(this.pitch)) {
                try {
                    int parseInt = Integer.parseInt(this.pitch);
                    if (parseInt < 10 || parseInt > 15) {
                        return 15;
                    }
                    return parseInt;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            return 15;
        }

        public int getRoll() {
            if (!TextUtils.isEmpty(this.roll)) {
                try {
                    int parseInt = Integer.parseInt(this.roll);
                    if (parseInt < 10 || parseInt > 15) {
                        return 15;
                    }
                    return parseInt;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            return 15;
        }

        public int getMaxRegImgNum() {
            if (!TextUtils.isEmpty(this.maxRegImgNum)) {
                try {
                    int parseInt = Integer.parseInt(this.maxRegImgNum);
                    if (parseInt < 1 || parseInt > 3) {
                        return 3;
                    }
                    return parseInt;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            return 3;
        }

        public int getPrefetchRegImgInterval() {
            if (!TextUtils.isEmpty(this.prefetchRegImgInterval)) {
                try {
                    int parseInt = Integer.parseInt(this.prefetchRegImgInterval);
                    if (parseInt < 100 || parseInt > 300) {
                        return 300;
                    }
                    return parseInt;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            return 300;
        }

        public int getCropFaceSize() {
            if (!TextUtils.isEmpty(this.cropFaceSize)) {
                try {
                    int parseInt = Integer.parseInt(this.cropFaceSize);
                    if (parseInt < 256 || parseInt > 768) {
                        return 256;
                    }
                    return parseInt;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            return 256;
        }

        public int getCropFaceRatio() {
            if (!TextUtils.isEmpty(this.cropFaceRatio)) {
                try {
                    int parseInt = Integer.parseInt(this.cropFaceRatio);
                    if (parseInt < 1 || parseInt > 3) {
                        return 3;
                    }
                    return parseInt;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            return 3;
        }

        public int getRecogtimeInterval() {
            try {
                if (!TextUtils.isEmpty(this.recogTimeInterval)) {
                    return Integer.valueOf(this.recogTimeInterval).intValue();
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            return 6;
        }

        public int getRecogActionType() {
            try {
                if (!TextUtils.isEmpty(this.recogActionType)) {
                    return Integer.valueOf(this.recogActionType).intValue();
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            return 1;
        }

        public int getRecogUploadPortraitCount(int i) {
            try {
                if (!TextUtils.isEmpty(this.recogUploadPortraitCount)) {
                    return Math.min(i, Math.max(1, Integer.valueOf(this.recogUploadPortraitCount).intValue()));
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            return 3;
        }

        public List<Integer> getABtestIllumList() {
            List<Integer> asList = Arrays.asList(6, 8, 10);
            return (this.illumList == null || this.illumList.isEmpty()) ? asList : this.illumList;
        }
    }
}
