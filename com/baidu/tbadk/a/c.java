package com.baidu.tbadk.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private static c dCf;
    private final HashMap<String, e> mSwitchs = new HashMap<>();
    private final HashMap<BdUniqueId, com.baidu.tbadk.a.a.a> dCg = new HashMap<>();

    private c() {
        aNH();
        D(aNG());
    }

    private void aNH() {
        a(new com.baidu.tbadk.a.a.c());
    }

    public static c aNI() {
        if (dCf == null) {
            synchronized (c.class) {
                if (dCf == null) {
                    dCf = new c();
                }
            }
        }
        return dCf;
    }

    protected void a(com.baidu.tbadk.a.a.a aVar) {
        if (aVar != null && aVar.aNX() != null) {
            this.dCg.put(aVar.aNX(), aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e j(BdUniqueId bdUniqueId) {
        com.baidu.tbadk.a.a.a aVar = this.dCg.get(bdUniqueId);
        if (aVar == null) {
            return null;
        }
        return aVar.aNZ();
    }

    private void aNJ() {
        for (Map.Entry<BdUniqueId, com.baidu.tbadk.a.a.a> entry : this.dCg.entrySet()) {
            com.baidu.tbadk.a.a.a value = entry.getValue();
            if (value != null) {
                b(value);
            }
        }
    }

    private void b(com.baidu.tbadk.a.a.a aVar) {
        e eVar = null;
        if (aVar != null) {
            ArrayList<String> aNY = aVar.aNY();
            if (w.isEmpty(aNY)) {
                aVar.a(null);
                return;
            }
            Iterator<String> it = aNY.iterator();
            while (it.hasNext()) {
                eVar = this.mSwitchs.get(it.next());
                if (eVar != null) {
                    break;
                }
            }
            aVar.a(eVar);
        }
    }

    private static String aNK() {
        return "ubs_abtest_config";
    }

    public synchronized e uM(String str) {
        return this.mSwitchs.get(str);
    }

    private void D(HashMap<String, e> hashMap) {
        synchronized (this.mSwitchs) {
            this.mSwitchs.clear();
            if (hashMap != null) {
                this.mSwitchs.putAll(hashMap);
            }
            aNJ();
        }
    }

    public void J(JSONArray jSONArray) {
        try {
            String aNK = aNK();
            if (jSONArray == null) {
                this.mSwitchs.clear();
                com.baidu.tbadk.core.sharedPref.b.aVP().remove(aNK);
                return;
            }
            HashMap<String, e> hashMap = new HashMap<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    String optString = jSONObject.optString(UbcStatConstant.KEY_CONTENT_EXT_SID);
                    hashMap.put(optString, new e(optString));
                }
            }
            D(hashMap);
            com.baidu.tbadk.core.sharedPref.b.aVP().putString(aNK, jSONArray.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private HashMap<String, e> aNG() {
        HashMap<String, e> hashMap = new HashMap<>();
        try {
            aNK();
            JSONArray jSONArray = new JSONArray(com.baidu.tbadk.core.sharedPref.b.aVP().getString(aNK(), "[]"));
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    String optString = jSONObject.optString(UbcStatConstant.KEY_CONTENT_EXT_SID);
                    hashMap.put(optString, new e(optString));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashMap;
    }
}
