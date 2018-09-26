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
    final /* synthetic */ d kU;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, Looper looper) {
        super(looper);
        this.kU = dVar;
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
                cn.jiguang.d.d.e.bD();
                context5 = this.kU.h;
                cn.jiguang.d.d.e.b(context5, string, data);
                return;
            }
            switch (message.what) {
                case 1001:
                    o bJ = o.bJ();
                    context3 = this.kU.h;
                    bJ.b(context3, true);
                    context4 = this.kU.h;
                    cn.jiguang.d.d.g.a(context4, false);
                    return;
                case 1002:
                    context2 = this.kU.h;
                    cn.jiguang.a.c.c.a(context2, false);
                    return;
                case 1003:
                    d.b(this.kU);
                    return;
                case 1004:
                    d.a(this.kU, true);
                    return;
                case ArBridge.MessageType.MSG_TYPE_RESUME_MUSIC /* 1005 */:
                    d.a(this.kU, false);
                    return;
                case 1006:
                case 1007:
                    this.kU.b(true, 0L);
                    return;
                case 1010:
                    gVar = this.kU.kP;
                    if (gVar != null) {
                        gVar2 = this.kU.kP;
                        gVar2.c();
                        return;
                    }
                    return;
                case 1011:
                    this.kU.e();
                    return;
                case ArBridge.MessageType.MSG_TYPE_VIDEO_PLAY_RES /* 1022 */:
                    d.d(this.kU);
                    return;
                case Constants.HTTP_ERRCODE_NOT_FIND /* 1032 */:
                    cn.jiguang.d.d.i bG = cn.jiguang.d.d.i.bG();
                    context = this.kU.h;
                    bG.a(context);
                    return;
                case 7301:
                    d.b(this.kU, message.getData().getLong(Headers.CONN_DIRECTIVE));
                    return;
                case 7303:
                    d.c(this.kU, message.getData().getLong(Headers.CONN_DIRECTIVE));
                    return;
                case 7304:
                    d.a(this.kU, message.getData().getLong(Headers.CONN_DIRECTIVE));
                    return;
                case 7306:
                    d dVar = this.kU;
                    cn.jiguang.e.c.a("JiguangTcpManager", "onLoginFailed - connection:" + message.getData().getLong(Headers.CONN_DIRECTIVE) + ", respCode:" + message.arg2);
                    return;
                case 7307:
                    g.kV.set(false);
                    return;
                case 7401:
                    Bundle data2 = message.getData();
                    if (data2 == null) {
                        cn.jiguang.e.c.c("JiguangTcpManager", "Unexpected - want to send null request.");
                        return;
                    }
                    h.bz().b(data2.getByteArray(com.baidu.fsg.face.liveness.beans.c.a), data2.getString("request_sdktype"), data2.getInt("request_timeout"));
                    return;
                case 7402:
                    Bundle data3 = message.getData();
                    if (data3 == null) {
                        cn.jiguang.e.c.c("JiguangTcpManager", "Unexpected - msg response bundle is null.");
                        return;
                    } else {
                        h.bz().a(message.getData().getLong(Headers.CONN_DIRECTIVE), data3.getString("request_sdktype"), message.obj);
                        return;
                    }
                case 7403:
                    if (message.obj == null || !(message.obj instanceof i)) {
                        return;
                    }
                    h.bz().e((i) message.obj);
                    return;
                case 7404:
                    if (message.obj == null || !(message.obj instanceof i)) {
                        return;
                    }
                    h.bz().d((i) message.obj);
                    return;
                default:
                    return;
            }
        } catch (Throwable th) {
        }
    }
}
