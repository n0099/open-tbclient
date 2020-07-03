package com.baidu.swan.apps.al.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.aq.i;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.e.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private final String cKv;

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
            this.cKv = str + File.separator + "aiapps_folder/stability";
        } else {
            this.cKv = "";
        }
    }

    public File D(JSONArray jSONArray) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            hd(9);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("_app_id", e.apO() == null ? "" : e.apO());
            jSONObject.put("_date", i.a(new Date(currentTimeMillis), "yyyy-MM-dd HH:mm:ss"));
            jSONArray.put(jSONObject);
            File bp = bp(currentTimeMillis);
            if (bp != null) {
                if (com.baidu.swan.apps.t.a.l(bp.getPath(), jSONArray.toString(), false)) {
                    return bp;
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

    public File[] ash() {
        if (TextUtils.isEmpty(this.cKv)) {
            return null;
        }
        try {
            return new File(this.cKv).listFiles();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("SwanStabilityTraceCache", "TraceCache Exception:", e);
                return null;
            }
            return null;
        }
    }

    private void hd(int i) {
        File[] ash = ash();
        if (ash != null && ash.length != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            Arrays.sort(ash, new Comparator<File>() { // from class: com.baidu.swan.apps.al.a.a.1
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
            ArrayList<File> arrayList = new ArrayList(ash.length);
            int i2 = 0;
            for (File file : ash) {
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

    private File bp(long j) {
        if (TextUtils.isEmpty(this.cKv)) {
            return null;
        }
        return new File(this.cKv + File.separator + (e.apO() == null ? "" : e.apO()) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + j + "_swan_stability_traces.log");
    }
}
