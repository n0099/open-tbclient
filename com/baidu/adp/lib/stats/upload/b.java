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
    private static b qN = null;
    private f qO;
    private String qP;
    private a qQ;
    private CustomMessageListener qR = new com.baidu.adp.lib.stats.upload.c(this, 2000994);

    public static b fJ() {
        if (qN == null) {
            synchronized (b.class) {
                if (qN == null) {
                    qN = new b();
                }
            }
        }
        return qN;
    }

    public void a(f fVar, String str) {
        this.qP = str;
        this.qO = fVar;
        if (this.qO != null) {
            this.qO.pW = Build.MODEL;
            this.qO.qa = Build.VERSION.RELEASE;
            this.qO.mNetType = g.F(BdBaseApplication.getInst());
            this.qO.pZ = String.valueOf(i.gs());
        }
        try {
            MessageManager.getInstance().registerListener(this.qR);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.qQ == null) {
            this.qQ = new a(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
            BdBaseApplication.getInst().registerReceiver(this.qQ, intentFilter);
        }
    }

    public void k(String str, String str2, String str3) {
        if (this.qO.mUid != null || str != null) {
            if (this.qO.mUid == null || !this.qO.mUid.equals(str)) {
                this.qO.mUid = str;
                this.qO.pX = str2;
                this.qO.pY = str3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fK() {
        this.qO.mNetType = g.F(BdBaseApplication.getInst());
        this.qO.pZ = String.valueOf(i.gs());
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
        private com.baidu.adp.lib.stats.base.a qS;
        private String qT;

        public C0009b(com.baidu.adp.lib.stats.base.a aVar, String str) {
            this.qS = aVar;
            this.qT = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            String a = d.a(this.qS, b.this.qO);
            String str = this.qT;
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            BdLog.i("commonHeader = " + a);
            BdLog.i("cache = " + str);
            this.qS.fs();
            b.this.a(this.qS, a, arrayList, null, true);
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
        if (com.baidu.adp.lib.stats.a.eI().eP() && aVar != null) {
            ArrayList<String> av = com.baidu.adp.lib.stats.switchs.a.fD().av(aVar.fu());
            if (!z) {
                boolean onlyWifiUpload = com.baidu.adp.lib.stats.switchs.a.fD().onlyWifiUpload(aVar.fu(), null);
                boolean gn = i.gn();
                if (!onlyWifiUpload || gn) {
                    if (av != null && av.size() > 0) {
                        ArrayList<String> arrayList3 = new ArrayList<>();
                        Iterator<String> it = av.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (!com.baidu.adp.lib.stats.switchs.a.fD().isUpload(aVar.fu(), next)) {
                                b(arrayList3, next);
                            } else if (!com.baidu.adp.lib.stats.switchs.a.fD().smallFlowUpload(aVar.fu(), next)) {
                                b(arrayList3, next);
                            } else {
                                boolean onlyWifiUpload2 = com.baidu.adp.lib.stats.switchs.a.fD().onlyWifiUpload(aVar.fu(), next);
                                boolean gn2 = i.gn();
                                if (onlyWifiUpload2 && !gn2) {
                                    b(arrayList3, next);
                                }
                            }
                        }
                        arrayList = arrayList3;
                        if (aVar.fv()) {
                            aVar.G(true);
                            if (arrayList == null || arrayList.size() <= 0) {
                                arrayList2 = null;
                            } else {
                                ArrayList arrayList4 = new ArrayList();
                                Iterator<String> it2 = arrayList.iterator();
                                while (it2.hasNext()) {
                                    try {
                                        arrayList4.add("st=" + URLEncoder.encode(com.baidu.adp.lib.stats.d.ap(it2.next()), "utf-8") + "&");
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
            if (aVar.fv()) {
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
        private com.baidu.adp.lib.stats.base.a qU;
        private ArrayList<String> qV;
        private boolean qW;
        private boolean qX;
        private boolean qY;

        public c(com.baidu.adp.lib.stats.base.a aVar, ArrayList<String> arrayList, boolean z, boolean z2, boolean z3) {
            this.qU = null;
            this.qV = null;
            this.qW = false;
            this.qX = false;
            this.qY = false;
            this.qU = aVar;
            this.qV = arrayList;
            this.qW = z;
            this.qX = z2;
            this.qY = z3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            b(this.qU, this.qW, this.qX, this.qY);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r3) {
            this.qU.G(false);
        }

        private void b(com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2, boolean z3) {
            int i;
            try {
                String a = d.a(aVar, b.this.qO);
                BdUploadingLogInfo a2 = com.baidu.adp.lib.stats.upload.a.a(aVar, z2);
                int size = a2.size();
                if (a2 != null && size > 0) {
                    if (!z) {
                        for (int i2 = 0; i2 < size; i2++) {
                            ArrayList<String> logStringByIndex = a2.getLogStringByIndex(i2, this.qV);
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
                        ArrayList<String> logStringByIndex2 = a2.getLogStringByIndex(i5, this.qV);
                        if (logStringByIndex2 != null && logStringByIndex2.size() != 0) {
                            if (i.gn()) {
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
        if (a(this.qP, aVar, str, arrayList, arrayList2, z, false) != null && i.gm()) {
            String a2 = a(this.qP, aVar, str, arrayList, arrayList2, z, true);
            if (a2 == null) {
                com.baidu.adp.lib.stats.d ao = com.baidu.adp.lib.stats.a.eI().ao("dbg");
                ao.q("issuc", "true");
                com.baidu.adp.lib.stats.a.eI().b("STAT_UPLOAD_USEIP", ao);
                return;
            }
            com.baidu.adp.lib.stats.d ao2 = com.baidu.adp.lib.stats.a.eI().ao("dbg");
            ao2.q("issuc", "false");
            ao2.q("reason", a2);
            com.baidu.adp.lib.stats.a.eI().b("STAT_UPLOAD_USEIP", ao2);
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
        List<e> er;
        StringBuilder sb;
        int i;
        int i2;
        if (str != null && aVar != null && (b = b(str2, arrayList)) != null && b.length > 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(b.length / 2);
            try {
                com.baidu.adp.lib.util.f.b(b, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                HashMap hashMap = new HashMap();
                hashMap.put(aVar.fw(), byteArray);
                ArrayList arrayList3 = new ArrayList(hashMap.entrySet());
                try {
                    if (aVar != null) {
                        try {
                            if (aVar.fu().equals("pfmonitor") && BdStatisticsSwitchStatic.eX()) {
                                str3 = "http://nlog.baidu.com/dplog/n";
                                fVar = new com.baidu.adp.lib.network.http.f();
                                if (z2 && str3.contains("c.tieba.baidu.com")) {
                                    str3 = str3.replace("c.tieba.baidu.com", "123.125.115.120");
                                    fVar.ep().o("Host", "c.tieba.baidu.com");
                                }
                                fVar.ep().setUrl(str3);
                                fVar.ep().setMethod(HttpMessageTask.HTTP_METHOD.POST);
                                a2 = d.a(this.qO, z);
                                if (a2 != null) {
                                    fVar.ep().d(new ArrayList(a2.entrySet()));
                                }
                                fVar.ep().d(arrayList3);
                                new com.baidu.adp.lib.network.http.d(fVar).g(3, -1, -1);
                                int i3 = fVar.eq().responseCode;
                                bArr = fVar.eq().oH;
                                if (bArr != null && i3 == 200) {
                                    try {
                                        if (new JSONObject(new String(bArr, "utf-8")).optInt(SocialConstants.PARAM_ERROR_CODE, -1) == 0) {
                                            b(arrayList2, aVar.fz());
                                            return null;
                                        }
                                    } catch (Exception e) {
                                        BdLog.e(e);
                                        return e.getMessage();
                                    }
                                }
                                er = fVar.er();
                                if (er != null && er.size() > 0) {
                                    sb = new StringBuilder();
                                    i = 0;
                                    while (true) {
                                        i2 = i;
                                        if (i2 < er.size()) {
                                            break;
                                        }
                                        e eVar = er.get(i2);
                                        if (eVar != null && !TextUtils.isEmpty(eVar.ol)) {
                                            if (sb.length() > 0) {
                                                sb.append(",");
                                            }
                                            sb.append(eVar.ol);
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
                    new com.baidu.adp.lib.network.http.d(fVar).g(3, -1, -1);
                    int i32 = fVar.eq().responseCode;
                    bArr = fVar.eq().oH;
                    if (bArr != null) {
                        if (new JSONObject(new String(bArr, "utf-8")).optInt(SocialConstants.PARAM_ERROR_CODE, -1) == 0) {
                        }
                    }
                    er = fVar.er();
                    if (er != null) {
                        sb = new StringBuilder();
                        i = 0;
                        while (true) {
                            i2 = i;
                            if (i2 < er.size()) {
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
                    fVar.ep().o("Host", "c.tieba.baidu.com");
                }
                fVar.ep().setUrl(str3);
                fVar.ep().setMethod(HttpMessageTask.HTTP_METHOD.POST);
                a2 = d.a(this.qO, z);
                if (a2 != null) {
                }
                fVar.ep().d(arrayList3);
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
