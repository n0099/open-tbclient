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
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class g {
    private static boolean b = false;
    c anP;
    private a.C0102a anT;
    private volatile FileLock anU;
    private volatile RandomAccessFile anV;
    private com.baidu.cesium.b.b anW;
    private Context f;

    /* loaded from: classes14.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final String[] f1314a = {ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "O", "0"};
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

        public e uC() {
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
        this.f = context.getApplicationContext();
        this.anT = aVar.uy().dt("bohrium");
        this.anT.a();
        this.anP = cVar;
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
        return this.anT.a("libbh.so", z);
    }

    private void a(com.baidu.cesium.e.a aVar) {
        com.baidu.cesium.b.b bVar = new com.baidu.cesium.b.b(new com.baidu.cesium.a());
        a.C0099a c0099a = new a.C0099a();
        c0099a.f1296a = this.f;
        c0099a.anj = aVar;
        a.c cVar = new a.c();
        for (com.baidu.cesium.b.a aVar2 : bVar.a()) {
            aVar2.a(c0099a);
            aVar2.a(cVar);
        }
        this.anW = bVar;
    }

    private static String c(String str) {
        try {
            return new com.baidu.cesium.f.a("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).a(new com.baidu.cesium.a.a().a(str.getBytes("UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static a l(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            String c = c(str);
            long currentTimeMillis = System.currentTimeMillis();
            a aVar = new a();
            aVar.i = str;
            aVar.k = c;
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

    public a S(String str, String str2) {
        com.baidu.cesium.b.a ds = this.anW.ds(str2);
        a.f fVar = new a.f();
        fVar.f1297a = true;
        a.g a2 = ds.a(str, fVar);
        if (a2 == null || !a2.a()) {
            return null;
        }
        return a2.f1298a;
    }

    public void a(a aVar) {
        a.d dVar = new a.d();
        for (com.baidu.cesium.b.a aVar2 : this.anW.a()) {
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
                if (new File(this.anT.b(), "libbh.so").exists() && (a2 = a(a(true))) != null) {
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
        return this.anT.c("libbh.so", aVar.f(), z);
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
            String[] strArr = a.f1314a;
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
        String a2 = a(this.f);
        if (Build.VERSION.SDK_INT < 23) {
            String uuid = UUID.randomUUID().toString();
            if (b) {
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
            File b2 = this.anT.b(".lock");
            if (!b2.exists()) {
                try {
                    b2.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                randomAccessFile = new RandomAccessFile(b2, "rw");
                int i = 0;
                while (true) {
                    if (i >= 100) {
                        break;
                    }
                    try {
                        this.anU = randomAccessFile.getChannel().lock();
                        this.anV = randomAccessFile;
                        z = true;
                        break;
                    } catch (OverlappingFileLockException e2) {
                        try {
                            Thread.sleep(100L);
                            i++;
                        } catch (Exception e3) {
                            e = e3;
                            com.baidu.cesium.f.c.a(e);
                            if (this.anU == null) {
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
        if (this.anU != null) {
            try {
                this.anU.release();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.anU = null;
        }
        com.baidu.cesium.f.c.a(this.anV);
        this.anV = null;
    }

    public a d() {
        a.f fVar = new a.f();
        fVar.f1297a = true;
        List<com.baidu.cesium.b.a> a2 = this.anW.a();
        Collections.sort(a2, com.baidu.cesium.b.a.ani);
        List<b> O = this.anP.O(this.f);
        if (O != null) {
            for (b bVar : O) {
                if (!bVar.d && bVar.c) {
                    for (com.baidu.cesium.b.a aVar : a2) {
                        a.g a3 = aVar.a(bVar.adT.packageName, fVar);
                        if (a3 != null && a3.a() && a3.f1298a != null) {
                            return a3.f1298a;
                        }
                    }
                    continue;
                }
            }
        }
        return null;
    }

    public a uw() {
        if (new File(this.anT.b(), "libbh.so").exists()) {
            return a(a(true));
        }
        return null;
    }
}
