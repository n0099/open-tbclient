package com.baidu.pass.biometrics.base.dynamicupdate;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class SdkConfigOptions {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "SdkConfigOptions";

    /* renamed from: a  reason: collision with root package name */
    public static final String f41729a = "liveness_config_option";
    public transient /* synthetic */ FieldHolder $fh;
    public LivenessConfigOption livenessConfigOption;

    public SdkConfigOptions() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.livenessConfigOption = new LivenessConfigOption();
    }

    public static SdkConfigOptions fromLocalJson(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            SdkConfigOptions sdkConfigOptions = new SdkConfigOptions();
            sdkConfigOptions.livenessConfigOption = LivenessConfigOption.fromJson(jSONObject.optJSONObject(f41729a));
            return sdkConfigOptions;
        }
        return (SdkConfigOptions) invokeL.objValue;
    }

    public static SdkConfigOptions fromOnLineJSON(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            SdkConfigOptions sdkConfigOptions = new SdkConfigOptions();
            sdkConfigOptions.livenessConfigOption = LivenessConfigOption.fromJson(jSONObject);
            return sdkConfigOptions;
        }
        return (SdkConfigOptions) invokeL.objValue;
    }

    public JSONObject toJSON() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(f41729a, this.livenessConfigOption == null ? "" : this.livenessConfigOption.toJSON());
                return jSONObject;
            } catch (JSONException unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "SdkConfigOptions{livenessConfigOption=" + this.livenessConfigOption + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public static class LivenessConfigOption {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String A = "recog_upload_portrait_count";
        public static final String B = "white_bg_illum_thr";
        public static final String C = "abtest_illum_list";
        public static final String D = "action";
        public static final int DEFAULT_MIN_FACE_SIZE = 100;
        public static final int DEFAULT_ORIGIN_IMG = 10000;
        public static final int DEFAULT_PITCH = 15;
        public static final int DEFAULT_ROLL = 15;
        public static final int DEFAULT_YAW = 15;
        public static final String E = "close_face";
        public static final int F = 40;
        public static final int G = 300;
        public static final int H = 300;
        public static final int I = 3;
        public static final int J = 300;
        public static final int K = 256;
        public static final int L = 3;
        public static final int LIVENESS_RECOG_TYPE_BLINK = 1;
        public static final int LIVENESS_RECOG_TYPE_OPEN_MOUTH = 2;
        public static final int M = 10;
        public static final int N = 6;
        public static final int O = 3;
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
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f41730a;
        public List<Integer> action;

        /* renamed from: b  reason: collision with root package name */
        public String f41731b;

        /* renamed from: c  reason: collision with root package name */
        public String f41732c;

        /* renamed from: d  reason: collision with root package name */
        public String f41733d;

        /* renamed from: e  reason: collision with root package name */
        public String f41734e;

        /* renamed from: f  reason: collision with root package name */
        public String f41735f;

        /* renamed from: g  reason: collision with root package name */
        public String f41736g;

        /* renamed from: h  reason: collision with root package name */
        public String f41737h;

        /* renamed from: i  reason: collision with root package name */
        public String f41738i;
        public List<Integer> illumList;
        public String j;
        public String k;
        public boolean mCloseFace;
        public String minFaceSize;
        public String recogActionType;
        public String recogTimeInterval;
        public String recogUploadPortraitCount;
        public String switchRecordVideo;
        public int whiteBgIllumThr;

        public LivenessConfigOption() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.illumList = new ArrayList();
            this.minFaceSize = String.valueOf(100);
            this.f41730a = String.valueOf(40);
            this.f41731b = String.valueOf(300);
            this.f41732c = String.valueOf(300);
            this.f41733d = String.valueOf(15);
            this.f41734e = String.valueOf(15);
            this.f41735f = String.valueOf(15);
            this.f41736g = String.valueOf(10000);
            this.f41737h = String.valueOf(3);
            this.f41738i = String.valueOf(300);
            this.j = String.valueOf(3);
            this.k = String.valueOf(256);
            this.action = new ArrayList();
        }

        public static void a(JSONArray jSONArray, List<Integer> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(65537, null, jSONArray, list) == null) || jSONArray == null) {
                return;
            }
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (!TextUtils.isEmpty(jSONArray.optString(i2))) {
                    list.add(Integer.valueOf(jSONArray.optInt(i2)));
                }
            }
        }

        public static LivenessConfigOption fromJson(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
                LivenessConfigOption livenessConfigOption = new LivenessConfigOption();
                if (jSONObject == null) {
                    return livenessConfigOption;
                }
                livenessConfigOption.minFaceSize = jSONObject.optString(l);
                livenessConfigOption.f41730a = jSONObject.optString(m);
                livenessConfigOption.f41731b = jSONObject.optString(n);
                livenessConfigOption.f41732c = jSONObject.optString(o);
                livenessConfigOption.f41733d = jSONObject.optString(p);
                livenessConfigOption.f41734e = jSONObject.optString(q);
                livenessConfigOption.f41735f = jSONObject.optString("roll");
                livenessConfigOption.f41736g = jSONObject.optString(s);
                livenessConfigOption.f41737h = jSONObject.optString(t);
                livenessConfigOption.f41738i = jSONObject.optString(u);
                livenessConfigOption.j = jSONObject.optString(v);
                livenessConfigOption.k = jSONObject.optString(w);
                livenessConfigOption.switchRecordVideo = jSONObject.optString(x);
                livenessConfigOption.recogActionType = jSONObject.optString(y);
                livenessConfigOption.recogTimeInterval = jSONObject.optString(z);
                livenessConfigOption.recogUploadPortraitCount = jSONObject.optString(A);
                livenessConfigOption.whiteBgIllumThr = jSONObject.optInt(B, 10);
                a(jSONObject.optJSONArray(C), livenessConfigOption.illumList);
                JSONArray optJSONArray = jSONObject.optJSONArray("action");
                livenessConfigOption.mCloseFace = jSONObject.optBoolean(E);
                a(optJSONArray, livenessConfigOption.action);
                return livenessConfigOption;
            }
            return (LivenessConfigOption) invokeL.objValue;
        }

        public List<Integer> getABtestIllumList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                List<Integer> asList = Arrays.asList(6, 8, 10);
                List<Integer> list = this.illumList;
                return (list == null || list.isEmpty()) ? asList : this.illumList;
            }
            return (List) invokeV.objValue;
        }

        public int getCropFaceRatio() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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
            return invokeV.intValue;
        }

        public int getCropFaceSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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
            return invokeV.intValue;
        }

        public int getDetectInterval() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (!TextUtils.isEmpty(this.f41732c)) {
                    try {
                        int parseInt = Integer.parseInt(this.f41732c);
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
            return invokeV.intValue;
        }

        public int getIllumThr() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (!TextUtils.isEmpty(this.f41730a)) {
                    try {
                        int parseInt = Integer.parseInt(this.f41730a);
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
            return invokeV.intValue;
        }

        public int getMaxRegImgNum() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (!TextUtils.isEmpty(this.f41737h)) {
                    try {
                        int parseInt = Integer.parseInt(this.f41737h);
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
            return invokeV.intValue;
        }

        public int getMinFaceSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
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
            return invokeV.intValue;
        }

        public String getOriginImg() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f41736g : (String) invokeV.objValue;
        }

        public int getOriginImgRandomControl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new Random().nextInt(10000) : invokeV.intValue;
        }

        public int getPitch() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                if (!TextUtils.isEmpty(this.f41734e)) {
                    try {
                        int parseInt = Integer.parseInt(this.f41734e);
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
            return invokeV.intValue;
        }

        public int getPrefetchRegImgInterval() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                if (!TextUtils.isEmpty(this.f41738i)) {
                    try {
                        int parseInt = Integer.parseInt(this.f41738i);
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
            return invokeV.intValue;
        }

        public int getRecogActionType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
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
            return invokeV.intValue;
        }

        public int getRecogUploadPortraitCount(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
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
            return invokeI.intValue;
        }

        public int getRecogtimeInterval() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
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
            return invokeV.intValue;
        }

        public int getRoll() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                if (!TextUtils.isEmpty(this.f41735f)) {
                    try {
                        int parseInt = Integer.parseInt(this.f41735f);
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
            return invokeV.intValue;
        }

        public int getTrackInterval() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                if (!TextUtils.isEmpty(this.f41731b)) {
                    try {
                        int parseInt = Integer.parseInt(this.f41731b);
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
            return invokeV.intValue;
        }

        public int getYaw() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                if (!TextUtils.isEmpty(this.f41733d)) {
                    try {
                        int parseInt = Integer.parseInt(this.f41733d);
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
            return invokeV.intValue;
        }

        public boolean isCloseFace() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mCloseFace : invokeV.booleanValue;
        }

        public boolean isOriginImg() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
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
            return invokeV.booleanValue;
        }

        public JSONObject toJSON() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(l, this.minFaceSize);
                    jSONObject.put(m, this.f41730a);
                    jSONObject.put(n, this.f41731b);
                    jSONObject.put(o, this.f41732c);
                    jSONObject.put(p, this.f41733d);
                    jSONObject.put(q, this.f41734e);
                    jSONObject.put("roll", this.f41735f);
                    jSONObject.put(s, this.f41736g);
                    jSONObject.put(t, this.f41737h);
                    jSONObject.put(u, this.f41738i);
                    jSONObject.put(v, this.j);
                    jSONObject.put(w, this.k);
                    jSONObject.put(x, this.switchRecordVideo);
                    jSONObject.put(y, this.recogActionType);
                    jSONObject.put(z, this.recogTimeInterval);
                    jSONObject.put(A, this.recogUploadPortraitCount);
                    jSONObject.put(B, this.whiteBgIllumThr);
                    jSONObject.put(E, this.mCloseFace);
                    a(jSONObject, C, this.illumList);
                    a(jSONObject, "action", this.action);
                    return jSONObject;
                } catch (JSONException e2) {
                    Log.e(e2);
                    return null;
                }
            }
            return (JSONObject) invokeV.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                return "LivenessConfigOption{illumList=" + this.illumList + ", minFaceSize='" + this.minFaceSize + ExtendedMessageFormat.QUOTE + ", illumThr='" + this.f41730a + ExtendedMessageFormat.QUOTE + ", trackInterval='" + this.f41731b + ExtendedMessageFormat.QUOTE + ", detectInterval='" + this.f41732c + ExtendedMessageFormat.QUOTE + ", yaw='" + this.f41733d + ExtendedMessageFormat.QUOTE + ", pitch='" + this.f41734e + ExtendedMessageFormat.QUOTE + ", roll='" + this.f41735f + ExtendedMessageFormat.QUOTE + ", originImg='" + this.f41736g + ExtendedMessageFormat.QUOTE + ", maxRegImgNum='" + this.f41737h + ExtendedMessageFormat.QUOTE + ", prefetchRegImgInterval='" + this.f41738i + ExtendedMessageFormat.QUOTE + ", cropFaceSize='" + this.j + ExtendedMessageFormat.QUOTE + ", cropFaceRatio='" + this.k + ExtendedMessageFormat.QUOTE + ", switchRecordVideo='" + this.switchRecordVideo + ExtendedMessageFormat.QUOTE + ", recogActionType='" + this.recogActionType + ExtendedMessageFormat.QUOTE + ", recogTimeInterval='" + this.recogTimeInterval + ExtendedMessageFormat.QUOTE + ", recogUploadPortraitCount='" + this.recogUploadPortraitCount + ExtendedMessageFormat.QUOTE + ", whiteBgIllumThr=" + this.whiteBgIllumThr + ", action=" + this.action + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }

        public static void a(JSONObject jSONObject, String str, List<Integer> list) throws JSONException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65538, null, jSONObject, str, list) == null) {
                JSONArray jSONArray = new JSONArray();
                for (Integer num : list) {
                    jSONArray.put(num.intValue());
                }
                jSONObject.put(str, jSONArray);
            }
        }
    }
}
