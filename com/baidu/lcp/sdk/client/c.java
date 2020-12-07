package com.baidu.lcp.sdk.client;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
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
/* loaded from: classes14.dex */
public class c implements b.a, Observer {
    private static volatile b ayW = new b();
    private static volatile Map<Long, Object> ayX = new LinkedHashMap();
    private static volatile c azb;
    private a ayZ;
    private Context context;
    private int ayY = -1;
    private final Queue<Object> aza = new LinkedBlockingQueue();

    public static synchronized c Ak() {
        c cVar;
        synchronized (c.class) {
            if (azb == null) {
                synchronized (c.class) {
                    if (azb == null) {
                        azb = new c();
                    }
                }
            }
            cVar = azb;
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Al() {
        c(this.context, e.getAppId(this.context), e.aO(this.context), d.getLoginOpenType(this.context));
    }

    public void c(Context context, String str, String str2, int i) {
        if (ayW.state == -2 || ayW.state == 0) {
            com.baidu.lcp.sdk.d.d.d("LCPClientManager", "SocketConnect state is " + (ayW.state == 0 ? "connected" : "connecting"));
        } else {
            d(context, str, str2, i);
        }
    }

    public synchronized void d(Context context, String str, String str2, int i) {
        String str3;
        String str4;
        long j;
        if (context != null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && RequsetNetworkUtils.isConnected(context)) {
                this.context = context;
                if (TextUtils.isEmpty(e.getAppId(context))) {
                    e.E(context, str);
                }
                if (TextUtils.isEmpty(e.aO(context))) {
                    e.F(context, str2);
                }
                f.aG(context).addObserver(azb);
                if (ayW.state == -2 || ayW.state == 0) {
                    com.baidu.lcp.sdk.d.d.d("LCPClientManager", "SocketConnect state is " + (ayW.state == 0 ? "connected" : "connecting"));
                } else {
                    if (this.ayZ == null) {
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                        this.ayZ = new a();
                        context.registerReceiver(this.ayZ, intentFilter);
                    }
                    if (d.ay(context)) {
                        String str5 = "1N";
                        long j2 = 0;
                        try {
                            String[] loginFlag = d.getLoginFlag(context);
                            if (loginFlag.length < 3) {
                                str3 = "ext";
                                str4 = "1N";
                                j = 0;
                            } else {
                                j2 = Long.valueOf(loginFlag[0]).longValue();
                                str5 = loginFlag[1];
                                str3 = loginFlag[2];
                                str4 = str5;
                                j = j2;
                            }
                            new a.b(context).fH(String.valueOf(d.getLoginOpenType(context))).fI(str4).X(d.getLoginCallTime(context)).Y(j).fJ(str3).aa(501110L).build();
                        } catch (Exception e) {
                            com.baidu.lcp.sdk.d.d.e("LCPClientManager", "LcpTrack init request getLoginFlag Exception ");
                            new a.b(context).fH(String.valueOf(d.getLoginOpenType(context))).fI(str5).X(d.getLoginCallTime(context)).Y(j2).fJ("ext").aa(501110L).build();
                        }
                        com.baidu.lcp.sdk.a.b.as(context);
                        d.writeLoginCallTime(context);
                        d.writeLoginFlag(context, "1Y", "context is nonnull, accessToken is null -> " + TextUtils.isEmpty(str2));
                        d.writeLoginOpenType(context, i);
                    }
                    if (!e.aM(context)) {
                        if (this.ayY < 0) {
                            Am();
                        }
                    } else {
                        com.baidu.lcp.sdk.d.d.e("LCPClientManager", "token is not null ");
                        dx(0);
                    }
                }
            }
        }
    }

    private void dx(int i) {
        if (this.context != null && e.aC(this.context)) {
            switch (i) {
                case 0:
                    com.baidu.lcp.sdk.d.d.d("LCPClientManager", "socketAction createSocket");
                    ayW.state = -2;
                    f.aG(this.context).At();
                    return;
                case 1:
                    com.baidu.lcp.sdk.d.d.d("LCPClientManager", "socketAction closeSocket");
                    f.aG(this.context).ah("socketAction closeSocket:", f.aG(this.context).azU);
                    return;
                default:
                    return;
            }
        }
    }

    public void a(@NonNull BLCPRequest bLCPRequest, @Nullable com.baidu.lcp.sdk.client.bean.b bVar) {
        if (this.context == null || !e.aC(this.context)) {
            if (bVar != null) {
                bVar.onResponse(ResponseCode.LCP_STATE_CONNECTING, "unconnected", bLCPRequest.serviceId, bLCPRequest.methodId, bLCPRequest.msgId, new byte[0]);
            }
        } else if (ayW.state != 0) {
            if (!(bLCPRequest instanceof com.baidu.lcp.sdk.client.bean.a) && !(bLCPRequest instanceof com.baidu.lcp.sdk.client.bean.c) && bVar != null) {
                bVar.onResponse(ResponseCode.LCP_STATE_CONNECTING, "unconnected", bLCPRequest.serviceId, bLCPRequest.methodId, bLCPRequest.msgId, new byte[0]);
            }
            if (ayW.state == -1) {
                Al();
            }
        } else {
            f.aG(this.context).b(bLCPRequest, bVar);
            if (bLCPRequest.methodId == 1 && bLCPRequest.serviceId == 4) {
                com.baidu.lcp.sdk.d.d.d("LCPClientManager", "云控登录打点");
                com.baidu.lcp.sdk.d.a.a(this.context, 1L, "invoke", bLCPRequest.msgId + "");
            }
            if (bLCPRequest.methodId == 50 && bLCPRequest.serviceId == 2) {
                com.baidu.lcp.sdk.d.a.a(this.context, 50L, "invoke", bLCPRequest.msgId + "");
            }
        }
    }

    public void Am() {
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
        this.ayY++;
        com.baidu.lcp.sdk.d.d.d("LCPClientManager", "no token, so request token, and tryCount = " + this.ayY);
        if (this.ayY < 3) {
            d.writeLoginFlag(this.context, "2N", "accessToken is null");
            com.baidu.lcp.sdk.b.b bVar = new com.baidu.lcp.sdk.b.b(this.context, this);
            com.baidu.lcp.sdk.b.c.a(bVar, bVar);
            return;
        }
        this.ayY = -1;
    }

    @Override // com.baidu.lcp.sdk.b.b.a
    public void fK(String str) {
        this.ayY = -1;
        dx(0);
        d.writeLoginFlag(this.context, "2Y", "accessToken success");
    }

    @Override // com.baidu.lcp.sdk.b.b.a
    public void onFailure(int i, String str) {
        com.baidu.lcp.sdk.d.d.e("LCPClientManager", "getToken :" + str);
        Am();
        d.writeLoginFlag(this.context, "2N_1", "accessToken fail");
        if (this.ayY == 2) {
            ayW.state = -1;
            f.aG(this.context).Ax();
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (obj instanceof b) {
            ayW.state = ((b) obj).state;
            com.baidu.lcp.sdk.d.d.d("LCPClientManager", "Manager update connectState :" + ayW.state);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            com.baidu.lcp.sdk.d.d.d("LCPClientManager", "NetStatusReceiver changed");
            if (RequsetNetworkUtils.isNetworkAvailable(context) && e.aC(context)) {
                com.baidu.lcp.sdk.d.d.e("LCPClientManager", "NetStatusReceiver reconnect");
                com.baidu.lcp.sdk.c.a.aH(context).submitForNetWork(new Runnable() { // from class: com.baidu.lcp.sdk.client.c.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.Al();
                    }
                });
            }
        }
    }

    public static int Aj() {
        return ayW.state;
    }

    public void pingRequest() {
        if (this.context != null) {
            f.aG(this.context).pingRequest();
        }
    }
}
