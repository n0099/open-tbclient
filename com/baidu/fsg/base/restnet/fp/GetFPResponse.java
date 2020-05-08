package com.baidu.fsg.base.restnet.fp;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.fsg.base.NoProguard;
import com.baidu.fsg.base.armor.RimArmor;
import com.baidu.fsg.base.restnet.beans.IBeanResponse;
import com.baidu.fsg.base.restnet.beans.business.core.utils.BdWalletUtils;
import com.baidu.fsg.base.utils.JsonUtils;
import com.baidu.fsg.base.widget.textfilter.EditTextPasteFilterUtils;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GetFPResponse implements IBeanResponse {
    public RimConfig conf;
    public String confSign;
    public Exp[] exps;
    public RimFp fp;
    public SoDownloadInfo so_download;

    /* loaded from: classes4.dex */
    public static class CommonConfig implements NoProguard {
        public String init_delay;
    }

    /* loaded from: classes4.dex */
    public static class Exp implements NoProguard {
        public ExpContent[] exp_contents;
        public String exp_id;
        public String exp_version;
        public String is_enable;
    }

    /* loaded from: classes4.dex */
    public static class ExpContent implements NoProguard {
        public String exp_name;
        public String exp_value;
    }

    /* loaded from: classes4.dex */
    public static class OcrConfig implements NoProguard {
        public int id_capture_interval;
        public int id_capture_max_num;
        public int id_capture_timeout;
        public int id_crop_size;
        public String id_logo_text;
    }

    /* loaded from: classes4.dex */
    public static class RimConfig implements NoProguard {

        /* renamed from: common  reason: collision with root package name */
        public CommonConfig f985common;
        public LivenessConfig living;
        public OcrConfig ocr;
    }

    /* loaded from: classes4.dex */
    public static class RimFp implements NoProguard {
        public String fp;
    }

    /* loaded from: classes4.dex */
    public static class SoDownloadInfo implements NoProguard {
        public boolean enable;
        public boolean extra_global_enable;
        public int gray;
        public SoInfo[] list;
        public String zip_version;
    }

    /* loaded from: classes4.dex */
    public static class SoInfo implements NoProguard {
        public String cpu;
        public String hash;
        public String url;
    }

    @Override // com.baidu.fsg.base.restnet.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return true;
    }

    @Override // com.baidu.fsg.base.restnet.beans.IBeanResponse
    public void storeResponse(Context context) {
        if (this.fp != null && !TextUtils.isEmpty(this.fp.fp)) {
            String decryptProxy = RimArmor.getInstance().decryptProxy(this.fp.fp);
            if (!TextUtils.isEmpty(decryptProxy) && !decryptProxy.equals(BdWalletUtils.getDeviceFP(context))) {
                BdWalletUtils.setDeviceFP(context, decryptProxy);
            }
        }
        if (this.conf != null) {
            String json = JsonUtils.toJson(this.conf);
            if (!TextUtils.isEmpty(json)) {
                BdWalletUtils.setRimAllConfig(context, json);
            }
        }
        if (this.so_download != null) {
            String json2 = JsonUtils.toJson(this.so_download);
            if (!TextUtils.isEmpty(json2)) {
                BdWalletUtils.setRimSoDownload(context, json2);
            }
        }
        if (this.exps != null) {
            String json3 = JsonUtils.toJson(this.exps);
            if (!TextUtils.isEmpty(json3)) {
                BdWalletUtils.setExps(context, json3);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class LivenessConfig implements NoProguard {
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
        private static final int a = 6;
        private static final int b = 3;
        public String custom_sp_config;
        public String custom_verfitytext_spno_list;
        public String custom_verifytext;
        public String recog_action_type;
        public String recog_time_interval;
        public String recog_upload_portrait_count;
        public String record_video_spno_list;
        public String report_type;
        public SpConf sp_conf;
        public String switch_record_video;
        public String min_face_size = String.valueOf(100);
        public String illum_thr = String.valueOf(40);
        public String track_interval = String.valueOf(300);
        public String detect_interval = String.valueOf(300);
        public String yaw = String.valueOf(15);
        public String pitch = String.valueOf(15);
        public String roll = String.valueOf(15);
        public String max_reg_img_num = String.valueOf(3);
        public String prefetch_reg_img_interval = String.valueOf(300);
        public String crop_face_ratio = String.valueOf(3);
        public String crop_face_size = String.valueOf(256);

        /* loaded from: classes4.dex */
        public static class SpConf implements NoProguard {
            public String tip_msg;
        }

        public int getMinFaceSize() {
            if (!TextUtils.isEmpty(this.min_face_size)) {
                try {
                    int parseInt = Integer.parseInt(this.min_face_size);
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
            if (!TextUtils.isEmpty(this.illum_thr)) {
                try {
                    int parseInt = Integer.parseInt(this.illum_thr);
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
            if (!TextUtils.isEmpty(this.track_interval)) {
                try {
                    int parseInt = Integer.parseInt(this.track_interval);
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
            if (!TextUtils.isEmpty(this.detect_interval)) {
                try {
                    int parseInt = Integer.parseInt(this.detect_interval);
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

        public int getMaxRegImgNum(String str) {
            JSONObject jSONObject;
            try {
                if (!TextUtils.isEmpty(this.custom_sp_config) && (jSONObject = new JSONObject(this.custom_sp_config)) != null) {
                    return jSONObject.getJSONObject(str).optInt("reg_count", 3);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (!TextUtils.isEmpty(this.max_reg_img_num)) {
                try {
                    int parseInt = Integer.parseInt(this.max_reg_img_num);
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

        public int getPrefetchRegImgInterval() {
            if (!TextUtils.isEmpty(this.prefetch_reg_img_interval)) {
                try {
                    int parseInt = Integer.parseInt(this.prefetch_reg_img_interval);
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
            if (!TextUtils.isEmpty(this.crop_face_size)) {
                try {
                    int parseInt = Integer.parseInt(this.crop_face_size);
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
            if (!TextUtils.isEmpty(this.crop_face_ratio)) {
                try {
                    int parseInt = Integer.parseInt(this.crop_face_ratio);
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

        public boolean getSwitchRecordVideo() {
            return "1".equals(this.switch_record_video);
        }

        public int getRecogtimeInterval() {
            try {
                if (!TextUtils.isEmpty(this.recog_time_interval)) {
                    return Integer.valueOf(this.recog_time_interval).intValue();
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            return 6;
        }

        public int getRecogActionType() {
            try {
                if (!TextUtils.isEmpty(this.recog_action_type)) {
                    return Integer.valueOf(this.recog_action_type).intValue();
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            return 1;
        }

        public boolean shouldRecordVideo(String str) {
            try {
                if (!TextUtils.isEmpty(this.record_video_spno_list) && !TextUtils.isEmpty(str)) {
                    return Arrays.asList(this.record_video_spno_list.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR)).contains(str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }

        public int getRecogUploadPortraitCount(int i) {
            try {
                if (!TextUtils.isEmpty(this.recog_upload_portrait_count)) {
                    return Math.min(i, Math.max(1, Integer.valueOf(this.recog_upload_portrait_count).intValue()));
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            return 3;
        }

        public boolean shouldRecogTextCustom(String str) {
            try {
                if (!TextUtils.isEmpty(this.custom_verfitytext_spno_list) && !TextUtils.isEmpty(str)) {
                    return Arrays.asList(this.custom_verfitytext_spno_list.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR)).contains(str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }

        public boolean isStatisticsEnable() {
            return (TextUtils.isEmpty(this.report_type) || this.report_type.equals("0")) ? false : true;
        }
    }
}
