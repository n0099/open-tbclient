package com.baidu.platform.comapi.wnplatform.o.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.baidu.mapapi.VersionInfo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes5.dex */
public class a {
    private static final String a = VersionInfo.getApiVersion();
    private static final String b = "BaiduBikeNavi_Resource_v" + a + ".jar";
    private static final String c = "BaiduBikeNavi_Resource_v" + a + ".png";
    private static String d = Environment.getExternalStorageDirectory() + "/";
    private static String e = d + b;
    private static AssetManager f = null;
    private static Resources g = null;
    private static Resources h = null;
    private static Resources.Theme i = null;
    private static Resources.Theme j = null;
    private static Field k = null;
    private static Field l = null;
    private static Field m = null;
    private static boolean n = false;
    private static Context o;

    public static boolean a(Context context) {
        boolean z = true;
        if (context == null) {
            Log.d("context == null", "context == null");
            return false;
        }
        o = context;
        if (com.baidu.platform.comapi.bikenavi.a.a.a) {
            try {
                z = b(context);
                Log.d("tryret", "tryret" + z);
            } catch (Exception e2) {
                Log.d("catch", "catch");
                z = false;
            }
        }
        return z;
    }

    public static void a() {
        o = null;
    }

    public static Resources b() {
        if (g == null) {
            g = o.getResources();
        }
        return g;
    }

    public static Drawable a(Context context, int i2) {
        return n ? b().getDrawable(i2) : context.getResources().getDrawable(i2);
    }

    public static String b(Context context, int i2) {
        return n ? b().getString(i2) : context.getResources().getString(i2);
    }

