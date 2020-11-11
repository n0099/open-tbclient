package com.baidu.swan.apps.ak.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ap.j;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.c.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private final String dzt;

    public a() {
        String str;
        try {
            str = AppRuntime.getAppContext().getFilesDir().getPath();
        } catch (Exception e) {
            if (DEBUG) {
                throw e;
            }
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            this.dzt = str + File.separator + "aiapps_folder/stability";
        } else {
            this.dzt = "";
        }
    }

    public File G(JSONArray jSONArray) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            kw(9);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("_app_id", e.aHw() == null ? "" : e.aHw());
            jSONObject.put("_date", j.a(new Date(currentTimeMillis), "yyyy-MM-dd HH:mm:ss"));
            jSONArray.put(jSONObject);
            File co = co(currentTimeMillis);
            if (co != null) {
                if (com.baidu.swan.apps.s.a.m(co.getPath(), jSONArray.toString(), false)) {
                    return co;
                }
            }
            return null;
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("SwanStabilityTraceCache", "TraceCache Exception:", e);
            }
            return null;
        }
    }

    public File[] aKa() {
        if (TextUtils.isEmpty(this.dzt)) {
            return null;
        }
        try {
            return new File(this.dzt).listFiles();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("SwanStabilityTraceCache", "TraceCache Exception:", e);
                return null;
            }
            return null;
        }
    }

    private void kw(int i) {
        File[] aKa = aKa();
        if (aKa != null && aKa.length != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            Arrays.sort(aKa, new Comparator<File>() { // from class: com.baidu.swan.apps.ak.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: c */
                public int compare(File file, File file2) {
                    long lastModified = file.lastModified();
                    long lastModified2 = file2.lastModified();
                    if (lastModified == lastModified2) {
                        return 0;
                    }
                    return lastModified - lastModified2 > 0 ? 1 : -1;
                }
            });
            ArrayList<File> arrayList = new ArrayList(aKa.length);
            int i2 = 0;
            for (File file : aKa) {
                if (i2 < i) {
                    if (file.lastModified() - currentTimeMillis > 172800000) {
                        arrayList.add(file);
                    }
                } else {
                    arrayList.add(file);
                }
                i2++;
            }
            for (File file2 : arrayList) {
                d.deleteFile(file2);
            }
        }
    }

    private File co(long j) {
        if (TextUtils.isEmpty(this.dzt)) {
            return null;
        }
        return new File(this.dzt + File.separator + (e.aHw() == null ? "" : e.aHw()) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + j + "_swan_stability_traces.log");
    }
}
