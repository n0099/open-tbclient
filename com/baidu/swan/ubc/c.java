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
    private a boP;
    private b boQ;
    private long boS;
    private long boT;
    private long boU;
    private int boV;
    private SparseArray<ArrayList> boW;
    private HashMap<String, Long> boX;
    private d boZ;
    private Context mContext;
    private k boY = q.Ts().uY();
    private List<h> boR = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.boP = new a(context);
        this.boQ = new b(context);
        s Tt = s.Tt();
        this.boS = Tt.getLong("ubc_last_upload_all_time", 0L);
        this.boT = Tt.getLong("ubc_last_upload_non_real", 0L);
        this.boU = Tt.getLong("ubc_reset_real_time_count_time", 0L);
        this.boV = Tt.getInt("ubc_real_time_count", 0);
        this.boZ = d.SW();
        this.boZ.a(this, context);
    }

    private void SM() {
        if (this.boW == null) {
            this.boW = new SparseArray<>();
            this.boP.a(this.boW);
            this.boX = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.boW.size(); i2++) {
                int keyAt = this.boW.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.boX.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.boZ.fo(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(h hVar) {
        boolean z = false;
        if (TextUtils.equals(hVar.getId(), hVar.Tc()) && this.boZ.jH(hVar.getId()) && (hVar.getOption() & 64) == 0) {
            z = true;
        }
        if (z && !c(hVar)) {
            this.boP.a(hVar);
        } else if (Math.abs(System.currentTimeMillis() - this.boT) >= d.SW().SX()) {
            if (!z) {
                this.boR.add(hVar);
            }
            SR();
        } else if ((hVar.getOption() & 1) == 0) {
            if (!z) {
                this.boR.add(hVar);
            }
            if (this.boR.size() >= 20) {
                SN();
            }
        } else if (!z) {
            this.boP.a(hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(h hVar) {
        this.boQ.a(hVar, this.boZ.jH(hVar.getId()));
    }

    private void SN() {
        if (this.boR != null && this.boR.size() != 0) {
            this.boP.G(this.boR);
            this.boR.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(i iVar) {
        this.boP.a(iVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str, int i, String str2) {
        this.boP.c(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        SN();
        this.boP.a(str, i, j, jSONArray);
        if (this.boZ.jH(str)) {
            SO();
        }
        if (Math.abs(System.currentTimeMillis() - this.boT) >= d.SW().SX()) {
            SR();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(String str, int i) {
        SN();
        this.boP.y(str, i);
        if (Math.abs(System.currentTimeMillis() - this.boT) >= d.SW().SX()) {
            SR();
        }
    }

    private boolean c(h hVar) {
        if (cD(this.mContext) && SP()) {
            SN();
            t tVar = new t();
            tVar.cW(true);
            JSONObject Tf = hVar.Tf();
            if (Tf != null && Tf.has("bizId")) {
                p.aG(Tf);
                tVar.aI(Tf);
                tVar.g(hVar.getTime(), hVar.getTime());
                try {
                    JSONObject jSONObject = Tf.getJSONObject("content");
                    JSONObject jSONObject2 = Tf.getJSONObject("appInfo");
                    if (jSONObject != null && jSONObject2 != null) {
                        jSONObject.put("appInfo", jSONObject2);
                        Tf.remove("appInfo");
                    }
                } catch (JSONException e) {
                }
            } else {
                try {
                    JSONObject jSONObject3 = new p(hVar.Tg()).toJSONObject();
                    jSONObject3.put("bizId", hVar.getId());
                    jSONObject3.put("timestamp", Long.toString(hVar.getTime()));
                    if (hVar.Tf() != null) {
                        jSONObject3.put("content", hVar.Tf());
                    } else {
                        jSONObject3.put("content", hVar.getContent());
                    }
                    jSONObject3.put("eventType", "0");
                    if (!TextUtils.isEmpty(hVar.Te())) {
                        jSONObject3.put(ImageViewerConfig.ABTEST, hVar.Te());
                        tVar.jV("1");
                    }
                    if (!TextUtils.isEmpty(hVar.getCategory())) {
                        jSONObject3.put("c", hVar.getCategory());
                    }
                    if (hVar.Ta()) {
                        jSONObject3.put("of", "1");
                    }
                    jSONObject3.put("idtype", this.boZ.jN(hVar.getId()));
                    tVar.aI(jSONObject3);
                    tVar.g(hVar.getTime(), hVar.getTime());
                } catch (JSONException e2) {
                }
            }
            if (this.boW == null) {
                SM();
            }
            if (this.boW.size() > 0) {
                this.boP.a(this.boW.valueAt(0), tVar);
            }
            c(tVar);
            SQ();
            return true;
        }
        return false;
    }

    private void SO() {
        if (cD(this.mContext) && SP()) {
            t tVar = new t();
            tVar.cW(true);
            if (this.boW == null) {
                SM();
            }
            if (this.boW.size() > 0) {
                if (q.Ts().Fq()) {
                    this.boP.a(tVar);
                } else {
                    this.boP.a(this.boW.valueAt(0), tVar);
                }
            }
            c(tVar);
            SQ();
        }
    }

    private boolean SP() {
        if (q.Ts().Fq()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.boU) > 86400000) {
            this.boV = 0;
            this.boU = currentTimeMillis;
            s.Tt().putLong("ubc_reset_real_time_count_time", this.boU);
            s.Tt().putInt("ubc_real_time_count", this.boV);
        }
        if (this.boV >= 1000) {
            if (this.boV == 1000) {
                this.boV++;
                q.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void SQ() {
        this.boV++;
        s.Tt().putInt("ubc_real_time_count", this.boV);
    }

    private void SR() {
        if (cD(this.mContext)) {
            this.boT = System.currentTimeMillis();
            s.Tt().putLong("ubc_last_upload_non_real", this.boT);
            ST();
            SN();
            this.boP.SI();
            HashSet hashSet = new HashSet();
            if (this.boW == null) {
                SM();
            }
            t tVar = new t();
            tVar.cW(false);
            int i = 0;
            for (int i2 = 0; i2 < this.boW.size(); i2++) {
                int keyAt = this.boW.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.boX.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.boZ.SX()) {
                        i |= this.boP.a(this.boW.valueAt(i2), tVar);
                        this.boX.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.boW.size(); i3++) {
                    int keyAt2 = this.boW.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (tVar.fs(51200)) {
                            break;
                        }
                        this.boP.a(this.boW.valueAt(i3), tVar);
                    }
                }
                c(tVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void SS() {
        if (cD(this.mContext) && Math.abs(System.currentTimeMillis() - this.boS) >= 3600000) {
            this.boP.SI();
            t tVar = new t();
            if (this.boP.a(tVar) != 0) {
                t tVar2 = new t();
                tVar2.g(tVar.Tz(), tVar.TA());
                tVar2.jV(tVar.Ty());
                tVar2.cW(true);
                t tVar3 = new t();
                tVar3.g(tVar.Tz(), tVar.TA());
                tVar3.jV(tVar.Ty());
                tVar3.cW(false);
                SparseArray<Integer> Tv = tVar.Tv();
                int size = Tv.size();
                for (int i = 0; i < size; i++) {
                    if (this.boZ.jH(String.valueOf(Tv.valueAt(i).intValue()))) {
                        tVar2.P(Tv.keyAt(i), Tv.valueAt(i).intValue());
                    } else {
                        tVar3.P(Tv.keyAt(i), Tv.valueAt(i).intValue());
                    }
                }
                ArrayList Tw = tVar.Tw();
                int size2 = Tw.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) Tw.get(i2);
                    if (this.boZ.jH(str)) {
                        tVar2.jU(str);
                    } else {
                        tVar3.jU(str);
                    }
                }
                JSONArray TB = tVar.TB();
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
                            if (this.boZ.jH(str2)) {
                                tVar2.aI(optJSONObject);
                            } else {
                                tVar3.aI(optJSONObject);
                            }
                        }
                    }
                }
                if (tVar2.TB().length() > 0) {
                    c(tVar2);
                }
                if (tVar3.TB().length() > 0) {
                    c(tVar3);
                }
                this.boS = System.currentTimeMillis();
                s.Tt().putLong("ubc_last_upload_all_time", this.boS);
                this.boT = this.boS;
                s.Tt().putLong("ubc_last_upload_non_real", this.boT);
            }
        }
    }

    private void c(t tVar) {
        if (!tVar.isEmpty()) {
            JSONArray Tx = tVar.Tx();
            String md5 = com.baidu.swan.c.c.toMd5(Tx.toString().getBytes(), true);
            bk(Tx.toString(), md5);
            if (!this.boP.a(tVar.Tv(), tVar.Tw(), tVar.TC(), md5)) {
                tVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", md5);
                if (file.exists() && file.delete()) {
                    Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.boP.jD(md5);
                return;
            }
            l.Tk().b(Tx, md5);
            tVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(JSONArray jSONArray, String str) {
        if (this.boY.f(jSONArray)) {
            l.Tk().G(str, true);
        } else {
            l.Tk().G(str, false);
        }
    }

    private void ST() {
        cU(true);
        cU(false);
    }

    private void cU(boolean z) {
        t tVar = new t();
        tVar.cW(z);
        if (this.boQ.a(tVar, z)) {
            JSONArray Tx = tVar.Tx();
            this.boQ.cT(z);
            l.Tk().t(Tx);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(JSONArray jSONArray) {
        if (!this.boY.f(jSONArray)) {
            q.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a SU() {
        return this.boP;
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
            r.jT("save to file suc");
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
        r.jT("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            r.jT("delete file suc");
        }
        this.boP.jD(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jG(String str) {
        r.jT("upload file fail");
        this.boP.jE(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void SV() {
        this.boP.SJ();
    }
}
