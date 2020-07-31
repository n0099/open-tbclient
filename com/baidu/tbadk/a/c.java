package com.baidu.tbadk.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private static c dIb;
    private final HashMap<String, e> mSwitchs = new HashMap<>();
    private final HashMap<BdUniqueId, com.baidu.tbadk.a.a.a> dIc = new HashMap<>();
    private final HashMap<BdUniqueId, e> dId = new HashMap<>();

    private c() {
        aRv();
        C(aRu());
    }

    private void aRv() {
        a(new com.baidu.tbadk.a.a.e());
        a(new com.baidu.tbadk.a.a.d());
        a(new com.baidu.tbadk.a.a.b());
    }

    public static c aRw() {
        if (dIb == null) {
            synchronized (c.class) {
                if (dIb == null) {
                    dIb = new c();
                }
            }
        }
        return dIb;
    }

    protected void a(com.baidu.tbadk.a.a.a aVar) {
        if (aVar != null && aVar.aRS() != null) {
            this.dIc.put(aVar.aRS(), aVar);
        }
    }

    public Map<BdUniqueId, e> aRx() {
        return this.dId;
    }

    private void aRy() {
        this.dId.clear();
        for (BdUniqueId bdUniqueId : this.dIc.keySet()) {
            this.dId.put(bdUniqueId, j(bdUniqueId));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e j(BdUniqueId bdUniqueId) {
        com.baidu.tbadk.a.a.a aVar = this.dIc.get(bdUniqueId);
        if (aVar == null) {
            return null;
        }
        return aVar.aRU();
    }

    private void aRz() {
        for (Map.Entry<BdUniqueId, com.baidu.tbadk.a.a.a> entry : this.dIc.entrySet()) {
            com.baidu.tbadk.a.a.a value = entry.getValue();
            if (value != null) {
                b(value);
            }
        }
        aRy();
    }

    private void b(com.baidu.tbadk.a.a.a aVar) {
        e eVar = null;
        if (aVar != null) {
            ArrayList<String> aRT = aVar.aRT();
            if (x.isEmpty(aRT)) {
                aVar.a((e) null);
                return;
            }
            Iterator<String> it = aRT.iterator();
            while (it.hasNext()) {
                eVar = this.mSwitchs.get(it.next());
                if (eVar != null) {
                    break;
                }
            }
            aVar.a(eVar);
        }
    }

    private static String aRA() {
        return "ubs_abtest_config";
    }

    public synchronized e vO(String str) {
        return this.mSwitchs.get(str);
    }

    private void C(HashMap<String, e> hashMap) {
        synchronized (this.mSwitchs) {
            this.mSwitchs.clear();
            if (hashMap != null) {
                this.mSwitchs.putAll(hashMap);
            }
            aRz();
        }
    }

    public void K(JSONArray jSONArray) {
        try {
            String aRA = aRA();
            if (jSONArray == null) {
                this.mSwitchs.clear();
                com.baidu.tbadk.core.sharedPref.b.aZP().remove(aRA);
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
            C(hashMap);
            com.baidu.tbadk.core.sharedPref.b.aZP().putString(aRA, jSONArray.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private HashMap<String, e> aRu() {
        HashMap<String, e> hashMap = new HashMap<>();
        try {
            aRA();
            JSONArray jSONArray = new JSONArray(com.baidu.tbadk.core.sharedPref.b.aZP().getString(aRA(), "[]"));
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
