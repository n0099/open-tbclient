package com.baidu.tbadk.core.hybrid.cache;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.hybrid.o;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static a adb;
    private Map<String, CacheEntry> adc = new HashMap();
    private boolean ade;

    private a() {
    }

    public static a ub() {
        if (adb == null) {
            synchronized (a.class) {
                if (adb == null) {
                    adb = new a();
                }
            }
        }
        return adb;
    }

    public CacheEntry da(String str) {
        uc();
        return this.adc.get(str);
    }

    public synchronized boolean a(CacheEntry cacheEntry) {
        boolean ud;
        uc();
        if (cacheEntry == null) {
            ud = false;
        } else {
            this.adc.put(cacheEntry.getUrl(), cacheEntry);
            ud = ud();
        }
        return ud;
    }

    public synchronized CacheEntry db(String str) {
        CacheEntry remove;
        uc();
        remove = this.adc.remove(str);
        if (remove == null) {
            remove = null;
        } else {
            ud();
        }
        return remove;
    }

    private synchronized void uc() {
        if (!this.ade) {
            this.ade = true;
            List<CacheEntry> ue = ue();
            if (ue != null && ue.size() > 0) {
                for (CacheEntry cacheEntry : ue) {
                    this.adc.put(cacheEntry.getUrl(), cacheEntry);
                }
            }
        }
    }

    private boolean ud() {
        File file = new File(TbadkCoreApplication.getInst().getFilesDir(), "tbhybrid/cache");
        if (file.exists() || file.mkdirs()) {
            File file2 = new File(file, "config.config");
            try {
                JSONArray jSONArray = new JSONArray();
                for (CacheEntry cacheEntry : this.adc.values()) {
                    jSONArray.put(new JSONObject(cacheEntry.toJson()));
                }
                return o.a(file2, jSONArray.toString().getBytes(), false);
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public List<CacheEntry> ue() {
        File file = new File(new File(TbadkCoreApplication.getInst().getFilesDir(), "tbhybrid/cache"), "config.config");
        if (file.exists() && file.isFile() && file.length() > 0) {
            byte[] p = o.p(file);
            if (p == null || p.length == 0) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray(new String(p));
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    CacheEntry cacheEntry = new CacheEntry();
                    cacheEntry.parse(jSONArray.getJSONObject(i).toString());
                    arrayList.add(cacheEntry);
                }
                return arrayList;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
