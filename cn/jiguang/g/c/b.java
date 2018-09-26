package cn.jiguang.g.c;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public final class b {
    private static int a = 0;

    private static int a(int i) {
        try {
            Method declaredMethod = Class.forName("android.telephony.SubscriptionManager").getDeclaredMethod("getSubId", Integer.TYPE);
            declaredMethod.setAccessible(true);
            int[] iArr = (int[]) declaredMethod.invoke(null, Integer.valueOf(i));
            return iArr.length > 0 ? iArr[0] : i;
        } catch (Throwable th) {
            return i;
        }
    }

    private static a a(TelephonyManager telephonyManager) {
        if (telephonyManager == null) {
            return null;
        }
        a aVar = new a();
        try {
            aVar.a = telephonyManager.getDeviceId();
            aVar.b = telephonyManager.getSubscriberId();
            aVar.c = telephonyManager.getSimSerialNumber();
            return aVar;
        } catch (Throwable th) {
            return aVar;
        }
    }

    public static ArrayList<a> a(Context context) {
        if ((a == 0 || a == 1) && a()) {
            a = 1;
            return av(context);
        } else if ((a == 0 || a == 2) && c(context)) {
            a = 2;
            return d(context);
        } else if ((a == 0 || a == 3) && e(context)) {
            a = 3;
            return aw(context);
        } else if ((a == 0 || a == 4) && g(context)) {
            a = 4;
            return ax(context);
        } else {
            a = 1;
            return av(context);
        }
    }

    private static boolean a() {
        try {
            return TelephonyManager.class.getMethod("getSimCount", new Class[0]) != null;
        } catch (Throwable th) {
            return false;
        }
    }

    private static ArrayList<a> av(Context context) {
        ArrayList<a> arrayList = new ArrayList<>();
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
            int b = b(telephonyManager);
            if (b > 0) {
                Method declaredMethod = telephonyManager.getClass().getDeclaredMethod("getImei", Integer.TYPE);
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = telephonyManager.getClass().getDeclaredMethod("getSimSerialNumber", Integer.TYPE);
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = telephonyManager.getClass().getDeclaredMethod("getSubscriberId", Integer.TYPE);
                declaredMethod3.setAccessible(true);
                for (int i = 0; i < b; i++) {
                    int a2 = a(i);
                    a aVar = new a();
                    try {
                        aVar.a = (String) declaredMethod.invoke(telephonyManager, Integer.valueOf(i));
                        aVar.c = (String) declaredMethod2.invoke(telephonyManager, Integer.valueOf(a2));
                        aVar.b = (String) declaredMethod3.invoke(telephonyManager, Integer.valueOf(a2));
                    } catch (Throwable th) {
                    }
                    arrayList.add(aVar);
                }
            } else {
                arrayList.add(a(telephonyManager));
            }
        } catch (Throwable th2) {
            arrayList.clear();
        }
        return arrayList;
    }

    private static ArrayList<a> aw(Context context) {
        ArrayList<a> arrayList = new ArrayList<>();
        try {
            Class<?> cls = Class.forName("android.telephony.MSimTelephonyManager");
            Object systemService = context.getSystemService("phone_msim");
            Method method = cls.getMethod("getDeviceId", Integer.TYPE);
            Method method2 = cls.getMethod("getSubscriberId", Integer.TYPE);
            a aVar = new a();
            try {
                aVar.a = (String) method.invoke(systemService, 0);
                aVar.b = (String) method2.invoke(systemService, 0);
            } catch (Throwable th) {
            }
            arrayList.add(aVar);
            a aVar2 = new a();
            try {
                aVar2.a = (String) method.invoke(systemService, 1);
                aVar2.b = (String) method2.invoke(systemService, 1);
            } catch (Throwable th2) {
            }
            arrayList.add(aVar2);
            return arrayList;
        } catch (Throwable th3) {
            return null;
        }
    }

    private static ArrayList<a> ax(Context context) {
        ArrayList<a> arrayList = new ArrayList<>();
        try {
            Class<?> cls = Class.forName("com.android.internal.telephony.PhoneFactory");
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService((String) cls.getMethod("getServiceName", String.class, Integer.TYPE).invoke(cls, ISapiAccount.SAPI_ACCOUNT_PHONE, 1));
            TelephonyManager telephonyManager2 = (TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
            a aVar = new a();
            try {
                aVar.b = telephonyManager2.getSubscriberId();
                aVar.a = telephonyManager2.getDeviceId();
                aVar.c = telephonyManager2.getSimSerialNumber();
            } catch (Throwable th) {
            }
            arrayList.add(aVar);
            a aVar2 = new a();
            try {
                aVar2.b = telephonyManager.getSubscriberId();
                aVar2.a = telephonyManager.getDeviceId();
                aVar2.c = telephonyManager.getSimSerialNumber();
            } catch (Throwable th2) {
            }
            arrayList.add(aVar2);
            return arrayList;
        } catch (Throwable th3) {
            return null;
        }
    }

    private static int b(TelephonyManager telephonyManager) {
        try {
            return ((Integer) telephonyManager.getClass().getMethod("getSimCount", new Class[0]).invoke(telephonyManager, new Object[0])).intValue();
        } catch (Throwable th) {
            return -1;
        }
    }

    private static ArrayList<Integer> c(TelephonyManager telephonyManager) {
        Field[] declaredFields;
        ArrayList<Integer> arrayList = new ArrayList<>();
        try {
            int i = 0;
            for (Field field : TelephonyManager.class.getDeclaredFields()) {
                field.setAccessible(true);
                if (TextUtils.equals(field.getType().getName(), "com.android.internal.telephony.ITelephonyRegistry") && field.get(telephonyManager) != null) {
                    arrayList.add(Integer.valueOf(i));
                    i++;
                }
            }
        } catch (Throwable th) {
            arrayList.clear();
            arrayList.add(0);
            arrayList.add(1);
        }
        return arrayList;
    }

    private static boolean c(Context context) {
        try {
            c((TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE));
            Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getSubscriberIdGemini", Integer.TYPE);
            Method declaredMethod2 = TelephonyManager.class.getDeclaredMethod("getDeviceIdGemini", Integer.TYPE);
            Method declaredMethod3 = TelephonyManager.class.getDeclaredMethod("getPhoneTypeGemini", Integer.TYPE);
            Field declaredField = TelephonyManager.class.getDeclaredField("mtkGeminiSupport");
            if (declaredMethod != null && declaredMethod2 != null && declaredMethod3 != null && declaredField != null) {
                declaredField.setAccessible(true);
                if (((Boolean) declaredField.get(null)).booleanValue()) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    private static ArrayList<a> d(Context context) {
        int i = 0;
        ArrayList<a> arrayList = new ArrayList<>();
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
            Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getSubscriberIdGemini", Integer.TYPE);
            Method declaredMethod2 = TelephonyManager.class.getDeclaredMethod("getDeviceIdGemini", Integer.TYPE);
            Method declaredMethod3 = TelephonyManager.class.getDeclaredMethod("getSimSerialNumberGemini", Integer.TYPE);
            ArrayList<Integer> c = c(telephonyManager);
            while (true) {
                int i2 = i;
                if (i2 >= c.size()) {
                    return arrayList;
                }
                a aVar = new a();
                try {
                    int intValue = c.get(i2).intValue();
                    aVar.b = (String) declaredMethod.invoke(telephonyManager, Integer.valueOf(intValue));
                    aVar.a = (String) declaredMethod2.invoke(telephonyManager, Integer.valueOf(intValue));
                    aVar.c = (String) declaredMethod3.invoke(telephonyManager, Integer.valueOf(intValue));
                } catch (Throwable th) {
                }
                arrayList.add(aVar);
                i = i2 + 1;
            }
        } catch (Throwable th2) {
            return null;
        }
    }

    private static boolean e(Context context) {
        try {
            Class<?> cls = Class.forName("android.telephony.MSimTelephonyManager");
            return (context.getSystemService("phone_msim") == null || cls.getMethod("getDeviceId", Integer.TYPE) == null || cls.getMethod("getSubscriberId", Integer.TYPE) == null) ? false : true;
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean g(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.telephony.PhoneFactory");
            Method method = cls.getMethod("getServiceName", String.class, Integer.TYPE);
            String str = (String) method.invoke(cls, ISapiAccount.SAPI_ACCOUNT_PHONE, 1);
            return (method == null || str == null || ((TelephonyManager) context.getSystemService(str)) == null) ? false : true;
        } catch (Throwable th) {
            return false;
        }
    }
}
