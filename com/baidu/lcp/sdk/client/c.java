package com.baidu.lcp.sdk.client;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.ResponseCode;
import com.baidu.android.imsdk.upload.utils.RequsetNetworkUtils;
import com.baidu.lcp.sdk.a.a;
import com.baidu.lcp.sdk.a.d;
import com.baidu.lcp.sdk.b.b;
import com.baidu.lcp.sdk.client.bean.BLCPRequest;
import com.baidu.lcp.sdk.connect.f;
import com.baidu.lcp.sdk.d.e;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes3.dex */
public class c implements b.a, Observer {
    private static volatile c auE;
    private a auC;
    private Context context;
    private static volatile b auz = new b();
    private static volatile Map<Long, Object> auA = new LinkedHashMap();
    private int auB = -1;
    private final Queue<Object> auD = new LinkedBlockingQueue();

    public static synchronized c vD() {
        c cVar;
        synchronized (c.class) {
            if (auE == null) {
                synchronized (c.class) {
                    if (auE == null) {
                        auE = new c();
                    }
                }
            }
            cVar = auE;
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vE() {
        c(this.context, e.getAppId(this.context), e.aM(this.context), d.getLoginOpenType(this.context));
    }

    public void c(Context context, String str, String str2, int i) {
        if (auz.state == -2 || auz.state == 0) {
            com.baidu.lcp.sdk.d.d.d("LCPClientManager", "SocketConnect state is " + (auz.state == 0 ? "connected" : "connecting"));
        } else {
            d(context, str, str2, i);
        }
    }

    public synchronized void d(Context context, String str, String str2, int i) {
        String str3;
        if (context != null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && RequsetNetworkUtils.isConnected(context)) {
                this.context = context;
                if (TextUtils.isEmpty(e.getAppId(context))) {
                    e.E(context, str);
                }
                if (TextUtils.isEmpty(e.aM(context))) {
                    e.F(context, str2);
                }
                f.aE(context).addObserver(auE);
                if (auz.state == -2 || auz.state == 0) {
                    com.baidu.lcp.sdk.d.d.d("LCPClientManager", "SocketConnect state is " + (auz.state == 0 ? "connected" : "connecting"));
                } else {
                    if (this.auC == null) {
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                        this.auC = new a();
                        context.registerReceiver(this.auC, intentFilter);
                    }
                    if (d.aw(context)) {
                        String str4 = "1N";
                        long j = 0;
                        try {
                            String[] loginFlag = d.getLoginFlag(context);
                            if (loginFlag.length < 3) {
                                str3 = "ext";
                            } else {
                                j = Long.valueOf(loginFlag[0]).longValue();
                                str4 = loginFlag[1];
                                str3 = loginFlag[2];
                            }
                            new a.b(context).ef(String.valueOf(d.getLoginOpenType(context))).eg(str4).W(d.getLoginCallTime(context)).X(j).eh(str3).Z(501110L).build();
                        } catch (Exception e) {
                            com.baidu.lcp.sdk.d.d.e("LCPClientManager", "LcpTrack init request getLoginFlag Exception ");
                            new a.b(context).ef(String.valueOf(d.getLoginOpenType(context))).eg(str4).W(d.getLoginCallTime(context)).X(j).eh("ext").Z(501110L).build();
                        }
                        com.baidu.lcp.sdk.a.b.aq(context);
                        d.writeLoginCallTime(context);
                        d.writeLoginFlag(context, "1Y", "context is nonnull, accessToken is null -> " + TextUtils.isEmpty(str2));
                        d.writeLoginOpenType(context, i);
                    }
                    if (!e.aK(context)) {
                        if (this.auB < 0) {
                            vF();
                        }
                    } else {
                        com.baidu.lcp.sdk.d.d.e("LCPClientManager", "token is not null ");
                        bO(0);
                    }
                }
            }
        }
    }

    private void bO(int i) {
        if (this.context != null && e.aA(this.context)) {
            switch (i) {
                case 0:
                    com.baidu.lcp.sdk.d.d.d("LCPClientManager", "socketAction createSocket");
                    auz.state = -2;
                    f.aE(this.context).vM();
                    return;
                case 1:
                    com.baidu.lcp.sdk.d.d.d("LCPClientManager", "socketAction closeSocket");
                    f.aE(this.context).af("socketAction closeSocket:", f.aE(this.context).avx);
                    return;
                default:
                    return;
            }
        }
    }

    public void a(@NonNull BLCPRequest bLCPRequest, @Nullable com.baidu.lcp.sdk.client.bean.b bVar) {
        if (this.context == null || !e.aA(this.context)) {
            if (bVar != null) {
                bVar.onResponse(ResponseCode.LCP_STATE_CONNECTING, "unconnected", bLCPRequest.serviceId, bLCPRequest.methodId, bLCPRequest.msgId, new byte[0]);
            }
        } else if (auz.state != 0) {
            if (!(bLCPRequest instanceof com.baidu.lcp.sdk.client.bean.a) && !(bLCPRequest instanceof com.baidu.lcp.sdk.client.bean.c) && bVar != null) {
                bVar.onResponse(ResponseCode.LCP_STATE_CONNECTING, "unconnected", bLCPRequest.serviceId, bLCPRequest.methodId, bLCPRequest.msgId, new byte[0]);
            }
            if (auz.state == -1) {
                vE();
            }
        } else {
            f.aE(this.context).b(bLCPRequest, bVar);
            if (bLCPRequest.methodId == 1 && bLCPRequest.serviceId == 4) {
                com.baidu.lcp.sdk.d.d.d("LCPClientManager", "云控登录打点");
                com.baidu.lcp.sdk.d.a.a(this.context, 1L, "invoke", bLCPRequest.msgId + "");
            }
            if (bLCPRequest.methodId == 50 && bLCPRequest.serviceId == 2) {
                com.baidu.lcp.sdk.d.a.a(this.context, 50L, "invoke", bLCPRequest.msgId + "");
            }
        }
    }

    public void vF() {
        Object valueOf;
        if (this.context == null || !RequsetNetworkUtils.isConnected(this.context)) {
            StringBuilder append = new StringBuilder().append("context = ").append(this.context).append(", net :");
            if (this.context == null) {
                valueOf = "";
            } else {
                valueOf = Boolean.valueOf(!RequsetNetworkUtils.isConnected(this.context));
            }
            com.baidu.lcp.sdk.d.d.d("LCPClientManager", append.append(valueOf).toString());
            return;
        }
        this.auB++;
        com.baidu.lcp.sdk.d.d.d("LCPClientManager", "no token, so request token, and tryCount = " + this.auB);
        if (this.auB < 3) {
            d.writeLoginFlag(this.context, "2N", "accessToken is null");
            com.baidu.lcp.sdk.b.b bVar = new com.baidu.lcp.sdk.b.b(this.context, this);
            com.baidu.lcp.sdk.b.c.a(bVar, bVar);
            return;
        }
        this.auB = -1;
    }

    @Override // com.baidu.lcp.sdk.b.b.a
    public void ei(String str) {
        this.auB = -1;
        bO(0);
        d.writeLoginFlag(this.context, "2Y", "accessToken success");
    }

    @Override // com.baidu.lcp.sdk.b.b.a
    public void onFailure(int i, String str) {
        com.baidu.lcp.sdk.d.d.e("LCPClientManager", "getToken :" + str);
        vF();
        d.writeLoginFlag(this.context, "2N_1", "accessToken fail");
        if (this.auB == 2) {
            auz.state = -1;
            f.aE(this.context).vQ();
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (obj instanceof b) {
            auz.state = ((b) obj).state;
            com.baidu.lcp.sdk.d.d.d("LCPClientManager", "Manager update connectState :" + auz.state);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            com.baidu.lcp.sdk.d.d.d("LCPClientManager", "NetStatusReceiver changed");
            if (RequsetNetworkUtils.isNetworkAvailable(context) && e.aA(context)) {
                com.baidu.lcp.sdk.d.d.e("LCPClientManager", "NetStatusReceiver reconnect");
                com.baidu.lcp.sdk.c.a.aF(context).submitForNetWork(new Runnable() { // from class: com.baidu.lcp.sdk.client.c.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.vE();
                    }
                });
            }
        }
    }

    public static int vC() {
        return auz.state;
    }

    public void pingRequest() {
        if (this.context != null) {
            f.aE(this.context).pingRequest();
        }
    }
}
