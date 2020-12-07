package com.baidu.live.recorder.helper;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.ala.ndk.AlaNdkAdapter;
import com.baidu.ala.recorder.video.AlaLiveVideoConfig;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.ala.recorder.video.DynamicBitRateConfig;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.live.ae.a;
import com.baidu.live.data.g;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.tbadk.TbConfig;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LiveRecorderConfigHelper {
    private static volatile LiveRecorderConfigHelper buM;
    private g buJ = new g();
    private boolean buK = false;
    private boolean buL = false;

    public VideoResolution f(boolean z, boolean z2) {
        if (!z2) {
            return fv(a.RB().brA.aMv);
        }
        if (TbadkCoreApplication.getInst().isOther()) {
            if (z && z2) {
                return fv(a.RB().brA.aME);
            }
            if (!z && z2) {
                return fv(a.RB().brA.aMF);
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

    public static LiveRecorderConfigHelper QY() {
        if (buM == null) {
            synchronized (LiveRecorderConfigHelper.class) {
                if (buM == null) {
                    buM = new LiveRecorderConfigHelper();
                }
            }
        }
        return buM;
    }

    public AlaLiveVideoConfig d(int i, int i2, boolean z) {
        VideoResolution videoResolution = null;
        if (i2 == 1) {
            videoResolution = f(true, false);
        }
        if (videoResolution == null) {
            videoResolution = fv(i);
        }
        if (i2 == 1 && !a.RB().brA.aMx) {
            videoResolution = VideoResolution.P360;
        }
        AlaLiveVideoConfig isLandscape = new AlaLiveVideoConfig(iv(a.RB().brA.aMz), iv(a.RB().brA.aMA), a.RB().brA.increaseThreshold, a.RB().brA.decreaseThreshold, a.RB().brA.increaseCount, a.RB().brA.aMx, a.RB().brA.aMy, videoResolution.getWidth(), videoResolution.getHeight()).setIsLandscape(z);
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
                alaLiveVideoConfig.getRtcBitRateConfig().resetBitRateItem(iv(a.RB().brA.aMC));
            } else {
                alaLiveVideoConfig.getRtcBitRateConfig().resetBitRateItem(iv(a.RB().brA.aMD));
            }
        }
    }

    public void QZ() {
        if (!this.buK) {
            this.buJ.gB(a.RB().brA.aMB);
            AlaNdkAdapter.setDomainConfigEnable(this.buJ.aIR ? 1 : 0);
            if (this.buJ.aIQ.size() > 0 && this.buJ.aIP.length() > 0 && this.buJ.aIR) {
                for (int i = 0; i < this.buJ.aIQ.size(); i++) {
                    g.a aVar = this.buJ.aIQ.get(i);
                    if (aVar != null && aVar.ip != null && aVar.ip.length() > 0) {
                        AlaNdkAdapter.setDomainConfig(this.buJ.aIP, aVar.ip, aVar.aIT);
                    }
                }
            }
            this.buK = true;
        }
    }

    public void Ra() {
        if (!this.buL) {
            AlaNdkAdapter.setHttpDnsEnable(a.RB().brA.aMH ? 1 : 0);
            AlaNdkAdapter.setPushOptTimestamp(a.RB().brA.aMJ ? 1 : 0);
            this.buL = true;
        }
    }

    public static List<DynamicBitRateConfig.DynamicBitRateItem> iv(String str) {
        JSONArray jSONArray;
        int length;
        int i;
        Exception e;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            jSONArray = new JSONArray(str);
        } catch (JSONException e2) {
            e2.printStackTrace();
            jSONArray = null;
        }
        if (jSONArray == null || (length = jSONArray.length()) <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            int optInt = optJSONObject.optInt("bitrate");
            int optInt2 = optJSONObject.optInt("frame");
            Log.i("iveRecordConfigHelper", "@@ old bitrate = " + optInt);
            Log.i("iveRecordConfigHelper", "@@ old     fps = " + optInt2);
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("bitrate", Integer.valueOf(optInt));
                hashMap.put(AlaRecorderLog.KEY_CANERA_START_FPS, Integer.valueOf(optInt2));
                Map<String, Object> process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
                if (process.containsKey("bitrate")) {
                    optInt = ((Integer) process.get("bitrate")).intValue();
                }
                i = process.containsKey(AlaRecorderLog.KEY_CANERA_START_FPS) ? ((Integer) process.get(AlaRecorderLog.KEY_CANERA_START_FPS)).intValue() : optInt2;
                try {
                    Log.i("iveRecordConfigHelper", "@@ new bitrate = " + optInt);
                    Log.i("iveRecordConfigHelper", "@@ new     fps = " + i);
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    Log.i("iveRecordConfigHelper", "@@ now bitrate = " + optInt);
                    Log.i("iveRecordConfigHelper", "@@ now     fps = " + i);
                    arrayList.add(new DynamicBitRateConfig.DynamicBitRateItem(optInt, i));
                }
            } catch (Exception e4) {
                i = optInt2;
                e = e4;
            }
            Log.i("iveRecordConfigHelper", "@@ now bitrate = " + optInt);
            Log.i("iveRecordConfigHelper", "@@ now     fps = " + i);
            arrayList.add(new DynamicBitRateConfig.DynamicBitRateItem(optInt, i));
        }
        return arrayList;
    }

    /* loaded from: classes4.dex */
    public enum VideoResolution {
        P720(1, PlatformPlugin.DEFAULT_SYSTEM_UI, 720),
        P576(2, 1024, 576),
        P540(3, TbConfig.HEAD_IMG_SIZE, 544),
        P360(4, 640, EncoderTextureDrawer.X264_WIDTH),
        RTC(0, 480, 270);
        
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
            if (a.RB().brA != null) {
                alaLiveVideoConfig.setSupportFaceStyle(a.RB().brA.aMN);
            }
            if (a.RB().brA != null) {
                alaLiveVideoConfig.setVideoGOP(a.RB().brA.aMw);
            }
            b(alaLiveVideoConfig);
        }
    }

    private void b(AlaLiveVideoConfig alaLiveVideoConfig) {
        if (a.RB().brA != null && a.RB().brA.aMG != null) {
            try {
                JSONObject jSONObject = new JSONObject(a.RB().brA.aMG);
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
