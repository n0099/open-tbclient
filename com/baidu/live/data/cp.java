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
/* loaded from: classes4.dex */
public class cp {
    public static cp aTG = new cp();
    public int aTA;
    public int aTD;
    public int aTE;
    public String aTF;
    public int aTx;
    public int aTy;
    public int aTz;
    public List<a> dataList;
    public int fps;

    static {
        aTG.fps = 15;
        aTG.aTx = 720;
        aTG.aTy = PlatformPlugin.DEFAULT_SYSTEM_UI;
        aTG.aTz = FeatureCodes.ADVANCE_BEAUTY;
        aTG.aTA = 1100;
        aTG.aTD = 800;
        aTG.aTE = 1100;
        aTG.aTF = "meg_public_show_2x.png";
        aTG.dataList = a.aTC;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.fps = jSONObject.optInt(AlaRecorderLog.KEY_CANERA_START_FPS, aTG.fps);
                this.aTx = jSONObject.optInt("video_w", aTG.aTx);
                this.aTy = jSONObject.optInt("video_h", aTG.aTy);
                this.aTF = jSONObject.optString("bgp", aTG.aTF);
                this.aTz = jSONObject.optInt("max_bitrate", aTG.aTz);
                this.aTA = jSONObject.optInt("min_bitrate", aTG.aTA);
                this.aTD = jSONObject.optInt("rtc_min_bitrate", aTG.aTD);
                this.aTE = jSONObject.optInt("rtc_max_bitrate", aTG.aTE);
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
                this.dataList = a.aTC;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        public static List<a> aTC = new ArrayList();
        public int height;
        public String order;
        public int shape;
        public int width;
        public int x;
        public int y;
        public int z;

        static {
            a aVar = new a();
            aVar.order = "0";
            aVar.shape = 1;
            aVar.x = 264;
            aVar.y = Opcodes.IFNE;
            aVar.z = 1;
            aVar.width = 192;
            aVar.height = 192;
            aTC.add(aVar);
            a aVar2 = new a();
            aVar2.order = "1";
            aVar2.shape = 0;
            aVar2.x = 0;
            aVar2.y = 250;
            aVar2.z = 0;
            aVar2.width = EncoderTextureDrawer.X264_WIDTH;
            aVar2.height = 480;
            aTC.add(aVar2);
            a aVar3 = new a();
            aVar3.order = "2";
            aVar3.shape = 0;
            aVar3.x = EncoderTextureDrawer.X264_WIDTH;
            aVar3.y = 250;
            aVar3.z = 0;
            aVar3.width = EncoderTextureDrawer.X264_WIDTH;
            aVar3.height = 480;
            aTC.add(aVar3);
        }

        public void parserJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                try {
                    this.order = jSONObject.optString(IMConstants.SERVICE_TYPE_ORDER);
                    this.shape = jSONObject.optInt("shape");
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
