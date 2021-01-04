package com.baidu.live.data;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.platform.comapi.map.MapBundleKey;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class cr {
    public static cr aUD = new cr();
    public int aUA;
    public int aUB;
    public String aUC;
    public int aUv;
    public int aUw;
    public int aUx;
    public List<a> dataList;
    public int fps;
    public int maxBitrate;

    static {
        aUD.fps = 15;
        aUD.aUv = 720;
        aUD.aUw = PlatformPlugin.DEFAULT_SYSTEM_UI;
        aUD.maxBitrate = FeatureCodes.ADVANCE_BEAUTY;
        aUD.aUx = 1100;
        aUD.aUA = 800;
        aUD.aUB = 1100;
        aUD.aUC = "meg_public_show_2x.png";
        aUD.dataList = a.aUz;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.fps = jSONObject.optInt(AlaRecorderLog.KEY_CANERA_START_FPS, aUD.fps);
                this.aUv = jSONObject.optInt("video_w", aUD.aUv);
                this.aUw = jSONObject.optInt("video_h", aUD.aUw);
                this.aUC = jSONObject.optString("bgp", aUD.aUC);
                this.maxBitrate = jSONObject.optInt("max_bitrate", aUD.maxBitrate);
                this.aUx = jSONObject.optInt("min_bitrate", aUD.aUx);
                this.aUA = jSONObject.optInt("rtc_min_bitrate", aUD.aUA);
                this.aUB = jSONObject.optInt("rtc_max_bitrate", aUD.aUB);
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
                this.dataList = a.aUz;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        public static List<a> aUz = new ArrayList();
        public int aUE;
        public int height;
        public String order;
        public int width;
        public int x;
        public int y;
        public int z;

        static {
            a aVar = new a();
            aVar.order = "0";
            aVar.aUE = 1;
            aVar.x = 264;
            aVar.y = Opcodes.IFNE;
            aVar.z = 1;
            aVar.width = 192;
            aVar.height = 192;
            aUz.add(aVar);
            a aVar2 = new a();
            aVar2.order = "1";
            aVar2.aUE = 0;
            aVar2.x = 0;
            aVar2.y = 250;
            aVar2.z = 0;
            aVar2.width = EncoderTextureDrawer.X264_WIDTH;
            aVar2.height = 480;
            aUz.add(aVar2);
            a aVar3 = new a();
            aVar3.order = "2";
            aVar3.aUE = 0;
            aVar3.x = EncoderTextureDrawer.X264_WIDTH;
            aVar3.y = 250;
            aVar3.z = 0;
            aVar3.width = EncoderTextureDrawer.X264_WIDTH;
            aVar3.height = 480;
            aUz.add(aVar3);
        }

        public void parserJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                try {
                    this.order = jSONObject.optString(IMConstants.SERVICE_TYPE_ORDER);
                    this.aUE = jSONObject.optInt("shape");
                    this.x = jSONObject.optInt("x");
                    this.y = jSONObject.optInt("y");
                    this.z = jSONObject.optInt(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z);
                    this.width = jSONObject.optInt("width");
                    this.height = jSONObject.optInt("height");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
