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
import com.baidu.tbadk.a.a.p;
import com.baidu.tbadk.a.a.q;
import com.baidu.tbadk.a.a.r;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private static c eGg;
    private final HashMap<String, e> mSwitchs = new HashMap<>();
    private final HashMap<BdUniqueId, com.baidu.tbadk.a.a.a> eGh = new HashMap<>();
    private final HashMap<BdUniqueId, e> eGi = new HashMap<>();

    private c() {
        biI();
        D(biH());
    }

    private void biI() {
        a(new q());
        a(new g());
        a(new h());
        a(new com.baidu.tbadk.a.a.d());
        a(new n());
        a(new com.baidu.tbadk.a.a.b());
        a(new com.baidu.tbadk.a.a.c());
        a(new l());
        a(new m());
        a(new p());
        a(new f());
        a(new com.baidu.tbadk.a.a.e());
        a(new j());
        a(new r());
        a(new k());
        a(new o());
    }

    public static c biJ() {
        if (eGg == null) {
            synchronized (c.class) {
                if (eGg == null) {
                    eGg = new c();
                }
            }
        }
        return eGg;
    }

    protected void a(com.baidu.tbadk.a.a.a aVar) {
        if (aVar != null && aVar.bjD() != null) {
            this.eGh.put(aVar.bjD(), aVar);
        }
    }

    public Map<BdUniqueId, e> biK() {
        return this.eGi;
    }

    private void biL() {
        this.eGi.clear();
        for (BdUniqueId bdUniqueId : this.eGh.keySet()) {
            this.eGi.put(bdUniqueId, j(bdUniqueId));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e j(BdUniqueId bdUniqueId) {
        com.baidu.tbadk.a.a.a aVar = this.eGh.get(bdUniqueId);
        if (aVar == null) {
            return null;
        }
        return aVar.bjF();
    }

    private void biM() {
        for (Map.Entry<BdUniqueId, com.baidu.tbadk.a.a.a> entry : this.eGh.entrySet()) {
            com.baidu.tbadk.a.a.a value = entry.getValue();
            if (value != null) {
                b(value);
            }
        }
        biL();
    }

    private void b(com.baidu.tbadk.a.a.a aVar) {
        e eVar = null;
        if (aVar != null) {
            ArrayList<String> bjE = aVar.bjE();
            if (y.isEmpty(bjE)) {
                aVar.a((e) null);
                return;
            }
            Iterator<String> it = bjE.iterator();
            while (it.hasNext()) {
                eVar = this.mSwitchs.get(it.next());
                if (eVar != null) {
                    break;
                }
            }
            aVar.a(eVar);
        }
    }

    private static String biN() {
        return "ubs_abtest_config";
    }

    public synchronized e zq(String str) {
        return this.mSwitchs.get(str);
    }

    private void D(HashMap<String, e> hashMap) {
        synchronized (this.mSwitchs) {
            this.mSwitchs.clear();
            if (hashMap != null) {
                this.mSwitchs.putAll(hashMap);
            }
            biM();
        }
    }

    public void zr(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                M(null);
            } else {
                M(new JSONArray(str));
            }
        } catch (Exception e) {
        }
    }

    public void M(JSONArray jSONArray) {
        try {
            String biN = biN();
            if (jSONArray == null) {
                this.mSwitchs.clear();
                com.baidu.tbadk.core.sharedPref.b.brQ().remove(biN);
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
            com.baidu.tbadk.core.sharedPref.b.brQ().putString(biN, jSONArray.toString());
            biO();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void biO() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921506, 1));
        com.baidu.tbadk.core.sharedPref.b.brQ().putInt("static_opt_open", d.biS() ? 1 : 0);
    }

    private HashMap<String, e> biH() {
        HashMap<String, e> hashMap = new HashMap<>();
        try {
            biN();
            JSONArray jSONArray = new JSONArray(com.baidu.tbadk.core.sharedPref.b.brQ().getString(biN(), "[]"));
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
