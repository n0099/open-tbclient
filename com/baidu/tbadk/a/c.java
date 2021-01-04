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
    private static c eIK;
    private final HashMap<String, e> mSwitchs = new HashMap<>();
    private final HashMap<BdUniqueId, com.baidu.tbadk.a.a.a> eIL = new HashMap<>();
    private final HashMap<BdUniqueId, e> eIM = new HashMap<>();

    private c() {
        bmp();
        B(bmo());
    }

    private void bmp() {
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

    public static c bmq() {
        if (eIK == null) {
            synchronized (c.class) {
                if (eIK == null) {
                    eIK = new c();
                }
            }
        }
        return eIK;
    }

    protected void a(com.baidu.tbadk.a.a.a aVar) {
        if (aVar != null && aVar.bnb() != null) {
            this.eIL.put(aVar.bnb(), aVar);
        }
    }

    public Map<BdUniqueId, e> bmr() {
        return this.eIM;
    }

    private void bms() {
        this.eIM.clear();
        for (BdUniqueId bdUniqueId : this.eIL.keySet()) {
            this.eIM.put(bdUniqueId, j(bdUniqueId));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e j(BdUniqueId bdUniqueId) {
        com.baidu.tbadk.a.a.a aVar = this.eIL.get(bdUniqueId);
        if (aVar == null) {
            return null;
        }
        return aVar.bnd();
    }

    private void bmt() {
        for (Map.Entry<BdUniqueId, com.baidu.tbadk.a.a.a> entry : this.eIL.entrySet()) {
            com.baidu.tbadk.a.a.a value = entry.getValue();
            if (value != null) {
                b(value);
            }
        }
        bms();
    }

    private void b(com.baidu.tbadk.a.a.a aVar) {
        e eVar = null;
        if (aVar != null) {
            ArrayList<String> bnc = aVar.bnc();
            if (x.isEmpty(bnc)) {
                aVar.a((e) null);
                return;
            }
            Iterator<String> it = bnc.iterator();
            while (it.hasNext()) {
                eVar = this.mSwitchs.get(it.next());
                if (eVar != null) {
                    break;
                }
            }
            aVar.a(eVar);
        }
    }

    private static String bmu() {
        return "ubs_abtest_config";
    }

    public synchronized e Aj(String str) {
        return this.mSwitchs.get(str);
    }

    private void B(HashMap<String, e> hashMap) {
        synchronized (this.mSwitchs) {
            this.mSwitchs.clear();
            if (hashMap != null) {
                this.mSwitchs.putAll(hashMap);
            }
            bmt();
        }
    }

    public void Ak(String str) {
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
            String bmu = bmu();
            if (jSONArray == null) {
                this.mSwitchs.clear();
                com.baidu.tbadk.core.sharedPref.b.bvq().remove(bmu);
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
            com.baidu.tbadk.core.sharedPref.b.bvq().putString(bmu, jSONArray.toString());
            bmv();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void bmv() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921506, 1));
        com.baidu.tbadk.core.sharedPref.b.bvq().putInt("static_opt_open", d.bmz() ? 1 : 0);
    }

    private HashMap<String, e> bmo() {
        HashMap<String, e> hashMap = new HashMap<>();
        try {
            bmu();
            JSONArray jSONArray = new JSONArray(com.baidu.tbadk.core.sharedPref.b.bvq().getString(bmu(), "[]"));
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
