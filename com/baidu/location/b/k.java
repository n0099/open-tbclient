package com.baidu.location.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.wifi.WifiInfo;
import android.os.Bundle;
import com.baidu.location.Jni;
import com.googlecode.mp4parser.boxes.ultraviolet.BaseLocationBox;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;
/* loaded from: classes26.dex */
public class k {
    private static Object c = new Object();
    private static k d = null;
    private static final String e = com.baidu.location.e.l.j() + "/hst.db";
    private SQLiteDatabase f = null;
    private boolean g = false;

    /* renamed from: a  reason: collision with root package name */
    a f1891a = null;
    a b = null;
    private String h = null;
    private int i = -2;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public class a extends com.baidu.location.e.f {
        private String b = null;
        private String c = null;
        private boolean d = true;
        private boolean e = false;

        a() {
            this.k = new HashMap();
        }

        @Override // com.baidu.location.e.f
        public void a() {
            this.i = 1;
            this.h = com.baidu.location.e.l.e();
            String encodeTp4 = Jni.encodeTp4(this.c);
            this.c = null;
            this.k.put(BaseLocationBox.TYPE, encodeTp4);
        }

        public void a(String str, String str2) {
            if (k.this.g) {
                return;
            }
            k.this.g = true;
            this.b = str;
            this.c = str2;
            ExecutorService c = z.a().c();
            if (c != null) {
                a(c, com.baidu.location.e.l.f);
            } else {
                b(com.baidu.location.e.l.f);
            }
        }

        @Override // com.baidu.location.e.f
        public void a(boolean z) {
            if (z && this.j != null) {
                try {
                    String str = this.j;
                    if (this.d) {
                        JSONObject jSONObject = new JSONObject(str);
                        JSONObject jSONObject2 = jSONObject.has("content") ? jSONObject.getJSONObject("content") : null;
                        if (jSONObject2 != null && jSONObject2.has("imo")) {
                            Long valueOf = Long.valueOf(jSONObject2.getJSONObject("imo").getString("mac"));
                            int i = jSONObject2.getJSONObject("imo").getInt("mv");
                            if (Jni.encode3(this.b).longValue() == valueOf.longValue()) {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                                contentValues.put("hst", Integer.valueOf(i));
                                try {
                                    if (k.this.f.update("hstdata", contentValues, "id = \"" + valueOf + "\"", null) <= 0) {
                                        contentValues.put("id", valueOf);
                                        k.this.f.insert("hstdata", null, contentValues);
                                    }
                                } catch (Exception e) {
                                }
                                Bundle bundle = new Bundle();
                                bundle.putByteArray("mac", this.b.getBytes());
                                bundle.putInt("hotspot", i);
                                k.this.a(bundle);
                            }
                        }
                    }
                } catch (Exception e2) {
                }
            } else if (this.d) {
                k.this.f();
            }
            if (this.k != null) {
                this.k.clear();
            }
            k.this.g = false;
        }
    }

    public static k a() {
        k kVar;
        synchronized (c) {
            if (d == null) {
                d = new k();
            }
            kVar = d;
        }
        return kVar;
    }

    private String a(boolean z) {
        com.baidu.location.c.a f = com.baidu.location.c.b.a().f();
        com.baidu.location.c.h o = com.baidu.location.c.i.a().o();
        StringBuffer stringBuffer = new StringBuffer(1024);
        if (f != null && f.b()) {
            stringBuffer.append(f.h());
        }
        if (o != null && o.a() > 1) {
            stringBuffer.append(o.a(15));
        } else if (com.baidu.location.c.i.a().l() != null) {
            stringBuffer.append(com.baidu.location.c.i.a().l());
        }
        if (z) {
            stringBuffer.append("&imo=1");
        }
        stringBuffer.append(com.baidu.location.c.f.a().m());
        stringBuffer.append(com.baidu.location.e.b.a().a(false));
        stringBuffer.append(b.a().c());
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bundle bundle) {
        b.a().a(bundle, 406);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Bundle bundle = new Bundle();
        bundle.putInt("hotspot", -1);
        a(bundle);
    }

