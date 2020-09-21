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
/* loaded from: classes14.dex */
public class c {
    private a dLe;
    private b dLf;
    private long dLh;
    private long dLi;
    private long dLj;
    private int dLk;
    private SparseArray<ArrayList> dLl;
    private HashMap<String, Long> dLm;
    private d dLo;
    private Context mContext;
    private m dLn = e.aWr().abk();
    private List<i> dLg = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.dLe = new a(context);
        this.dLf = new b(context);
        u aWZ = u.aWZ();
        this.dLh = aWZ.getLong("ubc_last_upload_all_time", 0L);
        this.dLi = aWZ.getLong("ubc_last_upload_non_real", 0L);
        this.dLj = aWZ.getLong("ubc_reset_real_time_count_time", 0L);
        this.dLk = aWZ.getInt("ubc_real_time_count", 0);
        this.dLo = d.aWn();
        this.dLo.a(this, context);
    }

    private void aWc() {
        if (this.dLl == null) {
            this.dLl = new SparseArray<>();
            this.dLe.b(this.dLl);
            this.dLm = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.dLl.size(); i2++) {
                int keyAt = this.dLl.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.dLm.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.dLo.mo(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(i iVar) {
        boolean z = false;
        if (TextUtils.equals(iVar.getId(), iVar.aWC()) && this.dLo.xu(iVar.getId()) && (iVar.getOption() & 64) == 0) {
            z = true;
        }
        if (z && !c(iVar)) {
            this.dLe.a(iVar);
        } else if (Math.abs(System.currentTimeMillis() - this.dLi) >= d.aWn().aWo()) {
            if (!z) {
                this.dLg.add(iVar);
            }
            aWh();
        } else if ((iVar.getOption() & 1) == 0) {
            if (!z) {
                this.dLg.add(iVar);
            }
            if (this.dLg.size() >= 20) {
                aWd();
            }
        } else if (!z) {
            this.dLe.a(iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(i iVar) {
        this.dLf.a(iVar, this.dLo.xu(iVar.getId()));
    }

    private void aWd() {
        if (this.dLg != null && this.dLg.size() != 0) {
            this.dLe.aD(this.dLg);
            this.dLg.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(k kVar) {
        this.dLe.a(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, int i, String str2) {
        this.dLe.f(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        aWd();
        this.dLe.a(str, i, j, jSONArray);
        if (this.dLo.xu(str)) {
            aWe();
        }
        if (Math.abs(System.currentTimeMillis() - this.dLi) >= d.aWn().aWo()) {
            aWh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(String str, int i) {
        aWd();
        this.dLe.H(str, i);
        if (Math.abs(System.currentTimeMillis() - this.dLi) >= d.aWn().aWo()) {
            aWh();
        }
    }

    private boolean c(i iVar) {
        if (dH(this.mContext) && aWf()) {
            aWd();
            v vVar = new v();
            vVar.hi(true);
            JSONObject aWF = iVar.aWF();
            if (aWF != null && aWF.has("bizId")) {
                s.cR(aWF);
                vVar.cT(aWF);
                vVar.q(iVar.getTime(), iVar.getTime());
                try {
                    JSONObject jSONObject = aWF.getJSONObject("content");
                    JSONObject jSONObject2 = aWF.getJSONObject("appInfo");
                    if (jSONObject != null && jSONObject2 != null) {
                        jSONObject.put("appInfo", jSONObject2);
                        aWF.remove("appInfo");
                    }
                } catch (JSONException e) {
                }
            } else {
                try {
                    JSONObject jSONObject3 = new s(iVar.aWG()).toJSONObject();
                    jSONObject3.put("bizId", iVar.getId());
                    jSONObject3.put("timestamp", Long.toString(iVar.getTime()));
                    if (iVar.aWF() != null) {
                        jSONObject3.put("content", iVar.aWF());
                    } else {
                        jSONObject3.put("content", iVar.getContent());
                    }
                    jSONObject3.put("eventType", "0");
                    if (!TextUtils.isEmpty(iVar.aWE())) {
                        jSONObject3.put("abtest", iVar.aWE());
                        vVar.xL("1");
                    }
                    if (!TextUtils.isEmpty(iVar.getCategory())) {
                        jSONObject3.put("c", iVar.getCategory());
                    }
                    if (iVar.aWA()) {
                        jSONObject3.put(MapBundleKey.MapObjKey.OBJ_OFFSET, "1");
                    }
                    jSONObject3.put("idtype", this.dLo.xA(iVar.getId()));
                    vVar.cT(jSONObject3);
                    vVar.q(iVar.getTime(), iVar.getTime());
                } catch (JSONException e2) {
                }
            }
            if (this.dLl == null) {
                aWc();
            }
            if (this.dLl.size() > 0) {
                this.dLe.a(this.dLl.valueAt(0), vVar);
            }
            c(vVar);
            aWg();
            return true;
        }
        return false;
    }

    private void aWe() {
        if (dH(this.mContext) && aWf()) {
            v vVar = new v();
            vVar.hi(true);
            if (this.dLl == null) {
                aWc();
            }
            if (this.dLl.size() > 0) {
                if (e.aWr().avV()) {
                    this.dLe.a(vVar);
                } else {
                    this.dLe.a(this.dLl.valueAt(0), vVar);
                }
            }
            c(vVar);
            aWg();
        }
    }

    private boolean aWf() {
        if (e.aWr().avV()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.dLj) > 86400000) {
            this.dLk = 0;
            this.dLj = currentTimeMillis;
            u.aWZ().putLong("ubc_reset_real_time_count_time", this.dLj);
            u.aWZ().putInt("ubc_real_time_count", this.dLk);
        }
        if (this.dLk >= 1000) {
            if (this.dLk == 1000) {
                this.dLk++;
                e.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void aWg() {
        this.dLk++;
        u.aWZ().putInt("ubc_real_time_count", this.dLk);
    }

    private void aWh() {
        if (dH(this.mContext)) {
            this.dLi = System.currentTimeMillis();
            u.aWZ().putLong("ubc_last_upload_non_real", this.dLi);
            aWj();
            aWd();
            this.dLe.aVW();
            HashSet hashSet = new HashSet();
            if (this.dLl == null) {
                aWc();
            }
            v vVar = new v();
            vVar.hi(false);
            int i = 0;
            for (int i2 = 0; i2 < this.dLl.size(); i2++) {
                int keyAt = this.dLl.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.dLm.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.dLo.aWo()) {
                        i |= this.dLe.a(this.dLl.valueAt(i2), vVar);
                        this.dLm.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.dLl.size(); i3++) {
                    int keyAt2 = this.dLl.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (vVar.mx(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.dLe.a(this.dLl.valueAt(i3), vVar);
                    }
                }
                c(vVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aWi() {
        if (dH(this.mContext) && Math.abs(System.currentTimeMillis() - this.dLh) >= BdKVCache.MILLS_1Hour) {
            this.dLe.aVW();
            v vVar = new v();
            if (this.dLe.a(vVar) != 0) {
                v vVar2 = new v();
                vVar2.q(vVar.aXf(), vVar.getMaxTime());
                vVar2.xL(vVar.aXe());
                vVar2.hi(true);
                v vVar3 = new v();
                vVar3.q(vVar.aXf(), vVar.getMaxTime());
                vVar3.xL(vVar.aXe());
                vVar3.hi(false);
                SparseArray<Integer> aXb = vVar.aXb();
                int size = aXb.size();
                for (int i = 0; i < size; i++) {
                    if (this.dLo.xu(String.valueOf(aXb.valueAt(i).intValue()))) {
                        vVar2.aF(aXb.keyAt(i), aXb.valueAt(i).intValue());
                    } else {
                        vVar3.aF(aXb.keyAt(i), aXb.valueAt(i).intValue());
                    }
                }
                ArrayList aXc = vVar.aXc();
                int size2 = aXc.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) aXc.get(i2);
                    if (this.dLo.xu(str)) {
                        vVar2.xK(str);
                    } else {
                        vVar3.xK(str);
                    }
                }
                JSONArray aXg = vVar.aXg();
                int length = aXg.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = aXg.optJSONObject(i3);
                    if (optJSONObject.has("bizId")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("bizId");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.dLo.xu(str2)) {
                                vVar2.cT(optJSONObject);
                            } else {
                                vVar3.cT(optJSONObject);
                            }
                        }
                    }
                }
                if (vVar2.aXg().length() > 0) {
                    c(vVar2);
                }
                if (vVar3.aXg().length() > 0) {
                    c(vVar3);
                }
                this.dLh = System.currentTimeMillis();
                u.aWZ().putLong("ubc_last_upload_all_time", this.dLh);
                this.dLi = this.dLh;
                u.aWZ().putLong("ubc_last_upload_non_real", this.dLi);
            }
        }
    }

    private void c(v vVar) {
        if (!vVar.isEmpty()) {
            JSONArray aXd = vVar.aXd();
            String md5 = com.baidu.swan.c.e.toMd5(aXd.toString().getBytes(), true);
            dk(aXd.toString(), md5);
            this.dLe.an(md5, vVar.aXh());
            if (!this.dLe.a(vVar.aXb(), vVar.aXc(), vVar.aXh(), md5)) {
                vVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", md5);
                if (file.exists() && file.delete()) {
                    Log.d("CeresBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.dLe.xp(md5);
                return;
            }
            n.aWN().d(aXd, md5);
            vVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(JSONArray jSONArray, String str) {
        if (this.dLn.H(jSONArray)) {
            n.aWN().ao(str, true);
        } else {
            n.aWN().ao(str, false);
        }
    }

    private void aWj() {
        hf(true);
        hf(false);
    }

    private void hf(boolean z) {
        v vVar = new v();
        vVar.hi(z);
        if (this.dLf.a(vVar, z)) {
            JSONArray aXd = vVar.aXd();
            this.dLf.he(z);
            n.aWN().K(aXd);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(JSONArray jSONArray) {
        if (!this.dLn.H(jSONArray)) {
            e.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a aWk() {
        return this.dLe;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(q qVar) {
        this.dLo.aF(qVar.aWT());
        this.dLo.mp(qVar.aWS() * 86400000);
        this.dLo.mq(qVar.aWR());
        u.aWZ().putString("ubc_version_md5", qVar.getSign());
        this.dLe.aE(qVar.aWT());
        qVar.aWT().clear();
        if (this.dLl == null) {
            this.dLl = new SparseArray<>();
        }
        this.dLl.clear();
        if (this.dLm == null) {
            this.dLm = new HashMap<>();
        }
        this.dLm.clear();
        this.dLe.b(this.dLl);
        int i = 0;
        for (int i2 = 0; i2 < this.dLl.size(); i2++) {
            int keyAt = this.dLl.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.dLm.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.dLo.mo(i);
    }

    @SuppressLint({"MissingPermission"})
    private boolean dH(Context context) {
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
                t.xJ("save to file suc");
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
    public void xr(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", str);
        t.xJ("delete file");
        if (file.exists() && file.delete()) {
            Log.d("CeresBehaviorModel", "deleteUploadFile file suc");
            t.xJ("delete file suc");
        }
        this.dLe.xp(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xs(String str) {
        t.xJ("upload file fail");
        this.dLe.xq(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aWl() {
        File[] listFiles;
        if (dH(this.mContext)) {
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
                    this.dLe.aVX();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    j xo = this.dLe.xo(listFiles[i].getName());
                    if (xo != null && TextUtils.equals("0", xo.aWI())) {
                        t.xJ("processFailedData file, no need to send");
                    } else if (xo != null && TextUtils.equals("1", xo.aWI())) {
                        t.xJ("processFailedData file, send");
                        this.dLe.dj(listFiles[i].getName(), "0");
                        xt(listFiles[i].getName());
                    } else {
                        t.xJ("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    void xt(String str) {
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
                                n.aWN().d(new JSONArray(com.baidu.swan.c.g.getStringFromInput(inputStream2)), str);
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
    public void aWm() {
        this.dLe.aVY();
    }
}
