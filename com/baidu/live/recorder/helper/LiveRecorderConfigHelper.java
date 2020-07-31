package com.baidu.live.recorder.helper;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.ala.ndk.AlaNdkAdapter;
import com.baidu.ala.recorder.video.AlaLiveVideoConfig;
import com.baidu.ala.recorder.video.DynamicBitRateConfig;
import com.baidu.live.data.e;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.v.a;
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
    private static volatile LiveRecorderConfigHelper bbT;
    private e bbQ = new e();
    private boolean bbR = false;
    private boolean bbS = false;

    public VideoResolution f(boolean z, boolean z2) {
        if (!z2) {
            return cM(a.Hs().aZn.aAg);
        }
        if (TbadkCoreApplication.getInst().isOther()) {
            if (z && z2) {
                return cM(a.Hs().aZn.aAo);
            }
            if (!z && z2) {
                return cM(a.Hs().aZn.aAp);
            }
            return VideoResolution.P540;
        }
        return VideoResolution.RTC;
    }

    private VideoResolution cM(int i) {
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

    public static LiveRecorderConfigHelper GN() {
        if (bbT == null) {
            synchronized (LiveRecorderConfigHelper.class) {
                if (bbT == null) {
                    bbT = new LiveRecorderConfigHelper();
                }
            }
        }
        return bbT;
    }

    public AlaLiveVideoConfig d(int i, int i2, boolean z) {
        VideoResolution videoResolution = null;
        if (i2 == 1) {
            videoResolution = f(true, false);
        }
        if (videoResolution == null) {
            videoResolution = cM(i);
        }
        if (i2 == 1 && !a.Hs().aZn.aAh) {
            videoResolution = VideoResolution.P360;
        }
        AlaLiveVideoConfig isLandscape = new AlaLiveVideoConfig(fE(a.Hs().aZn.aAj), fE(a.Hs().aZn.aAk), a.Hs().aZn.increaseThreshold, a.Hs().aZn.decreaseThreshold, a.Hs().aZn.increaseCount, a.Hs().aZn.aAh, a.Hs().aZn.aAi, videoResolution.getWidth(), videoResolution.getHeight()).setIsLandscape(z);
        if (i2 == 1) {
            isLandscape.setPreviewWidth(720);
            isLandscape.setPreviewHeight(PlatformPlugin.DEFAULT_SYSTEM_UI);
            if (a.Hs().aZn != null) {
                isLandscape.setSupportFaceStyle(a.Hs().aZn.aAw);
            }
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
                alaLiveVideoConfig.getRtcBitRateConfig().resetBitRateItem(fE(a.Hs().aZn.aAm));
            } else {
                alaLiveVideoConfig.getRtcBitRateConfig().resetBitRateItem(fE(a.Hs().aZn.aAn));
            }
        }
    }

    public void GO() {
        if (!this.bbR) {
            this.bbQ.eu(a.Hs().aZn.aAl);
            AlaNdkAdapter.setDomainConfigEnable(this.bbQ.axY ? 1 : 0);
            if (this.bbQ.axX.size() > 0 && this.bbQ.axW.length() > 0 && this.bbQ.axY) {
                for (int i = 0; i < this.bbQ.axX.size(); i++) {
                    e.a aVar = this.bbQ.axX.get(i);
                    if (aVar != null && aVar.ip != null && aVar.ip.length() > 0) {
                        AlaNdkAdapter.setDomainConfig(this.bbQ.axW, aVar.ip, aVar.aya);
                    }
                }
            }
            this.bbR = true;
        }
    }

    public void GP() {
        if (!this.bbS) {
            AlaNdkAdapter.setHttpDnsEnable(a.Hs().aZn.aAq ? 1 : 0);
            AlaNdkAdapter.setPushOptTimestamp(a.Hs().aZn.aAs ? 1 : 0);
            this.bbS = true;
        }
    }

    private List<DynamicBitRateConfig.DynamicBitRateItem> fE(String str) {
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
                hashMap.put("fps", Integer.valueOf(optInt2));
                Map<String, Object> process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
                if (process.containsKey("bitrate")) {
                    optInt = ((Integer) process.get("bitrate")).intValue();
                }
                i = process.containsKey("fps") ? ((Integer) process.get("fps")).intValue() : optInt2;
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
        P540(3, TbConfig.HEAD_IMG_SIZE, 540),
        P360(4, 640, 360),
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
}
