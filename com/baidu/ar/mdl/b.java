package com.baidu.ar.mdl;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    private SparseArray<a> cD = new SparseArray<>();

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x003c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(File file) {
        BufferedReader bufferedReader;
        String str = 0;
        str = 0;
        str = 0;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    }
                    String sb2 = sb.toString();
                    str = sb2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                            str = sb2;
                        } catch (IOException e) {
                            e.printStackTrace();
                            str = sb2;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return str;
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        str.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            throw th;
        }
        return str;
    }

    private void a(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                int i2 = jSONObject.getInt("type");
                JSONArray jSONArray2 = jSONObject.getJSONArray("models");
                int length2 = jSONArray2.length();
                a aVar = new a();
                aVar.type = i2;
                aVar.f1487tv = z;
                aVar.tw = new String[length2];
                for (int i3 = 0; i3 < length2; i3++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i3);
                    int optInt = jSONObject2.optInt(ARPMessageType.ARPMessageParamKeys.MODEL_TYPE_KEY, i3);
                    File file = new File(str2, jSONObject2.getString(MapBundleKey.MapObjKey.OBJ_DIR));
                    String optString = jSONObject2.optString("design_model", "");
                    String absolutePath = (!TextUtils.isEmpty(optString) ? new File(file, optString) : file).getAbsolutePath();
                    if (z) {
                        absolutePath = absolutePath.substring(1);
                    }
                    aVar.tw[optInt] = absolutePath;
                }
                this.cD.put(i2, aVar);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static String d(Context context, String str) {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(context.getAssets().open(str), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    inputStreamReader.close();
                    return sb.toString();
                }
                sb.append(readLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void a(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!str.startsWith("file:///android_asset/")) {
            a(a(new File(str, "dl_config.json")), str, false);
            return;
        }
        String substring = str.substring("file:///android_asset/".length());
        if (!substring.endsWith("/")) {
            substring = substring + "/";
        }
        a(d(context, substring + "dl_config.json"), substring, true);
    }

    public SparseArray<a> fm() {
        return this.cD;
    }
}
