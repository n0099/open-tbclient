package com.baidu.apollon.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.apollon.ApollonConstants;
/* loaded from: classes.dex */
public class ResUtils {
    public static final String ANIM = "anim";

    /* renamed from: a  reason: collision with root package name */
    public static final String f4076a = "id";

    /* renamed from: b  reason: collision with root package name */
    public static final String f4077b = "string";

    /* renamed from: c  reason: collision with root package name */
    public static final String f4078c = "layout";

    /* renamed from: d  reason: collision with root package name */
    public static final String f4079d = "style";

    /* renamed from: e  reason: collision with root package name */
    public static final String f4080e = "drawable";

    /* renamed from: f  reason: collision with root package name */
    public static final String f4081f = "color";

    /* renamed from: g  reason: collision with root package name */
    public static final String f4082g = "array";

    /* renamed from: h  reason: collision with root package name */
    public static final String f4083h = "attr";

    /* renamed from: i  reason: collision with root package name */
    public static final String f4084i = "dimen";
    public static final String j = "xml";
    public static final String k = "integer";
    public static final String l = "raw";
    public static Context mContext;
    public static String resourcePackageName;

    public static int a(Context context, String str, String str2) {
        if (mContext != null) {
            if (str != null && str.trim().length() != 0) {
                if (str2 != null && str2.trim().length() != 0) {
                    Resources resources = mContext.getResources();
                    String packageName = mContext.getPackageName();
                    if (ChannelUtils.isSpecailPackage()) {
                        packageName = "com.baidu.wallet";
                    }
                    if (ApollonConstants.DEBUG) {
                        Log.d("Apollon ResUtils", "context instance is " + context);
                        Log.d("Apollon ResUtils", "packake name is " + packageName + " attrName is " + str2 + ", context instance is " + context);
                    }
                    int identifier = resources.getIdentifier(str2, str, packageName);
                    return identifier <= 0 ? resources.getIdentifier(str2, str, resourcePackageName) : identifier;
                }
                throw new NullPointerException("the attrNme is null or empty");
            }
            throw new NullPointerException("the type is null or empty");
        }
        throw new NullPointerException("the context is null");
    }

    public static int anim(Context context, String str) {
        return a(mContext, "anim", str);
    }

    public static int array(Context context, String str) {
        return a(mContext, "array", str);
    }

    public static int attr(Context context, String str) {
        return a(mContext, "attr", str);
    }

    public static int color(Context context, String str) {
        return a(mContext, "color", str);
    }

    public static int dimen(Context context, String str) {
        return a(mContext, "dimen", str);
    }

    public static int drawable(Context context, String str) {
        return a(mContext, "drawable", str);
    }

    public static Animation getAnimation(Context context, String str) {
        Context context2 = mContext;
        return AnimationUtils.loadAnimation(context2, anim(context2, str));
    }

    public static int getColor(Context context, String str) {
        LogUtil.d("aaa", "name is " + str + "+++ color id is " + color(mContext, str));
        return mContext.getResources().getColor(color(mContext, str));
    }

    public static Context getContext() {
        return mContext;
    }

    public static float getDimension(Context context, String str) {
        return mContext.getResources().getDimension(dimen(mContext, str));
    }

    public static Drawable getDrawable(Context context, String str) {
        return mContext.getResources().getDrawable(drawable(mContext, str));
    }

    public static int getInteger(Context context, String str) {
        return mContext.getResources().getInteger(integer(mContext, str));
    }

    public static String getResourcePackageName() {
        return resourcePackageName;
    }

    public static String getString(Context context, String str) {
        Context context2 = mContext;
        if (context2 != null && context2.getResources() != null) {
            try {
                return mContext.getResources().getString(string(mContext, str));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }

    public static String[] getStringArray(Context context, String str) {
        return mContext.getResources().getStringArray(array(mContext, str));
    }

    public static int id(Context context, String str) {
        return a(mContext, "id", str);
    }

    public static int integer(Context context, String str) {
        return a(mContext, "integer", str);
    }

    public static int layout(Context context, String str) {
        return a(mContext, "layout", str);
    }

    public static int raw(Context context, String str) {
        return a(mContext, "raw", str);
    }

    public static void setApplicationContext(Context context) {
        mContext = context;
    }

    public static void setResourcePackageName(String str) {
        resourcePackageName = str;
    }

    public static int string(Context context, String str) {
        return a(mContext, "string", str);
    }

    public static int style(Context context, String str) {
        return a(mContext, "style", str);
    }

    public static int xml(Context context, String str) {
        return a(mContext, "xml", str);
    }

    public static int anim(Context context, String str, String str2) {
        return a(mContext, str, "anim", str2);
    }

    public static int a(Context context, String str, String str2, String str3) {
        if (mContext != null) {
            if (str2 != null && str2.trim().length() != 0) {
                if (str3 != null && str3.trim().length() != 0) {
                    Resources resources = mContext.getResources();
                    if (ChannelUtils.isSpecailPackage()) {
                        str = "com.baidu.wallet";
                    }
                    if (ApollonConstants.DEBUG) {
                        Log.d("Apollon ResUtils", "context instance is " + context);
                        Log.d("Apollon ResUtils", "packake name is " + str + " attrName is " + str3 + ", context instance is " + context);
                    }
                    int identifier = resources.getIdentifier(str3, str2, str);
                    return identifier <= 0 ? resources.getIdentifier(str3, str2, resourcePackageName) : identifier;
                }
                throw new NullPointerException("the attrNme is null or empty");
            }
            throw new NullPointerException("the type is null or empty");
        }
        throw new NullPointerException("the context is null");
    }
}
