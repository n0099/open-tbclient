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
/* loaded from: classes17.dex */
public class c {
    private a eqO;
    private b eqP;
    private long eqR;
    private long eqS;
    private long eqT;
    private int eqU;
    private SparseArray<ArrayList> eqV;
    private HashMap<String, Long> eqW;
    private d eqY;
    private Context mContext;
    private m eqX = e.bfQ().akQ();
    private List<i> eqQ = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.eqO = new a(context);
        this.eqP = new b(context);
        u bgy = u.bgy();
        this.eqR = bgy.getLong("ubc_last_upload_all_time", 0L);
        this.eqS = bgy.getLong("ubc_last_upload_non_real", 0L);
        this.eqT = bgy.getLong("ubc_reset_real_time_count_time", 0L);
        this.eqU = bgy.getInt("ubc_real_time_count", 0);
        this.eqY = d.bfM();
        this.eqY.a(this, context);
    }

    private void bfB() {
        if (this.eqV == null) {
            this.eqV = new SparseArray<>();
            this.eqO.b(this.eqV);
            this.eqW = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.eqV.size(); i2++) {
                int keyAt = this.eqV.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.eqW.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.eqY.nA(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(i iVar) {
        boolean z = false;
        if (TextUtils.equals(iVar.getId(), iVar.bgb()) && this.eqY.zp(iVar.getId()) && (iVar.getOption() & 64) == 0) {
            z = true;
        }
        if (z && !c(iVar)) {
            this.eqO.a(iVar);
        } else if (Math.abs(System.currentTimeMillis() - this.eqS) >= d.bfM().bfN()) {
            if (!z) {
                this.eqQ.add(iVar);
            }
            bfG();
        } else if ((iVar.getOption() & 1) == 0) {
            if (!z) {
                this.eqQ.add(iVar);
            }
            if (this.eqQ.size() >= 20) {
                bfC();
            }
        } else if (!z) {
            this.eqO.a(iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(i iVar) {
        this.eqP.a(iVar, this.eqY.zp(iVar.getId()));
    }

    private void bfC() {
        if (this.eqQ != null && this.eqQ.size() != 0) {
            this.eqO.ba(this.eqQ);
            this.eqQ.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(k kVar) {
        this.eqO.a(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str, int i, String str2) {
        this.eqO.i(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        bfC();
        this.eqO.a(str, i, j, jSONArray);
        if (this.eqY.zp(str)) {
            bfD();
        }
        if (Math.abs(System.currentTimeMillis() - this.eqS) >= d.bfM().bfN()) {
            bfG();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(String str, int i) {
        bfC();
        this.eqO.L(str, i);
        if (Math.abs(System.currentTimeMillis() - this.eqS) >= d.bfM().bfN()) {
            bfG();
        }
    }

    private boolean c(i iVar) {
        if (isNetWorkEnabled(this.mContext) && bfE()) {
            bfC();
            v vVar = new v();
            vVar.is(true);
            JSONObject bge = iVar.bge();
            if (bge != null && bge.has("bizId")) {
                s.dd(bge);
                vVar.df(bge);
                vVar.r(iVar.getTime(), iVar.getTime());
                try {
                    JSONObject jSONObject = bge.getJSONObject("content");
                    JSONObject jSONObject2 = bge.getJSONObject("appInfo");
                    if (jSONObject != null && jSONObject2 != null) {
                        jSONObject.put("appInfo", jSONObject2);
                        bge.remove("appInfo");
                    }
                } catch (JSONException e) {
                }
            } else {
                try {
                    JSONObject jSONObject3 = new s(iVar.bgf()).toJSONObject();
                    jSONObject3.put("bizId", iVar.getId());
                    jSONObject3.put("timestamp", Long.toString(iVar.getTime()));
                    if (iVar.bge() != null) {
                        jSONObject3.put("content", iVar.bge());
                    } else {
                        jSONObject3.put("content", iVar.getContent());
                    }
                    jSONObject3.put("eventType", "0");
                    if (!TextUtils.isEmpty(iVar.bgd())) {
                        jSONObject3.put("abtest", iVar.bgd());
                        vVar.zG("1");
                    }
                    if (!TextUtils.isEmpty(iVar.getCategory())) {
                        jSONObject3.put("c", iVar.getCategory());
                    }
                    if (iVar.bfZ()) {
                        jSONObject3.put(MapBundleKey.MapObjKey.OBJ_OFFSET, "1");
                    }
                    jSONObject3.put("idtype", this.eqY.zv(iVar.getId()));
                    vVar.df(jSONObject3);
                    vVar.r(iVar.getTime(), iVar.getTime());
                } catch (JSONException e2) {
                }
            }
            if (this.eqV == null) {
                bfB();
            }
            if (this.eqV.size() > 0) {
                this.eqO.a(this.eqV.valueAt(0), vVar);
            }
            c(vVar);
            bfF();
            return true;
        }
        return false;
    }

    private void bfD() {
        if (isNetWorkEnabled(this.mContext) && bfE()) {
            v vVar = new v();
            vVar.is(true);
            if (this.eqV == null) {
                bfB();
            }
            if (this.eqV.size() > 0) {
                if (e.bfQ().aFB()) {
                    this.eqO.a(vVar);
                } else {
                    this.eqO.a(this.eqV.valueAt(0), vVar);
                }
            }
            c(vVar);
            bfF();
        }
    }

    private boolean bfE() {
        if (e.bfQ().aFB()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.eqT) > 86400000) {
            this.eqU = 0;
            this.eqT = currentTimeMillis;
            u.bgy().putLong("ubc_reset_real_time_count_time", this.eqT);
            u.bgy().putInt("ubc_real_time_count", this.eqU);
        }
        if (this.eqU >= 1000) {
            if (this.eqU == 1000) {
                this.eqU++;
                e.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void bfF() {
        this.eqU++;
        u.bgy().putInt("ubc_real_time_count", this.eqU);
    }

    private void bfG() {
        if (isNetWorkEnabled(this.mContext)) {
            this.eqS = System.currentTimeMillis();
            u.bgy().putLong("ubc_last_upload_non_real", this.eqS);
            bfI();
            bfC();
            this.eqO.bfv();
            HashSet hashSet = new HashSet();
            if (this.eqV == null) {
                bfB();
            }
            v vVar = new v();
            vVar.is(false);
            int i = 0;
            for (int i2 = 0; i2 < this.eqV.size(); i2++) {
                int keyAt = this.eqV.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.eqW.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.eqY.bfN()) {
                        i |= this.eqO.a(this.eqV.valueAt(i2), vVar);
                        this.eqW.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.eqV.size(); i3++) {
                    int keyAt2 = this.eqV.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (vVar.nJ(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.eqO.a(this.eqV.valueAt(i3), vVar);
                    }
                }
                c(vVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bfH() {
        if (isNetWorkEnabled(this.mContext) && Math.abs(System.currentTimeMillis() - this.eqR) >= BdKVCache.MILLS_1Hour) {
            this.eqO.bfv();
            v vVar = new v();
            if (this.eqO.a(vVar) != 0) {
                v vVar2 = new v();
                vVar2.r(vVar.bgE(), vVar.getMaxTime());
                vVar2.zG(vVar.bgD());
                vVar2.is(true);
                v vVar3 = new v();
                vVar3.r(vVar.bgE(), vVar.getMaxTime());
                vVar3.zG(vVar.bgD());
                vVar3.is(false);
                SparseArray<Integer> bgA = vVar.bgA();
                int size = bgA.size();
                for (int i = 0; i < size; i++) {
                    if (this.eqY.zp(String.valueOf(bgA.valueAt(i).intValue()))) {
                        vVar2.aH(bgA.keyAt(i), bgA.valueAt(i).intValue());
                    } else {
                        vVar3.aH(bgA.keyAt(i), bgA.valueAt(i).intValue());
                    }
                }
                ArrayList bgB = vVar.bgB();
                int size2 = bgB.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) bgB.get(i2);
                    if (this.eqY.zp(str)) {
                        vVar2.zF(str);
                    } else {
                        vVar3.zF(str);
                    }
                }
                JSONArray bgF = vVar.bgF();
                int length = bgF.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = bgF.optJSONObject(i3);
                    if (optJSONObject.has("bizId")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("bizId");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.eqY.zp(str2)) {
                                vVar2.df(optJSONObject);
                            } else {
                                vVar3.df(optJSONObject);
                            }
                        }
                    }
                }
                if (vVar2.bgF().length() > 0) {
                    c(vVar2);
                }
                if (vVar3.bgF().length() > 0) {
                    c(vVar3);
                }
                this.eqR = System.currentTimeMillis();
                u.bgy().putLong("ubc_last_upload_all_time", this.eqR);
                this.eqS = this.eqR;
                u.bgy().putLong("ubc_last_upload_non_real", this.eqS);
            }
        }
    }

    private void c(v vVar) {
        if (!vVar.isEmpty()) {
            JSONArray bgC = vVar.bgC();
            String md5 = com.baidu.swan.c.e.toMd5(bgC.toString().getBytes(), true);
            dC(bgC.toString(), md5);
            this.eqO.au(md5, vVar.bgG());
            if (!this.eqO.a(vVar.bgA(), vVar.bgB(), vVar.bgG(), md5)) {
                vVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", md5);
                if (file.exists() && file.delete()) {
                    Log.d("CeresBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.eqO.zk(md5);
                return;
            }
            n.bgm().d(bgC, md5);
            vVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(JSONArray jSONArray, String str) {
        if (this.eqX.I(jSONArray)) {
            n.bgm().av(str, true);
        } else {
            n.bgm().av(str, false);
        }
    }

    private void bfI() {
        ip(true);
        ip(false);
    }

    private void ip(boolean z) {
        v vVar = new v();
        vVar.is(z);
        if (this.eqP.a(vVar, z)) {
            JSONArray bgC = vVar.bgC();
            this.eqP.io(z);
            n.bgm().L(bgC);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(JSONArray jSONArray) {
        if (!this.eqX.I(jSONArray)) {
            e.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a bfJ() {
        return this.eqO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(q qVar) {
        this.eqY.bc(qVar.bgs());
        this.eqY.nB(qVar.bgr() * 86400000);
        this.eqY.nC(qVar.bgq());
        u.bgy().putString("ubc_version_md5", qVar.getSign());
        this.eqO.bb(qVar.bgs());
        qVar.bgs().clear();
        if (this.eqV == null) {
            this.eqV = new SparseArray<>();
        }
        this.eqV.clear();
        if (this.eqW == null) {
            this.eqW = new HashMap<>();
        }
        this.eqW.clear();
        this.eqO.b(this.eqV);
        int i = 0;
        for (int i2 = 0; i2 < this.eqV.size(); i2++) {
            int keyAt = this.eqV.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.eqW.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.eqY.nA(i);
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

    private void dC(String str, String str2) {
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
                t.zE("save to file suc");
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
    public void zm(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", str);
        t.zE("delete file");
        if (file.exists() && file.delete()) {
            Log.d("CeresBehaviorModel", "deleteUploadFile file suc");
            t.zE("delete file suc");
        }
        this.eqO.zk(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zn(String str) {
        t.zE("upload file fail");
        this.eqO.zl(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bfK() {
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
                    this.eqO.bfw();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    j zj = this.eqO.zj(listFiles[i].getName());
                    if (zj != null && TextUtils.equals("0", zj.bgh())) {
                        t.zE("processFailedData file, no need to send");
                    } else if (zj != null && TextUtils.equals("1", zj.bgh())) {
                        t.zE("processFailedData file, send");
                        this.eqO.dB(listFiles[i].getName(), "0");
                        zo(listFiles[i].getName());
                    } else {
                        t.zE("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    void zo(String str) {
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
                                n.bgm().d(new JSONArray(com.baidu.swan.c.g.getStringFromInput(inputStream2)), str);
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
    public void bfL() {
        this.eqO.bfx();
    }
}
