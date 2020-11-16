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
/* loaded from: classes16.dex */
public class c {
    private a ejM;
    private b ejN;
    private long ejP;
    private long ejQ;
    private long ejR;
    private int ejS;
    private SparseArray<ArrayList> ejT;
    private HashMap<String, Long> ejU;
    private d ejW;
    private Context mContext;
    private m ejV = e.bcL().ahI();
    private List<i> ejO = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.ejM = new a(context);
        this.ejN = new b(context);
        u bdt = u.bdt();
        this.ejP = bdt.getLong("ubc_last_upload_all_time", 0L);
        this.ejQ = bdt.getLong("ubc_last_upload_non_real", 0L);
        this.ejR = bdt.getLong("ubc_reset_real_time_count_time", 0L);
        this.ejS = bdt.getInt("ubc_real_time_count", 0);
        this.ejW = d.bcH();
        this.ejW.a(this, context);
    }

    private void bcw() {
        if (this.ejT == null) {
            this.ejT = new SparseArray<>();
            this.ejM.b(this.ejT);
            this.ejU = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.ejT.size(); i2++) {
                int keyAt = this.ejT.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.ejU.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.ejW.nc(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(i iVar) {
        boolean z = false;
        if (TextUtils.equals(iVar.getId(), iVar.bcW()) && this.ejW.yI(iVar.getId()) && (iVar.getOption() & 64) == 0) {
            z = true;
        }
        if (z && !c(iVar)) {
            this.ejM.a(iVar);
        } else if (Math.abs(System.currentTimeMillis() - this.ejQ) >= d.bcH().bcI()) {
            if (!z) {
                this.ejO.add(iVar);
            }
            bcB();
        } else if ((iVar.getOption() & 1) == 0) {
            if (!z) {
                this.ejO.add(iVar);
            }
            if (this.ejO.size() >= 20) {
                bcx();
            }
        } else if (!z) {
            this.ejM.a(iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(i iVar) {
        this.ejN.a(iVar, this.ejW.yI(iVar.getId()));
    }

    private void bcx() {
        if (this.ejO != null && this.ejO.size() != 0) {
            this.ejM.aX(this.ejO);
            this.ejO.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(k kVar) {
        this.ejM.a(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str, int i, String str2) {
        this.ejM.i(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        bcx();
        this.ejM.a(str, i, j, jSONArray);
        if (this.ejW.yI(str)) {
            bcy();
        }
        if (Math.abs(System.currentTimeMillis() - this.ejQ) >= d.bcH().bcI()) {
            bcB();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(String str, int i) {
        bcx();
        this.ejM.K(str, i);
        if (Math.abs(System.currentTimeMillis() - this.ejQ) >= d.bcH().bcI()) {
            bcB();
        }
    }

    private boolean c(i iVar) {
        if (dN(this.mContext) && bcz()) {
            bcx();
            v vVar = new v();
            vVar.id(true);
            JSONObject bcZ = iVar.bcZ();
            if (bcZ != null && bcZ.has("bizId")) {
                s.db(bcZ);
                vVar.dd(bcZ);
                vVar.r(iVar.getTime(), iVar.getTime());
                try {
                    JSONObject jSONObject = bcZ.getJSONObject("content");
                    JSONObject jSONObject2 = bcZ.getJSONObject("appInfo");
                    if (jSONObject != null && jSONObject2 != null) {
                        jSONObject.put("appInfo", jSONObject2);
                        bcZ.remove("appInfo");
                    }
                } catch (JSONException e) {
                }
            } else {
                try {
                    JSONObject jSONObject3 = new s(iVar.bda()).toJSONObject();
                    jSONObject3.put("bizId", iVar.getId());
                    jSONObject3.put("timestamp", Long.toString(iVar.getTime()));
                    if (iVar.bcZ() != null) {
                        jSONObject3.put("content", iVar.bcZ());
                    } else {
                        jSONObject3.put("content", iVar.getContent());
                    }
                    jSONObject3.put("eventType", "0");
                    if (!TextUtils.isEmpty(iVar.bcY())) {
                        jSONObject3.put("abtest", iVar.bcY());
                        vVar.yZ("1");
                    }
                    if (!TextUtils.isEmpty(iVar.getCategory())) {
                        jSONObject3.put("c", iVar.getCategory());
                    }
                    if (iVar.bcU()) {
                        jSONObject3.put(MapBundleKey.MapObjKey.OBJ_OFFSET, "1");
                    }
                    jSONObject3.put("idtype", this.ejW.yO(iVar.getId()));
                    vVar.dd(jSONObject3);
                    vVar.r(iVar.getTime(), iVar.getTime());
                } catch (JSONException e2) {
                }
            }
            if (this.ejT == null) {
                bcw();
            }
            if (this.ejT.size() > 0) {
                this.ejM.a(this.ejT.valueAt(0), vVar);
            }
            c(vVar);
            bcA();
            return true;
        }
        return false;
    }

    private void bcy() {
        if (dN(this.mContext) && bcz()) {
            v vVar = new v();
            vVar.id(true);
            if (this.ejT == null) {
                bcw();
            }
            if (this.ejT.size() > 0) {
                if (e.bcL().aCs()) {
                    this.ejM.a(vVar);
                } else {
                    this.ejM.a(this.ejT.valueAt(0), vVar);
                }
            }
            c(vVar);
            bcA();
        }
    }

    private boolean bcz() {
        if (e.bcL().aCs()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.ejR) > 86400000) {
            this.ejS = 0;
            this.ejR = currentTimeMillis;
            u.bdt().putLong("ubc_reset_real_time_count_time", this.ejR);
            u.bdt().putInt("ubc_real_time_count", this.ejS);
        }
        if (this.ejS >= 1000) {
            if (this.ejS == 1000) {
                this.ejS++;
                e.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void bcA() {
        this.ejS++;
        u.bdt().putInt("ubc_real_time_count", this.ejS);
    }

    private void bcB() {
        if (dN(this.mContext)) {
            this.ejQ = System.currentTimeMillis();
            u.bdt().putLong("ubc_last_upload_non_real", this.ejQ);
            bcD();
            bcx();
            this.ejM.bcq();
            HashSet hashSet = new HashSet();
            if (this.ejT == null) {
                bcw();
            }
            v vVar = new v();
            vVar.id(false);
            int i = 0;
            for (int i2 = 0; i2 < this.ejT.size(); i2++) {
                int keyAt = this.ejT.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.ejU.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.ejW.bcI()) {
                        i |= this.ejM.a(this.ejT.valueAt(i2), vVar);
                        this.ejU.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.ejT.size(); i3++) {
                    int keyAt2 = this.ejT.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (vVar.nl(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.ejM.a(this.ejT.valueAt(i3), vVar);
                    }
                }
                c(vVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bcC() {
        if (dN(this.mContext) && Math.abs(System.currentTimeMillis() - this.ejP) >= BdKVCache.MILLS_1Hour) {
            this.ejM.bcq();
            v vVar = new v();
            if (this.ejM.a(vVar) != 0) {
                v vVar2 = new v();
                vVar2.r(vVar.bdz(), vVar.getMaxTime());
                vVar2.yZ(vVar.bdy());
                vVar2.id(true);
                v vVar3 = new v();
                vVar3.r(vVar.bdz(), vVar.getMaxTime());
                vVar3.yZ(vVar.bdy());
                vVar3.id(false);
                SparseArray<Integer> bdv = vVar.bdv();
                int size = bdv.size();
                for (int i = 0; i < size; i++) {
                    if (this.ejW.yI(String.valueOf(bdv.valueAt(i).intValue()))) {
                        vVar2.aF(bdv.keyAt(i), bdv.valueAt(i).intValue());
                    } else {
                        vVar3.aF(bdv.keyAt(i), bdv.valueAt(i).intValue());
                    }
                }
                ArrayList bdw = vVar.bdw();
                int size2 = bdw.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) bdw.get(i2);
                    if (this.ejW.yI(str)) {
                        vVar2.yY(str);
                    } else {
                        vVar3.yY(str);
                    }
                }
                JSONArray bdA = vVar.bdA();
                int length = bdA.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = bdA.optJSONObject(i3);
                    if (optJSONObject.has("bizId")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("bizId");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.ejW.yI(str2)) {
                                vVar2.dd(optJSONObject);
                            } else {
                                vVar3.dd(optJSONObject);
                            }
                        }
                    }
                }
                if (vVar2.bdA().length() > 0) {
                    c(vVar2);
                }
                if (vVar3.bdA().length() > 0) {
                    c(vVar3);
                }
                this.ejP = System.currentTimeMillis();
                u.bdt().putLong("ubc_last_upload_all_time", this.ejP);
                this.ejQ = this.ejP;
                u.bdt().putLong("ubc_last_upload_non_real", this.ejQ);
            }
        }
    }

    private void c(v vVar) {
        if (!vVar.isEmpty()) {
            JSONArray bdx = vVar.bdx();
            String md5 = com.baidu.swan.c.e.toMd5(bdx.toString().getBytes(), true);
            dv(bdx.toString(), md5);
            this.ejM.at(md5, vVar.bdB());
            if (!this.ejM.a(vVar.bdv(), vVar.bdw(), vVar.bdB(), md5)) {
                vVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", md5);
                if (file.exists() && file.delete()) {
                    Log.d("CeresBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.ejM.yD(md5);
                return;
            }
            n.bdh().d(bdx, md5);
            vVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(JSONArray jSONArray, String str) {
        if (this.ejV.H(jSONArray)) {
            n.bdh().au(str, true);
        } else {
            n.bdh().au(str, false);
        }
    }

    private void bcD() {
        ia(true);
        ia(false);
    }

    private void ia(boolean z) {
        v vVar = new v();
        vVar.id(z);
        if (this.ejN.a(vVar, z)) {
            JSONArray bdx = vVar.bdx();
            this.ejN.hZ(z);
            n.bdh().K(bdx);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(JSONArray jSONArray) {
        if (!this.ejV.H(jSONArray)) {
            e.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a bcE() {
        return this.ejM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(q qVar) {
        this.ejW.aZ(qVar.bdn());
        this.ejW.nd(qVar.bdm() * 86400000);
        this.ejW.ne(qVar.bdl());
        u.bdt().putString("ubc_version_md5", qVar.getSign());
        this.ejM.aY(qVar.bdn());
        qVar.bdn().clear();
        if (this.ejT == null) {
            this.ejT = new SparseArray<>();
        }
        this.ejT.clear();
        if (this.ejU == null) {
            this.ejU = new HashMap<>();
        }
        this.ejU.clear();
        this.ejM.b(this.ejT);
        int i = 0;
        for (int i2 = 0; i2 < this.ejT.size(); i2++) {
            int keyAt = this.ejT.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.ejU.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.ejW.nc(i);
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

    private void dv(String str, String str2) {
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
                t.yX("save to file suc");
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
    public void yF(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", str);
        t.yX("delete file");
        if (file.exists() && file.delete()) {
            Log.d("CeresBehaviorModel", "deleteUploadFile file suc");
            t.yX("delete file suc");
        }
        this.ejM.yD(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void yG(String str) {
        t.yX("upload file fail");
        this.ejM.yE(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bcF() {
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
                    this.ejM.bcr();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    j yC = this.ejM.yC(listFiles[i].getName());
                    if (yC != null && TextUtils.equals("0", yC.bdc())) {
                        t.yX("processFailedData file, no need to send");
                    } else if (yC != null && TextUtils.equals("1", yC.bdc())) {
                        t.yX("processFailedData file, send");
                        this.ejM.du(listFiles[i].getName(), "0");
                        yH(listFiles[i].getName());
                    } else {
                        t.yX("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    void yH(String str) {
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
                                n.bdh().d(new JSONArray(com.baidu.swan.c.g.getStringFromInput(inputStream2)), str);
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
    public void bcG() {
        this.ejM.bcs();
    }
}
