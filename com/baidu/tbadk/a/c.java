package com.baidu.tbadk.a;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tbadk.a.a.f;
import com.baidu.tbadk.a.a.g;
import com.baidu.tbadk.a.a.h;
import com.baidu.tbadk.a.a.j;
import com.baidu.tbadk.a.a.k;
import com.baidu.tbadk.a.a.l;
import com.baidu.tbadk.a.a.m;
import com.baidu.tbadk.a.a.n;
import com.baidu.tbadk.a.a.o;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private static c eDZ;
    private final HashMap<String, e> mSwitchs = new HashMap<>();
    private final HashMap<BdUniqueId, com.baidu.tbadk.a.a.a> eEa = new HashMap<>();
    private final HashMap<BdUniqueId, e> eEb = new HashMap<>();

    private c() {
        biw();
        B(biv());
    }

    private void biw() {
        a(new o());
        a(new g());
        a(new h());
        a(new com.baidu.tbadk.a.a.d());
        a(new m());
        a(new com.baidu.tbadk.a.a.b());
        a(new com.baidu.tbadk.a.a.c());
        a(new k());
        a(new l());
        a(new n());
        a(new f());
        a(new com.baidu.tbadk.a.a.e());
        a(new j());
    }

    public static c bix() {
        if (eDZ == null) {
            synchronized (c.class) {
                if (eDZ == null) {
                    eDZ = new c();
                }
            }
        }
        return eDZ;
    }

    protected void a(com.baidu.tbadk.a.a.a aVar) {
        if (aVar != null && aVar.bji() != null) {
            this.eEa.put(aVar.bji(), aVar);
        }
    }

    public Map<BdUniqueId, e> biy() {
        return this.eEb;
    }

    private void biz() {
        this.eEb.clear();
        for (BdUniqueId bdUniqueId : this.eEa.keySet()) {
            this.eEb.put(bdUniqueId, j(bdUniqueId));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e j(BdUniqueId bdUniqueId) {
        com.baidu.tbadk.a.a.a aVar = this.eEa.get(bdUniqueId);
        if (aVar == null) {
            return null;
        }
        return aVar.bjk();
    }

    private void biA() {
        for (Map.Entry<BdUniqueId, com.baidu.tbadk.a.a.a> entry : this.eEa.entrySet()) {
            com.baidu.tbadk.a.a.a value = entry.getValue();
            if (value != null) {
                b(value);
            }
        }
        biz();
    }

    private void b(com.baidu.tbadk.a.a.a aVar) {
        e eVar = null;
        if (aVar != null) {
            ArrayList<String> bjj = aVar.bjj();
            if (x.isEmpty(bjj)) {
                aVar.a((e) null);
                return;
            }
            Iterator<String> it = bjj.iterator();
            while (it.hasNext()) {
                eVar = this.mSwitchs.get(it.next());
                if (eVar != null) {
                    break;
                }
            }
            aVar.a(eVar);
        }
    }

    private static String biB() {
        return "ubs_abtest_config";
    }

    public synchronized e yY(String str) {
        return this.mSwitchs.get(str);
    }

    private void B(HashMap<String, e> hashMap) {
        synchronized (this.mSwitchs) {
            this.mSwitchs.clear();
            if (hashMap != null) {
                this.mSwitchs.putAll(hashMap);
            }
            biA();
        }
    }

    public void yZ(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                N(null);
            } else {
                N(new JSONArray(str));
            }
        } catch (Exception e) {
        }
    }

    public void N(JSONArray jSONArray) {
        try {
            String biB = biB();
            if (jSONArray == null) {
                this.mSwitchs.clear();
                com.baidu.tbadk.core.sharedPref.b.brx().remove(biB);
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
            com.baidu.tbadk.core.sharedPref.b.brx().putString(biB, jSONArray.toString());
            biC();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void biC() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921506, 1));
        com.baidu.tbadk.core.sharedPref.b.brx().putInt("static_opt_open", d.biG() ? 1 : 0);
    }

    private HashMap<String, e> biv() {
        HashMap<String, e> hashMap = new HashMap<>();
        try {
            biB();
            JSONArray jSONArray = new JSONArray(com.baidu.tbadk.core.sharedPref.b.brx().getString(biB(), "[]"));
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
