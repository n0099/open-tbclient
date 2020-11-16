package com.baidu.fsg.base.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.fsg.base.ApollonConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes15.dex */
public final class ResUtils {
    public static final String ANIM = "anim";

    /* renamed from: a  reason: collision with root package name */
    private static final String f1525a = "id";
    private static final String b = "string";
    private static final String c = "layout";
    private static final String d = "style";
    private static final String e = "drawable";
    private static final String f = "color";
    private static final String g = "array";
    private static final String h = "attr";
    private static final String i = "dimen";
    private static final String j = "xml";
    private static final String k = "integer";
    private static final String l = "raw";
    private static Context m = null;
    private static String resourcePakcageName;

    private ResUtils() {
    }

    public static int id(Context context, String str) {
        return a(context, "id", str);
    }

    public static void setResourcePackageName(String str) {
        resourcePakcageName = str;
    }

    public static String getResourcePackageName() {
        return resourcePakcageName;
    }

    public static int string(Context context, String str) {
        return a(context, b, str);
    }

    public static String string(String str) {
        return m.getString(a(m, b, str));
    }

    public static int layout(Context context, String str) {
        return a(context, c, str);
    }

    public static int style(Context context, String str) {
        return a(context, "style", str);
    }

    public static int drawable(Context context, String str) {
        return a(context, e, str);
    }

    public static int color(Context context, String str) {
        return a(context, f, str);
    }

    public static int anim(Context context, String str) {
        return a(context, ANIM, str);
    }

    public static int anim(Context context, String str, String str2) {
        return a(context, str, ANIM, str2);
    }

    public static int raw(Context context, String str) {
        return a(context, l, str);
    }

    public static int array(Context context, String str) {
        return a(context, "array", str);
    }

    public static int attr(Context context, String str) {
        return a(context, h, str);
    }

    public static int dimen(Context context, String str) {
        return a(context, i, str);
    }

    public static int integer(Context context, String str) {
        return a(context, k, str);
    }

    public static int xml(Context context, String str) {
        return a(context, j, str);
    }

    public static String getString(Context context, String str) {
        if (context != null && context.getResources() != null) {
            try {
                return context.getResources().getString(string(context, str));
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return "";
    }

    public static int getColor(Context context, String str) {
        LogUtil.d("aaa", "name is " + str + "+++ color id is " + color(context, str));
        return context.getResources().getColor(color(context, str));
    }

    public static Drawable getDrawable(Context context, String str) {
        return context.getResources().getDrawable(drawable(context, str));
    }

    public static String[] getStringArray(Context context, String str) {
        return context.getResources().getStringArray(array(context, str));
    }

    public static float getDimension(Context context, String str) {
        return context.getResources().getDimension(dimen(context, str));
    }

    public static int getInteger(Context context, String str) {
        return context.getResources().getInteger(integer(context, str));
    }

    public static Animation getAnimation(Context context, String str) {
        return AnimationUtils.loadAnimation(context, anim(context, str));
    }

    private static int a(Context context, String str, String str2) {
        if (context == null) {
            throw new NullPointerException("the context is null");
        }
        if (str != null && str.trim().length() != 0) {
            if (str2 != null && str2.trim().length() != 0) {
                Resources resources = context.getResources();
                String packageName = context.getPackageName();
                if (ChannelUtils.isSpecailPackage()) {
                    packageName = "com.baidu.wallet";
                }
                if (ApollonConstants.DEBUG) {
                    Log.d("ResUtils", "context instance is " + context);
                    Log.d("ResUtils", "packake name is " + packageName + " attrName is " + str2 + ", context instance is " + context);
                }
                int identifier = resources.getIdentifier(str2, str, packageName);
                if (identifier <= 0) {
                    return resources.getIdentifier(str2, str, resourcePakcageName);
                }
                return identifier;
            }
            throw new NullPointerException("the attrNme is null or empty");
        }
        throw new NullPointerException("the type is null or empty");
    }

    private static int a(Context context, String str, String str2, String str3) {
        if (context == null) {
            throw new NullPointerException("the context is null");
        }
        if (str2 != null && str2.trim().length() != 0) {
            if (str3 != null && str3.trim().length() != 0) {
                Resources resources = context.getResources();
                if (ChannelUtils.isSpecailPackage()) {
                    str = "com.baidu.walletss";
                }
                if (ApollonConstants.DEBUG) {
                    Log.d("ResUtils", "context instance is " + context);
                    Log.d("ResUtils", "packake name is " + str + " attrName is " + str3 + ", context instance is " + context);
                }
                int identifier = resources.getIdentifier(str3, str2, str);
                if (identifier <= 0) {
                    return resources.getIdentifier(str3, str2, resourcePakcageName);
                }
                return identifier;
            }
            throw new NullPointerException("the attrNme is null or empty");
        }
        throw new NullPointerException("the type is null or empty");
    }

    public static void setApplicationContext(Context context) {
        if (context != null) {
            m = context.getApplicationContext();
        }
    }

    public static Context getApplicationContext() {
        return m;
    }

    public static byte[] readAssets(Context context, String str) {
        return a(context, str);
    }

    private static byte[] a(Context context, String str) {
        if (context == null) {
            Log.i("cf", "concreteGetSign context 为空");
            return null;
        }
        Log.i("cf", "name =" + str);
        if (TextUtils.isEmpty(str)) {
            Log.i("cf", "concreteGetSign name 为空");
            return null;
        }
        Log.i("cf", "concreteGetSign 读取的文件内容是=" + str);
        try {
            InputStream open = context.getAssets().open(str);
            if (open != null) {
                int available = open.available();
                Log.i("cf", "concreteGetSign 读取的文件的长度是=" + available);
                if (available > 0) {
                    byte[] bArr = new byte[available];
                    open.read(bArr);
                    open.close();
                    Log.d("cf", "concreteGetSign 读取文件的16进制: " + a(bArr, true));
                    return bArr;
                }
                return null;
            }
            return null;
        } catch (Exception e2) {
            Log.e("cf", "concreteGetSign 读取文件发生了错误");
            e2.printStackTrace();
            return null;
        }
    }

    private static String a(byte[] bArr, boolean z) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < bArr.length; i2++) {
            String hexString = Integer.toHexString(bArr[i2] & 255);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            stringBuffer.append(hexString.toUpperCase());
            if (z && i2 != bArr.length - 1) {
                stringBuffer.append(":");
            }
        }
        return stringBuffer.toString();
    }

    public static void saveToSDCard(byte[] bArr) {
        if (bArr == null) {
            Log.i("cf", "saveToSDCard bs 为空");
            return;
        }
        File file = new File(Environment.getExternalStorageDirectory(), "rim.license");
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bArr);
            fileOutputStream.close();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        Log.i("cf", "saveToSDCard bs 成功");
    }
}
