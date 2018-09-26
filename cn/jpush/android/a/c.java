package cn.jpush.android.a;

import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.service.ServiceInterface;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class c implements cn.jiguang.api.b {
    @Override // cn.jiguang.api.b
    public long dispatchMessage(Context context, long j, int i, Object obj, ByteBuffer byteBuffer) {
        cn.jiguang.api.h aVar;
        if (cn.jpush.android.a.a(context)) {
            switch (i) {
                case 3:
                    aVar = new cn.jpush.a.b(obj, byteBuffer);
                    break;
                case 10:
                case 28:
                case 29:
                    aVar = new cn.jpush.a.d(obj, byteBuffer);
                    break;
                case 26:
                case 27:
                    aVar = new cn.jpush.a.a(obj, byteBuffer);
                    break;
                default:
                    aVar = null;
                    break;
            }
            if (!ServiceInterface.c(context) || aVar == null || !(aVar instanceof cn.jpush.a.b) || ((cn.jpush.a.b) aVar).a() == 20) {
                if (aVar != null) {
                    cn.jpush.android.d.f.a("JPushDataAction", "response:" + aVar.toString());
                    switch (aVar.getCommand()) {
                        case 3:
                            return k.a(cn.jpush.android.a.e, j, aVar);
                        case 26:
                            g.a().a(context, aVar.getRid().longValue(), aVar.code);
                            break;
                        case 27:
                            if (aVar.code != 0) {
                                cn.jpush.android.c.a.a().a(context, aVar.getRid().longValue(), aVar.code);
                                break;
                            } else {
                                cn.jpush.android.c.a.a().a(context, aVar.getRid().longValue());
                                break;
                            }
                        case 28:
                        case 29:
                            return n.a(context, ((cn.jpush.a.d) aVar).a(), aVar.getCommand() == 28 ? 1 : 2, aVar.getRid().longValue());
                    }
                }
                if (aVar != null) {
                    return aVar.getRid().longValue();
                }
                return -1L;
            }
            return -1L;
        }
        return -1L;
    }

    @Override // cn.jiguang.api.b
    public void dispatchTimeOutMessage(Context context, long j, long j2, int i) {
        if (cn.jpush.android.a.a(context)) {
            switch (i) {
                case 10:
                case 28:
                case 29:
                    f.a(context).a(j2, cn.jpush.android.api.b.c);
                    return;
                case 26:
                    g.a().a(context, j2, cn.jpush.android.api.b.c);
                    return;
                case 27:
                    cn.jpush.android.c.a.a().b(context, j2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // cn.jiguang.api.b
    public IBinder getBinderByType(String str) {
        return null;
    }

    @Override // cn.jiguang.api.b
    public String getSdkVersion() {
        return "3.1.6";
    }

    @Override // cn.jiguang.api.b
    public void handleMessage(Context context, long j, Object obj) {
        if (cn.jpush.android.a.a(context) && obj != null) {
            if (obj instanceof Bundle) {
                cn.jpush.android.service.e.a(context);
                Bundle bundle = (Bundle) obj;
                if (bundle != null) {
                    bundle.getInt("what");
                }
            } else if (!(obj instanceof Intent)) {
                cn.jpush.android.d.f.a("JPushDataAction", "handleMessage unknown object ");
            } else {
                cn.jpush.android.service.d.a();
                Intent intent = (Intent) obj;
                if (intent == null) {
                    cn.jpush.android.d.f.c("PushReceiverCore", "Received null intent broadcast. Give up processing.");
                    return;
                }
                try {
                    String action = intent.getAction();
                    cn.jpush.android.d.f.a("PushReceiverCore", "onReceive - " + action);
                    if (!cn.jpush.android.a.a(context.getApplicationContext()) || action == null) {
                        return;
                    }
                    if (JThirdPlatFormInterface.ACTION_PLUGIN_PALTFORM_REFRESSH_REGID.equals(action)) {
                        cn.jpush.android.c.d.a().b(context, intent.getExtras());
                    } else if (action.startsWith(JPushInterface.ACTION_NOTIFICATION_RECEIVED_PROXY)) {
                        try {
                            if (!ServiceInterface.d(context)) {
                                intent.getIntExtra("notificaion_type", 0);
                                String stringExtra = intent.getStringExtra("message");
                                if (TextUtils.isEmpty(stringExtra)) {
                                    cn.jpush.android.d.f.c("PushReceiverCore", "Got an empty notification, don't show it!");
                                } else {
                                    cn.jpush.android.data.a a = i.a(context, stringExtra, intent.getStringExtra("appId"), intent.getStringExtra("senderId"), intent.getStringExtra("msg_id"));
                                    if (a != null) {
                                        a.i = true;
                                        i.a(context, a);
                                    }
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (action.equals("android.intent.action.PACKAGE_ADDED")) {
                    } else {
                        if (action.equalsIgnoreCase("android.net.conn.CONNECTIVITY_CHANGE")) {
                            NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                            if (networkInfo == null || 2 == networkInfo.getType() || 3 == networkInfo.getType() || intent.getBooleanExtra("noConnectivity", false) || NetworkInfo.State.CONNECTED == networkInfo.getState()) {
                                return;
                            }
                            NetworkInfo.State state = NetworkInfo.State.DISCONNECTED;
                            networkInfo.getState();
                        } else if (action.startsWith("cn.jpush.android.intent.NOTIFICATION_OPENED_PROXY")) {
                            cn.jpush.android.service.d.a(context, intent);
                        } else if (action.startsWith("cn.jpush.android.intent.NOTIFICATION_CLICK_ACTION_PROXY")) {
                            try {
                                Intent intent2 = new Intent(JPushInterface.ACTION_NOTIFICATION_CLICK_ACTION);
                                intent2.putExtras(intent.getExtras());
                                intent2.addCategory(context.getPackageName());
                                intent2.setPackage(context.getPackageName());
                                context.sendBroadcast(intent2, context.getPackageName() + ".permission.JPUSH_MESSAGE");
                            } catch (Throwable th) {
                                cn.jpush.android.d.f.c("PushReceiverCore", "Click notification sendBroadcast :" + th.getMessage());
                            }
                        }
                    }
                } catch (NullPointerException e2) {
                    cn.jpush.android.d.f.c("PushReceiverCore", "Received no action intent broadcast. Give up processing.");
                }
            }
        }
    }

    @Override // cn.jiguang.api.b
    public boolean isSupportedCMD(int i) {
        return i == 3 || i == 10 || i == 27 || i == 28 || i == 29 || i == 26;
    }

    @Override // cn.jiguang.api.b
    public void onActionRun(Context context, long j, Bundle bundle, Object obj) {
        cn.jpush.android.d.f.a("JPushDataAction", "Action - onActionRun");
        if (cn.jpush.android.a.a(context)) {
            cn.jpush.android.service.e.a(context).a(bundle, (Handler) obj);
        }
    }

    @Override // cn.jiguang.api.b
    public void onEvent(Context context, long j, int i) {
        if (cn.jpush.android.a.a(context)) {
            switch (i) {
                case 0:
                default:
                    return;
                case 1:
                    cn.jpush.android.c.d.a().f(context);
                    return;
                case 19:
                    cn.jpush.android.service.e.a(context).a();
                    return;
            }
        }
    }
}
