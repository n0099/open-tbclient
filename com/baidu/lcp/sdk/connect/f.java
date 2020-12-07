package com.baidu.lcp.sdk.connect;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.imsdk.upload.utils.RequsetNetworkUtils;
import com.baidu.lcp.sdk.a.a;
import com.baidu.lcp.sdk.client.bean.BLCPRequest;
import com.baidu.lcp.sdk.connect.a;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Observable;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes14.dex */
public final class f extends Observable {
    private static volatile com.baidu.lcp.sdk.client.b ayW = new com.baidu.lcp.sdk.client.b();
    private static volatile f azW = null;
    private C0170f azK;
    private e azL;
    private com.baidu.lcp.sdk.connect.d azO;
    private c azR;
    private long azS;
    private long azX;
    private Context context;
    private final Map<Integer, Boolean> azC = new TreeMap();
    private AtomicInteger mConnectId = new AtomicInteger(0);
    private int azD = 0;
    private boolean azE = false;
    private volatile LinkedList<com.baidu.lcp.sdk.connect.b> azF = new LinkedList<>();
    private final HashMap<Long, com.baidu.lcp.sdk.connect.b> azG = new LinkedHashMap();
    private final Object mOutputSync = new Object();
    private final Object mSync = new Object();
    private com.baidu.lcp.sdk.pb.f azH = new com.baidu.lcp.sdk.pb.f();
    private Map<Long, com.baidu.lcp.sdk.client.bean.b> azI = new LinkedHashMap();
    private Map<Long, com.baidu.lcp.sdk.client.bean.b> azJ = new LinkedHashMap();
    private d azM = new d();
    private boolean mClose = false;
    private AtomicInteger azN = new AtomicInteger(0);
    private int mDelayTimes = -1;
    private g azP = new g();
    public String azT = "";
    public String azU = "";
    public String azV = "";
    private Runnable azY = new Runnable() { // from class: com.baidu.lcp.sdk.connect.f.2
        @Override // java.lang.Runnable
        public void run() {
            f.this.Aw();
        }
    };
    private Runnable azZ = new Runnable() { // from class: com.baidu.lcp.sdk.connect.f.3
        @Override // java.lang.Runnable
        public void run() {
            f.this.b(f.this.azH.d(f.this.context, 1L));
        }
    };
    private HandlerThread azQ = new HandlerThread("LCP HandlerThread");

    private f(Context context) {
        this.context = context;
        this.azQ.start();
        this.azR = new c(this.azQ.getLooper());
    }

    public static synchronized f aG(Context context) {
        f fVar;
        synchronized (f.class) {
            if (azW == null) {
                azW = new f(context.getApplicationContext());
            }
            fVar = azW;
        }
        return fVar;
    }

    public void At() {
        if (com.baidu.lcp.sdk.d.e.aC(this.context)) {
            Au();
            Aw();
        }
    }

    private void Au() {
        this.azD = 0;
        this.azN.set(0);
        com.baidu.lcp.sdk.connect.a.An();
    }

