package com.baidu.adp.lib.stats.upload;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.BdStatisticsSwitchStatic;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.g;
import com.baidu.adp.lib.util.j;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
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
    private static b OJ = null;
    private com.baidu.adp.lib.stats.c OL;
    private String OM;
    private a OO;
    private CustomMessageListener OP = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.adp.lib.stats.upload.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                b.this.nY();
            }
        }
    };
    private String mUploadUrl;

    public static b nX() {
        if (OJ == null) {
            synchronized (b.class) {
                if (OJ == null) {
                    OJ = new b();
                }
            }
        }
        return OJ;
    }

    public void a(com.baidu.adp.lib.stats.c cVar, String str, String str2) {
        this.mUploadUrl = str;
        this.OM = str2;
        this.OL = cVar;
        if (this.OL != null) {
            this.OL.Ny = Build.MODEL;
            this.OL.NB = Build.VERSION.RELEASE;
            this.OL.mNetType = com.baidu.adp.lib.stats.d.getNetType(BdBaseApplication.getInst());
            this.OL.NA = String.valueOf(j.netType());
        }
        try {
            MessageManager.getInstance().registerListener(this.OP);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        if (this.OO == null) {
            this.OO = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(BdStatsConstant.BROADCAST_ACCOUNT_CHANGED);
            BdBaseApplication.getInst().registerReceiver(this.OO, intentFilter);
        }
    }

    public void setUser(String str, String str2, String str3) {
        if (this.OL.mUid != null || str != null) {
            if (this.OL.mUid == null || !this.OL.mUid.equals(str)) {
                this.OL.mUid = str;
                this.OL.Nz = str2;
                this.OL.mBduss = str3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nY() {
        this.OL.mNetType = com.baidu.adp.lib.stats.d.getNetType(BdBaseApplication.getInst());
        this.OL.NA = String.valueOf(j.netType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                b.this.setUser(intent.getStringExtra(BdStatsConstant.INTENT_DATA_USERID), intent.getStringExtra(BdStatsConstant.INTENT_DATA_USERNAME), intent.getStringExtra(BdStatsConstant.INTENT_DATA_BDUSS));
            }
        }
    }

    public void a(com.baidu.adp.lib.stats.base.a aVar, String str) {
        new c(aVar, str).execute(new Object[0]);
    }

    public void b(com.baidu.adp.lib.stats.base.a aVar, String str) {
        new d(aVar, str).execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<Object, Integer, Void> {
        private com.baidu.adp.lib.stats.base.a OR;
        private String OT;

        public c(com.baidu.adp.lib.stats.base.a aVar, String str) {
            this.OR = aVar;
            this.OT = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String a2 = com.baidu.adp.lib.stats.upload.d.a(this.OR, b.this.OL);
            String str = this.OT;
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            BdLog.i("commonHeader = " + a2);
            BdLog.i("cache = " + str);
            this.OR.nC();
            b.this.a(this.OR, a2, arrayList, null, true);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends BdAsyncTask<Object, Integer, Void> {
        private String OT;
        private com.baidu.adp.lib.stats.base.a OU;

        public d(com.baidu.adp.lib.stats.base.a aVar, String str) {
            this.OU = aVar;
            this.OT = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str = this.OT;
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            this.OU.nE();
            b.this.a(this.OU, arrayList, (ArrayList<com.baidu.adp.lib.stats.base.d>) null);
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
            ArrayList<String> ce = com.baidu.adp.lib.stats.switchs.a.nS().ce(aVar.nF());
            if (!z) {
                boolean onlyWifiUpload = com.baidu.adp.lib.stats.switchs.a.nS().onlyWifiUpload(aVar.nF(), null);
                boolean isWifiNet = j.isWifiNet();
                if (!onlyWifiUpload || isWifiNet) {
                    if (ce != null && ce.size() > 0) {
                        ArrayList<String> arrayList3 = new ArrayList<>();
                        Iterator<String> it = ce.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (!com.baidu.adp.lib.stats.switchs.a.nS().isUpload(aVar.nF(), next)) {
                                b(arrayList3, next);
                            } else if (!com.baidu.adp.lib.stats.switchs.a.nS().smallFlowUpload(aVar.nF(), next)) {
                                b(arrayList3, next);
                            } else {
                                boolean onlyWifiUpload2 = com.baidu.adp.lib.stats.switchs.a.nS().onlyWifiUpload(aVar.nF(), next);
                                boolean isWifiNet2 = j.isWifiNet();
                                if (onlyWifiUpload2 && !isWifiNet2) {
                                    b(arrayList3, next);
                                }
                            }
                        }
                        arrayList = arrayList3;
                        if (aVar.nG()) {
                            aVar.ar(true);
                            if (arrayList == null || arrayList.size() <= 0) {
                                arrayList2 = null;
                            } else {
                                ArrayList arrayList4 = new ArrayList();
                                Iterator<String> it2 = arrayList.iterator();
                                while (it2.hasNext()) {
                                    try {
                                        arrayList4.add("st=" + URLEncoder.encode(com.baidu.adp.lib.stats.a.valueEscapeSpace(it2.next()), "utf-8") + ETAG.ITEM_SEPARATOR);
                                    } catch (UnsupportedEncodingException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                arrayList2 = arrayList4;
                            }
                            new e(aVar, arrayList2, z, z2, z3).execute(new Object[0]);
                            return;
                        }
                        return;
                    }
                } else {
                    return;
                }
            }
            arrayList = null;
            if (aVar.nG()) {
            }
        }
    }

    public void b(com.baidu.adp.lib.stats.base.a aVar) {
        if (!aVar.nH()) {
            aVar.as(true);
            new C0023b(aVar).execute(new Object[0]);
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
    public class e extends BdAsyncTask<Object, Integer, Void> {
        private com.baidu.adp.lib.stats.base.a OQ;
        private ArrayList<String> OV;
        private boolean OW;
        private boolean OX;
        private boolean OY;

        public e(com.baidu.adp.lib.stats.base.a aVar, ArrayList<String> arrayList, boolean z, boolean z2, boolean z3) {
            this.OQ = null;
            this.OV = null;
            this.OW = false;
            this.OX = false;
            this.OY = false;
            this.OQ = aVar;
            this.OV = arrayList;
            this.OW = z;
            this.OX = z2;
            this.OY = z3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            b(this.OQ, this.OW, this.OX, this.OY);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Void r3) {
            this.OQ.ar(false);
        }

        private void b(com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2, boolean z3) {
            int i;
            try {
                String a2 = com.baidu.adp.lib.stats.upload.d.a(aVar, b.this.OL);
                BdUploadingLogInfo a3 = com.baidu.adp.lib.stats.upload.a.a(aVar, z2);
                int size = a3.size();
                if (a3 != null && size > 0) {
                    if (!z) {
                        for (int i2 = 0; i2 < size; i2++) {
                            ArrayList<String> logStringByIndex = a3.getLogStringByIndex(i2, this.OV);
                            if (logStringByIndex != null && logStringByIndex.size() != 0) {
                                if (!z2) {
                                    b.this.a(aVar, a2, logStringByIndex, a3.get(i2), z3);
                                } else {
                                    ArrayList<com.baidu.adp.lib.stats.base.d> arrayList = a3.get(i2);
                                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                        if (arrayList.get(i3).mFileName.contains("notUpload/")) {
                                            arrayList.get(i3).mFileName = arrayList.get(i3).mFileName.replace("notUpload/", "");
                                        }
                                    }
                                    b.this.a(aVar, a2, logStringByIndex, arrayList, z3);
                                }
                            }
                        }
                        return;
                    }
                    int i4 = 0;
                    for (int i5 = size - 1; i5 >= 0; i5--) {
                        ArrayList<String> logStringByIndex2 = a3.getLogStringByIndex(i5, this.OV);
                        if (logStringByIndex2 != null && logStringByIndex2.size() != 0) {
                            if (j.isWifiNet()) {
                                i = i4;
                            } else {
                                i = i4 + logStringByIndex2.toString().length();
                                if (i > 102400) {
                                    return;
                                }
                            }
                            if (!z2) {
                                b.this.a(aVar, a2, logStringByIndex2, a3.get(i5), z3);
                                i4 = i;
                            } else {
                                ArrayList<com.baidu.adp.lib.stats.base.d> arrayList2 = a3.get(i5);
                                for (int i6 = 0; i6 < arrayList2.size(); i6++) {
                                    if (arrayList2.get(i6).mFileName.contains("notUpload/")) {
                                        arrayList2.get(i6).mFileName = arrayList2.get(i6).mFileName.replace("notUpload/", "");
                                    }
                                }
                                b.this.a(aVar, a2, logStringByIndex2, arrayList2, z3);
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

    /* renamed from: com.baidu.adp.lib.stats.upload.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0023b extends BdAsyncTask<Object, Integer, Void> {
        private com.baidu.adp.lib.stats.base.a OQ;

        public C0023b(@NonNull com.baidu.adp.lib.stats.base.a aVar) {
            this.OQ = null;
            this.OQ = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            c(this.OQ);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Void r3) {
            this.OQ.as(false);
        }

        private void c(com.baidu.adp.lib.stats.base.a aVar) {
            try {
                BdUploadingLogInfo d = com.baidu.adp.lib.stats.upload.c.d(aVar);
                int size = d.size();
                if (d != null && size > 0) {
                    for (int i = size - 1; i >= 0; i--) {
                        ArrayList<String> trackLogStringByIndex = d.getTrackLogStringByIndex(i);
                        if (trackLogStringByIndex != null && trackLogStringByIndex.size() != 0) {
                            b.this.a(aVar, trackLogStringByIndex, d.get(i));
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
                    sb.append(URLEncoder.encode(arrayList.get(i), "utf-8"));
                } catch (UnsupportedEncodingException e2) {
                    BdLog.e(e2);
                }
            }
            return sb.toString().getBytes();
        } catch (Exception e3) {
            BdLog.e(e3);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.adp.lib.stats.base.a aVar, String str, ArrayList<String> arrayList, ArrayList<com.baidu.adp.lib.stats.base.d> arrayList2, boolean z) {
        if (a(this.mUploadUrl, aVar, str, arrayList, arrayList2, z, false) != null && j.isNetWorkAvailable()) {
            String a2 = a(this.mUploadUrl, aVar, str, arrayList, arrayList2, z, true);
            if (a2 == null) {
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.append("issuc", "true");
                BdStatisticsManager.getInstance().debug("STAT_UPLOAD_USEIP", statsItem);
                return;
            }
            com.baidu.adp.lib.stats.a statsItem2 = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem2.append("issuc", "false");
            statsItem2.append(TiebaInitialize.LogFields.REASON, a2);
            BdStatisticsManager.getInstance().debug("STAT_UPLOAD_USEIP", statsItem2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [618=4] */
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
    private String a(String str, com.baidu.adp.lib.stats.base.a aVar, String str2, ArrayList<String> arrayList, ArrayList<com.baidu.adp.lib.stats.base.d> arrayList2, boolean z, boolean z2) {
        byte[] c2;
        ?? length;
        ByteArrayOutputStream byteArrayOutputStream;
        String str3;
        com.baidu.adp.lib.network.http.e eVar;
        HashMap<String, Object> a2;
        byte[] bArr;
        List<com.baidu.adp.lib.network.http.d> mz;
        StringBuilder sb;
        int i;
        if (str != null && aVar != null && (c2 = c(str2, arrayList)) != null && (length = c2.length) > 0) {
            OutputStream outputStream = null;
            try {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream(c2.length / 2);
                    try {
                        g.compress(c2, byteArrayOutputStream);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
                        length = byteArray;
                    } catch (Exception e2) {
                        e = e2;
                        BdLog.e(e);
                        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
                        length = 0;
                        if (length != 0) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    outputStream = length;
                    com.baidu.adp.lib.f.a.close(outputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                com.baidu.adp.lib.f.a.close(outputStream);
                throw th;
            }
            if (length != 0) {
                return "";
            }
            HashMap hashMap = new HashMap();
            hashMap.put(aVar.nI(), length);
            ArrayList arrayList3 = new ArrayList(hashMap.entrySet());
            try {
                if (aVar != null) {
                    try {
                        if (aVar.nF().equals(BdStatsConstant.StatsType.PERFORMANCE) && BdStatisticsSwitchStatic.isOn()) {
                            str3 = BdStatsConstant.BD_STATISTICS_PERFORMANCE_UPLOADURL;
                            eVar = new com.baidu.adp.lib.network.http.e();
                            if (z2 && str3.contains("c.tieba.baidu.com")) {
                                str3 = str3.replace("c.tieba.baidu.com", "123.125.115.120");
                                eVar.mx().u("Host", "c.tieba.baidu.com");
                            }
                            eVar.mx().setUrl(str3);
                            eVar.mx().setMethod(HttpMessageTask.HTTP_METHOD.POST);
                            a2 = com.baidu.adp.lib.stats.upload.d.a(this.OL, z);
                            if (a2 != null) {
                                eVar.mx().n(new ArrayList(a2.entrySet()));
                            }
                            eVar.mx().n(arrayList3);
                            new com.baidu.adp.lib.network.http.c(eVar).f(3, -1, -1);
                            int i2 = eVar.my().responseCode;
                            bArr = eVar.my().retBytes;
                            if (bArr != null && i2 == 200) {
                                try {
                                    if (new JSONObject(new String(bArr, "utf-8")).optInt("error_code", -1) == 0) {
                                        if (aVar != null && aVar.nF().equals(BdStatsConstant.StatsType.PERFORMANCE) && BdStatisticsSwitchStatic.isOn()) {
                                            com.baidu.adp.lib.network.http.e eVar2 = new com.baidu.adp.lib.network.http.e();
                                            String str4 = this.mUploadUrl;
                                            if (z2 && str4.contains("c.tieba.baidu.com")) {
                                                str4 = str4.replace("c.tieba.baidu.com", "123.125.115.120");
                                                eVar2.mx().u("Host", "c.tieba.baidu.com");
                                            }
                                            eVar2.mx().setUrl(str4);
                                            eVar2.mx().setMethod(HttpMessageTask.HTTP_METHOD.POST);
                                            if (a2 != null) {
                                                eVar2.mx().n(new ArrayList(a2.entrySet()));
                                            }
                                            hashMap.clear();
                                            hashMap.put("pf", length);
                                            arrayList3.clear();
                                            arrayList3.addAll(hashMap.entrySet());
                                            eVar2.mx().n(arrayList3);
                                            try {
                                                new com.baidu.adp.lib.network.http.c(eVar2).f(3, -1, -1);
                                            } catch (Exception e4) {
                                                BdLog.detailException(e4);
                                            }
                                        }
                                        b(arrayList2, aVar.nN());
                                        return null;
                                    }
                                } catch (Exception e5) {
                                    BdLog.e(e5);
                                    return e5.getMessage();
                                }
                            }
                            mz = eVar.mz();
                            if (mz != null && mz.size() > 0) {
                                sb = new StringBuilder();
                                for (i = 0; i < mz.size(); i++) {
                                    com.baidu.adp.lib.network.http.d dVar = mz.get(i);
                                    if (dVar != null && !TextUtils.isEmpty(dVar.exception)) {
                                        if (sb.length() > 0) {
                                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                        }
                                        sb.append(dVar.exception);
                                    }
                                }
                                if (sb.length() > 0) {
                                    return sb.toString();
                                }
                            }
                        }
                    } catch (Exception e6) {
                        BdLog.e(e6);
                        return e6.getMessage();
                    }
                }
                new com.baidu.adp.lib.network.http.c(eVar).f(3, -1, -1);
                int i22 = eVar.my().responseCode;
                bArr = eVar.my().retBytes;
                if (bArr != null) {
                    if (new JSONObject(new String(bArr, "utf-8")).optInt("error_code", -1) == 0) {
                    }
                }
                mz = eVar.mz();
                if (mz != null) {
                    sb = new StringBuilder();
                    while (i < mz.size()) {
                    }
                    if (sb.length() > 0) {
                    }
                }
            } catch (Exception e7) {
                BdLog.detailException(e7);
                return e7.getMessage();
            }
            str3 = str;
            eVar = new com.baidu.adp.lib.network.http.e();
            if (z2) {
                str3 = str3.replace("c.tieba.baidu.com", "123.125.115.120");
                eVar.mx().u("Host", "c.tieba.baidu.com");
            }
            eVar.mx().setUrl(str3);
            eVar.mx().setMethod(HttpMessageTask.HTTP_METHOD.POST);
            a2 = com.baidu.adp.lib.stats.upload.d.a(this.OL, z);
            if (a2 != null) {
            }
            eVar.mx().n(arrayList3);
        }
        return "";
    }

    private void b(ArrayList<com.baidu.adp.lib.stats.base.d> arrayList, boolean z) {
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<com.baidu.adp.lib.stats.base.d> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next().mFileName);
            }
            if (arrayList2.size() > 0) {
                com.baidu.adp.lib.stats.base.b.a(arrayList2, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(com.baidu.adp.lib.stats.base.a aVar, ArrayList<String> arrayList, ArrayList<com.baidu.adp.lib.stats.base.d> arrayList2) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        byte[] bArr = null;
        if (aVar == null || arrayList == null || arrayList.isEmpty()) {
            return false;
        }
        byte[] i = i(arrayList);
        if (i == null || i.length == 0) {
            return false;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(i.length / 2);
            try {
                try {
                    g.compress(i, byteArrayOutputStream);
                    bArr = byteArrayOutputStream.toByteArray();
                    com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e);
                    com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
                    if (bArr != null) {
                    }
                }
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream2 = byteArrayOutputStream;
                com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream2);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream2);
            throw th;
        }
        if (bArr != null) {
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(aVar.nJ(), bArr);
        ArrayList arrayList3 = new ArrayList(hashMap.entrySet());
        com.baidu.adp.lib.network.http.e eVar = new com.baidu.adp.lib.network.http.e();
        eVar.mx().u("Host", "c.tieba.baidu.com");
        eVar.mx().setUrl(this.OM);
        eVar.mx().setMethod(HttpMessageTask.HTTP_METHOD.POST);
        HashMap<String, Object> a2 = com.baidu.adp.lib.stats.upload.d.a(this.OL, false);
        if (a2 != null) {
            eVar.mx().n(new ArrayList(a2.entrySet()));
        }
        eVar.mx().n(arrayList3);
        try {
            new com.baidu.adp.lib.network.http.c(eVar).f(3, -1, -1);
            if (eVar.my().responseCode == 200) {
                try {
                    if (new JSONObject(new String(eVar.my().retBytes, "utf-8")).optString("error_code").equals("0")) {
                        ArrayList arrayList4 = new ArrayList();
                        Iterator<com.baidu.adp.lib.stats.base.d> it = arrayList2.iterator();
                        while (it.hasNext()) {
                            arrayList4.add(it.next().mFileName);
                        }
                        if (arrayList4.size() > 0) {
                            com.baidu.adp.lib.stats.base.c.a(arrayList4, aVar.nO());
                        }
                    }
                } catch (Exception e4) {
                    BdLog.e(e4);
                    return false;
                }
            }
            return true;
        } catch (Exception e5) {
            BdLog.detailException(e5);
            return false;
        }
    }

    private byte[] i(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (i != 0) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                sb.append(URLEncoder.encode(arrayList.get(i), "utf-8"));
            }
            return sb.toString().getBytes();
        } catch (Exception e2) {
            BdLog.e(e2);
            return null;
        }
    }
}
