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
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private static c esj;
    private final HashMap<String, e> mSwitchs = new HashMap<>();
    private final HashMap<BdUniqueId, com.baidu.tbadk.a.a.a> esk = new HashMap<>();
    private final HashMap<BdUniqueId, e> esl = new HashMap<>();

    private c() {
        bgV();
        B(bgU());
    }

    private void bgV() {
        a(new l());
        a(new h());
        a(new com.baidu.tbadk.a.a.e());
        a(new f());
        a(new com.baidu.tbadk.a.a.d());
        a(new i());
        a(new j());
        a(new com.baidu.tbadk.a.a.b());
        a(new com.baidu.tbadk.a.a.c());
        a(new k());
    }

    public static c bgW() {
        if (esj == null) {
            synchronized (c.class) {
                if (esj == null) {
                    esj = new c();
                }
            }
        }
        return esj;
    }

    protected void a(com.baidu.tbadk.a.a.a aVar) {
        if (aVar != null && aVar.bhy() != null) {
            this.esk.put(aVar.bhy(), aVar);
        }
    }

    public Map<BdUniqueId, e> bgX() {
        return this.esl;
    }

    private void bgY() {
        this.esl.clear();
        for (BdUniqueId bdUniqueId : this.esk.keySet()) {
            this.esl.put(bdUniqueId, j(bdUniqueId));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e j(BdUniqueId bdUniqueId) {
        com.baidu.tbadk.a.a.a aVar = this.esk.get(bdUniqueId);
        if (aVar == null) {
            return null;
        }
        return aVar.bhA();
    }

    private void bgZ() {
        for (Map.Entry<BdUniqueId, com.baidu.tbadk.a.a.a> entry : this.esk.entrySet()) {
            com.baidu.tbadk.a.a.a value = entry.getValue();
            if (value != null) {
                b(value);
            }
        }
        bgY();
    }

    private void b(com.baidu.tbadk.a.a.a aVar) {
        e eVar = null;
        if (aVar != null) {
            ArrayList<String> bhz = aVar.bhz();
            if (y.isEmpty(bhz)) {
                aVar.a((e) null);
                return;
            }
            Iterator<String> it = bhz.iterator();
            while (it.hasNext()) {
                eVar = this.mSwitchs.get(it.next());
                if (eVar != null) {
                    break;
                }
            }
            aVar.a(eVar);
        }
    }

    private static String bha() {
        return "ubs_abtest_config";
    }

    public synchronized e zH(String str) {
        return this.mSwitchs.get(str);
    }

    private void B(HashMap<String, e> hashMap) {
        synchronized (this.mSwitchs) {
            this.mSwitchs.clear();
            if (hashMap != null) {
                this.mSwitchs.putAll(hashMap);
            }
            bgZ();
        }
    }

    public void M(JSONArray jSONArray) {
        try {
            String bha = bha();
            if (jSONArray == null) {
                this.mSwitchs.clear();
                com.baidu.tbadk.core.sharedPref.b.bpu().remove(bha);
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
            com.baidu.tbadk.core.sharedPref.b.bpu().putString(bha, jSONArray.toString());
            bhb();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void bhb() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921506, 1));
        com.baidu.tbadk.core.sharedPref.b.bpu().putInt("static_opt_open", d.bhk() ? 1 : 0);
    }

    private HashMap<String, e> bgU() {
        HashMap<String, e> hashMap = new HashMap<>();
        try {
            bha();
            JSONArray jSONArray = new JSONArray(com.baidu.tbadk.core.sharedPref.b.bpu().getString(bha(), "[]"));
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