    private synchronized void Av() {
        this.azX = System.currentTimeMillis();
        if (!this.azU.isEmpty() && !this.azV.isEmpty() && com.baidu.lcp.sdk.connect.a.Ao()) {
            com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "10N_2", "connecting");
            ag(this.azU, this.azV);
        } else {
            com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "10N_1", "connecting");
            com.baidu.lcp.sdk.d.d.w("SocketTransceiver", "protocolOption  thread :" + Thread.activeCount() + ", cur :" + Thread.currentThread() + "， protocol count :" + this.azD);
            String[] split = com.baidu.lcp.sdk.d.e.k(this.context, this.azD).split(":");
            if (split.length >= 3) {
                String str = TextUtils.isEmpty(split[0]) ? "tcp" : split[0];
                String str2 = split[1];
                String str3 = split[2];
                if (this.azD >= com.baidu.lcp.sdk.d.e.aN(this.context)) {
                    this.azD = 0;
                    com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "10N_1", "connect failed, connectip:" + str2 + ", port:" + str3 + ", protocolType:" + str);
                    com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "protocolOption failed, connectip:" + str2 + ", port:" + str3 + ", protocolType:" + str);
                    this.azO = new com.baidu.lcp.sdk.connect.g(this.context, "tls");
                    this.azU = "lcs.baidu.com";
                    this.azV = "443";
                    ag("lcs.baidu.com", "443");
                } else {
                    if ("quic".equals(str) && !(this.azO instanceof QuicMessageHandler)) {
                        this.azO = new QuicMessageHandler(this.context);
                    } else if ("tcp".equals(str) || ("tls".equals(str) && !(this.azO instanceof com.baidu.lcp.sdk.connect.g))) {
                        this.azO = new com.baidu.lcp.sdk.connect.g(this.context, str);
                    }
                    this.azD++;
                    if (this.azO != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                        com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "type :" + str + ", host :" + str2 + ", port :" + str3);
                        this.azU = str2;
                        this.azV = str3;
                        ag(str2, str3);
                    } else {
                        this.azU = "";
                        this.azV = "";
                        Av();
                    }
                }
            }
        }
    }

    private synchronized void ag(final String str, final String str2) {
        com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "10Y", "DNS begin");
        com.baidu.lcp.sdk.connect.a.aD(this.context).a(str, new a.d() { // from class: com.baidu.lcp.sdk.connect.f.1
            @Override // com.baidu.lcp.sdk.connect.a.d
            public void c(int i, String str3, String str4) {
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "-----try to connect ip:" + str4);
                if (TextUtils.isEmpty(str4)) {
                    str4 = str;
                }
                f.this.azT = str4;
                com.baidu.lcp.sdk.a.d.writeLoginFlag(f.this.context, "14N_0", "socketConnect :" + f.this.azT);
                if (i == 0) {
                    com.baidu.lcp.sdk.c.a.aH(f.this.context).submitForNetWork(new a(str4, str2, Integer.valueOf(f.this.mConnectId.incrementAndGet())));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Aw() {
        if (!RequsetNetworkUtils.isConnected(this.context)) {
            Au();
        } else if (ayW.state == 0 || ayW.state == -2) {
            com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "connectImpl connect state:" + ayW.state);
            com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "17N_2", "connectState is " + ayW.state);
        } else {
            com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "10N_0", "connect begin");
            this.azR.removeCallbacks(this.azY);
            this.azR.removeCallbacks(this.azZ);
            this.azR.removeCallbacks(this.azM);
            Av();
        }
    }

    public synchronized void b(BLCPRequest bLCPRequest, com.baidu.lcp.sdk.client.bean.b bVar) {
        if (com.baidu.lcp.sdk.d.e.aC(this.context)) {
            com.baidu.lcp.sdk.connect.b bVar2 = new com.baidu.lcp.sdk.connect.b();
            bVar2.serviceId = bLCPRequest.serviceId;
            bVar2.methodId = bLCPRequest.methodId;
            bVar2.azr = bLCPRequest.azd;
            if (bLCPRequest.msgId < 0) {
                bVar2.msgId = System.currentTimeMillis();
            } else {
                bVar2.msgId = bLCPRequest.msgId;
            }
            switch (bLCPRequest.aze) {
                case TIMEOUT_20s:
                    bVar2.azs = 20000L;
                    break;
                case TIMEOUT_30s:
                    bVar2.azs = 30000L;
                    break;
                case TIMEOUT_50s:
                    bVar2.azs = 50000L;
                    break;
                default:
                    bVar2.azs = 5000L;
                    break;
            }
            if (bLCPRequest instanceof com.baidu.lcp.sdk.client.bean.a) {
                bVar2.msgId = (bVar2.serviceId * 10000) + bVar2.methodId;
                a(bVar2.serviceId, bVar2.methodId, bVar2.msgId, true, bVar);
            } else if (bLCPRequest instanceof com.baidu.lcp.sdk.client.bean.c) {
                b(this.azH.a(bVar2, false));
            } else {
                a(bVar2.serviceId, bVar2.methodId, bVar2.msgId, false, bVar);
                b(this.azH.a(bVar2, true));
            }
        }
    }

    private void a(long j, long j2, long j3, boolean z, com.baidu.lcp.sdk.client.bean.b bVar) {
        Long valueOf = Long.valueOf(j3);
        if (z) {
            if (bVar != null) {
                this.azJ.put(valueOf, bVar);
            }
        } else {
            this.azI.put(valueOf, bVar);
        }
        com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "isNotify:" + z + ", methodId:" + j2 + ", invoke keys :" + this.azI.keySet().toString() + ", notify keys :" + this.azJ.keySet().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(com.baidu.lcp.sdk.connect.b bVar) {
        try {
            synchronized (this.azF) {
                boolean z = false;
                Iterator<com.baidu.lcp.sdk.connect.b> it = this.azF.iterator();
                while (it.hasNext()) {
                    com.baidu.lcp.sdk.connect.b next = it.next();
                    com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "sendMessage queue :" + next.msgId);
                    z = next.azx ? true : z;
                }
                if (bVar.azx) {
                    if (z || ayW.state != -1) {
                        com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "sendMessage cur methodId :1, state :" + ayW.state);
                    } else {
                        this.azF.addFirst(bVar);
                        this.azF.notifyAll();
                        com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "16Y_2", "send Logig msg");
                    }
                } else if (ayW.state == -1) {
                    if (Ay()) {
                        if (this.azF.size() <= 0 || !z) {
                            this.azF.addFirst(this.azH.d(this.context, 1L));
                            this.azF.notifyAll();
                            com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "16Y_3", "heart rate and send Logig msg");
                        }
                        if (!bVar.isHeartbeat) {
                            this.azF.add(bVar);
                            this.azF.notifyAll();
                        }
                    } else {
                        if (bVar.isHeartbeat) {
                            Av();
                        }
                        this.azF.add(bVar);
                    }
                } else {
                    this.azF.add(bVar);
                    this.azF.notifyAll();
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
        if (bVar.errorCode == 0) {
            long j = bVar.azv > 0 ? bVar.azv : 60000L;
            if (bVar.methodId == 1) {
                a(j, true, str);
            } else if (bVar.methodId == 2) {
                ah("LCP logout:", str);
                ayW.state = bVar.azw;
                setChanged();
                notifyObservers(ayW);
                Ax();
            } else if (bVar.methodId == 3) {
                this.azM.ab(j);
            }
        } else if (String.valueOf(bVar.errorCode).startsWith("30") || bVar.errorCode == 1011) {
            com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "login error, then request token, error :" + bVar.errorCode);
            ah("errorCode:" + String.valueOf(bVar.errorCode), str);
            com.baidu.lcp.sdk.d.e.D(this.context, "");
            com.baidu.lcp.sdk.client.c.Ak().Am();
        } else if (bVar.errorCode == 1012) {
            com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "login error :" + bVar.errorCode);
        } else if (bVar.errorCode == 1013) {
            a(60000L, false, str);
        } else {
            ayW.state = -1;
            setChanged();
            notifyObservers(ayW);
            Ax();
            ba(true);
        }
    }

    private void a(long j, boolean z, String str) {
        try {
            this.azN.set(0);
            ayW.state = 0;
            setChanged();
            notifyObservers(ayW);
            Ax();
            if (z) {
                this.azR.setHost(str);
                this.azR.postDelayed(this.azM, j);
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "ping every 1分钟 ");
                com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "17Y", "login success");
                new a.b(this.context).fH("login ok").fI(OneKeyLoginSdkCall.k).X(System.currentTimeMillis()).Y(System.currentTimeMillis()).Z(0L).fJ("").aa(501111L).build();
            }
        } catch (Exception e2) {
            com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "handleLcpLoginSuccess Exception :" + e2);
        }
    }

    public void Ax() {
        Intent intent = new Intent();
        intent.putExtra("com.baidu.lcp.sdk.connect.state", ayW.state);
        intent.setAction("com.baidu.lcp.sdk.broadcast");
        LocalBroadcastManager.getInstance(this.context).sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, String str) {
        try {
            if (this.azG.size() > 0 && this.azG.containsKey(Long.valueOf(j))) {
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "handle msg timeout!!! " + this.azG.get(Long.valueOf(j)).toString());
                com.baidu.lcp.sdk.connect.b remove = this.azG.remove(Long.valueOf(j));
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
            if (this.azG.size() > 0 && this.azG.containsKey(Long.valueOf(j))) {
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "handle msg exception!!! " + this.azG.get(Long.valueOf(j)).toString());
                com.baidu.lcp.sdk.connect.b remove = this.azG.remove(Long.valueOf(j));
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
            if (this.azG.size() > 0 && this.azG.containsKey(Long.valueOf(j))) {
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "handle msg socket stoped!!! " + this.azG.get(Long.valueOf(j)).toString());
                com.baidu.lcp.sdk.connect.b remove = this.azG.remove(Long.valueOf(j));
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
            Long valueOf = Long.valueOf(!bVar.azt ? bVar.msgId : (bVar.serviceId * 10000) + bVar.methodId);
            com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "onBLCPResponse key:" + valueOf + ", msgId :" + bVar.msgId + ", invoke keys :" + this.azI.keySet().toString() + ", notify keys :" + this.azJ.keySet().toString());
            if (this.azJ.size() > 0 && this.azJ.containsKey(valueOf)) {
                remove = this.azJ.get(valueOf);
            } else {
                remove = (this.azI.size() <= 0 || !this.azI.containsKey(valueOf)) ? null : this.azI.remove(valueOf);
            }
            if (remove != null) {
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "onBLCPResponse methodId :" + bVar.methodId + ", serviceId :" + bVar.serviceId + ", error :" + bVar.errorCode + ", msgId :" + bVar.msgId + ", errMsg :" + bVar.errorMsg + ", invoke keys :" + this.azI.keySet().toString());
                remove.onResponse(bVar.errorCode, bVar.errorMsg, bVar.serviceId, bVar.methodId, bVar.msgId, bVar.azu);
                if (bVar.errorCode == 1011) {
                    com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "onBLCPResponse errorCode :" + bVar.errorCode + ", and will send lcm login msg .");
                    b(this.azH.d(this.context, 1L));
                }
            }
        } catch (Exception e2) {
            com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "onBLCPResponse Exception!!!", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
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
    /* loaded from: classes14.dex */
    public class d implements Runnable {
        private long azv;

        private d() {
            this.azv = 60000L;
        }

        public void ab(long j) {
            this.azv = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.azR.removeCallbacks(f.this.azM);
            if (com.baidu.lcp.sdk.d.e.aC(f.this.context)) {
                f.this.azR.postDelayed(f.this.azM, this.azv);
                f.this.b(f.this.azH.d(f.this.context, 3L));
            }
        }
    }

    /* loaded from: classes14.dex */
    private class b implements Runnable {
        Integer aAe;
        boolean aAg = false;
        String host;

        b(Integer num, String str) {
            this.aAe = num;
            this.host = str;
        }

        void AA() {
            this.aAg = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (f.this.azC) {
                if (!this.aAg && f.ayW.state != 0) {
                    f.this.azC.put(this.aAe, true);
                    com.baidu.lcp.sdk.a.d.writeLoginFlag(f.this.context, "14N_1", "socketConnect_timeout :" + f.this.azT);
                    f.this.d(401214, "time out", this.host);
                    f.this.ai("time out:", this.host);
                    return;
                }
                com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "ConnectTimeOutTask has stoped");
                f.this.azR.removeCallbacks(this);
            }
        }
    }

    /* loaded from: classes14.dex */
    final class a implements Runnable {
        private String aAd;
        private Integer aAe;
        private String host;

        public a(String str, String str2, Integer num) {
            this.host = str;
            this.aAd = str2;
            this.aAe = num;
        }

        @Override // java.lang.Runnable
        public synchronized void run() {
            try {
                if (!f.this.Ay()) {
                    if (f.this.azL != null && f.this.azL.isAlive()) {
                        f.this.azL.interrupt();
                        com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "readThread interrupt");
                    }
                    if (f.this.azK != null && f.this.azK.isAlive()) {
                        f.this.azK.interrupt();
                        com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "sendThread interrupt");
                    }
                    b bVar = new b(this.aAe, this.host);
                    f.this.azR.setHost(this.host);
                    f.this.azR.postDelayed(bVar, 5000L);
                    try {
                        com.baidu.lcp.sdk.a.d.writeLoginFlag(f.this.context, "14N", "socketConnect :" + f.this.azT);
                        com.baidu.lcp.sdk.connect.e y = f.this.azO.y(this.host, Integer.valueOf(this.aAd).intValue());
                        if (f.this.Ay()) {
                            com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "socketConnect after, but socket has created ok.");
                            f.this.b(y);
                        } else if (!y.azB.booleanValue()) {
                            com.baidu.lcp.sdk.a.d.writeLoginFlag(f.this.context, "15N", "connect env error");
                            f.this.d(401213, "connect env error", this.host);
                            f.this.azR.removeCallbacks(bVar);
                            f.this.ah("connect env error:", this.host);
                        } else {
                            synchronized (f.this.azC) {
                                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "socketNeedCloseMap remove connectTimeoutTask");
                                f.this.azR.removeCallbacks(bVar);
                                bVar.AA();
                                if (!f.this.Ay()) {
                                    if (f.this.azC.get(this.aAe) == null) {
                                        com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "socketNeedCloseMap setCurrentSocketState");
                                        f.this.azO.a(y);
                                    }
                                    com.baidu.lcp.sdk.d.e.m(f.this.context, f.this.azN.get() == 0 ? 1 : 2);
                                    com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "create Socket ok");
                                    f.this.d(401211, "connect ok", this.host);
                                    com.baidu.lcp.sdk.a.d.writeLoginFlag(f.this.context, "16Y", "connect ok");
                                    com.baidu.lcp.sdk.connect.a.C(f.this.context, this.host);
                                    f.this.b(f.this.azH.d(f.this.context, 1L));
                                    f.this.azS = SystemClock.currentThreadTimeMillis();
                                    if (com.baidu.lcp.sdk.d.b.aK(f.this.context) != 0) {
                                        com.baidu.lcp.sdk.c.a.aH(f.this.context).submitForNetWork(new Runnable() { // from class: com.baidu.lcp.sdk.connect.f.a.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                com.baidu.lcp.sdk.d.c.aL(f.this.context);
                                                com.baidu.lcp.sdk.d.c.write("lcp connect:" + (System.currentTimeMillis() - f.this.azX));
                                            }
                                        });
                                    }
                                    com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "connectImpl time:" + f.this.azS);
                                    f.ayW.state = -2;
                                    f.this.mClose = false;
                                    f.this.azK = new C0170f(this.host);
                                    f.this.azK.start();
                                    f.this.azL = new e(this.host);
                                    f.this.azL.start();
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
    public boolean Ay() {
        return (this.azO == null || this.azO.As() == null || this.azO.As().socket == null || !this.azO.As().socket.isConnected()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.lcp.sdk.connect.e eVar) {
        if (eVar != null && eVar.azA.booleanValue()) {
            try {
                if (eVar.socket != null) {
                    if (eVar.socket.hashCode() == this.azO.As().socket.hashCode()) {
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
        this.azT += ":" + com.baidu.lcp.sdk.connect.a.Ap() + ":" + RequsetNetworkUtils.getNetInfo(this.context);
        com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "connectTrack ext:" + this.azT + ", retry :" + this.azN.get() + ", reason :" + str);
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        new a.C0166a(this.context).T(this.azS).U(System.currentTimeMillis()).W(i).fF(str).fG(str2).V(this.azN.get()).build();
        if (com.baidu.lcp.sdk.a.d.i(this.context, 401216) && this.azN.get() >= 5 && i != 401211) {
            com.baidu.lcp.sdk.a.b.a(this.context, IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.CONNECTION).setConnection(IMPushPb.Connection.newBuilder().setStartTime(this.azS).setStopTime(System.currentTimeMillis()).setAliasId(401216L).setReason(str).setExt(str2).setRetryCount(this.azN.get()).build()).build());
        }
        this.azT = "";
    }

    /* loaded from: classes14.dex */
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
                        com.baidu.lcp.sdk.connect.b h = f.this.azH.h(f.this.azO.Ar());
                        if (h != null && h.msgId > 0) {
                            f.this.azR.removeCallbacks(f.this.azP);
                            h.azy = false;
                            com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "ReadThread :" + h.toString());
                            if (!h.isHeartbeat) {
                                if (h.azx) {
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
                                    bVar = (com.baidu.lcp.sdk.connect.b) f.this.azG.remove(Long.valueOf(h.msgId));
                                }
                                f.this.a(h, bVar, this.host);
                            }
                            synchronized (f.this.mSync) {
                                if (f.this.azG.size() != 0) {
                                    com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "ReadThread socketTimeoutRunnable ...");
                                    f.this.azP.setMsgId(h.msgId);
                                    f.this.azP.setHost(this.host);
                                    f.this.azR.setHost(this.host);
                                    f.this.azR.postDelayed(f.this.azP, h.azs);
                                }
                            }
                        }
                    } catch (Exception e) {
                        if (!f.this.mClose) {
                            com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "ReadThread exception: " + e, e);
                            f.this.azE = false;
                            f.this.ai("ReadThread exception: " + e, this.host);
                            return;
                        }
                        return;
                    }
                } catch (Exception e2) {
                    if (!f.this.mClose) {
                        com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "onStartCommand", e2);
                        f.this.azE = false;
                        f.this.ai("onStartCommand:" + e2, this.host);
                        return;
                    }
                    return;
                }
            }
        }
    }

    /* renamed from: com.baidu.lcp.sdk.connect.f$f  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    class C0170f extends Thread {
        private String host;

        C0170f(String str) {
            this.host = str;
            setName("LCP-SocketTransceiver-SendThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!f.this.mClose) {
                try {
                    com.baidu.lcp.sdk.connect.b bVar = null;
                    try {
                        synchronized (f.this.azF) {
                            if (f.this.azF.size() == 0) {
                                f.this.azF.wait();
                            } else {
                                bVar = (com.baidu.lcp.sdk.connect.b) f.this.azF.removeFirst();
                            }
                        }
                    } catch (InterruptedException e) {
                        com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "SendThread wait exception: " + e);
                        f.this.ai("SendThread wait exception: " + e, this.host);
                    }
                    if (bVar != null) {
                        try {
                            if (f.this.mClose) {
                                f.this.c(bVar.msgId, this.host);
                                return;
                            }
                            bVar.azy = true;
                            bVar.azw = f.ayW.state;
                            if (bVar.needReplay) {
                                synchronized (f.this.mSync) {
                                    if (f.this.azG.isEmpty()) {
                                        f.this.azR.removeCallbacks(f.this.azP);
                                        f.this.azP.setMsgId(bVar.msgId);
                                        f.this.azP.setHost(this.host);
                                        f.this.azR.setHost(this.host);
                                        f.this.azR.postDelayed(f.this.azP, 5000L);
                                    }
                                }
                            }
                            com.baidu.lcp.sdk.d.d.v("SocketTransceiver", "SendThread :" + bVar.toString());
                            if (bVar.azx) {
                                com.baidu.lcp.sdk.a.d.writeLoginFlag(f.this.context, "17N", "Send LoginMsg request");
                            }
                            if (bVar.methodId == 1 && bVar.serviceId == 4) {
                                com.baidu.lcp.sdk.d.a.a(f.this.context, 1L, UbcStatConstant.ContentType.UBC_TYPE_IM_SEND, bVar.msgId + "");
                            }
                            if (bVar.methodId == 50 && bVar.serviceId == 2) {
                                com.baidu.lcp.sdk.d.a.a(f.this.context, 50L, UbcStatConstant.ContentType.UBC_TYPE_IM_SEND, bVar.msgId + "");
                            }
                            synchronized (f.this.mOutputSync) {
                                f.this.azO.a(bVar);
                            }
                            if (!bVar.isHeartbeat && bVar.needReplay) {
                                synchronized (f.this.mSync) {
                                    f.this.azG.put(Long.valueOf(bVar.msgId), bVar);
                                }
                            }
                        } catch (Exception e2) {
                            com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "SendThread sendMessage Exception:", e2);
                            f.this.c(bVar.msgId, e2.toString(), this.host);
                            f.this.ai("SendThread sendMessage Exception:" + e2, this.host);
                            return;
                        }
                    }
                } catch (Exception e3) {
                    com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "SendThread Exception:", e3);
                    f.this.ai("SendThread Exception:" + e3, this.host);
                    return;
                }
            }
        }
    }

    private void fL(String str) {
        try {
            com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "fatalAllMessage begin ");
            synchronized (this.azF) {
                while (this.azF.size() > 0) {
                    b(this.azF.removeFirst(), str);
                }
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "fatalAllMessage sendQueue end ");
            }
            synchronized (this.mSync) {
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "fatalAllMessage mSync begin");
                for (Long l : this.azG.keySet()) {
                    b(this.azG.get(l), str);
                }
                this.azG.clear();
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

    public synchronized void ah(String str, String str2) {
        if (com.baidu.lcp.sdk.d.e.aC(this.context)) {
            com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "---socketDisconnect---");
            this.mClose = true;
            this.azE = true;
            fL(str2);
            Au();
            this.azR.removeCallbacks(this.azY);
            this.azR.removeCallbacks(this.azZ);
            this.azR.removeCallbacks(this.azM);
            com.baidu.lcp.sdk.connect.a.e(this.context, null, false);
            aj(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ai(String str, String str2) {
        com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "disconnectedByLcp, destroyConnection = " + this.azE + ", net :" + RequsetNetworkUtils.isConnected(this.context) + ", isSmallFlow :" + com.baidu.lcp.sdk.d.e.aC(this.context));
        if (com.baidu.lcp.sdk.d.e.aC(this.context)) {
            fL(str2);
            if (this.azE) {
                Au();
            } else {
                aj(str, str2);
                if (!RequsetNetworkUtils.isConnected(this.context)) {
                    Au();
                } else {
                    ba(false);
                }
            }
        }
    }

    private void ba(boolean z) {
        try {
            this.azN.incrementAndGet();
            if (this.azN.get() <= 10 && ayW.state == -1) {
                long dy = dy(this.azN.get());
                this.azR.removeCallbacks(this.azM);
                this.azR.removeCallbacks(z ? this.azY : this.azZ);
                this.azR.postDelayed(z ? this.azZ : this.azY, dy);
                com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "Schedule retry " + (z ? OneKeyLoginSdkCall.k : "connect") + " -- retry times: " + this.azN.get() + " time delay: " + dy);
            }
        } catch (Exception e2) {
            com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "retry Exception", e2);
        }
    }

    private long dy(int i) {
        if (i < 3) {
            return i * 1000;
        }
        return IMConnection.RETRY_DELAY_TIMES;
    }

    private synchronized void aj(String str, String str2) {
        if (com.baidu.lcp.sdk.d.e.aC(this.context)) {
            com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "destroy");
            d(401212, "connect stop, " + str, str2);
            ayW.state = -1;
            setChanged();
            notifyObservers(ayW);
            Ax();
            this.azR.removeCallbacks(this.azP);
            this.mClose = true;
            if (this.azO != null) {
                synchronized (this.azF) {
                    this.azF.notifyAll();
                    com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "destroy notifyAll");
                }
                try {
                    this.azO.socketClose();
                    com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "destroy socketClose ok");
                } catch (Exception e2) {
                    this.azO.a((com.baidu.lcp.sdk.connect.e) null);
                    com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "Exception destroy:", e2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
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
            f.this.ai("read and write thread timeout:", this.host);
        }
    }

    public void pingRequest() {
        com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "customPingRunnable send PingRequest ");
        b(this.azH.d(this.context, 3L));
    }
}