    public static View a(Activity activity, int i2, ViewGroup viewGroup) {
        View view;
        Throwable th;
        if (!n) {
            return LayoutInflater.from(activity).inflate(b().getXml(i2), viewGroup);
        }
        XmlResourceParser xml = g.getXml(i2);
        try {
            boolean a2 = a(activity);
            view = LayoutInflater.from(activity).inflate(xml, viewGroup);
            if (a2) {
                try {
                    b(activity);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        th.printStackTrace();
                        com.baidu.platform.comapi.wnplatform.d.a.a("ResUtils", "inflate", th);
                        return view;
                    } finally {
                        xml.close();
                    }
                }
            }
            return view;
        } catch (Throwable th3) {
            view = null;
            th = th3;
        }
    }

    public static Animation c(Context context, int i2) throws Resources.NotFoundException {
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = b().getAnimation(i2);
                    return a(context, xmlResourceParser);
                } catch (XmlPullParserException e2) {
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i2));
                    notFoundException.initCause(e2);
                    throw notFoundException;
                }
            } catch (IOException e3) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i2));
                notFoundException2.initCause(e3);
                throw notFoundException2;
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    public static void a(Dialog dialog, Resources.Theme theme) {
        try {
            Field declaredField = Class.forName("android.app.Dialog").getDeclaredField("mContext");
            declaredField.setAccessible(true);
            Field declaredField2 = Class.forName("android.view.ContextThemeWrapper").getDeclaredField("mTheme");
            declaredField2.setAccessible(true);
            declaredField2.set((ContextThemeWrapper) declaredField.get(dialog), theme);
        } catch (Throwable th) {
            com.baidu.platform.comapi.wnplatform.d.a.a("", th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.platform.comapi.wnplatform.o.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0084a implements FilenameFilter {
        C0084a() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith("BaiduBikeNavi_Resource_v") && !str.endsWith(new StringBuilder().append(a.a).append(".jar").toString());
        }
    }

    private static void d() {
        File[] listFiles = new File(d).listFiles(new C0084a());
        if (listFiles != null && listFiles.length > 0) {
            for (File file : listFiles) {
                file.delete();
            }
        }
    }

    private static boolean c(Context context) {
        d(context);
        try {
            InputStream open = context.getResources().getAssets().open(c);
            File file = new File(e);
            long length = file.length();
            int available = open.available();
            if (file.exists() && length == available) {
                open.close();
                return true;
            }
            d();
            FileOutputStream fileOutputStream = new FileOutputStream(new File(d, b));
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    open.close();
                    fileOutputStream.close();
                    return true;
                }
            }
        } catch (Exception e2) {
            return false;
        }
    }

    private static void d(Context context) {
        d = context.getFilesDir().getAbsolutePath();
        e = d + "/" + b;
    }

    private static AssetManager b(String str) {
        AssetManager assetManager;
        Throwable th;
        Class<?> cls;
        try {
            cls = Class.forName("android.content.res.AssetManager");
            assetManager = (AssetManager) cls.getConstructor(null).newInstance(null);
        } catch (Throwable th2) {
            assetManager = null;
            th = th2;
        }
        try {
            cls.getDeclaredMethod("addAssetPath", String.class).invoke(assetManager, str);
        } catch (Throwable th3) {
            th = th3;
            com.baidu.platform.comapi.wnplatform.d.a.a("", th.toString());
            return assetManager;
        }
        return assetManager;
    }

    private static Resources a(Context context, AssetManager assetManager) {
        return new Resources(assetManager, context.getResources().getDisplayMetrics(), context.getResources().getConfiguration());
    }

    private static Resources.Theme e() {
        if (i == null) {
            if (f == null) {
                f = b(e);
            }
            i = g.newTheme();
            i.applyStyle(a("com.android.internal.R.style.Theme"), true);
        }
        return i;
    }

    public static int a(String str) {
        try {
            String substring = str.substring(0, str.indexOf(".R.") + 2);
            int lastIndexOf = str.lastIndexOf(".");
            String substring2 = str.substring(lastIndexOf + 1, str.length());
            String substring3 = str.substring(0, lastIndexOf);
            return Class.forName(substring + "$" + substring3.substring(substring3.lastIndexOf(".") + 1, substring3.length())).getDeclaredField(substring2).getInt(null);
        } catch (Throwable th) {
            com.baidu.platform.comapi.wnplatform.d.a.a("", th.toString());
            return -1;
        }
    }

    private static Field f() {
        try {
            k = Class.forName("android.view.ContextThemeWrapper").getDeclaredField("mTheme");
            k.setAccessible(true);
        } catch (Throwable th) {
            com.baidu.platform.comapi.wnplatform.d.a.a("", th.toString());
        }
        return k;
    }

    private static Field g() {
        try {
            m = Class.forName("android.app.ContextImpl").getDeclaredField("mResources");
            m.setAccessible(true);
        } catch (Throwable th) {
            com.baidu.platform.comapi.wnplatform.d.a.a("", th.toString());
        }
        return m;
    }

    public static boolean a(Activity activity) {
        if (h != null) {
            return false;
        }
        try {
            if (k == null) {
                k = f();
            }
            if (m == null) {
                m = g();
            }
            if (i == null) {
                i = e();
            }
            Context baseContext = activity.getBaseContext();
            h = (Resources) m.get(baseContext);
            j = (Resources.Theme) k.get(activity);
            m.set(baseContext, g);
            k.set(activity, i);
            return true;
        } catch (Throwable th) {
            com.baidu.platform.comapi.wnplatform.d.a.a("", th.toString());
            return false;
        }
    }

    public static void b(Activity activity) {
        if (h != null) {
            try {
                m.set(activity.getBaseContext(), h);
                k.set(activity, j);
            } catch (Throwable th) {
                try {
                    com.baidu.platform.comapi.wnplatform.d.a.a("", th.toString());
                } finally {
                    h = null;
                }
            }
        }
    }

    public static boolean b(Context context) {
        if (!c(context)) {
            return false;
        }
        n = true;
        f = b(e);
        g = a(context, f);
        return true;
    }

    private static Animation a(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return a(context, xmlPullParser, null, Xml.asAttributeSet(xmlPullParser));
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0091, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Animation a(Context context, XmlPullParser xmlPullParser, AnimationSet animationSet, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Animation animation = null;
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    if (name.equals("set")) {
                        AnimationSet animationSet2 = new AnimationSet(context, attributeSet);
                        a(context, xmlPullParser, animationSet2, attributeSet);
                        animation = animationSet2;
                    } else if (name.equals("alpha")) {
                        animation = new AlphaAnimation(context, attributeSet);
                    } else if (name.equals("scale")) {
                        animation = new ScaleAnimation(context, attributeSet);
                    } else if (name.equals("rotate")) {
                        animation = new RotateAnimation(context, attributeSet);
                    } else if (name.equals("translate")) {
                        animation = new TranslateAnimation(context, attributeSet);
                    } else {
                        throw new RuntimeException("Unknown animation name: " + xmlPullParser.getName());
                    }
                    if (animationSet != null) {
                        animationSet.addAnimation(animation);
                    }
                }
            }
        }
    }
}
