package com.baidu.swan.apps.al.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.aq.j;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.d.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private final String cNM;

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
            this.cNM = str + File.separator + "aiapps_folder/stability";
        } else {
            this.cNM = "";
        }
    }

    public File E(JSONArray jSONArray) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            hm(9);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("_app_id", e.arx() == null ? "" : e.arx());
            jSONObject.put("_date", j.a(new Date(currentTimeMillis), "yyyy-MM-dd HH:mm:ss"));
            jSONArray.put(jSONObject);
            File bA = bA(currentTimeMillis);
            if (bA != null) {
                if (com.baidu.swan.apps.s.a.l(bA.getPath(), jSONArray.toString(), false)) {
                    return bA;
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

    public File[] aue() {
        if (TextUtils.isEmpty(this.cNM)) {
            return null;
        }
        try {
            return new File(this.cNM).listFiles();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("SwanStabilityTraceCache", "TraceCache Exception:", e);
                return null;
            }
            return null;
        }
    }

    private void hm(int i) {
        File[] aue = aue();
        if (aue != null && aue.length != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            Arrays.sort(aue, new Comparator<File>() { // from class: com.baidu.swan.apps.al.a.a.1
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
            ArrayList<File> arrayList = new ArrayList(aue.length);
            int i2 = 0;
            for (File file : aue) {
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

    private File bA(long j) {
        if (TextUtils.isEmpty(this.cNM)) {
            return null;
        }
        return new File(this.cNM + File.separator + (e.arx() == null ? "" : e.arx()) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + j + "_swan_stability_traces.log");
    }
}
