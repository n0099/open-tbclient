package com.baidu.location.a;

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
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {

    /* renamed from: d  reason: collision with root package name */
    public static h f6502d;

    /* renamed from: c  reason: collision with root package name */
    public static Object f6501c = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static final String f6503e = com.baidu.location.d.j.h() + "/hst.db";

    /* renamed from: f  reason: collision with root package name */
    public SQLiteDatabase f6506f = null;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6507g = false;

    /* renamed from: a  reason: collision with root package name */
    public a f6504a = null;

    /* renamed from: b  reason: collision with root package name */
    public a f6505b = null;

    /* renamed from: h  reason: collision with root package name */
    public String f6508h = null;
    public int i = -2;

    /* loaded from: classes2.dex */
    public class a extends com.baidu.location.d.e {

        /* renamed from: b  reason: collision with root package name */
        public String f6510b = null;

        /* renamed from: c  reason: collision with root package name */
        public String f6511c = null;

        /* renamed from: d  reason: collision with root package name */
        public boolean f6512d = true;

        /* renamed from: e  reason: collision with root package name */
        public boolean f6513e = false;

        public a() {
            this.k = new HashMap();
        }

        @Override // com.baidu.location.d.e
        public void a() {
            this.i = 1;
            this.f6705h = com.baidu.location.d.j.c();
            String encodeTp4 = Jni.encodeTp4(this.f6511c);
            this.f6511c = null;
            this.k.put(BaseLocationBox.TYPE, encodeTp4);
        }

        public void a(String str, String str2) {
            if (h.this.f6507g) {
                return;
            }
            h.this.f6507g = true;
            this.f6510b = str;
            this.f6511c = str2;
            b(com.baidu.location.d.j.f6719f);
        }

        @Override // com.baidu.location.d.e
        public void a(boolean z) {
            String str;
            if (z && (str = this.j) != null) {
                try {
                    if (this.f6512d) {
                        JSONObject jSONObject = new JSONObject(str);
                        JSONObject jSONObject2 = jSONObject.has("content") ? jSONObject.getJSONObject("content") : null;
                        if (jSONObject2 != null && jSONObject2.has("imo")) {
                            Long valueOf = Long.valueOf(jSONObject2.getJSONObject("imo").getString("mac"));
                            int i = jSONObject2.getJSONObject("imo").getInt("mv");
                            if (Jni.encode3(this.f6510b).longValue() == valueOf.longValue()) {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                                contentValues.put("hst", Integer.valueOf(i));
                                try {
                                    SQLiteDatabase sQLiteDatabase = h.this.f6506f;
                                    if (sQLiteDatabase.update("hstdata", contentValues, "id = \"" + valueOf + "\"", null) <= 0) {
                                        contentValues.put("id", valueOf);
                                        h.this.f6506f.insert("hstdata", null, contentValues);
                                    }
                                } catch (Exception unused) {
                                }
                                Bundle bundle = new Bundle();
                                bundle.putByteArray("mac", this.f6510b.getBytes());
                                bundle.putInt("hotspot", i);
                                h.this.a(bundle);
                            }
                        }
                    }
                } catch (Exception unused2) {
                }
            } else if (this.f6512d) {
                h.this.f();
            }
            Map<String, Object> map = this.k;
            if (map != null) {
                map.clear();
            }
            h.this.f6507g = false;
        }
    }

    public static h a() {
        h hVar;
        synchronized (f6501c) {
            if (f6502d == null) {
                f6502d = new h();
            }
            hVar = f6502d;
        }
        return hVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(boolean z) {
        String l;
        com.baidu.location.b.a f2 = com.baidu.location.b.b.a().f();
        com.baidu.location.b.h o = com.baidu.location.b.i.a().o();
        StringBuffer stringBuffer = new StringBuffer(1024);
        if (f2 != null && f2.b()) {
            stringBuffer.append(f2.g());
        }
        if (o == null || o.a() <= 1) {
            if (com.baidu.location.b.i.a().l() != null) {
                l = com.baidu.location.b.i.a().l();
            }
            if (z) {
                stringBuffer.append("&imo=1");
            }
            stringBuffer.append(com.baidu.location.d.b.a().a(false));
            stringBuffer.append(com.baidu.location.a.a.a().c());
            return stringBuffer.toString();
        }
        l = o.a(15);
        stringBuffer.append(l);
        if (z) {
        }
        stringBuffer.append(com.baidu.location.d.b.a().a(false));
        stringBuffer.append(com.baidu.location.a.a.a().c());
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bundle bundle) {
        com.baidu.location.a.a.a().a(bundle, 406);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Bundle bundle = new Bundle();
        bundle.putInt("hotspot", -1);
        a(bundle);
    }

    public void a(String str) {
        if (this.f6507g) {
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
            SQLiteDatabase sQLiteDatabase = this.f6506f;
            if (sQLiteDatabase.update("hstdata", contentValues, "id = \"" + valueOf + "\"", null) <= 0) {
                contentValues.put("id", valueOf);
                this.f6506f.insert("hstdata", null, contentValues);
            }
        } catch (Exception unused) {
        }
    }

    public void b() {
        try {
            File file = new File(f6503e);
            if (!file.exists()) {
                file.createNewFile();
            }
            if (file.exists()) {
                SQLiteDatabase openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(file, (SQLiteDatabase.CursorFactory) null);
                this.f6506f = openOrCreateDatabase;
                openOrCreateDatabase.execSQL("CREATE TABLE IF NOT EXISTS hstdata(id Long PRIMARY KEY,hst INT,tt INT);");
                this.f6506f.setVersion(1);
            }
        } catch (Exception unused) {
            this.f6506f = null;
        }
    }

    public void c() {
        SQLiteDatabase sQLiteDatabase = this.f6506f;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.close();
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.f6506f = null;
                throw th;
            }
            this.f6506f = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0076, code lost:
        if (r3 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0078, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0084, code lost:
        if (r3 == null) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized int d() {
        WifiInfo k;
        int i = -3;
        if (this.f6507g) {
            return -3;
        }
        try {
            if (com.baidu.location.b.i.i() && this.f6506f != null && (k = com.baidu.location.b.i.a().k()) != null && k.getBSSID() != null) {
                String replace = k.getBSSID().replace(":", "");
                Long encode3 = Jni.encode3(replace);
                if (this.f6508h == null || !replace.equals(this.f6508h) || this.i <= -2) {
                    Cursor cursor = null;
                    try {
                        SQLiteDatabase sQLiteDatabase = this.f6506f;
                        cursor = sQLiteDatabase.rawQuery("select * from hstdata where id = \"" + encode3 + "\";", null);
                        if (cursor == null || !cursor.moveToFirst()) {
                            i = -2;
                        } else {
                            i = cursor.getInt(1);
                            this.f6508h = replace;
                            this.i = i;
                        }
                    } catch (Exception unused) {
                    } catch (Throwable th) {
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception unused2) {
                            }
                        }
                        throw th;
                    }
                } else {
                    i = this.i;
                }
            }
        } catch (Exception unused3) {
        }
        this.i = i;
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0088, code lost:
        if (r3 == null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e() {
        WifiInfo k;
        if (this.f6507g) {
            return;
        }
        try {
            if (!com.baidu.location.b.i.i() || this.f6506f == null || (k = com.baidu.location.b.i.a().k()) == null || k.getBSSID() == null) {
                f();
                return;
            }
            String replace = k.getBSSID().replace(":", "");
            Long encode3 = Jni.encode3(replace);
            boolean z = false;
            Cursor cursor = null;
            try {
                SQLiteDatabase sQLiteDatabase = this.f6506f;
                cursor = sQLiteDatabase.rawQuery("select * from hstdata where id = \"" + encode3 + "\";", null);
                if (cursor != null && cursor.moveToFirst()) {
                    int i = cursor.getInt(1);
                    if ((System.currentTimeMillis() / 1000) - cursor.getInt(2) <= 259200) {
                        Bundle bundle = new Bundle();
                        bundle.putByteArray("mac", replace.getBytes());
                        bundle.putInt("hotspot", i);
                        a(bundle);
                    }
                }
                z = true;
            } catch (Exception unused) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception unused2) {
                    }
                }
                if (z) {
                    if (this.f6504a == null) {
                        this.f6504a = new a();
                    }
                    if (this.f6504a != null) {
                        this.f6504a.a(replace, a(true));
                    }
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
        } catch (Exception unused4) {
        }
    }
}
