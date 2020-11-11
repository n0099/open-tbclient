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
    private SparseArray<ArrayList> elA;
    private HashMap<String, Long> elB;
    private d elD;
    private a elt;
    private b elu;
    private long elw;
    private long elx;
    private long ely;
    private int elz;
    private Context mContext;
    private m elC = e.bds().aiq();
    private List<i> elv = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.elt = new a(context);
        this.elu = new b(context);
        u bea = u.bea();
        this.elw = bea.getLong("ubc_last_upload_all_time", 0L);
        this.elx = bea.getLong("ubc_last_upload_non_real", 0L);
        this.ely = bea.getLong("ubc_reset_real_time_count_time", 0L);
        this.elz = bea.getInt("ubc_real_time_count", 0);
        this.elD = d.bdo();
        this.elD.a(this, context);
    }

    private void bdd() {
        if (this.elA == null) {
            this.elA = new SparseArray<>();
            this.elt.b(this.elA);
            this.elB = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.elA.size(); i2++) {
                int keyAt = this.elA.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.elB.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.elD.ng(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(i iVar) {
        boolean z = false;
        if (TextUtils.equals(iVar.getId(), iVar.bdD()) && this.elD.yN(iVar.getId()) && (iVar.getOption() & 64) == 0) {
            z = true;
        }
        if (z && !c(iVar)) {
            this.elt.a(iVar);
        } else if (Math.abs(System.currentTimeMillis() - this.elx) >= d.bdo().bdp()) {
            if (!z) {
                this.elv.add(iVar);
            }
            bdi();
        } else if ((iVar.getOption() & 1) == 0) {
            if (!z) {
                this.elv.add(iVar);
            }
            if (this.elv.size() >= 20) {
                bde();
            }
        } else if (!z) {
            this.elt.a(iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(i iVar) {
        this.elu.a(iVar, this.elD.yN(iVar.getId()));
    }

    private void bde() {
        if (this.elv != null && this.elv.size() != 0) {
            this.elt.aX(this.elv);
            this.elv.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(k kVar) {
        this.elt.a(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str, int i, String str2) {
        this.elt.i(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        bde();
        this.elt.a(str, i, j, jSONArray);
        if (this.elD.yN(str)) {
            bdf();
        }
        if (Math.abs(System.currentTimeMillis() - this.elx) >= d.bdo().bdp()) {
            bdi();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(String str, int i) {
        bde();
        this.elt.K(str, i);
        if (Math.abs(System.currentTimeMillis() - this.elx) >= d.bdo().bdp()) {
            bdi();
        }
    }

    private boolean c(i iVar) {
        if (dN(this.mContext) && bdg()) {
            bde();
            v vVar = new v();
            vVar.ia(true);
            JSONObject bdG = iVar.bdG();
            if (bdG != null && bdG.has("bizId")) {
                s.dh(bdG);
                vVar.dj(bdG);
                vVar.r(iVar.getTime(), iVar.getTime());
                try {
                    JSONObject jSONObject = bdG.getJSONObject("content");
                    JSONObject jSONObject2 = bdG.getJSONObject("appInfo");
                    if (jSONObject != null && jSONObject2 != null) {
                        jSONObject.put("appInfo", jSONObject2);
                        bdG.remove("appInfo");
                    }
                } catch (JSONException e) {
                }
            } else {
                try {
                    JSONObject jSONObject3 = new s(iVar.bdH()).toJSONObject();
                    jSONObject3.put("bizId", iVar.getId());
                    jSONObject3.put("timestamp", Long.toString(iVar.getTime()));
                    if (iVar.bdG() != null) {
                        jSONObject3.put("content", iVar.bdG());
                    } else {
                        jSONObject3.put("content", iVar.getContent());
                    }
                    jSONObject3.put("eventType", "0");
                    if (!TextUtils.isEmpty(iVar.bdF())) {
                        jSONObject3.put("abtest", iVar.bdF());
                        vVar.ze("1");
                    }
                    if (!TextUtils.isEmpty(iVar.getCategory())) {
                        jSONObject3.put("c", iVar.getCategory());
                    }
                    if (iVar.bdB()) {
                        jSONObject3.put(MapBundleKey.MapObjKey.OBJ_OFFSET, "1");
                    }
                    jSONObject3.put("idtype", this.elD.yT(iVar.getId()));
                    vVar.dj(jSONObject3);
                    vVar.r(iVar.getTime(), iVar.getTime());
                } catch (JSONException e2) {
                }
            }
            if (this.elA == null) {
                bdd();
            }
            if (this.elA.size() > 0) {
                this.elt.a(this.elA.valueAt(0), vVar);
            }
            c(vVar);
            bdh();
            return true;
        }
        return false;
    }

    private void bdf() {
        if (dN(this.mContext) && bdg()) {
            v vVar = new v();
            vVar.ia(true);
            if (this.elA == null) {
                bdd();
            }
            if (this.elA.size() > 0) {
                if (e.bds().aDa()) {
                    this.elt.a(vVar);
                } else {
                    this.elt.a(this.elA.valueAt(0), vVar);
                }
            }
            c(vVar);
            bdh();
        }
    }

    private boolean bdg() {
        if (e.bds().aDa()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.ely) > 86400000) {
            this.elz = 0;
            this.ely = currentTimeMillis;
            u.bea().putLong("ubc_reset_real_time_count_time", this.ely);
            u.bea().putInt("ubc_real_time_count", this.elz);
        }
        if (this.elz >= 1000) {
            if (this.elz == 1000) {
                this.elz++;
                e.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void bdh() {
        this.elz++;
        u.bea().putInt("ubc_real_time_count", this.elz);
    }

    private void bdi() {
        if (dN(this.mContext)) {
            this.elx = System.currentTimeMillis();
            u.bea().putLong("ubc_last_upload_non_real", this.elx);
            bdk();
            bde();
            this.elt.bcX();
            HashSet hashSet = new HashSet();
            if (this.elA == null) {
                bdd();
            }
            v vVar = new v();
            vVar.ia(false);
            int i = 0;
            for (int i2 = 0; i2 < this.elA.size(); i2++) {
                int keyAt = this.elA.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.elB.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.elD.bdp()) {
                        i |= this.elt.a(this.elA.valueAt(i2), vVar);
                        this.elB.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.elA.size(); i3++) {
                    int keyAt2 = this.elA.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (vVar.np(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.elt.a(this.elA.valueAt(i3), vVar);
                    }
                }
                c(vVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bdj() {
        if (dN(this.mContext) && Math.abs(System.currentTimeMillis() - this.elw) >= BdKVCache.MILLS_1Hour) {
            this.elt.bcX();
            v vVar = new v();
            if (this.elt.a(vVar) != 0) {
                v vVar2 = new v();
                vVar2.r(vVar.beg(), vVar.getMaxTime());
                vVar2.ze(vVar.bef());
                vVar2.ia(true);
                v vVar3 = new v();
                vVar3.r(vVar.beg(), vVar.getMaxTime());
                vVar3.ze(vVar.bef());
                vVar3.ia(false);
                SparseArray<Integer> bec = vVar.bec();
                int size = bec.size();
                for (int i = 0; i < size; i++) {
                    if (this.elD.yN(String.valueOf(bec.valueAt(i).intValue()))) {
                        vVar2.aF(bec.keyAt(i), bec.valueAt(i).intValue());
                    } else {
                        vVar3.aF(bec.keyAt(i), bec.valueAt(i).intValue());
                    }
                }
                ArrayList bed = vVar.bed();
                int size2 = bed.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) bed.get(i2);
                    if (this.elD.yN(str)) {
                        vVar2.zd(str);
                    } else {
                        vVar3.zd(str);
                    }
                }
                JSONArray beh = vVar.beh();
                int length = beh.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = beh.optJSONObject(i3);
                    if (optJSONObject.has("bizId")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("bizId");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.elD.yN(str2)) {
                                vVar2.dj(optJSONObject);
                            } else {
                                vVar3.dj(optJSONObject);
                            }
                        }
                    }
                }
                if (vVar2.beh().length() > 0) {
                    c(vVar2);
                }
                if (vVar3.beh().length() > 0) {
                    c(vVar3);
                }
                this.elw = System.currentTimeMillis();
                u.bea().putLong("ubc_last_upload_all_time", this.elw);
                this.elx = this.elw;
                u.bea().putLong("ubc_last_upload_non_real", this.elx);
            }
        }
    }

    private void c(v vVar) {
        if (!vVar.isEmpty()) {
            JSONArray bee = vVar.bee();
            String md5 = com.baidu.swan.c.e.toMd5(bee.toString().getBytes(), true);
            dw(bee.toString(), md5);
            this.elt.at(md5, vVar.bei());
            if (!this.elt.a(vVar.bec(), vVar.bed(), vVar.bei(), md5)) {
                vVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", md5);
                if (file.exists() && file.delete()) {
                    Log.d("CeresBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.elt.yI(md5);
                return;
            }
            n.bdO().d(bee, md5);
            vVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(JSONArray jSONArray, String str) {
        if (this.elC.H(jSONArray)) {
            n.bdO().au(str, true);
        } else {
            n.bdO().au(str, false);
        }
    }

    private void bdk() {
        hX(true);
        hX(false);
    }

    private void hX(boolean z) {
        v vVar = new v();
        vVar.ia(z);
        if (this.elu.a(vVar, z)) {
            JSONArray bee = vVar.bee();
            this.elu.hW(z);
            n.bdO().K(bee);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(JSONArray jSONArray) {
        if (!this.elC.H(jSONArray)) {
            e.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a bdl() {
        return this.elt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(q qVar) {
        this.elD.aZ(qVar.bdU());
        this.elD.nh(qVar.bdT() * 86400000);
        this.elD.ni(qVar.bdS());
        u.bea().putString("ubc_version_md5", qVar.getSign());
        this.elt.aY(qVar.bdU());
        qVar.bdU().clear();
        if (this.elA == null) {
            this.elA = new SparseArray<>();
        }
        this.elA.clear();
        if (this.elB == null) {
            this.elB = new HashMap<>();
        }
        this.elB.clear();
        this.elt.b(this.elA);
        int i = 0;
        for (int i2 = 0; i2 < this.elA.size(); i2++) {
            int keyAt = this.elA.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.elB.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.elD.ng(i);
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

    private void dw(String str, String str2) {
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
                t.zc("save to file suc");
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
    public void yK(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", str);
        t.zc("delete file");
        if (file.exists() && file.delete()) {
            Log.d("CeresBehaviorModel", "deleteUploadFile file suc");
            t.zc("delete file suc");
        }
        this.elt.yI(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void yL(String str) {
        t.zc("upload file fail");
        this.elt.yJ(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bdm() {
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
                    this.elt.bcY();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    j yH = this.elt.yH(listFiles[i].getName());
                    if (yH != null && TextUtils.equals("0", yH.bdJ())) {
                        t.zc("processFailedData file, no need to send");
                    } else if (yH != null && TextUtils.equals("1", yH.bdJ())) {
                        t.zc("processFailedData file, send");
                        this.elt.dv(listFiles[i].getName(), "0");
                        yM(listFiles[i].getName());
                    } else {
                        t.zc("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    void yM(String str) {
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
                                n.bdO().d(new JSONArray(com.baidu.swan.c.g.getStringFromInput(inputStream2)), str);
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
    public void bdn() {
        this.elt.bcZ();
    }
}
