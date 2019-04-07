package com.baidu.swan.ubc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Base64OutputStream;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.FileOutputStream;
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
    private a boS;
    private b boT;
    private long boV;
    private long boW;
    private long boX;
    private int boY;
    private SparseArray<ArrayList> boZ;
    private HashMap<String, Long> bpa;
    private d bpc;
    private Context mContext;
    private k bpb = q.Tq().uX();
    private List<h> boU = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.boS = new a(context);
        this.boT = new b(context);
        s Tr = s.Tr();
        this.boV = Tr.getLong("ubc_last_upload_all_time", 0L);
        this.boW = Tr.getLong("ubc_last_upload_non_real", 0L);
        this.boX = Tr.getLong("ubc_reset_real_time_count_time", 0L);
        this.boY = Tr.getInt("ubc_real_time_count", 0);
        this.bpc = d.SU();
        this.bpc.a(this, context);
    }

    private void SK() {
        if (this.boZ == null) {
            this.boZ = new SparseArray<>();
            this.boS.a(this.boZ);
            this.bpa = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.boZ.size(); i2++) {
                int keyAt = this.boZ.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.bpa.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.bpc.fn(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(h hVar) {
        boolean z = false;
        if (TextUtils.equals(hVar.getId(), hVar.Ta()) && this.bpc.jI(hVar.getId()) && (hVar.getOption() & 64) == 0) {
            z = true;
        }
        if (z && !c(hVar)) {
            this.boS.a(hVar);
        } else if (Math.abs(System.currentTimeMillis() - this.boW) >= d.SU().SV()) {
            if (!z) {
                this.boU.add(hVar);
            }
            SP();
        } else if ((hVar.getOption() & 1) == 0) {
            if (!z) {
                this.boU.add(hVar);
            }
            if (this.boU.size() >= 20) {
                SL();
            }
        } else if (!z) {
            this.boS.a(hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(h hVar) {
        this.boT.a(hVar, this.bpc.jI(hVar.getId()));
    }

    private void SL() {
        if (this.boU != null && this.boU.size() != 0) {
            this.boS.G(this.boU);
            this.boU.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(i iVar) {
        this.boS.a(iVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str, int i, String str2) {
        this.boS.c(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        SL();
        this.boS.a(str, i, j, jSONArray);
        if (this.bpc.jI(str)) {
            SM();
        }
        if (Math.abs(System.currentTimeMillis() - this.boW) >= d.SU().SV()) {
            SP();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(String str, int i) {
        SL();
        this.boS.y(str, i);
        if (Math.abs(System.currentTimeMillis() - this.boW) >= d.SU().SV()) {
            SP();
        }
    }

    private boolean c(h hVar) {
        if (cD(this.mContext) && SN()) {
            SL();
            t tVar = new t();
            tVar.cW(true);
            JSONObject Td = hVar.Td();
            if (Td != null && Td.has("bizId")) {
                p.aG(Td);
                tVar.aI(Td);
                tVar.g(hVar.getTime(), hVar.getTime());
                try {
                    JSONObject jSONObject = Td.getJSONObject("content");
                    JSONObject jSONObject2 = Td.getJSONObject("appInfo");
                    if (jSONObject != null && jSONObject2 != null) {
                        jSONObject.put("appInfo", jSONObject2);
                        Td.remove("appInfo");
                    }
                } catch (JSONException e) {
                }
            } else {
                try {
                    JSONObject jSONObject3 = new p(hVar.Te()).toJSONObject();
                    jSONObject3.put("bizId", hVar.getId());
                    jSONObject3.put("timestamp", Long.toString(hVar.getTime()));
                    if (hVar.Td() != null) {
                        jSONObject3.put("content", hVar.Td());
                    } else {
                        jSONObject3.put("content", hVar.getContent());
                    }
                    jSONObject3.put("eventType", "0");
                    if (!TextUtils.isEmpty(hVar.Tc())) {
                        jSONObject3.put(ImageViewerConfig.ABTEST, hVar.Tc());
                        tVar.jW("1");
                    }
                    if (!TextUtils.isEmpty(hVar.getCategory())) {
                        jSONObject3.put("c", hVar.getCategory());
                    }
                    if (hVar.SY()) {
                        jSONObject3.put("of", "1");
                    }
                    jSONObject3.put("idtype", this.bpc.jO(hVar.getId()));
                    tVar.aI(jSONObject3);
                    tVar.g(hVar.getTime(), hVar.getTime());
                } catch (JSONException e2) {
                }
            }
            if (this.boZ == null) {
                SK();
            }
            if (this.boZ.size() > 0) {
                this.boS.a(this.boZ.valueAt(0), tVar);
            }
            c(tVar);
            SO();
            return true;
        }
        return false;
    }

    private void SM() {
        if (cD(this.mContext) && SN()) {
            t tVar = new t();
            tVar.cW(true);
            if (this.boZ == null) {
                SK();
            }
            if (this.boZ.size() > 0) {
                if (q.Tq().Fo()) {
                    this.boS.a(tVar);
                } else {
                    this.boS.a(this.boZ.valueAt(0), tVar);
                }
            }
            c(tVar);
            SO();
        }
    }

    private boolean SN() {
        if (q.Tq().Fo()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.boX) > 86400000) {
            this.boY = 0;
            this.boX = currentTimeMillis;
            s.Tr().putLong("ubc_reset_real_time_count_time", this.boX);
            s.Tr().putInt("ubc_real_time_count", this.boY);
        }
        if (this.boY >= 1000) {
            if (this.boY == 1000) {
                this.boY++;
                q.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void SO() {
        this.boY++;
        s.Tr().putInt("ubc_real_time_count", this.boY);
    }

    private void SP() {
        if (cD(this.mContext)) {
            this.boW = System.currentTimeMillis();
            s.Tr().putLong("ubc_last_upload_non_real", this.boW);
            SR();
            SL();
            this.boS.SG();
            HashSet hashSet = new HashSet();
            if (this.boZ == null) {
                SK();
            }
            t tVar = new t();
            tVar.cW(false);
            int i = 0;
            for (int i2 = 0; i2 < this.boZ.size(); i2++) {
                int keyAt = this.boZ.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.bpa.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.bpc.SV()) {
                        i |= this.boS.a(this.boZ.valueAt(i2), tVar);
                        this.bpa.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.boZ.size(); i3++) {
                    int keyAt2 = this.boZ.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (tVar.fr(51200)) {
                            break;
                        }
                        this.boS.a(this.boZ.valueAt(i3), tVar);
                    }
                }
                c(tVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void SQ() {
        if (cD(this.mContext) && Math.abs(System.currentTimeMillis() - this.boV) >= 3600000) {
            this.boS.SG();
            t tVar = new t();
            if (this.boS.a(tVar) != 0) {
                t tVar2 = new t();
                tVar2.g(tVar.Tx(), tVar.Ty());
                tVar2.jW(tVar.Tw());
                tVar2.cW(true);
                t tVar3 = new t();
                tVar3.g(tVar.Tx(), tVar.Ty());
                tVar3.jW(tVar.Tw());
                tVar3.cW(false);
                SparseArray<Integer> Tt = tVar.Tt();
                int size = Tt.size();
                for (int i = 0; i < size; i++) {
                    if (this.bpc.jI(String.valueOf(Tt.valueAt(i).intValue()))) {
                        tVar2.P(Tt.keyAt(i), Tt.valueAt(i).intValue());
                    } else {
                        tVar3.P(Tt.keyAt(i), Tt.valueAt(i).intValue());
                    }
                }
                ArrayList Tu = tVar.Tu();
                int size2 = Tu.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) Tu.get(i2);
                    if (this.bpc.jI(str)) {
                        tVar2.jV(str);
                    } else {
                        tVar3.jV(str);
                    }
                }
                JSONArray Tz = tVar.Tz();
                int length = Tz.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = Tz.optJSONObject(i3);
                    if (optJSONObject.has("bizId")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("bizId");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.bpc.jI(str2)) {
                                tVar2.aI(optJSONObject);
                            } else {
                                tVar3.aI(optJSONObject);
                            }
                        }
                    }
                }
                if (tVar2.Tz().length() > 0) {
                    c(tVar2);
                }
                if (tVar3.Tz().length() > 0) {
                    c(tVar3);
                }
                this.boV = System.currentTimeMillis();
                s.Tr().putLong("ubc_last_upload_all_time", this.boV);
                this.boW = this.boV;
                s.Tr().putLong("ubc_last_upload_non_real", this.boW);
            }
        }
    }

    private void c(t tVar) {
        if (!tVar.isEmpty()) {
            JSONArray Tv = tVar.Tv();
            String md5 = com.baidu.swan.c.c.toMd5(Tv.toString().getBytes(), true);
            bk(Tv.toString(), md5);
            if (!this.boS.a(tVar.Tt(), tVar.Tu(), tVar.TA(), md5)) {
                tVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", md5);
                if (file.exists() && file.delete()) {
                    Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.boS.jE(md5);
                return;
            }
            l.Ti().b(Tv, md5);
            tVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(JSONArray jSONArray, String str) {
        if (this.bpb.f(jSONArray)) {
            l.Ti().G(str, true);
        } else {
            l.Ti().G(str, false);
        }
    }

    private void SR() {
        cU(true);
        cU(false);
    }

    private void cU(boolean z) {
        t tVar = new t();
        tVar.cW(z);
        if (this.boT.a(tVar, z)) {
            JSONArray Tv = tVar.Tv();
            this.boT.cT(z);
            l.Ti().t(Tv);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(JSONArray jSONArray) {
        if (!this.bpb.f(jSONArray)) {
            q.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a SS() {
        return this.boS;
    }

    @SuppressLint({"MissingPermission"})
    private boolean cD(Context context) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [877=4] */
    private void bk(String str, String str2) {
        OutputStream fileOutputStream;
        String str3 = this.mContext.getFilesDir() + File.separator + "ubcsenddir";
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
            r.jU("save to file suc");
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
    public void jG(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "ubcsenddir", str);
        r.jU("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            r.jU("delete file suc");
        }
        this.boS.jE(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jH(String str) {
        r.jU("upload file fail");
        this.boS.jF(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ST() {
        this.boS.SH();
    }
}
