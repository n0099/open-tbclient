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
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private final String cWL;

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
            this.cWL = str + File.separator + "aiapps_folder/stability";
        } else {
            this.cWL = "";
        }
    }

    public File G(JSONArray jSONArray) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            jt(9);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("_app_id", e.azK() == null ? "" : e.azK());
            jSONObject.put("_date", j.a(new Date(currentTimeMillis), "yyyy-MM-dd HH:mm:ss"));
            jSONArray.put(jSONObject);
            File bH = bH(currentTimeMillis);
            if (bH != null) {
                if (com.baidu.swan.apps.s.a.l(bH.getPath(), jSONArray.toString(), false)) {
                    return bH;
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

    public File[] aCn() {
        if (TextUtils.isEmpty(this.cWL)) {
            return null;
        }
        try {
            return new File(this.cWL).listFiles();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("SwanStabilityTraceCache", "TraceCache Exception:", e);
                return null;
            }
            return null;
        }
    }

    private void jt(int i) {
        File[] aCn = aCn();
        if (aCn != null && aCn.length != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            Arrays.sort(aCn, new Comparator<File>() { // from class: com.baidu.swan.apps.ak.a.a.1
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
            ArrayList<File> arrayList = new ArrayList(aCn.length);
            int i2 = 0;
            for (File file : aCn) {
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

    private File bH(long j) {
        if (TextUtils.isEmpty(this.cWL)) {
            return null;
        }
        return new File(this.cWL + File.separator + (e.azK() == null ? "" : e.azK()) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + j + "_swan_stability_traces.log");
    }
}
