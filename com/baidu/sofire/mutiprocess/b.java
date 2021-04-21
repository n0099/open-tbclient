package com.baidu.sofire.mutiprocess;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.c;
import com.baidu.sofire.core.f;
import com.baidu.sofire.g.d;
import com.baidu.sofire.mutiprocess.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static Context f11522a;

    /* renamed from: b  reason: collision with root package name */
    public static Map<Integer, a> f11523b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public static Map<Integer, List<String>> f11524c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public static List<String> f11525d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public static a f11526e = new a.AbstractBinderC0163a() { // from class: com.baidu.sofire.mutiprocess.b.1
        @Override // com.baidu.sofire.mutiprocess.a
        public final Bundle a(Bundle bundle) throws RemoteException {
            return b.f(bundle);
        }

        @Override // com.baidu.sofire.mutiprocess.a
        public final Bundle b(Bundle bundle) throws RemoteException {
            return b.d(bundle);
        }

        @Override // com.baidu.sofire.mutiprocess.a
        public final Bundle a(String str) throws RemoteException {
            return b.d(str);
        }
    };

    public static int a(Context context) {
        return d.b(context);
    }

    public static Bundle d(Bundle bundle) {
        try {
            String string = bundle.getString("bundle_key_method_name");
            String string2 = bundle.getString("bundle_key_plugin_package_name");
            if (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string)) {
                f a2 = f.a();
                if (a2 == null) {
                    return a((int) OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
                }
                ApkInfo d2 = a2.d(string2);
                c a3 = c.a();
                if (a3 == null) {
                    return a((int) OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_JS_CODE_FAIL);
                }
                Pair<Integer, Object> a4 = a3.a(d2.key, string, new Class[]{Bundle.class}, bundle);
                if (((Integer) a4.first).intValue() == 0) {
                    if (a4.second instanceof Bundle) {
                        Bundle bundle2 = (Bundle) a4.second;
                        bundle2.putInt("bundle_key_error_code", 0);
                        return bundle2;
                    }
                    return a(-103);
                }
                return a(((Integer) a4.first).intValue());
            }
            return a(-101);
        } catch (Throwable unused) {
            d.a();
            try {
                return a(-100);
            } catch (Throwable unused2) {
                d.a();
                return null;
            }
        }
    }

    public static Bundle e(Bundle bundle) {
        try {
            bundle.setClassLoader(b.class.getClassLoader());
            int i = bundle.getInt("bundle_key_pid");
            BinderHolder binderHolder = (BinderHolder) bundle.getParcelable("bundle_key_binder_holder");
            if (i > 0 && binderHolder != null && binderHolder.f11519a != null) {
                f11523b.put(Integer.valueOf(i), a.AbstractBinderC0163a.a(binderHolder.f11519a));
                if (f11525d.size() <= 0) {
                    return a(0);
                }
                c a2 = c.a();
                f a3 = f.a();
                if (a2 != null && a3 != null) {
                    for (String str : f11525d) {
                        ApkInfo d2 = a3.d(str);
                        if (d2 == null) {
                            return a(0);
                        }
                        a2.a(d2.key, "notifyNewSubProcess", new Class[]{Integer.TYPE}, Integer.valueOf(i));
                    }
                    return a(0);
                }
                return a(0);
            }
            return a(-101);
        } catch (Throwable unused) {
            d.a();
            return null;
        }
    }

    public static Bundle f(Bundle bundle) {
        try {
            int i = bundle.getInt("bundle_key_ctrl_action");
            if (i != 1) {
                if (i != 2) {
                    return a((int) OneKeyLoginResult.ONE_KEY_LOGIN_CODE_CHECK_JS_FAIL);
                }
                return h(bundle);
            }
            return g(bundle);
        } catch (Throwable unused) {
            d.a();
            return null;
        }
    }

    public static Bundle g(Bundle bundle) {
        try {
            if (f11522a == null) {
                return a((int) OneKeyLoginResult.ONE_KEY_LOGIN_CODE_IN_GUIDE_PROCESS);
            }
            String string = bundle.getString("bundle_key_plugin_package_name");
            if (TextUtils.isEmpty(string)) {
                return a(-101);
            }
            c a2 = c.a(f11522a);
            if (a2 == null) {
                return a((int) OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_JS_CODE_FAIL);
            }
            if (a2.b(string)) {
                return a(0);
            }
            return a(-100);
        } catch (Throwable unused) {
            d.a();
            return null;
        }
    }

    public static Bundle h(Bundle bundle) {
        try {
            if (f11522a == null) {
                return a((int) OneKeyLoginResult.ONE_KEY_LOGIN_CODE_IN_GUIDE_PROCESS);
            }
            String string = bundle.getString("bundle_key_plugin_package_name");
            if (TextUtils.isEmpty(string)) {
                return a(-101);
            }
            f a2 = f.a();
            if (a2 == null) {
                return a((int) OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
            }
            if (a2.e(string)) {
                return a(0);
            }
            return a(-100);
        } catch (Throwable unused) {
            d.a();
            return null;
        }
    }

    public static Bundle a(String str, Bundle bundle) {
        if (!TextUtils.isEmpty(str) && str.contains("register_sub_process")) {
            return e(bundle);
        }
        if (!TextUtils.isEmpty(str) && str.contains("call_main_plugin")) {
            return d(bundle);
        }
        return a(-300);
    }

    public static void b(String str) {
        Set<Map.Entry<Integer, List<String>>> entrySet;
        try {
            if (f11524c == null || (entrySet = f11524c.entrySet()) == null) {
                return;
            }
            for (Map.Entry<Integer, List<String>> entry : entrySet) {
                List<String> value = entry.getValue();
                if (value != null && value.contains(str)) {
                    a(entry.getKey().intValue(), str, false);
                }
            }
        } catch (Throwable unused) {
            d.a();
        }
    }

    public static Bundle a(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("bundle_key_error_code", i);
        return bundle;
    }

    public static Set<Integer> a() {
        try {
            if (f11523b == null) {
                return null;
            }
            return f11523b.keySet();
        } catch (Throwable unused) {
            d.a();
            return null;
        }
    }

    public static void b(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (d.b(context, "ampf") && Build.VERSION.SDK_INT >= 11) {
                f11522a = context.getApplicationContext();
                ContentResolver contentResolver = context.getApplicationContext().getContentResolver();
                Bundle bundle = new Bundle();
                bundle.putInt("bundle_key_pid", Process.myPid());
                bundle.putParcelable("bundle_key_binder_holder", new BinderHolder(f11526e.asBinder()));
                contentResolver.call(b(), "sub_process_register_sub_process", (String) null, bundle);
            }
        } catch (Throwable unused) {
            d.a();
        }
    }

    public static int a(int i, String str, boolean z) {
        try {
            if (TextUtils.isEmpty(str)) {
                return -201;
            }
            if (f11523b == null) {
                return -200;
            }
            a aVar = f11523b.get(Integer.valueOf(i));
            if (aVar == null) {
                return -202;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("bundle_key_ctrl_action", z ? 1 : 2);
            bundle.putString("bundle_key_plugin_package_name", str);
            int i2 = aVar.a(bundle).getInt("bundle_key_error_code", -200);
            if (i2 == 0 && f11524c != null) {
                List<String> list = f11524c.get(Integer.valueOf(i));
                if (list == null) {
                    list = new ArrayList<>();
                    f11524c.put(Integer.valueOf(i), list);
                }
                if (z && !list.contains(str)) {
                    list.add(str);
                } else if (!z && list.contains(str)) {
                    list.remove(str);
                }
            }
            return i2;
        } catch (RemoteException unused) {
            d.a();
            return -203;
        } catch (Throwable unused2) {
            d.a();
            return -200;
        }
    }

    public static Bundle d(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return a(-101);
            }
            f a2 = f.a();
            if (a2 == null) {
                return a((int) OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
            }
            Bundle bundle = new Bundle();
            if (a2.d(str) == null) {
                bundle.putInt("bundle_key_error_code", 0);
                bundle.putInt("status", -1);
                return bundle;
            }
            bundle.putInt("bundle_key_error_code", 0);
            bundle.putInt("status", 1);
            return bundle;
        } catch (Throwable unused) {
            d.a();
            try {
                return a(-100);
            } catch (Throwable unused2) {
                d.a();
                return null;
            }
        }
    }

    public static Uri b() {
        if (f11522a == null) {
            return null;
        }
        return Uri.parse("content://" + f11522a.getPackageName() + ".sofire.ac.provider");
    }

    public static Map<Integer, Integer> a(String str) {
        try {
            if (TextUtils.isEmpty(str) || f11523b == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            for (Integer num : f11523b.keySet()) {
                hashMap.put(num, Integer.valueOf(a(num.intValue(), str, true)));
            }
            return hashMap;
        } catch (Throwable unused) {
            d.a();
            return null;
        }
    }

    public static Bundle a(int i, Bundle bundle) {
        try {
            if (bundle == null) {
                return a(-201);
            }
            if (f11523b == null) {
                return a(-200);
            }
            a aVar = f11523b.get(Integer.valueOf(i));
            if (aVar == null) {
                return a(-202);
            }
            return aVar.b(bundle);
        } catch (RemoteException unused) {
            d.a();
            return a(-203);
        } catch (Throwable unused2) {
            d.a();
            try {
                return a(-200);
            } catch (Throwable unused3) {
                d.a();
                return null;
            }
        }
    }

    public static void a(String str, boolean z) {
        try {
            if (TextUtils.isEmpty(str) || f11525d == null) {
                return;
            }
            if (z) {
                f11525d.add(str);
            } else {
                f11525d.remove(str);
            }
        } catch (Throwable unused) {
            d.a();
        }
    }

    public static Bundle a(int i, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return a(-201);
            }
            if (f11523b == null) {
                return a(-200);
            }
            a aVar = f11523b.get(Integer.valueOf(i));
            if (aVar == null) {
                return a(-202);
            }
            return aVar.a(str);
        } catch (RemoteException unused) {
            d.a();
            return a(-203);
        } catch (Throwable unused2) {
            d.a();
            return a(-200);
        }
    }

    public static Bundle a(Bundle bundle) {
        try {
        } catch (Throwable unused) {
            d.a();
        }
        if (f11522a == null) {
            return a(-204);
        }
        if (bundle == null) {
            return a(-201);
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return f11522a.getApplicationContext().getContentResolver().call(b(), "sub_process_call_main_plugin", (String) null, bundle);
        }
        return a(-200);
    }
}
