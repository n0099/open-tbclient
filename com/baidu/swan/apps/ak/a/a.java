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
    private final String dtB;

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
            this.dtB = str + File.separator + "aiapps_folder/stability";
        } else {
            this.dtB = "";
        }
    }

    public File G(JSONArray jSONArray) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            km(9);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("_app_id", e.aEW() == null ? "" : e.aEW());
            jSONObject.put("_date", j.a(new Date(currentTimeMillis), "yyyy-MM-dd HH:mm:ss"));
            jSONArray.put(jSONObject);
            File bS = bS(currentTimeMillis);
            if (bS != null) {
                if (com.baidu.swan.apps.s.a.l(bS.getPath(), jSONArray.toString(), false)) {
                    return bS;
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

    public File[] aHA() {
        if (TextUtils.isEmpty(this.dtB)) {
            return null;
        }
        try {
            return new File(this.dtB).listFiles();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("SwanStabilityTraceCache", "TraceCache Exception:", e);
                return null;
            }
            return null;
        }
    }

    private void km(int i) {
        File[] aHA = aHA();
        if (aHA != null && aHA.length != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            Arrays.sort(aHA, new Comparator<File>() { // from class: com.baidu.swan.apps.ak.a.a.1
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
            ArrayList<File> arrayList = new ArrayList(aHA.length);
            int i2 = 0;
            for (File file : aHA) {
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

    private File bS(long j) {
        if (TextUtils.isEmpty(this.dtB)) {
            return null;
        }
        return new File(this.dtB + File.separator + (e.aEW() == null ? "" : e.aEW()) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + j + "_swan_stability_traces.log");
    }
}
