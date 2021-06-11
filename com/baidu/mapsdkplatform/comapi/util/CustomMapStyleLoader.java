package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.searchbox.pms.db.PackageTable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CustomMapStyleLoader {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7914a = "CustomMapStyleLoader";

    /* renamed from: c  reason: collision with root package name */
    public static String f7915c;

    /* renamed from: b  reason: collision with root package name */
    public String f7916b;

    /* renamed from: d  reason: collision with root package name */
    public Context f7917d;

    /* renamed from: e  reason: collision with root package name */
    public String f7918e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7919f;

    /* renamed from: g  reason: collision with root package name */
    public AsyncHttpClient f7920g;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CustomMapStyleLoader.this.b();
            String d2 = CustomMapStyleLoader.this.d();
            if (TextUtils.isEmpty(d2)) {
                Log.e(CustomMapStyleLoader.f7914a, "build request url failed");
            } else {
                CustomMapStyleLoader.this.a(d2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final CustomMapStyleLoader f7922a = new CustomMapStyleLoader(null);
    }

    public CustomMapStyleLoader() {
        this.f7919f = true;
        this.f7920g = new AsyncHttpClient();
    }

    public /* synthetic */ CustomMapStyleLoader(c cVar) {
        this();
    }

    private String a(Map<String, String> map) {
        if (map.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (String str : map.keySet()) {
            String encodeUrlParamsValue = AppMD5.encodeUrlParamsValue(map.get(str));
            if (i2 != 0) {
                sb.append("&");
            }
            sb.append(str);
            sb.append("=");
            sb.append(encodeUrlParamsValue);
            i2++;
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        this.f7920g.get(str, new c(this));
    }

    private void a(JSONObject jSONObject) {
        File file = new File(f7915c);
        if (file.exists()) {
            file.delete();
        }
        try {
            if (file.createNewFile()) {
                file.createNewFile();
            }
        } catch (IOException e2) {
            Log.e(f7914a, "create custom file failed", e2);
        }
        String optString = jSONObject.optString("json");
        String optString2 = jSONObject.optString(PackageTable.MD5, StringUtil.NULL_STRING);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("json", optString);
            jSONObject2.put(PackageTable.MD5, optString2);
        } catch (JSONException e3) {
            Log.e(f7914a, "build style data failed", e3);
        }
        String jSONObject3 = jSONObject2.toString();
        try {
            FileOutputStream openFileOutput = this.f7917d.openFileOutput("server_custom_style_file.json", 0);
            openFileOutput.write(jSONObject3.getBytes());
            openFileOutput.flush();
            openFileOutput.close();
        } catch (IOException e4) {
            Log.e(f7914a, "write style data into file failed", e4);
        }
    }

    private boolean a(int i2, String str) {
        if (103 == i2 && c()) {
            b(i2, str);
            return false;
        }
        b(i2, str);
        return i2 == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (!c()) {
            this.f7916b = StringUtil.NULL_STRING;
            return;
        }
        try {
            FileInputStream openFileInput = this.f7917d.openFileInput("server_custom_style_file.json");
            JsonReader jsonReader = new JsonReader(new InputStreamReader(openFileInput));
            try {
                try {
                    try {
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            if (jsonReader.nextName().equals(PackageTable.MD5)) {
                                this.f7916b = jsonReader.nextString();
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        jsonReader.endObject();
                        jsonReader.close();
                        openFileInput.close();
                    } catch (IOException e2) {
                        Log.e(f7914a, "Close custom style failed", e2);
                    }
                } catch (IOException e3) {
                    this.f7916b = StringUtil.NULL_STRING;
                    Log.e(f7914a, "Read custom style failed", e3);
                    jsonReader.close();
                    openFileInput.close();
                }
            } catch (Throwable th) {
                try {
                    jsonReader.close();
                    openFileInput.close();
                } catch (IOException e4) {
                    Log.e(f7914a, "Close custom style failed", e4);
                }
                throw th;
            }
        } catch (FileNotFoundException e5) {
            this.f7916b = StringUtil.NULL_STRING;
            Log.e(f7914a, "Open custom style failed", e5);
        }
    }

    private void b(int i2, String str) {
        Intent intent = i2 == 0 ? new Intent(SDKInitializer.SDK_BROADTCAST_ACTION_STRING_LOAD_CUSTOM_STYLE_SUCCESS) : new Intent(SDKInitializer.SDK_BROADTCAST_ACTION_STRING_LOAD_CUSTOM_STYLE_ERROR);
        intent.putExtra("error_code", i2);
        intent.putExtra("error_message", str);
        this.f7917d.sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (a(jSONObject.optInt("status"), jSONObject.optString("message"))) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null || optJSONObject.length() == 0) {
                    Log.e(f7914a, "custom style data is null");
                } else {
                    a(optJSONObject);
                }
            }
        } catch (JSONException e2) {
            Log.e(f7914a, "parse response result failed", e2);
        }
    }

    private boolean c() {
        return new File(f7915c).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d() {
        String str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("style_id", this.f7918e);
        linkedHashMap.put("type", this.f7919f ? "publish" : "edit");
        linkedHashMap.put(PackageTable.MD5, this.f7916b);
        linkedHashMap.put("token", i.f7965d);
        return e() + "?" + ((a(linkedHashMap) + i.c()) + "&sign=" + AppMD5.getSignMD5String(str));
    }

    private String e() {
        return HttpClient.isHttpsEnable ? "https://api.map.baidu.com/sdkproxy/v2/lbs_androidsdk/custom/v2/getjsonstyle" : "http://api.map.baidu.com/sdkproxy/v2/lbs_androidsdk/custom/v2/getjsonstyle";
    }

    public static String getCustomStyleFilePath() {
        return f7915c;
    }

    public static CustomMapStyleLoader getInstance() {
        return b.f7922a;
    }

    public void initCustomStyleFilePath(Context context) {
        this.f7917d = context;
        f7915c = context.getFilesDir().getAbsolutePath();
        f7915c += "/server_custom_style_file.json";
    }

    public void loadCustomMapStyleFile(String str, boolean z) {
        if (NetworkUtil.isNetworkAvailable(this.f7917d) && !TextUtils.isEmpty(str)) {
            this.f7918e = str;
            this.f7919f = z;
            new Thread(new a(), "Load custom style").start();
        }
    }
}
