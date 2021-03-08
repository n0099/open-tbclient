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
/* loaded from: classes10.dex */
public class cx {
    public static cx aUt = new cx();
    public int aUk;
    public int aUl;
    public int aUm;
    public int aUn;
    public int aUq;
    public int aUr;
    public String aUs;
    public List<a> dataList;
    public int fps;
    public int maxBitrate;

    static {
        aUt.fps = 15;
        aUt.aUk = 720;
        aUt.aUl = 1280;
        aUt.maxBitrate = FeatureCodes.ADVANCE_BEAUTY;
        aUt.aUm = 1100;
        aUt.aUq = 800;
        aUt.aUr = 1100;
        aUt.aUn = 3;
        aUt.aUs = "meg_public_show_2x.png";
        aUt.dataList = a.aUp;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.fps = jSONObject.optInt(AlaRecorderLog.KEY_CANERA_START_FPS, aUt.fps);
                this.aUk = jSONObject.optInt("video_w", aUt.aUk);
                this.aUl = jSONObject.optInt("video_h", aUt.aUl);
                this.aUs = jSONObject.optString("bgp", aUt.aUs);
                this.maxBitrate = jSONObject.optInt("max_bitrate", aUt.maxBitrate);
                this.aUm = jSONObject.optInt("min_bitrate", aUt.aUm);
                this.aUq = jSONObject.optInt("rtc_min_bitrate", aUt.aUq);
                this.aUr = jSONObject.optInt("rtc_max_bitrate", aUt.aUr);
                this.aUn = jSONObject.optInt("yy_publish_codec_mode_android", aUt.aUn);
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
                this.dataList = a.aUp;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        public static List<a> aUp = new ArrayList();
        public int aUu;
        public int height;
        public String order;
        public int width;
        public int x;
        public int y;
        public int z;

        static {
            a aVar = new a();
            aVar.order = "0";
            aVar.aUu = 1;
            aVar.x = 264;
            aVar.y = Opcodes.IFNE;
            aVar.z = 1;
            aVar.width = 192;
            aVar.height = 192;
            aUp.add(aVar);
            a aVar2 = new a();
            aVar2.order = "1";
            aVar2.aUu = 0;
            aVar2.x = 0;
            aVar2.y = 250;
            aVar2.z = 0;
            aVar2.width = EncoderTextureDrawer.X264_WIDTH;
            aVar2.height = 480;
            aUp.add(aVar2);
            a aVar3 = new a();
            aVar3.order = "2";
            aVar3.aUu = 0;
            aVar3.x = EncoderTextureDrawer.X264_WIDTH;
            aVar3.y = 250;
            aVar3.z = 0;
            aVar3.width = EncoderTextureDrawer.X264_WIDTH;
            aVar3.height = 480;
            aUp.add(aVar3);
        }

        public void parserJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                try {
                    this.order = jSONObject.optString(IMConstants.SERVICE_TYPE_ORDER);
                    this.aUu = jSONObject.optInt("shape");
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
