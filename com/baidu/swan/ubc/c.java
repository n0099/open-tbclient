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
    private a dpm;
    private b dpn;
    private long dpp;
    private long dpq;
    private long dpr;
    private int dps;
    private SparseArray<ArrayList> dpt;
    private HashMap<String, Long> dpu;
    private d dpw;
    private Context mContext;
    private m dpv = e.aIh().ST();
    private List<i> dpo = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.dpm = new a(context);
        this.dpn = new b(context);
        u aIQ = u.aIQ();
        this.dpp = aIQ.getLong("ubc_last_upload_all_time", 0L);
        this.dpq = aIQ.getLong("ubc_last_upload_non_real", 0L);
        this.dpr = aIQ.getLong("ubc_reset_real_time_count_time", 0L);
        this.dps = aIQ.getInt("ubc_real_time_count", 0);
        this.dpw = d.aId();
        this.dpw.a(this, context);
    }

    private void aHS() {
        if (this.dpt == null) {
            this.dpt = new SparseArray<>();
            this.dpm.b(this.dpt);
            this.dpu = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.dpt.size(); i2++) {
                int keyAt = this.dpt.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.dpu.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.dpw.jt(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(i iVar) {
        boolean z = false;
        if (TextUtils.equals(iVar.getId(), iVar.aIs()) && this.dpw.tE(iVar.getId()) && (iVar.getOption() & 64) == 0) {
            z = true;
        }
        if (z && !c(iVar)) {
            this.dpm.a(iVar);
        } else if (Math.abs(System.currentTimeMillis() - this.dpq) >= d.aId().aIe()) {
            if (!z) {
                this.dpo.add(iVar);
            }
            aHX();
        } else if ((iVar.getOption() & 1) == 0) {
            if (!z) {
                this.dpo.add(iVar);
            }
            if (this.dpo.size() >= 20) {
                aHT();
            }
        } else if (!z) {
            this.dpm.a(iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(i iVar) {
        this.dpn.a(iVar, this.dpw.tE(iVar.getId()));
    }

    private void aHT() {
        if (this.dpo != null && this.dpo.size() != 0) {
            this.dpm.ap(this.dpo);
            this.dpo.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(k kVar) {
        this.dpm.a(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, int i, String str2) {
        this.dpm.f(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        aHT();
        this.dpm.a(str, i, j, jSONArray);
        if (this.dpw.tE(str)) {
            aHU();
        }
        if (Math.abs(System.currentTimeMillis() - this.dpq) >= d.aId().aIe()) {
            aHX();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(String str, int i) {
        aHT();
        this.dpm.G(str, i);
        if (Math.abs(System.currentTimeMillis() - this.dpq) >= d.aId().aIe()) {
            aHX();
        }
    }

    private boolean c(i iVar) {
        if (dx(this.mContext) && aHV()) {
            aHT();
            v vVar = new v();
            vVar.gp(true);
            JSONObject aIv = iVar.aIv();
            if (aIv != null && aIv.has("bizId")) {
                s.cv(aIv);
                vVar.cx(aIv);
                vVar.s(iVar.getTime(), iVar.getTime());
                try {
                    JSONObject jSONObject = aIv.getJSONObject("content");
                    JSONObject jSONObject2 = aIv.getJSONObject("appInfo");
                    if (jSONObject != null && jSONObject2 != null) {
                        jSONObject.put("appInfo", jSONObject2);
                        aIv.remove("appInfo");
                    }
                } catch (JSONException e) {
                }
            } else {
                try {
                    JSONObject jSONObject3 = new s(iVar.aIw()).toJSONObject();
                    jSONObject3.put("bizId", iVar.getId());
                    jSONObject3.put("timestamp", Long.toString(iVar.getTime()));
                    if (iVar.aIv() != null) {
                        jSONObject3.put("content", iVar.aIv());
                    } else {
                        jSONObject3.put("content", iVar.getContent());
                    }
                    jSONObject3.put("eventType", "0");
                    if (!TextUtils.isEmpty(iVar.aIu())) {
                        jSONObject3.put("abtest", iVar.aIu());
                        vVar.tV("1");
                    }
                    if (!TextUtils.isEmpty(iVar.getCategory())) {
                        jSONObject3.put("c", iVar.getCategory());
                    }
                    if (iVar.aIq()) {
                        jSONObject3.put("of", "1");
                    }
                    jSONObject3.put("idtype", this.dpw.tK(iVar.getId()));
                    vVar.cx(jSONObject3);
                    vVar.s(iVar.getTime(), iVar.getTime());
                } catch (JSONException e2) {
                }
            }
            if (this.dpt == null) {
                aHS();
            }
            if (this.dpt.size() > 0) {
                this.dpm.a(this.dpt.valueAt(0), vVar);
            }
            c(vVar);
            aHW();
            return true;
        }
        return false;
    }

    private void aHU() {
        if (dx(this.mContext) && aHV()) {
            v vVar = new v();
            vVar.gp(true);
            if (this.dpt == null) {
                aHS();
            }
            if (this.dpt.size() > 0) {
                if (e.aIh().akS()) {
                    this.dpm.a(vVar);
                } else {
                    this.dpm.a(this.dpt.valueAt(0), vVar);
                }
            }
            c(vVar);
            aHW();
        }
    }

    private boolean aHV() {
        if (e.aIh().akS()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.dpr) > 86400000) {
            this.dps = 0;
            this.dpr = currentTimeMillis;
            u.aIQ().putLong("ubc_reset_real_time_count_time", this.dpr);
            u.aIQ().putInt("ubc_real_time_count", this.dps);
        }
        if (this.dps >= 1000) {
            if (this.dps == 1000) {
                this.dps++;
                e.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void aHW() {
        this.dps++;
        u.aIQ().putInt("ubc_real_time_count", this.dps);
    }

    private void aHX() {
        if (dx(this.mContext)) {
            this.dpq = System.currentTimeMillis();
            u.aIQ().putLong("ubc_last_upload_non_real", this.dpq);
            aHZ();
            aHT();
            this.dpm.aHM();
            HashSet hashSet = new HashSet();
            if (this.dpt == null) {
                aHS();
            }
            v vVar = new v();
            vVar.gp(false);
            int i = 0;
            for (int i2 = 0; i2 < this.dpt.size(); i2++) {
                int keyAt = this.dpt.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.dpu.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.dpw.aIe()) {
                        i |= this.dpm.a(this.dpt.valueAt(i2), vVar);
                        this.dpu.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.dpt.size(); i3++) {
                    int keyAt2 = this.dpt.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (vVar.jC(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.dpm.a(this.dpt.valueAt(i3), vVar);
                    }
                }
                c(vVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aHY() {
        if (dx(this.mContext) && Math.abs(System.currentTimeMillis() - this.dpp) >= BdKVCache.MILLS_1Hour) {
            this.dpm.aHM();
            v vVar = new v();
            if (this.dpm.a(vVar) != 0) {
                v vVar2 = new v();
                vVar2.s(vVar.aIW(), vVar.getMaxTime());
                vVar2.tV(vVar.aIV());
                vVar2.gp(true);
                v vVar3 = new v();
                vVar3.s(vVar.aIW(), vVar.getMaxTime());
                vVar3.tV(vVar.aIV());
                vVar3.gp(false);
                SparseArray<Integer> aIS = vVar.aIS();
                int size = aIS.size();
                for (int i = 0; i < size; i++) {
                    if (this.dpw.tE(String.valueOf(aIS.valueAt(i).intValue()))) {
                        vVar2.aw(aIS.keyAt(i), aIS.valueAt(i).intValue());
                    } else {
                        vVar3.aw(aIS.keyAt(i), aIS.valueAt(i).intValue());
                    }
                }
                ArrayList aIT = vVar.aIT();
                int size2 = aIT.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) aIT.get(i2);
                    if (this.dpw.tE(str)) {
                        vVar2.tU(str);
                    } else {
                        vVar3.tU(str);
                    }
                }
                JSONArray aIX = vVar.aIX();
                int length = aIX.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = aIX.optJSONObject(i3);
                    if (optJSONObject.has("bizId")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("bizId");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.dpw.tE(str2)) {
                                vVar2.cx(optJSONObject);
                            } else {
                                vVar3.cx(optJSONObject);
                            }
                        }
                    }
                }
                if (vVar2.aIX().length() > 0) {
                    c(vVar2);
                }
                if (vVar3.aIX().length() > 0) {
                    c(vVar3);
                }
                this.dpp = System.currentTimeMillis();
                u.aIQ().putLong("ubc_last_upload_all_time", this.dpp);
                this.dpq = this.dpp;
                u.aIQ().putLong("ubc_last_upload_non_real", this.dpq);
            }
        }
    }

    private void c(v vVar) {
        if (!vVar.isEmpty()) {
            JSONArray aIU = vVar.aIU();
            String md5 = com.baidu.swan.e.e.toMd5(aIU.toString().getBytes(), true);
            cP(aIU.toString(), md5);
            this.dpm.ai(md5, vVar.aIY());
            if (!this.dpm.a(vVar.aIS(), vVar.aIT(), vVar.aIY(), md5)) {
                vVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", md5);
                if (file.exists() && file.delete()) {
                    Log.d("CeresBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.dpm.tz(md5);
                return;
            }
            n.aID().d(aIU, md5);
            vVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(JSONArray jSONArray, String str) {
        if (this.dpv.E(jSONArray)) {
            n.aID().aj(str, true);
        } else {
            n.aID().aj(str, false);
        }
    }

    private void aHZ() {
        gm(true);
        gm(false);
    }

    private void gm(boolean z) {
        v vVar = new v();
        vVar.gp(z);
        if (this.dpn.a(vVar, z)) {
            JSONArray aIU = vVar.aIU();
            this.dpn.gl(z);
            n.aID().H(aIU);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(JSONArray jSONArray) {
        if (!this.dpv.E(jSONArray)) {
            e.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a aIa() {
        return this.dpm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(q qVar) {
        this.dpw.ar(qVar.aIK());
        this.dpw.ju(qVar.aIJ() * 86400000);
        this.dpw.jv(qVar.aII());
        u.aIQ().putString("ubc_version_md5", qVar.getSign());
        this.dpm.aq(qVar.aIK());
        qVar.aIK().clear();
        if (this.dpt == null) {
            this.dpt = new SparseArray<>();
        }
        this.dpt.clear();
        if (this.dpu == null) {
            this.dpu = new HashMap<>();
        }
        this.dpu.clear();
        this.dpm.b(this.dpt);
        int i = 0;
        for (int i2 = 0; i2 < this.dpt.size(); i2++) {
            int keyAt = this.dpt.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.dpu.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.dpw.jt(i);
    }

    @SuppressLint({"MissingPermission"})
    private boolean dx(Context context) {
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

    private void cP(String str, String str2) {
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
                t.tT("save to file suc");
                com.baidu.swan.e.d.closeSafely(outputStream);
            } catch (Exception e2) {
                e = e2;
                outputStream = fileOutputStream;
                e.printStackTrace();
                com.baidu.swan.e.d.closeSafely(outputStream);
            } catch (Throwable th2) {
                th = th2;
                outputStream = fileOutputStream;
                com.baidu.swan.e.d.closeSafely(outputStream);
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void tB(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", str);
        t.tT("delete file");
        if (file.exists() && file.delete()) {
            Log.d("CeresBehaviorModel", "deleteUploadFile file suc");
            t.tT("delete file suc");
        }
        this.dpm.tz(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void tC(String str) {
        t.tT("upload file fail");
        this.dpm.tA(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aIb() {
        File[] listFiles;
        if (dx(this.mContext)) {
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
                    this.dpm.aHN();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    j ty = this.dpm.ty(listFiles[i].getName());
                    if (ty != null && TextUtils.equals("0", ty.aIy())) {
                        t.tT("processFailedData file, no need to send");
                    } else if (ty != null && TextUtils.equals("1", ty.aIy())) {
                        t.tT("processFailedData file, send");
                        this.dpm.cO(listFiles[i].getName(), "0");
                        tD(listFiles[i].getName());
                    } else {
                        t.tT("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    void tD(String str) {
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
                                n.aID().d(new JSONArray(com.baidu.swan.e.h.getStringFromInput(inputStream2)), str);
                                com.baidu.swan.e.d.closeSafely(inputStream2);
                            } catch (Throwable th2) {
                                inputStream = inputStream2;
                                th = th2;
                                com.baidu.swan.e.d.closeSafely(inputStream);
                                throw th;
                            }
                        }
                    } catch (Exception e) {
                        inputStream2 = inputStream;
                        com.baidu.swan.e.d.closeSafely(inputStream2);
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                inputStream2 = inputStream;
                com.baidu.swan.e.d.closeSafely(inputStream2);
            } catch (Throwable th4) {
                inputStream = null;
                th = th4;
            }
        } catch (Exception e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aIc() {
        this.dpm.aHO();
    }
}
