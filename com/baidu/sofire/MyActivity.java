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
import com.baidu.sofire.core.ApkInfo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class MyActivity extends Activity {
    public static Method aCB;
    public static Method aCC;
    public static Method aCD;
    public static Method aCE;
    public static Field aEE;
    public static Field aEF;
    public static Field aEG;
    public static Method aEH;
    public static Method aEI;
    public static Method aEJ;
    public static Method l;
    private Resources aEA;
    protected boolean a = false;
    protected a aEB = new a();
    protected Activity c = null;
    protected Configuration aEC = null;
    protected ActivityInfo aED = null;

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
        aEE = null;
        aEF = null;
        aEG = null;
        aEH = null;
        aEI = null;
        aCB = null;
        l = null;
        aCC = null;
        aCD = null;
        aCE = null;
        aEJ = null;
        aEH = e.a((Class<?>) Activity.class, "onCreate", (Class<?>[]) new Class[]{Bundle.class});
        aEI = e.a((Class<?>) Activity.class, "onPostCreate", (Class<?>[]) new Class[]{Bundle.class});
        aCB = e.a((Class<?>) Activity.class, "onStart", (Class<?>[]) new Class[0]);
        l = e.a((Class<?>) Activity.class, "onResume", (Class<?>[]) new Class[0]);
        aCC = e.a((Class<?>) Activity.class, "onPostResume", (Class<?>[]) new Class[0]);
        aCD = e.a((Class<?>) Activity.class, "onPause", (Class<?>[]) new Class[0]);
        aCE = e.a((Class<?>) Activity.class, "onStop", (Class<?>[]) new Class[0]);
        aEJ = e.a((Class<?>) Activity.class, "onDestroy", (Class<?>[]) new Class[0]);
        aEE = e.d(Activity.class, "mCurrentConfig");
        aEF = e.d(Activity.class, "mConfigChangeFlags");
        aEG = e.d(Activity.class, "mCalled");
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
        try {
            com.baidu.sofire.core.e uS = com.baidu.sofire.core.e.uS();
            if (uS == null) {
                super.onCreate(bundle);
                finish();
                return;
            }
            a(this.aEB, getIntent());
            this.aEB.toString();
            if (TextUtils.isEmpty(this.aEB.d)) {
                super.onCreate(bundle);
                finish();
                return;
            }
            ApkInfo cf = uS.cf(this.aEB.d);
            if (cf == null || cf.activities == null) {
                super.onCreate(bundle);
                finish();
                return;
            }
            ActivityInfo[] activityInfoArr = cf.activities;
            int length = activityInfoArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    activityInfo = null;
                    break;
                }
                ActivityInfo activityInfo2 = activityInfoArr[i];
                if (activityInfo2.name.equals(this.aEB.b)) {
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
            this.aED = activityInfo;
            int i2 = activityInfo.theme;
            if (i2 == 0) {
                i2 = cf.applicationTheme;
            }
            int i3 = i2 == 0 ? 16973829 : i2;
            setTheme(i3);
            this.a = true;
            Object newInstance = cf.classLoader.loadClass(this.aEB.b).newInstance();
            if (!(newInstance instanceof Activity)) {
                new StringBuilder().append(newInstance.toString());
                finish();
                return;
            }
            this.c = (Activity) newInstance;
            Activity activity = (Activity) newInstance;
            e.a(this, activity);
            Field d = e.d(ContextThemeWrapper.class, "mInflater");
            Field d2 = e.d(ContextThemeWrapper.class, "mTheme");
            Field d3 = e.d(ContextThemeWrapper.class, "mResources");
            if (d != null) {
                d.set(activity, null);
            }
            if (d2 != null) {
                d2.set(activity, null);
            }
            if (d3 != null) {
                Resources resources = getResources();
                AssetManager assetManager = new AssetManager();
                assetManager.addAssetPath(cf.pkgPath);
                new StringBuilder("p=").append(cf.pkgPath);
                this.aEA = new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                new StringBuilder("r=").append(this.aEA).append(", l=").append(activityInfo.labelRes);
                if (activityInfo.labelRes > 0) {
                    new StringBuilder().append(this.aEA.getString(activityInfo.labelRes));
                }
                d3.set(activity, this.aEA);
            }
            activity.setTheme(i3);
            activity.getTheme().applyStyle(i3, true);
            new StringBuilder().append(i3);
            Window window = activity.getWindow();
            Field d4 = e.d(window.getClass(), "mLayoutInflater");
            if (d4 != null) {
                d4.setAccessible(true);
                d4.set(window, ((LayoutInflater) d4.get(window)).cloneInContext(activity));
            }
            Field d5 = e.d(Window.class, "mCallback");
            if (d5 != null) {
                try {
                    d5.set(activity.getWindow(), this.c);
                } catch (IllegalAccessException e) {
                } catch (IllegalArgumentException e2) {
                }
            }
            Field d6 = e.d(Activity.class, "mActivityInfo");
            if (d6 != null) {
                d6.set(activity, activityInfo);
            }
            Field d7 = e.d(Activity.class, "mComponent");
            if (d7 != null) {
                d7.set(activity, new ComponentName(activityInfo.packageName, activityInfo.name));
            }
            Field d8 = e.d(Activity.class, "mTitle");
            if (d8 != null) {
                if (activityInfo.nonLocalizedLabel != null) {
                    str = activityInfo.nonLocalizedLabel.toString();
                } else if (activityInfo.labelRes != 0) {
                    if (this.aEA != null) {
                        new StringBuilder("p= ").append(cf.pkgPath);
                        new StringBuilder("r=").append(this.aEA).append(", l=").append(activityInfo.labelRes);
                        str = this.aEA.getString(activityInfo.labelRes);
                    } else {
                        str = null;
                    }
                } else if (activityInfo.name != null) {
                    str = activityInfo.name;
                } else {
                    str = activityInfo.packageName;
                }
                d8.set(activity, str);
            }
            Window window2 = activity.getWindow();
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(R.styleable.Window);
            Field d9 = e.d(activity.getWindow().getClass(), "mWindowStyle");
            if (d9 != null) {
                d9.set(window2, obtainStyledAttributes);
            }
            this.aEB.e.setExtrasClassLoader(cf.classLoader);
            activity.setIntent(this.aEB.e);
            if (this.a && aEH != null && this.c != null) {
                aEH.invoke(newInstance, bundle);
            }
            super.onCreate(bundle);
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        try {
            super.onPostCreate(bundle);
            if (this.a && aEI != null && this.c != null) {
                aEI.invoke(this.c, bundle);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        try {
            super.onDestroy();
            if (this.a && aEJ != null && this.c != null) {
                aEJ.invoke(this.c, new Object[0]);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        try {
            super.onPause();
            if (this.a && aCD != null && this.c != null) {
                aCD.invoke(this.c, new Object[0]);
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
            if (this.a && aCC != null && this.c != null) {
                aCC.invoke(this.c, new Object[0]);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        try {
            super.onStart();
            if (this.a && aCB != null && this.c != null) {
                aCB.invoke(this.c, new Object[0]);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        try {
            super.onStop();
            if (this.a && aCE != null && this.c != null) {
                aCE.invoke(this.c, new Object[0]);
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
                    aEG.setBoolean(this.c, false);
                    this.c.onConfigurationChanged(configuration);
                    boolean z = aEG.getBoolean(this.c);
                    if (0 != 0 || z) {
                        aEF.setInt(this.c, 0);
                        aEE.set(this.c, new Configuration(configuration));
                    }
                }
                if (this.aEC != null) {
                    this.aEC.updateFrom(configuration);
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    private boolean a(Configuration configuration) {
        try {
            if (this.aEC == null) {
                return false;
            }
            Configuration configuration2 = this.aEC;
            int i = this.aED.configChanges;
            int diff = configuration2.diff(configuration);
            return diff != 0 && (diff & i) == 0;
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
            return false;
        }
    }
}
