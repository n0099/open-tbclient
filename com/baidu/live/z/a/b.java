package com.baidu.live.z.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.ala.ndk.AlaNdkAdapter;
import com.baidu.ala.recorder.video.AlaLiveVideoConfig;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.ala.recorder.video.DynamicBitRateConfig;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.live.data.ar;
import com.baidu.live.data.h;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.kwai.video.player.KsMediaMeta;
import com.yy.mediaframework.base.VideoEncoderConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    private static volatile b bzI;
    private h bzF = new h();
    private boolean bzG = false;
    private boolean bzH = false;

    public a f(boolean z, boolean z2) {
        if (!z2) {
            return dS(com.baidu.live.ae.a.Qm().bwx.aMr);
        }
        if (TbadkCoreApplication.getInst().isOther()) {
            if (z && z2) {
                return dS(com.baidu.live.ae.a.Qm().bwx.aMA);
            }
            if (!z && z2) {
                return dS(com.baidu.live.ae.a.Qm().bwx.aMB);
            }
            return a.bzL;
        }
        return a.bzN;
    }

    public a g(boolean z, boolean z2) {
        if (z && z2) {
            ar arVar = com.baidu.live.ae.a.Qm().bwx;
            if (arVar != null && arVar.aME > 0 && arVar.aMF > 0) {
                return new a(100, arVar.aMF, arVar.aME);
            }
            return a.bzN;
        }
        return f(z, z2);
    }

    private a dS(int i) {
        if (i == 1) {
            return a.bzJ;
        }
        if (i == 2) {
            return a.bzK;
        }
        if (i == 3) {
            return a.bzL;
        }
        if (i == 4) {
            return a.bzM;
        }
        return a.bzL;
    }

    public static b PI() {
        if (bzI == null) {
            synchronized (b.class) {
                if (bzI == null) {
                    bzI = new b();
                }
            }
        }
        return bzI;
    }

    public AlaLiveVideoConfig d(int i, int i2, boolean z) {
        a aVar = null;
        if (i2 == 1) {
            aVar = f(true, false);
        }
        if (aVar == null) {
            aVar = dS(i);
        }
        if (i2 == 1 && !com.baidu.live.ae.a.Qm().bwx.aMt) {
            aVar = a.bzM;
        }
        AlaLiveVideoConfig isLandscape = new AlaLiveVideoConfig(hz(com.baidu.live.ae.a.Qm().bwx.aMv), hz(com.baidu.live.ae.a.Qm().bwx.aMw), com.baidu.live.ae.a.Qm().bwx.increaseThreshold, com.baidu.live.ae.a.Qm().bwx.decreaseThreshold, com.baidu.live.ae.a.Qm().bwx.increaseCount, com.baidu.live.ae.a.Qm().bwx.aMt, com.baidu.live.ae.a.Qm().bwx.aMu, aVar.getWidth(), aVar.getHeight()).setIsLandscape(z);
        isLandscape.setArReportOriginalValue(com.baidu.live.ae.a.Qm().bCs.aRk.isArReportOriginalValue());
        if (i2 == 1) {
            isLandscape.setPreviewWidth(720);
            isLandscape.setPreviewHeight(1280);
            a(isLandscape);
            return isLandscape;
        } else if (i2 == 2) {
            isLandscape.setPreviewWidth(aVar.getWidth());
            isLandscape.setPreviewHeight(aVar.getHeight());
            return isLandscape;
        } else {
            return null;
        }
    }

    public void a(boolean z, AlaLiveVideoConfig alaLiveVideoConfig) {
        if (alaLiveVideoConfig != null) {
            if (z) {
                alaLiveVideoConfig.getRtcBitRateConfig().resetBitRateItem(hz(com.baidu.live.ae.a.Qm().bwx.aMy));
            } else {
                alaLiveVideoConfig.getRtcBitRateConfig().resetBitRateItem(hz(com.baidu.live.ae.a.Qm().bwx.aMz));
            }
        }
    }

    public void a(boolean z, AlaLiveVideoConfig alaLiveVideoConfig, boolean z2) {
        if (alaLiveVideoConfig != null && com.baidu.live.ae.a.Qm().bwx != null) {
            if (z2) {
                alaLiveVideoConfig.getRtcBitRateConfig().resetBitRateItem(hz(com.baidu.live.ae.a.Qm().bwx.aMH));
                alaLiveVideoConfig.setVideoGOP(com.baidu.live.ae.a.Qm().bwx.aMG);
                return;
            }
            alaLiveVideoConfig.setVideoGOP(com.baidu.live.ae.a.Qm().bwx.aMs);
        }
    }

    public void PJ() {
        if (!this.bzG) {
            this.bzF.fy(com.baidu.live.ae.a.Qm().bwx.aMx);
            AlaNdkAdapter.setDomainConfigEnable(this.bzF.aHP ? 1 : 0);
            if (this.bzF.aHO.size() > 0 && this.bzF.aHN.length() > 0 && this.bzF.aHP) {
                for (int i = 0; i < this.bzF.aHO.size(); i++) {
                    h.a aVar = this.bzF.aHO.get(i);
                    if (aVar != null && aVar.ip != null && aVar.ip.length() > 0) {
                        AlaNdkAdapter.setDomainConfig(this.bzF.aHN, aVar.ip, aVar.aHR);
                    }
                }
            }
            this.bzG = true;
        }
    }

    public void PK() {
        if (!this.bzH) {
            AlaNdkAdapter.setHttpDnsEnable(com.baidu.live.ae.a.Qm().bwx.aMI ? 1 : 0);
            AlaNdkAdapter.setPushOptTimestamp(com.baidu.live.ae.a.Qm().bwx.aMK ? 1 : 0);
            this.bzH = true;
        }
    }

    public static List<DynamicBitRateConfig.DynamicBitRateItem> hz(String str) {
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

    /* loaded from: classes10.dex */
    public static class a {
        public static final a bzJ = new a(1, 1280, 720);
        public static final a bzK = new a(2, 1024, 576);
        public static final a bzL = new a(3, 960, VideoEncoderConfig.DEFAULT_ENCODE_HIGH_WIDTH);
        public static final a bzM = new a(4, 640, EncoderTextureDrawer.X264_WIDTH);
        public static final a bzN = new a(0, 480, 270);
        private int height;
        private int type;
        private int width;

        a(int i, int i2, int i3) {
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

        public String toString() {
            return "L" + this.type + ":" + this.height + "*" + this.width;
        }
    }

    private void a(AlaLiveVideoConfig alaLiveVideoConfig) {
        if (alaLiveVideoConfig != null) {
            if (com.baidu.live.ae.a.Qm().bwx != null) {
                alaLiveVideoConfig.setSupportFaceStyle(com.baidu.live.ae.a.Qm().bwx.aMO);
            }
            if (com.baidu.live.ae.a.Qm().bwx != null) {
                alaLiveVideoConfig.setVideoGOP(com.baidu.live.ae.a.Qm().bwx.aMs);
            }
            b(alaLiveVideoConfig);
        }
    }

    private void b(AlaLiveVideoConfig alaLiveVideoConfig) {
        if (com.baidu.live.ae.a.Qm().bwx != null && com.baidu.live.ae.a.Qm().bwx.aMC != null) {
            try {
                JSONObject jSONObject = new JSONObject(com.baidu.live.ae.a.Qm().bwx.aMC);
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
