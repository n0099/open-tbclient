package com.baidu.live.ar;

import android.text.TextUtils;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends BaseData {
    public static b VS = new b();
    public static b VT = new b();
    public String VP = "";
    public String VQ;
    private HashMap<String, Integer> VR;

    public b() {
        this.VQ = "";
        this.VQ = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        pz();
    }

    private void pz() {
        this.VR = new HashMap<>();
        for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
            this.VR.put(beautyAdjustKey.getJsonKey(), 0);
        }
    }

    public int cS(String str) {
        if (TextUtils.isEmpty(str) || this.VR == null || this.VR.isEmpty() || this.VR.get(str) == null) {
            return 0;
        }
        return this.VR.get(str).intValue();
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
    }
}
