package com.baidu.sofire;

import android.R;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Window;
import com.baidu.appsearchlib.Info;
import com.baidu.sofire.a;
import com.baidu.sofire.core.ApkInfo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class MyActivity extends Activity {
    public static Field f;
    public static Field g;
    public static Field h;
    public static Method i;
    public static Method j;
    public static Method k;
    public static Method l;
    public static Method m;
    public static Method n;
    public static Method o;
    public static Method p;
    protected boolean a = false;
    protected a b = new a();
    protected Activity c = null;
    protected Configuration d = null;
    protected ActivityInfo e = null;
    private Resources q;

    /* loaded from: classes.dex */
    public static class a {
        public boolean a = false;
        public String b;
        public String c;
        public String d;
        public Intent e;

        public final String toString() {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(getClass().getSimpleName()).append(": mode=").append(this.a).append(", activity=").append(this.b).append(", path=").append(this.c).append(",pkgName=").append(this.d);
                return sb.toString();
            } catch (Throwable th) {
                com.baidu.sofire.b.d.a(th);
                return "";
            }
        }
    }

    static {
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        l = null;
        m = null;
        n = null;
        o = null;
        p = null;
        i = f.a((Class<?>) Activity.class, "onCreate", (Class<?>[]) new Class[]{Bundle.class});
        j = f.a((Class<?>) Activity.class, "onPostCreate", (Class<?>[]) new Class[]{Bundle.class});
        k = f.a((Class<?>) Activity.class, "onStart", (Class<?>[]) new Class[0]);
        l = f.a((Class<?>) Activity.class, "onResume", (Class<?>[]) new Class[0]);
        m = f.a((Class<?>) Activity.class, "onPostResume", (Class<?>[]) new Class[0]);
        n = f.a((Class<?>) Activity.class, "onPause", (Class<?>[]) new Class[0]);
        o = f.a((Class<?>) Activity.class, "onStop", (Class<?>[]) new Class[0]);
        p = f.a((Class<?>) Activity.class, "onDestroy", (Class<?>[]) new Class[0]);
        f = f.a(Activity.class, "mCurrentConfig");
        g = f.a(Activity.class, "mConfigChangeFlags");
        h = f.a(Activity.class, "mCalled");
    }

    private static boolean a(a aVar, Intent intent) {
        try {
            String stringExtra = intent.getStringExtra("from_plugin_package");
            String stringExtra2 = intent.getStringExtra("target_class");
            if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
                return false;
            }
            aVar.a = true;
            aVar.d = stringExtra;
            aVar.b = stringExtra2;
            aVar.e = intent;
            return true;
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
            return false;
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        ActivityInfo activityInfo;
        String str;
        int i2 = 0;
        try {
            com.baidu.sofire.core.e a2 = com.baidu.sofire.core.e.a();
            if (a2 == null) {
                super.onCreate(bundle);
                finish();
                return;
            }
            Intent intent = getIntent();
            if ("a".equals(intent.getStringExtra(Info.kBaiduTimeKey))) {
                String stringExtra = intent.getStringExtra("c");
                Intent intent2 = new Intent();
                intent2.putExtra(Info.kBaiduTimeKey, "a");
                intent2.putExtra("c", stringExtra);
                new a.AnonymousClass1(getApplicationContext(), getIntent()).start();
            }
            a(this.b, intent);
            this.b.toString();
            if (TextUtils.isEmpty(this.b.d)) {
                super.onCreate(bundle);
                finish();
                return;
            }
            ApkInfo d = a2.d(this.b.d);
            if (d == null || d.activities == null) {
                super.onCreate(bundle);
                finish();
                return;
            }
            ActivityInfo[] activityInfoArr = d.activities;
            int length = activityInfoArr.length;
            while (true) {
                if (i2 >= length) {
                    activityInfo = null;
                    break;
                }
                ActivityInfo activityInfo2 = activityInfoArr[i2];
                if (activityInfo2.name.equals(this.b.b)) {
                    activityInfo = activityInfo2;
                    break;
                }
                i2++;
            }
            if (activityInfo == null) {
                super.onCreate(bundle);
                finish();
                return;
            }
            this.e = activityInfo;
            int i3 = activityInfo.theme;
            if (i3 == 0) {
                i3 = d.applicationTheme;
            }
            int i4 = i3 == 0 ? 16973829 : i3;
            setTheme(i4);
            this.a = true;
            Object newInstance = d.classLoader.loadClass(this.b.b).newInstance();
            if (!(newInstance instanceof Activity)) {
                new StringBuilder().append(newInstance.toString());
                finish();
                return;
            }
            this.c = (Activity) newInstance;
            Activity activity = (Activity) newInstance;
            f.a(this, activity);
            Field a3 = f.a(ContextThemeWrapper.class, "mInflater");
            Field a4 = f.a(ContextThemeWrapper.class, "mTheme");
            Field a5 = f.a(ContextThemeWrapper.class, "mResources");
            if (a3 != null) {
                try {
                    a3.set(activity, null);
                } catch (Throwable th) {
                    th.getMessage();
                }
            }
            if (a4 != null) {
                a4.set(activity, null);
            }
            if (a5 != null) {
                Resources resources = getResources();
                AssetManager assetManager = new AssetManager();
                assetManager.addAssetPath(d.pkgPath);
                new StringBuilder("p=").append(d.pkgPath);
                this.q = new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                new StringBuilder("r=").append(this.q).append(", l=").append(activityInfo.labelRes);
                if (activityInfo.labelRes > 0) {
                    new StringBuilder().append(this.q.getString(activityInfo.labelRes));
                }
                a5.set(activity, this.q);
            }
            activity.setTheme(i4);
            activity.getTheme().applyStyle(i4, true);
            new StringBuilder().append(i4);
            Window window = activity.getWindow();
            Field a6 = f.a(window.getClass(), "mLayoutInflater");
            if (a6 != null) {
                a6.setAccessible(true);
                try {
                    a6.set(window, ((LayoutInflater) a6.get(window)).cloneInContext(activity));
                } catch (Throwable th2) {
                    th2.getMessage();
                }
            }
            Field a7 = f.a(Window.class, "mCallback");
            if (a7 != null) {
                try {
                    a7.set(activity.getWindow(), this.c);
                } catch (IllegalAccessException e) {
                } catch (IllegalArgumentException e2) {
                }
            }
            Field a8 = f.a(Activity.class, "mActivityInfo");
            if (a8 != null) {
                try {
                    a8.set(activity, activityInfo);
                } catch (Throwable th3) {
                    th3.getMessage();
                }
            }
            Field a9 = f.a(Activity.class, "mComponent");
            if (a9 != null) {
                try {
                    a9.set(activity, new ComponentName(activityInfo.packageName, activityInfo.name));
                } catch (Throwable th4) {
                    th4.getMessage();
                }
            }
            Field a10 = f.a(Activity.class, "mTitle");
            if (a10 != null) {
                if (activityInfo.nonLocalizedLabel != null) {
                    str = activityInfo.nonLocalizedLabel.toString();
                } else if (activityInfo.labelRes != 0) {
                    if (this.q != null) {
                        new StringBuilder("p= ").append(d.pkgPath);
                        new StringBuilder("r=").append(this.q).append(", l=").append(activityInfo.labelRes);
                        str = this.q.getString(activityInfo.labelRes);
                    } else {
                        str = null;
                    }
                } else if (activityInfo.name != null) {
                    str = activityInfo.name;
                } else {
                    str = activityInfo.packageName;
                }
                try {
                    a10.set(activity, str);
                } catch (Throwable th5) {
                    th5.getMessage();
                }
            }
            Window window2 = activity.getWindow();
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(R.styleable.Window);
            Field a11 = f.a(activity.getWindow().getClass(), "mWindowStyle");
            if (a11 != null) {
                try {
                    a11.set(window2, obtainStyledAttributes);
                } catch (Throwable th6) {
                    th6.getMessage();
                }
            }
            this.b.e.setExtrasClassLoader(d.classLoader);
            activity.setIntent(this.b.e);
            if (this.a && i != null && this.c != null) {
                i.invoke(newInstance, bundle);
            }
            super.onCreate(bundle);
        } catch (Throwable th7) {
            com.baidu.sofire.b.d.a(th7);
        }
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        try {
            super.onPostCreate(bundle);
            if (this.a && j != null && this.c != null) {
                j.invoke(this.c, bundle);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        try {
            super.onDestroy();
            if (this.a && p != null && this.c != null) {
                p.invoke(this.c, new Object[0]);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        try {
            super.onPause();
            if (this.a && n != null && this.c != null) {
                n.invoke(this.c, new Object[0]);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        try {
            super.onResume();
            if (this.a && l != null && this.c != null) {
                l.invoke(this.c, new Object[0]);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        try {
            super.onPostResume();
            if (this.a && m != null && this.c != null) {
                m.invoke(this.c, new Object[0]);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        try {
            super.onStart();
            if (this.a && k != null && this.c != null) {
                k.invoke(this.c, new Object[0]);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        try {
            super.onStop();
            if (this.a && o != null && this.c != null) {
                o.invoke(this.c, new Object[0]);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        try {
            super.onConfigurationChanged(configuration);
            if (this.a && this.c != null) {
                if (!a(configuration)) {
                    h.setBoolean(this.c, false);
                    this.c.onConfigurationChanged(configuration);
                    boolean z = h.getBoolean(this.c);
                    if (0 != 0 || z) {
                        g.setInt(this.c, 0);
                        f.set(this.c, new Configuration(configuration));
                    }
                }
                if (this.d != null) {
                    this.d.updateFrom(configuration);
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    private boolean a(Configuration configuration) {
        try {
            if (this.d == null) {
                return false;
            }
            Configuration configuration2 = this.d;
            int i2 = this.e.configChanges;
            int diff = configuration2.diff(configuration);
            return diff != 0 && (diff & i2) == 0;
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
            return false;
        }
    }
}
