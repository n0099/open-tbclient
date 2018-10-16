package cn.jiguang.d.b;

import android.content.Context;
import android.net.http.Headers;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cn.jiguang.d.d.o;
import com.baidu.ar.util.Constants;
import com.baidu.baiduarsdk.ArBridge;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class f extends Handler {
    final /* synthetic */ d lA;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, Looper looper) {
        super(looper);
        this.lA = dVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Context context;
        g gVar;
        g gVar2;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        super.handleMessage(message);
        try {
            Bundle data = message.getData();
            String string = data != null ? data.getString("sdktype") : "";
            if (!cn.jiguang.g.i.a(string) && !string.equals(cn.jiguang.d.a.a)) {
                cn.jiguang.d.d.e.bU();
                context5 = this.lA.h;
                cn.jiguang.d.d.e.b(context5, string, data);
                return;
            }
            switch (message.what) {
                case 1001:
                    o ca = o.ca();
                    context3 = this.lA.h;
                    ca.b(context3, true);
                    context4 = this.lA.h;
                    cn.jiguang.d.d.g.a(context4, false);
                    return;
                case 1002:
                    context2 = this.lA.h;
                    cn.jiguang.a.c.c.a(context2, false);
                    return;
                case 1003:
                    d.b(this.lA);
                    return;
                case 1004:
                    d.a(this.lA, true);
                    return;
                case 1005:
                    d.a(this.lA, false);
                    return;
                case 1006:
                case 1007:
                    this.lA.b(true, 0L);
                    return;
                case 1010:
                    gVar = this.lA.lu;
                    if (gVar != null) {
                        gVar2 = this.lA.lu;
                        gVar2.c();
                        return;
                    }
                    return;
                case 1011:
                    this.lA.e();
                    return;
                case ArBridge.MessageType.MSG_TYPE_VIDEO_PLAY_RES /* 1022 */:
                    d.d(this.lA);
                    return;
                case Constants.HTTP_ERRCODE_NOT_FIND /* 1032 */:
                    cn.jiguang.d.d.i bX = cn.jiguang.d.d.i.bX();
                    context = this.lA.h;
                    bX.a(context);
                    return;
                case 7301:
                    d.b(this.lA, message.getData().getLong(Headers.CONN_DIRECTIVE));
                    return;
                case 7303:
                    d.c(this.lA, message.getData().getLong(Headers.CONN_DIRECTIVE));
                    return;
                case 7304:
                    d.a(this.lA, message.getData().getLong(Headers.CONN_DIRECTIVE));
                    return;
                case 7306:
                    d dVar = this.lA;
                    cn.jiguang.e.c.a("JiguangTcpManager", "onLoginFailed - connection:" + message.getData().getLong(Headers.CONN_DIRECTIVE) + ", respCode:" + message.arg2);
                    return;
                case 7307:
                    g.lB.set(false);
                    return;
                case 7401:
                    Bundle data2 = message.getData();
                    if (data2 == null) {
                        cn.jiguang.e.c.c("JiguangTcpManager", "Unexpected - want to send null request.");
                        return;
                    }
                    h.bQ().b(data2.getByteArray(com.baidu.fsg.face.liveness.beans.c.a), data2.getString("request_sdktype"), data2.getInt("request_timeout"));
                    return;
                case 7402:
                    Bundle data3 = message.getData();
                    if (data3 == null) {
                        cn.jiguang.e.c.c("JiguangTcpManager", "Unexpected - msg response bundle is null.");
                        return;
                    } else {
                        h.bQ().a(message.getData().getLong(Headers.CONN_DIRECTIVE), data3.getString("request_sdktype"), message.obj);
                        return;
                    }
                case 7403:
                    if (message.obj == null || !(message.obj instanceof i)) {
                        return;
                    }
                    h.bQ().e((i) message.obj);
                    return;
                case 7404:
                    if (message.obj == null || !(message.obj instanceof i)) {
                        return;
                    }
                    h.bQ().d((i) message.obj);
                    return;
                default:
                    return;
            }
        } catch (Throwable th) {
        }
    }
}
