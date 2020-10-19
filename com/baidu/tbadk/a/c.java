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
    private static c efx;
    private final HashMap<String, e> mSwitchs = new HashMap<>();
    private final HashMap<BdUniqueId, com.baidu.tbadk.a.a.a> efy = new HashMap<>();
    private final HashMap<BdUniqueId, e> efz = new HashMap<>();

    private c() {
        bdj();
        C(bdi());
    }

    private void bdj() {
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

    public static c bdk() {
        if (efx == null) {
            synchronized (c.class) {
                if (efx == null) {
                    efx = new c();
                }
            }
        }
        return efx;
    }

    protected void a(com.baidu.tbadk.a.a.a aVar) {
        if (aVar != null && aVar.bdL() != null) {
            this.efy.put(aVar.bdL(), aVar);
        }
    }

    public Map<BdUniqueId, e> bdl() {
        return this.efz;
    }

    private void bdm() {
        this.efz.clear();
        for (BdUniqueId bdUniqueId : this.efy.keySet()) {
            this.efz.put(bdUniqueId, j(bdUniqueId));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e j(BdUniqueId bdUniqueId) {
        com.baidu.tbadk.a.a.a aVar = this.efy.get(bdUniqueId);
        if (aVar == null) {
            return null;
        }
        return aVar.bdN();
    }

    private void bdn() {
        for (Map.Entry<BdUniqueId, com.baidu.tbadk.a.a.a> entry : this.efy.entrySet()) {
            com.baidu.tbadk.a.a.a value = entry.getValue();
            if (value != null) {
                b(value);
            }
        }
        bdm();
    }

    private void b(com.baidu.tbadk.a.a.a aVar) {
        e eVar = null;
        if (aVar != null) {
            ArrayList<String> bdM = aVar.bdM();
            if (y.isEmpty(bdM)) {
                aVar.a((e) null);
                return;
            }
            Iterator<String> it = bdM.iterator();
            while (it.hasNext()) {
                eVar = this.mSwitchs.get(it.next());
                if (eVar != null) {
                    break;
                }
            }
            aVar.a(eVar);
        }
    }

    private static String bdo() {
        return "ubs_abtest_config";
    }

    public synchronized e zg(String str) {
        return this.mSwitchs.get(str);
    }

    private void C(HashMap<String, e> hashMap) {
        synchronized (this.mSwitchs) {
            this.mSwitchs.clear();
            if (hashMap != null) {
                this.mSwitchs.putAll(hashMap);
            }
            bdn();
        }
    }

    public void M(JSONArray jSONArray) {
        try {
            String bdo = bdo();
            if (jSONArray == null) {
                this.mSwitchs.clear();
                com.baidu.tbadk.core.sharedPref.b.blO().remove(bdo);
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
            com.baidu.tbadk.core.sharedPref.b.blO().putString(bdo, jSONArray.toString());
            bdp();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void bdp() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921506, 1));
    }

    private HashMap<String, e> bdi() {
        HashMap<String, e> hashMap = new HashMap<>();
        try {
            bdo();
            JSONArray jSONArray = new JSONArray(com.baidu.tbadk.core.sharedPref.b.blO().getString(bdo(), "[]"));
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
