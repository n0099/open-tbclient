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
    public static final String f9420a = "liveness_config_option";
    public LivenessConfigOption livenessConfigOption = new LivenessConfigOption();

    public static SdkConfigOptions fromLocalJson(JSONObject jSONObject) {
        SdkConfigOptions sdkConfigOptions = new SdkConfigOptions();
        sdkConfigOptions.livenessConfigOption = LivenessConfigOption.fromJson(jSONObject.optJSONObject(f9420a));
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
            jSONObject.put(f9420a, this.livenessConfigOption == null ? "" : this.livenessConfigOption.toJSON());
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
        public String f9421a = String.valueOf(40);

        /* renamed from: b  reason: collision with root package name */
        public String f9422b = String.valueOf(300);

        /* renamed from: c  reason: collision with root package name */
        public String f9423c = String.valueOf(300);

        /* renamed from: d  reason: collision with root package name */
        public String f9424d = String.valueOf(15);

        /* renamed from: e  reason: collision with root package name */
        public String f9425e = String.valueOf(15);

        /* renamed from: f  reason: collision with root package name */
        public String f9426f = String.valueOf(15);

        /* renamed from: g  reason: collision with root package name */
        public String f9427g = String.valueOf(10000);

        /* renamed from: h  reason: collision with root package name */
        public String f9428h = String.valueOf(3);

        /* renamed from: i  reason: collision with root package name */
        public String f9429i = String.valueOf(300);
        public String j = String.valueOf(3);
        public String k = String.valueOf(256);
        public List<Integer> action = new ArrayList();

        public static void a(JSONArray jSONArray, List<Integer> list) {
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
            if (jSONObject == null) {
                return livenessConfigOption;
            }
            livenessConfigOption.minFaceSize = jSONObject.optString(l);
            livenessConfigOption.f9421a = jSONObject.optString(m);
            livenessConfigOption.f9422b = jSONObject.optString(n);
            livenessConfigOption.f9423c = jSONObject.optString(o);
            livenessConfigOption.f9424d = jSONObject.optString(p);
            livenessConfigOption.f9425e = jSONObject.optString(q);
            livenessConfigOption.f9426f = jSONObject.optString("roll");
            livenessConfigOption.f9427g = jSONObject.optString(s);
            livenessConfigOption.f9428h = jSONObject.optString(t);
            livenessConfigOption.f9429i = jSONObject.optString(u);
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
            if (!TextUtils.isEmpty(this.f9423c)) {
                try {
                    int parseInt = Integer.parseInt(this.f9423c);
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
            if (!TextUtils.isEmpty(this.f9421a)) {
                try {
                    int parseInt = Integer.parseInt(this.f9421a);
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
            if (!TextUtils.isEmpty(this.f9428h)) {
                try {
                    int parseInt = Integer.parseInt(this.f9428h);
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
            return this.f9427g;
        }

        public int getOriginImgRandomControl() {
            return new Random().nextInt(10000);
        }

        public int getPitch() {
            if (!TextUtils.isEmpty(this.f9425e)) {
                try {
                    int parseInt = Integer.parseInt(this.f9425e);
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
            if (!TextUtils.isEmpty(this.f9429i)) {
                try {
                    int parseInt = Integer.parseInt(this.f9429i);
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

        public int getRecogUploadPortraitCount(int i2) {
            try {
                if (TextUtils.isEmpty(this.recogUploadPortraitCount)) {
                    return 3;
                }
                return Math.min(i2, Math.max(1, Integer.valueOf(this.recogUploadPortraitCount).intValue()));
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
            if (!TextUtils.isEmpty(this.f9426f)) {
                try {
                    int parseInt = Integer.parseInt(this.f9426f);
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
            if (!TextUtils.isEmpty(this.f9422b)) {
                try {
                    int parseInt = Integer.parseInt(this.f9422b);
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
            if (!TextUtils.isEmpty(this.f9424d)) {
                try {
                    int parseInt = Integer.parseInt(this.f9424d);
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
                jSONObject.put(m, this.f9421a);
                jSONObject.put(n, this.f9422b);
                jSONObject.put(o, this.f9423c);
                jSONObject.put(p, this.f9424d);
                jSONObject.put(q, this.f9425e);
                jSONObject.put("roll", this.f9426f);
                jSONObject.put(s, this.f9427g);
                jSONObject.put(t, this.f9428h);
                jSONObject.put(u, this.f9429i);
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
            return "LivenessConfigOption{illumList=" + this.illumList + ", minFaceSize='" + this.minFaceSize + "', illumThr='" + this.f9421a + "', trackInterval='" + this.f9422b + "', detectInterval='" + this.f9423c + "', yaw='" + this.f9424d + "', pitch='" + this.f9425e + "', roll='" + this.f9426f + "', originImg='" + this.f9427g + "', maxRegImgNum='" + this.f9428h + "', prefetchRegImgInterval='" + this.f9429i + "', cropFaceSize='" + this.j + "', cropFaceRatio='" + this.k + "', switchRecordVideo='" + this.switchRecordVideo + "', recogActionType='" + this.recogActionType + "', recogTimeInterval='" + this.recogTimeInterval + "', recogUploadPortraitCount='" + this.recogUploadPortraitCount + "', whiteBgIllumThr=" + this.whiteBgIllumThr + ", action=" + this.action + '}';
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
