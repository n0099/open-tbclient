package com.baidu.location;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.location.GeofenceClient;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements a0, n {
    private static final String i = "GeofenceMan";
    public static final int iA = 10;
    private static final String iB = "http://loc.map.baidu.com/fence";
    private static final String iC = "geofence_id";
    private static final String iD = ";";
    private static final String iF = "status_code";
    private static ax iG = null;
    private static final int iI = 5;
    private static final int iJ = 2;
    private static final int iK = 1;
    private static final String iM = "geofence_ids";
    private static final String iy = "GeofenceMan";
    private static final int iz = 3;
    private Object iE = new Object();
    private HandlerThread iH;
    private a iL;
    private Context ix;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Handler {

        /* renamed from: do  reason: not valid java name */
        public static final int f80do = 2;

        /* renamed from: for  reason: not valid java name */
        public static final int f81for = 3;

        /* renamed from: if  reason: not valid java name */
        public static final int f82if = 0;

        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i;
            String[] strArr;
            int i2;
            String str;
            super.handleMessage(message);
            int i3 = message.what;
            Bundle data = message.getData();
            switch (i3) {
                case 0:
                    if (data != null) {
                        i2 = data.getInt(ax.iF, 1);
                        str = data.getString("geofence_id");
                    } else {
                        i2 = 1;
                        str = null;
                    }
                    ax.this.m239if(i2, str, (GeofenceClient.OnAddBDGeofencesResultListener) message.obj);
                    return;
                case 1:
                default:
                    return;
                case 2:
                    if (data != null) {
                        i = data.getInt(ax.iF, 1);
                        strArr = data.getStringArray(ax.iM);
                    } else {
                        i = 1;
                        strArr = null;
                    }
                    ax.this.m240if(i, strArr, (GeofenceClient.OnRemoveBDGeofencesResultListener) message.obj);
                    return;
                case 3:
                    ax.this.cn();
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends t {
        private static final String dN = "error";
        private static final int dO = -3;
        private static final String dP = "ext";
        private static final String dQ = "cl";
        private static final String dR = "fence";
        private static final String dS = "lac";
        private static final String dU = "wf";
        private static final String dW = "radius";
        private GeofenceClient.OnAddBDGeofencesResultListener dM;
        private int dV;
        private final at dX;

        public b(at atVar, GeofenceClient.OnAddBDGeofencesResultListener onAddBDGeofencesResultListener) {
            this.dX = atVar;
            this.dM = onAddBDGeofencesResultListener;
            this.cZ = new ArrayList();
        }

        @Override // com.baidu.location.t
        public void X() {
            this.cX = "http://loc.map.baidu.com/fence";
            DecimalFormat decimalFormat = new DecimalFormat("0.00000");
            this.cZ.add(new BasicNameValuePair(dR, Jni.j(String.format("&x=%s&y=%s&r=%s&coord=%s&type=%s&cu=%s&sdk=%s", decimalFormat.format(this.dX.a()), decimalFormat.format(this.dX.m196case()), String.valueOf(this.dX.m206new()), String.valueOf(this.dX.m205int()), Integer.valueOf(ax.m230do(ax.this.ix)), com.baidu.location.a.a.a.m65if(ax.this.ix), Float.valueOf(5.01f)))));
            this.cZ.add(new BasicNameValuePair(dP, Jni.j(String.format(Locale.CHINA, "&ki=%s&sn=%s", w.a(ax.this.ix), w.m362if(ax.this.ix)))));
        }

        public void al() {
            R();
        }

        @Override // com.baidu.location.t
        /* renamed from: do */
        public void mo112do(boolean z) {
            if (!z || this.cY == null) {
                ax.this.m241if(this.dM, 1, this.dX.getGeofenceId());
                return;
            }
            String str = null;
            try {
                JSONObject jSONObject = new JSONObject(EntityUtils.toString(this.cY, "UTF-8"));
                if (jSONObject != null) {
                    StringBuilder sb = new StringBuilder();
                    if (jSONObject.has(dS)) {
                        String string = jSONObject.getString(dS);
                        if (!TextUtils.isEmpty(string)) {
                            sb.append(string);
                            this.dX.m199do(true);
                        }
                    }
                    if (jSONObject.has(dQ)) {
                        String string2 = jSONObject.getString(dQ);
                        if (!TextUtils.isEmpty(string2)) {
                            sb.append(string2);
                            this.dX.a(true);
                        }
                    }
                    if (jSONObject.has(dU)) {
                        String string3 = jSONObject.getString(dU);
                        if (!TextUtils.isEmpty(string3)) {
                            sb.append(string3);
                            this.dX.m203if(true);
                        }
                    }
                    str = sb.toString();
                    if (jSONObject.has(dW)) {
                        this.dX.a(Float.valueOf(jSONObject.getString(dW)).floatValue());
                    }
                    if (jSONObject.has(dN)) {
                        this.dV = Integer.valueOf(jSONObject.getString(dN)).intValue();
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    ax.this.iL.post(new c(this.dX, str, this.dM));
                } else if (this.dV == -3) {
                    ax.this.m241if(this.dM, (int) BDLocationStatusCodes.GEOFENCE_SERVICE_NO_ALIVIABLE, this.dX.getGeofenceId());
                } else {
                    ax.this.m241if(this.dM, this.dV, this.dX.getGeofenceId());
                }
            } catch (Exception e) {
                ax.this.m241if(this.dM, 1, this.dX.getGeofenceId());
            }
        }
    }

    /* loaded from: classes.dex */
    private class c implements Runnable {

        /* renamed from: do  reason: not valid java name */
        private final at f83do;

        /* renamed from: for  reason: not valid java name */
        private final GeofenceClient.OnAddBDGeofencesResultListener f84for;

        /* renamed from: if  reason: not valid java name */
        private final String f85if;

        public c(at atVar, String str, GeofenceClient.OnAddBDGeofencesResultListener onAddBDGeofencesResultListener) {
            this.f83do = atVar;
            this.f85if = str;
            this.f84for = onAddBDGeofencesResultListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            ax.this.m241if(this.f84for, ax.this.m235if(this.f83do, this.f85if), this.f83do.getGeofenceId());
            if (f.getServiceContext() != null) {
                a3.cE().m106for(this.f83do);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Runnable {

        /* renamed from: do  reason: not valid java name */
        private final GeofenceClient.OnRemoveBDGeofencesResultListener f86do;

        /* renamed from: if  reason: not valid java name */
        private final List f87if;

        public d(List list, GeofenceClient.OnRemoveBDGeofencesResultListener onRemoveBDGeofencesResultListener) {
            this.f87if = list;
            this.f86do = onRemoveBDGeofencesResultListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            int m231do = ax.this.m231do(this.f87if);
            Message obtain = Message.obtain(ax.this.iL);
            obtain.what = 2;
            obtain.obj = this.f86do;
            Bundle bundle = new Bundle();
            bundle.putInt(ax.iF, m231do);
            bundle.putStringArray(ax.iM, (String[]) this.f87if.toArray(new String[this.f87if.size()]));
            obtain.setData(bundle);
            ax.this.iL.sendMessage(obtain);
        }
    }

    ax() {
    }

    private void co() {
        this.iH = new HandlerThread("GeofenceMan", 10);
        this.iH.start();
        this.iL = new a(this.iH.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cp() {
        SQLiteDatabase writableDatabase = m.a(this.ix).getWritableDatabase();
        if (writableDatabase != null) {
            writableDatabase.beginTransaction();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                writableDatabase.execSQL(String.format("DELETE FROM %s WHERE EXISTS (SELECT * FROM %s WHERE (%s + %s) < %d)", "geofence_detail", "geofence", "valid_date", "duration_millis", Long.valueOf(currentTimeMillis)));
                writableDatabase.execSQL(String.format("DELETE FROM %s WHERE (%s + %s) < %d", "geofence", "valid_date", "duration_millis", Long.valueOf(currentTimeMillis)));
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                writableDatabase.close();
            } catch (Exception e) {
                writableDatabase.endTransaction();
                writableDatabase.close();
            }
        }
    }

    private void cq() {
        this.iL.sendEmptyMessage(3);
    }

    private final void cr() {
        if (!t.m341if(this.ix)) {
            throw new IllegalStateException("Not net connection");
        }
    }

    private synchronized long cs() {
        long j;
        j = 0;
        try {
            SQLiteDatabase readableDatabase = m.a(this.ix).getReadableDatabase();
            if (readableDatabase != null) {
                j = DatabaseUtils.queryNumEntries(readableDatabase, "geofence");
                readableDatabase.close();
            }
        } catch (Exception e) {
        }
        return j;
    }

    /* renamed from: do  reason: not valid java name */
    public static int m230do(Context context) {
        String subscriberId = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        if (subscriberId != null) {
            if (subscriberId.startsWith("46000") || subscriberId.startsWith("46002") || subscriberId.startsWith("46007")) {
                return 1;
            }
            if (subscriberId.startsWith("46001")) {
                return 2;
            }
            if (subscriberId.startsWith("46003")) {
                return 3;
            }
        }
        return 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public synchronized int m231do(List list) {
        int i2;
        SQLiteDatabase writableDatabase = m.a(this.ix).getWritableDatabase();
        if (writableDatabase != null) {
            writableDatabase.beginTransaction();
            try {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    String[] strArr = {(String) it.next()};
                    writableDatabase.delete("geofence", String.format("%s=?", "geofence_id"), strArr);
                    writableDatabase.delete("geofence_detail", String.format("%s=?", "geofence_id"), strArr);
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                i2 = 0;
            } catch (Exception e) {
                writableDatabase.endTransaction();
                i2 = 1;
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
            writableDatabase.close();
        } else {
            i2 = 0;
        }
        return i2;
    }

    /* renamed from: for  reason: not valid java name */
    public static ax m233for(Context context) {
        if (iG == null) {
            iG = new ax();
            iG.co();
            iG.ix = context;
        }
        return iG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public synchronized int m235if(at atVar, String str) {
        String[] split;
        int i2 = 0;
        synchronized (this) {
            SQLiteDatabase writableDatabase = m.a(this.ix).getWritableDatabase();
            if (writableDatabase != null) {
                writableDatabase.beginTransaction();
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    ContentValues contentValues = new ContentValues();
                    String geofenceId = atVar.getGeofenceId();
                    contentValues.put("geofence_id", geofenceId);
                    contentValues.put("longitude", Double.valueOf(atVar.a()));
                    contentValues.put("latitude", Double.valueOf(atVar.m196case()));
                    contentValues.put("radius", Float.valueOf(atVar.m198do()));
                    contentValues.put("radius_type", Integer.valueOf(atVar.m206new()));
                    contentValues.put("valid_date", Long.valueOf(currentTimeMillis));
                    contentValues.put("duration_millis", Long.valueOf(atVar.m202goto()));
                    contentValues.put("coord_type", atVar.m205int());
                    contentValues.put("is_lac", Integer.valueOf(atVar.m195byte() ? 1 : 0));
                    contentValues.put("is_cell", Integer.valueOf(atVar.m204if() ? 1 : 0));
                    contentValues.put("is_wifi", Integer.valueOf(atVar.m201for() ? 1 : 0));
                    contentValues.put("next_active_time", (Integer) 0);
                    contentValues.put("next_exit_active_time", (Integer) 0);
                    writableDatabase.insert("geofence", null, contentValues);
                    for (String str2 : str.split(iD)) {
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("geofence_id", geofenceId);
                        contentValues2.put("ap_backup", str2);
                        int lastIndexOf = str2.lastIndexOf("|");
                        if (lastIndexOf != -1) {
                            str2 = str2.substring(0, lastIndexOf);
                        }
                        contentValues2.put("ap", str2);
                        writableDatabase.insert("geofence_detail", null, contentValues2);
                    }
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                } catch (Exception e) {
                    writableDatabase.endTransaction();
                    i2 = 1;
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
                writableDatabase.close();
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public void m239if(int i2, String str, GeofenceClient.OnAddBDGeofencesResultListener onAddBDGeofencesResultListener) {
        if (i2 == 1) {
        }
        onAddBDGeofencesResultListener.onAddBDGeofencesResult(i2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public void m240if(int i2, String[] strArr, GeofenceClient.OnRemoveBDGeofencesResultListener onRemoveBDGeofencesResultListener) {
        onRemoveBDGeofencesResultListener.onRemoveBDGeofencesByRequestIdsResult(i2, strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public void m241if(GeofenceClient.OnAddBDGeofencesResultListener onAddBDGeofencesResultListener, int i2, String str) {
        Message obtain = Message.obtain(this.iL);
        obtain.what = 0;
        obtain.obj = onAddBDGeofencesResultListener;
        Bundle bundle = new Bundle();
        bundle.putInt(iF, i2);
        bundle.putString("geofence_id", str);
        obtain.setData(bundle);
        this.iL.sendMessage(obtain);
    }

    /* renamed from: int  reason: not valid java name */
    public static void m245int(Context context) {
        a3.cE().m111try(f.getServiceContext());
    }

    public void cn() {
        synchronized (this.iE) {
            this.iL.post(new Runnable() { // from class: com.baidu.location.ax.3
                @Override // java.lang.Runnable
                public void run() {
                    ax.this.cp();
                }
            });
        }
    }

    /* renamed from: do  reason: not valid java name */
    public void m246do(final at atVar) {
        this.iL.post(new Runnable() { // from class: com.baidu.location.ax.1
            @Override // java.lang.Runnable
            public void run() {
                ax.this.m247do(atVar.getGeofenceId(), true);
            }
        });
    }

    /* renamed from: do  reason: not valid java name */
    public synchronized void m247do(String str, boolean z) {
        SQLiteDatabase writableDatabase;
        long j = a3.jw;
        synchronized (this) {
            if (!TextUtils.isEmpty(str) && (writableDatabase = m.a(this.ix).getWritableDatabase()) != null) {
                try {
                    ContentValues contentValues = new ContentValues();
                    if (z) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (GeofenceClient.e() != 0 && GeofenceClient.e() != a3.jw) {
                            j = GeofenceClient.e();
                        }
                        contentValues.put("next_active_time", Long.valueOf(j + currentTimeMillis));
                    } else {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        if (GeofenceClient.e() != 0 && GeofenceClient.e() != a3.jw) {
                            j = GeofenceClient.e();
                        }
                        contentValues.put("next_exit_active_time", Long.valueOf(j + currentTimeMillis2));
                    }
                    writableDatabase.update("geofence", contentValues, "geofence_id= ?", new String[]{str});
                    writableDatabase.close();
                } catch (Exception e) {
                    writableDatabase.close();
                }
            }
        }
    }

    /* renamed from: if  reason: not valid java name */
    public void m248if(final at atVar) {
        this.iL.post(new Runnable() { // from class: com.baidu.location.ax.2
            @Override // java.lang.Runnable
            public void run() {
                ax.this.m247do(atVar.getGeofenceId(), false);
            }
        });
    }

    /* renamed from: if  reason: not valid java name */
    public void m249if(at atVar, GeofenceClient.OnAddBDGeofencesResultListener onAddBDGeofencesResultListener) {
        cr();
        aq.a(onAddBDGeofencesResultListener, "OnAddBDGeofenceRecesResultListener not provided.");
        if (cs() >= 10) {
            onAddBDGeofencesResultListener.onAddBDGeofencesResult(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES, atVar.getGeofenceId());
            return;
        }
        new b(atVar, onAddBDGeofencesResultListener).al();
        cq();
    }

    /* renamed from: if  reason: not valid java name */
    public void m250if(List list, GeofenceClient.OnRemoveBDGeofencesResultListener onRemoveBDGeofencesResultListener) {
        aq.m188if(list != null && list.size() > 0, "geofenceRequestIds can't be null nor empty.");
        aq.a(onRemoveBDGeofencesResultListener, "onRemoveBDGeofencesResultListener not provided.");
        this.iL.post(new d(list, onRemoveBDGeofencesResultListener));
    }
}
