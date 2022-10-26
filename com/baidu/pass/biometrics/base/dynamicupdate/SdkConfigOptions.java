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
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SdkConfigOptions {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "SdkConfigOptions";
    public static final String a = "liveness_config_option";
    public transient /* synthetic */ FieldHolder $fh;
    public LivenessConfigOption livenessConfigOption;

    /* loaded from: classes2.dex */
    public class LivenessConfigOption {
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
        public static final int O = 1;
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
        public String a;
        public List action;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public List illumList;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.illumList = new ArrayList();
            this.minFaceSize = String.valueOf(100);
            this.a = String.valueOf(40);
            this.b = String.valueOf(300);
            this.c = String.valueOf(300);
            this.d = String.valueOf(15);
            this.e = String.valueOf(15);
            this.f = String.valueOf(15);
            this.g = String.valueOf(10000);
            this.h = String.valueOf(3);
            this.i = String.valueOf(300);
            this.j = String.valueOf(3);
            this.k = String.valueOf(256);
            this.action = new ArrayList();
        }

        public static void a(JSONArray jSONArray, List list) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(65537, null, jSONArray, list) == null) && jSONArray != null) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    if (!TextUtils.isEmpty(jSONArray.optString(i))) {
                        list.add(Integer.valueOf(jSONArray.optInt(i)));
                    }
                }
            }
        }

        public static void a(JSONObject jSONObject, String str, List list) throws JSONException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65538, null, jSONObject, str, list) == null) {
                JSONArray jSONArray = new JSONArray();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    jSONArray.put(((Integer) it.next()).intValue());
                }
                jSONObject.put(str, jSONArray);
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
                livenessConfigOption.a = jSONObject.optString(m);
                livenessConfigOption.b = jSONObject.optString(n);
                livenessConfigOption.c = jSONObject.optString(o);
                livenessConfigOption.d = jSONObject.optString(p);
                livenessConfigOption.e = jSONObject.optString(q);
                livenessConfigOption.f = jSONObject.optString("roll");
                livenessConfigOption.g = jSONObject.optString(s);
                livenessConfigOption.h = jSONObject.optString(t);
                livenessConfigOption.i = jSONObject.optString(u);
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

        public List getABtestIllumList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                List asList = Arrays.asList(6, 8, 10);
                List list = this.illumList;
                if (list != null && !list.isEmpty()) {
                    return this.illumList;
                }
                return asList;
            }
            return (List) invokeV.objValue;
        }

        public boolean isOriginImg() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                if (TextUtils.isEmpty(getOriginImg())) {
                    return true;
                }
                try {
                    if (getOriginImgRandomControl() < Integer.parseInt(getOriginImg())) {
                        return true;
                    }
                    return false;
                } catch (Exception unused) {
                    Log.e(SdkConfigOptions.TAG, "origin_img config is not integer");
                    return false;
                }
            }
            return invokeV.booleanValue;
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
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
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
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
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
                if (!TextUtils.isEmpty(this.c)) {
                    try {
                        int parseInt = Integer.parseInt(this.c);
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
            return invokeV.intValue;
        }

        public int getIllumThr() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (!TextUtils.isEmpty(this.a)) {
                    try {
                        int parseInt = Integer.parseInt(this.a);
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
            return invokeV.intValue;
        }

        public int getMaxRegImgNum() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (!TextUtils.isEmpty(this.h)) {
                    try {
                        int parseInt = Integer.parseInt(this.h);
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
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                return 100;
            }
            return invokeV.intValue;
        }

        public String getOriginImg() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.g;
            }
            return (String) invokeV.objValue;
        }

        public int getOriginImgRandomControl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return new Random().nextInt(10000);
            }
            return invokeV.intValue;
        }

        public int getPitch() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                if (!TextUtils.isEmpty(this.e)) {
                    try {
                        int parseInt = Integer.parseInt(this.e);
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
            return invokeV.intValue;
        }

        public int getPrefetchRegImgInterval() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                if (!TextUtils.isEmpty(this.i)) {
                    try {
                        int parseInt = Integer.parseInt(this.i);
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
            return invokeV.intValue;
        }

        public int getRecogActionType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                try {
                    if (!TextUtils.isEmpty(this.recogActionType)) {
                        return Integer.valueOf(this.recogActionType).intValue();
                    }
                    return 1;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return 1;
                }
            }
            return invokeV.intValue;
        }

        public int getRecogtimeInterval() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                try {
                    if (!TextUtils.isEmpty(this.recogTimeInterval)) {
                        return Integer.valueOf(this.recogTimeInterval).intValue();
                    }
                    return 6;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return 6;
                }
            }
            return invokeV.intValue;
        }

        public int getRoll() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                if (!TextUtils.isEmpty(this.f)) {
                    try {
                        int parseInt = Integer.parseInt(this.f);
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
            return invokeV.intValue;
        }

        public int getTrackInterval() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                if (!TextUtils.isEmpty(this.b)) {
                    try {
                        int parseInt = Integer.parseInt(this.b);
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
            return invokeV.intValue;
        }

        public int getYaw() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                if (!TextUtils.isEmpty(this.d)) {
                    try {
                        int parseInt = Integer.parseInt(this.d);
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
            return invokeV.intValue;
        }

        public boolean isCloseFace() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                return this.mCloseFace;
            }
            return invokeV.booleanValue;
        }

        public int getRecogUploadPortraitCount(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
                try {
                    if (!TextUtils.isEmpty(this.recogUploadPortraitCount)) {
                        return Math.min(i, Math.max(1, Integer.valueOf(this.recogUploadPortraitCount).intValue()));
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                return 1;
            }
            return invokeI.intValue;
        }

        public JSONObject toJSON() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(l, this.minFaceSize);
                    jSONObject.put(m, this.a);
                    jSONObject.put(n, this.b);
                    jSONObject.put(o, this.c);
                    jSONObject.put(p, this.d);
                    jSONObject.put(q, this.e);
                    jSONObject.put("roll", this.f);
                    jSONObject.put(s, this.g);
                    jSONObject.put(t, this.h);
                    jSONObject.put(u, this.i);
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
                } catch (JSONException e) {
                    Log.e(e);
                    return null;
                }
            }
            return (JSONObject) invokeV.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                return "LivenessConfigOption{illumList=" + this.illumList + ", minFaceSize='" + this.minFaceSize + "', illumThr='" + this.a + "', trackInterval='" + this.b + "', detectInterval='" + this.c + "', yaw='" + this.d + "', pitch='" + this.e + "', roll='" + this.f + "', originImg='" + this.g + "', maxRegImgNum='" + this.h + "', prefetchRegImgInterval='" + this.i + "', cropFaceSize='" + this.j + "', cropFaceRatio='" + this.k + "', switchRecordVideo='" + this.switchRecordVideo + "', recogActionType='" + this.recogActionType + "', recogTimeInterval='" + this.recogTimeInterval + "', recogUploadPortraitCount='" + this.recogUploadPortraitCount + "', whiteBgIllumThr=" + this.whiteBgIllumThr + ", action=" + this.action + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    public SdkConfigOptions() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.livenessConfigOption = new LivenessConfigOption();
    }

    public JSONObject toJSON() {
        InterceptResult invokeV;
        Object json;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.livenessConfigOption == null) {
                    json = "";
                } else {
                    json = this.livenessConfigOption.toJSON();
                }
                jSONObject.put(a, json);
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
            return "SdkConfigOptions{livenessConfigOption=" + this.livenessConfigOption + '}';
        }
        return (String) invokeV.objValue;
    }

    public static SdkConfigOptions fromLocalJson(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            SdkConfigOptions sdkConfigOptions = new SdkConfigOptions();
            sdkConfigOptions.livenessConfigOption = LivenessConfigOption.fromJson(jSONObject.optJSONObject(a));
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
}
