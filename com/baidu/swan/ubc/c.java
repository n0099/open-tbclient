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
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
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
    private a bwl;
    private b bwm;
    private long bwo;
    private long bwp;
    private long bwq;
    private int bwr;
    private SparseArray<ArrayList> bws;
    private HashMap<String, Long> bwt;
    private d bwv;
    private Context mContext;
    private l bwu = s.Yr().Fm();
    private List<h> bwn = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.bwl = new a(context);
        this.bwm = new b(context);
        u Ys = u.Ys();
        this.bwo = Ys.getLong("ubc_last_upload_all_time", 0L);
        this.bwp = Ys.getLong("ubc_last_upload_non_real", 0L);
        this.bwq = Ys.getLong("ubc_reset_real_time_count_time", 0L);
        this.bwr = Ys.getInt("ubc_real_time_count", 0);
        this.bwv = d.XG();
        this.bwv.a(this, context);
    }

    private void Xv() {
        if (this.bws == null) {
            this.bws = new SparseArray<>();
            this.bwl.a(this.bws);
            this.bwt = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.bws.size(); i2++) {
                int keyAt = this.bws.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.bwt.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.bwv.fW(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(h hVar) {
        boolean z = false;
        if (TextUtils.equals(hVar.getId(), hVar.XT()) && this.bwv.kP(hVar.getId()) && (hVar.getOption() & 64) == 0) {
            z = true;
        }
        if (z && !c(hVar)) {
            this.bwl.a(hVar);
        } else if (Math.abs(System.currentTimeMillis() - this.bwp) >= d.XG().XH()) {
            if (!z) {
                this.bwn.add(hVar);
            }
            XA();
        } else if ((hVar.getOption() & 1) == 0) {
            if (!z) {
                this.bwn.add(hVar);
            }
            if (this.bwn.size() >= 20) {
                Xw();
            }
        } else if (!z) {
            this.bwl.a(hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(h hVar) {
        this.bwm.a(hVar, this.bwv.kP(hVar.getId()));
    }

    private void Xw() {
        if (this.bwn != null && this.bwn.size() != 0) {
            this.bwl.H(this.bwn);
            this.bwn.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j jVar) {
        this.bwl.a(jVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str, int i, String str2) {
        this.bwl.c(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        Xw();
        this.bwl.a(str, i, j, jSONArray);
        if (this.bwv.kP(str)) {
            Xx();
        }
        if (Math.abs(System.currentTimeMillis() - this.bwp) >= d.XG().XH()) {
            XA();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(String str, int i) {
        Xw();
        this.bwl.t(str, i);
        if (Math.abs(System.currentTimeMillis() - this.bwp) >= d.XG().XH()) {
            XA();
        }
    }

    private boolean c(h hVar) {
        if (ch(this.mContext) && Xy()) {
            Xw();
            v vVar = new v();
            vVar.ds(true);
            JSONObject XW = hVar.XW();
            if (XW != null && XW.has("bizId")) {
                r.aS(XW);
                vVar.aU(XW);
                vVar.g(hVar.getTime(), hVar.getTime());
                try {
                    JSONObject jSONObject = XW.getJSONObject("content");
                    JSONObject jSONObject2 = XW.getJSONObject("appInfo");
                    if (jSONObject != null && jSONObject2 != null) {
                        jSONObject.put("appInfo", jSONObject2);
                        XW.remove("appInfo");
                    }
                } catch (JSONException e) {
                }
            } else {
                try {
                    JSONObject jSONObject3 = new r(hVar.XX()).toJSONObject();
                    jSONObject3.put("bizId", hVar.getId());
                    jSONObject3.put(DpStatConstants.KEY_TIMESTAMP, Long.toString(hVar.getTime()));
                    if (hVar.XW() != null) {
                        jSONObject3.put("content", hVar.XW());
                    } else {
                        jSONObject3.put("content", hVar.getContent());
                    }
                    jSONObject3.put("eventType", "0");
                    if (!TextUtils.isEmpty(hVar.XV())) {
                        jSONObject3.put(ImageViewerConfig.ABTEST, hVar.XV());
                        vVar.le("1");
                    }
                    if (!TextUtils.isEmpty(hVar.getCategory())) {
                        jSONObject3.put("c", hVar.getCategory());
                    }
                    if (hVar.XR()) {
                        jSONObject3.put("of", "1");
                    }
                    jSONObject3.put("idtype", this.bwv.kV(hVar.getId()));
                    vVar.aU(jSONObject3);
                    vVar.g(hVar.getTime(), hVar.getTime());
                } catch (JSONException e2) {
                }
            }
            if (this.bws == null) {
                Xv();
            }
            if (this.bws.size() > 0) {
                this.bwl.a(this.bws.valueAt(0), vVar);
            }
            c(vVar);
            Xz();
            return true;
        }
        return false;
    }

    private void Xx() {
        if (ch(this.mContext) && Xy()) {
            v vVar = new v();
            vVar.ds(true);
            if (this.bws == null) {
                Xv();
            }
            if (this.bws.size() > 0) {
                if (s.Yr().Ij()) {
                    this.bwl.a(vVar);
                } else {
                    this.bwl.a(this.bws.valueAt(0), vVar);
                }
            }
            c(vVar);
            Xz();
        }
    }

    private boolean Xy() {
        if (s.Yr().Ij()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.bwq) > 86400000) {
            this.bwr = 0;
            this.bwq = currentTimeMillis;
            u.Ys().putLong("ubc_reset_real_time_count_time", this.bwq);
            u.Ys().putInt("ubc_real_time_count", this.bwr);
        }
        if (this.bwr >= 1000) {
            if (this.bwr == 1000) {
                this.bwr++;
                s.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void Xz() {
        this.bwr++;
        u.Ys().putInt("ubc_real_time_count", this.bwr);
    }

    private void XA() {
        if (ch(this.mContext)) {
            this.bwp = System.currentTimeMillis();
            u.Ys().putLong("ubc_last_upload_non_real", this.bwp);
            XC();
            Xw();
            this.bwl.Xq();
            HashSet hashSet = new HashSet();
            if (this.bws == null) {
                Xv();
            }
            v vVar = new v();
            vVar.ds(false);
            int i = 0;
            for (int i2 = 0; i2 < this.bws.size(); i2++) {
                int keyAt = this.bws.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.bwt.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.bwv.XH()) {
                        i |= this.bwl.a(this.bws.valueAt(i2), vVar);
                        this.bwt.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.bws.size(); i3++) {
                    int keyAt2 = this.bws.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (vVar.gf(51200)) {
                            break;
                        }
                        this.bwl.a(this.bws.valueAt(i3), vVar);
                    }
                }
                c(vVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void XB() {
        if (ch(this.mContext) && Math.abs(System.currentTimeMillis() - this.bwo) >= 3600000) {
            this.bwl.Xq();
            v vVar = new v();
            if (this.bwl.a(vVar) != 0) {
                v vVar2 = new v();
                vVar2.g(vVar.Yy(), vVar.Yz());
                vVar2.le(vVar.Yx());
                vVar2.ds(true);
                v vVar3 = new v();
                vVar3.g(vVar.Yy(), vVar.Yz());
                vVar3.le(vVar.Yx());
                vVar3.ds(false);
                SparseArray<Integer> Yu = vVar.Yu();
                int size = Yu.size();
                for (int i = 0; i < size; i++) {
                    if (this.bwv.kP(String.valueOf(Yu.valueAt(i).intValue()))) {
                        vVar2.Q(Yu.keyAt(i), Yu.valueAt(i).intValue());
                    } else {
                        vVar3.Q(Yu.keyAt(i), Yu.valueAt(i).intValue());
                    }
                }
                ArrayList Yv = vVar.Yv();
                int size2 = Yv.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) Yv.get(i2);
                    if (this.bwv.kP(str)) {
                        vVar2.ld(str);
                    } else {
                        vVar3.ld(str);
                    }
                }
                JSONArray YA = vVar.YA();
                int length = YA.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = YA.optJSONObject(i3);
                    if (optJSONObject.has("bizId")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("bizId");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.bwv.kP(str2)) {
                                vVar2.aU(optJSONObject);
                            } else {
                                vVar3.aU(optJSONObject);
                            }
                        }
                    }
                }
                if (vVar2.YA().length() > 0) {
                    c(vVar2);
                }
                if (vVar3.YA().length() > 0) {
                    c(vVar3);
                }
                this.bwo = System.currentTimeMillis();
                u.Ys().putLong("ubc_last_upload_all_time", this.bwo);
                this.bwp = this.bwo;
                u.Ys().putLong("ubc_last_upload_non_real", this.bwp);
            }
        }
    }

    private void c(v vVar) {
        if (!vVar.isEmpty()) {
            JSONArray Yw = vVar.Yw();
            String md5 = com.baidu.swan.c.b.toMd5(Yw.toString().getBytes(), true);
            bp(Yw.toString(), md5);
            this.bwl.I(md5, vVar.YB());
            if (!this.bwl.a(vVar.Yu(), vVar.Yv(), vVar.YB(), md5)) {
                vVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", md5);
                if (file.exists() && file.delete()) {
                    Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.bwl.kK(md5);
                return;
            }
            m.Yc().b(Yw, md5);
            vVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(JSONArray jSONArray, String str) {
        if (this.bwu.s(jSONArray)) {
            m.Yc().J(str, true);
        } else {
            m.Yc().J(str, false);
        }
    }

    private void XC() {
        dq(true);
        dq(false);
    }

    private void dq(boolean z) {
        v vVar = new v();
        vVar.ds(z);
        if (this.bwm.a(vVar, z)) {
            JSONArray Yw = vVar.Yw();
            this.bwm.dp(z);
            m.Yc().r(Yw);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(JSONArray jSONArray) {
        if (!this.bwu.s(jSONArray)) {
            s.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a XD() {
        return this.bwl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(p pVar) {
        this.bwv.J(pVar.Yl());
        this.bwv.fX(pVar.Yk() * 86400000);
        this.bwv.fY(pVar.Yj());
        u.Ys().putString("ubc_version_md5", pVar.getSign());
        this.bwl.I(pVar.Yl());
        pVar.Yl().clear();
        if (this.bws == null) {
            this.bws = new SparseArray<>();
        }
        this.bws.clear();
        if (this.bwt == null) {
            this.bwt = new HashMap<>();
        }
        this.bwt.clear();
        this.bwl.a(this.bws);
        int i = 0;
        for (int i2 = 0; i2 < this.bws.size(); i2++) {
            int keyAt = this.bws.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.bwt.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.bwv.fW(i);
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
            t.lc("save to file suc");
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
    public void kM(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", str);
        t.lc("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            t.lc("delete file suc");
        }
        this.bwl.kK(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void kN(String str) {
        t.lc("upload file fail");
        this.bwl.kL(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void XE() {
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
                    this.bwl.Xr();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    i kJ = this.bwl.kJ(listFiles[i].getName());
                    if (kJ != null && TextUtils.equals("0", kJ.XZ())) {
                        t.lc("processFailedData file, no need to send");
                    } else if (kJ != null && TextUtils.equals("1", kJ.XZ())) {
                        t.lc("processFailedData file, send");
                        this.bwl.bo(listFiles[i].getName(), "0");
                        kO(listFiles[i].getName());
                    } else {
                        t.lc("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1023=4] */
    void kO(String str) {
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
                                m.Yc().b(new JSONArray(com.baidu.swan.c.f.l(inputStream2)), str);
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
    public void XF() {
        this.bwl.Xs();
    }
}
