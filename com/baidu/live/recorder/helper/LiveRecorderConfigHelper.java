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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes3.dex */
public class LiveRecorderConfigHelper {
    private static volatile LiveRecorderConfigHelper aYI;
    private e aYF = new e();
    private boolean aYG = false;
    private boolean aYH = false;

    public VideoResolution f(boolean z, boolean z2) {
        if (!z2) {
            return cC(a.Ge().aWF.awL);
        }
        if (TbadkCoreApplication.getInst().isOther()) {
            if (z && z2) {
                return cC(a.Ge().aWF.awT);
            }
            if (!z && z2) {
                return cC(a.Ge().aWF.awU);
            }
            return VideoResolution.P540;
        }
        return VideoResolution.RTC;
    }

    private VideoResolution cC(int i) {
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

    public static LiveRecorderConfigHelper FX() {
        if (aYI == null) {
            synchronized (LiveRecorderConfigHelper.class) {
                if (aYI == null) {
                    aYI = new LiveRecorderConfigHelper();
                }
            }
        }
        return aYI;
    }

    public AlaLiveVideoConfig d(int i, int i2, boolean z) {
        VideoResolution videoResolution = null;
        if (i2 == 1) {
            videoResolution = f(true, false);
        }
        if (videoResolution == null) {
            videoResolution = cC(i);
        }
        if (i2 == 1 && !a.Ge().aWF.awM) {
            videoResolution = VideoResolution.P360;
        }
        AlaLiveVideoConfig isLandscape = new AlaLiveVideoConfig(fA(a.Ge().aWF.awO), fA(a.Ge().aWF.awP), a.Ge().aWF.increaseThreshold, a.Ge().aWF.decreaseThreshold, a.Ge().aWF.increaseCount, a.Ge().aWF.awM, a.Ge().aWF.awN, videoResolution.getWidth(), videoResolution.getHeight()).setIsLandscape(z);
        if (i2 == 1) {
            isLandscape.setPreviewWidth(720);
            isLandscape.setPreviewHeight(1280);
            if (a.Ge().aWF != null) {
                isLandscape.setSupportFaceStyle(a.Ge().aWF.axa);
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
                alaLiveVideoConfig.getRtcBitRateConfig().resetBitRateItem(fA(a.Ge().aWF.awR));
            } else {
                alaLiveVideoConfig.getRtcBitRateConfig().resetBitRateItem(fA(a.Ge().aWF.awS));
            }
        }
    }

    public void FY() {
        if (!this.aYG) {
            this.aYF.eq(a.Ge().aWF.awQ);
            AlaNdkAdapter.setDomainConfigEnable(this.aYF.auF ? 1 : 0);
            if (this.aYF.auE.size() > 0 && this.aYF.auD.length() > 0 && this.aYF.auF) {
                for (int i = 0; i < this.aYF.auE.size(); i++) {
                    e.a aVar = this.aYF.auE.get(i);
                    if (aVar != null && aVar.ip != null && aVar.ip.length() > 0) {
                        AlaNdkAdapter.setDomainConfig(this.aYF.auD, aVar.ip, aVar.auH);
                    }
                }
            }
            this.aYG = true;
        }
    }

    public void FZ() {
        if (!this.aYH) {
            AlaNdkAdapter.setHttpDnsEnable(a.Ge().aWF.awV ? 1 : 0);
            this.aYH = true;
        }
    }

    private List<DynamicBitRateConfig.DynamicBitRateItem> fA(String str) {
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
            int optInt = optJSONObject.optInt(IjkMediaMeta.IJKM_KEY_BITRATE);
            int optInt2 = optJSONObject.optInt("frame");
            Log.i("iveRecordConfigHelper", "@@ old bitrate = " + optInt);
            Log.i("iveRecordConfigHelper", "@@ old     fps = " + optInt2);
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(IjkMediaMeta.IJKM_KEY_BITRATE, Integer.valueOf(optInt));
                hashMap.put("fps", Integer.valueOf(optInt2));
                Map<String, Object> process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
                if (process.containsKey(IjkMediaMeta.IJKM_KEY_BITRATE)) {
                    optInt = ((Integer) process.get(IjkMediaMeta.IJKM_KEY_BITRATE)).intValue();
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

    /* loaded from: classes3.dex */
    public enum VideoResolution {
        P720(1, 1280, 720),
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
