package com.baidu.swan.apps.adaptation.implementation;

import android.graphics.Bitmap;
import com.baidu.swan.apps.adaptation.a.u;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class i implements com.baidu.swan.apps.adaptation.a.u {
    @Override // com.baidu.swan.apps.adaptation.a.u
    public void a(Bitmap bitmap, HashMap<String, String> hashMap, File[] fileArr, u.a aVar) {
        a(aVar);
    }

    @Override // com.baidu.swan.apps.adaptation.a.u
    public void a(HashMap<String, String> hashMap, File file, u.a aVar) {
        a(aVar);
    }

    @Override // com.baidu.swan.apps.adaptation.a.u
    public void a(HashMap<String, String> hashMap, File file, u.a aVar, String str) {
        a(aVar);
    }

    private void a(u.a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", "success");
            aVar.onResult(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
