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
    public static cn aSp = new cn();
    public int aSg;
    public int aSh;
    public int aSi;
    public int aSj;
    public int aSm;
    public int aSn;
    public String aSo;
    public List<a> dataList;
    public int fps;

    static {
        aSp.fps = 15;
        aSp.aSg = 720;
        aSp.aSh = PlatformPlugin.DEFAULT_SYSTEM_UI;
        aSp.aSi = FeatureCodes.ADVANCE_BEAUTY;
        aSp.aSj = 1100;
        aSp.aSm = 800;
        aSp.aSn = 1100;
        aSp.aSo = "meg_public_show_2x.png";
        aSp.dataList = a.aSl;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.fps = jSONObject.optInt("fps", aSp.fps);
                this.aSg = jSONObject.optInt("video_w", aSp.aSg);
                this.aSh = jSONObject.optInt("video_h", aSp.aSh);
                this.aSo = jSONObject.optString("bgp", aSp.aSo);
                this.aSi = jSONObject.optInt("max_bitrate", aSp.aSi);
                this.aSj = jSONObject.optInt("min_bitrate", aSp.aSj);
                this.aSm = jSONObject.optInt("rtc_min_bitrate", aSp.aSm);
                this.aSn = jSONObject.optInt("rtc_max_bitrate", aSp.aSn);
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
                this.dataList = a.aSl;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        public static List<a> aSl = new ArrayList();
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
            aSl.add(aVar);
            a aVar2 = new a();
            aVar2.order = "1";
            aVar2.shape = 0;
            aVar2.x = 0;
            aVar2.y = 250;
            aVar2.z = 0;
            aVar2.width = EncoderTextureDrawer.X264_WIDTH;
            aVar2.height = 480;
            aSl.add(aVar2);
            a aVar3 = new a();
            aVar3.order = "2";
            aVar3.shape = 0;
            aVar3.x = EncoderTextureDrawer.X264_WIDTH;
            aVar3.y = 250;
            aVar3.z = 0;
            aVar3.width = EncoderTextureDrawer.X264_WIDTH;
            aVar3.height = 480;
            aSl.add(aVar3);
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
