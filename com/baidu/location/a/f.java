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
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f {
    private static Object c = new Object();
    private static f adA = null;
    private static final String e = com.baidu.location.d.g.h() + "/hst.db";
    private SQLiteDatabase adB = null;
    private boolean g = false;
    a adC = null;
    a adD = null;
    private String h = null;
    private int i = -2;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a extends com.baidu.location.d.e {
        private String b = null;
        private String c = null;
        private boolean d = true;
        private boolean e = false;

        a() {
            this.k = new HashMap();
        }

        @Override // com.baidu.location.d.e
        public void a() {
            this.i = 1;
            this.h = com.baidu.location.d.g.c();
            String encodeTp4 = Jni.encodeTp4(this.c);
            this.c = null;
            this.k.put(BaseLocationBox.TYPE, encodeTp4);
        }

        public void a(String str, String str2) {
            if (f.this.g) {
                return;
            }
            f.this.g = true;
            this.b = str;
            this.c = str2;
            b(com.baidu.location.d.g.f);
        }

        @Override // com.baidu.location.d.e
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
                                    if (f.this.adB.update("hstdata", contentValues, "id = \"" + valueOf + "\"", null) <= 0) {
                                        contentValues.put("id", valueOf);
                                        f.this.adB.insert("hstdata", null, contentValues);
                                    }
                                } catch (Exception e) {
                                }
                                Bundle bundle = new Bundle();
                                bundle.putByteArray("mac", this.b.getBytes());
                                bundle.putInt("hotspot", i);
                                f.this.a(bundle);
                            }
                        }
                    }
                } catch (Exception e2) {
                }
            } else if (this.d) {
                f.this.f();
            }
            if (this.k != null) {
                this.k.clear();
            }
            f.this.g = false;
        }
    }

    private String a(boolean z) {
        com.baidu.location.b.a tB = com.baidu.location.b.b.tA().tB();
        com.baidu.location.b.e tK = com.baidu.location.b.f.tH().tK();
        StringBuffer stringBuffer = new StringBuffer(1024);
        if (tB != null && tB.b()) {
            stringBuffer.append(tB.g());
        }
        if (tK != null && tK.a() > 1) {
            stringBuffer.append(tK.a(15));
        } else if (com.baidu.location.b.f.tH().l() != null) {
            stringBuffer.append(com.baidu.location.b.f.tH().l());
        }
        if (z) {
            stringBuffer.append("&imo=1");
        }
        stringBuffer.append(com.baidu.location.d.b.tM().a(false));
        stringBuffer.append(com.baidu.location.a.a.ti().c());
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bundle bundle) {
        com.baidu.location.a.a.ti().a(bundle, 406);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Bundle bundle = new Bundle();
        bundle.putInt("hotspot", -1);
        a(bundle);
    }

    public static f tn() {
        f fVar;
        synchronized (c) {
            if (adA == null) {
                adA = new f();
            }
            fVar = adA;
        }
        return fVar;
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
                if (this.adB.update("hstdata", contentValues, "id = \"" + valueOf + "\"", null) <= 0) {
                    contentValues.put("id", valueOf);
                    this.adB.insert("hstdata", null, contentValues);
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
                this.adB = SQLiteDatabase.openOrCreateDatabase(file, (SQLiteDatabase.CursorFactory) null);
                this.adB.execSQL("CREATE TABLE IF NOT EXISTS hstdata(id Long PRIMARY KEY,hst INT,tt INT);");
                this.adB.setVersion(1);
            }
        } catch (Exception e2) {
            this.adB = null;
        }
    }

    public void c() {
        if (this.adB != null) {
            try {
                this.adB.close();
            } catch (Exception e2) {
            } finally {
                this.adB = null;
            }
        }
    }

    public int d() {
        WifiInfo tI;
        Cursor cursor = null;
        int i = -3;
        if (!this.g) {
            try {
                if (com.baidu.location.b.f.i() && this.adB != null && (tI = com.baidu.location.b.f.tH().tI()) != null && tI.getBSSID() != null) {
                    String replace = tI.getBSSID().replace(":", "");
                    Long encode3 = Jni.encode3(replace);
                    if (this.h == null || !replace.equals(this.h) || this.i <= -2) {
                        try {
                            cursor = this.adB.rawQuery("select * from hstdata where id = \"" + encode3 + "\";", null);
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
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0080 A[Catch: Exception -> 0x009b, TRY_ENTER, TryCatch #1 {Exception -> 0x009b, blocks: (B:5:0x0007, B:7:0x000d, B:9:0x0011, B:11:0x001b, B:13:0x0021, B:26:0x0080, B:28:0x0084, B:29:0x008b, B:31:0x008f, B:49:0x00cb, B:50:0x00d0, B:15:0x0034, B:17:0x0058, B:19:0x005e, B:35:0x009e), top: B:58:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x007b A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
            if (!com.baidu.location.b.f.i() || this.adB == null) {
                f();
                return;
            }
            WifiInfo tI = com.baidu.location.b.f.tH().tI();
            if (tI == null || tI.getBSSID() == null) {
                f();
                return;
            }
            String replace = tI.getBSSID().replace(":", "");
            boolean z2 = false;
            try {
                rawQuery = this.adB.rawQuery("select * from hstdata where id = \"" + Jni.encode3(replace) + "\";", null);
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
                        if (this.adC == null) {
                            this.adC = new a();
                        }
                        if (this.adC != null) {
                            this.adC.a(replace, a(true));
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
