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
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f10336a = VersionInfo.getApiVersion();

    /* renamed from: b  reason: collision with root package name */
    public static final String f10337b = "BaiduBikeNavi_Resource_v" + f10336a + ".jar";

    /* renamed from: c  reason: collision with root package name */
    public static final String f10338c = "BaiduBikeNavi_Resource_v" + f10336a + EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX;

    /* renamed from: d  reason: collision with root package name */
    public static String f10339d;

    /* renamed from: e  reason: collision with root package name */
    public static String f10340e;

    /* renamed from: f  reason: collision with root package name */
    public static AssetManager f10341f;

    /* renamed from: g  reason: collision with root package name */
    public static Resources f10342g;

    /* renamed from: h  reason: collision with root package name */
    public static Resources f10343h;
    public static Resources.Theme i;
    public static Resources.Theme j;
    public static Field k;
    public static Field l;
    public static Field m;
    public static boolean n;
    public static Context o;

    /* renamed from: com.baidu.platform.comapi.wnplatform.o.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0132a implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(a.f10336a);
            sb.append(".jar");
            return str.startsWith("BaiduBikeNavi_Resource_v") && !str.endsWith(sb.toString());
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory());
        sb.append("/");
        f10339d = sb.toString();
        f10340e = f10339d + f10337b;
        f10341f = null;
        f10342g = null;
        f10343h = null;
        i = null;
        j = null;
        k = null;
        l = null;
        m = null;
        n = false;
    }

    public static boolean a(Context context) {
        if (context == null) {
            Log.d("context == null", "context == null");
            return false;
        }
        o = context;
        if (com.baidu.platform.comapi.bikenavi.a.a.f9825a) {
            try {
                boolean b2 = b(context);
                Log.d("tryret", "tryret" + b2);
                return b2;
            } catch (Exception unused) {
                Log.d("catch", "catch");
                return false;
            }
        }
        return true;
    }

    public static Resources b() {
        if (f10342g == null) {
            f10342g = o.getResources();
        }
        return f10342g;
    }

    public static void d() {
        File[] listFiles = new File(f10339d).listFiles(new C0132a());
        if (listFiles == null || listFiles.length <= 0) {
            return;
        }
        for (File file : listFiles) {
            file.delete();
        }
    }

    public static Resources.Theme e() {
        if (i == null) {
            if (f10341f == null) {
                f10341f = b(f10340e);
            }
            i = f10342g.newTheme();
            i.applyStyle(a("com.android.internal.R.style.Theme"), true);
        }
        return i;
    }

    public static Field f() {
        try {
            Field declaredField = Class.forName("android.view.ContextThemeWrapper").getDeclaredField("mTheme");
            k = declaredField;
            declaredField.setAccessible(true);
        } catch (Throwable th) {
            com.baidu.platform.comapi.wnplatform.d.a.a("", th.toString());
        }
        return k;
    }

    public static Field g() {
        try {
            Field declaredField = Class.forName("android.app.ContextImpl").getDeclaredField("mResources");
            m = declaredField;
            declaredField.setAccessible(true);
        } catch (Throwable th) {
            com.baidu.platform.comapi.wnplatform.d.a.a("", th.toString());
        }
        return m;
    }

    public static Animation c(Context context, int i2) throws Resources.NotFoundException {
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                xmlResourceParser = b().getAnimation(i2);
                return a(context, xmlResourceParser);
            } catch (IOException e2) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i2));
                notFoundException.initCause(e2);
                throw notFoundException;
            } catch (XmlPullParserException e3) {
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

    public static String b(Context context, int i2) {
        if (n) {
            return b().getString(i2);
        }
        return context.getResources().getString(i2);
    }

    public static void d(Context context) {
        f10339d = context.getFilesDir().getAbsolutePath();
        f10340e = f10339d + "/" + f10337b;
    }

    public static void a() {
        o = null;
    }

    public static AssetManager b(String str) {
        AssetManager assetManager = null;
        try {
            Class<?> cls = Class.forName("android.content.res.AssetManager");
            AssetManager assetManager2 = (AssetManager) cls.getConstructor(null).newInstance(null);
            try {
                cls.getDeclaredMethod(V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, String.class).invoke(assetManager2, str);
                return assetManager2;
            } catch (Throwable th) {
                th = th;
                assetManager = assetManager2;
                com.baidu.platform.comapi.wnplatform.d.a.a("", th.toString());
                return assetManager;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static Drawable a(Context context, int i2) {
        if (n) {
            return b().getDrawable(i2);
        }
        return context.getResources().getDrawable(i2);
    }

    public static View a(Activity activity, int i2, ViewGroup viewGroup) {
        if (!n) {
            return LayoutInflater.from(activity).inflate(b().getXml(i2), viewGroup);
        }
        XmlResourceParser xml = f10342g.getXml(i2);
        View view = null;
        try {
            boolean a2 = a(activity);
            view = LayoutInflater.from(activity).inflate(xml, viewGroup);
            if (a2) {
                b(activity);
            }
        } finally {
            try {
                return view;
            } finally {
            }
        }
        return view;
    }

    public static void b(Activity activity) {
        if (f10343h == null) {
            return;
        }
        try {
            m.set(activity.getBaseContext(), f10343h);
            k.set(activity, j);
        } finally {
            try {
            } finally {
            }
        }
    }

    public static boolean c(Context context) {
        d(context);
        try {
            InputStream open = context.getResources().getAssets().open(f10338c);
            File file = new File(f10340e);
            long length = file.length();
            int available = open.available();
            if (file.exists() && length == available) {
                open.close();
                return true;
            }
            d();
            FileOutputStream fileOutputStream = new FileOutputStream(new File(f10339d, f10337b));
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
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean b(Context context) {
        if (c(context)) {
            n = true;
            AssetManager b2 = b(f10340e);
            f10341f = b2;
            f10342g = a(context, b2);
            return true;
        }
        return false;
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

    public static Resources a(Context context, AssetManager assetManager) {
        return new Resources(assetManager, context.getResources().getDisplayMetrics(), context.getResources().getConfiguration());
    }

    public static int a(String str) {
        try {
            String substring = str.substring(0, str.indexOf(".R.") + 2);
            int lastIndexOf = str.lastIndexOf(".");
            String substring2 = str.substring(lastIndexOf + 1, str.length());
            String substring3 = str.substring(0, lastIndexOf);
            String substring4 = substring3.substring(substring3.lastIndexOf(".") + 1, substring3.length());
            return Class.forName(substring + "$" + substring4).getDeclaredField(substring2).getInt(null);
        } catch (Throwable th) {
            com.baidu.platform.comapi.wnplatform.d.a.a("", th.toString());
            return -1;
        }
    }

    public static boolean a(Activity activity) {
        if (f10343h != null) {
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
            f10343h = (Resources) m.get(baseContext);
            j = (Resources.Theme) k.get(activity);
            m.set(baseContext, f10342g);
            k.set(activity, i);
            return true;
        } catch (Throwable th) {
            com.baidu.platform.comapi.wnplatform.d.a.a("", th.toString());
            return false;
        }
    }

    public static Animation a(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return a(context, xmlPullParser, null, Xml.asAttributeSet(xmlPullParser));
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x0005 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x0005 */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0087, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Animation a(Context context, XmlPullParser xmlPullParser, AnimationSet animationSet, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        AnimationSet animationSet2 = null;
        while (true) {
            int next = xmlPullParser.next();
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    if (name.equals("set")) {
                        AnimationSet animationSet3 = new AnimationSet(context, attributeSet);
                        a(context, xmlPullParser, animationSet3, attributeSet);
                        animationSet2 = animationSet3;
                    } else if (name.equals("alpha")) {
                        animationSet2 = new AlphaAnimation(context, attributeSet);
                    } else if (name.equals("scale")) {
                        animationSet2 = new ScaleAnimation(context, attributeSet);
                    } else if (name.equals("rotate")) {
                        animationSet2 = new RotateAnimation(context, attributeSet);
                    } else if (name.equals("translate")) {
                        animationSet2 = new TranslateAnimation(context, attributeSet);
                    } else {
                        throw new RuntimeException("Unknown animation name: " + xmlPullParser.getName());
                    }
                    if (animationSet != null) {
                        animationSet.addAnimation(animationSet2);
                    }
                }
            }
        }
    }
}
