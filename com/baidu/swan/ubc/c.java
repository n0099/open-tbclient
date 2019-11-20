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
    private a bOb;
    private b bOc;
    private long bOe;
    private long bOf;
    private long bOg;
    private int bOh;
    private SparseArray<ArrayList> bOi;
    private HashMap<String, Long> bOj;
    private d bOl;
    private Context mContext;
    private l bOk = s.adf().Kh();
    private List<h> bOd = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.bOb = new a(context);
        this.bOc = new b(context);
        u adg = u.adg();
        this.bOe = adg.getLong("ubc_last_upload_all_time", 0L);
        this.bOf = adg.getLong("ubc_last_upload_non_real", 0L);
        this.bOg = adg.getLong("ubc_reset_real_time_count_time", 0L);
        this.bOh = adg.getInt("ubc_real_time_count", 0);
        this.bOl = d.act();
        this.bOl.a(this, context);
    }

    private void aci() {
        if (this.bOi == null) {
            this.bOi = new SparseArray<>();
            this.bOb.a(this.bOi);
            this.bOj = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.bOi.size(); i2++) {
                int keyAt = this.bOi.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.bOj.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.bOl.gQ(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(h hVar) {
        boolean z = false;
        if (TextUtils.equals(hVar.getId(), hVar.acG()) && this.bOl.lr(hVar.getId()) && (hVar.getOption() & 64) == 0) {
            z = true;
        }
        if (z && !c(hVar)) {
            this.bOb.a(hVar);
        } else if (Math.abs(System.currentTimeMillis() - this.bOf) >= d.act().acu()) {
            if (!z) {
                this.bOd.add(hVar);
            }
            acn();
        } else if ((hVar.getOption() & 1) == 0) {
            if (!z) {
                this.bOd.add(hVar);
            }
            if (this.bOd.size() >= 20) {
                acj();
            }
        } else if (!z) {
            this.bOb.a(hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(h hVar) {
        this.bOc.a(hVar, this.bOl.lr(hVar.getId()));
    }

    private void acj() {
        if (this.bOd != null && this.bOd.size() != 0) {
            this.bOb.ag(this.bOd);
            this.bOd.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.bOb.a(jVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(String str, int i, String str2) {
        this.bOb.e(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        acj();
        this.bOb.a(str, i, j, jSONArray);
        if (this.bOl.lr(str)) {
            ack();
        }
        if (Math.abs(System.currentTimeMillis() - this.bOf) >= d.act().acu()) {
            acn();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(String str, int i) {
        acj();
        this.bOb.t(str, i);
        if (Math.abs(System.currentTimeMillis() - this.bOf) >= d.act().acu()) {
            acn();
        }
    }

    private boolean c(h hVar) {
        if (ch(this.mContext) && acl()) {
            acj();
            v vVar = new v();
            vVar.dJ(true);
            JSONObject acJ = hVar.acJ();
            if (acJ != null && acJ.has("bizId")) {
                r.br(acJ);
                vVar.bt(acJ);
                vVar.m(hVar.getTime(), hVar.getTime());
                try {
                    JSONObject jSONObject = acJ.getJSONObject("content");
                    JSONObject jSONObject2 = acJ.getJSONObject("appInfo");
                    if (jSONObject != null && jSONObject2 != null) {
                        jSONObject.put("appInfo", jSONObject2);
                        acJ.remove("appInfo");
                    }
                } catch (JSONException e) {
                }
            } else {
                try {
                    JSONObject jSONObject3 = new r(hVar.acK()).toJSONObject();
                    jSONObject3.put("bizId", hVar.getId());
                    jSONObject3.put("timestamp", Long.toString(hVar.getTime()));
                    if (hVar.acJ() != null) {
                        jSONObject3.put("content", hVar.acJ());
                    } else {
                        jSONObject3.put("content", hVar.getContent());
                    }
                    jSONObject3.put("eventType", "0");
                    if (!TextUtils.isEmpty(hVar.acI())) {
                        jSONObject3.put("abtest", hVar.acI());
                        vVar.lG("1");
                    }
                    if (!TextUtils.isEmpty(hVar.getCategory())) {
                        jSONObject3.put("c", hVar.getCategory());
                    }
                    if (hVar.acE()) {
                        jSONObject3.put("of", "1");
                    }
                    jSONObject3.put("idtype", this.bOl.lx(hVar.getId()));
                    vVar.bt(jSONObject3);
                    vVar.m(hVar.getTime(), hVar.getTime());
                } catch (JSONException e2) {
                }
            }
            if (this.bOi == null) {
                aci();
            }
            if (this.bOi.size() > 0) {
                this.bOb.a(this.bOi.valueAt(0), vVar);
            }
            c(vVar);
            acm();
            return true;
        }
        return false;
    }

    private void ack() {
        if (ch(this.mContext) && acl()) {
            v vVar = new v();
            vVar.dJ(true);
            if (this.bOi == null) {
                aci();
            }
            if (this.bOi.size() > 0) {
                if (s.adf().Ne()) {
                    this.bOb.a(vVar);
                } else {
                    this.bOb.a(this.bOi.valueAt(0), vVar);
                }
            }
            c(vVar);
            acm();
        }
    }

    private boolean acl() {
        if (s.adf().Ne()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.bOg) > 86400000) {
            this.bOh = 0;
            this.bOg = currentTimeMillis;
            u.adg().putLong("ubc_reset_real_time_count_time", this.bOg);
            u.adg().putInt("ubc_real_time_count", this.bOh);
        }
        if (this.bOh >= 1000) {
            if (this.bOh == 1000) {
                this.bOh++;
                s.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void acm() {
        this.bOh++;
        u.adg().putInt("ubc_real_time_count", this.bOh);
    }

    private void acn() {
        if (ch(this.mContext)) {
            this.bOf = System.currentTimeMillis();
            u.adg().putLong("ubc_last_upload_non_real", this.bOf);
            acp();
            acj();
            this.bOb.acd();
            HashSet hashSet = new HashSet();
            if (this.bOi == null) {
                aci();
            }
            v vVar = new v();
            vVar.dJ(false);
            int i = 0;
            for (int i2 = 0; i2 < this.bOi.size(); i2++) {
                int keyAt = this.bOi.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.bOj.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.bOl.acu()) {
                        i |= this.bOb.a(this.bOi.valueAt(i2), vVar);
                        this.bOj.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.bOi.size(); i3++) {
                    int keyAt2 = this.bOi.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (vVar.gZ(51200)) {
                            break;
                        }
                        this.bOb.a(this.bOi.valueAt(i3), vVar);
                    }
                }
                c(vVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aco() {
        if (ch(this.mContext) && Math.abs(System.currentTimeMillis() - this.bOe) >= BdKVCache.MILLS_1Hour) {
            this.bOb.acd();
            v vVar = new v();
            if (this.bOb.a(vVar) != 0) {
                v vVar2 = new v();
                vVar2.m(vVar.adm(), vVar.getMaxTime());
                vVar2.lG(vVar.adl());
                vVar2.dJ(true);
                v vVar3 = new v();
                vVar3.m(vVar.adm(), vVar.getMaxTime());
                vVar3.lG(vVar.adl());
                vVar3.dJ(false);
                SparseArray<Integer> adi = vVar.adi();
                int size = adi.size();
                for (int i = 0; i < size; i++) {
                    if (this.bOl.lr(String.valueOf(adi.valueAt(i).intValue()))) {
                        vVar2.U(adi.keyAt(i), adi.valueAt(i).intValue());
                    } else {
                        vVar3.U(adi.keyAt(i), adi.valueAt(i).intValue());
                    }
                }
                ArrayList adj = vVar.adj();
                int size2 = adj.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) adj.get(i2);
                    if (this.bOl.lr(str)) {
                        vVar2.lF(str);
                    } else {
                        vVar3.lF(str);
                    }
                }
                JSONArray adn = vVar.adn();
                int length = adn.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = adn.optJSONObject(i3);
                    if (optJSONObject.has("bizId")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("bizId");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.bOl.lr(str2)) {
                                vVar2.bt(optJSONObject);
                            } else {
                                vVar3.bt(optJSONObject);
                            }
                        }
                    }
                }
                if (vVar2.adn().length() > 0) {
                    c(vVar2);
                }
                if (vVar3.adn().length() > 0) {
                    c(vVar3);
                }
                this.bOe = System.currentTimeMillis();
                u.adg().putLong("ubc_last_upload_all_time", this.bOe);
                this.bOf = this.bOe;
                u.adg().putLong("ubc_last_upload_non_real", this.bOf);
            }
        }
    }

    private void c(v vVar) {
        if (!vVar.isEmpty()) {
            JSONArray adk = vVar.adk();
            String md5 = com.baidu.swan.c.b.toMd5(adk.toString().getBytes(), true);
            bw(adk.toString(), md5);
            this.bOb.L(md5, vVar.ado());
            if (!this.bOb.a(vVar.adi(), vVar.adj(), vVar.ado(), md5)) {
                vVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", md5);
                if (file.exists() && file.delete()) {
                    Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.bOb.lm(md5);
                return;
            }
            m.acQ().b(adk, md5);
            vVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(JSONArray jSONArray, String str) {
        if (this.bOk.A(jSONArray)) {
            m.acQ().M(str, true);
        } else {
            m.acQ().M(str, false);
        }
    }

    private void acp() {
        dH(true);
        dH(false);
    }

    private void dH(boolean z) {
        v vVar = new v();
        vVar.dJ(z);
        if (this.bOc.a(vVar, z)) {
            JSONArray adk = vVar.adk();
            this.bOc.dG(z);
            m.acQ().z(adk);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(JSONArray jSONArray) {
        if (!this.bOk.A(jSONArray)) {
            s.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a acq() {
        return this.bOb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(p pVar) {
        this.bOl.ai(pVar.acZ());
        this.bOl.gR(pVar.acY() * 86400000);
        this.bOl.gS(pVar.acX());
        u.adg().putString("ubc_version_md5", pVar.getSign());
        this.bOb.ah(pVar.acZ());
        pVar.acZ().clear();
        if (this.bOi == null) {
            this.bOi = new SparseArray<>();
        }
        this.bOi.clear();
        if (this.bOj == null) {
            this.bOj = new HashMap<>();
        }
        this.bOj.clear();
        this.bOb.a(this.bOi);
        int i = 0;
        for (int i2 = 0; i2 < this.bOi.size(); i2++) {
            int keyAt = this.bOi.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.bOj.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.bOl.gQ(i);
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
        this.bOb.lm(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void lp(String str) {
        t.lE("upload file fail");
        this.bOb.ln(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void acr() {
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
                    this.bOb.ace();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    i ll = this.bOb.ll(listFiles[i].getName());
                    if (ll != null && TextUtils.equals("0", ll.acM())) {
                        t.lE("processFailedData file, no need to send");
                    } else if (ll != null && TextUtils.equals("1", ll.acM())) {
                        t.lE("processFailedData file, send");
                        this.bOb.bv(listFiles[i].getName(), "0");
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
                                m.acQ().b(new JSONArray(com.baidu.swan.c.f.j(inputStream2)), str);
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
    public void acs() {
        this.bOb.acf();
    }
}