    public void a(String str) {
        if (this.g) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.has("content") ? jSONObject.getJSONObject("content") : null;
            if (jSONObject2 == null || !jSONObject2.has("imo")) {
                return;
            }
            Long valueOf = Long.valueOf(jSONObject2.getJSONObject("imo").getString("mac"));
            int i = jSONObject2.getJSONObject("imo").getInt("mv");
            ContentValues contentValues = new ContentValues();
            contentValues.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
            contentValues.put("hst", Integer.valueOf(i));
            try {
                if (this.f.update("hstdata", contentValues, "id = \"" + valueOf + "\"", null) <= 0) {
                    contentValues.put("id", valueOf);
                    this.f.insert("hstdata", null, contentValues);
                }
            } catch (Exception e2) {
            }
        } catch (Exception e3) {
        }
    }

    public void b() {
        try {
            File file = new File(e);
            if (!file.exists()) {
                file.createNewFile();
            }
            if (file.exists()) {
                this.f = SQLiteDatabase.openOrCreateDatabase(file, (SQLiteDatabase.CursorFactory) null);
                this.f.execSQL("CREATE TABLE IF NOT EXISTS hstdata(id Long PRIMARY KEY,hst INT,tt INT);");
                this.f.setVersion(1);
            }
        } catch (Exception e2) {
            this.f = null;
        }
    }

    public void c() {
        if (this.f != null) {
            try {
                this.f.close();
            } catch (Exception e2) {
            } finally {
                this.f = null;
            }
        }
    }

    public synchronized int d() {
        int i;
        WifiInfo k;
        Cursor cursor = null;
        synchronized (this) {
            i = -3;
            if (!this.g) {
                try {
                    if (com.baidu.location.c.i.a().i() && this.f != null && (k = com.baidu.location.c.i.a().k()) != null && k.getBSSID() != null) {
                        String replace = k.getBSSID().replace(":", "");
                        Long encode3 = Jni.encode3(replace);
                        if (this.h == null || !replace.equals(this.h) || this.i <= -2) {
                            try {
                                cursor = this.f.rawQuery("select * from hstdata where id = \"" + encode3 + "\";", null);
                                if (cursor == null || !cursor.moveToFirst()) {
                                    i = -2;
                                } else {
                                    i = cursor.getInt(1);
                                    this.h = replace;
                                    this.i = i;
                                }
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e2) {
                                    }
                                }
                            } catch (Exception e3) {
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e4) {
                                    }
                                }
                            } catch (Throwable th) {
                                int i2 = i;
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e5) {
                                    }
                                }
                                try {
                                    throw th;
                                } catch (Exception e6) {
                                    i = i2;
                                }
                            }
                        } else {
                            i = this.i;
                        }
                    }
                } catch (Exception e7) {
                }
                this.i = i;
            }
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0084 A[Catch: Exception -> 0x009f, TRY_ENTER, TryCatch #7 {Exception -> 0x009f, blocks: (B:5:0x0007, B:7:0x0011, B:9:0x0015, B:11:0x001f, B:13:0x0025, B:26:0x0084, B:28:0x0088, B:29:0x008f, B:31:0x0093, B:49:0x00cf, B:50:0x00d4, B:15:0x0038, B:17:0x005c, B:19:0x0062, B:35:0x00a2), top: B:66:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x007f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e() {
        Cursor cursor;
        Cursor rawQuery;
        boolean z = true;
        if (this.g) {
            return;
        }
        try {
            if (!com.baidu.location.c.i.a().i() || this.f == null) {
                f();
                return;
            }
            WifiInfo k = com.baidu.location.c.i.a().k();
            if (k == null || k.getBSSID() == null) {
                f();
                return;
            }
            String replace = k.getBSSID().replace(":", "");
            boolean z2 = false;
            try {
                rawQuery = this.f.rawQuery("select * from hstdata where id = \"" + Jni.encode3(replace) + "\";", null);
            } catch (Exception e2) {
                cursor = null;
            }
            if (rawQuery != null) {
                try {
                } catch (Exception e3) {
                    cursor = rawQuery;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e4) {
                        }
                    }
                    if (z2) {
                    }
                }
                if (rawQuery.moveToFirst()) {
                    int i = rawQuery.getInt(1);
                    if ((System.currentTimeMillis() / 1000) - rawQuery.getInt(2) <= 259200) {
                        Bundle bundle = new Bundle();
                        bundle.putByteArray("mac", replace.getBytes());
                        bundle.putInt("hotspot", i);
                        a(bundle);
                        z = false;
                    }
                    z2 = z;
                    if (rawQuery != null) {
                        try {
                            rawQuery.close();
                        } catch (Exception e5) {
                        }
                    }
                    if (z2) {
                        if (this.f1891a == null) {
                            this.f1891a = new a();
                        }
                        if (this.f1891a != null) {
                            this.f1891a.a(replace, a(true));
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            z2 = true;
            if (rawQuery != null) {
            }
            if (z2) {
            }
        } catch (Exception e6) {
        }
    }
}
