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
import com.baidu.sofire.i.e;
import com.baidu.sofire.mutiprocess.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes15.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static Context f5592a;

    /* renamed from: b  reason: collision with root package name */
    private static Map<Integer, a> f5593b = new HashMap();
    private static Map<Integer, List<String>> c = new HashMap();
    private static List<String> d = new ArrayList();
    private static a e = new a.AbstractBinderC0366a() { // from class: com.baidu.sofire.mutiprocess.b.1
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

    /* JADX INFO: Access modifiers changed from: private */
    public static Bundle d(Bundle bundle) {
        Bundle a2;
        try {
            String string = bundle.getString("bundle_key_method_name");
            String string2 = bundle.getString("bundle_key_plugin_package_name");
            if (TextUtils.isEmpty(string2) || TextUtils.isEmpty(string)) {
                a2 = a(-101);
            } else {
                f a3 = f.a();
                if (a3 == null) {
                    a2 = a((int) OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
                } else {
                    ApkInfo d2 = a3.d(string2);
                    c a4 = c.a();
                    if (a4 == null) {
                        a2 = a((int) OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_JS_CODE_FAIL);
                    } else {
                        Pair<Integer, Object> a5 = a4.a(d2.key, string, new Class[]{Bundle.class}, bundle);
                        if (((Integer) a5.first).intValue() == 0) {
                            if (a5.second instanceof Bundle) {
                                a2 = (Bundle) a5.second;
                                a2.putInt("bundle_key_error_code", 0);
                            } else {
                                a2 = a(-103);
                            }
                        } else {
                            a2 = a(((Integer) a5.first).intValue());
                        }
                    }
                }
            }
            return a2;
        } catch (Throwable th) {
            e.a();
            try {
                return a(-100);
            } catch (Throwable th2) {
                e.a();
                return null;
            }
        }
    }

    public static int a(Context context) {
        try {
            int a2 = e.a(context);
            if (a2 == 1 || a2 == 3) {
                return 1;
            }
            return (a2 == 2 || a2 == 4) ? 0 : -1;
        } catch (Throwable th) {
            e.a();
            return -1;
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

    private static Bundle a(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("bundle_key_error_code", i);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Set<Integer> a() {
        try {
            if (f5593b == null) {
                return null;
            }
            return f5593b.keySet();
        } catch (Throwable th) {
            e.a();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int a(int i, String str, boolean z) {
        try {
            if (TextUtils.isEmpty(str)) {
                return -201;
            }
            if (f5593b == null) {
                return -200;
            }
            a aVar = f5593b.get(Integer.valueOf(i));
            if (aVar == null) {
                return -202;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("bundle_key_ctrl_action", z ? 1 : 2);
            bundle.putString("bundle_key_plugin_package_name", str);
            int i2 = aVar.a(bundle).getInt("bundle_key_error_code", -200);
            if (i2 == 0 && c != null) {
                List<String> list = c.get(Integer.valueOf(i));
                if (list == null) {
                    list = new ArrayList<>();
                    c.put(Integer.valueOf(i), list);
                }
                if (z && !list.contains(str)) {
                    list.add(str);
                } else if (!z && list.contains(str)) {
                    list.remove(str);
                }
            }
            return i2;
        } catch (RemoteException e2) {
            e.a();
            return -203;
        } catch (Throwable th) {
            e.a();
            return -200;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Map<Integer, Integer> a(String str) {
        try {
            if (!TextUtils.isEmpty(str) && f5593b != null) {
                HashMap hashMap = new HashMap();
                for (Integer num : f5593b.keySet()) {
                    hashMap.put(num, Integer.valueOf(a(num.intValue(), str, true)));
                }
                return hashMap;
            }
            return null;
        } catch (Throwable th) {
            e.a();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Bundle a(int i, Bundle bundle) {
        Bundle b2;
        try {
            if (bundle == null) {
                b2 = a(-201);
            } else if (f5593b == null) {
                b2 = a(-200);
            } else {
                a aVar = f5593b.get(Integer.valueOf(i));
                if (aVar == null) {
                    b2 = a(-202);
                } else {
                    b2 = aVar.b(bundle);
                }
            }
            return b2;
        } catch (RemoteException e2) {
            e.a();
            return a(-203);
        } catch (Throwable th) {
            e.a();
            try {
                return a(-200);
            } catch (Throwable th2) {
                e.a();
                return null;
            }
        }
    }

    private static Bundle e(Bundle bundle) {
        try {
            bundle.setClassLoader(b.class.getClassLoader());
            int i = bundle.getInt("bundle_key_pid");
            BinderHolder binderHolder = (BinderHolder) bundle.getParcelable("bundle_key_binder_holder");
            if (i <= 0 || binderHolder == null || binderHolder.f5589a == null) {
                return a(-101);
            }
            f5593b.put(Integer.valueOf(i), a.AbstractBinderC0366a.a(binderHolder.f5589a));
            if (d.size() <= 0) {
                return a(0);
            }
            c a2 = c.a();
            f a3 = f.a();
            if (a2 == null || a3 == null) {
                return a(0);
            }
            for (String str : d) {
                ApkInfo d2 = a3.d(str);
                if (d2 == null) {
                    return a(0);
                }
                a2.a(d2.key, "notifyNewSubProcess", new Class[]{Integer.TYPE}, Integer.valueOf(i));
            }
            return a(0);
        } catch (Throwable th) {
            e.a();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(String str, boolean z) {
        try {
            if (!TextUtils.isEmpty(str) && d != null) {
                if (z) {
                    d.add(str);
                } else {
                    d.remove(str);
                }
            }
        } catch (Throwable th) {
            e.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Bundle a(int i, String str) {
        Bundle a2;
        try {
            if (TextUtils.isEmpty(str)) {
                a2 = a(-201);
            } else if (f5593b == null) {
                a2 = a(-200);
            } else {
                a aVar = f5593b.get(Integer.valueOf(i));
                if (aVar == null) {
                    a2 = a(-202);
                } else {
                    a2 = aVar.a(str);
                }
            }
            return a2;
        } catch (RemoteException e2) {
            e.a();
            return a(-203);
        } catch (Throwable th) {
            e.a();
            return a(-200);
        }
    }

    public static void b(String str) {
        Set<Map.Entry<Integer, List<String>>> entrySet;
        try {
            if (c != null && (entrySet = c.entrySet()) != null) {
                for (Map.Entry<Integer, List<String>> entry : entrySet) {
                    List<String> value = entry.getValue();
                    if (value != null && value.contains(str)) {
                        a(entry.getKey().intValue(), str, false);
                    }
                }
            }
        } catch (Throwable th) {
            e.a();
        }
    }

    public static void b(Context context) {
        if (context != null) {
            try {
                if (e.c(context, "ampf") && Build.VERSION.SDK_INT >= 11) {
                    f5592a = context.getApplicationContext();
                    ContentResolver contentResolver = context.getApplicationContext().getContentResolver();
                    Bundle bundle = new Bundle();
                    bundle.putInt("bundle_key_pid", Process.myPid());
                    bundle.putParcelable("bundle_key_binder_holder", new BinderHolder(e.asBinder()));
                    contentResolver.call(b(), "sub_process_register_sub_process", (String) null, bundle);
                }
            } catch (Throwable th) {
                e.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0035 -> B:5:0x000a). Please submit an issue!!! */
    public static Bundle a(Bundle bundle) {
        try {
        } catch (Throwable th) {
            e.a();
        }
        if (f5592a == null) {
            return a(-204);
        } else if (bundle == null) {
            return a(-201);
        } else {
            if (Build.VERSION.SDK_INT >= 11) {
                return f5592a.getApplicationContext().getContentResolver().call(b(), "sub_process_call_main_plugin", (String) null, bundle);
            }
            return a(-200);
        }
    }

    private static Uri b() {
        if (f5592a == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder("content://");
        sb.append(f5592a.getPackageName()).append(".sofire.ac.provider");
        return Uri.parse(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bundle f(Bundle bundle) {
        Bundle h;
        try {
            switch (bundle.getInt("bundle_key_ctrl_action")) {
                case 1:
                    h = g(bundle);
                    break;
                case 2:
                    h = h(bundle);
                    break;
                default:
                    h = a((int) OneKeyLoginResult.ONE_KEY_LOGIN_CODE_CHECK_JS_FAIL);
                    break;
            }
            return h;
        } catch (Throwable th) {
            e.a();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bundle d(String str) {
        Bundle bundle;
        try {
            if (TextUtils.isEmpty(str)) {
                bundle = a(-101);
            } else {
                f a2 = f.a();
                if (a2 == null) {
                    bundle = a((int) OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
                } else {
                    bundle = new Bundle();
                    if (a2.d(str) == null) {
                        bundle.putInt("bundle_key_error_code", 0);
                        bundle.putInt("status", -1);
                    } else {
                        bundle.putInt("bundle_key_error_code", 0);
                        bundle.putInt("status", 1);
                    }
                }
            }
            return bundle;
        } catch (Throwable th) {
            e.a();
            try {
                return a(-100);
            } catch (Throwable th2) {
                e.a();
                return null;
            }
        }
    }

    private static Bundle g(Bundle bundle) {
        Bundle a2;
        try {
            if (f5592a == null) {
                a2 = a((int) OneKeyLoginResult.ONE_KEY_LOGIN_CODE_IN_GUIDE_PROCESS);
            } else {
                String string = bundle.getString("bundle_key_plugin_package_name");
                if (TextUtils.isEmpty(string)) {
                    a2 = a(-101);
                } else {
                    c a3 = c.a(f5592a);
                    if (a3 == null) {
                        a2 = a((int) OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_JS_CODE_FAIL);
                    } else if (a3.b(string)) {
                        a2 = a(0);
                    } else {
                        a2 = a(-100);
                    }
                }
            }
            return a2;
        } catch (Throwable th) {
            e.a();
            return null;
        }
    }

    private static Bundle h(Bundle bundle) {
        Bundle a2;
        try {
            if (f5592a == null) {
                a2 = a((int) OneKeyLoginResult.ONE_KEY_LOGIN_CODE_IN_GUIDE_PROCESS);
            } else {
                String string = bundle.getString("bundle_key_plugin_package_name");
                if (TextUtils.isEmpty(string)) {
                    a2 = a(-101);
                } else {
                    f a3 = f.a();
                    if (a3 == null) {
                        a2 = a((int) OneKeyLoginResult.ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL);
                    } else if (a3.e(string)) {
                        a2 = a(0);
                    } else {
                        a2 = a(-100);
                    }
                }
            }
            return a2;
        } catch (Throwable th) {
            e.a();
            return null;
        }
    }
}
