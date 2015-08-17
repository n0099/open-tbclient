package com.baidu.adp.lib.stats.upload;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.network.http.e;
import com.baidu.adp.lib.stats.BdStatisticsSwitchStatic;
import com.baidu.adp.lib.stats.f;
import com.baidu.adp.lib.stats.g;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.i;
import com.baidu.cloudsdk.social.core.SocialConstants;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private static b xi = null;
    private f xj;
    private String xk;
    private a xl;
    private CustomMessageListener xm = new c(this, 2000994);

    public static b im() {
        if (xi == null) {
            synchronized (b.class) {
                if (xi == null) {
                    xi = new b();
                }
            }
        }
        return xi;
    }

    public void a(f fVar, String str) {
        this.xk = str;
        this.xj = fVar;
        if (this.xj != null) {
            this.xj.wq = Build.MODEL;
            this.xj.wv = Build.VERSION.RELEASE;
            this.xj.mNetType = g.getNetType(BdBaseApplication.getInst());
            this.xj.wu = g.F(BdBaseApplication.getInst());
        }
        try {
            MessageManager.getInstance().registerListener(this.xm);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.xl == null) {
            this.xl = new a(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
            BdBaseApplication.getInst().registerReceiver(this.xl, intentFilter);
        }
    }

    public void f(String str, String str2, String str3) {
        if (this.xj.wr != null || str != null) {
            if (this.xj.wr == null || !this.xj.wr.equals(str)) {
                this.xj.wr = str;
                this.xj.ws = str2;
                this.xj.wt = str3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void in() {
        this.xj.mNetType = g.getNetType(BdBaseApplication.getInst());
        this.xj.wu = g.F(BdBaseApplication.getInst());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                b.this.f(intent.getStringExtra("intent_data_userid"), intent.getStringExtra("intent_data_username"), intent.getStringExtra("intent_data_bduss"));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2, boolean z3) {
        ArrayList<String> arrayList;
        ArrayList arrayList2;
        if (com.baidu.adp.lib.stats.a.hk().hr() && aVar != null) {
            ArrayList<String> aw = com.baidu.adp.lib.stats.switchs.a.ig().aw(aVar.hW());
            if (!z) {
                boolean onlyWifiUpload = com.baidu.adp.lib.stats.switchs.a.ig().onlyWifiUpload(aVar.hW(), null);
                boolean iP = i.iP();
                if (!onlyWifiUpload || iP) {
                    if (aw != null && aw.size() > 0) {
                        ArrayList<String> arrayList3 = new ArrayList<>();
                        Iterator<String> it = aw.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (!com.baidu.adp.lib.stats.switchs.a.ig().isUpload(aVar.hW(), next)) {
                                a(arrayList3, next);
                            } else if (!com.baidu.adp.lib.stats.switchs.a.ig().smallFlowUpload(aVar.hW(), next)) {
                                a(arrayList3, next);
                            } else {
                                boolean onlyWifiUpload2 = com.baidu.adp.lib.stats.switchs.a.ig().onlyWifiUpload(aVar.hW(), next);
                                boolean iP2 = i.iP();
                                if (onlyWifiUpload2 && !iP2) {
                                    a(arrayList3, next);
                                }
                            }
                        }
                        arrayList = arrayList3;
                        if (aVar.hX()) {
                            aVar.D(true);
                            if (arrayList == null || arrayList.size() <= 0) {
                                arrayList2 = null;
                            } else {
                                ArrayList arrayList4 = new ArrayList();
                                Iterator<String> it2 = arrayList.iterator();
                                while (it2.hasNext()) {
                                    try {
                                        arrayList4.add("st=" + URLEncoder.encode(com.baidu.adp.lib.stats.d.aq(it2.next()), "utf-8") + "&");
                                    } catch (UnsupportedEncodingException e) {
                                        e.printStackTrace();
                                    }
                                }
                                arrayList2 = arrayList4;
                            }
                            new C0007b(aVar, arrayList2, z, z2, z3).execute(new Object[0]);
                            return;
                        }
                        return;
                    }
                } else {
                    return;
                }
            }
            arrayList = null;
            if (aVar.hX()) {
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

    /* renamed from: com.baidu.adp.lib.stats.upload.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0007b extends BdAsyncTask<Object, Integer, Void> {
        private com.baidu.adp.lib.stats.base.a xn;
        private ArrayList<String> xo;
        private boolean xp;
        private boolean xq;
        private boolean xr;

        public C0007b(com.baidu.adp.lib.stats.base.a aVar, ArrayList<String> arrayList, boolean z, boolean z2, boolean z3) {
            this.xn = null;
            this.xo = null;
            this.xp = false;
            this.xq = false;
            this.xr = false;
            this.xn = aVar;
            this.xo = arrayList;
            this.xp = z;
            this.xq = z2;
            this.xr = z3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            b(this.xn, this.xp, this.xq, this.xr);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r3) {
            this.xn.D(false);
        }

        private void b(com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2, boolean z3) {
            int i;
            try {
                String a = d.a(aVar, b.this.xj);
                BdUploadingLogInfo a2 = com.baidu.adp.lib.stats.upload.a.a(aVar, z2);
                int size = a2.size();
                if (a2 != null && size > 0) {
                    if (!z) {
                        for (int i2 = 0; i2 < size; i2++) {
                            ArrayList<String> logStringByIndex = a2.getLogStringByIndex(i2, this.xo);
                            if (logStringByIndex != null && logStringByIndex.size() != 0) {
                                if (z2) {
                                    ArrayList<com.baidu.adp.lib.stats.base.c> arrayList = a2.get(i2);
                                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                        if (arrayList.get(i3).mFileName.contains("notUpload/")) {
                                            arrayList.get(i3).mFileName = arrayList.get(i3).mFileName.replace("notUpload/", "");
                                        }
                                    }
                                    b.this.a(aVar, a, logStringByIndex, arrayList, z3);
                                } else {
                                    b.this.a(aVar, a, logStringByIndex, a2.get(i2), z3);
                                }
                            }
                        }
                        return;
                    }
                    int i4 = 0;
                    for (int i5 = size - 1; i5 >= 0; i5--) {
                        ArrayList<String> logStringByIndex2 = a2.getLogStringByIndex(i5, this.xo);
                        if (logStringByIndex2 != null && logStringByIndex2.size() != 0) {
                            if (i.iP()) {
                                i = i4;
                            } else {
                                i = i4 + logStringByIndex2.toString().length();
                                if (i > 102400) {
                                    return;
                                }
                            }
                            if (z2) {
                                ArrayList<com.baidu.adp.lib.stats.base.c> arrayList2 = a2.get(i5);
                                for (int i6 = 0; i6 < arrayList2.size(); i6++) {
                                    if (arrayList2.get(i6).mFileName.contains("notUpload/")) {
                                        arrayList2.get(i6).mFileName = arrayList2.get(i6).mFileName.replace("notUpload/", "");
                                    }
                                }
                                b.this.a(aVar, a, logStringByIndex2, arrayList2, z3);
                                i4 = i;
                            } else {
                                b.this.a(aVar, a, logStringByIndex2, a2.get(i5), z3);
                                i4 = i;
                            }
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    private byte[] b(String str, ArrayList<String> arrayList) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.adp.lib.stats.base.a aVar, String str, ArrayList<String> arrayList, ArrayList<com.baidu.adp.lib.stats.base.c> arrayList2, boolean z) {
        byte[] b;
        if (aVar != null && (b = b(str, arrayList)) != null && b.length > 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(b.length / 2);
            try {
                com.baidu.adp.lib.util.f.a(b, byteArrayOutputStream);
            } catch (Exception e) {
                BdLog.e(e);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            HashMap hashMap = new HashMap();
            hashMap.put(aVar.hY(), byteArray);
            ArrayList arrayList3 = new ArrayList(hashMap.entrySet());
            try {
                String str2 = this.xk;
                if (aVar != null && aVar.hW().equals("pfmonitor") && BdStatisticsSwitchStatic.hz()) {
                    str2 = "http://nlog.baidu.com/dplog/n";
                }
                e eVar = new e();
                eVar.gS().setUrl(str2);
                eVar.gS().setMethod(HttpMessageTask.HTTP_METHOD.POST);
                HashMap<String, Object> a2 = d.a(this.xj, z);
                if (a2 != null) {
                    eVar.gS().d(new ArrayList(a2.entrySet()));
                }
                eVar.gS().d(arrayList3);
                try {
                    new com.baidu.adp.lib.network.http.c(eVar).h(3, -1, -1);
                } catch (Exception e2) {
                    BdLog.detailException(e2);
                }
                int i = eVar.gT().responseCode;
                byte[] bArr = eVar.gT().vg;
                if (bArr != null && i == 200) {
                    try {
                        if (new JSONObject(new String(bArr, "utf-8")).optInt(SocialConstants.PARAM_ERROR_CODE, -1) == 0) {
                            b(arrayList2, aVar.ib());
                        }
                    } catch (Exception e3) {
                        BdLog.e(e3);
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
