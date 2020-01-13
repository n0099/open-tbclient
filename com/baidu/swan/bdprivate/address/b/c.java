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
/* loaded from: classes10.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile c bYd;
    private boolean bHy;
    private List<d> bYa = new ArrayList();
    private Map<d, List<d>> bYb = new HashMap();
    private Map<d, List<d>> bYc = new HashMap();

    public static c afU() {
        if (bYd == null) {
            synchronized (c.class) {
                if (bYd == null) {
                    bYd = new c();
                }
            }
        }
        return bYd;
    }

    public void initData() {
        B(afZ());
        this.bHy = true;
    }

    public boolean afV() {
        return this.bHy;
    }

    public List<d> afW() {
        return this.bYa;
    }

    public Map<d, List<d>> afX() {
        return this.bYb;
    }

    public Map<d, List<d>> afY() {
        return this.bYc;
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
                        this.bYa.add(bd);
                        if (bd.agd()) {
                            this.bYb.put(bd, bd.SW);
                            for (d dVar : bd.SW) {
                                if (dVar.agd()) {
                                    this.bYc.put(dVar, dVar.SW);
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

    private JSONArray afZ() {
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
