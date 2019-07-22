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
    private a bvN;
    private b bvO;
    private long bvQ;
    private long bvR;
    private long bvS;
    private int bvT;
    private SparseArray<ArrayList> bvU;
    private HashMap<String, Long> bvV;
    private d bvX;
    private Context mContext;
    private l bvW = s.Yn().Fi();
    private List<h> bvP = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.bvN = new a(context);
        this.bvO = new b(context);
        u Yo = u.Yo();
        this.bvQ = Yo.getLong("ubc_last_upload_all_time", 0L);
        this.bvR = Yo.getLong("ubc_last_upload_non_real", 0L);
        this.bvS = Yo.getLong("ubc_reset_real_time_count_time", 0L);
        this.bvT = Yo.getInt("ubc_real_time_count", 0);
        this.bvX = d.XC();
        this.bvX.a(this, context);
    }

    private void Xr() {
        if (this.bvU == null) {
            this.bvU = new SparseArray<>();
            this.bvN.a(this.bvU);
            this.bvV = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.bvU.size(); i2++) {
                int keyAt = this.bvU.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.bvV.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.bvX.fV(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(h hVar) {
        boolean z = false;
        if (TextUtils.equals(hVar.getId(), hVar.XP()) && this.bvX.kN(hVar.getId()) && (hVar.getOption() & 64) == 0) {
            z = true;
        }
        if (z && !c(hVar)) {
            this.bvN.a(hVar);
        } else if (Math.abs(System.currentTimeMillis() - this.bvR) >= d.XC().XD()) {
            if (!z) {
                this.bvP.add(hVar);
            }
            Xw();
        } else if ((hVar.getOption() & 1) == 0) {
            if (!z) {
                this.bvP.add(hVar);
            }
            if (this.bvP.size() >= 20) {
                Xs();
            }
        } else if (!z) {
            this.bvN.a(hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(h hVar) {
        this.bvO.a(hVar, this.bvX.kN(hVar.getId()));
    }

    private void Xs() {
        if (this.bvP != null && this.bvP.size() != 0) {
            this.bvN.H(this.bvP);
            this.bvP.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.bvN.a(jVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str, int i, String str2) {
        this.bvN.c(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        Xs();
        this.bvN.a(str, i, j, jSONArray);
        if (this.bvX.kN(str)) {
            Xt();
        }
        if (Math.abs(System.currentTimeMillis() - this.bvR) >= d.XC().XD()) {
            Xw();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(String str, int i) {
        Xs();
        this.bvN.t(str, i);
        if (Math.abs(System.currentTimeMillis() - this.bvR) >= d.XC().XD()) {
            Xw();
        }
    }

    private boolean c(h hVar) {
        if (ch(this.mContext) && Xu()) {
            Xs();
            v vVar = new v();
            vVar.ds(true);
            JSONObject XS = hVar.XS();
            if (XS != null && XS.has("bizId")) {
                r.aS(XS);
                vVar.aU(XS);
                vVar.g(hVar.getTime(), hVar.getTime());
                try {
                    JSONObject jSONObject = XS.getJSONObject("content");
                    JSONObject jSONObject2 = XS.getJSONObject("appInfo");
                    if (jSONObject != null && jSONObject2 != null) {
                        jSONObject.put("appInfo", jSONObject2);
                        XS.remove("appInfo");
                    }
                } catch (JSONException e) {
                }
            } else {
                try {
                    JSONObject jSONObject3 = new r(hVar.XT()).toJSONObject();
                    jSONObject3.put("bizId", hVar.getId());
                    jSONObject3.put("timestamp", Long.toString(hVar.getTime()));
                    if (hVar.XS() != null) {
                        jSONObject3.put("content", hVar.XS());
                    } else {
                        jSONObject3.put("content", hVar.getContent());
                    }
                    jSONObject3.put("eventType", "0");
                    if (!TextUtils.isEmpty(hVar.XR())) {
                        jSONObject3.put(ImageViewerConfig.ABTEST, hVar.XR());
                        vVar.lc("1");
                    }
                    if (!TextUtils.isEmpty(hVar.getCategory())) {
                        jSONObject3.put("c", hVar.getCategory());
                    }
                    if (hVar.XN()) {
                        jSONObject3.put("of", "1");
                    }
                    jSONObject3.put("idtype", this.bvX.kT(hVar.getId()));
                    vVar.aU(jSONObject3);
                    vVar.g(hVar.getTime(), hVar.getTime());
                } catch (JSONException e2) {
                }
            }
            if (this.bvU == null) {
                Xr();
            }
            if (this.bvU.size() > 0) {
                this.bvN.a(this.bvU.valueAt(0), vVar);
            }
            c(vVar);
            Xv();
            return true;
        }
        return false;
    }

    private void Xt() {
        if (ch(this.mContext) && Xu()) {
            v vVar = new v();
            vVar.ds(true);
            if (this.bvU == null) {
                Xr();
            }
            if (this.bvU.size() > 0) {
                if (s.Yn().If()) {
                    this.bvN.a(vVar);
                } else {
                    this.bvN.a(this.bvU.valueAt(0), vVar);
                }
            }
            c(vVar);
            Xv();
        }
    }

    private boolean Xu() {
        if (s.Yn().If()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.bvS) > 86400000) {
            this.bvT = 0;
            this.bvS = currentTimeMillis;
            u.Yo().putLong("ubc_reset_real_time_count_time", this.bvS);
            u.Yo().putInt("ubc_real_time_count", this.bvT);
        }
        if (this.bvT >= 1000) {
            if (this.bvT == 1000) {
                this.bvT++;
                s.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void Xv() {
        this.bvT++;
        u.Yo().putInt("ubc_real_time_count", this.bvT);
    }

    private void Xw() {
        if (ch(this.mContext)) {
            this.bvR = System.currentTimeMillis();
            u.Yo().putLong("ubc_last_upload_non_real", this.bvR);
            Xy();
            Xs();
            this.bvN.Xm();
            HashSet hashSet = new HashSet();
            if (this.bvU == null) {
                Xr();
            }
            v vVar = new v();
            vVar.ds(false);
            int i = 0;
            for (int i2 = 0; i2 < this.bvU.size(); i2++) {
                int keyAt = this.bvU.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.bvV.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.bvX.XD()) {
                        i |= this.bvN.a(this.bvU.valueAt(i2), vVar);
                        this.bvV.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.bvU.size(); i3++) {
                    int keyAt2 = this.bvU.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (vVar.ge(51200)) {
                            break;
                        }
                        this.bvN.a(this.bvU.valueAt(i3), vVar);
                    }
                }
                c(vVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Xx() {
        if (ch(this.mContext) && Math.abs(System.currentTimeMillis() - this.bvQ) >= 3600000) {
            this.bvN.Xm();
            v vVar = new v();
            if (this.bvN.a(vVar) != 0) {
                v vVar2 = new v();
                vVar2.g(vVar.Yu(), vVar.Yv());
                vVar2.lc(vVar.Yt());
                vVar2.ds(true);
                v vVar3 = new v();
                vVar3.g(vVar.Yu(), vVar.Yv());
                vVar3.lc(vVar.Yt());
                vVar3.ds(false);
                SparseArray<Integer> Yq = vVar.Yq();
                int size = Yq.size();
                for (int i = 0; i < size; i++) {
                    if (this.bvX.kN(String.valueOf(Yq.valueAt(i).intValue()))) {
                        vVar2.Q(Yq.keyAt(i), Yq.valueAt(i).intValue());
                    } else {
                        vVar3.Q(Yq.keyAt(i), Yq.valueAt(i).intValue());
                    }
                }
                ArrayList Yr = vVar.Yr();
                int size2 = Yr.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) Yr.get(i2);
                    if (this.bvX.kN(str)) {
                        vVar2.lb(str);
                    } else {
                        vVar3.lb(str);
                    }
                }
                JSONArray Yw = vVar.Yw();
                int length = Yw.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = Yw.optJSONObject(i3);
                    if (optJSONObject.has("bizId")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("bizId");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.bvX.kN(str2)) {
                                vVar2.aU(optJSONObject);
                            } else {
                                vVar3.aU(optJSONObject);
                            }
                        }
                    }
                }
                if (vVar2.Yw().length() > 0) {
                    c(vVar2);
                }
                if (vVar3.Yw().length() > 0) {
                    c(vVar3);
                }
                this.bvQ = System.currentTimeMillis();
                u.Yo().putLong("ubc_last_upload_all_time", this.bvQ);
                this.bvR = this.bvQ;
                u.Yo().putLong("ubc_last_upload_non_real", this.bvR);
            }
        }
    }

    private void c(v vVar) {
        if (!vVar.isEmpty()) {
            JSONArray Ys = vVar.Ys();
            String md5 = com.baidu.swan.c.b.toMd5(Ys.toString().getBytes(), true);
            bp(Ys.toString(), md5);
            this.bvN.I(md5, vVar.Yx());
            if (!this.bvN.a(vVar.Yq(), vVar.Yr(), vVar.Yx(), md5)) {
                vVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", md5);
                if (file.exists() && file.delete()) {
                    Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.bvN.kI(md5);
                return;
            }
            m.XY().b(Ys, md5);
            vVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(JSONArray jSONArray, String str) {
        if (this.bvW.s(jSONArray)) {
            m.XY().J(str, true);
        } else {
            m.XY().J(str, false);
        }
    }

    private void Xy() {
        dq(true);
        dq(false);
    }

    private void dq(boolean z) {
        v vVar = new v();
        vVar.ds(z);
        if (this.bvO.a(vVar, z)) {
            JSONArray Ys = vVar.Ys();
            this.bvO.dp(z);
            m.XY().r(Ys);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(JSONArray jSONArray) {
        if (!this.bvW.s(jSONArray)) {
            s.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a Xz() {
        return this.bvN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(p pVar) {
        this.bvX.J(pVar.Yh());
        this.bvX.fW(pVar.Yg() * 86400000);
        this.bvX.fX(pVar.Yf());
        u.Yo().putString("ubc_version_md5", pVar.getSign());
        this.bvN.I(pVar.Yh());
        pVar.Yh().clear();
        if (this.bvU == null) {
            this.bvU = new SparseArray<>();
        }
        this.bvU.clear();
        if (this.bvV == null) {
            this.bvV = new HashMap<>();
        }
        this.bvV.clear();
        this.bvN.a(this.bvU);
        int i = 0;
        for (int i2 = 0; i2 < this.bvU.size(); i2++) {
            int keyAt = this.bvU.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.bvV.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.bvX.fV(i);
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
            t.la("save to file suc");
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
    public void kK(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", str);
        t.la("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            t.la("delete file suc");
        }
        this.bvN.kI(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void kL(String str) {
        t.la("upload file fail");
        this.bvN.kJ(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void XA() {
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
                    this.bvN.Xn();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    i kH = this.bvN.kH(listFiles[i].getName());
                    if (kH != null && TextUtils.equals("0", kH.XV())) {
                        t.la("processFailedData file, no need to send");
                    } else if (kH != null && TextUtils.equals("1", kH.XV())) {
                        t.la("processFailedData file, send");
                        this.bvN.bo(listFiles[i].getName(), "0");
                        kM(listFiles[i].getName());
                    } else {
                        t.la("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1023=4] */
    void kM(String str) {
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
                                m.XY().b(new JSONArray(com.baidu.swan.c.f.l(inputStream2)), str);
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
    public void XB() {
        this.bvN.Xo();
    }
}
