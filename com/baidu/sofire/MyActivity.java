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
    public static Method aDZ;
    public static Method aEa;
    public static Method aEb;
    public static Method aEc;
    public static Field aGa;
    public static Field aGb;
    public static Field aGc;
    public static Method aGd;
    public static Method aGe;
    public static Method aGf;
    public static Method l;
    private Resources aFW;
    protected boolean a = false;
    protected a aFX = new a();
    protected Activity c = null;
    protected Configuration aFY = null;
    protected ActivityInfo aFZ = null;

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
        aGa = null;
        aGb = null;
        aGc = null;
        aGd = null;
        aGe = null;
        aDZ = null;
        l = null;
        aEa = null;
        aEb = null;
        aEc = null;
        aGf = null;
        aGd = f.a((Class<?>) Activity.class, "onCreate", (Class<?>[]) new Class[]{Bundle.class});
        aGe = f.a((Class<?>) Activity.class, "onPostCreate", (Class<?>[]) new Class[]{Bundle.class});
        aDZ = f.a((Class<?>) Activity.class, "onStart", (Class<?>[]) new Class[0]);
        l = f.a((Class<?>) Activity.class, "onResume", (Class<?>[]) new Class[0]);
        aEa = f.a((Class<?>) Activity.class, "onPostResume", (Class<?>[]) new Class[0]);
        aEb = f.a((Class<?>) Activity.class, "onPause", (Class<?>[]) new Class[0]);
        aEc = f.a((Class<?>) Activity.class, "onStop", (Class<?>[]) new Class[0]);
        aGf = f.a((Class<?>) Activity.class, "onDestroy", (Class<?>[]) new Class[0]);
        aGa = f.d(Activity.class, "mCurrentConfig");
        aGb = f.d(Activity.class, "mConfigChangeFlags");
        aGc = f.d(Activity.class, "mCalled");
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
        int i = 0;
        try {
            com.baidu.sofire.core.e vF = com.baidu.sofire.core.e.vF();
            if (vF == null) {
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
            a(this.aFX, intent);
            this.aFX.toString();
            if (TextUtils.isEmpty(this.aFX.d)) {
                super.onCreate(bundle);
                finish();
                return;
            }
            ApkInfo cm = vF.cm(this.aFX.d);
            if (cm == null || cm.activities == null) {
                super.onCreate(bundle);
                finish();
                return;
            }
            ActivityInfo[] activityInfoArr = cm.activities;
            int length = activityInfoArr.length;
            while (true) {
                if (i >= length) {
                    activityInfo = null;
                    break;
                }
                ActivityInfo activityInfo2 = activityInfoArr[i];
                if (activityInfo2.name.equals(this.aFX.b)) {
                    activityInfo = activityInfo2;
                    break;
                }
                i++;
            }
            if (activityInfo == null) {
                super.onCreate(bundle);
                finish();
                return;
            }
            this.aFZ = activityInfo;
            int i2 = activityInfo.theme;
            if (i2 == 0) {
                i2 = cm.applicationTheme;
            }
            int i3 = i2 == 0 ? 16973829 : i2;
            setTheme(i3);
            this.a = true;
            Object newInstance = cm.classLoader.loadClass(this.aFX.b).newInstance();
            if (!(newInstance instanceof Activity)) {
                new StringBuilder().append(newInstance.toString());
                finish();
                return;
            }
            this.c = (Activity) newInstance;
            Activity activity = (Activity) newInstance;
            f.a(this, activity);
            Field d = f.d(ContextThemeWrapper.class, "mInflater");
            Field d2 = f.d(ContextThemeWrapper.class, "mTheme");
            Field d3 = f.d(ContextThemeWrapper.class, "mResources");
            if (d != null) {
                try {
                    d.set(activity, null);
                } catch (Throwable th) {
                    th.getMessage();
                }
            }
            if (d2 != null) {
                d2.set(activity, null);
            }
            if (d3 != null) {
                Resources resources = getResources();
                AssetManager assetManager = new AssetManager();
                assetManager.addAssetPath(cm.pkgPath);
                new StringBuilder("p=").append(cm.pkgPath);
                this.aFW = new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                new StringBuilder("r=").append(this.aFW).append(", l=").append(activityInfo.labelRes);
                if (activityInfo.labelRes > 0) {
                    new StringBuilder().append(this.aFW.getString(activityInfo.labelRes));
                }
                d3.set(activity, this.aFW);
            }
            activity.setTheme(i3);
            activity.getTheme().applyStyle(i3, true);
            new StringBuilder().append(i3);
            Window window = activity.getWindow();
            Field d4 = f.d(window.getClass(), "mLayoutInflater");
            if (d4 != null) {
                d4.setAccessible(true);
                try {
                    d4.set(window, ((LayoutInflater) d4.get(window)).cloneInContext(activity));
                } catch (Throwable th2) {
                    th2.getMessage();
                }
            }
            Field d5 = f.d(Window.class, "mCallback");
            if (d5 != null) {
                try {
                    d5.set(activity.getWindow(), this.c);
                } catch (IllegalAccessException e) {
                } catch (IllegalArgumentException e2) {
                }
            }
            Field d6 = f.d(Activity.class, "mActivityInfo");
            if (d6 != null) {
                try {
                    d6.set(activity, activityInfo);
                } catch (Throwable th3) {
                    th3.getMessage();
                }
            }
            Field d7 = f.d(Activity.class, "mComponent");
            if (d7 != null) {
                try {
                    d7.set(activity, new ComponentName(activityInfo.packageName, activityInfo.name));
                } catch (Throwable th4) {
                    th4.getMessage();
                }
            }
            Field d8 = f.d(Activity.class, "mTitle");
            if (d8 != null) {
                if (activityInfo.nonLocalizedLabel != null) {
                    str = activityInfo.nonLocalizedLabel.toString();
                } else if (activityInfo.labelRes != 0) {
                    if (this.aFW != null) {
                        new StringBuilder("p= ").append(cm.pkgPath);
                        new StringBuilder("r=").append(this.aFW).append(", l=").append(activityInfo.labelRes);
                        str = this.aFW.getString(activityInfo.labelRes);
                    } else {
                        str = null;
                    }
                } else if (activityInfo.name != null) {
                    str = activityInfo.name;
                } else {
                    str = activityInfo.packageName;
                }
                try {
                    d8.set(activity, str);
                } catch (Throwable th5) {
                    th5.getMessage();
                }
            }
            Window window2 = activity.getWindow();
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(R.styleable.Window);
            Field d9 = f.d(activity.getWindow().getClass(), "mWindowStyle");
            if (d9 != null) {
                try {
                    d9.set(window2, obtainStyledAttributes);
                } catch (Throwable th6) {
                    th6.getMessage();
                }
            }
            this.aFX.e.setExtrasClassLoader(cm.classLoader);
            activity.setIntent(this.aFX.e);
            if (this.a && aGd != null && this.c != null) {
                aGd.invoke(newInstance, bundle);
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
            if (this.a && aGe != null && this.c != null) {
                aGe.invoke(this.c, bundle);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        try {
            super.onDestroy();
            if (this.a && aGf != null && this.c != null) {
                aGf.invoke(this.c, new Object[0]);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        try {
            super.onPause();
            if (this.a && aEb != null && this.c != null) {
                aEb.invoke(this.c, new Object[0]);
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
            if (this.a && aEa != null && this.c != null) {
                aEa.invoke(this.c, new Object[0]);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        try {
            super.onStart();
            if (this.a && aDZ != null && this.c != null) {
                aDZ.invoke(this.c, new Object[0]);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        try {
            super.onStop();
            if (this.a && aEc != null && this.c != null) {
                aEc.invoke(this.c, new Object[0]);
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
                    aGc.setBoolean(this.c, false);
                    this.c.onConfigurationChanged(configuration);
                    boolean z = aGc.getBoolean(this.c);
                    if (0 != 0 || z) {
                        aGb.setInt(this.c, 0);
                        aGa.set(this.c, new Configuration(configuration));
                    }
                }
                if (this.aFY != null) {
                    this.aFY.updateFrom(configuration);
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    private boolean a(Configuration configuration) {
        try {
            if (this.aFY == null) {
                return false;
            }
            Configuration configuration2 = this.aFY;
            int i = this.aFZ.configChanges;
            int diff = configuration2.diff(configuration);
            return diff != 0 && (diff & i) == 0;
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
            return false;
        }
    }
}
