package com.baidu.tbadk.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tbadk.a.a.f;
import com.baidu.tbadk.a.a.h;
import com.baidu.tbadk.a.a.i;
import com.baidu.tbadk.a.a.j;
import com.baidu.tbadk.a.a.k;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private static c etP;
    private final HashMap<String, e> mSwitchs = new HashMap<>();
    private final HashMap<BdUniqueId, com.baidu.tbadk.a.a.a> etQ = new HashMap<>();
    private final HashMap<BdUniqueId, e> etR = new HashMap<>();

    private c() {
        bhC();
        C(bhB());
    }

    private void bhC() {
        a(new k());
        a(new h());
        a(new com.baidu.tbadk.a.a.e());
        a(new f());
        a(new com.baidu.tbadk.a.a.d());
        a(new i());
        a(new j());
        a(new com.baidu.tbadk.a.a.b());
        a(new com.baidu.tbadk.a.a.c());
    }

    public static c bhD() {
        if (etP == null) {
            synchronized (c.class) {
                if (etP == null) {
                    etP = new c();
                }
            }
        }
        return etP;
    }

    protected void a(com.baidu.tbadk.a.a.a aVar) {
        if (aVar != null && aVar.bie() != null) {
            this.etQ.put(aVar.bie(), aVar);
        }
    }

    public Map<BdUniqueId, e> bhE() {
        return this.etR;
    }

    private void bhF() {
        this.etR.clear();
        for (BdUniqueId bdUniqueId : this.etQ.keySet()) {
            this.etR.put(bdUniqueId, j(bdUniqueId));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e j(BdUniqueId bdUniqueId) {
        com.baidu.tbadk.a.a.a aVar = this.etQ.get(bdUniqueId);
        if (aVar == null) {
            return null;
        }
        return aVar.big();
    }

    private void bhG() {
        for (Map.Entry<BdUniqueId, com.baidu.tbadk.a.a.a> entry : this.etQ.entrySet()) {
            com.baidu.tbadk.a.a.a value = entry.getValue();
            if (value != null) {
                b(value);
            }
        }
        bhF();
    }

    private void b(com.baidu.tbadk.a.a.a aVar) {
        e eVar = null;
        if (aVar != null) {
            ArrayList<String> bif = aVar.bif();
            if (y.isEmpty(bif)) {
                aVar.a((e) null);
                return;
            }
            Iterator<String> it = bif.iterator();
            while (it.hasNext()) {
                eVar = this.mSwitchs.get(it.next());
                if (eVar != null) {
                    break;
                }
            }
            aVar.a(eVar);
        }
    }

    private static String bhH() {
        return "ubs_abtest_config";
    }

    public synchronized e zN(String str) {
        return this.mSwitchs.get(str);
    }

    private void C(HashMap<String, e> hashMap) {
        synchronized (this.mSwitchs) {
            this.mSwitchs.clear();
            if (hashMap != null) {
                this.mSwitchs.putAll(hashMap);
            }
            bhG();
        }
    }

    public void M(JSONArray jSONArray) {
        try {
            String bhH = bhH();
            if (jSONArray == null) {
                this.mSwitchs.clear();
                com.baidu.tbadk.core.sharedPref.b.bqh().remove(bhH);
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
            com.baidu.tbadk.core.sharedPref.b.bqh().putString(bhH, jSONArray.toString());
            bhI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void bhI() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921506, 1));
    }

    private HashMap<String, e> bhB() {
        HashMap<String, e> hashMap = new HashMap<>();
        try {
            bhH();
            JSONArray jSONArray = new JSONArray(com.baidu.tbadk.core.sharedPref.b.bqh().getString(bhH(), "[]"));
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
