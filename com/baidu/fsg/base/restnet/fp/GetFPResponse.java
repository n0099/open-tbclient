package com.baidu.fsg.base.restnet.fp;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.NoProguard;
import com.baidu.fsg.base.armor.RimArmor;
import com.baidu.fsg.base.restnet.beans.IBeanResponse;
import com.baidu.fsg.base.restnet.beans.business.core.utils.BdWalletUtils;
import com.baidu.fsg.base.utils.JsonUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class GetFPResponse implements IBeanResponse {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RimConfig conf;
    public String confSign;
    public Exp[] exps;
    public RimFp fp;
    public SoDownloadInfo so_download;

    /* loaded from: classes5.dex */
    public static class CommonConfig implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String init_delay;

        public CommonConfig() {
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

    /* loaded from: classes5.dex */
    public static class Exp implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ExpContent[] exp_contents;
        public String exp_id;
        public String exp_version;
        public String is_enable;

        public Exp() {
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

    /* loaded from: classes5.dex */
    public static class ExpContent implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String exp_name;
        public String exp_value;

        public ExpContent() {
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

    /* loaded from: classes5.dex */
    public static class LivenessConfig implements NoProguard {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int CROP_FACE_RATIO = 3;
        public static final int CROP_FACE_SIZE = 256;
        public static final int DETECT_INTERVAL = 300;
        public static final int ILLUM_THR = 40;
        public static final int LIVENESS_RECOG_TYPE_BLINK = 1;
        public static final int LIVENESS_RECOG_TYPE_OPEN_MOUTH = 2;
        public static final String LIVENESS_STATISTICS_REPORTTYPE_DONNOTUSE = "0";
        public static final String LIVENESS_STATISTICS_REPORTTYPE_TIMEOUT_ANYWAY = "2";
        public static final String LIVENESS_STATISTICS_REPORTTYPE_TIMEOUT_NOFACE = "1";
        public static final int MAX_REG_IMG_NUM = 3;
        public static final int MIN_FACE_SIZE = 100;
        public static final int PITCH = 15;
        public static final int PREFETCH_REG_IMG_INTERVAL = 300;
        public static final int ROLL = 15;
        public static final int TRACK_INTERVAL = 300;
        public static final int YAW = 15;

        /* renamed from: a  reason: collision with root package name */
        public static final int f39463a = 6;

        /* renamed from: b  reason: collision with root package name */
        public static final int f39464b = 3;
        public transient /* synthetic */ FieldHolder $fh;
        public String crop_face_ratio;
        public String crop_face_size;
        public String custom_sp_config;
        public String custom_verfitytext_spno_list;
        public String custom_verifytext;
        public String detect_interval;
        public String illum_thr;
        public String max_reg_img_num;
        public String min_face_size;
        public String pitch;
        public String prefetch_reg_img_interval;
        public String recog_action_type;
        public String recog_time_interval;
        public String recog_upload_portrait_count;
        public String record_video_spno_list;
        public String report_type;
        public String roll;
        public SpConf sp_conf;
        public String switch_record_video;
        public String track_interval;
        public String yaw;

        /* loaded from: classes5.dex */
        public static class SpConf implements NoProguard {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public String tip_msg;

            public SpConf() {
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

        public LivenessConfig() {
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
            this.min_face_size = String.valueOf(100);
            this.illum_thr = String.valueOf(40);
            this.track_interval = String.valueOf(300);
            this.detect_interval = String.valueOf(300);
            this.yaw = String.valueOf(15);
            this.pitch = String.valueOf(15);
            this.roll = String.valueOf(15);
            this.max_reg_img_num = String.valueOf(3);
            this.prefetch_reg_img_interval = String.valueOf(300);
            this.crop_face_ratio = String.valueOf(3);
            this.crop_face_size = String.valueOf(256);
        }

        public int getCropFaceRatio() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!TextUtils.isEmpty(this.crop_face_ratio)) {
                    try {
                        int parseInt = Integer.parseInt(this.crop_face_ratio);
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
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (!TextUtils.isEmpty(this.crop_face_size)) {
                    try {
                        int parseInt = Integer.parseInt(this.crop_face_size);
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
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (!TextUtils.isEmpty(this.detect_interval)) {
                    try {
                        int parseInt = Integer.parseInt(this.detect_interval);
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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (!TextUtils.isEmpty(this.illum_thr)) {
                    try {
                        int parseInt = Integer.parseInt(this.illum_thr);
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

        public int getMaxRegImgNum(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                try {
                    if (!TextUtils.isEmpty(this.custom_sp_config)) {
                        return new JSONObject(this.custom_sp_config).getJSONObject(str).optInt("reg_count", 3);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                if (!TextUtils.isEmpty(this.max_reg_img_num)) {
                    try {
                        int parseInt = Integer.parseInt(this.max_reg_img_num);
                        if (parseInt < 1 || parseInt > 3) {
                            return 3;
                        }
                        return parseInt;
                    } catch (NumberFormatException e3) {
                        e3.printStackTrace();
                    }
                }
                return 3;
            }
            return invokeL.intValue;
        }

        public int getMinFaceSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (!TextUtils.isEmpty(this.min_face_size)) {
                    try {
                        int parseInt = Integer.parseInt(this.min_face_size);
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

        public int getPitch() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                if (!TextUtils.isEmpty(this.pitch)) {
                    try {
                        int parseInt = Integer.parseInt(this.pitch);
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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                if (!TextUtils.isEmpty(this.prefetch_reg_img_interval)) {
                    try {
                        int parseInt = Integer.parseInt(this.prefetch_reg_img_interval);
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
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                try {
                    if (TextUtils.isEmpty(this.recog_action_type)) {
                        return 1;
                    }
                    return Integer.valueOf(this.recog_action_type).intValue();
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
            if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
                try {
                    if (TextUtils.isEmpty(this.recog_upload_portrait_count)) {
                        return 3;
                    }
                    return Math.min(i2, Math.max(1, Integer.valueOf(this.recog_upload_portrait_count).intValue()));
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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                try {
                    if (TextUtils.isEmpty(this.recog_time_interval)) {
                        return 6;
                    }
                    return Integer.valueOf(this.recog_time_interval).intValue();
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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                if (!TextUtils.isEmpty(this.roll)) {
                    try {
                        int parseInt = Integer.parseInt(this.roll);
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

        public boolean getSwitchRecordVideo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? "1".equals(this.switch_record_video) : invokeV.booleanValue;
        }

        public int getTrackInterval() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                if (!TextUtils.isEmpty(this.track_interval)) {
                    try {
                        int parseInt = Integer.parseInt(this.track_interval);
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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                if (!TextUtils.isEmpty(this.yaw)) {
                    try {
                        int parseInt = Integer.parseInt(this.yaw);
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

        public boolean isStatisticsEnable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (TextUtils.isEmpty(this.report_type) || this.report_type.equals("0")) ? false : true : invokeV.booleanValue;
        }

        public boolean shouldRecogTextCustom(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
                try {
                    if (TextUtils.isEmpty(this.custom_verfitytext_spno_list) || TextUtils.isEmpty(str)) {
                        return false;
                    }
                    return Arrays.asList(this.custom_verfitytext_spno_list.split("\\|")).contains(str);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return invokeL.booleanValue;
        }

        public boolean shouldRecordVideo(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
                try {
                    if (TextUtils.isEmpty(this.record_video_spno_list) || TextUtils.isEmpty(str)) {
                        return false;
                    }
                    return Arrays.asList(this.record_video_spno_list.split("\\|")).contains(str);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class OcrConfig implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int id_capture_interval;
        public int id_capture_max_num;
        public int id_capture_timeout;
        public int id_crop_size;
        public String id_logo_text;

        public OcrConfig() {
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

    /* loaded from: classes5.dex */
    public static class RimConfig implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: common  reason: collision with root package name */
        public CommonConfig f39465common;
        public LivenessConfig living;
        public OcrConfig ocr;

        public RimConfig() {
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

    /* loaded from: classes5.dex */
    public static class RimFp implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String fp;

        public RimFp() {
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

    /* loaded from: classes5.dex */
    public static class SoDownloadInfo implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean enable;
        public boolean extra_global_enable;
        public int gray;
        public SoInfo[] list;
        public String zip_version;

        public SoDownloadInfo() {
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

    /* loaded from: classes5.dex */
    public static class SoInfo implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String cpu;
        public String hash;
        public String url;

        public SoInfo() {
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

    public GetFPResponse() {
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

    @Override // com.baidu.fsg.base.restnet.beans.IBeanResponse
    public boolean checkResponseValidity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.fsg.base.restnet.beans.IBeanResponse
    public void storeResponse(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            RimFp rimFp = this.fp;
            if (rimFp != null && !TextUtils.isEmpty(rimFp.fp)) {
                String decryptProxy = RimArmor.getInstance().decryptProxy(this.fp.fp);
                if (!TextUtils.isEmpty(decryptProxy) && !decryptProxy.equals(BdWalletUtils.getDeviceFP(context))) {
                    BdWalletUtils.setDeviceFP(context, decryptProxy);
                }
            }
            RimConfig rimConfig = this.conf;
            if (rimConfig != null) {
                String json = JsonUtils.toJson(rimConfig);
                if (!TextUtils.isEmpty(json)) {
                    BdWalletUtils.setRimAllConfig(context, json);
                }
            }
            SoDownloadInfo soDownloadInfo = this.so_download;
            if (soDownloadInfo != null) {
                String json2 = JsonUtils.toJson(soDownloadInfo);
                if (!TextUtils.isEmpty(json2)) {
                    BdWalletUtils.setRimSoDownload(context, json2);
                }
            }
            Exp[] expArr = this.exps;
            if (expArr != null) {
                String json3 = JsonUtils.toJson(expArr);
                if (TextUtils.isEmpty(json3)) {
                    return;
                }
                BdWalletUtils.setExps(context, json3);
            }
        }
    }
}
