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
    private static b xP = null;
    private f xQ;
    private String xR;
    private a xS;
    private CustomMessageListener xT = new c(this, 2000994);

    public static b iD() {
        if (xP == null) {
            synchronized (b.class) {
                if (xP == null) {
                    xP = new b();
                }
            }
        }
        return xP;
    }

    public void a(f fVar, String str) {
        this.xR = str;
        this.xQ = fVar;
        if (this.xQ != null) {
            this.xQ.wX = Build.MODEL;
            this.xQ.xc = Build.VERSION.RELEASE;
            this.xQ.mNetType = g.w(BdBaseApplication.getInst());
            this.xQ.xb = g.v(BdBaseApplication.getInst());
        }
        try {
            MessageManager.getInstance().registerListener(this.xT);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.xS == null) {
            this.xS = new a(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
            BdBaseApplication.getInst().registerReceiver(this.xS, intentFilter);
        }
    }

    public void f(String str, String str2, String str3) {
        if (this.xQ.wY != null || str != null) {
            if (this.xQ.wY == null || !this.xQ.wY.equals(str)) {
                this.xQ.wY = str;
                this.xQ.wZ = str2;
                this.xQ.xa = str3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iE() {
        this.xQ.mNetType = g.w(BdBaseApplication.getInst());
        this.xQ.xb = g.v(BdBaseApplication.getInst());
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
        if (com.baidu.adp.lib.stats.a.hz().hG() && aVar != null) {
            ArrayList<String> az = com.baidu.adp.lib.stats.switchs.a.ix().az(aVar.io());
            if (!z) {
                boolean onlyWifiUpload = com.baidu.adp.lib.stats.switchs.a.ix().onlyWifiUpload(aVar.io(), null);
                boolean jg = i.jg();
                if (!onlyWifiUpload || jg) {
                    if (az != null && az.size() > 0) {
                        ArrayList<String> arrayList3 = new ArrayList<>();
                        Iterator<String> it = az.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (!com.baidu.adp.lib.stats.switchs.a.ix().isUpload(aVar.io(), next)) {
                                b(arrayList3, next);
                            } else if (!com.baidu.adp.lib.stats.switchs.a.ix().smallFlowUpload(aVar.io(), next)) {
                                b(arrayList3, next);
                            } else {
                                boolean onlyWifiUpload2 = com.baidu.adp.lib.stats.switchs.a.ix().onlyWifiUpload(aVar.io(), next);
                                boolean jg2 = i.jg();
                                if (onlyWifiUpload2 && !jg2) {
                                    b(arrayList3, next);
                                }
                            }
                        }
                        arrayList = arrayList3;
                        if (aVar.ip()) {
                            aVar.C(true);
                            if (arrayList == null || arrayList.size() <= 0) {
                                arrayList2 = null;
                            } else {
                                ArrayList arrayList4 = new ArrayList();
                                Iterator<String> it2 = arrayList.iterator();
                                while (it2.hasNext()) {
                                    try {
                                        arrayList4.add("st=" + URLEncoder.encode(com.baidu.adp.lib.stats.d.at(it2.next()), "utf-8") + "&");
                                    } catch (UnsupportedEncodingException e) {
                                        e.printStackTrace();
                                    }
                                }
                                arrayList2 = arrayList4;
                            }
                            new C0009b(aVar, arrayList2, z, z2, z3).execute(new Object[0]);
                            return;
                        }
                        return;
                    }
                } else {
                    return;
                }
            }
            arrayList = null;
            if (aVar.ip()) {
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

    /* renamed from: com.baidu.adp.lib.stats.upload.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0009b extends BdAsyncTask<Object, Integer, Void> {
        private com.baidu.adp.lib.stats.base.a xU;
        private ArrayList<String> xV;
        private boolean xW;
        private boolean xX;
        private boolean xY;

        public C0009b(com.baidu.adp.lib.stats.base.a aVar, ArrayList<String> arrayList, boolean z, boolean z2, boolean z3) {
            this.xU = null;
            this.xV = null;
            this.xW = false;
            this.xX = false;
            this.xY = false;
            this.xU = aVar;
            this.xV = arrayList;
            this.xW = z;
            this.xX = z2;
            this.xY = z3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            b(this.xU, this.xW, this.xX, this.xY);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r3) {
            this.xU.C(false);
        }

        private void b(com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2, boolean z3) {
            int i;
            try {
                String a = d.a(aVar, b.this.xQ);
                BdUploadingLogInfo a2 = com.baidu.adp.lib.stats.upload.a.a(aVar, z2);
                int size = a2.size();
                if (a2 != null && size > 0) {
                    if (!z) {
                        for (int i2 = 0; i2 < size; i2++) {
                            ArrayList<String> logStringByIndex = a2.getLogStringByIndex(i2, this.xV);
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
                        ArrayList<String> logStringByIndex2 = a2.getLogStringByIndex(i5, this.xV);
                        if (logStringByIndex2 != null && logStringByIndex2.size() != 0) {
                            if (i.jg()) {
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
        if (a(this.xR, aVar, str, arrayList, arrayList2, z, false) != null && i.jf()) {
            String a2 = a(this.xR, aVar, str, arrayList, arrayList2, z, true);
            if (a2 == null) {
                com.baidu.adp.lib.stats.d as = com.baidu.adp.lib.stats.a.hz().as("dbg");
                as.r("issuc", "true");
                com.baidu.adp.lib.stats.a.hz().b("STAT_UPLOAD_USEIP", as);
                return;
            }
            com.baidu.adp.lib.stats.d as2 = com.baidu.adp.lib.stats.a.hz().as("dbg");
            as2.r("issuc", "false");
            as2.r("reason", a2);
            com.baidu.adp.lib.stats.a.hz().b("STAT_UPLOAD_USEIP", as2);
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
        List<e> hi;
        StringBuilder sb;
        int i;
        int i2;
        if (str != null && aVar != null && (b = b(str2, arrayList)) != null && b.length > 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(b.length / 2);
            try {
                com.baidu.adp.lib.util.f.a(b, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                HashMap hashMap = new HashMap();
                hashMap.put(aVar.iq(), byteArray);
                ArrayList arrayList3 = new ArrayList(hashMap.entrySet());
                try {
                    if (aVar != null) {
                        try {
                            if (aVar.io().equals("pfmonitor") && BdStatisticsSwitchStatic.hO()) {
                                str3 = "http://nlog.baidu.com/dplog/n";
                                fVar = new com.baidu.adp.lib.network.http.f();
                                if (z2 && str3.contains("c.tieba.baidu.com")) {
                                    str3 = str3.replace("c.tieba.baidu.com", "123.125.115.120");
                                    fVar.hg().q("Host", "c.tieba.baidu.com");
                                }
                                fVar.hg().setUrl(str3);
                                fVar.hg().setMethod(HttpMessageTask.HTTP_METHOD.POST);
                                a2 = d.a(this.xQ, z);
                                if (a2 != null) {
                                    fVar.hg().d(new ArrayList(a2.entrySet()));
                                }
                                fVar.hg().d(arrayList3);
                                new com.baidu.adp.lib.network.http.d(fVar).g(3, -1, -1);
                                int i3 = fVar.hh().responseCode;
                                bArr = fVar.hh().vN;
                                if (bArr != null && i3 == 200) {
                                    try {
                                        if (new JSONObject(new String(bArr, "utf-8")).optInt(SocialConstants.PARAM_ERROR_CODE, -1) == 0) {
                                            b(arrayList2, aVar.it());
                                            return null;
                                        }
                                    } catch (Exception e) {
                                        BdLog.e(e);
                                        return e.getMessage();
                                    }
                                }
                                hi = fVar.hi();
                                if (hi != null && hi.size() > 0) {
                                    sb = new StringBuilder();
                                    i = 0;
                                    while (true) {
                                        i2 = i;
                                        if (i2 < hi.size()) {
                                            break;
                                        }
                                        e eVar = hi.get(i2);
                                        if (eVar != null && !TextUtils.isEmpty(eVar.vw)) {
                                            if (sb.length() > 0) {
                                                sb.append(",");
                                            }
                                            sb.append(eVar.vw);
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
                    int i32 = fVar.hh().responseCode;
                    bArr = fVar.hh().vN;
                    if (bArr != null) {
                        if (new JSONObject(new String(bArr, "utf-8")).optInt(SocialConstants.PARAM_ERROR_CODE, -1) == 0) {
                        }
                    }
                    hi = fVar.hi();
                    if (hi != null) {
                        sb = new StringBuilder();
                        i = 0;
                        while (true) {
                            i2 = i;
                            if (i2 < hi.size()) {
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
                    fVar.hg().q("Host", "c.tieba.baidu.com");
                }
                fVar.hg().setUrl(str3);
                fVar.hg().setMethod(HttpMessageTask.HTTP_METHOD.POST);
                a2 = d.a(this.xQ, z);
                if (a2 != null) {
                }
                fVar.hg().d(arrayList3);
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
