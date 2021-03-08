package com.baidu.adp.lib.stats.upload;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
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
    private static b Re = null;
    private com.baidu.adp.lib.stats.c Rf;
    private String Rg;
    private a Rh;
    private CustomMessageListener Ri = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.adp.lib.stats.upload.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                b.this.ny();
            }
        }
    };
    private String mUploadUrl;

    public static b nx() {
        if (Re == null) {
            synchronized (b.class) {
                if (Re == null) {
                    Re = new b();
                }
            }
        }
        return Re;
    }

    public void a(com.baidu.adp.lib.stats.c cVar, String str, String str2) {
        this.mUploadUrl = str;
        this.Rg = str2;
        this.Rf = cVar;
        if (this.Rf != null) {
            this.Rf.PO = Build.MODEL;
            this.Rf.PR = Build.VERSION.RELEASE;
            this.Rf.mNetType = com.baidu.adp.lib.stats.d.getNetType(BdBaseApplication.getInst());
            this.Rf.PQ = String.valueOf(j.netType());
        }
        try {
            MessageManager.getInstance().registerListener(this.Ri);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        if (this.Rh == null) {
            this.Rh = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(BdStatsConstant.BROADCAST_ACCOUNT_CHANGED);
            BdBaseApplication.getInst().registerReceiver(this.Rh, intentFilter);
        }
    }

    public void setUser(String str, String str2, String str3) {
        if (this.Rf.mUid != null || str != null) {
            if (this.Rf.mUid == null || !this.Rf.mUid.equals(str)) {
                this.Rf.mUid = str;
                this.Rf.PP = str2;
                this.Rf.mBduss = str3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ny() {
        this.Rf.mNetType = com.baidu.adp.lib.stats.d.getNetType(BdBaseApplication.getInst());
        this.Rf.PQ = String.valueOf(j.netType());
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
        private com.baidu.adp.lib.stats.base.a Rk;
        private String Rl;

        public c(com.baidu.adp.lib.stats.base.a aVar, String str) {
            this.Rk = aVar;
            this.Rl = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String a2 = com.baidu.adp.lib.stats.upload.d.a(this.Rk, b.this.Rf);
            String str = this.Rl;
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            BdLog.i("commonHeader = " + a2);
            BdLog.i("cache = " + str);
            this.Rk.nc();
            b.this.a(this.Rk, a2, arrayList, null, true);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends BdAsyncTask<Object, Integer, Void> {
        private String Rl;
        private com.baidu.adp.lib.stats.base.a Rm;

        public d(com.baidu.adp.lib.stats.base.a aVar, String str) {
            this.Rm = aVar;
            this.Rl = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String str = this.Rl;
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            this.Rm.ne();
            b.this.a(this.Rm, arrayList, (ArrayList<com.baidu.adp.lib.stats.base.d>) null);
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
            ArrayList<String> ce = com.baidu.adp.lib.stats.switchs.a.ns().ce(aVar.nf());
            if (!z) {
                boolean onlyWifiUpload = com.baidu.adp.lib.stats.switchs.a.ns().onlyWifiUpload(aVar.nf(), null);
                boolean isWifiNet = j.isWifiNet();
                if (!onlyWifiUpload || isWifiNet) {
                    if (ce != null && ce.size() > 0) {
                        ArrayList<String> arrayList3 = new ArrayList<>();
                        Iterator<String> it = ce.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (!com.baidu.adp.lib.stats.switchs.a.ns().isUpload(aVar.nf(), next)) {
                                b(arrayList3, next);
                            } else if (!com.baidu.adp.lib.stats.switchs.a.ns().smallFlowUpload(aVar.nf(), next)) {
                                b(arrayList3, next);
                            } else {
                                boolean onlyWifiUpload2 = com.baidu.adp.lib.stats.switchs.a.ns().onlyWifiUpload(aVar.nf(), next);
                                boolean isWifiNet2 = j.isWifiNet();
                                if (onlyWifiUpload2 && !isWifiNet2) {
                                    b(arrayList3, next);
                                }
                            }
                        }
                        arrayList = arrayList3;
                        if (aVar.ng()) {
                            aVar.ap(true);
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
            if (aVar.ng()) {
            }
        }
    }

    public void b(com.baidu.adp.lib.stats.base.a aVar) {
        if (!aVar.nh()) {
            aVar.aq(true);
            new C0024b(aVar).execute(new Object[0]);
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
        private com.baidu.adp.lib.stats.base.a Rj;
        private ArrayList<String> Rn;
        private boolean Ro;
        private boolean Rp;
        private boolean Rq;

        public e(com.baidu.adp.lib.stats.base.a aVar, ArrayList<String> arrayList, boolean z, boolean z2, boolean z3) {
            this.Rj = null;
            this.Rn = null;
            this.Ro = false;
            this.Rp = false;
            this.Rq = false;
            this.Rj = aVar;
            this.Rn = arrayList;
            this.Ro = z;
            this.Rp = z2;
            this.Rq = z3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            b(this.Rj, this.Ro, this.Rp, this.Rq);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Void r3) {
            this.Rj.ap(false);
        }

        private void b(com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2, boolean z3) {
            int i;
            try {
                String a2 = com.baidu.adp.lib.stats.upload.d.a(aVar, b.this.Rf);
                BdUploadingLogInfo a3 = com.baidu.adp.lib.stats.upload.a.a(aVar, z2);
                int size = a3.size();
                if (a3 != null && size > 0) {
                    if (!z) {
                        for (int i2 = 0; i2 < size; i2++) {
                            ArrayList<String> logStringByIndex = a3.getLogStringByIndex(i2, this.Rn);
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
                        ArrayList<String> logStringByIndex2 = a3.getLogStringByIndex(i5, this.Rn);
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
    private class C0024b extends BdAsyncTask<Object, Integer, Void> {
        private com.baidu.adp.lib.stats.base.a Rj;

        public C0024b(@NonNull com.baidu.adp.lib.stats.base.a aVar) {
            this.Rj = null;
            this.Rj = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            c(this.Rj);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Void r3) {
            this.Rj.aq(false);
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
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:94:0x0013 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0028 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003b  */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(String str, com.baidu.adp.lib.stats.base.a aVar, String str2, ArrayList<String> arrayList, ArrayList<com.baidu.adp.lib.stats.base.d> arrayList2, boolean z, boolean z2) {
        byte[] c2;
        ?? length;
        ByteArrayOutputStream byteArrayOutputStream;
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
            hashMap.put(aVar.ni(), length);
            ArrayList arrayList3 = new ArrayList(hashMap.entrySet());
            if (aVar != null) {
                try {
                    if (aVar.nf().equals(BdStatsConstant.StatsType.PERFORMANCE) && BdStatisticsSwitchStatic.isOn()) {
                        try {
                            com.baidu.adp.lib.network.http.e eVar = new com.baidu.adp.lib.network.http.e();
                            String str3 = this.mUploadUrl;
                            if (z2 && str3.contains("c.tieba.baidu.com")) {
                                str3 = str3.replace("c.tieba.baidu.com", "123.125.115.120");
                                eVar.lU().s("Host", "c.tieba.baidu.com");
                            }
                            eVar.lU().setUrl(str3);
                            eVar.lU().setMethod(HttpMessageTask.HTTP_METHOD.POST);
                            HashMap<String, Object> a2 = com.baidu.adp.lib.stats.upload.d.a(this.Rf, z);
                            if (a2 != null) {
                                eVar.lU().n(new ArrayList(a2.entrySet()));
                            }
                            hashMap.clear();
                            hashMap.put("pf", length);
                            arrayList3.clear();
                            arrayList3.addAll(hashMap.entrySet());
                            eVar.lU().n(arrayList3);
                            try {
                                new com.baidu.adp.lib.network.http.c(eVar).f(3, -1, -1);
                            } catch (Exception e4) {
                                BdLog.detailException(e4);
                            }
                            b(arrayList2, aVar.nn());
                            return null;
                        } catch (Exception e5) {
                            BdLog.e(e5);
                            return e5.getMessage();
                        }
                    }
                } catch (Exception e6) {
                    BdLog.e(e6);
                    return e6.getMessage();
                }
            }
            com.baidu.adp.lib.network.http.e eVar2 = new com.baidu.adp.lib.network.http.e();
            if (z2 && str.contains("c.tieba.baidu.com")) {
                str = str.replace("c.tieba.baidu.com", "123.125.115.120");
                eVar2.lU().s("Host", "c.tieba.baidu.com");
            }
            eVar2.lU().setUrl(str);
            eVar2.lU().setMethod(HttpMessageTask.HTTP_METHOD.POST);
            HashMap<String, Object> a3 = com.baidu.adp.lib.stats.upload.d.a(this.Rf, z);
            if (a3 != null) {
                eVar2.lU().n(new ArrayList(a3.entrySet()));
            }
            eVar2.lU().n(arrayList3);
            try {
                new com.baidu.adp.lib.network.http.c(eVar2).f(3, -1, -1);
                int i = eVar2.lV().responseCode;
                byte[] bArr = eVar2.lV().retBytes;
                if (bArr != null && i == 200) {
                    try {
                        if (new JSONObject(new String(bArr, "utf-8")).optInt("error_code", -1) == 0) {
                            b(arrayList2, aVar.nn());
                            return null;
                        }
                    } catch (Exception e7) {
                        BdLog.e(e7);
                        return e7.getMessage();
                    }
                }
                List<com.baidu.adp.lib.network.http.d> lW = eVar2.lW();
                if (lW != null && lW.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (int i2 = 0; i2 < lW.size(); i2++) {
                        com.baidu.adp.lib.network.http.d dVar = lW.get(i2);
                        if (dVar != null && !TextUtils.isEmpty(dVar.exception)) {
                            if (sb.length() > 0) {
                                sb.append(",");
                            }
                            sb.append(dVar.exception);
                        }
                    }
                    if (sb.length() > 0) {
                        return sb.toString();
                    }
                }
            } catch (Exception e8) {
                BdLog.detailException(e8);
                return e8.getMessage();
            }
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
        byte[] d2 = d(arrayList);
        if (d2 == null || d2.length == 0) {
            return false;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(d2.length / 2);
            try {
                try {
                    g.compress(d2, byteArrayOutputStream);
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
        hashMap.put(aVar.nj(), bArr);
        ArrayList arrayList3 = new ArrayList(hashMap.entrySet());
        com.baidu.adp.lib.network.http.e eVar = new com.baidu.adp.lib.network.http.e();
        eVar.lU().s("Host", "c.tieba.baidu.com");
        eVar.lU().setUrl(this.Rg);
        eVar.lU().setMethod(HttpMessageTask.HTTP_METHOD.POST);
        HashMap<String, Object> a2 = com.baidu.adp.lib.stats.upload.d.a(this.Rf, false);
        if (a2 != null) {
            eVar.lU().n(new ArrayList(a2.entrySet()));
        }
        eVar.lU().n(arrayList3);
        try {
            new com.baidu.adp.lib.network.http.c(eVar).f(3, -1, -1);
            if (eVar.lV().responseCode == 200) {
                try {
                    if (new JSONObject(new String(eVar.lV().retBytes, "utf-8")).optString("error_code").equals("0")) {
                        ArrayList arrayList4 = new ArrayList();
                        Iterator<com.baidu.adp.lib.stats.base.d> it = arrayList2.iterator();
                        while (it.hasNext()) {
                            arrayList4.add(it.next().mFileName);
                        }
                        if (arrayList4.size() > 0) {
                            com.baidu.adp.lib.stats.base.c.a(arrayList4, aVar.no());
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

    private byte[] d(ArrayList<String> arrayList) {
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
