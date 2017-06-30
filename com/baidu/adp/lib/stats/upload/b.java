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
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.BdStatisticsSwitchStatic;
import com.baidu.adp.lib.stats.e;
import com.baidu.adp.lib.stats.f;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.i;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private static b xH = null;
    private CustomMessageListener mNetworkChangedListener = new com.baidu.adp.lib.stats.upload.c(this, 2000994);
    private e xI;
    private String xJ;
    private a xK;

    public static b gH() {
        if (xH == null) {
            synchronized (b.class) {
                if (xH == null) {
                    xH = new b();
                }
            }
        }
        return xH;
    }

    public void a(e eVar, String str) {
        this.xJ = str;
        this.xI = eVar;
        if (this.xI != null) {
            this.xI.wT = Build.MODEL;
            this.xI.wW = Build.VERSION.RELEASE;
            this.xI.mNetType = f.ac(BdBaseApplication.getInst());
            this.xI.wV = String.valueOf(i.hp());
        }
        try {
            MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.xK == null) {
            this.xK = new a(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
            BdBaseApplication.getInst().registerReceiver(this.xK, intentFilter);
        }
    }

    public void setUser(String str, String str2, String str3) {
        if (this.xI.mUid != null || str != null) {
            if (this.xI.mUid == null || !this.xI.mUid.equals(str)) {
                this.xI.mUid = str;
                this.xI.wU = str2;
                this.xI.mBduss = str3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gI() {
        this.xI.mNetType = f.ac(BdBaseApplication.getInst());
        this.xI.wV = String.valueOf(i.hp());
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
                b.this.setUser(intent.getStringExtra("intent_data_userid"), intent.getStringExtra("intent_data_username"), intent.getStringExtra("intent_data_bduss"));
            }
        }
    }

    public void a(com.baidu.adp.lib.stats.base.a aVar, String str) {
        new C0007b(aVar, str).execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.adp.lib.stats.upload.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0007b extends BdAsyncTask<Object, Integer, Void> {
        private com.baidu.adp.lib.stats.base.a xL;
        private String xM;

        public C0007b(com.baidu.adp.lib.stats.base.a aVar, String str) {
            this.xL = aVar;
            this.xM = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String a = d.a(this.xL, b.this.xI);
            String str = this.xM;
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            BdLog.i("commonHeader = " + a);
            BdLog.i("cache = " + str);
            this.xL.gq();
            b.this.a(this.xL, a, arrayList, null, true);
            return null;
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
        if (BdStatisticsManager.getInstance().isMainProcess() && aVar != null) {
            ArrayList<String> ap = com.baidu.adp.lib.stats.switchs.a.gB().ap(aVar.gs());
            if (!z) {
                boolean onlyWifiUpload = com.baidu.adp.lib.stats.switchs.a.gB().onlyWifiUpload(aVar.gs(), null);
                boolean hk = i.hk();
                if (!onlyWifiUpload || hk) {
                    if (ap != null && ap.size() > 0) {
                        ArrayList<String> arrayList3 = new ArrayList<>();
                        Iterator<String> it = ap.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (!com.baidu.adp.lib.stats.switchs.a.gB().isUpload(aVar.gs(), next)) {
                                b(arrayList3, next);
                            } else if (!com.baidu.adp.lib.stats.switchs.a.gB().smallFlowUpload(aVar.gs(), next)) {
                                b(arrayList3, next);
                            } else {
                                boolean onlyWifiUpload2 = com.baidu.adp.lib.stats.switchs.a.gB().onlyWifiUpload(aVar.gs(), next);
                                boolean hk2 = i.hk();
                                if (onlyWifiUpload2 && !hk2) {
                                    b(arrayList3, next);
                                }
                            }
                        }
                        arrayList = arrayList3;
                        if (aVar.gt()) {
                            aVar.H(true);
                            if (arrayList == null || arrayList.size() <= 0) {
                                arrayList2 = null;
                            } else {
                                ArrayList arrayList4 = new ArrayList();
                                Iterator<String> it2 = arrayList.iterator();
                                while (it2.hasNext()) {
                                    try {
                                        arrayList4.add("st=" + URLEncoder.encode(com.baidu.adp.lib.stats.c.aj(it2.next()), "utf-8") + "&");
                                    } catch (UnsupportedEncodingException e) {
                                        e.printStackTrace();
                                    }
                                }
                                arrayList2 = arrayList4;
                            }
                            new c(aVar, arrayList2, z, z2, z3).execute(new Object[0]);
                            return;
                        }
                        return;
                    }
                } else {
                    return;
                }
            }
            arrayList = null;
            if (aVar.gt()) {
            }
        }
    }

    private void b(ArrayList<String> arrayList, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            if (!arrayList.contains(str)) {
                arrayList.add(str);
            }
        }
    }

    /* loaded from: classes.dex */
    private class c extends BdAsyncTask<Object, Integer, Void> {
        private com.baidu.adp.lib.stats.base.a xN;
        private ArrayList<String> xO;
        private boolean xP;
        private boolean xQ;
        private boolean xR;

        public c(com.baidu.adp.lib.stats.base.a aVar, ArrayList<String> arrayList, boolean z, boolean z2, boolean z3) {
            this.xN = null;
            this.xO = null;
            this.xP = false;
            this.xQ = false;
            this.xR = false;
            this.xN = aVar;
            this.xO = arrayList;
            this.xP = z;
            this.xQ = z2;
            this.xR = z3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            b(this.xN, this.xP, this.xQ, this.xR);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Void r3) {
            this.xN.H(false);
        }

        private void b(com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2, boolean z3) {
            int i;
            try {
                String a = d.a(aVar, b.this.xI);
                BdUploadingLogInfo a2 = com.baidu.adp.lib.stats.upload.a.a(aVar, z2);
                int size = a2.size();
                if (a2 != null && size > 0) {
                    if (!z) {
                        for (int i2 = 0; i2 < size; i2++) {
                            ArrayList<String> logStringByIndex = a2.getLogStringByIndex(i2, this.xO);
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
                        ArrayList<String> logStringByIndex2 = a2.getLogStringByIndex(i5, this.xO);
                        if (logStringByIndex2 != null && logStringByIndex2.size() != 0) {
                            if (i.hk()) {
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
        if (a(this.xJ, aVar, str, arrayList, arrayList2, z, false) != null && i.hj()) {
            String a2 = a(this.xJ, aVar, str, arrayList, arrayList2, z, true);
            if (a2 == null) {
                com.baidu.adp.lib.stats.c statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.p("issuc", "true");
                BdStatisticsManager.getInstance().debug("STAT_UPLOAD_USEIP", statsItem);
                return;
            }
            com.baidu.adp.lib.stats.c statsItem2 = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem2.p("issuc", "false");
            statsItem2.p("reason", a2);
            BdStatisticsManager.getInstance().debug("STAT_UPLOAD_USEIP", statsItem2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0085 A[Catch: Exception -> 0x0140, TryCatch #0 {Exception -> 0x0140, blocks: (B:14:0x0036, B:16:0x0042, B:19:0x004b, B:21:0x0052, B:23:0x005a, B:24:0x006d, B:26:0x0085, B:27:0x0095, B:29:0x00a7, B:42:0x00ee, B:43:0x00f7, B:45:0x00fd, B:47:0x0103, B:48:0x010a, B:50:0x0110, B:52:0x0116, B:53:0x011c, B:55:0x0124, B:57:0x012c, B:59:0x0132, B:60:0x0137, B:40:0x00e4, B:33:0x00b9, B:35:0x00cf, B:28:0x009c), top: B:66:0x0036, inners: #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00cf A[Catch: Exception -> 0x00ed, TRY_LEAVE, TryCatch #1 {Exception -> 0x00ed, blocks: (B:33:0x00b9, B:35:0x00cf), top: B:67:0x00b9, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0116 A[Catch: Exception -> 0x0140, TryCatch #0 {Exception -> 0x0140, blocks: (B:14:0x0036, B:16:0x0042, B:19:0x004b, B:21:0x0052, B:23:0x005a, B:24:0x006d, B:26:0x0085, B:27:0x0095, B:29:0x00a7, B:42:0x00ee, B:43:0x00f7, B:45:0x00fd, B:47:0x0103, B:48:0x010a, B:50:0x0110, B:52:0x0116, B:53:0x011c, B:55:0x0124, B:57:0x012c, B:59:0x0132, B:60:0x0137, B:40:0x00e4, B:33:0x00b9, B:35:0x00cf, B:28:0x009c), top: B:66:0x0036, inners: #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011c A[Catch: Exception -> 0x0140, TryCatch #0 {Exception -> 0x0140, blocks: (B:14:0x0036, B:16:0x0042, B:19:0x004b, B:21:0x0052, B:23:0x005a, B:24:0x006d, B:26:0x0085, B:27:0x0095, B:29:0x00a7, B:42:0x00ee, B:43:0x00f7, B:45:0x00fd, B:47:0x0103, B:48:0x010a, B:50:0x0110, B:52:0x0116, B:53:0x011c, B:55:0x0124, B:57:0x012c, B:59:0x0132, B:60:0x0137, B:40:0x00e4, B:33:0x00b9, B:35:0x00cf, B:28:0x009c), top: B:66:0x0036, inners: #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0110 A[EDGE_INSN: B:73:0x0110->B:50:0x0110 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(String str, com.baidu.adp.lib.stats.base.a aVar, String str2, ArrayList<String> arrayList, ArrayList<com.baidu.adp.lib.stats.base.c> arrayList2, boolean z, boolean z2) {
        byte[] b;
        String str3;
        com.baidu.adp.lib.network.http.f fVar;
        HashMap<String, Object> a2;
        byte[] bArr;
        List<com.baidu.adp.lib.network.http.e> fC;
        StringBuilder sb;
        int i;
        int i2;
        if (str != null && aVar != null && (b = b(str2, arrayList)) != null && b.length > 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(b.length / 2);
            try {
                com.baidu.adp.lib.util.f.b(b, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                HashMap hashMap = new HashMap();
                hashMap.put(aVar.gu(), byteArray);
                ArrayList arrayList3 = new ArrayList(hashMap.entrySet());
                try {
                    if (aVar != null) {
                        try {
                            if (aVar.gs().equals("pfmonitor") && BdStatisticsSwitchStatic.fU()) {
                                str3 = "http://nlog.baidu.com/dplog/n";
                                fVar = new com.baidu.adp.lib.network.http.f();
                                if (z2 && str3.contains("c.tieba.baidu.com")) {
                                    str3 = str3.replace("c.tieba.baidu.com", "123.125.115.120");
                                    fVar.fA().o("Host", "c.tieba.baidu.com");
                                }
                                fVar.fA().setUrl(str3);
                                fVar.fA().setMethod(HttpMessageTask.HTTP_METHOD.POST);
                                a2 = d.a(this.xI, z);
                                if (a2 != null) {
                                    fVar.fA().f(new ArrayList(a2.entrySet()));
                                }
                                fVar.fA().f(arrayList3);
                                new com.baidu.adp.lib.network.http.d(fVar).f(3, -1, -1);
                                int i3 = fVar.fB().responseCode;
                                bArr = fVar.fB().vS;
                                if (bArr != null && i3 == 200) {
                                    try {
                                        if (new JSONObject(new String(bArr, "utf-8")).optInt("error_code", -1) == 0) {
                                            b(arrayList2, aVar.gx());
                                            return null;
                                        }
                                    } catch (Exception e) {
                                        BdLog.e(e);
                                        return e.getMessage();
                                    }
                                }
                                fC = fVar.fC();
                                if (fC != null && fC.size() > 0) {
                                    sb = new StringBuilder();
                                    i = 0;
                                    while (true) {
                                        i2 = i;
                                        if (i2 < fC.size()) {
                                            break;
                                        }
                                        com.baidu.adp.lib.network.http.e eVar = fC.get(i2);
                                        if (eVar != null && !TextUtils.isEmpty(eVar.vz)) {
                                            if (sb.length() > 0) {
                                                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                            }
                                            sb.append(eVar.vz);
                                        }
                                        i = i2 + 1;
                                    }
                                    if (sb.length() > 0) {
                                        return sb.toString();
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            BdLog.e(e2);
                            return e2.getMessage();
                        }
                    }
                    new com.baidu.adp.lib.network.http.d(fVar).f(3, -1, -1);
                    int i32 = fVar.fB().responseCode;
                    bArr = fVar.fB().vS;
                    if (bArr != null) {
                        if (new JSONObject(new String(bArr, "utf-8")).optInt("error_code", -1) == 0) {
                        }
                    }
                    fC = fVar.fC();
                    if (fC != null) {
                        sb = new StringBuilder();
                        i = 0;
                        while (true) {
                            i2 = i;
                            if (i2 < fC.size()) {
                            }
                            i = i2 + 1;
                        }
                        if (sb.length() > 0) {
                        }
                    }
                } catch (Exception e3) {
                    BdLog.detailException(e3);
                    return e3.getMessage();
                }
                str3 = str;
                fVar = new com.baidu.adp.lib.network.http.f();
                if (z2) {
                    str3 = str3.replace("c.tieba.baidu.com", "123.125.115.120");
                    fVar.fA().o("Host", "c.tieba.baidu.com");
                }
                fVar.fA().setUrl(str3);
                fVar.fA().setMethod(HttpMessageTask.HTTP_METHOD.POST);
                a2 = d.a(this.xI, z);
                if (a2 != null) {
                }
                fVar.fA().f(arrayList3);
            } catch (Exception e4) {
                BdLog.e(e4);
                return e4.getMessage();
            }
        }
        return "";
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
