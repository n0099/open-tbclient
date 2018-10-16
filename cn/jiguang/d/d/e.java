package cn.jiguang.d.d;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import cn.jiguang.api.SdkType;
import com.baidu.webkit.internal.ETAG;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class e {
    public static HashMap<String, cn.jiguang.api.b> a = new HashMap<>();
    public static HashMap<String, cn.jiguang.api.c> b = new HashMap<>();
    private static final Object d;
    private static volatile e lX;

    static {
        a(cn.jiguang.d.a.a, j.class.getName());
        d = new Object();
    }

    private e() {
    }

    private static Object a(cn.jiguang.api.c cVar, Context context, int i, String str, int i2) {
        Object obj = null;
        if (cVar != null) {
            try {
                if (i2 == 0) {
                    obj = cVar.beforRegister(context, i, str);
                } else if (i2 == 1) {
                    obj = cVar.beforLogin(context, i, str);
                }
            } catch (Throwable th) {
                cn.jiguang.e.c.c("ActionManager", "#unexcepted- invoke method error:" + th);
            }
        }
        return obj;
    }

    public static void a(Context context, long j, int i) {
        for (Map.Entry<String, cn.jiguang.api.b> entry : a.entrySet()) {
            cn.jiguang.api.b value = entry.getValue();
            if (value != null) {
                value.onEvent(context, j, i);
            }
        }
    }

    private static void a(Context context, long j, int i, int i2) {
        for (Map.Entry<String, cn.jiguang.api.c> entry : b.entrySet()) {
            cn.jiguang.api.c value = entry.getValue();
            if (value != null) {
                value.onSendData(context, cn.jiguang.d.b.g.a.get(), j, i, i2);
            }
        }
    }

    public static void a(Context context, cn.jiguang.d.e.a.a.c cVar, ByteBuffer byteBuffer) {
        if (cVar == null) {
            return;
        }
        for (Map.Entry<String, cn.jiguang.api.b> entry : a.entrySet()) {
            cn.jiguang.api.b value = entry.getValue();
            if (value != null && value.isSupportedCMD(cVar.a())) {
                cVar.b(Long.valueOf(value.dispatchMessage(context, cn.jiguang.d.b.g.a.get(), cVar.a(), cVar, byteBuffer)));
                cn.jiguang.d.b.d.bO().a(entry.getKey(), cVar);
                byteBuffer.clear();
            }
        }
    }

    public static void a(Context context, String str, long j, Bundle bundle, Handler handler) {
        cn.jiguang.api.b bVar = a.get(str);
        if (bVar != null) {
            bVar.onActionRun(context, j, bundle, handler);
        }
    }

    public static void a(String str, String str2) {
        if (TextUtils.isEmpty(str2) || a.containsKey(str)) {
            return;
        }
        try {
            Object newInstance = Class.forName(str2).newInstance();
            if (newInstance instanceof cn.jiguang.api.b) {
                a.put(str, (cn.jiguang.api.b) newInstance);
            }
        } catch (Throwable th) {
            cn.jiguang.e.c.c("ActionManager", "#unexcepted - instance " + str2 + " class failed:" + th);
        }
    }

    public static boolean a(int i) {
        for (Map.Entry<String, cn.jiguang.api.c> entry : b.entrySet()) {
            cn.jiguang.api.c value = entry.getValue();
            if (value != null) {
                try {
                    cn.jiguang.e.c.a("ActionManager", "isAllowAction actionType:0,sdktype:" + entry.getKey() + ",action:" + value.checkAction(0));
                    if (!value.checkAction(0)) {
                        return false;
                    }
                } catch (Throwable th) {
                }
            }
        }
        return true;
    }

    public static void b(Context context, long j, int i) {
        for (Map.Entry<String, cn.jiguang.api.b> entry : a.entrySet()) {
            cn.jiguang.api.b value = entry.getValue();
            if (value != null) {
                value.dispatchTimeOutMessage(context, cn.jiguang.d.b.g.a.get(), j, i);
            }
        }
    }

    public static void b(Context context, String str, Object obj) {
        if (cn.jiguang.g.i.a(str)) {
            for (Map.Entry<String, cn.jiguang.api.b> entry : a.entrySet()) {
                cn.jiguang.d.b.d.bO();
                entry.getValue().handleMessage(context, cn.jiguang.d.b.d.g(), obj);
            }
            return;
        }
        cn.jiguang.api.b bVar = a.get(str);
        if (bVar != null) {
            cn.jiguang.d.b.d.bO();
            bVar.handleMessage(context, cn.jiguang.d.b.d.g(), obj);
        }
    }

    public static void b(String str, String str2) {
        if (b.containsKey(str)) {
            return;
        }
        try {
            Object newInstance = Class.forName(str2).newInstance();
            if (newInstance instanceof cn.jiguang.api.c) {
                b.put(str, (cn.jiguang.api.c) newInstance);
            }
        } catch (Throwable th) {
            cn.jiguang.e.c.c("ActionManager", "#unexcepted - instance " + str2 + " class failed:" + th);
        }
    }

    public static e bU() {
        if (lX == null) {
            synchronized (d) {
                if (lX == null) {
                    lX = new e();
                }
            }
        }
        return lX;
    }

    public static IBinder h(String str, String str2) {
        cn.jiguang.api.b bVar = a.get(str);
        if (bVar != null) {
            return bVar.getBinderByType(str2);
        }
        return null;
    }

    public static String j(String str, String str2) {
        cn.jiguang.api.b bVar;
        return (!a.containsKey(str) || (bVar = a.get(str)) == null || TextUtils.isEmpty(bVar.getSdkVersion())) ? str2 : bVar.getSdkVersion();
    }

    public final ArrayList<Object> a(Context context, String str, int i, String str2, int i2) {
        ArrayList<Object> arrayList = new ArrayList<>();
        if (cn.jiguang.g.i.a(str)) {
            for (Map.Entry<String, cn.jiguang.api.c> entry : b.entrySet()) {
                Object a2 = a(entry.getValue(), context, 21, str2, 1);
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
        } else {
            Object a3 = a(b.get(str), context, 21, str2, 1);
            if (a3 != null) {
                arrayList.add(a3);
            }
        }
        return arrayList;
    }

    public final void a(Context context, String str, long j, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            a(context, j, i, 6026);
            return;
        }
        cn.jiguang.api.c cVar = b.get(str);
        if (cVar == null) {
            a(context, j, i, 6026);
        } else {
            cVar.onSendData(context, cn.jiguang.d.b.g.a.get(), j, i, 6026);
        }
    }

    public final boolean a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            jSONObject.put(ETAG.KEY_SDK_VER, j(SdkType.JPUSH.name(), ""));
            jSONObject.put("core_sdk_ver", j(SdkType.JCORE.name(), ""));
            jSONObject.put("share_sdk_ver", j(SdkType.JSHARE.name(), ""));
            jSONObject.put("ssp_sdk_ver", j(SdkType.JSSP.name(), ""));
            jSONObject.put("statistics_sdk_ver", j(SdkType.JANALYTICS.name(), ""));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return true;
    }
}
