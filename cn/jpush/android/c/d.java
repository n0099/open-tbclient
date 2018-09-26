package cn.jpush.android.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.SdkType;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.d.f;
import cn.jpush.android.service.PushReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public final class d {
    private static d d;
    private List<JThirdPlatFormInterface> a = new ArrayList();
    private boolean c;
    private static Map<String, Byte> b = new HashMap();
    private static final Object e = new Object();

    static {
        b.put("cn.jpush.android.thirdpush.meizu.MeizuPushManager", (byte) 3);
        b.put("cn.jpush.android.thirdpush.xiaomi.XMPushManager", (byte) 1);
        b.put("cn.jpush.android.thirdpush.huawei.HWPushManager", (byte) 2);
        b.put("cn.jpush.android.thirdpush.fcm.FCMPushManager", (byte) 8);
        b.put("cn.jpush.android.thridpush.oppo.OPushManager", (byte) 4);
    }

    private d() {
    }

    public static d a() {
        if (d == null) {
            synchronized (e) {
                if (d == null) {
                    d = new d();
                }
            }
        }
        return d;
    }

    private e a(Bundle bundle) {
        if (bundle != null) {
            e eVar = new e(this);
            eVar.c = bundle.getString("data");
            eVar.a = bundle.getString("msg_id");
            eVar.b = bundle.getInt(JThirdPlatFormInterface.KEY_NOTI_ID, 0);
            eVar.d = bundle.getByte("platform", (byte) -1).byteValue();
            return eVar;
        }
        return null;
    }

    private void a(Context context, byte b2, String str) {
        if (context == null) {
            context = cn.jpush.android.a.e;
        }
        if (context == null) {
            return;
        }
        g(context);
        for (JThirdPlatFormInterface jThirdPlatFormInterface : this.a) {
            if (jThirdPlatFormInterface.getRomType(context) == b2) {
                a(context, jThirdPlatFormInterface);
                if (a(context, (int) b2, str)) {
                    b(context, b2, str);
                }
            }
        }
    }

    private static void a(Context context, JThirdPlatFormInterface jThirdPlatFormInterface) {
        if (jThirdPlatFormInterface == null || !jThirdPlatFormInterface.isNeedClearToken(context)) {
            return;
        }
        cn.jpush.android.b.b(context, (int) jThirdPlatFormInterface.getRomType(context), false);
        cn.jpush.android.b.a(context, jThirdPlatFormInterface.getRomType(context), (String) null);
    }

    private static boolean a(Context context, int i, String str) {
        return (cn.jpush.android.b.b(context, i) && TextUtils.equals(cn.jpush.android.b.a(context, i), str)) ? false : true;
    }

    private static void b(Context context, byte b2, String str) {
        cn.jpush.android.b.b(context, (int) b2, false);
        cn.jpush.android.b.a(context, b2, str);
        Bundle bundle = new Bundle();
        cn.jpush.android.service.e.a(context, bundle, JThirdPlatFormInterface.ACTION_PLUGIN_PALTFORM_REQUEST_REGID);
        bundle.putString("plugin.platform.regid ", str);
        bundle.putByte("plugin.platform.type", b2);
        cn.jiguang.api.e.b(context, cn.jpush.android.a.a, bundle);
    }

    private synchronized void g(Context context) {
        Object newInstance;
        if (!this.c && context != null) {
            for (Map.Entry<String, Byte> entry : b.entrySet()) {
                Class<?> loadClass = context.getClassLoader().loadClass(entry.getKey());
                if (loadClass != null && (newInstance = loadClass.newInstance()) != null && (newInstance instanceof JThirdPlatFormInterface)) {
                    ((JThirdPlatFormInterface) newInstance).init(context);
                    if (((JThirdPlatFormInterface) newInstance).isSupport(context)) {
                        this.a.add((JThirdPlatFormInterface) newInstance);
                    }
                }
            }
            this.c = true;
        }
    }

    public final void a(Context context) {
        g(context);
        if (JPushInterface.isPushStopped(context.getApplicationContext())) {
            return;
        }
        for (JThirdPlatFormInterface jThirdPlatFormInterface : this.a) {
            jThirdPlatFormInterface.register(context);
        }
    }

    public final void a(Context context, Bundle bundle) {
        if (bundle != null) {
            try {
                e a = a(bundle);
                cn.jpush.android.data.b a2 = c.a(context, a.c, a.a);
                a2.i = true;
                a2.f = true;
                a2.e = a.d;
                cn.jpush.android.api.c.a(context, a2);
                a(context, JThirdPlatFormInterface.ACTION_NOTIFICATION_ARRIVED, bundle);
            } catch (Throwable th) {
            }
        }
    }

    public final void a(Context context, String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.equals(JThirdPlatFormInterface.ACTION_NOTIFICATION_ARRIVED)) {
            e a = a(bundle);
            if (a != null) {
                c.a(context, a.c, a.a, a.b, a.d, false);
            }
        } else if (str.equals(JThirdPlatFormInterface.ACTION_NOTIFICATION_CLCKED)) {
            e a2 = a(bundle);
            if (a2 != null) {
                c.a(context, a2.c, a2.a, a2.b, a2.d, true);
            }
        } else if (str.equals(JThirdPlatFormInterface.ACTION_NOTIFICATION_SHOW)) {
            cn.jpush.android.service.e.a(context, bundle, JThirdPlatFormInterface.ACTION_NOTIFICATION_SHOW);
            cn.jiguang.api.e.b(context, cn.jpush.android.a.a, bundle);
        } else if (!str.equals(JThirdPlatFormInterface.ACTION_REGISTER_TOKEN) || bundle == null) {
        } else {
            a(context, bundle.getByte("platform", (byte) -1).byteValue(), bundle.getString("token"));
        }
    }

    public final void b(Context context) {
        g(context);
        for (JThirdPlatFormInterface jThirdPlatFormInterface : this.a) {
            jThirdPlatFormInterface.resumePush(context);
        }
    }

    public final void b(Context context, Bundle bundle) {
        g(context);
        byte byteValue = bundle.getByte("platform", (byte) -1).byteValue();
        if (byteValue <= 0) {
            return;
        }
        for (JThirdPlatFormInterface jThirdPlatFormInterface : this.a) {
            if (jThirdPlatFormInterface.getRomType(context) == byteValue) {
                a(context, byteValue, jThirdPlatFormInterface.getToken(context));
            }
        }
    }

    public final void c(Context context) {
        g(context);
        for (JThirdPlatFormInterface jThirdPlatFormInterface : this.a) {
            jThirdPlatFormInterface.stopPush(context);
        }
    }

    public final byte d(Context context) {
        g(context);
        byte b2 = 0;
        Iterator<JThirdPlatFormInterface> it = this.a.iterator();
        while (true) {
            byte b3 = b2;
            if (!it.hasNext()) {
                return b3;
            }
            JThirdPlatFormInterface next = it.next();
            byte romType = next.getRomType(context);
            byte b4 = (byte) (b3 | romType);
            String a = cn.jpush.android.b.a(context, romType);
            boolean b5 = cn.jpush.android.b.b(context, romType);
            if (next.getRomType(context) == 8) {
                b2 = (byte) (b4 | 8);
                if (b5 && !TextUtils.isEmpty(a)) {
                    b2 = (byte) (b2 | 32);
                }
            } else {
                b2 = next.getRomType(context) == 2 ? (byte) (b4 | 64) : b4;
                if (!b5 || TextUtils.isEmpty(a)) {
                    b2 = (byte) (b2 | 128);
                }
            }
        }
    }

    public final String e(Context context) {
        for (JThirdPlatFormInterface jThirdPlatFormInterface : this.a) {
            if (jThirdPlatFormInterface.getRomType(context) != 8) {
                return cn.jpush.android.b.a(context, jThirdPlatFormInterface.getRomType(context));
            }
        }
        return null;
    }

    public final void f(Context context) {
        if (context == null) {
            context = cn.jpush.android.a.e;
        }
        if (context == null) {
            return;
        }
        g(context);
        for (JThirdPlatFormInterface jThirdPlatFormInterface : this.a) {
            if (jThirdPlatFormInterface.needSendToMainProcess()) {
                String token = jThirdPlatFormInterface.getToken(context);
                if (TextUtils.isEmpty(token)) {
                    try {
                        Intent intent = new Intent(context, PushReceiver.class);
                        intent.setAction(JThirdPlatFormInterface.ACTION_PLUGIN_PALTFORM_REFRESSH_REGID);
                        Bundle bundle = new Bundle();
                        bundle.putString("sdktype", SdkType.JPUSH.name());
                        bundle.putByte("platform", jThirdPlatFormInterface.getRomType(context));
                        intent.putExtras(bundle);
                        intent.setPackage(context.getPackageName());
                        context.sendBroadcast(intent);
                    } catch (Throwable th) {
                        f.c("ThirdPushManager", "send ACTION_PLUGIN_PALTFORM_REFRESSH_REGID failed:" + th);
                    }
                } else {
                    a(context, jThirdPlatFormInterface.getRomType(context), token);
                }
            } else {
                a(context, jThirdPlatFormInterface);
                if (jThirdPlatFormInterface.getRomType(context) == 2) {
                    jThirdPlatFormInterface.getToken(context);
                } else {
                    String token2 = jThirdPlatFormInterface.getToken(context);
                    if (a(context, (int) jThirdPlatFormInterface.getRomType(context), token2)) {
                        b(context, jThirdPlatFormInterface.getRomType(context), token2);
                    }
                }
            }
        }
    }
}
