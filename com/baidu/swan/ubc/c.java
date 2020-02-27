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
/* loaded from: classes11.dex */
public class c {
    private a cEg;
    private b cEh;
    private long cEj;
    private long cEk;
    private long cEl;
    private int cEm;
    private SparseArray<ArrayList> cEn;
    private HashMap<String, Long> cEo;
    private d cEq;
    private Context mContext;
    private l cEp = s.avR().Iz();
    private List<h> cEi = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.cEg = new a(context);
        this.cEh = new b(context);
        u avS = u.avS();
        this.cEj = avS.getLong("ubc_last_upload_all_time", 0L);
        this.cEk = avS.getLong("ubc_last_upload_non_real", 0L);
        this.cEl = avS.getLong("ubc_reset_real_time_count_time", 0L);
        this.cEm = avS.getInt("ubc_real_time_count", 0);
        this.cEq = d.avg();
        this.cEq.a(this, context);
    }

    private void auV() {
        if (this.cEn == null) {
            this.cEn = new SparseArray<>();
            this.cEg.a(this.cEn);
            this.cEo = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.cEn.size(); i2++) {
                int keyAt = this.cEn.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.cEo.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.cEq.iR(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(h hVar) {
        boolean z = false;
        if (TextUtils.equals(hVar.getId(), hVar.Zw()) && this.cEq.qP(hVar.getId()) && (hVar.getOption() & 64) == 0) {
            z = true;
        }
        if (z && !c(hVar)) {
            this.cEg.a(hVar);
        } else if (Math.abs(System.currentTimeMillis() - this.cEk) >= d.avg().avh()) {
            if (!z) {
                this.cEi.add(hVar);
            }
            ava();
        } else if ((hVar.getOption() & 1) == 0) {
            if (!z) {
                this.cEi.add(hVar);
            }
            if (this.cEi.size() >= 20) {
                auW();
            }
        } else if (!z) {
            this.cEg.a(hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(h hVar) {
        this.cEh.a(hVar, this.cEq.qP(hVar.getId()));
    }

    private void auW() {
        if (this.cEi != null && this.cEi.size() != 0) {
            this.cEg.al(this.cEi);
            this.cEi.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.cEg.a(jVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, int i, String str2) {
        this.cEg.f(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        auW();
        this.cEg.a(str, i, j, jSONArray);
        if (this.cEq.qP(str)) {
            auX();
        }
        if (Math.abs(System.currentTimeMillis() - this.cEk) >= d.avg().avh()) {
            ava();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(String str, int i) {
        auW();
        this.cEg.u(str, i);
        if (Math.abs(System.currentTimeMillis() - this.cEk) >= d.avg().avh()) {
            ava();
        }
    }

    private boolean c(h hVar) {
        if (dG(this.mContext) && auY()) {
            auW();
            v vVar = new v();
            vVar.fg(true);
            JSONObject avv = hVar.avv();
            if (avv != null && avv.has("bizId")) {
                r.ce(avv);
                vVar.cg(avv);
                vVar.q(hVar.getTime(), hVar.getTime());
                try {
                    JSONObject jSONObject = avv.getJSONObject("content");
                    JSONObject jSONObject2 = avv.getJSONObject("appInfo");
                    if (jSONObject != null && jSONObject2 != null) {
                        jSONObject.put("appInfo", jSONObject2);
                        avv.remove("appInfo");
                    }
                } catch (JSONException e) {
                }
            } else {
                try {
                    JSONObject jSONObject3 = new r(hVar.avw()).toJSONObject();
                    jSONObject3.put("bizId", hVar.getId());
                    jSONObject3.put("timestamp", Long.toString(hVar.getTime()));
                    if (hVar.avv() != null) {
                        jSONObject3.put("content", hVar.avv());
                    } else {
                        jSONObject3.put("content", hVar.getContent());
                    }
                    jSONObject3.put("eventType", "0");
                    if (!TextUtils.isEmpty(hVar.avu())) {
                        jSONObject3.put("abtest", hVar.avu());
                        vVar.re("1");
                    }
                    if (!TextUtils.isEmpty(hVar.getCategory())) {
                        jSONObject3.put("c", hVar.getCategory());
                    }
                    if (hVar.avr()) {
                        jSONObject3.put("of", "1");
                    }
                    jSONObject3.put("idtype", this.cEq.qV(hVar.getId()));
                    vVar.cg(jSONObject3);
                    vVar.q(hVar.getTime(), hVar.getTime());
                } catch (JSONException e2) {
                }
            }
            if (this.cEn == null) {
                auV();
            }
            if (this.cEn.size() > 0) {
                this.cEg.a(this.cEn.valueAt(0), vVar);
            }
            c(vVar);
            auZ();
            return true;
        }
        return false;
    }

    private void auX() {
        if (dG(this.mContext) && auY()) {
            v vVar = new v();
            vVar.fg(true);
            if (this.cEn == null) {
                auV();
            }
            if (this.cEn.size() > 0) {
                if (s.avR().Zp()) {
                    this.cEg.a(vVar);
                } else {
                    this.cEg.a(this.cEn.valueAt(0), vVar);
                }
            }
            c(vVar);
            auZ();
        }
    }

    private boolean auY() {
        if (s.avR().Zp()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.cEl) > 86400000) {
            this.cEm = 0;
            this.cEl = currentTimeMillis;
            u.avS().putLong("ubc_reset_real_time_count_time", this.cEl);
            u.avS().putInt("ubc_real_time_count", this.cEm);
        }
        if (this.cEm >= 1000) {
            if (this.cEm == 1000) {
                this.cEm++;
                s.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void auZ() {
        this.cEm++;
        u.avS().putInt("ubc_real_time_count", this.cEm);
    }

    private void ava() {
        if (dG(this.mContext)) {
            this.cEk = System.currentTimeMillis();
            u.avS().putLong("ubc_last_upload_non_real", this.cEk);
            avc();
            auW();
            this.cEg.auP();
            HashSet hashSet = new HashSet();
            if (this.cEn == null) {
                auV();
            }
            v vVar = new v();
            vVar.fg(false);
            int i = 0;
            for (int i2 = 0; i2 < this.cEn.size(); i2++) {
                int keyAt = this.cEn.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.cEo.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.cEq.avh()) {
                        i |= this.cEg.a(this.cEn.valueAt(i2), vVar);
                        this.cEo.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.cEn.size(); i3++) {
                    int keyAt2 = this.cEn.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (vVar.ja(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.cEg.a(this.cEn.valueAt(i3), vVar);
                    }
                }
                c(vVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void avb() {
        if (dG(this.mContext) && Math.abs(System.currentTimeMillis() - this.cEj) >= BdKVCache.MILLS_1Hour) {
            this.cEg.auP();
            v vVar = new v();
            if (this.cEg.a(vVar) != 0) {
                v vVar2 = new v();
                vVar2.q(vVar.avY(), vVar.getMaxTime());
                vVar2.re(vVar.avX());
                vVar2.fg(true);
                v vVar3 = new v();
                vVar3.q(vVar.avY(), vVar.getMaxTime());
                vVar3.re(vVar.avX());
                vVar3.fg(false);
                SparseArray<Integer> avU = vVar.avU();
                int size = avU.size();
                for (int i = 0; i < size; i++) {
                    if (this.cEq.qP(String.valueOf(avU.valueAt(i).intValue()))) {
                        vVar2.at(avU.keyAt(i), avU.valueAt(i).intValue());
                    } else {
                        vVar3.at(avU.keyAt(i), avU.valueAt(i).intValue());
                    }
                }
                ArrayList avV = vVar.avV();
                int size2 = avV.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) avV.get(i2);
                    if (this.cEq.qP(str)) {
                        vVar2.rd(str);
                    } else {
                        vVar3.rd(str);
                    }
                }
                JSONArray avZ = vVar.avZ();
                int length = avZ.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = avZ.optJSONObject(i3);
                    if (optJSONObject.has("bizId")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("bizId");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.cEq.qP(str2)) {
                                vVar2.cg(optJSONObject);
                            } else {
                                vVar3.cg(optJSONObject);
                            }
                        }
                    }
                }
                if (vVar2.avZ().length() > 0) {
                    c(vVar2);
                }
                if (vVar3.avZ().length() > 0) {
                    c(vVar3);
                }
                this.cEj = System.currentTimeMillis();
                u.avS().putLong("ubc_last_upload_all_time", this.cEj);
                this.cEk = this.cEj;
                u.avS().putLong("ubc_last_upload_non_real", this.cEk);
            }
        }
    }

    private void c(v vVar) {
        if (!vVar.isEmpty()) {
            JSONArray avW = vVar.avW();
            String md5 = com.baidu.swan.d.d.toMd5(avW.toString().getBytes(), true);
            ci(avW.toString(), md5);
            this.cEg.Q(md5, vVar.awa());
            if (!this.cEg.a(vVar.avU(), vVar.avV(), vVar.awa(), md5)) {
                vVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", md5);
                if (file.exists() && file.delete()) {
                    Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.cEg.qK(md5);
                return;
            }
            m.avD().c(avW, md5);
            vVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(JSONArray jSONArray, String str) {
        if (this.cEp.E(jSONArray)) {
            m.avD().R(str, true);
        } else {
            m.avD().R(str, false);
        }
    }

    private void avc() {
        fd(true);
        fd(false);
    }

    private void fd(boolean z) {
        v vVar = new v();
        vVar.fg(z);
        if (this.cEh.a(vVar, z)) {
            JSONArray avW = vVar.avW();
            this.cEh.fc(z);
            m.avD().H(avW);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(JSONArray jSONArray) {
        if (!this.cEp.E(jSONArray)) {
            s.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a avd() {
        return this.cEg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(p pVar) {
        this.cEq.an(pVar.avL());
        this.cEq.iS(pVar.avK() * DateTimeUtil.TIME_DAY_MILLISECOND);
        this.cEq.iT(pVar.avJ());
        u.avS().putString("ubc_version_md5", pVar.getSign());
        this.cEg.am(pVar.avL());
        pVar.avL().clear();
        if (this.cEn == null) {
            this.cEn = new SparseArray<>();
        }
        this.cEn.clear();
        if (this.cEo == null) {
            this.cEo = new HashMap<>();
        }
        this.cEo.clear();
        this.cEg.a(this.cEn);
        int i = 0;
        for (int i2 = 0; i2 < this.cEn.size(); i2++) {
            int keyAt = this.cEn.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.cEo.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.cEq.iR(i);
    }

    @SuppressLint({"MissingPermission"})
    private boolean dG(Context context) {
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

    private void ci(String str, String str2) {
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
                t.rc("save to file suc");
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
    public void qM(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", str);
        t.rc("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            t.rc("delete file suc");
        }
        this.cEg.qK(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void qN(String str) {
        t.rc("upload file fail");
        this.cEg.qL(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ave() {
        File[] listFiles;
        if (dG(this.mContext)) {
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
                    this.cEg.auQ();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    i qJ = this.cEg.qJ(listFiles[i].getName());
                    if (qJ != null && TextUtils.equals("0", qJ.avy())) {
                        t.rc("processFailedData file, no need to send");
                    } else if (qJ != null && TextUtils.equals("1", qJ.avy())) {
                        t.rc("processFailedData file, send");
                        this.cEg.ch(listFiles[i].getName(), "0");
                        qO(listFiles[i].getName());
                    } else {
                        t.rc("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    void qO(String str) {
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
                                m.avD().c(new JSONArray(com.baidu.swan.d.g.getStringFromInput(inputStream2)), str);
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
    public void avf() {
        this.cEg.auR();
    }
}
