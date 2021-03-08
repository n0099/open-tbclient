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
/* loaded from: classes14.dex */
public class c {
    private int ezA;
    private SparseArray<ArrayList> ezB;
    private HashMap<String, Long> ezC;
    private d ezE;
    private a ezu;
    private b ezv;
    private long ezx;
    private long ezy;
    private long ezz;
    private Context mContext;
    private m ezD = e.beJ().aiI();
    private List<i> ezw = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.ezu = new a(context);
        this.ezv = new b(context);
        u bfr = u.bfr();
        this.ezx = bfr.getLong("ubc_last_upload_all_time", 0L);
        this.ezy = bfr.getLong("ubc_last_upload_non_real", 0L);
        this.ezz = bfr.getLong("ubc_reset_real_time_count_time", 0L);
        this.ezA = bfr.getInt("ubc_real_time_count", 0);
        this.ezE = d.beF();
        this.ezE.a(this, context);
    }

    private void beu() {
        int i = 0;
        if (this.ezB == null) {
            this.ezB = new SparseArray<>();
            this.ezu.c(this.ezB);
            this.ezC = new HashMap<>();
            int i2 = 0;
            while (true) {
                int i3 = i;
                if (i2 < this.ezB.size()) {
                    int keyAt = this.ezB.keyAt(i2);
                    i = (keyAt == 0 || i3 != 0) ? i3 : keyAt;
                    this.ezC.put("ubc_last_upload_time_level_" + keyAt, 0L);
                    i2++;
                } else {
                    this.ezE.mh(i3);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(i iVar) {
        boolean z = false;
        if (TextUtils.equals(iVar.getId(), iVar.beU()) && this.ezE.yD(iVar.getId()) && (iVar.getOption() & 64) == 0) {
            z = true;
        }
        if (z && !c(iVar)) {
            this.ezu.a(iVar);
        } else if (Math.abs(System.currentTimeMillis() - this.ezy) >= d.beF().beG()) {
            if (!z) {
                this.ezw.add(iVar);
            }
            bez();
        } else if ((iVar.getOption() & 1) == 0) {
            if (!z) {
                this.ezw.add(iVar);
            }
            if (this.ezw.size() >= 20) {
                bev();
            }
        } else if (!z) {
            this.ezu.a(iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(i iVar) {
        this.ezv.a(iVar, this.ezE.yD(iVar.getId()));
    }

    private void bev() {
        if (this.ezw != null && this.ezw.size() != 0) {
            this.ezu.bc(this.ezw);
            this.ezw.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(k kVar) {
        this.ezu.a(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str, int i, String str2) {
        this.ezu.i(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        bev();
        this.ezu.a(str, i, j, jSONArray);
        if (this.ezE.yD(str)) {
            bew();
        }
        if (Math.abs(System.currentTimeMillis() - this.ezy) >= d.beF().beG()) {
            bez();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P(String str, int i) {
        bev();
        this.ezu.P(str, i);
        if (Math.abs(System.currentTimeMillis() - this.ezy) >= d.beF().beG()) {
            bez();
        }
    }

    private boolean c(i iVar) {
        if (isNetWorkEnabled(this.mContext) && bex()) {
            bev();
            v vVar = new v();
            vVar.iL(true);
            JSONObject beX = iVar.beX();
            if (beX != null && beX.has("bizId")) {
                s.dk(beX);
                vVar.dm(beX);
                vVar.y(iVar.getTime(), iVar.getTime());
                try {
                    JSONObject jSONObject = beX.getJSONObject("content");
                    JSONObject jSONObject2 = beX.getJSONObject("appInfo");
                    if (jSONObject != null && jSONObject2 != null) {
                        jSONObject.put("appInfo", jSONObject2);
                        beX.remove("appInfo");
                    }
                } catch (JSONException e) {
                }
            } else {
                try {
                    JSONObject jSONObject3 = new s(iVar.beY()).toJSONObject();
                    jSONObject3.put("bizId", iVar.getId());
                    jSONObject3.put("timestamp", Long.toString(iVar.getTime()));
                    if (iVar.beX() != null) {
                        jSONObject3.put("content", iVar.beX());
                    } else {
                        jSONObject3.put("content", iVar.getContent());
                    }
                    jSONObject3.put("eventType", "0");
                    if (!TextUtils.isEmpty(iVar.beW())) {
                        jSONObject3.put("abtest", iVar.beW());
                        vVar.yU("1");
                    }
                    if (!TextUtils.isEmpty(iVar.getCategory())) {
                        jSONObject3.put("c", iVar.getCategory());
                    }
                    if (iVar.beS()) {
                        jSONObject3.put("of", "1");
                    }
                    jSONObject3.put("idtype", this.ezE.yJ(iVar.getId()));
                    vVar.dm(jSONObject3);
                    vVar.y(iVar.getTime(), iVar.getTime());
                } catch (JSONException e2) {
                }
            }
            if (this.ezB == null) {
                beu();
            }
            if (this.ezB.size() > 0) {
                this.ezu.a(this.ezB.valueAt(0), vVar);
            }
            c(vVar);
            bey();
            return true;
        }
        return false;
    }

    private void bew() {
        if (isNetWorkEnabled(this.mContext) && bex()) {
            v vVar = new v();
            vVar.iL(true);
            if (this.ezB == null) {
                beu();
            }
            if (this.ezB.size() > 0) {
                if (e.beJ().aDB()) {
                    this.ezu.a(vVar);
                } else {
                    this.ezu.a(this.ezB.valueAt(0), vVar);
                }
            }
            c(vVar);
            bey();
        }
    }

    private boolean bex() {
        if (e.beJ().aDB()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.ezz) > 86400000) {
            this.ezA = 0;
            this.ezz = currentTimeMillis;
            u.bfr().putLong("ubc_reset_real_time_count_time", this.ezz);
            u.bfr().putInt("ubc_real_time_count", this.ezA);
        }
        if (this.ezA >= 1000) {
            if (this.ezA == 1000) {
                this.ezA++;
                e.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void bey() {
        this.ezA++;
        u.bfr().putInt("ubc_real_time_count", this.ezA);
    }

    private void bez() {
        if (isNetWorkEnabled(this.mContext)) {
            this.ezy = System.currentTimeMillis();
            u.bfr().putLong("ubc_last_upload_non_real", this.ezy);
            beB();
            bev();
            this.ezu.beo();
            HashSet hashSet = new HashSet();
            if (this.ezB == null) {
                beu();
            }
            v vVar = new v();
            vVar.iL(false);
            int i = 0;
            for (int i2 = 0; i2 < this.ezB.size(); i2++) {
                int keyAt = this.ezB.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.ezC.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * AppStatusRules.DEFAULT_GRANULARITY)) - System.currentTimeMillis() < this.ezE.beG()) {
                        i |= this.ezu.a(this.ezB.valueAt(i2), vVar);
                        this.ezC.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.ezB.size(); i3++) {
                    int keyAt2 = this.ezB.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (vVar.mq(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.ezu.a(this.ezB.valueAt(i3), vVar);
                    }
                }
                c(vVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void beA() {
        if (isNetWorkEnabled(this.mContext) && Math.abs(System.currentTimeMillis() - this.ezx) >= BdKVCache.MILLS_1Hour) {
            this.ezu.beo();
            v vVar = new v();
            if (this.ezu.a(vVar) != 0) {
                v vVar2 = new v();
                vVar2.y(vVar.bfx(), vVar.getMaxTime());
                vVar2.yU(vVar.bfw());
                vVar2.iL(true);
                v vVar3 = new v();
                vVar3.y(vVar.bfx(), vVar.getMaxTime());
                vVar3.yU(vVar.bfw());
                vVar3.iL(false);
                SparseArray<Integer> bft = vVar.bft();
                int size = bft.size();
                for (int i = 0; i < size; i++) {
                    if (this.ezE.yD(String.valueOf(bft.valueAt(i).intValue()))) {
                        vVar2.aB(bft.keyAt(i), bft.valueAt(i).intValue());
                    } else {
                        vVar3.aB(bft.keyAt(i), bft.valueAt(i).intValue());
                    }
                }
                ArrayList bfu = vVar.bfu();
                int size2 = bfu.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) bfu.get(i2);
                    if (this.ezE.yD(str)) {
                        vVar2.yT(str);
                    } else {
                        vVar3.yT(str);
                    }
                }
                JSONArray bfy = vVar.bfy();
                int length = bfy.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = bfy.optJSONObject(i3);
                    if (optJSONObject.has("bizId")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("bizId");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.ezE.yD(str2)) {
                                vVar2.dm(optJSONObject);
                            } else {
                                vVar3.dm(optJSONObject);
                            }
                        }
                    }
                }
                if (vVar2.bfy().length() > 0) {
                    c(vVar2);
                }
                if (vVar3.bfy().length() > 0) {
                    c(vVar3);
                }
                this.ezx = System.currentTimeMillis();
                u.bfr().putLong("ubc_last_upload_all_time", this.ezx);
                this.ezy = this.ezx;
                u.bfr().putLong("ubc_last_upload_non_real", this.ezy);
            }
        }
    }

    private void c(v vVar) {
        if (!vVar.isEmpty()) {
            JSONArray bfv = vVar.bfv();
            String md5 = com.baidu.swan.c.e.toMd5(bfv.toString().getBytes(), true);
            du(bfv.toString(), md5);
            this.ezu.at(md5, vVar.bfz());
            if (!this.ezu.a(vVar.bft(), vVar.bfu(), vVar.bfz(), md5)) {
                vVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", md5);
                if (file.exists() && file.delete()) {
                    Log.d("CeresBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.ezu.yy(md5);
                return;
            }
            n.bff().d(bfv, md5);
            vVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(JSONArray jSONArray, String str) {
        if (this.ezD.H(jSONArray)) {
            n.bff().au(str, true);
        } else {
            n.bff().au(str, false);
        }
    }

    private void beB() {
        iI(true);
        iI(false);
    }

    private void iI(boolean z) {
        v vVar = new v();
        vVar.iL(z);
        if (this.ezv.a(vVar, z)) {
            JSONArray bfv = vVar.bfv();
            this.ezv.iH(z);
            n.bff().K(bfv);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(JSONArray jSONArray) {
        if (!this.ezD.H(jSONArray)) {
            e.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a beC() {
        return this.ezu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(q qVar) {
        int i = 0;
        this.ezE.be(qVar.bfl());
        this.ezE.mi(qVar.bfk() * 86400000);
        this.ezE.mj(qVar.bfj());
        u.bfr().putString("ubc_version_md5", qVar.getSign());
        this.ezu.bd(qVar.bfl());
        qVar.bfl().clear();
        if (this.ezB == null) {
            this.ezB = new SparseArray<>();
        }
        this.ezB.clear();
        if (this.ezC == null) {
            this.ezC = new HashMap<>();
        }
        this.ezC.clear();
        this.ezu.c(this.ezB);
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < this.ezB.size()) {
                int keyAt = this.ezB.keyAt(i2);
                i = (keyAt == 0 || i3 != 0) ? i3 : keyAt;
                this.ezC.put("ubc_last_upload_time_level_" + keyAt, 0L);
                i2++;
            } else {
                this.ezE.mh(i3);
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

    private void du(String str, String str2) {
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
                t.yS("save to file suc");
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
    public void yA(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", str);
        t.yS("delete file");
        if (file.exists() && file.delete()) {
            Log.d("CeresBehaviorModel", "deleteUploadFile file suc");
            t.yS("delete file suc");
        }
        this.ezu.yy(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void yB(String str) {
        t.yS("upload file fail");
        this.ezu.yz(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void beD() {
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
                    this.ezu.bep();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    j yx = this.ezu.yx(listFiles[i].getName());
                    if (yx != null && TextUtils.equals("0", yx.bfa())) {
                        t.yS("processFailedData file, no need to send");
                    } else if (yx != null && TextUtils.equals("1", yx.bfa())) {
                        t.yS("processFailedData file, send");
                        this.ezu.dt(listFiles[i].getName(), "0");
                        yC(listFiles[i].getName());
                    } else {
                        t.yS("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    void yC(String str) {
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
                                n.bff().d(new JSONArray(com.baidu.swan.c.g.getStringFromInput(inputStream2)), str);
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
    public void beE() {
        this.ezu.beq();
    }
}
