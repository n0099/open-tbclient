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
    private static volatile c cBv;
    private List<d> cBs = new ArrayList();
    private Map<d, List<d>> cBt = new HashMap();
    private Map<d, List<d>> cBu = new HashMap();
    private boolean ckA;

    public static c aqv() {
        if (cBv == null) {
            synchronized (c.class) {
                if (cBv == null) {
                    cBv = new c();
                }
            }
        }
        return cBv;
    }

    public void initData() {
        C(aqA());
        this.ckA = true;
    }

    public boolean aqw() {
        return this.ckA;
    }

    public List<d> aqx() {
        return this.cBs;
    }

    public Map<d, List<d>> aqy() {
        return this.cBt;
    }

    public Map<d, List<d>> aqz() {
        return this.cBu;
    }

    private void C(JSONArray jSONArray) {
        d bo;
        if (jSONArray != null && jSONArray.length() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < jSONArray.length()) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    if (optJSONObject != null && (bo = d.bo(optJSONObject)) != null) {
                        this.cBs.add(bo);
                        if (bo.aqE()) {
                            this.cBt.put(bo, bo.amU);
                            for (d dVar : bo.amU) {
                                if (dVar.aqE()) {
                                    this.cBu.put(dVar, dVar.amU);
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

    private JSONArray aqA() {
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
