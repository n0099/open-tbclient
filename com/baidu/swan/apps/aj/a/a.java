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
    private final String dID;

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
            this.dID = str + File.separator + "aiapps_folder/stability";
        } else {
            this.dID = "";
        }
    }

    public File H(JSONArray jSONArray) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            jq(9);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("_app_id", e.aIt() == null ? "" : e.aIt());
            jSONObject.put("_date", j.a(new Date(currentTimeMillis), "yyyy-MM-dd HH:mm:ss"));
            jSONArray.put(jSONObject);
            File cO = cO(currentTimeMillis);
            if (cO != null) {
                if (com.baidu.swan.apps.s.a.p(cO.getPath(), jSONArray.toString(), false)) {
                    return cO;
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

    public File[] aKX() {
        if (TextUtils.isEmpty(this.dID)) {
            return null;
        }
        try {
            return new File(this.dID).listFiles();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("SwanStabilityTraceCache", "TraceCache Exception:", e);
                return null;
            }
            return null;
        }
    }

    private void jq(int i) {
        File[] aKX = aKX();
        if (aKX != null && aKX.length != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            Arrays.sort(aKX, new Comparator<File>() { // from class: com.baidu.swan.apps.aj.a.a.1
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
            ArrayList<File> arrayList = new ArrayList(aKX.length);
            int length = aKX.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                File file = aKX[i2];
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

    private File cO(long j) {
        if (TextUtils.isEmpty(this.dID)) {
            return null;
        }
        return new File(this.dID + File.separator + (e.aIt() == null ? "" : e.aIt()) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + j + "_swan_stability_traces.log");
    }
}
