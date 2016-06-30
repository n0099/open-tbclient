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
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private static b nP = null;
    private f nQ;
    private String nR;
    private a nS;
    private CustomMessageListener nT = new com.baidu.adp.lib.stats.upload.c(this, 2000994);

    public static b eP() {
        if (nP == null) {
            synchronized (b.class) {
                if (nP == null) {
                    nP = new b();
                }
            }
        }
        return nP;
    }

    public void a(f fVar, String str) {
        this.nR = str;
        this.nQ = fVar;
        if (this.nQ != null) {
            this.nQ.mU = Build.MODEL;
            this.nQ.nb = Build.VERSION.RELEASE;
            this.nQ.mNetType = g.v(BdBaseApplication.getInst());
            this.nQ.na = String.valueOf(i.fx());
        }
        try {
            MessageManager.getInstance().registerListener(this.nT);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.nS == null) {
            this.nS = new a(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
            BdBaseApplication.getInst().registerReceiver(this.nS, intentFilter);
        }
    }

    public void k(String str, String str2, String str3) {
        if (this.nQ.mV != null || str != null) {
            if (this.nQ.mV == null || !this.nQ.mV.equals(str)) {
                this.nQ.mV = str;
                this.nQ.mW = str2;
                this.nQ.mZ = str3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eQ() {
        this.nQ.mNetType = g.v(BdBaseApplication.getInst());
        this.nQ.na = String.valueOf(i.fx());
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
                b.this.k(intent.getStringExtra("intent_data_userid"), intent.getStringExtra("intent_data_username"), intent.getStringExtra("intent_data_bduss"));
            }
        }
    }

    public void a(com.baidu.adp.lib.stats.base.a aVar, String str) {
        new C0009b(aVar, str).execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.adp.lib.stats.upload.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0009b extends BdAsyncTask<Object, Integer, Void> {
        private com.baidu.adp.lib.stats.base.a nU;
        private String nV;

        public C0009b(com.baidu.adp.lib.stats.base.a aVar, String str) {
            this.nU = aVar;
            this.nV = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String a = d.a(this.nU, b.this.nQ);
            String str = this.nV;
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            BdLog.i("commonHeader = " + a);
            BdLog.i("cache = " + str);
            this.nU.ey();
            b.this.a(this.nU, a, arrayList, null, true);
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
        if (com.baidu.adp.lib.stats.a.dO().dV() && aVar != null) {
            ArrayList<String> as = com.baidu.adp.lib.stats.switchs.a.eJ().as(aVar.eA());
            if (!z) {
                boolean onlyWifiUpload = com.baidu.adp.lib.stats.switchs.a.eJ().onlyWifiUpload(aVar.eA(), null);
                boolean fs = i.fs();
                if (!onlyWifiUpload || fs) {
                    if (as != null && as.size() > 0) {
                        ArrayList<String> arrayList3 = new ArrayList<>();
                        Iterator<String> it = as.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (!com.baidu.adp.lib.stats.switchs.a.eJ().isUpload(aVar.eA(), next)) {
                                b(arrayList3, next);
                            } else if (!com.baidu.adp.lib.stats.switchs.a.eJ().smallFlowUpload(aVar.eA(), next)) {
                                b(arrayList3, next);
                            } else {
                                boolean onlyWifiUpload2 = com.baidu.adp.lib.stats.switchs.a.eJ().onlyWifiUpload(aVar.eA(), next);
                                boolean fs2 = i.fs();
                                if (onlyWifiUpload2 && !fs2) {
                                    b(arrayList3, next);
                                }
                            }
                        }
                        arrayList = arrayList3;
                        if (aVar.eB()) {
                            aVar.C(true);
                            if (arrayList == null || arrayList.size() <= 0) {
                                arrayList2 = null;
                            } else {
                                ArrayList arrayList4 = new ArrayList();
                                Iterator<String> it2 = arrayList.iterator();
                                while (it2.hasNext()) {
                                    try {
                                        arrayList4.add("st=" + URLEncoder.encode(com.baidu.adp.lib.stats.d.am(it2.next()), "utf-8") + "&");
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
            if (aVar.eB()) {
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
        private com.baidu.adp.lib.stats.base.a nW;
        private ArrayList<String> nX;
        private boolean nY;
        private boolean nZ;
        private boolean oa;

        public c(com.baidu.adp.lib.stats.base.a aVar, ArrayList<String> arrayList, boolean z, boolean z2, boolean z3) {
            this.nW = null;
            this.nX = null;
            this.nY = false;
            this.nZ = false;
            this.oa = false;
            this.nW = aVar;
            this.nX = arrayList;
            this.nY = z;
            this.nZ = z2;
            this.oa = z3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            b(this.nW, this.nY, this.nZ, this.oa);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r3) {
            this.nW.C(false);
        }

        private void b(com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2, boolean z3) {
            int i;
            try {
                String a = d.a(aVar, b.this.nQ);
                BdUploadingLogInfo a2 = com.baidu.adp.lib.stats.upload.a.a(aVar, z2);
                int size = a2.size();
                if (a2 != null && size > 0) {
                    if (!z) {
                        for (int i2 = 0; i2 < size; i2++) {
                            ArrayList<String> logStringByIndex = a2.getLogStringByIndex(i2, this.nX);
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
                        ArrayList<String> logStringByIndex2 = a2.getLogStringByIndex(i5, this.nX);
                        if (logStringByIndex2 != null && logStringByIndex2.size() != 0) {
                            if (i.fs()) {
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
        if (a(this.nR, aVar, str, arrayList, arrayList2, z, false) != null && i.fr()) {
            String a2 = a(this.nR, aVar, str, arrayList, arrayList2, z, true);
            if (a2 == null) {
                com.baidu.adp.lib.stats.d al = com.baidu.adp.lib.stats.a.dO().al("dbg");
                al.q("issuc", "true");
                com.baidu.adp.lib.stats.a.dO().b("STAT_UPLOAD_USEIP", al);
                return;
            }
            com.baidu.adp.lib.stats.d al2 = com.baidu.adp.lib.stats.a.dO().al("dbg");
            al2.q("issuc", "false");
            al2.q("reason", a2);
            com.baidu.adp.lib.stats.a.dO().b("STAT_UPLOAD_USEIP", al2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0085 A[Catch: Exception -> 0x013f, TryCatch #0 {Exception -> 0x013f, blocks: (B:14:0x0036, B:16:0x0042, B:19:0x004b, B:21:0x0052, B:23:0x005a, B:24:0x006d, B:26:0x0085, B:27:0x0095, B:29:0x00a7, B:42:0x00ed, B:43:0x00f6, B:45:0x00fc, B:47:0x0102, B:48:0x0109, B:50:0x010f, B:52:0x0115, B:53:0x011b, B:55:0x0123, B:57:0x012b, B:59:0x0131, B:60:0x0136, B:40:0x00e3, B:33:0x00b9, B:35:0x00ce, B:28:0x009c), top: B:66:0x0036, inners: #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ce A[Catch: Exception -> 0x00ec, TRY_LEAVE, TryCatch #1 {Exception -> 0x00ec, blocks: (B:33:0x00b9, B:35:0x00ce), top: B:67:0x00b9, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0115 A[Catch: Exception -> 0x013f, TryCatch #0 {Exception -> 0x013f, blocks: (B:14:0x0036, B:16:0x0042, B:19:0x004b, B:21:0x0052, B:23:0x005a, B:24:0x006d, B:26:0x0085, B:27:0x0095, B:29:0x00a7, B:42:0x00ed, B:43:0x00f6, B:45:0x00fc, B:47:0x0102, B:48:0x0109, B:50:0x010f, B:52:0x0115, B:53:0x011b, B:55:0x0123, B:57:0x012b, B:59:0x0131, B:60:0x0136, B:40:0x00e3, B:33:0x00b9, B:35:0x00ce, B:28:0x009c), top: B:66:0x0036, inners: #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011b A[Catch: Exception -> 0x013f, TryCatch #0 {Exception -> 0x013f, blocks: (B:14:0x0036, B:16:0x0042, B:19:0x004b, B:21:0x0052, B:23:0x005a, B:24:0x006d, B:26:0x0085, B:27:0x0095, B:29:0x00a7, B:42:0x00ed, B:43:0x00f6, B:45:0x00fc, B:47:0x0102, B:48:0x0109, B:50:0x010f, B:52:0x0115, B:53:0x011b, B:55:0x0123, B:57:0x012b, B:59:0x0131, B:60:0x0136, B:40:0x00e3, B:33:0x00b9, B:35:0x00ce, B:28:0x009c), top: B:66:0x0036, inners: #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x010f A[EDGE_INSN: B:73:0x010f->B:50:0x010f ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(String str, com.baidu.adp.lib.stats.base.a aVar, String str2, ArrayList<String> arrayList, ArrayList<com.baidu.adp.lib.stats.base.c> arrayList2, boolean z, boolean z2) {
        byte[] b;
        String str3;
        com.baidu.adp.lib.network.http.f fVar;
        HashMap<String, Object> a2;
        byte[] bArr;
        List<e> dx;
        StringBuilder sb;
        int i;
        int i2;
        if (str != null && aVar != null && (b = b(str2, arrayList)) != null && b.length > 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(b.length / 2);
            try {
                com.baidu.adp.lib.util.f.a(b, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                HashMap hashMap = new HashMap();
                hashMap.put(aVar.eC(), byteArray);
                ArrayList arrayList3 = new ArrayList(hashMap.entrySet());
                try {
                    if (aVar != null) {
                        try {
                            if (aVar.eA().equals("pfmonitor") && BdStatisticsSwitchStatic.ed()) {
                                str3 = "http://nlog.baidu.com/dplog/n";
                                fVar = new com.baidu.adp.lib.network.http.f();
                                if (z2 && str3.contains("c.tieba.baidu.com")) {
                                    str3 = str3.replace("c.tieba.baidu.com", "123.125.115.120");
                                    fVar.dv().o("Host", "c.tieba.baidu.com");
                                }
                                fVar.dv().setUrl(str3);
                                fVar.dv().setMethod(HttpMessageTask.HTTP_METHOD.POST);
                                a2 = d.a(this.nQ, z);
                                if (a2 != null) {
                                    fVar.dv().d(new ArrayList(a2.entrySet()));
                                }
                                fVar.dv().d(arrayList3);
                                new com.baidu.adp.lib.network.http.d(fVar).f(3, -1, -1);
                                int i3 = fVar.dw().responseCode;
                                bArr = fVar.dw().lG;
                                if (bArr != null && i3 == 200) {
                                    try {
                                        if (new JSONObject(new String(bArr, "utf-8")).optInt(SocialConstants.PARAM_ERROR_CODE, -1) == 0) {
                                            b(arrayList2, aVar.eF());
                                            return null;
                                        }
                                    } catch (Exception e) {
                                        BdLog.e(e);
                                        return e.getMessage();
                                    }
                                }
                                dx = fVar.dx();
                                if (dx != null && dx.size() > 0) {
                                    sb = new StringBuilder();
                                    i = 0;
                                    while (true) {
                                        i2 = i;
                                        if (i2 < dx.size()) {
                                            break;
                                        }
                                        e eVar = dx.get(i2);
                                        if (eVar != null && !TextUtils.isEmpty(eVar.ll)) {
                                            if (sb.length() > 0) {
                                                sb.append(",");
                                            }
                                            sb.append(eVar.ll);
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
                    int i32 = fVar.dw().responseCode;
                    bArr = fVar.dw().lG;
                    if (bArr != null) {
                        if (new JSONObject(new String(bArr, "utf-8")).optInt(SocialConstants.PARAM_ERROR_CODE, -1) == 0) {
                        }
                    }
                    dx = fVar.dx();
                    if (dx != null) {
                        sb = new StringBuilder();
                        i = 0;
                        while (true) {
                            i2 = i;
                            if (i2 < dx.size()) {
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
                    fVar.dv().o("Host", "c.tieba.baidu.com");
                }
                fVar.dv().setUrl(str3);
                fVar.dv().setMethod(HttpMessageTask.HTTP_METHOD.POST);
                a2 = d.a(this.nQ, z);
                if (a2 != null) {
                }
                fVar.dv().d(arrayList3);
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
