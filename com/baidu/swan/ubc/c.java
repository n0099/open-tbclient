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
    private a cEi;
    private b cEj;
    private long cEl;
    private long cEm;
    private long cEn;
    private int cEo;
    private SparseArray<ArrayList> cEp;
    private HashMap<String, Long> cEq;
    private d cEs;
    private Context mContext;
    private l cEr = s.avT().IB();
    private List<h> cEk = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.cEi = new a(context);
        this.cEj = new b(context);
        u avU = u.avU();
        this.cEl = avU.getLong("ubc_last_upload_all_time", 0L);
        this.cEm = avU.getLong("ubc_last_upload_non_real", 0L);
        this.cEn = avU.getLong("ubc_reset_real_time_count_time", 0L);
        this.cEo = avU.getInt("ubc_real_time_count", 0);
        this.cEs = d.avi();
        this.cEs.a(this, context);
    }

    private void auX() {
        if (this.cEp == null) {
            this.cEp = new SparseArray<>();
            this.cEi.a(this.cEp);
            this.cEq = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.cEp.size(); i2++) {
                int keyAt = this.cEp.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.cEq.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.cEs.iR(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(h hVar) {
        boolean z = false;
        if (TextUtils.equals(hVar.getId(), hVar.Zy()) && this.cEs.qP(hVar.getId()) && (hVar.getOption() & 64) == 0) {
            z = true;
        }
        if (z && !c(hVar)) {
            this.cEi.a(hVar);
        } else if (Math.abs(System.currentTimeMillis() - this.cEm) >= d.avi().avj()) {
            if (!z) {
                this.cEk.add(hVar);
            }
            avc();
        } else if ((hVar.getOption() & 1) == 0) {
            if (!z) {
                this.cEk.add(hVar);
            }
            if (this.cEk.size() >= 20) {
                auY();
            }
        } else if (!z) {
            this.cEi.a(hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(h hVar) {
        this.cEj.a(hVar, this.cEs.qP(hVar.getId()));
    }

    private void auY() {
        if (this.cEk != null && this.cEk.size() != 0) {
            this.cEi.al(this.cEk);
            this.cEk.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.cEi.a(jVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, int i, String str2) {
        this.cEi.f(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        auY();
        this.cEi.a(str, i, j, jSONArray);
        if (this.cEs.qP(str)) {
            auZ();
        }
        if (Math.abs(System.currentTimeMillis() - this.cEm) >= d.avi().avj()) {
            avc();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(String str, int i) {
        auY();
        this.cEi.u(str, i);
        if (Math.abs(System.currentTimeMillis() - this.cEm) >= d.avi().avj()) {
            avc();
        }
    }

    private boolean c(h hVar) {
        if (dG(this.mContext) && ava()) {
            auY();
            v vVar = new v();
            vVar.fg(true);
            JSONObject avx = hVar.avx();
            if (avx != null && avx.has("bizId")) {
                r.ce(avx);
                vVar.cg(avx);
                vVar.q(hVar.getTime(), hVar.getTime());
                try {
                    JSONObject jSONObject = avx.getJSONObject("content");
                    JSONObject jSONObject2 = avx.getJSONObject("appInfo");
                    if (jSONObject != null && jSONObject2 != null) {
                        jSONObject.put("appInfo", jSONObject2);
                        avx.remove("appInfo");
                    }
                } catch (JSONException e) {
                }
            } else {
                try {
                    JSONObject jSONObject3 = new r(hVar.avy()).toJSONObject();
                    jSONObject3.put("bizId", hVar.getId());
                    jSONObject3.put("timestamp", Long.toString(hVar.getTime()));
                    if (hVar.avx() != null) {
                        jSONObject3.put("content", hVar.avx());
                    } else {
                        jSONObject3.put("content", hVar.getContent());
                    }
                    jSONObject3.put("eventType", "0");
                    if (!TextUtils.isEmpty(hVar.avw())) {
                        jSONObject3.put("abtest", hVar.avw());
                        vVar.re("1");
                    }
                    if (!TextUtils.isEmpty(hVar.getCategory())) {
                        jSONObject3.put("c", hVar.getCategory());
                    }
                    if (hVar.avt()) {
                        jSONObject3.put("of", "1");
                    }
                    jSONObject3.put("idtype", this.cEs.qV(hVar.getId()));
                    vVar.cg(jSONObject3);
                    vVar.q(hVar.getTime(), hVar.getTime());
                } catch (JSONException e2) {
                }
            }
            if (this.cEp == null) {
                auX();
            }
            if (this.cEp.size() > 0) {
                this.cEi.a(this.cEp.valueAt(0), vVar);
            }
            c(vVar);
            avb();
            return true;
        }
        return false;
    }

    private void auZ() {
        if (dG(this.mContext) && ava()) {
            v vVar = new v();
            vVar.fg(true);
            if (this.cEp == null) {
                auX();
            }
            if (this.cEp.size() > 0) {
                if (s.avT().Zr()) {
                    this.cEi.a(vVar);
                } else {
                    this.cEi.a(this.cEp.valueAt(0), vVar);
                }
            }
            c(vVar);
            avb();
        }
    }

    private boolean ava() {
        if (s.avT().Zr()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.cEn) > 86400000) {
            this.cEo = 0;
            this.cEn = currentTimeMillis;
            u.avU().putLong("ubc_reset_real_time_count_time", this.cEn);
            u.avU().putInt("ubc_real_time_count", this.cEo);
        }
        if (this.cEo >= 1000) {
            if (this.cEo == 1000) {
                this.cEo++;
                s.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void avb() {
        this.cEo++;
        u.avU().putInt("ubc_real_time_count", this.cEo);
    }

    private void avc() {
        if (dG(this.mContext)) {
            this.cEm = System.currentTimeMillis();
            u.avU().putLong("ubc_last_upload_non_real", this.cEm);
            ave();
            auY();
            this.cEi.auR();
            HashSet hashSet = new HashSet();
            if (this.cEp == null) {
                auX();
            }
            v vVar = new v();
            vVar.fg(false);
            int i = 0;
            for (int i2 = 0; i2 < this.cEp.size(); i2++) {
                int keyAt = this.cEp.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.cEq.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.cEs.avj()) {
                        i |= this.cEi.a(this.cEp.valueAt(i2), vVar);
                        this.cEq.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.cEp.size(); i3++) {
                    int keyAt2 = this.cEp.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (vVar.ja(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.cEi.a(this.cEp.valueAt(i3), vVar);
                    }
                }
                c(vVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void avd() {
        if (dG(this.mContext) && Math.abs(System.currentTimeMillis() - this.cEl) >= BdKVCache.MILLS_1Hour) {
            this.cEi.auR();
            v vVar = new v();
            if (this.cEi.a(vVar) != 0) {
                v vVar2 = new v();
                vVar2.q(vVar.awa(), vVar.getMaxTime());
                vVar2.re(vVar.avZ());
                vVar2.fg(true);
                v vVar3 = new v();
                vVar3.q(vVar.awa(), vVar.getMaxTime());
                vVar3.re(vVar.avZ());
                vVar3.fg(false);
                SparseArray<Integer> avW = vVar.avW();
                int size = avW.size();
                for (int i = 0; i < size; i++) {
                    if (this.cEs.qP(String.valueOf(avW.valueAt(i).intValue()))) {
                        vVar2.at(avW.keyAt(i), avW.valueAt(i).intValue());
                    } else {
                        vVar3.at(avW.keyAt(i), avW.valueAt(i).intValue());
                    }
                }
                ArrayList avX = vVar.avX();
                int size2 = avX.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) avX.get(i2);
                    if (this.cEs.qP(str)) {
                        vVar2.rd(str);
                    } else {
                        vVar3.rd(str);
                    }
                }
                JSONArray awb = vVar.awb();
                int length = awb.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = awb.optJSONObject(i3);
                    if (optJSONObject.has("bizId")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("bizId");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.cEs.qP(str2)) {
                                vVar2.cg(optJSONObject);
                            } else {
                                vVar3.cg(optJSONObject);
                            }
                        }
                    }
                }
                if (vVar2.awb().length() > 0) {
                    c(vVar2);
                }
                if (vVar3.awb().length() > 0) {
                    c(vVar3);
                }
                this.cEl = System.currentTimeMillis();
                u.avU().putLong("ubc_last_upload_all_time", this.cEl);
                this.cEm = this.cEl;
                u.avU().putLong("ubc_last_upload_non_real", this.cEm);
            }
        }
    }

    private void c(v vVar) {
        if (!vVar.isEmpty()) {
            JSONArray avY = vVar.avY();
            String md5 = com.baidu.swan.d.d.toMd5(avY.toString().getBytes(), true);
            ci(avY.toString(), md5);
            this.cEi.Q(md5, vVar.awc());
            if (!this.cEi.a(vVar.avW(), vVar.avX(), vVar.awc(), md5)) {
                vVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", md5);
                if (file.exists() && file.delete()) {
                    Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.cEi.qK(md5);
                return;
            }
            m.avF().c(avY, md5);
            vVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(JSONArray jSONArray, String str) {
        if (this.cEr.E(jSONArray)) {
            m.avF().R(str, true);
        } else {
            m.avF().R(str, false);
        }
    }

    private void ave() {
        fd(true);
        fd(false);
    }

    private void fd(boolean z) {
        v vVar = new v();
        vVar.fg(z);
        if (this.cEj.a(vVar, z)) {
            JSONArray avY = vVar.avY();
            this.cEj.fc(z);
            m.avF().H(avY);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(JSONArray jSONArray) {
        if (!this.cEr.E(jSONArray)) {
            s.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a avf() {
        return this.cEi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(p pVar) {
        this.cEs.an(pVar.avN());
        this.cEs.iS(pVar.avM() * DateTimeUtil.TIME_DAY_MILLISECOND);
        this.cEs.iT(pVar.avL());
        u.avU().putString("ubc_version_md5", pVar.getSign());
        this.cEi.am(pVar.avN());
        pVar.avN().clear();
        if (this.cEp == null) {
            this.cEp = new SparseArray<>();
        }
        this.cEp.clear();
        if (this.cEq == null) {
            this.cEq = new HashMap<>();
        }
        this.cEq.clear();
        this.cEi.a(this.cEp);
        int i = 0;
        for (int i2 = 0; i2 < this.cEp.size(); i2++) {
            int keyAt = this.cEp.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.cEq.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.cEs.iR(i);
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
        this.cEi.qK(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void qN(String str) {
        t.rc("upload file fail");
        this.cEi.qL(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void avg() {
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
                    this.cEi.auS();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    i qJ = this.cEi.qJ(listFiles[i].getName());
                    if (qJ != null && TextUtils.equals("0", qJ.avA())) {
                        t.rc("processFailedData file, no need to send");
                    } else if (qJ != null && TextUtils.equals("1", qJ.avA())) {
                        t.rc("processFailedData file, send");
                        this.cEi.ch(listFiles[i].getName(), "0");
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
                                m.avF().c(new JSONArray(com.baidu.swan.d.g.getStringFromInput(inputStream2)), str);
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
    public void avh() {
        this.cEi.auT();
    }
}
