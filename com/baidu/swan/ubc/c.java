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
    private a evK;
    private b evL;
    private long evN;
    private long evO;
    private long evP;
    private int evQ;
    private SparseArray<ArrayList> evR;
    private HashMap<String, Long> evS;
    private d evU;
    private Context mContext;
    private m evT = e.beu().aih();
    private List<i> evM = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.evK = new a(context);
        this.evL = new b(context);
        u bfc = u.bfc();
        this.evN = bfc.getLong("ubc_last_upload_all_time", 0L);
        this.evO = bfc.getLong("ubc_last_upload_non_real", 0L);
        this.evP = bfc.getLong("ubc_reset_real_time_count_time", 0L);
        this.evQ = bfc.getInt("ubc_real_time_count", 0);
        this.evU = d.beq();
        this.evU.a(this, context);
    }

    private void bef() {
        int i = 0;
        if (this.evR == null) {
            this.evR = new SparseArray<>();
            this.evK.e(this.evR);
            this.evS = new HashMap<>();
            int i2 = 0;
            while (true) {
                int i3 = i;
                if (i2 < this.evR.size()) {
                    int keyAt = this.evR.keyAt(i2);
                    i = (keyAt == 0 || i3 != 0) ? i3 : keyAt;
                    this.evS.put("ubc_last_upload_time_level_" + keyAt, 0L);
                    i2++;
                } else {
                    this.evU.md(i3);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(i iVar) {
        boolean z = false;
        if (TextUtils.equals(iVar.getId(), iVar.beF()) && this.evU.yd(iVar.getId()) && (iVar.getOption() & 64) == 0) {
            z = true;
        }
        if (z && !c(iVar)) {
            this.evK.a(iVar);
        } else if (Math.abs(System.currentTimeMillis() - this.evO) >= d.beq().ber()) {
            if (!z) {
                this.evM.add(iVar);
            }
            bek();
        } else if ((iVar.getOption() & 1) == 0) {
            if (!z) {
                this.evM.add(iVar);
            }
            if (this.evM.size() >= 20) {
                beg();
            }
        } else if (!z) {
            this.evK.a(iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(i iVar) {
        this.evL.a(iVar, this.evU.yd(iVar.getId()));
    }

    private void beg() {
        if (this.evM != null && this.evM.size() != 0) {
            this.evK.bh(this.evM);
            this.evM.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(k kVar) {
        this.evK.a(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str, int i, String str2) {
        this.evK.i(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        beg();
        this.evK.a(str, i, j, jSONArray);
        if (this.evU.yd(str)) {
            beh();
        }
        if (Math.abs(System.currentTimeMillis() - this.evO) >= d.beq().ber()) {
            bek();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(String str, int i) {
        beg();
        this.evK.M(str, i);
        if (Math.abs(System.currentTimeMillis() - this.evO) >= d.beq().ber()) {
            bek();
        }
    }

    private boolean c(i iVar) {
        if (isNetWorkEnabled(this.mContext) && bei()) {
            beg();
            v vVar = new v();
            vVar.iJ(true);
            JSONObject beI = iVar.beI();
            if (beI != null && beI.has("bizId")) {
                s.dl(beI);
                vVar.dn(beI);
                vVar.u(iVar.getTime(), iVar.getTime());
                try {
                    JSONObject jSONObject = beI.getJSONObject("content");
                    JSONObject jSONObject2 = beI.getJSONObject("appInfo");
                    if (jSONObject != null && jSONObject2 != null) {
                        jSONObject.put("appInfo", jSONObject2);
                        beI.remove("appInfo");
                    }
                } catch (JSONException e) {
                }
            } else {
                try {
                    JSONObject jSONObject3 = new s(iVar.beJ()).toJSONObject();
                    jSONObject3.put("bizId", iVar.getId());
                    jSONObject3.put("timestamp", Long.toString(iVar.getTime()));
                    if (iVar.beI() != null) {
                        jSONObject3.put("content", iVar.beI());
                    } else {
                        jSONObject3.put("content", iVar.getContent());
                    }
                    jSONObject3.put("eventType", "0");
                    if (!TextUtils.isEmpty(iVar.beH())) {
                        jSONObject3.put("abtest", iVar.beH());
                        vVar.yu("1");
                    }
                    if (!TextUtils.isEmpty(iVar.getCategory())) {
                        jSONObject3.put("c", iVar.getCategory());
                    }
                    if (iVar.beD()) {
                        jSONObject3.put("of", "1");
                    }
                    jSONObject3.put("idtype", this.evU.yj(iVar.getId()));
                    vVar.dn(jSONObject3);
                    vVar.u(iVar.getTime(), iVar.getTime());
                } catch (JSONException e2) {
                }
            }
            if (this.evR == null) {
                bef();
            }
            if (this.evR.size() > 0) {
                this.evK.a(this.evR.valueAt(0), vVar);
            }
            c(vVar);
            bej();
            return true;
        }
        return false;
    }

    private void beh() {
        if (isNetWorkEnabled(this.mContext) && bei()) {
            v vVar = new v();
            vVar.iJ(true);
            if (this.evR == null) {
                bef();
            }
            if (this.evR.size() > 0) {
                if (e.beu().aDc()) {
                    this.evK.a(vVar);
                } else {
                    this.evK.a(this.evR.valueAt(0), vVar);
                }
            }
            c(vVar);
            bej();
        }
    }

    private boolean bei() {
        if (e.beu().aDc()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.evP) > 86400000) {
            this.evQ = 0;
            this.evP = currentTimeMillis;
            u.bfc().putLong("ubc_reset_real_time_count_time", this.evP);
            u.bfc().putInt("ubc_real_time_count", this.evQ);
        }
        if (this.evQ >= 1000) {
            if (this.evQ == 1000) {
                this.evQ++;
                e.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void bej() {
        this.evQ++;
        u.bfc().putInt("ubc_real_time_count", this.evQ);
    }

    private void bek() {
        if (isNetWorkEnabled(this.mContext)) {
            this.evO = System.currentTimeMillis();
            u.bfc().putLong("ubc_last_upload_non_real", this.evO);
            bem();
            beg();
            this.evK.bdZ();
            HashSet hashSet = new HashSet();
            if (this.evR == null) {
                bef();
            }
            v vVar = new v();
            vVar.iJ(false);
            int i = 0;
            for (int i2 = 0; i2 < this.evR.size(); i2++) {
                int keyAt = this.evR.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.evS.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * AppStatusRules.DEFAULT_GRANULARITY)) - System.currentTimeMillis() < this.evU.ber()) {
                        i |= this.evK.a(this.evR.valueAt(i2), vVar);
                        this.evS.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.evR.size(); i3++) {
                    int keyAt2 = this.evR.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (vVar.mm(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.evK.a(this.evR.valueAt(i3), vVar);
                    }
                }
                c(vVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bel() {
        if (isNetWorkEnabled(this.mContext) && Math.abs(System.currentTimeMillis() - this.evN) >= BdKVCache.MILLS_1Hour) {
            this.evK.bdZ();
            v vVar = new v();
            if (this.evK.a(vVar) != 0) {
                v vVar2 = new v();
                vVar2.u(vVar.bfi(), vVar.getMaxTime());
                vVar2.yu(vVar.bfh());
                vVar2.iJ(true);
                v vVar3 = new v();
                vVar3.u(vVar.bfi(), vVar.getMaxTime());
                vVar3.yu(vVar.bfh());
                vVar3.iJ(false);
                SparseArray<Integer> bfe = vVar.bfe();
                int size = bfe.size();
                for (int i = 0; i < size; i++) {
                    if (this.evU.yd(String.valueOf(bfe.valueAt(i).intValue()))) {
                        vVar2.aE(bfe.keyAt(i), bfe.valueAt(i).intValue());
                    } else {
                        vVar3.aE(bfe.keyAt(i), bfe.valueAt(i).intValue());
                    }
                }
                ArrayList bff = vVar.bff();
                int size2 = bff.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) bff.get(i2);
                    if (this.evU.yd(str)) {
                        vVar2.yt(str);
                    } else {
                        vVar3.yt(str);
                    }
                }
                JSONArray bfj = vVar.bfj();
                int length = bfj.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = bfj.optJSONObject(i3);
                    if (optJSONObject.has("bizId")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("bizId");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.evU.yd(str2)) {
                                vVar2.dn(optJSONObject);
                            } else {
                                vVar3.dn(optJSONObject);
                            }
                        }
                    }
                }
                if (vVar2.bfj().length() > 0) {
                    c(vVar2);
                }
                if (vVar3.bfj().length() > 0) {
                    c(vVar3);
                }
                this.evN = System.currentTimeMillis();
                u.bfc().putLong("ubc_last_upload_all_time", this.evN);
                this.evO = this.evN;
                u.bfc().putLong("ubc_last_upload_non_real", this.evO);
            }
        }
    }

    private void c(v vVar) {
        if (!vVar.isEmpty()) {
            JSONArray bfg = vVar.bfg();
            String md5 = com.baidu.swan.c.e.toMd5(bfg.toString().getBytes(), true);
            dA(bfg.toString(), md5);
            this.evK.au(md5, vVar.bfk());
            if (!this.evK.a(vVar.bfe(), vVar.bff(), vVar.bfk(), md5)) {
                vVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", md5);
                if (file.exists() && file.delete()) {
                    Log.d("CeresBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.evK.xY(md5);
                return;
            }
            n.beQ().d(bfg, md5);
            vVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(JSONArray jSONArray, String str) {
        if (this.evT.I(jSONArray)) {
            n.beQ().av(str, true);
        } else {
            n.beQ().av(str, false);
        }
    }

    private void bem() {
        iG(true);
        iG(false);
    }

    private void iG(boolean z) {
        v vVar = new v();
        vVar.iJ(z);
        if (this.evL.a(vVar, z)) {
            JSONArray bfg = vVar.bfg();
            this.evL.iF(z);
            n.beQ().L(bfg);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(JSONArray jSONArray) {
        if (!this.evT.I(jSONArray)) {
            e.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a ben() {
        return this.evK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(q qVar) {
        int i = 0;
        this.evU.bj(qVar.beW());
        this.evU.me(qVar.beV() * 86400000);
        this.evU.mf(qVar.beU());
        u.bfc().putString("ubc_version_md5", qVar.getSign());
        this.evK.bi(qVar.beW());
        qVar.beW().clear();
        if (this.evR == null) {
            this.evR = new SparseArray<>();
        }
        this.evR.clear();
        if (this.evS == null) {
            this.evS = new HashMap<>();
        }
        this.evS.clear();
        this.evK.e(this.evR);
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < this.evR.size()) {
                int keyAt = this.evR.keyAt(i2);
                i = (keyAt == 0 || i3 != 0) ? i3 : keyAt;
                this.evS.put("ubc_last_upload_time_level_" + keyAt, 0L);
                i2++;
            } else {
                this.evU.md(i3);
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

    private void dA(String str, String str2) {
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
                t.ys("save to file suc");
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
    public void ya(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", str);
        t.ys("delete file");
        if (file.exists() && file.delete()) {
            Log.d("CeresBehaviorModel", "deleteUploadFile file suc");
            t.ys("delete file suc");
        }
        this.evK.xY(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void yb(String str) {
        t.ys("upload file fail");
        this.evK.xZ(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void beo() {
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
                    this.evK.bea();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    j xX = this.evK.xX(listFiles[i].getName());
                    if (xX != null && TextUtils.equals("0", xX.beL())) {
                        t.ys("processFailedData file, no need to send");
                    } else if (xX != null && TextUtils.equals("1", xX.beL())) {
                        t.ys("processFailedData file, send");
                        this.evK.dz(listFiles[i].getName(), "0");
                        yc(listFiles[i].getName());
                    } else {
                        t.ys("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    void yc(String str) {
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
                                n.beQ().d(new JSONArray(com.baidu.swan.c.g.getStringFromInput(inputStream2)), str);
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
    public void bep() {
        this.evK.beb();
    }
}
