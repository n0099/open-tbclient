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
    public static Method aCA;
    public static Method aCB;
    public static Method aCC;
    public static Method aCz;
    public static Field aEC;
    public static Field aED;
    public static Field aEE;
    public static Method aEF;
    public static Method aEG;
    public static Method aEH;
    public static Method l;
    private Resources aEy;
    protected boolean a = false;
    protected a aEz = new a();
    protected Activity c = null;
    protected Configuration aEA = null;
    protected ActivityInfo aEB = null;

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
        aEC = null;
        aED = null;
        aEE = null;
        aEF = null;
        aEG = null;
        aCz = null;
        l = null;
        aCA = null;
        aCB = null;
        aCC = null;
        aEH = null;
        aEF = e.a((Class<?>) Activity.class, "onCreate", (Class<?>[]) new Class[]{Bundle.class});
        aEG = e.a((Class<?>) Activity.class, "onPostCreate", (Class<?>[]) new Class[]{Bundle.class});
        aCz = e.a((Class<?>) Activity.class, "onStart", (Class<?>[]) new Class[0]);
        l = e.a((Class<?>) Activity.class, "onResume", (Class<?>[]) new Class[0]);
        aCA = e.a((Class<?>) Activity.class, "onPostResume", (Class<?>[]) new Class[0]);
        aCB = e.a((Class<?>) Activity.class, "onPause", (Class<?>[]) new Class[0]);
        aCC = e.a((Class<?>) Activity.class, "onStop", (Class<?>[]) new Class[0]);
        aEH = e.a((Class<?>) Activity.class, "onDestroy", (Class<?>[]) new Class[0]);
        aEC = e.d(Activity.class, "mCurrentConfig");
        aED = e.d(Activity.class, "mConfigChangeFlags");
        aEE = e.d(Activity.class, "mCalled");
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
            com.baidu.sofire.core.e uR = com.baidu.sofire.core.e.uR();
            if (uR == null) {
                super.onCreate(bundle);
                finish();
                return;
            }
            a(this.aEz, getIntent());
            this.aEz.toString();
            if (TextUtils.isEmpty(this.aEz.d)) {
                super.onCreate(bundle);
                finish();
                return;
            }
            ApkInfo cf = uR.cf(this.aEz.d);
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
                if (activityInfo2.name.equals(this.aEz.b)) {
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
            this.aEB = activityInfo;
            int i2 = activityInfo.theme;
            if (i2 == 0) {
                i2 = cf.applicationTheme;
            }
            int i3 = i2 == 0 ? 16973829 : i2;
            setTheme(i3);
            this.a = true;
            Object newInstance = cf.classLoader.loadClass(this.aEz.b).newInstance();
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
                this.aEy = new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                new StringBuilder("r=").append(this.aEy).append(", l=").append(activityInfo.labelRes);
                if (activityInfo.labelRes > 0) {
                    new StringBuilder().append(this.aEy.getString(activityInfo.labelRes));
                }
                d3.set(activity, this.aEy);
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
                    if (this.aEy != null) {
                        new StringBuilder("p= ").append(cf.pkgPath);
                        new StringBuilder("r=").append(this.aEy).append(", l=").append(activityInfo.labelRes);
                        str = this.aEy.getString(activityInfo.labelRes);
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
            this.aEz.e.setExtrasClassLoader(cf.classLoader);
            activity.setIntent(this.aEz.e);
            if (this.a && aEF != null && this.c != null) {
                aEF.invoke(newInstance, bundle);
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
            if (this.a && aEG != null && this.c != null) {
                aEG.invoke(this.c, bundle);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        try {
            super.onDestroy();
            if (this.a && aEH != null && this.c != null) {
                aEH.invoke(this.c, new Object[0]);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        try {
            super.onPause();
            if (this.a && aCB != null && this.c != null) {
                aCB.invoke(this.c, new Object[0]);
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
            if (this.a && aCA != null && this.c != null) {
                aCA.invoke(this.c, new Object[0]);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        try {
            super.onStart();
            if (this.a && aCz != null && this.c != null) {
                aCz.invoke(this.c, new Object[0]);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        try {
            super.onStop();
            if (this.a && aCC != null && this.c != null) {
                aCC.invoke(this.c, new Object[0]);
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
                    aEE.setBoolean(this.c, false);
                    this.c.onConfigurationChanged(configuration);
                    boolean z = aEE.getBoolean(this.c);
                    if (0 != 0 || z) {
                        aED.setInt(this.c, 0);
                        aEC.set(this.c, new Configuration(configuration));
                    }
                }
                if (this.aEA != null) {
                    this.aEA.updateFrom(configuration);
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    private boolean a(Configuration configuration) {
        try {
            if (this.aEA == null) {
                return false;
            }
            Configuration configuration2 = this.aEA;
            int i = this.aEB.configChanges;
            int diff = configuration2.diff(configuration);
            return diff != 0 && (diff & i) == 0;
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
            return false;
        }
    }
}
