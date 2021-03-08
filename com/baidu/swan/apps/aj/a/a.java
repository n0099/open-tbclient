package com.baidu.swan.apps.aj.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ao.j;
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
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private final String dMi;

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
            this.dMi = str + File.separator + "aiapps_folder/stability";
        } else {
            this.dMi = "";
        }
    }

    public File G(JSONArray jSONArray) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            ju(9);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("_app_id", e.aIP() == null ? "" : e.aIP());
            jSONObject.put("_date", j.a(new Date(currentTimeMillis), "yyyy-MM-dd HH:mm:ss"));
            jSONArray.put(jSONObject);
            File cU = cU(currentTimeMillis);
            if (cU != null) {
                if (com.baidu.swan.apps.s.a.p(cU.getPath(), jSONArray.toString(), false)) {
                    return cU;
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

    public File[] aLt() {
        if (TextUtils.isEmpty(this.dMi)) {
            return null;
        }
        try {
            return new File(this.dMi).listFiles();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("SwanStabilityTraceCache", "TraceCache Exception:", e);
                return null;
            }
            return null;
        }
    }

    private void ju(int i) {
        File[] aLt = aLt();
        if (aLt != null && aLt.length != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            Arrays.sort(aLt, new Comparator<File>() { // from class: com.baidu.swan.apps.aj.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                public int compare(File file, File file2) {
                    long lastModified = file.lastModified();
                    long lastModified2 = file2.lastModified();
                    if (lastModified == lastModified2) {
                        return 0;
                    }
                    return lastModified - lastModified2 > 0 ? 1 : -1;
                }
            });
            ArrayList<File> arrayList = new ArrayList(aLt.length);
            int length = aLt.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                File file = aLt[i2];
                if (i3 < i) {
                    if (file.lastModified() - currentTimeMillis > 172800000) {
                        arrayList.add(file);
                    }
                } else {
                    arrayList.add(file);
                }
                i2++;
                i3++;
            }
            for (File file2 : arrayList) {
                d.deleteFile(file2);
            }
        }
    }

    private File cU(long j) {
        if (TextUtils.isEmpty(this.dMi)) {
            return null;
        }
        return new File(this.dMi + File.separator + (e.aIP() == null ? "" : e.aIP()) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + j + "_swan_stability_traces.log");
    }
}
