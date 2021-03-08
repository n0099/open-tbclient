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
    private static c eHH;
    private final HashMap<String, e> mSwitchs = new HashMap<>();
    private final HashMap<BdUniqueId, com.baidu.tbadk.a.a.a> eHI = new HashMap<>();
    private final HashMap<BdUniqueId, e> eHJ = new HashMap<>();

    private c() {
        biK();
        D(biJ());
    }

    private void biK() {
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

    public static c biL() {
        if (eHH == null) {
            synchronized (c.class) {
                if (eHH == null) {
                    eHH = new c();
                }
            }
        }
        return eHH;
    }

    protected void a(com.baidu.tbadk.a.a.a aVar) {
        if (aVar != null && aVar.bjF() != null) {
            this.eHI.put(aVar.bjF(), aVar);
        }
    }

    public Map<BdUniqueId, e> biM() {
        return this.eHJ;
    }

    private void biN() {
        this.eHJ.clear();
        for (BdUniqueId bdUniqueId : this.eHI.keySet()) {
            this.eHJ.put(bdUniqueId, j(bdUniqueId));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e j(BdUniqueId bdUniqueId) {
        com.baidu.tbadk.a.a.a aVar = this.eHI.get(bdUniqueId);
        if (aVar == null) {
            return null;
        }
        return aVar.bjH();
    }

    private void biO() {
        for (Map.Entry<BdUniqueId, com.baidu.tbadk.a.a.a> entry : this.eHI.entrySet()) {
            com.baidu.tbadk.a.a.a value = entry.getValue();
            if (value != null) {
                b(value);
            }
        }
        biN();
    }

    private void b(com.baidu.tbadk.a.a.a aVar) {
        e eVar = null;
        if (aVar != null) {
            ArrayList<String> bjG = aVar.bjG();
            if (y.isEmpty(bjG)) {
                aVar.a((e) null);
                return;
            }
            Iterator<String> it = bjG.iterator();
            while (it.hasNext()) {
                eVar = this.mSwitchs.get(it.next());
                if (eVar != null) {
                    break;
                }
            }
            aVar.a(eVar);
        }
    }

    private static String biP() {
        return "ubs_abtest_config";
    }

    public synchronized e zx(String str) {
        return this.mSwitchs.get(str);
    }

    private void D(HashMap<String, e> hashMap) {
        synchronized (this.mSwitchs) {
            this.mSwitchs.clear();
            if (hashMap != null) {
                this.mSwitchs.putAll(hashMap);
            }
            biO();
        }
    }

    public void zy(String str) {
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
            String biP = biP();
            if (jSONArray == null) {
                this.mSwitchs.clear();
                com.baidu.tbadk.core.sharedPref.b.brR().remove(biP);
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
            com.baidu.tbadk.core.sharedPref.b.brR().putString(biP, jSONArray.toString());
            biQ();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void biQ() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921506, 1));
        com.baidu.tbadk.core.sharedPref.b.brR().putInt("static_opt_open", d.biU() ? 1 : 0);
    }

    private HashMap<String, e> biJ() {
        HashMap<String, e> hashMap = new HashMap<>();
        try {
            biP();
            JSONArray jSONArray = new JSONArray(com.baidu.tbadk.core.sharedPref.b.brR().getString(biP(), "[]"));
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
