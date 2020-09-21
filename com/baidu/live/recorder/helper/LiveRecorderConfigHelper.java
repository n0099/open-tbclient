package com.baidu.live.recorder.helper;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.ala.ndk.AlaNdkAdapter;
import com.baidu.ala.recorder.video.AlaLiveVideoConfig;
import com.baidu.ala.recorder.video.DynamicBitRateConfig;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.live.data.f;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.x.a;
import com.baidu.platform.comapi.UIMsg;
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
    private static volatile LiveRecorderConfigHelper bkt;
    private f bkq = new f();
    private boolean bkr = false;
    private boolean bks = false;

    public VideoResolution f(boolean z, boolean z2) {
        if (!z2) {
            return eP(a.NN().bhy.aGH);
        }
        if (TbadkCoreApplication.getInst().isOther()) {
            if (z && z2) {
                return eP(a.NN().bhy.aGP);
            }
            if (!z && z2) {
                return eP(a.NN().bhy.aGQ);
            }
            return VideoResolution.P540;
        }
        return VideoResolution.RTC;
    }

    private VideoResolution eP(int i) {
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

    public static LiveRecorderConfigHelper Nk() {
        if (bkt == null) {
            synchronized (LiveRecorderConfigHelper.class) {
                if (bkt == null) {
                    bkt = new LiveRecorderConfigHelper();
                }
            }
        }
        return bkt;
    }

    public AlaLiveVideoConfig d(int i, int i2, boolean z) {
        VideoResolution videoResolution = null;
        if (i2 == 1) {
            videoResolution = f(true, false);
        }
        if (videoResolution == null) {
            videoResolution = eP(i);
        }
        if (i2 == 1 && !a.NN().bhy.aGI) {
            videoResolution = VideoResolution.P360;
        }
        AlaLiveVideoConfig isLandscape = new AlaLiveVideoConfig(hr(a.NN().bhy.aGK), hr(a.NN().bhy.aGL), a.NN().bhy.increaseThreshold, a.NN().bhy.decreaseThreshold, a.NN().bhy.increaseCount, a.NN().bhy.aGI, a.NN().bhy.aGJ, videoResolution.getWidth(), videoResolution.getHeight()).setIsLandscape(z);
        if (i2 == 1) {
            isLandscape.setPreviewWidth(720);
            isLandscape.setPreviewHeight(PlatformPlugin.DEFAULT_SYSTEM_UI);
            if (a.NN().bhy != null) {
                isLandscape.setSupportFaceStyle(a.NN().bhy.aGX);
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
                alaLiveVideoConfig.getRtcBitRateConfig().resetBitRateItem(hr(a.NN().bhy.aGN));
            } else {
                alaLiveVideoConfig.getRtcBitRateConfig().resetBitRateItem(hr(a.NN().bhy.aGO));
            }
        }
    }

    public void Nl() {
        if (!this.bkr) {
            this.bkq.fS(a.NN().bhy.aGM);
            AlaNdkAdapter.setDomainConfigEnable(this.bkq.aDN ? 1 : 0);
            if (this.bkq.aDM.size() > 0 && this.bkq.aDL.length() > 0 && this.bkq.aDN) {
                for (int i = 0; i < this.bkq.aDM.size(); i++) {
                    f.a aVar = this.bkq.aDM.get(i);
                    if (aVar != null && aVar.ip != null && aVar.ip.length() > 0) {
                        AlaNdkAdapter.setDomainConfig(this.bkq.aDL, aVar.ip, aVar.aDP);
                    }
                }
            }
            this.bkr = true;
        }
    }

    public void Nm() {
        if (!this.bks) {
            AlaNdkAdapter.setHttpDnsEnable(a.NN().bhy.aGR ? 1 : 0);
            AlaNdkAdapter.setPushOptTimestamp(a.NN().bhy.aGT ? 1 : 0);
            this.bks = true;
        }
    }

    private List<DynamicBitRateConfig.DynamicBitRateItem> hr(String str) {
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
        P540(3, TbConfig.HEAD_IMG_SIZE, UIMsg.MsgDefine.MSG_NETWORK_CHANNEL),
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
}
