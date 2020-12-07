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
/* loaded from: classes9.dex */
public class SdkConfigOptions {
    public static final String HOST_VERSION = "3.0.0";
    public static final String TAG = "SdkConfigOptions";

    /* renamed from: a  reason: collision with root package name */
    private static final String f2698a = "face_sdk";
    private static final String b = "host_version";
    private static final String c = "zip_version";
    private static final String d = "updateFail";
    private static final String e = "distributedSdk";
    private static final String f = "liveness_config_option";
    private static final String g = "files";
    private static final String h = "file";
    private static final String i = "cpu";
    private static final String j = "so_global_enable";
    private static final String k = "enable";
    private static final String l = "gray";
    public DistributedFile distributedSdk;
    public boolean enable;
    public boolean globalEnable;
    public int grayThreshold;
    public String hostVersion;
    public LivenessConfigOption livenessConfigOption = new LivenessConfigOption();
    public boolean updateFail;
    public String zipVersion;

    /* loaded from: classes9.dex */
    public static class DistributedFile {

        /* renamed from: a  reason: collision with root package name */
        private static final String f2699a = "name";
        private static final String b = "url";
        private static final String c = "hash";
        public String fileName = null;
        public String downloadUrl = null;
        public String hash = null;

        public static DistributedFile fromJSON(JSONObject jSONObject) {
            DistributedFile distributedFile = new DistributedFile();
            if (jSONObject != null) {
                distributedFile.fileName = jSONObject.optString("name");
                distributedFile.downloadUrl = jSONObject.optString("url");
                distributedFile.hash = jSONObject.optString(c);
            }
            return distributedFile;
        }

