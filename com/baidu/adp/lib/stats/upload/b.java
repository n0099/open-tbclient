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
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.network.http.e;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.BdStatisticsSwitchStatic;
import com.baidu.adp.lib.stats.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.g;
import com.baidu.adp.lib.util.j;
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
    private static b xh = null;
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.adp.lib.stats.upload.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                b.this.gG();
            }
        }
    };
    private String mUploadUrl;
    private com.baidu.adp.lib.stats.c xi;
    private a xj;

    public static b gF() {
        if (xh == null) {
            synchronized (b.class) {
                if (xh == null) {
                    xh = new b();
                }
            }
        }
        return xh;
    }

    public void a(com.baidu.adp.lib.stats.c cVar, String str) {
        this.mUploadUrl = str;
        this.xi = cVar;
        if (this.xi != null) {
            this.xi.wr = Build.MODEL;
            this.xi.wv = Build.VERSION.RELEASE;
            this.xi.mNetType = d.ab(BdBaseApplication.getInst());
            this.xi.wu = String.valueOf(j.hn());
        }
        try {
            MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.xj == null) {
            this.xj = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
            BdBaseApplication.getInst().registerReceiver(this.xj, intentFilter);
        }
    }

    public void setUser(String str, String str2, String str3) {
        if (this.xi.mUid != null || str != null) {
            if (this.xi.mUid == null || !this.xi.mUid.equals(str)) {
                this.xi.mUid = str;
                this.xi.ws = str2;
                this.xi.wt = str3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gG() {
        this.xi.mNetType = d.ab(BdBaseApplication.getInst());
        this.xi.wu = String.valueOf(j.hn());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        private a() {
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
        private com.baidu.adp.lib.stats.base.a xk;
        private String xl;

        public C0007b(com.baidu.adp.lib.stats.base.a aVar, String str) {
            this.xk = aVar;
            this.xl = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String a = com.baidu.adp.lib.stats.upload.c.a(this.xk, b.this.xi);
            String str = this.xl;
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            BdLog.i("commonHeader = " + a);
            BdLog.i("cache = " + str);
            this.xk.go();
            b.this.a(this.xk, a, arrayList, null, true);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2, boolean z3) {
        ArrayList<String> arrayList;
        ArrayList arrayList2;
        if (BdStatisticsManager.getInstance().isMainProcess() && aVar != null) {
            ArrayList<String> as = com.baidu.adp.lib.stats.switchs.a.gz().as(aVar.gq());
            if (!z) {
                boolean onlyWifiUpload = com.baidu.adp.lib.stats.switchs.a.gz().onlyWifiUpload(aVar.gq(), null);
                boolean hi = j.hi();
                if (!onlyWifiUpload || hi) {
                    if (as != null && as.size() > 0) {
                        ArrayList<String> arrayList3 = new ArrayList<>();
                        Iterator<String> it = as.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (!com.baidu.adp.lib.stats.switchs.a.gz().isUpload(aVar.gq(), next)) {
                                b(arrayList3, next);
                            } else if (!com.baidu.adp.lib.stats.switchs.a.gz().smallFlowUpload(aVar.gq(), next)) {
                                b(arrayList3, next);
                            } else {
                                boolean onlyWifiUpload2 = com.baidu.adp.lib.stats.switchs.a.gz().onlyWifiUpload(aVar.gq(), next);
                                boolean hi2 = j.hi();
                                if (onlyWifiUpload2 && !hi2) {
                                    b(arrayList3, next);
                                }
                            }
                        }
                        arrayList = arrayList3;
                        if (aVar.gr()) {
                            aVar.I(true);
                            if (arrayList == null || arrayList.size() <= 0) {
                                arrayList2 = null;
                            } else {
                                ArrayList arrayList4 = new ArrayList();
                                Iterator<String> it2 = arrayList.iterator();
                                while (it2.hasNext()) {
                                    try {
                                        arrayList4.add("st=" + URLEncoder.encode(com.baidu.adp.lib.stats.a.am(it2.next()), "utf-8") + "&");
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
            if (aVar.gr()) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<Object, Integer, Void> {
        private com.baidu.adp.lib.stats.base.a xm;
        private ArrayList<String> xn;
        private boolean xo;
        private boolean xp;
        private boolean xq;

        public c(com.baidu.adp.lib.stats.base.a aVar, ArrayList<String> arrayList, boolean z, boolean z2, boolean z3) {
            this.xm = null;
            this.xn = null;
            this.xo = false;
            this.xp = false;
            this.xq = false;
            this.xm = aVar;
            this.xn = arrayList;
            this.xo = z;
            this.xp = z2;
            this.xq = z3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            b(this.xm, this.xo, this.xp, this.xq);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(Void r3) {
            this.xm.I(false);
        }

        private void b(com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2, boolean z3) {
            int i;
            try {
                String a = com.baidu.adp.lib.stats.upload.c.a(aVar, b.this.xi);
                BdUploadingLogInfo a2 = com.baidu.adp.lib.stats.upload.a.a(aVar, z2);
                int size = a2.size();
                if (a2 != null && size > 0) {
                    if (!z) {
                        for (int i2 = 0; i2 < size; i2++) {
                            ArrayList<String> logStringByIndex = a2.getLogStringByIndex(i2, this.xn);
                            if (logStringByIndex != null && logStringByIndex.size() != 0) {
                                if (!z2) {
                                    b.this.a(aVar, a, logStringByIndex, a2.get(i2), z3);
                                } else {
                                    ArrayList<com.baidu.adp.lib.stats.base.c> arrayList = a2.get(i2);
                                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                        if (arrayList.get(i3).mFileName.contains("notUpload/")) {
                                            arrayList.get(i3).mFileName = arrayList.get(i3).mFileName.replace("notUpload/", "");
                                        }
                                    }
                                    b.this.a(aVar, a, logStringByIndex, arrayList, z3);
                                }
                            }
                        }
                        return;
                    }
                    int i4 = 0;
                    for (int i5 = size - 1; i5 >= 0; i5--) {
                        ArrayList<String> logStringByIndex2 = a2.getLogStringByIndex(i5, this.xn);
                        if (logStringByIndex2 != null && logStringByIndex2.size() != 0) {
                            if (j.hi()) {
                                i = i4;
                            } else {
                                i = i4 + logStringByIndex2.toString().length();
                                if (i > 102400) {
                                    return;
                                }
                            }
                            if (!z2) {
                                b.this.a(aVar, a, logStringByIndex2, a2.get(i5), z3);
                                i4 = i;
                            } else {
                                ArrayList<com.baidu.adp.lib.stats.base.c> arrayList2 = a2.get(i5);
                                for (int i6 = 0; i6 < arrayList2.size(); i6++) {
                                    if (arrayList2.get(i6).mFileName.contains("notUpload/")) {
                                        arrayList2.get(i6).mFileName = arrayList2.get(i6).mFileName.replace("notUpload/", "");
                                    }
                                }
                                b.this.a(aVar, a, logStringByIndex2, arrayList2, z3);
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
        if (a(this.mUploadUrl, aVar, str, arrayList, arrayList2, z, false) != null && j.hh()) {
            String a2 = a(this.mUploadUrl, aVar, str, arrayList, arrayList2, z, true);
            if (a2 == null) {
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.p("issuc", "true");
                BdStatisticsManager.getInstance().debug("STAT_UPLOAD_USEIP", statsItem);
                return;
            }
            com.baidu.adp.lib.stats.a statsItem2 = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem2.p("issuc", "false");
            statsItem2.p("reason", a2);
            BdStatisticsManager.getInstance().debug("STAT_UPLOAD_USEIP", statsItem2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x008d A[Catch: Exception -> 0x014a, TryCatch #1 {Exception -> 0x014a, blocks: (B:14:0x0037, B:16:0x0044, B:19:0x004e, B:21:0x0055, B:23:0x005e, B:24:0x0075, B:26:0x008d, B:27:0x009d, B:29:0x00af, B:42:0x00f7, B:43:0x0100, B:45:0x0106, B:47:0x010c, B:48:0x0113, B:50:0x0119, B:52:0x0121, B:54:0x0129, B:56:0x012f, B:57:0x0135, B:58:0x013a, B:59:0x013e, B:61:0x0144, B:40:0x00ed, B:28:0x00a4, B:33:0x00c1, B:35:0x00d8), top: B:69:0x0037, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d8 A[Catch: Exception -> 0x00f6, TRY_LEAVE, TryCatch #2 {Exception -> 0x00f6, blocks: (B:33:0x00c1, B:35:0x00d8), top: B:70:0x00c1, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0119 A[Catch: Exception -> 0x014a, TryCatch #1 {Exception -> 0x014a, blocks: (B:14:0x0037, B:16:0x0044, B:19:0x004e, B:21:0x0055, B:23:0x005e, B:24:0x0075, B:26:0x008d, B:27:0x009d, B:29:0x00af, B:42:0x00f7, B:43:0x0100, B:45:0x0106, B:47:0x010c, B:48:0x0113, B:50:0x0119, B:52:0x0121, B:54:0x0129, B:56:0x012f, B:57:0x0135, B:58:0x013a, B:59:0x013e, B:61:0x0144, B:40:0x00ed, B:28:0x00a4, B:33:0x00c1, B:35:0x00d8), top: B:69:0x0037, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0144 A[Catch: Exception -> 0x014a, TRY_LEAVE, TryCatch #1 {Exception -> 0x014a, blocks: (B:14:0x0037, B:16:0x0044, B:19:0x004e, B:21:0x0055, B:23:0x005e, B:24:0x0075, B:26:0x008d, B:27:0x009d, B:29:0x00af, B:42:0x00f7, B:43:0x0100, B:45:0x0106, B:47:0x010c, B:48:0x0113, B:50:0x0119, B:52:0x0121, B:54:0x0129, B:56:0x012f, B:57:0x0135, B:58:0x013a, B:59:0x013e, B:61:0x0144, B:40:0x00ed, B:28:0x00a4, B:33:0x00c1, B:35:0x00d8), top: B:69:0x0037, inners: #0, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(String str, com.baidu.adp.lib.stats.base.a aVar, String str2, ArrayList<String> arrayList, ArrayList<com.baidu.adp.lib.stats.base.c> arrayList2, boolean z, boolean z2) {
        byte[] b;
        String str3;
        e eVar;
        HashMap<String, Object> a2;
        byte[] bArr;
        List<com.baidu.adp.lib.network.http.d> fA;
        StringBuilder sb;
        int i;
        if (str != null && aVar != null && (b = b(str2, arrayList)) != null && b.length > 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(b.length / 2);
            try {
                g.a(b, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                HashMap hashMap = new HashMap();
                hashMap.put(aVar.gs(), byteArray);
                ArrayList arrayList3 = new ArrayList(hashMap.entrySet());
                try {
                    if (aVar != null) {
                        try {
                            if (aVar.gq().equals("pfmonitor") && BdStatisticsSwitchStatic.fS()) {
                                str3 = "http://nlog.baidu.com/dplog/n";
                                eVar = new e();
                                if (z2 && str3.contains("c.tieba.baidu.com")) {
                                    str3 = str3.replace("c.tieba.baidu.com", "123.125.115.120");
                                    eVar.fy().o("Host", "c.tieba.baidu.com");
                                }
                                eVar.fy().setUrl(str3);
                                eVar.fy().setMethod(HttpMessageTask.HTTP_METHOD.POST);
                                a2 = com.baidu.adp.lib.stats.upload.c.a(this.xi, z);
                                if (a2 != null) {
                                    eVar.fy().f(new ArrayList(a2.entrySet()));
                                }
                                eVar.fy().f(arrayList3);
                                new com.baidu.adp.lib.network.http.c(eVar).f(3, -1, -1);
                                int i2 = eVar.fz().responseCode;
                                bArr = eVar.fz().vr;
                                if (bArr != null && i2 == 200) {
                                    try {
                                        if (new JSONObject(new String(bArr, "utf-8")).optInt("error_code", -1) == 0) {
                                            b(arrayList2, aVar.gv());
                                            return null;
                                        }
                                    } catch (Exception e) {
                                        BdLog.e(e);
                                        return e.getMessage();
                                    }
                                }
                                fA = eVar.fA();
                                if (fA != null && fA.size() > 0) {
                                    sb = new StringBuilder();
                                    for (i = 0; i < fA.size(); i++) {
                                        com.baidu.adp.lib.network.http.d dVar = fA.get(i);
                                        if (dVar != null && !TextUtils.isEmpty(dVar.uY)) {
                                            if (sb.length() > 0) {
                                                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                            }
                                            sb.append(dVar.uY);
                                        }
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
                    new com.baidu.adp.lib.network.http.c(eVar).f(3, -1, -1);
                    int i22 = eVar.fz().responseCode;
                    bArr = eVar.fz().vr;
                    if (bArr != null) {
                        if (new JSONObject(new String(bArr, "utf-8")).optInt("error_code", -1) == 0) {
                        }
                    }
                    fA = eVar.fA();
                    if (fA != null) {
                        sb = new StringBuilder();
                        while (i < fA.size()) {
                        }
                        if (sb.length() > 0) {
                        }
                    }
                } catch (Exception e3) {
                    BdLog.detailException(e3);
                    return e3.getMessage();
                }
                str3 = str;
                eVar = new e();
                if (z2) {
                    str3 = str3.replace("c.tieba.baidu.com", "123.125.115.120");
                    eVar.fy().o("Host", "c.tieba.baidu.com");
                }
                eVar.fy().setUrl(str3);
                eVar.fy().setMethod(HttpMessageTask.HTTP_METHOD.POST);
                a2 = com.baidu.adp.lib.stats.upload.c.a(this.xi, z);
                if (a2 != null) {
                }
                eVar.fy().f(arrayList3);
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
