package com.baidu.location.e;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.location.Jni;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k {
    private static final String d = String.format(Locale.US, "DELETE FROM LOG WHERE timestamp NOT IN (SELECT timestamp FROM LOG ORDER BY timestamp DESC LIMIT %d);", 3000);
    private static final String e = String.format(Locale.US, "SELECT * FROM LOG ORDER BY timestamp DESC LIMIT %d;", 3);
    private final SQLiteDatabase Iv;
    private String a = null;
    private final a IC = new a(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends com.baidu.location.h.f {
        private k IE;
        private int b;
        private long c;
        private String d = null;
        private boolean e = false;
        private boolean f = false;

        a(k kVar) {
            this.IE = kVar;
            this.Jx = new HashMap();
            this.b = 0;
            this.c = -1L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            if (this.e) {
                return;
            }
            this.d = this.IE.b();
            if (this.c != -1 && this.c + 86400000 <= System.currentTimeMillis()) {
                this.b = 0;
                this.c = -1L;
            }
            if (this.d == null || this.b >= 2) {
                return;
            }
            this.e = true;
            e();
        }

        @Override // com.baidu.location.h.f
        public void a() {
            this.Jx.clear();
            this.Jx.put("qt", "ofbh");
            this.Jx.put("req", this.d);
            this.h = d.a;
        }

        @Override // com.baidu.location.h.f
        public void a(boolean z) {
            this.f = false;
            if (z && this.j != null) {
                try {
                    JSONObject jSONObject = new JSONObject(this.j);
                    if (jSONObject != null && jSONObject.has("error") && jSONObject.getInt("error") == 161) {
                        this.f = true;
                    }
                } catch (Exception e) {
                }
            }
            this.e = false;
            if (!this.f) {
                this.b++;
                this.c = System.currentTimeMillis();
            }
            new l(this).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(SQLiteDatabase sQLiteDatabase) {
        this.Iv = sQLiteDatabase;
        if (this.Iv == null || !this.Iv.isOpen()) {
            return;
        }
        try {
            this.Iv.execSQL("CREATE TABLE IF NOT EXISTS LOG(timestamp LONG PRIMARY KEY, log VARCHAR(4000))");
        } catch (Exception e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z && this.a != null) {
            String format = String.format("DELETE FROM LOG WHERE timestamp in (%s);", this.a);
            try {
                if (this.a.length() > 0) {
                    this.Iv.execSQL(format);
                }
            } catch (Exception e2) {
            }
        }
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b() {
        Cursor cursor;
        Throwable th;
        String str = null;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        try {
            cursor = this.Iv.rawQuery(e, null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() > 0) {
                        StringBuffer stringBuffer = new StringBuffer();
                        cursor.moveToFirst();
                        while (!cursor.isAfterLast()) {
                            jSONArray.put(cursor.getString(1));
                            if (stringBuffer.length() != 0) {
                                stringBuffer.append(",");
                            }
                            stringBuffer.append(cursor.getLong(0));
                            cursor.moveToNext();
                        }
                        try {
                            jSONObject.put("ofloc", jSONArray);
                            str = jSONObject.toString();
                        } catch (JSONException e2) {
                        }
                        this.a = stringBuffer.toString();
                    }
                } catch (Exception e3) {
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e4) {
                        }
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e5) {
                        }
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e6) {
                }
            }
        } catch (Exception e7) {
            cursor = null;
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.IC.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        try {
            this.Iv.execSQL(String.format(Locale.US, "INSERT OR IGNORE INTO LOG VALUES (%d,\"%s\");", Long.valueOf(System.currentTimeMillis()), Jni.encodeOfflineLocationUpdateRequest(str)));
            this.Iv.execSQL(d);
        } catch (Exception e2) {
        }
    }
}
