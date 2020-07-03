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
/* loaded from: classes11.dex */
public class c {
    private a dtY;
    private b dtZ;
    private long dub;
    private long duc;
    private long dud;
    private int due;
    private SparseArray<ArrayList> duf;
    private HashMap<String, Long> dug;
    private d dui;
    private Context mContext;
    private m duh = e.aJn().TZ();
    private List<i> dua = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.dtY = new a(context);
        this.dtZ = new b(context);
        u aJW = u.aJW();
        this.dub = aJW.getLong("ubc_last_upload_all_time", 0L);
        this.duc = aJW.getLong("ubc_last_upload_non_real", 0L);
        this.dud = aJW.getLong("ubc_reset_real_time_count_time", 0L);
        this.due = aJW.getInt("ubc_real_time_count", 0);
        this.dui = d.aJj();
        this.dui.a(this, context);
    }

    private void aIY() {
        if (this.duf == null) {
            this.duf = new SparseArray<>();
            this.dtY.b(this.duf);
            this.dug = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.duf.size(); i2++) {
                int keyAt = this.duf.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.dug.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.dui.jE(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(i iVar) {
        boolean z = false;
        if (TextUtils.equals(iVar.getId(), iVar.aJy()) && this.dui.tM(iVar.getId()) && (iVar.getOption() & 64) == 0) {
            z = true;
        }
        if (z && !c(iVar)) {
            this.dtY.a(iVar);
        } else if (Math.abs(System.currentTimeMillis() - this.duc) >= d.aJj().aJk()) {
            if (!z) {
                this.dua.add(iVar);
            }
            aJd();
        } else if ((iVar.getOption() & 1) == 0) {
            if (!z) {
                this.dua.add(iVar);
            }
            if (this.dua.size() >= 20) {
                aIZ();
            }
        } else if (!z) {
            this.dtY.a(iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(i iVar) {
        this.dtZ.a(iVar, this.dui.tM(iVar.getId()));
    }

    private void aIZ() {
        if (this.dua != null && this.dua.size() != 0) {
            this.dtY.at(this.dua);
            this.dua.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(k kVar) {
        this.dtY.a(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, int i, String str2) {
        this.dtY.f(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        aIZ();
        this.dtY.a(str, i, j, jSONArray);
        if (this.dui.tM(str)) {
            aJa();
        }
        if (Math.abs(System.currentTimeMillis() - this.duc) >= d.aJj().aJk()) {
            aJd();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(String str, int i) {
        aIZ();
        this.dtY.G(str, i);
        if (Math.abs(System.currentTimeMillis() - this.duc) >= d.aJj().aJk()) {
            aJd();
        }
    }

    private boolean c(i iVar) {
        if (dy(this.mContext) && aJb()) {
            aIZ();
            v vVar = new v();
            vVar.gu(true);
            JSONObject aJB = iVar.aJB();
            if (aJB != null && aJB.has("bizId")) {
                s.cC(aJB);
                vVar.cE(aJB);
                vVar.s(iVar.getTime(), iVar.getTime());
                try {
                    JSONObject jSONObject = aJB.getJSONObject("content");
                    JSONObject jSONObject2 = aJB.getJSONObject("appInfo");
                    if (jSONObject != null && jSONObject2 != null) {
                        jSONObject.put("appInfo", jSONObject2);
                        aJB.remove("appInfo");
                    }
                } catch (JSONException e) {
                }
            } else {
                try {
                    JSONObject jSONObject3 = new s(iVar.aJC()).toJSONObject();
                    jSONObject3.put("bizId", iVar.getId());
                    jSONObject3.put("timestamp", Long.toString(iVar.getTime()));
                    if (iVar.aJB() != null) {
                        jSONObject3.put("content", iVar.aJB());
                    } else {
                        jSONObject3.put("content", iVar.getContent());
                    }
                    jSONObject3.put("eventType", "0");
                    if (!TextUtils.isEmpty(iVar.aJA())) {
                        jSONObject3.put("abtest", iVar.aJA());
                        vVar.ud("1");
                    }
                    if (!TextUtils.isEmpty(iVar.getCategory())) {
                        jSONObject3.put("c", iVar.getCategory());
                    }
                    if (iVar.aJw()) {
                        jSONObject3.put("of", "1");
                    }
                    jSONObject3.put("idtype", this.dui.tS(iVar.getId()));
                    vVar.cE(jSONObject3);
                    vVar.s(iVar.getTime(), iVar.getTime());
                } catch (JSONException e2) {
                }
            }
            if (this.duf == null) {
                aIY();
            }
            if (this.duf.size() > 0) {
                this.dtY.a(this.duf.valueAt(0), vVar);
            }
            c(vVar);
            aJc();
            return true;
        }
        return false;
    }

    private void aJa() {
        if (dy(this.mContext) && aJb()) {
            v vVar = new v();
            vVar.gu(true);
            if (this.duf == null) {
                aIY();
            }
            if (this.duf.size() > 0) {
                if (e.aJn().alY()) {
                    this.dtY.a(vVar);
                } else {
                    this.dtY.a(this.duf.valueAt(0), vVar);
                }
            }
            c(vVar);
            aJc();
        }
    }

    private boolean aJb() {
        if (e.aJn().alY()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.dud) > 86400000) {
            this.due = 0;
            this.dud = currentTimeMillis;
            u.aJW().putLong("ubc_reset_real_time_count_time", this.dud);
            u.aJW().putInt("ubc_real_time_count", this.due);
        }
        if (this.due >= 1000) {
            if (this.due == 1000) {
                this.due++;
                e.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void aJc() {
        this.due++;
        u.aJW().putInt("ubc_real_time_count", this.due);
    }

    private void aJd() {
        if (dy(this.mContext)) {
            this.duc = System.currentTimeMillis();
            u.aJW().putLong("ubc_last_upload_non_real", this.duc);
            aJf();
            aIZ();
            this.dtY.aIS();
            HashSet hashSet = new HashSet();
            if (this.duf == null) {
                aIY();
            }
            v vVar = new v();
            vVar.gu(false);
            int i = 0;
            for (int i2 = 0; i2 < this.duf.size(); i2++) {
                int keyAt = this.duf.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.dug.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.dui.aJk()) {
                        i |= this.dtY.a(this.duf.valueAt(i2), vVar);
                        this.dug.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.duf.size(); i3++) {
                    int keyAt2 = this.duf.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (vVar.jN(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.dtY.a(this.duf.valueAt(i3), vVar);
                    }
                }
                c(vVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aJe() {
        if (dy(this.mContext) && Math.abs(System.currentTimeMillis() - this.dub) >= BdKVCache.MILLS_1Hour) {
            this.dtY.aIS();
            v vVar = new v();
            if (this.dtY.a(vVar) != 0) {
                v vVar2 = new v();
                vVar2.s(vVar.aKc(), vVar.getMaxTime());
                vVar2.ud(vVar.aKb());
                vVar2.gu(true);
                v vVar3 = new v();
                vVar3.s(vVar.aKc(), vVar.getMaxTime());
                vVar3.ud(vVar.aKb());
                vVar3.gu(false);
                SparseArray<Integer> aJY = vVar.aJY();
                int size = aJY.size();
                for (int i = 0; i < size; i++) {
                    if (this.dui.tM(String.valueOf(aJY.valueAt(i).intValue()))) {
                        vVar2.ay(aJY.keyAt(i), aJY.valueAt(i).intValue());
                    } else {
                        vVar3.ay(aJY.keyAt(i), aJY.valueAt(i).intValue());
                    }
                }
                ArrayList aJZ = vVar.aJZ();
                int size2 = aJZ.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) aJZ.get(i2);
                    if (this.dui.tM(str)) {
                        vVar2.uc(str);
                    } else {
                        vVar3.uc(str);
                    }
                }
                JSONArray aKd = vVar.aKd();
                int length = aKd.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = aKd.optJSONObject(i3);
                    if (optJSONObject.has("bizId")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("bizId");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.dui.tM(str2)) {
                                vVar2.cE(optJSONObject);
                            } else {
                                vVar3.cE(optJSONObject);
                            }
                        }
                    }
                }
                if (vVar2.aKd().length() > 0) {
                    c(vVar2);
                }
                if (vVar3.aKd().length() > 0) {
                    c(vVar3);
                }
                this.dub = System.currentTimeMillis();
                u.aJW().putLong("ubc_last_upload_all_time", this.dub);
                this.duc = this.dub;
                u.aJW().putLong("ubc_last_upload_non_real", this.duc);
            }
        }
    }

    private void c(v vVar) {
        if (!vVar.isEmpty()) {
            JSONArray aKa = vVar.aKa();
            String md5 = com.baidu.swan.e.e.toMd5(aKa.toString().getBytes(), true);
            cR(aKa.toString(), md5);
            this.dtY.ak(md5, vVar.aKe());
            if (!this.dtY.a(vVar.aJY(), vVar.aJZ(), vVar.aKe(), md5)) {
                vVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", md5);
                if (file.exists() && file.delete()) {
                    Log.d("CeresBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.dtY.tH(md5);
                return;
            }
            n.aJJ().d(aKa, md5);
            vVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(JSONArray jSONArray, String str) {
        if (this.duh.E(jSONArray)) {
            n.aJJ().al(str, true);
        } else {
            n.aJJ().al(str, false);
        }
    }

    private void aJf() {
        gr(true);
        gr(false);
    }

    private void gr(boolean z) {
        v vVar = new v();
        vVar.gu(z);
        if (this.dtZ.a(vVar, z)) {
            JSONArray aKa = vVar.aKa();
            this.dtZ.gq(z);
            n.aJJ().H(aKa);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(JSONArray jSONArray) {
        if (!this.duh.E(jSONArray)) {
            e.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a aJg() {
        return this.dtY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(q qVar) {
        this.dui.av(qVar.aJQ());
        this.dui.jF(qVar.aJP() * 86400000);
        this.dui.jG(qVar.aJO());
        u.aJW().putString("ubc_version_md5", qVar.getSign());
        this.dtY.au(qVar.aJQ());
        qVar.aJQ().clear();
        if (this.duf == null) {
            this.duf = new SparseArray<>();
        }
        this.duf.clear();
        if (this.dug == null) {
            this.dug = new HashMap<>();
        }
        this.dug.clear();
        this.dtY.b(this.duf);
        int i = 0;
        for (int i2 = 0; i2 < this.duf.size(); i2++) {
            int keyAt = this.duf.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.dug.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.dui.jE(i);
    }

    @SuppressLint({"MissingPermission"})
    private boolean dy(Context context) {
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

    private void cR(String str, String str2) {
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
                t.ub("save to file suc");
                com.baidu.swan.e.d.closeSafely(outputStream);
            } catch (Exception e2) {
                e = e2;
                outputStream = fileOutputStream;
                e.printStackTrace();
                com.baidu.swan.e.d.closeSafely(outputStream);
            } catch (Throwable th2) {
                th = th2;
                outputStream = fileOutputStream;
                com.baidu.swan.e.d.closeSafely(outputStream);
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void tJ(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", str);
        t.ub("delete file");
        if (file.exists() && file.delete()) {
            Log.d("CeresBehaviorModel", "deleteUploadFile file suc");
            t.ub("delete file suc");
        }
        this.dtY.tH(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void tK(String str) {
        t.ub("upload file fail");
        this.dtY.tI(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aJh() {
        File[] listFiles;
        if (dy(this.mContext)) {
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
                    this.dtY.aIT();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    j tG = this.dtY.tG(listFiles[i].getName());
                    if (tG != null && TextUtils.equals("0", tG.aJE())) {
                        t.ub("processFailedData file, no need to send");
                    } else if (tG != null && TextUtils.equals("1", tG.aJE())) {
                        t.ub("processFailedData file, send");
                        this.dtY.cQ(listFiles[i].getName(), "0");
                        tL(listFiles[i].getName());
                    } else {
                        t.ub("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    void tL(String str) {
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
                                n.aJJ().d(new JSONArray(com.baidu.swan.e.h.getStringFromInput(inputStream2)), str);
                                com.baidu.swan.e.d.closeSafely(inputStream2);
                            } catch (Throwable th2) {
                                inputStream = inputStream2;
                                th = th2;
                                com.baidu.swan.e.d.closeSafely(inputStream);
                                throw th;
                            }
                        }
                    } catch (Exception e) {
                        inputStream2 = inputStream;
                        com.baidu.swan.e.d.closeSafely(inputStream2);
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                inputStream2 = inputStream;
                com.baidu.swan.e.d.closeSafely(inputStream2);
            } catch (Throwable th4) {
                inputStream = null;
                th = th4;
            }
        } catch (Exception e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aJi() {
        this.dtY.aIU();
    }
}
