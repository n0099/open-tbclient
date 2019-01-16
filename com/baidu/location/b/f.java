package com.baidu.location.b;

import android.net.wifi.WifiConfiguration;
import android.os.Handler;
import android.os.Message;
import com.baidu.android.bbalbs.common.security.Base64;
import com.baidu.location.Jni;
import com.baidu.location.g.g;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f {
    private static Object a = new Object();
    private static f aeF = null;
    private Handler c = null;
    private String d = null;
    private int e = 24;
    private a aeG = null;
    private long g = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends com.baidu.location.g.e {
        private boolean b = false;
        private int c = 0;
        private JSONArray d = null;
        private JSONArray e = null;

        a() {
            this.k = new HashMap();
        }

        @Override // com.baidu.location.g.e
        public void a() {
            this.h = g.e();
            this.k.clear();
            this.k.put("qt", "cltrw");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("data", this.d);
                jSONObject.put("frt", this.c);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.k.put("cltr[0]", "" + Jni.encodeOfflineLocationUpdateRequest(jSONObject.toString()));
            this.k.put("cfg", 1);
            this.k.put("info", Jni.encode(com.baidu.location.g.b.tZ().c()));
            this.k.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
        }

        @Override // com.baidu.location.g.e
        public void a(boolean z) {
            JSONObject jSONObject;
            boolean z2;
            if (z && this.j != null) {
                try {
                    jSONObject = new JSONObject(this.j);
                    z2 = true;
                } catch (Exception e) {
                    jSONObject = null;
                    z2 = false;
                }
                if (z2 && jSONObject != null) {
                    try {
                        jSONObject.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, System.currentTimeMillis());
                        jSONObject.put("data", this.e);
                        try {
                            File file = new File(f.this.d, "wcnf.dat");
                            if (!file.exists()) {
                                file.createNewFile();
                            }
                            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, false));
                            bufferedWriter.write(Base64.encode(jSONObject.toString().getBytes(), "UTF-8"));
                            bufferedWriter.flush();
                            bufferedWriter.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } catch (Exception e3) {
                    }
                }
            }
            this.b = false;
        }

        public void a(boolean z, JSONArray jSONArray, JSONArray jSONArray2) {
            if (this.b) {
                return;
            }
            this.b = true;
            if (z) {
                this.c = 1;
            } else {
                this.c = 0;
            }
            this.d = jSONArray;
            this.e = jSONArray2;
            b(g.e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b {
        public String a;
        public int b;

        b(String str, int i) {
            this.a = null;
            this.b = 0;
            this.a = str;
            this.b = i;
        }
    }

    private Object a(Object obj, String str) throws Exception {
        return obj.getClass().getField(str).get(obj);
    }

    private List<b> a(List<WifiConfiguration> list) {
        int i;
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (WifiConfiguration wifiConfiguration : list) {
            String str = wifiConfiguration.SSID;
            try {
                i = ((Integer) a(wifiConfiguration, "numAssociation")).intValue();
            } catch (Throwable th) {
                th.printStackTrace();
                i = 0;
            }
            if (i > 0 && str != null) {
                arrayList.add(new b(str, i));
            }
        }
        return arrayList;
    }

    private void a(boolean z, JSONArray jSONArray, JSONArray jSONArray2) {
        if (this.aeG == null) {
            this.aeG = new a();
        }
        this.aeG.a(z, jSONArray, jSONArray2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:116:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:117:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0041 A[Catch: Exception -> 0x00ac, TryCatch #0 {Exception -> 0x00ac, blocks: (B:4:0x0004, B:15:0x0041, B:16:0x0047, B:18:0x0059, B:21:0x0070, B:23:0x0076, B:24:0x0084, B:26:0x008a, B:63:0x0176, B:65:0x017d, B:67:0x0183, B:69:0x018a, B:71:0x0190, B:72:0x0194, B:74:0x019a, B:76:0x01c1, B:81:0x01d4, B:82:0x01d9, B:13:0x003a), top: B:98:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0059 A[Catch: Exception -> 0x00ac, TryCatch #0 {Exception -> 0x00ac, blocks: (B:4:0x0004, B:15:0x0041, B:16:0x0047, B:18:0x0059, B:21:0x0070, B:23:0x0076, B:24:0x0084, B:26:0x008a, B:63:0x0176, B:65:0x017d, B:67:0x0183, B:69:0x018a, B:71:0x0190, B:72:0x0194, B:74:0x019a, B:76:0x01c1, B:81:0x01d4, B:82:0x01d9, B:13:0x003a), top: B:98:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e9 A[Catch: Exception -> 0x01f6, TryCatch #2 {Exception -> 0x01f6, blocks: (B:38:0x00e0, B:40:0x00e9, B:42:0x00f9, B:43:0x0102, B:45:0x010b, B:46:0x0112, B:48:0x011b), top: B:102:0x00e0 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010b A[Catch: Exception -> 0x01f6, TryCatch #2 {Exception -> 0x01f6, blocks: (B:38:0x00e0, B:40:0x00e9, B:42:0x00f9, B:43:0x0102, B:45:0x010b, B:46:0x0112, B:48:0x011b), top: B:102:0x00e0 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x011b A[Catch: Exception -> 0x01f6, TRY_LEAVE, TryCatch #2 {Exception -> 0x01f6, blocks: (B:38:0x00e0, B:40:0x00e9, B:42:0x00f9, B:43:0x0102, B:45:0x010b, B:46:0x0112, B:48:0x011b), top: B:102:0x00e0 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0174 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x020d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d() {
        boolean z;
        Exception e;
        HashMap hashMap;
        boolean z2;
        long j;
        HashMap hashMap2;
        boolean z3;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        if (this.d == null) {
            return;
        }
        try {
            File file = new File(this.d, "wcnf.dat");
            long currentTimeMillis = System.currentTimeMillis();
            HashMap hashMap3 = null;
            if (file.exists()) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    }
                    bufferedReader.close();
                    String stringBuffer2 = stringBuffer.toString();
                    if (stringBuffer2 != null) {
                        JSONObject jSONObject = new JSONObject(new String(Base64.decode(stringBuffer2.getBytes())));
                        try {
                            if (jSONObject.has("ison")) {
                                if (jSONObject.getInt("ison") == 0) {
                                    z = false;
                                    if (jSONObject.has("cfg")) {
                                        JSONObject jSONObject2 = jSONObject.getJSONObject("cfg");
                                        if (jSONObject2.has("frq")) {
                                            this.e = jSONObject2.getInt("frq");
                                        }
                                    }
                                    if (jSONObject.has(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP)) {
                                        currentTimeMillis = jSONObject.getLong(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP);
                                    }
                                    if (jSONObject.has("data")) {
                                        hashMap2 = null;
                                        z2 = z;
                                        j = currentTimeMillis;
                                    } else {
                                        JSONArray jSONArray3 = jSONObject.getJSONArray("data");
                                        hashMap2 = new HashMap();
                                        try {
                                            int length = jSONArray3.length();
                                            for (int i = 0; i < length; i++) {
                                                JSONObject jSONObject3 = jSONArray3.getJSONObject(i);
                                                if (jSONObject3.has("ssid") && jSONObject3.has("num")) {
                                                    hashMap2.put(jSONObject3.getString("ssid"), new b(jSONObject3.getString("ssid"), jSONObject3.getInt("num")));
                                                }
                                            }
                                            z2 = z;
                                            j = currentTimeMillis;
                                        } catch (Exception e2) {
                                            hashMap3 = hashMap2;
                                            e = e2;
                                            e.printStackTrace();
                                            hashMap = hashMap3;
                                            z2 = z;
                                            if (!z2) {
                                            }
                                            if (System.currentTimeMillis() - currentTimeMillis > this.e * 60 * 60 * 1000) {
                                            }
                                        }
                                    }
                                }
                            }
                            if (jSONObject.has("cfg")) {
                            }
                            if (jSONObject.has(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP)) {
                            }
                            if (jSONObject.has("data")) {
                            }
                        } catch (Exception e3) {
                            e = e3;
                        }
                        z = true;
                    } else {
                        j = currentTimeMillis;
                        hashMap2 = null;
                        z2 = true;
                    }
                    hashMap = hashMap2;
                    currentTimeMillis = j;
                } catch (Exception e4) {
                    z = true;
                    e = e4;
                }
            } else {
                hashMap = null;
                currentTimeMillis = 0;
                z2 = true;
            }
            if (!z2) {
                this.e *= 4;
            }
            if (System.currentTimeMillis() - currentTimeMillis > this.e * 60 * 60 * 1000) {
                return;
            }
            JSONArray jSONArray4 = null;
            List<b> a2 = a(com.baidu.location.e.f.tU().d());
            if (currentTimeMillis == 0) {
                if (a2 != null && a2.size() > 0) {
                    jSONArray4 = new JSONArray();
                    jSONArray = new JSONArray();
                    for (b bVar : a2) {
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("ssid", bVar.a);
                        jSONObject4.put("num", bVar.b);
                        jSONArray4.put(jSONObject4);
                        jSONArray.put(jSONObject4);
                    }
                    z3 = true;
                    if (jSONArray4 != null || jSONArray == null) {
                        return;
                    }
                    a(z3, jSONArray4, jSONArray);
                    return;
                }
                jSONArray = null;
                z3 = false;
                if (jSONArray4 != null) {
                    return;
                }
                return;
            }
            if (a2 != null && a2.size() > 0) {
                JSONArray jSONArray5 = new JSONArray();
                if (hashMap != null && hashMap.size() > 0) {
                    for (b bVar2 : a2) {
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("ssid", bVar2.a);
                        jSONObject5.put("num", bVar2.b);
                        jSONArray5.put(jSONObject5);
                        if (hashMap.containsKey(bVar2.a) ? bVar2.b != ((b) hashMap.get(bVar2.a)).b : true) {
                            JSONArray jSONArray6 = jSONArray4 == null ? new JSONArray() : jSONArray4;
                            JSONObject jSONObject6 = new JSONObject();
                            jSONObject6.put("ssid", bVar2.a);
                            jSONObject6.put("num", bVar2.b);
                            jSONArray6.put(jSONObject6);
                            jSONArray2 = jSONArray6;
                        } else {
                            jSONArray2 = jSONArray4;
                        }
                        jSONArray4 = jSONArray2;
                    }
                }
                z3 = false;
                jSONArray = jSONArray5;
                if (jSONArray4 != null) {
                }
            }
            jSONArray = null;
            z3 = false;
            if (jSONArray4 != null) {
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public static f tC() {
        f fVar;
        synchronized (a) {
            if (aeF == null) {
                aeF = new f();
            }
            fVar = aeF;
        }
        return fVar;
    }

    public void b() {
        if (this.c == null) {
            this.c = new Handler() { // from class: com.baidu.location.b.f.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    switch (message.what) {
                        case 1:
                            f.this.d();
                            return;
                        default:
                            return;
                    }
                }
            };
        }
        this.d = g.g();
    }

    public void c() {
        if (System.currentTimeMillis() - this.g <= 3600000 || this.c == null) {
            return;
        }
        this.c.sendEmptyMessage(1);
        this.g = System.currentTimeMillis();
    }
}
