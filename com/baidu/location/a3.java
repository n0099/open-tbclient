package com.baidu.location;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Messenger;
import android.os.PowerManager;
import android.text.TextUtils;
import com.baidu.location.au;
import com.baidu.location.u;
import com.baidu.tbadk.TbConfig;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a3 implements n {
    private static final String jE = "com.baidu.locsdk.geofence.geofencestrategyservice";
    private static final int jF = 180000;
    private static final int jH = 60000;
    public static a3 jJ = null;
    private static final String jL = "0";
    public static final String jM = "http://loc.map.baidu.com/fence";
    private static final String jO = "&gf=1";
    private static final String jl = "GeofenceStrategyService";
    private static final int jn = 30000;
    private static final int jo = 360000;
    private static final int jq = 6;
    private static final String jt = "GeofenceStrategyService";
    public static final long jw = 1800000;
    private static final String jy = "1";
    private String jB;
    private c jC;
    private PowerManager.WakeLock jD;
    private int jG;
    private HandlerThread jI;
    private Messenger jK;
    private au.b jN;
    private List jP;
    private au.b jQ;
    private List jm;
    private String jp;
    private boolean jr;
    private boolean js;
    private String ju;
    private d jv;
    private Map jA = new HashMap();
    private Handler jz = new Handler();
    private boolean jx = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends t {
        private static final String d1 = "bloc";
        private static final String d2 = "ext";
        private static final String d3 = "error";
        private static final String d5 = "in";
        private static final String dZ = "fence";
        private at d0;
        private final String d4;

        public a(at atVar, String str) {
            this.d0 = atVar;
            this.d4 = str;
            this.cZ = new ArrayList();
        }

        private void am() {
            a3.this.jx = false;
            ax.m233for(f.getServiceContext()).m248if(this.d0);
            if (a3.this.jK != null) {
                Message obtain = Message.obtain((Handler) null, (int) a0.c);
                Bundle bundle = new Bundle();
                bundle.putString(GeofenceClient.BUNDLE_FOR_GEOFENCE_ID, this.d0.getGeofenceId());
                obtain.setData(bundle);
                a3.this.jK.send(obtain);
            }
        }

        private void ao() {
            a3.this.jx = false;
            a3.this.jA.put(this.d0.getGeofenceId(), Long.valueOf(System.currentTimeMillis()));
            ax.m233for(f.getServiceContext()).m246do(this.d0);
            if (a3.this.jK != null) {
                Message obtain = Message.obtain((Handler) null, (int) a0.f38new);
                Bundle bundle = new Bundle();
                bundle.putString(GeofenceClient.BUNDLE_FOR_GEOFENCE_ID, this.d0.getGeofenceId());
                obtain.setData(bundle);
                a3.this.jK.send(obtain);
            }
        }

        @Override // com.baidu.location.t
        void X() {
            this.cX = a3.jM;
            DecimalFormat decimalFormat = new DecimalFormat("0.00000");
            Object[] objArr = new Object[8];
            objArr[0] = decimalFormat.format(this.d0.a());
            objArr[1] = decimalFormat.format(this.d0.m196case());
            objArr[2] = String.valueOf(this.d0.m198do());
            objArr[3] = String.valueOf(this.d0.m205int());
            objArr[4] = Integer.valueOf(ax.m230do(f.getServiceContext()));
            objArr[5] = com.baidu.location.a.a.a.m65if(f.getServiceContext());
            objArr[6] = Integer.valueOf(this.d0.m197char());
            objArr[7] = au.cc().cf() ? "1" : "0";
            this.cZ.add(new BasicNameValuePair(dZ, Jni.j(String.format("&x=%s&y=%s&r=%s&coord=%s&type=%s&cu=%s&fence_type=%s&wf_on=%s", objArr))));
            this.cZ.add(new BasicNameValuePair(d1, this.d4));
            this.cZ.add(new BasicNameValuePair(d2, Jni.j(String.format(Locale.CHINA, "&ki=%s&sn=%s", w.a(f.getServiceContext()), w.m362if(f.getServiceContext())))));
        }

        public void an() {
            R();
        }

        @Override // com.baidu.location.t
        /* renamed from: do  reason: not valid java name */
        void mo112do(boolean z) {
            a3.this.jr = false;
            if (!z || this.cY == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(EntityUtils.toString(this.cY, "UTF-8"));
                if (jSONObject != null) {
                    int intValue = Integer.valueOf(jSONObject.getString(d3)).intValue();
                    int intValue2 = jSONObject.has(d5) ? Integer.valueOf(jSONObject.getString(d5)).intValue() : 0;
                    if (intValue == 0) {
                        a3.this.jB = null;
                        a3.this.jN = null;
                        ax.m233for(f.getServiceContext()).cn();
                        if (a3.this.jx) {
                            if (intValue2 == 1) {
                                ao();
                            } else if (intValue2 == 0) {
                                am();
                            }
                        } else if (intValue2 == 1 && this.d0.m207try() == 1) {
                            ao();
                        } else if (intValue2 == 0 && this.d0.m207try() == 0) {
                            am();
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends aj {
        private b() {
        }

        @Override // com.baidu.location.aj
        void aA() {
        }

        @Override // com.baidu.location.aj
        /* renamed from: byte  reason: not valid java name */
        void mo113byte(Message message) {
        }
    }

    /* loaded from: classes.dex */
    public class c extends BroadcastReceiver {
        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            a3.this.m82byte(context);
            a3.this.jz.post(a3.this.jv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements com.baidu.location.b, Runnable {
        private d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                List m89else = a3.this.m89else(true);
                if (a3.this.ju.equals(a3.this.jB) && !a3.this.cG() && a3.this.jr) {
                    return;
                }
                a3.this.jB = a3.this.ju;
                a3.this.jN = a3.this.jQ;
                u.a at = u.au().at();
                String k = Jni.k(String.format("%s|%s|%s|0", Integer.valueOf(at.f107byte), Integer.valueOf(at.f108case), Integer.valueOf(at.a)));
                a3.this.jp = String.format("%s|%s|%s|0", Integer.valueOf(at.f107byte), Integer.valueOf(at.f108case), Integer.valueOf(at.a));
                a3.this.jP = a3.this.m105for(k, true);
                a3.this.jm = a3.this.m105for(k, false);
                a3.this.m94for(m89else);
                a3.this.cH();
            } catch (Exception e) {
                a3.this.m108if(f.getServiceContext(), a3.jo);
            }
        }
    }

    a3() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: byte  reason: not valid java name */
    public void m82byte(Context context) {
        if (this.jD == null) {
            this.jD = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "GeofenceStrategyService");
            this.jD.setReferenceCounted(false);
            this.jD.acquire(TbConfig.USE_TIME_INTERVAL);
        }
    }

    public static a3 cE() {
        if (jJ == null) {
            jJ = new a3();
            jJ.cJ();
        }
        return jJ;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0072 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Map cF() {
        Cursor cursor = null;
        HashMap hashMap = new HashMap();
        SQLiteDatabase readableDatabase = m.a(f.getServiceContext()).getReadableDatabase();
        try {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                cursor = readableDatabase.rawQuery(String.format("SELECT a.ap, b.geofence_id FROM %s AS a LEFT JOIN %s AS b WHERE (a.geofence_id = b.geofence_id) AND ((b.valid_date + b.duration_millis) >= %d) AND (b.next_exit_active_time < %d) ", "geofence_detail", "geofence", Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis)), null);
            } catch (Exception e) {
                e.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
            }
            if (cursor == null || cursor.getCount() <= 0) {
                readableDatabase.close();
                return hashMap;
            }
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(GeofenceClient.BUNDLE_FOR_GEOFENCE_ID);
            int columnIndex2 = cursor.getColumnIndex("ap");
            do {
                String string = cursor.getString(columnIndex);
                String string2 = cursor.getString(columnIndex2);
                if (hashMap.containsKey(string)) {
                    ((List) hashMap.get(string)).add(string2);
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(string2);
                    hashMap.put(string, arrayList);
                }
            } while (cursor.moveToNext());
            readableDatabase.close();
            return hashMap;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cG() {
        if (this.jN == null) {
            return true;
        }
        return (this.jQ == this.jN || this.jN.a(this.jQ)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cH() {
        boolean z;
        if (this.jr) {
            m108if(f.getServiceContext(), jn);
        } else if (this.jG > 0) {
            m108if(f.getServiceContext(), this.jG >= 6 ? jF : this.jG * jn);
        } else if (this.jP == null || this.jP.size() <= 0) {
            m108if(f.getServiceContext(), jo);
        } else {
            boolean z2 = false;
            Iterator it = this.jP.iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                at atVar = (at) it.next();
                if (atVar.m204if() || atVar.m201for()) {
                    z2 = z;
                } else {
                    m106for(atVar);
                    z2 = true;
                }
            }
            if (this.jm != null && this.jm.size() > 0) {
                for (at atVar2 : this.jm) {
                    if (!atVar2.m204if() && !atVar2.m201for()) {
                        m106for(atVar2);
                        z = true;
                    }
                }
            }
            if (z) {
                m108if(f.getServiceContext(), jn);
            } else {
                m108if(f.getServiceContext(), jF);
            }
        }
    }

    private void cI() {
        if (this.jD == null || !this.jD.isHeld()) {
            return;
        }
        this.jD.release();
        this.jD = null;
    }

    private void cJ() {
        this.jI = new HandlerThread("GeofenceStrategyService", 10);
        this.jI.start();
        this.jz = new Handler(this.jI.getLooper());
        this.jv = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: else  reason: not valid java name */
    public List m89else(boolean z) {
        List<ScanResult> list;
        u.a at = u.au().at();
        this.jQ = au.cc().b7();
        ArrayList arrayList = new ArrayList();
        if (z) {
            this.ju = String.format("%s|%s|%s|%s", Integer.valueOf(at.f107byte), Integer.valueOf(at.f108case), Integer.valueOf(at.a), Integer.valueOf(at.f111for));
            arrayList.add(Jni.k(this.ju));
        }
        if (this.jQ != null && (list = this.jQ.f74for) != null) {
            for (ScanResult scanResult : list) {
                if (scanResult != null) {
                    arrayList.add(Jni.k(scanResult.BSSID.replace(":", "")));
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0103  */
    /* renamed from: for  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m94for(List list) {
        List<at> list2;
        ArrayList<at> arrayList;
        if (list == null || list.size() == 0) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.set(i, String.format("'%s'", list.get(i)));
        }
        List m107if = m107if(list, true);
        if (m107if != null) {
            Iterator it = m107if.iterator();
            while (it.hasNext()) {
                at atVar = (at) it.next();
                Iterator it2 = this.jA.entrySet().iterator();
                while (it2.hasNext()) {
                    Map.Entry entry = (Map.Entry) it2.next();
                    if (System.currentTimeMillis() - ((Long) entry.getValue()).longValue() >= jw) {
                        it2.remove();
                    }
                    if (atVar.getGeofenceId().equals(entry.getKey())) {
                        it.remove();
                    }
                }
            }
        }
        List<String> m89else = m89else(false);
        if (m89else != null && m89else.size() > 0) {
            Map cF = cF();
            if (cF.size() > 0) {
                for (String str : m89else) {
                    Iterator it3 = cF.entrySet().iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            if (((List) ((Map.Entry) it3.next()).getValue()).contains(str)) {
                                it3.remove();
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
            if (cF.size() > 0) {
                m89else.clear();
                m89else.addAll(cF.keySet());
                int size2 = m89else.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    m89else.set(i2, String.format("'%s'", m89else.get(i2)));
                }
                list2 = m107if(m89else, false);
                arrayList = new ArrayList();
                if (m107if != null) {
                    arrayList.addAll(m107if);
                }
                if (list2 != null) {
                    for (at atVar2 : list2) {
                        if (!arrayList.contains(atVar2) || this.jx) {
                            arrayList.add(atVar2);
                        }
                    }
                }
                if (arrayList != null || arrayList.size() <= 0) {
                    this.jr = false;
                }
                for (at atVar3 : arrayList) {
                    if (atVar3 != null) {
                        this.jr = true;
                        m106for(atVar3);
                        this.jB = this.ju;
                        this.jN = this.jQ;
                        this.jG = 0;
                    } else {
                        this.jr = false;
                        this.jG++;
                        this.jG = this.jG == Integer.MAX_VALUE ? 1 : this.jG;
                    }
                }
                return;
            }
        }
        list2 = null;
        arrayList = new ArrayList();
        if (m107if != null) {
        }
        if (list2 != null) {
        }
        if (arrayList != null) {
        }
        this.jr = false;
    }

    /* renamed from: for  reason: not valid java name */
    public List m105for(String str, boolean z) {
        Cursor cursor;
        SQLiteDatabase readableDatabase = m.a(f.getServiceContext()).getReadableDatabase();
        ArrayList arrayList = null;
        if (readableDatabase != null) {
            Cursor cursor2 = null;
            long currentTimeMillis = System.currentTimeMillis();
            try {
                cursor = readableDatabase.rawQuery(z ? String.format("SELECT distinct b.geofence_id, b.longitude, b.latitude, b.radius, b.coord_type, b.duration_millis, b.is_lac, b.is_cell, b.is_wifi, b.radius_type FROM %s AS a LEFT JOIN %s AS b WHERE (a.geofence_id = b.geofence_id) AND (a.ap = '%s' AND  (b.valid_date + b.duration_millis >= %d) AND b.next_active_time < %d)", "geofence_detail", "geofence", str, Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis)) : String.format("SELECT distinct b.geofence_id, b.longitude, b.latitude, b.radius, b.coord_type, b.duration_millis, b.is_lac, b.is_cell, b.is_wifi, b.radius_type FROM %s AS a LEFT JOIN %s AS b WHERE (a.geofence_id = b.geofence_id) AND (a.ap <> '%s' AND  (b.valid_date + b.duration_millis >= %d) AND b.next_exit_active_time < %d)", "geofence_detail", "geofence", str, Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis)), null);
                if (cursor != null) {
                    try {
                        try {
                            if (cursor.getCount() > 0) {
                                ArrayList arrayList2 = new ArrayList();
                                try {
                                    cursor.moveToFirst();
                                    int columnIndex = cursor.getColumnIndex(GeofenceClient.BUNDLE_FOR_GEOFENCE_ID);
                                    int columnIndex2 = cursor.getColumnIndex("longitude");
                                    int columnIndex3 = cursor.getColumnIndex("latitude");
                                    int columnIndex4 = cursor.getColumnIndex("radius");
                                    int columnIndex5 = cursor.getColumnIndex("coord_type");
                                    int columnIndex6 = cursor.getColumnIndex("duration_millis");
                                    int columnIndex7 = cursor.getColumnIndex("is_lac");
                                    int columnIndex8 = cursor.getColumnIndex("is_cell");
                                    int columnIndex9 = cursor.getColumnIndex("is_wifi");
                                    int columnIndex10 = cursor.getColumnIndex("radius_type");
                                    do {
                                        String string = cursor.getString(columnIndex);
                                        float floatValue = Float.valueOf(cursor.getString(columnIndex2)).floatValue();
                                        float floatValue2 = Float.valueOf(cursor.getString(columnIndex3)).floatValue();
                                        float floatValue3 = Float.valueOf(cursor.getString(columnIndex4)).floatValue();
                                        String string2 = cursor.getString(columnIndex5);
                                        long j = cursor.getLong(columnIndex6);
                                        boolean z2 = cursor.getInt(columnIndex7) != 0;
                                        boolean z3 = cursor.getInt(columnIndex8) != 0;
                                        boolean z4 = cursor.getInt(columnIndex9) != 0;
                                        at atVar = new at(string, floatValue, floatValue2, cursor.getInt(columnIndex10), j, string2);
                                        if (atVar != null) {
                                            atVar.a(floatValue3);
                                            atVar.m199do(z2);
                                            atVar.a(z3);
                                            atVar.m203if(z4);
                                            if (!this.jx) {
                                                atVar.a(z ? 1 : 0);
                                            }
                                        }
                                        arrayList2.add(atVar);
                                    } while (cursor.moveToNext());
                                    arrayList = arrayList2;
                                } catch (Exception e) {
                                    cursor2 = cursor;
                                    arrayList = arrayList2;
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    readableDatabase.close();
                                    return arrayList;
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    } catch (Exception e2) {
                        cursor2 = cursor;
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e3) {
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
            }
            readableDatabase.close();
        }
        return arrayList;
    }

    /* renamed from: for  reason: not valid java name */
    public void m106for(at atVar) {
        new a(atVar, Jni.j(new b().h(jO).replace(BDGeofence.COORD_TYPE_GCJ, atVar.m205int()))).an();
    }

    /* renamed from: if  reason: not valid java name */
    public List m107if(List list, boolean z) {
        Cursor cursor;
        String join = TextUtils.join(",", list);
        SQLiteDatabase readableDatabase = m.a(f.getServiceContext()).getReadableDatabase();
        ArrayList arrayList = null;
        if (readableDatabase != null) {
            Cursor cursor2 = null;
            try {
                long currentTimeMillis = System.currentTimeMillis();
                cursor = readableDatabase.rawQuery(z ? String.format("SELECT distinct b.geofence_id, b.longitude, b.latitude, b.radius, b.coord_type, b.duration_millis, b.is_lac, b.is_cell, b.is_wifi, b.radius_type FROM %s AS a LEFT JOIN %s AS b WHERE (a.geofence_id = b.geofence_id) AND (a.ap IN (%s) AND  (b.valid_date + b.duration_millis) >= %d) AND (b.next_active_time < %d)", "geofence_detail", "geofence", join, Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis)) : String.format("SELECT distinct b.geofence_id, b.longitude, b.latitude, b.radius, b.coord_type, b.duration_millis, b.is_lac, b.is_cell, b.is_wifi, b.radius_type FROM %s AS a LEFT JOIN %s AS b WHERE (a.geofence_id = b.geofence_id) AND (b.geofence_id IN (%s) AND  (b.valid_date + b.duration_millis) >= %d) AND (b.next_exit_active_time < %d)", "geofence_detail", "geofence", join, Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis)), null);
                if (cursor != null) {
                    try {
                        try {
                            if (cursor.getCount() > 0) {
                                ArrayList arrayList2 = new ArrayList();
                                try {
                                    arrayList2.clear();
                                    cursor.moveToFirst();
                                    int columnIndex = cursor.getColumnIndex(GeofenceClient.BUNDLE_FOR_GEOFENCE_ID);
                                    int columnIndex2 = cursor.getColumnIndex("longitude");
                                    int columnIndex3 = cursor.getColumnIndex("latitude");
                                    int columnIndex4 = cursor.getColumnIndex("radius");
                                    int columnIndex5 = cursor.getColumnIndex("coord_type");
                                    int columnIndex6 = cursor.getColumnIndex("duration_millis");
                                    int columnIndex7 = cursor.getColumnIndex("is_lac");
                                    int columnIndex8 = cursor.getColumnIndex("is_cell");
                                    int columnIndex9 = cursor.getColumnIndex("is_wifi");
                                    int columnIndex10 = cursor.getColumnIndex("radius_type");
                                    do {
                                        String string = cursor.getString(columnIndex);
                                        float floatValue = Float.valueOf(cursor.getString(columnIndex2)).floatValue();
                                        float floatValue2 = Float.valueOf(cursor.getString(columnIndex3)).floatValue();
                                        float floatValue3 = Float.valueOf(cursor.getString(columnIndex4)).floatValue();
                                        String string2 = cursor.getString(columnIndex5);
                                        long j = cursor.getLong(columnIndex6);
                                        boolean z2 = cursor.getInt(columnIndex7) != 0;
                                        boolean z3 = cursor.getInt(columnIndex8) != 0;
                                        boolean z4 = cursor.getInt(columnIndex9) != 0;
                                        at atVar = new at(string, floatValue, floatValue2, cursor.getInt(columnIndex10), j, string2);
                                        if (atVar != null) {
                                            atVar.a(floatValue3);
                                            atVar.m199do(z2);
                                            atVar.a(z3);
                                            atVar.m203if(z4);
                                            if (!this.jx) {
                                                atVar.a(z ? 1 : 0);
                                            }
                                        }
                                        arrayList2.add(atVar);
                                    } while (cursor.moveToNext());
                                    arrayList = arrayList2;
                                } catch (Exception e) {
                                    cursor2 = cursor;
                                    arrayList = arrayList2;
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    readableDatabase.close();
                                    return arrayList;
                                }
                            }
                        } catch (Exception e2) {
                            cursor2 = cursor;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e3) {
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
            }
            readableDatabase.close();
        }
        return arrayList;
    }

    /* renamed from: if  reason: not valid java name */
    public void m108if(Context context, int i) {
        Intent intent = new Intent(jE);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 134217728);
        if (i > 0) {
            i.a(context, broadcast, i);
            return;
        }
        i.a(context, broadcast);
        context.sendBroadcast(intent);
    }

    /* renamed from: if  reason: not valid java name */
    public void m109if(Context context, Message message) {
        if (this.js) {
            return;
        }
        this.jK = message.replyTo;
        this.js = true;
        this.jC = new c();
        context.registerReceiver(this.jC, new IntentFilter(jE));
        m108if(context, 0);
    }

    /* renamed from: new  reason: not valid java name */
    public void m110new(Context context) {
        m109if(context, (Message) null);
    }

    /* renamed from: try  reason: not valid java name */
    public void m111try(Context context) {
        this.js = false;
        i.a(context, PendingIntent.getBroadcast(context, 0, new Intent(jE), 134217728));
        cI();
        if (this.jC != null) {
            try {
                context.unregisterReceiver(this.jC);
            } catch (Exception e) {
            }
        }
    }
}
