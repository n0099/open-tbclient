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
/* loaded from: classes3.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private final String cYP;

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
            this.cYP = str + File.separator + "aiapps_folder/stability";
        } else {
            this.cYP = "";
        }
    }

    public File G(JSONArray jSONArray) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            jE(9);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("_app_id", e.aAt() == null ? "" : e.aAt());
            jSONObject.put("_date", j.a(new Date(currentTimeMillis), "yyyy-MM-dd HH:mm:ss"));
            jSONArray.put(jSONObject);
            File bI = bI(currentTimeMillis);
            if (bI != null) {
                if (com.baidu.swan.apps.s.a.l(bI.getPath(), jSONArray.toString(), false)) {
                    return bI;
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

    public File[] aCX() {
        if (TextUtils.isEmpty(this.cYP)) {
            return null;
        }
        try {
            return new File(this.cYP).listFiles();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("SwanStabilityTraceCache", "TraceCache Exception:", e);
                return null;
            }
            return null;
        }
    }

    private void jE(int i) {
        File[] aCX = aCX();
        if (aCX != null && aCX.length != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            Arrays.sort(aCX, new Comparator<File>() { // from class: com.baidu.swan.apps.ak.a.a.1
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
            ArrayList<File> arrayList = new ArrayList(aCX.length);
            int i2 = 0;
            for (File file : aCX) {
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

    private File bI(long j) {
        if (TextUtils.isEmpty(this.cYP)) {
            return null;
        }
        return new File(this.cYP + File.separator + (e.aAt() == null ? "" : e.aAt()) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + j + "_swan_stability_traces.log");
    }
}
