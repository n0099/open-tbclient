package com.baidu.swan.apps.process.b.a;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
/* loaded from: classes2.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(int i, String str, String str2, @Nullable Bundle bundle) {
        a gR = gR(str);
        if (gR == null) {
            if (DEBUG) {
                throw new RuntimeException("Messenger创建代理类失败");
            }
            a(i, str2, null);
            return;
        }
        if (DEBUG) {
            Log.d("MDelegate-Delegation", "exec call messenger delegation: " + str);
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        gR.baS = bundle;
        gR.baT = i;
        gR.baU = str2;
        gR.u(bundle);
    }

    public static void a(int i, String str, @Nullable Bundle bundle) {
        if (!com.baidu.swan.apps.process.b.b.d.a.gS(str)) {
            if (DEBUG) {
                Log.d("MDelegate-Delegation", "send result to client: " + i + " observer: " + str);
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("key_observer_id", str);
            if (bundle != null) {
                bundle2.putBundle("key_result_data", bundle);
            }
            if (i == -1000) {
                com.baidu.swan.apps.process.messaging.a.a.v(bundle2);
            } else {
                com.baidu.swan.apps.process.messaging.a.a.d(i, bundle2);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [143=4] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static a gR(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.e("MDelegate-Delegation", "create delegation with null delegate name");
            }
            return null;
        }
        try {
            Class<?> cls = Class.forName(str);
            if (cls == null) {
                if (DEBUG) {
                    throw new RuntimeException("Messenger代理类不存在：" + str);
                }
                return null;
            }
            int modifiers = cls.getModifiers();
            if (!a.class.isAssignableFrom(cls) || cls.isInterface() || Modifier.isAbstract(modifiers)) {
                if (DEBUG) {
                    throw new RuntimeException("Messenger代理类不合法：" + str);
                }
                return null;
            }
            Constructor<?> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            declaredConstructor.setAccessible(true);
            Object newInstance = declaredConstructor.newInstance(new Object[0]);
            if (newInstance instanceof a) {
                return (a) newInstance;
            }
            if (DEBUG) {
                throw new RuntimeException("Messenger代理类不是:" + a.class.getName());
            }
            return null;
        } catch (ClassNotFoundException e) {
            e = e;
            if (DEBUG) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            return null;
        } catch (IllegalAccessException e2) {
            e = e2;
            if (DEBUG) {
            }
        } catch (InstantiationException e3) {
            e = e3;
            if (DEBUG) {
            }
        } catch (NoSuchMethodException e4) {
            e = e4;
            if (DEBUG) {
            }
        } catch (InvocationTargetException e5) {
            e = e5;
            if (DEBUG) {
            }
        }
    }
}
