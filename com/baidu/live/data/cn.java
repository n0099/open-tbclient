package com.baidu.live.data;

import com.alibaba.fastjson.asm.Opcodes;
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
public class cn {
    public static cn aQE = new cn();
    public int aQB;
    public int aQC;
    public String aQD;
    public int aQv;
    public int aQw;
    public int aQx;
    public int aQy;
    public List<a> dataList;
    public int fps;

    static {
        aQE.fps = 15;
        aQE.aQv = 720;
        aQE.aQw = PlatformPlugin.DEFAULT_SYSTEM_UI;
        aQE.aQx = FeatureCodes.ADVANCE_BEAUTY;
        aQE.aQy = 1100;
        aQE.aQB = 800;
        aQE.aQC = 1100;
        aQE.aQD = "meg_public_show_2x.png";
        aQE.dataList = a.aQA;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.fps = jSONObject.optInt("fps", aQE.fps);
                this.aQv = jSONObject.optInt("video_w", aQE.aQv);
                this.aQw = jSONObject.optInt("video_h", aQE.aQw);
                this.aQD = jSONObject.optString("bgp", aQE.aQD);
                this.aQx = jSONObject.optInt("max_bitrate", aQE.aQx);
                this.aQy = jSONObject.optInt("min_bitrate", aQE.aQy);
                this.aQB = jSONObject.optInt("rtc_min_bitrate", aQE.aQB);
                this.aQC = jSONObject.optInt("rtc_max_bitrate", aQE.aQC);
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
                this.dataList = a.aQA;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        public static List<a> aQA = new ArrayList();
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
            aQA.add(aVar);
            a aVar2 = new a();
            aVar2.order = "1";
            aVar2.shape = 0;
            aVar2.x = 0;
            aVar2.y = 250;
            aVar2.z = 0;
            aVar2.width = EncoderTextureDrawer.X264_WIDTH;
            aVar2.height = 480;
            aQA.add(aVar2);
            a aVar3 = new a();
            aVar3.order = "2";
            aVar3.shape = 0;
            aVar3.x = EncoderTextureDrawer.X264_WIDTH;
            aVar3.y = 250;
            aVar3.z = 0;
            aVar3.width = EncoderTextureDrawer.X264_WIDTH;
            aVar3.height = 480;
            aQA.add(aVar3);
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
