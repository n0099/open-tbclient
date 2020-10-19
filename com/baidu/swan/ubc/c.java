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
import com.baidu.platform.comapi.map.MapBundleKey;
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
    private a dXf;
    private b dXg;
    private long dXi;
    private long dXj;
    private long dXk;
    private int dXl;
    private SparseArray<ArrayList> dXm;
    private HashMap<String, Long> dXn;
    private d dXp;
    private Context mContext;
    private m dXo = e.aYZ().adW();
    private List<i> dXh = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.dXf = new a(context);
        this.dXg = new b(context);
        u aZH = u.aZH();
        this.dXi = aZH.getLong("ubc_last_upload_all_time", 0L);
        this.dXj = aZH.getLong("ubc_last_upload_non_real", 0L);
        this.dXk = aZH.getLong("ubc_reset_real_time_count_time", 0L);
        this.dXl = aZH.getInt("ubc_real_time_count", 0);
        this.dXp = d.aYV();
        this.dXp.a(this, context);
    }

    private void aYK() {
        if (this.dXm == null) {
            this.dXm = new SparseArray<>();
            this.dXf.b(this.dXm);
            this.dXn = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.dXm.size(); i2++) {
                int keyAt = this.dXm.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.dXn.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.dXp.mL(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(i iVar) {
        boolean z = false;
        if (TextUtils.equals(iVar.getId(), iVar.aZk()) && this.dXp.yg(iVar.getId()) && (iVar.getOption() & 64) == 0) {
            z = true;
        }
        if (z && !c(iVar)) {
            this.dXf.a(iVar);
        } else if (Math.abs(System.currentTimeMillis() - this.dXj) >= d.aYV().aYW()) {
            if (!z) {
                this.dXh.add(iVar);
            }
            aYP();
        } else if ((iVar.getOption() & 1) == 0) {
            if (!z) {
                this.dXh.add(iVar);
            }
            if (this.dXh.size() >= 20) {
                aYL();
            }
        } else if (!z) {
            this.dXf.a(iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(i iVar) {
        this.dXg.a(iVar, this.dXp.yg(iVar.getId()));
    }

    private void aYL() {
        if (this.dXh != null && this.dXh.size() != 0) {
            this.dXf.aG(this.dXh);
            this.dXh.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(k kVar) {
        this.dXf.a(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(String str, int i, String str2) {
        this.dXf.h(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        aYL();
        this.dXf.a(str, i, j, jSONArray);
        if (this.dXp.yg(str)) {
            aYM();
        }
        if (Math.abs(System.currentTimeMillis() - this.dXj) >= d.aYV().aYW()) {
            aYP();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(String str, int i) {
        aYL();
        this.dXf.I(str, i);
        if (Math.abs(System.currentTimeMillis() - this.dXj) >= d.aYV().aYW()) {
            aYP();
        }
    }

    private boolean c(i iVar) {
        if (dN(this.mContext) && aYN()) {
            aYL();
            v vVar = new v();
            vVar.hE(true);
            JSONObject aZn = iVar.aZn();
            if (aZn != null && aZn.has("bizId")) {
                s.cY(aZn);
                vVar.da(aZn);
                vVar.q(iVar.getTime(), iVar.getTime());
                try {
                    JSONObject jSONObject = aZn.getJSONObject("content");
                    JSONObject jSONObject2 = aZn.getJSONObject("appInfo");
                    if (jSONObject != null && jSONObject2 != null) {
                        jSONObject.put("appInfo", jSONObject2);
                        aZn.remove("appInfo");
                    }
                } catch (JSONException e) {
                }
            } else {
                try {
                    JSONObject jSONObject3 = new s(iVar.aZo()).toJSONObject();
                    jSONObject3.put("bizId", iVar.getId());
                    jSONObject3.put("timestamp", Long.toString(iVar.getTime()));
                    if (iVar.aZn() != null) {
                        jSONObject3.put("content", iVar.aZn());
                    } else {
                        jSONObject3.put("content", iVar.getContent());
                    }
                    jSONObject3.put("eventType", "0");
                    if (!TextUtils.isEmpty(iVar.aZm())) {
                        jSONObject3.put("abtest", iVar.aZm());
                        vVar.yx("1");
                    }
                    if (!TextUtils.isEmpty(iVar.getCategory())) {
                        jSONObject3.put("c", iVar.getCategory());
                    }
                    if (iVar.aZi()) {
                        jSONObject3.put(MapBundleKey.MapObjKey.OBJ_OFFSET, "1");
                    }
                    jSONObject3.put("idtype", this.dXp.ym(iVar.getId()));
                    vVar.da(jSONObject3);
                    vVar.q(iVar.getTime(), iVar.getTime());
                } catch (JSONException e2) {
                }
            }
            if (this.dXm == null) {
                aYK();
            }
            if (this.dXm.size() > 0) {
                this.dXf.a(this.dXm.valueAt(0), vVar);
            }
            c(vVar);
            aYO();
            return true;
        }
        return false;
    }

    private void aYM() {
        if (dN(this.mContext) && aYN()) {
            v vVar = new v();
            vVar.hE(true);
            if (this.dXm == null) {
                aYK();
            }
            if (this.dXm.size() > 0) {
                if (e.aYZ().ayG()) {
                    this.dXf.a(vVar);
                } else {
                    this.dXf.a(this.dXm.valueAt(0), vVar);
                }
            }
            c(vVar);
            aYO();
        }
    }

    private boolean aYN() {
        if (e.aYZ().ayG()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.dXk) > 86400000) {
            this.dXl = 0;
            this.dXk = currentTimeMillis;
            u.aZH().putLong("ubc_reset_real_time_count_time", this.dXk);
            u.aZH().putInt("ubc_real_time_count", this.dXl);
        }
        if (this.dXl >= 1000) {
            if (this.dXl == 1000) {
                this.dXl++;
                e.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void aYO() {
        this.dXl++;
        u.aZH().putInt("ubc_real_time_count", this.dXl);
    }

    private void aYP() {
        if (dN(this.mContext)) {
            this.dXj = System.currentTimeMillis();
            u.aZH().putLong("ubc_last_upload_non_real", this.dXj);
            aYR();
            aYL();
            this.dXf.aYE();
            HashSet hashSet = new HashSet();
            if (this.dXm == null) {
                aYK();
            }
            v vVar = new v();
            vVar.hE(false);
            int i = 0;
            for (int i2 = 0; i2 < this.dXm.size(); i2++) {
                int keyAt = this.dXm.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.dXn.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.dXp.aYW()) {
                        i |= this.dXf.a(this.dXm.valueAt(i2), vVar);
                        this.dXn.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.dXm.size(); i3++) {
                    int keyAt2 = this.dXm.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (vVar.mU(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.dXf.a(this.dXm.valueAt(i3), vVar);
                    }
                }
                c(vVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aYQ() {
        if (dN(this.mContext) && Math.abs(System.currentTimeMillis() - this.dXi) >= BdKVCache.MILLS_1Hour) {
            this.dXf.aYE();
            v vVar = new v();
            if (this.dXf.a(vVar) != 0) {
                v vVar2 = new v();
                vVar2.q(vVar.aZN(), vVar.getMaxTime());
                vVar2.yx(vVar.aZM());
                vVar2.hE(true);
                v vVar3 = new v();
                vVar3.q(vVar.aZN(), vVar.getMaxTime());
                vVar3.yx(vVar.aZM());
                vVar3.hE(false);
                SparseArray<Integer> aZJ = vVar.aZJ();
                int size = aZJ.size();
                for (int i = 0; i < size; i++) {
                    if (this.dXp.yg(String.valueOf(aZJ.valueAt(i).intValue()))) {
                        vVar2.aE(aZJ.keyAt(i), aZJ.valueAt(i).intValue());
                    } else {
                        vVar3.aE(aZJ.keyAt(i), aZJ.valueAt(i).intValue());
                    }
                }
                ArrayList aZK = vVar.aZK();
                int size2 = aZK.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) aZK.get(i2);
                    if (this.dXp.yg(str)) {
                        vVar2.yw(str);
                    } else {
                        vVar3.yw(str);
                    }
                }
                JSONArray aZO = vVar.aZO();
                int length = aZO.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = aZO.optJSONObject(i3);
                    if (optJSONObject.has("bizId")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("bizId");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.dXp.yg(str2)) {
                                vVar2.da(optJSONObject);
                            } else {
                                vVar3.da(optJSONObject);
                            }
                        }
                    }
                }
                if (vVar2.aZO().length() > 0) {
                    c(vVar2);
                }
                if (vVar3.aZO().length() > 0) {
                    c(vVar3);
                }
                this.dXi = System.currentTimeMillis();
                u.aZH().putLong("ubc_last_upload_all_time", this.dXi);
                this.dXj = this.dXi;
                u.aZH().putLong("ubc_last_upload_non_real", this.dXj);
            }
        }
    }

    private void c(v vVar) {
        if (!vVar.isEmpty()) {
            JSONArray aZL = vVar.aZL();
            String md5 = com.baidu.swan.c.e.toMd5(aZL.toString().getBytes(), true);
            dp(aZL.toString(), md5);
            this.dXf.ar(md5, vVar.aZP());
            if (!this.dXf.a(vVar.aZJ(), vVar.aZK(), vVar.aZP(), md5)) {
                vVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", md5);
                if (file.exists() && file.delete()) {
                    Log.d("CeresBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.dXf.yb(md5);
                return;
            }
            n.aZv().d(aZL, md5);
            vVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(JSONArray jSONArray, String str) {
        if (this.dXo.H(jSONArray)) {
            n.aZv().as(str, true);
        } else {
            n.aZv().as(str, false);
        }
    }

    private void aYR() {
        hB(true);
        hB(false);
    }

    private void hB(boolean z) {
        v vVar = new v();
        vVar.hE(z);
        if (this.dXg.a(vVar, z)) {
            JSONArray aZL = vVar.aZL();
            this.dXg.hA(z);
            n.aZv().K(aZL);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(JSONArray jSONArray) {
        if (!this.dXo.H(jSONArray)) {
            e.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a aYS() {
        return this.dXf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(q qVar) {
        this.dXp.aI(qVar.aZB());
        this.dXp.mM(qVar.aZA() * 86400000);
        this.dXp.mN(qVar.aZz());
        u.aZH().putString("ubc_version_md5", qVar.getSign());
        this.dXf.aH(qVar.aZB());
        qVar.aZB().clear();
        if (this.dXm == null) {
            this.dXm = new SparseArray<>();
        }
        this.dXm.clear();
        if (this.dXn == null) {
            this.dXn = new HashMap<>();
        }
        this.dXn.clear();
        this.dXf.b(this.dXm);
        int i = 0;
        for (int i2 = 0; i2 < this.dXm.size(); i2++) {
            int keyAt = this.dXm.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.dXn.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.dXp.mL(i);
    }

    @SuppressLint({"MissingPermission"})
    private boolean dN(Context context) {
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

    private void dp(String str, String str2) {
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
                t.yv("save to file suc");
                com.baidu.swan.c.d.closeSafely(outputStream);
            } catch (Exception e2) {
                e = e2;
                outputStream = fileOutputStream;
                e.printStackTrace();
                com.baidu.swan.c.d.closeSafely(outputStream);
            } catch (Throwable th2) {
                th = th2;
                outputStream = fileOutputStream;
                com.baidu.swan.c.d.closeSafely(outputStream);
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void yd(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", str);
        t.yv("delete file");
        if (file.exists() && file.delete()) {
            Log.d("CeresBehaviorModel", "deleteUploadFile file suc");
            t.yv("delete file suc");
        }
        this.dXf.yb(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ye(String str) {
        t.yv("upload file fail");
        this.dXf.yc(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aYT() {
        File[] listFiles;
        if (dN(this.mContext)) {
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
                    e.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, jSONObject.toString());
                    for (File file2 : listFiles) {
                        file2.delete();
                    }
                    this.dXf.aYF();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    j ya = this.dXf.ya(listFiles[i].getName());
                    if (ya != null && TextUtils.equals("0", ya.aZq())) {
                        t.yv("processFailedData file, no need to send");
                    } else if (ya != null && TextUtils.equals("1", ya.aZq())) {
                        t.yv("processFailedData file, send");
                        this.dXf.m35do(listFiles[i].getName(), "0");
                        yf(listFiles[i].getName());
                    } else {
                        t.yv("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    void yf(String str) {
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
                                n.aZv().d(new JSONArray(com.baidu.swan.c.g.getStringFromInput(inputStream2)), str);
                                com.baidu.swan.c.d.closeSafely(inputStream2);
                            } catch (Throwable th2) {
                                inputStream = inputStream2;
                                th = th2;
                                com.baidu.swan.c.d.closeSafely(inputStream);
                                throw th;
                            }
                        }
                    } catch (Exception e) {
                        inputStream2 = inputStream;
                        com.baidu.swan.c.d.closeSafely(inputStream2);
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                inputStream2 = inputStream;
                com.baidu.swan.c.d.closeSafely(inputStream2);
            } catch (Throwable th4) {
                inputStream = null;
                th = th4;
            }
        } catch (Exception e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aYU() {
        this.dXf.aYG();
    }
}
