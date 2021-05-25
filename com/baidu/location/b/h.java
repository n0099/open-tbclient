package com.baidu.location.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.wifi.WifiInfo;
import android.os.Bundle;
import com.baidu.location.Jni;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.googlecode.mp4parser.boxes.ultraviolet.BaseLocationBox;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {

    /* renamed from: d  reason: collision with root package name */
    public static h f6492d;

    /* renamed from: c  reason: collision with root package name */
    public static Object f6491c = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static final String f6493e = com.baidu.location.e.k.j() + "/hst.db";

    /* renamed from: f  reason: collision with root package name */
    public SQLiteDatabase f6496f = null;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6497g = false;

    /* renamed from: a  reason: collision with root package name */
    public a f6494a = null;

    /* renamed from: b  reason: collision with root package name */
    public a f6495b = null;

    /* renamed from: h  reason: collision with root package name */
    public String f6498h = null;

    /* renamed from: i  reason: collision with root package name */
    public int f6499i = -2;

    /* loaded from: classes2.dex */
    public class a extends com.baidu.location.e.e {

        /* renamed from: b  reason: collision with root package name */
        public String f6501b = null;

        /* renamed from: c  reason: collision with root package name */
        public String f6502c = null;

        /* renamed from: d  reason: collision with root package name */
        public boolean f6503d = true;

        /* renamed from: e  reason: collision with root package name */
        public boolean f6504e = false;

        public a() {
            this.k = new HashMap();
        }

        @Override // com.baidu.location.e.e
        public void a() {
            this.f6708i = 1;
            this.f6707h = com.baidu.location.e.k.e();
            String encodeTp4 = Jni.encodeTp4(this.f6502c);
            this.f6502c = null;
            this.k.put(BaseLocationBox.TYPE, encodeTp4);
        }

        public void a(String str, String str2) {
            if (h.this.f6497g) {
                return;
            }
            h.this.f6497g = true;
            this.f6501b = str;
            this.f6502c = str2;
            ExecutorService c2 = v.a().c();
            if (c2 != null) {
                a(c2, com.baidu.location.e.k.f6724f);
            } else {
                b(com.baidu.location.e.k.f6724f);
            }
        }

        @Override // com.baidu.location.e.e
        public void a(boolean z) {
            String str;
            if (z && (str = this.j) != null) {
                try {
                    if (this.f6503d) {
                        JSONObject jSONObject = new JSONObject(str);
                        JSONObject jSONObject2 = jSONObject.has("content") ? jSONObject.getJSONObject("content") : null;
                        if (jSONObject2 != null && jSONObject2.has("imo")) {
                            Long valueOf = Long.valueOf(jSONObject2.getJSONObject("imo").getString(IAdRequestParam.MAC));
                            int i2 = jSONObject2.getJSONObject("imo").getInt("mv");
                            if (Jni.encode3(this.f6501b).longValue() == valueOf.longValue()) {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                                contentValues.put("hst", Integer.valueOf(i2));
                                try {
                                    SQLiteDatabase sQLiteDatabase = h.this.f6496f;
                                    if (sQLiteDatabase.update("hstdata", contentValues, "id = \"" + valueOf + "\"", null) <= 0) {
                                        contentValues.put("id", valueOf);
                                        h.this.f6496f.insert("hstdata", null, contentValues);
                                    }
                                } catch (Exception unused) {
                                }
                                Bundle bundle = new Bundle();
                                bundle.putByteArray(IAdRequestParam.MAC, this.f6501b.getBytes());
                                bundle.putInt("hotspot", i2);
                                h.this.a(bundle);
                            }
                        }
                    }
                } catch (Exception unused2) {
                }
            } else if (this.f6503d) {
                h.this.f();
            }
            Map<String, Object> map = this.k;
            if (map != null) {
                map.clear();
            }
            h.this.f6497g = false;
        }
    }

    public static h a() {
        h hVar;
        synchronized (f6491c) {
            if (f6492d == null) {
                f6492d = new h();
            }
            hVar = f6492d;
        }
        return hVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(boolean z) {
        String l;
        com.baidu.location.c.a f2 = com.baidu.location.c.b.a().f();
        com.baidu.location.c.h o = com.baidu.location.c.i.a().o();
        StringBuffer stringBuffer = new StringBuffer(1024);
        if (f2 != null && f2.b()) {
            stringBuffer.append(f2.g());
        }
        if (o == null || o.a() <= 1) {
            if (com.baidu.location.c.i.a().l() != null) {
                l = com.baidu.location.c.i.a().l();
            }
            if (z) {
                stringBuffer.append("&imo=1");
            }
            stringBuffer.append(com.baidu.location.e.b.a().a(false));
            stringBuffer.append(com.baidu.location.b.a.a().c());
            return stringBuffer.toString();
        }
        l = o.a(15);
        stringBuffer.append(l);
        if (z) {
        }
        stringBuffer.append(com.baidu.location.e.b.a().a(false));
        stringBuffer.append(com.baidu.location.b.a.a().c());
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bundle bundle) {
        com.baidu.location.b.a.a().a(bundle, 406);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Bundle bundle = new Bundle();
        bundle.putInt("hotspot", -1);
        a(bundle);
    }

    public void a(String str) {
        if (this.f6497g) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.has("content") ? jSONObject.getJSONObject("content") : null;
            if (jSONObject2 == null || !jSONObject2.has("imo")) {
                return;
            }
            Long valueOf = Long.valueOf(jSONObject2.getJSONObject("imo").getString(IAdRequestParam.MAC));
            int i2 = jSONObject2.getJSONObject("imo").getInt("mv");
            ContentValues contentValues = new ContentValues();
            contentValues.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
            contentValues.put("hst", Integer.valueOf(i2));
            SQLiteDatabase sQLiteDatabase = this.f6496f;
            if (sQLiteDatabase.update("hstdata", contentValues, "id = \"" + valueOf + "\"", null) <= 0) {
                contentValues.put("id", valueOf);
                this.f6496f.insert("hstdata", null, contentValues);
            }
        } catch (Exception unused) {
        }
    }

    public void b() {
        try {
            File file = new File(f6493e);
            if (!file.exists()) {
                file.createNewFile();
            }
            if (file.exists()) {
                SQLiteDatabase openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(file, (SQLiteDatabase.CursorFactory) null);
                this.f6496f = openOrCreateDatabase;
                openOrCreateDatabase.execSQL("CREATE TABLE IF NOT EXISTS hstdata(id Long PRIMARY KEY,hst INT,tt INT);");
                this.f6496f.setVersion(1);
            }
        } catch (Exception unused) {
            this.f6496f = null;
        }
    }

    public void c() {
        SQLiteDatabase sQLiteDatabase = this.f6496f;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.close();
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.f6496f = null;
                throw th;
            }
            this.f6496f = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0077, code lost:
        if (r3 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0079, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0085, code lost:
        if (r3 == null) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized int d() {
        WifiInfo k;
        int i2 = -3;
        if (this.f6497g) {
            return -3;
        }
        try {
            if (com.baidu.location.c.i.i() && this.f6496f != null && (k = com.baidu.location.c.i.a().k()) != null && k.getBSSID() != null) {
                String replace = k.getBSSID().replace(":", "");
                Long encode3 = Jni.encode3(replace);
                if (this.f6498h == null || !replace.equals(this.f6498h) || this.f6499i <= -2) {
                    Cursor cursor = null;
                    try {
                        SQLiteDatabase sQLiteDatabase = this.f6496f;
                        cursor = sQLiteDatabase.rawQuery("select * from hstdata where id = \"" + encode3 + "\";", null);
                        if (cursor == null || !cursor.moveToFirst()) {
                            i2 = -2;
                        } else {
                            i2 = cursor.getInt(1);
                            this.f6498h = replace;
                            this.f6499i = i2;
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
                    i2 = this.f6499i;
                }
            }
        } catch (Exception unused3) {
        }
        this.f6499i = i2;
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0089, code lost:
        if (r3 == null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e() {
        WifiInfo k;
        if (this.f6497g) {
            return;
        }
        try {
            if (!com.baidu.location.c.i.i() || this.f6496f == null || (k = com.baidu.location.c.i.a().k()) == null || k.getBSSID() == null) {
                f();
                return;
            }
            String replace = k.getBSSID().replace(":", "");
            Long encode3 = Jni.encode3(replace);
            boolean z = false;
            Cursor cursor = null;
            try {
                SQLiteDatabase sQLiteDatabase = this.f6496f;
                cursor = sQLiteDatabase.rawQuery("select * from hstdata where id = \"" + encode3 + "\";", null);
                if (cursor != null && cursor.moveToFirst()) {
                    int i2 = cursor.getInt(1);
                    if ((System.currentTimeMillis() / 1000) - cursor.getInt(2) <= 259200) {
                        Bundle bundle = new Bundle();
                        bundle.putByteArray(IAdRequestParam.MAC, replace.getBytes());
                        bundle.putInt("hotspot", i2);
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
                    if (this.f6494a == null) {
                        this.f6494a = new a();
                    }
                    if (this.f6494a != null) {
                        this.f6494a.a(replace, a(true));
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
