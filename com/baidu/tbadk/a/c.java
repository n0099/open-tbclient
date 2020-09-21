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
    private static c dTw;
    private final HashMap<String, e> mSwitchs = new HashMap<>();
    private final HashMap<BdUniqueId, com.baidu.tbadk.a.a.a> dTx = new HashMap<>();
    private final HashMap<BdUniqueId, e> dTy = new HashMap<>();

    private c() {
        baB();
        A(baA());
    }

    private void baB() {
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

    public static c baC() {
        if (dTw == null) {
            synchronized (c.class) {
                if (dTw == null) {
                    dTw = new c();
                }
            }
        }
        return dTw;
    }

    protected void a(com.baidu.tbadk.a.a.a aVar) {
        if (aVar != null && aVar.bbd() != null) {
            this.dTx.put(aVar.bbd(), aVar);
        }
    }

    public Map<BdUniqueId, e> baD() {
        return this.dTy;
    }

    private void baE() {
        this.dTy.clear();
        for (BdUniqueId bdUniqueId : this.dTx.keySet()) {
            this.dTy.put(bdUniqueId, j(bdUniqueId));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e j(BdUniqueId bdUniqueId) {
        com.baidu.tbadk.a.a.a aVar = this.dTx.get(bdUniqueId);
        if (aVar == null) {
            return null;
        }
        return aVar.bbf();
    }

    private void baF() {
        for (Map.Entry<BdUniqueId, com.baidu.tbadk.a.a.a> entry : this.dTx.entrySet()) {
            com.baidu.tbadk.a.a.a value = entry.getValue();
            if (value != null) {
                b(value);
            }
        }
        baE();
    }

    private void b(com.baidu.tbadk.a.a.a aVar) {
        e eVar = null;
        if (aVar != null) {
            ArrayList<String> bbe = aVar.bbe();
            if (y.isEmpty(bbe)) {
                aVar.a((e) null);
                return;
            }
            Iterator<String> it = bbe.iterator();
            while (it.hasNext()) {
                eVar = this.mSwitchs.get(it.next());
                if (eVar != null) {
                    break;
                }
            }
            aVar.a(eVar);
        }
    }

    private static String baG() {
        return "ubs_abtest_config";
    }

    public synchronized e yu(String str) {
        return this.mSwitchs.get(str);
    }

    private void A(HashMap<String, e> hashMap) {
        synchronized (this.mSwitchs) {
            this.mSwitchs.clear();
            if (hashMap != null) {
                this.mSwitchs.putAll(hashMap);
            }
            baF();
        }
    }

    public void M(JSONArray jSONArray) {
        try {
            String baG = baG();
            if (jSONArray == null) {
                this.mSwitchs.clear();
                com.baidu.tbadk.core.sharedPref.b.bjf().remove(baG);
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
            com.baidu.tbadk.core.sharedPref.b.bjf().putString(baG, jSONArray.toString());
            baH();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void baH() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921506, 1));
    }

    private HashMap<String, e> baA() {
        HashMap<String, e> hashMap = new HashMap<>();
        try {
            baG();
            JSONArray jSONArray = new JSONArray(com.baidu.tbadk.core.sharedPref.b.bjf().getString(baG(), "[]"));
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
