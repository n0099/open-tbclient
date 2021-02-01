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
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private final String dKH;

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
            this.dKH = str + File.separator + "aiapps_folder/stability";
        } else {
            this.dKH = "";
        }
    }

    public File G(JSONArray jSONArray) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            jt(9);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("_app_id", e.aIM() == null ? "" : e.aIM());
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

    public File[] aLq() {
        if (TextUtils.isEmpty(this.dKH)) {
            return null;
        }
        try {
            return new File(this.dKH).listFiles();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("SwanStabilityTraceCache", "TraceCache Exception:", e);
                return null;
            }
            return null;
        }
    }

    private void jt(int i) {
        File[] aLq = aLq();
        if (aLq != null && aLq.length != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            Arrays.sort(aLq, new Comparator<File>() { // from class: com.baidu.swan.apps.aj.a.a.1
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
            ArrayList<File> arrayList = new ArrayList(aLq.length);
            int length = aLq.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                File file = aLq[i2];
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
        if (TextUtils.isEmpty(this.dKH)) {
            return null;
        }
        return new File(this.dKH + File.separator + (e.aIM() == null ? "" : e.aIM()) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + j + "_swan_stability_traces.log");
    }
}
