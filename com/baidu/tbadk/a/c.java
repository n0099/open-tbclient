package com.baidu.tbadk.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private static c dwZ;
    private final HashMap<String, e> mSwitchs = new HashMap<>();
    private final HashMap<BdUniqueId, com.baidu.tbadk.a.a.a> dxa = new HashMap<>();

    private c() {
        aMe();
        D(aMd());
    }

    private void aMe() {
        a(new com.baidu.tbadk.a.a.c());
    }

    public static c aMf() {
        if (dwZ == null) {
            synchronized (c.class) {
                if (dwZ == null) {
                    dwZ = new c();
                }
            }
        }
        return dwZ;
    }

    protected void a(com.baidu.tbadk.a.a.a aVar) {
        if (aVar != null && aVar.aMu() != null) {
            this.dxa.put(aVar.aMu(), aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e j(BdUniqueId bdUniqueId) {
        com.baidu.tbadk.a.a.a aVar = this.dxa.get(bdUniqueId);
        if (aVar == null) {
            return null;
        }
        return aVar.aMw();
    }

    private void aMg() {
        for (Map.Entry<BdUniqueId, com.baidu.tbadk.a.a.a> entry : this.dxa.entrySet()) {
            com.baidu.tbadk.a.a.a value = entry.getValue();
            if (value != null) {
                b(value);
            }
        }
    }

    private void b(com.baidu.tbadk.a.a.a aVar) {
        e eVar = null;
        if (aVar != null) {
            ArrayList<String> aMv = aVar.aMv();
            if (v.isEmpty(aMv)) {
                aVar.a(null);
                return;
            }
            Iterator<String> it = aMv.iterator();
            while (it.hasNext()) {
                eVar = this.mSwitchs.get(it.next());
                if (eVar != null) {
                    break;
                }
            }
            aVar.a(eVar);
        }
    }

    private static String aMh() {
        return "ubs_abtest_config";
    }

    public synchronized e uE(String str) {
        return this.mSwitchs.get(str);
    }

    private void D(HashMap<String, e> hashMap) {
        synchronized (this.mSwitchs) {
            this.mSwitchs.clear();
            if (hashMap != null) {
                this.mSwitchs.putAll(hashMap);
            }
            aMg();
        }
    }

    public void J(JSONArray jSONArray) {
        try {
            String aMh = aMh();
            if (jSONArray == null) {
                this.mSwitchs.clear();
                com.baidu.tbadk.core.sharedPref.b.aTX().remove(aMh);
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
            com.baidu.tbadk.core.sharedPref.b.aTX().putString(aMh, jSONArray.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private HashMap<String, e> aMd() {
        HashMap<String, e> hashMap = new HashMap<>();
        try {
            aMh();
            JSONArray jSONArray = new JSONArray(com.baidu.tbadk.core.sharedPref.b.aTX().getString(aMh(), "[]"));
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
