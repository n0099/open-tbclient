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
import com.baidu.ar.util.IoUtils;
import com.baidu.searchbox.ng.ai.apps.network.WebSocketAction;
import com.baidu.webkit.internal.ABTestConstants;
import com.baidu.webkit.internal.ETAG;
import com.tencent.connect.common.Constants;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private static b EW = null;
    private com.baidu.adp.lib.stats.c EX;
    private a EY;
    private CustomMessageListener mNetworkChangedListener = new CustomMessageListener(2000994) { // from class: com.baidu.adp.lib.stats.upload.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                b.this.kx();
            }
        }
    };
    private String mUploadUrl;

    public static b kw() {
        if (EW == null) {
            synchronized (b.class) {
                if (EW == null) {
                    EW = new b();
                }
            }
        }
        return EW;
    }

    public void a(com.baidu.adp.lib.stats.c cVar, String str) {
        this.mUploadUrl = str;
        this.EX = cVar;
        if (this.EX != null) {
            this.EX.Ef = Build.MODEL;
            this.EX.Ej = Build.VERSION.RELEASE;
            this.EX.mNetType = d.getNetType(BdBaseApplication.getInst());
            this.EX.Ei = String.valueOf(j.ld());
        }
        try {
            MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.EY == null) {
            this.EY = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
            BdBaseApplication.getInst().registerReceiver(this.EY, intentFilter);
        }
    }

    public void setUser(String str, String str2, String str3) {
        if (this.EX.mUid != null || str != null) {
            if (this.EX.mUid == null || !this.EX.mUid.equals(str)) {
                this.EX.mUid = str;
                this.EX.Eg = str2;
                this.EX.Eh = str3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kx() {
        this.EX.mNetType = d.getNetType(BdBaseApplication.getInst());
        this.EX.Ei = String.valueOf(j.ld());
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
        new C0020b(aVar, str).execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.adp.lib.stats.upload.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0020b extends BdAsyncTask<Object, Integer, Void> {
        private com.baidu.adp.lib.stats.base.a EZ;
        private String Fa;

        public C0020b(com.baidu.adp.lib.stats.base.a aVar, String str) {
            this.EZ = aVar;
            this.Fa = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String a = com.baidu.adp.lib.stats.upload.c.a(this.EZ, b.this.EX);
            String str = this.Fa;
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            BdLog.i("commonHeader = " + a);
            BdLog.i("cache = " + str);
            this.EZ.kf();
            b.this.a(this.EZ, a, arrayList, null, true);
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
            ArrayList<String> bc = com.baidu.adp.lib.stats.switchs.a.kq().bc(aVar.kh());
            if (!z) {
                boolean onlyWifiUpload = com.baidu.adp.lib.stats.switchs.a.kq().onlyWifiUpload(aVar.kh(), null);
                boolean kY = j.kY();
                if (!onlyWifiUpload || kY) {
                    if (bc != null && bc.size() > 0) {
                        ArrayList<String> arrayList3 = new ArrayList<>();
                        Iterator<String> it = bc.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (!com.baidu.adp.lib.stats.switchs.a.kq().isUpload(aVar.kh(), next)) {
                                a(arrayList3, next);
                            } else if (!com.baidu.adp.lib.stats.switchs.a.kq().smallFlowUpload(aVar.kh(), next)) {
                                a(arrayList3, next);
                            } else {
                                boolean onlyWifiUpload2 = com.baidu.adp.lib.stats.switchs.a.kq().onlyWifiUpload(aVar.kh(), next);
                                boolean kY2 = j.kY();
                                if (onlyWifiUpload2 && !kY2) {
                                    a(arrayList3, next);
                                }
                            }
                        }
                        arrayList = arrayList3;
                        if (aVar.ki()) {
                            aVar.W(true);
                            if (arrayList == null || arrayList.size() <= 0) {
                                arrayList2 = null;
                            } else {
                                ArrayList arrayList4 = new ArrayList();
                                Iterator<String> it2 = arrayList.iterator();
                                while (it2.hasNext()) {
                                    try {
                                        arrayList4.add("st=" + URLEncoder.encode(com.baidu.adp.lib.stats.a.aW(it2.next()), IoUtils.UTF_8) + ETAG.ITEM_SEPARATOR);
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
            if (aVar.ki()) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<Object, Integer, Void> {
        private com.baidu.adp.lib.stats.base.a Fb;
        private ArrayList<String> Fc;
        private boolean Fd;
        private boolean Fe;
        private boolean Ff;

        public c(com.baidu.adp.lib.stats.base.a aVar, ArrayList<String> arrayList, boolean z, boolean z2, boolean z3) {
            this.Fb = null;
            this.Fc = null;
            this.Fd = false;
            this.Fe = false;
            this.Ff = false;
            this.Fb = aVar;
            this.Fc = arrayList;
            this.Fd = z;
            this.Fe = z2;
            this.Ff = z3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            b(this.Fb, this.Fd, this.Fe, this.Ff);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Void r3) {
            this.Fb.W(false);
        }

        private void b(com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2, boolean z3) {
            int i;
            try {
                String a = com.baidu.adp.lib.stats.upload.c.a(aVar, b.this.EX);
                BdUploadingLogInfo a2 = com.baidu.adp.lib.stats.upload.a.a(aVar, z2);
                int size = a2.size();
                if (a2 != null && size > 0) {
                    if (!z) {
                        for (int i2 = 0; i2 < size; i2++) {
                            ArrayList<String> logStringByIndex = a2.getLogStringByIndex(i2, this.Fc);
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
                        ArrayList<String> logStringByIndex2 = a2.getLogStringByIndex(i5, this.Fc);
                        if (logStringByIndex2 != null && logStringByIndex2.size() != 0) {
                            if (j.kY()) {
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

    private byte[] c(String str, ArrayList<String> arrayList) {
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
                    sb.append(URLEncoder.encode(arrayList.get(i), IoUtils.UTF_8));
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
        if (a(this.mUploadUrl, aVar, str, arrayList, arrayList2, z, false) != null && j.kX()) {
            String a2 = a(this.mUploadUrl, aVar, str, arrayList, arrayList2, z, true);
            if (a2 == null) {
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.append("issuc", "true");
                BdStatisticsManager.getInstance().debug("STAT_UPLOAD_USEIP", statsItem);
                return;
            }
            com.baidu.adp.lib.stats.a statsItem2 = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem2.append("issuc", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE);
            statsItem2.append(WebSocketAction.PARAM_KEY_REASON, a2);
            BdStatisticsManager.getInstance().debug("STAT_UPLOAD_USEIP", statsItem2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [529=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:101:0x0013 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0028 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a8 A[Catch: Exception -> 0x01e5, TryCatch #5 {Exception -> 0x01e5, blocks: (B:25:0x0052, B:27:0x005f, B:30:0x0069, B:32:0x0070, B:34:0x0079, B:35:0x0090, B:37:0x00a8, B:38:0x00b8, B:40:0x00ca, B:70:0x0192, B:71:0x019b, B:73:0x01a1, B:75:0x01a7, B:76:0x01ae, B:78:0x01b4, B:80:0x01bc, B:82:0x01c4, B:84:0x01ca, B:85:0x01d0, B:86:0x01d5, B:87:0x01d9, B:89:0x01df, B:64:0x0183, B:39:0x00bf, B:44:0x00dc, B:47:0x00f5, B:49:0x0102, B:51:0x0108, B:53:0x0111, B:55:0x011a, B:56:0x0131, B:58:0x0143, B:59:0x0153, B:67:0x018d, B:61:0x0178), top: B:105:0x0052, inners: #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b4 A[Catch: Exception -> 0x01e5, TryCatch #5 {Exception -> 0x01e5, blocks: (B:25:0x0052, B:27:0x005f, B:30:0x0069, B:32:0x0070, B:34:0x0079, B:35:0x0090, B:37:0x00a8, B:38:0x00b8, B:40:0x00ca, B:70:0x0192, B:71:0x019b, B:73:0x01a1, B:75:0x01a7, B:76:0x01ae, B:78:0x01b4, B:80:0x01bc, B:82:0x01c4, B:84:0x01ca, B:85:0x01d0, B:86:0x01d5, B:87:0x01d9, B:89:0x01df, B:64:0x0183, B:39:0x00bf, B:44:0x00dc, B:47:0x00f5, B:49:0x0102, B:51:0x0108, B:53:0x0111, B:55:0x011a, B:56:0x0131, B:58:0x0143, B:59:0x0153, B:67:0x018d, B:61:0x0178), top: B:105:0x0052, inners: #6, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01df A[Catch: Exception -> 0x01e5, TRY_LEAVE, TryCatch #5 {Exception -> 0x01e5, blocks: (B:25:0x0052, B:27:0x005f, B:30:0x0069, B:32:0x0070, B:34:0x0079, B:35:0x0090, B:37:0x00a8, B:38:0x00b8, B:40:0x00ca, B:70:0x0192, B:71:0x019b, B:73:0x01a1, B:75:0x01a7, B:76:0x01ae, B:78:0x01b4, B:80:0x01bc, B:82:0x01c4, B:84:0x01ca, B:85:0x01d0, B:86:0x01d5, B:87:0x01d9, B:89:0x01df, B:64:0x0183, B:39:0x00bf, B:44:0x00dc, B:47:0x00f5, B:49:0x0102, B:51:0x0108, B:53:0x0111, B:55:0x011a, B:56:0x0131, B:58:0x0143, B:59:0x0153, B:67:0x018d, B:61:0x0178), top: B:105:0x0052, inners: #6, #7 }] */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(String str, com.baidu.adp.lib.stats.base.a aVar, String str2, ArrayList<String> arrayList, ArrayList<com.baidu.adp.lib.stats.base.c> arrayList2, boolean z, boolean z2) {
        byte[] c2;
        ?? length;
        ByteArrayOutputStream byteArrayOutputStream;
        String str3;
        e eVar;
        HashMap<String, Object> a2;
        byte[] bArr;
        List<com.baidu.adp.lib.network.http.d> jt;
        StringBuilder sb;
        int i;
        if (str != null && aVar != null && (c2 = c(str2, arrayList)) != null && (length = c2.length) > 0) {
            OutputStream outputStream = null;
            try {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream(c2.length / 2);
                    try {
                        g.a(c2, byteArrayOutputStream);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                        length = byteArray;
                    } catch (Exception e) {
                        e = e;
                        BdLog.e(e);
                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                        length = 0;
                        if (length != 0) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    outputStream = length;
                    com.baidu.adp.lib.g.a.b(outputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                com.baidu.adp.lib.g.a.b(outputStream);
                throw th;
            }
            if (length != 0) {
                return "";
            }
            HashMap hashMap = new HashMap();
            hashMap.put(aVar.kj(), length);
            ArrayList arrayList3 = new ArrayList(hashMap.entrySet());
            try {
                if (aVar != null) {
                    try {
                        if (aVar.kh().equals("pfmonitor") && BdStatisticsSwitchStatic.jL()) {
                            str3 = "http://nlog.baidu.com/dplog/n";
                            eVar = new e();
                            if (z2 && str3.contains("c.tieba.baidu.com")) {
                                str3 = str3.replace("c.tieba.baidu.com", "123.125.115.120");
                                eVar.jr().y("Host", "c.tieba.baidu.com");
                            }
                            eVar.jr().setUrl(str3);
                            eVar.jr().setMethod(HttpMessageTask.HTTP_METHOD.POST);
                            a2 = com.baidu.adp.lib.stats.upload.c.a(this.EX, z);
                            if (a2 != null) {
                                eVar.jr().j(new ArrayList(a2.entrySet()));
                            }
                            eVar.jr().j(arrayList3);
                            new com.baidu.adp.lib.network.http.c(eVar).g(3, -1, -1);
                            int i2 = eVar.js().responseCode;
                            bArr = eVar.js().Dc;
                            if (bArr != null && i2 == 200) {
                                try {
                                    if (new JSONObject(new String(bArr, IoUtils.UTF_8)).optInt("error_code", -1) == 0) {
                                        if (aVar != null && aVar.kh().equals("pfmonitor") && BdStatisticsSwitchStatic.jL()) {
                                            e eVar2 = new e();
                                            String str4 = this.mUploadUrl;
                                            if (z2 && str4.contains("c.tieba.baidu.com")) {
                                                str4 = str4.replace("c.tieba.baidu.com", "123.125.115.120");
                                                eVar2.jr().y("Host", "c.tieba.baidu.com");
                                            }
                                            eVar2.jr().setUrl(str4);
                                            eVar2.jr().setMethod(HttpMessageTask.HTTP_METHOD.POST);
                                            if (a2 != null) {
                                                eVar2.jr().j(new ArrayList(a2.entrySet()));
                                            }
                                            hashMap.clear();
                                            hashMap.put(Constants.PARAM_PLATFORM_ID, length);
                                            arrayList3.clear();
                                            arrayList3.addAll(hashMap.entrySet());
                                            eVar2.jr().j(arrayList3);
                                            try {
                                                new com.baidu.adp.lib.network.http.c(eVar2).g(3, -1, -1);
                                            } catch (Exception e3) {
                                                BdLog.detailException(e3);
                                            }
                                        }
                                        b(arrayList2, aVar.km());
                                        return null;
                                    }
                                } catch (Exception e4) {
                                    BdLog.e(e4);
                                    return e4.getMessage();
                                }
                            }
                            jt = eVar.jt();
                            if (jt != null && jt.size() > 0) {
                                sb = new StringBuilder();
                                for (i = 0; i < jt.size(); i++) {
                                    com.baidu.adp.lib.network.http.d dVar = jt.get(i);
                                    if (dVar != null && !TextUtils.isEmpty(dVar.CH)) {
                                        if (sb.length() > 0) {
                                            sb.append(",");
                                        }
                                        sb.append(dVar.CH);
                                    }
                                }
                                if (sb.length() > 0) {
                                    return sb.toString();
                                }
                            }
                        }
                    } catch (Exception e5) {
                        BdLog.e(e5);
                        return e5.getMessage();
                    }
                }
                new com.baidu.adp.lib.network.http.c(eVar).g(3, -1, -1);
                int i22 = eVar.js().responseCode;
                bArr = eVar.js().Dc;
                if (bArr != null) {
                    if (new JSONObject(new String(bArr, IoUtils.UTF_8)).optInt("error_code", -1) == 0) {
                    }
                }
                jt = eVar.jt();
                if (jt != null) {
                    sb = new StringBuilder();
                    while (i < jt.size()) {
                    }
                    if (sb.length() > 0) {
                    }
                }
            } catch (Exception e6) {
                BdLog.detailException(e6);
                return e6.getMessage();
            }
            str3 = str;
            eVar = new e();
            if (z2) {
                str3 = str3.replace("c.tieba.baidu.com", "123.125.115.120");
                eVar.jr().y("Host", "c.tieba.baidu.com");
            }
            eVar.jr().setUrl(str3);
            eVar.jr().setMethod(HttpMessageTask.HTTP_METHOD.POST);
            a2 = com.baidu.adp.lib.stats.upload.c.a(this.EX, z);
            if (a2 != null) {
            }
            eVar.jr().j(arrayList3);
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
