package com.baidu.swan.bdprivate.address.b;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.bdprivate.address.c.d;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile c bXR;
    private boolean bGO;
    private List<d> bXO = new ArrayList();
    private Map<d, List<d>> bXP = new HashMap();
    private Map<d, List<d>> bXQ = new HashMap();

    public static c afB() {
        if (bXR == null) {
            synchronized (c.class) {
                if (bXR == null) {
                    bXR = new c();
                }
            }
        }
        return bXR;
    }

    public void initData() {
        A(afG());
        this.bGO = true;
    }

    public boolean afC() {
        return this.bGO;
    }

    public List<d> afD() {
        return this.bXO;
    }

    public Map<d, List<d>> afE() {
        return this.bXP;
    }

    public Map<d, List<d>> afF() {
        return this.bXQ;
    }

    private void A(JSONArray jSONArray) {
        d bd;
        if (jSONArray != null && jSONArray.length() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < jSONArray.length()) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    if (optJSONObject != null && (bd = d.bd(optJSONObject)) != null) {
                        this.bXO.add(bd);
                        if (bd.afK()) {
                            this.bXP.put(bd, bd.ST);
                            for (d dVar : bd.ST) {
                                if (dVar.afK()) {
                                    this.bXQ.put(dVar, dVar.ST);
                                }
                            }
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private JSONArray afG() {
        JSONArray jSONArray;
        Exception e;
        InputStream open;
        try {
            open = AppRuntime.getAppContext().getAssets().open("pickerRegion.js");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            jSONArray = new JSONArray(new String(bArr, "UTF-8"));
        } catch (Exception e2) {
            jSONArray = null;
            e = e2;
        }
        try {
            open.close();
        } catch (Exception e3) {
            e = e3;
            if (DEBUG) {
                e.printStackTrace();
            }
            return jSONArray;
        }
        return jSONArray;
    }
}
