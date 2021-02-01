package com.baidu.live.data;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class cx {
    public static cx aST = new cx();
    public int aSK;
    public int aSL;
    public int aSM;
    public int aSN;
    public int aSQ;
    public int aSR;
    public String aSS;
    public List<a> dataList;
    public int fps;
    public int maxBitrate;

    static {
        aST.fps = 15;
        aST.aSK = 720;
        aST.aSL = 1280;
        aST.maxBitrate = FeatureCodes.ADVANCE_BEAUTY;
        aST.aSM = 1100;
        aST.aSQ = 800;
        aST.aSR = 1100;
        aST.aSN = 3;
        aST.aSS = "meg_public_show_2x.png";
        aST.dataList = a.aSP;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.fps = jSONObject.optInt(AlaRecorderLog.KEY_CANERA_START_FPS, aST.fps);
                this.aSK = jSONObject.optInt("video_w", aST.aSK);
                this.aSL = jSONObject.optInt("video_h", aST.aSL);
                this.aSS = jSONObject.optString("bgp", aST.aSS);
                this.maxBitrate = jSONObject.optInt("max_bitrate", aST.maxBitrate);
                this.aSM = jSONObject.optInt("min_bitrate", aST.aSM);
                this.aSQ = jSONObject.optInt("rtc_min_bitrate", aST.aSQ);
                this.aSR = jSONObject.optInt("rtc_max_bitrate", aST.aSR);
                this.aSN = jSONObject.optInt("yy_publish_codec_mode_android", aST.aSN);
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
                this.dataList = a.aSP;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        public static List<a> aSP = new ArrayList();
        public int aSU;
        public int height;
        public String order;
        public int width;
        public int x;
        public int y;
        public int z;

        static {
            a aVar = new a();
            aVar.order = "0";
            aVar.aSU = 1;
            aVar.x = 264;
            aVar.y = Opcodes.IFNE;
            aVar.z = 1;
            aVar.width = 192;
            aVar.height = 192;
            aSP.add(aVar);
            a aVar2 = new a();
            aVar2.order = "1";
            aVar2.aSU = 0;
            aVar2.x = 0;
            aVar2.y = 250;
            aVar2.z = 0;
            aVar2.width = EncoderTextureDrawer.X264_WIDTH;
            aVar2.height = 480;
            aSP.add(aVar2);
            a aVar3 = new a();
            aVar3.order = "2";
            aVar3.aSU = 0;
            aVar3.x = EncoderTextureDrawer.X264_WIDTH;
            aVar3.y = 250;
            aVar3.z = 0;
            aVar3.width = EncoderTextureDrawer.X264_WIDTH;
            aVar3.height = 480;
            aSP.add(aVar3);
        }

        public void parserJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                try {
                    this.order = jSONObject.optString(IMConstants.SERVICE_TYPE_ORDER);
                    this.aSU = jSONObject.optInt("shape");
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
