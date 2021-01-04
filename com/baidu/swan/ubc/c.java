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
import com.kwad.sdk.collector.AppStatusRules;
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
/* loaded from: classes6.dex */
public class c {
    private b eAA;
    private long eAC;
    private long eAD;
    private long eAE;
    private int eAF;
    private SparseArray<ArrayList> eAG;
    private HashMap<String, Long> eAH;
    private d eAJ;
    private a eAz;
    private Context mContext;
    private m eAI = e.bin().ama();
    private List<i> eAB = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.eAz = new a(context);
        this.eAA = new b(context);
        u biV = u.biV();
        this.eAC = biV.getLong("ubc_last_upload_all_time", 0L);
        this.eAD = biV.getLong("ubc_last_upload_non_real", 0L);
        this.eAE = biV.getLong("ubc_reset_real_time_count_time", 0L);
        this.eAF = biV.getInt("ubc_real_time_count", 0);
        this.eAJ = d.bij();
        this.eAJ.a(this, context);
    }

    private void bhY() {
        int i = 0;
        if (this.eAG == null) {
            this.eAG = new SparseArray<>();
            this.eAz.e(this.eAG);
            this.eAH = new HashMap<>();
            int i2 = 0;
            while (true) {
                int i3 = i;
                if (i2 < this.eAG.size()) {
                    int keyAt = this.eAG.keyAt(i2);
                    i = (keyAt == 0 || i3 != 0) ? i3 : keyAt;
                    this.eAH.put("ubc_last_upload_time_level_" + keyAt, 0L);
                    i2++;
                } else {
                    this.eAJ.nJ(i3);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(i iVar) {
        boolean z = false;
        if (TextUtils.equals(iVar.getId(), iVar.biy()) && this.eAJ.zo(iVar.getId()) && (iVar.getOption() & 64) == 0) {
            z = true;
        }
        if (z && !c(iVar)) {
            this.eAz.a(iVar);
        } else if (Math.abs(System.currentTimeMillis() - this.eAD) >= d.bij().bik()) {
            if (!z) {
                this.eAB.add(iVar);
            }
            bid();
        } else if ((iVar.getOption() & 1) == 0) {
            if (!z) {
                this.eAB.add(iVar);
            }
            if (this.eAB.size() >= 20) {
                bhZ();
            }
        } else if (!z) {
            this.eAz.a(iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(i iVar) {
        this.eAA.a(iVar, this.eAJ.zo(iVar.getId()));
    }

    private void bhZ() {
        if (this.eAB != null && this.eAB.size() != 0) {
            this.eAz.bh(this.eAB);
            this.eAB.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(k kVar) {
        this.eAz.a(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str, int i, String str2) {
        this.eAz.i(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        bhZ();
        this.eAz.a(str, i, j, jSONArray);
        if (this.eAJ.zo(str)) {
            bia();
        }
        if (Math.abs(System.currentTimeMillis() - this.eAD) >= d.bij().bik()) {
            bid();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(String str, int i) {
        bhZ();
        this.eAz.M(str, i);
        if (Math.abs(System.currentTimeMillis() - this.eAD) >= d.bij().bik()) {
            bid();
        }
    }

    private boolean c(i iVar) {
        if (isNetWorkEnabled(this.mContext) && bib()) {
            bhZ();
            v vVar = new v();
            vVar.iN(true);
            JSONObject biB = iVar.biB();
            if (biB != null && biB.has("bizId")) {
                s.dl(biB);
                vVar.dn(biB);
                vVar.u(iVar.getTime(), iVar.getTime());
                try {
                    JSONObject jSONObject = biB.getJSONObject("content");
                    JSONObject jSONObject2 = biB.getJSONObject("appInfo");
                    if (jSONObject != null && jSONObject2 != null) {
                        jSONObject.put("appInfo", jSONObject2);
                        biB.remove("appInfo");
                    }
                } catch (JSONException e) {
                }
            } else {
                try {
                    JSONObject jSONObject3 = new s(iVar.biC()).toJSONObject();
                    jSONObject3.put("bizId", iVar.getId());
                    jSONObject3.put("timestamp", Long.toString(iVar.getTime()));
                    if (iVar.biB() != null) {
                        jSONObject3.put("content", iVar.biB());
                    } else {
                        jSONObject3.put("content", iVar.getContent());
                    }
                    jSONObject3.put("eventType", "0");
                    if (!TextUtils.isEmpty(iVar.biA())) {
                        jSONObject3.put("abtest", iVar.biA());
                        vVar.zF("1");
                    }
                    if (!TextUtils.isEmpty(iVar.getCategory())) {
                        jSONObject3.put("c", iVar.getCategory());
                    }
                    if (iVar.biw()) {
                        jSONObject3.put(MapBundleKey.MapObjKey.OBJ_OFFSET, "1");
                    }
                    jSONObject3.put("idtype", this.eAJ.zu(iVar.getId()));
                    vVar.dn(jSONObject3);
                    vVar.u(iVar.getTime(), iVar.getTime());
                } catch (JSONException e2) {
                }
            }
            if (this.eAG == null) {
                bhY();
            }
            if (this.eAG.size() > 0) {
                this.eAz.a(this.eAG.valueAt(0), vVar);
            }
            c(vVar);
            bic();
            return true;
        }
        return false;
    }

    private void bia() {
        if (isNetWorkEnabled(this.mContext) && bib()) {
            v vVar = new v();
            vVar.iN(true);
            if (this.eAG == null) {
                bhY();
            }
            if (this.eAG.size() > 0) {
                if (e.bin().aGV()) {
                    this.eAz.a(vVar);
                } else {
                    this.eAz.a(this.eAG.valueAt(0), vVar);
                }
            }
            c(vVar);
            bic();
        }
    }

    private boolean bib() {
        if (e.bin().aGV()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.eAE) > 86400000) {
            this.eAF = 0;
            this.eAE = currentTimeMillis;
            u.biV().putLong("ubc_reset_real_time_count_time", this.eAE);
            u.biV().putInt("ubc_real_time_count", this.eAF);
        }
        if (this.eAF >= 1000) {
            if (this.eAF == 1000) {
                this.eAF++;
                e.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void bic() {
        this.eAF++;
        u.biV().putInt("ubc_real_time_count", this.eAF);
    }

    private void bid() {
        if (isNetWorkEnabled(this.mContext)) {
            this.eAD = System.currentTimeMillis();
            u.biV().putLong("ubc_last_upload_non_real", this.eAD);
            bif();
            bhZ();
            this.eAz.bhS();
            HashSet hashSet = new HashSet();
            if (this.eAG == null) {
                bhY();
            }
            v vVar = new v();
            vVar.iN(false);
            int i = 0;
            for (int i2 = 0; i2 < this.eAG.size(); i2++) {
                int keyAt = this.eAG.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.eAH.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * AppStatusRules.DEFAULT_GRANULARITY)) - System.currentTimeMillis() < this.eAJ.bik()) {
                        i |= this.eAz.a(this.eAG.valueAt(i2), vVar);
                        this.eAH.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.eAG.size(); i3++) {
                    int keyAt2 = this.eAG.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (vVar.nS(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.eAz.a(this.eAG.valueAt(i3), vVar);
                    }
                }
                c(vVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bie() {
        if (isNetWorkEnabled(this.mContext) && Math.abs(System.currentTimeMillis() - this.eAC) >= BdKVCache.MILLS_1Hour) {
            this.eAz.bhS();
            v vVar = new v();
            if (this.eAz.a(vVar) != 0) {
                v vVar2 = new v();
                vVar2.u(vVar.bjb(), vVar.getMaxTime());
                vVar2.zF(vVar.bja());
                vVar2.iN(true);
                v vVar3 = new v();
                vVar3.u(vVar.bjb(), vVar.getMaxTime());
                vVar3.zF(vVar.bja());
                vVar3.iN(false);
                SparseArray<Integer> biX = vVar.biX();
                int size = biX.size();
                for (int i = 0; i < size; i++) {
                    if (this.eAJ.zo(String.valueOf(biX.valueAt(i).intValue()))) {
                        vVar2.aE(biX.keyAt(i), biX.valueAt(i).intValue());
                    } else {
                        vVar3.aE(biX.keyAt(i), biX.valueAt(i).intValue());
                    }
                }
                ArrayList biY = vVar.biY();
                int size2 = biY.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) biY.get(i2);
                    if (this.eAJ.zo(str)) {
                        vVar2.zE(str);
                    } else {
                        vVar3.zE(str);
                    }
                }
                JSONArray bjc = vVar.bjc();
                int length = bjc.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = bjc.optJSONObject(i3);
                    if (optJSONObject.has("bizId")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("bizId");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.eAJ.zo(str2)) {
                                vVar2.dn(optJSONObject);
                            } else {
                                vVar3.dn(optJSONObject);
                            }
                        }
                    }
                }
                if (vVar2.bjc().length() > 0) {
                    c(vVar2);
                }
                if (vVar3.bjc().length() > 0) {
                    c(vVar3);
                }
                this.eAC = System.currentTimeMillis();
                u.biV().putLong("ubc_last_upload_all_time", this.eAC);
                this.eAD = this.eAC;
                u.biV().putLong("ubc_last_upload_non_real", this.eAD);
            }
        }
    }

    private void c(v vVar) {
        if (!vVar.isEmpty()) {
            JSONArray biZ = vVar.biZ();
            String md5 = com.baidu.swan.c.e.toMd5(biZ.toString().getBytes(), true);
            dB(biZ.toString(), md5);
            this.eAz.au(md5, vVar.bjd());
            if (!this.eAz.a(vVar.biX(), vVar.biY(), vVar.bjd(), md5)) {
                vVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", md5);
                if (file.exists() && file.delete()) {
                    Log.d("CeresBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.eAz.zj(md5);
                return;
            }
            n.biJ().d(biZ, md5);
            vVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(JSONArray jSONArray, String str) {
        if (this.eAI.I(jSONArray)) {
            n.biJ().av(str, true);
        } else {
            n.biJ().av(str, false);
        }
    }

    private void bif() {
        iK(true);
        iK(false);
    }

    private void iK(boolean z) {
        v vVar = new v();
        vVar.iN(z);
        if (this.eAA.a(vVar, z)) {
            JSONArray biZ = vVar.biZ();
            this.eAA.iJ(z);
            n.biJ().L(biZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(JSONArray jSONArray) {
        if (!this.eAI.I(jSONArray)) {
            e.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a big() {
        return this.eAz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(q qVar) {
        int i = 0;
        this.eAJ.bj(qVar.biP());
        this.eAJ.nK(qVar.biO() * 86400000);
        this.eAJ.nL(qVar.biN());
        u.biV().putString("ubc_version_md5", qVar.getSign());
        this.eAz.bi(qVar.biP());
        qVar.biP().clear();
        if (this.eAG == null) {
            this.eAG = new SparseArray<>();
        }
        this.eAG.clear();
        if (this.eAH == null) {
            this.eAH = new HashMap<>();
        }
        this.eAH.clear();
        this.eAz.e(this.eAG);
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < this.eAG.size()) {
                int keyAt = this.eAG.keyAt(i2);
                i = (keyAt == 0 || i3 != 0) ? i3 : keyAt;
                this.eAH.put("ubc_last_upload_time_level_" + keyAt, 0L);
                i2++;
            } else {
                this.eAJ.nJ(i3);
                return;
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    private boolean isNetWorkEnabled(Context context) {
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

    private void dB(String str, String str2) {
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
                t.zD("save to file suc");
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
    public void zl(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", str);
        t.zD("delete file");
        if (file.exists() && file.delete()) {
            Log.d("CeresBehaviorModel", "deleteUploadFile file suc");
            t.zD("delete file suc");
        }
        this.eAz.zj(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zm(String str) {
        t.zD("upload file fail");
        this.eAz.zk(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bih() {
        File[] listFiles;
        if (isNetWorkEnabled(this.mContext)) {
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
                    this.eAz.bhT();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    j zi = this.eAz.zi(listFiles[i].getName());
                    if (zi != null && TextUtils.equals("0", zi.biE())) {
                        t.zD("processFailedData file, no need to send");
                    } else if (zi != null && TextUtils.equals("1", zi.biE())) {
                        t.zD("processFailedData file, send");
                        this.eAz.dA(listFiles[i].getName(), "0");
                        zn(listFiles[i].getName());
                    } else {
                        t.zD("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    void zn(String str) {
        Throwable th;
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            try {
                InputStream fileInputStream = new FileInputStream(new File(this.mContext.getFilesDir() + File.separator + "statistics_data", str));
                if (fileInputStream != null) {
                    try {
                        if (fileInputStream.available() > 0) {
                            inputStream2 = new Base64InputStream(fileInputStream, 0);
                            try {
                                n.biJ().d(new JSONArray(com.baidu.swan.c.g.getStringFromInput(inputStream2)), str);
                                com.baidu.swan.c.d.closeSafely(inputStream2);
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream = inputStream2;
                                com.baidu.swan.c.d.closeSafely(inputStream);
                                throw th;
                            }
                        }
                    } catch (Exception e) {
                        inputStream2 = fileInputStream;
                        com.baidu.swan.c.d.closeSafely(inputStream2);
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = fileInputStream;
                    }
                }
                inputStream2 = fileInputStream;
                com.baidu.swan.c.d.closeSafely(inputStream2);
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
            }
        } catch (Exception e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bii() {
        this.eAz.bhU();
    }
}
