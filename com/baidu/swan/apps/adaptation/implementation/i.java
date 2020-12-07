package com.baidu.swan.apps.adaptation.implementation;

import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.swan.apps.adaptation.a.w;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class i implements com.baidu.swan.apps.adaptation.a.w {
    @Override // com.baidu.swan.apps.adaptation.a.w
    public void a(Bitmap bitmap, HashMap<String, String> hashMap, File[] fileArr, w.a aVar) {
        a(aVar);
    }

    @Override // com.baidu.swan.apps.adaptation.a.w
    public void a(HashMap<String, String> hashMap, File file, w.a aVar) {
        a(aVar);
    }

    @Override // com.baidu.swan.apps.adaptation.a.w
    public void a(HashMap<String, String> hashMap, File file, w.a aVar, String str) {
        a(aVar);
    }

    @Override // com.baidu.swan.apps.adaptation.a.w
    public void e(Context context, String str, String str2, String str3) {
    }

    private void a(w.a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", "success");
            aVar.onResult(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
