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
/* loaded from: classes11.dex */
public class b {
    private static volatile b byi;
    private h byf = new h();
    private boolean byg = false;
    private boolean byh = false;

    public a f(boolean z, boolean z2) {
        if (!z2) {
            return dR(com.baidu.live.ae.a.Qj().buX.aKR);
        }
        if (TbadkCoreApplication.getInst().isOther()) {
            if (z && z2) {
                return dR(com.baidu.live.ae.a.Qj().buX.aLa);
            }
            if (!z && z2) {
                return dR(com.baidu.live.ae.a.Qj().buX.aLb);
            }
            return a.byl;
        }
        return a.byn;
    }

    public a g(boolean z, boolean z2) {
        if (z && z2) {
            ar arVar = com.baidu.live.ae.a.Qj().buX;
            if (arVar != null && arVar.aLe > 0 && arVar.aLf > 0) {
                return new a(100, arVar.aLf, arVar.aLe);
            }
            return a.byn;
        }
        return f(z, z2);
    }

    private a dR(int i) {
        if (i == 1) {
            return a.byj;
        }
        if (i == 2) {
            return a.byk;
        }
        if (i == 3) {
            return a.byl;
        }
        if (i == 4) {
            return a.bym;
        }
        return a.byl;
    }

    public static b PF() {
        if (byi == null) {
            synchronized (b.class) {
                if (byi == null) {
                    byi = new b();
                }
            }
        }
        return byi;
    }

    public AlaLiveVideoConfig d(int i, int i2, boolean z) {
        a aVar = null;
        if (i2 == 1) {
            aVar = f(true, false);
        }
        if (aVar == null) {
            aVar = dR(i);
        }
        if (i2 == 1 && !com.baidu.live.ae.a.Qj().buX.aKT) {
            aVar = a.bym;
        }
        AlaLiveVideoConfig isLandscape = new AlaLiveVideoConfig(ht(com.baidu.live.ae.a.Qj().buX.aKV), ht(com.baidu.live.ae.a.Qj().buX.aKW), com.baidu.live.ae.a.Qj().buX.increaseThreshold, com.baidu.live.ae.a.Qj().buX.decreaseThreshold, com.baidu.live.ae.a.Qj().buX.increaseCount, com.baidu.live.ae.a.Qj().buX.aKT, com.baidu.live.ae.a.Qj().buX.aKU, aVar.getWidth(), aVar.getHeight()).setIsLandscape(z);
        isLandscape.setArReportOriginalValue(com.baidu.live.ae.a.Qj().bAS.aPK.isArReportOriginalValue());
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
                alaLiveVideoConfig.getRtcBitRateConfig().resetBitRateItem(ht(com.baidu.live.ae.a.Qj().buX.aKY));
            } else {
                alaLiveVideoConfig.getRtcBitRateConfig().resetBitRateItem(ht(com.baidu.live.ae.a.Qj().buX.aKZ));
            }
        }
    }

    public void a(boolean z, AlaLiveVideoConfig alaLiveVideoConfig, boolean z2) {
        if (alaLiveVideoConfig != null && com.baidu.live.ae.a.Qj().buX != null) {
            if (z2) {
                alaLiveVideoConfig.getRtcBitRateConfig().resetBitRateItem(ht(com.baidu.live.ae.a.Qj().buX.aLh));
                alaLiveVideoConfig.setVideoGOP(com.baidu.live.ae.a.Qj().buX.aLg);
                return;
            }
            alaLiveVideoConfig.setVideoGOP(com.baidu.live.ae.a.Qj().buX.aKS);
        }
    }

    public void PG() {
        if (!this.byg) {
            this.byf.fs(com.baidu.live.ae.a.Qj().buX.aKX);
            AlaNdkAdapter.setDomainConfigEnable(this.byf.aGp ? 1 : 0);
            if (this.byf.aGo.size() > 0 && this.byf.aGn.length() > 0 && this.byf.aGp) {
                for (int i = 0; i < this.byf.aGo.size(); i++) {
                    h.a aVar = this.byf.aGo.get(i);
                    if (aVar != null && aVar.ip != null && aVar.ip.length() > 0) {
                        AlaNdkAdapter.setDomainConfig(this.byf.aGn, aVar.ip, aVar.aGr);
                    }
                }
            }
            this.byg = true;
        }
    }

    public void PH() {
        if (!this.byh) {
            AlaNdkAdapter.setHttpDnsEnable(com.baidu.live.ae.a.Qj().buX.aLi ? 1 : 0);
            AlaNdkAdapter.setPushOptTimestamp(com.baidu.live.ae.a.Qj().buX.aLk ? 1 : 0);
            this.byh = true;
        }
    }

    public static List<DynamicBitRateConfig.DynamicBitRateItem> ht(String str) {
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
    public static class a {
        public static final a byj = new a(1, 1280, 720);
        public static final a byk = new a(2, 1024, 576);
        public static final a byl = new a(3, 960, VideoEncoderConfig.DEFAULT_ENCODE_HIGH_WIDTH);
        public static final a bym = new a(4, 640, EncoderTextureDrawer.X264_WIDTH);
        public static final a byn = new a(0, 480, 270);
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
            if (com.baidu.live.ae.a.Qj().buX != null) {
                alaLiveVideoConfig.setSupportFaceStyle(com.baidu.live.ae.a.Qj().buX.aLo);
            }
            if (com.baidu.live.ae.a.Qj().buX != null) {
                alaLiveVideoConfig.setVideoGOP(com.baidu.live.ae.a.Qj().buX.aKS);
            }
            b(alaLiveVideoConfig);
        }
    }

    private void b(AlaLiveVideoConfig alaLiveVideoConfig) {
        if (com.baidu.live.ae.a.Qj().buX != null && com.baidu.live.ae.a.Qj().buX.aLc != null) {
            try {
                JSONObject jSONObject = new JSONObject(com.baidu.live.ae.a.Qj().buX.aLc);
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
