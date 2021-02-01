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
    private static volatile com.baidu.lcp.sdk.client.b auo = new com.baidu.lcp.sdk.client.b();
    private static volatile f avo = null;
    private C0153f avc;
    private e avd;
    private com.baidu.lcp.sdk.connect.d avg;
    private c avj;
    private long avk;
    private long avp;
    private Context context;
    private final Map<Integer, Boolean> auU = new TreeMap();
    private AtomicInteger mConnectId = new AtomicInteger(0);
    private int auV = 0;
    private boolean auW = false;
    private volatile LinkedList<com.baidu.lcp.sdk.connect.b> auX = new LinkedList<>();
    private final HashMap<Long, com.baidu.lcp.sdk.connect.b> auY = new LinkedHashMap();
    private final Object mOutputSync = new Object();
    private final Object mSync = new Object();
    private com.baidu.lcp.sdk.pb.f auZ = new com.baidu.lcp.sdk.pb.f();
    private Map<Long, com.baidu.lcp.sdk.client.bean.b> ava = new LinkedHashMap();
    private Map<Long, com.baidu.lcp.sdk.client.bean.b> avb = new LinkedHashMap();
    private d ave = new d();
    private boolean mClose = false;
    private AtomicInteger avf = new AtomicInteger(0);
    private int mDelayTimes = -1;
    private g avh = new g();
    public String avl = "";
    public String avm = "";
    public String avn = "";
    private Runnable avq = new Runnable() { // from class: com.baidu.lcp.sdk.connect.f.2
        @Override // java.lang.Runnable
        public void run() {
            f.this.vM();
        }
    };
    private Runnable avr = new Runnable() { // from class: com.baidu.lcp.sdk.connect.f.3
        @Override // java.lang.Runnable
        public void run() {
            f.this.b(f.this.auZ.f(f.this.context, 1L));
        }
    };
    private HandlerThread avi = new HandlerThread("LCP HandlerThread");

    private f(Context context) {
        this.context = context;
        this.avi.start();
        this.avj = new c(this.avi.getLooper());
    }

    public static synchronized f aE(Context context) {
        f fVar;
        synchronized (f.class) {
            if (avo == null) {
                avo = new f(context.getApplicationContext());
            }
            fVar = avo;
        }
        return fVar;
    }

    public void vJ() {
        if (com.baidu.lcp.sdk.d.e.aA(this.context)) {
            vK();
            vM();
        }
    }

    private void vK() {
        this.auV = 0;
        this.avf.set(0);
        com.baidu.lcp.sdk.connect.a.vD();
    }

    private synchronized void vL() {
        this.avp = System.currentTimeMillis();
        if (!this.avm.isEmpty() && !this.avn.isEmpty() && com.baidu.lcp.sdk.connect.a.vE()) {
            com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "10N_2", "connecting");
            ab(this.avm, this.avn);
        } else {
            com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "10N_1", "connecting");
            com.baidu.lcp.sdk.d.d.w("SocketTransceiver", "protocolOption  thread :" + Thread.activeCount() + ", cur :" + Thread.currentThread() + "， protocol count :" + this.auV);
            String[] split = com.baidu.lcp.sdk.d.e.k(this.context, this.auV).split(":");
            if (split.length >= 3) {
                String str = TextUtils.isEmpty(split[0]) ? "tcp" : split[0];
                String str2 = split[1];
                String str3 = split[2];
                if (this.auV >= com.baidu.lcp.sdk.d.e.aL(this.context)) {
                    this.auV = 0;
                    com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "10N_1", "connect failed, connectip:" + str2 + ", port:" + str3 + ", protocolType:" + str);
                    com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "protocolOption failed, connectip:" + str2 + ", port:" + str3 + ", protocolType:" + str);
                    this.avg = new com.baidu.lcp.sdk.connect.g(this.context, "tls");
                    this.avm = "lcs.baidu.com";
                    this.avn = "443";
                    ab("lcs.baidu.com", "443");
                } else {
                    if ("quic".equals(str) && !(this.avg instanceof QuicMessageHandler)) {
                        this.avg = new QuicMessageHandler(this.context);
                    } else if ("tcp".equals(str) || ("tls".equals(str) && !(this.avg instanceof com.baidu.lcp.sdk.connect.g))) {
                        this.avg = new com.baidu.lcp.sdk.connect.g(this.context, str);
                    }
                    this.auV++;
                    if (this.avg != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                        com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "type :" + str + ", host :" + str2 + ", port :" + str3);
                        this.avm = str2;
                        this.avn = str3;
                        ab(str2, str3);
                    } else {
                        this.avm = "";
                        this.avn = "";
                        vL();
                    }
                }
            }
        }
    }

    private synchronized void ab(final String str, final String str2) {
        com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "10Y", "DNS begin");
        com.baidu.lcp.sdk.connect.a.aB(this.context).a(str, new a.d() { // from class: com.baidu.lcp.sdk.connect.f.1
            @Override // com.baidu.lcp.sdk.connect.a.d
            public void c(int i, String str3, String str4) {
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "-----try to connect ip:" + str4);
                if (TextUtils.isEmpty(str4)) {
                    str4 = str;
                }
                f.this.avl = str4;
                com.baidu.lcp.sdk.a.d.writeLoginFlag(f.this.context, "14N_0", "socketConnect :" + f.this.avl);
                if (i == 0) {
                    com.baidu.lcp.sdk.c.a.aF(f.this.context).submitForNetWork(new a(str4, str2, Integer.valueOf(f.this.mConnectId.incrementAndGet())));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void vM() {
        if (!RequsetNetworkUtils.isConnected(this.context)) {
            vK();
        } else if (auo.state == 0 || auo.state == -2) {
            com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "connectImpl connect state:" + auo.state);
            com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "17N_2", "connectState is " + auo.state);
        } else {
            com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "10N_0", "connect begin");
            this.avj.removeCallbacks(this.avq);
            this.avj.removeCallbacks(this.avr);
            this.avj.removeCallbacks(this.ave);
            vL();
        }
    }

    public synchronized void b(BLCPRequest bLCPRequest, com.baidu.lcp.sdk.client.bean.b bVar) {
        if (com.baidu.lcp.sdk.d.e.aA(this.context)) {
            com.baidu.lcp.sdk.connect.b bVar2 = new com.baidu.lcp.sdk.connect.b();
            bVar2.serviceId = bLCPRequest.serviceId;
            bVar2.methodId = bLCPRequest.methodId;
            bVar2.auJ = bLCPRequest.auv;
            if (bLCPRequest.msgId < 0) {
                bVar2.msgId = System.currentTimeMillis();
            } else {
                bVar2.msgId = bLCPRequest.msgId;
            }
            switch (bLCPRequest.auw) {
                case TIMEOUT_20s:
                    bVar2.auK = 20000L;
                    break;
                case TIMEOUT_30s:
                    bVar2.auK = 30000L;
                    break;
                case TIMEOUT_50s:
                    bVar2.auK = 50000L;
                    break;
                default:
                    bVar2.auK = 5000L;
                    break;
            }
            if (bLCPRequest instanceof com.baidu.lcp.sdk.client.bean.a) {
                bVar2.msgId = (bVar2.serviceId * 10000) + bVar2.methodId;
                a(bVar2.serviceId, bVar2.methodId, bVar2.msgId, true, bVar);
            } else if (bLCPRequest instanceof com.baidu.lcp.sdk.client.bean.c) {
                b(this.auZ.a(bVar2, false));
            } else {
                a(bVar2.serviceId, bVar2.methodId, bVar2.msgId, false, bVar);
                b(this.auZ.a(bVar2, true));
            }
        }
    }

    private void a(long j, long j2, long j3, boolean z, com.baidu.lcp.sdk.client.bean.b bVar) {
        Long valueOf = Long.valueOf(j3);
        if (z) {
            if (bVar != null) {
                this.avb.put(valueOf, bVar);
            }
        } else {
            this.ava.put(valueOf, bVar);
        }
        com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "isNotify:" + z + ", methodId:" + j2 + ", invoke keys :" + this.ava.keySet().toString() + ", notify keys :" + this.avb.keySet().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(com.baidu.lcp.sdk.connect.b bVar) {
        try {
            synchronized (this.auX) {
                boolean z = false;
                Iterator<com.baidu.lcp.sdk.connect.b> it = this.auX.iterator();
                while (it.hasNext()) {
                    com.baidu.lcp.sdk.connect.b next = it.next();
                    com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "sendMessage queue :" + next.msgId);
                    z = next.auP ? true : z;
                }
                if (bVar.auP) {
                    if (z || auo.state != -1) {
                        com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "sendMessage cur methodId :1, state :" + auo.state);
                    } else {
                        this.auX.addFirst(bVar);
                        this.auX.notifyAll();
                        com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "16Y_2", "send Logig msg");
                    }
                } else if (auo.state == -1) {
                    if (vO()) {
                        if (this.auX.size() <= 0 || !z) {
                            this.auX.addFirst(this.auZ.f(this.context, 1L));
                            this.auX.notifyAll();
                            com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "16Y_3", "heart rate and send Logig msg");
                        }
                        if (!bVar.isHeartbeat) {
                            this.auX.add(bVar);
                            this.auX.notifyAll();
                        }
                    } else {
                        if (bVar.isHeartbeat) {
                            vL();
                        }
                        this.auX.add(bVar);
                    }
                } else {
                    this.auX.add(bVar);
                    this.auX.notifyAll();
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
            if (bVar.auN > 0) {
                j = bVar.auN;
            }
            if (bVar.methodId == 1) {
                a(j, true, str);
            } else if (bVar.methodId == 2) {
                ac("LCP logout:", str);
                auo.state = bVar.auO;
                setChanged();
                notifyObservers(auo);
                vN();
            } else if (bVar.methodId == 3) {
                this.ave.aa(j);
            }
        } else if (String.valueOf(bVar.errorCode).startsWith("30") || bVar.errorCode == 1011) {
            com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "login error, then request token, error :" + bVar.errorCode);
            ac("errorCode:" + String.valueOf(bVar.errorCode), str);
            com.baidu.lcp.sdk.d.e.D(this.context, "");
            com.baidu.lcp.sdk.client.c.vA().vC();
        } else if (bVar.errorCode == 1012) {
            com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "login error :" + bVar.errorCode);
        } else if (bVar.errorCode == 1013) {
            a(AppStatusRules.DEFAULT_GRANULARITY, false, str);
        } else {
            auo.state = -1;
            setChanged();
            notifyObservers(auo);
            vN();
            aT(true);
        }
    }

    private void a(long j, boolean z, String str) {
        try {
            this.avf.set(0);
            auo.state = 0;
            setChanged();
            notifyObservers(auo);
            vN();
            if (z) {
                this.avj.setHost(str);
                this.avj.postDelayed(this.ave, j);
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "ping every 1分钟 ");
                com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "17Y", "login success");
                new a.b(this.context).ef("login ok").eg(OneKeyLoginSdkCall.k).W(System.currentTimeMillis()).X(System.currentTimeMillis()).Y(0L).eh("").Z(501111L).build();
            }
        } catch (Exception e2) {
            com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "handleLcpLoginSuccess Exception :" + e2);
        }
    }

    public void vN() {
        Intent intent = new Intent();
        intent.putExtra("com.baidu.lcp.sdk.connect.state", auo.state);
        intent.setAction("com.baidu.lcp.sdk.broadcast");
        LocalBroadcastManager.getInstance(this.context).sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, String str) {
        try {
            if (this.auY.size() > 0 && this.auY.containsKey(Long.valueOf(j))) {
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "handle msg timeout!!! " + this.auY.get(Long.valueOf(j)).toString());
                com.baidu.lcp.sdk.connect.b remove = this.auY.remove(Long.valueOf(j));
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
            if (this.auY.size() > 0 && this.auY.containsKey(Long.valueOf(j))) {
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "handle msg exception!!! " + this.auY.get(Long.valueOf(j)).toString());
                com.baidu.lcp.sdk.connect.b remove = this.auY.remove(Long.valueOf(j));
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
            if (this.auY.size() > 0 && this.auY.containsKey(Long.valueOf(j))) {
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "handle msg socket stoped!!! " + this.auY.get(Long.valueOf(j)).toString());
                com.baidu.lcp.sdk.connect.b remove = this.auY.remove(Long.valueOf(j));
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
            Long valueOf = Long.valueOf(!bVar.auL ? bVar.msgId : (bVar.serviceId * 10000) + bVar.methodId);
            com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "onBLCPResponse key:" + valueOf + ", msgId :" + bVar.msgId + ", invoke keys :" + this.ava.keySet().toString() + ", notify keys :" + this.avb.keySet().toString());
            if (this.avb.size() > 0 && this.avb.containsKey(valueOf)) {
                remove = this.avb.get(valueOf);
            } else {
                remove = (this.ava.size() <= 0 || !this.ava.containsKey(valueOf)) ? null : this.ava.remove(valueOf);
            }
            if (remove != null) {
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "onBLCPResponse methodId :" + bVar.methodId + ", serviceId :" + bVar.serviceId + ", error :" + bVar.errorCode + ", msgId :" + bVar.msgId + ", errMsg :" + bVar.errorMsg + ", invoke keys :" + this.ava.keySet().toString());
                remove.onResponse(bVar.errorCode, bVar.errorMsg, bVar.serviceId, bVar.methodId, bVar.msgId, bVar.auM);
                if (bVar.errorCode == 1011) {
                    com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "onBLCPResponse errorCode :" + bVar.errorCode + ", and will send lcm login msg .");
                    b(this.auZ.f(this.context, 1L));
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
        private long auN;

        private d() {
            this.auN = AppStatusRules.DEFAULT_GRANULARITY;
        }

        public void aa(long j) {
            this.auN = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.avj.removeCallbacks(f.this.ave);
            if (com.baidu.lcp.sdk.d.e.aA(f.this.context)) {
                f.this.avj.postDelayed(f.this.ave, this.auN);
                f.this.b(f.this.auZ.f(f.this.context, 3L));
            }
        }
    }

    /* loaded from: classes3.dex */
    private class b implements Runnable {
        Integer avw;
        boolean avy = false;
        String host;

        b(Integer num, String str) {
            this.avw = num;
            this.host = str;
        }

        void vQ() {
            this.avy = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (f.this.auU) {
                if (!this.avy && f.auo.state != 0) {
                    f.this.auU.put(this.avw, true);
                    com.baidu.lcp.sdk.a.d.writeLoginFlag(f.this.context, "14N_1", "socketConnect_timeout :" + f.this.avl);
                    f.this.d(401214, "time out", this.host);
                    f.this.ad("time out:", this.host);
                    return;
                }
                com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "ConnectTimeOutTask has stoped");
                f.this.avj.removeCallbacks(this);
            }
        }
    }

    /* loaded from: classes3.dex */
    final class a implements Runnable {
        private String avv;
        private Integer avw;
        private String host;

        public a(String str, String str2, Integer num) {
            this.host = str;
            this.avv = str2;
            this.avw = num;
        }

        @Override // java.lang.Runnable
        public synchronized void run() {
            try {
                if (!f.this.vO()) {
                    if (f.this.avd != null && f.this.avd.isAlive()) {
                        f.this.avd.interrupt();
                        com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "readThread interrupt");
                    }
                    if (f.this.avc != null && f.this.avc.isAlive()) {
                        f.this.avc.interrupt();
                        com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "sendThread interrupt");
                    }
                    b bVar = new b(this.avw, this.host);
                    f.this.avj.setHost(this.host);
                    f.this.avj.postDelayed(bVar, 5000L);
                    try {
                        com.baidu.lcp.sdk.a.d.writeLoginFlag(f.this.context, "14N", "socketConnect :" + f.this.avl);
                        com.baidu.lcp.sdk.connect.e y = f.this.avg.y(this.host, Integer.valueOf(this.avv).intValue());
                        if (f.this.vO()) {
                            com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "socketConnect after, but socket has created ok.");
                            f.this.b(y);
                        } else if (!y.auT.booleanValue()) {
                            com.baidu.lcp.sdk.a.d.writeLoginFlag(f.this.context, "15N", "connect env error");
                            f.this.d(401213, "connect env error", this.host);
                            f.this.avj.removeCallbacks(bVar);
                            f.this.ac("connect env error:", this.host);
                        } else {
                            synchronized (f.this.auU) {
                                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "socketNeedCloseMap remove connectTimeoutTask");
                                f.this.avj.removeCallbacks(bVar);
                                bVar.vQ();
                                if (!f.this.vO()) {
                                    if (f.this.auU.get(this.avw) == null) {
                                        com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "socketNeedCloseMap setCurrentSocketState");
                                        f.this.avg.a(y);
                                    }
                                    com.baidu.lcp.sdk.d.e.m(f.this.context, f.this.avf.get() == 0 ? 1 : 2);
                                    com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "create Socket ok");
                                    f.this.d(401211, "connect ok", this.host);
                                    com.baidu.lcp.sdk.a.d.writeLoginFlag(f.this.context, "16Y", "connect ok");
                                    com.baidu.lcp.sdk.connect.a.C(f.this.context, this.host);
                                    f.this.b(f.this.auZ.f(f.this.context, 1L));
                                    f.this.avk = SystemClock.currentThreadTimeMillis();
                                    if (com.baidu.lcp.sdk.d.b.aI(f.this.context) != 0) {
                                        com.baidu.lcp.sdk.c.a.aF(f.this.context).submitForNetWork(new Runnable() { // from class: com.baidu.lcp.sdk.connect.f.a.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                com.baidu.lcp.sdk.d.c.aJ(f.this.context);
                                                com.baidu.lcp.sdk.d.c.write("lcp connect:" + (System.currentTimeMillis() - f.this.avp));
                                            }
                                        });
                                    }
                                    com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "connectImpl time:" + f.this.avk);
                                    f.auo.state = -2;
                                    f.this.mClose = false;
                                    f.this.avc = new C0153f(this.host);
                                    f.this.avc.start();
                                    f.this.avd = new e(this.host);
                                    f.this.avd.start();
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
    public boolean vO() {
        return (this.avg == null || this.avg.vI() == null || this.avg.vI().socket == null || !this.avg.vI().socket.isConnected()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.lcp.sdk.connect.e eVar) {
        if (eVar != null && eVar.auS.booleanValue()) {
            try {
                if (eVar.socket != null) {
                    if (eVar.socket.hashCode() == this.avg.vI().socket.hashCode()) {
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
        this.avl += ":" + com.baidu.lcp.sdk.connect.a.vF() + ":" + RequsetNetworkUtils.getNetInfo(this.context);
        com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "connectTrack ext:" + this.avl + ", retry :" + this.avf.get() + ", reason :" + str);
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        new a.C0149a(this.context).S(this.avk).T(System.currentTimeMillis()).V(i).ed(str).ee(str2).U(this.avf.get()).build();
        if (com.baidu.lcp.sdk.a.d.i(this.context, 401216) && this.avf.get() >= 5 && i != 401211) {
            com.baidu.lcp.sdk.a.b.a(this.context, IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.CONNECTION).setConnection(IMPushPb.Connection.newBuilder().setStartTime(this.avk).setStopTime(System.currentTimeMillis()).setAliasId(401216L).setReason(str).setExt(str2).setRetryCount(this.avf.get()).build()).build());
        }
        this.avl = "";
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
                        com.baidu.lcp.sdk.connect.b h = f.this.auZ.h(f.this.avg.vH());
                        if (h != null && h.msgId > 0) {
                            f.this.avj.removeCallbacks(f.this.avh);
                            h.auQ = false;
                            com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "ReadThread :" + h.toString());
                            if (!h.isHeartbeat) {
                                if (h.auP) {
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
                                    bVar = (com.baidu.lcp.sdk.connect.b) f.this.auY.remove(Long.valueOf(h.msgId));
                                }
                                f.this.a(h, bVar, this.host);
                            }
                            synchronized (f.this.mSync) {
                                if (f.this.auY.size() != 0) {
                                    com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "ReadThread socketTimeoutRunnable ...");
                                    f.this.avh.setMsgId(h.msgId);
                                    f.this.avh.setHost(this.host);
                                    f.this.avj.setHost(this.host);
                                    f.this.avj.postDelayed(f.this.avh, h.auK);
                                }
                            }
                        }
                    } catch (Exception e) {
                        if (!f.this.mClose) {
                            com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "ReadThread exception: " + e, e);
                            f.this.auW = false;
                            f.this.ad("ReadThread exception: " + e, this.host);
                            return;
                        }
                        return;
                    }
                } catch (Exception e2) {
                    if (!f.this.mClose) {
                        com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "onStartCommand", e2);
                        f.this.auW = false;
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
    class C0153f extends Thread {
        private String host;

        C0153f(String str) {
            this.host = str;
            setName("LCP-SocketTransceiver-SendThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!f.this.mClose) {
                try {
                    com.baidu.lcp.sdk.connect.b bVar = null;
                    try {
                        synchronized (f.this.auX) {
                            if (f.this.auX.size() == 0) {
                                f.this.auX.wait();
                            } else {
                                bVar = (com.baidu.lcp.sdk.connect.b) f.this.auX.removeFirst();
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
                            bVar.auQ = true;
                            bVar.auO = f.auo.state;
                            if (bVar.needReplay) {
                                synchronized (f.this.mSync) {
                                    if (f.this.auY.isEmpty()) {
                                        f.this.avj.removeCallbacks(f.this.avh);
                                        f.this.avh.setMsgId(bVar.msgId);
                                        f.this.avh.setHost(this.host);
                                        f.this.avj.setHost(this.host);
                                        f.this.avj.postDelayed(f.this.avh, 5000L);
                                    }
                                }
                            }
                            com.baidu.lcp.sdk.d.d.v("SocketTransceiver", "SendThread :" + bVar.toString());
                            if (bVar.auP) {
                                com.baidu.lcp.sdk.a.d.writeLoginFlag(f.this.context, "17N", "Send LoginMsg request");
                            }
                            if (bVar.methodId == 1 && bVar.serviceId == 4) {
                                com.baidu.lcp.sdk.d.a.a(f.this.context, 1L, UbcStatConstant.ContentType.UBC_TYPE_IM_SEND, bVar.msgId + "");
                            }
                            if (bVar.methodId == 50 && bVar.serviceId == 2) {
                                com.baidu.lcp.sdk.d.a.a(f.this.context, 50L, UbcStatConstant.ContentType.UBC_TYPE_IM_SEND, bVar.msgId + "");
                            }
                            synchronized (f.this.mOutputSync) {
                                f.this.avg.a(bVar);
                            }
                            if (!bVar.isHeartbeat && bVar.needReplay) {
                                synchronized (f.this.mSync) {
                                    f.this.auY.put(Long.valueOf(bVar.msgId), bVar);
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

    private void ej(String str) {
        try {
            com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "fatalAllMessage begin ");
            synchronized (this.auX) {
                while (this.auX.size() > 0) {
                    b(this.auX.removeFirst(), str);
                }
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "fatalAllMessage sendQueue end ");
            }
            synchronized (this.mSync) {
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "fatalAllMessage mSync begin");
                for (Long l : this.auY.keySet()) {
                    b(this.auY.get(l), str);
                }
                this.auY.clear();
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
        if (com.baidu.lcp.sdk.d.e.aA(this.context)) {
            com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "---socketDisconnect---");
            this.mClose = true;
            this.auW = true;
            ej(str2);
            vK();
            this.avj.removeCallbacks(this.avq);
            this.avj.removeCallbacks(this.avr);
            this.avj.removeCallbacks(this.ave);
            com.baidu.lcp.sdk.connect.a.e(this.context, null, false);
            af(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ad(String str, String str2) {
        com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "disconnectedByLcp, destroyConnection = " + this.auW + ", net :" + RequsetNetworkUtils.isConnected(this.context) + ", isSmallFlow :" + com.baidu.lcp.sdk.d.e.aA(this.context));
        if (com.baidu.lcp.sdk.d.e.aA(this.context)) {
            ej(str2);
            if (this.auW) {
                vK();
            } else {
                af(str, str2);
                if (!RequsetNetworkUtils.isConnected(this.context)) {
                    vK();
                } else {
                    aT(false);
                }
            }
        }
    }

    private void aT(boolean z) {
        try {
            this.avf.incrementAndGet();
            if (this.avf.get() <= 10 && auo.state == -1) {
                long bP = bP(this.avf.get());
                this.avj.removeCallbacks(this.ave);
                this.avj.removeCallbacks(z ? this.avq : this.avr);
                this.avj.postDelayed(z ? this.avr : this.avq, bP);
                com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "Schedule retry " + (z ? OneKeyLoginSdkCall.k : "connect") + " -- retry times: " + this.avf.get() + " time delay: " + bP);
            }
        } catch (Exception e2) {
            com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "retry Exception", e2);
        }
    }

    private long bP(int i) {
        if (i < 3) {
            return i * 1000;
        }
        return IMConnection.RETRY_DELAY_TIMES;
    }

    private synchronized void af(String str, String str2) {
        if (com.baidu.lcp.sdk.d.e.aA(this.context)) {
            com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "destroy");
            d(401212, "connect stop, " + str, str2);
            auo.state = -1;
            setChanged();
            notifyObservers(auo);
            vN();
            this.avj.removeCallbacks(this.avh);
            this.mClose = true;
            if (this.avg != null) {
                synchronized (this.auX) {
                    this.auX.notifyAll();
                    com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "destroy notifyAll");
                }
                try {
                    this.avg.socketClose();
                    com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "destroy socketClose ok");
                } catch (Exception e2) {
                    this.avg.a((com.baidu.lcp.sdk.connect.e) null);
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
        b(this.auZ.f(this.context, 3L));
    }
}
