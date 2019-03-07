package cn.jiguang.d.b;

import android.content.Context;
import android.net.http.Headers;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.PointerIconCompat;
import cn.jiguang.d.d.o;
import com.baidu.pass.biometrics.face.liveness.beans.BeanDataCache;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class f extends Handler {
    final /* synthetic */ d lD;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, Looper looper) {
        super(looper);
        this.lD = dVar;
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
                cn.jiguang.d.d.e.bT();
                context5 = this.lD.h;
                cn.jiguang.d.d.e.b(context5, string, data);
                return;
            }
            switch (message.what) {
                case 1001:
                    o bZ = o.bZ();
                    context3 = this.lD.h;
                    bZ.b(context3, true);
                    context4 = this.lD.h;
                    cn.jiguang.d.d.g.a(context4, false);
                    return;
                case 1002:
                    context2 = this.lD.h;
                    cn.jiguang.a.c.c.a(context2, false);
                    return;
                case PointerIconCompat.TYPE_HELP /* 1003 */:
                    d.b(this.lD);
                    return;
                case PointerIconCompat.TYPE_WAIT /* 1004 */:
                    d.a(this.lD, true);
                    return;
                case 1005:
                    d.a(this.lD, false);
                    return;
                case PointerIconCompat.TYPE_CELL /* 1006 */:
                case PointerIconCompat.TYPE_CROSSHAIR /* 1007 */:
                    this.lD.b(true, 0L);
                    return;
                case 1010:
                    gVar = this.lD.lx;
                    if (gVar != null) {
                        gVar2 = this.lD.lx;
                        gVar2.c();
                        return;
                    }
                    return;
                case 1011:
                    this.lD.e();
                    return;
                case 1022:
                    d.d(this.lD);
                    return;
                case 1032:
                    cn.jiguang.d.d.i bW = cn.jiguang.d.d.i.bW();
                    context = this.lD.h;
                    bW.a(context);
                    return;
                case 7301:
                    d.b(this.lD, message.getData().getLong(Headers.CONN_DIRECTIVE));
                    return;
                case 7303:
                    d.c(this.lD, message.getData().getLong(Headers.CONN_DIRECTIVE));
                    return;
                case 7304:
                    d.a(this.lD, message.getData().getLong(Headers.CONN_DIRECTIVE));
                    return;
                case 7306:
                    d dVar = this.lD;
                    cn.jiguang.e.c.a("JiguangTcpManager", "onLoginFailed - connection:" + message.getData().getLong(Headers.CONN_DIRECTIVE) + ", respCode:" + message.arg2);
                    return;
                case 7307:
                    g.lE.set(false);
                    return;
                case 7401:
                    Bundle data2 = message.getData();
                    if (data2 == null) {
                        cn.jiguang.e.c.c("JiguangTcpManager", "Unexpected - want to send null request.");
                        return;
                    }
                    h.bP().b(data2.getByteArray(BeanDataCache.KEY), data2.getString("request_sdktype"), data2.getInt("request_timeout"));
                    return;
                case 7402:
                    Bundle data3 = message.getData();
                    if (data3 == null) {
                        cn.jiguang.e.c.c("JiguangTcpManager", "Unexpected - msg response bundle is null.");
                        return;
                    } else {
                        h.bP().a(message.getData().getLong(Headers.CONN_DIRECTIVE), data3.getString("request_sdktype"), message.obj);
                        return;
                    }
                case 7403:
                    if (message.obj == null || !(message.obj instanceof i)) {
                        return;
                    }
                    h.bP().e((i) message.obj);
                    return;
                case 7404:
                    if (message.obj == null || !(message.obj instanceof i)) {
                        return;
                    }
                    h.bP().d((i) message.obj);
                    return;
                default:
                    return;
            }
        } catch (Throwable th) {
        }
    }
}
