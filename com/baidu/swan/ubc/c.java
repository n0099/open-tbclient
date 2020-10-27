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
/* loaded from: classes9.dex */
public class c {
    private a efB;
    private b efC;
    private long efE;
    private long efF;
    private long efG;
    private int efH;
    private SparseArray<ArrayList> efI;
    private HashMap<String, Long> efJ;
    private d efL;
    private Context mContext;
    private m efK = e.baS().afQ();
    private List<i> efD = new ArrayList(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.mContext = context;
        this.efB = new a(context);
        this.efC = new b(context);
        u bbA = u.bbA();
        this.efE = bbA.getLong("ubc_last_upload_all_time", 0L);
        this.efF = bbA.getLong("ubc_last_upload_non_real", 0L);
        this.efG = bbA.getLong("ubc_reset_real_time_count_time", 0L);
        this.efH = bbA.getInt("ubc_real_time_count", 0);
        this.efL = d.baO();
        this.efL.a(this, context);
    }

    private void baD() {
        if (this.efI == null) {
            this.efI = new SparseArray<>();
            this.efB.b(this.efI);
            this.efJ = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.efI.size(); i2++) {
                int keyAt = this.efI.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                this.efJ.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.efL.mW(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(i iVar) {
        boolean z = false;
        if (TextUtils.equals(iVar.getId(), iVar.bbd()) && this.efL.yz(iVar.getId()) && (iVar.getOption() & 64) == 0) {
            z = true;
        }
        if (z && !c(iVar)) {
            this.efB.a(iVar);
        } else if (Math.abs(System.currentTimeMillis() - this.efF) >= d.baO().baP()) {
            if (!z) {
                this.efD.add(iVar);
            }
            baI();
        } else if ((iVar.getOption() & 1) == 0) {
            if (!z) {
                this.efD.add(iVar);
            }
            if (this.efD.size() >= 20) {
                baE();
            }
        } else if (!z) {
            this.efB.a(iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(i iVar) {
        this.efC.a(iVar, this.efL.yz(iVar.getId()));
    }

    private void baE() {
        if (this.efD != null && this.efD.size() != 0) {
            this.efB.aQ(this.efD);
            this.efD.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(k kVar) {
        this.efB.a(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(String str, int i, String str2) {
        this.efB.h(str, i, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        baE();
        this.efB.a(str, i, j, jSONArray);
        if (this.efL.yz(str)) {
            baF();
        }
        if (Math.abs(System.currentTimeMillis() - this.efF) >= d.baO().baP()) {
            baI();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(String str, int i) {
        baE();
        this.efB.I(str, i);
        if (Math.abs(System.currentTimeMillis() - this.efF) >= d.baO().baP()) {
            baI();
        }
    }

    private boolean c(i iVar) {
        if (dN(this.mContext) && baG()) {
            baE();
            v vVar = new v();
            vVar.hR(true);
            JSONObject bbg = iVar.bbg();
            if (bbg != null && bbg.has("bizId")) {
                s.db(bbg);
                vVar.dd(bbg);
                vVar.q(iVar.getTime(), iVar.getTime());
                try {
                    JSONObject jSONObject = bbg.getJSONObject("content");
                    JSONObject jSONObject2 = bbg.getJSONObject("appInfo");
                    if (jSONObject != null && jSONObject2 != null) {
                        jSONObject.put("appInfo", jSONObject2);
                        bbg.remove("appInfo");
                    }
                } catch (JSONException e) {
                }
            } else {
                try {
                    JSONObject jSONObject3 = new s(iVar.bbh()).toJSONObject();
                    jSONObject3.put("bizId", iVar.getId());
                    jSONObject3.put("timestamp", Long.toString(iVar.getTime()));
                    if (iVar.bbg() != null) {
                        jSONObject3.put("content", iVar.bbg());
                    } else {
                        jSONObject3.put("content", iVar.getContent());
                    }
                    jSONObject3.put("eventType", "0");
                    if (!TextUtils.isEmpty(iVar.bbf())) {
                        jSONObject3.put("abtest", iVar.bbf());
                        vVar.yQ("1");
                    }
                    if (!TextUtils.isEmpty(iVar.getCategory())) {
                        jSONObject3.put("c", iVar.getCategory());
                    }
                    if (iVar.bbb()) {
                        jSONObject3.put(MapBundleKey.MapObjKey.OBJ_OFFSET, "1");
                    }
                    jSONObject3.put("idtype", this.efL.yF(iVar.getId()));
                    vVar.dd(jSONObject3);
                    vVar.q(iVar.getTime(), iVar.getTime());
                } catch (JSONException e2) {
                }
            }
            if (this.efI == null) {
                baD();
            }
            if (this.efI.size() > 0) {
                this.efB.a(this.efI.valueAt(0), vVar);
            }
            c(vVar);
            baH();
            return true;
        }
        return false;
    }

    private void baF() {
        if (dN(this.mContext) && baG()) {
            v vVar = new v();
            vVar.hR(true);
            if (this.efI == null) {
                baD();
            }
            if (this.efI.size() > 0) {
                if (e.baS().aAA()) {
                    this.efB.a(vVar);
                } else {
                    this.efB.a(this.efI.valueAt(0), vVar);
                }
            }
            c(vVar);
            baH();
        }
    }

    private boolean baG() {
        if (e.baS().aAA()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.efG) > 86400000) {
            this.efH = 0;
            this.efG = currentTimeMillis;
            u.bbA().putLong("ubc_reset_real_time_count_time", this.efG);
            u.bbA().putInt("ubc_real_time_count", this.efH);
        }
        if (this.efH >= 1000) {
            if (this.efH == 1000) {
                this.efH++;
                e.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    private void baH() {
        this.efH++;
        u.bbA().putInt("ubc_real_time_count", this.efH);
    }

    private void baI() {
        if (dN(this.mContext)) {
            this.efF = System.currentTimeMillis();
            u.bbA().putLong("ubc_last_upload_non_real", this.efF);
            baK();
            baE();
            this.efB.bax();
            HashSet hashSet = new HashSet();
            if (this.efI == null) {
                baD();
            }
            v vVar = new v();
            vVar.hR(false);
            int i = 0;
            for (int i2 = 0; i2 < this.efI.size(); i2++) {
                int keyAt = this.efI.keyAt(i2);
                if (keyAt != 0) {
                    long longValue = this.efJ.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.efL.baP()) {
                        i |= this.efB.a(this.efI.valueAt(i2), vVar);
                        this.efJ.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i != 0) {
                for (int i3 = 0; i3 < this.efI.size(); i3++) {
                    int keyAt2 = this.efI.keyAt(i3);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (vVar.nf(com.baidu.fsg.base.statistics.b.c)) {
                            break;
                        }
                        this.efB.a(this.efI.valueAt(i3), vVar);
                    }
                }
                c(vVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void baJ() {
        if (dN(this.mContext) && Math.abs(System.currentTimeMillis() - this.efE) >= BdKVCache.MILLS_1Hour) {
            this.efB.bax();
            v vVar = new v();
            if (this.efB.a(vVar) != 0) {
                v vVar2 = new v();
                vVar2.q(vVar.bbG(), vVar.getMaxTime());
                vVar2.yQ(vVar.bbF());
                vVar2.hR(true);
                v vVar3 = new v();
                vVar3.q(vVar.bbG(), vVar.getMaxTime());
                vVar3.yQ(vVar.bbF());
                vVar3.hR(false);
                SparseArray<Integer> bbC = vVar.bbC();
                int size = bbC.size();
                for (int i = 0; i < size; i++) {
                    if (this.efL.yz(String.valueOf(bbC.valueAt(i).intValue()))) {
                        vVar2.aF(bbC.keyAt(i), bbC.valueAt(i).intValue());
                    } else {
                        vVar3.aF(bbC.keyAt(i), bbC.valueAt(i).intValue());
                    }
                }
                ArrayList bbD = vVar.bbD();
                int size2 = bbD.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = (String) bbD.get(i2);
                    if (this.efL.yz(str)) {
                        vVar2.yP(str);
                    } else {
                        vVar3.yP(str);
                    }
                }
                JSONArray bbH = vVar.bbH();
                int length = bbH.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = bbH.optJSONObject(i3);
                    if (optJSONObject.has("bizId")) {
                        String str2 = null;
                        try {
                            str2 = optJSONObject.getString("bizId");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.efL.yz(str2)) {
                                vVar2.dd(optJSONObject);
                            } else {
                                vVar3.dd(optJSONObject);
                            }
                        }
                    }
                }
                if (vVar2.bbH().length() > 0) {
                    c(vVar2);
                }
                if (vVar3.bbH().length() > 0) {
                    c(vVar3);
                }
                this.efE = System.currentTimeMillis();
                u.bbA().putLong("ubc_last_upload_all_time", this.efE);
                this.efF = this.efE;
                u.bbA().putLong("ubc_last_upload_non_real", this.efF);
            }
        }
    }

    private void c(v vVar) {
        if (!vVar.isEmpty()) {
            JSONArray bbE = vVar.bbE();
            String md5 = com.baidu.swan.c.e.toMd5(bbE.toString().getBytes(), true);
            dw(bbE.toString(), md5);
            this.efB.at(md5, vVar.bbI());
            if (!this.efB.a(vVar.bbC(), vVar.bbD(), vVar.bbI(), md5)) {
                vVar.clearData();
                File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", md5);
                if (file.exists() && file.delete()) {
                    Log.d("CeresBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.efB.yu(md5);
                return;
            }
            n.bbo().d(bbE, md5);
            vVar.clearData();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(JSONArray jSONArray, String str) {
        if (this.efK.H(jSONArray)) {
            n.bbo().au(str, true);
        } else {
            n.bbo().au(str, false);
        }
    }

    private void baK() {
        hO(true);
        hO(false);
    }

    private void hO(boolean z) {
        v vVar = new v();
        vVar.hR(z);
        if (this.efC.a(vVar, z)) {
            JSONArray bbE = vVar.bbE();
            this.efC.hN(z);
            n.bbo().K(bbE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(JSONArray jSONArray) {
        if (!this.efK.H(jSONArray)) {
            e.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a baL() {
        return this.efB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(q qVar) {
        this.efL.aS(qVar.bbu());
        this.efL.mX(qVar.bbt() * 86400000);
        this.efL.mY(qVar.bbs());
        u.bbA().putString("ubc_version_md5", qVar.getSign());
        this.efB.aR(qVar.bbu());
        qVar.bbu().clear();
        if (this.efI == null) {
            this.efI = new SparseArray<>();
        }
        this.efI.clear();
        if (this.efJ == null) {
            this.efJ = new HashMap<>();
        }
        this.efJ.clear();
        this.efB.b(this.efI);
        int i = 0;
        for (int i2 = 0; i2 < this.efI.size(); i2++) {
            int keyAt = this.efI.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            this.efJ.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.efL.mW(i);
    }

    @SuppressLint({"MissingPermission"})
    private boolean dN(Context context) {
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

    private void dw(String str, String str2) {
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
                t.yO("save to file suc");
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
    public void yw(String str) {
        File file = new File(this.mContext.getFilesDir() + File.separator + "statistics_data", str);
        t.yO("delete file");
        if (file.exists() && file.delete()) {
            Log.d("CeresBehaviorModel", "deleteUploadFile file suc");
            t.yO("delete file suc");
        }
        this.efB.yu(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void yx(String str) {
        t.yO("upload file fail");
        this.efB.yv(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void baM() {
        File[] listFiles;
        if (dN(this.mContext)) {
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
                    this.efB.bay();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    j yt = this.efB.yt(listFiles[i].getName());
                    if (yt != null && TextUtils.equals("0", yt.bbj())) {
                        t.yO("processFailedData file, no need to send");
                    } else if (yt != null && TextUtils.equals("1", yt.bbj())) {
                        t.yO("processFailedData file, send");
                        this.efB.dv(listFiles[i].getName(), "0");
                        yy(listFiles[i].getName());
                    } else {
                        t.yO("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    void yy(String str) {
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
                                n.bbo().d(new JSONArray(com.baidu.swan.c.g.getStringFromInput(inputStream2)), str);
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
    public void baN() {
        this.efB.baz();
    }
}
