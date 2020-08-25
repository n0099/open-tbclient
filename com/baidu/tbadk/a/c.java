package com.baidu.tbadk.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tbadk.a.a.f;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    private static c dRi;
    private final HashMap<String, e> mSwitchs = new HashMap<>();
    private final HashMap<BdUniqueId, com.baidu.tbadk.a.a.a> dRj = new HashMap<>();
    private final HashMap<BdUniqueId, e> dRk = new HashMap<>();

    private c() {
        aZM();
        A(aZL());
    }

    private void aZM() {
        a(new f());
        a(new com.baidu.tbadk.a.a.e());
        a(new com.baidu.tbadk.a.a.b());
        a(new com.baidu.tbadk.a.a.c());
    }

    public static c aZN() {
        if (dRi == null) {
            synchronized (c.class) {
                if (dRi == null) {
                    dRi = new c();
                }
            }
        }
        return dRi;
    }

    protected void a(com.baidu.tbadk.a.a.a aVar) {
        if (aVar != null && aVar.baj() != null) {
            this.dRj.put(aVar.baj(), aVar);
        }
    }

    public Map<BdUniqueId, e> aZO() {
        return this.dRk;
    }

    private void aZP() {
        this.dRk.clear();
        for (BdUniqueId bdUniqueId : this.dRj.keySet()) {
            this.dRk.put(bdUniqueId, j(bdUniqueId));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e j(BdUniqueId bdUniqueId) {
        com.baidu.tbadk.a.a.a aVar = this.dRj.get(bdUniqueId);
        if (aVar == null) {
            return null;
        }
        return aVar.bal();
    }

    private void aZQ() {
        for (Map.Entry<BdUniqueId, com.baidu.tbadk.a.a.a> entry : this.dRj.entrySet()) {
            com.baidu.tbadk.a.a.a value = entry.getValue();
            if (value != null) {
                b(value);
            }
        }
        aZP();
    }

    private void b(com.baidu.tbadk.a.a.a aVar) {
        e eVar = null;
        if (aVar != null) {
            ArrayList<String> bak = aVar.bak();
            if (y.isEmpty(bak)) {
                aVar.a((e) null);
                return;
            }
            Iterator<String> it = bak.iterator();
            while (it.hasNext()) {
                eVar = this.mSwitchs.get(it.next());
                if (eVar != null) {
                    break;
                }
            }
            aVar.a(eVar);
        }
    }

    private static String aZR() {
        return "ubs_abtest_config";
    }

    public synchronized e xZ(String str) {
        return this.mSwitchs.get(str);
    }

    private void A(HashMap<String, e> hashMap) {
        synchronized (this.mSwitchs) {
            this.mSwitchs.clear();
            if (hashMap != null) {
                this.mSwitchs.putAll(hashMap);
            }
            aZQ();
        }
    }

    public void M(JSONArray jSONArray) {
        try {
            String aZR = aZR();
            if (jSONArray == null) {
                this.mSwitchs.clear();
                com.baidu.tbadk.core.sharedPref.b.bik().remove(aZR);
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
            A(hashMap);
            com.baidu.tbadk.core.sharedPref.b.bik().putString(aZR, jSONArray.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private HashMap<String, e> aZL() {
        HashMap<String, e> hashMap = new HashMap<>();
        try {
            aZR();
            JSONArray jSONArray = new JSONArray(com.baidu.tbadk.core.sharedPref.b.bik().getString(aZR(), "[]"));
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
