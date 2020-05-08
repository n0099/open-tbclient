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
    private static volatile c cBB;
    private boolean ckG;
    private List<d> cBy = new ArrayList();
    private Map<d, List<d>> cBz = new HashMap();
    private Map<d, List<d>> cBA = new HashMap();

    public static c aqu() {
        if (cBB == null) {
            synchronized (c.class) {
                if (cBB == null) {
                    cBB = new c();
                }
            }
        }
        return cBB;
    }

    public void initData() {
        C(aqz());
        this.ckG = true;
    }

    public boolean aqv() {
        return this.ckG;
    }

    public List<d> aqw() {
        return this.cBy;
    }

    public Map<d, List<d>> aqx() {
        return this.cBz;
    }

    public Map<d, List<d>> aqy() {
        return this.cBA;
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
                        this.cBy.add(bo);
                        if (bo.aqD()) {
                            this.cBz.put(bo, bo.ana);
                            for (d dVar : bo.ana) {
                                if (dVar.aqD()) {
                                    this.cBA.put(dVar, dVar.ana);
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

    private JSONArray aqz() {
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
