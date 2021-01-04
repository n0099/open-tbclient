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
    private C0162f aAa;
    private e aAb;
    private com.baidu.lcp.sdk.connect.d aAe;
    private c aAh;
    private long aAi;
    private long aAn;
    private Context context;
    private static volatile com.baidu.lcp.sdk.client.b azm = new com.baidu.lcp.sdk.client.b();
    private static volatile f aAm = null;
    private final Map<Integer, Boolean> azS = new TreeMap();
    private AtomicInteger mConnectId = new AtomicInteger(0);
    private int azT = 0;
    private boolean azU = false;
    private volatile LinkedList<com.baidu.lcp.sdk.connect.b> azV = new LinkedList<>();
    private final HashMap<Long, com.baidu.lcp.sdk.connect.b> azW = new LinkedHashMap();
    private final Object mOutputSync = new Object();
    private final Object mSync = new Object();
    private com.baidu.lcp.sdk.pb.f azX = new com.baidu.lcp.sdk.pb.f();
    private Map<Long, com.baidu.lcp.sdk.client.bean.b> azY = new LinkedHashMap();
    private Map<Long, com.baidu.lcp.sdk.client.bean.b> azZ = new LinkedHashMap();
    private d aAc = new d();
    private boolean mClose = false;
    private AtomicInteger aAd = new AtomicInteger(0);
    private int mDelayTimes = -1;
    private g aAf = new g();
    public String aAj = "";
    public String aAk = "";
    public String aAl = "";
    private Runnable aAo = new Runnable() { // from class: com.baidu.lcp.sdk.connect.f.2
        @Override // java.lang.Runnable
        public void run() {
            f.this.zK();
        }
    };
    private Runnable aAp = new Runnable() { // from class: com.baidu.lcp.sdk.connect.f.3
        @Override // java.lang.Runnable
        public void run() {
            f.this.b(f.this.azX.f(f.this.context, 1L));
        }
    };
    private HandlerThread aAg = new HandlerThread("LCP HandlerThread");

    private f(Context context) {
        this.context = context;
        this.aAg.start();
        this.aAh = new c(this.aAg.getLooper());
    }

    public static synchronized f aF(Context context) {
        f fVar;
        synchronized (f.class) {
            if (aAm == null) {
                aAm = new f(context.getApplicationContext());
            }
            fVar = aAm;
        }
        return fVar;
    }

    public void zH() {
        if (com.baidu.lcp.sdk.d.e.aB(this.context)) {
            zI();
            zK();
        }
    }

    private void zI() {
        this.azT = 0;
        this.aAd.set(0);
        com.baidu.lcp.sdk.connect.a.zB();
    }

    private synchronized void zJ() {
        this.aAn = System.currentTimeMillis();
        if (!this.aAk.isEmpty() && !this.aAl.isEmpty() && com.baidu.lcp.sdk.connect.a.zC()) {
            com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "10N_2", "connecting");
            af(this.aAk, this.aAl);
        } else {
            com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "10N_1", "connecting");
            com.baidu.lcp.sdk.d.d.w("SocketTransceiver", "protocolOption  thread :" + Thread.activeCount() + ", cur :" + Thread.currentThread() + "， protocol count :" + this.azT);
            String[] split = com.baidu.lcp.sdk.d.e.k(this.context, this.azT).split(":");
            if (split.length >= 3) {
                String str = TextUtils.isEmpty(split[0]) ? "tcp" : split[0];
                String str2 = split[1];
                String str3 = split[2];
                if (this.azT >= com.baidu.lcp.sdk.d.e.aM(this.context)) {
                    this.azT = 0;
                    com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "10N_1", "connect failed, connectip:" + str2 + ", port:" + str3 + ", protocolType:" + str);
                    com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "protocolOption failed, connectip:" + str2 + ", port:" + str3 + ", protocolType:" + str);
                    this.aAe = new com.baidu.lcp.sdk.connect.g(this.context, "tls");
                    this.aAk = "lcs.baidu.com";
                    this.aAl = "443";
                    af("lcs.baidu.com", "443");
                } else {
                    if ("quic".equals(str) && !(this.aAe instanceof QuicMessageHandler)) {
                        this.aAe = new QuicMessageHandler(this.context);
                    } else if ("tcp".equals(str) || ("tls".equals(str) && !(this.aAe instanceof com.baidu.lcp.sdk.connect.g))) {
                        this.aAe = new com.baidu.lcp.sdk.connect.g(this.context, str);
                    }
                    this.azT++;
                    if (this.aAe != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                        com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "type :" + str + ", host :" + str2 + ", port :" + str3);
                        this.aAk = str2;
                        this.aAl = str3;
                        af(str2, str3);
                    } else {
                        this.aAk = "";
                        this.aAl = "";
                        zJ();
                    }
                }
            }
        }
    }

    private synchronized void af(final String str, final String str2) {
        com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "10Y", "DNS begin");
        com.baidu.lcp.sdk.connect.a.aC(this.context).a(str, new a.d() { // from class: com.baidu.lcp.sdk.connect.f.1
            @Override // com.baidu.lcp.sdk.connect.a.d
            public void c(int i, String str3, String str4) {
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "-----try to connect ip:" + str4);
                if (TextUtils.isEmpty(str4)) {
                    str4 = str;
                }
                f.this.aAj = str4;
                com.baidu.lcp.sdk.a.d.writeLoginFlag(f.this.context, "14N_0", "socketConnect :" + f.this.aAj);
                if (i == 0) {
                    com.baidu.lcp.sdk.c.a.aG(f.this.context).submitForNetWork(new a(str4, str2, Integer.valueOf(f.this.mConnectId.incrementAndGet())));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void zK() {
        if (!RequsetNetworkUtils.isConnected(this.context)) {
            zI();
        } else if (azm.state == 0 || azm.state == -2) {
            com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "connectImpl connect state:" + azm.state);
            com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "17N_2", "connectState is " + azm.state);
        } else {
            com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "10N_0", "connect begin");
            this.aAh.removeCallbacks(this.aAo);
            this.aAh.removeCallbacks(this.aAp);
            this.aAh.removeCallbacks(this.aAc);
            zJ();
        }
    }

    public synchronized void b(BLCPRequest bLCPRequest, com.baidu.lcp.sdk.client.bean.b bVar) {
        if (com.baidu.lcp.sdk.d.e.aB(this.context)) {
            com.baidu.lcp.sdk.connect.b bVar2 = new com.baidu.lcp.sdk.connect.b();
            bVar2.serviceId = bLCPRequest.serviceId;
            bVar2.methodId = bLCPRequest.methodId;
            bVar2.azH = bLCPRequest.azt;
            if (bLCPRequest.msgId < 0) {
                bVar2.msgId = System.currentTimeMillis();
            } else {
                bVar2.msgId = bLCPRequest.msgId;
            }
            switch (bLCPRequest.azu) {
                case TIMEOUT_20s:
                    bVar2.azI = 20000L;
                    break;
                case TIMEOUT_30s:
                    bVar2.azI = 30000L;
                    break;
                case TIMEOUT_50s:
                    bVar2.azI = 50000L;
                    break;
                default:
                    bVar2.azI = 5000L;
                    break;
            }
            if (bLCPRequest instanceof com.baidu.lcp.sdk.client.bean.a) {
                bVar2.msgId = (bVar2.serviceId * 10000) + bVar2.methodId;
                a(bVar2.serviceId, bVar2.methodId, bVar2.msgId, true, bVar);
            } else if (bLCPRequest instanceof com.baidu.lcp.sdk.client.bean.c) {
                b(this.azX.a(bVar2, false));
            } else {
                a(bVar2.serviceId, bVar2.methodId, bVar2.msgId, false, bVar);
                b(this.azX.a(bVar2, true));
            }
        }
    }

    private void a(long j, long j2, long j3, boolean z, com.baidu.lcp.sdk.client.bean.b bVar) {
        Long valueOf = Long.valueOf(j3);
        if (z) {
            if (bVar != null) {
                this.azZ.put(valueOf, bVar);
            }
        } else {
            this.azY.put(valueOf, bVar);
        }
        com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "isNotify:" + z + ", methodId:" + j2 + ", invoke keys :" + this.azY.keySet().toString() + ", notify keys :" + this.azZ.keySet().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(com.baidu.lcp.sdk.connect.b bVar) {
        try {
            synchronized (this.azV) {
                boolean z = false;
                Iterator<com.baidu.lcp.sdk.connect.b> it = this.azV.iterator();
                while (it.hasNext()) {
                    com.baidu.lcp.sdk.connect.b next = it.next();
                    com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "sendMessage queue :" + next.msgId);
                    z = next.azN ? true : z;
                }
                if (bVar.azN) {
                    if (z || azm.state != -1) {
                        com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "sendMessage cur methodId :1, state :" + azm.state);
                    } else {
                        this.azV.addFirst(bVar);
                        this.azV.notifyAll();
                        com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "16Y_2", "send Logig msg");
                    }
                } else if (azm.state == -1) {
                    if (zM()) {
                        if (this.azV.size() <= 0 || !z) {
                            this.azV.addFirst(this.azX.f(this.context, 1L));
                            this.azV.notifyAll();
                            com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "16Y_3", "heart rate and send Logig msg");
                        }
                        if (!bVar.isHeartbeat) {
                            this.azV.add(bVar);
                            this.azV.notifyAll();
                        }
                    } else {
                        if (bVar.isHeartbeat) {
                            zJ();
                        }
                        this.azV.add(bVar);
                    }
                } else {
                    this.azV.add(bVar);
                    this.azV.notifyAll();
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
            if (bVar.azL > 0) {
                j = bVar.azL;
            }
            if (bVar.methodId == 1) {
                a(j, true, str);
            } else if (bVar.methodId == 2) {
                ag("LCP logout:", str);
                azm.state = bVar.azM;
                setChanged();
                notifyObservers(azm);
                zL();
            } else if (bVar.methodId == 3) {
                this.aAc.aa(j);
            }
        } else if (String.valueOf(bVar.errorCode).startsWith("30") || bVar.errorCode == 1011) {
            com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "login error, then request token, error :" + bVar.errorCode);
            ag("errorCode:" + String.valueOf(bVar.errorCode), str);
            com.baidu.lcp.sdk.d.e.D(this.context, "");
            com.baidu.lcp.sdk.client.c.zy().zA();
        } else if (bVar.errorCode == 1012) {
            com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "login error :" + bVar.errorCode);
        } else if (bVar.errorCode == 1013) {
            a(AppStatusRules.DEFAULT_GRANULARITY, false, str);
        } else {
            azm.state = -1;
            setChanged();
            notifyObservers(azm);
            zL();
            aX(true);
        }
    }

    private void a(long j, boolean z, String str) {
        try {
            this.aAd.set(0);
            azm.state = 0;
            setChanged();
            notifyObservers(azm);
            zL();
            if (z) {
                this.aAh.setHost(str);
                this.aAh.postDelayed(this.aAc, j);
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "ping every 1分钟 ");
                com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "17Y", "login success");
                new a.b(this.context).fr("login ok").fs(OneKeyLoginSdkCall.k).W(System.currentTimeMillis()).X(System.currentTimeMillis()).Y(0L).ft("").Z(501111L).build();
            }
        } catch (Exception e2) {
            com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "handleLcpLoginSuccess Exception :" + e2);
        }
    }

    public void zL() {
        Intent intent = new Intent();
        intent.putExtra("com.baidu.lcp.sdk.connect.state", azm.state);
        intent.setAction("com.baidu.lcp.sdk.broadcast");
        LocalBroadcastManager.getInstance(this.context).sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, String str) {
        try {
            if (this.azW.size() > 0 && this.azW.containsKey(Long.valueOf(j))) {
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "handle msg timeout!!! " + this.azW.get(Long.valueOf(j)).toString());
                com.baidu.lcp.sdk.connect.b remove = this.azW.remove(Long.valueOf(j));
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
            if (this.azW.size() > 0 && this.azW.containsKey(Long.valueOf(j))) {
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "handle msg exception!!! " + this.azW.get(Long.valueOf(j)).toString());
                com.baidu.lcp.sdk.connect.b remove = this.azW.remove(Long.valueOf(j));
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
            if (this.azW.size() > 0 && this.azW.containsKey(Long.valueOf(j))) {
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "handle msg socket stoped!!! " + this.azW.get(Long.valueOf(j)).toString());
                com.baidu.lcp.sdk.connect.b remove = this.azW.remove(Long.valueOf(j));
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
            Long valueOf = Long.valueOf(!bVar.azJ ? bVar.msgId : (bVar.serviceId * 10000) + bVar.methodId);
            com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "onBLCPResponse key:" + valueOf + ", msgId :" + bVar.msgId + ", invoke keys :" + this.azY.keySet().toString() + ", notify keys :" + this.azZ.keySet().toString());
            if (this.azZ.size() > 0 && this.azZ.containsKey(valueOf)) {
                remove = this.azZ.get(valueOf);
            } else {
                remove = (this.azY.size() <= 0 || !this.azY.containsKey(valueOf)) ? null : this.azY.remove(valueOf);
            }
            if (remove != null) {
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "onBLCPResponse methodId :" + bVar.methodId + ", serviceId :" + bVar.serviceId + ", error :" + bVar.errorCode + ", msgId :" + bVar.msgId + ", errMsg :" + bVar.errorMsg + ", invoke keys :" + this.azY.keySet().toString());
                remove.onResponse(bVar.errorCode, bVar.errorMsg, bVar.serviceId, bVar.methodId, bVar.msgId, bVar.azK);
                if (bVar.errorCode == 1011) {
                    com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "onBLCPResponse errorCode :" + bVar.errorCode + ", and will send lcm login msg .");
                    b(this.azX.f(this.context, 1L));
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
        private long azL;

        private d() {
            this.azL = AppStatusRules.DEFAULT_GRANULARITY;
        }

        public void aa(long j) {
            this.azL = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.aAh.removeCallbacks(f.this.aAc);
            if (com.baidu.lcp.sdk.d.e.aB(f.this.context)) {
                f.this.aAh.postDelayed(f.this.aAc, this.azL);
                f.this.b(f.this.azX.f(f.this.context, 3L));
            }
        }
    }

    /* loaded from: classes3.dex */
    private class b implements Runnable {
        Integer aAu;
        boolean aAw = false;
        String host;

        b(Integer num, String str) {
            this.aAu = num;
            this.host = str;
        }

        void zO() {
            this.aAw = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (f.this.azS) {
                if (!this.aAw && f.azm.state != 0) {
                    f.this.azS.put(this.aAu, true);
                    com.baidu.lcp.sdk.a.d.writeLoginFlag(f.this.context, "14N_1", "socketConnect_timeout :" + f.this.aAj);
                    f.this.d(401214, "time out", this.host);
                    f.this.ah("time out:", this.host);
                    return;
                }
                com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "ConnectTimeOutTask has stoped");
                f.this.aAh.removeCallbacks(this);
            }
        }
    }

    /* loaded from: classes3.dex */
    final class a implements Runnable {
        private String aAt;
        private Integer aAu;
        private String host;

        public a(String str, String str2, Integer num) {
            this.host = str;
            this.aAt = str2;
            this.aAu = num;
        }

        @Override // java.lang.Runnable
        public synchronized void run() {
            try {
                if (!f.this.zM()) {
                    if (f.this.aAb != null && f.this.aAb.isAlive()) {
                        f.this.aAb.interrupt();
                        com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "readThread interrupt");
                    }
                    if (f.this.aAa != null && f.this.aAa.isAlive()) {
                        f.this.aAa.interrupt();
                        com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "sendThread interrupt");
                    }
                    b bVar = new b(this.aAu, this.host);
                    f.this.aAh.setHost(this.host);
                    f.this.aAh.postDelayed(bVar, 5000L);
                    try {
                        com.baidu.lcp.sdk.a.d.writeLoginFlag(f.this.context, "14N", "socketConnect :" + f.this.aAj);
                        com.baidu.lcp.sdk.connect.e y = f.this.aAe.y(this.host, Integer.valueOf(this.aAt).intValue());
                        if (f.this.zM()) {
                            com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "socketConnect after, but socket has created ok.");
                            f.this.b(y);
                        } else if (!y.azR.booleanValue()) {
                            com.baidu.lcp.sdk.a.d.writeLoginFlag(f.this.context, "15N", "connect env error");
                            f.this.d(401213, "connect env error", this.host);
                            f.this.aAh.removeCallbacks(bVar);
                            f.this.ag("connect env error:", this.host);
                        } else {
                            synchronized (f.this.azS) {
                                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "socketNeedCloseMap remove connectTimeoutTask");
                                f.this.aAh.removeCallbacks(bVar);
                                bVar.zO();
                                if (!f.this.zM()) {
                                    if (f.this.azS.get(this.aAu) == null) {
                                        com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "socketNeedCloseMap setCurrentSocketState");
                                        f.this.aAe.a(y);
                                    }
                                    com.baidu.lcp.sdk.d.e.m(f.this.context, f.this.aAd.get() == 0 ? 1 : 2);
                                    com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "create Socket ok");
                                    f.this.d(401211, "connect ok", this.host);
                                    com.baidu.lcp.sdk.a.d.writeLoginFlag(f.this.context, "16Y", "connect ok");
                                    com.baidu.lcp.sdk.connect.a.C(f.this.context, this.host);
                                    f.this.b(f.this.azX.f(f.this.context, 1L));
                                    f.this.aAi = SystemClock.currentThreadTimeMillis();
                                    if (com.baidu.lcp.sdk.d.b.aJ(f.this.context) != 0) {
                                        com.baidu.lcp.sdk.c.a.aG(f.this.context).submitForNetWork(new Runnable() { // from class: com.baidu.lcp.sdk.connect.f.a.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                com.baidu.lcp.sdk.d.c.aK(f.this.context);
                                                com.baidu.lcp.sdk.d.c.write("lcp connect:" + (System.currentTimeMillis() - f.this.aAn));
                                            }
                                        });
                                    }
                                    com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "connectImpl time:" + f.this.aAi);
                                    f.azm.state = -2;
                                    f.this.mClose = false;
                                    f.this.aAa = new C0162f(this.host);
                                    f.this.aAa.start();
                                    f.this.aAb = new e(this.host);
                                    f.this.aAb.start();
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
    public boolean zM() {
        return (this.aAe == null || this.aAe.zG() == null || this.aAe.zG().socket == null || !this.aAe.zG().socket.isConnected()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.lcp.sdk.connect.e eVar) {
        if (eVar != null && eVar.azQ.booleanValue()) {
            try {
                if (eVar.socket != null) {
                    if (eVar.socket.hashCode() == this.aAe.zG().socket.hashCode()) {
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
        this.aAj += ":" + com.baidu.lcp.sdk.connect.a.zD() + ":" + RequsetNetworkUtils.getNetInfo(this.context);
        com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "connectTrack ext:" + this.aAj + ", retry :" + this.aAd.get() + ", reason :" + str);
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        new a.C0158a(this.context).S(this.aAi).T(System.currentTimeMillis()).V(i).fp(str).fq(str2).U(this.aAd.get()).build();
        if (com.baidu.lcp.sdk.a.d.i(this.context, 401216) && this.aAd.get() >= 5 && i != 401211) {
            com.baidu.lcp.sdk.a.b.a(this.context, IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.CONNECTION).setConnection(IMPushPb.Connection.newBuilder().setStartTime(this.aAi).setStopTime(System.currentTimeMillis()).setAliasId(401216L).setReason(str).setExt(str2).setRetryCount(this.aAd.get()).build()).build());
        }
        this.aAj = "";
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
                        com.baidu.lcp.sdk.connect.b h = f.this.azX.h(f.this.aAe.zF());
                        if (h != null && h.msgId > 0) {
                            f.this.aAh.removeCallbacks(f.this.aAf);
                            h.azO = false;
                            com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "ReadThread :" + h.toString());
                            if (!h.isHeartbeat) {
                                if (h.azN) {
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
                                    bVar = (com.baidu.lcp.sdk.connect.b) f.this.azW.remove(Long.valueOf(h.msgId));
                                }
                                f.this.a(h, bVar, this.host);
                            }
                            synchronized (f.this.mSync) {
                                if (f.this.azW.size() != 0) {
                                    com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "ReadThread socketTimeoutRunnable ...");
                                    f.this.aAf.setMsgId(h.msgId);
                                    f.this.aAf.setHost(this.host);
                                    f.this.aAh.setHost(this.host);
                                    f.this.aAh.postDelayed(f.this.aAf, h.azI);
                                }
                            }
                        }
                    } catch (Exception e) {
                        if (!f.this.mClose) {
                            com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "ReadThread exception: " + e, e);
                            f.this.azU = false;
                            f.this.ah("ReadThread exception: " + e, this.host);
                            return;
                        }
                        return;
                    }
                } catch (Exception e2) {
                    if (!f.this.mClose) {
                        com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "onStartCommand", e2);
                        f.this.azU = false;
                        f.this.ah("onStartCommand:" + e2, this.host);
                        return;
                    }
                    return;
                }
            }
        }
    }

    /* renamed from: com.baidu.lcp.sdk.connect.f$f  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0162f extends Thread {
        private String host;

        C0162f(String str) {
            this.host = str;
            setName("LCP-SocketTransceiver-SendThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!f.this.mClose) {
                try {
                    com.baidu.lcp.sdk.connect.b bVar = null;
                    try {
                        synchronized (f.this.azV) {
                            if (f.this.azV.size() == 0) {
                                f.this.azV.wait();
                            } else {
                                bVar = (com.baidu.lcp.sdk.connect.b) f.this.azV.removeFirst();
                            }
                        }
                    } catch (InterruptedException e) {
                        com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "SendThread wait exception: " + e);
                        f.this.ah("SendThread wait exception: " + e, this.host);
                    }
                    if (bVar != null) {
                        try {
                            if (f.this.mClose) {
                                f.this.c(bVar.msgId, this.host);
                                return;
                            }
                            bVar.azO = true;
                            bVar.azM = f.azm.state;
                            if (bVar.needReplay) {
                                synchronized (f.this.mSync) {
                                    if (f.this.azW.isEmpty()) {
                                        f.this.aAh.removeCallbacks(f.this.aAf);
                                        f.this.aAf.setMsgId(bVar.msgId);
                                        f.this.aAf.setHost(this.host);
                                        f.this.aAh.setHost(this.host);
                                        f.this.aAh.postDelayed(f.this.aAf, 5000L);
                                    }
                                }
                            }
                            com.baidu.lcp.sdk.d.d.v("SocketTransceiver", "SendThread :" + bVar.toString());
                            if (bVar.azN) {
                                com.baidu.lcp.sdk.a.d.writeLoginFlag(f.this.context, "17N", "Send LoginMsg request");
                            }
                            if (bVar.methodId == 1 && bVar.serviceId == 4) {
                                com.baidu.lcp.sdk.d.a.a(f.this.context, 1L, UbcStatConstant.ContentType.UBC_TYPE_IM_SEND, bVar.msgId + "");
                            }
                            if (bVar.methodId == 50 && bVar.serviceId == 2) {
                                com.baidu.lcp.sdk.d.a.a(f.this.context, 50L, UbcStatConstant.ContentType.UBC_TYPE_IM_SEND, bVar.msgId + "");
                            }
                            synchronized (f.this.mOutputSync) {
                                f.this.aAe.a(bVar);
                            }
                            if (!bVar.isHeartbeat && bVar.needReplay) {
                                synchronized (f.this.mSync) {
                                    f.this.azW.put(Long.valueOf(bVar.msgId), bVar);
                                }
                            }
                        } catch (Exception e2) {
                            com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "SendThread sendMessage Exception:", e2);
                            f.this.c(bVar.msgId, e2.toString(), this.host);
                            f.this.ah("SendThread sendMessage Exception:" + e2, this.host);
                            return;
                        }
                    }
                } catch (Exception e3) {
                    com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "SendThread Exception:", e3);
                    f.this.ah("SendThread Exception:" + e3, this.host);
                    return;
                }
            }
        }
    }

    private void fv(String str) {
        try {
            com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "fatalAllMessage begin ");
            synchronized (this.azV) {
                while (this.azV.size() > 0) {
                    b(this.azV.removeFirst(), str);
                }
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "fatalAllMessage sendQueue end ");
            }
            synchronized (this.mSync) {
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "fatalAllMessage mSync begin");
                for (Long l : this.azW.keySet()) {
                    b(this.azW.get(l), str);
                }
                this.azW.clear();
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

    public synchronized void ag(String str, String str2) {
        if (com.baidu.lcp.sdk.d.e.aB(this.context)) {
            com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "---socketDisconnect---");
            this.mClose = true;
            this.azU = true;
            fv(str2);
            zI();
            this.aAh.removeCallbacks(this.aAo);
            this.aAh.removeCallbacks(this.aAp);
            this.aAh.removeCallbacks(this.aAc);
            com.baidu.lcp.sdk.connect.a.e(this.context, null, false);
            ai(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ah(String str, String str2) {
        com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "disconnectedByLcp, destroyConnection = " + this.azU + ", net :" + RequsetNetworkUtils.isConnected(this.context) + ", isSmallFlow :" + com.baidu.lcp.sdk.d.e.aB(this.context));
        if (com.baidu.lcp.sdk.d.e.aB(this.context)) {
            fv(str2);
            if (this.azU) {
                zI();
            } else {
                ai(str, str2);
                if (!RequsetNetworkUtils.isConnected(this.context)) {
                    zI();
                } else {
                    aX(false);
                }
            }
        }
    }

    private void aX(boolean z) {
        try {
            this.aAd.incrementAndGet();
            if (this.aAd.get() <= 10 && azm.state == -1) {
                long dv = dv(this.aAd.get());
                this.aAh.removeCallbacks(this.aAc);
                this.aAh.removeCallbacks(z ? this.aAo : this.aAp);
                this.aAh.postDelayed(z ? this.aAp : this.aAo, dv);
                com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "Schedule retry " + (z ? OneKeyLoginSdkCall.k : "connect") + " -- retry times: " + this.aAd.get() + " time delay: " + dv);
            }
        } catch (Exception e2) {
            com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "retry Exception", e2);
        }
    }

    private long dv(int i) {
        if (i < 3) {
            return i * 1000;
        }
        return IMConnection.RETRY_DELAY_TIMES;
    }

    private synchronized void ai(String str, String str2) {
        if (com.baidu.lcp.sdk.d.e.aB(this.context)) {
            com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "destroy");
            d(401212, "connect stop, " + str, str2);
            azm.state = -1;
            setChanged();
            notifyObservers(azm);
            zL();
            this.aAh.removeCallbacks(this.aAf);
            this.mClose = true;
            if (this.aAe != null) {
                synchronized (this.azV) {
                    this.azV.notifyAll();
                    com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "destroy notifyAll");
                }
                try {
                    this.aAe.socketClose();
                    com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "destroy socketClose ok");
                } catch (Exception e2) {
                    this.aAe.a((com.baidu.lcp.sdk.connect.e) null);
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
            f.this.ah("read and write thread timeout:", this.host);
        }
    }

    public void pingRequest() {
        com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "customPingRunnable send PingRequest ");
        b(this.azX.f(this.context, 3L));
    }
}
