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
    public static Method NH;
    public static Method NI;
    public static Method NJ;
    public static Method NK;
    public static Field PV;
    public static Field PW;
    public static Field PX;
    public static Method PY;
    public static Method PZ;
    public static Method Qa;
    public static Method l;
    private Resources PQ;
    protected boolean a = false;
    protected a PR = new a();
    protected Activity c = null;
    protected Configuration PT = null;
    protected ActivityInfo PU = null;

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
        PV = null;
        PW = null;
        PX = null;
        PY = null;
        PZ = null;
        NH = null;
        l = null;
        NI = null;
        NJ = null;
        NK = null;
        Qa = null;
        PY = f.a((Class<?>) Activity.class, "onCreate", (Class<?>[]) new Class[]{Bundle.class});
        PZ = f.a((Class<?>) Activity.class, "onPostCreate", (Class<?>[]) new Class[]{Bundle.class});
        NH = f.a((Class<?>) Activity.class, "onStart", (Class<?>[]) new Class[0]);
        l = f.a((Class<?>) Activity.class, "onResume", (Class<?>[]) new Class[0]);
        NI = f.a((Class<?>) Activity.class, "onPostResume", (Class<?>[]) new Class[0]);
        NJ = f.a((Class<?>) Activity.class, "onPause", (Class<?>[]) new Class[0]);
        NK = f.a((Class<?>) Activity.class, "onStop", (Class<?>[]) new Class[0]);
        Qa = f.a((Class<?>) Activity.class, "onDestroy", (Class<?>[]) new Class[0]);
        PV = f.d(Activity.class, "mCurrentConfig");
        PW = f.d(Activity.class, "mConfigChangeFlags");
        PX = f.d(Activity.class, "mCalled");
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
            com.baidu.sofire.core.e no = com.baidu.sofire.core.e.no();
            if (no == null) {
                super.onCreate(bundle);
                finish();
                return;
            }
            a(this.PR, getIntent());
            this.PR.toString();
            if (TextUtils.isEmpty(this.PR.d)) {
                super.onCreate(bundle);
                finish();
                return;
            }
            ApkInfo bY = no.bY(this.PR.d);
            if (bY == null || bY.activities == null) {
                super.onCreate(bundle);
                finish();
                return;
            }
            ActivityInfo[] activityInfoArr = bY.activities;
            int length = activityInfoArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    activityInfo = null;
                    break;
                }
                ActivityInfo activityInfo2 = activityInfoArr[i];
                if (activityInfo2.name.equals(this.PR.b)) {
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
            this.PU = activityInfo;
            int i2 = activityInfo.theme;
            if (i2 == 0) {
                i2 = bY.applicationTheme;
            }
            int i3 = i2 == 0 ? 16973829 : i2;
            setTheme(i3);
            this.a = true;
            Object newInstance = bY.classLoader.loadClass(this.PR.b).newInstance();
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
                d.set(activity, null);
            }
            if (d2 != null) {
                d2.set(activity, null);
            }
            if (d3 != null) {
                Resources resources = getResources();
                AssetManager assetManager = new AssetManager();
                assetManager.addAssetPath(bY.pkgPath);
                new StringBuilder("p=").append(bY.pkgPath);
                this.PQ = new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                new StringBuilder("r=").append(this.PQ).append(", l=").append(activityInfo.labelRes);
                if (activityInfo.labelRes > 0) {
                    new StringBuilder().append(this.PQ.getString(activityInfo.labelRes));
                }
                d3.set(activity, this.PQ);
            }
            activity.setTheme(i3);
            activity.getTheme().applyStyle(i3, true);
            new StringBuilder().append(i3);
            Window window = activity.getWindow();
            Field d4 = f.d(window.getClass(), "mLayoutInflater");
            if (d4 != null) {
                d4.setAccessible(true);
                d4.set(window, ((LayoutInflater) d4.get(window)).cloneInContext(activity));
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
                d6.set(activity, activityInfo);
            }
            Field d7 = f.d(Activity.class, "mComponent");
            if (d7 != null) {
                d7.set(activity, new ComponentName(activityInfo.packageName, activityInfo.name));
            }
            Field d8 = f.d(Activity.class, "mTitle");
            if (d8 != null) {
                if (activityInfo.nonLocalizedLabel != null) {
                    str = activityInfo.nonLocalizedLabel.toString();
                } else if (activityInfo.labelRes != 0) {
                    if (this.PQ != null) {
                        new StringBuilder("p= ").append(bY.pkgPath);
                        new StringBuilder("r=").append(this.PQ).append(", l=").append(activityInfo.labelRes);
                        str = this.PQ.getString(activityInfo.labelRes);
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
            Field d9 = f.d(activity.getWindow().getClass(), "mWindowStyle");
            if (d9 != null) {
                d9.set(window2, obtainStyledAttributes);
            }
            this.PR.e.setExtrasClassLoader(bY.classLoader);
            activity.setIntent(this.PR.e);
            if (this.a && PY != null && this.c != null) {
                PY.invoke(newInstance, bundle);
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
            if (this.a && PZ != null && this.c != null) {
                PZ.invoke(this.c, bundle);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        try {
            super.onDestroy();
            if (this.a && Qa != null && this.c != null) {
                Qa.invoke(this.c, new Object[0]);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        try {
            super.onPause();
            if (this.a && NJ != null && this.c != null) {
                NJ.invoke(this.c, new Object[0]);
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
            if (this.a && NI != null && this.c != null) {
                NI.invoke(this.c, new Object[0]);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        try {
            super.onStart();
            if (this.a && NH != null && this.c != null) {
                NH.invoke(this.c, new Object[0]);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        try {
            super.onStop();
            if (this.a && NK != null && this.c != null) {
                NK.invoke(this.c, new Object[0]);
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
                    PX.setBoolean(this.c, false);
                    this.c.onConfigurationChanged(configuration);
                    boolean z = PX.getBoolean(this.c);
                    if (0 != 0 || z) {
                        PW.setInt(this.c, 0);
                        PV.set(this.c, new Configuration(configuration));
                    }
                }
                if (this.PT != null) {
                    this.PT.updateFrom(configuration);
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    private boolean a(Configuration configuration) {
        try {
            if (this.PT == null) {
                return false;
            }
            Configuration configuration2 = this.PT;
            int i = this.PU.configChanges;
            int diff = configuration2.diff(configuration);
            return diff != 0 && (diff & i) == 0;
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
            return false;
        }
    }
}
