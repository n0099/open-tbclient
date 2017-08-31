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
    private static a adH;
    private Map<String, CacheEntry> adI = new HashMap();
    private boolean adJ;

    private a() {
    }

    public static a ui() {
        if (adH == null) {
            synchronized (a.class) {
                if (adH == null) {
                    adH = new a();
                }
            }
        }
        return adH;
    }

    public CacheEntry cZ(String str) {
        uj();
        return this.adI.get(str);
    }

    public synchronized boolean a(CacheEntry cacheEntry) {
        boolean uk;
        uj();
        if (cacheEntry == null) {
            uk = false;
        } else {
            this.adI.put(cacheEntry.getUrl(), cacheEntry);
            uk = uk();
        }
        return uk;
    }

    public synchronized CacheEntry da(String str) {
        CacheEntry remove;
        uj();
        remove = this.adI.remove(str);
        if (remove == null) {
            remove = null;
        } else {
            uk();
        }
        return remove;
    }

    private synchronized void uj() {
        if (!this.adJ) {
            this.adJ = true;
            List<CacheEntry> ul = ul();
            if (ul != null && ul.size() > 0) {
                for (CacheEntry cacheEntry : ul) {
                    this.adI.put(cacheEntry.getUrl(), cacheEntry);
                }
            }
        }
    }

    private boolean uk() {
        File file = new File(TbadkCoreApplication.getInst().getFilesDir(), "tbhybrid/cache");
        if (file.exists() || file.mkdirs()) {
            File file2 = new File(file, "config.config");
            try {
                JSONArray jSONArray = new JSONArray();
                for (CacheEntry cacheEntry : this.adI.values()) {
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

    public List<CacheEntry> ul() {
        File file = new File(new File(TbadkCoreApplication.getInst().getFilesDir(), "tbhybrid/cache"), "config.config");
        if (file.exists() && file.isFile() && file.length() > 0) {
            byte[] r = o.r(file);
            if (r == null || r.length == 0) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray(new String(r));
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
