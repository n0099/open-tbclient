package com.baidu.mapsdkplatform.comapi.map;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.webkit.internal.ETAG;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2227a = f.class.getSimpleName();
    private AsyncHttpClient b;

    /* loaded from: classes7.dex */
    public interface a {
        void a(int i, String str, String str2);

        void a(String str);

        void a(boolean z, String str);
    }

    /* loaded from: classes7.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private static final f f2228a = new f(null);
    }

    private f() {
        this.b = new AsyncHttpClient();
    }

    /* synthetic */ f(g gVar) {
        this();
    }

    public static f a() {
        return b.f2228a;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x005e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(Context context) {
        BufferedReader bufferedReader;
        Throwable th;
        IOException e;
        if (context == null) {
            return null;
        }
        File file = new File(context.getFilesDir().getAbsolutePath(), "ver.cfg");
        if (!file.exists()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    } catch (IOException e2) {
                        e = e2;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                                return "";
                            } catch (IOException e3) {
                                e3.printStackTrace();
                                return "";
                            }
                        }
                        return "";
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            return sb.toString();
        } catch (IOException e6) {
            bufferedReader = null;
            e = e6;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            if (bufferedReader != null) {
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(Context context, String str) {
        if (context == null) {
            return null;
        }
        return context.getFilesDir().getAbsolutePath() + File.separator + "sc_sty_" + str + ".sty";
    }

    private String a(Context context, String str, boolean z) {
        if (context == null) {
            return "";
        }
        String b2 = b(context, str);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(MapBundleKey.MapObjKey.OBJ_STYLE_ID, str);
        if (z) {
            linkedHashMap.put("type", UgcUBCUtils.PUBLISH_PAGE);
        } else {
            linkedHashMap.put("type", "edit");
        }
        linkedHashMap.put("md5", b2);
        linkedHashMap.put("token", SyncSysInfo.getAuthToken());
        String str2 = a(linkedHashMap) + SyncSysInfo.getPhoneInfo();
        return b("api.map.baidu.com/sdkproxy/v2/lbs_androidsdk/custom/v2/getjsonstyle") + "?" + (str2 + "&sign=" + AppMD5.getSignMD5String(str2));
    }

    private String a(Map<String, String> map) {
        if (map.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = map.keySet().iterator();
        int i = 0;
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return sb.toString();
            }
            String next = it.next();
            String encodeUrlParamsValue = AppMD5.encodeUrlParamsValue(map.get(next));
            if (i2 == 0) {
                sb.append(next).append(ETAG.EQUAL).append(encodeUrlParamsValue);
            } else {
                sb.append(ETAG.ITEM_SEPARATOR).append(next).append(ETAG.EQUAL).append(encodeUrlParamsValue);
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, String str2) {
        JSONArray jSONArray;
        JSONObject jSONObject;
        int i;
        PrintWriter printWriter;
        PrintWriter printWriter2 = null;
        if (context == null) {
            return;
        }
        File file = new File(context.getFilesDir().getAbsolutePath(), "ver.cfg");
        String a2 = a(context);
        try {
            try {
                jSONArray = TextUtils.isEmpty(a2) ? new JSONArray() : new JSONArray(a2);
                int length = jSONArray.length();
                if (length == 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(str, str2);
                    jSONArray.put(jSONObject2);
                } else {
                    int i2 = 0;
                    JSONObject jSONObject3 = null;
                    while (true) {
                        if (i2 < length) {
                            jSONObject3 = (JSONObject) jSONArray.opt(i2);
                            if (jSONObject3 != null && jSONObject3.has(str)) {
                                int i3 = i2;
                                jSONObject = jSONObject3;
                                i = i3;
                                break;
                            }
                            i2++;
                        } else {
                            jSONObject = jSONObject3;
                            i = -1;
                            break;
                        }
                    }
                    if (i == -1 || jSONObject == null) {
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put(str, str2);
                        jSONArray.put(jSONObject4);
                    } else {
                        jSONObject.put(str, str2);
                        jSONArray.put(i, jSONObject);
                    }
                }
                printWriter = new PrintWriter(new FileWriter(file.getAbsoluteFile()));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            printWriter.write(jSONArray.toString());
            if (printWriter != null) {
                printWriter.close();
            }
        } catch (Exception e2) {
            e = e2;
            printWriter2 = printWriter;
            e.printStackTrace();
            if (printWriter2 != null) {
                printWriter2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            printWriter2 = printWriter;
            if (printWriter2 != null) {
                printWriter2.close();
            }
            throw th;
        }
    }

    private void a(Context context, String str, String str2, a aVar) {
        this.b.get(str, new g(this, context, str2, aVar));
    }

    private void a(Context context, String str, String str2, String str3, a aVar) {
        if (TextUtils.isEmpty(str) || context == null) {
            return;
        }
        String b2 = b(str);
        String a2 = a(context, str2);
        new com.baidu.mapsdkplatform.comapi.commonutils.a.d().a(b2, context.getFilesDir().getAbsolutePath(), str2 + ".zip", 2, new h(this, context, str2, aVar, str3, a2));
    }

    private void a(Context context, String str, boolean z, a aVar) {
        String a2 = a(context, str);
        if (!a(a2)) {
            a2 = null;
        }
        if (aVar != null) {
            aVar.a(a2);
        }
        if (!NetworkUtil.isNetworkAvailable(context)) {
            if (aVar != null) {
                aVar.a(HttpClient.HttpStateError.NETWORK_ERROR.ordinal(), HttpClient.HttpStateError.NETWORK_ERROR.name(), a2);
            }
        } else if (TextUtils.isEmpty(str)) {
        } else {
            String a3 = a(context, str, z);
            if (TextUtils.isEmpty(a3)) {
                Log.e(f2227a, "build request url failed");
            } else {
                a(context, a3, str, aVar);
            }
        }
    }

    private boolean a(int i, String str) {
        return (103 == i && a(str)) ? false : true;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:83:0x0130 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:85:0x0132 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:87:0x0134 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:89:0x0136 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:91:0x0138 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:93:0x013b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:95:0x013e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:97:0x0141 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v14, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r2v16, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r2v18, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r2v20, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r2v22, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r2v24, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r2v27, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r2v29, resolved type: java.lang.String */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0122 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(Context context, File file, String str) {
        ZipFile zipFile;
        ZipFile zipFile2;
        boolean z = false;
        if (file != null && context != null) {
            try {
                try {
                    zipFile2 = new ZipFile(file.getAbsoluteFile());
                    try {
                        ZipEntry entry = zipFile2.getEntry(str + ".sty");
                        zipFile = zipFile2;
                        if (entry != null) {
                            boolean a2 = a(zipFile2.getInputStream(entry), new FileOutputStream(new File(a(context, str))));
                            file.delete();
                            ZipFile zipFile3 = zipFile2;
                            if (zipFile2 != null) {
                                try {
                                    zipFile2.close();
                                    zipFile3 = zipFile2;
                                } catch (IOException e) {
                                    String str2 = f2227a;
                                    Log.e(str2, "Close zipFile failed", e);
                                    zipFile3 = str2;
                                }
                            }
                            z = a2;
                            zipFile = zipFile3;
                        } else if (zipFile2 != null) {
                            try {
                                zipFile2.close();
                                zipFile = zipFile2;
                            } catch (IOException e2) {
                                String str3 = f2227a;
                                Log.e(str3, "Close zipFile failed", e2);
                                zipFile = str3;
                            }
                        }
                    } catch (FileNotFoundException e3) {
                        e = e3;
                        Log.e(f2227a, "unzip style file FileNotFoundException", e);
                        zipFile = zipFile2;
                        if (zipFile2 != null) {
                            try {
                                zipFile2.close();
                                zipFile = zipFile2;
                            } catch (IOException e4) {
                                String str4 = f2227a;
                                Log.e(str4, "Close zipFile failed", e4);
                                zipFile = str4;
                            }
                        }
                        return z;
                    } catch (IOException e5) {
                        e = e5;
                        Log.e(f2227a, "unzip style file IOException", e);
                        zipFile = zipFile2;
                        if (zipFile2 != null) {
                            try {
                                zipFile2.close();
                                zipFile = zipFile2;
                            } catch (IOException e6) {
                                String str5 = f2227a;
                                Log.e(str5, "Close zipFile failed", e6);
                                zipFile = str5;
                            }
                        }
                        return z;
                    } catch (IllegalStateException e7) {
                        e = e7;
                        Log.e(f2227a, "unzip style file IllegalStateException", e);
                        zipFile = zipFile2;
                        if (zipFile2 != null) {
                            try {
                                zipFile2.close();
                                zipFile = zipFile2;
                            } catch (IOException e8) {
                                String str6 = f2227a;
                                Log.e(str6, "Close zipFile failed", e8);
                                zipFile = str6;
                            }
                        }
                        return z;
                    } catch (NullPointerException e9) {
                        e = e9;
                        Log.e(f2227a, "unzip style file NullPointerException", e);
                        zipFile = zipFile2;
                        if (zipFile2 != null) {
                            try {
                                zipFile2.close();
                                zipFile = zipFile2;
                            } catch (IOException e10) {
                                String str7 = f2227a;
                                Log.e(str7, "Close zipFile failed", e10);
                                zipFile = str7;
                            }
                        }
                        return z;
                    } catch (SecurityException e11) {
                        e = e11;
                        Log.e(f2227a, "unzip style file SecurityException", e);
                        zipFile = zipFile2;
                        if (zipFile2 != null) {
                            try {
                                zipFile2.close();
                                zipFile = zipFile2;
                            } catch (IOException e12) {
                                String str8 = f2227a;
                                Log.e(str8, "Close zipFile failed", e12);
                                zipFile = str8;
                            }
                        }
                        return z;
                    } catch (ZipException e13) {
                        e = e13;
                        Log.e(f2227a, "unzip style file ZipException", e);
                        zipFile = zipFile2;
                        if (zipFile2 != null) {
                            try {
                                zipFile2.close();
                                zipFile = zipFile2;
                            } catch (IOException e14) {
                                String str9 = f2227a;
                                Log.e(str9, "Close zipFile failed", e14);
                                zipFile = str9;
                            }
                        }
                        return z;
                    } catch (Exception e15) {
                        if (zipFile2 != null) {
                            try {
                                zipFile2.close();
                            } catch (IOException e16) {
                                Log.e(f2227a, "Close zipFile failed", e16);
                            }
                        }
                        return z;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e17) {
                            Log.e(f2227a, "Close zipFile failed", e17);
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e18) {
                e = e18;
                zipFile2 = null;
            } catch (IOException e19) {
                e = e19;
                zipFile2 = null;
            } catch (IllegalStateException e20) {
                e = e20;
                zipFile2 = null;
            } catch (NullPointerException e21) {
                e = e21;
                zipFile2 = null;
            } catch (SecurityException e22) {
                e = e22;
                zipFile2 = null;
            } catch (ZipException e23) {
                e = e23;
                zipFile2 = null;
            } catch (Exception e24) {
                zipFile2 = null;
            } catch (Throwable th2) {
                th = th2;
                zipFile = null;
                if (zipFile != null) {
                }
                throw th;
            }
        }
        return z;
    }

    private boolean a(InputStream inputStream, FileOutputStream fileOutputStream) throws IOException, NullPointerException {
        if (inputStream == null || fileOutputStream == null) {
            return false;
        }
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    Log.e(f2227a, "Close InputStream error", e);
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e2) {
                    Log.e(f2227a, "Close OutputStream error", e2);
                }
            }
        }
        fileOutputStream.flush();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    private String b(Context context, String str) {
        try {
            JSONArray jSONArray = new JSONArray(a(context));
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                String optString = ((JSONObject) jSONArray.opt(i)).optString(str);
                if (!TextUtils.isEmpty(optString)) {
                    return optString;
                }
            }
            return "";
        } catch (JSONException e) {
            return "";
        }
    }

    private String b(String str) {
        return HttpClient.isHttpsEnable ? SapiUtils.COOKIE_HTTPS_URL_PREFIX + str : "http://" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, String str, String str2, a aVar) {
        String a2 = a(context, str2);
        String str3 = a(a2) ? a2 : null;
        if (TextUtils.isEmpty(str)) {
            if (aVar != null) {
                aVar.a(HttpClient.HttpStateError.SERVER_ERROR.ordinal(), HttpClient.HttpStateError.SERVER_ERROR.name(), str3);
                return;
            }
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("status");
            String optString = jSONObject.optString("message");
            if (!a(optInt, a2)) {
                if (aVar != null) {
                    aVar.a(false, str3);
                }
            } else if (optInt != 0) {
                if (aVar != null) {
                    aVar.a(optInt, optString, str3);
                }
            } else {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null && optJSONObject.length() != 0) {
                    a(context, optJSONObject.optString("pb_url", ""), str2, optJSONObject.optString("md5", ""), aVar);
                } else if (aVar != null) {
                    aVar.a(HttpClient.HttpStateError.SERVER_ERROR.ordinal(), "custom style data is null", str3);
                }
            }
        } catch (JSONException e) {
            if (aVar != null) {
                aVar.a(HttpClient.HttpStateError.INNER_ERROR.ordinal(), "parse response result failed", str3);
            }
        }
    }

    public void a(Context context, String str, a aVar) {
        a(context, str, true, aVar);
    }
}
