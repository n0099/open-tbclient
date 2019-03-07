package cn.jiguang.d.d;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class j implements cn.jiguang.api.b {
    @Override // cn.jiguang.api.b
    public long dispatchMessage(Context context, long j, int i, Object obj, ByteBuffer byteBuffer) {
        cn.jiguang.api.h a = cn.jiguang.d.e.a.a.a.a((cn.jiguang.d.e.a.a.c) obj, byteBuffer);
        if (a != null) {
            if (a.code == 0) {
                switch (a.getCommand()) {
                    case 19:
                        cn.jiguang.d.b.d.bN().a(a, j);
                        break;
                    case 25:
                        cn.jiguang.a.c.a.a(context, cn.jiguang.d.b.d.bN().bO(), j, a);
                        break;
                    case 26:
                        if (a.code != 0) {
                            i.bW().a(context, a.getRid().longValue());
                            break;
                        } else {
                            i.bW().b(context, a.getRid().longValue());
                            break;
                        }
                    case 30:
                    case 32:
                        cn.jiguang.d.f.a.ce().a(a.code, a.getCommand());
                        break;
                }
            } else {
                cn.jiguang.e.c.c("JCoreAction", "Received error response - code:" + a.code);
            }
        }
        if (a != null) {
            return a.getHead().cb().longValue();
        }
        return -1L;
    }

    @Override // cn.jiguang.api.b
    public void dispatchTimeOutMessage(Context context, long j, long j2, int i) {
        if (i == 26) {
            i.bW().c(context, j2);
        } else if (i == 32 || i == 30) {
            cn.jiguang.d.f.a.ce().a(context, i);
        }
    }

    @Override // cn.jiguang.api.b
    public IBinder getBinderByType(String str) {
        return null;
    }

    @Override // cn.jiguang.api.b
    public String getSdkVersion() {
        return "1.2.5";
    }

    @Override // cn.jiguang.api.b
    public void handleMessage(Context context, long j, Object obj) {
    }

    @Override // cn.jiguang.api.b
    public boolean isSupportedCMD(int i) {
        return i == 0 || i == 1 || i == 19 || i == 25 || i == 26 || i == 30 || i == 32;
    }

    @Override // cn.jiguang.api.b
    public void onActionRun(Context context, long j, Bundle bundle, Object obj) {
        if (bundle != null) {
            String string = bundle.getString("action");
            if (!TextUtils.isEmpty(string) && string.equals("asm")) {
                cn.jiguang.d.f.a.ce().a(context, bundle);
                return;
            }
        }
        cn.jiguang.a.c.b.bt();
        cn.jiguang.e.c.a("ARunAction", " pkg:" + cn.jiguang.d.a.c);
        cn.jiguang.e.c.a("ARunAction", new StringBuilder("bundle:").append(bundle).toString() != null ? bundle.toString() : "");
        if (bundle == null || !"cn.jpush.android.intent.REPORT".equals(bundle.getString("action"))) {
            return;
        }
        String string2 = bundle.getString("report");
        bundle.getString("report.extra.info");
        cn.jiguang.a.a.c.e.a(context, string2);
    }

    @Override // cn.jiguang.api.b
    public void onEvent(Context context, long j, int i) {
    }
}
