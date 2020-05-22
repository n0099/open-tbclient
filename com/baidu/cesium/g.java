package com.baidu.cesium;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.support.media.ExifInterface;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.cesium.b.a;
import com.baidu.cesium.e.a;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class g {
    private a.C0101a ajB;
    private volatile FileLock ajC;
    private volatile RandomAccessFile ajD;
    private com.baidu.cesium.b.b ajE;
    c ajx;
    private Context g;
    private static boolean c = false;
    public static Comparator<com.baidu.cesium.b.a> ajF = new Comparator<com.baidu.cesium.b.a>() { // from class: com.baidu.cesium.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(com.baidu.cesium.b.a aVar, com.baidu.cesium.b.a aVar2) {
            long b = aVar.b() - aVar2.b();
            return b != 0 ? b > 0 ? -1 : 1 : aVar.a().compareTo(aVar2.a());
        }
    };

    /* loaded from: classes13.dex */
    public static class a {
        public static final String[] a = {ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "O", "0"};
        private String i;
        private String j;
        private String k;
        private long l;
        private String m;
        private int n = 1;

        public String b() {
            return this.i;
        }

        public String c() {
            return this.m;
        }

        public String d() {
            return this.j;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.n == aVar.n && this.i.equals(aVar.i) && this.j.equals(aVar.j) && this.k.equals(aVar.k)) {
                if (this.m == aVar.m) {
                    return true;
                }
                if (this.m != null && this.m.equals(aVar.m)) {
                    return true;
                }
            }
            return false;
        }

        public String f() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("dik", this.i);
                jSONObject.put("v270fk", this.j);
                jSONObject.put("cck", this.k);
                jSONObject.put("vsk", this.n);
                jSONObject.put("ctk", this.l);
                jSONObject.put("ek", this.m);
                return jSONObject.toString();
            } catch (JSONException e) {
                com.baidu.cesium.f.c.a(e);
                return null;
            }
        }

        public String g() {
            String str = this.j;
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.i).append("|").append(str);
            if (ExifInterface.GPS_MEASUREMENT_INTERRUPTED.equals(str)) {
                sb.append(this.k);
            }
            if (!TextUtils.isEmpty(this.m)) {
                sb.append(this.m);
            }
            return sb.toString().trim();
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.i, this.j, this.k, this.m, Integer.valueOf(this.n)});
        }

        public e sp() {
            e eVar = new e();
            eVar.d = this.i;
            StringBuilder sb = new StringBuilder();
            sb.append(this.j);
            if (ExifInterface.GPS_MEASUREMENT_INTERRUPTED.equals(this.j)) {
                sb.append(this.k);
            }
            if (!TextUtils.isEmpty(this.m)) {
                sb.append(this.m);
            }
            eVar.e = sb.toString().trim();
            return eVar;
        }
    }

    public g(Context context, com.baidu.cesium.e.a aVar, c cVar) {
        if (context == null) {
            throw new NullPointerException("context should not be null!!!");
        }
        this.g = context.getApplicationContext();
        this.ajB = aVar.sl().cZ("bohrium");
        this.ajB.a();
        this.ajx = cVar;
        a(aVar);
    }

    public static a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("dik", "");
            String optString2 = jSONObject.optString("cck", "");
            long optLong = jSONObject.optLong("ctk", 0L);
            int optInt = jSONObject.optInt("vsk", 1);
            String optString3 = jSONObject.optString("ek", "");
            String optString4 = jSONObject.optString("v270fk", ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            a aVar = new a();
            aVar.i = optString;
            aVar.k = optString2;
            aVar.l = optLong;
            aVar.n = optInt;
            aVar.m = optString3;
            aVar.j = optString4;
            return aVar;
        } catch (Exception e) {
            com.baidu.cesium.f.c.a(e);
            return null;
        }
    }

    private String a(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        return TextUtils.isEmpty(string) ? "" : string;
    }

    private String a(boolean z) {
        return this.ajB.a("libbh.so", z);
    }

    private void a(com.baidu.cesium.e.a aVar) {
        com.baidu.cesium.b.b bVar = new com.baidu.cesium.b.b(new com.baidu.cesium.a());
        a.C0098a c0098a = new a.C0098a();
        c0098a.a = this.g;
        c0098a.aiD = aVar;
        a.c cVar = new a.c();
        for (com.baidu.cesium.b.a aVar2 : bVar.a()) {
            aVar2.a(c0098a);
            aVar2.a(cVar);
        }
        this.ajE = bVar;
    }

    private static String c(String str) {
        try {
            return new com.baidu.cesium.f.a("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).a(new com.baidu.cesium.a.a().a(str.getBytes("UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static a k(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            String c2 = c(str);
            long currentTimeMillis = System.currentTimeMillis();
            a aVar = new a();
            aVar.i = str;
            aVar.k = c2;
            aVar.l = currentTimeMillis;
            aVar.n = 1;
            aVar.m = str3;
            aVar.j = str2;
            return aVar;
        } catch (Exception e) {
            com.baidu.cesium.f.c.a(e);
            return null;
        }
    }

    public a a() {
        if (new File(this.ajB.b(), "libbh.so").exists()) {
            return a(a(true));
        }
        return null;
    }

    public void a(a aVar) {
        a.d dVar = new a.d();
        for (com.baidu.cesium.b.a aVar2 : this.ajE.a()) {
            aVar2.a(dVar, aVar);
        }
    }

    public boolean a(a aVar, boolean z, boolean z2) {
        a a2;
        if (aVar == null || TextUtils.isEmpty(aVar.i)) {
            throw new NullPointerException("content should not be null");
        }
        if (!z2) {
            try {
                if (new File(this.ajB.b(), "libbh.so").exists() && (a2 = a(a(true))) != null) {
                    String g = a2.g();
                    if (!TextUtils.isEmpty(g) && g.equals(aVar.g())) {
                        return true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return this.ajB.c("libbh.so", aVar.f(), z);
    }

    public a b(e eVar) {
        boolean z = false;
        if (eVar == null) {
            throw new IllegalArgumentException("arg non-nullable is expected");
        }
        a aVar = new a();
        aVar.l = System.currentTimeMillis();
        aVar.n = 1;
        try {
            aVar.j = eVar.e.substring(0, 1);
            aVar.i = eVar.d;
            aVar.k = c(eVar.d);
            String[] strArr = a.a;
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = true;
                    break;
                } else if (strArr[i].equals(aVar.j)) {
                    break;
                } else {
                    i++;
                }
            }
            if (!z || eVar.e == null || eVar.e.length() < 2) {
                return aVar;
            }
            aVar.m = eVar.e.substring(1);
            return aVar;
        } catch (Exception e) {
            return null;
        }
    }

    public a b(String str) {
        String str2;
        String a2 = a(this.g);
        if (Build.VERSION.SDK_INT < 23) {
            String uuid = UUID.randomUUID().toString();
            if (c) {
                Log.d("CuidV270Manager", "uuid: " + uuid);
            }
            str2 = str + a2 + uuid;
        } else {
            str2 = "com.baidu" + a2;
        }
        String a3 = com.baidu.cesium.d.b.a(str2.getBytes(), true);
        a aVar = new a();
        aVar.l = System.currentTimeMillis();
        aVar.n = 1;
        aVar.i = a3;
        aVar.j = ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
        aVar.k = c(a3);
        aVar.m = null;
        return aVar;
    }

    public synchronized boolean b() {
        RandomAccessFile randomAccessFile;
        boolean z = false;
        synchronized (this) {
            File b = this.ajB.b(".lock");
            if (!b.exists()) {
                try {
                    b.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                randomAccessFile = new RandomAccessFile(b, "rw");
                int i = 0;
                while (true) {
                    if (i >= 100) {
                        break;
                    }
                    try {
                        this.ajC = randomAccessFile.getChannel().lock();
                        this.ajD = randomAccessFile;
                        z = true;
                        break;
                    } catch (OverlappingFileLockException e2) {
                        try {
                            Thread.sleep(100L);
                            i++;
                        } catch (Exception e3) {
                            e = e3;
                            com.baidu.cesium.f.c.a(e);
                            if (this.ajC == null) {
                                com.baidu.cesium.f.c.a(randomAccessFile);
                            }
                            return z;
                        }
                    }
                }
            } catch (Exception e4) {
                e = e4;
                randomAccessFile = null;
            }
        }
        return z;
    }

    public synchronized void c() {
        if (this.ajC != null) {
            try {
                this.ajC.release();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.ajC = null;
        }
        com.baidu.cesium.f.c.a(this.ajD);
        this.ajD = null;
    }

    public a d() {
        a.f fVar = new a.f();
        fVar.a = true;
        List<com.baidu.cesium.b.a> a2 = this.ajE.a();
        Collections.sort(a2, com.baidu.cesium.b.a.aiC);
        List<b> T = this.ajx.T(this.g);
        if (T != null) {
            for (b bVar : T) {
                if (!bVar.d && bVar.c) {
                    for (com.baidu.cesium.b.a aVar : a2) {
                        a.g a3 = aVar.a(bVar.a.packageName, fVar);
                        if (a3 != null && a3.a() && a3.a != null) {
                            return a3.a;
                        }
                    }
                    continue;
                }
            }
        }
        return null;
    }
}
