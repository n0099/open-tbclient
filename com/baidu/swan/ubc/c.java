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
/* loaded from: classes10.dex */
public class c {
    private a dIW;
    private b dIX;
    private long dIZ;
    private long dJa;
    private long dJb;
    private int dJc;
    private SparseArray<ArrayList> dJd;
    private HashMap<String, Long> dJe;
    private d dJg;
    private Context mContext;
    private m dJf = e.aVF().aaB();
    private List<i> dIY = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.dIW = new a(context);
        this.dIX = new b(context);
        u aWn = u.aWn();
        this.dIZ = aWn.getLong("ubc_last_upload_all_time", 0L);
        this.dJa = aWn.getLong("ubc_last_upload_non_real", 0L);
        this.dJb = aWn.getLong("ubc_reset_real_time_count_time", 0L);
        this.dJc = aWn.getInt("ubc_real_time_count", 0);
        this.dJg = d.aVB();
        this.dJg.a(this, context);
    }

    private void aVq() {
        if (this.dJd == null) {
            this.dJd = new SparseArray<>();
            this.dIW.b(this.dJd);
            this.dJe = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.dJd.size(); i2++) {
                int keyAt = this.dJd.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.dJe.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.dJg.md(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(i iVar) {
        boolean z = false;
        if (TextUtils.equals(iVar.getId(), iVar.aVQ()) && this.dJg.xa(iVar.getId()) && (iVar.getOption() & 64) == 0) {
            z = true;
        }
        if (z && !c(iVar)) {
            this.dIW.a(iVar);
        } else if (Math.abs(System.currentTimeMillis() - this.dJa) >= d.aVB().aVC()) {
            if (!z) {
                this.dIY.add(iVar);
            }
            aVv();
        } else if ((iVar.getOption() & 1) == 0) {
            if (!z) {
                this.dIY.add(iVar);
            }
            if (this.dIY.size() >= 20) {
                aVr();
            }
        } else if (!z) {
            this.dIW.a(iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(i iVar) {
        this.dIX.a(iVar, this.dJg.xa(iVar.getId()));
    }

    private void aVr() {
        if (this.dIY != null && this.dIY.size() != 0) {
            this.dIW.az(this.dIY);
            this.dIY.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(k kVar) {
        this.dIW.a(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, int i, String str2) {
        this.dIW.f(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        aVr();
        this.dIW.a(str, i, j, jSONArray);
        if (this.dJg.xa(str)) {
            aVs();
        }
        if (Math.abs(System.currentTimeMillis() - this.dJa) >= d.aVB().aVC()) {
            aVv();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(String str, int i) {
        aVr();
        this.dIW.H(str, i);
        if (Math.abs(System.currentTimeMillis() - this.dJa) >= d.aVB().aVC()) {
            aVv();
        }
    }

    private boolean c(i iVar) {
        if (dI(this.mContext) && aVt()) {
            aVr();
            v vVar = new v();
            vVar.hj(true);
            JSONObject aVT = iVar.aVT();
            if (aVT != null && aVT.has("bizId")) {
                s.cO(aVT);
                vVar.cQ(aVT);
                vVar.u(iVar.getTime(), iVar.getTime());
                try {
                    JSONObject jSONObject = aVT.getJSONObject("content");
                    JSONObject jSONObject2 = aVT.getJSONObject("appInfo");
                    if (jSONObject != null && jSONObject2 != null) {
                        jSONObject.put("appInfo", jSONObject2);
                        aVT.remove("appInfo");
                    }
                } catch (JSONException e) {
                }
            } else {
                try {
                    JSONObject jSONObject3 = new s(iVar.aVU()).toJSONObject();
                    jSONObject3.put("bizId", iVar.getId());
                    jSONObject3.put("timestamp", Long.toString(iVar.getTime()));
                    if (iVar.aVT() != null) {
                        jSONObject3.put("content", iVar.aVT());
                    } else {
                        jSONObject3.put("content", iVar.getContent());
                    }
                    jSONObject3.put("eventType", "0");
                    if (!TextUtils.isEmpty(iVar.aVS())) {
                        jSONObject3.put("abtest", iVar.aVS());
                        vVar.xr("1");
                    }
                    if (!TextUtils.isEmpty(iVar.getCategory())) {
                        jSONObject3.put("c", iVar.getCategory());
                    }
                    if (iVar.aVO()) {
                        jSONObject3.put(MapBundleKey.MapObjKey.OBJ_OFFSET, "1");
                    }
                    jSONObject3.put("idtype", this.dJg.xg(iVar.getId()));
                    vVar.cQ(jSONObject3);
                    vVar.u(iVar.getTime(), iVar.getTime());
                } catch (JSONException e2) {
                }
            }
            if (this.dJd == null) {
                aVq();
            }
            if (this.dJd.size() > 0) {
                this.dIW.a(this.dJd.valueAt(0), vVar);
            }
            c(vVar);
            aVu();
            return true;
        }
        return false;
    }

    private void aVs() {
        if (dI(this.mContext) && aVt()) {
            v vVar = new v();
            vVar.hj(true);
            if (this.dJd == null) {
                aVq();
            }
            if (this.dJd.size() > 0) {
                if (e.aVF().avm()) {
                    this.dIW.a(vVar);
                } else {
                    this.dIW.a(this.dJd.valueAt(0), vVar);
                }
            }
            c(vVar);
            aVu();
        }
    }

    private boolean aVt() {
        if (e.aVF().avm()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.dJb) > 86400000) {
            this.dJc = 0;
            this.dJb = currentTimeMillis;
            u.aWn().putLong("ubc_reset_real_time_count_time", this.dJb);
            u.aWn().putInt("ubc_real_time_count", this.dJc);
        }
        if (this.dJc >= 1000) {
            if (this.dJc == 1000) {
                this.dJc++;
                e.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void aVu() {
        this.dJc++;
        u.aWn().putInt("ubc_real_time_count", this.dJc);
    }

    private void aVv() {
        if (dI(this.mContext)) {
            this.dJa = System.currentTimeMillis();
            u.aWn().putLong("ubc_last_upload_non_real", this.dJa);
            aVx();
            aVr();
            this.dIW.aVk();
            HashSet hashSet = new HashSet();
            if (this.dJd == null) {
                aVq();
            }
            v vVar = new v();
            vVar.hj(false);
            int i = 0;
            for (int i2 = 0; i2 < this.dJd.size(); i2++) {
                int keyAt = this.dJd.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.dJe.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.dJg.aVC()) {
                        i |= this.dIW.a(this.dJd.valueAt(i2), vVar);
                        this.dJe.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.dJd.size(); i3++) {
                    int keyAt2 = this.dJd.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (vVar.mm(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.dIW.a(this.dJd.valueAt(i3), vVar);
                    }
                }
                c(vVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aVw() {
        if (dI(this.mContext) && Math.abs(System.currentTimeMillis() - this.dIZ) >= BdKVCache.MILLS_1Hour) {
            this.dIW.aVk();
            v vVar = new v();
            if (this.dIW.a(vVar) != 0) {
                v vVar2 = new v();
                vVar2.u(vVar.aWt(), vVar.getMaxTime());
                vVar2.xr(vVar.aWs());
                vVar2.hj(true);
                v vVar3 = new v();
                vVar3.u(vVar.aWt(), vVar.getMaxTime());
                vVar3.xr(vVar.aWs());
                vVar3.hj(false);
                SparseArray<Integer> aWp = vVar.aWp();
                int size = aWp.size();
                for (int i = 0; i < size; i++) {
                    if (this.dJg.xa(String.valueOf(aWp.valueAt(i).intValue()))) {
                        vVar2.aF(aWp.keyAt(i), aWp.valueAt(i).intValue());
                    } else {
                        vVar3.aF(aWp.keyAt(i), aWp.valueAt(i).intValue());
                    }
                }
                ArrayList aWq = vVar.aWq();
                int size2 = aWq.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) aWq.get(i2);
                    if (this.dJg.xa(str)) {
                        vVar2.xq(str);
                    } else {
                        vVar3.xq(str);
                    }
                }
                JSONArray aWu = vVar.aWu();
                int length = aWu.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = aWu.optJSONObject(i3);
                    if (optJSONObject.has("bizId")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("bizId");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.dJg.xa(str2)) {
                                vVar2.cQ(optJSONObject);
                            } else {
                                vVar3.cQ(optJSONObject);
                            }
                        }
                    }
                }
                if (vVar2.aWu().length() > 0) {
                    c(vVar2);
                }
                if (vVar3.aWu().length() > 0) {
                    c(vVar3);
                }
                this.dIZ = System.currentTimeMillis();
                u.aWn().putLong("ubc_last_upload_all_time", this.dIZ);
                this.dJa = this.dIZ;
                u.aWn().putLong("ubc_last_upload_non_real", this.dJa);
            }
        }
    }

    private void c(v vVar) {
        if (!vVar.isEmpty()) {
            JSONArray aWr = vVar.aWr();
            String md5 = com.baidu.swan.c.e.toMd5(aWr.toString().getBytes(), true);
            dk(aWr.toString(), md5);
            this.dIW.an(md5, vVar.aWv());
            if (!this.dIW.a(vVar.aWp(), vVar.aWq(), vVar.aWv(), md5)) {
                vVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", md5);
                if (file.exists() && file.delete()) {
                    Log.d("CeresBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.dIW.wV(md5);
                return;
            }
            n.aWb().d(aWr, md5);
            vVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(JSONArray jSONArray, String str) {
        if (this.dJf.H(jSONArray)) {
            n.aWb().ao(str, true);
        } else {
            n.aWb().ao(str, false);
        }
    }

    private void aVx() {
        hg(true);
        hg(false);
    }

    private void hg(boolean z) {
        v vVar = new v();
        vVar.hj(z);
        if (this.dIX.a(vVar, z)) {
            JSONArray aWr = vVar.aWr();
            this.dIX.hf(z);
            n.aWb().K(aWr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(JSONArray jSONArray) {
        if (!this.dJf.H(jSONArray)) {
            e.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a aVy() {
        return this.dIW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(q qVar) {
        this.dJg.aB(qVar.aWh());
        this.dJg.me(qVar.aWg() * 86400000);
        this.dJg.mf(qVar.aWf());
        u.aWn().putString("ubc_version_md5", qVar.getSign());
        this.dIW.aA(qVar.aWh());
        qVar.aWh().clear();
        if (this.dJd == null) {
            this.dJd = new SparseArray<>();
        }
        this.dJd.clear();
        if (this.dJe == null) {
            this.dJe = new HashMap<>();
        }
        this.dJe.clear();
        this.dIW.b(this.dJd);
        int i = 0;
        for (int i2 = 0; i2 < this.dJd.size(); i2++) {
            int keyAt = this.dJd.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.dJe.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.dJg.md(i);
    }

    @SuppressLint({"MissingPermission"})
    private boolean dI(Context context) {
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

    private void dk(String str, String str2) {
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
                t.xp("save to file suc");
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
    public void wX(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", str);
        t.xp("delete file");
        if (file.exists() && file.delete()) {
            Log.d("CeresBehaviorModel", "deleteUploadFile file suc");
            t.xp("delete file suc");
        }
        this.dIW.wV(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void wY(String str) {
        t.xp("upload file fail");
        this.dIW.wW(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aVz() {
        File[] listFiles;
        if (dI(this.mContext)) {
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
                    this.dIW.aVl();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    j wU = this.dIW.wU(listFiles[i].getName());
                    if (wU != null && TextUtils.equals("0", wU.aVW())) {
                        t.xp("processFailedData file, no need to send");
                    } else if (wU != null && TextUtils.equals("1", wU.aVW())) {
                        t.xp("processFailedData file, send");
                        this.dIW.dj(listFiles[i].getName(), "0");
                        wZ(listFiles[i].getName());
                    } else {
                        t.xp("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    void wZ(String str) {
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
                                n.aWb().d(new JSONArray(com.baidu.swan.c.g.getStringFromInput(inputStream2)), str);
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
    public void aVA() {
        this.dIW.aVm();
    }
}
