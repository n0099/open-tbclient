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
    private a dJa;
    private b dJb;
    private long dJd;
    private long dJe;
    private long dJf;
    private int dJg;
    private SparseArray<ArrayList> dJh;
    private HashMap<String, Long> dJi;
    private d dJk;
    private Context mContext;
    private m dJj = e.aVF().aaB();
    private List<i> dJc = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.dJa = new a(context);
        this.dJb = new b(context);
        u aWn = u.aWn();
        this.dJd = aWn.getLong("ubc_last_upload_all_time", 0L);
        this.dJe = aWn.getLong("ubc_last_upload_non_real", 0L);
        this.dJf = aWn.getLong("ubc_reset_real_time_count_time", 0L);
        this.dJg = aWn.getInt("ubc_real_time_count", 0);
        this.dJk = d.aVB();
        this.dJk.a(this, context);
    }

    private void aVq() {
        if (this.dJh == null) {
            this.dJh = new SparseArray<>();
            this.dJa.b(this.dJh);
            this.dJi = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.dJh.size(); i2++) {
                int keyAt = this.dJh.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.dJi.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.dJk.md(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(i iVar) {
        boolean z = false;
        if (TextUtils.equals(iVar.getId(), iVar.aVQ()) && this.dJk.xb(iVar.getId()) && (iVar.getOption() & 64) == 0) {
            z = true;
        }
        if (z && !c(iVar)) {
            this.dJa.a(iVar);
        } else if (Math.abs(System.currentTimeMillis() - this.dJe) >= d.aVB().aVC()) {
            if (!z) {
                this.dJc.add(iVar);
            }
            aVv();
        } else if ((iVar.getOption() & 1) == 0) {
            if (!z) {
                this.dJc.add(iVar);
            }
            if (this.dJc.size() >= 20) {
                aVr();
            }
        } else if (!z) {
            this.dJa.a(iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(i iVar) {
        this.dJb.a(iVar, this.dJk.xb(iVar.getId()));
    }

    private void aVr() {
        if (this.dJc != null && this.dJc.size() != 0) {
            this.dJa.az(this.dJc);
            this.dJc.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(k kVar) {
        this.dJa.a(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, int i, String str2) {
        this.dJa.f(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        aVr();
        this.dJa.a(str, i, j, jSONArray);
        if (this.dJk.xb(str)) {
            aVs();
        }
        if (Math.abs(System.currentTimeMillis() - this.dJe) >= d.aVB().aVC()) {
            aVv();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(String str, int i) {
        aVr();
        this.dJa.H(str, i);
        if (Math.abs(System.currentTimeMillis() - this.dJe) >= d.aVB().aVC()) {
            aVv();
        }
    }

    private boolean c(i iVar) {
        if (dI(this.mContext) && aVt()) {
            aVr();
            v vVar = new v();
            vVar.hk(true);
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
                        vVar.xs("1");
                    }
                    if (!TextUtils.isEmpty(iVar.getCategory())) {
                        jSONObject3.put("c", iVar.getCategory());
                    }
                    if (iVar.aVO()) {
                        jSONObject3.put(MapBundleKey.MapObjKey.OBJ_OFFSET, "1");
                    }
                    jSONObject3.put("idtype", this.dJk.xh(iVar.getId()));
                    vVar.cQ(jSONObject3);
                    vVar.u(iVar.getTime(), iVar.getTime());
                } catch (JSONException e2) {
                }
            }
            if (this.dJh == null) {
                aVq();
            }
            if (this.dJh.size() > 0) {
                this.dJa.a(this.dJh.valueAt(0), vVar);
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
            vVar.hk(true);
            if (this.dJh == null) {
                aVq();
            }
            if (this.dJh.size() > 0) {
                if (e.aVF().avm()) {
                    this.dJa.a(vVar);
                } else {
                    this.dJa.a(this.dJh.valueAt(0), vVar);
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
        if (Math.abs(currentTimeMillis - this.dJf) > 86400000) {
            this.dJg = 0;
            this.dJf = currentTimeMillis;
            u.aWn().putLong("ubc_reset_real_time_count_time", this.dJf);
            u.aWn().putInt("ubc_real_time_count", this.dJg);
        }
        if (this.dJg >= 1000) {
            if (this.dJg == 1000) {
                this.dJg++;
                e.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void aVu() {
        this.dJg++;
        u.aWn().putInt("ubc_real_time_count", this.dJg);
    }

    private void aVv() {
        if (dI(this.mContext)) {
            this.dJe = System.currentTimeMillis();
            u.aWn().putLong("ubc_last_upload_non_real", this.dJe);
            aVx();
            aVr();
            this.dJa.aVk();
            HashSet hashSet = new HashSet();
            if (this.dJh == null) {
                aVq();
            }
            v vVar = new v();
            vVar.hk(false);
            int i = 0;
            for (int i2 = 0; i2 < this.dJh.size(); i2++) {
                int keyAt = this.dJh.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.dJi.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.dJk.aVC()) {
                        i |= this.dJa.a(this.dJh.valueAt(i2), vVar);
                        this.dJi.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.dJh.size(); i3++) {
                    int keyAt2 = this.dJh.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (vVar.mm(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.dJa.a(this.dJh.valueAt(i3), vVar);
                    }
                }
                c(vVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aVw() {
        if (dI(this.mContext) && Math.abs(System.currentTimeMillis() - this.dJd) >= BdKVCache.MILLS_1Hour) {
            this.dJa.aVk();
            v vVar = new v();
            if (this.dJa.a(vVar) != 0) {
                v vVar2 = new v();
                vVar2.u(vVar.aWt(), vVar.getMaxTime());
                vVar2.xs(vVar.aWs());
                vVar2.hk(true);
                v vVar3 = new v();
                vVar3.u(vVar.aWt(), vVar.getMaxTime());
                vVar3.xs(vVar.aWs());
                vVar3.hk(false);
                SparseArray<Integer> aWp = vVar.aWp();
                int size = aWp.size();
                for (int i = 0; i < size; i++) {
                    if (this.dJk.xb(String.valueOf(aWp.valueAt(i).intValue()))) {
                        vVar2.aF(aWp.keyAt(i), aWp.valueAt(i).intValue());
                    } else {
                        vVar3.aF(aWp.keyAt(i), aWp.valueAt(i).intValue());
                    }
                }
                ArrayList aWq = vVar.aWq();
                int size2 = aWq.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) aWq.get(i2);
                    if (this.dJk.xb(str)) {
                        vVar2.xr(str);
                    } else {
                        vVar3.xr(str);
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
                            if (this.dJk.xb(str2)) {
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
                this.dJd = System.currentTimeMillis();
                u.aWn().putLong("ubc_last_upload_all_time", this.dJd);
                this.dJe = this.dJd;
                u.aWn().putLong("ubc_last_upload_non_real", this.dJe);
            }
        }
    }

    private void c(v vVar) {
        if (!vVar.isEmpty()) {
            JSONArray aWr = vVar.aWr();
            String md5 = com.baidu.swan.c.e.toMd5(aWr.toString().getBytes(), true);
            dk(aWr.toString(), md5);
            this.dJa.an(md5, vVar.aWv());
            if (!this.dJa.a(vVar.aWp(), vVar.aWq(), vVar.aWv(), md5)) {
                vVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", md5);
                if (file.exists() && file.delete()) {
                    Log.d("CeresBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.dJa.wW(md5);
                return;
            }
            n.aWb().d(aWr, md5);
            vVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(JSONArray jSONArray, String str) {
        if (this.dJj.H(jSONArray)) {
            n.aWb().ao(str, true);
        } else {
            n.aWb().ao(str, false);
        }
    }

    private void aVx() {
        hh(true);
        hh(false);
    }

    private void hh(boolean z) {
        v vVar = new v();
        vVar.hk(z);
        if (this.dJb.a(vVar, z)) {
            JSONArray aWr = vVar.aWr();
            this.dJb.hg(z);
            n.aWb().K(aWr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(JSONArray jSONArray) {
        if (!this.dJj.H(jSONArray)) {
            e.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a aVy() {
        return this.dJa;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(q qVar) {
        this.dJk.aB(qVar.aWh());
        this.dJk.me(qVar.aWg() * 86400000);
        this.dJk.mf(qVar.aWf());
        u.aWn().putString("ubc_version_md5", qVar.getSign());
        this.dJa.aA(qVar.aWh());
        qVar.aWh().clear();
        if (this.dJh == null) {
            this.dJh = new SparseArray<>();
        }
        this.dJh.clear();
        if (this.dJi == null) {
            this.dJi = new HashMap<>();
        }
        this.dJi.clear();
        this.dJa.b(this.dJh);
        int i = 0;
        for (int i2 = 0; i2 < this.dJh.size(); i2++) {
            int keyAt = this.dJh.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.dJi.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.dJk.md(i);
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
                t.xq("save to file suc");
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
    public void wY(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", str);
        t.xq("delete file");
        if (file.exists() && file.delete()) {
            Log.d("CeresBehaviorModel", "deleteUploadFile file suc");
            t.xq("delete file suc");
        }
        this.dJa.wW(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void wZ(String str) {
        t.xq("upload file fail");
        this.dJa.wX(str);
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
                    this.dJa.aVl();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    j wV = this.dJa.wV(listFiles[i].getName());
                    if (wV != null && TextUtils.equals("0", wV.aVW())) {
                        t.xq("processFailedData file, no need to send");
                    } else if (wV != null && TextUtils.equals("1", wV.aVW())) {
                        t.xq("processFailedData file, send");
                        this.dJa.dj(listFiles[i].getName(), "0");
                        xa(listFiles[i].getName());
                    } else {
                        t.xq("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    void xa(String str) {
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
        this.dJa.aVm();
    }
}
