package com.baidu.adp.lib.stats.upload;

import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.stats.BdStatisticsSwitchStatic;
import com.baidu.adp.lib.stats.q;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.g;
import com.baidu.adp.lib.util.k;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private static b xm = null;
    private String wn;
    private com.baidu.adp.lib.h.e xn;
    private d xo;
    private c xp;

    public static b iv() {
        if (xm == null) {
            synchronized (b.class) {
                if (xm == null) {
                    xm = new b();
                }
            }
        }
        return xm;
    }

    public void a(com.baidu.adp.lib.h.e eVar, String str) {
        this.wn = str;
        this.xn = eVar;
        if (this.xn != null) {
            this.xn.xF = Build.MODEL;
            this.xn.wm = Build.VERSION.RELEASE;
            this.xn.mNetType = com.baidu.adp.lib.h.f.getNetType(BdBaseApplication.getInst());
            this.xn.ws = com.baidu.adp.lib.h.f.H(BdBaseApplication.getInst());
        }
        if (this.xo == null) {
            try {
                this.xo = new d(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                BdBaseApplication.getInst().registerReceiver(this.xo, intentFilter);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        if (this.xp == null) {
            this.xp = new c(this, null);
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("adp.bdstatisticsmanager.account_changed");
            BdBaseApplication.getInst().registerReceiver(this.xp, intentFilter2);
        }
    }

    public void f(String str, String str2, String str3) {
        if (this.xn.mUid != null || str != null) {
            if (this.xn.mUid == null || !this.xn.mUid.equals(str)) {
                this.xn.mUid = str;
                this.xn.wj = str2;
                this.xn.wk = str3;
            }
        }
    }

    public void hB() {
        this.xn.mNetType = com.baidu.adp.lib.h.f.getNetType(BdBaseApplication.getInst());
        this.xn.ws = com.baidu.adp.lib.h.f.H(BdBaseApplication.getInst());
    }

    public void a(com.baidu.adp.lib.stats.base.a aVar, boolean z) {
        ArrayList<String> arrayList;
        ArrayList arrayList2 = null;
        if (com.baidu.adp.lib.h.a.iB().iE() && aVar != null) {
            ArrayList<String> im = aVar.im();
            if (im.size() > 0) {
                ArrayList<String> arrayList3 = new ArrayList<>();
                if (!z) {
                    Iterator<String> it = im.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!com.baidu.adp.lib.stats.switchs.a.ip().isUpload(aVar.ig(), next)) {
                            a(arrayList3, next);
                        } else if (!com.baidu.adp.lib.stats.switchs.a.ip().smallFlowUpload(aVar.ig(), next)) {
                            a(arrayList3, next);
                        } else {
                            boolean onlyWifiUpload = com.baidu.adp.lib.stats.switchs.a.ip().onlyWifiUpload(aVar.ig(), next);
                            boolean iY = k.iY();
                            if (onlyWifiUpload && !iY) {
                                a(arrayList3, next);
                            }
                        }
                    }
                }
                arrayList = arrayList3;
            } else {
                arrayList = null;
            }
            if (!aVar.ih()) {
                aVar.D(true);
                if (arrayList != null && arrayList.size() > 0) {
                    arrayList2 = new ArrayList();
                    Iterator<String> it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        try {
                            arrayList2.add("st=" + URLEncoder.encode(q.ay(it2.next()), "utf-8") + "&");
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }
                }
                new e(this, aVar, arrayList2, z).execute(new Object[0]);
            }
        }
    }

    private void a(ArrayList<String> arrayList, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            if (!arrayList.contains(str)) {
                arrayList.add(str);
            }
        }
    }

    private byte[] a(String str, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                sb.append("&rec");
                sb.append(i);
                sb.append('=');
                try {
                    sb.append(URLEncoder.encode(arrayList.get(i), "utf-8"));
                } catch (UnsupportedEncodingException e) {
                    BdLog.e(e);
                }
            }
            return sb.toString().getBytes();
        } catch (Exception e2) {
            BdLog.e(e2);
            return null;
        }
    }

    public void a(com.baidu.adp.lib.stats.base.a aVar, String str, ArrayList<String> arrayList, ArrayList<com.baidu.adp.lib.stats.base.c> arrayList2) {
        byte[] a;
        if (aVar != null && (a = a(str, arrayList)) != null && a.length > 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(a.length / 2);
            try {
                g.a(a, byteArrayOutputStream);
            } catch (Exception e) {
                BdLog.e(e);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            HashMap hashMap = new HashMap();
            hashMap.put(aVar.getPostFileName(), byteArray);
            ArrayList arrayList3 = new ArrayList(hashMap.entrySet());
            try {
                String str2 = this.wn;
                if (aVar != null && aVar.ig().equals("pfmonitor") && BdStatisticsSwitchStatic.hJ()) {
                    str2 = "http://nlog.baidu.com/dplog/n";
                }
                com.baidu.adp.lib.network.http.e eVar = new com.baidu.adp.lib.network.http.e();
                eVar.gY().setUrl(str2);
                eVar.gY().setMethod(HttpMessageTask.HTTP_METHOD.POST);
                HashMap<String, Object> a2 = f.a(this.xn);
                if (a2 != null) {
                    eVar.gY().d(new ArrayList(a2.entrySet()));
                }
                eVar.gY().d(arrayList3);
                try {
                    new com.baidu.adp.lib.network.http.c(eVar).k(3, -1, -1);
                } catch (Exception e2) {
                    BdLog.detailException(e2);
                }
                int i = eVar.gZ().responseCode;
                byte[] bArr = eVar.gZ().vk;
                if (bArr != null && i == 200) {
                    try {
                        if (new JSONObject(new String(bArr, "utf-8")).optInt("error_code", -1) == 0) {
                            b(arrayList2, aVar.ij());
                        }
                    } catch (Exception e3) {
                    }
                }
            } catch (Exception e4) {
                BdLog.e(e4);
            }
        }
    }

    private void b(ArrayList<com.baidu.adp.lib.stats.base.c> arrayList, boolean z) {
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<com.baidu.adp.lib.stats.base.c> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next().mFileName);
            }
            if (arrayList2.size() > 0) {
                com.baidu.adp.lib.stats.base.b.a(arrayList2, z);
            }
        }
    }
}
