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
/* loaded from: classes10.dex */
public class c {
    private a cAi;
    private b cAj;
    private long cAl;
    private long cAm;
    private long cAn;
    private int cAo;
    private SparseArray<ArrayList> cAp;
    private HashMap<String, Long> cAq;
    private d cAs;
    private Context mContext;
    private l cAr = s.atD().Gk();
    private List<h> cAk = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.cAi = new a(context);
        this.cAj = new b(context);
        u atE = u.atE();
        this.cAl = atE.getLong("ubc_last_upload_all_time", 0L);
        this.cAm = atE.getLong("ubc_last_upload_non_real", 0L);
        this.cAn = atE.getLong("ubc_reset_real_time_count_time", 0L);
        this.cAo = atE.getInt("ubc_real_time_count", 0);
        this.cAs = d.asS();
        this.cAs.a(this, context);
    }

    private void asH() {
        if (this.cAp == null) {
            this.cAp = new SparseArray<>();
            this.cAi.a(this.cAp);
            this.cAq = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.cAp.size(); i2++) {
                int keyAt = this.cAp.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.cAq.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.cAs.iA(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(h hVar) {
        boolean z = false;
        if (TextUtils.equals(hVar.getId(), hVar.Xi()) && this.cAs.qA(hVar.getId()) && (hVar.getOption() & 64) == 0) {
            z = true;
        }
        if (z && !c(hVar)) {
            this.cAi.a(hVar);
        } else if (Math.abs(System.currentTimeMillis() - this.cAm) >= d.asS().asT()) {
            if (!z) {
                this.cAk.add(hVar);
            }
            asM();
        } else if ((hVar.getOption() & 1) == 0) {
            if (!z) {
                this.cAk.add(hVar);
            }
            if (this.cAk.size() >= 20) {
                asI();
            }
        } else if (!z) {
            this.cAi.a(hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(h hVar) {
        this.cAj.a(hVar, this.cAs.qA(hVar.getId()));
    }

    private void asI() {
        if (this.cAk != null && this.cAk.size() != 0) {
            this.cAi.al(this.cAk);
            this.cAk.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.cAi.a(jVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(String str, int i, String str2) {
        this.cAi.e(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        asI();
        this.cAi.a(str, i, j, jSONArray);
        if (this.cAs.qA(str)) {
            asJ();
        }
        if (Math.abs(System.currentTimeMillis() - this.cAm) >= d.asS().asT()) {
            asM();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(String str, int i) {
        asI();
        this.cAi.w(str, i);
        if (Math.abs(System.currentTimeMillis() - this.cAm) >= d.asS().asT()) {
            asM();
        }
    }

    private boolean c(h hVar) {
        if (dC(this.mContext) && asK()) {
            asI();
            v vVar = new v();
            vVar.eZ(true);
            JSONObject ath = hVar.ath();
            if (ath != null && ath.has("bizId")) {
                r.ce(ath);
                vVar.cg(ath);
                vVar.q(hVar.getTime(), hVar.getTime());
                try {
                    JSONObject jSONObject = ath.getJSONObject("content");
                    JSONObject jSONObject2 = ath.getJSONObject("appInfo");
                    if (jSONObject != null && jSONObject2 != null) {
                        jSONObject.put("appInfo", jSONObject2);
                        ath.remove("appInfo");
                    }
                } catch (JSONException e) {
                }
            } else {
                try {
                    JSONObject jSONObject3 = new r(hVar.ati()).toJSONObject();
                    jSONObject3.put("bizId", hVar.getId());
                    jSONObject3.put("timestamp", Long.toString(hVar.getTime()));
                    if (hVar.ath() != null) {
                        jSONObject3.put("content", hVar.ath());
                    } else {
                        jSONObject3.put("content", hVar.getContent());
                    }
                    jSONObject3.put("eventType", "0");
                    if (!TextUtils.isEmpty(hVar.atg())) {
                        jSONObject3.put("abtest", hVar.atg());
                        vVar.qP("1");
                    }
                    if (!TextUtils.isEmpty(hVar.getCategory())) {
                        jSONObject3.put("c", hVar.getCategory());
                    }
                    if (hVar.atd()) {
                        jSONObject3.put("of", "1");
                    }
                    jSONObject3.put("idtype", this.cAs.qG(hVar.getId()));
                    vVar.cg(jSONObject3);
                    vVar.q(hVar.getTime(), hVar.getTime());
                } catch (JSONException e2) {
                }
            }
            if (this.cAp == null) {
                asH();
            }
            if (this.cAp.size() > 0) {
                this.cAi.a(this.cAp.valueAt(0), vVar);
            }
            c(vVar);
            asL();
            return true;
        }
        return false;
    }

    private void asJ() {
        if (dC(this.mContext) && asK()) {
            v vVar = new v();
            vVar.eZ(true);
            if (this.cAp == null) {
                asH();
            }
            if (this.cAp.size() > 0) {
                if (s.atD().Xb()) {
                    this.cAi.a(vVar);
                } else {
                    this.cAi.a(this.cAp.valueAt(0), vVar);
                }
            }
            c(vVar);
            asL();
        }
    }

    private boolean asK() {
        if (s.atD().Xb()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.cAn) > 86400000) {
            this.cAo = 0;
            this.cAn = currentTimeMillis;
            u.atE().putLong("ubc_reset_real_time_count_time", this.cAn);
            u.atE().putInt("ubc_real_time_count", this.cAo);
        }
        if (this.cAo >= 1000) {
            if (this.cAo == 1000) {
                this.cAo++;
                s.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void asL() {
        this.cAo++;
        u.atE().putInt("ubc_real_time_count", this.cAo);
    }

    private void asM() {
        if (dC(this.mContext)) {
            this.cAm = System.currentTimeMillis();
            u.atE().putLong("ubc_last_upload_non_real", this.cAm);
            asO();
            asI();
            this.cAi.asB();
            HashSet hashSet = new HashSet();
            if (this.cAp == null) {
                asH();
            }
            v vVar = new v();
            vVar.eZ(false);
            int i = 0;
            for (int i2 = 0; i2 < this.cAp.size(); i2++) {
                int keyAt = this.cAp.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.cAq.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.cAs.asT()) {
                        i |= this.cAi.a(this.cAp.valueAt(i2), vVar);
                        this.cAq.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.cAp.size(); i3++) {
                    int keyAt2 = this.cAp.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (vVar.iJ(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.cAi.a(this.cAp.valueAt(i3), vVar);
                    }
                }
                c(vVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void asN() {
        if (dC(this.mContext) && Math.abs(System.currentTimeMillis() - this.cAl) >= BdKVCache.MILLS_1Hour) {
            this.cAi.asB();
            v vVar = new v();
            if (this.cAi.a(vVar) != 0) {
                v vVar2 = new v();
                vVar2.q(vVar.atK(), vVar.getMaxTime());
                vVar2.qP(vVar.atJ());
                vVar2.eZ(true);
                v vVar3 = new v();
                vVar3.q(vVar.atK(), vVar.getMaxTime());
                vVar3.qP(vVar.atJ());
                vVar3.eZ(false);
                SparseArray<Integer> atG = vVar.atG();
                int size = atG.size();
                for (int i = 0; i < size; i++) {
                    if (this.cAs.qA(String.valueOf(atG.valueAt(i).intValue()))) {
                        vVar2.at(atG.keyAt(i), atG.valueAt(i).intValue());
                    } else {
                        vVar3.at(atG.keyAt(i), atG.valueAt(i).intValue());
                    }
                }
                ArrayList atH = vVar.atH();
                int size2 = atH.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) atH.get(i2);
                    if (this.cAs.qA(str)) {
                        vVar2.qO(str);
                    } else {
                        vVar3.qO(str);
                    }
                }
                JSONArray atL = vVar.atL();
                int length = atL.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = atL.optJSONObject(i3);
                    if (optJSONObject.has("bizId")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("bizId");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.cAs.qA(str2)) {
                                vVar2.cg(optJSONObject);
                            } else {
                                vVar3.cg(optJSONObject);
                            }
                        }
                    }
                }
                if (vVar2.atL().length() > 0) {
                    c(vVar2);
                }
                if (vVar3.atL().length() > 0) {
                    c(vVar3);
                }
                this.cAl = System.currentTimeMillis();
                u.atE().putLong("ubc_last_upload_all_time", this.cAl);
                this.cAm = this.cAl;
                u.atE().putLong("ubc_last_upload_non_real", this.cAm);
            }
        }
    }

    private void c(v vVar) {
        if (!vVar.isEmpty()) {
            JSONArray atI = vVar.atI();
            String md5 = com.baidu.swan.d.d.toMd5(atI.toString().getBytes(), true);
            bZ(atI.toString(), md5);
            this.cAi.Q(md5, vVar.atM());
            if (!this.cAi.a(vVar.atG(), vVar.atH(), vVar.atM(), md5)) {
                vVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", md5);
                if (file.exists() && file.delete()) {
                    Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.cAi.qv(md5);
                return;
            }
            m.atp().c(atI, md5);
            vVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(JSONArray jSONArray, String str) {
        if (this.cAr.E(jSONArray)) {
            m.atp().R(str, true);
        } else {
            m.atp().R(str, false);
        }
    }

    private void asO() {
        eW(true);
        eW(false);
    }

    private void eW(boolean z) {
        v vVar = new v();
        vVar.eZ(z);
        if (this.cAj.a(vVar, z)) {
            JSONArray atI = vVar.atI();
            this.cAj.eV(z);
            m.atp().H(atI);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(JSONArray jSONArray) {
        if (!this.cAr.E(jSONArray)) {
            s.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a asP() {
        return this.cAi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(p pVar) {
        this.cAs.an(pVar.atx());
        this.cAs.iB(pVar.atw() * DateTimeUtil.TIME_DAY_MILLISECOND);
        this.cAs.iC(pVar.atv());
        u.atE().putString("ubc_version_md5", pVar.getSign());
        this.cAi.am(pVar.atx());
        pVar.atx().clear();
        if (this.cAp == null) {
            this.cAp = new SparseArray<>();
        }
        this.cAp.clear();
        if (this.cAq == null) {
            this.cAq = new HashMap<>();
        }
        this.cAq.clear();
        this.cAi.a(this.cAp);
        int i = 0;
        for (int i2 = 0; i2 < this.cAp.size(); i2++) {
            int keyAt = this.cAp.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.cAq.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.cAs.iA(i);
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

    private void bZ(String str, String str2) {
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
                t.qN("save to file suc");
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
    public void qx(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", str);
        t.qN("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            t.qN("delete file suc");
        }
        this.cAi.qv(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void qy(String str) {
        t.qN("upload file fail");
        this.cAi.qw(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void asQ() {
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
                    this.cAi.asC();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    i qu = this.cAi.qu(listFiles[i].getName());
                    if (qu != null && TextUtils.equals("0", qu.atk())) {
                        t.qN("processFailedData file, no need to send");
                    } else if (qu != null && TextUtils.equals("1", qu.atk())) {
                        t.qN("processFailedData file, send");
                        this.cAi.bY(listFiles[i].getName(), "0");
                        qz(listFiles[i].getName());
                    } else {
                        t.qN("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    void qz(String str) {
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
                                m.atp().c(new JSONArray(com.baidu.swan.d.g.getStringFromInput(inputStream2)), str);
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
    public void asR() {
        this.cAi.asD();
    }
}
