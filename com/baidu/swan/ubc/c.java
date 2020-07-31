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
/* loaded from: classes9.dex */
public class c {
    private a dzN;
    private b dzO;
    private long dzQ;
    private long dzR;
    private long dzS;
    private int dzT;
    private SparseArray<ArrayList> dzU;
    private HashMap<String, Long> dzV;
    private d dzX;
    private Context mContext;
    private m dzW = e.aNf().Uz();
    private List<i> dzP = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.dzN = new a(context);
        this.dzO = new b(context);
        u aNN = u.aNN();
        this.dzQ = aNN.getLong("ubc_last_upload_all_time", 0L);
        this.dzR = aNN.getLong("ubc_last_upload_non_real", 0L);
        this.dzS = aNN.getLong("ubc_reset_real_time_count_time", 0L);
        this.dzT = aNN.getInt("ubc_real_time_count", 0);
        this.dzX = d.aNb();
        this.dzX.a(this, context);
    }

    private void aMQ() {
        if (this.dzU == null) {
            this.dzU = new SparseArray<>();
            this.dzN.b(this.dzU);
            this.dzV = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.dzU.size(); i2++) {
                int keyAt = this.dzU.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.dzV.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.dzX.jX(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(i iVar) {
        boolean z = false;
        if (TextUtils.equals(iVar.getId(), iVar.aNq()) && this.dzX.uP(iVar.getId()) && (iVar.getOption() & 64) == 0) {
            z = true;
        }
        if (z && !c(iVar)) {
            this.dzN.a(iVar);
        } else if (Math.abs(System.currentTimeMillis() - this.dzR) >= d.aNb().aNc()) {
            if (!z) {
                this.dzP.add(iVar);
            }
            aMV();
        } else if ((iVar.getOption() & 1) == 0) {
            if (!z) {
                this.dzP.add(iVar);
            }
            if (this.dzP.size() >= 20) {
                aMR();
            }
        } else if (!z) {
            this.dzN.a(iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(i iVar) {
        this.dzO.a(iVar, this.dzX.uP(iVar.getId()));
    }

    private void aMR() {
        if (this.dzP != null && this.dzP.size() != 0) {
            this.dzN.az(this.dzP);
            this.dzP.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(k kVar) {
        this.dzN.a(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, int i, String str2) {
        this.dzN.f(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        aMR();
        this.dzN.a(str, i, j, jSONArray);
        if (this.dzX.uP(str)) {
            aMS();
        }
        if (Math.abs(System.currentTimeMillis() - this.dzR) >= d.aNb().aNc()) {
            aMV();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(String str, int i) {
        aMR();
        this.dzN.G(str, i);
        if (Math.abs(System.currentTimeMillis() - this.dzR) >= d.aNb().aNc()) {
            aMV();
        }
    }

    private boolean c(i iVar) {
        if (dC(this.mContext) && aMT()) {
            aMR();
            v vVar = new v();
            vVar.gP(true);
            JSONObject aNt = iVar.aNt();
            if (aNt != null && aNt.has("bizId")) {
                s.cI(aNt);
                vVar.cK(aNt);
                vVar.t(iVar.getTime(), iVar.getTime());
                try {
                    JSONObject jSONObject = aNt.getJSONObject("content");
                    JSONObject jSONObject2 = aNt.getJSONObject("appInfo");
                    if (jSONObject != null && jSONObject2 != null) {
                        jSONObject.put("appInfo", jSONObject2);
                        aNt.remove("appInfo");
                    }
                } catch (JSONException e) {
                }
            } else {
                try {
                    JSONObject jSONObject3 = new s(iVar.aNu()).toJSONObject();
                    jSONObject3.put("bizId", iVar.getId());
                    jSONObject3.put("timestamp", Long.toString(iVar.getTime()));
                    if (iVar.aNt() != null) {
                        jSONObject3.put("content", iVar.aNt());
                    } else {
                        jSONObject3.put("content", iVar.getContent());
                    }
                    jSONObject3.put("eventType", "0");
                    if (!TextUtils.isEmpty(iVar.aNs())) {
                        jSONObject3.put("abtest", iVar.aNs());
                        vVar.vg("1");
                    }
                    if (!TextUtils.isEmpty(iVar.getCategory())) {
                        jSONObject3.put("c", iVar.getCategory());
                    }
                    if (iVar.aNo()) {
                        jSONObject3.put("of", "1");
                    }
                    jSONObject3.put("idtype", this.dzX.uV(iVar.getId()));
                    vVar.cK(jSONObject3);
                    vVar.t(iVar.getTime(), iVar.getTime());
                } catch (JSONException e2) {
                }
            }
            if (this.dzU == null) {
                aMQ();
            }
            if (this.dzU.size() > 0) {
                this.dzN.a(this.dzU.valueAt(0), vVar);
            }
            c(vVar);
            aMU();
            return true;
        }
        return false;
    }

    private void aMS() {
        if (dC(this.mContext) && aMT()) {
            v vVar = new v();
            vVar.gP(true);
            if (this.dzU == null) {
                aMQ();
            }
            if (this.dzU.size() > 0) {
                if (e.aNf().anr()) {
                    this.dzN.a(vVar);
                } else {
                    this.dzN.a(this.dzU.valueAt(0), vVar);
                }
            }
            c(vVar);
            aMU();
        }
    }

    private boolean aMT() {
        if (e.aNf().anr()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.dzS) > 86400000) {
            this.dzT = 0;
            this.dzS = currentTimeMillis;
            u.aNN().putLong("ubc_reset_real_time_count_time", this.dzS);
            u.aNN().putInt("ubc_real_time_count", this.dzT);
        }
        if (this.dzT >= 1000) {
            if (this.dzT == 1000) {
                this.dzT++;
                e.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void aMU() {
        this.dzT++;
        u.aNN().putInt("ubc_real_time_count", this.dzT);
    }

    private void aMV() {
        if (dC(this.mContext)) {
            this.dzR = System.currentTimeMillis();
            u.aNN().putLong("ubc_last_upload_non_real", this.dzR);
            aMX();
            aMR();
            this.dzN.aMK();
            HashSet hashSet = new HashSet();
            if (this.dzU == null) {
                aMQ();
            }
            v vVar = new v();
            vVar.gP(false);
            int i = 0;
            for (int i2 = 0; i2 < this.dzU.size(); i2++) {
                int keyAt = this.dzU.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.dzV.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.dzX.aNc()) {
                        i |= this.dzN.a(this.dzU.valueAt(i2), vVar);
                        this.dzV.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.dzU.size(); i3++) {
                    int keyAt2 = this.dzU.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (vVar.kg(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.dzN.a(this.dzU.valueAt(i3), vVar);
                    }
                }
                c(vVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aMW() {
        if (dC(this.mContext) && Math.abs(System.currentTimeMillis() - this.dzQ) >= BdKVCache.MILLS_1Hour) {
            this.dzN.aMK();
            v vVar = new v();
            if (this.dzN.a(vVar) != 0) {
                v vVar2 = new v();
                vVar2.t(vVar.aNT(), vVar.getMaxTime());
                vVar2.vg(vVar.aNS());
                vVar2.gP(true);
                v vVar3 = new v();
                vVar3.t(vVar.aNT(), vVar.getMaxTime());
                vVar3.vg(vVar.aNS());
                vVar3.gP(false);
                SparseArray<Integer> aNP = vVar.aNP();
                int size = aNP.size();
                for (int i = 0; i < size; i++) {
                    if (this.dzX.uP(String.valueOf(aNP.valueAt(i).intValue()))) {
                        vVar2.ay(aNP.keyAt(i), aNP.valueAt(i).intValue());
                    } else {
                        vVar3.ay(aNP.keyAt(i), aNP.valueAt(i).intValue());
                    }
                }
                ArrayList aNQ = vVar.aNQ();
                int size2 = aNQ.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) aNQ.get(i2);
                    if (this.dzX.uP(str)) {
                        vVar2.vf(str);
                    } else {
                        vVar3.vf(str);
                    }
                }
                JSONArray aNU = vVar.aNU();
                int length = aNU.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = aNU.optJSONObject(i3);
                    if (optJSONObject.has("bizId")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("bizId");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.dzX.uP(str2)) {
                                vVar2.cK(optJSONObject);
                            } else {
                                vVar3.cK(optJSONObject);
                            }
                        }
                    }
                }
                if (vVar2.aNU().length() > 0) {
                    c(vVar2);
                }
                if (vVar3.aNU().length() > 0) {
                    c(vVar3);
                }
                this.dzQ = System.currentTimeMillis();
                u.aNN().putLong("ubc_last_upload_all_time", this.dzQ);
                this.dzR = this.dzQ;
                u.aNN().putLong("ubc_last_upload_non_real", this.dzR);
            }
        }
    }

    private void c(v vVar) {
        if (!vVar.isEmpty()) {
            JSONArray aNR = vVar.aNR();
            String md5 = com.baidu.swan.d.e.toMd5(aNR.toString().getBytes(), true);
            cU(aNR.toString(), md5);
            this.dzN.aj(md5, vVar.aNV());
            if (!this.dzN.a(vVar.aNP(), vVar.aNQ(), vVar.aNV(), md5)) {
                vVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", md5);
                if (file.exists() && file.delete()) {
                    Log.d("CeresBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.dzN.uK(md5);
                return;
            }
            n.aNB().d(aNR, md5);
            vVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(JSONArray jSONArray, String str) {
        if (this.dzW.F(jSONArray)) {
            n.aNB().ak(str, true);
        } else {
            n.aNB().ak(str, false);
        }
    }

    private void aMX() {
        gM(true);
        gM(false);
    }

    private void gM(boolean z) {
        v vVar = new v();
        vVar.gP(z);
        if (this.dzO.a(vVar, z)) {
            JSONArray aNR = vVar.aNR();
            this.dzO.gL(z);
            n.aNB().I(aNR);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(JSONArray jSONArray) {
        if (!this.dzW.F(jSONArray)) {
            e.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a aMY() {
        return this.dzN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(q qVar) {
        this.dzX.aB(qVar.aNH());
        this.dzX.jY(qVar.aNG() * 86400000);
        this.dzX.jZ(qVar.aNF());
        u.aNN().putString("ubc_version_md5", qVar.getSign());
        this.dzN.aA(qVar.aNH());
        qVar.aNH().clear();
        if (this.dzU == null) {
            this.dzU = new SparseArray<>();
        }
        this.dzU.clear();
        if (this.dzV == null) {
            this.dzV = new HashMap<>();
        }
        this.dzV.clear();
        this.dzN.b(this.dzU);
        int i = 0;
        for (int i2 = 0; i2 < this.dzU.size(); i2++) {
            int keyAt = this.dzU.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.dzV.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.dzX.jX(i);
    }

    @SuppressLint({"MissingPermission"})
    private boolean dC(Context context) {
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

    private void cU(String str, String str2) {
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
                t.ve("save to file suc");
                com.baidu.swan.d.d.closeSafely(outputStream);
            } catch (Exception e2) {
                e = e2;
                outputStream = fileOutputStream;
                e.printStackTrace();
                com.baidu.swan.d.d.closeSafely(outputStream);
            } catch (Throwable th2) {
                th = th2;
                outputStream = fileOutputStream;
                com.baidu.swan.d.d.closeSafely(outputStream);
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void uM(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", str);
        t.ve("delete file");
        if (file.exists() && file.delete()) {
            Log.d("CeresBehaviorModel", "deleteUploadFile file suc");
            t.ve("delete file suc");
        }
        this.dzN.uK(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void uN(String str) {
        t.ve("upload file fail");
        this.dzN.uL(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aMZ() {
        File[] listFiles;
        if (dC(this.mContext)) {
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
                    this.dzN.aML();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    j uJ = this.dzN.uJ(listFiles[i].getName());
                    if (uJ != null && TextUtils.equals("0", uJ.aNw())) {
                        t.ve("processFailedData file, no need to send");
                    } else if (uJ != null && TextUtils.equals("1", uJ.aNw())) {
                        t.ve("processFailedData file, send");
                        this.dzN.cT(listFiles[i].getName(), "0");
                        uO(listFiles[i].getName());
                    } else {
                        t.ve("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    void uO(String str) {
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
                                n.aNB().d(new JSONArray(com.baidu.swan.d.g.getStringFromInput(inputStream2)), str);
                                com.baidu.swan.d.d.closeSafely(inputStream2);
                            } catch (Throwable th2) {
                                inputStream = inputStream2;
                                th = th2;
                                com.baidu.swan.d.d.closeSafely(inputStream);
                                throw th;
                            }
                        }
                    } catch (Exception e) {
                        inputStream2 = inputStream;
                        com.baidu.swan.d.d.closeSafely(inputStream2);
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                inputStream2 = inputStream;
                com.baidu.swan.d.d.closeSafely(inputStream2);
            } catch (Throwable th4) {
                inputStream = null;
                th = th4;
            }
        } catch (Exception e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aNa() {
        this.dzN.aMM();
    }
}
