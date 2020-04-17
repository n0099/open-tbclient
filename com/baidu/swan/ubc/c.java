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
    private SparseArray<ArrayList> ddA;
    private HashMap<String, Long> ddB;
    private d ddD;
    private a dds;
    private b ddt;
    private long ddw;
    private long ddx;
    private long ddy;
    private int ddz;
    private Context mContext;
    private l ddC = s.aEh().Qq();
    private List<h> ddv = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.dds = new a(context);
        this.ddt = new b(context);
        u aEi = u.aEi();
        this.ddw = aEi.getLong("ubc_last_upload_all_time", 0L);
        this.ddx = aEi.getLong("ubc_last_upload_non_real", 0L);
        this.ddy = aEi.getLong("ubc_reset_real_time_count_time", 0L);
        this.ddz = aEi.getInt("ubc_real_time_count", 0);
        this.ddD = d.aDw();
        this.ddD.a(this, context);
    }

    private void aDl() {
        if (this.ddA == null) {
            this.ddA = new SparseArray<>();
            this.dds.a(this.ddA);
            this.ddB = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.ddA.size(); i2++) {
                int keyAt = this.ddA.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.ddB.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.ddD.iY(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(h hVar) {
        boolean z = false;
        if (TextUtils.equals(hVar.getId(), hVar.ahG()) && this.ddD.sb(hVar.getId()) && (hVar.getOption() & 64) == 0) {
            z = true;
        }
        if (z && !c(hVar)) {
            this.dds.a(hVar);
        } else if (Math.abs(System.currentTimeMillis() - this.ddx) >= d.aDw().aDx()) {
            if (!z) {
                this.ddv.add(hVar);
            }
            aDq();
        } else if ((hVar.getOption() & 1) == 0) {
            if (!z) {
                this.ddv.add(hVar);
            }
            if (this.ddv.size() >= 20) {
                aDm();
            }
        } else if (!z) {
            this.dds.a(hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(h hVar) {
        this.ddt.a(hVar, this.ddD.sb(hVar.getId()));
    }

    private void aDm() {
        if (this.ddv != null && this.ddv.size() != 0) {
            this.dds.au(this.ddv);
            this.ddv.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.dds.a(jVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, int i, String str2) {
        this.dds.f(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        aDm();
        this.dds.a(str, i, j, jSONArray);
        if (this.ddD.sb(str)) {
            aDn();
        }
        if (Math.abs(System.currentTimeMillis() - this.ddx) >= d.aDw().aDx()) {
            aDq();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(String str, int i) {
        aDm();
        this.dds.C(str, i);
        if (Math.abs(System.currentTimeMillis() - this.ddx) >= d.aDw().aDx()) {
            aDq();
        }
    }

    private boolean c(h hVar) {
        if (dt(this.mContext) && aDo()) {
            aDm();
            v vVar = new v();
            vVar.ge(true);
            JSONObject aDL = hVar.aDL();
            if (aDL != null && aDL.has("bizId")) {
                r.cp(aDL);
                vVar.cr(aDL);
                vVar.r(hVar.getTime(), hVar.getTime());
                try {
                    JSONObject jSONObject = aDL.getJSONObject("content");
                    JSONObject jSONObject2 = aDL.getJSONObject("appInfo");
                    if (jSONObject != null && jSONObject2 != null) {
                        jSONObject.put("appInfo", jSONObject2);
                        aDL.remove("appInfo");
                    }
                } catch (JSONException e) {
                }
            } else {
                try {
                    JSONObject jSONObject3 = new r(hVar.aDM()).toJSONObject();
                    jSONObject3.put("bizId", hVar.getId());
                    jSONObject3.put("timestamp", Long.toString(hVar.getTime()));
                    if (hVar.aDL() != null) {
                        jSONObject3.put("content", hVar.aDL());
                    } else {
                        jSONObject3.put("content", hVar.getContent());
                    }
                    jSONObject3.put("eventType", "0");
                    if (!TextUtils.isEmpty(hVar.aDK())) {
                        jSONObject3.put("abtest", hVar.aDK());
                        vVar.sq("1");
                    }
                    if (!TextUtils.isEmpty(hVar.getCategory())) {
                        jSONObject3.put("c", hVar.getCategory());
                    }
                    if (hVar.aDH()) {
                        jSONObject3.put("of", "1");
                    }
                    jSONObject3.put("idtype", this.ddD.sh(hVar.getId()));
                    vVar.cr(jSONObject3);
                    vVar.r(hVar.getTime(), hVar.getTime());
                } catch (JSONException e2) {
                }
            }
            if (this.ddA == null) {
                aDl();
            }
            if (this.ddA.size() > 0) {
                this.dds.a(this.ddA.valueAt(0), vVar);
            }
            c(vVar);
            aDp();
            return true;
        }
        return false;
    }

    private void aDn() {
        if (dt(this.mContext) && aDo()) {
            v vVar = new v();
            vVar.ge(true);
            if (this.ddA == null) {
                aDl();
            }
            if (this.ddA.size() > 0) {
                if (s.aEh().ahz()) {
                    this.dds.a(vVar);
                } else {
                    this.dds.a(this.ddA.valueAt(0), vVar);
                }
            }
            c(vVar);
            aDp();
        }
    }

    private boolean aDo() {
        if (s.aEh().ahz()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.ddy) > 86400000) {
            this.ddz = 0;
            this.ddy = currentTimeMillis;
            u.aEi().putLong("ubc_reset_real_time_count_time", this.ddy);
            u.aEi().putInt("ubc_real_time_count", this.ddz);
        }
        if (this.ddz >= 1000) {
            if (this.ddz == 1000) {
                this.ddz++;
                s.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void aDp() {
        this.ddz++;
        u.aEi().putInt("ubc_real_time_count", this.ddz);
    }

    private void aDq() {
        if (dt(this.mContext)) {
            this.ddx = System.currentTimeMillis();
            u.aEi().putLong("ubc_last_upload_non_real", this.ddx);
            aDs();
            aDm();
            this.dds.aDf();
            HashSet hashSet = new HashSet();
            if (this.ddA == null) {
                aDl();
            }
            v vVar = new v();
            vVar.ge(false);
            int i = 0;
            for (int i2 = 0; i2 < this.ddA.size(); i2++) {
                int keyAt = this.ddA.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.ddB.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.ddD.aDx()) {
                        i |= this.dds.a(this.ddA.valueAt(i2), vVar);
                        this.ddB.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.ddA.size(); i3++) {
                    int keyAt2 = this.ddA.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (vVar.jh(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.dds.a(this.ddA.valueAt(i3), vVar);
                    }
                }
                c(vVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aDr() {
        if (dt(this.mContext) && Math.abs(System.currentTimeMillis() - this.ddw) >= BdKVCache.MILLS_1Hour) {
            this.dds.aDf();
            v vVar = new v();
            if (this.dds.a(vVar) != 0) {
                v vVar2 = new v();
                vVar2.r(vVar.aEo(), vVar.getMaxTime());
                vVar2.sq(vVar.aEn());
                vVar2.ge(true);
                v vVar3 = new v();
                vVar3.r(vVar.aEo(), vVar.getMaxTime());
                vVar3.sq(vVar.aEn());
                vVar3.ge(false);
                SparseArray<Integer> aEk = vVar.aEk();
                int size = aEk.size();
                for (int i = 0; i < size; i++) {
                    if (this.ddD.sb(String.valueOf(aEk.valueAt(i).intValue()))) {
                        vVar2.aw(aEk.keyAt(i), aEk.valueAt(i).intValue());
                    } else {
                        vVar3.aw(aEk.keyAt(i), aEk.valueAt(i).intValue());
                    }
                }
                ArrayList aEl = vVar.aEl();
                int size2 = aEl.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) aEl.get(i2);
                    if (this.ddD.sb(str)) {
                        vVar2.sp(str);
                    } else {
                        vVar3.sp(str);
                    }
                }
                JSONArray aEp = vVar.aEp();
                int length = aEp.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = aEp.optJSONObject(i3);
                    if (optJSONObject.has("bizId")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("bizId");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.ddD.sb(str2)) {
                                vVar2.cr(optJSONObject);
                            } else {
                                vVar3.cr(optJSONObject);
                            }
                        }
                    }
                }
                if (vVar2.aEp().length() > 0) {
                    c(vVar2);
                }
                if (vVar3.aEp().length() > 0) {
                    c(vVar3);
                }
                this.ddw = System.currentTimeMillis();
                u.aEi().putLong("ubc_last_upload_all_time", this.ddw);
                this.ddx = this.ddw;
                u.aEi().putLong("ubc_last_upload_non_real", this.ddx);
            }
        }
    }

    private void c(v vVar) {
        if (!vVar.isEmpty()) {
            JSONArray aEm = vVar.aEm();
            String md5 = com.baidu.swan.d.d.toMd5(aEm.toString().getBytes(), true);
            cs(aEm.toString(), md5);
            this.dds.V(md5, vVar.aEq());
            if (!this.dds.a(vVar.aEk(), vVar.aEl(), vVar.aEq(), md5)) {
                vVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", md5);
                if (file.exists() && file.delete()) {
                    Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.dds.rW(md5);
                return;
            }
            m.aDT().c(aEm, md5);
            vVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(JSONArray jSONArray, String str) {
        if (this.ddC.F(jSONArray)) {
            m.aDT().W(str, true);
        } else {
            m.aDT().W(str, false);
        }
    }

    private void aDs() {
        gb(true);
        gb(false);
    }

    private void gb(boolean z) {
        v vVar = new v();
        vVar.ge(z);
        if (this.ddt.a(vVar, z)) {
            JSONArray aEm = vVar.aEm();
            this.ddt.ga(z);
            m.aDT().I(aEm);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(JSONArray jSONArray) {
        if (!this.ddC.F(jSONArray)) {
            s.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a aDt() {
        return this.dds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(p pVar) {
        this.ddD.aw(pVar.aEb());
        this.ddD.iZ(pVar.aEa() * 86400000);
        this.ddD.ja(pVar.aDZ());
        u.aEi().putString("ubc_version_md5", pVar.getSign());
        this.dds.av(pVar.aEb());
        pVar.aEb().clear();
        if (this.ddA == null) {
            this.ddA = new SparseArray<>();
        }
        this.ddA.clear();
        if (this.ddB == null) {
            this.ddB = new HashMap<>();
        }
        this.ddB.clear();
        this.dds.a(this.ddA);
        int i = 0;
        for (int i2 = 0; i2 < this.ddA.size(); i2++) {
            int keyAt = this.ddA.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.ddB.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.ddD.iY(i);
    }

    @SuppressLint({"MissingPermission"})
    private boolean dt(Context context) {
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

    private void cs(String str, String str2) {
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
                t.so("save to file suc");
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
    public void rY(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", str);
        t.so("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            t.so("delete file suc");
        }
        this.dds.rW(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void rZ(String str) {
        t.so("upload file fail");
        this.dds.rX(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aDu() {
        File[] listFiles;
        if (dt(this.mContext)) {
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
                    this.dds.aDg();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    i rV = this.dds.rV(listFiles[i].getName());
                    if (rV != null && TextUtils.equals("0", rV.aDO())) {
                        t.so("processFailedData file, no need to send");
                    } else if (rV != null && TextUtils.equals("1", rV.aDO())) {
                        t.so("processFailedData file, send");
                        this.dds.cr(listFiles[i].getName(), "0");
                        sa(listFiles[i].getName());
                    } else {
                        t.so("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    void sa(String str) {
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
                                m.aDT().c(new JSONArray(com.baidu.swan.d.g.getStringFromInput(inputStream2)), str);
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
    public void aDv() {
        this.dds.aDh();
    }
}
