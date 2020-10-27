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
    private static c enV;
    private final HashMap<String, e> mSwitchs = new HashMap<>();
    private final HashMap<BdUniqueId, com.baidu.tbadk.a.a.a> enW = new HashMap<>();
    private final HashMap<BdUniqueId, e> enX = new HashMap<>();

    private c() {
        bfc();
        C(bfb());
    }

    private void bfc() {
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

    public static c bfd() {
        if (enV == null) {
            synchronized (c.class) {
                if (enV == null) {
                    enV = new c();
                }
            }
        }
        return enV;
    }

    protected void a(com.baidu.tbadk.a.a.a aVar) {
        if (aVar != null && aVar.bfE() != null) {
            this.enW.put(aVar.bfE(), aVar);
        }
    }

    public Map<BdUniqueId, e> bfe() {
        return this.enX;
    }

    private void bff() {
        this.enX.clear();
        for (BdUniqueId bdUniqueId : this.enW.keySet()) {
            this.enX.put(bdUniqueId, j(bdUniqueId));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e j(BdUniqueId bdUniqueId) {
        com.baidu.tbadk.a.a.a aVar = this.enW.get(bdUniqueId);
        if (aVar == null) {
            return null;
        }
        return aVar.bfG();
    }

    private void bfg() {
        for (Map.Entry<BdUniqueId, com.baidu.tbadk.a.a.a> entry : this.enW.entrySet()) {
            com.baidu.tbadk.a.a.a value = entry.getValue();
            if (value != null) {
                b(value);
            }
        }
        bff();
    }

    private void b(com.baidu.tbadk.a.a.a aVar) {
        e eVar = null;
        if (aVar != null) {
            ArrayList<String> bfF = aVar.bfF();
            if (y.isEmpty(bfF)) {
                aVar.a((e) null);
                return;
            }
            Iterator<String> it = bfF.iterator();
            while (it.hasNext()) {
                eVar = this.mSwitchs.get(it.next());
                if (eVar != null) {
                    break;
                }
            }
            aVar.a(eVar);
        }
    }

    private static String bfh() {
        return "ubs_abtest_config";
    }

    public synchronized e zz(String str) {
        return this.mSwitchs.get(str);
    }

    private void C(HashMap<String, e> hashMap) {
        synchronized (this.mSwitchs) {
            this.mSwitchs.clear();
            if (hashMap != null) {
                this.mSwitchs.putAll(hashMap);
            }
            bfg();
        }
    }

    public void M(JSONArray jSONArray) {
        try {
            String bfh = bfh();
            if (jSONArray == null) {
                this.mSwitchs.clear();
                com.baidu.tbadk.core.sharedPref.b.bnH().remove(bfh);
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
            com.baidu.tbadk.core.sharedPref.b.bnH().putString(bfh, jSONArray.toString());
            bfi();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void bfi() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921506, 1));
    }

    private HashMap<String, e> bfb() {
        HashMap<String, e> hashMap = new HashMap<>();
        try {
            bfh();
            JSONArray jSONArray = new JSONArray(com.baidu.tbadk.core.sharedPref.b.bnH().getString(bfh(), "[]"));
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
