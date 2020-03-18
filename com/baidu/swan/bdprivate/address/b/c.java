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
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile c ccv;
    private boolean bLQ;
    private List<d> ccr = new ArrayList();
    private Map<d, List<d>> cct = new HashMap();
    private Map<d, List<d>> ccu = new HashMap();

    public static c ain() {
        if (ccv == null) {
            synchronized (c.class) {
                if (ccv == null) {
                    ccv = new c();
                }
            }
        }
        return ccv;
    }

    public void initData() {
        B(ais());
        this.bLQ = true;
    }

    public boolean aio() {
        return this.bLQ;
    }

    public List<d> aip() {
        return this.ccr;
    }

    public Map<d, List<d>> aiq() {
        return this.cct;
    }

    public Map<d, List<d>> air() {
        return this.ccu;
    }

    private void B(JSONArray jSONArray) {
        d bd;
        if (jSONArray != null && jSONArray.length() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < jSONArray.length()) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    if (optJSONObject != null && (bd = d.bd(optJSONObject)) != null) {
                        this.ccr.add(bd);
                        if (bd.aiw()) {
                            this.cct.put(bd, bd.UM);
                            for (d dVar : bd.UM) {
                                if (dVar.aiw()) {
                                    this.ccu.put(dVar, dVar.UM);
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

    private JSONArray ais() {
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
