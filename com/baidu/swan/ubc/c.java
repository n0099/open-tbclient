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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
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
    private a buX;
    private b buY;
    private long bva;
    private long bvb;
    private long bvc;
    private int bvd;
    private SparseArray<ArrayList> bve;
    private HashMap<String, Long> bvf;
    private d bvh;
    private Context mContext;
    private l bvg = s.Xr().Ez();
    private List<h> buZ = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.buX = new a(context);
        this.buY = new b(context);
        u Xs = u.Xs();
        this.bva = Xs.getLong("ubc_last_upload_all_time", 0L);
        this.bvb = Xs.getLong("ubc_last_upload_non_real", 0L);
        this.bvc = Xs.getLong("ubc_reset_real_time_count_time", 0L);
        this.bvd = Xs.getInt("ubc_real_time_count", 0);
        this.bvh = d.WI();
        this.bvh.a(this, context);
    }

    private void Wx() {
        if (this.bve == null) {
            this.bve = new SparseArray<>();
            this.buX.a(this.bve);
            this.bvf = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.bve.size(); i2++) {
                int keyAt = this.bve.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.bvf.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.bvh.fR(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(h hVar) {
        boolean z = false;
        if (TextUtils.equals(hVar.getId(), hVar.WU()) && this.bvh.kG(hVar.getId()) && (hVar.getOption() & 64) == 0) {
            z = true;
        }
        if (z && !c(hVar)) {
            this.buX.a(hVar);
        } else if (Math.abs(System.currentTimeMillis() - this.bvb) >= d.WI().WJ()) {
            if (!z) {
                this.buZ.add(hVar);
            }
            WC();
        } else if ((hVar.getOption() & 1) == 0) {
            if (!z) {
                this.buZ.add(hVar);
            }
            if (this.buZ.size() >= 20) {
                Wy();
            }
        } else if (!z) {
            this.buX.a(hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(h hVar) {
        this.buY.a(hVar, this.bvh.kG(hVar.getId()));
    }

    private void Wy() {
        if (this.buZ != null && this.buZ.size() != 0) {
            this.buX.H(this.buZ);
            this.buZ.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.buX.a(jVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str, int i, String str2) {
        this.buX.c(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        Wy();
        this.buX.a(str, i, j, jSONArray);
        if (this.bvh.kG(str)) {
            Wz();
        }
        if (Math.abs(System.currentTimeMillis() - this.bvb) >= d.WI().WJ()) {
            WC();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(String str, int i) {
        Wy();
        this.buX.t(str, i);
        if (Math.abs(System.currentTimeMillis() - this.bvb) >= d.WI().WJ()) {
            WC();
        }
    }

    private boolean c(h hVar) {
        if (cg(this.mContext) && WA()) {
            Wy();
            v vVar = new v();
            vVar.dn(true);
            JSONObject WX = hVar.WX();
            if (WX != null && WX.has("bizId")) {
                r.aS(WX);
                vVar.aU(WX);
                vVar.g(hVar.getTime(), hVar.getTime());
                try {
                    JSONObject jSONObject = WX.getJSONObject("content");
                    JSONObject jSONObject2 = WX.getJSONObject("appInfo");
                    if (jSONObject != null && jSONObject2 != null) {
                        jSONObject.put("appInfo", jSONObject2);
                        WX.remove("appInfo");
                    }
                } catch (JSONException e) {
                }
            } else {
                try {
                    JSONObject jSONObject3 = new r(hVar.WY()).toJSONObject();
                    jSONObject3.put("bizId", hVar.getId());
                    jSONObject3.put("timestamp", Long.toString(hVar.getTime()));
                    if (hVar.WX() != null) {
                        jSONObject3.put("content", hVar.WX());
                    } else {
                        jSONObject3.put("content", hVar.getContent());
                    }
                    jSONObject3.put("eventType", "0");
                    if (!TextUtils.isEmpty(hVar.WW())) {
                        jSONObject3.put(ImageViewerConfig.ABTEST, hVar.WW());
                        vVar.kV("1");
                    }
                    if (!TextUtils.isEmpty(hVar.getCategory())) {
                        jSONObject3.put("c", hVar.getCategory());
                    }
                    if (hVar.WS()) {
                        jSONObject3.put("of", "1");
                    }
                    jSONObject3.put("idtype", this.bvh.kM(hVar.getId()));
                    vVar.aU(jSONObject3);
                    vVar.g(hVar.getTime(), hVar.getTime());
                } catch (JSONException e2) {
                }
            }
            if (this.bve == null) {
                Wx();
            }
            if (this.bve.size() > 0) {
                this.buX.a(this.bve.valueAt(0), vVar);
            }
            c(vVar);
            WB();
            return true;
        }
        return false;
    }

    private void Wz() {
        if (cg(this.mContext) && WA()) {
            v vVar = new v();
            vVar.dn(true);
            if (this.bve == null) {
                Wx();
            }
            if (this.bve.size() > 0) {
                if (s.Xr().Ht()) {
                    this.buX.a(vVar);
                } else {
                    this.buX.a(this.bve.valueAt(0), vVar);
                }
            }
            c(vVar);
            WB();
        }
    }

    private boolean WA() {
        if (s.Xr().Ht()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.bvc) > 86400000) {
            this.bvd = 0;
            this.bvc = currentTimeMillis;
            u.Xs().putLong("ubc_reset_real_time_count_time", this.bvc);
            u.Xs().putInt("ubc_real_time_count", this.bvd);
        }
        if (this.bvd >= 1000) {
            if (this.bvd == 1000) {
                this.bvd++;
                s.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void WB() {
        this.bvd++;
        u.Xs().putInt("ubc_real_time_count", this.bvd);
    }

    private void WC() {
        if (cg(this.mContext)) {
            this.bvb = System.currentTimeMillis();
            u.Xs().putLong("ubc_last_upload_non_real", this.bvb);
            WE();
            Wy();
            this.buX.Ws();
            HashSet hashSet = new HashSet();
            if (this.bve == null) {
                Wx();
            }
            v vVar = new v();
            vVar.dn(false);
            int i = 0;
            for (int i2 = 0; i2 < this.bve.size(); i2++) {
                int keyAt = this.bve.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.bvf.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.bvh.WJ()) {
                        i |= this.buX.a(this.bve.valueAt(i2), vVar);
                        this.bvf.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.bve.size(); i3++) {
                    int keyAt2 = this.bve.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (vVar.ga(51200)) {
                            break;
                        }
                        this.buX.a(this.bve.valueAt(i3), vVar);
                    }
                }
                c(vVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void WD() {
        if (cg(this.mContext) && Math.abs(System.currentTimeMillis() - this.bva) >= 3600000) {
            this.buX.Ws();
            v vVar = new v();
            if (this.buX.a(vVar) != 0) {
                v vVar2 = new v();
                vVar2.g(vVar.Xy(), vVar.Xz());
                vVar2.kV(vVar.Xx());
                vVar2.dn(true);
                v vVar3 = new v();
                vVar3.g(vVar.Xy(), vVar.Xz());
                vVar3.kV(vVar.Xx());
                vVar3.dn(false);
                SparseArray<Integer> Xu = vVar.Xu();
                int size = Xu.size();
                for (int i = 0; i < size; i++) {
                    if (this.bvh.kG(String.valueOf(Xu.valueAt(i).intValue()))) {
                        vVar2.N(Xu.keyAt(i), Xu.valueAt(i).intValue());
                    } else {
                        vVar3.N(Xu.keyAt(i), Xu.valueAt(i).intValue());
                    }
                }
                ArrayList Xv = vVar.Xv();
                int size2 = Xv.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) Xv.get(i2);
                    if (this.bvh.kG(str)) {
                        vVar2.kU(str);
                    } else {
                        vVar3.kU(str);
                    }
                }
                JSONArray XA = vVar.XA();
                int length = XA.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = XA.optJSONObject(i3);
                    if (optJSONObject.has("bizId")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("bizId");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.bvh.kG(str2)) {
                                vVar2.aU(optJSONObject);
                            } else {
                                vVar3.aU(optJSONObject);
                            }
                        }
                    }
                }
                if (vVar2.XA().length() > 0) {
                    c(vVar2);
                }
                if (vVar3.XA().length() > 0) {
                    c(vVar3);
                }
                this.bva = System.currentTimeMillis();
                u.Xs().putLong("ubc_last_upload_all_time", this.bva);
                this.bvb = this.bva;
                u.Xs().putLong("ubc_last_upload_non_real", this.bvb);
            }
        }
    }

    private void c(v vVar) {
        if (!vVar.isEmpty()) {
            JSONArray Xw = vVar.Xw();
            String md5 = com.baidu.swan.c.b.toMd5(Xw.toString().getBytes(), true);
            bp(Xw.toString(), md5);
            this.buX.H(md5, vVar.XB());
            if (!this.buX.a(vVar.Xu(), vVar.Xv(), vVar.XB(), md5)) {
                vVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", md5);
                if (file.exists() && file.delete()) {
                    Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.buX.kB(md5);
                return;
            }
            m.Xd().b(Xw, md5);
            vVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(JSONArray jSONArray, String str) {
        if (this.bvg.s(jSONArray)) {
            m.Xd().I(str, true);
        } else {
            m.Xd().I(str, false);
        }
    }

    private void WE() {
        dl(true);
        dl(false);
    }

    private void dl(boolean z) {
        v vVar = new v();
        vVar.dn(z);
        if (this.buY.a(vVar, z)) {
            JSONArray Xw = vVar.Xw();
            this.buY.dk(z);
            m.Xd().r(Xw);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(JSONArray jSONArray) {
        if (!this.bvg.s(jSONArray)) {
            s.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a WF() {
        return this.buX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(p pVar) {
        this.bvh.J(pVar.Xl());
        this.bvh.fS(pVar.Xk() * 86400000);
        this.bvh.fT(pVar.getThreshold());
        u.Xs().putString("ubc_version_md5", pVar.getSign());
        this.buX.I(pVar.Xl());
        pVar.Xl().clear();
        if (this.bve == null) {
            this.bve = new SparseArray<>();
        }
        this.bve.clear();
        if (this.bvf == null) {
            this.bvf = new HashMap<>();
        }
        this.bvf.clear();
        this.buX.a(this.bve);
        int i = 0;
        for (int i2 = 0; i2 < this.bve.size(); i2++) {
            int keyAt = this.bve.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.bvf.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.bvh.fR(i);
    }

    @SuppressLint({"MissingPermission"})
    private boolean cg(Context context) {
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
    private void bp(String str, String str2) {
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
            t.kT("save to file suc");
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
    public void kD(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", str);
        t.kT("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            t.kT("delete file suc");
        }
        this.buX.kB(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void kE(String str) {
        t.kT("upload file fail");
        this.buX.kC(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void WG() {
        File[] listFiles;
        if (cg(this.mContext)) {
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
                    this.buX.Wt();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    i kA = this.buX.kA(listFiles[i].getName());
                    if (kA != null && TextUtils.equals("0", kA.Xa())) {
                        t.kT("processFailedData file, no need to send");
                    } else if (kA != null && TextUtils.equals("1", kA.Xa())) {
                        t.kT("processFailedData file, send");
                        this.buX.bo(listFiles[i].getName(), "0");
                        kF(listFiles[i].getName());
                    } else {
                        t.kT("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1023=4] */
    void kF(String str) {
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
                                m.Xd().b(new JSONArray(com.baidu.swan.c.f.l(inputStream2)), str);
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
    public void WH() {
        this.buX.Wu();
    }
}
