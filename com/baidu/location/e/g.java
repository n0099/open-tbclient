package com.baidu.location.e;

import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.location.e.e;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes.dex */
class g extends Thread {
    final /* synthetic */ e.c KH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e.c cVar) {
        this.KH = cVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, IGET, INVOKE] complete} */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0331 A[Catch: Exception -> 0x0249, all -> 0x02bb, TryCatch #3 {Exception -> 0x0249, blocks: (B:24:0x0092, B:26:0x00a5, B:28:0x00ad, B:30:0x00bb, B:32:0x00c8, B:34:0x00d0, B:36:0x00e9, B:38:0x00f1, B:40:0x0122, B:42:0x012a, B:43:0x0149, B:45:0x014f, B:48:0x016a, B:52:0x017c, B:55:0x01bc, B:58:0x01e4, B:61:0x020c, B:84:0x02b6, B:101:0x0321, B:102:0x0329, B:68:0x0242, B:104:0x0331, B:106:0x0350, B:108:0x036f, B:110:0x038e, B:112:0x0396, B:113:0x03b5, B:115:0x03bb, B:118:0x03d6, B:122:0x03e8, B:125:0x042c, B:128:0x0454, B:130:0x047a, B:133:0x04a6, B:136:0x04b0, B:137:0x04bd, B:132:0x049d, B:139:0x04c5, B:141:0x04e4, B:143:0x0503, B:144:0x0520, B:146:0x05c8, B:148:0x05d0, B:150:0x05d8, B:151:0x05df), top: B:181:0x0092, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0350 A[Catch: Exception -> 0x0249, all -> 0x02bb, TryCatch #3 {Exception -> 0x0249, blocks: (B:24:0x0092, B:26:0x00a5, B:28:0x00ad, B:30:0x00bb, B:32:0x00c8, B:34:0x00d0, B:36:0x00e9, B:38:0x00f1, B:40:0x0122, B:42:0x012a, B:43:0x0149, B:45:0x014f, B:48:0x016a, B:52:0x017c, B:55:0x01bc, B:58:0x01e4, B:61:0x020c, B:84:0x02b6, B:101:0x0321, B:102:0x0329, B:68:0x0242, B:104:0x0331, B:106:0x0350, B:108:0x036f, B:110:0x038e, B:112:0x0396, B:113:0x03b5, B:115:0x03bb, B:118:0x03d6, B:122:0x03e8, B:125:0x042c, B:128:0x0454, B:130:0x047a, B:133:0x04a6, B:136:0x04b0, B:137:0x04bd, B:132:0x049d, B:139:0x04c5, B:141:0x04e4, B:143:0x0503, B:144:0x0520, B:146:0x05c8, B:148:0x05d0, B:150:0x05d8, B:151:0x05df), top: B:181:0x0092, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x036f A[Catch: Exception -> 0x0249, all -> 0x02bb, TryCatch #3 {Exception -> 0x0249, blocks: (B:24:0x0092, B:26:0x00a5, B:28:0x00ad, B:30:0x00bb, B:32:0x00c8, B:34:0x00d0, B:36:0x00e9, B:38:0x00f1, B:40:0x0122, B:42:0x012a, B:43:0x0149, B:45:0x014f, B:48:0x016a, B:52:0x017c, B:55:0x01bc, B:58:0x01e4, B:61:0x020c, B:84:0x02b6, B:101:0x0321, B:102:0x0329, B:68:0x0242, B:104:0x0331, B:106:0x0350, B:108:0x036f, B:110:0x038e, B:112:0x0396, B:113:0x03b5, B:115:0x03bb, B:118:0x03d6, B:122:0x03e8, B:125:0x042c, B:128:0x0454, B:130:0x047a, B:133:0x04a6, B:136:0x04b0, B:137:0x04bd, B:132:0x049d, B:139:0x04c5, B:141:0x04e4, B:143:0x0503, B:144:0x0520, B:146:0x05c8, B:148:0x05d0, B:150:0x05d8, B:151:0x05df), top: B:181:0x0092, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x03bb A[Catch: Exception -> 0x0249, all -> 0x02bb, TryCatch #3 {Exception -> 0x0249, blocks: (B:24:0x0092, B:26:0x00a5, B:28:0x00ad, B:30:0x00bb, B:32:0x00c8, B:34:0x00d0, B:36:0x00e9, B:38:0x00f1, B:40:0x0122, B:42:0x012a, B:43:0x0149, B:45:0x014f, B:48:0x016a, B:52:0x017c, B:55:0x01bc, B:58:0x01e4, B:61:0x020c, B:84:0x02b6, B:101:0x0321, B:102:0x0329, B:68:0x0242, B:104:0x0331, B:106:0x0350, B:108:0x036f, B:110:0x038e, B:112:0x0396, B:113:0x03b5, B:115:0x03bb, B:118:0x03d6, B:122:0x03e8, B:125:0x042c, B:128:0x0454, B:130:0x047a, B:133:0x04a6, B:136:0x04b0, B:137:0x04bd, B:132:0x049d, B:139:0x04c5, B:141:0x04e4, B:143:0x0503, B:144:0x0520, B:146:0x05c8, B:148:0x05d0, B:150:0x05d8, B:151:0x05df), top: B:181:0x0092, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x04c5 A[Catch: Exception -> 0x0249, all -> 0x02bb, TryCatch #3 {Exception -> 0x0249, blocks: (B:24:0x0092, B:26:0x00a5, B:28:0x00ad, B:30:0x00bb, B:32:0x00c8, B:34:0x00d0, B:36:0x00e9, B:38:0x00f1, B:40:0x0122, B:42:0x012a, B:43:0x0149, B:45:0x014f, B:48:0x016a, B:52:0x017c, B:55:0x01bc, B:58:0x01e4, B:61:0x020c, B:84:0x02b6, B:101:0x0321, B:102:0x0329, B:68:0x0242, B:104:0x0331, B:106:0x0350, B:108:0x036f, B:110:0x038e, B:112:0x0396, B:113:0x03b5, B:115:0x03bb, B:118:0x03d6, B:122:0x03e8, B:125:0x042c, B:128:0x0454, B:130:0x047a, B:133:0x04a6, B:136:0x04b0, B:137:0x04bd, B:132:0x049d, B:139:0x04c5, B:141:0x04e4, B:143:0x0503, B:144:0x0520, B:146:0x05c8, B:148:0x05d0, B:150:0x05d8, B:151:0x05df), top: B:181:0x0092, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x04e4 A[Catch: Exception -> 0x0249, all -> 0x02bb, TryCatch #3 {Exception -> 0x0249, blocks: (B:24:0x0092, B:26:0x00a5, B:28:0x00ad, B:30:0x00bb, B:32:0x00c8, B:34:0x00d0, B:36:0x00e9, B:38:0x00f1, B:40:0x0122, B:42:0x012a, B:43:0x0149, B:45:0x014f, B:48:0x016a, B:52:0x017c, B:55:0x01bc, B:58:0x01e4, B:61:0x020c, B:84:0x02b6, B:101:0x0321, B:102:0x0329, B:68:0x0242, B:104:0x0331, B:106:0x0350, B:108:0x036f, B:110:0x038e, B:112:0x0396, B:113:0x03b5, B:115:0x03bb, B:118:0x03d6, B:122:0x03e8, B:125:0x042c, B:128:0x0454, B:130:0x047a, B:133:0x04a6, B:136:0x04b0, B:137:0x04bd, B:132:0x049d, B:139:0x04c5, B:141:0x04e4, B:143:0x0503, B:144:0x0520, B:146:0x05c8, B:148:0x05d0, B:150:0x05d8, B:151:0x05df), top: B:181:0x0092, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0503 A[Catch: Exception -> 0x0249, all -> 0x02bb, TryCatch #3 {Exception -> 0x0249, blocks: (B:24:0x0092, B:26:0x00a5, B:28:0x00ad, B:30:0x00bb, B:32:0x00c8, B:34:0x00d0, B:36:0x00e9, B:38:0x00f1, B:40:0x0122, B:42:0x012a, B:43:0x0149, B:45:0x014f, B:48:0x016a, B:52:0x017c, B:55:0x01bc, B:58:0x01e4, B:61:0x020c, B:84:0x02b6, B:101:0x0321, B:102:0x0329, B:68:0x0242, B:104:0x0331, B:106:0x0350, B:108:0x036f, B:110:0x038e, B:112:0x0396, B:113:0x03b5, B:115:0x03bb, B:118:0x03d6, B:122:0x03e8, B:125:0x042c, B:128:0x0454, B:130:0x047a, B:133:0x04a6, B:136:0x04b0, B:137:0x04bd, B:132:0x049d, B:139:0x04c5, B:141:0x04e4, B:143:0x0503, B:144:0x0520, B:146:0x05c8, B:148:0x05d0, B:150:0x05d8, B:151:0x05df), top: B:181:0x0092, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x014f A[Catch: Exception -> 0x0249, all -> 0x02bb, TryCatch #3 {Exception -> 0x0249, blocks: (B:24:0x0092, B:26:0x00a5, B:28:0x00ad, B:30:0x00bb, B:32:0x00c8, B:34:0x00d0, B:36:0x00e9, B:38:0x00f1, B:40:0x0122, B:42:0x012a, B:43:0x0149, B:45:0x014f, B:48:0x016a, B:52:0x017c, B:55:0x01bc, B:58:0x01e4, B:61:0x020c, B:84:0x02b6, B:101:0x0321, B:102:0x0329, B:68:0x0242, B:104:0x0331, B:106:0x0350, B:108:0x036f, B:110:0x038e, B:112:0x0396, B:113:0x03b5, B:115:0x03bb, B:118:0x03d6, B:122:0x03e8, B:125:0x042c, B:128:0x0454, B:130:0x047a, B:133:0x04a6, B:136:0x04b0, B:137:0x04bd, B:132:0x049d, B:139:0x04c5, B:141:0x04e4, B:143:0x0503, B:144:0x0520, B:146:0x05c8, B:148:0x05d0, B:150:0x05d8, B:151:0x05df), top: B:181:0x0092, outer: #4 }] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Exception e;
        Iterator<String> keys;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z;
        Iterator<String> keys2;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z2;
        e eVar;
        e eVar2;
        super.run();
        if (e.this.Kp == null || e.this.Kq == null || !e.this.Kp.isOpen() || !e.this.Kq.isOpen()) {
            this.KH.f = false;
            return;
        }
        JSONObject jSONObject3 = null;
        try {
            if (this.KH.j != null) {
                jSONObject = new JSONObject(this.KH.j);
                try {
                    jSONObject2 = jSONObject.has("model") ? jSONObject.getJSONObject("model") : null;
                    try {
                        if (jSONObject.has("rgc")) {
                            jSONObject3 = jSONObject.getJSONObject("rgc");
                        }
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        e.this.Kp.beginTransaction();
                        e.this.Kq.beginTransaction();
                        if (jSONObject3 != null) {
                        }
                        if (jSONObject != null) {
                            this.KH.KE = System.currentTimeMillis();
                        }
                        if (jSONObject != null) {
                            String[] split = jSONObject.getString("bdlist").split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                            eVar2 = this.KH.KC;
                            eVar2.a(split);
                        }
                        if (jSONObject != null) {
                            eVar = this.KH.KC;
                            eVar.a(jSONObject.getJSONObject("loadurl").getString("host"), jSONObject.getJSONObject("loadurl").getString("module"), jSONObject.getJSONObject("loadurl").getString("req"));
                        }
                        if (jSONObject2 != null) {
                            JSONObject jSONObject4 = jSONObject2.getJSONObject("cell");
                            keys2 = jSONObject4.keys();
                            StringBuffer stringBuffer = new StringBuffer();
                            StringBuffer stringBuffer2 = new StringBuffer();
                            StringBuffer stringBuffer3 = new StringBuffer();
                            boolean z3 = true;
                            boolean z4 = true;
                            boolean z5 = true;
                            i6 = 0;
                            i7 = 0;
                            i8 = 0;
                            while (keys2.hasNext()) {
                            }
                            if (i7 > 0) {
                            }
                            if (i8 > 0) {
                            }
                            if (i6 > 0) {
                            }
                        }
                        if (jSONObject2 != null) {
                            JSONObject jSONObject5 = jSONObject2.getJSONObject("ap");
                            keys = jSONObject5.keys();
                            i = 0;
                            i2 = 0;
                            i3 = 0;
                            boolean z6 = true;
                            boolean z7 = true;
                            boolean z8 = true;
                            StringBuffer stringBuffer4 = new StringBuffer();
                            StringBuffer stringBuffer5 = new StringBuffer();
                            StringBuffer stringBuffer6 = new StringBuffer();
                            while (keys.hasNext()) {
                            }
                            if (i2 > 0) {
                            }
                            if (i3 > 0) {
                            }
                            if (i > 0) {
                            }
                        }
                        e.this.Kp.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", "AP", "AP", 200000));
                        e.this.Kp.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", "CL", "CL", 200000));
                        e.this.Kq.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", "AP", "AP", 10000));
                        e.this.Kq.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", "CL", "CL", 10000));
                        if (jSONObject2 != null) {
                            this.KH.c();
                        }
                        e.this.Kp.setTransactionSuccessful();
                        e.this.Kq.setTransactionSuccessful();
                        if (e.this.Kp != null) {
                            e.this.Kp.endTransaction();
                        }
                        if (e.this.Kq != null) {
                            e.this.Kq.endTransaction();
                        }
                        this.KH.j = null;
                        this.KH.f = false;
                    }
                } catch (Exception e3) {
                    jSONObject2 = null;
                    e = e3;
                }
            } else {
                jSONObject = null;
                jSONObject2 = null;
            }
        } catch (Exception e4) {
            jSONObject = null;
            jSONObject2 = null;
            e = e4;
        }
        e.this.Kp.beginTransaction();
        e.this.Kq.beginTransaction();
        if (jSONObject3 != null) {
            try {
                try {
                    e.this.Kk.mN().a(jSONObject3);
                } catch (Exception e5) {
                    this.KH.c();
                    try {
                        if (e.this.Kp != null && e.this.Kp.isOpen()) {
                            e.this.Kp.endTransaction();
                        }
                        if (e.this.Kq != null && e.this.Kq.isOpen()) {
                            e.this.Kq.endTransaction();
                        }
                    } catch (Exception e6) {
                    }
                    this.KH.j = null;
                    this.KH.f = false;
                    return;
                }
            } catch (Throwable th) {
                try {
                    if (e.this.Kp != null && e.this.Kp.isOpen()) {
                        e.this.Kp.endTransaction();
                    }
                    if (e.this.Kq != null && e.this.Kq.isOpen()) {
                        e.this.Kq.endTransaction();
                    }
                } catch (Exception e7) {
                }
                this.KH.j = null;
                this.KH.f = false;
                throw th;
            }
        }
        if (jSONObject != null && jSONObject.has("type") && jSONObject.getString("type").equals("0")) {
            this.KH.KE = System.currentTimeMillis();
        }
        if (jSONObject != null && jSONObject.has("bdlist")) {
            String[] split2 = jSONObject.getString("bdlist").split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            eVar2 = this.KH.KC;
            eVar2.a(split2);
        }
        if (jSONObject != null && jSONObject.has("loadurl")) {
            eVar = this.KH.KC;
            eVar.a(jSONObject.getJSONObject("loadurl").getString("host"), jSONObject.getJSONObject("loadurl").getString("module"), jSONObject.getJSONObject("loadurl").getString("req"));
        }
        if (jSONObject2 != null && jSONObject2.has("cell")) {
            JSONObject jSONObject42 = jSONObject2.getJSONObject("cell");
            keys2 = jSONObject42.keys();
            StringBuffer stringBuffer7 = new StringBuffer();
            StringBuffer stringBuffer22 = new StringBuffer();
            StringBuffer stringBuffer32 = new StringBuffer();
            boolean z32 = true;
            boolean z42 = true;
            boolean z52 = true;
            i6 = 0;
            i7 = 0;
            i8 = 0;
            while (keys2.hasNext()) {
                String next = keys2.next();
                String string = jSONObject42.getString(next);
                Double valueOf = Double.valueOf(string.split(",")[3]);
                if (z42) {
                    z42 = false;
                } else {
                    stringBuffer22.append(',');
                }
                stringBuffer22.append(next);
                i7++;
                if (valueOf.doubleValue() > 0.0d) {
                    if (z52) {
                        z52 = false;
                    } else {
                        stringBuffer32.append(',');
                    }
                    stringBuffer32.append('(').append(next).append(',').append(string).append("," + (System.currentTimeMillis() / 1000)).append(')');
                    i8++;
                    i9 = i6;
                    z2 = z32;
                } else {
                    if (z32) {
                        z32 = false;
                    } else {
                        stringBuffer7.append(',');
                    }
                    stringBuffer7.append(next);
                    i9 = i6 + 1;
                    z2 = z32;
                }
                if (i7 >= 100) {
                    e.this.Kq.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", stringBuffer22.toString()));
                    z42 = true;
                    stringBuffer22.setLength(0);
                    i7 -= 100;
                }
                if (i8 >= 100) {
                    e.this.Kp.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", stringBuffer32.toString()));
                    z52 = true;
                    stringBuffer32.setLength(0);
                    i8 -= 100;
                }
                if (i9 >= 100) {
                    e.this.Kp.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", stringBuffer7.toString()));
                    z2 = true;
                    stringBuffer7.setLength(0);
                    i9 -= 100;
                }
                z32 = z2;
                i6 = i9;
            }
            if (i7 > 0) {
                e.this.Kq.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", stringBuffer22.toString()));
            }
            if (i8 > 0) {
                e.this.Kp.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", stringBuffer32.toString()));
            }
            if (i6 > 0) {
                e.this.Kp.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", stringBuffer7.toString()));
            }
        }
        if (jSONObject2 != null && jSONObject2.has("ap")) {
            JSONObject jSONObject52 = jSONObject2.getJSONObject("ap");
            keys = jSONObject52.keys();
            i = 0;
            i2 = 0;
            i3 = 0;
            boolean z62 = true;
            boolean z72 = true;
            boolean z82 = true;
            StringBuffer stringBuffer42 = new StringBuffer();
            StringBuffer stringBuffer52 = new StringBuffer();
            StringBuffer stringBuffer62 = new StringBuffer();
            while (keys.hasNext()) {
                String next2 = keys.next();
                String string2 = jSONObject52.getString(next2);
                Double valueOf2 = Double.valueOf(string2.split(",")[3]);
                if (z72) {
                    z72 = false;
                } else {
                    stringBuffer52.append(',');
                }
                stringBuffer52.append(next2);
                i2++;
                if (valueOf2.doubleValue() > 0.0d) {
                    if (z82) {
                        z82 = false;
                    } else {
                        stringBuffer62.append(',');
                    }
                    stringBuffer62.append('(').append(next2).append(',').append(string2).append("," + (System.currentTimeMillis() / 1000)).append(')');
                    int i10 = i3 + 1;
                    i5 = i;
                    z = z82;
                    i4 = i10;
                } else {
                    if (z62) {
                        z62 = false;
                    } else {
                        stringBuffer42.append(',');
                    }
                    stringBuffer42.append(next2);
                    boolean z9 = z82;
                    i4 = i3;
                    i5 = i + 1;
                    z = z9;
                }
                if (i2 >= 100) {
                    e.this.Kq.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", stringBuffer52.toString()));
                    z72 = true;
                    stringBuffer52.setLength(0);
                    i2 -= 100;
                }
                if (i4 >= 100) {
                    e.this.Kp.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", stringBuffer62.toString()));
                    z = true;
                    stringBuffer62.setLength(0);
                    i4 -= 100;
                }
                if (i5 > 0) {
                    e.this.Kp.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", stringBuffer42.toString()));
                }
                i = i5;
                i3 = i4;
                z82 = z;
            }
            if (i2 > 0) {
                e.this.Kq.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", stringBuffer52.toString()));
            }
            if (i3 > 0) {
                e.this.Kp.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", stringBuffer62.toString()));
            }
            if (i > 0) {
                e.this.Kp.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", stringBuffer42.toString()));
            }
        }
        e.this.Kp.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", "AP", "AP", 200000));
        e.this.Kp.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", "CL", "CL", 200000));
        e.this.Kq.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", "AP", "AP", 10000));
        e.this.Kq.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", "CL", "CL", 10000));
        if (jSONObject2 != null && !jSONObject2.has("ap") && !jSONObject2.has("cell")) {
            this.KH.c();
        }
        e.this.Kp.setTransactionSuccessful();
        e.this.Kq.setTransactionSuccessful();
        try {
            if (e.this.Kp != null && e.this.Kp.isOpen()) {
                e.this.Kp.endTransaction();
            }
            if (e.this.Kq != null && e.this.Kq.isOpen()) {
                e.this.Kq.endTransaction();
            }
        } catch (Exception e8) {
        }
        this.KH.j = null;
        this.KH.f = false;
    }
}
