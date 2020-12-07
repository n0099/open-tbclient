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
import com.baidu.tbadk.a.a.l;
import com.baidu.tbadk.a.a.m;
import com.baidu.tbadk.a.a.n;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private static c ezm;
    private final HashMap<String, e> mSwitchs = new HashMap<>();
    private final HashMap<BdUniqueId, com.baidu.tbadk.a.a.a> ezn = new HashMap<>();
    private final HashMap<BdUniqueId, e> ezo = new HashMap<>();

    private c() {
        bka();
        B(bjZ());
    }

    private void bka() {
        a(new n());
        a(new h());
        a(new com.baidu.tbadk.a.a.e());
        a(new f());
        a(new com.baidu.tbadk.a.a.d());
        a(new i());
        a(new l());
        a(new com.baidu.tbadk.a.a.b());
        a(new com.baidu.tbadk.a.a.c());
        a(new j());
        a(new k());
        a(new m());
    }

    public static c bkb() {
        if (ezm == null) {
            synchronized (c.class) {
                if (ezm == null) {
                    ezm = new c();
                }
            }
        }
        return ezm;
    }

    protected void a(com.baidu.tbadk.a.a.a aVar) {
        if (aVar != null && aVar.bkH() != null) {
            this.ezn.put(aVar.bkH(), aVar);
        }
    }

    public Map<BdUniqueId, e> bkc() {
        return this.ezo;
    }

    private void bkd() {
        this.ezo.clear();
        for (BdUniqueId bdUniqueId : this.ezn.keySet()) {
            this.ezo.put(bdUniqueId, j(bdUniqueId));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e j(BdUniqueId bdUniqueId) {
        com.baidu.tbadk.a.a.a aVar = this.ezn.get(bdUniqueId);
        if (aVar == null) {
            return null;
        }
        return aVar.bkJ();
    }

    private void bke() {
        for (Map.Entry<BdUniqueId, com.baidu.tbadk.a.a.a> entry : this.ezn.entrySet()) {
            com.baidu.tbadk.a.a.a value = entry.getValue();
            if (value != null) {
                b(value);
            }
        }
        bkd();
    }

    private void b(com.baidu.tbadk.a.a.a aVar) {
        e eVar = null;
        if (aVar != null) {
            ArrayList<String> bkI = aVar.bkI();
            if (y.isEmpty(bkI)) {
                aVar.a((e) null);
                return;
            }
            Iterator<String> it = bkI.iterator();
            while (it.hasNext()) {
                eVar = this.mSwitchs.get(it.next());
                if (eVar != null) {
                    break;
                }
            }
            aVar.a(eVar);
        }
    }

    private static String bkf() {
        return "ubs_abtest_config";
    }

    public synchronized e Ao(String str) {
        return this.mSwitchs.get(str);
    }

    private void B(HashMap<String, e> hashMap) {
        synchronized (this.mSwitchs) {
            this.mSwitchs.clear();
            if (hashMap != null) {
                this.mSwitchs.putAll(hashMap);
            }
            bke();
        }
    }

    public void N(JSONArray jSONArray) {
        try {
            String bkf = bkf();
            if (jSONArray == null) {
                this.mSwitchs.clear();
                com.baidu.tbadk.core.sharedPref.b.bsO().remove(bkf);
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
            B(hashMap);
            com.baidu.tbadk.core.sharedPref.b.bsO().putString(bkf, jSONArray.toString());
            bkg();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void bkg() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921506, 1));
        com.baidu.tbadk.core.sharedPref.b.bsO().putInt("static_opt_open", d.bko() ? 1 : 0);
    }

    private HashMap<String, e> bjZ() {
        HashMap<String, e> hashMap = new HashMap<>();
        try {
            bkf();
            JSONArray jSONArray = new JSONArray(com.baidu.tbadk.core.sharedPref.b.bsO().getString(bkf(), "[]"));
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
