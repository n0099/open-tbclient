package com.baidu.swan.ubc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Base64OutputStream;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c {
    private static final boolean DEBUG = g.DEBUG;
    private a boO;
    private b boP;
    private long boR;
    private long boS;
    private long boT;
    private int boU;
    private SparseArray<ArrayList> boV;
    private HashMap<String, Long> boW;
    private d boY;
    private Context mContext;
    private l boX = r.Ts().uY();
    private List<i> boQ = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.boO = new a(context);
        this.boP = new b(context);
        t Tt = t.Tt();
        this.boR = Tt.getLong("ubc_last_upload_all_time", 0L);
        this.boS = Tt.getLong("ubc_last_upload_non_real", 0L);
        this.boT = Tt.getLong("ubc_reset_real_time_count_time", 0L);
        this.boU = Tt.getInt("ubc_real_time_count", 0);
        this.boY = d.SW();
        this.boY.a(this, context);
    }

    private void SM() {
        if (this.boV == null) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "BehaviorModel initCache");
            }
            this.boV = new SparseArray<>();
            this.boO.a(this.boV);
            this.boW = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.boV.size(); i2++) {
                int keyAt = this.boV.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.boW.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.boY.fo(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(i iVar) {
        boolean z = false;
        if (TextUtils.equals(iVar.getId(), iVar.Tc()) && this.boY.jH(iVar.getId()) && (iVar.getOption() & 64) == 0) {
            z = true;
        }
        if (z && !c(iVar)) {
            this.boO.a(iVar);
        } else if (Math.abs(System.currentTimeMillis() - this.boS) >= d.SW().SX()) {
            if (!z) {
                this.boQ.add(iVar);
            }
            SR();
        } else if ((iVar.getOption() & 1) == 0) {
            if (!z) {
                this.boQ.add(iVar);
            }
            if (this.boQ.size() >= 20) {
                SN();
            }
        } else if (!z) {
            this.boO.a(iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(i iVar) {
        this.boP.a(iVar, this.boY.jH(iVar.getId()));
    }

    private void SN() {
        if (this.boQ != null && this.boQ.size() != 0) {
            this.boO.G(this.boQ);
            this.boQ.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.boO.a(jVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str, int i, String str2) {
        this.boO.c(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        SN();
        this.boO.a(str, i, j, jSONArray);
        if (this.boY.jH(str)) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadRealTimeFlow ");
            }
            SO();
        }
        if (Math.abs(System.currentTimeMillis() - this.boS) >= d.SW().SX()) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            SR();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(String str, int i) {
        SN();
        this.boO.y(str, i);
        if (Math.abs(System.currentTimeMillis() - this.boS) >= d.SW().SX()) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "cancel flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            SR();
        }
    }

    private boolean c(i iVar) {
        if (cD(this.mContext) && SP()) {
            SN();
            u uVar = new u();
            uVar.cW(true);
            JSONObject Tf = iVar.Tf();
            if (Tf != null && Tf.has("bizId")) {
                q.aG(Tf);
                uVar.aI(Tf);
                uVar.g(iVar.getTime(), iVar.getTime());
                try {
                    JSONObject jSONObject = Tf.getJSONObject("content");
                    JSONObject jSONObject2 = Tf.getJSONObject("appInfo");
                    if (jSONObject != null && jSONObject2 != null) {
                        jSONObject.put("appInfo", jSONObject2);
                        Tf.remove("appInfo");
                    }
                } catch (JSONException e) {
                    if (DEBUG) {
                        Log.e("UBCBehaviorModel", "content is not a json object", e);
                    }
                }
            } else {
                try {
                    JSONObject jSONObject3 = new q(iVar.Tg()).toJSONObject();
                    jSONObject3.put("bizId", iVar.getId());
                    jSONObject3.put("timestamp", Long.toString(iVar.getTime()));
                    if (iVar.Tf() != null) {
                        jSONObject3.put("content", iVar.Tf());
                    } else {
                        jSONObject3.put("content", iVar.getContent());
                    }
                    jSONObject3.put("eventType", "0");
                    if (!TextUtils.isEmpty(iVar.Te())) {
                        jSONObject3.put(ImageViewerConfig.ABTEST, iVar.Te());
                        uVar.jV("1");
                    }
                    if (!TextUtils.isEmpty(iVar.getCategory())) {
                        jSONObject3.put("c", iVar.getCategory());
                    }
                    if (iVar.Ta()) {
                        jSONObject3.put("of", "1");
                    }
                    jSONObject3.put("idtype", this.boY.jN(iVar.getId()));
                    uVar.aI(jSONObject3);
                    uVar.g(iVar.getTime(), iVar.getTime());
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
            if (this.boV == null) {
                SM();
            }
            if (this.boV.size() > 0) {
                this.boO.a(this.boV.valueAt(0), uVar);
            }
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "UBC real time data:");
            }
            c(uVar);
            SQ();
            return true;
        }
        return false;
    }

    private void SO() {
        if (cD(this.mContext) && SP()) {
            u uVar = new u();
            uVar.cW(true);
            if (this.boV == null) {
                SM();
            }
            if (this.boV.size() > 0) {
                if (r.Ts().Fq()) {
                    this.boO.a(uVar);
                } else {
                    this.boO.a(this.boV.valueAt(0), uVar);
                }
            }
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "UBC real time flow:");
            }
            c(uVar);
            SQ();
        }
    }

    private boolean SP() {
        if (r.Ts().Fq()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.boT) > 86400000) {
            this.boU = 0;
            this.boT = currentTimeMillis;
            t.Tt().putLong("ubc_reset_real_time_count_time", this.boT);
            t.Tt().putInt("ubc_real_time_count", this.boU);
        }
        if (this.boU >= 1000) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "real time upload total count check fail");
            }
            if (this.boU == 1000) {
                this.boU++;
                if (!DEBUG) {
                    r.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
                }
            }
            return false;
        }
        return true;
    }

    private void SQ() {
        this.boU++;
        t.Tt().putInt("ubc_real_time_count", this.boU);
    }

    private void SR() {
        if (cD(this.mContext)) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", " upload no real data");
            }
            this.boS = System.currentTimeMillis();
            t.Tt().putLong("ubc_last_upload_non_real", this.boS);
            ST();
            SN();
            this.boO.SI();
            HashSet hashSet = new HashSet();
            if (this.boV == null) {
                SM();
            }
            u uVar = new u();
            uVar.cW(false);
            int i = 0;
            for (int i2 = 0; i2 < this.boV.size(); i2++) {
                int keyAt = this.boV.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.boW.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.boY.SX()) {
                        i |= this.boO.a(this.boV.valueAt(i2), uVar);
                        this.boW.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.boV.size(); i3++) {
                    int keyAt2 = this.boV.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (uVar.fs(51200)) {
                            break;
                        }
                        this.boO.a(this.boV.valueAt(i3), uVar);
                    }
                }
                if (DEBUG) {
                    Log.d("UBCBehaviorModel", "UBC non real time:");
                }
                c(uVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void SS() {
        if (cD(this.mContext) && Math.abs(System.currentTimeMillis() - this.boR) >= 3600000) {
            this.boO.SI();
            u uVar = new u();
            if (this.boO.a(uVar) != 0) {
                u uVar2 = new u();
                uVar2.g(uVar.Tz(), uVar.TA());
                uVar2.jV(uVar.Ty());
                uVar2.cW(true);
                u uVar3 = new u();
                uVar3.g(uVar.Tz(), uVar.TA());
                uVar3.jV(uVar.Ty());
                uVar3.cW(false);
                SparseArray<Integer> Tv = uVar.Tv();
                int size = Tv.size();
                for (int i = 0; i < size; i++) {
                    if (this.boY.jH(String.valueOf(Tv.valueAt(i).intValue()))) {
                        uVar2.P(Tv.keyAt(i), Tv.valueAt(i).intValue());
                    } else {
                        uVar3.P(Tv.keyAt(i), Tv.valueAt(i).intValue());
                    }
                }
                ArrayList Tw = uVar.Tw();
                int size2 = Tw.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) Tw.get(i2);
                    if (this.boY.jH(str)) {
                        uVar2.jU(str);
                    } else {
                        uVar3.jU(str);
                    }
                }
                JSONArray TB = uVar.TB();
                int length = TB.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = TB.optJSONObject(i3);
                    if (optJSONObject.has("bizId")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("bizId");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.boY.jH(str2)) {
                                uVar2.aI(optJSONObject);
                            } else {
                                uVar3.aI(optJSONObject);
                            }
                        }
                    }
                }
                if (DEBUG) {
                    Log.d("UBCBehaviorModel", "total " + uVar.TB().length() + " real size = " + uVar2.TB().length() + "   no real  = " + uVar3.TB().length());
                }
                if (uVar2.TB().length() > 0) {
                    c(uVar2);
                }
                if (uVar3.TB().length() > 0) {
                    c(uVar3);
                }
                if (DEBUG) {
                    Log.d("UBCBehaviorModel", "UBC all data:");
                }
                this.boR = System.currentTimeMillis();
                t.Tt().putLong("ubc_last_upload_all_time", this.boR);
                this.boS = this.boR;
                t.Tt().putLong("ubc_last_upload_non_real", this.boS);
            }
        }
    }

    private void c(u uVar) {
        if (!uVar.isEmpty()) {
            JSONArray Tx = uVar.Tx();
            String md5 = com.baidu.swan.c.c.toMd5(Tx.toString().getBytes(), true);
            bk(Tx.toString(), md5);
            if (DEBUG) {
                s.d(uVar);
                Log.d("UBCBehaviorModel", "save send data to file " + md5);
            }
            if (!this.boO.a(uVar.Tv(), uVar.Tw(), uVar.TC(), md5)) {
                uVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", md5);
                if (file.exists() && file.delete()) {
                    Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.boO.jD(md5);
                return;
            }
            m.Tk().b(Tx, md5);
            uVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(JSONArray jSONArray, String str) {
        if (this.boX.f(jSONArray)) {
            m.Tk().G(str, true);
        } else {
            m.Tk().G(str, false);
        }
    }

    private void ST() {
        cU(true);
        cU(false);
    }

    private void cU(boolean z) {
        u uVar = new u();
        uVar.cW(z);
        if (this.boP.a(uVar, z)) {
            JSONArray Tx = uVar.Tx();
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "checkFileData:" + Tx.toString());
            }
            this.boP.cT(z);
            m.Tk().t(Tx);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(JSONArray jSONArray) {
        if (!this.boX.f(jSONArray) && !DEBUG) {
            r.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a SU() {
        return this.boO;
    }

    @SuppressLint({"MissingPermission"})
    private boolean cD(Context context) {
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Exception e) {
            if (DEBUG) {
                Log.d("UBCBehaviorModel", "get network info error!");
            }
            networkInfo = null;
        }
        return networkInfo != null && networkInfo.isAvailable();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [877=4] */
    private void bk(String str, String str2) {
        OutputStream fileOutputStream;
        String str3 = this.mContext.getFilesDir() + File.separator + "ubcsenddir";
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(str3, str2);
        if (file2.exists()) {
            return;
        }
        OutputStream outputStream = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            outputStream = new Base64OutputStream(fileOutputStream, 0);
            outputStream.write(str.getBytes());
            outputStream.flush();
            s.jT("save to file suc");
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        } catch (Exception e3) {
            e = e3;
            outputStream = fileOutputStream;
            e.printStackTrace();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th = th2;
            outputStream = fileOutputStream;
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jF(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", str);
        if (DEBUG) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file:" + file.getAbsolutePath());
        }
        s.jT("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            s.jT("delete file suc");
        }
        this.boO.jD(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jG(String str) {
        if (DEBUG) {
            Log.d("UBCBehaviorModel", "upload file fail:" + str);
        }
        s.jT("upload file fail");
        this.boO.jE(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void SV() {
        this.boO.SJ();
    }
}
