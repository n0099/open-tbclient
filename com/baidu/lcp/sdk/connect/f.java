package com.baidu.lcp.sdk.connect;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.imsdk.upload.utils.RequsetNetworkUtils;
import com.baidu.lcp.sdk.a.a;
import com.baidu.lcp.sdk.client.bean.BLCPRequest;
import com.baidu.lcp.sdk.connect.a;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.kwad.sdk.collector.AppStatusRules;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Observable;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public final class f extends Observable {
    private static volatile com.baidu.lcp.sdk.client.b avO = new com.baidu.lcp.sdk.client.b();
    private static volatile f awO = null;
    private C0159f awC;
    private e awD;
    private com.baidu.lcp.sdk.connect.d awG;
    private c awJ;
    private long awK;
    private long awP;
    private Context context;
    private final Map<Integer, Boolean> awu = new TreeMap();
    private AtomicInteger mConnectId = new AtomicInteger(0);
    private int awv = 0;
    private boolean aww = false;
    private volatile LinkedList<com.baidu.lcp.sdk.connect.b> awx = new LinkedList<>();
    private final HashMap<Long, com.baidu.lcp.sdk.connect.b> awy = new LinkedHashMap();
    private final Object mOutputSync = new Object();
    private final Object mSync = new Object();
    private com.baidu.lcp.sdk.pb.f awz = new com.baidu.lcp.sdk.pb.f();
    private Map<Long, com.baidu.lcp.sdk.client.bean.b> awA = new LinkedHashMap();
    private Map<Long, com.baidu.lcp.sdk.client.bean.b> awB = new LinkedHashMap();
    private d awE = new d();
    private boolean mClose = false;
    private AtomicInteger awF = new AtomicInteger(0);
    private int mDelayTimes = -1;
    private g awH = new g();
    public String awL = "";
    public String awM = "";
    public String awN = "";
    private Runnable awQ = new Runnable() { // from class: com.baidu.lcp.sdk.connect.f.2
        @Override // java.lang.Runnable
        public void run() {
            f.this.vP();
        }
    };
    private Runnable awR = new Runnable() { // from class: com.baidu.lcp.sdk.connect.f.3
        @Override // java.lang.Runnable
        public void run() {
            f.this.b(f.this.awz.d(f.this.context, 1L));
        }
    };
    private HandlerThread awI = new HandlerThread("LCP HandlerThread");

    private f(Context context) {
        this.context = context;
        this.awI.start();
        this.awJ = new c(this.awI.getLooper());
    }

    public static synchronized f aD(Context context) {
        f fVar;
        synchronized (f.class) {
            if (awO == null) {
                awO = new f(context.getApplicationContext());
            }
            fVar = awO;
        }
        return fVar;
    }

    public void vM() {
        if (com.baidu.lcp.sdk.d.e.az(this.context)) {
            vN();
            vP();
        }
    }

    private void vN() {
        this.awv = 0;
        this.awF.set(0);
        com.baidu.lcp.sdk.connect.a.vG();
    }

    private synchronized void vO() {
        this.awP = System.currentTimeMillis();
        if (!this.awM.isEmpty() && !this.awN.isEmpty() && com.baidu.lcp.sdk.connect.a.vH()) {
            com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "10N_2", "connecting");
            ab(this.awM, this.awN);
        } else {
            com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "10N_1", "connecting");
            com.baidu.lcp.sdk.d.d.w("SocketTransceiver", "protocolOption  thread :" + Thread.activeCount() + ", cur :" + Thread.currentThread() + "， protocol count :" + this.awv);
            String[] split = com.baidu.lcp.sdk.d.e.k(this.context, this.awv).split(":");
            if (split.length >= 3) {
                String str = TextUtils.isEmpty(split[0]) ? "tcp" : split[0];
                String str2 = split[1];
                String str3 = split[2];
                if (this.awv >= com.baidu.lcp.sdk.d.e.aK(this.context)) {
                    this.awv = 0;
                    com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "10N_1", "connect failed, connectip:" + str2 + ", port:" + str3 + ", protocolType:" + str);
                    com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "protocolOption failed, connectip:" + str2 + ", port:" + str3 + ", protocolType:" + str);
                    this.awG = new com.baidu.lcp.sdk.connect.g(this.context, "tls");
                    this.awM = "lcs.baidu.com";
                    this.awN = "443";
                    ab("lcs.baidu.com", "443");
                } else {
                    if ("quic".equals(str) && !(this.awG instanceof QuicMessageHandler)) {
                        this.awG = new QuicMessageHandler(this.context);
                    } else if ("tcp".equals(str) || ("tls".equals(str) && !(this.awG instanceof com.baidu.lcp.sdk.connect.g))) {
                        this.awG = new com.baidu.lcp.sdk.connect.g(this.context, str);
                    }
                    this.awv++;
                    if (this.awG != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                        com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "type :" + str + ", host :" + str2 + ", port :" + str3);
                        this.awM = str2;
                        this.awN = str3;
                        ab(str2, str3);
                    } else {
                        this.awM = "";
                        this.awN = "";
                        vO();
                    }
                }
            }
        }
    }

    private synchronized void ab(final String str, final String str2) {
        com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "10Y", "DNS begin");
        com.baidu.lcp.sdk.connect.a.aA(this.context).a(str, new a.d() { // from class: com.baidu.lcp.sdk.connect.f.1
            @Override // com.baidu.lcp.sdk.connect.a.d
            public void c(int i, String str3, String str4) {
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "-----try to connect ip:" + str4);
                if (TextUtils.isEmpty(str4)) {
                    str4 = str;
                }
                f.this.awL = str4;
                com.baidu.lcp.sdk.a.d.writeLoginFlag(f.this.context, "14N_0", "socketConnect :" + f.this.awL);
                if (i == 0) {
                    com.baidu.lcp.sdk.c.a.aE(f.this.context).submitForNetWork(new a(str4, str2, Integer.valueOf(f.this.mConnectId.incrementAndGet())));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void vP() {
        if (!RequsetNetworkUtils.isConnected(this.context)) {
            vN();
        } else if (avO.state == 0 || avO.state == -2) {
            com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "connectImpl connect state:" + avO.state);
            com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "17N_2", "connectState is " + avO.state);
        } else {
            com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "10N_0", "connect begin");
            this.awJ.removeCallbacks(this.awQ);
            this.awJ.removeCallbacks(this.awR);
            this.awJ.removeCallbacks(this.awE);
            vO();
        }
    }

    public synchronized void b(BLCPRequest bLCPRequest, com.baidu.lcp.sdk.client.bean.b bVar) {
        if (com.baidu.lcp.sdk.d.e.az(this.context)) {
            com.baidu.lcp.sdk.connect.b bVar2 = new com.baidu.lcp.sdk.connect.b();
            bVar2.serviceId = bLCPRequest.serviceId;
            bVar2.methodId = bLCPRequest.methodId;
            bVar2.awj = bLCPRequest.avV;
            if (bLCPRequest.msgId < 0) {
                bVar2.msgId = System.currentTimeMillis();
            } else {
                bVar2.msgId = bLCPRequest.msgId;
            }
            switch (bLCPRequest.avW) {
                case TIMEOUT_20s:
                    bVar2.awk = 20000L;
                    break;
                case TIMEOUT_30s:
                    bVar2.awk = 30000L;
                    break;
                case TIMEOUT_50s:
                    bVar2.awk = 50000L;
                    break;
                default:
                    bVar2.awk = 5000L;
                    break;
            }
            if (bLCPRequest instanceof com.baidu.lcp.sdk.client.bean.a) {
                bVar2.msgId = (bVar2.serviceId * 10000) + bVar2.methodId;
                a(bVar2.serviceId, bVar2.methodId, bVar2.msgId, true, bVar);
            } else if (bLCPRequest instanceof com.baidu.lcp.sdk.client.bean.c) {
                b(this.awz.a(bVar2, false));
            } else {
                a(bVar2.serviceId, bVar2.methodId, bVar2.msgId, false, bVar);
                b(this.awz.a(bVar2, true));
            }
        }
    }

    private void a(long j, long j2, long j3, boolean z, com.baidu.lcp.sdk.client.bean.b bVar) {
        Long valueOf = Long.valueOf(j3);
        if (z) {
            if (bVar != null) {
                this.awB.put(valueOf, bVar);
            }
        } else {
            this.awA.put(valueOf, bVar);
        }
        com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "isNotify:" + z + ", methodId:" + j2 + ", invoke keys :" + this.awA.keySet().toString() + ", notify keys :" + this.awB.keySet().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(com.baidu.lcp.sdk.connect.b bVar) {
        try {
            synchronized (this.awx) {
                boolean z = false;
                Iterator<com.baidu.lcp.sdk.connect.b> it = this.awx.iterator();
                while (it.hasNext()) {
                    com.baidu.lcp.sdk.connect.b next = it.next();
                    com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "sendMessage queue :" + next.msgId);
                    z = next.awp ? true : z;
                }
                if (bVar.awp) {
                    if (z || avO.state != -1) {
                        com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "sendMessage cur methodId :1, state :" + avO.state);
                    } else {
                        this.awx.addFirst(bVar);
                        this.awx.notifyAll();
                        com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "16Y_2", "send Logig msg");
                    }
                } else if (avO.state == -1) {
                    if (vR()) {
                        if (this.awx.size() <= 0 || !z) {
                            this.awx.addFirst(this.awz.d(this.context, 1L));
                            this.awx.notifyAll();
                            com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "16Y_3", "heart rate and send Logig msg");
                        }
                        if (!bVar.isHeartbeat) {
                            this.awx.add(bVar);
                            this.awx.notifyAll();
                        }
                    } else {
                        if (bVar.isHeartbeat) {
                            vO();
                        }
                        this.awx.add(bVar);
                    }
                } else {
                    this.awx.add(bVar);
                    this.awx.notifyAll();
                }
            }
        } catch (Exception e2) {
            com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "sendMessage Exception :", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.lcp.sdk.connect.b bVar, com.baidu.lcp.sdk.connect.b bVar2, String str) {
        if (bVar.serviceId == 1) {
            a(bVar, str);
        } else if (bVar.serviceId != -1) {
            c(bVar);
        } else if (bVar2 != null) {
            if (bVar2.serviceId == 1) {
                a(bVar2, str);
            } else {
                c(bVar2);
            }
        }
    }

    private void a(com.baidu.lcp.sdk.connect.b bVar, String str) {
        long j = AppStatusRules.DEFAULT_GRANULARITY;
        if (bVar.errorCode == 0) {
            if (bVar.awn > 0) {
                j = bVar.awn;
            }
            if (bVar.methodId == 1) {
                a(j, true, str);
            } else if (bVar.methodId == 2) {
                ac("LCP logout:", str);
                avO.state = bVar.awo;
                setChanged();
                notifyObservers(avO);
                vQ();
            } else if (bVar.methodId == 3) {
                this.awE.aa(j);
            }
        } else if (String.valueOf(bVar.errorCode).startsWith("30") || bVar.errorCode == 1011) {
            com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "login error, then request token, error :" + bVar.errorCode);
            ac("errorCode:" + String.valueOf(bVar.errorCode), str);
            com.baidu.lcp.sdk.d.e.D(this.context, "");
            com.baidu.lcp.sdk.client.c.vD().vF();
        } else if (bVar.errorCode == 1012) {
            com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "login error :" + bVar.errorCode);
        } else if (bVar.errorCode == 1013) {
            a(AppStatusRules.DEFAULT_GRANULARITY, false, str);
        } else {
            avO.state = -1;
            setChanged();
            notifyObservers(avO);
            vQ();
            aT(true);
        }
    }

    private void a(long j, boolean z, String str) {
        try {
            this.awF.set(0);
            avO.state = 0;
            setChanged();
            notifyObservers(avO);
            vQ();
            if (z) {
                this.awJ.setHost(str);
                this.awJ.postDelayed(this.awE, j);
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "ping every 1分钟 ");
                com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "17Y", "login success");
                new a.b(this.context).el("login ok").em(OneKeyLoginSdkCall.k).W(System.currentTimeMillis()).X(System.currentTimeMillis()).Y(0L).en("").Z(501111L).build();
            }
        } catch (Exception e2) {
            com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "handleLcpLoginSuccess Exception :" + e2);
        }
    }

    public void vQ() {
        Intent intent = new Intent();
        intent.putExtra("com.baidu.lcp.sdk.connect.state", avO.state);
        intent.setAction("com.baidu.lcp.sdk.broadcast");
        LocalBroadcastManager.getInstance(this.context).sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, String str) {
        try {
            if (this.awy.size() > 0 && this.awy.containsKey(Long.valueOf(j))) {
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "handle msg timeout!!! " + this.awy.get(Long.valueOf(j)).toString());
                com.baidu.lcp.sdk.connect.b remove = this.awy.remove(Long.valueOf(j));
                if (remove != null) {
                    remove.errorCode = 8004;
                    remove.errorMsg = "socket timeout";
                    a(remove, remove, str);
                }
            }
        } catch (Exception e2) {
            com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "handle msg timeout!!! " + e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j, String str, String str2) {
        try {
            if (this.awy.size() > 0 && this.awy.containsKey(Long.valueOf(j))) {
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "handle msg exception!!! " + this.awy.get(Long.valueOf(j)).toString());
                com.baidu.lcp.sdk.connect.b remove = this.awy.remove(Long.valueOf(j));
                if (remove != null) {
                    remove.errorCode = 8005;
                    remove.errorMsg = "socket exception :" + str;
                    a(remove, remove, str2);
                }
            }
        } catch (Exception e2) {
            com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "handle msg exception!!! " + e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j, String str) {
        try {
            if (this.awy.size() > 0 && this.awy.containsKey(Long.valueOf(j))) {
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "handle msg socket stoped!!! " + this.awy.get(Long.valueOf(j)).toString());
                com.baidu.lcp.sdk.connect.b remove = this.awy.remove(Long.valueOf(j));
                if (remove != null) {
                    remove.errorCode = 8006;
                    remove.errorMsg = "socket stopped :";
                    a(remove, remove, str);
                }
            }
        } catch (Exception e2) {
            com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "handle msg socket stoped!!! " + e2);
        }
    }

    private synchronized void c(com.baidu.lcp.sdk.connect.b bVar) {
        com.baidu.lcp.sdk.client.bean.b remove;
        try {
            Long valueOf = Long.valueOf(!bVar.awl ? bVar.msgId : (bVar.serviceId * 10000) + bVar.methodId);
            com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "onBLCPResponse key:" + valueOf + ", msgId :" + bVar.msgId + ", invoke keys :" + this.awA.keySet().toString() + ", notify keys :" + this.awB.keySet().toString());
            if (this.awB.size() > 0 && this.awB.containsKey(valueOf)) {
                remove = this.awB.get(valueOf);
            } else {
                remove = (this.awA.size() <= 0 || !this.awA.containsKey(valueOf)) ? null : this.awA.remove(valueOf);
            }
            if (remove != null) {
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "onBLCPResponse methodId :" + bVar.methodId + ", serviceId :" + bVar.serviceId + ", error :" + bVar.errorCode + ", msgId :" + bVar.msgId + ", errMsg :" + bVar.errorMsg + ", invoke keys :" + this.awA.keySet().toString());
                remove.onResponse(bVar.errorCode, bVar.errorMsg, bVar.serviceId, bVar.methodId, bVar.msgId, bVar.awm);
                if (bVar.errorCode == 1011) {
                    com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "onBLCPResponse errorCode :" + bVar.errorCode + ", and will send lcm login msg .");
                    b(this.awz.d(this.context, 1L));
                }
            }
        } catch (Exception e2) {
            com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "onBLCPResponse Exception!!!", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c extends Handler {
        private String host;

        public c(Looper looper) {
            super(looper);
        }

        public void setHost(String str) {
            this.host = str;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    long j = message.arg1;
                    synchronized (f.this.mSync) {
                        f.this.b(j, this.host);
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d implements Runnable {
        private long awn;

        private d() {
            this.awn = AppStatusRules.DEFAULT_GRANULARITY;
        }

        public void aa(long j) {
            this.awn = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.awJ.removeCallbacks(f.this.awE);
            if (com.baidu.lcp.sdk.d.e.az(f.this.context)) {
                f.this.awJ.postDelayed(f.this.awE, this.awn);
                f.this.b(f.this.awz.d(f.this.context, 3L));
            }
        }
    }

    /* loaded from: classes3.dex */
    private class b implements Runnable {
        Integer awW;
        boolean awY = false;
        String host;

        b(Integer num, String str) {
            this.awW = num;
            this.host = str;
        }

        void vT() {
            this.awY = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (f.this.awu) {
                if (!this.awY && f.avO.state != 0) {
                    f.this.awu.put(this.awW, true);
                    com.baidu.lcp.sdk.a.d.writeLoginFlag(f.this.context, "14N_1", "socketConnect_timeout :" + f.this.awL);
                    f.this.d(401214, "time out", this.host);
                    f.this.ad("time out:", this.host);
                    return;
                }
                com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "ConnectTimeOutTask has stoped");
                f.this.awJ.removeCallbacks(this);
            }
        }
    }

    /* loaded from: classes3.dex */
    final class a implements Runnable {
        private String awV;
        private Integer awW;
        private String host;

        public a(String str, String str2, Integer num) {
            this.host = str;
            this.awV = str2;
            this.awW = num;
        }

        @Override // java.lang.Runnable
        public synchronized void run() {
            try {
                if (!f.this.vR()) {
                    if (f.this.awD != null && f.this.awD.isAlive()) {
                        f.this.awD.interrupt();
                        com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "readThread interrupt");
                    }
                    if (f.this.awC != null && f.this.awC.isAlive()) {
                        f.this.awC.interrupt();
                        com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "sendThread interrupt");
                    }
                    b bVar = new b(this.awW, this.host);
                    f.this.awJ.setHost(this.host);
                    f.this.awJ.postDelayed(bVar, 5000L);
                    try {
                        com.baidu.lcp.sdk.a.d.writeLoginFlag(f.this.context, "14N", "socketConnect :" + f.this.awL);
                        com.baidu.lcp.sdk.connect.e y = f.this.awG.y(this.host, Integer.valueOf(this.awV).intValue());
                        if (f.this.vR()) {
                            com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "socketConnect after, but socket has created ok.");
                            f.this.b(y);
                        } else if (!y.awt.booleanValue()) {
                            com.baidu.lcp.sdk.a.d.writeLoginFlag(f.this.context, "15N", "connect env error");
                            f.this.d(401213, "connect env error", this.host);
                            f.this.awJ.removeCallbacks(bVar);
                            f.this.ac("connect env error:", this.host);
                        } else {
                            synchronized (f.this.awu) {
                                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "socketNeedCloseMap remove connectTimeoutTask");
                                f.this.awJ.removeCallbacks(bVar);
                                bVar.vT();
                                if (!f.this.vR()) {
                                    if (f.this.awu.get(this.awW) == null) {
                                        com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "socketNeedCloseMap setCurrentSocketState");
                                        f.this.awG.a(y);
                                    }
                                    com.baidu.lcp.sdk.d.e.m(f.this.context, f.this.awF.get() == 0 ? 1 : 2);
                                    com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "create Socket ok");
                                    f.this.d(401211, "connect ok", this.host);
                                    com.baidu.lcp.sdk.a.d.writeLoginFlag(f.this.context, "16Y", "connect ok");
                                    com.baidu.lcp.sdk.connect.a.C(f.this.context, this.host);
                                    f.this.b(f.this.awz.d(f.this.context, 1L));
                                    f.this.awK = SystemClock.currentThreadTimeMillis();
                                    if (com.baidu.lcp.sdk.d.b.aH(f.this.context) != 0) {
                                        com.baidu.lcp.sdk.c.a.aE(f.this.context).submitForNetWork(new Runnable() { // from class: com.baidu.lcp.sdk.connect.f.a.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                com.baidu.lcp.sdk.d.c.aI(f.this.context);
                                                com.baidu.lcp.sdk.d.c.write("lcp connect:" + (System.currentTimeMillis() - f.this.awP));
                                            }
                                        });
                                    }
                                    com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "connectImpl time:" + f.this.awK);
                                    f.avO.state = -2;
                                    f.this.mClose = false;
                                    f.this.awC = new C0159f(this.host);
                                    f.this.awC.start();
                                    f.this.awD = new e(this.host);
                                    f.this.awD.start();
                                } else {
                                    com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "socketNeedCloseMap but socket has created ok.");
                                    f.this.b(y);
                                }
                            }
                        }
                    } finally {
                    }
                } else {
                    com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "socket create begin, but socket has created ok.");
                }
            } catch (Exception e) {
                com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "connectRunnable", e);
                com.baidu.lcp.sdk.a.d.writeLoginFlag(f.this.context, "16N", "connect exception");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean vR() {
        return (this.awG == null || this.awG.vL() == null || this.awG.vL().socket == null || !this.awG.vL().socket.isConnected()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.lcp.sdk.connect.e eVar) {
        if (eVar != null && eVar.aws.booleanValue()) {
            try {
                if (eVar.socket != null) {
                    if (eVar.socket.hashCode() == this.awG.vL().socket.hashCode()) {
                        com.baidu.lcp.sdk.d.d.v("SocketTransceiver", "closeExistedConnection  state.socket.hashCode() is same to cur socket!!!");
                        return;
                    }
                    eVar.socket.close();
                    eVar.socket = null;
                    if (eVar.inputStream != null) {
                        eVar.inputStream.close();
                        eVar.inputStream = null;
                    }
                    if (eVar.outputStream != null) {
                        eVar.outputStream.close();
                        eVar.outputStream = null;
                    }
                    com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "closeExistedConnection ok");
                }
            } catch (IOException e2) {
                com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "closeExistedConnection :" + e2.getMessage(), e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i, String str, String str2) {
        this.awL += ":" + com.baidu.lcp.sdk.connect.a.vI() + ":" + RequsetNetworkUtils.getNetInfo(this.context);
        com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "connectTrack ext:" + this.awL + ", retry :" + this.awF.get() + ", reason :" + str);
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        new a.C0155a(this.context).S(this.awK).T(System.currentTimeMillis()).V(i).ej(str).ek(str2).U(this.awF.get()).build();
        if (com.baidu.lcp.sdk.a.d.i(this.context, 401216) && this.awF.get() >= 5 && i != 401211) {
            com.baidu.lcp.sdk.a.b.a(this.context, IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.CONNECTION).setConnection(IMPushPb.Connection.newBuilder().setStartTime(this.awK).setStopTime(System.currentTimeMillis()).setAliasId(401216L).setReason(str).setExt(str2).setRetryCount(this.awF.get()).build()).build());
        }
        this.awL = "";
    }

    /* loaded from: classes3.dex */
    class e extends Thread {
        private String host;

        e(String str) {
            this.host = str;
            setName("LCP-SocketTransceiver-readThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            com.baidu.lcp.sdk.connect.b bVar;
            while (!f.this.mClose) {
                try {
                    try {
                        com.baidu.lcp.sdk.connect.b h = f.this.awz.h(f.this.awG.vK());
                        if (h != null && h.msgId > 0) {
                            f.this.awJ.removeCallbacks(f.this.awH);
                            h.awq = false;
                            com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "ReadThread :" + h.toString());
                            if (!h.isHeartbeat) {
                                if (h.awp) {
                                    com.baidu.lcp.sdk.a.d.writeLoginFlag(f.this.context, "17N_1", "Read LoginMsg Response");
                                }
                                if (h.methodId == 1 && h.serviceId == 4) {
                                    com.baidu.lcp.sdk.d.a.a(f.this.context, 1L, "read", h.msgId + "");
                                }
                                if (h.methodId == 50 && h.serviceId == 2) {
                                    com.baidu.lcp.sdk.d.a.a(f.this.context, 50L, "read", h.msgId + "");
                                }
                                synchronized (f.this.mSync) {
                                    com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "ReadThread handleResponseMessage...");
                                    bVar = (com.baidu.lcp.sdk.connect.b) f.this.awy.remove(Long.valueOf(h.msgId));
                                }
                                f.this.a(h, bVar, this.host);
                            }
                            synchronized (f.this.mSync) {
                                if (f.this.awy.size() != 0) {
                                    com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "ReadThread socketTimeoutRunnable ...");
                                    f.this.awH.setMsgId(h.msgId);
                                    f.this.awH.setHost(this.host);
                                    f.this.awJ.setHost(this.host);
                                    f.this.awJ.postDelayed(f.this.awH, h.awk);
                                }
                            }
                        }
                    } catch (Exception e) {
                        if (!f.this.mClose) {
                            com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "ReadThread exception: " + e, e);
                            f.this.aww = false;
                            f.this.ad("ReadThread exception: " + e, this.host);
                            return;
                        }
                        return;
                    }
                } catch (Exception e2) {
                    if (!f.this.mClose) {
                        com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "onStartCommand", e2);
                        f.this.aww = false;
                        f.this.ad("onStartCommand:" + e2, this.host);
                        return;
                    }
                    return;
                }
            }
        }
    }

    /* renamed from: com.baidu.lcp.sdk.connect.f$f  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0159f extends Thread {
        private String host;

        C0159f(String str) {
            this.host = str;
            setName("LCP-SocketTransceiver-SendThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!f.this.mClose) {
                try {
                    com.baidu.lcp.sdk.connect.b bVar = null;
                    try {
                        synchronized (f.this.awx) {
                            if (f.this.awx.size() == 0) {
                                f.this.awx.wait();
                            } else {
                                bVar = (com.baidu.lcp.sdk.connect.b) f.this.awx.removeFirst();
                            }
                        }
                    } catch (InterruptedException e) {
                        com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "SendThread wait exception: " + e);
                        f.this.ad("SendThread wait exception: " + e, this.host);
                    }
                    if (bVar != null) {
                        try {
                            if (f.this.mClose) {
                                f.this.c(bVar.msgId, this.host);
                                return;
                            }
                            bVar.awq = true;
                            bVar.awo = f.avO.state;
                            if (bVar.needReplay) {
                                synchronized (f.this.mSync) {
                                    if (f.this.awy.isEmpty()) {
                                        f.this.awJ.removeCallbacks(f.this.awH);
                                        f.this.awH.setMsgId(bVar.msgId);
                                        f.this.awH.setHost(this.host);
                                        f.this.awJ.setHost(this.host);
                                        f.this.awJ.postDelayed(f.this.awH, 5000L);
                                    }
                                }
                            }
                            com.baidu.lcp.sdk.d.d.v("SocketTransceiver", "SendThread :" + bVar.toString());
                            if (bVar.awp) {
                                com.baidu.lcp.sdk.a.d.writeLoginFlag(f.this.context, "17N", "Send LoginMsg request");
                            }
                            if (bVar.methodId == 1 && bVar.serviceId == 4) {
                                com.baidu.lcp.sdk.d.a.a(f.this.context, 1L, UbcStatConstant.ContentType.UBC_TYPE_IM_SEND, bVar.msgId + "");
                            }
                            if (bVar.methodId == 50 && bVar.serviceId == 2) {
                                com.baidu.lcp.sdk.d.a.a(f.this.context, 50L, UbcStatConstant.ContentType.UBC_TYPE_IM_SEND, bVar.msgId + "");
                            }
                            synchronized (f.this.mOutputSync) {
                                f.this.awG.a(bVar);
                            }
                            if (!bVar.isHeartbeat && bVar.needReplay) {
                                synchronized (f.this.mSync) {
                                    f.this.awy.put(Long.valueOf(bVar.msgId), bVar);
                                }
                            }
                        } catch (Exception e2) {
                            com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "SendThread sendMessage Exception:", e2);
                            f.this.c(bVar.msgId, e2.toString(), this.host);
                            f.this.ad("SendThread sendMessage Exception:" + e2, this.host);
                            return;
                        }
                    }
                } catch (Exception e3) {
                    com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "SendThread Exception:", e3);
                    f.this.ad("SendThread Exception:" + e3, this.host);
                    return;
                }
            }
        }
    }

    private void ep(String str) {
        try {
            com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "fatalAllMessage begin ");
            synchronized (this.awx) {
                while (this.awx.size() > 0) {
                    b(this.awx.removeFirst(), str);
                }
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "fatalAllMessage sendQueue end ");
            }
            synchronized (this.mSync) {
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "fatalAllMessage mSync begin");
                for (Long l : this.awy.keySet()) {
                    b(this.awy.get(l), str);
                }
                this.awy.clear();
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "fatalAllMessage mSync end");
            }
        } catch (Exception e2) {
            com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "fatalAllMessage Exception", e2);
        }
    }

    private void b(com.baidu.lcp.sdk.connect.b bVar, String str) {
        if (bVar != null && bVar.serviceId != 1) {
            com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "fetalAndClearAllMsgs :" + bVar.msgId + ", serviceId :" + bVar.serviceId + ", methodId :" + bVar.methodId);
            a(new com.baidu.lcp.sdk.connect.b(), bVar, str);
        }
    }

    public synchronized void ac(String str, String str2) {
        if (com.baidu.lcp.sdk.d.e.az(this.context)) {
            com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "---socketDisconnect---");
            this.mClose = true;
            this.aww = true;
            ep(str2);
            vN();
            this.awJ.removeCallbacks(this.awQ);
            this.awJ.removeCallbacks(this.awR);
            this.awJ.removeCallbacks(this.awE);
            com.baidu.lcp.sdk.connect.a.e(this.context, null, false);
            af(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ad(String str, String str2) {
        com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "disconnectedByLcp, destroyConnection = " + this.aww + ", net :" + RequsetNetworkUtils.isConnected(this.context) + ", isSmallFlow :" + com.baidu.lcp.sdk.d.e.az(this.context));
        if (com.baidu.lcp.sdk.d.e.az(this.context)) {
            ep(str2);
            if (this.aww) {
                vN();
            } else {
                af(str, str2);
                if (!RequsetNetworkUtils.isConnected(this.context)) {
                    vN();
                } else {
                    aT(false);
                }
            }
        }
    }

    private void aT(boolean z) {
        try {
            this.awF.incrementAndGet();
            if (this.awF.get() <= 10 && avO.state == -1) {
                long bQ = bQ(this.awF.get());
                this.awJ.removeCallbacks(this.awE);
                this.awJ.removeCallbacks(z ? this.awQ : this.awR);
                this.awJ.postDelayed(z ? this.awR : this.awQ, bQ);
                com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "Schedule retry " + (z ? OneKeyLoginSdkCall.k : "connect") + " -- retry times: " + this.awF.get() + " time delay: " + bQ);
            }
        } catch (Exception e2) {
            com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "retry Exception", e2);
        }
    }

    private long bQ(int i) {
        if (i < 3) {
            return i * 1000;
        }
        return IMConnection.RETRY_DELAY_TIMES;
    }

    private synchronized void af(String str, String str2) {
        if (com.baidu.lcp.sdk.d.e.az(this.context)) {
            com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "destroy");
            d(401212, "connect stop, " + str, str2);
            avO.state = -1;
            setChanged();
            notifyObservers(avO);
            vQ();
            this.awJ.removeCallbacks(this.awH);
            this.mClose = true;
            if (this.awG != null) {
                synchronized (this.awx) {
                    this.awx.notifyAll();
                    com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "destroy notifyAll");
                }
                try {
                    this.awG.socketClose();
                    com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "destroy socketClose ok");
                } catch (Exception e2) {
                    this.awG.a((com.baidu.lcp.sdk.connect.e) null);
                    com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "Exception destroy:", e2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class g implements Runnable {
        private String host;
        private long msgId;

        private g() {
        }

        public void setMsgId(long j) {
            this.msgId = j;
        }

        public void setHost(String str) {
            this.host = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.b(this.msgId, this.host);
            f.this.ad("read and write thread timeout:", this.host);
        }
    }

    public void pingRequest() {
        com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "customPingRunnable send PingRequest ");
        b(this.awz.d(this.context, 3L));
    }
}
