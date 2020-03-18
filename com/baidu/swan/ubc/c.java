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
    private SparseArray<ArrayList> cEA;
    private HashMap<String, Long> cEB;
    private d cED;
    private a cEt;
    private b cEu;
    private long cEw;
    private long cEx;
    private long cEy;
    private int cEz;
    private Context mContext;
    private l cEC = s.avW().IE();
    private List<h> cEv = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.cEt = new a(context);
        this.cEu = new b(context);
        u avX = u.avX();
        this.cEw = avX.getLong("ubc_last_upload_all_time", 0L);
        this.cEx = avX.getLong("ubc_last_upload_non_real", 0L);
        this.cEy = avX.getLong("ubc_reset_real_time_count_time", 0L);
        this.cEz = avX.getInt("ubc_real_time_count", 0);
        this.cED = d.avl();
        this.cED.a(this, context);
    }

    private void ava() {
        if (this.cEA == null) {
            this.cEA = new SparseArray<>();
            this.cEt.a(this.cEA);
            this.cEB = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.cEA.size(); i2++) {
                int keyAt = this.cEA.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.cEB.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.cED.iR(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(h hVar) {
        boolean z = false;
        if (TextUtils.equals(hVar.getId(), hVar.ZB()) && this.cED.qO(hVar.getId()) && (hVar.getOption() & 64) == 0) {
            z = true;
        }
        if (z && !c(hVar)) {
            this.cEt.a(hVar);
        } else if (Math.abs(System.currentTimeMillis() - this.cEx) >= d.avl().avm()) {
            if (!z) {
                this.cEv.add(hVar);
            }
            avf();
        } else if ((hVar.getOption() & 1) == 0) {
            if (!z) {
                this.cEv.add(hVar);
            }
            if (this.cEv.size() >= 20) {
                avb();
            }
        } else if (!z) {
            this.cEt.a(hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(h hVar) {
        this.cEu.a(hVar, this.cED.qO(hVar.getId()));
    }

    private void avb() {
        if (this.cEv != null && this.cEv.size() != 0) {
            this.cEt.al(this.cEv);
            this.cEv.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.cEt.a(jVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, int i, String str2) {
        this.cEt.f(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        avb();
        this.cEt.a(str, i, j, jSONArray);
        if (this.cED.qO(str)) {
            avc();
        }
        if (Math.abs(System.currentTimeMillis() - this.cEx) >= d.avl().avm()) {
            avf();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(String str, int i) {
        avb();
        this.cEt.u(str, i);
        if (Math.abs(System.currentTimeMillis() - this.cEx) >= d.avl().avm()) {
            avf();
        }
    }

    private boolean c(h hVar) {
        if (dF(this.mContext) && avd()) {
            avb();
            v vVar = new v();
            vVar.fh(true);
            JSONObject avA = hVar.avA();
            if (avA != null && avA.has("bizId")) {
                r.ce(avA);
                vVar.cg(avA);
                vVar.q(hVar.getTime(), hVar.getTime());
                try {
                    JSONObject jSONObject = avA.getJSONObject("content");
                    JSONObject jSONObject2 = avA.getJSONObject("appInfo");
                    if (jSONObject != null && jSONObject2 != null) {
                        jSONObject.put("appInfo", jSONObject2);
                        avA.remove("appInfo");
                    }
                } catch (JSONException e) {
                }
            } else {
                try {
                    JSONObject jSONObject3 = new r(hVar.avB()).toJSONObject();
                    jSONObject3.put("bizId", hVar.getId());
                    jSONObject3.put("timestamp", Long.toString(hVar.getTime()));
                    if (hVar.avA() != null) {
                        jSONObject3.put("content", hVar.avA());
                    } else {
                        jSONObject3.put("content", hVar.getContent());
                    }
                    jSONObject3.put("eventType", "0");
                    if (!TextUtils.isEmpty(hVar.avz())) {
                        jSONObject3.put("abtest", hVar.avz());
                        vVar.rd("1");
                    }
                    if (!TextUtils.isEmpty(hVar.getCategory())) {
                        jSONObject3.put("c", hVar.getCategory());
                    }
                    if (hVar.avw()) {
                        jSONObject3.put("of", "1");
                    }
                    jSONObject3.put("idtype", this.cED.qU(hVar.getId()));
                    vVar.cg(jSONObject3);
                    vVar.q(hVar.getTime(), hVar.getTime());
                } catch (JSONException e2) {
                }
            }
            if (this.cEA == null) {
                ava();
            }
            if (this.cEA.size() > 0) {
                this.cEt.a(this.cEA.valueAt(0), vVar);
            }
            c(vVar);
            ave();
            return true;
        }
        return false;
    }

    private void avc() {
        if (dF(this.mContext) && avd()) {
            v vVar = new v();
            vVar.fh(true);
            if (this.cEA == null) {
                ava();
            }
            if (this.cEA.size() > 0) {
                if (s.avW().Zu()) {
                    this.cEt.a(vVar);
                } else {
                    this.cEt.a(this.cEA.valueAt(0), vVar);
                }
            }
            c(vVar);
            ave();
        }
    }

    private boolean avd() {
        if (s.avW().Zu()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.cEy) > 86400000) {
            this.cEz = 0;
            this.cEy = currentTimeMillis;
            u.avX().putLong("ubc_reset_real_time_count_time", this.cEy);
            u.avX().putInt("ubc_real_time_count", this.cEz);
        }
        if (this.cEz >= 1000) {
            if (this.cEz == 1000) {
                this.cEz++;
                s.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void ave() {
        this.cEz++;
        u.avX().putInt("ubc_real_time_count", this.cEz);
    }

    private void avf() {
        if (dF(this.mContext)) {
            this.cEx = System.currentTimeMillis();
            u.avX().putLong("ubc_last_upload_non_real", this.cEx);
            avh();
            avb();
            this.cEt.auU();
            HashSet hashSet = new HashSet();
            if (this.cEA == null) {
                ava();
            }
            v vVar = new v();
            vVar.fh(false);
            int i = 0;
            for (int i2 = 0; i2 < this.cEA.size(); i2++) {
                int keyAt = this.cEA.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.cEB.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.cED.avm()) {
                        i |= this.cEt.a(this.cEA.valueAt(i2), vVar);
                        this.cEB.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.cEA.size(); i3++) {
                    int keyAt2 = this.cEA.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (vVar.ja(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.cEt.a(this.cEA.valueAt(i3), vVar);
                    }
                }
                c(vVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void avg() {
        if (dF(this.mContext) && Math.abs(System.currentTimeMillis() - this.cEw) >= BdKVCache.MILLS_1Hour) {
            this.cEt.auU();
            v vVar = new v();
            if (this.cEt.a(vVar) != 0) {
                v vVar2 = new v();
                vVar2.q(vVar.awd(), vVar.getMaxTime());
                vVar2.rd(vVar.awc());
                vVar2.fh(true);
                v vVar3 = new v();
                vVar3.q(vVar.awd(), vVar.getMaxTime());
                vVar3.rd(vVar.awc());
                vVar3.fh(false);
                SparseArray<Integer> avZ = vVar.avZ();
                int size = avZ.size();
                for (int i = 0; i < size; i++) {
                    if (this.cED.qO(String.valueOf(avZ.valueAt(i).intValue()))) {
                        vVar2.at(avZ.keyAt(i), avZ.valueAt(i).intValue());
                    } else {
                        vVar3.at(avZ.keyAt(i), avZ.valueAt(i).intValue());
                    }
                }
                ArrayList awa = vVar.awa();
                int size2 = awa.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) awa.get(i2);
                    if (this.cED.qO(str)) {
                        vVar2.rc(str);
                    } else {
                        vVar3.rc(str);
                    }
                }
                JSONArray awe = vVar.awe();
                int length = awe.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = awe.optJSONObject(i3);
                    if (optJSONObject.has("bizId")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("bizId");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.cED.qO(str2)) {
                                vVar2.cg(optJSONObject);
                            } else {
                                vVar3.cg(optJSONObject);
                            }
                        }
                    }
                }
                if (vVar2.awe().length() > 0) {
                    c(vVar2);
                }
                if (vVar3.awe().length() > 0) {
                    c(vVar3);
                }
                this.cEw = System.currentTimeMillis();
                u.avX().putLong("ubc_last_upload_all_time", this.cEw);
                this.cEx = this.cEw;
                u.avX().putLong("ubc_last_upload_non_real", this.cEx);
            }
        }
    }

    private void c(v vVar) {
        if (!vVar.isEmpty()) {
            JSONArray awb = vVar.awb();
            String md5 = com.baidu.swan.d.d.toMd5(awb.toString().getBytes(), true);
            ch(awb.toString(), md5);
            this.cEt.Q(md5, vVar.awf());
            if (!this.cEt.a(vVar.avZ(), vVar.awa(), vVar.awf(), md5)) {
                vVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", md5);
                if (file.exists() && file.delete()) {
                    Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.cEt.qJ(md5);
                return;
            }
            m.avI().c(awb, md5);
            vVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(JSONArray jSONArray, String str) {
        if (this.cEC.E(jSONArray)) {
            m.avI().R(str, true);
        } else {
            m.avI().R(str, false);
        }
    }

    private void avh() {
        fe(true);
        fe(false);
    }

    private void fe(boolean z) {
        v vVar = new v();
        vVar.fh(z);
        if (this.cEu.a(vVar, z)) {
            JSONArray awb = vVar.awb();
            this.cEu.fd(z);
            m.avI().H(awb);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(JSONArray jSONArray) {
        if (!this.cEC.E(jSONArray)) {
            s.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a avi() {
        return this.cEt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(p pVar) {
        this.cED.an(pVar.avQ());
        this.cED.iS(pVar.avP() * DateTimeUtil.TIME_DAY_MILLISECOND);
        this.cED.iT(pVar.avO());
        u.avX().putString("ubc_version_md5", pVar.getSign());
        this.cEt.am(pVar.avQ());
        pVar.avQ().clear();
        if (this.cEA == null) {
            this.cEA = new SparseArray<>();
        }
        this.cEA.clear();
        if (this.cEB == null) {
            this.cEB = new HashMap<>();
        }
        this.cEB.clear();
        this.cEt.a(this.cEA);
        int i = 0;
        for (int i2 = 0; i2 < this.cEA.size(); i2++) {
            int keyAt = this.cEA.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.cEB.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.cED.iR(i);
    }

    @SuppressLint({"MissingPermission"})
    private boolean dF(Context context) {
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

    private void ch(String str, String str2) {
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
                t.rb("save to file suc");
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
    public void qL(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", str);
        t.rb("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            t.rb("delete file suc");
        }
        this.cEt.qJ(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void qM(String str) {
        t.rb("upload file fail");
        this.cEt.qK(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void avj() {
        File[] listFiles;
        if (dF(this.mContext)) {
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
                    this.cEt.auV();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    i qI = this.cEt.qI(listFiles[i].getName());
                    if (qI != null && TextUtils.equals("0", qI.avD())) {
                        t.rb("processFailedData file, no need to send");
                    } else if (qI != null && TextUtils.equals("1", qI.avD())) {
                        t.rb("processFailedData file, send");
                        this.cEt.cg(listFiles[i].getName(), "0");
                        qN(listFiles[i].getName());
                    } else {
                        t.rb("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    void qN(String str) {
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
                                m.avI().c(new JSONArray(com.baidu.swan.d.g.getStringFromInput(inputStream2)), str);
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
    public void avk() {
        this.cEt.auW();
    }
}
