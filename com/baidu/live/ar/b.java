package com.baidu.live.ar;

import android.text.TextUtils;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.tbadk.core.data.BaseData;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends BaseData {
    public static b Wc = new b();
    public static b We = new b();
    public String VZ = "";
    public String Wa;
    private HashMap<String, Integer> Wb;

    public b() {
        this.Wa = "";
        this.Wa = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        pE();
    }

    private void pE() {
        this.Wb = new HashMap<>();
        for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
            this.Wb.put(beautyAdjustKey.getJsonKey(), 0);
        }
    }

    public int cR(String str) {
        if (TextUtils.isEmpty(str) || this.Wb == null || this.Wb.isEmpty() || this.Wb.get(str) == null) {
            return 0;
        }
        return this.Wb.get(str).intValue();
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
    }
}
