package com.baidu.pass.biometrics.base.dynamicupdate;

import android.text.TextUtils;
import com.baidu.pass.biometrics.base.debug.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SdkConfigOptions {
    public static final String TAG = "SdkConfigOptions";

    /* renamed from: a  reason: collision with root package name */
    public static final String f9086a = "liveness_config_option";
    public LivenessConfigOption livenessConfigOption = new LivenessConfigOption();

    public static SdkConfigOptions fromLocalJson(JSONObject jSONObject) {
        SdkConfigOptions sdkConfigOptions = new SdkConfigOptions();
        sdkConfigOptions.livenessConfigOption = LivenessConfigOption.fromJson(jSONObject.optJSONObject(f9086a));
        return sdkConfigOptions;
    }

    public static SdkConfigOptions fromOnLineJSON(JSONObject jSONObject) {
        SdkConfigOptions sdkConfigOptions = new SdkConfigOptions();
        sdkConfigOptions.livenessConfigOption = LivenessConfigOption.fromJson(jSONObject);
        return sdkConfigOptions;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f9086a, this.livenessConfigOption == null ? "" : this.livenessConfigOption.toJSON());
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public String toString() {
        return "SdkConfigOptions{livenessConfigOption=" + this.livenessConfigOption + '}';
    }

    /* loaded from: classes2.dex */
    public static class LivenessConfigOption {
        public static final String A = "recog_upload_portrait_count";
        public static final String B = "white_bg_illum_thr";
        public static final String C = "abtest_illum_list";
        public static final String D = "action";
        public static final int DEFAULT_MIN_FACE_SIZE = 100;
        public static final int DEFAULT_ORIGIN_IMG = 10000;
        public static final int DEFAULT_PITCH = 15;
        public static final int DEFAULT_ROLL = 15;
        public static final int DEFAULT_YAW = 15;
        public static final int E = 40;
        public static final int F = 300;
        public static final int G = 300;
        public static final int H = 3;
        public static final int I = 300;
        public static final int J = 256;
        public static final int K = 3;
        public static final int L = 10;
        public static final int LIVENESS_RECOG_TYPE_BLINK = 1;
        public static final int LIVENESS_RECOG_TYPE_OPEN_MOUTH = 2;
        public static final int M = 6;
        public static final int N = 3;
        public static final String l = "min_face_size";
        public static final String m = "illum_thr";
        public static final String n = "track_interval";
        public static final String o = "detect_interval";
        public static final String p = "yaw";
        public static final String q = "pitch";
        public static final String r = "roll";
        public static final String s = "origin_img";
        public static final String t = "max_reg_img_num";
        public static final String u = "prefetch_reg_img_interval";
        public static final String v = "crop_face_size";
        public static final String w = "crop_face_ratio";
        public static final String x = "switch_record_video";
        public static final String y = "recog_action_type";
        public static final String z = "recog_time_interval";
        public String recogActionType;
        public String recogTimeInterval;
        public String recogUploadPortraitCount;
        public String switchRecordVideo;
        public int whiteBgIllumThr;
        public List<Integer> illumList = new ArrayList();
        public String minFaceSize = String.valueOf(100);

        /* renamed from: a  reason: collision with root package name */
        public String f9087a = String.valueOf(40);

        /* renamed from: b  reason: collision with root package name */
        public String f9088b = String.valueOf(300);

        /* renamed from: c  reason: collision with root package name */
        public String f9089c = String.valueOf(300);

        /* renamed from: d  reason: collision with root package name */
        public String f9090d = String.valueOf(15);

        /* renamed from: e  reason: collision with root package name */
        public String f9091e = String.valueOf(15);

        /* renamed from: f  reason: collision with root package name */
        public String f9092f = String.valueOf(15);

        /* renamed from: g  reason: collision with root package name */
        public String f9093g = String.valueOf(10000);

        /* renamed from: h  reason: collision with root package name */
        public String f9094h = String.valueOf(3);
        public String i = String.valueOf(300);
        public String j = String.valueOf(3);
        public String k = String.valueOf(256);
        public List<Integer> action = new ArrayList();

        public static void a(JSONArray jSONArray, List<Integer> list) {
            if (jSONArray != null) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    if (!TextUtils.isEmpty(jSONArray.optString(i))) {
                        list.add(Integer.valueOf(jSONArray.optInt(i)));
                    }
                }
            }
        }

        public static LivenessConfigOption fromJson(JSONObject jSONObject) {
            LivenessConfigOption livenessConfigOption = new LivenessConfigOption();
            if (jSONObject == null) {
                return livenessConfigOption;
            }
            livenessConfigOption.minFaceSize = jSONObject.optString(l);
            livenessConfigOption.f9087a = jSONObject.optString(m);
            livenessConfigOption.f9088b = jSONObject.optString(n);
            livenessConfigOption.f9089c = jSONObject.optString(o);
            livenessConfigOption.f9090d = jSONObject.optString(p);
            livenessConfigOption.f9091e = jSONObject.optString(q);
            livenessConfigOption.f9092f = jSONObject.optString("roll");
            livenessConfigOption.f9093g = jSONObject.optString(s);
            livenessConfigOption.f9094h = jSONObject.optString(t);
            livenessConfigOption.i = jSONObject.optString(u);
            livenessConfigOption.j = jSONObject.optString(v);
            livenessConfigOption.k = jSONObject.optString(w);
            livenessConfigOption.switchRecordVideo = jSONObject.optString(x);
            livenessConfigOption.recogActionType = jSONObject.optString(y);
            livenessConfigOption.recogTimeInterval = jSONObject.optString(z);
            livenessConfigOption.recogUploadPortraitCount = jSONObject.optString(A);
            livenessConfigOption.whiteBgIllumThr = jSONObject.optInt(B, 10);
            a(jSONObject.optJSONArray(C), livenessConfigOption.illumList);
            a(jSONObject.optJSONArray("action"), livenessConfigOption.action);
            return livenessConfigOption;
        }

        public List<Integer> getABtestIllumList() {
            List<Integer> asList = Arrays.asList(6, 8, 10);
            List<Integer> list = this.illumList;
            return (list == null || list.isEmpty()) ? asList : this.illumList;
        }

        public int getCropFaceRatio() {
            if (!TextUtils.isEmpty(this.k)) {
                try {
                    int parseInt = Integer.parseInt(this.k);
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
            if (!TextUtils.isEmpty(this.j)) {
                try {
                    int parseInt = Integer.parseInt(this.j);
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
            if (!TextUtils.isEmpty(this.f9089c)) {
                try {
                    int parseInt = Integer.parseInt(this.f9089c);
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
            if (!TextUtils.isEmpty(this.f9087a)) {
                try {
                    int parseInt = Integer.parseInt(this.f9087a);
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
            if (!TextUtils.isEmpty(this.f9094h)) {
                try {
                    int parseInt = Integer.parseInt(this.f9094h);
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

        public String getOriginImg() {
            return this.f9093g;
        }

        public int getOriginImgRandomControl() {
            return new Random().nextInt(10000);
        }

        public int getPitch() {
            if (!TextUtils.isEmpty(this.f9091e)) {
                try {
                    int parseInt = Integer.parseInt(this.f9091e);
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
            if (!TextUtils.isEmpty(this.i)) {
                try {
                    int parseInt = Integer.parseInt(this.i);
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
                if (TextUtils.isEmpty(this.recogActionType)) {
                    return 1;
                }
                return Integer.valueOf(this.recogActionType).intValue();
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
                return 1;
            }
        }

        public int getRecogUploadPortraitCount(int i) {
            try {
                if (TextUtils.isEmpty(this.recogUploadPortraitCount)) {
                    return 3;
                }
                return Math.min(i, Math.max(1, Integer.valueOf(this.recogUploadPortraitCount).intValue()));
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
                return 3;
            }
        }

        public int getRecogtimeInterval() {
            try {
                if (TextUtils.isEmpty(this.recogTimeInterval)) {
                    return 6;
                }
                return Integer.valueOf(this.recogTimeInterval).intValue();
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
                return 6;
            }
        }

        public int getRoll() {
            if (!TextUtils.isEmpty(this.f9092f)) {
                try {
                    int parseInt = Integer.parseInt(this.f9092f);
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
            if (!TextUtils.isEmpty(this.f9088b)) {
                try {
                    int parseInt = Integer.parseInt(this.f9088b);
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
            if (!TextUtils.isEmpty(this.f9090d)) {
                try {
                    int parseInt = Integer.parseInt(this.f9090d);
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

        public boolean isOriginImg() {
            if (TextUtils.isEmpty(getOriginImg())) {
                return true;
            }
            try {
                return getOriginImgRandomControl() < Integer.parseInt(getOriginImg());
            } catch (Exception unused) {
                Log.e("SdkConfigOptions", "origin_img config is not integer");
                return false;
            }
        }

        public JSONObject toJSON() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(l, this.minFaceSize);
                jSONObject.put(m, this.f9087a);
                jSONObject.put(n, this.f9088b);
                jSONObject.put(o, this.f9089c);
                jSONObject.put(p, this.f9090d);
                jSONObject.put(q, this.f9091e);
                jSONObject.put("roll", this.f9092f);
                jSONObject.put(s, this.f9093g);
                jSONObject.put(t, this.f9094h);
                jSONObject.put(u, this.i);
                jSONObject.put(v, this.j);
                jSONObject.put(w, this.k);
                jSONObject.put(x, this.switchRecordVideo);
                jSONObject.put(y, this.recogActionType);
                jSONObject.put(z, this.recogTimeInterval);
                jSONObject.put(A, this.recogUploadPortraitCount);
                jSONObject.put(B, this.whiteBgIllumThr);
                a(jSONObject, C, this.illumList);
                a(jSONObject, "action", this.action);
                return jSONObject;
            } catch (JSONException e2) {
                Log.e(e2);
                return null;
            }
        }

        public String toString() {
            return "LivenessConfigOption{illumList=" + this.illumList + ", minFaceSize='" + this.minFaceSize + "', illumThr='" + this.f9087a + "', trackInterval='" + this.f9088b + "', detectInterval='" + this.f9089c + "', yaw='" + this.f9090d + "', pitch='" + this.f9091e + "', roll='" + this.f9092f + "', originImg='" + this.f9093g + "', maxRegImgNum='" + this.f9094h + "', prefetchRegImgInterval='" + this.i + "', cropFaceSize='" + this.j + "', cropFaceRatio='" + this.k + "', switchRecordVideo='" + this.switchRecordVideo + "', recogActionType='" + this.recogActionType + "', recogTimeInterval='" + this.recogTimeInterval + "', recogUploadPortraitCount='" + this.recogUploadPortraitCount + "', whiteBgIllumThr=" + this.whiteBgIllumThr + ", action=" + this.action + '}';
        }

        public static void a(JSONObject jSONObject, String str, List<Integer> list) throws JSONException {
            JSONArray jSONArray = new JSONArray();
            for (Integer num : list) {
                jSONArray.put(num.intValue());
            }
            jSONObject.put(str, jSONArray);
        }
    }
}