        public JSONObject toJSON() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", this.fileName);
                jSONObject.put("url", this.downloadUrl);
                jSONObject.put(c, this.hash);
                return jSONObject;
            } catch (JSONException e) {
                Log.e(e);
                return null;
            }
        }
    }

    public static SdkConfigOptions fromLocalJson(JSONObject jSONObject) {
        SdkConfigOptions sdkConfigOptions = new SdkConfigOptions();
        sdkConfigOptions.hostVersion = jSONObject.optString("host_version");
        sdkConfigOptions.zipVersion = jSONObject.optString("zip_version");
        sdkConfigOptions.updateFail = jSONObject.optBoolean("updateFail");
        sdkConfigOptions.globalEnable = jSONObject.optBoolean(j);
        sdkConfigOptions.enable = jSONObject.optBoolean("enable");
        sdkConfigOptions.grayThreshold = jSONObject.optInt("gray");
        sdkConfigOptions.distributedSdk = DistributedFile.fromJSON(jSONObject.optJSONObject("distributedSdk"));
        sdkConfigOptions.livenessConfigOption = LivenessConfigOption.fromJson(jSONObject.optJSONObject(f));
        return sdkConfigOptions;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a9, code lost:
        r1.distributedSdk = com.baidu.pass.biometrics.base.dynamicupdate.SdkConfigOptions.DistributedFile.fromJSON(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SdkConfigOptions fromOnLineJSON(JSONObject jSONObject) {
        JSONObject jSONObject2;
        int i2 = 0;
        SdkConfigOptions sdkConfigOptions = new SdkConfigOptions();
        sdkConfigOptions.livenessConfigOption = LivenessConfigOption.fromJson(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray(f2698a);
        if (optJSONArray == null) {
            return sdkConfigOptions;
        }
        try {
            int length = optJSONArray.length();
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    jSONObject2 = null;
                    break;
                }
                jSONObject2 = optJSONArray.getJSONObject(i3);
                if (jSONObject2 != null && HOST_VERSION.equals(jSONObject2.optString("host_version"))) {
                    break;
                }
                i3++;
            }
        } catch (JSONException e2) {
            Log.e("SdkConfigOptions", e2);
        }
        if (jSONObject2 == null) {
            return sdkConfigOptions;
        }
        sdkConfigOptions.globalEnable = jSONObject.optBoolean(j, true);
        sdkConfigOptions.hostVersion = jSONObject2.optString("host_version");
        sdkConfigOptions.zipVersion = jSONObject2.optString("zip_version");
        sdkConfigOptions.enable = jSONObject2.optBoolean("enable", true);
        sdkConfigOptions.grayThreshold = jSONObject2.optInt("gray");
        JSONArray jSONArray = jSONObject2.optJSONObject("files").getJSONArray("file");
        if (jSONArray == null) {
            return sdkConfigOptions;
        }
        String cpuType = PassBiometricUtil.getCpuType();
        if ("armeabi".equals(cpuType)) {
            cpuType = "armeabi-v7a";
        }
        int length2 = jSONArray.length();
        while (true) {
            if (i2 < length2) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                if (jSONObject3 != null && cpuType.equals(jSONObject3.optString("cpu"))) {
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        return sdkConfigOptions;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(HOST_VERSION, this.hostVersion);
            jSONObject.put("zip_version", this.zipVersion);
            jSONObject.put("updateFail", this.updateFail);
            jSONObject.put(j, this.globalEnable);
            jSONObject.put("enable", this.enable);
            jSONObject.put("gray", this.grayThreshold);
            jSONObject.put("distributedSdk", this.distributedSdk == null ? "" : this.distributedSdk.toJSON());
            jSONObject.put(f, this.livenessConfigOption == null ? "" : this.livenessConfigOption.toJSON());
            return jSONObject;
        } catch (JSONException e2) {
            return null;
        }
    }

    /* loaded from: classes9.dex */
    public static class LivenessConfigOption {
        private static final int A = 10;
        private static final int B = 6;
        private static final int C = 3;
        public static final int DEFAULT_MIN_FACE_SIZE = 100;
        public static final int DEFAULT_PITCH = 15;
        public static final int DEFAULT_YAW = 15;
        public static final int LIVENESS_RECOG_TYPE_BLINK = 1;
        public static final int LIVENESS_RECOG_TYPE_OPEN_MOUTH = 2;

        /* renamed from: a  reason: collision with root package name */
        private static final String f2700a = "min_face_size";
        private static final String b = "illum_thr";
        private static final String c = "track_interval";
        private static final String d = "detect_interval";
        private static final String e = "yaw";
        private static final String f = "pitch";
        private static final String g = "roll";
        private static final String h = "max_reg_img_num";
        private static final String i = "prefetch_reg_img_interval";
        private static final String j = "crop_face_size";
        private static final String k = "crop_face_ratio";
        private static final String l = "switch_record_video";
        private static final String m = "recog_action_type";
        private static final String n = "recog_time_interval";
        private static final String o = "recog_upload_portrait_count";
        private static final String p = "white_bg_illum_thr";
        private static final String q = "abtest_illum_list";
        private static final String r = "close_skip_living";
        private static final int s = 40;
        private static final int t = 300;
        private static final int u = 300;
        private static final int v = 15;
        private static final int w = 3;
        private static final int x = 300;
        private static final int y = 256;
        private static final int z = 3;
        public String recogActionType;
        public String recogTimeInterval;
        public String recogUploadPortraitCount;
        public String switchRecordVideo;
        public int whiteBgIllumThr;
        public List<Integer> illumList = new ArrayList();
        public String minFaceSize = String.valueOf(100);
        private String D = String.valueOf(40);
        private String E = String.valueOf(300);
        private String F = String.valueOf(300);
        private String G = String.valueOf(15);
        private String H = String.valueOf(15);
        private String I = String.valueOf(15);
        private String J = String.valueOf(3);
        private String K = String.valueOf(300);
        private String L = String.valueOf(3);
        private String M = String.valueOf(256);
        public boolean closeSkipLiving = false;

        private static void a(JSONArray jSONArray, List<Integer> list) {
            if (jSONArray != null) {
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    if (!TextUtils.isEmpty(jSONArray.optString(i2))) {
                        list.add(Integer.valueOf(jSONArray.optInt(i2)));
                    }
                }
            }
        }

        public static LivenessConfigOption fromJson(JSONObject jSONObject) {
            LivenessConfigOption livenessConfigOption = new LivenessConfigOption();
            if (jSONObject != null) {
                livenessConfigOption.minFaceSize = jSONObject.optString(f2700a);
                livenessConfigOption.D = jSONObject.optString(b);
                livenessConfigOption.E = jSONObject.optString(c);
                livenessConfigOption.F = jSONObject.optString(d);
                livenessConfigOption.G = jSONObject.optString(e);
                livenessConfigOption.H = jSONObject.optString(f);
                livenessConfigOption.I = jSONObject.optString("roll");
                livenessConfigOption.J = jSONObject.optString(h);
                livenessConfigOption.K = jSONObject.optString(i);
                livenessConfigOption.L = jSONObject.optString(j);
                livenessConfigOption.M = jSONObject.optString(k);
                livenessConfigOption.switchRecordVideo = jSONObject.optString(l);
                livenessConfigOption.recogActionType = jSONObject.optString(m);
                livenessConfigOption.recogTimeInterval = jSONObject.optString(n);
                livenessConfigOption.recogUploadPortraitCount = jSONObject.optString(o);
                livenessConfigOption.whiteBgIllumThr = jSONObject.optInt(p, 10);
                livenessConfigOption.closeSkipLiving = jSONObject.optBoolean(r, false);
                a(jSONObject.optJSONArray(q), livenessConfigOption.illumList);
            }
            return livenessConfigOption;
        }

        public List<Integer> getABtestIllumList() {
            List<Integer> asList = Arrays.asList(6, 8, 10);
            List<Integer> list = this.illumList;
            return (list == null || list.isEmpty()) ? asList : this.illumList;
        }

        public int getCropFaceRatio() {
            if (!TextUtils.isEmpty(this.M)) {
                try {
                    int parseInt = Integer.parseInt(this.M);
                    if (parseInt < 1 || parseInt > 3) {
                        return 3;
                    }
                    return parseInt;
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
            return 3;
        }

        public int getCropFaceSize() {
            if (!TextUtils.isEmpty(this.L)) {
                try {
                    int parseInt = Integer.parseInt(this.L);
                    if (parseInt < 256 || parseInt > 768) {
                        return 256;
                    }
                    return parseInt;
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
            return 256;
        }

        public int getDetectInterval() {
            if (!TextUtils.isEmpty(this.F)) {
                try {
                    int parseInt = Integer.parseInt(this.F);
                    if (parseInt < 100 || parseInt > 500) {
                        return 300;
                    }
                    return parseInt;
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
            return 300;
        }

        public int getIllumThr() {
            if (!TextUtils.isEmpty(this.D)) {
                try {
                    int parseInt = Integer.parseInt(this.D);
                    if (parseInt < 0 || parseInt > 255) {
                        return 40;
                    }
                    return parseInt;
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
            return 40;
        }

        public int getMaxRegImgNum() {
            if (!TextUtils.isEmpty(this.J)) {
                try {
                    int parseInt = Integer.parseInt(this.J);
                    if (parseInt < 1 || parseInt > 3) {
                        return 3;
                    }
                    return parseInt;
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
            return 3;
        }

        public int getMinFaceSize() {
            if (!TextUtils.isEmpty(this.minFaceSize)) {
                try {
                    int parseInt = Integer.parseInt(this.minFaceSize);
                    if (parseInt < 30 || parseInt > 200) {
                        return 100;
                    }
                    return parseInt;
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
            return 100;
        }

        public int getPitch() {
            if (!TextUtils.isEmpty(this.H)) {
                try {
                    int parseInt = Integer.parseInt(this.H);
                    if (parseInt < 10 || parseInt > 15) {
                        return 15;
                    }
                    return parseInt;
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
            return 15;
        }

        public int getPrefetchRegImgInterval() {
            if (!TextUtils.isEmpty(this.K)) {
                try {
                    int parseInt = Integer.parseInt(this.K);
                    if (parseInt < 100 || parseInt > 300) {
                        return 300;
                    }
                    return parseInt;
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
            return 300;
        }

        public int getRecogActionType() {
            try {
                if (!TextUtils.isEmpty(this.recogActionType)) {
                    return Integer.valueOf(this.recogActionType).intValue();
                }
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
            return 1;
        }

        public int getRecogUploadPortraitCount(int i2) {
            try {
                if (!TextUtils.isEmpty(this.recogUploadPortraitCount)) {
                    return Math.min(i2, Math.max(1, Integer.valueOf(this.recogUploadPortraitCount).intValue()));
                }
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
            return 3;
        }

        public int getRecogtimeInterval() {
            try {
                if (!TextUtils.isEmpty(this.recogTimeInterval)) {
                    return Integer.valueOf(this.recogTimeInterval).intValue();
                }
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
            return 6;
        }

        public int getRoll() {
            if (!TextUtils.isEmpty(this.I)) {
                try {
                    int parseInt = Integer.parseInt(this.I);
                    if (parseInt < 10 || parseInt > 15) {
                        return 15;
                    }
                    return parseInt;
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
            return 15;
        }

        public int getTrackInterval() {
            if (!TextUtils.isEmpty(this.E)) {
                try {
                    int parseInt = Integer.parseInt(this.E);
                    if (parseInt < 100 || parseInt > 300) {
                        return 300;
                    }
                    return parseInt;
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
            return 300;
        }

        public int getYaw() {
            if (!TextUtils.isEmpty(this.G)) {
                try {
                    int parseInt = Integer.parseInt(this.G);
                    if (parseInt < 10 || parseInt > 15) {
                        return 15;
                    }
                    return parseInt;
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
            return 15;
        }

        public JSONObject toJSON() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(f2700a, this.minFaceSize);
                jSONObject.put(b, this.D);
                jSONObject.put(c, this.E);
                jSONObject.put(d, this.F);
                jSONObject.put(e, this.G);
                jSONObject.put(f, this.H);
                jSONObject.put("roll", this.I);
                jSONObject.put(h, this.J);
                jSONObject.put(i, this.K);
                jSONObject.put(j, this.L);
                jSONObject.put(k, this.M);
                jSONObject.put(l, this.switchRecordVideo);
                jSONObject.put(m, this.recogActionType);
                jSONObject.put(n, this.recogTimeInterval);
                jSONObject.put(o, this.recogUploadPortraitCount);
                jSONObject.put(p, this.whiteBgIllumThr);
                jSONObject.put(r, this.closeSkipLiving);
                a(jSONObject, q, this.illumList);
                return jSONObject;
            } catch (JSONException e2) {
                Log.e(e2);
                return null;
            }
        }

        private static void a(JSONObject jSONObject, String str, List<Integer> list) throws JSONException {
            JSONArray jSONArray = new JSONArray();
            for (Integer num : list) {
                jSONArray.put(num.intValue());
            }
            jSONObject.put(str, jSONArray);
        }
    }
}
