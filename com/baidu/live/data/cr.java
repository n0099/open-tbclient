package com.baidu.live.data;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.mobstat.Config;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class cr {
    public static cr aPQ = new cr();
    public int aPI;
    public int aPJ;
    public int aPK;
    public int aPN;
    public int aPO;
    public String aPP;
    public List<a> dataList;
    public int fps;
    public int maxBitrate;

    static {
        aPQ.fps = 15;
        aPQ.aPI = 720;
        aPQ.aPJ = PlatformPlugin.DEFAULT_SYSTEM_UI;
        aPQ.maxBitrate = FeatureCodes.ADVANCE_BEAUTY;
        aPQ.aPK = 1100;
        aPQ.aPN = 800;
        aPQ.aPO = 1100;
        aPQ.aPP = "meg_public_show_2x.png";
        aPQ.dataList = a.aPM;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.fps = jSONObject.optInt(AlaRecorderLog.KEY_CANERA_START_FPS, aPQ.fps);
                this.aPI = jSONObject.optInt("video_w", aPQ.aPI);
                this.aPJ = jSONObject.optInt("video_h", aPQ.aPJ);
                this.aPP = jSONObject.optString("bgp", aPQ.aPP);
                this.maxBitrate = jSONObject.optInt("max_bitrate", aPQ.maxBitrate);
                this.aPK = jSONObject.optInt("min_bitrate", aPQ.aPK);
                this.aPN = jSONObject.optInt("rtc_min_bitrate", aPQ.aPN);
                this.aPO = jSONObject.optInt("rtc_max_bitrate", aPQ.aPO);
                JSONArray optJSONArray = jSONObject.optJSONArray("list");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.dataList = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            a aVar = new a();
                            aVar.parserJson(optJSONObject);
                            this.dataList.add(aVar);
                        }
                    }
                    return;
                }
                this.dataList = a.aPM;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        public static List<a> aPM = new ArrayList();
        public int aPR;
        public int height;
        public String order;
        public int width;
        public int x;
        public int y;
        public int z;

        static {
            a aVar = new a();
            aVar.order = "0";
            aVar.aPR = 1;
            aVar.x = 264;
            aVar.y = Opcodes.IFNE;
            aVar.z = 1;
            aVar.width = 192;
            aVar.height = 192;
            aPM.add(aVar);
            a aVar2 = new a();
            aVar2.order = "1";
            aVar2.aPR = 0;
            aVar2.x = 0;
            aVar2.y = 250;
            aVar2.z = 0;
            aVar2.width = EncoderTextureDrawer.X264_WIDTH;
            aVar2.height = 480;
            aPM.add(aVar2);
            a aVar3 = new a();
            aVar3.order = "2";
            aVar3.aPR = 0;
            aVar3.x = EncoderTextureDrawer.X264_WIDTH;
            aVar3.y = 250;
            aVar3.z = 0;
            aVar3.width = EncoderTextureDrawer.X264_WIDTH;
            aVar3.height = 480;
            aPM.add(aVar3);
        }

        public void parserJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                try {
                    this.order = jSONObject.optString(IMConstants.SERVICE_TYPE_ORDER);
                    this.aPR = jSONObject.optInt("shape");
                    this.x = jSONObject.optInt(Config.EVENT_HEAT_X);
                    this.y = jSONObject.optInt("y");
                    this.z = jSONObject.optInt("z");
                    this.width = jSONObject.optInt("width");
                    this.height = jSONObject.optInt("height");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
