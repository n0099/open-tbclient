package com.baidu.tbadk.core.hybrid.cache;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.hybrid.r;
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
    private static a acF;
    private Map<String, CacheEntry> acG = new HashMap();
    private boolean acH;

    private a() {
    }

    public static a tV() {
        if (acF == null) {
            synchronized (a.class) {
                if (acF == null) {
                    acF = new a();
                }
            }
        }
        return acF;
    }

    public CacheEntry cX(String str) {
        tW();
        return this.acG.get(str);
    }

    public synchronized boolean a(CacheEntry cacheEntry) {
        boolean tX;
        tW();
        if (cacheEntry == null) {
            tX = false;
        } else {
            this.acG.put(cacheEntry.getUrl(), cacheEntry);
            tX = tX();
        }
        return tX;
    }

    public synchronized CacheEntry cY(String str) {
        CacheEntry remove;
        tW();
        remove = this.acG.remove(str);
        if (remove == null) {
            remove = null;
        } else {
            tX();
        }
        return remove;
    }

    private synchronized void tW() {
        if (!this.acH) {
            this.acH = true;
            List<CacheEntry> tY = tY();
            if (tY != null && tY.size() > 0) {
                for (CacheEntry cacheEntry : tY) {
                    this.acG.put(cacheEntry.getUrl(), cacheEntry);
                }
            }
        }
    }

    private boolean tX() {
        File file = new File(TbadkCoreApplication.m9getInst().getFilesDir(), "tbhybrid/cache");
        if (file.exists() || file.mkdirs()) {
            File file2 = new File(file, "config.config");
            try {
                JSONArray jSONArray = new JSONArray();
                for (CacheEntry cacheEntry : this.acG.values()) {
                    jSONArray.put(new JSONObject(cacheEntry.toJson()));
                }
                return r.a(file2, jSONArray.toString().getBytes(), false);
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public List<CacheEntry> tY() {
        File file = new File(new File(TbadkCoreApplication.m9getInst().getFilesDir(), "tbhybrid/cache"), "config.config");
        if (file.exists() && file.isFile() && file.length() > 0) {
            byte[] p = r.p(file);
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
