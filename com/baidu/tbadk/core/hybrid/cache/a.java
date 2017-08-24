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
    private static a aez;
    private Map<String, CacheEntry> aeA = new HashMap();
    private boolean aeB;

    private a() {
    }

    public static a un() {
        if (aez == null) {
            synchronized (a.class) {
                if (aez == null) {
                    aez = new a();
                }
            }
        }
        return aez;
    }

    public CacheEntry dj(String str) {
        uo();
        return this.aeA.get(str);
    }

    public synchronized boolean a(CacheEntry cacheEntry) {
        boolean up;
        uo();
        if (cacheEntry == null) {
            up = false;
        } else {
            this.aeA.put(cacheEntry.getUrl(), cacheEntry);
            up = up();
        }
        return up;
    }

    public synchronized CacheEntry dk(String str) {
        CacheEntry remove;
        uo();
        remove = this.aeA.remove(str);
        if (remove == null) {
            remove = null;
        } else {
            up();
        }
        return remove;
    }

    private synchronized void uo() {
        if (!this.aeB) {
            this.aeB = true;
            List<CacheEntry> uq = uq();
            if (uq != null && uq.size() > 0) {
                for (CacheEntry cacheEntry : uq) {
                    this.aeA.put(cacheEntry.getUrl(), cacheEntry);
                }
            }
        }
    }

    private boolean up() {
        File file = new File(TbadkCoreApplication.getInst().getFilesDir(), "tbhybrid/cache");
        if (file.exists() || file.mkdirs()) {
            File file2 = new File(file, "config.config");
            try {
                JSONArray jSONArray = new JSONArray();
                for (CacheEntry cacheEntry : this.aeA.values()) {
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

    public List<CacheEntry> uq() {
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
