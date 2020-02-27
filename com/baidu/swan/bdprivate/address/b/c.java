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
    private static volatile c cch;
    private boolean bLD;
    private List<d> cce = new ArrayList();
    private Map<d, List<d>> ccf = new HashMap();
    private Map<d, List<d>> ccg = new HashMap();

    public static c aii() {
        if (cch == null) {
            synchronized (c.class) {
                if (cch == null) {
                    cch = new c();
                }
            }
        }
        return cch;
    }

    public void initData() {
        B(ain());
        this.bLD = true;
    }

    public boolean aij() {
        return this.bLD;
    }

    public List<d> aik() {
        return this.cce;
    }

    public Map<d, List<d>> ail() {
        return this.ccf;
    }

    public Map<d, List<d>> aim() {
        return this.ccg;
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
                        this.cce.add(bd);
                        if (bd.air()) {
                            this.ccf.put(bd, bd.UB);
                            for (d dVar : bd.UB) {
                                if (dVar.air()) {
                                    this.ccg.put(dVar, dVar.UB);
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

    private JSONArray ain() {
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
