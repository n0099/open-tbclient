package com.baidu.browser.core.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.baidu.browser.core.BdCore;
import com.baidu.loginshare.e;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class BdUtil {
    private static final String BAIDU_BROWSER_PACKAGE_NAME = "com.baidu.browser.apps";
    private static final boolean DEBUG = false;
    private static final String LOG_TAG = "BdSysWebView";
    public static final String UTF8 = "utf-8";

    private BdUtil() {
    }

    public static int dip2pix(Context context, float f) {
        return Math.round(BdCore.getScreenDensity(context) * f);
    }

    public static String composeUrl(String str) {
        if (str == null || str.length() <= 0) {
            return str;
        }
        String str2 = (str.startsWith(e.f) || str.startsWith(e.g) || str.startsWith("ftp://") || str.startsWith("rtsp://") || str.startsWith("mms://")) ? str : e.f + str;
        if (!checkStrIsUrl(str2)) {
            try {
                return String.valueOf("http://m.baidu.com/ssid=0/from=0/bd_page_type=1/uid=wiaui_1298960413_1175/s?tn=iphone&st=11104i&tj=i_sbtn0&pu=sz%401320_480&word=") + URLEncoder.encode(str, "gbk");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return str2;
            }
        }
        return str2;
    }

    private static boolean checkStrIsUrl(String str) {
        return Pattern.compile("^((https|http|ftp|rtsp|mms)?://)?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?(([0-9]{1,3}\\.){3}[0-9]{1,3}|([0-9a-z_!~*'()-]+\\.)*([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\.[a-z]{2,6})(:[0-9]{1,4})?((/?)|(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$", 2).matcher(str).find();
    }

    public static String reverseString(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        for (int i = length - 1; i >= 0; i--) {
            stringBuffer.append(str.charAt(i));
        }
        return stringBuffer.toString();
    }

    public static boolean hasBaiduBrowserInstalled(Context context) {
        for (PackageInfo packageInfo : context.getPackageManager().getInstalledPackages(0)) {
            if (packageInfo.packageName != null && packageInfo.packageName.equals(BAIDU_BROWSER_PACKAGE_NAME)) {
                return true;
            }
        }
        return false;
    }

    public static boolean invokeMethod(Object obj, String str, Object[] objArr, Object[] objArr2) {
        Class[] clsArr = objArr == null ? null : new Class[objArr.length];
        if (objArr != null) {
            for (int i = 0; i < objArr.length; i++) {
                clsArr[i] = objArr[i] == null ? null : objArr[i].getClass();
            }
        }
        return invokeMethod(obj, str, clsArr, objArr, objArr2);
    }

    public static boolean invokeMethod(Object obj, String str, Class[] clsArr, Object[] objArr, Object[] objArr2) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        Method method = getMethod(obj, str, clsArr);
        if (method != null) {
            method.setAccessible(true);
            try {
                Object invoke = method.invoke(obj, objArr);
                if (objArr2 != null && objArr2.length > 0) {
                    objArr2[0] = invoke;
                }
            } catch (ExceptionInInitializerError e) {
                throw new IllegalArgumentException(str, e);
            } catch (IllegalAccessException e2) {
                throw new IllegalArgumentException(str, e2);
            } catch (InvocationTargetException e3) {
                throw new IllegalArgumentException(str, e3);
            }
        } else {
            z = false;
        }
        return z;
    }

    protected Object getFieldValue(Object obj, String str) {
        Field field;
        if (obj == null || (field = getField(obj, str)) == null) {
            return null;
        }
        field.setAccessible(true);
        try {
            return field.get(obj);
        } catch (ExceptionInInitializerError e) {
            throw new IllegalArgumentException(str, e);
        } catch (IllegalAccessException e2) {
            throw new IllegalArgumentException(str, e2);
        }
    }

    protected boolean setFieldValue(Object obj, String str, Object obj2) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        Field field = getField(obj, str);
        if (field != null) {
            field.setAccessible(true);
            try {
                field.set(obj, obj2);
            } catch (ExceptionInInitializerError e) {
                throw new IllegalArgumentException(str, e);
            } catch (IllegalAccessException e2) {
                throw new IllegalArgumentException(str, e2);
            }
        } else {
            z = false;
        }
        return z;
    }

    protected Field getField(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                return cls.getDeclaredField(str);
            } catch (NoSuchFieldException e) {
            } catch (SecurityException e2) {
                throw new IllegalArgumentException(String.valueOf(cls.getName()) + "." + str, e2);
            }
        }
        return null;
    }

    protected static Method getMethod(Object obj, String str, Class[] clsArr) {
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                return cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException e) {
            } catch (SecurityException e2) {
                throw new IllegalArgumentException(String.valueOf(cls.getName()) + "." + str, e2);
            }
        }
        return null;
    }
}
