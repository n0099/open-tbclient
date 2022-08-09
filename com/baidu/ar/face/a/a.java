package com.baidu.ar.face.a;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.ar.a.c;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] pM;
    public transient /* synthetic */ FieldHolder $fh;
    public String pL;

    /* renamed from: com.baidu.ar.face.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0058a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String pN;
        public String pO;
        public String pP;
        public String pQ;
        public String pR;
        public String pS;
        public String pT;
        public final /* synthetic */ a pU;

        public C0058a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.pU = aVar;
        }
    }

    /* loaded from: classes.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int[] ot;
        public final /* synthetic */ a pU;
        public String pV;
        public String pW;
        public String pX;
        public String pY;
        public String pZ;
        public String qa;
        public String qb;
        public String qc;
        public C0058a qd;
        public C0058a qe;
        public C0058a qf;
        public int qg;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.pU = aVar;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-42162550, "Lcom/baidu/ar/face/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-42162550, "Lcom/baidu/ar/face/a/a;");
                return;
            }
        }
        pM = new int[]{3, 10, 10, 10, 10};
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private void a(b bVar, JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, bVar, jSONObject) == null) {
            JSONObject optJSONObject3 = jSONObject.optJSONObject("customize");
            bVar.qg = 0;
            bVar.ot = pM;
            if (optJSONObject3 == null || (optJSONObject = optJSONObject3.optJSONObject("algo")) == null || (optJSONObject2 = optJSONObject.optJSONObject("algo_face")) == null) {
                return;
            }
            String optString = optJSONObject2.optString(PollingModel.LEVEL);
            if (!TextUtils.isEmpty(optString)) {
                if (optString.equals("high")) {
                    i = 2;
                } else if (optString.equals("medium")) {
                    i = 1;
                } else if (optString.equals("mediumlow") || optString.equals(Config.EXCEPTION_MEMORY_LOW)) {
                    bVar.qg = 0;
                }
                bVar.qg = i;
            }
            JSONArray optJSONArray = optJSONObject2.optJSONArray("detect_rate");
            if (optJSONArray == null || optJSONArray.length() < 5) {
                return;
            }
            try {
                int[] iArr = new int[5];
                for (int i2 = 0; i2 < 5; i2++) {
                    iArr[i2] = optJSONArray.getInt(i2) < pM[i2] ? pM[i2] : optJSONArray.getInt(i2);
                }
                bVar.ot = iArr;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private b b(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, str, jSONObject)) == null) {
            b bVar = new b(this);
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                bVar.pV = this.pL + jSONObject2.getString("detect_model");
                bVar.pW = this.pL + jSONObject2.getString("animate");
                bVar.qa = this.pL + jSONObject2.getString("expression");
                bVar.pX = this.pL + jSONObject2.getString("track1_heavy");
                bVar.pY = this.pL + jSONObject2.getString("track1_medium");
                bVar.pZ = this.pL + jSONObject2.getString("track1_lite");
                bVar.qb = this.pL + jSONObject2.getString("mouth");
                bVar.qc = this.pL + jSONObject2.getString("gender");
                bVar.qf = f(jSONObject2.getJSONObject("high_device_model"));
                bVar.qe = f(jSONObject2.getJSONObject("medium_device_model"));
                bVar.qd = f(jSONObject2.getJSONObject("low_device_model"));
                if (jSONObject == null) {
                    bVar.qg = c.ag();
                    bVar.ot = pM;
                } else {
                    a(bVar, jSONObject);
                }
                return bVar;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (b) invokeLL.objValue;
    }

    private C0058a f(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, jSONObject)) == null) {
            C0058a c0058a = new C0058a(this);
            try {
                String string = jSONObject.getString("track_param_0");
                c0058a.pN = string;
                if (TextUtils.isEmpty(string)) {
                    c0058a.pN = "";
                } else {
                    c0058a.pN = this.pL + c0058a.pN;
                }
                String string2 = jSONObject.getString("track_param_1");
                c0058a.pO = string2;
                if (TextUtils.isEmpty(string2)) {
                    c0058a.pO = "";
                } else {
                    c0058a.pO = this.pL + c0058a.pO;
                }
                String string3 = jSONObject.getString("track_param_2");
                c0058a.pP = string3;
                if (TextUtils.isEmpty(string3)) {
                    c0058a.pP = "";
                } else {
                    c0058a.pP = this.pL + c0058a.pP;
                }
                String string4 = jSONObject.getString("track_param_3");
                c0058a.pQ = string4;
                if (TextUtils.isEmpty(string4)) {
                    c0058a.pQ = "";
                } else {
                    c0058a.pQ = this.pL + c0058a.pQ;
                }
                c0058a.pR = jSONObject.getString("trackingSmoothAlpha");
                c0058a.pS = jSONObject.getString("trackingSmoothThreshold");
                c0058a.pT = jSONObject.getString("trackingMouthThreshold");
                return c0058a;
            } catch (JSONException e) {
                com.baidu.ar.h.b.b("FaceModelConfig", "parse DeviceModel error");
                e.printStackTrace();
                return null;
            }
        }
        return (C0058a) invokeL.objValue;
    }

    public b a(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jSONObject)) == null) {
            this.pL = str;
            return b("{\n  \"detect_model\": \"detect/enc_zhibo_0849_initsize320.lite.bin\",\n  \"animate\": \"animate/skeletonModel_v3.1.11.bin\",\n  \"expression\": \"animate/enc_exp_v0.1.5_int16.lite.bin\",\n  \"track1_heavy\": \"track/v3_pose_occlu_s_0729.lite.bin_enc\",\n  \"track1_medium\": \"track/v3_pose_occlu_s_0729.lite.bin_enc\",\n  \"track1_lite\": \"track/mPts_automl_mv3_5ms_64_pose_s_model_epoch327.lite.bin_enc\",\n  \"mouth\": \"track/enc_mouth_mv27ky_br13stm.lite.bin\",\n  \"gender\": \"attributes/gender_v1.bin\",\n  \"high_device_model\": {\n    \"track_param_0\": \"track/enc_angle_mv8_int16.bs4.lite.bin\",\n    \"track_param_1\": \"track/v3_pose_occlu_s_0729.lite.bin_enc\",\n    \"track_param_2\": \"track/enc_eye_mv6ky_br14e326.lite.bin\",\n    \"track_param_3\": \"track/iris_mv6gp_dengdayan_model_epoch96.lite.bin_enc\",\n    \"trackingSmoothAlpha\": \"0.01\",\n    \"trackingMouthThreshold\": \"-1.0\",\n    \"trackingSmoothThreshold\": \"1\"\n  },\n  \"medium_device_model\": {\n    \"track_param_0\": \"track/enc_angle_mv8_int16.bs4.lite.bin\",\n    \"track_param_1\": \"track/v3_pose_occlu_s_0729.lite.bin_enc\",\n    \"track_param_2\": \"track/enc_eye_mv6ky_br14e326.lite.bin\",\n    \"track_param_3\": \"track/iris_mv6gp_dengdayan_model_epoch96.lite.bin_enc\",\n    \"trackingSmoothAlpha\": \"0.01\",\n    \"trackingMouthThreshold\": \"-1.0\",\n    \"trackingSmoothThreshold\": \"1\"\n  },\n  \"low_device_model\": {\n    \"track_param_0\": \"track/enc_angle_mv8_int16.bs4.lite.bin\",\n    \"track_param_1\": \"track/mPts_automl_mv3_5ms_64_pose_s_model_epoch327.lite.bin_enc\",\n    \"track_param_2\": \"track/enc_eye_mv6ky_br14e326.lite.bin\",\n    \"track_param_3\": \"track/iris_mv6gp_dengdayan_model_epoch96.lite.bin_enc\",\n    \"trackingSmoothAlpha\": \"0.01\",\n    \"trackingMouthThreshold\": \"-1.0\",\n    \"trackingSmoothThreshold\": \"1\"\n  }\n}", jSONObject);
        }
        return (b) invokeLL.objValue;
    }
}
