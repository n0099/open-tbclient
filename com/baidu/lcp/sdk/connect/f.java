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
    private static volatile com.baidu.lcp.sdk.client.b auz = new com.baidu.lcp.sdk.client.b();
    private static volatile f avz = null;
    private long avA;
    private C0153f avn;
    private e avo;
    private com.baidu.lcp.sdk.connect.d avr;
    private c avu;
    private long avv;
    private Context context;
    private final Map<Integer, Boolean> avf = new TreeMap();
    private AtomicInteger mConnectId = new AtomicInteger(0);
    private int avg = 0;
    private boolean avh = false;
    private volatile LinkedList<com.baidu.lcp.sdk.connect.b> avi = new LinkedList<>();
    private final HashMap<Long, com.baidu.lcp.sdk.connect.b> avj = new LinkedHashMap();
    private final Object mOutputSync = new Object();
    private final Object mSync = new Object();
    private com.baidu.lcp.sdk.pb.f avk = new com.baidu.lcp.sdk.pb.f();
    private Map<Long, com.baidu.lcp.sdk.client.bean.b> avl = new LinkedHashMap();
    private Map<Long, com.baidu.lcp.sdk.client.bean.b> avm = new LinkedHashMap();
    private d avp = new d();
    private boolean mClose = false;
    private AtomicInteger avq = new AtomicInteger(0);
    private int mDelayTimes = -1;
    private g avs = new g();
    public String avw = "";
    public String avx = "";
    public String avy = "";
    private Runnable avB = new Runnable() { // from class: com.baidu.lcp.sdk.connect.f.2
        @Override // java.lang.Runnable
        public void run() {
            f.this.vP();
        }
    };
    private Runnable avC = new Runnable() { // from class: com.baidu.lcp.sdk.connect.f.3
        @Override // java.lang.Runnable
        public void run() {
            f.this.b(f.this.avk.f(f.this.context, 1L));
        }
    };
    private HandlerThread avt = new HandlerThread("LCP HandlerThread");

    private f(Context context) {
        this.context = context;
        this.avt.start();
        this.avu = new c(this.avt.getLooper());
    }

    public static synchronized f aE(Context context) {
        f fVar;
        synchronized (f.class) {
            if (avz == null) {
                avz = new f(context.getApplicationContext());
            }
            fVar = avz;
        }
        return fVar;
    }

    public void vM() {
        if (com.baidu.lcp.sdk.d.e.aA(this.context)) {
            vN();
            vP();
        }
    }

    private void vN() {
        this.avg = 0;
        this.avq.set(0);
        com.baidu.lcp.sdk.connect.a.vG();
    }

    private synchronized void vO() {
        this.avA = System.currentTimeMillis();
        if (!this.avx.isEmpty() && !this.avy.isEmpty() && com.baidu.lcp.sdk.connect.a.vH()) {
            com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "10N_2", "connecting");
            ad(this.avx, this.avy);
        } else {
            com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "10N_1", "connecting");
            com.baidu.lcp.sdk.d.d.w("SocketTransceiver", "protocolOption  thread :" + Thread.activeCount() + ", cur :" + Thread.currentThread() + "， protocol count :" + this.avg);
            String[] split = com.baidu.lcp.sdk.d.e.k(this.context, this.avg).split(":");
            if (split.length >= 3) {
                String str = TextUtils.isEmpty(split[0]) ? "tcp" : split[0];
                String str2 = split[1];
                String str3 = split[2];
                if (this.avg >= com.baidu.lcp.sdk.d.e.aL(this.context)) {
                    this.avg = 0;
                    com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "10N_1", "connect failed, connectip:" + str2 + ", port:" + str3 + ", protocolType:" + str);
                    com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "protocolOption failed, connectip:" + str2 + ", port:" + str3 + ", protocolType:" + str);
                    this.avr = new com.baidu.lcp.sdk.connect.g(this.context, "tls");
                    this.avx = "lcs.baidu.com";
                    this.avy = "443";
                    ad("lcs.baidu.com", "443");
                } else {
                    if ("quic".equals(str) && !(this.avr instanceof QuicMessageHandler)) {
                        this.avr = new QuicMessageHandler(this.context);
                    } else if ("tcp".equals(str) || ("tls".equals(str) && !(this.avr instanceof com.baidu.lcp.sdk.connect.g))) {
                        this.avr = new com.baidu.lcp.sdk.connect.g(this.context, str);
                    }
                    this.avg++;
                    if (this.avr != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                        com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "type :" + str + ", host :" + str2 + ", port :" + str3);
                        this.avx = str2;
                        this.avy = str3;
                        ad(str2, str3);
                    } else {
                        this.avx = "";
                        this.avy = "";
                        vO();
                    }
                }
            }
        }
    }

    private synchronized void ad(final String str, final String str2) {
        com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "10Y", "DNS begin");
        com.baidu.lcp.sdk.connect.a.aB(this.context).a(str, new a.d() { // from class: com.baidu.lcp.sdk.connect.f.1
            @Override // com.baidu.lcp.sdk.connect.a.d
            public void c(int i, String str3, String str4) {
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "-----try to connect ip:" + str4);
                if (TextUtils.isEmpty(str4)) {
                    str4 = str;
                }
                f.this.avw = str4;
                com.baidu.lcp.sdk.a.d.writeLoginFlag(f.this.context, "14N_0", "socketConnect :" + f.this.avw);
                if (i == 0) {
                    com.baidu.lcp.sdk.c.a.aF(f.this.context).submitForNetWork(new a(str4, str2, Integer.valueOf(f.this.mConnectId.incrementAndGet())));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void vP() {
        if (!RequsetNetworkUtils.isConnected(this.context)) {
            vN();
        } else if (auz.state == 0 || auz.state == -2) {
            com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "connectImpl connect state:" + auz.state);
            com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "17N_2", "connectState is " + auz.state);
        } else {
            com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "10N_0", "connect begin");
            this.avu.removeCallbacks(this.avB);
            this.avu.removeCallbacks(this.avC);
            this.avu.removeCallbacks(this.avp);
            vO();
        }
    }

    public synchronized void b(BLCPRequest bLCPRequest, com.baidu.lcp.sdk.client.bean.b bVar) {
        if (com.baidu.lcp.sdk.d.e.aA(this.context)) {
            com.baidu.lcp.sdk.connect.b bVar2 = new com.baidu.lcp.sdk.connect.b();
            bVar2.serviceId = bLCPRequest.serviceId;
            bVar2.methodId = bLCPRequest.methodId;
            bVar2.auU = bLCPRequest.auG;
            if (bLCPRequest.msgId < 0) {
                bVar2.msgId = System.currentTimeMillis();
            } else {
                bVar2.msgId = bLCPRequest.msgId;
            }
            switch (bLCPRequest.auH) {
                case TIMEOUT_20s:
                    bVar2.auV = 20000L;
                    break;
                case TIMEOUT_30s:
                    bVar2.auV = 30000L;
                    break;
                case TIMEOUT_50s:
                    bVar2.auV = 50000L;
                    break;
                default:
                    bVar2.auV = 5000L;
                    break;
            }
            if (bLCPRequest instanceof com.baidu.lcp.sdk.client.bean.a) {
                bVar2.msgId = (bVar2.serviceId * 10000) + bVar2.methodId;
                a(bVar2.serviceId, bVar2.methodId, bVar2.msgId, true, bVar);
            } else if (bLCPRequest instanceof com.baidu.lcp.sdk.client.bean.c) {
                b(this.avk.a(bVar2, false));
            } else {
                a(bVar2.serviceId, bVar2.methodId, bVar2.msgId, false, bVar);
                b(this.avk.a(bVar2, true));
            }
        }
    }

    private void a(long j, long j2, long j3, boolean z, com.baidu.lcp.sdk.client.bean.b bVar) {
        Long valueOf = Long.valueOf(j3);
        if (z) {
            if (bVar != null) {
                this.avm.put(valueOf, bVar);
            }
        } else {
            this.avl.put(valueOf, bVar);
        }
        com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "isNotify:" + z + ", methodId:" + j2 + ", invoke keys :" + this.avl.keySet().toString() + ", notify keys :" + this.avm.keySet().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(com.baidu.lcp.sdk.connect.b bVar) {
        try {
            synchronized (this.avi) {
                boolean z = false;
                Iterator<com.baidu.lcp.sdk.connect.b> it = this.avi.iterator();
                while (it.hasNext()) {
                    com.baidu.lcp.sdk.connect.b next = it.next();
                    com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "sendMessage queue :" + next.msgId);
                    z = next.ava ? true : z;
                }
                if (bVar.ava) {
                    if (z || auz.state != -1) {
                        com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "sendMessage cur methodId :1, state :" + auz.state);
                    } else {
                        this.avi.addFirst(bVar);
                        this.avi.notifyAll();
                        com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "16Y_2", "send Logig msg");
                    }
                } else if (auz.state == -1) {
                    if (vR()) {
                        if (this.avi.size() <= 0 || !z) {
                            this.avi.addFirst(this.avk.f(this.context, 1L));
                            this.avi.notifyAll();
                            com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "16Y_3", "heart rate and send Logig msg");
                        }
                        if (!bVar.isHeartbeat) {
                            this.avi.add(bVar);
                            this.avi.notifyAll();
                        }
                    } else {
                        if (bVar.isHeartbeat) {
                            vO();
                        }
                        this.avi.add(bVar);
                    }
                } else {
                    this.avi.add(bVar);
                    this.avi.notifyAll();
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
            if (bVar.auY > 0) {
                j = bVar.auY;
            }
            if (bVar.methodId == 1) {
                a(j, true, str);
            } else if (bVar.methodId == 2) {
                af("LCP logout:", str);
                auz.state = bVar.auZ;
                setChanged();
                notifyObservers(auz);
                vQ();
            } else if (bVar.methodId == 3) {
                this.avp.aa(j);
            }
        } else if (String.valueOf(bVar.errorCode).startsWith("30") || bVar.errorCode == 1011) {
            com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "login error, then request token, error :" + bVar.errorCode);
            af("errorCode:" + String.valueOf(bVar.errorCode), str);
            com.baidu.lcp.sdk.d.e.D(this.context, "");
            com.baidu.lcp.sdk.client.c.vD().vF();
        } else if (bVar.errorCode == 1012) {
            com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "login error :" + bVar.errorCode);
        } else if (bVar.errorCode == 1013) {
            a(AppStatusRules.DEFAULT_GRANULARITY, false, str);
        } else {
            auz.state = -1;
            setChanged();
            notifyObservers(auz);
            vQ();
            aT(true);
        }
    }

    private void a(long j, boolean z, String str) {
        try {
            this.avq.set(0);
            auz.state = 0;
            setChanged();
            notifyObservers(auz);
            vQ();
            if (z) {
                this.avu.setHost(str);
                this.avu.postDelayed(this.avp, j);
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "ping every 1分钟 ");
                com.baidu.lcp.sdk.a.d.writeLoginFlag(this.context, "17Y", "login success");
                new a.b(this.context).ef("login ok").eg(OneKeyLoginSdkCall.k).W(System.currentTimeMillis()).X(System.currentTimeMillis()).Y(0L).eh("").Z(501111L).build();
            }
        } catch (Exception e2) {
            com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "handleLcpLoginSuccess Exception :" + e2);
        }
    }

    public void vQ() {
        Intent intent = new Intent();
        intent.putExtra("com.baidu.lcp.sdk.connect.state", auz.state);
        intent.setAction("com.baidu.lcp.sdk.broadcast");
        LocalBroadcastManager.getInstance(this.context).sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, String str) {
        try {
            if (this.avj.size() > 0 && this.avj.containsKey(Long.valueOf(j))) {
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "handle msg timeout!!! " + this.avj.get(Long.valueOf(j)).toString());
                com.baidu.lcp.sdk.connect.b remove = this.avj.remove(Long.valueOf(j));
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
            if (this.avj.size() > 0 && this.avj.containsKey(Long.valueOf(j))) {
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "handle msg exception!!! " + this.avj.get(Long.valueOf(j)).toString());
                com.baidu.lcp.sdk.connect.b remove = this.avj.remove(Long.valueOf(j));
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
            if (this.avj.size() > 0 && this.avj.containsKey(Long.valueOf(j))) {
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "handle msg socket stoped!!! " + this.avj.get(Long.valueOf(j)).toString());
                com.baidu.lcp.sdk.connect.b remove = this.avj.remove(Long.valueOf(j));
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
            Long valueOf = Long.valueOf(!bVar.auW ? bVar.msgId : (bVar.serviceId * 10000) + bVar.methodId);
            com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "onBLCPResponse key:" + valueOf + ", msgId :" + bVar.msgId + ", invoke keys :" + this.avl.keySet().toString() + ", notify keys :" + this.avm.keySet().toString());
            if (this.avm.size() > 0 && this.avm.containsKey(valueOf)) {
                remove = this.avm.get(valueOf);
            } else {
                remove = (this.avl.size() <= 0 || !this.avl.containsKey(valueOf)) ? null : this.avl.remove(valueOf);
            }
            if (remove != null) {
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "onBLCPResponse methodId :" + bVar.methodId + ", serviceId :" + bVar.serviceId + ", error :" + bVar.errorCode + ", msgId :" + bVar.msgId + ", errMsg :" + bVar.errorMsg + ", invoke keys :" + this.avl.keySet().toString());
                remove.onResponse(bVar.errorCode, bVar.errorMsg, bVar.serviceId, bVar.methodId, bVar.msgId, bVar.auX);
                if (bVar.errorCode == 1011) {
                    com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "onBLCPResponse errorCode :" + bVar.errorCode + ", and will send lcm login msg .");
                    b(this.avk.f(this.context, 1L));
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
        private long auY;

        private d() {
            this.auY = AppStatusRules.DEFAULT_GRANULARITY;
        }

        public void aa(long j) {
            this.auY = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.avu.removeCallbacks(f.this.avp);
            if (com.baidu.lcp.sdk.d.e.aA(f.this.context)) {
                f.this.avu.postDelayed(f.this.avp, this.auY);
                f.this.b(f.this.avk.f(f.this.context, 3L));
            }
        }
    }

    /* loaded from: classes3.dex */
    private class b implements Runnable {
        Integer avH;
        boolean avJ = false;
        String host;

        b(Integer num, String str) {
            this.avH = num;
            this.host = str;
        }

        void vT() {
            this.avJ = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (f.this.avf) {
                if (!this.avJ && f.auz.state != 0) {
                    f.this.avf.put(this.avH, true);
                    com.baidu.lcp.sdk.a.d.writeLoginFlag(f.this.context, "14N_1", "socketConnect_timeout :" + f.this.avw);
                    f.this.d(401214, "time out", this.host);
                    f.this.ag("time out:", this.host);
                    return;
                }
                com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "ConnectTimeOutTask has stoped");
                f.this.avu.removeCallbacks(this);
            }
        }
    }

    /* loaded from: classes3.dex */
    final class a implements Runnable {
        private String avG;
        private Integer avH;
        private String host;

        public a(String str, String str2, Integer num) {
            this.host = str;
            this.avG = str2;
            this.avH = num;
        }

        @Override // java.lang.Runnable
        public synchronized void run() {
            try {
                if (!f.this.vR()) {
                    if (f.this.avo != null && f.this.avo.isAlive()) {
                        f.this.avo.interrupt();
                        com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "readThread interrupt");
                    }
                    if (f.this.avn != null && f.this.avn.isAlive()) {
                        f.this.avn.interrupt();
                        com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "sendThread interrupt");
                    }
                    b bVar = new b(this.avH, this.host);
                    f.this.avu.setHost(this.host);
                    f.this.avu.postDelayed(bVar, 5000L);
                    try {
                        com.baidu.lcp.sdk.a.d.writeLoginFlag(f.this.context, "14N", "socketConnect :" + f.this.avw);
                        com.baidu.lcp.sdk.connect.e y = f.this.avr.y(this.host, Integer.valueOf(this.avG).intValue());
                        if (f.this.vR()) {
                            com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "socketConnect after, but socket has created ok.");
                            f.this.b(y);
                        } else if (!y.ave.booleanValue()) {
                            com.baidu.lcp.sdk.a.d.writeLoginFlag(f.this.context, "15N", "connect env error");
                            f.this.d(401213, "connect env error", this.host);
                            f.this.avu.removeCallbacks(bVar);
                            f.this.af("connect env error:", this.host);
                        } else {
                            synchronized (f.this.avf) {
                                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "socketNeedCloseMap remove connectTimeoutTask");
                                f.this.avu.removeCallbacks(bVar);
                                bVar.vT();
                                if (!f.this.vR()) {
                                    if (f.this.avf.get(this.avH) == null) {
                                        com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "socketNeedCloseMap setCurrentSocketState");
                                        f.this.avr.a(y);
                                    }
                                    com.baidu.lcp.sdk.d.e.m(f.this.context, f.this.avq.get() == 0 ? 1 : 2);
                                    com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "create Socket ok");
                                    f.this.d(401211, "connect ok", this.host);
                                    com.baidu.lcp.sdk.a.d.writeLoginFlag(f.this.context, "16Y", "connect ok");
                                    com.baidu.lcp.sdk.connect.a.C(f.this.context, this.host);
                                    f.this.b(f.this.avk.f(f.this.context, 1L));
                                    f.this.avv = SystemClock.currentThreadTimeMillis();
                                    if (com.baidu.lcp.sdk.d.b.aI(f.this.context) != 0) {
                                        com.baidu.lcp.sdk.c.a.aF(f.this.context).submitForNetWork(new Runnable() { // from class: com.baidu.lcp.sdk.connect.f.a.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                com.baidu.lcp.sdk.d.c.aJ(f.this.context);
                                                com.baidu.lcp.sdk.d.c.write("lcp connect:" + (System.currentTimeMillis() - f.this.avA));
                                            }
                                        });
                                    }
                                    com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "connectImpl time:" + f.this.avv);
                                    f.auz.state = -2;
                                    f.this.mClose = false;
                                    f.this.avn = new C0153f(this.host);
                                    f.this.avn.start();
                                    f.this.avo = new e(this.host);
                                    f.this.avo.start();
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
        return (this.avr == null || this.avr.vL() == null || this.avr.vL().socket == null || !this.avr.vL().socket.isConnected()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.lcp.sdk.connect.e eVar) {
        if (eVar != null && eVar.avd.booleanValue()) {
            try {
                if (eVar.socket != null) {
                    if (eVar.socket.hashCode() == this.avr.vL().socket.hashCode()) {
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
        this.avw += ":" + com.baidu.lcp.sdk.connect.a.vI() + ":" + RequsetNetworkUtils.getNetInfo(this.context);
        com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "connectTrack ext:" + this.avw + ", retry :" + this.avq.get() + ", reason :" + str);
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        new a.C0149a(this.context).S(this.avv).T(System.currentTimeMillis()).V(i).ed(str).ee(str2).U(this.avq.get()).build();
        if (com.baidu.lcp.sdk.a.d.i(this.context, 401216) && this.avq.get() >= 5 && i != 401211) {
            com.baidu.lcp.sdk.a.b.a(this.context, IMPushPb.Action.newBuilder().setActionType(IMPushPb.ActionType.CONNECTION).setConnection(IMPushPb.Connection.newBuilder().setStartTime(this.avv).setStopTime(System.currentTimeMillis()).setAliasId(401216L).setReason(str).setExt(str2).setRetryCount(this.avq.get()).build()).build());
        }
        this.avw = "";
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
                        com.baidu.lcp.sdk.connect.b h = f.this.avk.h(f.this.avr.vK());
                        if (h != null && h.msgId > 0) {
                            f.this.avu.removeCallbacks(f.this.avs);
                            h.avb = false;
                            com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "ReadThread :" + h.toString());
                            if (!h.isHeartbeat) {
                                if (h.ava) {
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
                                    bVar = (com.baidu.lcp.sdk.connect.b) f.this.avj.remove(Long.valueOf(h.msgId));
                                }
                                f.this.a(h, bVar, this.host);
                            }
                            synchronized (f.this.mSync) {
                                if (f.this.avj.size() != 0) {
                                    com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "ReadThread socketTimeoutRunnable ...");
                                    f.this.avs.setMsgId(h.msgId);
                                    f.this.avs.setHost(this.host);
                                    f.this.avu.setHost(this.host);
                                    f.this.avu.postDelayed(f.this.avs, h.auV);
                                }
                            }
                        }
                    } catch (Exception e) {
                        if (!f.this.mClose) {
                            com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "ReadThread exception: " + e, e);
                            f.this.avh = false;
                            f.this.ag("ReadThread exception: " + e, this.host);
                            return;
                        }
                        return;
                    }
                } catch (Exception e2) {
                    if (!f.this.mClose) {
                        com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "onStartCommand", e2);
                        f.this.avh = false;
                        f.this.ag("onStartCommand:" + e2, this.host);
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
                        synchronized (f.this.avi) {
                            if (f.this.avi.size() == 0) {
                                f.this.avi.wait();
                            } else {
                                bVar = (com.baidu.lcp.sdk.connect.b) f.this.avi.removeFirst();
                            }
                        }
                    } catch (InterruptedException e) {
                        com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "SendThread wait exception: " + e);
                        f.this.ag("SendThread wait exception: " + e, this.host);
                    }
                    if (bVar != null) {
                        try {
                            if (f.this.mClose) {
                                f.this.c(bVar.msgId, this.host);
                                return;
                            }
                            bVar.avb = true;
                            bVar.auZ = f.auz.state;
                            if (bVar.needReplay) {
                                synchronized (f.this.mSync) {
                                    if (f.this.avj.isEmpty()) {
                                        f.this.avu.removeCallbacks(f.this.avs);
                                        f.this.avs.setMsgId(bVar.msgId);
                                        f.this.avs.setHost(this.host);
                                        f.this.avu.setHost(this.host);
                                        f.this.avu.postDelayed(f.this.avs, 5000L);
                                    }
                                }
                            }
                            com.baidu.lcp.sdk.d.d.v("SocketTransceiver", "SendThread :" + bVar.toString());
                            if (bVar.ava) {
                                com.baidu.lcp.sdk.a.d.writeLoginFlag(f.this.context, "17N", "Send LoginMsg request");
                            }
                            if (bVar.methodId == 1 && bVar.serviceId == 4) {
                                com.baidu.lcp.sdk.d.a.a(f.this.context, 1L, UbcStatConstant.ContentType.UBC_TYPE_IM_SEND, bVar.msgId + "");
                            }
                            if (bVar.methodId == 50 && bVar.serviceId == 2) {
                                com.baidu.lcp.sdk.d.a.a(f.this.context, 50L, UbcStatConstant.ContentType.UBC_TYPE_IM_SEND, bVar.msgId + "");
                            }
                            synchronized (f.this.mOutputSync) {
                                f.this.avr.a(bVar);
                            }
                            if (!bVar.isHeartbeat && bVar.needReplay) {
                                synchronized (f.this.mSync) {
                                    f.this.avj.put(Long.valueOf(bVar.msgId), bVar);
                                }
                            }
                        } catch (Exception e2) {
                            com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "SendThread sendMessage Exception:", e2);
                            f.this.c(bVar.msgId, e2.toString(), this.host);
                            f.this.ag("SendThread sendMessage Exception:" + e2, this.host);
                            return;
                        }
                    }
                } catch (Exception e3) {
                    com.baidu.lcp.sdk.d.d.e("SocketTransceiver", "SendThread Exception:", e3);
                    f.this.ag("SendThread Exception:" + e3, this.host);
                    return;
                }
            }
        }
    }

    private void ej(String str) {
        try {
            com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "fatalAllMessage begin ");
            synchronized (this.avi) {
                while (this.avi.size() > 0) {
                    b(this.avi.removeFirst(), str);
                }
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "fatalAllMessage sendQueue end ");
            }
            synchronized (this.mSync) {
                com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "fatalAllMessage mSync begin");
                for (Long l : this.avj.keySet()) {
                    b(this.avj.get(l), str);
                }
                this.avj.clear();
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

    public synchronized void af(String str, String str2) {
        if (com.baidu.lcp.sdk.d.e.aA(this.context)) {
            com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "---socketDisconnect---");
            this.mClose = true;
            this.avh = true;
            ej(str2);
            vN();
            this.avu.removeCallbacks(this.avB);
            this.avu.removeCallbacks(this.avC);
            this.avu.removeCallbacks(this.avp);
            com.baidu.lcp.sdk.connect.a.e(this.context, null, false);
            ah(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ag(String str, String str2) {
        com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "disconnectedByLcp, destroyConnection = " + this.avh + ", net :" + RequsetNetworkUtils.isConnected(this.context) + ", isSmallFlow :" + com.baidu.lcp.sdk.d.e.aA(this.context));
        if (com.baidu.lcp.sdk.d.e.aA(this.context)) {
            ej(str2);
            if (this.avh) {
                vN();
            } else {
                ah(str, str2);
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
            this.avq.incrementAndGet();
            if (this.avq.get() <= 10 && auz.state == -1) {
                long bP = bP(this.avq.get());
                this.avu.removeCallbacks(this.avp);
                this.avu.removeCallbacks(z ? this.avB : this.avC);
                this.avu.postDelayed(z ? this.avC : this.avB, bP);
                com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "Schedule retry " + (z ? OneKeyLoginSdkCall.k : "connect") + " -- retry times: " + this.avq.get() + " time delay: " + bP);
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

    private synchronized void ah(String str, String str2) {
        if (com.baidu.lcp.sdk.d.e.aA(this.context)) {
            com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "destroy");
            d(401212, "connect stop, " + str, str2);
            auz.state = -1;
            setChanged();
            notifyObservers(auz);
            vQ();
            this.avu.removeCallbacks(this.avs);
            this.mClose = true;
            if (this.avr != null) {
                synchronized (this.avi) {
                    this.avi.notifyAll();
                    com.baidu.lcp.sdk.d.d.i("SocketTransceiver", "destroy notifyAll");
                }
                try {
                    this.avr.socketClose();
                    com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "destroy socketClose ok");
                } catch (Exception e2) {
                    this.avr.a((com.baidu.lcp.sdk.connect.e) null);
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
            f.this.ag("read and write thread timeout:", this.host);
        }
    }

    public void pingRequest() {
        com.baidu.lcp.sdk.d.d.d("SocketTransceiver", "customPingRunnable send PingRequest ");
        b(this.avk.f(this.context, 3L));
    }
}
