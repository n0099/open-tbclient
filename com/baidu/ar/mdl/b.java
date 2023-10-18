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
/* loaded from: classes.dex */
public class b {
    public SparseArray<a> cD = new SparseArray<>();

    /* JADX WARN: Removed duplicated region for block: B:37:0x003f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(File file) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
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
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return sb2;
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
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
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
            if (bufferedReader2 != null) {
            }
            throw th;
        }
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
                aVar.f1035tv = z;
                aVar.tw = new String[length2];
                for (int i3 = 0; i3 < length2; i3++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i3);
                    int optInt = jSONObject2.optInt(ARPMessageType.ARPMessageParamKeys.MODEL_TYPE_KEY, i3);
                    File file = new File(str2, jSONObject2.getString(MapBundleKey.MapObjKey.OBJ_DIR));
                    String optString = jSONObject2.optString("design_model", "");
                    if (!TextUtils.isEmpty(optString)) {
                        file = new File(file, optString);
                    }
                    String absolutePath = file.getAbsolutePath();
                    if (z) {
                        absolutePath = absolutePath.substring(1);
                    }
                    aVar.tw[optInt] = absolutePath;
                }
                try {
                    this.cD.put(i2, aVar);
                } catch (JSONException e) {
                    e = e;
                    e.printStackTrace();
                    return;
                }
            }
        } catch (JSONException e2) {
            e = e2;
        }
    }

    public static String d(Context context, String str) {
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
        String a;
        boolean z;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith("file:///android_asset/")) {
            str = str.substring(22);
            if (!str.endsWith("/")) {
                str = str + "/";
            }
            a = d(context, str + "dl_config.json");
            z = true;
        } else {
            a = a(new File(str, "dl_config.json"));
            z = false;
        }
        a(a, str, z);
    }

    public SparseArray<a> fm() {
        return this.cD;
    }
}
