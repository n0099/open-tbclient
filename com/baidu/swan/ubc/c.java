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
/* loaded from: classes15.dex */
public class c {
    private a exR;
    private b exS;
    private long exU;
    private long exV;
    private long exW;
    private int exX;
    private SparseArray<ArrayList> exY;
    private HashMap<String, Long> exZ;
    private d eyb;
    private Context mContext;
    private m eya = e.beH().aiF();
    private List<i> exT = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.exR = new a(context);
        this.exS = new b(context);
        u bfp = u.bfp();
        this.exU = bfp.getLong("ubc_last_upload_all_time", 0L);
        this.exV = bfp.getLong("ubc_last_upload_non_real", 0L);
        this.exW = bfp.getLong("ubc_reset_real_time_count_time", 0L);
        this.exX = bfp.getInt("ubc_real_time_count", 0);
        this.eyb = d.beD();
        this.eyb.a(this, context);
    }

    private void bes() {
        int i = 0;
        if (this.exY == null) {
            this.exY = new SparseArray<>();
            this.exR.e(this.exY);
            this.exZ = new HashMap<>();
            int i2 = 0;
            while (true) {
                int i3 = i;
                if (i2 < this.exY.size()) {
                    int keyAt = this.exY.keyAt(i2);
                    i = (keyAt == 0 || i3 != 0) ? i3 : keyAt;
                    this.exZ.put("ubc_last_upload_time_level_" + keyAt, 0L);
                    i2++;
                } else {
                    this.eyb.mg(i3);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(i iVar) {
        boolean z = false;
        if (TextUtils.equals(iVar.getId(), iVar.beS()) && this.eyb.yw(iVar.getId()) && (iVar.getOption() & 64) == 0) {
            z = true;
        }
        if (z && !c(iVar)) {
            this.exR.a(iVar);
        } else if (Math.abs(System.currentTimeMillis() - this.exV) >= d.beD().beE()) {
            if (!z) {
                this.exT.add(iVar);
            }
            bex();
        } else if ((iVar.getOption() & 1) == 0) {
            if (!z) {
                this.exT.add(iVar);
            }
            if (this.exT.size() >= 20) {
                bet();
            }
        } else if (!z) {
            this.exR.a(iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(i iVar) {
        this.exS.a(iVar, this.eyb.yw(iVar.getId()));
    }

    private void bet() {
        if (this.exT != null && this.exT.size() != 0) {
            this.exR.bc(this.exT);
            this.exT.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(k kVar) {
        this.exR.a(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str, int i, String str2) {
        this.exR.i(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        bet();
        this.exR.a(str, i, j, jSONArray);
        if (this.eyb.yw(str)) {
            beu();
        }
        if (Math.abs(System.currentTimeMillis() - this.exV) >= d.beD().beE()) {
            bex();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O(String str, int i) {
        bet();
        this.exR.O(str, i);
        if (Math.abs(System.currentTimeMillis() - this.exV) >= d.beD().beE()) {
            bex();
        }
    }

    private boolean c(i iVar) {
        if (isNetWorkEnabled(this.mContext) && bev()) {
            bet();
            v vVar = new v();
            vVar.iL(true);
            JSONObject beV = iVar.beV();
            if (beV != null && beV.has("bizId")) {
                s.di(beV);
                vVar.dk(beV);
                vVar.y(iVar.getTime(), iVar.getTime());
                try {
                    JSONObject jSONObject = beV.getJSONObject("content");
                    JSONObject jSONObject2 = beV.getJSONObject("appInfo");
                    if (jSONObject != null && jSONObject2 != null) {
                        jSONObject.put("appInfo", jSONObject2);
                        beV.remove("appInfo");
                    }
                } catch (JSONException e) {
                }
            } else {
                try {
                    JSONObject jSONObject3 = new s(iVar.beW()).toJSONObject();
                    jSONObject3.put("bizId", iVar.getId());
                    jSONObject3.put("timestamp", Long.toString(iVar.getTime()));
                    if (iVar.beV() != null) {
                        jSONObject3.put("content", iVar.beV());
                    } else {
                        jSONObject3.put("content", iVar.getContent());
                    }
                    jSONObject3.put("eventType", "0");
                    if (!TextUtils.isEmpty(iVar.beU())) {
                        jSONObject3.put("abtest", iVar.beU());
                        vVar.yN("1");
                    }
                    if (!TextUtils.isEmpty(iVar.getCategory())) {
                        jSONObject3.put("c", iVar.getCategory());
                    }
                    if (iVar.beQ()) {
                        jSONObject3.put("of", "1");
                    }
                    jSONObject3.put("idtype", this.eyb.yC(iVar.getId()));
                    vVar.dk(jSONObject3);
                    vVar.y(iVar.getTime(), iVar.getTime());
                } catch (JSONException e2) {
                }
            }
            if (this.exY == null) {
                bes();
            }
            if (this.exY.size() > 0) {
                this.exR.a(this.exY.valueAt(0), vVar);
            }
            c(vVar);
            bew();
            return true;
        }
        return false;
    }

    private void beu() {
        if (isNetWorkEnabled(this.mContext) && bev()) {
            v vVar = new v();
            vVar.iL(true);
            if (this.exY == null) {
                bes();
            }
            if (this.exY.size() > 0) {
                if (e.beH().aDy()) {
                    this.exR.a(vVar);
                } else {
                    this.exR.a(this.exY.valueAt(0), vVar);
                }
            }
            c(vVar);
            bew();
        }
    }

    private boolean bev() {
        if (e.beH().aDy()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.exW) > 86400000) {
            this.exX = 0;
            this.exW = currentTimeMillis;
            u.bfp().putLong("ubc_reset_real_time_count_time", this.exW);
            u.bfp().putInt("ubc_real_time_count", this.exX);
        }
        if (this.exX >= 1000) {
            if (this.exX == 1000) {
                this.exX++;
                e.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void bew() {
        this.exX++;
        u.bfp().putInt("ubc_real_time_count", this.exX);
    }

    private void bex() {
        if (isNetWorkEnabled(this.mContext)) {
            this.exV = System.currentTimeMillis();
            u.bfp().putLong("ubc_last_upload_non_real", this.exV);
            bez();
            bet();
            this.exR.bem();
            HashSet hashSet = new HashSet();
            if (this.exY == null) {
                bes();
            }
            v vVar = new v();
            vVar.iL(false);
            int i = 0;
            for (int i2 = 0; i2 < this.exY.size(); i2++) {
                int keyAt = this.exY.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.exZ.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * AppStatusRules.DEFAULT_GRANULARITY)) - System.currentTimeMillis() < this.eyb.beE()) {
                        i |= this.exR.a(this.exY.valueAt(i2), vVar);
                        this.exZ.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.exY.size(); i3++) {
                    int keyAt2 = this.exY.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (vVar.mp(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.exR.a(this.exY.valueAt(i3), vVar);
                    }
                }
                c(vVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bey() {
        if (isNetWorkEnabled(this.mContext) && Math.abs(System.currentTimeMillis() - this.exU) >= BdKVCache.MILLS_1Hour) {
            this.exR.bem();
            v vVar = new v();
            if (this.exR.a(vVar) != 0) {
                v vVar2 = new v();
                vVar2.y(vVar.bfv(), vVar.getMaxTime());
                vVar2.yN(vVar.bfu());
                vVar2.iL(true);
                v vVar3 = new v();
                vVar3.y(vVar.bfv(), vVar.getMaxTime());
                vVar3.yN(vVar.bfu());
                vVar3.iL(false);
                SparseArray<Integer> bfr = vVar.bfr();
                int size = bfr.size();
                for (int i = 0; i < size; i++) {
                    if (this.eyb.yw(String.valueOf(bfr.valueAt(i).intValue()))) {
                        vVar2.aB(bfr.keyAt(i), bfr.valueAt(i).intValue());
                    } else {
                        vVar3.aB(bfr.keyAt(i), bfr.valueAt(i).intValue());
                    }
                }
                ArrayList bfs = vVar.bfs();
                int size2 = bfs.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) bfs.get(i2);
                    if (this.eyb.yw(str)) {
                        vVar2.yM(str);
                    } else {
                        vVar3.yM(str);
                    }
                }
                JSONArray bfw = vVar.bfw();
                int length = bfw.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = bfw.optJSONObject(i3);
                    if (optJSONObject.has("bizId")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("bizId");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.eyb.yw(str2)) {
                                vVar2.dk(optJSONObject);
                            } else {
                                vVar3.dk(optJSONObject);
                            }
                        }
                    }
                }
                if (vVar2.bfw().length() > 0) {
                    c(vVar2);
                }
                if (vVar3.bfw().length() > 0) {
                    c(vVar3);
                }
                this.exU = System.currentTimeMillis();
                u.bfp().putLong("ubc_last_upload_all_time", this.exU);
                this.exV = this.exU;
                u.bfp().putLong("ubc_last_upload_non_real", this.exV);
            }
        }
    }

    private void c(v vVar) {
        if (!vVar.isEmpty()) {
            JSONArray bft = vVar.bft();
            String md5 = com.baidu.swan.c.e.toMd5(bft.toString().getBytes(), true);
            du(bft.toString(), md5);
            this.exR.at(md5, vVar.bfx());
            if (!this.exR.a(vVar.bfr(), vVar.bfs(), vVar.bfx(), md5)) {
                vVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", md5);
                if (file.exists() && file.delete()) {
                    Log.d("CeresBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.exR.yr(md5);
                return;
            }
            n.bfd().d(bft, md5);
            vVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(JSONArray jSONArray, String str) {
        if (this.eya.H(jSONArray)) {
            n.bfd().au(str, true);
        } else {
            n.bfd().au(str, false);
        }
    }

    private void bez() {
        iI(true);
        iI(false);
    }

    private void iI(boolean z) {
        v vVar = new v();
        vVar.iL(z);
        if (this.exS.a(vVar, z)) {
            JSONArray bft = vVar.bft();
            this.exS.iH(z);
            n.bfd().K(bft);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(JSONArray jSONArray) {
        if (!this.eya.H(jSONArray)) {
            e.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a beA() {
        return this.exR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(q qVar) {
        int i = 0;
        this.eyb.be(qVar.bfj());
        this.eyb.mh(qVar.bfi() * 86400000);
        this.eyb.mi(qVar.bfh());
        u.bfp().putString("ubc_version_md5", qVar.getSign());
        this.exR.bd(qVar.bfj());
        qVar.bfj().clear();
        if (this.exY == null) {
            this.exY = new SparseArray<>();
        }
        this.exY.clear();
        if (this.exZ == null) {
            this.exZ = new HashMap<>();
        }
        this.exZ.clear();
        this.exR.e(this.exY);
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < this.exY.size()) {
                int keyAt = this.exY.keyAt(i2);
                i = (keyAt == 0 || i3 != 0) ? i3 : keyAt;
                this.exZ.put("ubc_last_upload_time_level_" + keyAt, 0L);
                i2++;
            } else {
                this.eyb.mg(i3);
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
                t.yL("save to file suc");
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
    public void yt(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", str);
        t.yL("delete file");
        if (file.exists() && file.delete()) {
            Log.d("CeresBehaviorModel", "deleteUploadFile file suc");
            t.yL("delete file suc");
        }
        this.exR.yr(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void yu(String str) {
        t.yL("upload file fail");
        this.exR.ys(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void beB() {
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
                    this.exR.ben();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    j yq = this.exR.yq(listFiles[i].getName());
                    if (yq != null && TextUtils.equals("0", yq.beY())) {
                        t.yL("processFailedData file, no need to send");
                    } else if (yq != null && TextUtils.equals("1", yq.beY())) {
                        t.yL("processFailedData file, send");
                        this.exR.dt(listFiles[i].getName(), "0");
                        yv(listFiles[i].getName());
                    } else {
                        t.yL("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    void yv(String str) {
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
                                n.bfd().d(new JSONArray(com.baidu.swan.c.g.getStringFromInput(inputStream2)), str);
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
    public void beC() {
        this.exR.beo();
    }
}
