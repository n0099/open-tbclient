package com.baidu.swan.ubc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Base64InputStream;
import android.util.Base64OutputStream;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.android.util.time.DateTimeUtil;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class c {
    private long cAa;
    private long cAb;
    private long cAc;
    private int cAd;
    private SparseArray<ArrayList> cAe;
    private HashMap<String, Long> cAf;
    private d cAh;
    private a czX;
    private b czY;
    private Context mContext;
    private l cAg = s.atk().FO();
    private List<h> czZ = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.czX = new a(context);
        this.czY = new b(context);
        u atl = u.atl();
        this.cAa = atl.getLong("ubc_last_upload_all_time", 0L);
        this.cAb = atl.getLong("ubc_last_upload_non_real", 0L);
        this.cAc = atl.getLong("ubc_reset_real_time_count_time", 0L);
        this.cAd = atl.getInt("ubc_real_time_count", 0);
        this.cAh = d.asz();
        this.cAh.a(this, context);
    }

    private void aso() {
        if (this.cAe == null) {
            this.cAe = new SparseArray<>();
            this.czX.a(this.cAe);
            this.cAf = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.cAe.size(); i2++) {
                int keyAt = this.cAe.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.cAf.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.cAh.iA(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(h hVar) {
        boolean z = false;
        if (TextUtils.equals(hVar.getId(), hVar.WL()) && this.cAh.qx(hVar.getId()) && (hVar.getOption() & 64) == 0) {
            z = true;
        }
        if (z && !c(hVar)) {
            this.czX.a(hVar);
        } else if (Math.abs(System.currentTimeMillis() - this.cAb) >= d.asz().asA()) {
            if (!z) {
                this.czZ.add(hVar);
            }
            ast();
        } else if ((hVar.getOption() & 1) == 0) {
            if (!z) {
                this.czZ.add(hVar);
            }
            if (this.czZ.size() >= 20) {
                asp();
            }
        } else if (!z) {
            this.czX.a(hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(h hVar) {
        this.czY.a(hVar, this.cAh.qx(hVar.getId()));
    }

    private void asp() {
        if (this.czZ != null && this.czZ.size() != 0) {
            this.czX.am(this.czZ);
            this.czZ.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.czX.a(jVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(String str, int i, String str2) {
        this.czX.e(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        asp();
        this.czX.a(str, i, j, jSONArray);
        if (this.cAh.qx(str)) {
            asq();
        }
        if (Math.abs(System.currentTimeMillis() - this.cAb) >= d.asz().asA()) {
            ast();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(String str, int i) {
        asp();
        this.czX.w(str, i);
        if (Math.abs(System.currentTimeMillis() - this.cAb) >= d.asz().asA()) {
            ast();
        }
    }

    private boolean c(h hVar) {
        if (dC(this.mContext) && asr()) {
            asp();
            v vVar = new v();
            vVar.eU(true);
            JSONObject asO = hVar.asO();
            if (asO != null && asO.has("bizId")) {
                r.ce(asO);
                vVar.cg(asO);
                vVar.q(hVar.getTime(), hVar.getTime());
                try {
                    JSONObject jSONObject = asO.getJSONObject("content");
                    JSONObject jSONObject2 = asO.getJSONObject("appInfo");
                    if (jSONObject != null && jSONObject2 != null) {
                        jSONObject.put("appInfo", jSONObject2);
                        asO.remove("appInfo");
                    }
                } catch (JSONException e) {
                }
            } else {
                try {
                    JSONObject jSONObject3 = new r(hVar.asP()).toJSONObject();
                    jSONObject3.put("bizId", hVar.getId());
                    jSONObject3.put("timestamp", Long.toString(hVar.getTime()));
                    if (hVar.asO() != null) {
                        jSONObject3.put("content", hVar.asO());
                    } else {
                        jSONObject3.put("content", hVar.getContent());
                    }
                    jSONObject3.put("eventType", "0");
                    if (!TextUtils.isEmpty(hVar.asN())) {
                        jSONObject3.put("abtest", hVar.asN());
                        vVar.qM("1");
                    }
                    if (!TextUtils.isEmpty(hVar.getCategory())) {
                        jSONObject3.put("c", hVar.getCategory());
                    }
                    if (hVar.asK()) {
                        jSONObject3.put("of", "1");
                    }
                    jSONObject3.put("idtype", this.cAh.qD(hVar.getId()));
                    vVar.cg(jSONObject3);
                    vVar.q(hVar.getTime(), hVar.getTime());
                } catch (JSONException e2) {
                }
            }
            if (this.cAe == null) {
                aso();
            }
            if (this.cAe.size() > 0) {
                this.czX.a(this.cAe.valueAt(0), vVar);
            }
            c(vVar);
            ass();
            return true;
        }
        return false;
    }

    private void asq() {
        if (dC(this.mContext) && asr()) {
            v vVar = new v();
            vVar.eU(true);
            if (this.cAe == null) {
                aso();
            }
            if (this.cAe.size() > 0) {
                if (s.atk().WE()) {
                    this.czX.a(vVar);
                } else {
                    this.czX.a(this.cAe.valueAt(0), vVar);
                }
            }
            c(vVar);
            ass();
        }
    }

    private boolean asr() {
        if (s.atk().WE()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.cAc) > 86400000) {
            this.cAd = 0;
            this.cAc = currentTimeMillis;
            u.atl().putLong("ubc_reset_real_time_count_time", this.cAc);
            u.atl().putInt("ubc_real_time_count", this.cAd);
        }
        if (this.cAd >= 1000) {
            if (this.cAd == 1000) {
                this.cAd++;
                s.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void ass() {
        this.cAd++;
        u.atl().putInt("ubc_real_time_count", this.cAd);
    }

    private void ast() {
        if (dC(this.mContext)) {
            this.cAb = System.currentTimeMillis();
            u.atl().putLong("ubc_last_upload_non_real", this.cAb);
            asv();
            asp();
            this.czX.asi();
            HashSet hashSet = new HashSet();
            if (this.cAe == null) {
                aso();
            }
            v vVar = new v();
            vVar.eU(false);
            int i = 0;
            for (int i2 = 0; i2 < this.cAe.size(); i2++) {
                int keyAt = this.cAe.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.cAf.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.cAh.asA()) {
                        i |= this.czX.a(this.cAe.valueAt(i2), vVar);
                        this.cAf.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.cAe.size(); i3++) {
                    int keyAt2 = this.cAe.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (vVar.iJ(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.czX.a(this.cAe.valueAt(i3), vVar);
                    }
                }
                c(vVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void asu() {
        if (dC(this.mContext) && Math.abs(System.currentTimeMillis() - this.cAa) >= BdKVCache.MILLS_1Hour) {
            this.czX.asi();
            v vVar = new v();
            if (this.czX.a(vVar) != 0) {
                v vVar2 = new v();
                vVar2.q(vVar.atr(), vVar.getMaxTime());
                vVar2.qM(vVar.atq());
                vVar2.eU(true);
                v vVar3 = new v();
                vVar3.q(vVar.atr(), vVar.getMaxTime());
                vVar3.qM(vVar.atq());
                vVar3.eU(false);
                SparseArray<Integer> atn = vVar.atn();
                int size = atn.size();
                for (int i = 0; i < size; i++) {
                    if (this.cAh.qx(String.valueOf(atn.valueAt(i).intValue()))) {
                        vVar2.ap(atn.keyAt(i), atn.valueAt(i).intValue());
                    } else {
                        vVar3.ap(atn.keyAt(i), atn.valueAt(i).intValue());
                    }
                }
                ArrayList ato = vVar.ato();
                int size2 = ato.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) ato.get(i2);
                    if (this.cAh.qx(str)) {
                        vVar2.qL(str);
                    } else {
                        vVar3.qL(str);
                    }
                }
                JSONArray ats = vVar.ats();
                int length = ats.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = ats.optJSONObject(i3);
                    if (optJSONObject.has("bizId")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("bizId");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.cAh.qx(str2)) {
                                vVar2.cg(optJSONObject);
                            } else {
                                vVar3.cg(optJSONObject);
                            }
                        }
                    }
                }
                if (vVar2.ats().length() > 0) {
                    c(vVar2);
                }
                if (vVar3.ats().length() > 0) {
                    c(vVar3);
                }
                this.cAa = System.currentTimeMillis();
                u.atl().putLong("ubc_last_upload_all_time", this.cAa);
                this.cAb = this.cAa;
                u.atl().putLong("ubc_last_upload_non_real", this.cAb);
            }
        }
    }

    private void c(v vVar) {
        if (!vVar.isEmpty()) {
            JSONArray atp = vVar.atp();
            String md5 = com.baidu.swan.d.d.toMd5(atp.toString().getBytes(), true);
            bY(atp.toString(), md5);
            this.czX.Q(md5, vVar.att());
            if (!this.czX.a(vVar.atn(), vVar.ato(), vVar.att(), md5)) {
                vVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", md5);
                if (file.exists() && file.delete()) {
                    Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.czX.qs(md5);
                return;
            }
            m.asW().c(atp, md5);
            vVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(JSONArray jSONArray, String str) {
        if (this.cAg.D(jSONArray)) {
            m.asW().R(str, true);
        } else {
            m.asW().R(str, false);
        }
    }

    private void asv() {
        eR(true);
        eR(false);
    }

    private void eR(boolean z) {
        v vVar = new v();
        vVar.eU(z);
        if (this.czY.a(vVar, z)) {
            JSONArray atp = vVar.atp();
            this.czY.eQ(z);
            m.asW().G(atp);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(JSONArray jSONArray) {
        if (!this.cAg.D(jSONArray)) {
            s.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a asw() {
        return this.czX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(p pVar) {
        this.cAh.ao(pVar.ate());
        this.cAh.iB(pVar.atd() * DateTimeUtil.TIME_DAY_MILLISECOND);
        this.cAh.iC(pVar.atc());
        u.atl().putString("ubc_version_md5", pVar.getSign());
        this.czX.an(pVar.ate());
        pVar.ate().clear();
        if (this.cAe == null) {
            this.cAe = new SparseArray<>();
        }
        this.cAe.clear();
        if (this.cAf == null) {
            this.cAf = new HashMap<>();
        }
        this.cAf.clear();
        this.czX.a(this.cAe);
        int i = 0;
        for (int i2 = 0; i2 < this.cAe.size(); i2++) {
            int keyAt = this.cAe.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.cAf.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.cAh.iA(i);
    }

    @SuppressLint({"MissingPermission"})
    private boolean dC(Context context) {
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

    private void bY(String str, String str2) {
        OutputStream fileOutputStream;
        String str3 = this.mContext.getFilesDir() + File.separator + "statistics_data";
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(str3, str2);
        if (!file2.exists()) {
            OutputStream outputStream = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            }
            try {
                outputStream = new Base64OutputStream(fileOutputStream, 0);
                outputStream.write(str.getBytes());
                outputStream.flush();
                t.qK("save to file suc");
                com.baidu.swan.d.c.closeSafely(outputStream);
            } catch (Exception e2) {
                e = e2;
                outputStream = fileOutputStream;
                e.printStackTrace();
                com.baidu.swan.d.c.closeSafely(outputStream);
            } catch (Throwable th2) {
                th = th2;
                outputStream = fileOutputStream;
                com.baidu.swan.d.c.closeSafely(outputStream);
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void qu(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", str);
        t.qK("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            t.qK("delete file suc");
        }
        this.czX.qs(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void qv(String str) {
        t.qK("upload file fail");
        this.czX.qt(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void asx() {
        File[] listFiles;
        if (dC(this.mContext)) {
            File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data");
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                if (listFiles.length > 50) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "del_file");
                        jSONObject.put("del_file_size", listFiles.length);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    s.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, jSONObject.toString());
                    for (File file2 : listFiles) {
                        file2.delete();
                    }
                    this.czX.asj();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    i qr = this.czX.qr(listFiles[i].getName());
                    if (qr != null && TextUtils.equals("0", qr.asR())) {
                        t.qK("processFailedData file, no need to send");
                    } else if (qr != null && TextUtils.equals("1", qr.asR())) {
                        t.qK("processFailedData file, send");
                        this.czX.bX(listFiles[i].getName(), "0");
                        qw(listFiles[i].getName());
                    } else {
                        t.qK("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    void qw(String str) {
        InputStream inputStream;
        Throwable th;
        InputStream inputStream2 = null;
        try {
            try {
                inputStream = new FileInputStream(new File(this.mContext.getFilesDir() + File.separator + "statistics_data", str));
                if (inputStream != null) {
                    try {
                        if (inputStream.available() > 0) {
                            inputStream2 = new Base64InputStream(inputStream, 0);
                            try {
                                m.asW().c(new JSONArray(com.baidu.swan.d.g.getStringFromInput(inputStream2)), str);
                                com.baidu.swan.d.c.closeSafely(inputStream2);
                            } catch (Throwable th2) {
                                inputStream = inputStream2;
                                th = th2;
                                com.baidu.swan.d.c.closeSafely(inputStream);
                                throw th;
                            }
                        }
                    } catch (Exception e) {
                        inputStream2 = inputStream;
                        com.baidu.swan.d.c.closeSafely(inputStream2);
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                inputStream2 = inputStream;
                com.baidu.swan.d.c.closeSafely(inputStream2);
            } catch (Throwable th4) {
                inputStream = null;
                th = th4;
            }
        } catch (Exception e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void asy() {
        this.czX.ask();
    }
}
