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
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ng.ai.apps.media.audio.event.AudioStatusCallback;
import com.baidu.sofire.b.r;
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

        public String toString() {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(getClass().getSimpleName()).append(": mode=").append(this.a).append(", activity=").append(this.b).append(", path=").append(this.c).append(",pkgName=").append(this.d);
                return sb.toString();
            } catch (Throwable th) {
                com.baidu.sofire.b.e.a(th);
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
        i = f.b(Activity.class, "onCreate", Bundle.class);
        j = f.b(Activity.class, "onPostCreate", Bundle.class);
        k = f.b(Activity.class, "onStart", new Class[0]);
        l = f.b(Activity.class, "onResume", new Class[0]);
        m = f.b(Activity.class, "onPostResume", new Class[0]);
        n = f.b(Activity.class, AudioStatusCallback.ON_PAUSE, new Class[0]);
        o = f.b(Activity.class, AudioStatusCallback.ON_STOP, new Class[0]);
        p = f.b(Activity.class, "onDestroy", new Class[0]);
        f = f.b(Activity.class, "mCurrentConfig");
        g = f.b(Activity.class, "mConfigChangeFlags");
        h = f.b(Activity.class, "mCalled");
    }

    protected boolean a(a aVar, Intent intent) {
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
            com.baidu.sofire.b.e.a(th);
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
        try {
            b.a("Activity OnCreate");
            Intent intent = getIntent();
            if (Config.APP_VERSION_CODE.equals(intent.getStringExtra("t"))) {
                a(getApplicationContext(), intent);
            }
            com.baidu.sofire.core.g a2 = com.baidu.sofire.core.g.a();
            if (a2 == null) {
                b.a("ERROR: ApkHub not initialized");
                super.onCreate(bundle);
                finish();
                return;
            }
            a(this.b, intent);
            b.a(this.b.toString());
            if (TextUtils.isEmpty(this.b.d)) {
                b.a("mInitData.pkgName is null, abort ...");
                super.onCreate(bundle);
                finish();
                return;
            }
            ApkInfo d = a2.d(this.b.d);
            if (d == null || d.activities == null) {
                b.a("bad apk data, abort ...");
                super.onCreate(bundle);
                finish();
                return;
            }
            ActivityInfo[] activityInfoArr = d.activities;
            int length = activityInfoArr.length;
            int i2 = 0;
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
                b.a("activity not found. aborting...");
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
                b.a("Bad class type: " + newInstance.toString());
                finish();
                return;
            }
            this.c = (Activity) newInstance;
            Activity activity = (Activity) newInstance;
            f.a(this, activity);
            a(activity, d, i4, activityInfo);
            a(activity);
            a(activity, d, activityInfo);
            b(activity, d, activityInfo);
            this.b.e.setExtrasClassLoader(d.classLoader);
            activity.setIntent(this.b.e);
            if (this.a && i != null && this.c != null) {
                i.invoke(newInstance, bundle);
            }
            super.onCreate(bundle);
            b.a("load external activity done");
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
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
            com.baidu.sofire.b.e.a(th);
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
            com.baidu.sofire.b.e.a(th);
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
            com.baidu.sofire.b.e.a(th);
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
            com.baidu.sofire.b.e.a(th);
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
            com.baidu.sofire.b.e.a(th);
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
            com.baidu.sofire.b.e.a(th);
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
            com.baidu.sofire.b.e.a(th);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        try {
            super.onConfigurationChanged(configuration);
            if (this.a && this.c != null) {
                if (a(configuration)) {
                    a();
                } else {
                    b(configuration);
                }
                if (this.d != null) {
                    this.d.updateFrom(configuration);
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
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
            com.baidu.sofire.b.e.a(th);
            return false;
        }
    }

    private void a() {
    }

    private void b(Configuration configuration) {
        try {
            h.setBoolean(this.c, false);
            this.c.onConfigurationChanged(configuration);
            boolean z = h.getBoolean(this.c);
            if (0 != 0 || z) {
                g.setInt(this.c, 0);
                f.set(this.c, new Configuration(configuration));
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
    }

    protected void a(Activity activity, ApkInfo apkInfo, int i2, ActivityInfo activityInfo) {
        try {
            Field b = f.b(ContextThemeWrapper.class, "mInflater");
            Field b2 = f.b(ContextThemeWrapper.class, "mTheme");
            Field b3 = f.b(ContextThemeWrapper.class, "mResources");
            if (b != null) {
                b.set(activity, null);
            }
            if (b2 != null) {
                b2.set(activity, null);
            }
            if (b3 != null) {
                Resources resources = getResources();
                AssetManager assetManager = new AssetManager();
                assetManager.addAssetPath(apkInfo.pkgPath);
                b.a("p=" + apkInfo.pkgPath);
                this.q = new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                b.a("r=" + this.q + ", l=" + activityInfo.labelRes);
                if (activityInfo.labelRes > 0) {
                    b.a("luginResources.getString=" + this.q.getString(activityInfo.labelRes));
                }
                b3.set(activity, this.q);
            }
            activity.setTheme(i2);
            activity.getTheme().applyStyle(i2, true);
            b.a("applying theme: resID=" + i2);
            Window window = activity.getWindow();
            Field b4 = f.b(window.getClass(), "mLayoutInflater");
            if (b4 != null) {
                b4.setAccessible(true);
                b4.set(window, ((LayoutInflater) b4.get(window)).cloneInContext(activity));
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
    }

    protected void a(Activity activity) {
        try {
            Field b = f.b(Window.class, "mCallback");
            if (b != null) {
                try {
                    b.set(activity.getWindow(), this.c);
                } catch (IllegalAccessException e) {
                } catch (IllegalArgumentException e2) {
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
    }

    private static void a(final Context context, final Intent intent) {
        r.a().a(new Runnable() { // from class: com.baidu.sofire.MyActivity.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    b.a("PPP(activity) now to active " + intent.toString());
                    String stringExtra = intent.getStringExtra("c");
                    Intent intent2 = new Intent();
                    intent2.putExtra("t", Config.APP_VERSION_CODE);
                    intent2.putExtra("c", stringExtra);
                    com.baidu.sofire.a.a(context.getApplicationContext(), intent2);
                } catch (Throwable th) {
                    com.baidu.sofire.b.e.a(th);
                }
            }
        });
    }

    private void a(Activity activity, ApkInfo apkInfo, ActivityInfo activityInfo) {
        try {
            Field b = f.b(Activity.class, "mActivityInfo");
            if (b != null) {
                b.set(activity, activityInfo);
            }
            Field b2 = f.b(Activity.class, "mComponent");
            if (b2 != null) {
                b2.set(activity, new ComponentName(activityInfo.packageName, activityInfo.name));
            }
            Field b3 = f.b(Activity.class, "mTitle");
            if (b3 != null) {
                String str = null;
                if (activityInfo.nonLocalizedLabel != null) {
                    str = activityInfo.nonLocalizedLabel.toString();
                } else if (activityInfo.labelRes != 0) {
                    if (this.q != null) {
                        b.a("p= " + apkInfo.pkgPath);
                        b.a("r=" + this.q + ", l=" + activityInfo.labelRes);
                        str = this.q.getString(activityInfo.labelRes);
                    }
                } else if (activityInfo.name != null) {
                    str = activityInfo.name;
                } else {
                    str = activityInfo.packageName;
                }
                b3.set(activity, str);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
    }

    private void b(Activity activity, ApkInfo apkInfo, ActivityInfo activityInfo) {
        try {
            Window window = activity.getWindow();
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(R.styleable.Window);
            Field b = f.b(activity.getWindow().getClass(), "mWindowStyle");
            if (b != null) {
                b.set(window, obtainStyledAttributes);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
    }
}
