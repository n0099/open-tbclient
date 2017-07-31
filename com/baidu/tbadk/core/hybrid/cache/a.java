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
    private static a aex;
    private Map<String, CacheEntry> aey = new HashMap();
    private boolean aez;

    private a() {
    }

    public static a um() {
        if (aex == null) {
            synchronized (a.class) {
                if (aex == null) {
                    aex = new a();
                }
            }
        }
        return aex;
    }

    public CacheEntry dg(String str) {
        un();
        return this.aey.get(str);
    }

    public synchronized boolean a(CacheEntry cacheEntry) {
        boolean uo;
        un();
        if (cacheEntry == null) {
            uo = false;
        } else {
            this.aey.put(cacheEntry.getUrl(), cacheEntry);
            uo = uo();
        }
        return uo;
    }

    public synchronized CacheEntry dh(String str) {
        CacheEntry remove;
        un();
        remove = this.aey.remove(str);
        if (remove == null) {
            remove = null;
        } else {
            uo();
        }
        return remove;
    }

    private synchronized void un() {
        if (!this.aez) {
            this.aez = true;
            List<CacheEntry> up = up();
            if (up != null && up.size() > 0) {
                for (CacheEntry cacheEntry : up) {
                    this.aey.put(cacheEntry.getUrl(), cacheEntry);
                }
            }
        }
    }

    private boolean uo() {
        File file = new File(TbadkCoreApplication.getInst().getFilesDir(), "tbhybrid/cache");
        if (file.exists() || file.mkdirs()) {
            File file2 = new File(file, "config.config");
            try {
                JSONArray jSONArray = new JSONArray();
                for (CacheEntry cacheEntry : this.aey.values()) {
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

    public List<CacheEntry> up() {
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
