package com.baidu.live.recorder.helper;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.ala.ndk.AlaNdkAdapter;
import com.baidu.ala.recorder.video.AlaLiveVideoConfig;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.ala.recorder.video.DynamicBitRateConfig;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.live.data.h;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.tbadk.TbConfig;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.kwai.video.player.KsMediaMeta;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class LiveRecorderConfigHelper {
    private static volatile LiveRecorderConfigHelper bzx;
    private h bzu = new h();
    private boolean bzv = false;
    private boolean bzw = false;

    public VideoResolution f(boolean z, boolean z2) {
        if (!z2) {
            return fv(com.baidu.live.af.a.SE().bwi.aMZ);
        }
        if (TbadkCoreApplication.getInst().isOther()) {
            if (z && z2) {
                return fv(com.baidu.live.af.a.SE().bwi.aNi);
            }
            if (!z && z2) {
                return fv(com.baidu.live.af.a.SE().bwi.aNj);
            }
            return VideoResolution.P540;
        }
        return VideoResolution.RTC;
    }

    private VideoResolution fv(int i) {
        if (i == 1) {
            return VideoResolution.P720;
        }
        if (i == 2) {
            return VideoResolution.P576;
        }
        if (i == 3) {
            return VideoResolution.P540;
        }
        if (i == 4) {
            return VideoResolution.P360;
        }
        return VideoResolution.P540;
    }

    public static LiveRecorderConfigHelper Sb() {
        if (bzx == null) {
            synchronized (LiveRecorderConfigHelper.class) {
                if (bzx == null) {
                    bzx = new LiveRecorderConfigHelper();
                }
            }
        }
        return bzx;
    }

    public AlaLiveVideoConfig d(int i, int i2, boolean z) {
        VideoResolution videoResolution = null;
        if (i2 == 1) {
            videoResolution = f(true, false);
        }
        if (videoResolution == null) {
            videoResolution = fv(i);
        }
        if (i2 == 1 && !com.baidu.live.af.a.SE().bwi.aNb) {
            videoResolution = VideoResolution.P360;
        }
        AlaLiveVideoConfig isLandscape = new AlaLiveVideoConfig(ii(com.baidu.live.af.a.SE().bwi.aNd), ii(com.baidu.live.af.a.SE().bwi.aNe), com.baidu.live.af.a.SE().bwi.increaseThreshold, com.baidu.live.af.a.SE().bwi.decreaseThreshold, com.baidu.live.af.a.SE().bwi.increaseCount, com.baidu.live.af.a.SE().bwi.aNb, com.baidu.live.af.a.SE().bwi.aNc, videoResolution.getWidth(), videoResolution.getHeight()).setIsLandscape(z);
        if (i2 == 1) {
            isLandscape.setPreviewWidth(720);
            isLandscape.setPreviewHeight(PlatformPlugin.DEFAULT_SYSTEM_UI);
            a(isLandscape);
            return isLandscape;
        } else if (i2 == 2) {
            isLandscape.setPreviewWidth(videoResolution.getWidth());
            isLandscape.setPreviewHeight(videoResolution.getHeight());
            return isLandscape;
        } else {
            return null;
        }
    }

    public void a(boolean z, AlaLiveVideoConfig alaLiveVideoConfig) {
        if (alaLiveVideoConfig != null) {
            if (z) {
                alaLiveVideoConfig.getRtcBitRateConfig().resetBitRateItem(ii(com.baidu.live.af.a.SE().bwi.aNg));
            } else {
                alaLiveVideoConfig.getRtcBitRateConfig().resetBitRateItem(ii(com.baidu.live.af.a.SE().bwi.aNh));
            }
        }
    }

    public void Sc() {
        if (!this.bzv) {
            this.bzu.gk(com.baidu.live.af.a.SE().bwi.aNf);
            AlaNdkAdapter.setDomainConfigEnable(this.bzu.aJp ? 1 : 0);
            if (this.bzu.aJo.size() > 0 && this.bzu.aJn.length() > 0 && this.bzu.aJp) {
                for (int i = 0; i < this.bzu.aJo.size(); i++) {
                    h.a aVar = this.bzu.aJo.get(i);
                    if (aVar != null && aVar.ip != null && aVar.ip.length() > 0) {
                        AlaNdkAdapter.setDomainConfig(this.bzu.aJn, aVar.ip, aVar.aJr);
                    }
                }
            }
            this.bzv = true;
        }
    }

    public void Sd() {
        if (!this.bzw) {
            AlaNdkAdapter.setHttpDnsEnable(com.baidu.live.af.a.SE().bwi.aNl ? 1 : 0);
            AlaNdkAdapter.setPushOptTimestamp(com.baidu.live.af.a.SE().bwi.aNn ? 1 : 0);
            this.bzw = true;
        }
    }

    public static List<DynamicBitRateConfig.DynamicBitRateItem> ii(String str) {
        JSONArray jSONArray;
        int length;
        int i;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            jSONArray = new JSONArray(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONArray = null;
        }
        if (jSONArray == null || (length = jSONArray.length()) <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            int optInt = optJSONObject.optInt(KsMediaMeta.KSM_KEY_BITRATE);
            int optInt2 = optJSONObject.optInt("frame");
            Log.i("iveRecordConfigHelper", "@@ old bitrate = " + optInt);
            Log.i("iveRecordConfigHelper", "@@ old     fps = " + optInt2);
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(KsMediaMeta.KSM_KEY_BITRATE, Integer.valueOf(optInt));
                hashMap.put(AlaRecorderLog.KEY_CANERA_START_FPS, Integer.valueOf(optInt2));
                Map<String, Object> process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
                if (process.containsKey(KsMediaMeta.KSM_KEY_BITRATE)) {
                    optInt = ((Integer) process.get(KsMediaMeta.KSM_KEY_BITRATE)).intValue();
                }
                i = process.containsKey(AlaRecorderLog.KEY_CANERA_START_FPS) ? ((Integer) process.get(AlaRecorderLog.KEY_CANERA_START_FPS)).intValue() : optInt2;
                try {
                    Log.i("iveRecordConfigHelper", "@@ new bitrate = " + optInt);
                    Log.i("iveRecordConfigHelper", "@@ new     fps = " + i);
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    Log.i("iveRecordConfigHelper", "@@ now bitrate = " + optInt);
                    Log.i("iveRecordConfigHelper", "@@ now     fps = " + i);
                    arrayList.add(new DynamicBitRateConfig.DynamicBitRateItem(optInt, i));
                }
            } catch (Exception e3) {
                e = e3;
                i = optInt2;
            }
            Log.i("iveRecordConfigHelper", "@@ now bitrate = " + optInt);
            Log.i("iveRecordConfigHelper", "@@ now     fps = " + i);
            arrayList.add(new DynamicBitRateConfig.DynamicBitRateItem(optInt, i));
        }
        return arrayList;
    }

    /* loaded from: classes11.dex */
    public enum VideoResolution {
        P720(1, PlatformPlugin.DEFAULT_SYSTEM_UI, 720),
        P576(2, 1024, 576),
        P540(3, TbConfig.HEAD_IMG_SIZE, 544),
        P360(4, 640, EncoderTextureDrawer.X264_WIDTH),
        RTC(0, 480, SubsamplingScaleImageView.ORIENTATION_270);
        
        private int height;
        private int type;
        private int width;

        VideoResolution(int i, int i2, int i3) {
            this.type = i;
            this.width = i3;
            this.height = i2;
        }

        public int getWidth() {
            return this.width;
        }

        public int getHeight() {
            return this.height;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "L" + this.type + ":" + this.height + "*" + this.width;
        }
    }

    private void a(AlaLiveVideoConfig alaLiveVideoConfig) {
        if (alaLiveVideoConfig != null) {
            if (com.baidu.live.af.a.SE().bwi != null) {
                alaLiveVideoConfig.setSupportFaceStyle(com.baidu.live.af.a.SE().bwi.aNr);
            }
            if (com.baidu.live.af.a.SE().bwi != null) {
                alaLiveVideoConfig.setVideoGOP(com.baidu.live.af.a.SE().bwi.aNa);
            }
            b(alaLiveVideoConfig);
        }
    }

    private void b(AlaLiveVideoConfig alaLiveVideoConfig) {
        if (com.baidu.live.af.a.SE().bwi != null && com.baidu.live.af.a.SE().bwi.aNk != null) {
            try {
                JSONObject jSONObject = new JSONObject(com.baidu.live.af.a.SE().bwi.aNk);
                boolean z = jSONObject.optInt("switch", 1) == 1;
                double optDouble = jSONObject.optDouble("threshold", 0.3d);
                alaLiveVideoConfig.setHwEncoderReset(z);
                alaLiveVideoConfig.setResetHwEncoderThreshold((float) optDouble);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
