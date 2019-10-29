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
import java.io.IOException;
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
/* loaded from: classes2.dex */
public class c {
    private a bOS;
    private b bOT;
    private long bOV;
    private long bOW;
    private long bOX;
    private int bOY;
    private SparseArray<ArrayList> bOZ;
    private HashMap<String, Long> bPa;
    private d bPc;
    private Context mContext;
    private l bPb = s.adh().Kg();
    private List<h> bOU = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.bOS = new a(context);
        this.bOT = new b(context);
        u adi = u.adi();
        this.bOV = adi.getLong("ubc_last_upload_all_time", 0L);
        this.bOW = adi.getLong("ubc_last_upload_non_real", 0L);
        this.bOX = adi.getLong("ubc_reset_real_time_count_time", 0L);
        this.bOY = adi.getInt("ubc_real_time_count", 0);
        this.bPc = d.acv();
        this.bPc.a(this, context);
    }

    private void ack() {
        if (this.bOZ == null) {
            this.bOZ = new SparseArray<>();
            this.bOS.a(this.bOZ);
            this.bPa = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.bOZ.size(); i2++) {
                int keyAt = this.bOZ.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.bPa.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.bPc.gR(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(h hVar) {
        boolean z = false;
        if (TextUtils.equals(hVar.getId(), hVar.acI()) && this.bPc.lr(hVar.getId()) && (hVar.getOption() & 64) == 0) {
            z = true;
        }
        if (z && !c(hVar)) {
            this.bOS.a(hVar);
        } else if (Math.abs(System.currentTimeMillis() - this.bOW) >= d.acv().acw()) {
            if (!z) {
                this.bOU.add(hVar);
            }
            acp();
        } else if ((hVar.getOption() & 1) == 0) {
            if (!z) {
                this.bOU.add(hVar);
            }
            if (this.bOU.size() >= 20) {
                acl();
            }
        } else if (!z) {
            this.bOS.a(hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(h hVar) {
        this.bOT.a(hVar, this.bPc.lr(hVar.getId()));
    }

    private void acl() {
        if (this.bOU != null && this.bOU.size() != 0) {
            this.bOS.ag(this.bOU);
            this.bOU.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.bOS.a(jVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(String str, int i, String str2) {
        this.bOS.e(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        acl();
        this.bOS.a(str, i, j, jSONArray);
        if (this.bPc.lr(str)) {
            acm();
        }
        if (Math.abs(System.currentTimeMillis() - this.bOW) >= d.acv().acw()) {
            acp();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(String str, int i) {
        acl();
        this.bOS.t(str, i);
        if (Math.abs(System.currentTimeMillis() - this.bOW) >= d.acv().acw()) {
            acp();
        }
    }

    private boolean c(h hVar) {
        if (ch(this.mContext) && acn()) {
            acl();
            v vVar = new v();
            vVar.dJ(true);
            JSONObject acL = hVar.acL();
            if (acL != null && acL.has("bizId")) {
                r.bq(acL);
                vVar.bs(acL);
                vVar.m(hVar.getTime(), hVar.getTime());
                try {
                    JSONObject jSONObject = acL.getJSONObject("content");
                    JSONObject jSONObject2 = acL.getJSONObject("appInfo");
                    if (jSONObject != null && jSONObject2 != null) {
                        jSONObject.put("appInfo", jSONObject2);
                        acL.remove("appInfo");
                    }
                } catch (JSONException e) {
                }
            } else {
                try {
                    JSONObject jSONObject3 = new r(hVar.acM()).toJSONObject();
                    jSONObject3.put("bizId", hVar.getId());
                    jSONObject3.put("timestamp", Long.toString(hVar.getTime()));
                    if (hVar.acL() != null) {
                        jSONObject3.put("content", hVar.acL());
                    } else {
                        jSONObject3.put("content", hVar.getContent());
                    }
                    jSONObject3.put("eventType", "0");
                    if (!TextUtils.isEmpty(hVar.acK())) {
                        jSONObject3.put("abtest", hVar.acK());
                        vVar.lG("1");
                    }
                    if (!TextUtils.isEmpty(hVar.getCategory())) {
                        jSONObject3.put("c", hVar.getCategory());
                    }
                    if (hVar.acG()) {
                        jSONObject3.put("of", "1");
                    }
                    jSONObject3.put("idtype", this.bPc.lx(hVar.getId()));
                    vVar.bs(jSONObject3);
                    vVar.m(hVar.getTime(), hVar.getTime());
                } catch (JSONException e2) {
                }
            }
            if (this.bOZ == null) {
                ack();
            }
            if (this.bOZ.size() > 0) {
                this.bOS.a(this.bOZ.valueAt(0), vVar);
            }
            c(vVar);
            aco();
            return true;
        }
        return false;
    }

    private void acm() {
        if (ch(this.mContext) && acn()) {
            v vVar = new v();
            vVar.dJ(true);
            if (this.bOZ == null) {
                ack();
            }
            if (this.bOZ.size() > 0) {
                if (s.adh().Nd()) {
                    this.bOS.a(vVar);
                } else {
                    this.bOS.a(this.bOZ.valueAt(0), vVar);
                }
            }
            c(vVar);
            aco();
        }
    }

    private boolean acn() {
        if (s.adh().Nd()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.bOX) > 86400000) {
            this.bOY = 0;
            this.bOX = currentTimeMillis;
            u.adi().putLong("ubc_reset_real_time_count_time", this.bOX);
            u.adi().putInt("ubc_real_time_count", this.bOY);
        }
        if (this.bOY >= 1000) {
            if (this.bOY == 1000) {
                this.bOY++;
                s.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void aco() {
        this.bOY++;
        u.adi().putInt("ubc_real_time_count", this.bOY);
    }

    private void acp() {
        if (ch(this.mContext)) {
            this.bOW = System.currentTimeMillis();
            u.adi().putLong("ubc_last_upload_non_real", this.bOW);
            acr();
            acl();
            this.bOS.acf();
            HashSet hashSet = new HashSet();
            if (this.bOZ == null) {
                ack();
            }
            v vVar = new v();
            vVar.dJ(false);
            int i = 0;
            for (int i2 = 0; i2 < this.bOZ.size(); i2++) {
                int keyAt = this.bOZ.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.bPa.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.bPc.acw()) {
                        i |= this.bOS.a(this.bOZ.valueAt(i2), vVar);
                        this.bPa.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.bOZ.size(); i3++) {
                    int keyAt2 = this.bOZ.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (vVar.ha(51200)) {
                            break;
                        }
                        this.bOS.a(this.bOZ.valueAt(i3), vVar);
                    }
                }
                c(vVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void acq() {
        if (ch(this.mContext) && Math.abs(System.currentTimeMillis() - this.bOV) >= BdKVCache.MILLS_1Hour) {
            this.bOS.acf();
            v vVar = new v();
            if (this.bOS.a(vVar) != 0) {
                v vVar2 = new v();
                vVar2.m(vVar.ado(), vVar.getMaxTime());
                vVar2.lG(vVar.adn());
                vVar2.dJ(true);
                v vVar3 = new v();
                vVar3.m(vVar.ado(), vVar.getMaxTime());
                vVar3.lG(vVar.adn());
                vVar3.dJ(false);
                SparseArray<Integer> adk = vVar.adk();
                int size = adk.size();
                for (int i = 0; i < size; i++) {
                    if (this.bPc.lr(String.valueOf(adk.valueAt(i).intValue()))) {
                        vVar2.W(adk.keyAt(i), adk.valueAt(i).intValue());
                    } else {
                        vVar3.W(adk.keyAt(i), adk.valueAt(i).intValue());
                    }
                }
                ArrayList adl = vVar.adl();
                int size2 = adl.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) adl.get(i2);
                    if (this.bPc.lr(str)) {
                        vVar2.lF(str);
                    } else {
                        vVar3.lF(str);
                    }
                }
                JSONArray adp = vVar.adp();
                int length = adp.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = adp.optJSONObject(i3);
                    if (optJSONObject.has("bizId")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("bizId");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.bPc.lr(str2)) {
                                vVar2.bs(optJSONObject);
                            } else {
                                vVar3.bs(optJSONObject);
                            }
                        }
                    }
                }
                if (vVar2.adp().length() > 0) {
                    c(vVar2);
                }
                if (vVar3.adp().length() > 0) {
                    c(vVar3);
                }
                this.bOV = System.currentTimeMillis();
                u.adi().putLong("ubc_last_upload_all_time", this.bOV);
                this.bOW = this.bOV;
                u.adi().putLong("ubc_last_upload_non_real", this.bOW);
            }
        }
    }

    private void c(v vVar) {
        if (!vVar.isEmpty()) {
            JSONArray adm = vVar.adm();
            String md5 = com.baidu.swan.c.b.toMd5(adm.toString().getBytes(), true);
            bw(adm.toString(), md5);
            this.bOS.L(md5, vVar.adq());
            if (!this.bOS.a(vVar.adk(), vVar.adl(), vVar.adq(), md5)) {
                vVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", md5);
                if (file.exists() && file.delete()) {
                    Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.bOS.lm(md5);
                return;
            }
            m.acS().b(adm, md5);
            vVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(JSONArray jSONArray, String str) {
        if (this.bPb.A(jSONArray)) {
            m.acS().M(str, true);
        } else {
            m.acS().M(str, false);
        }
    }

    private void acr() {
        dH(true);
        dH(false);
    }

    private void dH(boolean z) {
        v vVar = new v();
        vVar.dJ(z);
        if (this.bOT.a(vVar, z)) {
            JSONArray adm = vVar.adm();
            this.bOT.dG(z);
            m.acS().z(adm);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(JSONArray jSONArray) {
        if (!this.bPb.A(jSONArray)) {
            s.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a acs() {
        return this.bOS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(p pVar) {
        this.bPc.ai(pVar.adb());
        this.bPc.gS(pVar.ada() * 86400000);
        this.bPc.gT(pVar.acZ());
        u.adi().putString("ubc_version_md5", pVar.getSign());
        this.bOS.ah(pVar.adb());
        pVar.adb().clear();
        if (this.bOZ == null) {
            this.bOZ = new SparseArray<>();
        }
        this.bOZ.clear();
        if (this.bPa == null) {
            this.bPa = new HashMap<>();
        }
        this.bPa.clear();
        this.bOS.a(this.bOZ);
        int i = 0;
        for (int i2 = 0; i2 < this.bOZ.size(); i2++) {
            int keyAt = this.bOZ.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.bPa.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.bPc.gR(i);
    }

    @SuppressLint({"MissingPermission"})
    private boolean ch(Context context) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [878=4] */
    private void bw(String str, String str2) {
        OutputStream fileOutputStream;
        String str3 = this.mContext.getFilesDir() + File.separator + "statistics_data";
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(str3, str2);
        if (file2.exists()) {
            return;
        }
        OutputStream outputStream = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            outputStream = new Base64OutputStream(fileOutputStream, 0);
            outputStream.write(str.getBytes());
            outputStream.flush();
            t.lE("save to file suc");
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        } catch (Exception e3) {
            e = e3;
            outputStream = fileOutputStream;
            e.printStackTrace();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th = th2;
            outputStream = fileOutputStream;
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void lo(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", str);
        t.lE("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            t.lE("delete file suc");
        }
        this.bOS.lm(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void lp(String str) {
        t.lE("upload file fail");
        this.bOS.ln(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void act() {
        File[] listFiles;
        if (ch(this.mContext)) {
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
                    s.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, jSONObject.toString());
                    for (File file2 : listFiles) {
                        file2.delete();
                    }
                    this.bOS.acg();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    i ll = this.bOS.ll(listFiles[i].getName());
                    if (ll != null && TextUtils.equals("0", ll.acO())) {
                        t.lE("processFailedData file, no need to send");
                    } else if (ll != null && TextUtils.equals("1", ll.acO())) {
                        t.lE("processFailedData file, send");
                        this.bOS.bv(listFiles[i].getName(), "0");
                        lq(listFiles[i].getName());
                    } else {
                        t.lE("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1023=4] */
    void lq(String str) {
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
                                m.acS().b(new JSONArray(com.baidu.swan.c.f.j(inputStream2)), str);
                                inputStream = inputStream2;
                            } catch (Throwable th2) {
                                inputStream = inputStream2;
                                th = th2;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        }
                    } catch (Exception e2) {
                        inputStream2 = inputStream;
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                                return;
                            } catch (IOException e3) {
                                e3.printStackTrace();
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
            } catch (Throwable th4) {
                inputStream = null;
                th = th4;
            }
        } catch (Exception e5) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void acu() {
        this.bOS.ach();
    }
}
